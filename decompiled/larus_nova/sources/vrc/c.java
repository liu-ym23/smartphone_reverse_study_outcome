package vrc;

import com.facebook.keyframes.model.KFAnimation;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.github.alexzhirkevich.compottie.internal.animation.k2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;

/* JADX INFO: loaded from: classes41.dex */
public final class c implements io.github.alexzhirkevich.compottie.internal.animation.expressions.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f556947a = null;

    static {
        f556947a = new c();
    }

    public c() {
    }

    @Override // io.github.alexzhirkevich.compottie.internal.animation.expressions.f
    public final Object a(k2<? extends Object> r100, io.github.alexzhirkevich.compottie.internal.animation.expressions.e r101, prc.f r102) {
        Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "state");
        return Float.valueOf(Duration.m10811getInWholeMillisecondsimpl(r102.d()) / 1000.0f);
    }
}
