package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/relax/relaxframework/FlexWrap;", "", "", "value", "I", "getValue", "()I", "Wrap", "NoWrap", "WrapReverse", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum FlexWrap extends Enum<FlexWrap> {
    public static final FlexWrap NoWrap = null;
    public static final FlexWrap Wrap = null;
    public static final FlexWrap WrapReverse = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FlexWrap[] f404724a = null;
    private final int value;

    public static FlexWrap valueOf(String r100) {
        return (FlexWrap) r27.a.a(FlexWrap.class, r100);
    }

    public static FlexWrap[] values() {
        return (FlexWrap[]) f404724a.clone();
    }

    static {
        FlexWrap r100 = new FlexWrap("Wrap", 0, 0);
        Wrap = r100;
        FlexWrap r101 = new FlexWrap("NoWrap", 1, 1);
        NoWrap = r101;
        FlexWrap r102 = new FlexWrap("WrapReverse", 2, 2);
        WrapReverse = r102;
        f404724a = new FlexWrap[]{r100, r101, r102};
    }

    public final int getValue() {
        return this.value;
    }

    public FlexWrap(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
