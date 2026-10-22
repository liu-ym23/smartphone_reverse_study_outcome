package com.bytedance.android.livesdk.ktvimpl.mv;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.Drawable;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.ktv.common.view.ContinuousSurfaceAdapterView;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.frame.AbsRecycleViewKWidget;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.widget.KtvStageWidget;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u0006J\b\u0010\u0005\u001a\u00020\u0004H\u0007¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/mv/KtvMvWidget;", "Lcom/bytedance/android/livesdk/ktvimpl/base/frame/AbsRecycleViewKWidget;", "Lcom/bytedance/android/livesdk/ktvimpl/mv/KtvMvViewModel;", "", "", "onResume", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvMvWidget extends AbsRecycleViewKWidget<KtvMvViewModel> {
    public static final /* synthetic */ int q = 0;
    public Integer h;
    public final Drawable i;
    public final SmoothEnterTextureView j;
    public final SmoothEnterSurfaceView k;
    public final boolean l;
    public View m;
    public final View n;
    public final lb0.b o;
    public com.bytedance.android.livesdk.ktvimpl.mv.c p;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ ViewGroup a;
        public final /* synthetic */ KtvMvWidget b;

        public b(ViewGroup r1, KtvMvWidget r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            int r0 = this.b.e.getWidth() / 12;
            if (r0 > 0) goto L6;
            r0 = 80;
        L6:
            if (KtvSettingHelper.z() == true) goto L11;
            ViewGroup r2 = this.a;
            View r4 = this.b.m;
            if (r4 != null) goto L10;
            Intrinsics.throwUninitializedPropertyAccessException("edgetView");
        L10:
            FrameLayout.LayoutParams r5 = new FrameLayout.LayoutParams(-1, r0);
            r5.gravity = 80;
            Unit r1 = Unit.INSTANCE;
            r2.addView(r4, r5);
        L11:
            this.a.addView(this.b.n, new ViewGroup.LayoutParams(-1, -1));
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

    public static final class c implements TextureView.SurfaceTextureListener {
        public final /* synthetic */ KtvMvWidget a;

        @Override // android.view.TextureView.SurfaceTextureListener
        public final boolean onSurfaceTextureDestroyed(SurfaceTexture r2) {
            Intrinsics.checkNotNullParameter(r2, "surface");
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureUpdated(SurfaceTexture r2) {
            Intrinsics.checkNotNullParameter(r2, "surface");
        }

        public c(KtvMvWidget r1) {
            this.a = r1;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureAvailable(SurfaceTexture r1, int r2, int r3) {
            Intrinsics.checkNotNullParameter(r1, "surface");
            KtvMvWidget r4 = this.a;
            int r5 = KtvMvWidget.q;
            r4.getClass();
            KtvMvViewModel r6 = (KtvMvViewModel) this.a.d;
            if (r6 == null) goto L6;
            r6.setMvSurface(new Surface(r1));
            return;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureSizeChanged(SurfaceTexture r1, int r2, int r3) {
            Intrinsics.checkNotNullParameter(r1, "surface");
            KtvMvWidget r4 = this.a;
            int r5 = KtvMvWidget.q;
            KtvMvViewModel r6 = (KtvMvViewModel) r4.d;
            if (r6 == null) goto L6;
            r6.setMvSurface(new Surface(r1));
            return;
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ KtvMvWidget a;

        public d(KtvMvWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            Boolean r4 = (Boolean) r3;
            KtvMvWidget r0 = this.a;
            int r1 = KtvMvWidget.q;
            KtvMvViewModel r2 = (KtvMvViewModel) r0.d;
            if (r2 != null) goto L5;
        L9:
            ViewGroup r5 = this.a.c;
            if (r5 != null) goto L12;
            return;
        L12:
            if (Intrinsics.areEqual(r4, Boolean.TRUE) == false) goto L14;
            int r6 = 8;
        L15:
            r5.setVisibility(r6);
            return;
        L14:
            r6 = 0;
            goto L15
        L5:
            if (r2.isCameraVideoShow() != true) goto L9;
            if (this.a.l == false) goto L9;
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.frame.AbsViewKWidget
    public final int d() {
        return 0;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.frame.AbsViewKWidget
    public final void c() {
        KtvMvViewModel r0 = (KtvMvViewModel) this.d;
        if (r0 == null) goto L7;
        NextLiveData<Integer> r1 = r0.getMvRegionShowState();
        if (r1 == null) goto L7;
        b(r1, new KtvMvWidget$bindData$1(this));
    L7:
        KtvMvViewModel r2 = (KtvMvViewModel) this.d;
        if (r2 == null) goto L10;
        r2.setThemeColorUpdateListener(new KtvMvWidget$bindData$2(this));
    L10:
        KtvMvViewModel r3 = (KtvMvViewModel) this.d;
        if (r3 == null) goto L16;
        NextLiveData<Boolean> r4 = r3.isShowDefaultMv();
        if (r4 == null) goto L17;
        b(r4, new KtvMvWidget$bindData$3(this));
        return;
    L17:
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.frame.AbsViewKWidget
    public final View e() {
        Context r0 = this.e.getContext();
        if (r0 != null) goto L6;
        return null;
    L6:
        FrameLayout r1 = new FrameLayout(r0);
        r1.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r1.setBackground(this.i);
        return r1;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.frame.AbsViewKWidget
    public final void f() {
        Context r0 = this.e.getContext();
        if (r0 != null) goto L5;
        return;
    L5:
        View r1 = new View(r0);
        Drawable r2 = this.o;
        Object r3 = null;
        if ((r2 instanceof lb0.b) == true) goto L8;
        r2 = null;
    L8:
        r1.setBackground(r2);
        r1.setVisibility(8);
        Unit r4 = Unit.INSTANCE;
        this.m = r1;
        this.j.setSurfaceTextureListener(new c(this));
        KtvMvViewModel r5 = (KtvMvViewModel) this.d;
        if (r5 == null) goto L11;
        r5.setRenderStartListener(new KtvMvWidget$initView$3(this));
    L11:
        KtvMvViewModel r6 = (KtvMvViewModel) this.d;
        if (r6 == null) goto L14;
        r6.bindMultiScenePreviewStatistics(null);
    L14:
        ViewGroup r7 = this.c;
        if (r7 == null) goto L17;
        r7.addView(this.j, new ViewGroup.LayoutParams(-1, -1));
        r7.post(new b(r7, this));
    L17:
        j(this.p);
        Integer r8 = this.h;
        if (r8 != null) goto L21;
    L22:
        ViewGroup r9 = this.c;
        if (r9 == null) goto L25;
        r9.setVisibility(0);
    L25:
        SmoothEnterTextureView r10 = this.j;
        if ((r10 instanceof SmoothEnterSurfaceView) == false) goto L29;
        r3 = r10;
    L29:
        SmoothEnterSurfaceView r11 = (SmoothEnterSurfaceView) r3;
        if (r11 == null) goto L32;
        r11.setBusinessVisible(0);
    L32:
        SmoothEnterTextureView r12 = this.j;
        if (r12 == null) goto L35;
        r12.setVisibility(0);
    L35:
        l();
    L36:
        this.h = 0;
        return;
    L21:
        if (r8.intValue() == 0) goto L36;
        goto L22
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.frame.AbsLifeCycleKWidget, com.bytedance.android.livesdk.ktvimpl.base.frame.IKWidget
    public final ViewModelProvider.Factory getViewModelFactory() {
        return new AnonymousClass1(this);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.frame.AbsRecycleViewKWidget
    public final boolean i() {
        KtvMvViewModel r0 = (KtvMvViewModel) this.d;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isCleared() != true) goto L7;
        return true;
    }

    public final void l() {
        SmoothEnterTextureView r0 = this.j;
        if (r0 == null) goto L5;
        Integer r1 = Integer.valueOf(r0.getVisibility());
    L7:
        if (r1.intValue() != 0) goto L9;
        boolean r2 = true;
    L11:
        if (r2 == true) goto L16;
        View r3 = this.m;
        if (r3 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("edgetView");
    L15:
        r3.setVisibility(8);
        return;
    L16:
        View r4 = this.m;
        if (r4 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("edgetView");
    L19:
        r4.setVisibility(0);
        return;
    L9:
        r2 = false;
        goto L11
    L5:
        r1 = null;
        goto L7
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        SmoothEnterSurfaceView r0 = this.k;
        if (((ContinuousSurfaceAdapterView) r0).a == false) goto L6;
        r0.attachFromWindow("widget resume");
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.frame.AbsRecycleViewKWidget
    public final void j(com.bytedance.android.livesdk.ktvimpl.base.frame.c r3) {
        Intrinsics.checkNotNullParameter(r3, "outFuncProvider");
        com.bytedance.android.livesdk.ktvimpl.mv.c r4 = (com.bytedance.android.livesdk.ktvimpl.mv.c) r3;
        this.p = r4;
        KtvContext r5 = r4.b();
        if (r5 == null) goto L7;
        MutableLiveData<Boolean> r6 = r5.getRealOpenStateData();
        if (r6 == null) goto L7;
        r6.observe(this.a, new d(this));
    L7:
        KtvMvViewModel r7 = (KtvMvViewModel) this.d;
        if (r7 == null) goto L11;
        r7.onUpdateRunContext(this.p);
        return;
    }

    /* JADX WARN: Type inference failed for: r3v4, types: [android.view.SurfaceView, com.bytedance.android.livesdk.ktvimpl.mv.SmoothEnterSurfaceView] */
    public KtvMvWidget(KtvStageWidget r3, ViewGroup r4, com.bytedance.android.livesdk.ktvimpl.mv.c r5) {
        Intrinsics.checkNotNullParameter(r3, "owner");
        Intrinsics.checkNotNullParameter(r4, "containerView");
        Intrinsics.checkNotNullParameter(r5, "mvRunContext");
        super(r3, r4, r5);
        this.p = r5;
        this.i = r4.getContext().getDrawable(2131252117);
        SmoothEnterTextureView r6 = new SmoothEnterTextureView(r4.getContext(), null);
        r6.setBgInfock(new KtvMvWidget$$special$$inlined$apply$lambda$1(this));
        Unit r7 = Unit.INSTANCE;
        this.j = r6;
        ?? r8 = new SmoothEnterSurfaceView(r4.getContext(), null);
        r8.setZOrderOnTop(true);
        r8.setZOrderMediaOverlay(true);
        r8.getHolder().setFormat(-2);
        r8.setSmoothEnterCallback(new j(this));
        this.k = r8;
        this.l = ((Boolean) vm2.h.l4.getValue(null, vm2.h.a[270(0x10e, float:3.78E-43)])).booleanValue();
        View r9 = new View(r4.getContext());
        r9.setBackgroundColor(ColorProtector.parseColor("#81000000"));
        this.n = r9;
        lb0.b r10 = new lb0.b();
        r10.c = null;
        r10.d = null;
        this.o = r10;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.frame.AbsRecycleViewKWidget
    public final void k(LifecycleOwner r2, ViewGroup r3, com.bytedance.android.livesdk.ktvimpl.base.frame.c r4, Function1<? super Boolean, Unit> r5) {
        Intrinsics.checkNotNullParameter(r3, "newContainer");
        super.k(r2, r3, r4, r5);
        KtvMvViewModel r6 = (KtvMvViewModel) this.d;
        if (r6 == null) goto L6;
        r6.onReload(this.g);
        return;
    }
}
