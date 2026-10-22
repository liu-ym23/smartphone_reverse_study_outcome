package io.github.alexzhirkevich.compottie.internal.animation.expressions.operations.math;

import com.facebook.keyframes.model.KFAnimation;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.github.alexzhirkevich.compottie.internal.animation.k2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final /* synthetic */ class a0 implements io.github.alexzhirkevich.compottie.internal.animation.expressions.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ io.github.alexzhirkevich.compottie.internal.animation.expressions.f f490911a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ io.github.alexzhirkevich.compottie.internal.animation.expressions.f f490912b;

    public /* synthetic */ a0(io.github.alexzhirkevich.compottie.internal.animation.expressions.f r100, io.github.alexzhirkevich.compottie.internal.animation.expressions.f r101) {
        this.f490911a = r100;
        this.f490912b = r101;
    }

    @Override // io.github.alexzhirkevich.compottie.internal.animation.expressions.f
    public final Object a(k2 r100, io.github.alexzhirkevich.compottie.internal.animation.expressions.e r101, prc.f r102) {
        io.github.alexzhirkevich.compottie.internal.animation.expressions.f r103 = this.f490911a;
        io.github.alexzhirkevich.compottie.internal.animation.expressions.f r104 = this.f490912b;
        Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "state");
        return b0.a(r103.a(r100, r101, r102), r104.a(r100, r101, r102));
    }
}
