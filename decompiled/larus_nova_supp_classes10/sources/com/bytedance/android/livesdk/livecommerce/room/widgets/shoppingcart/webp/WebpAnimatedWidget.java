package com.bytedance.android.livesdk.livecommerce.room.widgets.shoppingcart.webp;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import com.bytedance.android.ec.core.utils.ECLiveEntranceMonitor;
import com.bytedance.android.ec.core.widget.ECNetImageView;
import com.bytedance.android.ec.model.response.IconItem;
import com.bytedance.android.ec.model.response.LottieIconData;
import com.bytedance.android.ec.model.response.RelatedAction;
import com.bytedance.android.ec.sdk.helper.i;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.EntryController;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.coupon.EnterRequestHandler;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import com.bytedance.android.livesdk.livecommerce.room.widgets.anim.CartCardLinkedAnimController;
import com.bytedance.android.livesdk.livecommerce.room.widgets.anim.g;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.livecommerce.utils.p;
import com.bytedance.android.livesdk.livecommerce.utils.w0;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class WebpAnimatedWidget extends FrameLayout implements yk2.c {
    public static boolean n;
    public Map<Integer, View> a;
    public boolean b;
    public yk2.d c;
    public yk2.a d;
    public final CartCardLinkedAnimController e;
    public boolean f;
    public boolean g;
    public boolean h;
    public final FrameLayout i;
    public boolean j;
    public RelatedAction k;
    public Pair<RelatedAction, ? extends Runnable> l;
    public final RoomContextController m;

    public static final class a {
    }

    static {
    }

    @Override // yk2.c
    public View getView() {
        return this;
    }

    private final yk2.d getCustomImageAdapter() {
        Lazy r0 = EnterRequestHandler.a;
        String r1 = EnterRequestHandler.f();
        if (r1 != null) goto L7;
        return null;
    L7:
        return new e(CollectionsKt.listOf(r1));
    }

    @Override // yk2.c
    public String getCartAnimRelatedInfo() {
        RelatedAction r0 = this.k;
        if (r0 != null) goto L5;
        return null;
    L5:
        RelatedAction.RelatedType r2 = r0.getRelatedType();
        if (c.a[r2.ordinal()] != 1) goto L13;
        RelatedAction.BannerRelatedMeta r1 = r0.getBannerRelatedMeta();
        if (r1 != null) goto L11;
        return null;
    L11:
        return r1.getCartIconRelatedInfo();
    L13:
        return null;
    }

    public final void h() {
        Pair<RelatedAction, ? extends Runnable> r0 = this.l;
        if (r0 == null) goto L5;
        MainThreadPostUtils.d((Runnable) r0.component2());
    L5:
        this.l = null;
    }

    @Override // yk2.c
    public final void unload() {
        this.i.removeAllViews();
        this.j = false;
        h();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        p.a = true;
        if (this.m.v() == false) goto L5;
        this.m.A().t.e0();
    L6:
        ECLiveEntranceMonitor.trace$default("onAttachedToWindow", "WebpAnimatedWidget", false, 4, null);
        n = true;
        return;
    L5:
        boolean r1 = EntryController.M1;
        EntryController.a.a().e0();
        goto L6
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        boolean r0 = p.a;
        p.a = false;
        ECLiveEntranceMonitor.trace$default("onDetachedFromWindow", "WebpAnimatedWidget", false, 4, null);
    }

    @Override // yk2.b
    public final void playAnimation() {
        if (d(2131376634).getVisibility() == 0) goto L5;
        return;
    L5:
        ECLiveABUtils r0 = ECLiveABUtils.INSTANCE;
        boolean r3 = true;
        if (r0.getEC_LIVE_SHOPPING_CART_NEW().booleanValue() == false) goto L34;
        Lazy r1 = EnterRequestHandler.a;
        IconItem r2 = EnterRequestHandler.g();
        if (r2 == null) goto L27;
        LottieIconData r5 = r2.getLottieIcon();
        if (r5 != null) goto L12;
    L17:
        String r6 = r2.getAnimatedIcon();
        if (r6 == null) goto L27;
        if (r6.length() > 0) goto L23;
        r3 = false;
    L23:
        if (r3 == false) goto L27;
        g(new e(CollectionsKt.listOf(r6)), false, false, r2);
        return;
    L12:
        if (r5.isValid() != true) goto L17;
        if (this.j == true) goto L17;
        this.j = true;
        i.a.b(getContext());
    L27:
        if (r0.getEC_LIVE_SHOPPING_CART_DISABLE_ANIM() == false) goto L29;
        return;
    L29:
        yk2.d r4 = this.c;
        if (r4 != null) goto L32;
        return;
    L32:
        g(r4, false, false, null);
        return;
    L34:
        yk2.d r7 = getCustomImageAdapter();
        if (r7 != null) goto L42;
        r7 = this.c;
        if (r7 != null) goto L39;
    L41:
        r7 = null;
        goto L42
    L39:
        if ((!r0.getEC_LIVE_SHOPPING_CART_DISABLE_ANIM()) == false) goto L41;
    L42:
        if (r7 != null) goto L44;
        return;
    L44:
        g(r7, false, false, null);
    }

    @Override // yk2.c
    public final boolean c() {
        return this.h;
    }

    @Override // yk2.b
    public yk2.a getController() {
        return this.d;
    }

    public final yk2.d getDefaultImageAdapter() {
        return this.c;
    }

    public final View d(int r3) {
        if (this.a != null) goto L5;
        this.a = new LinkedHashMap();
    L5:
        View r0 = this.a.get(Integer.valueOf(r3));
        if (r0 != null) goto L12;
        View r1 = findViewById(r3);
        if (r1 == null) goto L10;
        this.a.put(Integer.valueOf(r3), r1);
        return r1;
    L10:
        return null;
    L12:
        return r0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r2) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        super.dispatchDraw(r2);
        if (this.b == false) goto L6;
        System.out.println("Django: WebpAnimatedWidget:onDrawEnd");
        return;
    }

    @Override // yk2.b
    public void setController(yk2.a r1) {
        this.d = r1;
    }

    public final void setD3Room(boolean r1) {
        this.g = r1;
    }

    public final void setDefaultImageAdapter(yk2.d r1) {
        this.c = r1;
    }

    public final void setEnableLinkedAnimation(boolean r1) {
        this.h = r1;
    }

    public WebpAnimatedWidget(Context r5, RoomContextController r6) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "roomContextController");
        CartCardLinkedAnimController r0 = null;
        super(r5, null, 0);
        this.m = r6;
        this.a = new LinkedHashMap();
        if (r6.v() == false) goto L9;
        ECContext r2 = r6.r();
        if (r2 == null) goto L14;
        com.bytedance.live.datacontext.i<CartCardLinkedAnimController> r3 = r2.getLinkedAnimController();
        if (r3 == null) goto L14;
        r0 = (CartCardLinkedAnimController) r3.getValue();
    L14:
        this.e = r0;
        th.a.c(r5, 2131560987, this, true);
        d(2131371366).getHierarchy().setFadeDuration(0);
        setClipChildren(false);
        if (r0 == null) goto L17;
        r0.d = this;
    L17:
        ViewGroup.LayoutParams r7 = ((FrameLayout) d(2131377451)).getLayoutParams();
        if (r7 != null) goto L20;
    L27:
        this.i = (FrameLayout) findViewById(2131372675);
        if (this.j == true) goto L32;
        this.j = true;
        i.a.b(getContext());
        return;
    L32:
        return;
    L20:
        if (r6.v() == true) goto L24;
        int r8 = RoomContextController.h;
        r6 = RoomContextController.a.a();
    L24:
        if (r6.s() == true) goto L26;
        r7.width = UtilityKotlinExtentionsKt.d(38);
        r7.height = UtilityKotlinExtentionsKt.d(38);
        goto L27
    L26:
        r7.width = UtilityKotlinExtentionsKt.d(36);
        r7.height = UtilityKotlinExtentionsKt.d(36);
        goto L27
    L9:
        int r4 = RoomContextController.h;
        ECContext r9 = RoomContextController.a.a().r();
        if (r9 == null) goto L14;
        com.bytedance.live.datacontext.i<CartCardLinkedAnimController> r10 = r9.getLinkedAnimController();
        if (r10 == null) goto L14;
        r0 = (CartCardLinkedAnimController) r10.getValue();
        goto L14
    }

    @Override // yk2.c
    public final void a(boolean r3, e r4) {
        Intrinsics.checkNotNullParameter(r4, "cartImageAdapter");
        g(r4, true, r3, null);
    }

    public final void e(String r3, float r4) {
        ((TextView) d(2131391424)).setText(r3);
        ViewGroup.LayoutParams r5 = ((TextView) d(2131391424)).getLayoutParams();
        if ((r5 instanceof FrameLayout.LayoutParams) == true) goto L5;
        r5 = null;
    L5:
        FrameLayout.LayoutParams r6 = (FrameLayout.LayoutParams) r5;
        if (r6 == null) goto L9;
        MarginLayoutParamsCompat.setMarginEnd(r6, w0.a(r4));
        return;
    }

    public final void f(boolean r4, int r5) {
        if (r4 == true) goto L6;
        this.f = false;
        ((TextView) d(2131391424)).setVisibility(8);
        return;
    L6:
        if (r5 <= 0) goto L8;
        boolean r6 = true;
    L9:
        this.f = r6;
        ((TextView) d(2131391424)).setVisibility(0);
        if (r5 > 0) goto L13;
        ((TextView) d(2131391424)).setVisibility(8);
        return;
    L13:
        if (r5 >= 10) goto L16;
        e(String.valueOf(r5), -2.0f);
        return;
    L16:
        if (r5 >= 100) goto L18;
        e(String.valueOf(r5), -4.0f);
        return;
    L18:
        e("99+", -6.0f);
        return;
    L8:
        r6 = false;
        goto L9
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r4, int r5) {
        super.onMeasure(r4, r5);
        if (n == false) goto L6;
        n = false;
        ECLiveEntranceMonitor.trace$default("onMeasure", "WebpAnimatedWidget", false, 4, null);
        return;
    }

    @Override // yk2.c
    public final void b(final boolean r5, e r6, e r7) {
        Intrinsics.checkNotNullParameter(r6, "smallCardImageAdapter");
        Intrinsics.checkNotNullParameter(r7, "cartImageAdapter");
        g(r7, true, r5, null);
        if (this.m.v() == true) goto L6;
        d(2131371367).setVisibility(0);
        ECNetImageView r8 = d(2131371367);
        PipelineDraweeControllerBuilder r9 = Fresco.newDraweeControllerBuilder().setFirstAvailableImageRequests((Object[]) r6.a());
        WebpAnimatedWidget$playSmallCardAnimation$1 r0 = WebpAnimatedWidget$playSmallCardAnimation$1.INSTANCE;
        Function0<Unit> r2 = new WebpAnimatedWidget$playSmallCardAnimation$2(this);
        Function1<Integer, Unit> r3 = new WebpAnimatedWidget$playSmallCardAnimation$3(this, r5);
        Intrinsics.checkNotNullParameter(r0, "onStart");
        Intrinsics.checkNotNullParameter(r2, "onEnd");
        r8.setController(r9.setControllerListener(new f(null, r0, r2, r3)).build());
        return;
    }

    public final void g(yk2.d r6, final boolean r7, final boolean r8, final IconItem r9) {
        if (ViewCompat.isAttachedToWindow(this) == true) goto L11;
        CartCardLinkedAnimController r10 = this.e;
        if (r10 == null) goto L21;
        r10.b = false;
        g r11 = r10.c;
        if (r11 == null) goto L9;
        r11.a();
    L9:
        r10.c = null;
        return;
    L21:
        return;
    L11:
        int r0 = (int) UtilityKotlinExtentionsKt.c(66);
        int r2 = (int) UtilityKotlinExtentionsKt.c(130);
        if (this.g == false) goto L16;
        ViewGroup.LayoutParams r3 = d(2131371366).getLayoutParams();
        if (r3.width == r0) goto L19;
        r3.width = r0;
        r3.height = r0;
        d(2131371366).setLayoutParams(r3);
    L19:
        ECNetImageView r1 = d(2131371366);
        PipelineDraweeControllerBuilder r12 = Fresco.newDraweeControllerBuilder().setFirstAvailableImageRequests((Object[]) r6.a());
        Function0<Unit> r4 = new WebpAnimatedWidget$playAnimationImpl$1(this, r9, r7, r8);
        Function0<Unit> r13 = new WebpAnimatedWidget$playAnimationImpl$2(this, r7, r8);
        Function1<Integer, Unit> r14 = new WebpAnimatedWidget$playAnimationImpl$3(this, r8);
        Intrinsics.checkNotNullParameter(r4, "onStart");
        Intrinsics.checkNotNullParameter(r13, "onEnd");
        r1.setController(r12.setControllerListener(new f(null, r4, r13, r14)).build());
        return;
    L16:
        ViewGroup.LayoutParams r5 = d(2131371366).getLayoutParams();
        if (r5.width == r2) goto L19;
        r5.width = r2;
        r5.height = r2;
        d(2131371366).setLayoutParams(r5);
        goto L19
    }
}
