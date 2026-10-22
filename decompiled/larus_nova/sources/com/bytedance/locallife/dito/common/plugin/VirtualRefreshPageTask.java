package com.bytedance.locallife.dito.common.plugin;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ies.dmt.ui.widget.DmtLoadingLayout;
import com.bytedance.locallife.dito.core.DitoFragment;
import com.bytedance.locallife.dito.core.viewmodel.DitoDataCenter;
import com.bytedance.locallife.dito.event.ThreadLiveData;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.Timer;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.concurrent.TimersKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002¨\u0006\u0004"}, d2 = {"Lcom/bytedance/locallife/dito/common/plugin/VirtualRefreshPageTask;", "Ljava/lang/Runnable;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/locallife/dito/data/l;", "dito-common-saas_release"}, k = 1, mv = {1, 4, 3})
public final class VirtualRefreshPageTask implements Runnable, Observer<com.bytedance.locallife.dito.data.l> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DitoFragment f257523a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e0 f257524b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final s f257525c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final t f257526d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final x f257527e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f257528f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f257529g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile AtomicBoolean f257530h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f257531i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public DitoFragment f257532j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f257533k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f257534l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Timer f257535m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f257536n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Handler f257537o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f257538p;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f257539a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ VirtualRefreshPageTask f257540b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f257541c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f257542d;

        public a(int r100, VirtualRefreshPageTask r101, boolean r102, String r103) {
            this.f257539a = r100;
            this.f257540b = r101;
            this.f257541c = r102;
            this.f257542d = r103;
        }

        public final void a() {
            if (this.f257539a == 1) goto L7;
            Timer r100 = this.f257540b.f257535m;
            if (r100 == null) goto L7;
            r100.cancel();
        L7:
            DitoFragment r101 = this.f257540b.f257532j;
            if (r101 == null) goto L14;
            DitoDataCenter r102 = r101.pa0();
            if (r102 == null) goto L14;
            ThreadLiveData<com.bytedance.locallife.dito.data.l> r103 = r102.H();
            if (r103 == null) goto L14;
            r103.removeObserver(this.f257540b);
        L14:
            VirtualRefreshPageTask r104 = this.f257540b;
            if (r104.f257524b.f257569b == false) goto L24;
            View r105 = r104.f257523a.getView();
            if (r105 == null) goto L20;
            DmtLoadingLayout r106 = (DmtLoadingLayout) r105.findViewById(R.id.poi_dynamic_id_virtual_refresh_loading_view);
        L21:
            if (r106 == null) goto L24;
            r106.setVisibility(8);
            goto L24
        L20:
            r106 = null;
        L24:
            this.f257540b.f257527e.c();
            t r107 = this.f257540b.f257526d;
            if (r107 == null) goto L28;
            boolean r108 = this.f257541c;
            String r109 = this.f257542d;
            y r110 = new y(r108 ? 1 : 0, r109);
            int r111 = this.f257539a;
            VirtualRefreshPageTask r112 = this.f257540b;
            r110.j(r111);
            r110.i(r112.f257533k);
            r110.h(r112.f257527e);
            r107.a(r110);
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public final void a() {
        if (this.f257529g == false) goto L5;
        return;
    L5:
        this.f257529g = true;
        Timer r100 = this.f257535m;
        if (r100 == null) goto L8;
        r100.cancel();
    L8:
        s r101 = this.f257525c;
        if (r101 == null) goto L11;
        r101.onCancel();
    L11:
        f(this, "user cancel", null, 4, 2);
    }

    public final void b() {
        this.f257527e.a();
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L19
        h();     // Catch: Throwable -> L19
        Context r101 = this.f257523a.getContext();     // Catch: Throwable -> L19
        if (r101 != null) goto L25;
        Unit r102 = null;
    L15:
        if (r102 != null) goto L17;
        f(this, "current page has no context", null, 0, 6);     // Catch: Throwable -> L19
    L17:
        Object r103 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L19
    L21:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L29;
        f(this, "unknown exception," + r104, r104, 0, 4);
        return;
    L29:
        return;
    L25:
        Bundle r105 = new Bundle();     // Catch: Throwable -> L11
        oq6.a r106 = new oq6.a(0, 0, r105);     // Catch: Throwable -> L11
        Uri.Builder r107 = UriProtector.parse(this.f257533k).buildUpon().appendQueryParameter("is_refresh_page", "1").appendQueryParameter("virtual_refresh_id", this.f257528f);     // Catch: Throwable -> L11
        s r108 = this.f257525c;     // Catch: Throwable -> L11
        if (r108 == null) goto L9;
        r108.Vt(r107, r105);     // Catch: Throwable -> L11
    L9:
        ((r) this.f257538p.getValue()).b(r101, r107.build().toString(), r106);     // Catch: Throwable -> L11
    L13:
        r102 = Unit.INSTANCE;     // Catch: Throwable -> L19
        goto L15
    L11:
        th = move-exception;
        f(this, "open route error:" + th.getMessage(), th, 0, 4);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L21
    }

    public final boolean d() {
        if (this.f257530h.get() == false) goto L5;
    L7:
        return false;
    L5:
        if (this.f257529g == true) goto L7;
        return true;
    }

    public final void h() {
        if (this.f257524b.f257569b == true) goto L5;
        return;
    L5:
        ViewGroup r100 = ((r) this.f257538p.getValue()).c(this.f257523a);
        Function0<Unit> r101 = new VirtualRefreshPageTask$showLoading$1(this);
        if (r100 == null) goto L12;
        DmtLoadingLayout r102 = (DmtLoadingLayout) r100.findViewById(R.id.poi_dynamic_id_virtual_refresh_loading_view);
        if (r102 != null) goto L13;
        Context r103 = r100.getContext();
        if (r103 == null) goto L12;
        DmtLoadingLayout r104 = new DmtLoadingLayout(r103);
        r104.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        r104.setId(R.id.poi_dynamic_id_virtual_refresh_loading_view);
        r100.addView(r104);
        r102 = r104;
    L13:
        if (r102 == null) goto L15;
        r102.setOnTouchListener(new c0(r101));
    L15:
        if (r102 == null) goto L19;
        r102.setVisibility(0);
        return;
    L19:
        return;
    L12:
        r102 = null;
        goto L13
    }

    public final String toString() {
        return "VirtualRefreshPageTask(currentFra=" + this.f257523a + ", param=" + this.f257524b + ", stateChangeListener=" + this.f257525c + ", result=" + this.f257526d + ", isCancelled=" + this.f257529g + ", isDone=" + this.f257530h.get() + ", targetFra=" + this.f257532j + ", schema='" + this.f257533k + "', timeoutMill=" + this.f257534l + ", timeOutTimer=" + this.f257535m + ", hasTimeOut=" + this.f257536n + ')';
    }

    @Override // java.lang.Runnable
    public final void run() {
        b();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public final boolean c(FragmentActivity r100) {
        if (r100 == null) goto L10;
        Intent r101 = r100.getIntent();
        if (r101 == null) goto L10;
        Bundle r102 = r101.getExtras();
        if (r102 == null) goto L10;
        String r103 = r102.getString("virtual_refresh_id");
        if (r103 == null) goto L10;
        return r103.equals(this.f257528f);
    L10:
        return false;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        com.bytedance.locallife.dito.data.l r101 = (com.bytedance.locallife.dito.data.l) r100;
        rq6.a r102 = rq6.a.f538927a;
        StringBuilder r103 = new StringBuilder("====>onChanged:");
        if (r101 == null) goto L5;
        String r104 = r101.getType();
    L6:
        r103.append(r104);
        r102.b("VirtualRefreshPage", r103.toString());
        if (d() == false) goto L36;
        DitoFragment r105 = this.f257532j;
        if (r105 == null) goto L31;
        if (r101 == null) goto L31;
        if (Intrinsics.areEqual(r101.f258214a, "REQUEST_COMPLETE") == true) goto L29;
        s r106 = this.f257525c;
        if (r106 == null) goto L19;
        boolean r107 = true;
        if (r106.zY(r105, r101) != true) goto L19;
    L20:
        if (r107 == true) goto L29;
        if (r101.a() == false) goto L30;
        StringBuilder r108 = new StringBuilder("target page error:");
        Throwable r109 = r101.f258216c;
        if (r109 == null) goto L27;
        String r110 = r109.getMessage();
    L28:
        r108.append(r110);
        f(this, r108.toString(), null, 0, 6);
        goto L30
    L27:
        r110 = null;
    L30:
        Unit r111 = Unit.INSTANCE;
    L32:
        if (r111 != null) goto L35;
        f(this, "target page is null", null, 0, 6);
        return;
    L35:
        return;
    L19:
        r107 = false;
    L29:
        e(r105, 0);
    L31:
        r111 = null;
        goto L32
    L36:
        return;
    L5:
        r104 = null;
        goto L6
    }

    public final void e(final DitoFragment r100, final int r101) {
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L16
        this.f257527e.b();     // Catch: Throwable -> L16
        if (this.f257523a.isVisible() == false) goto L13;
        Function0<Unit> r103 = new VirtualRefreshPageTask$onComplete$1$successRunnable$1(this, r100, r101);     // Catch: Throwable -> L16
        s r104 = this.f257525c;     // Catch: Throwable -> L16
        if (r104 != null) goto L8;
    L10:
        boolean r105 = false;
    L11:
        if (r105 == false) goto L14;
        r103.invoke();     // Catch: Throwable -> L16
    L14:
        Object r106 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L16
    L18:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L24;
        f(this, "onComplete Error", r107, 0, 4);
        return;
    L24:
        return;
    L8:
        if (r104.Wx(this.f257523a, r100, r101, r103) == true) goto L10;
        r105 = true;
        goto L11
    L13:
        f(this, "source page not visible", null, 0, 6);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L18
    }

    public final void g(boolean r100, int r101, String r102) {
        rq6.a r103 = rq6.a.f538927a;
        r103.c("VirtualRefreshPage", "======>dispatchResult,success:" + r100 + ",resultFrom:" + r101 + ",msg:" + r102 + ",stack:" + Log.getStackTraceString(new Throwable()));
        if (this.f257531i == false) goto L6;
        r103.b("VirtualRefreshPage", "refresh page has already dispatch result" + this);
        return;
    L6:
        this.f257531i = true;
        this.f257537o.post(new a(r101, this, r100, r102));
    }

    public VirtualRefreshPageTask(DitoFragment r100, e0 r110, DitoVirtualRefreshPagePlugin.b r111, DitoVirtualRefreshPagePlugin.c r112) {
        x r101 = new x(0);
        Intrinsics.checkNotNullParameter(r100, "currentFra");
        Intrinsics.checkNotNullParameter(r110, "param");
        Intrinsics.checkNotNullParameter(r101, "taskMetrics");
        this.f257523a = r100;
        this.f257524b = r110;
        this.f257525c = r111;
        this.f257526d = r112;
        this.f257527e = r101;
        this.f257528f = String.valueOf(System.currentTimeMillis());
        this.f257530h = new AtomicBoolean(false);
        this.f257533k = r110.f257568a;
        long r102 = r110.f257570c;
        this.f257534l = r102;
        this.f257537o = new Handler(Looper.getMainLooper());
        this.f257538p = LazyKt.lazy(new VirtualRefreshPageTask$virtualRefreshPageStrategy$2(this));
        FragmentManager.FragmentLifecycleCallbacks r113 = new VirtualRefreshPageTask$fragmentLifecycleCallbacks$1(this);
        if (r102 <= 0) goto L5;
        Timer r114 = TimersKt.timer(null, false);
        r114.schedule(new d0(this), 0, r102);
        this.f257535m = r114;
    L5:
        FragmentManager r103 = m.a(r100);
        if (r103 == null) goto L9;
        r103.registerFragmentLifecycleCallbacks(r113, false);
        return;
    }

    public static void f(VirtualRefreshPageTask r100, String r101, Throwable r102, int r103, int r104) {
        if ((r104 & 2) == 0) goto L6;
        r102 = null;
    L6:
        if ((r104 & 4) == 0) goto L9;
        r103 = 3;
    L9:
        if (r100.f257530h.compareAndSet(false, true) == false) goto L13;
        r100.f257537o.post(new z(r100, r101, r102, r103));
        return;
    }
}
