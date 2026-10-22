package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/relax/relaxframework/AnimationDirectionType;", "", "", "value", "I", "getValue", "()I", "Normal", "Reverse", "Alternate", "AlternateReverse", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum AnimationDirectionType extends Enum<AnimationDirectionType> {
    public static final AnimationDirectionType Alternate = null;
    public static final AnimationDirectionType AlternateReverse = null;
    public static final AnimationDirectionType Normal = null;
    public static final AnimationDirectionType Reverse = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AnimationDirectionType[] f404666a = null;
    private final int value;

    public static AnimationDirectionType valueOf(String r100) {
        return (AnimationDirectionType) r27.a.a(AnimationDirectionType.class, r100);
    }

    public static AnimationDirectionType[] values() {
        return (AnimationDirectionType[]) f404666a.clone();
    }

    static {
        AnimationDirectionType r100 = new AnimationDirectionType("Normal", 0, 0);
        Normal = r100;
        AnimationDirectionType r101 = new AnimationDirectionType("Reverse", 1, 1);
        Reverse = r101;
        AnimationDirectionType r102 = new AnimationDirectionType("Alternate", 2, 2);
        Alternate = r102;
        AnimationDirectionType r103 = new AnimationDirectionType("AlternateReverse", 3, 3);
        AlternateReverse = r103;
        f404666a = new AnimationDirectionType[]{r100, r101, r102, r103};
    }

    public final int getValue() {
        return this.value;
    }

    public AnimationDirectionType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
