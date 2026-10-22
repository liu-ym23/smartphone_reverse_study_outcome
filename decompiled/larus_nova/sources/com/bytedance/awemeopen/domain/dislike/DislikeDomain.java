package com.bytedance.awemeopen.domain.dislike;

import android.content.Context;
import com.bytedance.awemeopen.infra.util.NetworkUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class DislikeDomain {
    public DislikeDomain() {
    }

    public final void a(final Context r100, final b r101, final a r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "dislikeModelDm");
        Intrinsics.checkNotNullParameter(r102, "config");
        if (NetworkUtils.b(r100) == true) goto L8;
        Function0<Unit> r103 = r102.f198315b;
        if (r103 == null) goto L14;
        r103.invoke();
        return;
    L14:
        return;
    L8:
        Function1<? super Function1<? super String, Unit>, Unit> r104 = r102.f198316c;
        if (r104 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("tokenSource");
        r104 = null;
    L12:
        r104.invoke(new DislikeDomain$dislike$1(r102, this, r100, r101));
    }
}
