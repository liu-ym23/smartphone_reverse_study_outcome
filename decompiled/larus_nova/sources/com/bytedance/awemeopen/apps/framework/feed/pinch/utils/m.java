package com.bytedance.awemeopen.apps.framework.feed.pinch.utils;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.app.Activity;
import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.awemeopen.apps.framework.AosExtConfig;
import com.bytedance.awemeopen.apps.framework.feed.AosEventReporter;
import com.bytedance.awemeopen.apps.framework.feed.pinch.presenter.q;
import com.bytedance.awemeopen.apps.framework.feed.pinch.presenter.r;
import com.bytedance.awemeopen.apps.framework.feed.pinch.presenter.u;
import com.bytedance.awemeopen.apps.framework.feed.pinch.ui.VideoPinchView;
import com.bytedance.awemeopen.apps.framework.feed.pinch.vm.PinchStateViewModel;
import com.bytedance.awemeopen.apps.framework.framework.livedata.DiscardFirstValueLiveData;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.o;
import com.bytedance.awemeopen.apps.framework.utils.n0;
import com.bytedance.awemeopen.apps.photo.pinch.PinchEnterMethod;
import com.bytedance.awemeopen.apps.photo.pinch.PinchStableView;
import com.bytedance.awemeopen.bizmodels.feed.Video;
import com.bytedance.awemeopen.bizmodels.profile.User;
import com.bytedance.awemeopen.export.api.pageconfig.recfeed.FeedPageConfig;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import r14.y;

/* JADX INFO: loaded from: classes14.dex */
public final class m implements com.bytedance.awemeopen.apps.framework.feed.pinch.presenter.j, d, com.bytedance.awemeopen.infra.base.player.k {
    public static final /* synthetic */ int E = 0;
    public final int A;
    public final int B;
    public String C;
    public String D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a f195840a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f195841b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f195842c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public sz3.c f195843d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public r14.c f195844e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public VideoPinchView f195845f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public qz3.b f195846g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public qz3.a f195847h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f195848i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final u f195849j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f195850k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f195851l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f195852m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f195853n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f195854o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f195855p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Function0<Unit> f195856q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f195857r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final f f195858s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final g f195859t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final h f195860u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public volatile boolean f195861v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final i f195862w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f195863x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final j f195864y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f195865z;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.awemeopen.infra.base.player.k
    public final void c(String r100) {
    }

    @Override // com.bytedance.awemeopen.infra.base.player.k
    public final void d(String r100, long r101, int r102) {
    }

    @Override // com.bytedance.awemeopen.infra.base.player.k
    public final void e(String r100, int r101, String r102) {
    }

    @Override // com.bytedance.awemeopen.infra.base.player.k
    public final void f(String r100, boolean r101, int r102, int r103) {
    }

