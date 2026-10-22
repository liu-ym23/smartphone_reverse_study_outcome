package com.bytedance.android.livesdk.ktvimpl.base.lyrics.widget;

import android.graphics.Typeface;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.canvasgl.glview.GLContinuousSurfaceAdapterView;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.ktv.common.util.e;
import com.bytedance.android.live.ktv.common.util.k;
import com.bytedance.android.live.ktv.common.util.u;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.frame.AbsViewKWidget;
import com.bytedance.android.livesdk.ktvimpl.base.lyrics.DotCountDownView;
import com.bytedance.android.livesdk.ktvimpl.base.lyrics.KtvMvLyricPresenter;
import com.bytedance.android.livesdk.ktvimpl.base.lyrics.MvLyricView;
import com.bytedance.android.livesdk.ktvimpl.base.lyrics.MvLyricViewV2;
import com.bytedance.android.livesdk.ktvimpl.base.lyrics.gl.MvLyricGLView;
import com.bytedance.android.livesdk.ktvimpl.base.lyrics.gl.MvLyricSurfaceView;
import com.bytedance.android.livesdk.ktvimpl.base.lyrics.viewModel.MvLyricViewModel;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomViewModel;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import vm2.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003J\b\u0010\u0005\u001a\u00020\u0004H\u0007¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/lyrics/widget/MvLyricWidget;", "Lcom/bytedance/android/livesdk/ktvimpl/base/frame/AbsViewKWidget;", "Lcom/bytedance/android/livesdk/ktvimpl/base/lyrics/viewModel/MvLyricViewModel;", "Lcom/bytedance/android/livesdk/ktvimpl/base/lyrics/b;", "", "onResume", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MvLyricWidget extends AbsViewKWidget<MvLyricViewModel> implements com.bytedance.android.livesdk.ktvimpl.base.lyrics.b {
    public final boolean g;
    public boolean h;
    public final com.bytedance.android.livesdk.ktvimpl.base.lyrics.a i;
    public jb0.b j;
    public final KtvMvLyricPresenter k;
    public final Handler l;
    public final HashSet<String> m;
    public final TextView n;
    public final TextView o;
    public final DotCountDownView p;
    public final TextView q;
    public Function1<? super Long, Unit> r;
    public final LinearLayout s;
    public final int t;
    public final int u;
    public boolean v;
    public final a w;
    public final b x;
    public final com.bytedance.android.livesdk.ktvimpl.base.lyrics.viewModel.a y;
    public final KtvRoomViewModel z;

    public static final class a implements tb0.a {
        public final /* synthetic */ MvLyricWidget a;

        public final void onBizDestory() {
            jb0.b r0 = this.a.j;
            if (r0 == null) goto L6;
            r0.b = true;
            return;
        }

        public final void onBizEnterRoom() {
            this.a.j();
            com.bytedance.android.livesdk.ktvimpl.base.lyrics.a r0 = this.a.i;
            u r2 = null;
            if ((r0 instanceof u) == true) goto L5;
            r0 = null;
        L5:
            u r1 = (u) r0;
            if (r1 == null) goto L8;
            r1.onVHSelected();
        L8:
            com.bytedance.android.livesdk.ktvimpl.base.lyrics.a r3 = this.a.i;
            if ((r3 instanceof u) == true) goto L11;
            r3 = null;
        L11:
            u r4 = (u) r3;
            if (r4 == null) goto L14;
            r4.onVHResume();
        L14:
            u r5 = this.a.i;
            if ((r5 instanceof u) == false) goto L18;
            r2 = r5;
        L18:
            u r6 = r2;
            if (r6 == null) goto L22;
            r6.attachFromWindow("onBizEnterKtvRoom");
            return;
        }

        public final void onBizHide() {
            com.bytedance.android.livesdk.ktvimpl.base.lyrics.a r0 = this.a.i;
            u r2 = null;
            if ((r0 instanceof u) == true) goto L5;
            r0 = null;
        L5:
            u r1 = (u) r0;
            if (r1 == null) goto L8;
            r1.onVHUnSelected();
        L8:
            u r3 = this.a.i;
            if ((r3 instanceof u) == false) goto L12;
            r2 = r3;
        L12:
            u r4 = r2;
            if (r4 == null) goto L16;
            r4.detachFromWindow("onBizHide");
            return;
        }

        public final void onBizLeaveRoom() {
            this.a.j();
        }

        public final void onBizShow() {
            com.bytedance.android.livesdk.ktvimpl.base.lyrics.a r0 = this.a.i;
            u r2 = null;
            if ((r0 instanceof u) == true) goto L5;
            r0 = null;
        L5:
            u r1 = (u) r0;
            if (r1 == null) goto L8;
            r1.onVHSelected();
        L8:
            u r3 = this.a.i;
            if ((r3 instanceof u) == false) goto L12;
            r2 = r3;
        L12:
            u r4 = r2;
            if (r4 == null) goto L16;
            r4.attachFromWindow("onBizShow");
            return;
        }

        public a(MvLyricWidget r1) {
            this.a = r1;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ MvLyricWidget a;

        public b(MvLyricWidget r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.q.setVisibility(8);     // Catch: Throwable -> L4
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
        public final /* synthetic */ com.bytedance.android.live.ktv.common.util.c a;

        public c(com.bytedance.android.live.ktv.common.util.c r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Function2 r0 = this.a.getOneDrawCallback();     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            Unit r1 = (Unit) r0.invoke(Boolean.TRUE, Long.valueOf(System.currentTimeMillis()));     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.frame.AbsViewKWidget
    public final void f() {
        LinearLayout r0 = this.s;
        r0.setOrientation(1);
        ViewGroup r1 = this.c;
        if (r1 == null) goto L5;
        r1.addView(r0, new ViewGroup.LayoutParams(-1, -1));
    L5:
        TextView r2 = this.n;
        LinearLayout.LayoutParams r3 = new LinearLayout.LayoutParams(-1, 0);
        r3.gravity = 17;
        r3.weight = 1.0f;
        Unit r7 = Unit.INSTANCE;
        r0.addView(r2, r3);
        this.n.setTextColor(ColorProtector.parseColor("#ffffff"));
        this.o.setTextColor(ColorProtector.parseColor("#ffffff"));
        this.n.setTypeface(Typeface.DEFAULT_BOLD);
        this.o.setTypeface(Typeface.DEFAULT_BOLD);
        this.n.setTextSize(15.0f);
        this.o.setTextSize(15.0f);
        this.n.setGravity(17);
        this.o.setGravity(17);
        TextView r4 = this.o;
        LinearLayout.LayoutParams r5 = new LinearLayout.LayoutParams(-1, 0);
        r5.gravity = 17;
        r5.weight = 1.0f;
        r0.addView(r4, r5);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.frame.AbsLifeCycleKWidget, com.bytedance.android.livesdk.ktvimpl.base.frame.IKWidget
    public final ViewModelProvider.Factory getViewModelFactory() {
        return new AnonymousClass1(this);
    }

    public final void i() {
        MvLyricViewModel r0 = (MvLyricViewModel) this.d;
        if (r0 == null) goto L6;
        r0.releaseLyricRes();
    L6:
        if (KtvSettingHelper.r().booleanValue() == false) goto L32;
        KtvContext r1 = this.y.b();
        if (r1 == null) goto L12;
        e r2 = r1.getBizLcMager();
        if (r2 == null) goto L12;
        r2.c(this.w);
    L12:
        KtvMvLyricPresenter r3 = this.k;
        ViewParent r4 = null;
        r3.m = null;
        r3.e();
        u r5 = this.i;
        if ((r5 instanceof u) == true) goto L15;
    L23:
        ViewParent r6 = this.i.asView().getParent();
        if (r6 == null) goto L32;
        if ((r6 instanceof ViewGroup) == false) goto L29;
        r4 = r6;
    L29:
        ViewGroup r7 = (ViewGroup) r4;
        if (r7 == null) goto L32;
        r7.removeView(this.i.asView());
        goto L32
    L15:
        if (r5 == null) goto L22;
        r5.onVHUnBind();
        u r8 = this.i;
        if (r8 == null) goto L20;
        r8.detachFromWindow("onDetached");
        goto L23
    L20:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.ktv.common.util.SurfaceViewAdapter");
    L22:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.ktv.common.util.SurfaceViewAdapter");
    L32:
        this.i.asView().setVisibility(8);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.b
    public final boolean isFinishDrawLastLine() {
        return this.i.isFinishDrawLastLine();
    }

    public final void j() {
        com.bytedance.android.livesdk.ktvimpl.base.lyrics.a r0 = this.i;
        if ((r0 instanceof com.bytedance.android.live.ktv.common.util.c) == true) goto L5;
        r0 = null;
    L5:
        com.bytedance.android.live.ktv.common.util.c r1 = (com.bytedance.android.live.ktv.common.util.c) r0;
        if (r1 == null) goto L14;
        KtvContext r2 = this.y.b();
        if (r2 == null) goto L12;
        k r3 = r2.getStatisticHelper();
        if (r3 == null) goto L12;
        r3.b(r1);
    L12:
        this.e.postDelayed(new c(r1), h.A());
        return;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        com.bytedance.android.livesdk.ktvimpl.base.lyrics.a r0 = this.i;
        if ((r0 instanceof u) == true) goto L5;
        r0 = null;
    L5:
        u r1 = (u) r0;
        if (r1 != null) goto L8;
        return;
    L8:
        if (r1.isVHSelected() == true) goto L10;
        return;
    L10:
        if (((Boolean) KtvSettingHelper.E0.getValue()).booleanValue() == true) goto L12;
    L13:
        r1.attachFromWindow("widget resume");
        return;
    L12:
        if (r1.isVHPaused() == false) goto L13;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.frame.AbsLifeCycleKWidget, com.bytedance.android.livesdk.ktvimpl.base.frame.IKWidget
    public final void onUnLoad() {
        IKtvService r0 = jc1.k.f(IKtvService.class);
        String r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.getEnterRoomType();
    L7:
        if (Intrinsics.areEqual(r2, "type_no_feed") == false) goto L15;
        StringBuilder r3 = new StringBuilder("handleLyricSmoothExitRoom ;; enterRoomTypeEvent == ");
        IKtvService r4 = jc1.k.f(IKtvService.class);
        if (r4 == null) goto L11;
        r1 = r4.getEnterRoomType();
    L11:
        r3.append(r1);
        ALogger.i("alog_ktv_smooth_enter_room", r3.toString());
        IKtvService r5 = jc1.k.f(IKtvService.class);
        if (r5 == null) goto L14;
        r5.saveEnterRoomType("");
    L14:
        boolean r6 = true;
    L16:
        if (r6 == false) goto L18;
        return;
    L18:
        this.i.asView().setVisibility(8);
        this.l.removeCallbacks(this.x);
        MvLyricViewModel r7 = (MvLyricViewModel) this.d;
        if (r7 == null) goto L21;
        r7.releaseLyricRes();
    L21:
        KtvContext r8 = this.y.b();
        if (r8 == null) goto L26;
        e r9 = r8.getBizLcMager();
        if (r9 == null) goto L26;
        r9.c(this.w);
    L26:
        super.onUnLoad();
        return;
    L15:
        r6 = false;
        goto L16
    L5:
        r2 = null;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.frame.AbsViewKWidget
    public final View e() {
        j();
        com.bytedance.android.livesdk.ktvimpl.base.lyrics.a r0 = this.i;
        if ((r0 instanceof u) == true) goto L5;
        r0 = null;
    L5:
        u r1 = (u) r0;
        if (r1 != null) goto L8;
    L22:
        FrameLayout r2 = new FrameLayout(this.e.getContext());
        r2.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        if (this.y.h() == false) goto L25;
        final DotCountDownView r3 = this.p;
        r3.setVisibility(8);
        this.k.m = new MvLyricWidget$initContentView$$inlined$apply$lambda$1(r3, this);
        Unit r4 = Unit.INSTANCE;
        r2.addView(r3, new FrameLayout.LayoutParams(this.u, this.t));
        View r5 = this.i.asView();
        FrameLayout.LayoutParams r6 = new FrameLayout.LayoutParams(-1, -1);
        r6.topMargin = this.t;
        r2.addView(r5, r6);
        r2.addView(this.q, new ViewGroup.LayoutParams(-1, -1));
    L26:
        return r2;
    L25:
        this.i.getDisplayConfig();
        r2.addView(this.i.asView(), new FrameLayout.LayoutParams(-1, -1));
        r2.addView(this.q, new ViewGroup.LayoutParams(-1, -1));
        goto L26
    L8:
        if (this.v == false) goto L10;
        r1.onVHSelected();
    L11:
        com.bytedance.android.livesdk.ktvimpl.base.lyrics.a r7 = this.i;
        if ((r7 instanceof GLContinuousSurfaceAdapterView) == true) goto L14;
        r7 = null;
    L14:
        GLContinuousSurfaceAdapterView r8 = (GLContinuousSurfaceAdapterView) r7;
        if (r8 == null) goto L17;
        jb0.b r9 = new jb0.b(r8, ((Number) h.q2.getValue(null, h.a[171(0xab, float:2.4E-43)])).intValue());
        this.j = r9;
        r9.b = false;
        r9.a();
    L17:
        KtvContext r10 = this.y.b();
        if (r10 == null) goto L22;
        e r11 = r10.getBizLcMager();
        if (r11 == null) goto L22;
        r11.a(this.w);
        goto L22
    L10:
        r1.onVHUnSelected();
        goto L11
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.frame.AbsViewKWidget
    public final void h() {
        super.h();
        if (this.h == true) goto L5;
    L7:
        this.h = true;
        MvLyricViewModel r0 = (MvLyricViewModel) this.d;
        if (r0 == null) goto L10;
        r0.setLyricControlPresenter(this.k);
    L10:
        MvLyricViewModel r1 = (MvLyricViewModel) this.d;
        if (r1 == null) goto L15;
        MutableLiveData<String[]> r2 = r1.getLyricPlaceHolderData();
        if (r2 == null) goto L15;
        b(r2, new MvLyricWidget$bindobserver$1(this));
    L15:
        KtvRoomViewModel r3 = this.z;
        if (r3 == null) goto L26;
        NextLiveData<com.bytedance.android.livesdk.ktvimpl.base.sei.k> r4 = r3.getFeedSeiModel();
        if (r4 == null) goto L27;
        com.bytedance.android.livesdk.ktvimpl.base.sei.k r5 = (com.bytedance.android.livesdk.ktvimpl.base.sei.k) r4.getValue();
        if (r5 == null) goto L29;
        MvLyricViewModel r6 = (MvLyricViewModel) this.d;
        if (r6 == null) goto L28;
        r6.handleLyricSei(r5);
        return;
    L28:
        return;
    L29:
        return;
    L27:
        return;
    L26:
        return;
    L5:
        if (KtvSettingHelper.w() == false) goto L7;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.b
    public final void a(Function1<? super Long, Unit> r1) {
        this.r = r1;
    }

    public MvLyricWidget(LifecycleOwner r4, ViewGroup r5, com.bytedance.android.livesdk.ktvimpl.base.lyrics.viewModel.a r6, KtvRoomViewModel r7) {
        Intrinsics.checkNotNullParameter(r4, "owner");
        Intrinsics.checkNotNullParameter(r5, "containerView");
        Intrinsics.checkNotNullParameter(r6, "lyricContext");
        super(r4, r5, r6);
        this.y = r6;
        this.z = r7;
        this.g = true;
        if (KtvSettingHelper.z() == false) goto L13;
        if (((Boolean) KtvSettingHelper.Q0.getValue()).booleanValue() == false) goto L13;
        if (Build.VERSION.SDK_INT >= 26) goto L9;
    L11:
        com.bytedance.android.livesdk.ktvimpl.base.lyrics.a r8 = new MvLyricGLView(r5.getContext());
    L16:
        this.i = r8;
        this.k = new KtvMvLyricPresenter(r8, r6, new MvLyricWidget$lyricPresenter$1(this));
        this.l = new Handler(Looper.getMainLooper());
        HashSet<String> r9 = new HashSet();
        r9.add(s1.B(2131918536));
        r9.add(s1.B(2131918554));
        Unit r10 = Unit.INSTANCE;
        this.m = r9;
        this.n = new TextView(r5.getContext());
        this.o = new TextView(r5.getContext());
        this.p = new DotCountDownView(r5.getContext(), null);
        TextView r11 = new TextView(r5.getContext());
        r11.setTextColor(ColorProtector.parseColor("#ffffff"));
        r11.setTextSize(15.0f);
        r11.setTypeface(Typeface.DEFAULT_BOLD);
        r11.setGravity(16);
        r11.setVisibility(8);
        this.q = r11;
        LinearLayout r12 = new LinearLayout(r5.getContext());
        r12.setOrientation(1);
        ViewGroup r13 = this.c;
        if (r13 == null) goto L19;
        r13.addView(r12, new ViewGroup.LayoutParams(-1, -1));
    L19:
        this.s = r12;
        this.t = UtilityKotlinExtentionsKt.i(15);
        this.u = UtilityKotlinExtentionsKt.i(60);
        this.w = new a(this);
        this.x = new b(this);
        return;
    L9:
        if (((Boolean) h.S2.getValue(null, h.a[199(0xc7, float:2.79E-43)])).booleanValue() == false) goto L11;
        r8 = new MvLyricSurfaceView(r5.getContext(), null);
    L13:
        if (((Boolean) KtvSettingHelper.F0.getValue()).booleanValue() == false) goto L15;
        r8 = new MvLyricViewV2(this.e.getContext(), null);
        goto L16
    L15:
        r8 = new MvLyricView(this.e.getContext(), null);
        goto L16
    }
}
