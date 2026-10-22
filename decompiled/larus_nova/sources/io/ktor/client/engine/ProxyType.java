package io.ktor.client.engine;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lio/ktor/client/engine/ProxyType;", "", "SOCKS", "HTTP", "UNKNOWN", "ktor-client-core"}, k = 1, mv = {1, 8, 0})
public final enum ProxyType extends Enum<ProxyType> {
    public static final ProxyType HTTP = null;
    public static final ProxyType SOCKS = null;
    public static final ProxyType UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ProxyType[] f491642a = null;

    public static ProxyType valueOf(String r100) {
        return (ProxyType) r27.a.a(ProxyType.class, r100);
    }

    public static ProxyType[] values() {
        return (ProxyType[]) f491642a.clone();
    }

    static {
        ProxyType r100 = new ProxyType("SOCKS", 0);
        SOCKS = r100;
        ProxyType r101 = new ProxyType("HTTP", 1);
        HTTP = r101;
        ProxyType r102 = new ProxyType("UNKNOWN", 2);
        UNKNOWN = r102;
        f491642a = new ProxyType[]{r100, r101, r102};
    }

    public ProxyType(String r100, int r101) {
        super(r100, r101);
    }
}
