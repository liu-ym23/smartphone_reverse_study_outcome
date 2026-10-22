package com.larus.dora.obric.device_management.device_home;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/dora/obric/device_management/device_home/DoraObricEnvironmentMemoryLabel;", "", "<init>", "(Ljava/lang/String;I)V", "ON", "OFF", "UNAVAILABLE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraObricEnvironmentMemoryLabel extends Enum<DoraObricEnvironmentMemoryLabel> {
    public static final DoraObricEnvironmentMemoryLabel OFF = null;
    public static final DoraObricEnvironmentMemoryLabel ON = null;
    public static final DoraObricEnvironmentMemoryLabel UNAVAILABLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DoraObricEnvironmentMemoryLabel[] f339143a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f339144b = null;

    public static EnumEntries<DoraObricEnvironmentMemoryLabel> getEntries() {
        return f339144b;
    }

    static {
        DoraObricEnvironmentMemoryLabel r100 = new DoraObricEnvironmentMemoryLabel("ON", 0);
        ON = r100;
        DoraObricEnvironmentMemoryLabel r101 = new DoraObricEnvironmentMemoryLabel("OFF", 1);
        OFF = r101;
        DoraObricEnvironmentMemoryLabel r102 = new DoraObricEnvironmentMemoryLabel("UNAVAILABLE", 2);
        UNAVAILABLE = r102;
        DoraObricEnvironmentMemoryLabel[] r103 = {r100, r101, r102};
        f339143a = r103;
        f339144b = EnumEntriesKt.enumEntries(r103);
    }

    public static DoraObricEnvironmentMemoryLabel[] values() {
        return (DoraObricEnvironmentMemoryLabel[]) f339143a.clone();
    }

    public static DoraObricEnvironmentMemoryLabel valueOf(String r100) {
        return (DoraObricEnvironmentMemoryLabel) r27.a.a(DoraObricEnvironmentMemoryLabel.class, r100);
    }

    public DoraObricEnvironmentMemoryLabel(String r100, int r101) {
        super(r100, r101);
    }
}
