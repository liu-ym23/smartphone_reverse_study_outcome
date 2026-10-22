package com.larus.dora.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/dora/api/DoraServerDeviceType;", "", "<init>", "(Ljava/lang/String;I)V", "G1", "G2", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraServerDeviceType extends Enum<DoraServerDeviceType> {
    public static final DoraServerDeviceType G1 = null;
    public static final DoraServerDeviceType G2 = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DoraServerDeviceType[] f331714a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f331715b = null;

    public static EnumEntries<DoraServerDeviceType> getEntries() {
        return f331715b;
    }

    static {
        DoraServerDeviceType r100 = new DoraServerDeviceType("G1", 0);
        G1 = r100;
        DoraServerDeviceType r101 = new DoraServerDeviceType("G2", 1);
        G2 = r101;
        DoraServerDeviceType[] r102 = {r100, r101};
        f331714a = r102;
        f331715b = EnumEntriesKt.enumEntries(r102);
    }

    public static DoraServerDeviceType[] values() {
        return (DoraServerDeviceType[]) f331714a.clone();
    }

    public static DoraServerDeviceType valueOf(String r100) {
        return (DoraServerDeviceType) a.a(DoraServerDeviceType.class, r100);
    }

    public DoraServerDeviceType(String r100, int r101) {
        super(r100, r101);
    }
}
