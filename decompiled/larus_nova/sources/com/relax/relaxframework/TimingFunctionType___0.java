package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/relax/relaxframework/TimingFunctionType___0;", "", "", "value", "I", "getValue", "()I", "Linear", "EaseIn", "EaseOut", "EaseInEaseOut", "SquareBezier", "CubicBezier", "Steps", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum TimingFunctionType___0 extends Enum<TimingFunctionType___0> {
    public static final TimingFunctionType___0 CubicBezier = null;
    public static final TimingFunctionType___0 EaseIn = null;
    public static final TimingFunctionType___0 EaseInEaseOut = null;
    public static final TimingFunctionType___0 EaseOut = null;
    public static final TimingFunctionType___0 Linear = null;
    public static final TimingFunctionType___0 SquareBezier = null;
    public static final TimingFunctionType___0 Steps = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TimingFunctionType___0[] f404975a = null;
    private final int value;

    public static TimingFunctionType___0 valueOf(String r100) {
        return (TimingFunctionType___0) r27.a.a(TimingFunctionType___0.class, r100);
    }

    public static TimingFunctionType___0[] values() {
        return (TimingFunctionType___0[]) f404975a.clone();
    }

    static {
        TimingFunctionType___0 r100 = new TimingFunctionType___0("Linear", 0, 0);
        Linear = r100;
        TimingFunctionType___0 r101 = new TimingFunctionType___0("EaseIn", 1, 1);
        EaseIn = r101;
        TimingFunctionType___0 r102 = new TimingFunctionType___0("EaseOut", 2, 2);
        EaseOut = r102;
        TimingFunctionType___0 r103 = new TimingFunctionType___0("EaseInEaseOut", 3, 3);
        EaseInEaseOut = r103;
        TimingFunctionType___0 r104 = new TimingFunctionType___0("SquareBezier", 4, 4);
        SquareBezier = r104;
        TimingFunctionType___0 r105 = new TimingFunctionType___0("CubicBezier", 5, 5);
        CubicBezier = r105;
        TimingFunctionType___0 r110 = new TimingFunctionType___0("Steps", 6, 6);
        Steps = r110;
        f404975a = new TimingFunctionType___0[]{r100, r101, r102, r103, r104, r105, r110};
    }

    public final int getValue() {
        return this.value;
    }

    public TimingFunctionType___0(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
