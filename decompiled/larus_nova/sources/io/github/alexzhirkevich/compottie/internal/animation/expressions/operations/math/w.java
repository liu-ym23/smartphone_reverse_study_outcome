package io.github.alexzhirkevich.compottie.internal.animation.expressions.operations.math;

import com.facebook.keyframes.model.KFAnimation;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.github.alexzhirkevich.compottie.internal.animation.k2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final /* synthetic */ class w implements io.github.alexzhirkevich.compottie.internal.animation.expressions.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ io.github.alexzhirkevich.compottie.internal.animation.expressions.f f490945a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ io.github.alexzhirkevich.compottie.internal.animation.expressions.f f490946b;

    public /* synthetic */ w(io.github.alexzhirkevich.compottie.internal.animation.expressions.f r100, io.github.alexzhirkevich.compottie.internal.animation.expressions.f r101) {
        this.f490945a = r100;
        this.f490946b = r101;
    }

    @Override // io.github.alexzhirkevich.compottie.internal.animation.expressions.f
    public final Object a(k2 r100, io.github.alexzhirkevich.compottie.internal.animation.expressions.e r101, prc.f r102) {
        io.github.alexzhirkevich.compottie.internal.animation.expressions.f r103 = this.f490945a;
        io.github.alexzhirkevich.compottie.internal.animation.expressions.f r104 = this.f490946b;
        Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "state");
        return x.a(r103.a(r100, r101, r102), r104.a(r100, r101, r102));
    }
}
