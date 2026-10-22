package com.relax.relaxframework;

import com.amap.api.services.poisearch.PoiSearch;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/relax/relaxframework/RadialGradientShape;", "", "", "value", "J", "getValue", "()J", PoiSearch.SearchBound.ELLIPSE_SHAPE, "Circle", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum RadialGradientShape extends Enum<RadialGradientShape> {
    public static final RadialGradientShape Circle = null;
    public static final RadialGradientShape Ellipse = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RadialGradientShape[] f404850a = null;
    private final long value;

    public static RadialGradientShape valueOf(String r100) {
        return (RadialGradientShape) r27.a.a(RadialGradientShape.class, r100);
    }

    public static RadialGradientShape[] values() {
        return (RadialGradientShape[]) f404850a.clone();
    }

    static {
        RadialGradientShape r100 = new RadialGradientShape(PoiSearch.SearchBound.ELLIPSE_SHAPE, 0, 0);
        Ellipse = r100;
        RadialGradientShape r101 = new RadialGradientShape("Circle", 1, 1);
        Circle = r101;
        f404850a = new RadialGradientShape[]{r100, r101};
    }

    public final long getValue() {
        return this.value;
    }

    public RadialGradientShape(String r100, int r101, long r102) {
        super(r100, r101);
        this.value = r102;
    }
}
