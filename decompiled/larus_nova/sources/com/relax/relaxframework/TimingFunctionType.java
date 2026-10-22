package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/relax/relaxframework/TimingFunctionType;", "", "", "value", "I", "getValue", "()I", "Linear", "EaseIn", "EaseOut", "EaseInEaseOut", "SquareBezier", "CubicBezier", "Steps", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum TimingFunctionType extends Enum<TimingFunctionType> {
    public static final TimingFunctionType CubicBezier = null;
    public static final TimingFunctionType EaseIn = null;
    public static final TimingFunctionType EaseInEaseOut = null;
    public static final TimingFunctionType EaseOut = null;
    public static final TimingFunctionType Linear = null;
    public static final TimingFunctionType SquareBezier = null;
    public static final TimingFunctionType Steps = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TimingFunctionType[] f404974a = null;
    private final int value;

    public static TimingFunctionType valueOf(String r100) {
        return (TimingFunctionType) r27.a.a(TimingFunctionType.class, r100);
    }

    public static TimingFunctionType[] values() {
        return (TimingFunctionType[]) f404974a.clone();
    }

    static {
        TimingFunctionType r100 = new TimingFunctionType("Linear", 0, 0);
        Linear = r100;
        TimingFunctionType r101 = new TimingFunctionType("EaseIn", 1, 1);
        EaseIn = r101;
        TimingFunctionType r102 = new TimingFunctionType("EaseOut", 2, 2);
        EaseOut = r102;
        TimingFunctionType r103 = new TimingFunctionType("EaseInEaseOut", 3, 3);
        EaseInEaseOut = r103;
        TimingFunctionType r104 = new TimingFunctionType("SquareBezier", 4, 4);
        SquareBezier = r104;
        TimingFunctionType r105 = new TimingFunctionType("CubicBezier", 5, 5);
        CubicBezier = r105;
        TimingFunctionType r110 = new TimingFunctionType("Steps", 6, 6);
        Steps = r110;
        f404974a = new TimingFunctionType[]{r100, r101, r102, r103, r104, r105, r110};
    }

    public final int getValue() {
        return this.value;
    }

    public TimingFunctionType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
