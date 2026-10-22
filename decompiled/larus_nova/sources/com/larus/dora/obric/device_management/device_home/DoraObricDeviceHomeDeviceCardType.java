package com.larus.dora.obric.device_management.device_home;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/dora/obric/device_management/device_home/DoraObricDeviceHomeDeviceCardType;", "", "<init>", "(Ljava/lang/String;I)V", "GLASSES", "EARBUDS", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraObricDeviceHomeDeviceCardType extends Enum<DoraObricDeviceHomeDeviceCardType> {
    public static final DoraObricDeviceHomeDeviceCardType EARBUDS = null;
    public static final DoraObricDeviceHomeDeviceCardType GLASSES = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DoraObricDeviceHomeDeviceCardType[] f339031a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f339032b = null;

    public static EnumEntries<DoraObricDeviceHomeDeviceCardType> getEntries() {
        return f339032b;
    }

    static {
        DoraObricDeviceHomeDeviceCardType r100 = new DoraObricDeviceHomeDeviceCardType("GLASSES", 0);
        GLASSES = r100;
        DoraObricDeviceHomeDeviceCardType r101 = new DoraObricDeviceHomeDeviceCardType("EARBUDS", 1);
        EARBUDS = r101;
        DoraObricDeviceHomeDeviceCardType[] r102 = {r100, r101};
        f339031a = r102;
        f339032b = EnumEntriesKt.enumEntries(r102);
    }

    public static DoraObricDeviceHomeDeviceCardType[] values() {
        return (DoraObricDeviceHomeDeviceCardType[]) f339031a.clone();
    }

    public static DoraObricDeviceHomeDeviceCardType valueOf(String r100) {
        return (DoraObricDeviceHomeDeviceCardType) r27.a.a(DoraObricDeviceHomeDeviceCardType.class, r100);
    }

    public DoraObricDeviceHomeDeviceCardType(String r100, int r101) {
        super(r100, r101);
    }
}
