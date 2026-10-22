package com.bytedance.common.jato.view.dump;

import r27.a;

/* JADX INFO: loaded from: classes15.dex */
public final enum RenderLifeType extends Enum<RenderLifeType> {
    private static final /* synthetic */ RenderLifeType[] $VALUES = null;
    public static final RenderLifeType TraversalEnd = null;
    public static final RenderLifeType TraversalStart = null;
    public static final RenderLifeType attachedToWindow = null;
    public static final RenderLifeType createEnd = null;
    public static final RenderLifeType createStart = null;
    public static final RenderLifeType createView = null;
    public static final RenderLifeType destroyView = null;
    public static final RenderLifeType detachedFromWindow = null;
    public static final RenderLifeType drawEnd = null;
    public static final RenderLifeType drawStart = null;
    public static final RenderLifeType layoutEnd = null;
    public static final RenderLifeType layoutStart = null;
    public static final RenderLifeType measureEnd = null;
    public static final RenderLifeType measureStart = null;
    public static final RenderLifeType unknown = null;

    static {
        RenderLifeType r100 = new RenderLifeType("unknown", 0);
        unknown = r100;
        RenderLifeType r101 = new RenderLifeType("createStart", 1);
        createStart = r101;
        RenderLifeType r102 = new RenderLifeType("createEnd", 2);
        createEnd = r102;
        RenderLifeType r103 = new RenderLifeType("createView", 3);
        createView = r103;
        RenderLifeType r104 = new RenderLifeType("destroyView", 4);
        destroyView = r104;
        RenderLifeType r105 = new RenderLifeType("measureStart", 5);
        measureStart = r105;
        RenderLifeType r110 = new RenderLifeType("measureEnd", 6);
        measureEnd = r110;
        RenderLifeType r111 = new RenderLifeType("layoutStart", 7);
        layoutStart = r111;
        RenderLifeType r112 = new RenderLifeType("layoutEnd", 8);
        layoutEnd = r112;
        RenderLifeType r113 = new RenderLifeType("attachedToWindow", 9);
        attachedToWindow = r113;
        RenderLifeType r114 = new RenderLifeType("detachedFromWindow", 10);
        detachedFromWindow = r114;
        RenderLifeType r115 = new RenderLifeType("drawStart", 11);
        drawStart = r115;
        RenderLifeType r106 = new RenderLifeType("drawEnd", 12);
        drawEnd = r106;
        RenderLifeType r107 = new RenderLifeType("TraversalStart", 13);
        TraversalStart = r107;
        RenderLifeType r108 = new RenderLifeType("TraversalEnd", 14);
        TraversalEnd = r108;
        $VALUES = new RenderLifeType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108};
    }

    public static RenderLifeType[] values() {
        return (RenderLifeType[]) $VALUES.clone();
    }

    public int index() {
        return ordinal() + 0;
    }

    public static RenderLifeType valueOf(String r100) {
        return (RenderLifeType) a.a(RenderLifeType.class, r100);
    }

    private RenderLifeType(String r100, int r101) {
        super(r100, r101);
    }
}
