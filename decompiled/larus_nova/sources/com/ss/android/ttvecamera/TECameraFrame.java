package com.ss.android.ttvecamera;

import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.DngCreator;
import android.hardware.camera2.TotalCaptureResult;
import android.os.Build;
import android.util.Rational;
import androidx.exifinterface.media.ExifInterface;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes38.dex */
public class TECameraFrame {
    public static final int FRAME_TYPE_BUFFER = 2;
    public static final int FRAME_TYPE_DEFAULT = 0;
    public static final int FRAME_TYPE_RAW = 4;
    public static final int FRAME_TYPE_TEXTURE = 1;
    public static final int FRAME_TYPE_YUV_PLANS = 3;
    public static final String TAG = "TECameraFrame";
    private boolean isDependSurfaceTimestamp;
    private boolean isMatchFrameHandleFps;
    private CameraFrameBase mCameraFrameBase;
    private boolean mCanDrop;
    private int mHeight;
    private Metadata mMetadata;
    private int mWidth;
    public long mfTimestampNS;

    /* JADX INFO: renamed from: com.ss.android.ttvecamera.TECameraFrame$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$android$ttvecamera$TECameraFrame$ETEPixelFormat = null;

        static {
            int[] r100 = new int[ETEPixelFormat.values().length];
            $SwitchMap$com$ss$android$ttvecamera$TECameraFrame$ETEPixelFormat = r100;
            r100[ETEPixelFormat.PIXEL_FORMAT_YUV420.ordinal()] = 1;     // Catch: NoSuchFieldError -> L21
        L60:
            $SwitchMap$com$ss$android$ttvecamera$TECameraFrame$ETEPixelFormat[ETEPixelFormat.PIXEL_FORMAT_YUV420P.ordinal()] = 2;     // Catch: NoSuchFieldError -> L22
        L44:
            $SwitchMap$com$ss$android$ttvecamera$TECameraFrame$ETEPixelFormat[ETEPixelFormat.PIXEL_FORMAT_NV21.ordinal()] = 3;     // Catch: NoSuchFieldError -> L23
        L56:
            $SwitchMap$com$ss$android$ttvecamera$TECameraFrame$ETEPixelFormat[ETEPixelFormat.PIXEL_FORMAT_YUV422P.ordinal()] = 4;     // Catch: NoSuchFieldError -> L24
        L62:
            $SwitchMap$com$ss$android$ttvecamera$TECameraFrame$ETEPixelFormat[ETEPixelFormat.PIXEL_FORMAT_YUYV422.ordinal()] = 5;     // Catch: NoSuchFieldError -> L25
        L46:
            $SwitchMap$com$ss$android$ttvecamera$TECameraFrame$ETEPixelFormat[ETEPixelFormat.PIXEL_FORMAT_UYVY422.ordinal()] = 6;     // Catch: NoSuchFieldError -> L26
        L50:
            $SwitchMap$com$ss$android$ttvecamera$TECameraFrame$ETEPixelFormat[ETEPixelFormat.PIXEL_FORMAT_RGB8.ordinal()] = 7;     // Catch: NoSuchFieldError -> L27
        L70:
            $SwitchMap$com$ss$android$ttvecamera$TECameraFrame$ETEPixelFormat[ETEPixelFormat.PIXEL_FORMAT_RGBA8.ordinal()] = 8;     // Catch: NoSuchFieldError -> L28
        L40:
            $SwitchMap$com$ss$android$ttvecamera$TECameraFrame$ETEPixelFormat[ETEPixelFormat.PIXEL_FORMAT_JPEG.ordinal()] = 9;     // Catch: NoSuchFieldError -> L29
        L64:
            $SwitchMap$com$ss$android$ttvecamera$TECameraFrame$ETEPixelFormat[ETEPixelFormat.PIXEL_FORMAT_GRAY8.ordinal()] = 10;     // Catch: NoSuchFieldError -> L30
        L66:
            $SwitchMap$com$ss$android$ttvecamera$TECameraFrame$ETEPixelFormat[ETEPixelFormat.PIXEL_FORMAT_BGR8.ordinal()] = 11;     // Catch: NoSuchFieldError -> L31
        L52:
            $SwitchMap$com$ss$android$ttvecamera$TECameraFrame$ETEPixelFormat[ETEPixelFormat.PIXEL_FORMAT_NV12.ordinal()] = 12;     // Catch: NoSuchFieldError -> L32
        L58:
            $SwitchMap$com$ss$android$ttvecamera$TECameraFrame$ETEPixelFormat[ETEPixelFormat.PIXEL_FORMAT_OpenGL_GRAY.ordinal()] = 13;     // Catch: NoSuchFieldError -> L33
        L42:
            $SwitchMap$com$ss$android$ttvecamera$TECameraFrame$ETEPixelFormat[ETEPixelFormat.PIXEL_FORMAT_OpenGL_RGB8.ordinal()] = 14;     // Catch: NoSuchFieldError -> L34
        L48:
            $SwitchMap$com$ss$android$ttvecamera$TECameraFrame$ETEPixelFormat[ETEPixelFormat.PIXEL_FORMAT_OpenGL_RGBA8.ordinal()] = 15;     // Catch: NoSuchFieldError -> L35
        L68:
            $SwitchMap$com$ss$android$ttvecamera$TECameraFrame$ETEPixelFormat[ETEPixelFormat.PIXEL_FORMAT_OpenGL_OES.ordinal()] = 16;     // Catch: NoSuchFieldError -> L36
        L38:
            $SwitchMap$com$ss$android$ttvecamera$TECameraFrame$ETEPixelFormat[ETEPixelFormat.PIXEL_FORMAT_Count.ordinal()] = 17;     // Catch: NoSuchFieldError -> L37
            return;
        }
    }

    public static class BufferFrame extends CameraFrameBase {
        private byte[] mBufferData;
        private int mSize;

        public byte[] getBufferData() {
            return this.mBufferData;
        }

        public int getBufferSize() {
            return this.mSize;
        }

        public BufferFrame(int r100, int r101, long r102, byte[] r110, int r111, ETEPixelFormat r112, int r113) {
            super(r100, r101, r102, r113);
            this.mType = 2;
            this.mRotationRad = r111;
            this.mPixelFormat = r112;
            this.mBufferData = r110;
            this.mSize = (r100 * r101) * 4;
        }
    }

    public static class CameraFrameBase {
        public int mFacing;
        public TEFrameSizei mFrameSizei;
        public ETEPixelFormat mPixelFormat;
        public int mRotationRad;
        public int mType;
        public long mfTimestampNs;

        public CameraFrameBase(int r100, int r101, long r102) {
            this(r100, r101, r102, 0);
        }

        public CameraFrameBase(int r100, int r101, long r102, int r103) {
            this.mType = 0;
            this.mFrameSizei = new TEFrameSizei(r100, r101);
            this.mfTimestampNs = r102;
            this.mFacing = r103;
        }
    }

    public static final enum ETEPixelFormat extends Enum<ETEPixelFormat> {
        private static final /* synthetic */ ETEPixelFormat[] $VALUES = null;
        public static final ETEPixelFormat PIXEL_FORMAT_ARGB8 = null;
        public static final ETEPixelFormat PIXEL_FORMAT_BGR8 = null;
        public static final ETEPixelFormat PIXEL_FORMAT_BGRA8 = null;
        public static final ETEPixelFormat PIXEL_FORMAT_BUFFER = null;
        public static final ETEPixelFormat PIXEL_FORMAT_Count = null;
        public static final ETEPixelFormat PIXEL_FORMAT_GRAY8 = null;
        public static final ETEPixelFormat PIXEL_FORMAT_JPEG = null;
        public static final ETEPixelFormat PIXEL_FORMAT_NV12 = null;
        public static final ETEPixelFormat PIXEL_FORMAT_NV21 = null;
        public static final ETEPixelFormat PIXEL_FORMAT_OpenGL_GRAY = null;
        public static final ETEPixelFormat PIXEL_FORMAT_OpenGL_OES = null;
        public static final ETEPixelFormat PIXEL_FORMAT_OpenGL_RGB8 = null;
        public static final ETEPixelFormat PIXEL_FORMAT_OpenGL_RGBA8 = null;
        public static final ETEPixelFormat PIXEL_FORMAT_RAW_SENSOR = null;
        public static final ETEPixelFormat PIXEL_FORMAT_RGB8 = null;
        public static final ETEPixelFormat PIXEL_FORMAT_RGBA8 = null;
        public static final ETEPixelFormat PIXEL_FORMAT_Recorder = null;
        public static final ETEPixelFormat PIXEL_FORMAT_UYVY422 = null;
        public static final ETEPixelFormat PIXEL_FORMAT_YUV420 = null;
        public static final ETEPixelFormat PIXEL_FORMAT_YUV420P = null;
        public static final ETEPixelFormat PIXEL_FORMAT_YUV422P = null;
        public static final ETEPixelFormat PIXEL_FORMAT_YUYV422 = null;

