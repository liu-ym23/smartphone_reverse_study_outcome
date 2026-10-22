package com.ss.android.lark.larkconfig.larksetting.handler.log;

import com.bytedance.android.livesdk.diagnose.DiagnoseResult;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/larkconfig/larksetting/handler/log/ProcessEnum;", "", "<init>", "(Ljava/lang/String;I)V", "Main", DiagnoseResult.DIAGNOSE_LEVEL_P0, "Mini", "Mail", "Sandbox", "Wschannel", "Push", "PushService", "Default", "larksetting_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ProcessEnum extends Enum<ProcessEnum> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
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

    private static final /* synthetic */ ProcessEnum[] $values() {
        return new ProcessEnum[]{Main, P0, Mini, Mail, Sandbox, Wschannel, Push, PushService, Default};
    }

    public static EnumEntries<ProcessEnum> getEntries() {
        return $ENTRIES;
    }

    static {
        Main = new ProcessEnum("Main", 0);
        P0 = new ProcessEnum(DiagnoseResult.DIAGNOSE_LEVEL_P0, 1);
        Mini = new ProcessEnum("Mini", 2);
        Mail = new ProcessEnum("Mail", 3);
        Sandbox = new ProcessEnum("Sandbox", 4);
        Wschannel = new ProcessEnum("Wschannel", 5);
        Push = new ProcessEnum("Push", 6);
        PushService = new ProcessEnum("PushService", 7);
        Default = new ProcessEnum("Default", 8);
        ProcessEnum[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static ProcessEnum[] values() {
        return (ProcessEnum[]) $VALUES.clone();
    }

    public static ProcessEnum valueOf(String r100) {
        return (ProcessEnum) a.a(ProcessEnum.class, r100);
    }

    private ProcessEnum(String r100, int r101) {
        super(r100, r101);
    }
}
