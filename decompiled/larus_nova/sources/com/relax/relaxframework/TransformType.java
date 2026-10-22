package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0015\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016¨\u0006\u0017"}, d2 = {"Lcom/relax/relaxframework/TransformType;", "", "", "value", "I", "getValue", "()I", "None", "Translate", "TranslateX", "TranslateY", "TranslateZ", "Translate3d", "Rotate", "RotateX", "RotateY", "RotateZ", "Scale", "ScaleX", "ScaleY", "Skew", "SkewX", "SkewY", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum TransformType extends Enum<TransformType> {
    public static final TransformType None = null;
    public static final TransformType Rotate = null;
    public static final TransformType RotateX = null;
    public static final TransformType RotateY = null;
    public static final TransformType RotateZ = null;
    public static final TransformType Scale = null;
    public static final TransformType ScaleX = null;
    public static final TransformType ScaleY = null;
    public static final TransformType Skew = null;
    public static final TransformType SkewX = null;
    public static final TransformType SkewY = null;
    public static final TransformType Translate = null;
    public static final TransformType Translate3d = null;
    public static final TransformType TranslateX = null;
    public static final TransformType TranslateY = null;
    public static final TransformType TranslateZ = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TransformType[] f404981a = null;
    private final int value;

    public static TransformType valueOf(String r100) {
        return (TransformType) r27.a.a(TransformType.class, r100);
    }

    public static TransformType[] values() {
        return (TransformType[]) f404981a.clone();
    }

    static {
        TransformType r100 = new TransformType("None", 0, 0);
        None = r100;
        TransformType r101 = new TransformType("Translate", 1, 1);
        Translate = r101;
        TransformType r102 = new TransformType("TranslateX", 2, 2);
        TranslateX = r102;
        TransformType r103 = new TransformType("TranslateY", 3, 4);
        TranslateY = r103;
        TransformType r104 = new TransformType("TranslateZ", 4, 8);
        TranslateZ = r104;
        TransformType r110 = new TransformType("Translate3d", 5, 16);
        Translate3d = r110;
        TransformType r111 = new TransformType("Rotate", 6, 32);
        Rotate = r111;
        TransformType r112 = new TransformType("RotateX", 7, 64);
        RotateX = r112;
        TransformType r105 = new TransformType("RotateY", 8, 128);
        RotateY = r105;
        TransformType r106 = new TransformType("RotateZ", 9, 256);
        RotateZ = r106;
        TransformType r113 = new TransformType("Scale", 10, 512);
        Scale = r113;
        TransformType r107 = new TransformType("ScaleX", 11, 1024);
        ScaleX = r107;
        TransformType r108 = new TransformType("ScaleY", 12, 2048);
        ScaleY = r108;
        TransformType r109 = new TransformType("Skew", 13, 4096);
        Skew = r109;
        TransformType r114 = new TransformType("SkewX", 14, 8192);
        SkewX = r114;
        TransformType r115 = new TransformType("SkewY", 15, 16384);
        SkewY = r115;
        f404981a = new TransformType[]{r100, r101, r102, r103, r104, r110, r111, r112, r105, r106, r113, r107, r108, r109, r114, r115};
    }

    public final int getValue() {
        return this.value;
    }

    public TransformType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
