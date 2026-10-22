package androidx.camera.core.impl.utils;

import android.os.Build;
import android.util.Pair;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraCaptureMetaData;
import androidx.collection.SieveCacheKt;
import androidx.core.util.Preconditions;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class ExifData {
    private static final boolean DEBUG = false;
    static final ExifTag[] EXIF_POINTER_TAGS = null;
    static final ExifTag[][] EXIF_TAGS = null;
    private static final ExifTag[] IFD_EXIF_TAGS = null;
    static final String[] IFD_FORMAT_NAMES = null;
    private static final ExifTag[] IFD_GPS_TAGS = null;
    private static final ExifTag[] IFD_INTEROPERABILITY_TAGS = null;
    private static final ExifTag[] IFD_TIFF_TAGS = null;
    static final int IFD_TYPE_EXIF = 1;
    static final int IFD_TYPE_GPS = 2;
    static final int IFD_TYPE_INTEROPERABILITY = 3;
    static final int IFD_TYPE_PRIMARY = 0;
    private static final int MM_IN_MICRONS = 1000;
    private static final String TAG = "ExifData";
    static final String TAG_EXIF_IFD_POINTER = "ExifIFDPointer";
    static final String TAG_GPS_INFO_IFD_POINTER = "GPSInfoIFDPointer";
    static final String TAG_INTEROPERABILITY_IFD_POINTER = "InteroperabilityIFDPointer";
    static final String TAG_SUB_IFD_POINTER = "SubIFDPointer";
    static final HashSet<String> sTagSetForCompatibility = null;
    private final List<Map<String, ExifAttribute>> mAttributes;
    private final ByteOrder mByteOrder;

    /* JADX INFO: renamed from: androidx.camera.core.impl.utils.ExifData$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$camera$core$impl$CameraCaptureMetaData$FlashState = null;

        static {
            int[] r0 = new int[CameraCaptureMetaData.FlashState.values().length];
            $SwitchMap$androidx$camera$core$impl$CameraCaptureMetaData$FlashState = r0;
            r0[CameraCaptureMetaData.FlashState.READY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$androidx$camera$core$impl$CameraCaptureMetaData$FlashState[CameraCaptureMetaData.FlashState.NONE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$androidx$camera$core$impl$CameraCaptureMetaData$FlashState[CameraCaptureMetaData.FlashState.FIRED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public static final class Builder {
        private static final Pattern DATETIME_PRIMARY_FORMAT_PATTERN = null;
        private static final Pattern DATETIME_SECONDARY_FORMAT_PATTERN = null;
        private static final int DATETIME_VALUE_STRING_LENGTH = 19;
        private static final Pattern GPS_TIMESTAMP_PATTERN = null;
        static final List<HashMap<String, ExifTag>> sExifTagMapsForWriting = null;
        final List<Map<String, ExifAttribute>> mAttributes;
        private final ByteOrder mByteOrder;

        static {
            GPS_TIMESTAMP_PATTERN = PatternProtector.compile("^(\\d{2}):(\\d{2}):(\\d{2})$");
            DATETIME_PRIMARY_FORMAT_PATTERN = PatternProtector.compile("^(\\d{4}):(\\d{2}):(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
            DATETIME_SECONDARY_FORMAT_PATTERN = PatternProtector.compile("^(\\d{4})-(\\d{2})-(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
            sExifTagMapsForWriting = Collections.list(new AnonymousClass1());
        }

        public ExifData build() {
            ArrayList r0 = Collections.list(new AnonymousClass3(this));
            if (((Map) ListProtector.get(r0, 1)).isEmpty() == true) goto L6;
            setAttributeIfMissing("ExposureProgram", String.valueOf(0), r0);
            setAttributeIfMissing("ExifVersion", "0230", r0);
            setAttributeIfMissing("ComponentsConfiguration", "1,2,3,0", r0);
            setAttributeIfMissing("MeteringMode", String.valueOf(0), r0);
            setAttributeIfMissing("LightSource", String.valueOf(0), r0);
            setAttributeIfMissing("FlashpixVersion", "0100", r0);
            setAttributeIfMissing("FocalPlaneResolutionUnit", String.valueOf(2), r0);
            setAttributeIfMissing("FileSource", String.valueOf(3), r0);
            setAttributeIfMissing("SceneType", String.valueOf(1), r0);
            setAttributeIfMissing("CustomRendered", String.valueOf(0), r0);
            setAttributeIfMissing("SceneCaptureType", String.valueOf(0), r0);
            setAttributeIfMissing("Contrast", String.valueOf(0), r0);
            setAttributeIfMissing("Saturation", String.valueOf(0), r0);
            setAttributeIfMissing("Sharpness", String.valueOf(0), r0);
        L6:
            if (((Map) ListProtector.get(r0, 2)).isEmpty() == true) goto L9;
            setAttributeIfMissing("GPSVersionID", "2300", r0);
            setAttributeIfMissing("GPSSpeedRef", "K", r0);
            setAttributeIfMissing("GPSTrackRef", "T", r0);
            setAttributeIfMissing("GPSImgDirectionRef", "T", r0);
            setAttributeIfMissing("GPSDestBearingRef", "T", r0);
            setAttributeIfMissing("GPSDestDistanceRef", "K", r0);
        L9:
            return new ExifData(this.mByteOrder, r0);
        }

        public Builder(ByteOrder r2) {
            this.mAttributes = Collections.list(new AnonymousClass2(this));
            this.mByteOrder = r2;
        }

        private static Pair<Integer, Integer> guessDataFormat(String r10) {
            int r3 = 1;
            if (r10.contains(",") == false) goto L35;
            String[] r11 = r10.split(",", -1);
            Pair<Integer, Integer> r0 = guessDataFormat(r11[0]);
            if (((Integer) r0.first).intValue() != 2) goto L8;
            return r0;
        L8:
            if (r3 >= r11.length) goto L33;
            Pair<Integer, Integer> r1 = guessDataFormat(r11[r3]);
            if (((Integer) r1.first).equals(r0.first) == false) goto L12;
        L15:
            int r2 = ((Integer) r0.first).intValue();
        L17:
            if (((Integer) r0.second).intValue() != (-1)) goto L19;
        L23:
            int r4 = -1;
        L24:
            if (r2 != (-1)) goto L28;
            if (r4 != (-1)) goto L28;
            return new Pair(2, -1);
        L28:
            if (r2 != (-1)) goto L30;
            r0 = new Pair(Integer.valueOf(r4), -1);
        L32:
            r3 = r3 + 1;
            goto L8
        L30:
            if (r4 != (-1)) goto L32;
            r0 = new Pair(Integer.valueOf(r2), -1);
            goto L32
        L19:
            if (((Integer) r1.first).equals(r0.second) == false) goto L21;
        L22:
            r4 = ((Integer) r0.second).intValue();
            goto L24
        L21:
            if (((Integer) r1.second).equals(r0.second) == false) goto L23;
        L12:
            if (((Integer) r1.second).equals(r0.first) == true) goto L15;
            r2 = -1;
            goto L17
        L33:
            return r0;
        L35:
            if (r10.contains("/") == false) goto L73;
            String[] r12 = r10.split("/", -1);
            if (r12.length != 2) goto L55;
            long r5 = (long) CastDoubleProtector.parseDouble(r12[0]);     // Catch: NumberFormatException -> L71
            long r6 = (long) CastDoubleProtector.parseDouble(r12[1]);     // Catch: NumberFormatException -> L71
            if (r5 < 0) goto L53;
            if (r6 < 0) goto L53;
            if (r5 > SieveCacheKt.NodeLinkMask) goto L51;
            if (r6 > SieveCacheKt.NodeLinkMask) goto L51;
            return new Pair(10, 5);
        L51:
            return new Pair(5, -1);
        L53:
            return new Pair(10, -1);
        L55:
            return new Pair(2, -1);
        L73:
            long r7 = CastLongProtector.parseLong(r10);     // Catch: NumberFormatException -> L67
            if (r7 >= 0) goto L59;
        L62:
            if (r7 >= 0) goto L66;
            return new Pair(9, -1);
        L66:
            return new Pair(4, -1);
        L59:
            if (r7 > 65535) goto L62;
            return new Pair(3, 4);
        L67:
            CastDoubleProtector.parseDouble(r10);     // Catch: NumberFormatException -> L69
            return new Pair(12, -1);
        L70:
            return new Pair(2, -1);
        }

        public Builder removeAttribute(String r3) {
            setAttributeInternal(r3, null, this.mAttributes);
            return this;
        }

        public Builder setExposureTimeNanos(long r4) {
            return setAttribute("ExposureTime", String.valueOf(r4 / TimeUnit.SECONDS.toNanos(1)));
        }

        public Builder setFlashState(CameraCaptureMetaData.FlashState r4) {
            if (r4 != CameraCaptureMetaData.FlashState.UNKNOWN) goto L5;
            return this;
        L5:
            int r0 = AnonymousClass1.$SwitchMap$androidx$camera$core$impl$CameraCaptureMetaData$FlashState[r4.ordinal()];
            if (r0 != 1) goto L8;
            int r5 = 0;
        L17:
            if ((r5 & 1) != 1) goto L20;
            setAttribute("LightSource", String.valueOf(4));
        L20:
            return setAttribute("Flash", String.valueOf(r5));
        L8:
            if (r0 != 2) goto L10;
            r5 = 32;
            goto L17
        L10:
            if (r0 == 3) goto L13;
            Logger.w(ExifData.TAG, "Unknown flash state: " + r4);
            return this;
        L13:
            r5 = 1;
            goto L17
        }

        public Builder setFocalLength(float r6) {
            return setAttribute("FocalLength", new LongRational((long) (r6 * 1000.0f), 1000).toString());
        }

        public Builder setImageHeight(int r2) {
            return setAttribute("ImageLength", String.valueOf(r2));
        }

        public Builder setImageWidth(int r2) {
            return setAttribute("ImageWidth", String.valueOf(r2));
        }

        public Builder setIso(int r3) {
            return setAttribute("SensitivityType", String.valueOf(3)).setAttribute("PhotographicSensitivity", String.valueOf(Math.min(65535, r3)));
        }

        public Builder setLensFNumber(float r2) {
            return setAttribute("FNumber", String.valueOf(r2));
        }

        public Builder setOrientationDegrees(int r3) {
            if (r3 != 0) goto L4;
            int r4 = 1;
        L15:
            return setAttribute("Orientation", String.valueOf(r4));
        L4:
            if (r3 != 90) goto L6;
            r4 = 6;
            goto L15
        L6:
            if (r3 != 180) goto L8;
            r4 = 3;
            goto L15
        L8:
            if (r3 == 270) goto L10;
            Logger.w(ExifData.TAG, "Unexpected orientation value: " + r3 + ". Must be one of 0, 90, 180, 270.");
            r4 = 0;
            goto L15
        L10:
            r4 = 8;
            goto L15
        }

        public Builder setWhiteBalanceMode(WhiteBalanceMode r2) {
            int r3 = r2.ordinal();
            if (r3 != 0) goto L5;
            String r4 = String.valueOf(0);
        L10:
            return setAttribute("WhiteBalance", r4);
        L5:
            if (r3 == 1) goto L7;
            r4 = null;
            goto L10
        L7:
            r4 = String.valueOf(1);
            goto L10
        }

        public Builder setAttribute(String r2, String r3) {
            setAttributeInternal(r2, r3, this.mAttributes);
            return this;
        }

        private void setAttributeIfMissing(String r3, String r4, List<Map<String, ExifAttribute>> r5) {
            Iterator<Map<String, ExifAttribute>> r0 = r5.iterator();
        L4:
            if (r0.hasNext() == false) goto L8;
            if (r0.next().containsKey(r3) == false) goto L4;
            return;
        L8:
            setAttributeInternal(r3, r4, r5);
        }

        private void setAttributeInternal(String r18, String r19, List<Map<String, ExifAttribute>> r20) {
            Builder r1 = this;
            String r0 = r18;
            String r2 = r19;
            if ("DateTime".equals(r0) == false) goto L5;
        L8:
            if (r2 == null) goto L19;
            boolean r4 = DATETIME_PRIMARY_FORMAT_PATTERN.matcher(r2).find();
            boolean r8 = DATETIME_SECONDARY_FORMAT_PATTERN.matcher(r2).find();
            if (r19.length() != DATETIME_VALUE_STRING_LENGTH) goto L16;
            if (r4 == true) goto L14;
            if (r8 == false) goto L16;
        L14:
            if (r8 == false) goto L19;
            r2 = r2.replaceAll("-", ":");
        L16:
            Logger.w(ExifData.TAG, "Invalid value for " + r0 + " : " + r2);
            return;
        L19:
            if ("ISOSpeedRatings".equals(r0) == false) goto L21;
            r0 = "PhotographicSensitivity";
        L21:
            String r5 = r0;
            int r3 = 2;
            int r9 = 1;
            if (r2 != null) goto L24;
        L37:
            char r6 = 0;
            int r7 = 0;
        L39:
            if (r7 >= ExifData.EXIF_TAGS.length) goto L100;
            ExifTag r10 = (ExifTag) ((HashMap) ListProtector.get(sExifTagMapsForWriting, r7)).get(r5);
            if (r10 == null) goto L98;
            if (r2 != null) goto L44;
            ((Map) ListProtector.get(r20, r7)).remove(r5);
            goto L98
        L44:
            Pair<Integer, Integer> r11 = guessDataFormat(r2);
            if (r10.primaryFormat != ((Integer) r11.first).intValue()) goto L47;
        L62:
            int r12 = r10.primaryFormat;
        L63:
            String r13 = "/";
            switch(r12) {
                case 1: goto L97;
                case 2: goto L96;
                case 3: goto L91;
                case 4: goto L86;
                case 5: goto L81;
                case 6: goto L98;
                case 7: goto L96;
                case 8: goto L98;
                case 9: goto L76;
                case 10: goto L71;
                case 11: goto L98;
                case 12: goto L66;
                default: goto L98;
            };
        L66:
            String[] r14 = r2.split(",", -1);
            double[] r15 = new double[r14.length];
            int r16 = 0;
        L68:
            if (r16 >= r14.length) goto L70;
            r15[r16] = CastDoubleProtector.parseDouble(r14[r16]);
            r16 = r16 + 1;
            goto L68
        L70:
            ((Map) ListProtector.get(r20, r7)).put(r5, ExifAttribute.createDouble(r15, r1.mByteOrder));
            goto L98
        L71:
            String[] r17 = r2.split(",", -1);
            LongRational[] r110 = new LongRational[r17.length];
            int r111 = 0;
        L73:
            if (r111 >= r17.length) goto L75;
            String[] r112 = r17[r111].split(r13, -1);
            r110[r111] = new LongRational((long) CastDoubleProtector.parseDouble(r112[r6]), (long) CastDoubleProtector.parseDouble(r112[r9]));
            r111 = r111 + 1;
            r13 = r13;
            r9 = 1;
            goto L73
        L75:
            r1 = this;
            ((Map) ListProtector.get(r20, r7)).put(r5, ExifAttribute.createSRational(r110, r1.mByteOrder));
            goto L98
        L76:
            String[] r21 = r2.split(",", -1);
            int[] r22 = new int[r21.length];
            int r23 = 0;
        L78:
            if (r23 >= r21.length) goto L80;
            r22[r23] = CastIntegerProtector.parseInt(r21[r23]);
            r23 = r23 + 1;
            goto L78
        L80:
            ((Map) ListProtector.get(r20, r7)).put(r5, ExifAttribute.createSLong(r22, r1.mByteOrder));
            goto L98
        L81:
            String r113 = "/";
            String[] r24 = r2.split(",", -1);
            LongRational[] r25 = new LongRational[r24.length];
            int r26 = 0;
        L83:
            if (r26 >= r24.length) goto L85;
            String r114 = r113;
            String[] r27 = r24[r26].split(r114, -1);
            r25[r26] = new LongRational((long) CastDoubleProtector.parseDouble(r27[r6]), (long) CastDoubleProtector.parseDouble(r27[1]));
            r26 = r26 + 1;
            r113 = r114;
            r7 = r7;
            r6 = 0;
            goto L83
        L85:
            int r28 = r7;
            ((Map) ListProtector.get(r20, r28)).put(r5, ExifAttribute.createURational(r25, r1.mByteOrder));
        L99:
            r7 = r28 + 1;
            r3 = 2;
            r6 = 0;
            r9 = 1;
            goto L39
        L86:
            r28 = r7;
            String[] r29 = r2.split(",", -1);
            long[] r30 = new long[r29.length];
            int r31 = 0;
        L88:
            if (r31 >= r29.length) goto L90;
            r30[r31] = CastLongProtector.parseLong(r29[r31]);
            r31 = r31 + 1;
            goto L88
        L90:
            ((Map) ListProtector.get(r20, r28)).put(r5, ExifAttribute.createULong(r30, r1.mByteOrder));
            goto L99
        L91:
            r28 = r7;
            String[] r32 = r2.split(",", -1);
            int[] r33 = new int[r32.length];
            int r34 = 0;
        L93:
            if (r34 >= r32.length) goto L95;
            r33[r34] = CastIntegerProtector.parseInt(r32[r34]);
            r34 = r34 + 1;
            goto L93
        L95:
            ((Map) ListProtector.get(r20, r28)).put(r5, ExifAttribute.createUShort(r33, r1.mByteOrder));
            goto L99
        L96:
            r28 = r7;
            ((Map) ListProtector.get(r20, r28)).put(r5, ExifAttribute.createString(r2));
            goto L99
        L97:
            r28 = r7;
            ((Map) ListProtector.get(r20, r28)).put(r5, ExifAttribute.createByte(r2));
            goto L99
        L47:
            if (r10.primaryFormat == ((Integer) r11.second).intValue()) goto L62;
            int r115 = r10.secondaryFormat;
            if (r115 != (-1)) goto L52;
        L56:
            r12 = r10.primaryFormat;
            if (r12 == r9) goto L63;
            if (r12 == 7) goto L63;
            if (r12 != r3) goto L98;
        L52:
            if (r115 != ((Integer) r11.first).intValue()) goto L54;
        L55:
            r12 = r10.secondaryFormat;
            goto L63
        L54:
            if (r10.secondaryFormat != ((Integer) r11.second).intValue()) goto L56;
        L98:
            r28 = r7;
            goto L99
        L100:
            return;
        L24:
            if (ExifData.sTagSetForCompatibility.contains(r5) == false) goto L37;
            if (r5.equals("GPSTimeStamp") == false) goto L101;
            Matcher r35 = GPS_TIMESTAMP_PATTERN.matcher(r2);
            if (r35.find() == true) goto L31;
            Logger.w(ExifData.TAG, "Invalid value for " + r5 + " : " + r2);
            return;
        L31:
            r2 = CastIntegerProtector.parseInt((String) Preconditions.checkNotNull(r35.group(1))) + "/1," + CastIntegerProtector.parseInt((String) Preconditions.checkNotNull(r35.group(2))) + "/1," + CastIntegerProtector.parseInt((String) Preconditions.checkNotNull(r35.group(3))) + "/1";
            goto L37
        L101:
            r2 = new LongRational(CastDoubleProtector.parseDouble(r2)).toString();     // Catch: NumberFormatException -> L34
        L34:
            e = move-exception;
            Logger.w(ExifData.TAG, "Invalid value for " + r5 + " : " + r2, e);
            return;
        L5:
            if ("DateTimeOriginal".equals(r0) == true) goto L8;
            if ("DateTimeDigitized".equals(r0) == false) goto L19;
            goto L8
        }
    }

    public static final enum WhiteBalanceMode extends Enum<WhiteBalanceMode> {
        private static final /* synthetic */ WhiteBalanceMode[] $VALUES = null;
        public static final WhiteBalanceMode AUTO = null;
        public static final WhiteBalanceMode MANUAL = null;

        private static /* synthetic */ WhiteBalanceMode[] $values() {
            return new WhiteBalanceMode[]{AUTO, MANUAL};
        }

        static {
            AUTO = new WhiteBalanceMode("AUTO", 0);
            MANUAL = new WhiteBalanceMode("MANUAL", 1);
            $VALUES = $values();
        }

        public static WhiteBalanceMode[] values() {
            return (WhiteBalanceMode[]) $VALUES.clone();
        }

        public static WhiteBalanceMode valueOf(String r1) {
            return (WhiteBalanceMode) r27.a.a(WhiteBalanceMode.class, r1);
        }

        private WhiteBalanceMode(String r1, int r2) {
            super(r1, r2);
        }
    }

    static {
        IFD_FORMAT_NAMES = new String[]{"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};
        ExifTag[] r1 = {new ExifTag("ImageWidth", 256, 3, 4), new ExifTag("ImageLength", 257, 3, 4), new ExifTag("Make", 271, 2), new ExifTag("Model", 272, 2), new ExifTag("Orientation", 274, 3), new ExifTag("XResolution", 282, 5), new ExifTag("YResolution", 283, 5), new ExifTag("ResolutionUnit", 296, 3), new ExifTag("Software", 305, 2), new ExifTag("DateTime", 306, 2), new ExifTag("YCbCrPositioning", 531, 3), new ExifTag(TAG_SUB_IFD_POINTER, 330, 4), new ExifTag(TAG_EXIF_IFD_POINTER, 34665, 4), new ExifTag(TAG_GPS_INFO_IFD_POINTER, 34853, 4)};
        IFD_TIFF_TAGS = r1;
        ExifTag[] r2 = {new ExifTag("ExposureTime", 33434, 5), new ExifTag("FNumber", 33437, 5), new ExifTag("ExposureProgram", 34850, 3), new ExifTag("PhotographicSensitivity", 34855, 3), new ExifTag("SensitivityType", 34864, 3), new ExifTag("ExifVersion", 36864, 2), new ExifTag("DateTimeOriginal", 36867, 2), new ExifTag("DateTimeDigitized", 36868, 2), new ExifTag("ComponentsConfiguration", 37121, 7), new ExifTag("ShutterSpeedValue", 37377, 10), new ExifTag("ApertureValue", 37378, 5), new ExifTag("BrightnessValue", 37379, 10), new ExifTag("ExposureBiasValue", 37380, 10), new ExifTag("MaxApertureValue", 37381, 5), new ExifTag("MeteringMode", 37383, 3), new ExifTag("LightSource", 37384, 3), new ExifTag("Flash", 37385, 3), new ExifTag("FocalLength", 37386, 5), new ExifTag("SubSecTime", 37520, 2), new ExifTag("SubSecTimeOriginal", 37521, 2), new ExifTag("SubSecTimeDigitized", 37522, 2), new ExifTag("FlashpixVersion", 40960, 7), new ExifTag("ColorSpace", 40961, 3), new ExifTag("PixelXDimension", 40962, 3, 4), new ExifTag("PixelYDimension", 40963, 3, 4), new ExifTag(TAG_INTEROPERABILITY_IFD_POINTER, 40965, 4), new ExifTag("FocalPlaneResolutionUnit", 41488, 3), new ExifTag("SensingMethod", 41495, 3), new ExifTag("FileSource", 41728, 7), new ExifTag("SceneType", 41729, 7), new ExifTag("CustomRendered", 41985, 3), new ExifTag("ExposureMode", 41986, 3), new ExifTag("WhiteBalance", 41987, 3), new ExifTag("SceneCaptureType", 41990, 3), new ExifTag("Contrast", 41992, 3), new ExifTag("Saturation", 41993, 3), new ExifTag("Sharpness", 41994, 3)};
        IFD_EXIF_TAGS = r2;
        ExifTag[] r3 = {new ExifTag("GPSVersionID", 0, 1), new ExifTag("GPSLatitudeRef", 1, 2), new ExifTag("GPSLatitude", 2, 5, 10), new ExifTag("GPSLongitudeRef", 3, 2), new ExifTag("GPSLongitude", 4, 5, 10), new ExifTag("GPSAltitudeRef", 5, 1), new ExifTag("GPSAltitude", 6, 5), new ExifTag("GPSTimeStamp", 7, 5), new ExifTag("GPSSpeedRef", 12, 2), new ExifTag("GPSTrackRef", 14, 2), new ExifTag("GPSImgDirectionRef", 16, 2), new ExifTag("GPSDestBearingRef", 23, 2), new ExifTag("GPSDestDistanceRef", 25, 2)};
        IFD_GPS_TAGS = r3;
        EXIF_POINTER_TAGS = new ExifTag[]{new ExifTag(TAG_SUB_IFD_POINTER, 330, 4), new ExifTag(TAG_EXIF_IFD_POINTER, 34665, 4), new ExifTag(TAG_GPS_INFO_IFD_POINTER, 34853, 4), new ExifTag(TAG_INTEROPERABILITY_IFD_POINTER, 40965, 4)};
        ExifTag[] r0 = {new ExifTag("InteroperabilityIndex", 1, 2)};
        IFD_INTEROPERABILITY_TAGS = r0;
        EXIF_TAGS = new ExifTag[][]{r1, r2, r3, r0};
        sTagSetForCompatibility = new HashSet(Arrays.asList(new String[]{"FNumber", "ExposureTime", "GPSTimeStamp"}));
    }

    public static Builder builderForDevice() {
        return new Builder(ByteOrder.BIG_ENDIAN).setAttribute("Orientation", String.valueOf(1)).setAttribute("XResolution", "72/1").setAttribute("YResolution", "72/1").setAttribute("ResolutionUnit", String.valueOf(2)).setAttribute("YCbCrPositioning", String.valueOf(1)).setAttribute("Make", Build.MANUFACTURER).setAttribute("Model", Build.MODEL);
    }

    public ByteOrder getByteOrder() {
        return this.mByteOrder;
    }

    private ExifAttribute getExifAttribute(String r3) {
        if ("ISOSpeedRatings".equals(r3) == false) goto L5;
        r3 = "PhotographicSensitivity";
    L5:
        int r0 = 0;
    L7:
        if (r0 >= EXIF_TAGS.length) goto L12;
        ExifAttribute r1 = (ExifAttribute) ((Map) ListProtector.get(this.mAttributes, r0)).get(r3);
        if (r1 != null) goto L10;
        r0 = r0 + 1;
        goto L7
    L10:
        return r1;
    L12:
        return null;
    }

    public String getAttribute(String r7) {
        ExifAttribute r0 = getExifAttribute(r7);
        if (r0 != null) goto L5;
    L27:
        return null;
    L5:
        if (sTagSetForCompatibility.contains(r7) == true) goto L9;
        return r0.getStringValue(this.mByteOrder);
    L9:
        if (r7.equals("GPSTimeStamp") == false) goto L29;
        int r8 = r0.format;
        if (r8 != 5) goto L13;
    L16:
        LongRational[] r9 = (LongRational[]) r0.getValue(this.mByteOrder);
        if (r9 != null) goto L19;
    L23:
        Logger.w(TAG, "Invalid GPS Timestamp array. array=" + Arrays.toString(r9));
        return null;
    L19:
        if (r9.length != 3) goto L23;
        return String.format(Locale.US, "%02d:%02d:%02d", new Object[]{Integer.valueOf((int) (r9[0].getNumerator() / r9[0].getDenominator())), Integer.valueOf((int) (r9[1].getNumerator() / r9[1].getDenominator())), Integer.valueOf((int) (r9[2].getNumerator() / r9[2].getDenominator()))});
    L13:
        if (r8 == 10) goto L16;
        Logger.w(TAG, "GPS Timestamp format is not rational. format=" + r0.format);
        return null;
    L29:
        return Double.toString(r0.getDoubleValue(this.mByteOrder));
    }

    public Map<String, ExifAttribute> getAttributes(int r4) {
        Preconditions.checkArgumentInRange(r4, 0, EXIF_TAGS.length, "Invalid IFD index: " + r4 + ". Index should be between [0, EXIF_TAGS.length] ");
        return (Map) ListProtector.get(this.mAttributes, r4);
    }

    public ExifData(ByteOrder r3, List<Map<String, ExifAttribute>> r4) {
        if (r4.size() != EXIF_TAGS.length) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkState(r0, "Malformed attributes list. Number of IFDs mismatch.");
        this.mByteOrder = r3;
        this.mAttributes = r4;
        return;
    L5:
        r0 = false;
        goto L6
    }

    public static ExifData create(ImageProxy r2, int r3) {
        Builder r0 = builderForDevice();
        if (r2.getImageInfo() == null) goto L5;
        r2.getImageInfo().populateExifData(r0);
    L5:
        r0.setOrientationDegrees(r3);
        return r0.setImageWidth(r2.getWidth()).setImageHeight(r2.getHeight()).build();
    }
}
