package gja;

import com.obric.common.oea.foundation.animation.token.Token$Bounce;
import com.obric.common.oea.foundation.animation.token.Token$Delay;
import com.obric.common.oea.foundation.animation.token.Token$Duration;
import com.obric.common.oea.foundation.animation.token.Token$Easing;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class b {
    public static com.obric.common.oea.foundation.animation.spec.spring.b b(float r100, float r101) {
        return new com.obric.common.oea.foundation.animation.spec.spring.b(r100, r101, 0, 8);
    }

    public static com.obric.common.oea.foundation.animation.spec.spring.b c(Token$Bounce r100, Token$Duration r101) {
        Intrinsics.checkNotNullParameter(r100, "bounce");
        Intrinsics.checkNotNullParameter(r101, "duration");
        return new com.obric.common.oea.foundation.animation.spec.spring.b(r100.getDampingRatio(), r101.getStiffness(), 0, 8);
    }

    public static final com.obric.common.oea.foundation.animation.spec.spring.b a(Token$Bounce r100, Token$Duration r101, Token$Delay r102) {
        Intrinsics.checkNotNullParameter(r100, "bounce");
        Intrinsics.checkNotNullParameter(r101, "duration");
        Intrinsics.checkNotNullParameter(r102, "delay");
        return new com.obric.common.oea.foundation.animation.spec.spring.b(r100.getDampingRatio(), r101.getStiffness(), r102.getValue(), 8);
    }

    public static final hja.a d(Token$Duration r100, Token$Delay r101, Token$Easing r102) {
        Intrinsics.checkNotNullParameter(r100, "duration");
        Intrinsics.checkNotNullParameter(r101, "delay");
        Intrinsics.checkNotNullParameter(r102, "easing");
        return new hja.a(r100.getDuration(), r101.getValue(), r102);
    }
}
