package com.larus.avlink.aiproactive;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/avlink/aiproactive/EnvObserveStatus;", "", "<init>", "(Ljava/lang/String;I)V", "NOT_OPEN", "PAUSED", "RUNNING", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum EnvObserveStatus extends Enum<EnvObserveStatus> {
    public static final EnvObserveStatus NOT_OPEN = null;
    public static final EnvObserveStatus PAUSED = null;
    public static final EnvObserveStatus RUNNING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EnvObserveStatus[] f291548a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f291549b = null;

    public static EnumEntries<EnvObserveStatus> getEntries() {
        return f291549b;
    }

    static {
        EnvObserveStatus r100 = new EnvObserveStatus("NOT_OPEN", 0);
        NOT_OPEN = r100;
        EnvObserveStatus r101 = new EnvObserveStatus("PAUSED", 1);
        PAUSED = r101;
        EnvObserveStatus r102 = new EnvObserveStatus("RUNNING", 2);
        RUNNING = r102;
        EnvObserveStatus[] r103 = {r100, r101, r102};
        f291548a = r103;
        f291549b = EnumEntriesKt.enumEntries(r103);
    }

    public static EnvObserveStatus[] values() {
        return (EnvObserveStatus[]) f291548a.clone();
    }

    public static EnvObserveStatus valueOf(String r100) {
        return (EnvObserveStatus) r27.a.a(EnvObserveStatus.class, r100);
    }

    public EnvObserveStatus(String r100, int r101) {
        super(r100, r101);
    }
}
