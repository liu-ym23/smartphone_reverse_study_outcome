package com.bytedance.android.shopping.store.home.presenter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.store.common.headlive.StoreV3LiveRoomVO;
import com.bytedance.android.livesdk.ec.adapter.api.FloatWindowState;
import com.bytedance.android.livesdk.ec.adapter.api.Scene;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.services.apm.api.EnsureManager;
import com.gyf.barlibrary.ImmersionBar;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\bJ\b\u0010\u0004\u001a\u00020\u0003H\u0007J\b\u0010\u0005\u001a\u00020\u0003H\u0007J\b\u0010\u0006\u001a\u00020\u0003H\u0007J\b\u0010\u0007\u001a\u00020\u0003H\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/store/home/presenter/ECShopCroppedStyleRootPresenterV2;", "Lcom/bytedance/android/shopping/store/home/presenter/ECShopBasePresenter;", "Landroidx/lifecycle/LifecycleObserver;", "", "onResume", "onPause", "onStop", "onDestroy", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShopCroppedStyleRootPresenterV2 extends ECShopBasePresenter implements LifecycleObserver {
    public static final /* synthetic */ int H = 0;
    public ViewGroup A;
    public View B;
    public boolean C;
    public ImmersionBar D;
    public Boolean E;
    public ECStoreAwemeFeedVideoZoomController F;
    public View G;
    public final s83.d u;
    public Float v;
    public CoordinatorLayout w;
    public View x;
    public ViewGroup y;
    public View z;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ ECShopCroppedStyleRootPresenterV2 a;

        public c(ECShopCroppedStyleRootPresenterV2 r1) {
            this.a = r1;
        }

        public final void onChanged(Object r8) {
            com.bytedance.android.shopping.store.home.entity.n r9 = (com.bytedance.android.shopping.store.home.entity.n) r8;
            ECShopCroppedStyleRootPresenterV2 r0 = this.a;
            r0.getClass();
            int r1 = com.bytedance.android.shopping.store.home.p.a;
            if (r0.U() == false) goto L6;
            ((Number) r0.q.getValue()).intValue();
            r0.h0();
            r0.f0();
        L16:
            ECShopCroppedStyleRootPresenterV2 r2 = this.a;
            r2.getClass();
            com.bytedance.android.shopping.store.home.entity.p r10 = r9.h;
            if (r10 == null) goto L25;
            Double r11 = r10.b();
            if (r11 == null) goto L26;
            int r12 = Color.argb((int) (255 * r11.doubleValue()), 0, 0, 0);
            View r3 = r2.G;
            if (r3 != null) goto L23;
            Intrinsics.throwUninitializedPropertyAccessException("rootView");
        L23:
            r3.setBackgroundColor(r12);
            return;
        L26:
            return;
        L25:
            return;
        L6:
            if (r0.E() == false) goto L9;
            ((Number) r0.o.getValue()).intValue();
            r0.f0();
            goto L16
        L9:
            if (r0.I() == true) goto L11;
        L13:
            boolean r4 = false;
        L14:
            if (r4 == false) goto L16;
            ((Number) r0.p.getValue()).intValue();
            r0.f0();
            goto L16
        L11:
            if (r0.U() == true) goto L13;
            r4 = true;
            goto L14
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ ECShopCroppedStyleRootPresenterV2 a;

        public d(ECShopCroppedStyleRootPresenterV2 r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            this.a.Q();
        }
    }

    public static final class e<T> implements Observer {
        public final /* synthetic */ ECShopCroppedStyleRootPresenterV2 a;

        public e(ECShopCroppedStyleRootPresenterV2 r1) {
            this.a = r1;
        }

        public final void onChanged(Object r6) {
            Integer r7 = (Integer) r6;
            ECShopCroppedStyleRootPresenterV2 r0 = this.a;
            if (r0.C == false) goto L5;
        L7:
            this.a.r0();
            this.a.s0(false);
            this.a.V();
            if (r7 != null) goto L11;
        L13:
            boolean r8 = false;
        L14:
            CoordinatorLayout r1 = this.a.w;
            if (r1 != null) goto L17;
            Intrinsics.throwUninitializedPropertyAccessException("coordinatorLayout");
        L17:
            ViewGroup.LayoutParams r3 = r1.getLayoutParams();
            if (r3 != null) goto L20;
        L33:
            r1.requestLayout();
            View r9 = this.a.x;
            if (r9 != null) goto L36;
            Intrinsics.throwUninitializedPropertyAccessException("rootTabBarContainer");
        L36:
            r9.setAlpha(this.a.b0());
            ECShopCroppedStyleRootPresenterV2 r10 = this.a;
            boolean r2 = r10.V();
            ViewGroup r11 = r10.A;
            if (r11 != null) goto L39;
            Intrinsics.throwUninitializedPropertyAccessException("tipsContainer");
        L39:
            Iterator<T> r12 = com.bytedance.commerce.base.view.b.a(r11).iterator();
        L41:
            if (r12.hasNext() == false) goto L49;
            View r4 = (View) r12.next();
            if ((r4 instanceof com.bytedance.android.shopping.store.home.view.p) == false) goto L41;
            com.bytedance.android.shopping.store.home.view.p r5 = (com.bytedance.android.shopping.store.home.view.p) r4;
            if (r2 == false) goto L47;
            int r13 = 0;
        L48:
            r5.setVisibility(r13);
            goto L41
        L47:
            r13 = 4;
            goto L48
        L49:
            return;
        L20:
            if ((r3 instanceof ViewGroup.MarginLayoutParams) == true) goto L23;
            r3 = null;
        L23:
            if (r3 == null) goto L33;
            ViewGroup.MarginLayoutParams r14 = (ViewGroup.MarginLayoutParams) r3;
            if (r8 == true) goto L27;
        L31:
            int r15 = 0;
        L32:
            r14.bottomMargin = r15;
            goto L33
        L27:
            if ((!Intrinsics.areEqual((Boolean) this.a.T().isBrandShop().getValue(), Boolean.TRUE)) == false) goto L31;
            if (this.a.T().isMiddleTabFramework() == true) goto L31;
            r15 = this.a.e0();
            goto L32
        L11:
            if (r7.intValue() != 2) goto L13;
            r8 = true;
            goto L14
        L5:
            if (r0.V() == false) goto L7;
            this.a.T().reportEnterCroppedStyleStoreOnFullScreenState();
            this.a.C = true;
            goto L7
        }
    }

    public static final class f<T> implements Observer {
        public final /* synthetic */ ECShopCroppedStyleRootPresenterV2 a;

        public f(ECShopCroppedStyleRootPresenterV2 r1) {
            this.a = r1;
        }

        public final void onChanged(Object r18) {
            Boolean r1 = (Boolean) r18;
            ECShopCroppedStyleRootPresenterV2 r2 = this.a;
            int r3 = ECShopCroppedStyleRootPresenterV2.H;
            r2.q0();
            ECShopCroppedStyleRootPresenterV2 r4 = this.a;
            boolean r7 = r4.T().getStoreParam().getStoreUIParam().getLiveDefaultMute();
            im.b r5 = r4.T().getLiveManager();
            boolean r6 = r4.U();
            StoreV3LiveRoomVO r8 = (StoreV3LiveRoomVO) r4.T().getLiveInfo().getValue();
            Context r9 = r4.u().c();
            DialogFragment r10 = r4.S();
            View r11 = r4.o0();
            if ((r11 instanceof FrameLayout) == true) goto L5;
            r11 = null;
        L5:
            im.b.c(r5, null, r6, r8, r7, new im.o(r9, r10, (FrameLayout) r11, (StoreV3LiveRoomVO) r4.T().getLiveInfo().getValue(), r4.T().getPassThroughLogData(), r4.T().getStoreParam().getSearchParams(), ((Number) r4.T().getStoreSizeConfig().m.getValue()).intValue(), r4.T().getStoreParam().getShopId()), false, r4.T().getStoreParam().getStoreUIParam().getCanShowFloatLive(), 160);
        }
    }

    public static final class g<T> implements Observer {
        public final /* synthetic */ ECShopCroppedStyleRootPresenterV2 a;

        public g(ECShopCroppedStyleRootPresenterV2 r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            Pair r3 = (Pair) r2;
            ECShopCroppedStyleRootPresenterV2 r4 = this.a;
            int r0 = ECShopCroppedStyleRootPresenterV2.H;
            r4.q0();
        }
    }

    public static final class h<T> implements Observer {
        public final /* synthetic */ ECShopCroppedStyleRootPresenterV2 a;

        public h(ECShopCroppedStyleRootPresenterV2 r1) {
            this.a = r1;
        }

        public final void onChanged(Object r7) {
            Float r8 = (Float) r7;
            ECShopCroppedStyleRootPresenterV2 r0 = this.a;
            int r1 = ECShopCroppedStyleRootPresenterV2.H;
            float r2 = r0.Z();
            r0.q0();
            boolean r3 = true;
            if ((!Intrinsics.areEqual(r2, r0.v)) == true) goto L5;
        L8:
            View r4 = r0.x;
            if (r4 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("rootTabBarContainer");
        L11:
            r4.setAlpha(r0.b0());
            r0.v = Float.valueOf(r2);
            if (r8.floatValue() <= 0.0f) goto L16;
            if (r8.floatValue() >= 1.0f) goto L16;
            return;
        L16:
            if (r8.floatValue() > 0) goto L18;
            int r9 = 1;
        L19:
            jm.a<Integer> r5 = this.a.T().getCroppedState();
            Integer r6 = (Integer) r5.getValue();
            if (r6 != null) goto L23;
        L26:
            if (r3 == true) goto L29;
            r5 = null;
        L29:
            if (r5 == null) goto L33;
            r5.setValue(Integer.valueOf(r9));
            return;
        L33:
            return;
        L23:
            if (r6.intValue() != r9) goto L26;
            r3 = false;
            goto L26
        L18:
            r9 = 2;
            goto L19
        L5:
            if (r2 <= 0.75f) goto L7;
            im.b.i(r0.T().getLiveManager(), false, false, 3);
            goto L8
        L7:
            im.b r10 = r0.T().getLiveManager();
            int r11 = im.b.q;
            r10.a(false);
            goto L8
        }
    }

    static {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        Boolean r0 = this.E;
        Boolean r1 = Boolean.TRUE;
        if (Intrinsics.areEqual(r0, r1) == true) goto L5;
    L24:
        int r2 = ECSdk.a;
        IAdapterService r3 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r3 == null) goto L28;
        r3.cancelMuteLiveRoom();
        return;
    L28:
        return;
    L5:
        if (Intrinsics.areEqual((Boolean) T().getFlagJumpToFeedVideoPage().getValue(), r1) == false) goto L9;
        s83.d r4 = this.u;
        if (r4 == null) goto L12;
        r4.f();
    L12:
        s83.d r5 = this.u;
        if (r5 == null) goto L15;
        Boolean r6 = Boolean.valueOf(r5.isPlaying());
    L17:
        if (com.bytedance.android.shopping.extensions.k.i(r6) == true) goto L21;
        s83.d r7 = this.u;
        if (r7 == null) goto L21;
        r7.c();
    L21:
        s83.d r8 = this.u;
        if (r8 == null) goto L24;
        r8.h();
        goto L24
    L15:
        r6 = null;
        goto L17
    L9:
        s83.d r9 = this.u;
        if (r9 == null) goto L12;
        r9.e(false, u().c());
        goto L12
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onPause() {
        if (Intrinsics.areEqual(this.E, Boolean.FALSE) == false) goto L15;
        Fragment r0 = this.h;
        if (r0 != null) goto L7;
    L9:
        boolean r1 = false;
    L10:
        if (r1 == true) goto L16;
        s83.d r2 = this.u;
        if (r2 == null) goto L17;
        r2.e(true, u().c());
        return;
    L17:
        return;
    L16:
        return;
    L7:
        if (r0.isRemoving() != true) goto L9;
        r1 = true;
        goto L10
    }

    public final void r0() {
        Boolean r0 = this.E;
        if (r0 != null) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(r0, Boolean.TRUE) == true) goto L8;
        s83.d r1 = this.u;
        if (r1 == null) goto L26;
        r1.g();
        return;
    L26:
        return;
    L8:
        if (V() == false) goto L12;
        s83.d r2 = this.u;
        if (r2 == null) goto L22;
        r2.g();
        return;
    L22:
        return;
    L12:
        s83.d r3 = this.u;
        if (r3 == null) goto L15;
        r3.c();
    L15:
        s83.d r4 = this.u;
        if (r4 == null) goto L24;
        r4.h();
        return;
    }

    public final void C() {
        im.b r0 = T().getLiveManager();
        int r1 = im.b.q;
        r0.a(false);
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L9
        ImmersionBar r3 = this.D;     // Catch: Throwable -> L9
        if (r3 == null) goto L6;
        r3.destroy();     // Catch: Throwable -> L9
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L7:
        Result.constructor-impl(r4);     // Catch: Throwable -> L9
    L11:
        this.D = null;
        return;
    L6:
        r4 = null;
    L9:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        Boolean r1 = null;
        if (V() == true) goto L5;
        T().getLiveManager().a(true);
    L24:
        r0();
        s0(true);
        if (this.E != null) goto L31;
        s83.d r0 = this.u;
        if (r0 == null) goto L29;
        r1 = Boolean.valueOf(r0.isPlaying());
    L29:
        this.E = Boolean.valueOf(com.bytedance.android.shopping.extensions.k.i(r1));
        return;
    L31:
        return;
    L5:
        im.b r2 = T().getLiveManager();
        r2.getClass();
        int r3 = ECSdk.a;
        IAdapterService r4 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r4 == null) goto L12;
        wu1.a r5 = r4.getECLiveStateController();
        if (r5 == null) goto L12;
        Scene r6 = Scene.LIVE;
        Pair r7 = r5.c();
        if (r7 == null) goto L12;
        FloatWindowState r8 = (FloatWindowState) r7.getFirst();
    L13:
        if (r8 == null) goto L15;
        int r9 = im.c.b[r8.ordinal()];
        if (r9 == 1) goto L23;
        if (r9 != 2) goto L24;
        r2.a(true);
        goto L24
    L23:
        im.b.i(r2, true, false, 2);
        goto L24
    L15:
        if (r2.d() == false) goto L17;
        r2.h(true, true);
        goto L24
    L17:
        r2.a(true);
    L12:
        r8 = null;
        goto L13
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public final void onStop() {
        if (V() == true) goto L12;
        Fragment r0 = this.h;
        if (r0 == null) goto L9;
        boolean r2 = true;
        if (r0.isRemoving() != true) goto L9;
    L10:
        if (r2 == true) goto L12;
        im.b r1 = T().getLiveManager();
        int r3 = im.b.q;
        r1.f(false);
    L9:
        r2 = false;
    L12:
        boolean r4 = T().getStoreParam().getStatusBarDarkFont();
        Activity r5 = X();
        int r6 = com.bytedance.android.ec.core.utils.y1.a;
        com.bytedance.android.ec.core.utils.y1.c(r5, r5.getWindow(), r4);
    }

    public final void q0() {
        Integer r0 = (Integer) T().getStoreInfoAreaWithoutTipsHeight().getValue();
        boolean r1 = false;
        if (r0 == null) goto L5;
        int r2 = r0.intValue();
    L6:
        if (r2 != 0) goto L8;
        return;
    L8:
        float r3 = b0();
        float r4 = a0(0.5f);
        h0();
        if (D() == false) goto L11;
        d0();
    L11:
        m0();
        Integer r5 = (Integer) T().getLynxProductComponentHeight().getValue();
        if (r5 == null) goto L14;
        r5.intValue();
    L14:
        boolean r6 = i0();
        float r7 = 1 - r3;
        if (this.z == null) goto L17;
        boolean r8 = true;
    L18:
        int r9 = 857085987;
        int r10 = 4;
        if (r8 == true) goto L24;
        View r11 = new View(u().c());
        FrameLayout.LayoutParams r12 = new FrameLayout.LayoutParams(com.bytedance.android.shopping.extensions.b.b(32), com.bytedance.android.shopping.extensions.b.b(4));
        r12.gravity = 49;
        r12.topMargin = com.bytedance.android.shopping.extensions.b.b(7);
        Unit r13 = Unit.INSTANCE;
        r11.setLayoutParams(r12);
        GradientDrawable r14 = new GradientDrawable();
        r14.setColor(857085987);
        r14.setCornerRadius(com.bytedance.android.ec.core.utils.q.a(4));
        int r15 = qc3.a.a;
        Intrinsics.checkNotNullParameter(r11, "$this$setBackgroundCompat");
        r11.setBackground(r14);
        ViewGroup r16 = this.y;
        if (r16 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("infoGroupAreaContainer");
    L23:
        r16.addView(r11);
        this.z = r11;
    L24:
        View r17 = this.z;
        if (r17 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("slideIndicator");
    L27:
        Drawable r18 = r17.getBackground();
        Unit r19 = null;
        if ((r18 instanceof GradientDrawable) == true) goto L30;
        r18 = null;
    L30:
        GradientDrawable r20 = (GradientDrawable) r18;
        if (r20 == null) goto L35;
        if (r6 == false) goto L34;
        r9 = -1;
    L34:
        r20.setColor(r9);
    L35:
        View r21 = this.z;
        if (r21 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("slideIndicator");
    L38:
        r21.setAlpha(r7);
        if (this.B == null) goto L41;
        boolean r22 = true;
    L42:
        if (r22 == true) goto L50;
        ShoppingAsyncInflater.a r23 = ShoppingAsyncInflater.e;
        Context r24 = u().c();
        r23.getClass();
        ShoppingAsyncInflater r25 = ShoppingAsyncInflater.a.a(r24);
        ViewGroup r26 = this.A;
        if (r26 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("tipsContainer");
    L46:
        View r27 = r25.aU(2131560938, r26, false);
        GradientDrawable r110 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{0, (int) 2768240640L});
        r110.setGradientType(0);
        Unit r28 = Unit.INSTANCE;
        qc3.a.e(r27, r110);
        r27.setOnClickListener(b.a);
        ViewGroup r29 = this.A;
        if (r29 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("tipsContainer");
    L49:
        r29.addView(r27);
        this.B = r27;
    L50:
        View r30 = this.B;
        if (r30 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("slideTips");
    L53:
        r30.setAlpha(r7);
        View r31 = this.B;
        if (r31 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("slideTips");
    L57:
        if (r3 >= 1.0f) goto L60;
        r10 = 0;
    L60:
        r31.setVisibility(r10);
        Result.Companion r32 = Result.Companion;     // Catch: Throwable -> L79
        if (T().getStoreParam().getStatusBarDarkFont() == false) goto L68;
        ImmersionBar r33 = this.D;     // Catch: Throwable -> L79
        if (r33 == null) goto L77;
        ImmersionBar r34 = r33.statusBarDarkFont(!r6);     // Catch: Throwable -> L79
        if (r34 == null) goto L77;
        r34.init();     // Catch: Throwable -> L79
        r19 = Unit.INSTANCE;     // Catch: Throwable -> L79
    L77:
        Result.constructor-impl(r19);     // Catch: Throwable -> L79
        return;
    L68:
        ImmersionBar r35 = this.D;     // Catch: Throwable -> L79
        if (r35 == null) goto L77;
        if (r4 <= 0.0f) goto L74;
        if (r6 == true) goto L74;
        r1 = true;
    L74:
        ImmersionBar r36 = r35.statusBarDarkFont(r1);     // Catch: Throwable -> L79
        if (r36 == null) goto L77;
        r36.init();     // Catch: Throwable -> L79
        r19 = Unit.INSTANCE;     // Catch: Throwable -> L79
    L79:
        th = move-exception;
        Result.Companion r37 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return;
    L41:
        r22 = false;
        goto L42
    L17:
        r8 = false;
        goto L18
    L5:
        r2 = 0;
        goto L6
    }

    public ECShopCroppedStyleRootPresenterV2(Fragment r1) {
        super(r1);
        boolean r2 = ECServiceManager.a;
        this.u = ((s83.g) ECServiceManager.c(s83.g.class)).N();
    }

    public final void A(QModel r6) {
        if (U() == true) goto L5;
        return;
    L5:
        Fragment r7 = this.h;
        Object r1 = null;
        if ((r7 instanceof com.bytedance.android.shopping.store.tabkit.f) == false) goto L11;
        if (r7 == null) goto L9;
        r7 = r7.getParentFragment();
        goto L11
    L9:
        r7 = null;
    L11:
        if ((r7 instanceof DialogFragment) == true) goto L13;
        r7 = null;
    L13:
        DialogFragment r8 = (DialogFragment) r7;
        if (r8 != null) goto L218;
    L23:
        this.w = w().b(2131371057).f();
        this.G = y().findViewById(2131371126);
        T().getHeaderArea().a(W(), new c(this), false);
        View r9 = w().b(2131371128).f();
        r9.setAlpha(0.0f);
        Unit r0 = Unit.INSTANCE;
        this.x = r9;
        this.y = (ViewGroup) w().b(2131371092).f();
        this.A = (ViewGroup) w().b(2131371154).f();
        Z();
        T().getSlideDistance().a(W(), new w(this), false);
        View r10 = y().findViewById(2131370852);
        if (r10 == null) goto L26;
        r10.setOnClickListener(new d(this));
    L26:
        q0();
        T().getCroppedState().a(W(), new e(this), false);
        T().isLiveOn().a(W(), new f(this), false);
        T().getSelectedTabLocation().a(W(), new g(this), false);
        T().getCollapseFactor().a(W(), new h(this), false);
        k0().addObserver(this);
        int r11 = hk3.e.a;
        int r12 = com.bytedance.android.ec.core.opt.ab.m.a;
        Object r13 = 0;
        boolean r2 = ECServiceManager.a;
        s83.g r3 = (s83.g) ECServiceManager.c(s83.g.class);
        if (r3 == null) goto L32;
        s83.a r4 = r3.q();
        if (r4 == null) goto L32;
        Object r5 = r4.e("ec_store_video_zoom");
        if (r5 == null) goto L32;
    L199:
        if (((Number) r5).intValue() != 1) goto L220;
        Uri r14 = T().getSchema();
        if (r14 == null) goto L221;
        String r15 = UriProtector.getQueryParameter(r14, "video_zoom_controller_hash");
        if (r15 == null) goto L222;
        int r16 = CastIntegerProtector.parseInt(r15);
        int r17 = ((Number) this.r.getValue()).intValue();
        int r18 = com.bytedance.android.shopping.store.home.p.a;
        ECStoreAwemeFeedVideoZoomController r19 = new ECStoreAwemeFeedVideoZoomController(r17 - ((Number) this.q.getValue()).intValue(), r16);
        k0().addObserver(r19);
        Unit r20 = Unit.INSTANCE;
        this.F = r19;
        return;
    L222:
        return;
    L221:
        return;
    L220:
        return;
    L32:
        int r21 = com.bytedance.android.ec.core.opt.ab.n.a;
        int r22 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r23 = Result.Companion;     // Catch: Throwable -> L189
        Object r24 = com.bytedance.android.ec.base.settings.d.c.get("ec_store_video_zoom");     // Catch: Throwable -> L83
        if (r24 != null) goto L38;
    L80:
        Object r25 = null;
    L81:
        Object r26 = Result.constructor-impl(r25);     // Catch: Throwable -> L83
    L85:
        Throwable r27 = Result.exceptionOrNull-impl(r26);     // Catch: Throwable -> L189
        if (r27 == null) goto L89;
        EnsureManager.ensureNotReachHere(r27);     // Catch: Throwable -> L189
    L89:
        if (Result.isFailure-impl(r26) == false) goto L92;
        r26 = null;
    L92:
        if ((r26 instanceof Integer) == true) goto L94;
        r26 = null;
    L94:
        r5 = (Integer) r26;     // Catch: Throwable -> L189
        if (r5 != null) goto L101;
        Object r28 = com.bytedance.android.ec.base.settings.d.a.get("ec_store_video_zoom");     // Catch: Throwable -> L189
        if ((r28 instanceof Integer) == true) goto L100;
        r28 = null;
    L100:
        r5 = (Integer) r28;     // Catch: Throwable -> L189
    L101:
        if (r5 != null) goto L199;
        int r29 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L189
        Object r30 = com.bytedance.android.ec.base.settings.d.c.get("ec_store_video_zoom");     // Catch: Throwable -> L153
        if (r30 != null) goto L108;
    L150:
        Object r31 = null;
    L151:
        Object r32 = Result.constructor-impl(r31);     // Catch: Throwable -> L153
    L155:
        Throwable r33 = Result.exceptionOrNull-impl(r32);     // Catch: Throwable -> L180
        if (r33 == null) goto L159;
        EnsureManager.ensureNotReachHere(r33);     // Catch: Throwable -> L180
    L159:
        if (Result.isFailure-impl(r32) == false) goto L162;
        r32 = null;
    L162:
        if ((r32 instanceof Integer) == true) goto L164;
        r32 = null;
    L164:
        r5 = (Integer) r32;     // Catch: Throwable -> L180
        if (r5 != null) goto L187;
        IHybridHostService r34 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L180
        if (r34 == null) goto L170;
        Object r35 = r34.getHostABValue("ec_store_video_zoom", r13);     // Catch: Throwable -> L180
    L171:
        if (r35 != null) goto L173;
    L186:
        r5 = r13;
        goto L187
    L173:
        if ((r35 instanceof Integer) == false) goto L176;
        r1 = r35;
    L176:
        Integer r36 = (Integer) r1;     // Catch: Throwable -> L180
        if (r36 == null) goto L186;
        r5 = r36;
        goto L187
    L180:
        th = move-exception;
        Result.Companion r37 = Result.Companion;     // Catch: Throwable -> L189
        r5 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L189
        Throwable r38 = Result.exceptionOrNull-impl(r5);     // Catch: Throwable -> L189
        if (r38 == null) goto L185;
        EnsureManager.ensureNotReachHere(r38);     // Catch: Throwable -> L189
    L185:
        if (Result.isFailure-impl(r5) == false) goto L187;
    L170:
        r35 = null;
    L187:
        com.bytedance.android.ec.base.settings.d.d("ec_store_video_zoom", r5);     // Catch: Throwable -> L189
        goto L199
    L108:
        if ((r30 instanceof Integer) == true) goto L110;
        Object r39 = null;
    L111:
        r31 = (Integer) r39;     // Catch: Throwable -> L153
        if (r31 != null) goto L151;
        if ((r30 instanceof Number) == false) goto L138;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L123;
        Float r40 = Float.valueOf(((Number) r30).floatValue());     // Catch: Throwable -> L153
        if ((r40 instanceof Integer) == true) goto L121;
        r40 = null;
    L121:
        r31 = (Integer) r40;     // Catch: Throwable -> L153
        goto L151
    L123:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L129;
        Double r41 = Double.valueOf(((Number) r30).doubleValue());     // Catch: Throwable -> L153
        if ((r41 instanceof Integer) == true) goto L127;
        r41 = null;
    L127:
        r31 = (Integer) r41;     // Catch: Throwable -> L153
        goto L151
    L129:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L132;
        r31 = Integer.valueOf(((Number) r30).intValue());     // Catch: Throwable -> L153
        goto L151
    L132:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L138;
        Long r42 = Long.valueOf(((Number) r30).longValue());     // Catch: Throwable -> L153
        if ((r42 instanceof Integer) == true) goto L136;
        r42 = null;
    L136:
        r31 = (Integer) r42;     // Catch: Throwable -> L153
    L138:
        if ((r30 instanceof JSONObject) == false) goto L140;
    L208:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L146
        Object r43 = SDKSettingsCacheManager.a().fromJson(r30.toString(), Integer.class);     // Catch: Throwable -> L146
        if ((r43 instanceof Integer) == true) goto L144;
        r43 = null;
    L144:
        Object r44 = Result.constructor-impl((Integer) r43);     // Catch: Throwable -> L146
    L148:
        r31 = r44;
        if (Result.isFailure-impl(r31) == false) goto L151;
    L146:
        th = move-exception;
        Result.Companion r45 = Result.Companion;     // Catch: Throwable -> L153
        r44 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L153
        goto L148
    L140:
        if ((r30 instanceof JSONArray) == false) goto L150;
    L110:
        r39 = r30;
    L153:
        th = move-exception;
        Result.Companion r46 = Result.Companion;     // Catch: Throwable -> L180
        r32 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L180
        goto L155
    L38:
        if ((r24 instanceof Integer) == true) goto L40;
        Object r47 = null;
    L41:
        r25 = (Integer) r47;     // Catch: Throwable -> L83
        if (r25 != null) goto L81;
        if ((r24 instanceof Number) == false) goto L68;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L53;
        Float r48 = Float.valueOf(((Number) r24).floatValue());     // Catch: Throwable -> L83
        if ((r48 instanceof Integer) == true) goto L51;
        r48 = null;
    L51:
        r25 = (Integer) r48;     // Catch: Throwable -> L83
        goto L81
    L53:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L59;
        Double r49 = Double.valueOf(((Number) r24).doubleValue());     // Catch: Throwable -> L83
        if ((r49 instanceof Integer) == true) goto L57;
        r49 = null;
    L57:
        r25 = (Integer) r49;     // Catch: Throwable -> L83
        goto L81
    L59:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L62;
        r25 = Integer.valueOf(((Number) r24).intValue());     // Catch: Throwable -> L83
        goto L81
    L62:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L68;
        Long r50 = Long.valueOf(((Number) r24).longValue());     // Catch: Throwable -> L83
        if ((r50 instanceof Integer) == true) goto L66;
        r50 = null;
    L66:
        r25 = (Integer) r50;     // Catch: Throwable -> L83
    L68:
        if ((r24 instanceof JSONObject) == false) goto L70;
    L206:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L76
        Object r51 = SDKSettingsCacheManager.a().fromJson(r24.toString(), Integer.class);     // Catch: Throwable -> L76
        if ((r51 instanceof Integer) == true) goto L74;
        r51 = null;
    L74:
        Object r52 = Result.constructor-impl((Integer) r51);     // Catch: Throwable -> L76
    L78:
        r25 = r52;
        if (Result.isFailure-impl(r25) == false) goto L81;
    L76:
        th = move-exception;
        Result.Companion r53 = Result.Companion;     // Catch: Throwable -> L83
        r52 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L83
        goto L78
    L70:
        if ((r24 instanceof JSONArray) == false) goto L80;
    L40:
        r47 = r24;
    L83:
        th = move-exception;
        Result.Companion r54 = Result.Companion;     // Catch: Throwable -> L189
        r26 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L189
    L189:
        th = move-exception;
        Result.Companion r55 = Result.Companion;
        Object r56 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r57 = Result.exceptionOrNull-impl(r56);
        if (r57 == null) goto L194;
        EnsureManager.ensureNotReachHere(r57);
    L194:
        if (Result.isFailure-impl(r56) == true) goto L197;
        r13 = r56;
    L197:
        r5 = r13;
        goto L199
    L218:
        Result.Companion r58 = Result.Companion;     // Catch: Throwable -> L17
        Object r59 = Result.constructor-impl(ImmersionBar.with(r8));     // Catch: Throwable -> L17
    L20:
        if (Result.isFailure-impl(r59) == false) goto L22;
        r59 = null;
    L22:
        this.D = (ImmersionBar) r59;
    L17:
        th = move-exception;
        Result.Companion r60 = Result.Companion;
        r59 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L20
    }

    public final void s0(boolean r3) {
        boolean r0 = V();
        if (r0 == false) goto L5;
        T().getLiveManager().f(r3);
    L5:
        if (r0 == true) goto L15;
        im.b r4 = T().getLiveManager();
        if (r4.d() == false) goto L16;
        int r1 = im.l.a;
        boolean r2 = ECServiceManager.a;
        if (Intrinsics.areEqual(((s83.g) ECServiceManager.c(s83.g.class)).E(), Boolean.TRUE) == false) goto L17;
        int r5 = ECSdk.a;
        IAdapterService r6 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r6 == null) goto L13;
        r6.cancelMuteLiveRoom();
    L13:
        r4.j = false;
        return;
    L17:
        return;
    L16:
        return;
    }
}
