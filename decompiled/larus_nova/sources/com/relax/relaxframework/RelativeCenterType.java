package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/relax/relaxframework/RelativeCenterType;", "", "", "value", "I", "getValue", "()I", "None", "Vertical", "Horizontal", "Both", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum RelativeCenterType extends Enum<RelativeCenterType> {
    public static final RelativeCenterType Both = null;
    public static final RelativeCenterType Horizontal = null;
    public static final RelativeCenterType None = null;
    public static final RelativeCenterType Vertical = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RelativeCenterType[] f404869a = null;
    private final int value;

    public static RelativeCenterType valueOf(String r100) {
        return (RelativeCenterType) r27.a.a(RelativeCenterType.class, r100);
    }

    public static RelativeCenterType[] values() {
        return (RelativeCenterType[]) f404869a.clone();
    }

    static {
        RelativeCenterType r100 = new RelativeCenterType("None", 0, 0);
        None = r100;
        RelativeCenterType r101 = new RelativeCenterType("Vertical", 1, 1);
        Vertical = r101;
        RelativeCenterType r102 = new RelativeCenterType("Horizontal", 2, 2);
        Horizontal = r102;
        RelativeCenterType r103 = new RelativeCenterType("Both", 3, 3);
        Both = r103;
        f404869a = new RelativeCenterType[]{r100, r101, r102, r103};
    }

    public final int getValue() {
        return this.value;
    }

    public RelativeCenterType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
