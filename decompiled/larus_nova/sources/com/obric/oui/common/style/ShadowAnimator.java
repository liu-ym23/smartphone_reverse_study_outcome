package com.obric.oui.common.style;

import android.view.View;
import com.obric.common.oea.foundation.animation.token.AnimationProperty$FloatProperty;
import com.obric.common.oea.foundation.animation.token.Token$Bounce;
import com.obric.common.oea.foundation.animation.token.Token$Duration;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class ShadowAnimator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f399501a = 0;

    static {
    }

    @JvmStatic
    public static final fja.d a(final View r100, final float r110, final float r111, final List<q> r112, final List<q> r113) {
        Intrinsics.checkNotNullParameter(r100, "view");
        com.obric.common.oea.foundation.animation.builder.b.a r101 = com.obric.common.oea.foundation.animation.builder.c.a(r100);
        AnimationProperty$FloatProperty r102 = AnimationProperty$FloatProperty.SCALE_X;
        Float r103 = Float.valueOf(r100.getScaleX());
        Token$Bounce r104 = Token$Bounce.OUI_ANIMATION_BOUNCE_SNAPPY_4;
        Token$Duration r105 = Token$Duration.OUI_ANIMATION_DURATION_MEDIUM_3;
        com.obric.common.oea.foundation.animation.spec.spring.b r106 = gja.b.c(r104, r105);
        r106.f396390b = 0.01f;
        Unit r107 = Unit.INSTANCE;
        com.obric.common.oea.foundation.animation.builder.b.a.c(r101, r102, r103, r111, r106);
        AnimationProperty$FloatProperty r108 = AnimationProperty$FloatProperty.SCALE_Y;
        Float r109 = Float.valueOf(r100.getScaleY());
        com.obric.common.oea.foundation.animation.spec.spring.b r114 = gja.b.c(r104, r105);
        r114.f396390b = 0.01f;
        com.obric.common.oea.foundation.animation.builder.b.a.c(r101, r108, r109, r111, r114);
        Function3<String, Object, Object, Unit> r115 = new ShadowAnimator$startWithScaleAnimation$3(r110, r111, r112, r113, r100);
        Intrinsics.checkNotNullParameter(r115, "callback");
        r101.f396371d = r115;
        Function2<Boolean, Throwable, Unit> r116 = new ShadowAnimator$startWithScaleAnimation$4(r100, r113);
        Intrinsics.checkNotNullParameter(r116, "callback");
        r101.f396372e = r116;
        return com.obric.common.oea.foundation.animation.builder.b.a(r101.a());
    }
}
