package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0012\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/relax/relaxframework/MapEventKey;", "", "", "value", "I", "getValue", "()I", "Viewdraw", "MapLoad", "ZoomChange", "Load", "RegionChange", "MoveByUser", "ZoomByUser", "SelectAnnotation", "DeselectAnnotation", "SingleTapAtMap", "PolygonEditStart", "PolygonEdit", "PolygonEditEnd", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum MapEventKey extends Enum<MapEventKey> {
    public static final MapEventKey DeselectAnnotation = null;
    public static final MapEventKey Load = null;
    public static final MapEventKey MapLoad = null;
    public static final MapEventKey MoveByUser = null;
    public static final MapEventKey PolygonEdit = null;
    public static final MapEventKey PolygonEditEnd = null;
    public static final MapEventKey PolygonEditStart = null;
    public static final MapEventKey RegionChange = null;
    public static final MapEventKey SelectAnnotation = null;
    public static final MapEventKey SingleTapAtMap = null;
    public static final MapEventKey Viewdraw = null;
    public static final MapEventKey ZoomByUser = null;
    public static final MapEventKey ZoomChange = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MapEventKey[] f404783a = null;
    private final int value;

    public static MapEventKey valueOf(String r100) {
        return (MapEventKey) r27.a.a(MapEventKey.class, r100);
    }

    public static MapEventKey[] values() {
        return (MapEventKey[]) f404783a.clone();
    }

    static {
        MapEventKey r100 = new MapEventKey("Viewdraw", 0, 30086);
        Viewdraw = r100;
        MapEventKey r101 = new MapEventKey("MapLoad", 1, 30103);
        MapLoad = r101;
        MapEventKey r102 = new MapEventKey("ZoomChange", 2, 30104);
        ZoomChange = r102;
        MapEventKey r103 = new MapEventKey("Load", 3, 30105);
        Load = r103;
        MapEventKey r104 = new MapEventKey("RegionChange", 4, 30106);
        RegionChange = r104;
        MapEventKey r105 = new MapEventKey("MoveByUser", 5, 30107);
        MoveByUser = r105;
        MapEventKey r110 = new MapEventKey("ZoomByUser", 6, 30108);
        ZoomByUser = r110;
        MapEventKey r111 = new MapEventKey("SelectAnnotation", 7, 30109);
        SelectAnnotation = r111;
        MapEventKey r112 = new MapEventKey("DeselectAnnotation", 8, 30110);
        DeselectAnnotation = r112;
        MapEventKey r113 = new MapEventKey("SingleTapAtMap", 9, 30111);
        SingleTapAtMap = r113;
        MapEventKey r114 = new MapEventKey("PolygonEditStart", 10, 30112);
        PolygonEditStart = r114;
        MapEventKey r106 = new MapEventKey("PolygonEdit", 11, 30113);
        PolygonEdit = r106;
        MapEventKey r107 = new MapEventKey("PolygonEditEnd", 12, 30114);
        PolygonEditEnd = r107;
        f404783a = new MapEventKey[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106, r107};
    }

    public final int getValue() {
        return this.value;
    }

    public MapEventKey(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
