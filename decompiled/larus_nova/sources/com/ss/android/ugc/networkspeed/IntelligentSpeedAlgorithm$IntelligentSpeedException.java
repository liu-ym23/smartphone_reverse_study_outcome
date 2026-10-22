package com.ss.android.ugc.networkspeed;

/* JADX INFO: loaded from: classes40.dex */
public class IntelligentSpeedAlgorithm$IntelligentSpeedException extends Exception {
    public static final int COMPONENT_FUNC_RATIO_NULL = 2;
    public static final int COMPONENT_IS_NOT_ENABLE = 1;
    public static final int COMPONENT_IS_NULL = 0;
    public static final int COMPONENT_NOT_INITIALIZED = 3;
    public static final int SPEED_CALCULATE_ERROR = 5;
    public static final int SPEED_EVALUATOR_NOT_INITIALIZED = 4;
    private int code;
    private String msg;

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public IntelligentSpeedAlgorithm$IntelligentSpeedException(int r100, String r101) {
        this.code = r100;
        this.msg = r101;
    }
}
