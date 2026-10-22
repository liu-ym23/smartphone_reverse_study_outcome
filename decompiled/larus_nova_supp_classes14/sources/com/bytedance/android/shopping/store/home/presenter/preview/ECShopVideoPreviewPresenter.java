package com.bytedance.android.shopping.store.home.presenter.preview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.store.view.ECHeaderSlideIndicator;
import com.bytedance.android.shopping.store.home.ECShopHeaderVideoManager;
import com.bytedance.android.shopping.store.home.frame.container.ShopContainerType;
import com.bytedance.android.shopping.store.moments.vo.Author;
import com.bytedance.android.shopping.store.moments.vo.Aweme;
import com.bytedance.android.shopping.store.moments.vo.Video;
import com.bytedance.android.shopping.store.repository.vo.ShopHeaderVideoInfoVO;
import com.bytedance.android.shopping.store.repository.vo.ShopHeaderVideoVO;
import com.bytedance.android.shopping.store.viewmodel.ShopStatus;
import com.bytedance.awemeopen.apps.photo.pinch.PinchEnterMethod;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u0005:\u0001\nJ\b\u0010\u0007\u001a\u00020\u0006H\u0007J\b\u0010\b\u001a\u00020\u0006H\u0007J\b\u0010\t\u001a\u00020\u0006H\u0007¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/store/home/presenter/preview/ECShopVideoPreviewPresenter;", "Lcom/bytedance/android/shopping/store/home/frame/presenter/a;", "Lcom/bytedance/android/shopping/store/repository/vo/ShopHeaderVideoVO;", "Landroid/view/View$OnClickListener;", "Landroidx/lifecycle/LifecycleObserver;", "Lcom/bytedance/android/shopping/store/home/presenter/preview/q;", "", "onResume", "onPause", "onDestroy", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShopVideoPreviewPresenter extends com.bytedance.android.shopping.store.home.frame.presenter.a<ShopHeaderVideoVO> implements View.OnClickListener, LifecycleObserver, q {
    public static final /* synthetic */ int E = 0;
    public final Lazy A;
    public final Lazy B;
    public ShopHeaderVideoVO C;
    public boolean D;
    public final int j;
    public ViewGroup k;
    public ViewGroup l;
    public ViewGroup m;
    public SimpleDraweeView n;
    public ViewGroup o;
    public View p;
    public View q;
    public View r;
    public View s;
    public ECHeaderSlideIndicator t;
    public boolean u;
    public boolean v;
    public boolean w;
    public final List<String> x;
    public final Map<String, String> y;
    public final Lazy z;

    public static final class a {
    }

    static {
    }

    public ECShopVideoPreviewPresenter() {
        this(null);
    }

    @Override // com.bytedance.android.shopping.store.home.frame.presenter.a
    public final void j0() {
    }

    public final ECShopVideoPreviewGroupPresenter.b l0() {
        return (ECShopVideoPreviewGroupPresenter.b) this.z.getValue();
    }

    public final ECShopHeaderVideoManager m0() {
        return (ECShopHeaderVideoManager) this.B.getValue();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onPause() {
        if (this.u == false) goto L8;
        ECShopHeaderVideoManager r0 = m0();
        if (r0 == null) goto L9;
        r0.e();
        return;
    L9:
        return;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        ECShopHeaderVideoManager r0 = m0();
        if (r0 == null) goto L8;
        ViewGroup r1 = this.m;
        if (r1 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("videoSceneContainer");
    L7:
        r0.g(r1);
    L8:
        e0().removeObserver(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        ECShopVideoPreviewGroupPresenter.b r0 = l0();
        if (r0 == null) goto L11;
        Float r1 = (Float) r0.b.getCollapseFactor().getValue();
        if (r1 == null) goto L7;
        float r2 = r1.floatValue();
    L9:
        if (Float.valueOf(r2).floatValue() >= 1.0f) goto L11;
        boolean r3 = true;
    L12:
        this.v = false;
        if (this.D == false) goto L21;
        if (this.w == false) goto L21;
        ECShopVideoPreviewGroupPresenter.a r4 = (ECShopVideoPreviewGroupPresenter.a) this.A.getValue();
        if (r4 == null) goto L19;
        r4.a.getChangeStateEvent().setValue(new ui3.c(4, ShopStatus.PREVIEW_EXPANDED, 2));
    L19:
        this.w = false;
    L21:
        if (this.u == false) goto L27;
        if (r3 == false) goto L28;
        ECShopHeaderVideoManager r5 = m0();
        if (r5 == null) goto L29;
        r5.h();
        return;
    L29:
        return;
    L28:
        return;
    L27:
        return;
    L7:
        r2 = 0.0f;
    L11:
        r3 = false;
        goto L12
    }

    public ECShopVideoPreviewPresenter(Fragment r1) {
        Intrinsics.checkNotNull(r1);
        super(r1);
        this.j = com.bytedance.android.shopping.extensions.b.b(100);
        this.x = new ArrayList();
        this.y = new LinkedHashMap();
        this.z = LazyKt.lazy(new ECShopVideoPreviewPresenter$modelAdapter$2(this));
        this.A = LazyKt.lazy(new ECShopVideoPreviewPresenter$behaviorAdapter$2(this));
        this.B = LazyKt.lazy(new ECShopVideoPreviewPresenter$videoManager$2(this));
    }

    @Override // com.bytedance.android.shopping.store.home.frame.presenter.a
    public final void i0(ShopHeaderVideoVO r19) {
        this.C = r19;
        ShoppingAsyncInflater.a r1 = ShoppingAsyncInflater.e;
        Context r2 = th.a.e(Y().c(), true);
        r1.getClass();
        ShoppingAsyncInflater r3 = ShoppingAsyncInflater.a.a(r2);
        View r4 = a0();
        if (r4 == null) goto L157;
        View r5 = r3.aU(2131560870, (ViewGroup) r4, false);
        View r6 = a0();
        if (r6 == null) goto L155;
        ((ViewGroup) r6).addView(r5);
        com.bytedance.android.shopping.store.home.frame.presenter.e r7 = this.h;
        ShopContainerType r8 = ShopContainerType.LIVE_PREVIEW_CONTAINER;
        View r9 = r7.c(r8);
        ECUrlModel r10 = null;
        if ((r9 instanceof ViewGroup) == true) goto L9;
        r9 = null;
    L9:
        ViewGroup r11 = (ViewGroup) r9;
        if (r11 == null) goto L13;
        this.k = r11;
        this.l = (ViewGroup) a0().findViewById(2131370883);
        this.m = (ViewGroup) a0().findViewById(2131372882);
        this.n = a0().findViewById(2131376720);
        this.o = (ViewGroup) a0().findViewById(2131370884);
        this.p = a0().findViewById(2131370885);
        this.q = a0().findViewById(2131370755);
        this.r = a0().findViewById(2131370752);
        this.s = a0().findViewById(2131370753);
        this.t = a0().findViewById(2131370754);
    L13:
        ECShopVideoPreviewGroupPresenter.b r12 = l0();
        if (r12 == null) goto L16;
        FrameLayout.LayoutParams r13 = new FrameLayout.LayoutParams(-1, com.bytedance.android.shopping.extensions.b.b(264));
        r13.gravity = 80;
        r13.bottomMargin = 0;
        Unit r14 = Unit.INSTANCE;
        Drawable r15 = th.a.e(r12.a, true).getDrawable(2131248297);
        FrameLayout.LayoutParams r16 = new FrameLayout.LayoutParams(-1, com.bytedance.android.shopping.extensions.b.b(47));
        r16.gravity = 80;
        r16.bottomMargin = 0;
        GradientDrawable r17 = new GradientDrawable();
        qc3.a.f(r17, new int[]{0, 1291845632});
        GradientDrawable r18 = new GradientDrawable();
        qc3.a.f(r18, new int[]{(int) 2147483648L, 0});
        r r20 = new r();
        r20.a = r15;
        r20.b = r16;
        r20.c = r17;
        r20.d = r13;
        r20.e = r18;
    L17:
        if (r20 == null) goto L19;
        Drawable r21 = r20.e;
    L20:
        if (r21 == null) goto L25;
        View r22 = this.q;
        if (r22 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("videoTopMask");
    L24:
        qc3.a.e(r22, r21);
    L25:
        if (r20 == null) goto L27;
        Drawable r23 = r20.c;
    L28:
        if (r20 == null) goto L30;
        FrameLayout.LayoutParams r24 = r20.d;
    L32:
        if (r23 == null) goto L37;
        View r110 = this.r;
        if (r110 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("bottomInfoAreaMask");
    L36:
        qc3.a.e(r110, r23);
    L37:
        if (r24 == null) goto L42;
        View r25 = this.r;
        if (r25 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("bottomInfoAreaMask");
    L41:
        r25.setLayoutParams(r24);
    L42:
        if (r20 == null) goto L44;
        Drawable r26 = r20.a;
    L45:
        if (r20 == null) goto L47;
        FrameLayout.LayoutParams r27 = r20.b;
    L49:
        if (r26 == null) goto L54;
        View r28 = this.s;
        if (r28 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("bottomGradualMask");
    L53:
        r28.setBackground(r26);
    L54:
        if (r27 == null) goto L59;
        View r29 = this.s;
        if (r29 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("bottomGradualMask");
    L58:
        r29.setLayoutParams(r27);
    L59:
        ViewGroup r30 = this.k;
        if (r30 != null) goto L62;
        Intrinsics.throwUninitializedPropertyAccessException("videoContainer");
    L62:
        int r31 = r30.getLayoutParams().width;
        ECShopVideoPreviewGroupPresenter.b r32 = l0();
        if (r32 == null) goto L65;
        int r33 = th.a.e(r32.a, true).getResources().getDimensionPixelSize(2131166417);
    L66:
        this.h.a(r8, new vi3.c(r31, r33));
        if (l0() == null) goto L72;
        ECHeaderSlideIndicator r34 = this.t;
        if (r34 != null) goto L71;
        Intrinsics.throwUninitializedPropertyAccessException("slideIndicator");
    L71:
        r34.setVisibility(0);
    L76:
        ECHeaderSlideIndicator r35 = this.t;
        if (r35 != null) goto L79;
        Intrinsics.throwUninitializedPropertyAccessException("slideIndicator");
    L79:
        r35.setText(2131896860);
        ShopHeaderVideoVO r36 = this.C;
        String r37 = "";
        if (r36 == null) goto L100;
        List<ShopHeaderVideoInfoVO> r38 = r36.getFeedData();
        if (r38 == null) goto L100;
        Iterator<T> r39 = r38.iterator();
    L85:
        if (r39.hasNext() == false) goto L100;
        String r40 = ((ShopHeaderVideoInfoVO) r39.next()).getAwemedata();
        if (r40 == null) goto L85;
        int r41 = com.bytedance.android.ec.store.utils.h.a;
        Aweme r42 = (Aweme) GsonProtectorUtils.fromJson(new Gson(), r40, new l().getType());
        String r43 = r42.getAwemeId();
        if (r43 != null) goto L91;
        r43 = "";
    L91:
        boolean r44 = ECServiceManager.a;
        s83.f r45 = ((s83.g) ECServiceManager.c(s83.g.class)).p();
        if (r45 == null) goto L94;
        r45.r(r43);
    L94:
        ((ArrayList) this.x).add(r43);
        Map<String, String> r46 = this.y;
        Author r47 = r42.getAuthor();
        if (r47 == null) goto L98;
        String r48 = r47.getUid();
        if (r48 == null) goto L98;
    L99:
        r46.put(r43, r48);
    L98:
        r48 = "";
    L100:
        ShopHeaderVideoVO r49 = this.C;
        if (r49 == null) goto L141;
        List<ShopHeaderVideoInfoVO> r50 = r49.getFeedData();
        if (r50 == null) goto L141;
        ShopHeaderVideoInfoVO r51 = (ShopHeaderVideoInfoVO) CollectionsKt.first(r50);
        if (r51 == null) goto L141;
        String r52 = r51.getAwemedata();
        if (r52 == null) goto L141;
        int r53 = com.bytedance.android.ec.store.utils.h.a;
        Aweme r54 = (Aweme) GsonProtectorUtils.fromJson(new Gson(), r52, new m().getType());
        ECShopHeaderVideoManager r55 = m0();
        if (r55 == null) goto L111;
        r55.b(this.x);
    L111:
        SimpleDraweeView r111 = this.n;
        if (r111 != null) goto L114;
        Intrinsics.throwUninitializedPropertyAccessException("videoCover");
    L114:
        Video r56 = r54.getVideo();
        if (r56 == null) goto L117;
        r10 = r56.getOriginCover();
    L117:
        h0.d(r111, r10, null, null, null, null, null, 120);
        ViewGroup r57 = this.o;
        if (r57 != null) goto L120;
        Intrinsics.throwUninitializedPropertyAccessException("videoElementLayer");
    L120:
        r57.setVisibility(0);
        ECShopHeaderVideoManager r58 = m0();
        if (r58 == null) goto L129;
        Context r59 = Y().c();
        ViewGroup r60 = this.m;
        if (r60 != null) goto L125;
        Intrinsics.throwUninitializedPropertyAccessException("videoSceneContainer");
    L125:
        SimpleDraweeView r112 = this.n;
        if (r112 != null) goto L128;
        Intrinsics.throwUninitializedPropertyAccessException("videoCover");
    L128:
        r58.f(r59, r60, r112);
    L129:
        this.u = true;
        ECShopHeaderVideoManager r61 = m0();
        if (r61 == null) goto L133;
        String r62 = r61.b;
        if (r62 == null) goto L133;
    L134:
        ECShopVideoPreviewGroupPresenter.a r63 = (ECShopVideoPreviewGroupPresenter.a) this.A.getValue();
        if (r63 == null) goto L141;
        Pair[] r64 = new Pair[2];
        r64[0] = TuplesKt.to("video_id", r62);
        String r65 = (String) ((LinkedHashMap) this.y).get(r62);
        if (r65 == null) goto L140;
        r37 = r65;
    L140:
        r64[1] = TuplesKt.to("author_id", r37);
        Intrinsics.checkNotNullParameter("store_video_show", "eventName");
        Intrinsics.checkNotNullParameter(r64, "params");
        r63.a.doEventAction("store_video_show", (Pair[]) Arrays.copyOf(r64, 2));
    L133:
        r62 = "";
    L141:
        View r66 = this.p;
        if (r66 != null) goto L144;
        Intrinsics.throwUninitializedPropertyAccessException("soundBtn");
    L144:
        r66.setOnClickListener(this);
        ViewGroup r67 = this.o;
        if (r67 != null) goto L147;
        Intrinsics.throwUninitializedPropertyAccessException("videoElementLayer");
    L147:
        r67.setOnClickListener(this);
        ECShopHeaderVideoManager r68 = m0();
        if (r68 == null) goto L152;
        jm.a<Boolean> r69 = r68.f;
        if (r69 == null) goto L152;
        r69.a(h0(), new n(this), false);
    L152:
        this.D = true;
        e0().addObserver(this);
        return;
    L72:
        ECHeaderSlideIndicator r70 = this.t;
        if (r70 != null) goto L75;
        Intrinsics.throwUninitializedPropertyAccessException("slideIndicator");
    L75:
        r70.setVisibility(8);
        goto L76
    L65:
        r33 = 0;
        goto L66
    L47:
        r27 = null;
        goto L49
    L44:
        r26 = null;
        goto L45
    L30:
        r24 = null;
        goto L32
    L27:
        r23 = null;
        goto L28
    L19:
        r21 = null;
        goto L20
    L16:
        r20 = null;
        goto L17
    L155:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L157:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    public final void k0(int r9) {
        if (this.w == false) goto L5;
        return;
    L5:
        this.w = true;
        Context r1 = Y().c();
        if (r9 == 0) goto L10;
        if (r9 != 1) goto L10;
        String r2 = "slide";
    L12:
        if (r9 == 1) goto L14;
        ECShopHeaderVideoManager r10 = m0();
        if (r10 == null) goto L31;
        ViewGroup r5 = this.m;
        if (r5 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("videoSceneContainer");
    L30:
        r10.a(r1, r5, ((QFragmentPresenter) this).e);
    L31:
        ECShopHeaderVideoManager r11 = m0();
        String r3 = "";
        if (r11 == null) goto L35;
        String r12 = r11.b;
        if (r12 == null) goto L35;
    L36:
        String r4 = (String) ((LinkedHashMap) this.y).get(r12);
        if (r4 == null) goto L40;
        r3 = r4;
    L40:
        ECShopVideoPreviewGroupPresenter.a r6 = (ECShopVideoPreviewGroupPresenter.a) this.A.getValue();
        if (r6 == null) goto L44;
        Intrinsics.checkNotNullParameter(r12, "videoId");
        Intrinsics.checkNotNullParameter(r3, "authorId");
        Intrinsics.checkNotNullParameter(r2, "clickType");
        r6.a.getVideoManager().h.setValue(Boolean.TRUE);
        r6.a.doEventAction("store_video_click", new Pair[]{TuplesKt.to("video_id", r12), TuplesKt.to("click_type", r2), TuplesKt.to("author_id", r3)});
        return;
    L44:
        return;
    L35:
        r12 = "";
        goto L36
    L14:
        if (this.v == true) goto L31;
        this.v = true;
        ECShopVideoPreviewGroupPresenter.a r13 = (ECShopVideoPreviewGroupPresenter.a) this.A.getValue();
        if (r13 == null) goto L19;
        r13.a.getChangeStateEvent().setValue(new ui3.c(5, ShopStatus.HIDE, 2));
    L19:
        ECShopHeaderVideoManager r14 = m0();
        if (r14 == null) goto L31;
        ViewGroup r7 = this.m;
        if (r7 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("videoSceneContainer");
    L24:
        r14.a(r1, r7, ((QFragmentPresenter) this).e);
    L10:
        r2 = PinchEnterMethod.CLICK;
        goto L12
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r8) {
        Intrinsics.checkNotNullParameter(r8, "v");
        int r0 = kn.a.a;
        if (kn.a.a(r8.getId()) == true) goto L37;
        ECShopVideoPreviewGroupPresenter.b r1 = l0();
        if (r1 != null) goto L7;
    L9:
        int r9 = r8.getId();
        if (r9 != 2131370885) goto L34;
        ECShopHeaderVideoManager r10 = m0();
        if (r10 != null) goto L14;
    L17:
        ECShopHeaderVideoManager r11 = m0();
        String r2 = null;
        if (r11 == null) goto L22;
        jm.a<Boolean> r12 = r11.f;
        if (r12 == null) goto L22;
        Boolean r13 = (Boolean) r12.getValue();
    L23:
        ECShopVideoPreviewGroupPresenter.a r3 = (ECShopVideoPreviewGroupPresenter.a) this.A.getValue();
        if (r3 == null) goto L38;
        Pair[] r5 = new Pair[2];
        ECShopHeaderVideoManager r6 = m0();
        if (r6 == null) goto L28;
        r2 = r6.b;
    L28:
        r5[0] = TuplesKt.to("video_id", r2);
        if (Intrinsics.areEqual(r13, Boolean.FALSE) == false) goto L31;
        String r14 = "on";
    L32:
        r5[1] = TuplesKt.to("status_to", r14);
        Intrinsics.checkNotNullParameter("store_video_audio_click", "eventName");
        Intrinsics.checkNotNullParameter(r5, "params");
        r3.a.doEventAction("store_video_audio_click", (Pair[]) Arrays.copyOf(r5, 2));
        return;
    L31:
        r14 = "off";
        goto L32
    L38:
        return;
    L22:
        r13 = null;
        goto L23
    L14:
        if (r10.c() == false) goto L16;
        r10.i();
        goto L17
    L16:
        r10.d();
        goto L17
    L34:
        if (r9 != 2131370884) goto L40;
        k0(0);
        return;
    L40:
        return;
    L7:
        if ((!r1.b.getStoreParam().isPreview()) == true) goto L9;
        return;
    }

    @Override // com.bytedance.android.shopping.store.home.presenter.preview.q
    public final void O(float r4, int r5, boolean r6, int r7, boolean r8) {
        int r9 = 0;
        if (r4 < 1.0f) goto L5;
        int r10 = 4;
    L6:
        ViewGroup r0 = this.k;
        if (r0 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("videoContainer");
    L10:
        if (r0.getVisibility() == r10) goto L15;
        ViewGroup r1 = this.k;
        if (r1 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("videoContainer");
    L14:
        r1.setVisibility(r10);
    L15:
        ViewGroup r2 = this.l;
        if (r2 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("videoContainerLayer");
    L19:
        if (r2.getVisibility() == r10) goto L24;
        ViewGroup r3 = this.l;
        if (r3 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("videoContainerLayer");
    L23:
        r3.setVisibility(r10);
    L24:
        if (r10 != 0) goto L28;
        ECShopHeaderVideoManager r11 = m0();
        if (r11 == null) goto L32;
        r11.h();
    L32:
        if (r4 > 0) goto L51;
        int r12 = r5 * (-1);
        if (r12 >= 0) goto L38;
        return;
    L38:
        if (r12 > this.j) goto L40;
    L43:
        ViewGroup r13 = this.k;
        if (r13 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("videoContainer");
    L46:
        ECShopVideoPreviewGroupPresenter.b r14 = l0();
        if (r14 == null) goto L49;
        r9 = th.a.e(r14.a, true).getResources().getDimensionPixelSize(2131166417);
    L49:
        wg.a.d(r13, r9 + r12);
        return;
    L40:
        if (this.w == true) goto L43;
        if (r7 != 1) goto L43;
        k0(1);
        goto L43
    L51:
        return;
    L28:
        ECShopHeaderVideoManager r15 = m0();
        if (r15 == null) goto L32;
        r15.e();
        goto L32
    L5:
        r10 = 0;
        goto L6
    }
}
