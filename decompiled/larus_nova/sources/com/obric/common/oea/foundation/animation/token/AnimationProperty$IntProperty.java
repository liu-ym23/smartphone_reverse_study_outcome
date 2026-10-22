package com.obric.common.oea.foundation.animation.token;

import com.ss.android.bytedcert.config.ThemeConfig;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0001\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\tR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"com/obric/common/oea/foundation/animation/token/AnimationProperty$IntProperty", "", "Lcom/obric/common/oea/foundation/animation/token/AnimationProperty$IntProperty;", "", "propertyName", "Ljava/lang/String;", "getPropertyName", "()Ljava/lang/String;", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "BACKGROUND_COLOR", ThemeConfig.TEXT_COLOR, "STROKE_COLOR", "FILL_COLOR", "WIDTH", "HEIGHT", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
public final enum AnimationProperty$IntProperty extends Enum<AnimationProperty$IntProperty> {
    public static final AnimationProperty$IntProperty BACKGROUND_COLOR = null;
    public static final a Companion = null;
    public static final AnimationProperty$IntProperty FILL_COLOR = null;
    public static final AnimationProperty$IntProperty HEIGHT = null;
    public static final AnimationProperty$IntProperty STROKE_COLOR = null;
    public static final AnimationProperty$IntProperty TEXT_COLOR = null;
    public static final AnimationProperty$IntProperty WIDTH = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AnimationProperty$IntProperty[] f396403a = null;
    private final String propertyName;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.obric.common.oea.foundation.animation.token.AnimationProperty$IntProperty$a] */
    static {
        AnimationProperty$IntProperty r100 = new AnimationProperty$IntProperty("BACKGROUND_COLOR", 0, "backgroundColor");
        BACKGROUND_COLOR = r100;
        AnimationProperty$IntProperty r101 = new AnimationProperty$IntProperty(ThemeConfig.TEXT_COLOR, 1, "textColor");
        TEXT_COLOR = r101;
        AnimationProperty$IntProperty r102 = new AnimationProperty$IntProperty("STROKE_COLOR", 2, "strokeColor");
        STROKE_COLOR = r102;
        AnimationProperty$IntProperty r103 = new AnimationProperty$IntProperty("FILL_COLOR", 3, "fillColor");
        FILL_COLOR = r103;
        AnimationProperty$IntProperty r104 = new AnimationProperty$IntProperty("WIDTH", 4, "width");
        WIDTH = r104;
        AnimationProperty$IntProperty r105 = new AnimationProperty$IntProperty("HEIGHT", 5, "height");
        HEIGHT = r105;
        f396403a = new AnimationProperty$IntProperty[]{r100, r101, r102, r103, r104, r105};
        Companion = new a();
    }

    public static AnimationProperty$IntProperty valueOf(String r100) {
        return (AnimationProperty$IntProperty) r27.a.a(AnimationProperty$IntProperty.class, r100);
    }

    public static AnimationProperty$IntProperty[] values() {
        return (AnimationProperty$IntProperty[]) f396403a.clone();
    }

    public final String getPropertyName() {
        return this.propertyName;
    }

    public AnimationProperty$IntProperty(String r100, int r101, String r102) {
        super(r100, r101);
        this.propertyName = r102;
    }
}
