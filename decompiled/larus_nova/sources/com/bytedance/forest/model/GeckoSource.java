package com.bytedance.forest.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/forest/model/GeckoSource;", "", "REMOTE_SETTING", "CLIENT_CONFIG", "URL_QUERY", "QUERIED_PREFIX", "INJECTED_PREFIXES", "forest_release"}, k = 1, mv = {1, 4, 0})
public final enum GeckoSource extends Enum<GeckoSource> {
    public static final GeckoSource CLIENT_CONFIG = null;
    public static final GeckoSource INJECTED_PREFIXES = null;
    public static final GeckoSource QUERIED_PREFIX = null;
    public static final GeckoSource REMOTE_SETTING = null;
    public static final GeckoSource URL_QUERY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GeckoSource[] f244248a = null;

    static {
        GeckoSource r100 = new GeckoSource("REMOTE_SETTING", 0);
        REMOTE_SETTING = r100;
        GeckoSource r101 = new GeckoSource("CLIENT_CONFIG", 1);
        CLIENT_CONFIG = r101;
        GeckoSource r102 = new GeckoSource("URL_QUERY", 2);
        URL_QUERY = r102;
        GeckoSource r103 = new GeckoSource("QUERIED_PREFIX", 3);
        QUERIED_PREFIX = r103;
        GeckoSource r104 = new GeckoSource("INJECTED_PREFIXES", 4);
        INJECTED_PREFIXES = r104;
        f244248a = new GeckoSource[]{r100, r101, r102, r103, r104};
    }

    public static GeckoSource valueOf(String r100) {
        return (GeckoSource) r27.a.a(GeckoSource.class, r100);
    }

    public static GeckoSource[] values() {
        return (GeckoSource[]) f244248a.clone();
    }

    public GeckoSource(String r100, int r101) {
        super(r100, r101);
    }
}
