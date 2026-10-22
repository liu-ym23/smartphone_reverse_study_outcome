package com.larus.home.impl.main.side_bar.view.group.render;

import android.view.View;
import com.larus.home.api.feed.FlowFeedActionScene;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class c0 implements eb9.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c0 f345613a = null;

    static {
        f345613a = new c0();
    }

    public c0() {
    }

    @Override // eb9.p
    public final boolean a(eb9.o<?> r100, eb9.u r101) {
        Intrinsics.checkNotNullParameter(r100, BrowserDependency.UrlClickType.CARD);
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        return true;
    }

    @Override // eb9.p
    public final boolean c(eb9.o<?> r100, eb9.u r101) {
        Intrinsics.checkNotNullParameter(r100, BrowserDependency.UrlClickType.CARD);
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        return true;
    }

    @Override // eb9.p
    public final void d(eb9.o<?> r100, int r101, eb9.u r102) {
        Intrinsics.checkNotNullParameter(r100, BrowserDependency.UrlClickType.CARD);
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // eb9.p
    public final List<eb9.d> f(eb9.o<?> r100, FlowFeedActionScene r101, eb9.u r102) {
        return eb9.p.a.a(r100, r101, r102);
    }

    @Override // eb9.p
    public final boolean b(eb9.o<?> r100, View r101, int r102, eb9.u r103) {
        eb9.p.a.c(r100, r101, r103);
        return false;
    }

    @Override // eb9.p
    public final void e(eb9.o<?> r100, eb9.d r101, eb9.c r102, eb9.u r103) {
        eb9.p.a.b(r100, r101, r102, r103);
    }
}
