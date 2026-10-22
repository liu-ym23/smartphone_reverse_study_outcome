package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/relax/relaxframework/ImageRenderingType;", "", "", "value", "I", "getValue", "()I", "Auto", "CrispEdges", "Pixelated", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum ImageRenderingType extends Enum<ImageRenderingType> {
    public static final ImageRenderingType Auto = null;
    public static final ImageRenderingType CrispEdges = null;
    public static final ImageRenderingType Pixelated = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ImageRenderingType[] f404739a = null;
    private final int value;

    public static ImageRenderingType valueOf(String r100) {
        return (ImageRenderingType) r27.a.a(ImageRenderingType.class, r100);
    }

    public static ImageRenderingType[] values() {
        return (ImageRenderingType[]) f404739a.clone();
    }

    static {
        ImageRenderingType r100 = new ImageRenderingType("Auto", 0, 0);
        Auto = r100;
        ImageRenderingType r101 = new ImageRenderingType("CrispEdges", 1, 1);
        CrispEdges = r101;
        ImageRenderingType r102 = new ImageRenderingType("Pixelated", 2, 2);
        Pixelated = r102;
        f404739a = new ImageRenderingType[]{r100, r101, r102};
    }

    public final int getValue() {
        return this.value;
    }

    public ImageRenderingType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
