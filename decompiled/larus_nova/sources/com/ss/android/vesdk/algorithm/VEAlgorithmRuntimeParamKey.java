package com.ss.android.vesdk.algorithm;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum VEAlgorithmRuntimeParamKey extends Enum<VEAlgorithmRuntimeParamKey> {
    private static final /* synthetic */ VEAlgorithmRuntimeParamKey[] $VALUES = null;
    public static final VEAlgorithmRuntimeParamKey FACE_ATTR_FEMALE_SCORE_RANGE = null;
    public static final VEAlgorithmRuntimeParamKey FACE_ATTR_FORCE_DETEC = null;
    public static final VEAlgorithmRuntimeParamKey FACE_ATTR_MALE_SCORE_RANGE = null;
    public static final VEAlgorithmRuntimeParamKey FACE_PARAM_BASE_SMOOTH_LEVEL = null;
    public static final VEAlgorithmRuntimeParamKey FACE_PARAM_EXTRA_SMOOTH_LEVEL = null;
    public static final VEAlgorithmRuntimeParamKey FACE_PARAM_USE_FILTER_V2 = null;
    public static final VEAlgorithmRuntimeParamKey SKELETON_FORCE_DETECT = null;
    private int value;

    private static /* synthetic */ VEAlgorithmRuntimeParamKey[] $values() {
        return new VEAlgorithmRuntimeParamKey[]{FACE_PARAM_BASE_SMOOTH_LEVEL, FACE_PARAM_EXTRA_SMOOTH_LEVEL, FACE_ATTR_MALE_SCORE_RANGE, FACE_ATTR_FEMALE_SCORE_RANGE, FACE_ATTR_FORCE_DETEC, SKELETON_FORCE_DETECT, FACE_PARAM_USE_FILTER_V2};
    }

    static {
        FACE_PARAM_BASE_SMOOTH_LEVEL = new VEAlgorithmRuntimeParamKey("FACE_PARAM_BASE_SMOOTH_LEVEL", 0, 100);
        FACE_PARAM_EXTRA_SMOOTH_LEVEL = new VEAlgorithmRuntimeParamKey("FACE_PARAM_EXTRA_SMOOTH_LEVEL", 1, 101);
        FACE_ATTR_MALE_SCORE_RANGE = new VEAlgorithmRuntimeParamKey("FACE_ATTR_MALE_SCORE_RANGE", 2, 102);
        FACE_ATTR_FEMALE_SCORE_RANGE = new VEAlgorithmRuntimeParamKey("FACE_ATTR_FEMALE_SCORE_RANGE", 3, 103);
        FACE_ATTR_FORCE_DETEC = new VEAlgorithmRuntimeParamKey("FACE_ATTR_FORCE_DETEC", 4, 104);
        SKELETON_FORCE_DETECT = new VEAlgorithmRuntimeParamKey("SKELETON_FORCE_DETECT", 5, 105);
        FACE_PARAM_USE_FILTER_V2 = new VEAlgorithmRuntimeParamKey("FACE_PARAM_USE_FILTER_V2", 6, 107);
        $VALUES = $values();
    }

    public static VEAlgorithmRuntimeParamKey[] values() {
        return (VEAlgorithmRuntimeParamKey[]) $VALUES.clone();
    }

    public int getValue() {
        return this.value;
    }

    public static VEAlgorithmRuntimeParamKey valueOf(String r100) {
        return (VEAlgorithmRuntimeParamKey) a.a(VEAlgorithmRuntimeParamKey.class, r100);
    }

    private VEAlgorithmRuntimeParamKey(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
