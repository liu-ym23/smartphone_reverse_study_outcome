package com.larus.dora.obric.device_management.device_home;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/dora/obric/device_management/device_home/DoraObricEnvironmentMemoryIcon;", "", "<init>", "(Ljava/lang/String;I)V", "RUNNING", "PAUSED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraObricEnvironmentMemoryIcon extends Enum<DoraObricEnvironmentMemoryIcon> {
    public static final DoraObricEnvironmentMemoryIcon PAUSED = null;
    public static final DoraObricEnvironmentMemoryIcon RUNNING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DoraObricEnvironmentMemoryIcon[] f339141a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f339142b = null;

    public static EnumEntries<DoraObricEnvironmentMemoryIcon> getEntries() {
        return f339142b;
    }

    static {
        DoraObricEnvironmentMemoryIcon r100 = new DoraObricEnvironmentMemoryIcon("RUNNING", 0);
        RUNNING = r100;
        DoraObricEnvironmentMemoryIcon r101 = new DoraObricEnvironmentMemoryIcon("PAUSED", 1);
        PAUSED = r101;
        DoraObricEnvironmentMemoryIcon[] r102 = {r100, r101};
        f339141a = r102;
        f339142b = EnumEntriesKt.enumEntries(r102);
    }

    public static DoraObricEnvironmentMemoryIcon[] values() {
        return (DoraObricEnvironmentMemoryIcon[]) f339141a.clone();
    }

    public static DoraObricEnvironmentMemoryIcon valueOf(String r100) {
        return (DoraObricEnvironmentMemoryIcon) r27.a.a(DoraObricEnvironmentMemoryIcon.class, r100);
    }

    public DoraObricEnvironmentMemoryIcon(String r100, int r101) {
        super(r100, r101);
    }
}
