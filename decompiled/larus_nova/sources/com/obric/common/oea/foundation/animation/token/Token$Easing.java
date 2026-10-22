package com.obric.common.oea.foundation.animation.token;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0014\n\u0002\b\u001d\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001f¨\u0006 "}, d2 = {"com/obric/common/oea/foundation/animation/token/Token$Easing", "", "Lcom/obric/common/oea/foundation/animation/token/Token$Easing;", "", "values", "[F", "getValues", "()[F", "OUI_ANIMATION_EASING_LINEAR", "OUI_ANIMATION_EASING_STANDARD", "OUI_ANIMATION_EASING_EASE", "OUI_ANIMATION_EASING_EASE_IN", "OUI_ANIMATION_EASING_EASE_OUT", "OUI_ANIMATION_EASING_EASE_IN_OUT", "OUI_ANIMATION_EASING_EASE_IN_SINE", "OUI_ANIMATION_EASING_EASE_OUT_SINE", "OUI_ANIMATION_EASING_EASE_IN_OUT_SINE", "OUI_ANIMATION_EASING_EASE_IN_QUAD", "OUI_ANIMATION_EASING_EASE_OUT_QUAD", "OUI_ANIMATION_EASING_EASE_IN_OUT_QUAD", "OUI_ANIMATION_EASING_EASE_IN_CUBIC", "OUI_ANIMATION_EASING_EASE_OUT_CUBIC", "OUI_ANIMATION_EASING_EASE_IN_OUT_CUBIC", "OUI_ANIMATION_EASING_EASE_IN_QUART", "OUI_ANIMATION_EASING_EASE_OUT_QUART", "OUI_ANIMATION_EASING_EASE_IN_OUT_QUART", "OUI_ANIMATION_EASING_EASE_IN_QUINT", "OUI_ANIMATION_EASING_EASE_OUT_QUINT", "OUI_ANIMATION_EASING_EASE_IN_OUT_QUINT", "OUI_ANIMATION_EASING_EASE_IN_EXPO", "OUI_ANIMATION_EASING_EASE_OUT_EXPO", "OUI_ANIMATION_EASING_EASE_IN_OUT_EXPO", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
public final enum Token$Easing extends Enum<Token$Easing> {
    public static final Token$Easing OUI_ANIMATION_EASING_EASE = null;
    public static final Token$Easing OUI_ANIMATION_EASING_EASE_IN = null;
    public static final Token$Easing OUI_ANIMATION_EASING_EASE_IN_CUBIC = null;
    public static final Token$Easing OUI_ANIMATION_EASING_EASE_IN_EXPO = null;
    public static final Token$Easing OUI_ANIMATION_EASING_EASE_IN_OUT = null;
    public static final Token$Easing OUI_ANIMATION_EASING_EASE_IN_OUT_CUBIC = null;
    public static final Token$Easing OUI_ANIMATION_EASING_EASE_IN_OUT_EXPO = null;
    public static final Token$Easing OUI_ANIMATION_EASING_EASE_IN_OUT_QUAD = null;
    public static final Token$Easing OUI_ANIMATION_EASING_EASE_IN_OUT_QUART = null;
    public static final Token$Easing OUI_ANIMATION_EASING_EASE_IN_OUT_QUINT = null;
    public static final Token$Easing OUI_ANIMATION_EASING_EASE_IN_OUT_SINE = null;
    public static final Token$Easing OUI_ANIMATION_EASING_EASE_IN_QUAD = null;
    public static final Token$Easing OUI_ANIMATION_EASING_EASE_IN_QUART = null;
    public static final Token$Easing OUI_ANIMATION_EASING_EASE_IN_QUINT = null;
    public static final Token$Easing OUI_ANIMATION_EASING_EASE_IN_SINE = null;
    public static final Token$Easing OUI_ANIMATION_EASING_EASE_OUT = null;
    public static final Token$Easing OUI_ANIMATION_EASING_EASE_OUT_CUBIC = null;
    public static final Token$Easing OUI_ANIMATION_EASING_EASE_OUT_EXPO = null;
    public static final Token$Easing OUI_ANIMATION_EASING_EASE_OUT_QUAD = null;
    public static final Token$Easing OUI_ANIMATION_EASING_EASE_OUT_QUART = null;
    public static final Token$Easing OUI_ANIMATION_EASING_EASE_OUT_QUINT = null;
    public static final Token$Easing OUI_ANIMATION_EASING_EASE_OUT_SINE = null;
    public static final Token$Easing OUI_ANIMATION_EASING_LINEAR = null;
    public static final Token$Easing OUI_ANIMATION_EASING_STANDARD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Token$Easing[] f396407a = null;
    private final float[] values;

    public static Token$Easing valueOf(String r100) {
        return (Token$Easing) a.a(Token$Easing.class, r100);
    }

    public static Token$Easing[] values() {
        return (Token$Easing[]) f396407a.clone();
    }

    static {
        Token$Easing r100 = new Token$Easing("OUI_ANIMATION_EASING_LINEAR", 0, new float[]{0.0f, 0.0f, 1.0f, 1.0f});
        OUI_ANIMATION_EASING_LINEAR = r100;
        Token$Easing r101 = new Token$Easing("OUI_ANIMATION_EASING_STANDARD", 1, new float[]{0.34f, 0.69f, 0.1f, 1.0f});
        OUI_ANIMATION_EASING_STANDARD = r101;
        Token$Easing r102 = new Token$Easing("OUI_ANIMATION_EASING_EASE", 2, new float[]{0.25f, 0.1f, 0.25f, 1.0f});
        OUI_ANIMATION_EASING_EASE = r102;
        Token$Easing r103 = new Token$Easing("OUI_ANIMATION_EASING_EASE_IN", 3, new float[]{0.42f, 0.0f, 1.0f, 1.0f});
        OUI_ANIMATION_EASING_EASE_IN = r103;
        Token$Easing r104 = new Token$Easing("OUI_ANIMATION_EASING_EASE_OUT", 4, new float[]{0.0f, 0.0f, 0.58f, 1.0f});
        OUI_ANIMATION_EASING_EASE_OUT = r104;
        Token$Easing r105 = new Token$Easing("OUI_ANIMATION_EASING_EASE_IN_OUT", 5, new float[]{0.42f, 0.0f, 0.58f, 1.0f});
        OUI_ANIMATION_EASING_EASE_IN_OUT = r105;
        Token$Easing r106 = new Token$Easing("OUI_ANIMATION_EASING_EASE_IN_SINE", 6, new float[]{0.47f, 0.0f, 0.745f, 0.715f});
        OUI_ANIMATION_EASING_EASE_IN_SINE = r106;
        Token$Easing r107 = new Token$Easing("OUI_ANIMATION_EASING_EASE_OUT_SINE", 7, new float[]{0.39f, 0.575f, 0.565f, 1.0f});
        OUI_ANIMATION_EASING_EASE_OUT_SINE = r107;
        Token$Easing r108 = new Token$Easing("OUI_ANIMATION_EASING_EASE_IN_OUT_SINE", 8, new float[]{0.445f, 0.05f, 0.55f, 0.95f});
        OUI_ANIMATION_EASING_EASE_IN_OUT_SINE = r108;
        Token$Easing r109 = new Token$Easing("OUI_ANIMATION_EASING_EASE_IN_QUAD", 9, new float[]{0.26f, 0.0f, 0.6f, 0.2f});
        OUI_ANIMATION_EASING_EASE_IN_QUAD = r109;
        Token$Easing r110 = new Token$Easing("OUI_ANIMATION_EASING_EASE_OUT_QUAD", 10, new float[]{0.4f, 0.8f, 0.74f, 1.0f});
        OUI_ANIMATION_EASING_EASE_OUT_QUAD = r110;
        Token$Easing r111 = new Token$Easing("OUI_ANIMATION_EASING_EASE_IN_OUT_QUAD", 11, new float[]{0.48f, 0.04f, 0.52f, 0.96f});
        OUI_ANIMATION_EASING_EASE_IN_OUT_QUAD = r111;
        Token$Easing r112 = new Token$Easing("OUI_ANIMATION_EASING_EASE_IN_CUBIC", 12, new float[]{0.4f, 0.0f, 0.68f, 0.06f});
        OUI_ANIMATION_EASING_EASE_IN_CUBIC = r112;
        Token$Easing r113 = new Token$Easing("OUI_ANIMATION_EASING_EASE_OUT_CUBIC", 13, new float[]{0.32f, 0.94f, 0.6f, 1.0f});
        OUI_ANIMATION_EASING_EASE_OUT_CUBIC = r113;
        Token$Easing r114 = new Token$Easing("OUI_ANIMATION_EASING_EASE_IN_OUT_CUBIC", 14, new float[]{0.66f, 0.0f, 0.34f, 1.0f});
        OUI_ANIMATION_EASING_EASE_IN_OUT_CUBIC = r114;
        Token$Easing r115 = new Token$Easing("OUI_ANIMATION_EASING_EASE_IN_QUART", 15, new float[]{0.52f, 0.0f, 0.74f, 0.0f});
        OUI_ANIMATION_EASING_EASE_IN_QUART = r115;
        Token$Easing r116 = new Token$Easing("OUI_ANIMATION_EASING_EASE_OUT_QUART", 16, new float[]{0.26f, 1.0f, 0.48f, 1.0f});
        OUI_ANIMATION_EASING_EASE_OUT_QUART = r116;
        Token$Easing r117 = new Token$Easing("OUI_ANIMATION_EASING_EASE_IN_OUT_QUART", 17, new float[]{0.76f, 0.0f, 0.24f, 1.0f});
        OUI_ANIMATION_EASING_EASE_IN_OUT_QUART = r117;
        Token$Easing r118 = new Token$Easing("OUI_ANIMATION_EASING_EASE_IN_QUINT", 18, new float[]{0.64f, 0.0f, 0.78f, 0.0f});
        OUI_ANIMATION_EASING_EASE_IN_QUINT = r118;
        Token$Easing r119 = new Token$Easing("OUI_ANIMATION_EASING_EASE_OUT_QUINT", 19, new float[]{0.22f, 1.0f, 0.36f, 1.0f});
        OUI_ANIMATION_EASING_EASE_OUT_QUINT = r119;
        Token$Easing r120 = new Token$Easing("OUI_ANIMATION_EASING_EASE_IN_OUT_QUINT", 20, new float[]{0.84f, 0.0f, 0.16f, 1.0f});
        OUI_ANIMATION_EASING_EASE_IN_OUT_QUINT = r120;
        Token$Easing r121 = new Token$Easing("OUI_ANIMATION_EASING_EASE_IN_EXPO", 21, new float[]{0.66f, 0.0f, 0.86f, 0.0f});
        OUI_ANIMATION_EASING_EASE_IN_EXPO = r121;
        Token$Easing r122 = new Token$Easing("OUI_ANIMATION_EASING_EASE_OUT_EXPO", 22, new float[]{0.14f, 1.0f, 0.34f, 1.0f});
        OUI_ANIMATION_EASING_EASE_OUT_EXPO = r122;
        Token$Easing r123 = new Token$Easing("OUI_ANIMATION_EASING_EASE_IN_OUT_EXPO", 23, new float[]{0.9f, 0.0f, 0.1f, 1.0f});
        OUI_ANIMATION_EASING_EASE_IN_OUT_EXPO = r123;
        f396407a = new Token$Easing[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r120, r121, r122, r123};
    }

    public final float[] getValues() {
        return this.values;
    }

    public Token$Easing(String r100, int r101, float... r102) {
        super(r100, r101);
        this.values = r102;
    }
}
