package com.larus.dora.obric.device_management.device_home;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/dora/obric/device_management/device_home/DoraObricEnvironmentMemoryTextStyle;", "", "<init>", "(Ljava/lang/String;I)V", "RUNNING", "PAUSED", "HEADPHONE", "DISABLED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraObricEnvironmentMemoryTextStyle extends Enum<DoraObricEnvironmentMemoryTextStyle> {
    public static final DoraObricEnvironmentMemoryTextStyle DISABLED = null;
    public static final DoraObricEnvironmentMemoryTextStyle HEADPHONE = null;
    public static final DoraObricEnvironmentMemoryTextStyle PAUSED = null;
    public static final DoraObricEnvironmentMemoryTextStyle RUNNING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DoraObricEnvironmentMemoryTextStyle[] f339147a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f339148b = null;

    public static EnumEntries<DoraObricEnvironmentMemoryTextStyle> getEntries() {
        return f339148b;
    }

    static {
        DoraObricEnvironmentMemoryTextStyle r100 = new DoraObricEnvironmentMemoryTextStyle("RUNNING", 0);
        RUNNING = r100;
        DoraObricEnvironmentMemoryTextStyle r101 = new DoraObricEnvironmentMemoryTextStyle("PAUSED", 1);
        PAUSED = r101;
        DoraObricEnvironmentMemoryTextStyle r102 = new DoraObricEnvironmentMemoryTextStyle("HEADPHONE", 2);
        HEADPHONE = r102;
        DoraObricEnvironmentMemoryTextStyle r103 = new DoraObricEnvironmentMemoryTextStyle("DISABLED", 3);
        DISABLED = r103;
        DoraObricEnvironmentMemoryTextStyle[] r104 = {r100, r101, r102, r103};
        f339147a = r104;
        f339148b = EnumEntriesKt.enumEntries(r104);
    }

    public static DoraObricEnvironmentMemoryTextStyle[] values() {
        return (DoraObricEnvironmentMemoryTextStyle[]) f339147a.clone();
    }

    public static DoraObricEnvironmentMemoryTextStyle valueOf(String r100) {
        return (DoraObricEnvironmentMemoryTextStyle) r27.a.a(DoraObricEnvironmentMemoryTextStyle.class, r100);
    }

    public DoraObricEnvironmentMemoryTextStyle(String r100, int r101) {
        super(r100, r101);
    }
}