        private static /* synthetic */ ETEPixelFormat[] $values() {
            return new ETEPixelFormat[]{PIXEL_FORMAT_YUV420, PIXEL_FORMAT_YUV420P, PIXEL_FORMAT_NV12, PIXEL_FORMAT_NV21, PIXEL_FORMAT_YUYV422, PIXEL_FORMAT_YUV422P, PIXEL_FORMAT_UYVY422, PIXEL_FORMAT_GRAY8, PIXEL_FORMAT_RGB8, PIXEL_FORMAT_BGR8, PIXEL_FORMAT_ARGB8, PIXEL_FORMAT_RGBA8, PIXEL_FORMAT_BGRA8, PIXEL_FORMAT_OpenGL_GRAY, PIXEL_FORMAT_OpenGL_RGB8, PIXEL_FORMAT_OpenGL_RGBA8, PIXEL_FORMAT_OpenGL_OES, PIXEL_FORMAT_JPEG, PIXEL_FORMAT_BUFFER, PIXEL_FORMAT_Count, PIXEL_FORMAT_Recorder, PIXEL_FORMAT_RAW_SENSOR};
        }

        static {
            PIXEL_FORMAT_YUV420 = new ETEPixelFormat("PIXEL_FORMAT_YUV420", 0);
            PIXEL_FORMAT_YUV420P = new ETEPixelFormat("PIXEL_FORMAT_YUV420P", 1);
            PIXEL_FORMAT_NV12 = new ETEPixelFormat("PIXEL_FORMAT_NV12", 2);
            PIXEL_FORMAT_NV21 = new ETEPixelFormat("PIXEL_FORMAT_NV21", 3);
            PIXEL_FORMAT_YUYV422 = new ETEPixelFormat("PIXEL_FORMAT_YUYV422", 4);
            PIXEL_FORMAT_YUV422P = new ETEPixelFormat("PIXEL_FORMAT_YUV422P", 5);
            PIXEL_FORMAT_UYVY422 = new ETEPixelFormat("PIXEL_FORMAT_UYVY422", 6);
            PIXEL_FORMAT_GRAY8 = new ETEPixelFormat("PIXEL_FORMAT_GRAY8", 7);
            PIXEL_FORMAT_RGB8 = new ETEPixelFormat("PIXEL_FORMAT_RGB8", 8);
            PIXEL_FORMAT_BGR8 = new ETEPixelFormat("PIXEL_FORMAT_BGR8", 9);
            PIXEL_FORMAT_ARGB8 = new ETEPixelFormat("PIXEL_FORMAT_ARGB8", 10);
            PIXEL_FORMAT_RGBA8 = new ETEPixelFormat("PIXEL_FORMAT_RGBA8", 11);
            PIXEL_FORMAT_BGRA8 = new ETEPixelFormat("PIXEL_FORMAT_BGRA8", 12);
            PIXEL_FORMAT_OpenGL_GRAY = new ETEPixelFormat("PIXEL_FORMAT_OpenGL_GRAY", 13);
            PIXEL_FORMAT_OpenGL_RGB8 = new ETEPixelFormat("PIXEL_FORMAT_OpenGL_RGB8", 14);
            PIXEL_FORMAT_OpenGL_RGBA8 = new ETEPixelFormat("PIXEL_FORMAT_OpenGL_RGBA8", 15);
            PIXEL_FORMAT_OpenGL_OES = new ETEPixelFormat("PIXEL_FORMAT_OpenGL_OES", 16);
            PIXEL_FORMAT_JPEG = new ETEPixelFormat("PIXEL_FORMAT_JPEG", 17);
            PIXEL_FORMAT_BUFFER = new ETEPixelFormat("PIXEL_FORMAT_BUFFER", 18);
            PIXEL_FORMAT_Count = new ETEPixelFormat("PIXEL_FORMAT_Count", 19);
            PIXEL_FORMAT_Recorder = new ETEPixelFormat("PIXEL_FORMAT_Recorder", 20);
            PIXEL_FORMAT_RAW_SENSOR = new ETEPixelFormat("PIXEL_FORMAT_RAW_SENSOR", 21);
            $VALUES = $values();
        }

