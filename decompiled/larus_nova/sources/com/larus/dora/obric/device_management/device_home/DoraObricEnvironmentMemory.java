package com.larus.dora.obric.device_management.device_home;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/dora/obric/device_management/device_home/DoraObricEnvironmentMemory;", "", "<init>", "(Ljava/lang/String;I)V", "ENABLED", "DISABLED", "UNKNOWN", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraObricEnvironmentMemory extends Enum<DoraObricEnvironmentMemory> {
    public static final DoraObricEnvironmentMemory DISABLED = null;
    public static final DoraObricEnvironmentMemory ENABLED = null;
    public static final DoraObricEnvironmentMemory UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DoraObricEnvironmentMemory[] f339137a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f339138b = null;

    public static EnumEntries<DoraObricEnvironmentMemory> getEntries() {
        return f339138b;
    }

    static {
        DoraObricEnvironmentMemory r100 = new DoraObricEnvironmentMemory("ENABLED", 0);
        ENABLED = r100;
        DoraObricEnvironmentMemory r101 = new DoraObricEnvironmentMemory("DISABLED", 1);
        DISABLED = r101;
        DoraObricEnvironmentMemory r102 = new DoraObricEnvironmentMemory("UNKNOWN", 2);
        UNKNOWN = r102;
        DoraObricEnvironmentMemory[] r103 = {r100, r101, r102};
        f339137a = r103;
        f339138b = EnumEntriesKt.enumEntries(r103);
    }

    public static DoraObricEnvironmentMemory[] values() {
        return (DoraObricEnvironmentMemory[]) f339137a.clone();
    }

    public static DoraObricEnvironmentMemory valueOf(String r100) {
        return (DoraObricEnvironmentMemory) r27.a.a(DoraObricEnvironmentMemory.class, r100);
    }

    public DoraObricEnvironmentMemory(String r100, int r101) {
        super(r100, r101);
    }
}
