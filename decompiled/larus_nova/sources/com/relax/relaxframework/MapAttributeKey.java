package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0012\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/relax/relaxframework/MapAttributeKey;", "", "", "value", "I", "getValue", "()I", "Center", "Zoom", "Bound", "Annotation", "Line", "NeedUserLocationHeading", "UserLocationAnnotation", "EnableZoomGestures", "EnableScrollGestures", "EnableRotateGestures", "EnableTiltGestures", "EnableCollision", "CollisionPercent", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum MapAttributeKey extends Enum<MapAttributeKey> {
    public static final MapAttributeKey Annotation = null;
    public static final MapAttributeKey Bound = null;
    public static final MapAttributeKey Center = null;
    public static final MapAttributeKey CollisionPercent = null;
    public static final MapAttributeKey EnableCollision = null;
    public static final MapAttributeKey EnableRotateGestures = null;
    public static final MapAttributeKey EnableScrollGestures = null;
    public static final MapAttributeKey EnableTiltGestures = null;
    public static final MapAttributeKey EnableZoomGestures = null;
    public static final MapAttributeKey Line = null;
    public static final MapAttributeKey NeedUserLocationHeading = null;
    public static final MapAttributeKey UserLocationAnnotation = null;
    public static final MapAttributeKey Zoom = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MapAttributeKey[] f404782a = null;
    private final int value;

    public static MapAttributeKey valueOf(String r100) {
        return (MapAttributeKey) r27.a.a(MapAttributeKey.class, r100);
    }

    public static MapAttributeKey[] values() {
        return (MapAttributeKey[]) f404782a.clone();
    }

    static {
        MapAttributeKey r100 = new MapAttributeKey("Center", 0, 20229);
        Center = r100;
        MapAttributeKey r101 = new MapAttributeKey("Zoom", 1, 20230);
        Zoom = r101;
        MapAttributeKey r102 = new MapAttributeKey("Bound", 2, 20231);
        Bound = r102;
        MapAttributeKey r103 = new MapAttributeKey("Annotation", 3, 20232);
        Annotation = r103;
        MapAttributeKey r104 = new MapAttributeKey("Line", 4, 20233);
        Line = r104;
        MapAttributeKey r105 = new MapAttributeKey("NeedUserLocationHeading", 5, 20258);
        NeedUserLocationHeading = r105;
        MapAttributeKey r110 = new MapAttributeKey("UserLocationAnnotation", 6, 20259);
        UserLocationAnnotation = r110;
        MapAttributeKey r111 = new MapAttributeKey("EnableZoomGestures", 7, 20260);
        EnableZoomGestures = r111;
        MapAttributeKey r112 = new MapAttributeKey("EnableScrollGestures", 8, 20261);
        EnableScrollGestures = r112;
        MapAttributeKey r113 = new MapAttributeKey("EnableRotateGestures", 9, 20262);
        EnableRotateGestures = r113;
        MapAttributeKey r114 = new MapAttributeKey("EnableTiltGestures", 10, 20263);
        EnableTiltGestures = r114;
        MapAttributeKey r106 = new MapAttributeKey("EnableCollision", 11, 20264);
        EnableCollision = r106;
        MapAttributeKey r107 = new MapAttributeKey("CollisionPercent", 12, 20265);
        CollisionPercent = r107;
        f404782a = new MapAttributeKey[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106, r107};
    }

    public final int getValue() {
        return this.value;
    }

    public MapAttributeKey(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
