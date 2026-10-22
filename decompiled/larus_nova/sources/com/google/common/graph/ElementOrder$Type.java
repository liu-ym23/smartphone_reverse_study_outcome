package com.google.common.graph;

/* JADX INFO: loaded from: classes23.dex */
public final enum ElementOrder$Type extends Enum<ElementOrder$Type> {
    public static final ElementOrder$Type INSERTION = null;
    public static final ElementOrder$Type SORTED = null;
    public static final ElementOrder$Type STABLE = null;
    public static final ElementOrder$Type UNORDERED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ElementOrder$Type[] f275552a = null;

    static {
        ElementOrder$Type r100 = new ElementOrder$Type("UNORDERED", 0);
        UNORDERED = r100;
        ElementOrder$Type r101 = new ElementOrder$Type("STABLE", 1);
        STABLE = r101;
        ElementOrder$Type r102 = new ElementOrder$Type("INSERTION", 2);
        INSERTION = r102;
        ElementOrder$Type r103 = new ElementOrder$Type("SORTED", 3);
        SORTED = r103;
        f275552a = new ElementOrder$Type[]{r100, r101, r102, r103};
    }

    public static ElementOrder$Type[] values() {
        return (ElementOrder$Type[]) f275552a.clone();
    }

    public static ElementOrder$Type valueOf(String r100) {
        return (ElementOrder$Type) r27.a.a(ElementOrder$Type.class, r100);
    }

    public ElementOrder$Type(String r100, int r101) {
        super(r100, r101);
    }
}