    @Override // com.bytedance.awemeopen.infra.base.player.k
    public final void h(String r100) {
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pinch.presenter.j
    public final void i() {
        boolean r100 = false;
        this.f195854o = false;
        r14.c r101 = this.f195844e;
        if (r101 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == true) goto L40;
        qz3.b r103 = this.f195846g;
        if (r103 != null) goto L12;
    L14:
        boolean r104 = false;
    L15:
        if (r104 == false) goto L40;
        if (this.f195849j.f195753o <= 1.0f) goto L29;
        qz3.b r105 = this.f195846g;
        if (r105 != null) goto L21;
    L23:
        boolean r106 = false;
    L24:
        if (r106 == false) goto L29;
        qz3.b r107 = this.f195846g;
        if (r107 == null) goto L40;
        r107.e(TuplesKt.to(Boolean.TRUE, "pinch_zoom_in"));
        goto L40
    L21:
        if (r105.A() == true) goto L23;
        r106 = true;
    L29:
        if (this.f195849j.f195753o > 1.0f) goto L40;
        qz3.b r108 = this.f195846g;
        if (r108 != null) goto L33;
    L35:
        boolean r109 = false;
    L36:
        if (r109 == false) goto L40;
        qz3.b r110 = this.f195846g;
        if (r110 == null) goto L40;
        r110.e(TuplesKt.to(Boolean.FALSE, "back_zoom_in"));
        goto L40
    L33:
        if (r108.A() != true) goto L35;
        r109 = true;
        goto L36
    L12:
        if (r103.j() != true) goto L14;
        r104 = true;
    L40:
        qz3.b r111 = this.f195846g;
        if (r111 == null) goto L47;
        View r112 = o();
        if (r112 == null) goto L45;
        Integer r113 = Integer.valueOf(r112.hashCode());
    L46:
        r111.x(r113, false, 0.0f);
        goto L47
    L45:
        r113 = null;
    L47:
        qz3.b r114 = this.f195846g;
        if (r114 == null) goto L50;
        r114.f();
    L50:
        qz3.b r115 = this.f195846g;
        if (r115 != null) goto L53;
    L55:
        if (r100 == true) goto L58;
        t(o(), true);
        return;
    L58:
        return;
    L53:
        if (r115.A() != true) goto L55;
        r100 = true;
        goto L55
    L5:
        if (com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.c.a(r101) != 3) goto L7;
        r102 = true;
        goto L8
    }

    @Override // com.bytedance.awemeopen.infra.base.player.k
    public final void onPlayPrepare(String r100) {
    }

    @Override // com.bytedance.awemeopen.infra.base.player.k
    public final void onPlaying(String r100) {
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pinch.presenter.j
    public final void a() {
        qz3.b r100 = this.f195846g;
        if (r100 == null) goto L9;
        View r101 = o();
        if (r101 == null) goto L7;
        int r102 = r101.hashCode();
    L8:
        r100.k(TuplesKt.to(Integer.valueOf(r102), 0));
        goto L9
    L7:
        r102 = 0;
    L9:
        Function0<Unit> r103 = this.f195856q;
        if (r103 == null) goto L13;
        r103.invoke();
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pinch.presenter.j
    public final void k() {
        if (this.f195841b == true) goto L5;
        return;
    L5:
        if (o() == null) goto L15;
        this.f195854o = true;
        this.f195841b = false;
        View r100 = o();
        if (r100 == null) goto L13;
        ViewParent r101 = r100.getParent();
        if (r101 == null) goto L13;
        r101.requestDisallowInterceptTouchEvent(false);
    L13:
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pinch.presenter.j
    public final void m() {
        float r100 = this.f195849j.f195753o;
        if (r100 <= 1.0f) goto L6;
        this.f195865z |= this.A;
    L8:
        int r101 = this.f195865z;
        if ((this.A & r101) != 0) goto L11;
    L13:
        boolean r102 = false;
    L14:
        if (r102 == false) goto L18;
        qz3.b r103 = this.f195846g;
        if (r103 == null) goto L18;
        r103.t();
    L18:
        View r104 = o();
        if (r104 == null) goto L24;
        qz3.b r105 = this.f195846g;
        if (r105 == null) goto L25;
        r105.k(TuplesKt.to(Integer.valueOf(r104.hashCode()), 1));
        return;
    L25:
        return;
    L24:
        return;
    L11:
        if ((r101 & this.B) == 0) goto L13;
        r102 = true;
        goto L14
    L6:
        if (r100 >= 1.0f) goto L8;
        this.f195865z |= this.B;
        goto L8
    }

    public final View o() {
        sz3.c r100 = this.f195843d;
        if (r100 == null) goto L7;
        Function0<? extends View> r101 = r100.f543934j;
        if (r101 == null) goto L7;
        return r101.invoke();
    L7:
        return null;
    }

    public final void u() {
        sz3.c r100 = this.f195843d;
        if (r100 == null) goto L9;
        PinchStateViewModel r101 = r100.f543937m;
        if (r101 == null) goto L9;
        MutableLiveData<Boolean> r102 = r101.getEnterPinchEvent();
        if (r102 == null) goto L9;
        r102.removeObserver(this.f195862w);
    L9:
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r103 = this.f195840a;
        if (r103 == null) goto L15;
        o r104 = r103.f195163c;
        if (r104 == null) goto L16;
        r104.removePlayStateListener(this);
        return;
    L16:
        return;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.awemeopen.apps.framework.feed.pinch.utils.f] */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.bytedance.awemeopen.apps.framework.feed.pinch.utils.g] */
    /* JADX WARN: Type inference failed for: r0v4, types: [com.bytedance.awemeopen.apps.framework.feed.pinch.utils.h] */
    /* JADX WARN: Type inference failed for: r0v5, types: [com.bytedance.awemeopen.apps.framework.feed.pinch.utils.i] */
    /* JADX WARN: Type inference failed for: r0v6, types: [com.bytedance.awemeopen.apps.framework.feed.pinch.utils.j] */
    public m() {
        this.f195849j = new u(this);
        this.f195855p = 1.0f;
        this.f195858s = new f(this);
        this.f195859t = new g(this);
        this.f195860u = new h(this);
        this.f195862w = new i(this);
        this.f195864y = new j(this);
        this.A = 1;
        this.B = 2;
        this.C = "";
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pinch.presenter.j
    public final void b() {
        View r100 = o();
        if (r100 == null) goto L5;
        float r101 = r100.getScaleX();
    L6:
        this.f195855p = r101;
        qz3.b r102 = this.f195846g;
        int r103 = 0;
        if (r102 == null) goto L14;
        View r104 = o();
        if (r104 == null) goto L11;
        int r105 = r104.hashCode();
    L12:
        r102.k(TuplesKt.to(Integer.valueOf(r105), 2));
        goto L14
    L11:
        r105 = 0;
    L14:
        if (this.f195855p <= 8.0f) goto L25;
        u r106 = this.f195849j;
        r106.f195754p = 8.0f;
        r106.f195753o = 8.0f;
        View r107 = r106.f195741c;
        if (r107 == null) goto L18;
        ObjectAnimator r108 = ObjectAnimator.ofPropertyValuesHolder(r107, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(LiveDegradeFpsAnimator.SCALE_X, new float[]{8.0f}), PropertyValuesHolder.ofFloat(LiveDegradeFpsAnimator.SCALE_Y, new float[]{8.0f})});
        r108.setDuration(100);
        r108.start();
    L18:
        qz3.b r109 = this.f195846g;
        if (r109 == null) goto L26;
        View r110 = o();
        if (r110 == null) goto L23;
        r103 = r110.hashCode();
    L23:
        r109.k(TuplesKt.to(Integer.valueOf(r103), 4));
        return;
    L26:
        return;
    L25:
        return;
    L5:
        r101 = 1.0f;
        goto L6
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pinch.presenter.j
    public final void j(float r100) {
        Objects.toString(o());
        if (this.f195841b == false) goto L6;
        return;
    L6:
        if (o() != null) goto L8;
        return;
    L8:
        if (this.f195843d == null) goto L105;
        View r101 = o();
        Integer r102 = null;
        if (r101 == null) goto L13;
        Context r103 = r101.getContext();
    L15:
        if ((r103 instanceof Activity) == false) goto L17;
        Context r104 = (Activity) r103;
    L18:
        if (r104 != null) goto L32;
        View r105 = o();
        if (r105 == null) goto L23;
        Object r106 = r105.getParent();
    L25:
        if ((r106 instanceof View) == false) goto L27;
        View r107 = (View) r106;
    L28:
        if (r107 == null) goto L30;
        r104 = r107.getContext();
        goto L32
    L30:
        r104 = null;
        goto L32
    L27:
        r107 = null;
        goto L28
    L23:
        r106 = null;
    L32:
        if ((r104 instanceof Activity) == true) goto L34;
        return;
    L34:
        qz3.b r108 = this.f195846g;
        if (r108 != null) goto L37;
    L39:
        boolean r109 = false;
    L40:
        if (r109 == false) goto L42;
    L43:
        qz3.b r110 = this.f195846g;
        if (r110 == null) goto L46;
        r110.v(true);
    L46:
        r("clean_mode");
    L47:
        this.f195865z = 0;
        qz3.b r111 = this.f195846g;
        if (r111 == null) goto L50;
        r111.t();
    L50:
        this.f195841b = true;
        sz3.c r112 = this.f195843d;
        if (r112 != null) goto L53;
    L77:
        View r113 = o();
        if (r113 == null) goto L82;
        ViewParent r114 = r113.getParent();
        if (r114 == null) goto L82;
        r114.requestDisallowInterceptTouchEvent(true);
    L82:
        View r115 = o();
        if (r115 == null) goto L85;
        r102 = Integer.valueOf(r115.hashCode());
    L85:
        sz3.c r116 = this.f195843d;
        if (r116 == null) goto L92;
        PinchStateViewModel r117 = r116.f543937m;
        if (r117 == null) goto L92;
        MutableLiveData<Boolean> r118 = r117.getEnterPinchEvent();
        if (r118 == null) goto L92;
        boolean r119 = Intrinsics.areEqual(r118.getValue(), Boolean.TRUE);
    L93:
        if (r119 == true) goto L99;
        sz3.c r120 = this.f195843d;
        if (r120 == null) goto L99;
        PinchStateViewModel r121 = r120.f543937m;
        if (r121 == null) goto L99;
        r121.setPinchLifecycleEvent(true);
    L99:
        qz3.b r122 = this.f195846g;
        if (r122 == null) goto L102;
        r122.x(r102, true, r100);
    L102:
        s(true);
        t(o(), false);
        this.f195853n = this.f195852m;
        return;
    L92:
        r119 = false;
        goto L93
    L53:
        if (this.f195845f != null) goto L55;
        VideoPinchView r123 = new VideoPinchView(r104, r112, this);
        this.f195845f = r123;
        r123.setTag("video_pinch_view_tag");
    L55:
        VideoPinchView r124 = this.f195845f;
        if (r124 != null) goto L58;
    L60:
        boolean r125 = false;
    L61:
        if (r125 == true) goto L76;
        VideoPinchView r126 = this.f195845f;
        if (r126 == null) goto L65;
        r126.b(r112, this);
    L65:
        VideoPinchView r127 = this.f195845f;
        if (r127 == null) goto L68;
        r127.setEnterMethod(PinchEnterMethod.PINCH);
    L68:
        ViewGroup.LayoutParams r128 = new ViewGroup.LayoutParams(-1, -1);
        VideoPinchView r129 = this.f195845f;
        if (r129 == null) goto L72;
        r129.setLayoutParams(r128);
    L72:
        ViewGroup r130 = p(r104);
        if (r130 == null) goto L75;
        r130.addView(this.f195845f);
    L75:
        q(PinchEnterMethod.PINCH);
        r("constant");
    L76:
        this.f195849j.f195760v = null;
        goto L77
    L58:
        if (r124.e() != true) goto L60;
        r125 = true;
        goto L61
    L42:
        if (this.f195852m == false) goto L47;
    L37:
        if (r108.B() != true) goto L39;
        r109 = true;
        goto L40
    L17:
        r104 = null;
        goto L18
    L13:
        r103 = null;
        goto L15
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v3, types: [com.bytedance.awemeopen.apps.framework.feed.pinch.utils.l] */
    /* JADX WARN: Type inference failed for: r5v3, types: [com.bytedance.awemeopen.apps.framework.feed.pinch.utils.k] */
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
    public final void n(sz3.c r100) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        r14.c r101 = r100.f543930f;
        this.f195844e = r101;
        this.f195843d = r100;
        this.f195849j.f195740b = r101;
        this.f195850k = false;
        boolean r102 = true;
        if (this.f195848i == true) goto L40;
        this.f195848i = true;
        this.f195846g = r100.f543933i;
        qz3.a r103 = r100.f543932h;
        this.f195847h = r103;
        if (r103 == null) goto L8;
        r103.c(r100.f543926b, this.f195858s);
    L8:
        qz3.a r104 = this.f195847h;
        if (r104 == null) goto L15;
        sz3.c r105 = this.f195843d;
        if (r105 == null) goto L13;
        LifecycleOwner r106 = r105.f543926b;
    L14:
        r104.d(r106, this.f195864y);
        goto L15
    L13:
        r106 = null;
    L15:
        qz3.b r107 = this.f195846g;
        if (r107 == null) goto L18;
        r107.a(this.f195859t);
    L18:
        qz3.b r108 = this.f195846g;
        if (r108 == 0) goto L25;
        sz3.c r109 = this.f195843d;
        if (r109 == null) goto L23;
        LifecycleOwner r110 = r109.f543926b;
    L24:
        r108.b(r110, new k(this));
        goto L25
    L23:
        r110 = null;
    L25:
        qz3.b r111 = this.f195846g;
        if (r111 == null) goto L28;
        r111.w(this.f195860u);
    L28:
        sz3.c r112 = this.f195843d;
        if (r112 == null) goto L37;
        LifecycleOwner r113 = r112.f543926b;
        if (r113 == null) goto L37;
        PinchStateViewModel r114 = r112.f543937m;
        if (r114 == null) goto L37;
        MutableLiveData<Boolean> r115 = r114.getEnterPinchEvent();
        if (r115 == null) goto L37;
        r115.observe(r113, this.f195862w);
    L37:
        qz3.b r116 = this.f195846g;
        if (r116 == 0) goto L40;
        r116.D(new l(this));
    L40:
        qz3.b r117 = this.f195846g;
        if (r117 != null) goto L43;
    L45:
        r102 = false;
    L46:
        this.f195851l = r102;
        Activity r118 = r100.getActivity();
        if (r118 == null) goto L49;
        u r119 = this.f195849j;
        r119.getClass();
        Intrinsics.checkNotNullParameter(r118, PerfLog.PARAM_KEY_CONTEXT_ID);
        r119.f195743e = new GestureDetector(r118, new q(r119));
        b r120 = new b(r118, new r(r119));
        r120.f195820d = false;
        r119.f195742d = r120;
    L49:
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r121 = this.f195840a;
        if (r121 == null) goto L54;
        o r122 = r121.f195163c;
        if (r122 == null) goto L54;
        r122.addPlayStateListener(this);
    L54:
        this.f195849j.f195760v = null;
        r100.f543941q = new VideoPinchUtil$bindPinch$2(this);
        return;
    L43:
        if (r117.B() != true) goto L45;
        goto L45
    }

    public final ViewGroup p(Context r100) {
        sz3.c r101 = this.f195843d;
        if (r101 == null) goto L5;
        ViewGroup r102 = r101.f543935k;
    L6:
        if (r102 == null) goto L8;
        if (r101 != null) goto L25;
        return null;
    L25:
        return r101.f543935k;
    L8:
        if ((r100 instanceof FragmentActivity) == false) goto L10;
        FragmentActivity r103 = (FragmentActivity) r100;
    L11:
        if (r103 == null) goto L19;
        Window r104 = r103.getWindow();
        if (r104 == null) goto L19;
        View r105 = r104.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L21;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r106 = ThreadMethodProxy.currentThread();
        if (r106 == com.larus.home.impl.utils.c.f346341a) goto L21;
        com.larus.home.impl.utils.c.a(r106, "getDecorView");
    L21:
        if ((r105 instanceof ViewGroup) == true) goto L27;
        return null;
    L27:
        return (ViewGroup) r105;
    L19:
        r105 = null;
        goto L21
    L10:
        r103 = null;
        goto L11
    L5:
        r102 = null;
        goto L6
    }

    public final void q(String r100) {
        if (Intrinsics.areEqual(this.C, "graphic_detail") == false) goto L5;
        return;
    L5:
        this.D = r100;
        LinkedHashMap r101 = new LinkedHashMap();
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r102 = this.f195840a;
        if (r102 == null) goto L11;
        o r103 = r102.f195163c;
        if (r103 == null) goto L11;
        String r104 = r103.sceneId();
        if (r104 == null) goto L11;
    L12:
        r101.put("enter_from", r104);
        r14.c r105 = this.f195844e;
        Comparable r106 = "";
        if (r105 == null) goto L16;
        String r107 = r105.c();
        if (r107 == null) goto L16;
    L17:
        r101.put("group_id", r107);
        r14.c r108 = this.f195844e;
        if (r108 == null) goto L23;
        User r109 = r108.f();
        if (r109 == null) goto L23;
        String r110 = r109.u();
        if (r110 == null) goto L23;
    L24:
        r101.put("author_id", r110);
        r101.put("enter_method", r100);
        r14.c r111 = this.f195844e;
        if (r111 == null) goto L27;
        r106 = Integer.valueOf(r111.i());
    L27:
        r101.put("aweme_type", r106);
        AosEventReporter.s(AosEventReporter.f194596a, "enter_clear_screen_mode", r101, null, null, null, 28);
        return;
    L23:
        r110 = "";
    L16:
        r107 = "";
    L11:
        r104 = this.C;
        goto L12
    }

    public final void r(String r100) {
        Intrinsics.checkNotNullParameter(r100, "zoomType");
        if (this.f195840a == null) goto L40;
        int r101 = com.bytedance.awemeopen.bizmodels.user.d.f198220a;
        sz3.c r102 = this.f195843d;
        if (r102 == null) goto L7;
        r14.c r103 = r102.f543930f;
    L9:
        if (com.bytedance.awemeopen.bizmodels.user.d.b(r103) == true) goto L11;
        return;
    L11:
        if (Intrinsics.areEqual(this.C, "graphic_detail") == true) goto L42;
        LinkedHashMap r104 = new LinkedHashMap();
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r105 = this.f195840a;
        if (r105 == null) goto L19;
        o r106 = r105.f195163c;
        if (r106 == null) goto L19;
        String r107 = r106.sceneId();
        if (r107 == null) goto L19;
    L20:
        r104.put("enter_from", r107);
        r14.c r108 = this.f195844e;
        Comparable r109 = "";
        if (r108 == null) goto L24;
        String r110 = r108.c();
        if (r110 == null) goto L24;
    L25:
        r104.put("group_id", r110);
        r14.c r111 = this.f195844e;
        if (r111 == null) goto L31;
        User r112 = r111.f();
        if (r112 == null) goto L31;
        String r113 = r112.u();
        if (r113 == null) goto L31;
    L32:
        r104.put("author_id", r113);
        String r114 = this.D;
        if (r114 != null) goto L35;
        r114 = "";
    L35:
        r104.put("enter_method", r114);
        r14.c r115 = this.f195844e;
        if (r115 == null) goto L38;
        r109 = Integer.valueOf(r115.i());
    L38:
        r104.put("aweme_type", r109);
        r104.put("zoom_type", r100);
        AosEventReporter.s(AosEventReporter.f194596a, "pinch_zoom", r104, null, null, null, 28);
        return;
    L31:
        r113 = "";
    L24:
        r110 = "";
    L19:
        r107 = this.C;
        goto L20
    L42:
        return;
    L7:
        r103 = null;
        goto L9
    }

    public final void s(boolean r100) {
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r101 = this.f195840a;
        int r102 = 0;
        if (r101 == null) goto L9;
        o r103 = r101.f195163c;
        if (r103 == null) goto L9;
        DiscardFirstValueLiveData<Boolean> r104 = r103.getEnterPinchMode();
        if (r104 == null) goto L9;
        boolean r105 = Intrinsics.areEqual(r104.getValue(), Boolean.valueOf(r100));
    L10:
        if (r105 == false) goto L12;
        return;
    L12:
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r106 = this.f195840a;
        if (r106 == null) goto L19;
        o r107 = r106.f195163c;
        if (r107 == null) goto L19;
        DiscardFirstValueLiveData<Boolean> r108 = r107.getEnterPinchMode();
        if (r108 == null) goto L19;
        r108.setValue(Boolean.valueOf(r100));
    L19:
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r109 = this.f195840a;
        View r110 = null;
        if (r109 == null) goto L24;
        View r111 = r109.f195161a;
        if (r111 == null) goto L24;
        View r112 = r111.findViewById(R.id.feed_page);
    L26:
        if (r112 == null) goto L32;
        if (r100 == false) goto L30;
        int r113 = 8;
    L31:
        r112.setVisibility(r113);
        goto L32
    L30:
        r113 = 0;
    L32:
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r114 = this.f195840a;
        if (r114 == null) goto L37;
        View r115 = r114.f195161a;
        if (r115 == null) goto L37;
        View r116 = r115.findViewById(R.id.fullscreen_watch);
    L38:
        if (r116 == null) goto L49;
        if (r100 == true) goto L47;
        boolean r117 = com.bytedance.awemeopen.apps.framework.landscape.f.f197129a;
        r14.c r118 = this.f195844e;
        if (r118 == null) goto L44;
        Video r119 = r118.P();
    L46:
        if (com.bytedance.awemeopen.apps.framework.landscape.f.b(r119) == false) goto L47;
    L48:
        r116.setVisibility(r102);
        goto L49
    L44:
        r119 = null;
    L47:
        r102 = 8;
    L49:
        if (r100 == false) goto L59;
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r120 = this.f195840a;
        if (r120 == null) goto L55;
        View r121 = r120.f195161a;
        if (r121 == null) goto L55;
        r110 = r121.findViewById(R.id.pause_btn);
    L55:
        if (r110 == null) goto L60;
        r110.setVisibility(8);
        return;
    L60:
        return;
    L59:
        return;
    L37:
        r116 = null;
    L24:
        r112 = null;
    L9:
        r105 = false;
        goto L10
    }

    @Override // com.bytedance.awemeopen.infra.base.player.k
    public final void l(String r100, com.bytedance.awemeopen.infra.base.player.l r101) {
        Intrinsics.checkNotNullParameter(r101, "playerStatusInfo");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r7v1, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5, types: [android.view.ViewGroup, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v8 */
    public final void t(View r100, boolean r101) {
        sz3.c r102 = this.f195843d;
        if (r102 != null) goto L5;
        return;
    L5:
        if (r102.f543935k != null) goto L8;
        return;
    L8:
        if (com.bytedance.awemeopen.apps.framework.feed.ui.information.a.f196000l == true) goto L10;
        return;
    L10:
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r103 = this.f195840a;
        boolean r104 = true;
        int r105 = 0;
        if (r103 == null) goto L19;
        o r106 = r103.f195163c;
        if (r106 == null) goto L19;
        FeedPageConfig r107 = r106.getPageConfig();
        if (r107 == null) goto L19;
        if (r107.getEnableFeedBtmComment() != true) goto L19;
        boolean r108 = true;
    L21:
        if (r108 == true) goto L23;
    L24:
        sz3.c r109 = this.f195843d;
        if (r109 == null) goto L29;
        ViewGroup r110 = r109.f543935k;
        if (r110 == null) goto L29;
        View r111 = r110.findViewById(R.id.rl_write_comment);
    L30:
        if (r111 == null) goto L32;
        boolean r112 = true;
    L33:
        if (r112 == true) goto L36;
        r104 = false;
    L36:
        if (r104 == false) goto L76;
        sz3.c r113 = this.f195843d;
        if (r113 == null) goto L40;
        ViewGroup r114 = r113.f543935k;
    L41:
        if (r114 == null) goto L76;
        if (r113 == null) goto L48;
        ViewGroup r115 = r113.f543935k;
        if (r115 == null) goto L48;
        View r116 = r115.findViewById(R.id.feed_content_refresh);
        if (r116 == null) goto L48;
    L51:
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r117 = this.f195840a;
        if (r117 == null) goto L56;
        View r118 = r117.f195161a;
        if (r118 == null) goto L56;
        View r119 = r118.findViewById(R.id.feed_page);
    L57:
        if (r119 == null) goto L76;
        if (this.f195863x != 0) goto L69;
        ViewGroup.LayoutParams r120 = r116.getLayoutParams();
        if ((r120 instanceof ViewGroup.MarginLayoutParams) == false) goto L64;
        ViewGroup.MarginLayoutParams r121 = (ViewGroup.MarginLayoutParams) r120;
    L65:
        if (r121 == null) goto L67;
        int r122 = r121.bottomMargin;
    L68:
        this.f195863x = r122;
        goto L69
    L67:
        r122 = 0;
        goto L68
    L64:
        r121 = null;
    L69:
        if (r101 == true) goto L71;
        View r123 = r116;
    L72:
        n0.e(r123, 0);
        if (r101 == true) goto L75;
        r116 = r119;
    L75:
        n0.e(r116, this.f195863x);
        goto L76
    L71:
        r123 = r119;
    L56:
        r119 = null;
    L48:
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r124 = this.f195840a;
        if (r124 == null) goto L76;
        r116 = r124.f195161a;
        goto L51
    L40:
        r114 = null;
    L76:
        if (r101 == true) goto L79;
        r105 = 4;
    L79:
        sz3.c r125 = this.f195843d;
        if (r125 == null) goto L84;
        Activity r126 = r125.getActivity();
        if (r126 == null) goto L84;
        View r127 = r126.findViewById(R.id.aos_feed_top_linear_gradient);
    L85:
        if (r127 == null) goto L88;
        r127.setVisibility(r105);
    L88:
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r128 = this.f195840a;
        if (r128 == null) goto L93;
        View r129 = r128.f195161a;
        if (r129 == null) goto L93;
        View r130 = r129.findViewById(R.id.aos_feed_bottom_linear_gradient);
    L94:
        if (r130 == null) goto L97;
        r130.setVisibility(r105);
    L97:
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r131 = this.f195840a;
        if (r131 == null) goto L102;
        View r132 = r131.f195161a;
        if (r132 == null) goto L102;
        View r133 = r132.findViewById(R.id.progress_bar_mask);
    L103:
        if (r133 == null) goto L106;
        r133.setVisibility(r105);
    L106:
        if (r100 == 0) goto L108;
        ViewParent r134 = r100.getParent();
    L110:
        if ((r134 instanceof ViewGroup) == false) goto L112;
        r100 = (ViewGroup) r134;
    L113:
        if (r100 == 0) goto L116;
        r100.setClipChildren(r101);
    L116:
        if (r100 == 0) goto L119;
        r100.setClipToPadding(r101);
    L119:
        sz3.c r135 = this.f195843d;
        if (r135 == null) goto L122;
        ViewGroup r136 = r135.f543935k;
    L124:
        if (Intrinsics.areEqual(r100, r136) == true) goto L132;
        if (r100 != 0) goto L106;
        return;
    L132:
        return;
    L122:
        r136 = null;
        goto L124
    L112:
        r100 = 0;
        goto L113
    L108:
        r134 = null;
    L102:
        r133 = null;
    L93:
        r130 = null;
    L84:
        r127 = null;
        goto L85
    L32:
        r112 = false;
    L29:
        r111 = null;
        goto L30
    L23:
        if (AosExtConfig.f193138b.getCommentConfig().f1843c == true) goto L36;
    L19:
        r108 = false;
        goto L21
    }

    @Override // com.bytedance.awemeopen.infra.base.player.k
    public final void g(String r100, boolean r101, String r102) {
        r14.c r103 = this.f195844e;
        if (r103 == null) goto L5;
        String r104 = r103.c();
    L7:
        if (Intrinsics.areEqual(r100, r104) == false) goto L10;
        this.f195850k = true;
        this.f195849j.d(o());
        return;
    L10:
        return;
    L5:
        r104 = null;
        goto L7
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pinch.presenter.j
    public final boolean onFling(MotionEvent r100, MotionEvent r101, float r102, float r110) {
        Intrinsics.checkNotNullParameter(r101, "e2");
        if (this.f195841b == false) goto L5;
    L92:
        return false;
    L5:
        if (this.f195851l == false) goto L92;
        int r103 = com.bytedance.awemeopen.bizmodels.user.d.f198220a;
        sz3.c r104 = this.f195843d;
        r14.c r105 = null;
        if (r104 == null) goto L10;
        r14.c r106 = r104.f543930f;
    L12:
        if (com.bytedance.awemeopen.bizmodels.user.d.b(r106) == false) goto L64;
        if (r100 == null) goto L64;
        float r107 = r101.getX() - r100.getX();
        float r108 = r101.getY() - r100.getY();
        sz3.c r109 = this.f195843d;
        if (r109 == null) goto L17;
        r14.c r111 = r109.f543930f;
    L19:
        if (com.bytedance.awemeopen.bizmodels.user.d.b(r111) == false) goto L64;
        if (Math.abs(r108) >= Math.abs(r107)) goto L64;
        if (r107 <= 0.0f) goto L37;
        sz3.c r112 = this.f195843d;
        if (r112 == null) goto L34;
        Function0<Integer> r113 = r112.f543940p;
        if (r113 == null) goto L34;
        Integer r114 = r113.invoke();
        if (r114 == null) goto L34;
        if (r114.intValue() != 0) goto L34;
        boolean r115 = true;
    L35:
        if (r115 == true) goto L64;
    L34:
        r115 = false;
    L37:
        if (r107 >= 0.0f) goto L56;
        sz3.c r116 = this.f195843d;
        if (r116 == null) goto L54;
        Function0<Integer> r117 = r116.f543940p;
        if (r117 == null) goto L54;
        Integer r118 = r117.invoke();
        r14.c r119 = this.f195844e;
        if (r119 == null) goto L47;
        List<y> r120 = r119.v();
        if (r120 == null) goto L47;
        int r121 = r120.size();
    L48:
        int r122 = r121 - 1;
        if (r118 == null) goto L54;
        if (r118.intValue() != r122) goto L54;
        boolean r123 = true;
    L55:
        if (r123 == true) goto L64;
    L47:
        r121 = 0;
    L54:
        r123 = false;
    L56:
        r14.c r124 = this.f195844e;
        if (r124 == null) goto L61;
        List<y> r125 = r124.v();
        if (r125 == null) goto L61;
        int r126 = r125.size();
    L62:
        if (r126 == 1) goto L64;
        return false;
    L61:
        r126 = 0;
        goto L62
    L17:
        r111 = null;
    L64:
        sz3.c r127 = this.f195843d;
        if (r127 == null) goto L68;
        r105 = r127.f543930f;
    L68:
        if (com.bytedance.awemeopen.bizmodels.user.d.b(r105) == true) goto L78;
        qz3.b r128 = this.f195846g;
        if (r128 != null) goto L72;
    L74:
        boolean r129 = false;
    L75:
        if (r129 == false) goto L78;
        return true;
    L72:
        if (r128.A() != true) goto L74;
        r129 = true;
    L78:
        if (Math.abs(r110) >= Math.abs(r102)) goto L81;
        String r130 = "slide";
    L84:
        VideoPinchView r131 = this.f195845f;
        if (r131 == null) goto L87;
        r131.f(r130);
    L87:
        VideoPinchView r132 = this.f195845f;
        if (r132 == null) goto L90;
        VideoPinchView.g(r132);
    L90:
        this.f195841b = false;
        return true;
    L81:
        if (r110 <= 0.0f) goto L83;
        r130 = "slide_down";
        goto L84
    L83:
        r130 = PinchStableView.Gesture.PULL_UP;
        goto L84
    L10:
        r106 = null;
        goto L12
    }
}
