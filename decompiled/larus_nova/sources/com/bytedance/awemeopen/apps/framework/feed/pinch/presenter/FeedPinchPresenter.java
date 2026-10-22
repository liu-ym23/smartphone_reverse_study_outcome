package com.bytedance.awemeopen.apps.framework.feed.pinch.presenter;

import android.content.ComponentCallbacks2;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.awemeopen.apps.framework.base.view.VideoViewHolderRootView;
import com.bytedance.awemeopen.apps.framework.base.view.verticalviewPager.VerticalViewPager;
import com.bytedance.awemeopen.apps.framework.feed.AosEventReporter;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.presenter.photo.PhotoFeedProgressPresenter;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.presenter.photo.PhotoFeedProgressPresenter$observePinchEvent$1;
import com.bytedance.awemeopen.apps.framework.feed.pinch.vm.FeedSpeedControlViewModel;
import com.bytedance.awemeopen.apps.framework.feed.pinch.vm.PinchStateViewModel;
import com.bytedance.awemeopen.apps.framework.framework.livedata.DiscardFirstValueLiveData;
import com.bytedance.awemeopen.apps.framework.player.FullVideoView;
import com.bytedance.awemeopen.apps.photo.pinch.PinchStableView;
import com.bytedance.awemeopen.bizmodels.profile.User;
import com.larus.nova.R;
import java.util.LinkedHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class FeedPinchPresenter extends g04.a<jz3.a> {
    public long A;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a f195652e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public r14.c f195653f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public qz3.c f195654g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public qz3.d f195655h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public com.bytedance.awemeopen.apps.framework.feed.pinch.utils.m f195656i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f195657j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public e f195658k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public f f195659l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public h f195660m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public FeedSpeedControlViewModel f195661n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public g f195662o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f195663p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f195664q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final FeedPinchPresenter$viewpagerTouchListener$1 f195665r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public CopyOnWriteArrayList<o54.a> f195666s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f195667t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f195668u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public i f195669v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f195670w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Lazy f195671x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final d f195672y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f195673z;

    @Override // g04.a
    public final void g() {
        ViewGroup r100 = this.f195652e.f195162b;
        VerticalViewPager r101 = null;
        if ((r100 instanceof VerticalViewPager) == false) goto L5;
        VerticalViewPager r102 = (VerticalViewPager) r100;
    L6:
        if (r102 == null) goto L14;
        int r103 = r102.getChildCount();
        int r104 = 0;
    L9:
        if (r104 >= r103) goto L14;
        View r105 = r102.getChildAt(r104);
        if (r105 == null) goto L13;
        r105.setVisibility(0);
        r105.setAlpha(1.0f);
    L13:
        r104 = r104 + 1;
    L14:
        com.bytedance.awemeopen.apps.framework.feed.pinch.utils.m r106 = this.f195656i;
        if (r106 == null) goto L17;
        r106.f195857r = true;
    L17:
        ViewGroup r107 = this.f195652e.f195162b;
        if ((r107 instanceof VerticalViewPager) == false) goto L20;
        r101 = (VerticalViewPager) r107;
    L20:
        if (r101 == null) goto L26;
        this.f195673z = r101.getCurrentItem();
        return;
    L26:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // g04.a
    public final void h() {
        View r100 = this.f479457a;
        VerticalViewPager r101 = null;
        if ((r100 instanceof VideoViewHolderRootView) == false) goto L5;
        VideoViewHolderRootView r102 = (VideoViewHolderRootView) r100;
    L6:
        if (r102 == null) goto L9;
        r102.setPinchListener(null);
    L9:
        com.bytedance.awemeopen.apps.framework.feed.pinch.utils.m r103 = this.f195656i;
        if (r103 == null) goto L12;
        r103.u();
    L12:
        com.bytedance.awemeopen.apps.framework.feed.pinch.utils.m r104 = this.f195656i;
        if (r104 == null) goto L16;
        r104.f195856q = null;
    L16:
        CopyOnWriteArrayList<o54.a> r105 = this.f195666s;
        if (r105 == null) goto L19;
        r105.clear();
    L19:
        this.f195666s = null;
        ViewGroup r106 = this.f195652e.f195162b;
        if ((r106 instanceof VerticalViewPager) == false) goto L22;
        r101 = (VerticalViewPager) r106;
    L22:
        if (r101 == null) goto L24;
        r101.v(this.f195665r);
    L24:
        e r107 = this.f195658k;
        if (r107 == null) goto L34;
        com.bytedance.awemeopen.apps.framework.feed.pinch.utils.m r108 = this.f195656i;
        if (r108 == null) goto L34;
        sz3.c r109 = r108.f195843d;
        if (r109 == null) goto L34;
        qz3.b r110 = r109.f543933i;
        if (r110 == null) goto L34;
        r110.r(r107);
    L34:
        if (this.f195659l == null) goto L36;
        DiscardFirstValueLiveData<Boolean> r111 = this.f195652e.f195163c.getEnterPinchMode();
        f r112 = this.f195659l;
        Intrinsics.checkNotNull(r112);
        r111.removeObserver(r112);
    L36:
        g r113 = this.f195662o;
        if (r113 == null) goto L43;
        FeedSpeedControlViewModel r114 = this.f195661n;
        if (r114 == null) goto L43;
        MutableLiveData<Pair<String, Boolean>> r115 = r114.getFastSpeedModeEvent();
        if (r115 == null) goto L43;
        r115.removeObserver(r113);
    L43:
        h r116 = this.f195660m;
        if (r116 == null) goto L52;
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r117 = this.f195652e;
        if (r117 == null) goto L52;
        com.bytedance.awemeopen.apps.framework.framework.viewpager.o r118 = r117.f195163c;
        if (r118 == null) goto L52;
        DiscardFirstValueLiveData<Boolean> r119 = r118.getLoadMoreUiShow();
        if (r119 == null) goto L52;
        r119.removeObserver(r116);
    L52:
        i r120 = this.f195669v;
        if (r120 == null) goto L57;
        MutableLiveData<Integer> r121 = this.f195652e.f195163c.getSlidesProgressPosition();
        if (r121 == null) goto L57;
        r121.removeObserver(r120);
    L57:
        qz3.d r122 = this.f195655h;
        if (r122 == null) goto L61;
        r122.h(this.f195672y);
        return;
    L61:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // g04.a
    public final void i() {
        com.bytedance.awemeopen.apps.framework.feed.pinch.utils.m r100 = this.f195656i;
        boolean r101 = true;
        if (r100 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        Integer r103 = null;
        if (r102 == false) goto L13;
        qz3.d r104 = this.f195655h;
        if (r104 == null) goto L13;
        r104.x(null, false, 0.0f);
    L13:
        qz3.d r105 = this.f195655h;
        if (r105 != null) goto L16;
    L18:
        r101 = false;
    L19:
        if (r101 == false) goto L39;
        ViewGroup r106 = this.f195652e.f195162b;
        if ((r106 instanceof VerticalViewPager) == false) goto L23;
        VerticalViewPager r107 = (VerticalViewPager) r106;
    L24:
        if (r107 == null) goto L26;
        r103 = Integer.valueOf(r107.getCurrentItem());
    L26:
        if (r103 != null) goto L28;
    L35:
        String r108 = "slide";
    L36:
        qz3.d r109 = this.f195655h;
        if (r109 == null) goto L39;
        r109.z(new sz3.a(Boolean.TRUE, r108));
        goto L39
    L28:
        if (this.f195673z < 0) goto L35;
        if (r103.intValue() <= this.f195673z) goto L33;
        r108 = PinchStableView.Gesture.PULL_UP;
        goto L36
    L33:
        if (r103.intValue() >= this.f195673z) goto L35;
        r108 = "slide_down";
        goto L36
    L23:
        r107 = null;
    L39:
        com.bytedance.awemeopen.apps.framework.feed.pinch.utils.m r110 = this.f195656i;
        if (r110 == null) goto L43;
        r110.f195857r = false;
        return;
    L43:
        return;
    L16:
        if (r105.B() != true) goto L18;
    L5:
        if (r100.f195841b != true) goto L7;
        r102 = true;
        goto L8
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.bytedance.awemeopen.apps.framework.feed.pinch.presenter.d] */
    /* JADX WARN: Type inference failed for: r2v2, types: [com.bytedance.awemeopen.apps.framework.feed.pinch.presenter.FeedPinchPresenter$viewpagerTouchListener$1] */
    public FeedPinchPresenter(com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r100) {
        Intrinsics.checkNotNullParameter(r100, "feedGroupParameters");
        super(r100.f195161a);
        this.f195652e = r100;
        this.f195663p = true;
        this.f195665r = new FeedPinchPresenter$viewpagerTouchListener$1(this);
        this.f195668u = -1;
        this.f195671x = LazyKt.lazy(new FeedPinchPresenter$photoFeedPagerPresenter$2(this));
        this.f195672y = new d(this);
        this.f195673z = -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v62, types: [androidx.lifecycle.Observer, com.bytedance.awemeopen.apps.framework.feed.pages.recommend.presenter.photo.PhotoFeedProgressPresenter$observePinchEvent$1, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v63, types: [androidx.lifecycle.Observer, com.bytedance.awemeopen.apps.framework.feed.pages.recommend.presenter.photo.o, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v4, types: [androidx.lifecycle.Observer, com.bytedance.awemeopen.apps.framework.feed.pinch.presenter.e, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v2, types: [com.bytedance.awemeopen.apps.framework.feed.pinch.presenter.f] */
    /* JADX WARN: Type inference failed for: r2v3, types: [com.bytedance.awemeopen.apps.framework.feed.pinch.presenter.g] */
    /* JADX WARN: Type inference failed for: r8v28, types: [com.bytedance.awemeopen.apps.framework.feed.pinch.presenter.h] */
    /* JADX WARN: Type inference failed for: r8v57, types: [com.bytedance.awemeopen.apps.framework.feed.pinch.presenter.i] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // g04.a
    public final void f(jz3.a r100) {
        jz3.a r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "data");
        boolean r102 = false;
        if (r101.f501173a.c().length() != 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == true) goto L127;
        this.f195653f = r101.f501173a;
        View r104 = this.f479457a;
        LifecycleOwner r105 = null;
        if ((r104 instanceof VideoViewHolderRootView) == false) goto L11;
        VideoViewHolderRootView r106 = (VideoViewHolderRootView) r104;
    L12:
        if (r106 == null) goto L15;
        r106.setPinchListener(new c(this));
    L15:
        this.f195655h = new qz3.d();
        this.f195654g = new qz3.c();
        com.bytedance.awemeopen.apps.framework.feed.pinch.utils.m r107 = new com.bytedance.awemeopen.apps.framework.feed.pinch.utils.m();
        r107.f195840a = this.f195652e;
        this.f195656i = r107;
        r14.c r108 = this.f195653f;
        Intrinsics.checkNotNull(r108);
        int r109 = com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.c.a(r108);
        if (r109 == 1) goto L18;
    L19:
        if (r109 == 3) goto L21;
    L23:
        boolean r110 = false;
    L24:
        this.f195667t = r110;
        r14.c r111 = this.f195653f;
        if (r111 != null) goto L27;
    L29:
        boolean r112 = false;
    L30:
        if (r112 == false) goto L63;
        View r113 = iz3.a.b(this.f195652e);
        if (r113 == null) goto L36;
        ViewGroup r114 = (FrameLayout) r113.findViewById(R.id.supportSeekBarFL);
        if (r114 == null) goto L36;
    L40:
        final sz3.c r115 = new sz3.c();
        r115.f543930f = this.f195653f;
        r115.f543931g = r101;
        r115.f543932h = this.f195654g;
        r115.f543933i = this.f195655h;
        r115.f543934j = new FeedPinchPresenter$bindSlides$pinchParams$1$1(this);
        r115.f543939o = Boolean.valueOf(this.f195667t);
        r115.f543925a = this.f195652e.getActivity();
        r115.f543929e = this.f195652e.f195163c.sceneId();
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r116 = this.f195652e;
        r115.f543926b = r116.f195165e.f195172d;
        r115.f543927c = r116.f195163c;
        r115.f543935k = r114;
        PinchStateViewModel.a r117 = PinchStateViewModel.Companion;
        ComponentCallbacks2 r118 = r116.getActivity();
        if ((r118 instanceof LifecycleOwner) == false) goto L43;
        LifecycleOwner r119 = (LifecycleOwner) r118;
    L44:
        if (r119 != null) goto L46;
        r119 = this.f195652e.f195165e.f195172d;
    L46:
        r117.getClass();
        r115.f543937m = PinchStateViewModel.a.a(r119);
        r115.f543940p = new FeedPinchPresenter$bindSlides$pinchParams$1$2(this);
        com.bytedance.awemeopen.apps.framework.feed.pinch.utils.m r120 = this.f195656i;
        if (r120 == null) goto L49;
        r120.n(r115);
    L49:
        this.f195669v = new i(this);
        MutableLiveData<Integer> r121 = this.f195652e.f195163c.getSlidesProgressPosition();
        if (r121 == null) goto L52;
        LifecycleOwner r122 = this.f195652e.f195165e.f195172d;
        i r123 = this.f195669v;
        Intrinsics.checkNotNull(r123);
        r121.observe(r122, r123);
    L52:
        qz3.d r124 = this.f195655h;
        if (r124 == null) goto L55;
        r124.i(this.f195652e.f195165e.f195172d, this.f195672y);
    L55:
        final PhotoFeedProgressPresenter r125 = (PhotoFeedProgressPresenter) c(PhotoFeedProgressPresenter.class);
        if (r125 == null) goto L79;
        Intrinsics.checkNotNullParameter(r115, "pinchParams");
        r125.f195600r = r115;
        ?? r126 = new PhotoFeedProgressPresenter$observePinchEvent$1(r125);
        r125.f195601s = r126;
        qz3.b r127 = r115.f543933i;
        if (r127 == 0) goto L60;
        LifecycleOwner r128 = r115.f543926b;
        Intrinsics.checkNotNull(r126);
        r127.C(r128, r126);
    L60:
        ?? r129 = new com.bytedance.awemeopen.apps.framework.feed.pages.recommend.presenter.photo.o(r125);
        r125.f195602t = r129;
        qz3.b r130 = r115.f543933i;
        if (r130 == 0) goto L79;
        LifecycleOwner r131 = r115.f543926b;
        Intrinsics.checkNotNull(r129);
        r130.i(r131, r129);
    L79:
        com.bytedance.awemeopen.apps.framework.feed.pinch.utils.m r132 = this.f195656i;
        if (r132 == null) goto L83;
        r132.f195856q = new FeedPinchPresenter$bindPinch$2(this);
    L83:
        ViewGroup r133 = this.f195652e.f195162b;
        if ((r133 instanceof VerticalViewPager) == false) goto L86;
        final VerticalViewPager r134 = (VerticalViewPager) r133;
    L87:
        if (r134 == null) goto L89;
        r134.c(this.f195665r);
    L89:
        if (r134 == null) goto L91;
        boolean r135 = r134.P0;
    L92:
        this.f195657j = r135;
        ComponentCallbacks2 r136 = this.f195652e.getActivity();
        if ((r136 instanceof o54.a) == false) goto L95;
        o54.a r137 = (o54.a) r136;
    L96:
        if (r137 == null) goto L109;
        Intrinsics.checkNotNullParameter(r137, "pinchObserver");
        if (this.f195666s != null) goto L100;
        this.f195666s = new CopyOnWriteArrayList();
    L100:
        CopyOnWriteArrayList<o54.a> r138 = this.f195666s;
        if (r138 != null) goto L103;
    L105:
        if (r102 == false) goto L109;
        CopyOnWriteArrayList<o54.a> r139 = this.f195666s;
        if (r139 == null) goto L109;
        r139.add(r137);
        goto L109
    L103:
        if (r138.contains(r137) == true) goto L105;
        r102 = true;
    L109:
        LifecycleOwner r140 = r115.f543926b;
        FeedSpeedControlViewModel.a r141 = FeedSpeedControlViewModel.Companion;
        ComponentCallbacks2 r142 = r115.getActivity();
        if ((r142 instanceof LifecycleOwner) == false) goto L112;
        r105 = (LifecycleOwner) r142;
    L112:
        if (r105 != null) goto L114;
        r105 = r140;
    L114:
        r141.getClass();
        this.f195661n = FeedSpeedControlViewModel.a.a(r105, "");
        ?? r143 = new e(r134, this);
        this.f195658k = r143;
        this.f195659l = new f(this);
        this.f195662o = new g(this, r115, r134);
        this.f195660m = new h(this);
        if (r140 == null) goto L126;
        qz3.b r144 = r115.f543933i;
        if (r144 == 0) goto L119;
        Intrinsics.checkNotNull(r143);
        r144.u(r140, r143);
    L119:
        DiscardFirstValueLiveData<Boolean> r145 = this.f195652e.f195163c.getEnterPinchMode();
        f r146 = this.f195659l;
        Intrinsics.checkNotNull(r146);
        r145.observe(r140, r146);
        FeedSpeedControlViewModel r147 = this.f195661n;
        if (r147 == null) goto L124;
        MutableLiveData<Pair<String, Boolean>> r148 = r147.getFastSpeedModeEvent();
        if (r148 == null) goto L124;
        g r149 = this.f195662o;
        Intrinsics.checkNotNull(r149);
        r148.observe(r140, r149);
    L124:
        DiscardFirstValueLiveData<Boolean> r150 = this.f195652e.f195163c.getLoadMoreUiShow();
        h r151 = this.f195660m;
        Intrinsics.checkNotNull(r151);
        r150.observe(r140, r151);
        return;
    L126:
        return;
    L95:
        r137 = null;
        goto L96
    L91:
        r135 = false;
        goto L92
    L86:
        r134 = null;
        goto L87
    L43:
        r119 = null;
    L36:
        View r152 = this.f195652e.f195165e.f195170b;
        if ((r152 instanceof ViewGroup) == false) goto L39;
        r114 = (ViewGroup) r152;
        goto L40
    L39:
        r114 = null;
        goto L40
    L63:
        View r153 = this.f195652e.f195165e.f195170b;
        if ((r153 instanceof ViewGroup) == false) goto L66;
        ViewGroup r154 = (ViewGroup) r153;
    L67:
        r115 = new sz3.c();
        r115.f543930f = this.f195653f;
        r115.f543931g = r101;
        r115.f543932h = this.f195654g;
        r115.f543933i = this.f195655h;
        r115.f543934j = new FeedPinchPresenter$bindVideo$pinchParams$1$1(this);
        r115.f543939o = Boolean.valueOf(this.f195667t);
        r115.f543925a = this.f195652e.getActivity();
        r115.f543929e = this.f195652e.f195163c.sceneId();
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r155 = this.f195652e;
        r115.f543926b = r155.f195165e.f195172d;
        r115.f543927c = r155.f195163c;
        r115.f543935k = r154;
        r115.f543936l = ((FullVideoView) this.f479457a.findViewById(R.id.item_feeditem_videoview)).getVideoView().getCustomPlayer();
        PinchStateViewModel.a r156 = PinchStateViewModel.Companion;
        ComponentCallbacks2 r157 = this.f195652e.getActivity();
        if ((r157 instanceof LifecycleOwner) == false) goto L70;
        LifecycleOwner r158 = (LifecycleOwner) r157;
    L71:
        if (r158 != null) goto L73;
        r158 = this.f195652e.f195165e.f195172d;
    L73:
        r156.getClass();
        r115.f543937m = PinchStateViewModel.a.a(r158);
        com.bytedance.awemeopen.apps.framework.feed.pinch.utils.m r159 = this.f195656i;
        if (r159 == null) goto L76;
        r159.n(r115);
    L76:
        qz3.d r160 = this.f195655h;
        if (r160 == null) goto L79;
        r160.i(this.f195652e.f195165e.f195172d, this.f195672y);
        goto L79
    L70:
        r158 = null;
        goto L71
    L66:
        r154 = null;
        goto L67
    L27:
        if (com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.c.a(r111) != 3) goto L29;
        r112 = true;
        goto L30
    L21:
        if (com.bytedance.awemeopen.apps.framework.feed.ui.information.a.f196001m == false) goto L23;
    L22:
        r110 = true;
        goto L24
    L18:
        if (com.bytedance.awemeopen.apps.framework.feed.ui.information.a.f195999k == true) goto L22;
    L11:
        r106 = null;
        goto L12
    L127:
        return;
    L5:
        r103 = false;
        goto L6
    }

    public final void m(boolean r100) {
        int r101 = 0;
        if (r100 == false) goto L5;
        int r102 = 4;
    L6:
        ViewGroup r103 = this.f195652e.f195162b;
        if ((r103 instanceof VerticalViewPager) == false) goto L9;
        VerticalViewPager r104 = (VerticalViewPager) r103;
    L10:
        if (r104 != null) goto L12;
        return;
    L12:
        int r105 = r104.getChildCount();
    L13:
        if (r101 >= r105) goto L24;
        View r106 = r104.getChildAt(r101);
        boolean r107 = Intrinsics.areEqual(this.f479457a, r106);
        if (r106 == null) goto L23;
        if (r107 == false) goto L18;
        if (r100 == true) goto L23;
    L18:
        r106.setVisibility(r102);
        if (r100 == false) goto L21;
        float r108 = 0.0f;
    L22:
        r106.setAlpha(r108);
        goto L23
    L21:
        r108 = 1.0f;
    L23:
        r101 = r101 + 1;
        goto L13
    L24:
        return;
    L9:
        r104 = null;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final void n(boolean r100, String r101) {
        LinkedHashMap r102 = new LinkedHashMap();
        r102.put("enter_from", this.f195652e.f195163c.sceneId());
        r14.c r103 = this.f195653f;
        if (r103 == null) goto L6;
        String r104 = r103.c();
        if (r104 == null) goto L6;
    L7:
        r102.put("group_id", r104);
        r14.c r105 = this.f195653f;
        if (r105 == null) goto L13;
        User r106 = r105.f();
        if (r106 == null) goto L13;
        String r107 = r106.u();
        if (r107 == null) goto L13;
    L14:
        r102.put("author_id", r107);
        if (r100 == false) goto L19;
        if (r101 != null) goto L18;
        r101 = "";
    L18:
        r102.put("enter_method", r101);
    L41:
        if (r100 == false) goto L43;
        this.A = System.currentTimeMillis();
    L44:
        com.bytedance.awemeopen.apps.framework.feed.pinch.utils.m r108 = this.f195656i;
        float r109 = 1.0f;
        if (r108 == null) goto L51;
        sz3.c r110 = r108.f195843d;
        if (r110 == null) goto L51;
        com.bytedance.awemeopen.infra.base.player.g r111 = r110.f543936l;
        if (r111 == null) goto L51;
        float r112 = r111.getPlaySpeed();
    L52:
        r102.put("to_status", Float.valueOf(r112));
        com.bytedance.awemeopen.apps.framework.feed.pinch.utils.m r113 = this.f195656i;
        if (r113 == null) goto L55;
        r109 = r113.f195849j.f195761w;
    L55:
        r102.put("zoom_size", Float.valueOf(r109));
        AosEventReporter.s(AosEventReporter.f194596a, "pure_clear_screen_mode", r102, null, null, null, 28);
        return;
    L51:
        r112 = 1.0f;
        goto L52
    L43:
        r102.put("duration", Long.valueOf(System.currentTimeMillis() - this.A));
        goto L44
    L19:
        if (r101 == null) goto L38;
        int r114 = r101.hashCode();
        if (r114 == (-1377687758)) goto L35;
        if (r114 == (-1272607767)) goto L31;
        if (r114 != 1089111664) goto L38;
        if (r101.equals("slide_down") == false) goto L38;
    L33:
        r101 = "slide";
    L40:
        r102.put("exit_method", r101);
        goto L41
    L31:
        if (r101.equals(PinchStableView.Gesture.PULL_UP) == true) goto L33;
    L35:
        if (r101.equals("button") == false) goto L38;
        r101 = "back_click";
    L38:
        if (r101 != null) goto L40;
        r101 = "";
    L13:
        r107 = "";
    L6:
        r104 = "";
        goto L7
    }
}
