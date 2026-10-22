package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/relax/relaxframework/VisibilityType;", "", "", "value", "I", "getValue", "()I", "Hidden", "Visible", "Gone", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum VisibilityType extends Enum<VisibilityType> {
    public static final VisibilityType Gone = null;
    public static final VisibilityType Hidden = null;
    public static final VisibilityType Visible = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VisibilityType[] f404992a = null;
    private final int value;

    public static VisibilityType valueOf(String r100) {
        return (VisibilityType) r27.a.a(VisibilityType.class, r100);
    }

    public static VisibilityType[] values() {
        return (VisibilityType[]) f404992a.clone();
    }

    static {
        VisibilityType r100 = new VisibilityType("Hidden", 0, 0);
        Hidden = r100;
        VisibilityType r101 = new VisibilityType("Visible", 1, 1);
        Visible = r101;
        VisibilityType r102 = new VisibilityType("Gone", 2, 2);
        Gone = r102;
        f404992a = new VisibilityType[]{r100, r101, r102};
    }

    public final int getValue() {
        return this.value;
    }

    public VisibilityType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
