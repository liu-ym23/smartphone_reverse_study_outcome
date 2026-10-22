package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/relax/relaxframework/FlexWrapType;", "", "", "value", "I", "getValue", "()I", "Wrap", "Nowrap", "WrapReverse", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum FlexWrapType extends Enum<FlexWrapType> {
    public static final FlexWrapType Nowrap = null;
    public static final FlexWrapType Wrap = null;
    public static final FlexWrapType WrapReverse = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FlexWrapType[] f404725a = null;
    private final int value;

    public static FlexWrapType valueOf(String r100) {
        return (FlexWrapType) r27.a.a(FlexWrapType.class, r100);
    }

    public static FlexWrapType[] values() {
        return (FlexWrapType[]) f404725a.clone();
    }

    static {
        FlexWrapType r100 = new FlexWrapType("Wrap", 0, 0);
        Wrap = r100;
        FlexWrapType r101 = new FlexWrapType("Nowrap", 1, 1);
        Nowrap = r101;
        FlexWrapType r102 = new FlexWrapType("WrapReverse", 2, 2);
        WrapReverse = r102;
        f404725a = new FlexWrapType[]{r100, r101, r102};
    }

    public final int getValue() {
        return this.value;
    }

    public FlexWrapType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
