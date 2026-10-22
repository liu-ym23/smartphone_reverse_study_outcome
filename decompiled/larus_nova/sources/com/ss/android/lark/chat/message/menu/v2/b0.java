package com.ss.android.lark.chat.message.menu.v2;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.animation.PathInterpolatorCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes35.dex */
public final class b0 implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f415691a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f415692b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RecyclerView f415693c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h f415694d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.ss.android.lark.chat.message.menu.v2.c f415695e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f415696f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f415697g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f415698h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f415699i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f415700j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f415701k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f415702l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int[] f415703m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final float f415704n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f415705o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f415706p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f415707q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f415708r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Lazy f415709s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f415710t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Lazy f415711u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Lazy f415712v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Function2<Boolean, int[], Unit> f415713w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Function1<Boolean, Unit> f415714x;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f415715a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b0 f415716b;

        public b(RecyclerView r100, b0 r101) {
            this.f415715a = r100;
            this.f415716b = r101;
        }

        public final void a() {
            b0 r100 = this.f415716b;
            int r101 = r100.f415692b;
            if (r101 != 0) goto L5;
            return;
        L5:
            if (r100.f415695e.a() == false) goto L11;
            r100.f415691a.getLocationOnScreen(r100.f415703m);
            int r102 = r100.f415703m[1];
            int r103 = r100.f415707q;
            if (r102 == r103) goto L11;
            r101 = Math.max(r101 - (r102 - r103), 0);
        L11:
            b0 r104 = this.f415716b;
            int r105 = r104.f415692b - r101;
            if (r105 == 0) goto L16;
            float r106 = r104.f415697g + r105;
            r104.f415697g = r106;
            r104.f415693c.setTranslationY(r104.f415704n - r106);
            this.f415716b.f415698h = r105;
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

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b0 f415717a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ float f415718b;

        public c(b0 r100, float r101) {
            this.f415717a = r100;
            this.f415718b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            b0 r100 = this.f415717a;     // Catch: Throwable -> L6
            h r101 = r100.f415694d;     // Catch: Throwable -> L6
            if (r101 == null) goto L9;
            int r102 = r100.f415702l;     // Catch: Throwable -> L6
            r101.b(new int[]{(int) (r102 - this.f415718b), r102});     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    static {
    }

    @Override // com.ss.android.lark.chat.message.menu.v2.f
    public final void c() {
        this.f415699i = false;
        this.f415714x.invoke(Boolean.TRUE);
    }

    @Override // com.ss.android.lark.chat.message.menu.v2.f
    public final void a() {
        if (this.f415693c.getTranslationY() != this.f415704n) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L8;
        return;
    L8:
        i(this.f415693c.getTranslationY(), this.f415704n, new MessageListAndPanelScrollCoordinator$onPanelDismiss$1(this), new MessageListAndPanelScrollCoordinator$onPanelDismiss$2(this));
        return;
    L5:
        r100 = false;
        goto L6
    }

    @Override // com.ss.android.lark.chat.message.menu.v2.f
    public final void b() {
        RecyclerView r100 = this.f415693c;
        OneShotPreDrawListener.add(r100, new b(r100, this));
        this.f415714x.invoke(Boolean.TRUE);
    }

    @Override // com.ss.android.lark.chat.message.menu.v2.f
    public final void f() {
        float r100 = this.f415693c.getTranslationY();
        float r101 = this.f415704n;
        if (r100 != r101) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L8;
        return;
    L8:
        this.f415693c.setTranslationY(r101);
        this.f415696f = 0;
        return;
    L5:
        r102 = false;
        goto L6
    }

    @Override // com.ss.android.lark.chat.message.menu.v2.f
    public final void h() {
        if (this.f415693c.getTranslationY() != this.f415704n) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L8;
        return;
    L8:
        float r101 = this.f415693c.getTranslationY();
        float r102 = this.f415704n;
        Function0<Unit> r103 = new MessageListAndPanelScrollCoordinator$onPanelTempDismiss$1(this);
        i(r101, r102, MessageListAndPanelScrollCoordinator$startTranslationAnim$1.INSTANCE, r103);
        this.f415699i = false;
        return;
    L5:
        r100 = false;
        goto L6
    }

    @Override // com.ss.android.lark.chat.message.menu.v2.f
    public final void g(final float r100) {
        float r101 = 0.0f;
        if (this.f415701k == false) goto L6;
        float r102 = 0.0f;
    L9:
        MessageListAndPanelScrollCoordinator$onPanelFirstShow$1 r103 = MessageListAndPanelScrollCoordinator$onPanelFirstShow$1.INSTANCE;
        Function0<Unit> r104 = new MessageListAndPanelScrollCoordinator$onPanelFirstShow$2(this, r100);
        if (r102 != 0.0f) goto L12;
        boolean r105 = true;
    L13:
        if (r105 == true) goto L16;
        r101 = ((r102 + this.f415698h) - this.f415696f) - this.f415697g;
    L16:
        int r106 = (int) r101;
        ValueAnimator r107 = ValueAnimator.ofInt(new int[]{0, r106});
        Ref.IntRef r108 = new Ref.IntRef();
        r107.setInterpolator(new AccelerateDecelerateInterpolator());
        r107.setDuration(250);
        r107.addUpdateListener(new e0(r108, this));
        Intrinsics.checkNotNull(r107);
        r107.addListener(new d0(r103));
        r107.addListener(new c0(r104, this, r101, r106));
        r107.start();
        return;
    L12:
        r105 = false;
        goto L13
    L6:
        if (this.f415700j == false) goto L8;
        r102 = (this.f415707q - (this.f415705o + this.f415695e.w3())) - ((Number) this.f415710t.getValue()).intValue();
        goto L9
    L8:
        r102 = Math.max(0.0f, r100 - this.f415708r);
        goto L9
    }

    @Override // com.ss.android.lark.chat.message.menu.v2.f
    public final void e(int r100, float r101) {
        this.f415702l = r100;
        boolean r102 = true;
        if (this.f415691a.getMeasuredHeight() < (((r100 - r101) - ((Number) this.f415711u.getValue()).intValue()) - ((Number) this.f415712v.getValue()).intValue())) goto L5;
        boolean r103 = true;
    L6:
        this.f415700j = r103;
        if (r103 == false) goto L13;
        this.f415699i = false;
        if ((this.f415707q - (this.f415705o + this.f415695e.w3())) < ((Number) this.f415710t.getValue()).intValue()) goto L12;
        r102 = false;
    L12:
        this.f415701k = r102;
        return;
    L13:
        this.f415708r = (r100 - (this.f415707q + this.f415691a.getMeasuredHeight())) - ((Number) this.f415709s.getValue()).intValue();
        return;
    L5:
        r103 = false;
        goto L6
    }

    @Override // com.ss.android.lark.chat.message.menu.v2.f
    public final void d(float r100, float r101, long r102) {
        if (r100 != r101) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L9;
        return;
    L9:
        if (this.f415699i == true) goto L12;
        this.f415691a.postDelayed(new c(this, r101), r102);
        return;
    L12:
        return;
    L5:
        r103 = false;
        goto L6
    }

    public final void i(float r100, float r101, Function0 r102, Function0 r103) {
        if (r100 != r101) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == false) goto L8;
        return;
    L8:
        ValueAnimator r105 = ValueAnimator.ofFloat(new float[]{r100, r101});
        r105.setInterpolator(PathInterpolatorCompat.create(0.66f, 0.0f, 0.34f, 1.0f));
        r105.setDuration(200);
        r105.addUpdateListener(new h0(this));
        Intrinsics.checkNotNull(r105);
        r105.addListener(new g0(r102));
        r105.addListener(new f0(r103));
        r105.start();
        return;
    L5:
        r104 = false;
        goto L6
    }

    public b0(View r100, int r101, RecyclerView r102, MessageActionPanelManager$showOverlayMessageMenu$1.b r103, MessageActionPanelManager$showOverlayMessageMenu$1.a r104) {
        Intrinsics.checkNotNullParameter(r100, "anchorView");
        Intrinsics.checkNotNullParameter(r102, "listView");
        Intrinsics.checkNotNullParameter(r104, "dependency");
        this.f415691a = r100;
        this.f415692b = r101;
        this.f415693c = r102;
        this.f415694d = r103;
        this.f415695e = r104;
        this.f415699i = true;
        int[] r105 = new int[2];
        this.f415703m = r105;
        this.f415704n = r102.getTranslationY();
        r102.getLocationOnScreen(r105);
        this.f415705o = r105[1];
        this.f415706p = true;
        r100.getLocationOnScreen(r105);
        this.f415707q = r105[1];
        this.f415709s = LazyKt.lazy(new MessageListAndPanelScrollCoordinator$minBottomOffset$2(this));
        this.f415710t = LazyKt.lazy(new MessageListAndPanelScrollCoordinator$minTopOffset$2(this));
        this.f415711u = LazyKt.lazy(new MessageListAndPanelScrollCoordinator$titleHeightToCheckLong$2(this));
        this.f415712v = LazyKt.lazy(new MessageListAndPanelScrollCoordinator$statusHeight$2(this));
        this.f415713w = new MessageListAndPanelScrollCoordinator$showSelectedWindowAction$1(this);
        this.f415714x = new MessageListAndPanelScrollCoordinator$hideSelectedWindowAction$1(this);
    }
}
