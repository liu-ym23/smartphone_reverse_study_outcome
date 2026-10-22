package com.bytedance.ee.bear.bitable.homepage;

import android.content.Context;
import android.view.View;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class BitableHomeLoadingViewV4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f212152a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f212153b;

    public static final class a {
    }

    static {
    }

    public final void a() {
        View r100 = this.f212152a;
        if (r100 == null) goto L9;
        r100.setVisibility(8);
        if (((CircularProgressDrawable) this.f212153b.getValue()).isRunning() == false) goto L7;
        ((CircularProgressDrawable) this.f212153b.getValue()).stop();
    L7:
        tt5.a.h("BitableHomeLoadingViewV4", "hideLoading");
        return;
    }

    public BitableHomeLoadingViewV4(final Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f212153b = LazyKt.lazy(new BitableHomeLoadingViewV4$loadingDrawable$2(r100));
    }
}
