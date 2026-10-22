package com.obric.common.oea.foundation.animation.token;

import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0086\u0001\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\tR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"com/obric/common/oea/foundation/animation/token/AnimationProperty$FloatProperty", "", "Lcom/obric/common/oea/foundation/animation/token/AnimationProperty$FloatProperty;", "", "propertyName", "Ljava/lang/String;", "getPropertyName", "()Ljava/lang/String;", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "X", "Y", "SCALE_X", "SCALE_Y", "ROTATION", "ROTATION_X", "ROTATION_Y", "TRANSLATION_X", "TRANSLATION_Y", "ALPHA", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
public final enum AnimationProperty$FloatProperty extends Enum<AnimationProperty$FloatProperty> {
    public static final AnimationProperty$FloatProperty ALPHA = null;
    public static final a Companion = null;
    public static final AnimationProperty$FloatProperty ROTATION = null;
    public static final AnimationProperty$FloatProperty ROTATION_X = null;
    public static final AnimationProperty$FloatProperty ROTATION_Y = null;
    public static final AnimationProperty$FloatProperty SCALE_X = null;
    public static final AnimationProperty$FloatProperty SCALE_Y = null;
    public static final AnimationProperty$FloatProperty TRANSLATION_X = null;
    public static final AnimationProperty$FloatProperty TRANSLATION_Y = null;
    public static final AnimationProperty$FloatProperty X = null;
    public static final AnimationProperty$FloatProperty Y = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AnimationProperty$FloatProperty[] f396402a = null;
    private final String propertyName;

    public static AnimationProperty$FloatProperty valueOf(String r100) {
        return (AnimationProperty$FloatProperty) r27.a.a(AnimationProperty$FloatProperty.class, r100);
    }

    public static AnimationProperty$FloatProperty[] values() {
        return (AnimationProperty$FloatProperty[]) f396402a.clone();
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.obric.common.oea.foundation.animation.token.AnimationProperty$FloatProperty$a] */
    static {
        AnimationProperty$FloatProperty r100 = new AnimationProperty$FloatProperty("X", 0, "x");
        X = r100;
        AnimationProperty$FloatProperty r101 = new AnimationProperty$FloatProperty("Y", 1, "y");
        Y = r101;
        AnimationProperty$FloatProperty r102 = new AnimationProperty$FloatProperty("SCALE_X", 2, LiveDegradeFpsAnimator.SCALE_X);
        SCALE_X = r102;
        AnimationProperty$FloatProperty r103 = new AnimationProperty$FloatProperty("SCALE_Y", 3, LiveDegradeFpsAnimator.SCALE_Y);
        SCALE_Y = r103;
        AnimationProperty$FloatProperty r104 = new AnimationProperty$FloatProperty("ROTATION", 4, "rotation");
        ROTATION = r104;
        AnimationProperty$FloatProperty r105 = new AnimationProperty$FloatProperty("ROTATION_X", 5, "rotationX");
        ROTATION_X = r105;
        AnimationProperty$FloatProperty r106 = new AnimationProperty$FloatProperty("ROTATION_Y", 6, "rotationY");
        ROTATION_Y = r106;
        AnimationProperty$FloatProperty r107 = new AnimationProperty$FloatProperty("TRANSLATION_X", 7, LiveDegradeFpsAnimator.TRANSLATION_X);
        TRANSLATION_X = r107;
        AnimationProperty$FloatProperty r108 = new AnimationProperty$FloatProperty("TRANSLATION_Y", 8, LiveDegradeFpsAnimator.TRANSLATION_Y);
        TRANSLATION_Y = r108;
        AnimationProperty$FloatProperty r109 = new AnimationProperty$FloatProperty("ALPHA", 9, "alpha");
        ALPHA = r109;
        f396402a = new AnimationProperty$FloatProperty[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109};
        Companion = new a();
    }

    public final String getPropertyName() {
        return this.propertyName;
    }

    public AnimationProperty$FloatProperty(String r100, int r101, String r102) {
        super(r100, r101);
        this.propertyName = r102;
    }
}
