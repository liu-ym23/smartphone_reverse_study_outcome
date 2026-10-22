package com.larus.dora.obric.device_management.device_home;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/dora/obric/device_management/device_home/DoraObricDeviceModeEntryProduct;", "", "<init>", "(Ljava/lang/String;I)V", "G1", "G2", "G_AIR", "G_PIN", "UNSUPPORTED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraObricDeviceModeEntryProduct extends Enum<DoraObricDeviceModeEntryProduct> {
    public static final DoraObricDeviceModeEntryProduct G1 = null;
    public static final DoraObricDeviceModeEntryProduct G2 = null;
    public static final DoraObricDeviceModeEntryProduct G_AIR = null;
    public static final DoraObricDeviceModeEntryProduct G_PIN = null;
    public static final DoraObricDeviceModeEntryProduct UNSUPPORTED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DoraObricDeviceModeEntryProduct[] f339126a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f339127b = null;

    public static EnumEntries<DoraObricDeviceModeEntryProduct> getEntries() {
        return f339127b;
    }

    static {
        DoraObricDeviceModeEntryProduct r100 = new DoraObricDeviceModeEntryProduct("G1", 0);
        G1 = r100;
        DoraObricDeviceModeEntryProduct r101 = new DoraObricDeviceModeEntryProduct("G2", 1);
        G2 = r101;
        DoraObricDeviceModeEntryProduct r102 = new DoraObricDeviceModeEntryProduct("G_AIR", 2);
        G_AIR = r102;
        DoraObricDeviceModeEntryProduct r103 = new DoraObricDeviceModeEntryProduct("G_PIN", 3);
        G_PIN = r103;
        DoraObricDeviceModeEntryProduct r104 = new DoraObricDeviceModeEntryProduct("UNSUPPORTED", 4);
        UNSUPPORTED = r104;
        DoraObricDeviceModeEntryProduct[] r105 = {r100, r101, r102, r103, r104};
        f339126a = r105;
        f339127b = EnumEntriesKt.enumEntries(r105);
    }

    public static DoraObricDeviceModeEntryProduct[] values() {
        return (DoraObricDeviceModeEntryProduct[]) f339126a.clone();
    }

    public static DoraObricDeviceModeEntryProduct valueOf(String r100) {
        return (DoraObricDeviceModeEntryProduct) r27.a.a(DoraObricDeviceModeEntryProduct.class, r100);
    }

    public DoraObricDeviceModeEntryProduct(String r100, int r101) {
        super(r100, r101);
    }
}
