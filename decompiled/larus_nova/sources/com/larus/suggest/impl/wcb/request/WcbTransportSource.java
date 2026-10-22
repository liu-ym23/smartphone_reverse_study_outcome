package com.larus.suggest.impl.wcb.request;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/suggest/impl/wcb/request/WcbTransportSource;", "", "<init>", "(Ljava/lang/String;I)V", "CACHE", "NETWORK", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum WcbTransportSource extends Enum<WcbTransportSource> {
    public static final WcbTransportSource CACHE = null;
    public static final WcbTransportSource NETWORK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ WcbTransportSource[] f370085a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f370086b = null;

    public static EnumEntries<WcbTransportSource> getEntries() {
        return f370086b;
    }

    static {
        WcbTransportSource r100 = new WcbTransportSource("CACHE", 0);
        CACHE = r100;
        WcbTransportSource r101 = new WcbTransportSource("NETWORK", 1);
        NETWORK = r101;
        WcbTransportSource[] r102 = {r100, r101};
        f370085a = r102;
        f370086b = EnumEntriesKt.enumEntries(r102);
    }

    public static WcbTransportSource[] values() {
        return (WcbTransportSource[]) f370085a.clone();
    }

    public static WcbTransportSource valueOf(String r100) {
        return (WcbTransportSource) r27.a.a(WcbTransportSource.class, r100);
    }

    public WcbTransportSource(String r100, int r101) {
        super(r100, r101);
    }
}
