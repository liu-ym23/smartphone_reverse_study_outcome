package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/relax/relaxframework/PositionType;", "", "", "value", "I", "getValue", "()I", "Absolute", "Relative", "Fixed", "Sticky", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum PositionType extends Enum<PositionType> {
    public static final PositionType Absolute = null;
    public static final PositionType Fixed = null;
    public static final PositionType Relative = null;
    public static final PositionType Sticky = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PositionType[] f404848a = null;
    private final int value;

    public static PositionType valueOf(String r100) {
        return (PositionType) r27.a.a(PositionType.class, r100);
    }

    public static PositionType[] values() {
        return (PositionType[]) f404848a.clone();
    }

    static {
        PositionType r100 = new PositionType("Absolute", 0, 0);
        Absolute = r100;
        PositionType r101 = new PositionType("Relative", 1, 1);
        Relative = r101;
        PositionType r102 = new PositionType("Fixed", 2, 2);
        Fixed = r102;
        PositionType r103 = new PositionType("Sticky", 3, 3);
        Sticky = r103;
        f404848a = new PositionType[]{r100, r101, r102, r103};
    }

    public final int getValue() {
        return this.value;
    }

    public PositionType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
