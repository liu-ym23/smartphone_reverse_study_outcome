package com.ss.android.vesdk.algorithm;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum VECommCallbackType extends Enum<VECommCallbackType> {
    private static final /* synthetic */ VECommCallbackType[] $VALUES = null;
    public static final VECommCallbackType CALLBACK_TYPE_ERROR = null;
    public static final VECommCallbackType CALLBACK_TYPE_FINISH = null;
    public static final VECommCallbackType CALLBACK_TYPE_NONE = null;
    public static final VECommCallbackType CALLBACK_TYPE_PROGRESS = null;
    public static final VECommCallbackType CALLBACK_TYPE_RESULT_LAST = null;
    public static final VECommCallbackType CALLBACK_TYPE_RESULT_PER_FRAME = null;
    public static final VECommCallbackType CALLBACK_TYPE_RETRY_SW_COMPILE = null;

    private static /* synthetic */ VECommCallbackType[] $values() {
        return new VECommCallbackType[]{CALLBACK_TYPE_NONE, CALLBACK_TYPE_PROGRESS, CALLBACK_TYPE_ERROR, CALLBACK_TYPE_RESULT_PER_FRAME, CALLBACK_TYPE_RESULT_LAST, CALLBACK_TYPE_FINISH, CALLBACK_TYPE_RETRY_SW_COMPILE};
    }

    static {
        CALLBACK_TYPE_NONE = new VECommCallbackType("CALLBACK_TYPE_NONE", 0);
        CALLBACK_TYPE_PROGRESS = new VECommCallbackType("CALLBACK_TYPE_PROGRESS", 1);
        CALLBACK_TYPE_ERROR = new VECommCallbackType("CALLBACK_TYPE_ERROR", 2);
        CALLBACK_TYPE_RESULT_PER_FRAME = new VECommCallbackType("CALLBACK_TYPE_RESULT_PER_FRAME", 3);
        CALLBACK_TYPE_RESULT_LAST = new VECommCallbackType("CALLBACK_TYPE_RESULT_LAST", 4);
        CALLBACK_TYPE_FINISH = new VECommCallbackType("CALLBACK_TYPE_FINISH", 5);
        CALLBACK_TYPE_RETRY_SW_COMPILE = new VECommCallbackType("CALLBACK_TYPE_RETRY_SW_COMPILE", 6);
        $VALUES = $values();
    }

    public static VECommCallbackType[] values() {
        return (VECommCallbackType[]) $VALUES.clone();
    }

    public static VECommCallbackType valueOf(String r100) {
        return (VECommCallbackType) a.a(VECommCallbackType.class, r100);
    }

    private VECommCallbackType(String r100, int r101) {
        super(r100, r101);
    }
}
