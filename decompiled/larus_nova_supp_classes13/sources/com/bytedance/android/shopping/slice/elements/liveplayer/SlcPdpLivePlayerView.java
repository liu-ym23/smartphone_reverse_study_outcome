package com.bytedance.android.shopping.slice.elements.liveplayer;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.adapter.api.model.ECLiveMode;
import com.bytedance.android.ec.adapter.api.player.IECLivePlayerClient;
import com.bytedance.android.ec.adapter.api.player.IECPlayerViewService;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.ec.core.utils.UIUtils;
import com.bytedance.android.ec.core.utils.y0;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ecom.arch.slice.render.widget.roundcorner.SlcRoundFrameLayout;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerView;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.services.apm.api.EnsureManager;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H\u0003J\b\u0010\u0005\u001a\u00020\u0003H\u0003J\b\u0010\u0006\u001a\u00020\u0003H\u0003¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/shopping/slice/elements/liveplayer/SlcPdpLivePlayerView;", "Lcom/bytedance/android/ecom/arch/slice/render/widget/roundcorner/SlcRoundFrameLayout;", "Landroidx/lifecycle/LifecycleObserver;", "", "onPageStop", "onPageStart", "onPageDestroy", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SlcPdpLivePlayerView extends SlcRoundFrameLayout implements LifecycleObserver {
    public static final /* synthetic */ int g = 0;
    public final ECDraweeView c;
    public le.b d;
    public com.bytedance.android.shopping.slice.elements.liveplayer.a e;
    public final h f;

    public static final class a implements View.OnAttachStateChangeListener {
        public final /* synthetic */ SlcPdpLivePlayerView a;

        public a(SlcPdpLivePlayerView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r2) {
            Intrinsics.checkNotNullParameter(r2, "v");
            SlcPdpLivePlayerView r3 = this.a;
            int r0 = SlcPdpLivePlayerView.g;
            r3.e("onAttach");
            Lazy r4 = UIUtils.a;
            UIUtils.c().post(this.a.f);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r2) {
            Intrinsics.checkNotNullParameter(r2, "v");
            SlcPdpLivePlayerView r3 = this.a;
            int r0 = SlcPdpLivePlayerView.g;
            r3.e("onDetach");
            Lazy r4 = UIUtils.a;
            UIUtils.c().removeCallbacks(this.a.f);
            this.a.h();
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ SlcPdpLivePlayerView a;

        public b(SlcPdpLivePlayerView r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            Boolean r3 = (Boolean) r2;
            if (r3 != null) goto L5;
            return;
        L5:
            if (r3.booleanValue() == false) goto L9;
            SlcPdpLivePlayerView r4 = this.a;
            int r0 = SlcPdpLivePlayerView.g;
            r4.c.setVisibility(8);
            return;
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ SlcPdpLivePlayerView a;

        public c(SlcPdpLivePlayerView r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            Boolean r3 = (Boolean) r2;
            if (r3 != null) goto L5;
            return;
        L5:
            if (r3.booleanValue() == false) goto L9;
            this.a.c.setVisibility(0);
            return;
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ SlcPdpLivePlayerView a;

        public d(SlcPdpLivePlayerView r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            Boolean r3 = (Boolean) r2;
            if (r3 != null) goto L5;
            return;
        L5:
            if (r3.booleanValue() == false) goto L9;
            this.a.c.setVisibility(0);
            return;
        }
    }

    public static final class e<T> implements Observer {
        public final /* synthetic */ SlcPdpLivePlayerView a;

        public e(SlcPdpLivePlayerView r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            Boolean r3 = (Boolean) r2;
            if (r3 != null) goto L5;
            return;
        L5:
            if (r3.booleanValue() == false) goto L9;
            this.a.c.setVisibility(0);
            return;
        }
    }

    public static final class f<T> implements Observer {
        public final /* synthetic */ SlcPdpLivePlayerView a;

        public f(SlcPdpLivePlayerView r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            Boolean r3 = (Boolean) r2;
            if (r3 != null) goto L5;
            return;
        L5:
            if (r3.booleanValue() == false) goto L9;
            this.a.c.setVisibility(0);
            return;
        }
    }

    public static final class g<T> implements Observer {
        public final /* synthetic */ SlcPdpLivePlayerView a;

        public g(SlcPdpLivePlayerView r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            String r3 = (String) r2;
            this.a.c.setVisibility(0);
        }
    }

    public static final class h implements Runnable {
        public final /* synthetic */ SlcPdpLivePlayerView a;

        @Override // java.lang.Runnable
        public final void run() {
            this.a.g();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public h(SlcPdpLivePlayerView r1) {
            this.a = r1;
        }
    }

    private static /* synthetic */ void getStartPlayAction$annotations() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private final void onPageDestroy() {
        e("onPageDestroy");
        le.b r0 = this.d;
        if (r0 == null) goto L7;
        IECLivePlayerClient r1 = r0.a();
        if (r1 == null) goto L7;
        r1.release();
    L7:
        this.d = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    private final void onPageStart() {
        e("onPageStart");
        if (ViewCompat.isAttachedToWindow(this) == false) goto L6;
        g();
        return;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    private final void onPageStop() {
        e("onPageStop");
        h();
    }

    public final void f() {
        le.b r0 = this.d;
        if (r0 == null) goto L8;
        IECLivePlayerClient r1 = r0.a();
        if (r1 == null) goto L9;
        td.e r2 = r1.getEventHub();
        r2.getFirstFrame().observe(r1.getLifecycleOwner(), new b(this));
        r2.getStopped().observe(r1.getLifecycleOwner(), new c(this));
        r2.getReleased().observe(r1.getLifecycleOwner(), new d(this));
        r2.getPlayComplete().observe(r1.getLifecycleOwner(), new e(this));
        r2.getLiveEnd().observe(r1.getLifecycleOwner(), new f(this));
        r2.getPlayerMediaError().observe(r1.getLifecycleOwner(), new g(this));
        return;
    L9:
        return;
    }

    public final void g() {
        e("startPlay");
        le.b r0 = this.d;
        if (r0 != null) goto L7;
        com.bytedance.android.shopping.slice.elements.liveplayer.a r1 = this.e;
        if (r1 == null) goto L14;
        c(r1);
        return;
    L14:
        return;
    L7:
        com.bytedance.android.shopping.slice.elements.liveplayer.a r2 = this.e;
        if (r2 == null) goto L16;
        if (r0 == null) goto L11;
        IECLivePlayerClient r3 = r0.a();
    L12:
        i(r2, r3);
        return;
    L11:
        r3 = null;
        goto L12
    }

    public final void h() {
        e("stopPlay");
        le.b r0 = this.d;
        if (r0 == null) goto L8;
        IECLivePlayerClient r1 = r0.a();
        if (r1 == null) goto L9;
        r1.stop();
        return;
    L9:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b() {
        int r0 = getWidth();
        if (r0 != 0) goto L5;
        return;
    L5:
        int r1 = (int) ((r0 * 16.0f) / 9);
        le.b r2 = this.d;
        if (r2 == null) goto L17;
        LivePlayerView r3 = r2.getView();
        if (r3 == null) goto L18;
        ViewGroup.LayoutParams r4 = r3.getLayoutParams();
        if ((r4 instanceof FrameLayout.LayoutParams) == true) goto L12;
        r4 = null;
    L12:
        FrameLayout.LayoutParams r5 = (FrameLayout.LayoutParams) r4;
        if (r5 != null) goto L15;
        r5 = new FrameLayout.LayoutParams(r0, r1);
    L15:
        r5.gravity = 17;
        r5.width = r0;
        r5.height = r1;
        Unit r6 = Unit.INSTANCE;
        r3.setLayoutParams(r5);
        return;
    L18:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c(com.bytedance.android.shopping.slice.elements.liveplayer.a r15) {
        if (y0.a() == true) goto L5;
        return;
    L5:
        this.c.setVisibility(0);
        String r0 = r15.b;
        le.b r2 = null;
        if (r0 == null) goto L30;
        Long r1 = StringsKt.toLongOrNull(r0);
        if (r1 == null) goto L30;
        long r3 = r1.longValue();
        int r4 = ECSdk.a;
        IAdapterService r5 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r5 == null) goto L14;
        IECPlayerViewService r6 = r5.getPlayerViewService();
        if (r6 == null) goto L14;
        le.b r7 = IECPlayerViewService.a.a(r6, getContext(), null, 0, String.valueOf(r3), "ec_detail_shop_live_player", false, false, 384);
    L15:
        if (r7 == null) goto L30;
        com.bytedance.android.ec.adapter.impl.adapters.reverse.player.d r8 = (com.bytedance.android.ec.adapter.impl.adapters.reverse.player.d) r7;
        r8.setScaleType(2);
        r8.b.setVisibility(0);
        if (r8.a().isPlaying() == true) goto L44;
        IECLivePlayerClient r9 = r8.a();     // Catch: Exception -> L27
    L29:
        i(r15, r9);
    L31:
        if (r7 == null) goto L36;
        this.d = r7;
        if (getChildCount() <= 1) goto L35;
        removeViewAt(getChildCount() - 1);
    L35:
        addView(((com.bytedance.android.ec.adapter.impl.adapters.reverse.player.d) r7).b);
        b();
        r2 = r7;
    L36:
        if (r2 != null) goto L39;
        return;
    L39:
        if (((com.bytedance.android.ec.adapter.impl.adapters.reverse.player.d) r2).a().isPlaying() == false) goto L46;
        f();
        this.c.setVisibility(8);
        return;
    L46:
        return;
    L27:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e);
        r9 = null;
        goto L29
    L44:
        IECLivePlayerClient r16 = r8.a();     // Catch: Exception -> L21
    L23:
        if (r16 == null) goto L31;
        r16.resumePlay();
    L21:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e);
        r16 = null;
    L14:
        r7 = null;
    L30:
        r7 = null;
        goto L31
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void d(com.bytedance.android.shopping.slice.elements.liveplayer.a r8) {
        if (Intrinsics.areEqual(r8, this.e) == false) goto L5;
        return;
    L5:
        this.e = r8;
        String r2 = r8.c;
        if (r2 == null) goto L10;
        h0.e(this.c, r2, new r("ec_detail", "ec_store_live_cover_image"), null, null, 120);
        setVisibility(0);
    L10:
        if (ViewCompat.isAttachedToWindow(this) == false) goto L13;
        c(r8);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean dispatchHoverEvent(MotionEvent r1) {
        return super/*android.widget.FrameLayout*/.dispatchHoverEvent(r1);
    }

    public final void e(String r2) {
        dm.a.a("SlcPdpLivePlayerView").i(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SlcPdpLivePlayerView(Context r10, LifecycleOwner r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, null, 6, 0);
        ECDraweeView r0 = new ECDraweeView(r10, null, 0, 6, null);
        GenericDraweeHierarchy r12 = r0.getHierarchy();
        if (r12 == null) goto L5;
        r12.setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
    L5:
        addView(r0, new ViewGroup.LayoutParams(-1, -1));
        Unit r13 = Unit.INSTANCE;
        this.c = r0;
        this.f = new h(this);
        if (r11 == null) goto L10;
        Lifecycle r14 = r11.getLifecycle();
        if (r14 == null) goto L10;
        r14.addObserver(this);
    L10:
        addOnAttachStateChangeListener(new a(this));
    }

    public final void i(com.bytedance.android.shopping.slice.elements.liveplayer.a r4, IECLivePlayerClient r5) {
        le.a.a r0 = new le.a.a();
        String r1 = r4.a;
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        Intrinsics.checkNotNullParameter(r1, "data");
        r0.a = r1;
        String r6 = r4.d;
        if (r6 == null) goto L8;
        Intrinsics.checkNotNullParameter(r6, "resolution");
        r0.b = r6;
    L8:
        ECLiveMode r7 = ECLiveMode.MEDIA;
        Intrinsics.checkNotNullParameter(r7, "streamType");
        r0.c = r7;
        r0.h = true;
        r0.f = true;
        le.a r8 = r0.a();
        if (r5 == null) goto L12;
        r5.stream(r8, new SlcPdpLivePlayerView$stream$1(this));
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super/*android.widget.FrameLayout*/.onSizeChanged(r1, r2, r3, r4);
        b();
    }
}
