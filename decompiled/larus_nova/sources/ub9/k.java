package ub9;

import android.content.Context;
import android.view.View;
import com.larus.ivykit.view.LoadErrorView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class k implements ix7.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LoadErrorView f549408a;

    public k() {
    }

    @Override // ix7.c
    public final View b() {
        return null;
    }

    @Override // ix7.c
    public final void a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f549408a = new LoadErrorView(r100, null, 6, 0);
    }

    @Override // ix7.c
    public final View c(final com.ivy.ivykit.plugin.impl.render.e r100) {
        Intrinsics.checkNotNullParameter(r100, "refresher");
        LoadErrorView r101 = this.f549408a;
        if (r101 == null) goto L5;
        r101.setOnRetryListener(new j(r100));
        return r101;
    L5:
        return null;
    }
}
