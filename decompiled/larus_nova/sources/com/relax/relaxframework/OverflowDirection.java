package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/relax/relaxframework/OverflowDirection;", "", "", "value", "I", "getValue", "()I", "OverflowX", "OverflowY", "Overflow", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum OverflowDirection extends Enum<OverflowDirection> {
    public static final OverflowDirection Overflow = null;
    public static final OverflowDirection OverflowX = null;
    public static final OverflowDirection OverflowY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OverflowDirection[] f404831a = null;
    private final int value;

    public static OverflowDirection valueOf(String r100) {
        return (OverflowDirection) r27.a.a(OverflowDirection.class, r100);
    }

    public static OverflowDirection[] values() {
        return (OverflowDirection[]) f404831a.clone();
    }

    static {
        OverflowDirection r100 = new OverflowDirection("OverflowX", 0, 1);
        OverflowX = r100;
        OverflowDirection r101 = new OverflowDirection("OverflowY", 1, 2);
        OverflowY = r101;
        OverflowDirection r102 = new OverflowDirection("Overflow", 2, 3);
        Overflow = r102;
        f404831a = new OverflowDirection[]{r100, r101, r102};
    }

    public final int getValue() {
        return this.value;
    }

    public OverflowDirection(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
