package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/relax/relaxframework/AnimationPlayStateType;", "", "", "value", "I", "getValue", "()I", "Paused", "Running", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum AnimationPlayStateType extends Enum<AnimationPlayStateType> {
    public static final AnimationPlayStateType Paused = null;
    public static final AnimationPlayStateType Running = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AnimationPlayStateType[] f404669a = null;
    private final int value;

    public static AnimationPlayStateType valueOf(String r100) {
        return (AnimationPlayStateType) r27.a.a(AnimationPlayStateType.class, r100);
    }

    public static AnimationPlayStateType[] values() {
        return (AnimationPlayStateType[]) f404669a.clone();
    }

    static {
        AnimationPlayStateType r100 = new AnimationPlayStateType("Paused", 0, 0);
        Paused = r100;
        AnimationPlayStateType r101 = new AnimationPlayStateType("Running", 1, 1);
        Running = r101;
        f404669a = new AnimationPlayStateType[]{r100, r101};
    }

    public final int getValue() {
        return this.value;
    }

    public AnimationPlayStateType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
