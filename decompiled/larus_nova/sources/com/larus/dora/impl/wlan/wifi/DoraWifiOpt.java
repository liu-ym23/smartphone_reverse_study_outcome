package com.larus.dora.impl.wlan.wifi;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/dora/impl/wlan/wifi/DoraWifiOpt;", "", "<init>", "(Ljava/lang/String;I)V", "ADD", "DELETE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraWifiOpt extends Enum<DoraWifiOpt> {
    public static final DoraWifiOpt ADD = null;
    public static final DoraWifiOpt DELETE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DoraWifiOpt[] f338250a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f338251b = null;

    public static EnumEntries<DoraWifiOpt> getEntries() {
        return f338251b;
    }

    static {
        DoraWifiOpt r100 = new DoraWifiOpt("ADD", 0);
        ADD = r100;
        DoraWifiOpt r101 = new DoraWifiOpt("DELETE", 1);
        DELETE = r101;
        DoraWifiOpt[] r102 = {r100, r101};
        f338250a = r102;
        f338251b = EnumEntriesKt.enumEntries(r102);
    }

    public static DoraWifiOpt[] values() {
        return (DoraWifiOpt[]) f338250a.clone();
    }

    public static DoraWifiOpt valueOf(String r100) {
        return (DoraWifiOpt) r27.a.a(DoraWifiOpt.class, r100);
    }

    public DoraWifiOpt(String r100, int r101) {
        super(r100, r101);
    }
}
