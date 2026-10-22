package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/relax/relaxframework/BorderWidthType;", "", "", "value", "I", "getValue", "()I", "Thin", "Medium", "Thick", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum BorderWidthType extends Enum<BorderWidthType> {
    public static final BorderWidthType Medium = null;
    public static final BorderWidthType Thick = null;
    public static final BorderWidthType Thin = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BorderWidthType[] f404688a = null;
    private final int value;

    public static BorderWidthType valueOf(String r100) {
        return (BorderWidthType) r27.a.a(BorderWidthType.class, r100);
    }

    public static BorderWidthType[] values() {
        return (BorderWidthType[]) f404688a.clone();
    }

    static {
        BorderWidthType r100 = new BorderWidthType("Thin", 0, 1);
        Thin = r100;
        BorderWidthType r101 = new BorderWidthType("Medium", 1, 3);
        Medium = r101;
        BorderWidthType r102 = new BorderWidthType("Thick", 2, 5);
        Thick = r102;
        f404688a = new BorderWidthType[]{r100, r101, r102};
    }

    public final int getValue() {
        return this.value;
    }

    public BorderWidthType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
