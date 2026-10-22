package com.larus.dora.obric.device_management.device_home;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/dora/obric/device_management/device_home/DoraObricEnvironmentMemoryState;", "", "<init>", "(Ljava/lang/String;I)V", "WORKING", "OFF", "UNAVAILABLE", "UNKNOWN", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraObricEnvironmentMemoryState extends Enum<DoraObricEnvironmentMemoryState> {
    public static final DoraObricEnvironmentMemoryState OFF = null;
    public static final DoraObricEnvironmentMemoryState UNAVAILABLE = null;
    public static final DoraObricEnvironmentMemoryState UNKNOWN = null;
    public static final DoraObricEnvironmentMemoryState WORKING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DoraObricEnvironmentMemoryState[] f339145a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f339146b = null;

    public static EnumEntries<DoraObricEnvironmentMemoryState> getEntries() {
        return f339146b;
    }

    static {
        DoraObricEnvironmentMemoryState r100 = new DoraObricEnvironmentMemoryState("WORKING", 0);
        WORKING = r100;
        DoraObricEnvironmentMemoryState r101 = new DoraObricEnvironmentMemoryState("OFF", 1);
        OFF = r101;
        DoraObricEnvironmentMemoryState r102 = new DoraObricEnvironmentMemoryState("UNAVAILABLE", 2);
        UNAVAILABLE = r102;
        DoraObricEnvironmentMemoryState r103 = new DoraObricEnvironmentMemoryState("UNKNOWN", 3);
        UNKNOWN = r103;
        DoraObricEnvironmentMemoryState[] r104 = {r100, r101, r102, r103};
        f339145a = r104;
        f339146b = EnumEntriesKt.enumEntries(r104);
    }

    public static DoraObricEnvironmentMemoryState[] values() {
        return (DoraObricEnvironmentMemoryState[]) f339145a.clone();
    }

    public static DoraObricEnvironmentMemoryState valueOf(String r100) {
        return (DoraObricEnvironmentMemoryState) r27.a.a(DoraObricEnvironmentMemoryState.class, r100);
    }

    public DoraObricEnvironmentMemoryState(String r100, int r101) {
        super(r100, r101);
    }
}
