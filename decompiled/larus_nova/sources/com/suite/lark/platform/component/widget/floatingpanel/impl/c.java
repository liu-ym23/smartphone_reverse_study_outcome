package com.suite.lark.platform.component.widget.floatingpanel.impl;

import android.content.Context;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.apm.constant.UploadTypeInf;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.p;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.suite.lark.platform.component.widget.floatingpanel.impl.container.FloatingPanelTopPageViewContainer;
import com.suite.lark.platform.component.widget.floatingpanel.impl.view.FloatingPanelView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import yoc.g;
import z5c.i0;
import z5c.y3;

/* JADX INFO: loaded from: classes36.dex */
public final class c {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f460671j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f460672a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.suite.lark.platform.component.widget.floatingpanel.impl.container.b f460673b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f460674c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function2<Context, FloatingPanelView.g, FloatingPanelView> f460675d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public FloatingCardItem<yoc.b> f460676e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<FloatingCardItem<yoc.c>> f460677f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f460678g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final d f460679h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f460680i;

    public static final class a {
    }

    public static final class b implements e.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f460681a;

        @Override // com.suite.lark.platform.component.widget.floatingpanel.impl.e.b
        public final void a() {
            this.f460681a.invoke();
        }

        public b(Function0<Unit> r100) {
            this.f460681a = r100;
        }
    }

    static {
    }

    public final void b() {
        Log.i("FloatingPanelPresenter", "dismissIfEmpty");
        if (this.f460676e == null) goto L5;
    L7:
        boolean r100 = false;
    L8:
        if (r100 == false) goto L16;
        Log.i("FloatingPanelPresenter", "dismiss");
        if (c().isAttachedToWindow() == false) goto L14;
        Long r101 = FloatPanelHitPoint.f460654a;
        if (r101 == null) goto L14;
        long r102 = r101.longValue();
        FloatPanelHitPoint.f460654a = null;
        long r103 = Math.max(0, System.currentTimeMillis() - r102);
        Statistics.sendEvent("core_float_dialog_display", s5c.d.b.b(y3.f570425q.a("2"), i0.f570218c.a(String.valueOf(r103))).toJson());
    L14:
        c().l();
        this.f460673b.dismiss();
        return;
    L16:
        return;
    L5:
        if (((ArrayList) this.f460677f).isEmpty() == false) goto L7;
        r100 = true;
        goto L8
    }

    public final FloatingPanelView c() {
        return (FloatingPanelView) this.f460680i.getValue();
    }

    public final void f() {
        Log.i("FloatingPanelPresenter", "onAnyCardRemoved");
        this.f460674c.c("fallback_dismiss", 500, this.f460679h);
    }

    public final void g() {
        Log.i("FloatingPanelPresenter", "removeBanner");
        FloatingCardItem<yoc.b> r100 = this.f460676e;
        if (r100 == null) goto L5;
        this.f460674c.b(r100.f460661e);
    L5:
        this.f460676e = null;
        if (c().i() == false) goto L9;
        f();
        return;
    }

    public static final void a(c r100) {
        r100.getClass();
        Log.i("FloatingPanelPresenter", "onAnyCardShown");
        r100.f460674c.b("fallback_dismiss");
    }

    public final int d(FloatingCardItem<?> r100) {
        if (((ArrayList) this.f460677f).isEmpty() == false) goto L5;
        return 0;
    L5:
        r100.f460657a.getPriority();
        ((FloatingCardItem) CollectionsKt.first(this.f460677f)).f460657a.getPriority();
        return 0;
    }

    public final void i(int r100) {
        Log.i("FloatingPanelPresenter", "removeCardAtIndex, index: " + r100 + ", cardCount: " + ((ArrayList) this.f460677f).size());
        FloatingCardItem r101 = (FloatingCardItem) ListProtector.remove(this.f460677f, r100);
        c().j(r101.f460661e);
        this.f460674c.b(r101.f460661e);
        f();
        if (r100 != 0) goto L18;
        boolean r102 = true;
        if ((!((ArrayList) this.f460677f).isEmpty()) == false) goto L19;
        FloatingCardItem r103 = (FloatingCardItem) ListProtector.get(this.f460677f, 0);
        Card r104 = r103.f460657a;
        if ((r104 instanceof g) == false) goto L9;
        g r105 = (g) r104;
    L10:
        if (r105 != null) goto L12;
    L14:
        r102 = false;
    L15:
        if (r102 == false) goto L20;
        Log.i("FloatingPanelPresenter", "Remove invalid card, id: " + r103.f460661e);
        i(0);
        return;
    L20:
        return;
    L12:
        if (r105.isValid() == true) goto L14;
    L9:
        r105 = null;
        goto L10
    L19:
        return;
    }

    public final void k(Function0<Unit> r100) {
        if (c().isAttachedToWindow() == true) goto L5;
        Long r101 = FloatPanelHitPoint.f460654a;
        FloatPanelHitPoint.f460654a = Long.valueOf(System.currentTimeMillis());
        Statistics.sendEvent("core_float_dialog_display", s5c.d.b.c(y3.f570425q.a("1")));
    L5:
        this.f460673b.c(c());
        this.f460673b.b(r100);
    }

    public final void e(List<String> r100, int r101) {
        ArrayList r102 = (ArrayList) r100;
        if (r102.isEmpty() == false) goto L6;
        return;
    L6:
        if (r102.size() != r101) goto L14;
        Log.i("FloatingPanelPresenter", "removeAllCards");
        c().h();
        f();
        e r103 = this.f460674c;
        ReentrantLock r104 = r103.f460712a;
        r104.lock();
        r103.f460715d.removeMessages(1);     // Catch: Throwable -> L11
        ((LinkedHashMap) r103.f460714c).clear();     // Catch: Throwable -> L11
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L11
        r104.unlock();
        return;
    L11:
        th = move-exception;
        r104.unlock();
        throw th;
    L14:
        c().k(r100);
        Iterator<T> r106 = r100.iterator();
    L16:
        if (r106.hasNext() == false) goto L18;
        String r107 = (String) r106.next();
        this.f460674c.b(r107);
        goto L16
    L18:
        f();
    }

    public final void h(int r110, String r111) {
        Intrinsics.checkNotNullParameter(r111, "id");
        Log.i("FloatingPanelPresenter", "removeCard, id: " + r111);
        Iterator r100 = ((ArrayList) this.f460677f).iterator();
        int r101 = 0;
        int r102 = 0;
    L4:
        if (r100.hasNext() == false) goto L14;
        FloatingCardItem r103 = (FloatingCardItem) r100.next();
        if (r103.f460662f == r110) goto L8;
    L10:
        boolean r104 = false;
    L11:
        if (r104 == true) goto L15;
        r102 = r102 + 1;
    L15:
        if (r102 < 0) goto L17;
        i(r102);
        return;
    L17:
        ArrayList r105 = new ArrayList();
        int r112 = Math.min(((ArrayList) this.f460677f).size(), 5);
    L18:
        if (r101 >= r112) goto L20;
        r105.add(((FloatingCardItem) ListProtector.get(this.f460677f, r101)).f460661e);
        r101 = r101 + 1;
        goto L18
    L20:
        Log.w("FloatingPanelPresenter", "removeCard, card not found, id: " + r111 + ", cards: " + ((ArrayList) this.f460677f).size() + ", ids: " + CollectionsKt.joinToString$default(r105, null, null, null, 0, null, null, 63, null));
        return;
    L8:
        if (Intrinsics.areEqual(r103.f460663g, r111) == false) goto L10;
        r104 = true;
        goto L11
    L14:
        r102 = -1;
        goto L15
    }

    public final void j(int r110, Function1<? super yoc.c, Boolean> r111) {
        Intrinsics.checkNotNullParameter(r111, "filter");
        Log.i("FloatingPanelPresenter", "removeCards with condition");
        if (((ArrayList) this.f460677f).isEmpty() == false) goto L5;
        return;
    L5:
        int r100 = ((ArrayList) this.f460677f).size();
        ArrayList r101 = new ArrayList();
        int r102 = this.f460677f.size();
        int r103 = 0;
        boolean r104 = true;
    L6:
        if (r103 >= r102) goto L28;
        FloatingCardItem r105 = (FloatingCardItem) ListProtector.get(this.f460677f, r103);
        if (r105.f460662f == r110) goto L10;
    L12:
        if (r104 == false) goto L24;
        Card r106 = r105.f460657a;
        if ((r106 instanceof g) == false) goto L16;
        g r107 = (g) r106;
    L17:
        if (r107 != null) goto L19;
    L21:
        boolean r108 = false;
    L22:
        if (r108 == false) goto L24;
    L11:
        boolean r109 = true;
    L25:
        if (r109 == false) goto L27;
        r101.add(Integer.valueOf(r103));
    L27:
        r103 = r103 + 1;
        goto L6
    L19:
        if (r107.isValid() == true) goto L21;
        r108 = true;
        goto L22
    L16:
        r107 = null;
    L24:
        r104 = false;
        r109 = false;
        goto L25
    L10:
        if (r111.invoke(r105.f460657a).booleanValue() == false) goto L12;
    L28:
        ArrayList r112 = new ArrayList();
        Iterator r113 = p.a(r101).iterator();
    L30:
        if (r113.hasNext() == false) goto L32;
        int r114 = ((Number) r113.next()).intValue();
        r112.add(((FloatingCardItem) ListProtector.remove(this.f460677f, r114)).f460661e);
        goto L30
    L32:
        e(r112, r100);
    }

    public final void l(FloatingCardItem<?> r100, Function0<Unit> r101) {
        Log.i("FloatingPanelPresenter", "startTimerIfNeeded, itemId: " + r100.f460661e);
        Card r102 = r100.f460657a;
        if ((r102 instanceof yoc.d) == false) goto L5;
        yoc.d r103 = (yoc.d) r102;
    L6:
        if (r103 == null) goto L11;
        long r104 = r103.getDisplayDuration();
        if (r104 <= 0) goto L12;
        Log.i("FloatingPanelPresenter", "startTimer, itemId: " + r100.f460661e + ", duration: " + r104);
        this.f460674c.c(r100.f460661e, r104, new b(r101));
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r103 = null;
        goto L6
    }

    public c(Context r100, FloatingPanelTopPageViewContainer r101, e r102) {
        FloatingPanelPresenter$1 r103 = FloatingPanelPresenter$1.INSTANCE;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r102, UploadTypeInf.TIMER);
        Intrinsics.checkNotNullParameter(r103, "viewFactory");
        this.f460672a = r100;
        this.f460673b = r101;
        this.f460674c = r102;
        this.f460675d = r103;
        this.f460677f = new ArrayList();
        LazyThreadSafetyMode r104 = LazyThreadSafetyMode.NONE;
        this.f460678g = LazyKt.lazy(r104, new FloatingPanelPresenter$viewDelegate$2(this));
        this.f460679h = new d(this);
        this.f460680i = LazyKt.lazy(r104, new FloatingPanelPresenter$rootView$2(this));
        r101.f460692j = new com.suite.lark.platform.component.widget.floatingpanel.impl.b(this);
    }
}
