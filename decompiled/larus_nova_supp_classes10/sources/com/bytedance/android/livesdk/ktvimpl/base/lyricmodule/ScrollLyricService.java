package com.bytedance.android.livesdk.ktvimpl.base.lyricmodule;

import android.content.Context;
import android.graphics.RectF;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.android.livesdk.ktvapi.config.ScrollLyricConfigV2;
import com.bytedance.android.livesdk.ktvimpl.base.lyricv2.LyricLinearLayoutManager;
import com.bytedance.android.livesdk.ktvimpl.base.lyricv2.view.KtvScrollLyricViewV2;
import com.bytedance.android.livesdk.ktvimpl.base.lyricv2.view.ScrollLyricAdapterV2;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import fd2.a0;
import fd2.g0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class ScrollLyricService extends AbsLyricService {
    public final KtvScrollLyricViewV2 h;
    public final Lazy i;
    public final Lazy j;
    public final ArrayList<Function1<g0, Unit>> k;
    public final g0 l;
    public int m;
    public Function2<? super Integer, ? super Integer, Unit> n;
    public final int o;
    public ScrollLyricAdapterV2.SingleLineViewHolder p;

    public static final class a<T> implements Observer {
        public final /* synthetic */ ScrollLyricService a;

        public a(ScrollLyricService r1) {
            this.a = r1;
        }

        public final void onChanged(Object r5) {
            Integer r6 = (Integer) r5;
            this.a.w().notifyDataSetChanged();
            ScrollLyricService r0 = this.a;
            g0 r1 = r0.l;
            r1.getClass();
            if (r6 != null) goto L5;
            long r2 = 0;
        L10:
            Long r7 = Long.valueOf(r2);
        L12:
            r1.b = r7;
            ScrollLyricService.u(this.a);
            return;
        L5:
            List<com.bytedance.component.lyric.model.b> r3 = r0.g.c();
            if (r3 == null) goto L11;
            com.bytedance.component.lyric.model.b r8 = (com.bytedance.component.lyric.model.b) KtvUtilsKt.K(r3, r6.intValue());
            if (r8 == null) goto L11;
            r2 = r8.b;
        L11:
            r7 = null;
            goto L12
        }
    }

    public static final class b {
    }

    static {
    }

    public final void p() {
        this.h.setNestedScrollingEnabled(false);
    }

    public final ScrollLyricAdapterV2 w() {
        return (ScrollLyricAdapterV2) this.i.getValue();
    }

    public final LyricScrollControllerV2 x() {
        return (LyricScrollControllerV2) this.j.getValue();
    }

    public final void a() {
        g0 r0 = this.l;
        r0.getClass();
        r0.b = null;
        com.bytedance.android.livesdk.ktvapi.config.a r1 = this.e;
        if ((r1 instanceof ScrollLyricConfigV2) == true) goto L5;
        r1 = null;
    L5:
        ScrollLyricConfigV2 r2 = (ScrollLyricConfigV2) r1;
        if (r2 == null) goto L10;
        NextLiveData r3 = r2.n;
        if (r3 == null) goto L10;
        r3.setValue(null);
    L10:
        x().b = -1;
        x().d(false);
    }

    public final Long f() {
        List<com.bytedance.component.lyric.model.b> r0 = this.g.c();
        if (r0 == null) goto L7;
        com.bytedance.component.lyric.model.b r1 = (com.bytedance.component.lyric.model.b) CollectionsKt.firstOrNull(r0);
        if (r1 == null) goto L7;
        return Long.valueOf(r1.b);
    L7:
        return null;
    }

    public final int h() {
        List<com.bytedance.component.lyric.model.b> r0 = this.g.c();
        if (r0 == null) goto L20;
        ArrayList r2 = new ArrayList();
        Iterator<T> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L14;
        Object r3 = r1.next();
        if (((com.bytedance.component.lyric.model.b) r3).a != 0) goto L10;
        boolean r4 = true;
    L11:
        if (r4 == false) goto L6;
        r2.add(r3);
        goto L6
    L10:
        r4 = false;
        goto L11
    L14:
        return r2.size();
    L20:
        return 0;
    }

    public final List<Object> q() {
        return this.g.c();
    }

    public final ScrollLyricAdapterV2.SingleLineViewHolder v() {
        ScrollLyricAdapterV2.SingleLineViewHolder r0 = this.p;
        RecyclerView.ViewHolder r1 = null;
        if (r0 == null) goto L16;
        if (r0 == null) goto L6;
        Integer r2 = Integer.valueOf(r0.getAdapterPosition());
    L7:
        com.bytedance.android.livesdk.ktvapi.config.a r3 = this.e;
        if ((r3 instanceof ScrollLyricConfigV2) == true) goto L10;
        r3 = null;
    L10:
        ScrollLyricConfigV2 r4 = (ScrollLyricConfigV2) r3;
        if (r4 == null) goto L13;
        Integer r5 = r4.f;
    L15:
        if ((!Intrinsics.areEqual(r2, r5)) == true) goto L16;
    L29:
        return this.p;
    L13:
        r5 = null;
        goto L15
    L6:
        r2 = null;
    L16:
        com.bytedance.android.livesdk.ktvapi.config.a r6 = this.e;
        if ((r6 instanceof ScrollLyricConfigV2) == true) goto L19;
        r6 = null;
    L19:
        ScrollLyricConfigV2 r7 = (ScrollLyricConfigV2) r6;
        if (r7 == null) goto L29;
        Integer r8 = r7.f;
        if (r8 == null) goto L29;
        RecyclerView.ViewHolder r9 = this.h.findViewHolderForAdapterPosition(r8.intValue());
        if ((r9 instanceof ScrollLyricAdapterV2.SingleLineViewHolder) == false) goto L27;
        r1 = r9;
    L27:
        this.p = (ScrollLyricAdapterV2.SingleLineViewHolder) r1;
        goto L29
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyricmodule.AbsLyricService
    public final void reset() {
        LyricScrollControllerV2 r0 = x();
        r0.b = -1;
        r0.d(false);
        r0.o.b(0);
        r0.a.removeCallbacks(r0.m);
        super.reset();
    }

    public final KtvScrollLyricViewV2 getRenderView() {
        return this.h;
    }

    public final com.bytedance.android.livesdk.ktvapi.config.a j() {
        return this.e;
    }

    public static final void u(ScrollLyricService r3) {
        Iterator<Function1<g0, Unit>> r0 = r3.k.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Function1<g0, Unit> r1 = r0.next();
        if (r1 == null) goto L4;
        Unit r2 = (Unit) r1.invoke(r3.l);
        goto L4
    }

    public final long b(int r3) {
        List<com.bytedance.component.lyric.model.b> r0 = this.g.c();
        if (r0 == null) goto L9;
        com.bytedance.component.lyric.model.b r4 = (com.bytedance.component.lyric.model.b) CollectionsKt.getOrNull(r0, r3);
        if (r4 == null) goto L9;
        Integer r5 = r4.m;
        if (r5 == null) goto L9;
        return r5.intValue();
    L9:
        return 0;
    }

    public final void c(Function2<? super Integer, ? super Integer, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.n = r2;
    }

    public final void d(Function1<? super g0, Unit> r2) {
        if (r2 != null) goto L6;
        this.k.clear();
        return;
    L6:
        if (this.k.contains(r2) == true) goto L9;
        this.k.add(r2);
        return;
    }

    public final void g(Function2<? super Integer, ? super Integer, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "cb");
        this.h.r(r2);
    }

    public final int i(long r10) {
        List<com.bytedance.component.lyric.model.b> r0 = this.g.c();
        if (r0 == null) goto L13;
        ArrayList r3 = new ArrayList();
        Iterator<T> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L14;
        Object r4 = r1.next();
        if (((com.bytedance.component.lyric.model.b) r4).a != 0) goto L10;
        boolean r5 = true;
    L11:
        if (r5 == false) goto L6;
        r3.add(r4);
        goto L6
    L10:
        r5 = false;
    L14:
        if (r3 == null) goto L52;
        int r2 = r3.size();
        int r6 = 0;
        int r7 = 0;
    L16:
        if (r6 >= r2) goto L38;
        if (r10 < ((com.bytedance.component.lyric.model.b) ListProtector.get(r3, 0)).b) goto L55;
        if (r10 >= ((com.bytedance.component.lyric.model.b) ListProtector.get(r3, r6)).b) goto L25;
        if (r6 <= 0) goto L25;
        return r6 - 1;
    L25:
        if (r6 != (r3.size() - 1)) goto L30;
        if (r10 < ((com.bytedance.component.lyric.model.b) ListProtector.get(r3, r6)).b) goto L30;
        return r3.size() - 1;
    L30:
        if (r6 >= r3.size()) goto L36;
        if (r10 <= ((com.bytedance.component.lyric.model.b) ListProtector.get(r3, r6)).b) goto L36;
        if (r10 >= ((com.bytedance.component.lyric.model.b) ListProtector.get(r3, r6)).c) goto L36;
        r7 = r6;
    L36:
        r6 = r6 + 1;
        goto L16
    L55:
        return 0;
    L38:
        return r7;
    L52:
        return 0;
    L13:
        r3 = null;
        goto L14
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyricmodule.AbsLyricService
    public final void k(a0 r5) {
        Intrinsics.checkNotNullParameter(r5, "request");
        com.bytedance.android.livesdk.ktvapi.config.a r0 = this.e;
        if (r0.e > 0) goto L5;
        r0.e = this.h.getWidth();
    L5:
        super.k(r5);
    }

    public final long l(int r3) {
        List<com.bytedance.component.lyric.model.b> r0 = this.g.c();
        if (r0 == null) goto L7;
        com.bytedance.component.lyric.model.b r4 = (com.bytedance.component.lyric.model.b) CollectionsKt.getOrNull(r0, r3);
        if (r4 == null) goto L7;
        return r4.b;
    L7:
        return 0;
    }

    public final void n(boolean r2) {
        LyricScrollControllerV2 r0 = x();
        if (r2 == false) goto L5;
        r0.n.setOnTouchListener(r0.g);
        return;
    L5:
        r0.n.setOnTouchListener(null);
    }

    public final void y(Integer r7) {
        int r0 = -1;
        this.m = -1;
        ScrollLyricAdapterV2 r1 = w();
        r1.c.f = null;
        ArrayList<com.bytedance.component.lyric.model.b> r2 = r1.d.a;
        if (r7 == null) goto L5;
        r0 = r7.intValue();
    L5:
        com.bytedance.component.lyric.model.b r8 = (com.bytedance.component.lyric.model.b) KtvUtilsKt.K(r2, r0);
        if (r8 != null) goto L18;
        Iterator<com.bytedance.component.lyric.model.b> r9 = r1.d.a.iterator();
    L9:
        if (r9.hasNext() == false) goto L16;
        com.bytedance.component.lyric.model.b r3 = r9.next();
        if (r3.a != 2) goto L13;
        boolean r4 = true;
    L14:
        if (r4 == false) goto L9;
    L17:
        r8 = r3;
        goto L18
    L13:
        r4 = false;
        goto L14
    L16:
        r3 = null;
    L18:
        if (r8 == null) goto L20;
        r8.a = 0;
    L20:
        r1.notifyDataSetChanged();
        w().c.g = null;
        w().c.h = null;
    }

    public final void e(int r8, int r9) {
        this.m = -1;
        List<com.bytedance.component.lyric.model.b> r0 = this.g.c();
        com.bytedance.component.lyric.model.b r1 = null;
        if (r0 == null) goto L11;
        com.bytedance.component.lyric.model.b r2 = (com.bytedance.component.lyric.model.b) KtvUtilsKt.K(r0, r8);
        if (r2 == null) goto L11;
        int r3 = r2.b;
        if (r3 >= r9) goto L10;
        y(null);
        ALogger.i("ScrollLyricService", "startCountDownOnTheLine:startTime is less than countDownDuration.#" + r3);
        return;
    L10:
        w().c.g = Integer.valueOf(r3 - r9);
        w().c.h = Integer.valueOf(r3);
    L11:
        ScrollLyricAdapterV2 r10 = w();
        Iterator<com.bytedance.component.lyric.model.b> r4 = r10.d.a.iterator();
    L13:
        if (r4.hasNext() == false) goto L20;
        com.bytedance.component.lyric.model.b r5 = r4.next();
        if (r5.a != 2) goto L17;
        boolean r6 = true;
    L18:
        if (r6 == false) goto L13;
        r1 = r5;
        goto L20
    L17:
        r6 = false;
    L20:
        com.bytedance.component.lyric.model.b r7 = r1;
        if (r7 == null) goto L23;
        r7.a = 0;
    L23:
        com.bytedance.component.lyric.model.b r11 = (com.bytedance.component.lyric.model.b) KtvUtilsKt.K(r10.d.a, r8);
        if (r11 == null) goto L26;
        r11.a = 2;
    L26:
        r10.c.j.setValue(Float.valueOf(0.0f));
        ScrollLyricConfigV2 r12 = r10.c;
        Integer r13 = Integer.valueOf(r8);
        r12.f = r13;
        if (r13 != null) goto L29;
    L31:
        r10.notifyDataSetChanged();
        x().b(true);
        return;
    L29:
        if (r12.i == r13.intValue()) goto L31;
        r12.b(r13.intValue());
        goto L31
    }

    public final void m(int r2, int r3) {
        this.g.d(r2, r3);
        w().notifyDataSetChanged();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [android.view.ViewGroup, com.bytedance.android.livesdk.ktvimpl.base.lyricv2.view.KtvScrollLyricViewV2, java.lang.Object] */
    public final void o(RectF r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "rectF");
        ?? r0 = this.h;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r3, "rect");
        r0.l.setColor(r4);
        r0.i = r3;
        r0.invalidate();
    }

    public final int s(Integer r3, Long r4) {
        if (r3 != null) goto L5;
    L7:
        if (r4 == null) goto L18;
        ud2.a r5 = this.g;
        if ((r5 instanceof d) == true) goto L12;
        r5 = null;
    L12:
        d r6 = (d) r5;
        if (r6 != null) goto L19;
        return 0;
    L19:
        return r6.f(r4.longValue());
    L18:
        return this.g.b();
    L5:
        if (r3.intValue() != 2) goto L7;
        return x().i;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyricmodule.AbsLyricService
    public final void r(long r10, boolean r12, Boolean r13) {
        boolean r0 = true;
        if (r12 == false) goto L8;
        x().d(false);
        super.r(r10, r12, r13);
        if (Intrinsics.areEqual(r13, Boolean.TRUE) == false) goto L76;
        x().c(true);
    L76:
        r0 = false;
    L77:
        if (r0 == false) goto L80;
        super.r(r10, r12, r13);
        LyricScrollControllerV2 r11 = x();
        int r14 = LyricScrollControllerV2.q;
        r11.c(false);
        return;
    L80:
        return;
    L8:
        if (x().o.g == null) goto L77;
        Integer r2 = w().c.g;
        if (r2 == null) goto L76;
        long r3 = r2.intValue();
        if (r10 < r3) goto L14;
        Integer r4 = w().c.h;
        if (r4 == null) goto L28;
        int r5 = r4.intValue();
    L30:
        if (r10 >= r5) goto L42;
        ScrollLyricAdapterV2.SingleLineViewHolder r6 = v();
        if (r6 == null) goto L37;
        com.bytedance.android.livesdk.ktvimpl.base.lyricv2.view.a r7 = r6.b;
        if (r7 == null) goto L37;
        if (r7.getVisibility() == 0) goto L42;
    L37:
        ScrollLyricAdapterV2.SingleLineViewHolder r8 = v();
        if (r8 == null) goto L42;
        com.bytedance.android.livesdk.ktvimpl.base.lyricv2.view.a r9 = r8.b;
        if (r9 == null) goto L42;
        r9.setVisibility(0);
    L42:
        Integer r15 = w().c.h;
        if (r15 == null) goto L45;
        int r16 = r15.intValue();
    L46:
        RecyclerView.ViewHolder r17 = null;
        if (r10 <= r16) goto L52;
        if (this.m <= 0) goto L76;
        y(null);
        goto L76
    L52:
        if (r3 >= r10) goto L76;
        int r18 = ((int) ((r10 - r3) / ((long) 1000))) + 1;
        if (r18 == this.m) goto L76;
        com.bytedance.android.livesdk.ktvapi.config.a r1 = this.e;
        if ((r1 instanceof ScrollLyricConfigV2) == true) goto L58;
        r1 = null;
    L58:
        ScrollLyricConfigV2 r19 = (ScrollLyricConfigV2) r1;
        if (r19 == null) goto L75;
        Integer r20 = r19.f;
        if (r20 == null) goto L75;
        RecyclerView.ViewHolder r21 = this.h.findViewHolderForAdapterPosition(r20.intValue());
        if ((r21 instanceof ScrollLyricAdapterV2.SingleLineViewHolder) == false) goto L66;
        r17 = r21;
    L66:
        ScrollLyricAdapterV2.SingleLineViewHolder r22 = (ScrollLyricAdapterV2.SingleLineViewHolder) r17;
        if (r22 == null) goto L75;
        com.bytedance.android.livesdk.ktvimpl.base.lyricv2.view.a r23 = r22.b;
        if (r23 == null) goto L74;
        r23.c = r18;
        int r24 = r23.b;
        if (r18 <= r24) goto L73;
        r23.c = r24;
    L73:
        r23.invalidate();
    L74:
        r22.c = Integer.valueOf(r18);
    L75:
        this.m = r18;
        goto L76
    L45:
        r16 = 0;
        goto L46
    L28:
        r5 = 0;
        goto L30
    L14:
        if ((r3 - r10) <= this.o) goto L20;
        ScrollLyricAdapterV2.SingleLineViewHolder r25 = v();
        if (r25 == null) goto L42;
        com.bytedance.android.livesdk.ktvimpl.base.lyricv2.view.a r26 = r25.b;
        if (r26 == null) goto L42;
        r26.setVisibility(8);
        goto L42
    L20:
        ScrollLyricAdapterV2.SingleLineViewHolder r27 = v();
        if (r27 == null) goto L42;
        com.bytedance.android.livesdk.ktvimpl.base.lyricv2.view.a r28 = r27.b;
        if (r28 == null) goto L42;
        r28.setVisibility(0);
        goto L42
    }

    public ScrollLyricService(final Context r2, final ScrollLyricConfigV2 r3, com.bytedance.android.livesdk.ktvimpl.base.lyricmodule.b r4, final d r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "displayConfig");
        Intrinsics.checkNotNullParameter(r4, "resourceManager");
        Intrinsics.checkNotNullParameter(r5, "model");
        super(r3, r4, r5);
        KtvScrollLyricViewV2 r6 = new KtvScrollLyricViewV2(r2, null);
        this.h = r6;
        this.i = LazyKt.lazy(new ScrollLyricService$lyricAdapter$2(r2, r3, r5));
        this.j = LazyKt.lazy(new ScrollLyricService$scrollController$2(this, r3, r5));
        this.k = new ArrayList();
        this.l = new g0();
        this.m = -1;
        r6.r(new AnonymousClass1(r3));
        r6.setOnSizeChangedListener(new AnonymousClass2(this, r3));
        r6.setFadingEdgeEnable(r3.r);
        r6.setTouchable(r3.s);
        r6.setAdapter(w());
        r6.setLayoutManager(new LyricLinearLayoutManager(r2));
        LyricScrollControllerV2 r7 = x();
        r7.f = new AnonymousClass3(this);
        r3.n.observeForever(new a(this));
        if (r3.q == false) goto L5;
        r6.setItemViewCacheSize(Integer.MAX_VALUE);
    L5:
        this.o = 1000;
    }
}
