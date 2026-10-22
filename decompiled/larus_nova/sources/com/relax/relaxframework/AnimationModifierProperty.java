package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0013\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Lcom/relax/relaxframework/AnimationModifierProperty;", "", "", "value", "I", "getValue", "()I", "Animation", "AnimationName", "AnimationDuration", "AnimationTimingFunction", "AnimationDelay", "AnimationIterationCount", "AnimationDirection", "AnimationFillMode", "AnimationPlayState", "Transition", "TransitionProperty", "TransitionDuration", "TransitionDelay", "TransitionTimingFunction", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum AnimationModifierProperty extends Enum<AnimationModifierProperty> {
    public static final AnimationModifierProperty Animation = null;
    public static final AnimationModifierProperty AnimationDelay = null;
    public static final AnimationModifierProperty AnimationDirection = null;
    public static final AnimationModifierProperty AnimationDuration = null;
    public static final AnimationModifierProperty AnimationFillMode = null;
    public static final AnimationModifierProperty AnimationIterationCount = null;
    public static final AnimationModifierProperty AnimationName = null;
    public static final AnimationModifierProperty AnimationPlayState = null;
    public static final AnimationModifierProperty AnimationTimingFunction = null;
    public static final AnimationModifierProperty Transition = null;
    public static final AnimationModifierProperty TransitionDelay = null;
    public static final AnimationModifierProperty TransitionDuration = null;
    public static final AnimationModifierProperty TransitionProperty = null;
    public static final AnimationModifierProperty TransitionTimingFunction = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AnimationModifierProperty[] f404668a = null;
    private final int value;

    public static AnimationModifierProperty valueOf(String r100) {
        return (AnimationModifierProperty) r27.a.a(AnimationModifierProperty.class, r100);
    }

    public static AnimationModifierProperty[] values() {
        return (AnimationModifierProperty[]) f404668a.clone();
    }

    static {
        AnimationModifierProperty r100 = new AnimationModifierProperty("Animation", 0, 56);
        Animation = r100;
        AnimationModifierProperty r101 = new AnimationModifierProperty("AnimationName", 1, 57);
        AnimationName = r101;
        AnimationModifierProperty r102 = new AnimationModifierProperty("AnimationDuration", 2, 58);
        AnimationDuration = r102;
        AnimationModifierProperty r103 = new AnimationModifierProperty("AnimationTimingFunction", 3, 59);
        AnimationTimingFunction = r103;
        AnimationModifierProperty r104 = new AnimationModifierProperty("AnimationDelay", 4, 60);
        AnimationDelay = r104;
        AnimationModifierProperty r105 = new AnimationModifierProperty("AnimationIterationCount", 5, 61);
        AnimationIterationCount = r105;
        AnimationModifierProperty r110 = new AnimationModifierProperty("AnimationDirection", 6, 62);
        AnimationDirection = r110;
        AnimationModifierProperty r111 = new AnimationModifierProperty("AnimationFillMode", 7, 63);
        AnimationFillMode = r111;
        AnimationModifierProperty r112 = new AnimationModifierProperty("AnimationPlayState", 8, 64);
        AnimationPlayState = r112;
        AnimationModifierProperty r113 = new AnimationModifierProperty("Transition", 9, 111);
        Transition = r113;
        AnimationModifierProperty r114 = new AnimationModifierProperty("TransitionProperty", 10, 112);
        TransitionProperty = r114;
        AnimationModifierProperty r106 = new AnimationModifierProperty("TransitionDuration", 11, 113);
        TransitionDuration = r106;
        AnimationModifierProperty r107 = new AnimationModifierProperty("TransitionDelay", 12, 114);
        TransitionDelay = r107;
        AnimationModifierProperty r108 = new AnimationModifierProperty("TransitionTimingFunction", 13, 115);
        TransitionTimingFunction = r108;
        f404668a = new AnimationModifierProperty[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106, r107, r108};
    }

    public final int getValue() {
        return this.value;
    }

    public AnimationModifierProperty(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
