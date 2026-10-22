package androidx.camera.core.impl.utils;

import android.location.Location;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.Logger;
import androidx.camera.video.AudioStats;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class Exif {
    private static final List<String> ALL_EXIF_TAGS = null;
    private static final ThreadLocal<SimpleDateFormat> DATETIME_FORMAT = null;
    private static final ThreadLocal<SimpleDateFormat> DATE_FORMAT = null;
    private static final List<String> DO_NOT_COPY_EXIF_TAGS = null;
    public static final long INVALID_TIMESTAMP = -1;
    private static final String KILOMETERS_PER_HOUR = "K";
    private static final String KNOTS = "N";
    private static final String MILES_PER_HOUR = "M";
    private static final String TAG = null;
    public static final String TAG_THUMBNAIL_ORIENTATION = "ThumbnailOrientation";
    private static final ThreadLocal<SimpleDateFormat> TIME_FORMAT = null;
    private final ExifInterface mExifInterface;
    private boolean mRemoveTimestamp;

    public static final class Speed {

        public static final class Converter {
            final double mMph;

            public double toMetersPerSecond() {
                return this.mMph / 2.23694d;
            }

            public Converter(double r1) {
                this.mMph = r1;
            }
        }

        private Speed() {
        }

        public static Converter fromKilometersPerHour(double r3) {
            return new Converter(r3 * 0.621371d);
        }

        public static Converter fromKnots(double r3) {
            return new Converter(r3 * 1.15078d);
        }

        public static Converter fromMilesPerHour(double r1) {
            return new Converter(r1);
        }
    }

    static {
        TAG = "Exif";
        DATE_FORMAT = new AnonymousClass1();
        TIME_FORMAT = new AnonymousClass2();
        DATETIME_FORMAT = new AnonymousClass3();
        ALL_EXIF_TAGS = getAllExifTags();
        DO_NOT_COPY_EXIF_TAGS = Arrays.asList(new String[]{"ImageWidth", "ImageLength", "PixelXDimension", "PixelYDimension", "Compression", "JPEGInterchangeFormat", "JPEGInterchangeFormatLength", "ThumbnailImageLength", "ThumbnailImageWidth", TAG_THUMBNAIL_ORIENTATION});
    }

    public static List<String> getAllExifTags() {
        return Arrays.asList(new String[]{"ImageWidth", "ImageLength", "BitsPerSample", "Compression", "PhotometricInterpretation", "Orientation", "SamplesPerPixel", "PlanarConfiguration", "YCbCrSubSampling", "YCbCrPositioning", "XResolution", "YResolution", "ResolutionUnit", "StripOffsets", "RowsPerStrip", "StripByteCounts", "JPEGInterchangeFormat", "JPEGInterchangeFormatLength", "TransferFunction", "WhitePoint", "PrimaryChromaticities", "YCbCrCoefficients", "ReferenceBlackWhite", "DateTime", "ImageDescription", "Make", "Model", "Software", "Artist", "Copyright", "ExifVersion", "FlashpixVersion", "ColorSpace", "Gamma", "PixelXDimension", "PixelYDimension", "ComponentsConfiguration", "CompressedBitsPerPixel", "MakerNote", "UserComment", "RelatedSoundFile", "DateTimeOriginal", "DateTimeDigitized", "OffsetTime", "OffsetTimeOriginal", "OffsetTimeDigitized", "SubSecTime", "SubSecTimeOriginal", "SubSecTimeDigitized", "ExposureTime", "FNumber", "ExposureProgram", "SpectralSensitivity", "PhotographicSensitivity", "OECF", "SensitivityType", "StandardOutputSensitivity", "RecommendedExposureIndex", "ISOSpeed", "ISOSpeedLatitudeyyy", "ISOSpeedLatitudezzz", "ShutterSpeedValue", "ApertureValue", "BrightnessValue", "ExposureBiasValue", "MaxApertureValue", "SubjectDistance", "MeteringMode", "LightSource", "Flash", "SubjectArea", "FocalLength", "FlashEnergy", "SpatialFrequencyResponse", "FocalPlaneXResolution", "FocalPlaneYResolution", "FocalPlaneResolutionUnit", "SubjectLocation", "ExposureIndex", "SensingMethod", "FileSource", "SceneType", "CFAPattern", "CustomRendered", "ExposureMode", "WhiteBalance", "DigitalZoomRatio", "FocalLengthIn35mmFilm", "SceneCaptureType", "GainControl", "Contrast", "Saturation", "Sharpness", "DeviceSettingDescription", "SubjectDistanceRange", "ImageUniqueID", "CameraOwnerName", "BodySerialNumber", "LensSpecification", "LensMake", "LensModel", "LensSerialNumber", "GPSVersionID", "GPSLatitudeRef", "GPSLatitude", "GPSLongitudeRef", "GPSLongitude", "GPSAltitudeRef", "GPSAltitude", "GPSTimeStamp", "GPSSatellites", "GPSStatus", "GPSMeasureMode", "GPSDOP", "GPSSpeedRef", "GPSSpeed", "GPSTrackRef", "GPSTrack", "GPSImgDirectionRef", "GPSImgDirection", "GPSMapDatum", "GPSDestLatitudeRef", "GPSDestLatitude", "GPSDestLongitudeRef", "GPSDestLongitude", "GPSDestBearingRef", "GPSDestBearing", "GPSDestDistanceRef", "GPSDestDistance", "GPSProcessingMethod", "GPSAreaInformation", "GPSDateStamp", "GPSDifferential", "GPSHPositioningError", "InteroperabilityIndex", "ThumbnailImageLength", "ThumbnailImageWidth", TAG_THUMBNAIL_ORIENTATION, "DNGVersion", "DefaultCropSize", "ThumbnailImage", "PreviewImageStart", "PreviewImageLength", "AspectFrame", "SensorBottomBorder", "SensorLeftBorder", "SensorRightBorder", "SensorTopBorder", "ISO", "JpgFromRaw", "Xmp", "NewSubfileType", "SubfileType"});
    }

    public String getDescription() {
        return this.mExifInterface.getAttribute("ImageDescription");
    }

    public int getHeight() {
        return this.mExifInterface.getAttributeInt("ImageLength", 0);
    }

    public long getLastModifiedTimestamp() {
        long r0 = parseTimestamp(this.mExifInterface.getAttribute("DateTime"));
        if (r0 != (-1)) goto L5;
        return -1;
    L5:
        String r2 = this.mExifInterface.getAttribute("SubSecTime");
        if (r2 == null) goto L19;
        long r3 = CastLongProtector.parseLong(r2);     // Catch: NumberFormatException -> L14
    L9:
        if (r3 <= 1000) goto L13;
        r3 = r3 / 10;     // Catch: NumberFormatException -> L14
    L13:
        return r0 + r3;
    L20:
        return r0;
    L19:
        return r0;
    }

    public Location getLocation() {
        String r1 = this.mExifInterface.getAttribute("GPSProcessingMethod");
        double[] r2 = this.mExifInterface.getLatLong();
        double r6 = this.mExifInterface.getAltitude(AudioStats.AUDIO_AMPLITUDE_NONE);
        double r8 = this.mExifInterface.getAttributeDouble("GPSSpeed", AudioStats.AUDIO_AMPLITUDE_NONE);
        String r3 = this.mExifInterface.getAttribute("GPSSpeedRef");
        if (r3 != null) goto L5;
        r3 = KILOMETERS_PER_HOUR;
    L5:
        long r11 = parseTimestamp(this.mExifInterface.getAttribute("GPSDateStamp"), this.mExifInterface.getAttribute("GPSTimeStamp"));
        if (r2 != null) goto L9;
        return null;
    L9:
        if (r1 != null) goto L11;
        r1 = TAG;
    L11:
        Location r13 = new Location(r1);
        r13.setLatitude(r2[0]);
        r13.setLongitude(r2[1]);
        if (r6 == AudioStats.AUDIO_AMPLITUDE_NONE) goto L15;
        r13.setAltitude(r6);
    L15:
        if (r8 == AudioStats.AUDIO_AMPLITUDE_NONE) goto L40;
        int r4 = r3.hashCode();
        if (r4 == 75) goto L30;
        if (r4 == 77) goto L27;
        if (r4 == 78) goto L24;
    L32:
        byte r5 = -1;
    L33:
        if (r5 == 0) goto L37;
        if (r5 == 1) goto L36;
        double r7 = Speed.fromKilometersPerHour(r8).toMetersPerSecond();
    L38:
        r13.setSpeed((float) r7);
        goto L40
    L36:
        r7 = Speed.fromKnots(r8).toMetersPerSecond();
        goto L38
    L37:
        r7 = Speed.fromMilesPerHour(r8).toMetersPerSecond();
        goto L38
    L24:
        if (r3.equals(KNOTS) == false) goto L32;
        r5 = 1;
        goto L33
    L27:
        if (r3.equals(MILES_PER_HOUR) == false) goto L32;
        r5 = 0;
        goto L33
    L30:
        if (r3.equals(KILOMETERS_PER_HOUR) == false) goto L32;
        r5 = 2;
    L40:
        if (r11 == (-1)) goto L42;
        r13.setTime(r11);
    L42:
        return r13;
    }

    public String getMetadata() {
        return this.mExifInterface.getAttribute("Xmp");
    }

    public int getOrientation() {
        return this.mExifInterface.getAttributeInt("Orientation", 0);
    }

    public long getTimestamp() {
        long r0 = parseTimestamp(this.mExifInterface.getAttribute("DateTimeOriginal"));
        if (r0 != (-1)) goto L5;
        return -1;
    L5:
        String r2 = this.mExifInterface.getAttribute("SubSecTimeOriginal");
        if (r2 == null) goto L19;
        long r3 = CastLongProtector.parseLong(r2);     // Catch: NumberFormatException -> L14
    L9:
        if (r3 <= 1000) goto L13;
        r3 = r3 / 10;     // Catch: NumberFormatException -> L14
    L13:
        return r0 + r3;
    L20:
        return r0;
    L19:
        return r0;
    }

    public int getWidth() {
        return this.mExifInterface.getAttributeInt("ImageWidth", 0);
    }

    public void removeLocation() {
        this.mExifInterface.setAttribute("GPSProcessingMethod", null);
        this.mExifInterface.setAttribute("GPSLatitude", null);
        this.mExifInterface.setAttribute("GPSLatitudeRef", null);
        this.mExifInterface.setAttribute("GPSLongitude", null);
        this.mExifInterface.setAttribute("GPSLongitudeRef", null);
        this.mExifInterface.setAttribute("GPSAltitude", null);
        this.mExifInterface.setAttribute("GPSAltitudeRef", null);
        this.mExifInterface.setAttribute("GPSSpeed", null);
        this.mExifInterface.setAttribute("GPSSpeedRef", null);
        this.mExifInterface.setAttribute("GPSDateStamp", null);
        this.mExifInterface.setAttribute("GPSTimeStamp", null);
    }

    public void removeTimestamp() {
        this.mExifInterface.setAttribute("DateTime", null);
        this.mExifInterface.setAttribute("DateTimeOriginal", null);
        this.mExifInterface.setAttribute("DateTimeDigitized", null);
        this.mExifInterface.setAttribute("SubSecTime", null);
        this.mExifInterface.setAttribute("SubSecTimeOriginal", null);
        this.mExifInterface.setAttribute("SubSecTimeDigitized", null);
        this.mRemoveTimestamp = true;
    }

    public void save() throws IOException {
        if (this.mRemoveTimestamp == true) goto L5;
        attachLastModifiedTimestamp();
    L5:
        this.mExifInterface.saveAttributes();
    }

    public String toString() {
        return String.format(Locale.ENGLISH, "Exif{width=%s, height=%s, rotation=%d, isFlippedVertically=%s, isFlippedHorizontally=%s, location=%s, timestamp=%s, description=%s}", new Object[]{Integer.valueOf(getWidth()), Integer.valueOf(getHeight()), Integer.valueOf(getRotation()), Boolean.valueOf(isFlippedVertically()), Boolean.valueOf(isFlippedHorizontally()), getLocation(), Long.valueOf(getTimestamp()), getDescription()});
    }

    private void attachLastModifiedTimestamp() {
        long r0 = System.currentTimeMillis();
        String r2 = convertToExifDateTime(r0);
        this.mExifInterface.setAttribute("DateTime", r2);
        String r1 = Long.toString(r0 - convertFromExifDateTime(r2).getTime());     // Catch: ParseException -> L5
        this.mExifInterface.setAttribute("SubSecTime", r1);     // Catch: ParseException -> L5
        return;
    }

    public void attachTimestamp() {
        long r0 = System.currentTimeMillis();
        String r2 = convertToExifDateTime(r0);
        this.mExifInterface.setAttribute("DateTimeOriginal", r2);
        this.mExifInterface.setAttribute("DateTimeDigitized", r2);
        String r1 = Long.toString(r0 - convertFromExifDateTime(r2).getTime());     // Catch: ParseException -> L6
        this.mExifInterface.setAttribute("SubSecTimeOriginal", r1);     // Catch: ParseException -> L6
        this.mExifInterface.setAttribute("SubSecTimeDigitized", r1);     // Catch: ParseException -> L6
    L4:
        this.mRemoveTimestamp = false;
    }

    public void flipHorizontally() {
        switch(getOrientation()) {
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            case 8: goto L5;
            default: goto L4;
        };
    L4:
        int r0 = 2;
    L12:
        this.mExifInterface.setAttribute("Orientation", String.valueOf(r0));
        return;
    L5:
        r0 = 7;
        goto L12
    L6:
        r0 = 8;
        goto L12
    L7:
        r0 = 5;
        goto L12
    L8:
        r0 = 6;
        goto L12
    L9:
        r0 = 3;
        goto L12
    L10:
        r0 = 4;
        goto L12
    L11:
        r0 = 1;
        goto L12
    }

    public void flipVertically() {
        switch(getOrientation()) {
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            case 8: goto L5;
            default: goto L4;
        };
    L4:
        int r0 = 4;
    L12:
        this.mExifInterface.setAttribute("Orientation", String.valueOf(r0));
        return;
    L5:
        r0 = 5;
        goto L12
    L6:
        r0 = 6;
        goto L12
    L7:
        r0 = 7;
        goto L12
    L8:
        r0 = 8;
        goto L12
    L9:
        r0 = 1;
        goto L12
    L10:
        r0 = 2;
        goto L12
    L11:
        r0 = 3;
        goto L12
    }

    public int getRotation() {
        switch(getOrientation()) {
            case 3: goto L9;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L7;
            case 8: goto L6;
            default: goto L4;
        };
    L4:
        return 0;
    L6:
        return 270;
    L7:
        return 90;
    L8:
        return 270;
    L9:
        return 180;
    }

    public boolean isFlippedHorizontally() {
        if (getOrientation() == 2) goto L6;
        return false;
    L6:
        return true;
    }

    public boolean isFlippedVertically() {
        int r0 = getOrientation();
        if (r0 != 4) goto L5;
    L10:
        return true;
    L5:
        if (r0 == 5) goto L10;
        if (r0 == 7) goto L10;
        return false;
    }

    public ExifInterface getExifInterface() {
        return this.mExifInterface;
    }

    private Exif(ExifInterface r2) {
        this.mRemoveTimestamp = false;
        this.mExifInterface = r2;
    }

    private static Date convertFromExifDate(String r1) throws ParseException {
        return DATE_FORMAT.get().parse(r1);
    }

    private static Date convertFromExifDateTime(String r1) throws ParseException {
        return DATETIME_FORMAT.get().parse(r1);
    }

    private static Date convertFromExifTime(String r1) throws ParseException {
        return TIME_FORMAT.get().parse(r1);
    }

    private static String convertToExifDateTime(long r2) {
        return DATETIME_FORMAT.get().format(new Date(r2));
    }

    public static Exif createFromFile(File r0) throws IOException {
        return createFromFileString(r0.toString());
    }

    public static Exif createFromFileString(String r2) throws IOException {
        return new Exif(new ExifInterface(r2));
    }

    public static Exif createFromImageProxy(ImageProxy r1) throws IOException {
        ByteBuffer r2 = r1.getPlanes()[0].getBuffer();
        r2.rewind();
        byte[] r0 = new byte[r2.capacity()];
        r2.get(r0);
        return createFromInputStream(new ByteArrayInputStream(r0));
    }

    public static Exif createFromInputStream(InputStream r2) throws IOException {
        return new Exif(new ExifInterface(r2));
    }

    private long parseTimestamp(String r3) {
        if (r3 != null) goto L8;
        return -1;
    L8:
        return convertFromExifDateTime(r3).getTime();
    L10:
        return -1;
    }

    public void attachLocation(Location r2) {
        this.mExifInterface.setGpsInfo(r2);
    }

    public void copyToCroppedImage(Exif r5) {
        ArrayList r0 = new ArrayList(ALL_EXIF_TAGS);
        r0.removeAll(DO_NOT_COPY_EXIF_TAGS);
        Iterator r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L10;
        String r2 = (String) r1.next();
        String r3 = this.mExifInterface.getAttribute(r2);
        String r4 = r5.mExifInterface.getAttribute(r2);
        if (r3 == null) goto L4;
        if (r3.equals(r4) == true) goto L4;
        r5.mExifInterface.setAttribute(r2, r3);
        goto L4
    }

    public void rotate(int r10) {
        if ((r10 % 90) == 0) goto L6;
        Logger.w(TAG, String.format(Locale.US, "Can only rotate in right angles (eg. 0, 90, 180, 270). %d is unsupported.", new Object[]{Integer.valueOf(r10)}));
        this.mExifInterface.setAttribute("Orientation", String.valueOf(0));
        return;
    L6:
        int r11 = r10 % 360;
        int r0 = getOrientation();
    L8:
        if (r11 >= 0) goto L18;
        r11 = r11 + 90;
        switch(r0) {
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L13;
            case 7: goto L12;
            case 8: goto L16;
            default: goto L11;
        };
    L12:
        r0 = 2;
        goto L8
    L13:
        r0 = 1;
        goto L8
    L14:
        r0 = 4;
        goto L8
    L15:
        r0 = 7;
        goto L8
    L16:
        r0 = 6;
        goto L8
    L17:
        r0 = 5;
        goto L8
    L11:
        r0 = 8;
    L18:
        if (r11 <= 0) goto L29;
        r11 = r11 - 90;
        switch(r0) {
            case 2: goto L28;
            case 3: goto L27;
            case 4: goto L26;
            case 5: goto L25;
            case 6: goto L24;
            case 7: goto L23;
            case 8: goto L22;
            default: goto L21;
        };
    L22:
        r0 = 1;
        goto L18
    L23:
        r0 = 4;
        goto L18
    L24:
        r0 = 3;
        goto L18
    L25:
        r0 = 2;
        goto L18
    L26:
        r0 = 5;
        goto L18
    L27:
        r0 = 8;
        goto L18
    L28:
        r0 = 7;
        goto L18
    L21:
        r0 = 6;
        goto L18
    L29:
        this.mExifInterface.setAttribute("Orientation", String.valueOf(r0));
    }

    public void setDescription(String r3) {
        this.mExifInterface.setAttribute("ImageDescription", r3);
    }

    public void setOrientation(int r3) {
        this.mExifInterface.setAttribute("Orientation", String.valueOf(r3));
    }

    private long parseTimestamp(String r3, String r4) {
        if (r3 != null) goto L6;
        if (r4 != null) goto L6;
        return -1;
    L6:
        if (r4 == null) goto L16;
        if (r3 != null) goto L15;
        return convertFromExifTime(r4).getTime();
    L13:
        return -1;
    L15:
        return parseTimestamp(r3 + " " + r4);
    L16:
        return convertFromExifDate(r3).getTime();
    L9:
        return -1;
    }
}
