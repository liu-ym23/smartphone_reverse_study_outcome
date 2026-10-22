package com.larus.dora.obric.device_management.device_home;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/dora/obric/device_management/device_home/DoraObricDeviceModeIndicator;", "", "<init>", "(Ljava/lang/String;I)V", "ASSISTANT_MEMORY_OFF", "ASSISTANT_MEMORY_ON", "HEADPHONE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraObricDeviceModeIndicator extends Enum<DoraObricDeviceModeIndicator> {
    public static final DoraObricDeviceModeIndicator ASSISTANT_MEMORY_OFF = null;
    public static final DoraObricDeviceModeIndicator ASSISTANT_MEMORY_ON = null;
    public static final DoraObricDeviceModeIndicator HEADPHONE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DoraObricDeviceModeIndicator[] f339135a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f339136b = null;

    public static EnumEntries<DoraObricDeviceModeIndicator> getEntries() {
        return f339136b;
    }

    static {
        DoraObricDeviceModeIndicator r100 = new DoraObricDeviceModeIndicator("ASSISTANT_MEMORY_OFF", 0);
        ASSISTANT_MEMORY_OFF = r100;
        DoraObricDeviceModeIndicator r101 = new DoraObricDeviceModeIndicator("ASSISTANT_MEMORY_ON", 1);
        ASSISTANT_MEMORY_ON = r101;
        DoraObricDeviceModeIndicator r102 = new DoraObricDeviceModeIndicator("HEADPHONE", 2);
        HEADPHONE = r102;
        DoraObricDeviceModeIndicator[] r103 = {r100, r101, r102};
        f339135a = r103;
        f339136b = EnumEntriesKt.enumEntries(r103);
    }

    public static DoraObricDeviceModeIndicator[] values() {
        return (DoraObricDeviceModeIndicator[]) f339135a.clone();
    }

    public static DoraObricDeviceModeIndicator valueOf(String r100) {
        return (DoraObricDeviceModeIndicator) r27.a.a(DoraObricDeviceModeIndicator.class, r100);
    }

    public DoraObricDeviceModeIndicator(String r100, int r101) {
        super(r100, r101);
    }
}
