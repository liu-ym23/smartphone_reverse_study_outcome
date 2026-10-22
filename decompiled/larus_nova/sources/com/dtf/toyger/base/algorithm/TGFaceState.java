package com.dtf.toyger.base.algorithm;

/* JADX INFO: loaded from: classes22.dex */
public class TGFaceState {
    public static final int TG_MESSAGE_BAD_BRIGHTNESS = 8;
    public static final int TG_MESSAGE_BAD_EYE_OPENNESS = 10;
    public static final int TG_MESSAGE_BAD_PITCH = 5;
    public static final int TG_MESSAGE_BAD_QUALITY = 9;
    public static final int TG_MESSAGE_BAD_ROLL = 20;
    public static final int TG_MESSAGE_BAD_YAW = 6;
    public static final int TG_MESSAGE_BLINK_OPENNESS = 11;
    public static final int TG_MESSAGE_DEPTH_DAMAGE = 13;
    public static final int TG_MESSAGE_DISTANCE_TOO_CLOSE = 3;
    public static final int TG_MESSAGE_DISTANCE_TOO_FAR = 2;
    public static final int TG_MESSAGE_FACE_NOT_IN_CENTER = 4;
    public static final int TG_MESSAGE_FACE_TOO_MORE = 19;
    public static final int TG_MESSAGE_HAT = 22;
    public static final int TG_MESSAGE_IMAGE_PERFECT = 0;
    public static final int TG_MESSAGE_IS_MOVING = 7;
    public static final int TG_MESSAGE_LEFT_YAW_GUIDE = 14;
    public static final int TG_MESSAGE_LIP_MOVE_GUIDE = 17;
    public static final int TG_MESSAGE_MASK = 21;
    public static final int TG_MESSAGE_MOUTH_OPEN_GUIDE = 16;
    public static final int TG_MESSAGE_NO_FACE = 1;
    public static final int TG_MESSAGE_OCCLUSION = 23;
    public static final int TG_MESSAGE_PHOTINUS_GUIDE = 18;
    public static final int TG_MESSAGE_QUALITY_ERROR = 24;
    public static final int TG_MESSAGE_RIGHT_YAW_GUIDE = 15;
    public static final int TG_MESSAGE_STACK_TIME = 12;
    public static final int TG_Message_Calibrate_Too_Close = 28;
    public static final int TG_Message_Calibrate_Too_Far = 27;
    public static final int TG_Message_Face_Not_In_Position = 30;
    public static final int TG_Message_NearFar_Collect = 29;
    public static final int TG_Message_Target_Too_Close = 26;
    public static final int TG_Message_Target_Too_Far = 25;
    public static final int TG_STATIC_MESSAGE_BLINK_LIVENESS = 1;
    public static final int TG_STATIC_MESSAGE_EQUIPMENT_LIVENESS = 8;
    public static final int TG_STATIC_MESSAGE_LEFT_YAW_LIVENESS = 2;
    public static final int TG_STATIC_MESSAGE_LIP_MOVEMENT_LIVENESS = 5;
    public static final int TG_STATIC_MESSAGE_MOUTH_OPEN_LIVENESS = 4;
    public static final int TG_STATIC_MESSAGE_NEARFAR_LIVENESS = 7;
    public static final int TG_STATIC_MESSAGE_NOLIVENESS = 0;
    public static final int TG_STATIC_MESSAGE_PHOTINUS_LIVENESS = 6;
    public static final int TG_STATIC_MESSAGE_RIGHT_YAW_LIVENESS = 3;
    public int brightness;
    public int distance;
    public boolean faceInCenter;
    public int goodPitch;
    public boolean goodQuality;
    public int goodYaw;
    public boolean hasFace;
    public boolean isMoving;
    public int messageCode;
    public float progress;
    public int staticMessage;
    public float targetFaceRegion;

    public TGFaceState() {
    }

    public TGFaceState(float r100, int r101) {
        this.progress = r100;
        this.messageCode = r101;
    }

    public TGFaceState(boolean r100, int r101, int r102, boolean r103, int r104, int r105, boolean r106, boolean r107, float r108) {
        this.hasFace = r100;
        this.brightness = r101;
        this.distance = r102;
        this.faceInCenter = r103;
        this.goodPitch = r104;
        this.goodYaw = r105;
        this.isMoving = r106;
        this.goodQuality = r107;
        this.progress = r108;
    }
}
