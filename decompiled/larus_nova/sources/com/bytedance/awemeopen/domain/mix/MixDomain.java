package com.bytedance.awemeopen.domain.mix;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.awemeopen.infra.base.task.AoPool;
import com.bytedance.awemeopen.infra.support.AoCodeResult;
import com.bytedance.awemeopen.infra.util.NetworkUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class MixDomain {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Boolean> f198417a;

    public MixDomain() {
        this.f198417a = new LinkedHashMap();
    }

    public static void c(Context r100, final String r101, final Function1 r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "mixId");
        Intrinsics.checkNotNullParameter(r102, "callback");
        if (NetworkUtils.b(r100) == true) goto L6;
        int r103 = AoCodeResult.f198929d;
        r102.invoke(AoCodeResult.a.a(1));
        return;
    L6:
        AoPool.a(new MixDomain$mixDetail$1(r101, r102));
    }

    public final void a(FragmentActivity r100, final String r101, final boolean r102, final c r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "mixId");
        Intrinsics.checkNotNullParameter(r103, "config");
        if (NetworkUtils.b(r100) == true) goto L8;
        Function1<? super String, Unit> r104 = r103.f198424c;
        if (r104 == null) goto L14;
        r104.invoke(r100.getString(R.string.network_unavailable));
        return;
    L14:
        return;
    L8:
        Function1<? super Function1<? super String, Unit>, Unit> r105 = r103.f198423b;
        if (r105 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("tokenSource");
        r105 = null;
    L12:
        r105.invoke(new MixDomain$collect$1(r103, this, r101, r102));
    }

    public static void b(Context r100, final String r101, final int r102, final int r103, final Function1 r110, final Function1 r111) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "mixId");
        Intrinsics.checkNotNullParameter(r110, "filter");
        Intrinsics.checkNotNullParameter(r111, "callback");
        if (NetworkUtils.b(r100) == true) goto L6;
        int r104 = AoCodeResult.f198929d;
        r111.invoke(AoCodeResult.a.a(1));
        return;
    L6:
        AoPool.a(new MixDomain$getMixAwemeList$1(r101, r102, r103, r110, r111));
    }
}
