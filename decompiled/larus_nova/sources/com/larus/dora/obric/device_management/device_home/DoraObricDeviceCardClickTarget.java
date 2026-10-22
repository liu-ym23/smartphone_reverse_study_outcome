package com.larus.dora.obric.device_management.device_home;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/dora/obric/device_management/device_home/DoraObricDeviceCardClickTarget;", "", "<init>", "(Ljava/lang/String;I)V", "CARD", "MODE_ENTRY", "SETTINGS", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraObricDeviceCardClickTarget extends Enum<DoraObricDeviceCardClickTarget> {
    public static final DoraObricDeviceCardClickTarget CARD = null;
    public static final DoraObricDeviceCardClickTarget MODE_ENTRY = null;
    public static final DoraObricDeviceCardClickTarget SETTINGS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DoraObricDeviceCardClickTarget[] f339027a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f339028b = null;

    public static EnumEntries<DoraObricDeviceCardClickTarget> getEntries() {
        return f339028b;
    }

    static {
        DoraObricDeviceCardClickTarget r100 = new DoraObricDeviceCardClickTarget("CARD", 0);
        CARD = r100;
        DoraObricDeviceCardClickTarget r101 = new DoraObricDeviceCardClickTarget("MODE_ENTRY", 1);
        MODE_ENTRY = r101;
        DoraObricDeviceCardClickTarget r102 = new DoraObricDeviceCardClickTarget("SETTINGS", 2);
        SETTINGS = r102;
        DoraObricDeviceCardClickTarget[] r103 = {r100, r101, r102};
        f339027a = r103;
        f339028b = EnumEntriesKt.enumEntries(r103);
    }

    public static DoraObricDeviceCardClickTarget[] values() {
        return (DoraObricDeviceCardClickTarget[]) f339027a.clone();
    }

    public static DoraObricDeviceCardClickTarget valueOf(String r100) {
        return (DoraObricDeviceCardClickTarget) r27.a.a(DoraObricDeviceCardClickTarget.class, r100);
    }

    public DoraObricDeviceCardClickTarget(String r100, int r101) {
        super(r100, r101);
    }
}
