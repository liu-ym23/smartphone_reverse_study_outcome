package io.github.alexzhirkevich.compottie.internal.animation.expressions.operations.composition;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.facebook.keyframes.model.KFAnimation;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.github.alexzhirkevich.compottie.internal.animation.k2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class m extends OpTransformContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.github.alexzhirkevich.compottie.internal.animation.expressions.f f490853a;

    public m(io.github.alexzhirkevich.compottie.internal.animation.expressions.f r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_LAYER);
        this.f490853a = r100;
    }

    @Override // io.github.alexzhirkevich.compottie.internal.animation.expressions.f
    public final Object a(k2 r100, io.github.alexzhirkevich.compottie.internal.animation.expressions.e r101, prc.f r102) {
        Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "state");
        Object r103 = this.f490853a.a(r100, r101, r102);
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type io.github.alexzhirkevich.compottie.internal.layers.Layer");
        return ((dsc.s) r103).getTransform();
    }
}
