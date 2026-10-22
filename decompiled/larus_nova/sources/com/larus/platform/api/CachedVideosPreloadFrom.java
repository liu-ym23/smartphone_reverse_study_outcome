package com.larus.platform.api;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, d2 = {"Lcom/larus/platform/api/CachedVideosPreloadFrom;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "DEFAULT", "OUTER_FALLBACK", "CMD", "BIND_PULL_API", "REFRESH_VIDEO", "UN_CONSUMED", "UNLIMITED_FLOW", "Companion", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CachedVideosPreloadFrom extends Enum<CachedVideosPreloadFrom> {
    public static final CachedVideosPreloadFrom BIND_PULL_API = null;
    public static final CachedVideosPreloadFrom CMD = null;
    public static final a Companion = null;
    public static final CachedVideosPreloadFrom DEFAULT = null;
    public static final CachedVideosPreloadFrom OUTER_FALLBACK = null;
    public static final CachedVideosPreloadFrom REFRESH_VIDEO = null;
    public static final CachedVideosPreloadFrom UNLIMITED_FLOW = null;
    public static final CachedVideosPreloadFrom UN_CONSUMED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Integer, CachedVideosPreloadFrom> f364760a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ CachedVideosPreloadFrom[] f364761b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f364762c = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<CachedVideosPreloadFrom> getEntries() {
        return f364762c;
    }

    static {
        int r100 = 0;
        CachedVideosPreloadFrom r101 = new CachedVideosPreloadFrom("DEFAULT", 0, 0);
        DEFAULT = r101;
        CachedVideosPreloadFrom r102 = new CachedVideosPreloadFrom("OUTER_FALLBACK", 1, 1);
        OUTER_FALLBACK = r102;
        CachedVideosPreloadFrom r103 = new CachedVideosPreloadFrom("CMD", 2, 2);
        CMD = r103;
        CachedVideosPreloadFrom r104 = new CachedVideosPreloadFrom("BIND_PULL_API", 3, 3);
        BIND_PULL_API = r104;
        CachedVideosPreloadFrom r105 = new CachedVideosPreloadFrom("REFRESH_VIDEO", 4, 4);
        REFRESH_VIDEO = r105;
        CachedVideosPreloadFrom r106 = new CachedVideosPreloadFrom("UN_CONSUMED", 5, 5);
        UN_CONSUMED = r106;
        CachedVideosPreloadFrom r110 = new CachedVideosPreloadFrom("UNLIMITED_FLOW", 6, 6);
        UNLIMITED_FLOW = r110;
        CachedVideosPreloadFrom[] r111 = {r101, r102, r103, r104, r105, r106, r110};
        f364761b = r111;
        f364762c = EnumEntriesKt.enumEntries(r111);
        Companion = new a();
        CachedVideosPreloadFrom[] r107 = values();
        LinkedHashMap r108 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(r107.length), 16));
        int r109 = r107.length;
    L3:
        if (r100 >= r109) goto L5;
        CachedVideosPreloadFrom r112 = r107[r100];
        r108.put(Integer.valueOf(r112.value), r112);
        r100 = r100 + 1;
        goto L3
    L5:
        f364760a = r108;
    }

    public static CachedVideosPreloadFrom[] values() {
        return (CachedVideosPreloadFrom[]) f364761b.clone();
    }

    public static final /* synthetic */ Map access$getMap$cp() {
        return f364760a;
    }

    public final int getValue() {
        return this.value;
    }

    public static CachedVideosPreloadFrom valueOf(String r100) {
        return (CachedVideosPreloadFrom) r27.a.a(CachedVideosPreloadFrom.class, r100);
    }

    public CachedVideosPreloadFrom(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
