package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/relax/relaxframework/BoxSizingType;", "", "", "value", "I", "getValue", "()I", "BorderBox", "ContentBox", "Auto", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum BoxSizingType extends Enum<BoxSizingType> {
    public static final BoxSizingType Auto = null;
    public static final BoxSizingType BorderBox = null;
    public static final BoxSizingType ContentBox = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BoxSizingType[] f404689a = null;
    private final int value;

    public static BoxSizingType valueOf(String r100) {
        return (BoxSizingType) r27.a.a(BoxSizingType.class, r100);
    }

    public static BoxSizingType[] values() {
        return (BoxSizingType[]) f404689a.clone();
    }

    static {
        BoxSizingType r100 = new BoxSizingType("BorderBox", 0, 0);
        BorderBox = r100;
        BoxSizingType r101 = new BoxSizingType("ContentBox", 1, 1);
        ContentBox = r101;
        BoxSizingType r102 = new BoxSizingType("Auto", 2, 2);
        Auto = r102;
        f404689a = new BoxSizingType[]{r100, r101, r102};
    }

    public final int getValue() {
        return this.value;
    }

    public BoxSizingType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
