package com.larus.network;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/network/NetworkQualityType;", "", "<init>", "(Ljava/lang/String;I)V", "NO_NET", "WEAK_NETWORK", "NORMAL_NETWORK", "network_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum NetworkQualityType extends Enum<NetworkQualityType> {
    public static final NetworkQualityType NORMAL_NETWORK = null;
    public static final NetworkQualityType NO_NET = null;
    public static final NetworkQualityType WEAK_NETWORK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NetworkQualityType[] f360097a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f360098b = null;

    public static EnumEntries<NetworkQualityType> getEntries() {
        return f360098b;
    }

    static {
        NetworkQualityType r100 = new NetworkQualityType("NO_NET", 0);
        NO_NET = r100;
        NetworkQualityType r101 = new NetworkQualityType("WEAK_NETWORK", 1);
        WEAK_NETWORK = r101;
        NetworkQualityType r102 = new NetworkQualityType("NORMAL_NETWORK", 2);
        NORMAL_NETWORK = r102;
        NetworkQualityType[] r103 = {r100, r101, r102};
        f360097a = r103;
        f360098b = EnumEntriesKt.enumEntries(r103);
    }

    public static NetworkQualityType[] values() {
        return (NetworkQualityType[]) f360097a.clone();
    }

    public static NetworkQualityType valueOf(String r100) {
        return (NetworkQualityType) r27.a.a(NetworkQualityType.class, r100);
    }

    public NetworkQualityType(String r100, int r101) {
        super(r100, r101);
    }
}
