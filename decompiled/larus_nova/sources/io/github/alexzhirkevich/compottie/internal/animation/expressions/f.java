package io.github.alexzhirkevich.compottie.internal.animation.expressions;

import com.facebook.keyframes.model.KFAnimation;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.github.alexzhirkevich.compottie.internal.animation.k2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public interface f {

    public static final class a implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f490821a = null;

        static {
            f490821a = new a();
        }

        public a() {
        }

        @Override // io.github.alexzhirkevich.compottie.internal.animation.expressions.f
        public final Object a(k2 r100, e r101, prc.f r102) {
            Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r102, "state");
            return y.f491000a;
        }
    }

    Object a(k2<? extends Object> r100, e r101, prc.f r102);
}
