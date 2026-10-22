package com.bytedance.android.livesdk.ktvimpl.base.lyricmodule;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.ktvapi.config.ScrollLyricConfigV2;
import com.bytedance.android.livesdk.ktvimpl.base.lyricv2.view.KtvScrollLyricViewV2;
import com.bytedance.android.livesdk.ktvimpl.base.lyricv2.view.ScrollLyricAdapterV2;
import com.bytedance.bdlocation.sensor.SensorBatchGpsCollector;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class LyricScrollControllerV2 {
    public static final /* synthetic */ int q = 0;
    public final Handler a;
    public int b;
    public boolean c;
    public boolean d;
    public final int e;
    public Function1<? super Boolean, Unit> f;
    public final b g;
    public int h;
    public int i;
    public int j;
    public Integer k;
    public final LyricScrollControllerV2$mOnScrollListener$1 l;
    public final c m;
    public final KtvScrollLyricViewV2 n;
    public final ScrollLyricConfigV2 o;
    public final d p;

    public static final class a {
    }

    public static final class b implements View.OnTouchListener {
        public final /* synthetic */ LyricScrollControllerV2 a;

        public b(LyricScrollControllerV2 r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r3, MotionEvent r4) {
            if (r4 != null) goto L5;
            return false;
        L5:
            int r0 = r4.getAction();
            if (r0 != 0) goto L8;
            this.a.d = false;
            r4.getY();
            LyricScrollControllerV2 r5 = this.a;
            r5.h = 0;
            LyricScrollControllerV2.a(r5);
            ALogger.i("onScrollStateChanged", "setlastScrollLine---" + this.a.i);
            LyricScrollControllerV2 r6 = this.a;
            r6.a.removeCallbacks(r6.m);
        L17:
            return false;
        L8:
            if (r0 != 1) goto L10;
            LyricScrollControllerV2 r1 = this.a;
            r1.d = true;
            r1.b(false);
            this.a.getClass();
            return false;
        L10:
            if (r0 != 2) goto L17;
            this.a.d(true);
            return false;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ LyricScrollControllerV2 a;

        public c(LyricScrollControllerV2 r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Function1<? super Boolean, Unit> r0 = this.a.f;     // Catch: Throwable -> L7
            if (r0 == null) goto L5;
            Unit r1 = (Unit) r0.invoke(null);     // Catch: Throwable -> L7
        L5:
            this.a.c(true);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }
    }

    static {
    }

    public static final void a(LyricScrollControllerV2 r3) {
        LinearLayoutManager r0 = r3.n.getLayoutManager();
        if (r0 == null) goto L7;
        int r1 = r0.findFirstVisibleItemPosition() + 0;
        r3.i = r1;
        r3.j = r1;
        r3.h = 0;
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
    }

    public final void b(boolean r4) {
        if (r4 == false) goto L4;
        this.a.removeCallbacks(this.m);
        return;
    L4:
        Integer r5 = this.k;
        if (r5 != null) goto L8;
        return;
    L8:
        if (r5.intValue() == 0) goto L10;
        return;
    L10:
        if (this.d == false) goto L15;
        this.a.removeCallbacks(this.m);
        this.a.postDelayed(this.m, SensorBatchGpsCollector.DEFAULT_NETWORK_FALLBACK_TIMEOUT_MS);
        return;
    }

    public final void c(boolean r5) {
        int r0 = this.p.c;
        if (r0 != this.b) goto L5;
        if (r5 == true) goto L5;
        return;
    L5:
        this.o.b(r0);
        RecyclerView.Adapter r6 = this.n.getAdapter();
        LinearLayoutManager r2 = null;
        if ((r6 instanceof ScrollLyricAdapterV2) == true) goto L8;
        r6 = null;
    L8:
        ScrollLyricAdapterV2 r7 = (ScrollLyricAdapterV2) r6;
        if (r7 != null) goto L11;
    L26:
        this.b = r0;
        return;
    L11:
        if (this.c == false) goto L13;
    L25:
        r7.notifyDataSetChanged();
        goto L26
    L13:
        if (Math.abs(r0 - this.b) > this.e) goto L15;
    L24:
        e(r0);
        goto L25
    L15:
        if (((com.bytedance.android.livesdk.ktvapi.config.a) r7.c).a <= 0) goto L24;
        LinearLayoutManager r1 = this.n.getLayoutManager();
        if ((r1 instanceof LinearLayoutManager) == false) goto L20;
        r2 = r1;
    L20:
        LinearLayoutManager r3 = r2;
        if (r3 == null) goto L23;
        r3.scrollToPositionWithOffset(r0, ((com.bytedance.android.livesdk.ktvapi.config.a) r7.c).a * 0);
        goto L25
    L23:
        e(r0);
        goto L25
    }

    public final void d(boolean r3) {
        this.c = r3;
        ScrollLyricConfigV2 r0 = this.o;
        if (r0.o == r3) goto L11;
        r0.o = r3;
        RecyclerView.Adapter r1 = this.n.getAdapter();
        if (r1 == null) goto L7;
        r1.notifyDataSetChanged();
    L7:
        Function1<? super Boolean, Unit> r2 = this.f;
        if (r2 == null) goto L11;
        Unit r4 = (Unit) r2.invoke(Boolean.valueOf(r3));
    L11:
        if (r3 == false) goto L15;
        LyricScrollControllerV2$mOnScrollListener$1 r5 = this.l;
        KtvScrollLyricViewV2 r6 = this.n;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r6, "v");
        if (r5.a == true) goto L17;
        r5.a = true;
        r6.addOnScrollListener(r5);
        return;
    L17:
        return;
    L15:
        LyricScrollControllerV2$mOnScrollListener$1 r7 = this.l;
        KtvScrollLyricViewV2 r8 = this.n;
        r7.getClass();
        Intrinsics.checkNotNullParameter(r8, "v");
        r7.a = false;
        r8.removeOnScrollListener(r7);
    }

    public final void e(int r5) {
        if (this.n.getLayoutManager() != null) goto L5;
        return;
    L5:
        LyricScrollControllerV2$mOnScrollListener$1 r0 = this.l;
        int r2 = 0;
        if (r0.a == false) goto L8;
        KtvScrollLyricViewV2 r1 = this.n;
        Intrinsics.checkNotNullParameter(r1, "v");
        r0.a = false;
        r1.removeOnScrollListener(r0);
    L8:
        if (r5 != 0) goto L17;
        LinearLayoutManager r6 = this.n.getLayoutManager();
        if (r6 == null) goto L16;
        if (r6.findFirstVisibleItemPosition() <= 0) goto L23;
        this.n.smoothScrollToPosition(0);
        ALogger.i(bb0.b.b(), "KtvScrollController :smoothScrollTo: target 0, invoke class :".concat(LyricScrollControllerV2.class.getSimpleName()));
        return;
    L23:
        return;
    L16:
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
    L17:
        KtvScrollLyricViewV2 r3 = this.n;
        if (r5 <= 0) goto L21;
        r2 = 0 + r5;
    L21:
        r3.smoothScrollToPosition(r2);
    }

    /* JADX WARN: Type inference failed for: r3v6, types: [com.bytedance.android.livesdk.ktvimpl.base.lyricmodule.LyricScrollControllerV2$mOnScrollListener$1] */
    public LyricScrollControllerV2(KtvScrollLyricViewV2 r2, ScrollLyricConfigV2 r3, d r4) {
        Intrinsics.checkNotNullParameter(r2, "lyricView");
        Intrinsics.checkNotNullParameter(r3, "config");
        Intrinsics.checkNotNullParameter(r4, "displayModel");
        this.n = r2;
        this.o = r3;
        this.p = r4;
        this.a = new Handler();
        this.b = -1;
        this.d = true;
        this.e = 7;
        this.g = new b(this);
        this.l = new LyricScrollControllerV2$mOnScrollListener$1(this);
        r2.addOnScrollListener(new AnonymousClass1(this));
        this.m = new c(this);
    }
}
