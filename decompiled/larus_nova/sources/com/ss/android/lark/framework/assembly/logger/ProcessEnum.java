package com.ss.android.lark.framework.assembly.logger;

import com.bytedance.android.livesdk.diagnose.DiagnoseResult;

/* JADX INFO: loaded from: classes36.dex */
public final enum ProcessEnum extends Enum<ProcessEnum> {
    private static final /* synthetic */ ProcessEnum[] $VALUES = null;
    public static final ProcessEnum Default = null;
    public static final ProcessEnum Mail = null;
    public static final ProcessEnum Main = null;
    public static final ProcessEnum Mini = null;
    public static final ProcessEnum P0 = null;
    public static final ProcessEnum Push = null;
    public static final ProcessEnum PushService = null;
    public static final ProcessEnum Sandbox = null;
    public static final ProcessEnum Wschannel = null;

    static {
        ProcessEnum r100 = new ProcessEnum("Main", 0);
        Main = r100;
        ProcessEnum r101 = new ProcessEnum(DiagnoseResult.DIAGNOSE_LEVEL_P0, 1);
        P0 = r101;
        ProcessEnum r102 = new ProcessEnum("Mini", 2);
        Mini = r102;
        ProcessEnum r103 = new ProcessEnum("Mail", 3);
        Mail = r103;
        ProcessEnum r104 = new ProcessEnum("Sandbox", 4);
        Sandbox = r104;
        ProcessEnum r105 = new ProcessEnum("Wschannel", 5);
        Wschannel = r105;
        ProcessEnum r110 = new ProcessEnum("Push", 6);
        Push = r110;
        ProcessEnum r111 = new ProcessEnum("PushService", 7);
        PushService = r111;
        ProcessEnum r112 = new ProcessEnum("Default", 8);
        Default = r112;
        $VALUES = new ProcessEnum[]{r100, r101, r102, r103, r104, r105, r110, r111, r112};
    }

    public static ProcessEnum[] values() {
        return (ProcessEnum[]) $VALUES.clone();
    }

    public static ProcessEnum valueOf(String r100) {
        return (ProcessEnum) r27.a.a(ProcessEnum.class, r100);
    }

    private ProcessEnum(String r100, int r101) {
        super(r100, r101);
    }
}
