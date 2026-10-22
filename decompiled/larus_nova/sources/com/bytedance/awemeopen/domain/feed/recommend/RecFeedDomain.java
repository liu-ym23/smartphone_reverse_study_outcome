package com.bytedance.awemeopen.domain.feed.recommend;

import android.content.Context;
import com.bytedance.awemeopen.infra.base.task.AoPool;
import com.bytedance.awemeopen.infra.support.AoCodeResult;
import com.bytedance.awemeopen.infra.util.NetworkUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import r14.v;

/* JADX INFO: loaded from: classes44.dex */
public final class RecFeedDomain {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f198356a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f198357b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashSet<Function1<String, Unit>> f198358c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashSet<Function1<String, Unit>> f198359d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final HashSet<Function0<Unit>> f198360e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final HashSet<Function0<Unit>> f198361f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final HashSet<Function0<Unit>> f198362g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final HashSet<Function2<String, Map<String, String>, Unit>> f198363h;

    public final void a() {
        AoPool.e(new RecFeedDomain$closeSideProfile$1(this), 1);
    }

    public final void e() {
        AoPool.e(new RecFeedDomain$hostDislike$1(this), 1);
    }

    public final void g() {
        AoPool.e(new RecFeedDomain$openSideProfile$1(this), 1);
    }

    public RecFeedDomain() {
        this.f198357b = true;
        this.f198358c = new HashSet();
        this.f198359d = new HashSet();
        this.f198360e = new HashSet();
        this.f198361f = new HashSet();
        this.f198362g = new HashSet();
        this.f198363h = new HashSet();
    }

    public final void insert(final String r100) {
        Intrinsics.checkNotNullParameter(r100, "hostRawData");
        AoPool.e(new AnonymousClass1(this, r100), 1);
    }

    public final void j(final String r100) {
        Intrinsics.checkNotNullParameter(r100, "hostRawData");
        AoPool.e(new RecFeedDomain$updateCurrentHostVideoData$1(this, r100), 1);
    }

    public static void b(final String r100, final Function1 r101) {
        Intrinsics.checkNotNullParameter(r100, "tagsInString");
        Intrinsics.checkNotNullParameter(r101, "callback");
        if (NetworkUtils.b(y54.a.a()) == true) goto L6;
        int r102 = AoCodeResult.f198929d;
        r101.invoke(AoCodeResult.a.a(1));
        return;
    L6:
        AoPool.a(new RecFeedDomain$getMaaSToken$1(r100, r101));
    }

    public static void i(final int r100, final int r101, final int r102, final Function1 r103) {
        Intrinsics.checkNotNullParameter(r103, "callback");
        if (NetworkUtils.b(y54.a.a()) == true) goto L6;
        int r104 = AoCodeResult.f198929d;
        r103.invoke(AoCodeResult.a.a(1));
        return;
    L6:
        AoPool.a(new RecFeedDomain$reportCpmForFeed$1(r100, r101, r102, r103));
    }

    public final void c(final Context r100, final b r101, final Function1<? super List<r14.c>, ? extends List<r14.c>> r110, final Function3<? super List<r14.c>, ? super v, ? super Exception, Unit> r111) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r110, "filter");
        Intrinsics.checkNotNullParameter(r111, "callback");
        AoPool.a(new RecFeedDomain$getRecExternalCard$1(this, r101, r100, r110, r111));
    }

    public final void d(final Context r100, final b r101, final Function1<? super List<r14.c>, ? extends List<r14.c>> r110, final Function3<? super List<r14.c>, ? super v, ? super Exception, Unit> r111) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r110, "filter");
        Intrinsics.checkNotNullParameter(r111, "callback");
        AoPool.a(new RecFeedDomain$getSpecified$1(r100, r101, this, r110, r111));
    }

    public final void f(final Context r100, final b r101, final Function1<? super List<r14.c>, ? extends List<r14.c>> r110, final Function3<? super List<r14.c>, ? super v, ? super Exception, Unit> r111) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r110, "filter");
        Intrinsics.checkNotNullParameter(r111, "callback");
        AoPool.a(new RecFeedDomain$loadMoreFeed$1(r100, r101, this, r110, r111));
    }

    public final void h(final Context r100, final b r101, final Function1<? super List<r14.c>, ? extends List<r14.c>> r110, final Function3<? super List<r14.c>, ? super v, ? super Exception, Unit> r111) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r110, "filter");
        Intrinsics.checkNotNullParameter(r111, "callback");
        AoPool.a(new RecFeedDomain$refreshFeed$1(r100, r101, this, r110, r111));
    }
}
