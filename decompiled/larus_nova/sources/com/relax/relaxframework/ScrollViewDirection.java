package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/relax/relaxframework/ScrollViewDirection;", "", "", "value", "I", "getValue", "()I", "Normal", "Rtl", "Ltr", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum ScrollViewDirection extends Enum<ScrollViewDirection> {
    public static final ScrollViewDirection Ltr = null;
    public static final ScrollViewDirection Normal = null;
    public static final ScrollViewDirection Rtl = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ScrollViewDirection[] f404953a = null;
    private final int value;

    public static ScrollViewDirection valueOf(String r100) {
        return (ScrollViewDirection) r27.a.a(ScrollViewDirection.class, r100);
    }

    public static ScrollViewDirection[] values() {
        return (ScrollViewDirection[]) f404953a.clone();
    }

    static {
        ScrollViewDirection r100 = new ScrollViewDirection("Normal", 0, 0);
        Normal = r100;
        ScrollViewDirection r101 = new ScrollViewDirection("Rtl", 1, 2);
        Rtl = r101;
        ScrollViewDirection r102 = new ScrollViewDirection("Ltr", 2, 3);
        Ltr = r102;
        f404953a = new ScrollViewDirection[]{r100, r101, r102};
    }

    public final int getValue() {
        return this.value;
    }

    public ScrollViewDirection(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
