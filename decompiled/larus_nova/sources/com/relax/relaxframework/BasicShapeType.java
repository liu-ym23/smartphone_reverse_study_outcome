package com.relax.relaxframework;

import com.amap.api.services.poisearch.PoiSearch;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/relax/relaxframework/BasicShapeType;", "", "", "value", "I", "getValue", "()I", "Unknown", "Circle", PoiSearch.SearchBound.ELLIPSE_SHAPE, "Path", "SuperEllipse", "Inset", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum BasicShapeType extends Enum<BasicShapeType> {
    public static final BasicShapeType Circle = null;
    public static final BasicShapeType Ellipse = null;
    public static final BasicShapeType Inset = null;
    public static final BasicShapeType Path = null;
    public static final BasicShapeType SuperEllipse = null;
    public static final BasicShapeType Unknown = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BasicShapeType[] f404686a = null;
    private final int value;

    public static BasicShapeType valueOf(String r100) {
        return (BasicShapeType) r27.a.a(BasicShapeType.class, r100);
    }

    public static BasicShapeType[] values() {
        return (BasicShapeType[]) f404686a.clone();
    }

    static {
        BasicShapeType r100 = new BasicShapeType("Unknown", 0, 0);
        Unknown = r100;
        BasicShapeType r101 = new BasicShapeType("Circle", 1, 1);
        Circle = r101;
        BasicShapeType r102 = new BasicShapeType(PoiSearch.SearchBound.ELLIPSE_SHAPE, 2, 2);
        Ellipse = r102;
        BasicShapeType r103 = new BasicShapeType("Path", 3, 3);
        Path = r103;
        BasicShapeType r104 = new BasicShapeType("SuperEllipse", 4, 4);
        SuperEllipse = r104;
        BasicShapeType r105 = new BasicShapeType("Inset", 5, 5);
        Inset = r105;
        f404686a = new BasicShapeType[]{r100, r101, r102, r103, r104, r105};
    }

    public final int getValue() {
        return this.value;
    }

    public BasicShapeType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
