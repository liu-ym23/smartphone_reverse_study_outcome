package com.bytedance.applog.monitor.v3;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final enum Features$BooleanFeatureKeys extends Enum<Features$BooleanFeatureKeys> {
    public static final Features$BooleanFeatureKeys ADJUST_TERMINATE_SWITCH = null;
    public static final Features$BooleanFeatureKeys BG_SESSION_SWITCH = null;
    public static final Features$BooleanFeatureKeys CHILD_MODE_BEFORE_INIT_SWITCH = null;
    public static final Features$BooleanFeatureKeys CHILD_MODE_SWITCH = null;
    public static final Features$BooleanFeatureKeys CONTROL_CUSTOM_HEADER_SWITCH = null;
    public static final Features$BooleanFeatureKeys CONTROL_EVENT_PARAM_SWITCH = null;
    public static final Features$BooleanFeatureKeys CUSTOM_EVENT_FILTER = null;
    public static final Features$BooleanFeatureKeys DATA_ISOLATE_SWITCH = null;
    public static final Features$BooleanFeatureKeys DEBUG_LOG_SWITCH = null;
    public static final Features$BooleanFeatureKeys DEVTOOLS_SWITCH = null;
    public static final Features$BooleanFeatureKeys DISABLE_PERSONALIZATION_SWITCH = null;
    public static final Features$BooleanFeatureKeys ENCRYPT_SWITCH = null;
    public static final Features$BooleanFeatureKeys EVENT_USER_ID_SWITCH = null;
    public static final Features$BooleanFeatureKeys FORWARD_REPORT_SWITCH = null;
    public static final Features$BooleanFeatureKeys LOG_SETTINGS_EVENT_FILTER = null;
    public static final Features$BooleanFeatureKeys NORMAL_SAMPLING_SWITCH = null;
    public static final Features$BooleanFeatureKeys PRIORITY_SWITCH = null;
    public static final Features$BooleanFeatureKeys RECOVERY_SWITCH = null;
    public static final Features$BooleanFeatureKeys TEA_SAMPLING_SWITCH = null;
    public static final Features$BooleanFeatureKeys TOURIST_MODE_EVENT_SWITCH = null;
    public static final Features$BooleanFeatureKeys TOURIST_MODE_SWITCH = null;
    public static final /* synthetic */ Features$BooleanFeatureKeys[] a = null;
    private final int position;

    static {
        Features$BooleanFeatureKeys r0 = new Features$BooleanFeatureKeys("NORMAL_SAMPLING_SWITCH", 0, 0);
        NORMAL_SAMPLING_SWITCH = r0;
        Features$BooleanFeatureKeys r1 = new Features$BooleanFeatureKeys("TEA_SAMPLING_SWITCH", 1, 1);
        TEA_SAMPLING_SWITCH = r1;
        Features$BooleanFeatureKeys r3 = new Features$BooleanFeatureKeys("PRIORITY_SWITCH", 2, 2);
        PRIORITY_SWITCH = r3;
        Features$BooleanFeatureKeys r5 = new Features$BooleanFeatureKeys("RECOVERY_SWITCH", 3, 3);
        RECOVERY_SWITCH = r5;
        Features$BooleanFeatureKeys r7 = new Features$BooleanFeatureKeys("LOG_SETTINGS_EVENT_FILTER", 4, 4);
        LOG_SETTINGS_EVENT_FILTER = r7;
        Features$BooleanFeatureKeys r9 = new Features$BooleanFeatureKeys("CUSTOM_EVENT_FILTER", 5, 5);
        CUSTOM_EVENT_FILTER = r9;
        Features$BooleanFeatureKeys r11 = new Features$BooleanFeatureKeys("ENCRYPT_SWITCH", 6, 6);
        ENCRYPT_SWITCH = r11;
        Features$BooleanFeatureKeys r13 = new Features$BooleanFeatureKeys("FORWARD_REPORT_SWITCH", 7, 7);
        FORWARD_REPORT_SWITCH = r13;
        Features$BooleanFeatureKeys r15 = new Features$BooleanFeatureKeys("DATA_ISOLATE_SWITCH", 8, 8);
        DATA_ISOLATE_SWITCH = r15;
        Features$BooleanFeatureKeys r14 = new Features$BooleanFeatureKeys("EVENT_USER_ID_SWITCH", 9, 9);
        EVENT_USER_ID_SWITCH = r14;
        Features$BooleanFeatureKeys r12 = new Features$BooleanFeatureKeys("TOURIST_MODE_SWITCH", 10, 10);
        TOURIST_MODE_SWITCH = r12;
        Features$BooleanFeatureKeys r10 = new Features$BooleanFeatureKeys("TOURIST_MODE_EVENT_SWITCH", 11, 11);
        TOURIST_MODE_EVENT_SWITCH = r10;
        Features$BooleanFeatureKeys r8 = new Features$BooleanFeatureKeys("ADJUST_TERMINATE_SWITCH", 12, 12);
        ADJUST_TERMINATE_SWITCH = r8;
        Features$BooleanFeatureKeys r6 = new Features$BooleanFeatureKeys("DISABLE_PERSONALIZATION_SWITCH", 13, 13);
        DISABLE_PERSONALIZATION_SWITCH = r6;
        Features$BooleanFeatureKeys r4 = new Features$BooleanFeatureKeys("CHILD_MODE_BEFORE_INIT_SWITCH", 14, 14);
        CHILD_MODE_BEFORE_INIT_SWITCH = r4;
        Features$BooleanFeatureKeys r2 = new Features$BooleanFeatureKeys("CHILD_MODE_SWITCH", 15, 15);
        CHILD_MODE_SWITCH = r2;
        Features$BooleanFeatureKeys r16 = new Features$BooleanFeatureKeys("DEVTOOLS_SWITCH", 16, 16);
        DEVTOOLS_SWITCH = r16;
        Features$BooleanFeatureKeys r17 = new Features$BooleanFeatureKeys("DEBUG_LOG_SWITCH", 17, 17);
        DEBUG_LOG_SWITCH = r17;
        Features$BooleanFeatureKeys r18 = new Features$BooleanFeatureKeys("BG_SESSION_SWITCH", 18, 18);
        BG_SESSION_SWITCH = r18;
        Features$BooleanFeatureKeys r19 = new Features$BooleanFeatureKeys("CONTROL_EVENT_PARAM_SWITCH", 19, 21);
        CONTROL_EVENT_PARAM_SWITCH = r19;
        Features$BooleanFeatureKeys r20 = new Features$BooleanFeatureKeys("CONTROL_CUSTOM_HEADER_SWITCH", 20, 22);
        CONTROL_CUSTOM_HEADER_SWITCH = r20;
        a = new Features$BooleanFeatureKeys[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r16, r17, r18, r19, r20};
    }

    public static Features$BooleanFeatureKeys[] values() {
        return (Features$BooleanFeatureKeys[]) a.clone();
    }

    public static Features$BooleanFeatureKeys valueOf(String r1) {
        return (Features$BooleanFeatureKeys) a.a(Features$BooleanFeatureKeys.class, r1);
    }

    public int toBits(int r3, boolean r4) {
        int r0 = 1 << this.position;
        if (r4 == false) goto L7;
        return r3 | r0;
    L7:
        return r3 & (~r0);
    }

    public Features$BooleanFeatureKeys(String r1, int r2, int r3) {
        super(r1, r2);
        this.position = r3;
    }
}
