package com.bytedance.android.shopping.store.home.presenter;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.store.view.ECHeaderSlideIndicator;
import com.bytedance.android.shopping.store.home.ECShopHeaderVideoManager;
import com.bytedance.android.shopping.store.home.api.StoreUIParam;
import com.bytedance.android.shopping.store.repository.vo.ShopHeaderVideoVO;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.bytedance.awemeopen.apps.photo.pinch.PinchEnterMethod;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\bJ\b\u0010\u0005\u001a\u00020\u0004H\u0007J\b\u0010\u0006\u001a\u00020\u0004H\u0007J\b\u0010\u0007\u001a\u00020\u0004H\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/store/home/presenter/ECShopLinkageHeaderVideoPresenter;", "Lcom/bytedance/android/shopping/store/home/presenter/ECShopBasePresenter;", "Landroid/view/View$OnClickListener;", "Landroidx/lifecycle/LifecycleObserver;", "", "onResume", "onPause", "onDestroy", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShopLinkageHeaderVideoPresenter extends ECShopBasePresenter implements View.OnClickListener, LifecycleObserver {
    public static final /* synthetic */ int K = 0;
    public View A;
    public View B;
    public View C;
    public View D;
    public ECHeaderSlideIndicator E;
    public boolean F;
    public boolean G;
    public boolean H;
    public final List<String> I;
    public final Map<String, String> J;
    public Pair<Integer, Integer> u;
    public ViewGroup v;
    public ViewGroup w;
    public ViewGroup x;
    public SimpleDraweeView y;
    public ViewGroup z;

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ ECShopLinkageHeaderVideoPresenter a;

        public b(ECShopLinkageHeaderVideoPresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r9) {
            ShopHeaderVideoVO r10 = (ShopHeaderVideoVO) r9;
            StoreUIParam r11 = this.a.T().getStoreParam().getStoreUIParam();
            if (this.a.I() == true) goto L5;
        L7:
            boolean r0 = false;
        L8:
            r11.setHasHeaderVideo(r0);
            ShoppingAsyncInflater.a r12 = ShoppingAsyncInflater.e;
            Context r1 = th.a.e(this.a.u().c(), true);
            r12.getClass();
            ShoppingAsyncInflater r13 = ShoppingAsyncInflater.a.a(r1);
            View r2 = this.a.y();
            if (r2 == null) goto L90;
            View r14 = r13.aU(2131560870, (ViewGroup) r2, false);
            View r3 = this.a.y();
            if (r3 == null) goto L88;
            ((ViewGroup) r3).addView(r14);
            ECShopLinkageHeaderVideoPresenter r15 = this.a;
            View r4 = r15.o0();
            CoordinatorLayout r5 = r4.findViewById(2131371057);
            ViewGroup r6 = (ViewGroup) r4.findViewById(2131371107);
            r15.v = r6;
            if (r6 != null) goto L15;
            Intrinsics.throwUninitializedPropertyAccessException("videoContainer");
        L15:
            ViewGroup r7 = (ViewGroup) r6.findViewById(2131370883);
            r15.w = r7;
            if (r7 != null) goto L18;
            Intrinsics.throwUninitializedPropertyAccessException("videoContainerLayer");
        L18:
            r15.x = (ViewGroup) r7.findViewById(2131372882);
            ViewGroup r8 = r15.w;
            if (r8 != null) goto L21;
            Intrinsics.throwUninitializedPropertyAccessException("videoContainerLayer");
        L21:
            r15.y = r8.findViewById(2131376720);
            ViewGroup r16 = r15.w;
            if (r16 != null) goto L24;
            Intrinsics.throwUninitializedPropertyAccessException("videoContainerLayer");
        L24:
            ViewGroup r17 = (ViewGroup) r16.findViewById(2131370884);
            r15.z = r17;
            if (r17 != null) goto L27;
            Intrinsics.throwUninitializedPropertyAccessException("videoElementLayer");
        L27:
            r15.A = r17.findViewById(2131370885);
            ViewGroup r18 = r15.z;
            if (r18 != null) goto L30;
            Intrinsics.throwUninitializedPropertyAccessException("videoElementLayer");
        L30:
            r15.B = r18.findViewById(2131370755);
            ViewGroup r19 = r15.z;
            if (r19 != null) goto L33;
            Intrinsics.throwUninitializedPropertyAccessException("videoElementLayer");
        L33:
            r15.C = r19.findViewById(2131370752);
            ViewGroup r20 = r15.z;
            if (r20 != null) goto L36;
            Intrinsics.throwUninitializedPropertyAccessException("videoElementLayer");
        L36:
            r15.D = r20.findViewById(2131370753);
            ViewGroup r21 = r15.z;
            if (r21 != null) goto L39;
            Intrinsics.throwUninitializedPropertyAccessException("videoElementLayer");
        L39:
            r15.E = r21.findViewById(2131370754);
            ECShopLinkageHeaderVideoPresenter r22 = this.a;
            if (r22.u != null) goto L42;
            r22.u = new Pair(0, Integer.valueOf(com.bytedance.android.shopping.extensions.b.b(100)));
        L42:
            Pair<Integer, Integer> r23 = r22.u;
            Intrinsics.checkNotNull(r23);
            int r24 = ((Number) r23.getFirst()).intValue();
            ViewGroup r25 = r22.v;
            if (r25 != null) goto L45;
            Intrinsics.throwUninitializedPropertyAccessException("videoContainer");
        L45:
            ViewGroup.LayoutParams r26 = r25.getLayoutParams();
            if (r26 == null) goto L48;
            r26.height = r24;
        L48:
            r25.requestLayout();
            int[] r27 = {(int) 2147483648L, 0};
            View r28 = r22.B;
            if (r28 != null) goto L51;
            Intrinsics.throwUninitializedPropertyAccessException("videoTopMask");
        L51:
            GradientDrawable r29 = new GradientDrawable();
            qc3.a.f(r29, r27);
            Unit r30 = Unit.INSTANCE;
            qc3.a.e(r28, r29);
            View r31 = r22.B;
            if (r31 != null) goto L54;
            Intrinsics.throwUninitializedPropertyAccessException("videoTopMask");
        L54:
            r31.requestLayout();
            int[] r32 = {0, 1291845632};
            View r33 = r22.C;
            if (r33 != null) goto L57;
            Intrinsics.throwUninitializedPropertyAccessException("bottomInfoAreaMask");
        L57:
            GradientDrawable r34 = new GradientDrawable();
            qc3.a.f(r34, r32);
            qc3.a.e(r33, r34);
            View r35 = r22.C;
            if (r35 != null) goto L60;
            Intrinsics.throwUninitializedPropertyAccessException("bottomInfoAreaMask");
        L60:
            r35.requestLayout();
            View r36 = r22.D;
            if (r36 != null) goto L63;
            Intrinsics.throwUninitializedPropertyAccessException("bottomGradualMask");
        L63:
            ViewGroup.LayoutParams r37 = r36.getLayoutParams();
            if (r37 == null) goto L66;
            r37.height = com.bytedance.android.shopping.extensions.b.b(47);
            ((ViewGroup.MarginLayoutParams) r37).bottomMargin = 0;
        L66:
            View r38 = r22.D;
            if (r38 != null) goto L69;
            Intrinsics.throwUninitializedPropertyAccessException("bottomGradualMask");
        L69:
            r38.setBackground(th.a.e(r22.u().c(), true).getDrawable(2131248297));
            View r39 = r22.D;
            if (r39 != null) goto L72;
            Intrinsics.throwUninitializedPropertyAccessException("bottomGradualMask");
        L72:
            r39.requestLayout();
            ECHeaderSlideIndicator r40 = r22.E;
            if (r40 != null) goto L75;
            Intrinsics.throwUninitializedPropertyAccessException("slideIndicator");
        L75:
            ViewGroup.LayoutParams r41 = r40.getLayoutParams();
            if (r41 == null) goto L86;
            ((ViewGroup.MarginLayoutParams) r41).bottomMargin = com.bytedance.android.shopping.extensions.b.b(120);
            r40.setText(2131896860);
            r22.T().getCollapseFactor().a(r22.W(), new r0(r22), false);
            r22.T().getVideoInfo().a(ECQuickUtilKt.a(r22.u()), new u0(r22), false);
            View r42 = r22.A;
            if (r42 != null) goto L80;
            Intrinsics.throwUninitializedPropertyAccessException("soundBtn");
        L80:
            r42.setOnClickListener(r22);
            ViewGroup r43 = r22.z;
            if (r43 != null) goto L83;
            Intrinsics.throwUninitializedPropertyAccessException("videoElementLayer");
        L83:
            r43.setOnClickListener(r22);
            r22.T().getVideoManager().f.a(r22.W(), new v0(r22), false);
            this.a.k0().addObserver(this.a);
            this.a.T().getCollapseFactor().a(this.a.W(), new w0(this), false);
            return;
        L86:
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        L88:
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        L90:
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        L5:
            if (this.a.U() == true) goto L7;
            r0 = true;
            goto L8
        }
    }

    static {
    }

    public ECShopLinkageHeaderVideoPresenter() {
        super(null);
        this.I = new ArrayList();
        this.J = new LinkedHashMap();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onPause() {
        if (this.F == false) goto L6;
        T().getVideoManager().e();
        return;
    }

    @Override // com.bytedance.android.shopping.store.home.presenter.ECShopBasePresenter
    public final View o0() {
        View r0 = y();
    L4:
        if ((r0.getParent() instanceof ViewGroup) == false) goto L22;
        ViewParent r1 = r0.getParent();
        if (r1 == null) goto L21;
        if (((ViewGroup) r1).getId() == 2131371126) goto L9;
        Object r2 = r0.getParent();
        if (r2 == null) goto L19;
        r0 = (View) r2;
        goto L4
    L19:
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    L9:
        Object r3 = r0.getParent();
        if (r3 == null) goto L14;
        return (View) r3;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    L21:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L22:
        int r4 = ye.a.a;
        ye.a.a(Log.getStackTraceString(new Throwable()));
        return super.o0();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        ECShopHeaderVideoManager r0 = T().getVideoManager();
        ViewGroup r1 = this.x;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("videoSceneContainer");
    L5:
        r0.g(r1);
        k0().removeObserver(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        Float r0 = (Float) T().getCollapseFactor().getValue();
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        this.G = false;
        if (I() == false) goto L14;
        if (this.H == false) goto L14;
        T().getChangeStateEvent().setValue(new ui3.c(4, null, 6));
    L14:
        if (this.F == false) goto L18;
        if (r1 == false) goto L19;
        T().getVideoManager().h();
        return;
    L19:
        return;
    L18:
        return;
    L5:
        if (r0.floatValue() >= 1.0f) goto L7;
        r1 = true;
        goto L8
    }

    public final void A(QModel r4) {
        T().getVideoInfo().a(W(), new b(this), false);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r6) {
        Intrinsics.checkNotNullParameter(r6, "v");
        int r0 = kn.a.a;
        if (kn.a.a(r6.getId()) == false) goto L5;
        return;
    L5:
        if (T().getStoreParam().isPreview() == true) goto L25;
        int r7 = r6.getId();
        if (r7 != 2131370885) goto L19;
        ECShopHeaderVideoManager r8 = T().getVideoManager();
        if (r8.c() == false) goto L12;
        r8.i();
    L13:
        Boolean r9 = (Boolean) T().getVideoManager().f.getValue();
        ECStoreViewModel r1 = T();
        Pair<String, String>[] r2 = new Pair[2];
        r2[0] = TuplesKt.to("video_id", T().getVideoManager().b);
        if (Intrinsics.areEqual(r9, Boolean.FALSE) == false) goto L16;
        String r10 = "on";
    L17:
        r2[1] = TuplesKt.to("status_to", r10);
        r1.doEventAction("store_video_audio_click", r2);
        return;
    L16:
        r10 = "off";
        goto L17
    L12:
        r8.d();
        goto L13
    L19:
        if (r7 != 2131370884) goto L24;
        q0(0);
        return;
    L24:
        return;
    }

    public final void q0(int r9) {
        Boolean r0 = (Boolean) T().getVideoManager().h.getValue();
        Boolean r1 = Boolean.TRUE;
        if (Intrinsics.areEqual(r0, r1) == false) goto L5;
        return;
    L5:
        this.H = true;
        Context r2 = u().c();
        if (r9 == 0) goto L10;
        if (r9 != 1) goto L10;
        String r3 = "slide";
    L11:
        T().getVideoManager().h.setValue(r1);
        if (r9 == 1) goto L14;
        ECShopHeaderVideoManager r10 = T().getVideoManager();
        ViewGroup r4 = this.x;
        if (r4 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("videoSceneContainer");
    L23:
        r10.a(r2, r4, this.h);
    L24:
        ECStoreViewModel r11 = T();
        Pair<String, String>[] r5 = new Pair[3];
        r5[0] = TuplesKt.to("video_id", T().getVideoManager().b);
        r5[1] = TuplesKt.to("click_type", r3);
        Map<String, String> r6 = this.J;
        LinkedHashMap r7 = (LinkedHashMap) r6;
        String r8 = (String) r7.get(T().getVideoManager().b);
        if (r8 != null) goto L27;
        r8 = "";
    L27:
        r5[2] = TuplesKt.to("author_id", r8);
        r11.doEventAction("store_video_click", r5);
        return;
    L14:
        if (this.G == true) goto L24;
        this.G = true;
        T().getChangeStateEvent().setValue(new ui3.c(5, null, 6));
        ECShopHeaderVideoManager r12 = T().getVideoManager();
        ViewGroup r13 = this.x;
        if (r13 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("videoSceneContainer");
    L19:
        r12.a(r2, r13, this.h);
    L10:
        r3 = PinchEnterMethod.CLICK;
        goto L11
    }
}