        public static ETEPixelFormat[] values() {
            return (ETEPixelFormat[]) $VALUES.clone();
        }

        public static ETEPixelFormat valueOf(String r100) {
            return (ETEPixelFormat) r27.a.a(ETEPixelFormat.class, r100);
        }

        private ETEPixelFormat(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static class Metadata {
        public TotalCaptureResult captureResult;
        public int exposureTime;
        public long exposureTimeInt64;
        public float fovX;
        public float fovY;
        public int height;
        public int iso;
        public float mCurrentZoom;
        public int maeState;
        public int mafState;
        public int maxIso;
        public int mflashState;
        public int minIso;
        public long timestamp;
        public long updateTimestamp;
        public int width;

        public HashMap<String, String> flatten() {
            HashMap<String, String> r100 = new HashMap();
            if (this.timestamp == (-1)) goto L11;
            TimeZone r101 = TimeZone.getDefault();
            SimpleDateFormat r102 = new SimpleDateFormat("yyyy:MM:dd kk:mm:ss");
            r102.setTimeZone(r101);
            String r103 = r102.format(Long.valueOf(this.timestamp));
            if (r103 == null) goto L11;
            r100.put(ExifInterface.TAG_DATETIME, r103);
            int r104 = Build.VERSION.SDK_INT;
            if (r104 < 23) goto L9;
            r100.put(ExifInterface.TAG_DATETIME_DIGITIZED, r103);
        L9:
            if (r104 < 24) goto L11;
            r100.put(ExifInterface.TAG_DATETIME_ORIGINAL, r103);
        L11:
            int r105 = this.width;
            if (r105 == (-1)) goto L16;
            r100.put(ExifInterface.TAG_IMAGE_WIDTH, String.valueOf(r105));
            if (Build.VERSION.SDK_INT < 24) goto L16;
            r100.put(ExifInterface.TAG_PIXEL_X_DIMENSION, String.valueOf(this.width));
        L16:
            int r106 = this.height;
            if (r106 == (-1)) goto L21;
            r100.put(ExifInterface.TAG_IMAGE_LENGTH, String.valueOf(r106));
            if (Build.VERSION.SDK_INT < 24) goto L21;
            r100.put(ExifInterface.TAG_PIXEL_Y_DIMENSION, String.valueOf(this.height));
        L21:
            String r107 = Build.MANUFACTURER;
            if (r107 == null) goto L24;
            r100.put(ExifInterface.TAG_MAKE, r107);
        L24:
            String r108 = Build.MODEL;
            if (r108 == null) goto L27;
            r100.put(ExifInterface.TAG_MODEL, r108);
        L27:
            TotalCaptureResult r109 = this.captureResult;
            if (r109 == null) goto L55;
            int r110 = Build.VERSION.SDK_INT;
            Long r111 = (Long) r109.get(CaptureResult.SENSOR_EXPOSURE_TIME);
            if (r111 == null) goto L32;
            r100.put(ExifInterface.TAG_EXPOSURE_TIME, String.valueOf(new Rational((int) (r111.longValue() / 1000000), 1000).floatValue()));
        L32:
            Integer r112 = (Integer) this.captureResult.get(CaptureResult.CONTROL_AWB_MODE);
            if (r112 != null) goto L35;
        L38:
            Integer r113 = (Integer) this.captureResult.get(CaptureResult.FLASH_STATE);
            if (r113 != null) goto L41;
        L44:
            if (r110 < 24) goto L55;
            Float r114 = (Float) this.captureResult.get(CaptureResult.LENS_FOCAL_LENGTH);
            if (r114 == null) goto L48;
            r100.put(ExifInterface.TAG_FOCAL_LENGTH, new Rational((int) (r114.floatValue() * 1000.0f), 1000).toString());
        L48:
            Integer r115 = (Integer) this.captureResult.get(CaptureResult.CONTROL_POST_RAW_SENSITIVITY_BOOST);
            Integer r116 = (Integer) this.captureResult.get(CaptureResult.SENSOR_SENSITIVITY);
            if (r116 == null) goto L52;
            if (r115 == null) goto L52;
            r100.put(ExifInterface.TAG_ISO_SPEED_RATINGS, String.valueOf((r116.intValue() * r115.intValue()) / 100));
        L52:
            Float r117 = (Float) this.captureResult.get(CaptureResult.LENS_APERTURE);
            if (r117 == null) goto L55;
            r100.put(ExifInterface.TAG_F_NUMBER, String.valueOf(r117));
            goto L55
        L41:
            if (r113.intValue() != 3) goto L43;
            r100.put(ExifInterface.TAG_FLASH, "1");
            goto L44
        L43:
            r100.put(ExifInterface.TAG_FLASH, "0");
            goto L44
        L35:
            if (r112.intValue() != 1) goto L37;
            r100.put(ExifInterface.TAG_WHITE_BALANCE, String.valueOf(0));
            goto L38
        L37:
            r100.put(ExifInterface.TAG_WHITE_BALANCE, String.valueOf(1));
        L55:
            r100.put("afState", String.valueOf(this.mafState));
            return r100;
        }

        public HashMap<String, Object> flattenForTitan() {
            HashMap<String, Object> r100 = new HashMap();
            int r101 = this.iso;
            if (r101 == (-1)) goto L5;
            r100.put("iso", Integer.valueOf(r101));
        L5:
            int r102 = this.maxIso;
            if (r102 == (-1)) goto L8;
            r100.put("maxiso", Integer.valueOf(r102));
        L8:
            int r103 = this.minIso;
            if (r103 == (-1)) goto L11;
            r100.put("minIso", Integer.valueOf(r103));
        L11:
            r100.put("aeState", Integer.valueOf(this.maeState));
            r100.put("afState", Integer.valueOf(this.mafState));
            r100.put("flashState", Integer.valueOf(this.mflashState));
            r100.put("currentZoom", Float.valueOf(this.mCurrentZoom));
            r100.put("fovX", Float.valueOf(this.fovX));
            r100.put("fovY", Float.valueOf(this.fovY));
            r100.put("exposuretime", Integer.valueOf(this.exposureTime));
            r100.put("exposuretimeInt64", Long.valueOf(this.exposureTimeInt64));
            if (this.mflashState != 3) goto L14;
            int r104 = 1;
        L15:
            r100.put(ExifInterface.TAG_FLASH, Integer.valueOf(r104));
            return r100;
        L14:
            r104 = 0;
            goto L15
        }

        public Metadata() {
            this.width = -1;
            this.height = -1;
            this.timestamp = -1;
            this.captureResult = null;
            this.iso = -1;
            this.maxIso = 0;
            this.minIso = 0;
            this.maeState = -1;
            this.mafState = -1;
            this.mflashState = -1;
            this.mCurrentZoom = 1.0f;
            this.fovX = -1.0f;
            this.fovY = -1.0f;
            this.exposureTime = 0;
            this.exposureTimeInt64 = 0;
            this.updateTimestamp = 0;
        }
    }

    public static class RawFrame extends CameraFrameBase {
        DngCreator mDngCreator;
        TEPlane mPlane;

        public DngCreator getDngCreator() {
            return this.mDngCreator;
        }

        public TEPlane getPlane() {
            return this.mPlane;
        }

        public RawFrame(int r100, int r101, long r102, TEPlane r110, int r111, ETEPixelFormat r112, int r113, DngCreator r114) {
            super(r100, r101, r102, r113);
            this.mType = 4;
            this.mRotationRad = r111;
            this.mPixelFormat = r112;
            this.mPlane = r110;
            this.mDngCreator = r114;
        }
    }

    public static class TextureFrame extends CameraFrameBase {
        float[] mMVPMatrix;
        private int mTextureID;

        public float[] getMVPMatrix() {
            return this.mMVPMatrix;
        }

        public int getTextureID() {
            return this.mTextureID;
        }

        public static /* synthetic */ int access$002(TextureFrame r100, int r101) {
            r100.mTextureID = r101;
            return r101;
        }

        public TextureFrame(int r100, int r101, long r102, int r110, int r111, float[] r112, ETEPixelFormat r113, int r114) {
            super(r100, r101, r102, r114);
            this.mType = 1;
            this.mTextureID = r110;
            this.mRotationRad = r111;
            this.mMVPMatrix = r112;
            this.mPixelFormat = r113;
        }
    }

    public static class YUVBytesFrame extends CameraFrameBase {
        byte[] mBytes;

        public byte[] getBytes() {
            return this.mBytes;
        }

        public YUVBytesFrame(int r100, int r101, long r102, byte[] r110, int r111, ETEPixelFormat r112, int r113) {
            super(r100, r101, r102, r113);
            this.mType = 3;
            this.mRotationRad = r111;
            this.mPixelFormat = r112;
            this.mBytes = r110;
        }
    }

    public static class YUVPlansFrame extends CameraFrameBase {
        TEPlane mPlane;

        public TEPlane getPlane() {
            return this.mPlane;
        }

        public YUVPlansFrame(int r100, int r101, long r102, TEPlane r110, int r111, ETEPixelFormat r112, int r113) {
            super(r100, r101, r102, r113);
            this.mType = 3;
            this.mRotationRad = r111;
            this.mPixelFormat = r112;
            this.mPlane = r110;
        }
    }

    public byte[] getBufferData() {
        CameraFrameBase r100 = this.mCameraFrameBase;
        if ((r100 instanceof BufferFrame) == true) goto L5;
        return null;
    L5:
        return ((BufferFrame) r100).getBufferData();
    }

    public int getBufferSize() {
        CameraFrameBase r100 = this.mCameraFrameBase;
        if ((r100 instanceof BufferFrame) == true) goto L5;
        return 0;
    L5:
        return ((BufferFrame) r100).getBufferSize();
    }

    public int getFacing() {
        return this.mCameraFrameBase.mFacing;
    }

    public float[] getMVPMatrix() {
        CameraFrameBase r100 = this.mCameraFrameBase;
        if ((r100 instanceof TextureFrame) == true) goto L5;
        return null;
    L5:
        return ((TextureFrame) r100).getMVPMatrix();
    }

    public ETEPixelFormat getPixelFormat() {
        return this.mCameraFrameBase.mPixelFormat;
    }

    public TEPlane getPlans() {
        CameraFrameBase r100 = this.mCameraFrameBase;
        if ((r100 instanceof YUVPlansFrame) == true) goto L5;
        return null;
    L5:
        return ((YUVPlansFrame) r100).getPlane();
    }

    public int getRotation() {
        return this.mCameraFrameBase.mRotationRad;
    }

    public TEFrameSizei getSize() {
        return this.mCameraFrameBase.mFrameSizei;
    }

    public int getTextureID() {
        CameraFrameBase r100 = this.mCameraFrameBase;
        if ((r100 instanceof TextureFrame) == true) goto L5;
        return 0;
    L5:
        return ((TextureFrame) r100).getTextureID();
    }

    public int getType() {
        return this.mCameraFrameBase.mType;
    }

    public byte[] getJpegData() {
        if (getPixelFormat() == ETEPixelFormat.PIXEL_FORMAT_JPEG) goto L6;
        TELogUtils.e(TAG, "Current format is " + getPixelFormat() + ", could not get jpeg data!");
        return null;
    L6:
        CameraFrameBase r100 = this.mCameraFrameBase;
        if ((r100 instanceof BufferFrame) == false) goto L10;
        return ((BufferFrame) r100).getBufferData();
    L10:
        if ((r100 instanceof YUVPlansFrame) == false) goto L12;
        ByteBuffer r101 = ((YUVPlansFrame) r100).getPlane().getPlaneBuffer(0);
        r101.rewind();
        byte[] r102 = new byte[r101.remaining()];
        r101.get(r102);
        return r102;
    L12:
        TELogUtils.e(TAG, "Unexpected frame instance! Failed to get jpeg data.");
        return null;
    }

    public Metadata getMetadata() {
        return this.mMetadata;
    }

    public long getTimeStampNS() {
        return this.mfTimestampNS;
    }

    public boolean isCanDrop() {
        return this.mCanDrop;
    }

    public boolean isDependSurfaceTimestamp() {
        return this.isDependSurfaceTimestamp;
    }

    public boolean isMatchFrameHandleFps() {
        return this.isMatchFrameHandleFps;
    }

    public static int pixelFormat2ImageFormat(ETEPixelFormat r100) {
        switch(AnonymousClass1.$SwitchMap$com$ss$android$ttvecamera$TECameraFrame$ETEPixelFormat[r100.ordinal()]) {
            case 1: goto L20;
            case 2: goto L18;
            case 3: goto L16;
            case 4: goto L14;
            case 5: goto L12;
            case 6: goto L12;
            case 7: goto L10;
            case 8: goto L8;
            case 9: goto L6;
            default: goto L4;
        };
    L4:
        return 0;
    L6:
        return 256;
    L8:
        return 42;
    L10:
        return 41;
    L12:
        return 39;
    L14:
        return 16;
    L16:
        return 17;
    L18:
        return 842094169;
    L20:
        return 35;
    }

    public void dumpImageToPath(String r100) {
        if (this.mCameraFrameBase != null) goto L6;
        TELogUtils.e(TAG, "frame is null, dump failed!");
        return;
    L6:
        String r101 = r100 + "_TECameraFrame" + ("_" + getSize().width + "x" + getSize().height) + ("_" + System.currentTimeMillis());
        int r102 = AnonymousClass1.$SwitchMap$com$ss$android$ttvecamera$TECameraFrame$ETEPixelFormat[getPixelFormat().ordinal()];
        if (r102 != 1) goto L9;
        String r103 = r101 + "_YUV420.yuv";
        TELogUtils.i(TAG, "Start to dump TECameraFrame to " + r103);
        if (getPlans() == null) goto L42;
        TECameraUtils.saveYUVToPath(getPlans().getPlanes(), getSize().width, getSize().height, r103);
        return;
    L42:
        CameraFrameBase r104 = this.mCameraFrameBase;
        if ((r104 instanceof BufferFrame) == false) goto L45;
        TECameraUtils.saveYUVToPath(((BufferFrame) r104).getBufferData(), getSize().width, getSize().height, r103);
        return;
    L45:
        TELogUtils.e(TAG, "data is null, dump failed!");
        return;
    L9:
        if (r102 != 2) goto L11;
        String r105 = r101 + "_YUV420P.yuv";
        TELogUtils.i(TAG, "Start to dump TECameraFrame to " + r105);
        if (getPlans() == null) goto L35;
        TECameraUtils.saveYUVToPath(getPlans().getPlanes(), getSize().width, getSize().height, r105);
        return;
    L35:
        CameraFrameBase r106 = this.mCameraFrameBase;
        if ((r106 instanceof BufferFrame) == false) goto L38;
        TECameraUtils.saveYUVToPath(((BufferFrame) r106).getBufferData(), getSize().width, getSize().height, r105);
        return;
    L38:
        TELogUtils.e(TAG, "data is null, dump failed!");
        return;
    L11:
        if (r102 != 3) goto L13;
        String r107 = r101 + "_NV21.yuv";
        TELogUtils.i(TAG, "Start to dump TECameraFrame to " + r107);
        if (getPlans() == null) goto L28;
        TECameraUtils.saveYUVToPath(getPlans().getPlanes(), getSize().width, getSize().height, r107);
        return;
    L28:
        CameraFrameBase r108 = this.mCameraFrameBase;
        if ((r108 instanceof BufferFrame) == false) goto L31;
        TECameraUtils.saveYUVToPath(((BufferFrame) r108).getBufferData(), getSize().width, getSize().height, r107);
        return;
    L31:
        TELogUtils.e(TAG, "data is null, dump failed!");
        return;
    L13:
        if (r102 != 9) goto L15;
        String r109 = r101 + "_JPEG.jpeg";
        TELogUtils.i(TAG, "Start to dump TECameraFrame to " + r109);
        TECameraUtils.saveJPEGToPath(getJpegData(), r109);
        return;
    L15:
        if (r102 == 12) goto L17;
        TELogUtils.e(TAG, "unexpected dump image format: " + getPixelFormat());
        return;
    L17:
        String r110 = r101 + "_NV12.yuv";
        TELogUtils.i(TAG, "Start to dump TECameraFrame to " + r110);
        if (getPlans() == null) goto L20;
        TECameraUtils.saveYUVToPath(getPlans().getPlanes(), getSize().width, getSize().height, r110);
        return;
    L20:
        CameraFrameBase r111 = this.mCameraFrameBase;
        if ((r111 instanceof BufferFrame) == false) goto L23;
        TECameraUtils.saveYUVToPath(((BufferFrame) r111).getBufferData(), getSize().width, getSize().height, r110);
        return;
    L23:
        TELogUtils.e(TAG, "data is null, dump failed!");
    }

    public void setCanDrop(boolean r100) {
        this.mCanDrop = r100;
    }

    public void setDependSurfaceTimestamp(boolean r100) {
        this.isDependSurfaceTimestamp = r100;
    }

    public void setEnableMatchFrameHandleFps(boolean r100) {
        this.isMatchFrameHandleFps = r100;
    }

    public void setMetadata(Metadata r100) {
        this.mMetadata = r100;
    }

    public void setTextureID(int r100) {
        CameraFrameBase r101 = this.mCameraFrameBase;
        if ((r101 instanceof TextureFrame) == false) goto L6;
        TextureFrame.access$002((TextureFrame) r101, r100);
        return;
    }

    public static ETEPixelFormat imageFormat2PixelFormat(int r100, int r101) {
        if (r101 != 2) goto L7;
        return ETEPixelFormat.PIXEL_FORMAT_OpenGL_OES;
    L7:
        if (r101 != 1) goto L16;
        if (r100 == 41) goto L10;
        if (r100 != 42) goto L15;
        return ETEPixelFormat.PIXEL_FORMAT_OpenGL_RGBA8;
    L15:
        return ETEPixelFormat.PIXEL_FORMAT_Count;
    L10:
        return ETEPixelFormat.PIXEL_FORMAT_OpenGL_RGB8;
    L16:
        if (r101 != 0) goto L42;
        if (r100 == 17) goto L40;
        if (r100 == 35) goto L38;
        if (r100 == 39) goto L36;
        if (r100 == 256) goto L34;
        if (r100 == 41) goto L32;
        if (r100 == 42) goto L30;
        return ETEPixelFormat.PIXEL_FORMAT_Count;
    L30:
        return ETEPixelFormat.PIXEL_FORMAT_RGBA8;
    L32:
        return ETEPixelFormat.PIXEL_FORMAT_RGB8;
    L34:
        return ETEPixelFormat.PIXEL_FORMAT_JPEG;
    L36:
        return ETEPixelFormat.PIXEL_FORMAT_YUV422P;
    L38:
        return ETEPixelFormat.PIXEL_FORMAT_YUV420P;
    L40:
        return ETEPixelFormat.PIXEL_FORMAT_NV21;
    L42:
        return ETEPixelFormat.PIXEL_FORMAT_Count;
    }

    public TECameraFrame(int r100, int r101, long r102) {
        this.isDependSurfaceTimestamp = true;
        this.isMatchFrameHandleFps = false;
        this.mCanDrop = false;
        this.mCameraFrameBase = new CameraFrameBase(0, 0, 0);
        this.mWidth = r100;
        this.mHeight = r101;
        this.mfTimestampNS = r102;
    }

    public void initBufferFrame(byte[] r110, int r111, ETEPixelFormat r112, int r113) {
        this.mCameraFrameBase = new BufferFrame(this.mWidth, this.mHeight, this.mfTimestampNS, r110, r111, r112, r113);
    }

    public void initYUVBytesPlans(byte[] r110, int r111, ETEPixelFormat r112, int r113) {
        this.mCameraFrameBase = new YUVBytesFrame(this.mWidth, this.mHeight, this.mfTimestampNS, r110, r111, r112, r113);
    }

    public void initYUVPlans(TEPlane r110, int r111, ETEPixelFormat r112, int r113) {
        this.mCameraFrameBase = new YUVPlansFrame(this.mWidth, this.mHeight, this.mfTimestampNS, r110, r111, r112, r113);
    }

    public void initRawPlans(TEPlane r110, int r111, ETEPixelFormat r112, int r113, DngCreator r114) {
        this.mCameraFrameBase = new RawFrame(this.mWidth, this.mHeight, this.mfTimestampNS, r110, r111, r112, r113, r114);
    }

    public void initTextureFrame(int r110, int r111, float[] r112, ETEPixelFormat r113, int r114) {
        this.mCameraFrameBase = new TextureFrame(this.mWidth, this.mHeight, this.mfTimestampNS, r110, r111, r112, r113, r114);
    }

    public TECameraFrame(TEPlane r100, ETEPixelFormat r110, int r111, int r112, int r113, DngCreator r114) {
        this(r111, r112, 0);
        initRawPlans(r100, r113, r110, 0, r114);
    }

    public TECameraFrame(TEPlane r100, ETEPixelFormat r101, int r102, int r103, int r104, int r105) {
        this(r102, r103, 0);
        initYUVPlans(r100, r104, r101, r105);
    }

    public TECameraFrame(byte[] r100, ETEPixelFormat r101, int r102, int r103, int r104, int r105) {
        this(r102, r103, 0);
        initBufferFrame(r100, r104, r101, r105);
    }
}
