package com.lightning.edu.ei.edgealgorithm;

import r27.a;

/* JADX INFO: loaded from: classes32.dex */
public final enum Status extends Enum<Status> {
    private static final /* synthetic */ Status[] $VALUES = null;
    public static final Status STATUS_BITMAP_GET_INFO = null;
    public static final Status STATUS_BITMAP_IS_RECYCLED = null;
    public static final Status STATUS_BITMAP_LOCK_PIXELS = null;
    public static final Status STATUS_BITMAP_NOT_RGBA8888 = null;
    public static final Status STATUS_CHECK_BLUR_FAILED = null;
    public static final Status STATUS_CHECK_DARK_FAILED = null;
    public static final Status STATUS_CHECK_SCENE_FAILED = null;
    public static final Status STATUS_DETECTION_INFERENCE_FAILED = null;
    public static final Status STATUS_DETECTION_INFERENCE_IS_NULL = null;
    public static final Status STATUS_IMAGE_SMALL = null;
    public static final Status STATUS_INFERENCE_IS_NULL = null;
    public static final Status STATUS_INFERENCE_IS_NULL_C = null;
    public static final Status STATUS_NEED_REFUSE = null;
    public static final Status STATUS_NEED_RETAKE = null;
    public static final Status STATUS_SUCCESS = null;
    private int statusCode;
    private String statusMsg;

    static {
        Status r100 = new Status("STATUS_SUCCESS", 0, 0, "Success");
        STATUS_SUCCESS = r100;
        Status r101 = new Status("STATUS_INFERENCE_IS_NULL", 1, 1, "Inference is null (InferenceNative)");
        STATUS_INFERENCE_IS_NULL = r101;
        Status r102 = new Status("STATUS_IMAGE_SMALL", 2, 2, "Image too small");
        STATUS_IMAGE_SMALL = r102;
        Status r103 = new Status("STATUS_INFERENCE_IS_NULL_C", 3, 3, "Inference is nullptr (JNI)");
        STATUS_INFERENCE_IS_NULL_C = r103;
        Status r104 = new Status("STATUS_BITMAP_IS_RECYCLED", 4, 4, "Bitmap is recycled");
        STATUS_BITMAP_IS_RECYCLED = r104;
        Status r105 = new Status("STATUS_BITMAP_GET_INFO", 5, 5, "Bitmap get info error");
        STATUS_BITMAP_GET_INFO = r105;
        Status r110 = new Status("STATUS_BITMAP_NOT_RGBA8888", 6, 6, "Bitmap is not RGBA8888 format");
        STATUS_BITMAP_NOT_RGBA8888 = r110;
        Status r111 = new Status("STATUS_BITMAP_LOCK_PIXELS", 7, 7, "Bitmap lock pixels error");
        STATUS_BITMAP_LOCK_PIXELS = r111;
        Status r112 = new Status("STATUS_CHECK_BLUR_FAILED", 8, 8, "Check Blur Failed");
        STATUS_CHECK_BLUR_FAILED = r112;
        Status r113 = new Status("STATUS_CHECK_SCENE_FAILED", 9, 9, "Check Scene Failed");
        STATUS_CHECK_SCENE_FAILED = r113;
        Status r114 = new Status("STATUS_CHECK_DARK_FAILED", 10, 10, "Check Dark Failed, Too Dark");
        STATUS_CHECK_DARK_FAILED = r114;
        Status r106 = new Status("STATUS_NEED_RETAKE", 11, 11, "Need retake photo!");
        STATUS_NEED_RETAKE = r106;
        Status r107 = new Status("STATUS_NEED_REFUSE", 12, 12, "Need refuse photo!");
        STATUS_NEED_REFUSE = r107;
        Status r108 = new Status("STATUS_DETECTION_INFERENCE_FAILED", 13, 13, "Detection Inference run error");
        STATUS_DETECTION_INFERENCE_FAILED = r108;
        Status r109 = new Status("STATUS_DETECTION_INFERENCE_IS_NULL", 14, 14, "Detection Inference is null (InferenceNative)");
        STATUS_DETECTION_INFERENCE_IS_NULL = r109;
        $VALUES = new Status[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106, r107, r108, r109};
    }

    public static Status[] values() {
        return (Status[]) $VALUES.clone();
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public String getStatusMsg() {
        return this.statusMsg;
    }

    public static Status valueOf(String r100) {
        return (Status) a.a(Status.class, r100);
    }

    private Status(String r100, int r101, int r102, String r103) {
        super(r100, r101);
        this.statusCode = r102;
        this.statusMsg = r103;
    }
}
