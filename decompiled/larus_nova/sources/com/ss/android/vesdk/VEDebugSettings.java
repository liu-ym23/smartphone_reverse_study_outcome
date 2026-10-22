package com.ss.android.vesdk;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;

/* JADX INFO: loaded from: classes40.dex */
public class VEDebugSettings {
    private static final String TAG = "VEDebugSettings";
    private String mCaptureDir;
    private boolean mEnableImageDump;
    private String mImageDumpDir;
    private ImageDumpType mImageDumpType;
    private String mPreviewDir;

    public static final enum ImageDumpType extends Enum<ImageDumpType> {
        public static final ImageDumpType BOTH = null;
        public static final ImageDumpType CAPTURE = null;
        public static final ImageDumpType PREVIEW = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ImageDumpType[] f455535a = null;

        static {
            ImageDumpType r100 = new ImageDumpType("CAPTURE", 0);
            CAPTURE = r100;
            ImageDumpType r101 = new ImageDumpType("PREVIEW", 1);
            PREVIEW = r101;
            ImageDumpType r102 = new ImageDumpType("BOTH", 2);
            BOTH = r102;
            f455535a = new ImageDumpType[]{r100, r101, r102};
        }

        public static ImageDumpType[] values() {
            return (ImageDumpType[]) f455535a.clone();
        }

        public static ImageDumpType valueOf(String r100) {
            return (ImageDumpType) r27.a.a(ImageDumpType.class, r100);
        }

        public ImageDumpType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static /* synthetic */ class a {
    }

    public int getImageDumpTypeValue() {
        return this.mImageDumpType.ordinal();
    }

    public void init() {
        if (this.mEnableImageDump == false) goto L24;
        PolarisFileWrapper r100 = new PolarisFileWrapper(this.mImageDumpDir);
        if (r100.exists() == true) goto L10;
        if (r100.isDirectory() == true) goto L10;
        VELogUtil.i(TAG, "Dump directory is not exist, so do mkdir {" + this.mImageDumpDir + com.alipay.sdk.m.u.i.f25855d);
        r100.mkdir();
    L10:
        if (isNeedDumpCapture() == false) goto L17;
        PolarisFileWrapper r101 = new PolarisFileWrapper(this.mCaptureDir);
        if (r101.exists() == true) goto L17;
        if (r101.isDirectory() == true) goto L17;
        VELogUtil.i(TAG, "Dump capture directory is not exist, so do mkdir {" + this.mCaptureDir + com.alipay.sdk.m.u.i.f25855d);
        r101.mkdir();
    L17:
        if (isNeedDumpPreview() == false) goto L25;
        PolarisFileWrapper r102 = new PolarisFileWrapper(this.mPreviewDir);
        if (r102.exists() == false) goto L21;
        return;
    L21:
        if (r102.isDirectory() == true) goto L27;
        VELogUtil.i(TAG, "Dump preview directory is not exist, so do mkdir {" + this.mPreviewDir + com.alipay.sdk.m.u.i.f25855d);
        r102.mkdir();
        return;
    L27:
        return;
    L25:
        return;
    }

    public boolean isNeedDumpCapture() {
        if (this.mEnableImageDump == false) goto L10;
        ImageDumpType r100 = this.mImageDumpType;
        if (r100 != ImageDumpType.BOTH) goto L7;
        return true;
    L7:
        if (r100 != ImageDumpType.CAPTURE) goto L13;
        return true;
    L13:
        return false;
    L10:
        return false;
    }

    public boolean isNeedDumpPreview() {
        if (this.mEnableImageDump == false) goto L10;
        ImageDumpType r100 = this.mImageDumpType;
        if (r100 != ImageDumpType.BOTH) goto L7;
        return true;
    L7:
        if (r100 != ImageDumpType.PREVIEW) goto L13;
        return true;
    L13:
        return false;
    L10:
        return false;
    }

    public String toString() {
        return "DebugSettings{mEnableImageDump=" + this.mEnableImageDump + ", mImageDumpType=" + this.mImageDumpType + ", mImageDumpDir=" + this.mImageDumpDir + ", mCaptureDir=" + this.mCaptureDir + ", mPreviewDir=" + this.mPreviewDir + com.alipay.sdk.m.u.i.f25855d;
    }

    private VEDebugSettings() {
        this.mEnableImageDump = false;
        this.mImageDumpType = ImageDumpType.CAPTURE;
        this.mImageDumpDir = "sdcard/vemo";
        StringBuilder r100 = new StringBuilder();
        r100.append(this.mImageDumpDir);
        String r101 = File.separator;
        r100.append(r101);
        r100.append("capture");
        this.mCaptureDir = r100.toString();
        this.mPreviewDir = this.mImageDumpDir + r101 + "preview";
    }

    public String getCapDumpDir() {
        return this.mCaptureDir;
    }

    public boolean getEnableImageDump() {
        return this.mEnableImageDump;
    }

    public String getImageDumpDir() {
        return this.mImageDumpDir;
    }

    public ImageDumpType getImageDumpType() {
        return this.mImageDumpType;
    }

    public String getPrvDumpDir() {
        return this.mPreviewDir;
    }

    public /* synthetic */ VEDebugSettings(a r100) {
        this();
    }

    public static /* synthetic */ boolean access$102(VEDebugSettings r100, boolean r101) {
        r100.mEnableImageDump = r101;
        return r101;
    }

    public static /* synthetic */ ImageDumpType access$202(VEDebugSettings r100, ImageDumpType r101) {
        r100.mImageDumpType = r101;
        return r101;
    }

    public static /* synthetic */ String access$302(VEDebugSettings r100, String r101) {
        r100.mImageDumpDir = r101;
        return r101;
    }

    public static /* synthetic */ String access$402(VEDebugSettings r100, String r101) {
        r100.mCaptureDir = r101;
        return r101;
    }

    public static /* synthetic */ String access$502(VEDebugSettings r100, String r101) {
        r100.mPreviewDir = r101;
        return r101;
    }
}
