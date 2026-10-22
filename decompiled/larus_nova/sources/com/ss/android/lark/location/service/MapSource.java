package com.ss.android.lark.location.service;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/location/service/MapSource;", "", "<init>", "(Ljava/lang/String;I)V", "AMAP", "GOOGLE", "BING", "location_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MapSource extends Enum<MapSource> {
    public static final MapSource AMAP = null;
    public static final MapSource BING = null;
    public static final MapSource GOOGLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MapSource[] f431198a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f431199b = null;

    public static EnumEntries<MapSource> getEntries() {
        return f431199b;
    }

    static {
        MapSource r100 = new MapSource("AMAP", 0);
        AMAP = r100;
        MapSource r101 = new MapSource("GOOGLE", 1);
        GOOGLE = r101;
        MapSource r102 = new MapSource("BING", 2);
        BING = r102;
        MapSource[] r103 = {r100, r101, r102};
        f431198a = r103;
        f431199b = EnumEntriesKt.enumEntries(r103);
    }

    public static MapSource[] values() {
        return (MapSource[]) f431198a.clone();
    }

    public static MapSource valueOf(String r100) {
        return (MapSource) r27.a.a(MapSource.class, r100);
    }

    public MapSource(String r100, int r101) {
        super(r100, r101);
    }
}
