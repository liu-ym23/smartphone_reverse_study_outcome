package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/relax/relaxframework/AnimationFillModeType;", "", "", "value", "I", "getValue", "()I", "None", "Forwards", "Backwards", "Both", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum AnimationFillModeType extends Enum<AnimationFillModeType> {
    public static final AnimationFillModeType Backwards = null;
    public static final AnimationFillModeType Both = null;
    public static final AnimationFillModeType Forwards = null;
    public static final AnimationFillModeType None = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AnimationFillModeType[] f404667a = null;
    private final int value;

    public static AnimationFillModeType valueOf(String r100) {
        return (AnimationFillModeType) r27.a.a(AnimationFillModeType.class, r100);
    }

    public static AnimationFillModeType[] values() {
        return (AnimationFillModeType[]) f404667a.clone();
    }

    static {
        AnimationFillModeType r100 = new AnimationFillModeType("None", 0, 0);
        None = r100;
        AnimationFillModeType r101 = new AnimationFillModeType("Forwards", 1, 1);
        Forwards = r101;
        AnimationFillModeType r102 = new AnimationFillModeType("Backwards", 2, 2);
        Backwards = r102;
        AnimationFillModeType r103 = new AnimationFillModeType("Both", 3, 3);
        Both = r103;
        f404667a = new AnimationFillModeType[]{r100, r101, r102, r103};
    }

    public final int getValue() {
        return this.value;
    }

    public AnimationFillModeType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
