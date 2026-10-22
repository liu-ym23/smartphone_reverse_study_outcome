package com.larus.dora.impl.file;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0087\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/larus/dora/impl/file/DoraTaskTrigger;", "", "<init>", "(Ljava/lang/String;I)V", "COMMAND_ARRIVED", "DEVICE_IDLE", "DEVICE_ATTACH", "MANUAL_RESUME", "RECOVERY", "AUTO_REQUEUE", "UNKNOWN", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraTaskTrigger extends Enum<DoraTaskTrigger> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ DoraTaskTrigger[] $VALUES = null;
    public static final DoraTaskTrigger AUTO_REQUEUE = null;
    public static final DoraTaskTrigger COMMAND_ARRIVED = null;
    public static final a Companion = null;
    public static final DoraTaskTrigger DEVICE_ATTACH = null;
    public static final DoraTaskTrigger DEVICE_IDLE = null;
    public static final DoraTaskTrigger MANUAL_RESUME = null;
    public static final DoraTaskTrigger RECOVERY = null;
    public static final DoraTaskTrigger UNKNOWN = null;

    private static final /* synthetic */ DoraTaskTrigger[] $values() {
        return new DoraTaskTrigger[]{COMMAND_ARRIVED, DEVICE_IDLE, DEVICE_ATTACH, MANUAL_RESUME, RECOVERY, AUTO_REQUEUE, UNKNOWN};
    }

    public static EnumEntries<DoraTaskTrigger> getEntries() {
        return $ENTRIES;
    }

    /* JADX WARN: Type inference failed for: r0v9, types: [com.larus.dora.impl.file.DoraTaskTrigger$a] */
    static {
        COMMAND_ARRIVED = new DoraTaskTrigger("COMMAND_ARRIVED", 0);
        DEVICE_IDLE = new DoraTaskTrigger("DEVICE_IDLE", 1);
        DEVICE_ATTACH = new DoraTaskTrigger("DEVICE_ATTACH", 2);
        MANUAL_RESUME = new DoraTaskTrigger("MANUAL_RESUME", 3);
        RECOVERY = new DoraTaskTrigger("RECOVERY", 4);
        AUTO_REQUEUE = new DoraTaskTrigger("AUTO_REQUEUE", 5);
        UNKNOWN = new DoraTaskTrigger("UNKNOWN", 6);
        DoraTaskTrigger[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
        Companion = new a();
    }

    public static DoraTaskTrigger[] values() {
        return (DoraTaskTrigger[]) $VALUES.clone();
    }

    public static DoraTaskTrigger valueOf(String r100) {
        return (DoraTaskTrigger) r27.a.a(DoraTaskTrigger.class, r100);
    }

    private DoraTaskTrigger(String r100, int r101) {
        super(r100, r101);
    }
}
