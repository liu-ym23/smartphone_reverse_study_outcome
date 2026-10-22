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
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class m implements com.bytedance.awemeopen.apps.framework.feed.pinch.presenter.j, d, com.bytedance.awemeopen.infra.base.player.k {
    public static final /* synthetic */ int E = 0;
    public final int A;
    public final int B;
    public String C;
    public String D;
    public com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a a;
    public boolean b;
    public View c;
    public sz3.c d;
    public r14.c e;
    public VideoPinchView f;
    public qz3.b g;
    public qz3.a h;
    public boolean i;
    public final u j;
    public boolean k;
    public boolean l;
    public boolean m;
    public boolean n;
    public boolean o;
    public float p;
    public Function0<Unit> q;
    public boolean r;
    public final f s;
    public final g t;
    public final h u;
    public volatile boolean v;
    public final i w;
    public int x;
    public final j y;
    public int z;

    public static final class a {
    }

    static {
    }

    public final void c(String r1) {
    }

    public final void d(String r1, long r2, int r4) {
    }

    public final void e(String r1, int r2, String r3) {
    }

    public final void f(String r1, boolean r2, int r3, int r4) {
    }

    public final void h(String r1) {
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pinch.presenter.j
    public final void i() {
        boolean r0 = false;
        this.o = false;
        r14.c r1 = this.e;
        if (r1 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == true) goto L40;
        qz3.b r3 = this.g;
        if (r3 != null) goto L12;
    L14:
        boolean r4 = false;
    L15:
        if (r4 == false) goto L40;
        if (this.j.o <= 1.0f) goto L29;
        qz3.b r5 = this.g;
        if (r5 != null) goto L21;
    L23:
        boolean r6 = false;
    L24:
        if (r6 == false) goto L29;
        qz3.b r7 = this.g;
        if (r7 == null) goto L40;
        r7.e(TuplesKt.to(Boolean.TRUE, "pinch_zoom_in"));
        goto L40
    L21:
        if (r5.A() == true) goto L23;
        r6 = true;
    L29:
        if (this.j.o > 1.0f) goto L40;
        qz3.b r8 = this.g;
        if (r8 != null) goto L33;
    L35:
        boolean r9 = false;
    L36:
        if (r9 == false) goto L40;
        qz3.b r10 = this.g;
        if (r10 == null) goto L40;
        r10.e(TuplesKt.to(Boolean.FALSE, "back_zoom_in"));
        goto L40
    L33:
        if (r8.A() != true) goto L35;
        r9 = true;
        goto L36
    L12:
        if (r3.j() != true) goto L14;
        r4 = true;
    L40:
        qz3.b r11 = this.g;
        if (r11 == null) goto L47;
        View r12 = o();
        if (r12 == null) goto L45;
        Integer r13 = Integer.valueOf(r12.hashCode());
    L46:
        r11.x(r13, false, 0.0f);
        goto L47
    L45:
        r13 = null;
    L47:
        qz3.b r14 = this.g;
        if (r14 == null) goto L50;
        r14.f();
    L50:
        qz3.b r15 = this.g;
        if (r15 != null) goto L53;
    L55:
        if (r0 == true) goto L58;
        t(o(), true);
        return;
    L58:
        return;
    L53:
        if (r15.A() != true) goto L55;
        r0 = true;
        goto L55
    L5:
        if (com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.c.a(r1) != 3) goto L7;
        r2 = true;
        goto L8
    }

    public final void onPlayPrepare(String r1) {
    }

    public final void onPlaying(String r1) {
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pinch.presenter.j
    public final void a() {
        qz3.b r0 = this.g;
        if (r0 == null) goto L9;
        View r1 = o();
        if (r1 == null) goto L7;
        int r2 = r1.hashCode();
    L8:
        r0.k(TuplesKt.to(Integer.valueOf(r2), 0));
        goto L9
    L7:
        r2 = 0;
    L9:
        Function0<Unit> r3 = this.q;
        if (r3 == null) goto L13;
        r3.invoke();
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pinch.presenter.j
    public final void k() {
        if (this.b == true) goto L5;
        return;
    L5:
        if (o() == null) goto L15;
        this.o = true;
        this.b = false;
        View r1 = o();
        if (r1 == null) goto L13;
        ViewParent r2 = r1.getParent();
        if (r2 == null) goto L13;
        r2.requestDisallowInterceptTouchEvent(false);
    L13:
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pinch.presenter.j
    public final void m() {
        float r0 = this.j.o;
        if (r0 <= 1.0f) goto L6;
        this.z |= this.A;
    L8:
        int r1 = this.z;
        if ((this.A & r1) != 0) goto L11;
    L13:
        boolean r2 = false;
    L14:
        if (r2 == false) goto L18;
        qz3.b r3 = this.g;
        if (r3 == null) goto L18;
        r3.t();
    L18:
        View r4 = o();
        if (r4 == null) goto L24;
        qz3.b r5 = this.g;
        if (r5 == null) goto L25;
        r5.k(TuplesKt.to(Integer.valueOf(r4.hashCode()), 1));
        return;
    L25:
        return;
    L24:
        return;
    L11:
        if ((r1 & this.B) == 0) goto L13;
        r2 = true;
        goto L14
    L6:
        if (r0 >= 1.0f) goto L8;
        this.z |= this.B;
        goto L8
    }

    public final View o() {
        sz3.c r0 = this.d;
        if (r0 == null) goto L7;
        Function0<? extends View> r1 = r0.j;
        if (r1 == null) goto L7;
        return (View) r1.invoke();
    L7:
        return null;
    }

    public final void u() {
        sz3.c r0 = this.d;
        if (r0 == null) goto L9;
        PinchStateViewModel r1 = r0.m;
        if (r1 == null) goto L9;
        MutableLiveData<Boolean> r2 = r1.getEnterPinchEvent();
        if (r2 == null) goto L9;
        r2.removeObserver(this.w);
    L9:
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r3 = this.a;
        if (r3 == null) goto L15;
        o r4 = r3.c;
        if (r4 == null) goto L16;
        r4.removePlayStateListener(this);
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
        this.j = new u(this);
        this.p = 1.0f;
        this.s = new f(this);
        this.t = new g(this);
        this.u = new h(this);
        this.w = new i(this);
        this.y = new j(this);
        this.A = 1;
        this.B = 2;
        this.C = "";
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pinch.presenter.j
    public final void b() {
        View r0 = o();
        if (r0 == null) goto L5;
        float r1 = r0.getScaleX();
    L6:
        this.p = r1;
        qz3.b r2 = this.g;
        int r3 = 0;
        if (r2 == null) goto L14;
        View r4 = o();
        if (r4 == null) goto L11;
        int r5 = r4.hashCode();
    L12:
        r2.k(TuplesKt.to(Integer.valueOf(r5), 2));
        goto L14
    L11:
        r5 = 0;
    L14:
        if (this.p <= 8.0f) goto L25;
        u r6 = this.j;
        r6.p = 8.0f;
        r6.o = 8.0f;
        View r7 = r6.c;
        if (r7 == null) goto L18;
        ObjectAnimator r8 = ObjectAnimator.ofPropertyValuesHolder(r7, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat("scaleX", new float[]{8.0f}), PropertyValuesHolder.ofFloat("scaleY", new float[]{8.0f})});
        r8.setDuration(100);
        r8.start();
    L18:
        qz3.b r9 = this.g;
        if (r9 == null) goto L26;
        View r10 = o();
        if (r10 == null) goto L23;
        r3 = r10.hashCode();
    L23:
        r9.k(TuplesKt.to(Integer.valueOf(r3), 4));
        return;
    L26:
        return;
    L25:
        return;
    L5:
        r1 = 1.0f;
        goto L6
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pinch.presenter.j
    public final void j(float r8) {
        Objects.toString(o());
        if (this.b == false) goto L6;
        return;
    L6:
        if (o() != null) goto L8;
        return;
    L8:
        if (this.d == null) goto L105;
        View r0 = o();
        Integer r1 = null;
        if (r0 == null) goto L13;
        Context r2 = r0.getContext();
    L15:
        if ((r2 instanceof Activity) == false) goto L17;
        Context r3 = (Activity) r2;
    L18:
        if (r3 != null) goto L32;
        View r4 = o();
        if (r4 == null) goto L23;
        Object r5 = r4.getParent();
    L25:
        if ((r5 instanceof View) == false) goto L27;
        View r6 = (View) r5;
    L28:
        if (r6 == null) goto L30;
        r3 = r6.getContext();
        goto L32
    L30:
        r3 = null;
        goto L32
    L27:
        r6 = null;
        goto L28
    L23:
        r5 = null;
    L32:
        if ((r3 instanceof Activity) == true) goto L34;
        return;
    L34:
        qz3.b r7 = this.g;
        if (r7 != null) goto L37;
    L39:
        boolean r9 = false;
    L40:
        if (r9 == false) goto L42;
    L43:
        qz3.b r10 = this.g;
        if (r10 == null) goto L46;
        r10.v(true);
    L46:
        r("clean_mode");
    L47:
        this.z = 0;
        qz3.b r11 = this.g;
        if (r11 == null) goto L50;
        r11.t();
    L50:
        this.b = true;
        sz3.c r12 = this.d;
        if (r12 != null) goto L53;
    L77:
        View r13 = o();
        if (r13 == null) goto L82;
        ViewParent r14 = r13.getParent();
        if (r14 == null) goto L82;
        r14.requestDisallowInterceptTouchEvent(true);
    L82:
        View r15 = o();
        if (r15 == null) goto L85;
        r1 = Integer.valueOf(r15.hashCode());
    L85:
        sz3.c r16 = this.d;
        if (r16 == null) goto L92;
        PinchStateViewModel r17 = r16.m;
        if (r17 == null) goto L92;
        MutableLiveData<Boolean> r18 = r17.getEnterPinchEvent();
        if (r18 == null) goto L92;
        boolean r19 = Intrinsics.areEqual(r18.getValue(), Boolean.TRUE);
    L93:
        if (r19 == true) goto L99;
        sz3.c r20 = this.d;
        if (r20 == null) goto L99;
        PinchStateViewModel r21 = r20.m;
        if (r21 == null) goto L99;
        r21.setPinchLifecycleEvent(true);
    L99:
        qz3.b r22 = this.g;
        if (r22 == null) goto L102;
        r22.x(r1, true, r8);
    L102:
        s(true);
        t(o(), false);
        this.n = this.m;
        return;
    L92:
        r19 = false;
        goto L93
    L53:
        if (this.f != null) goto L55;
        VideoPinchView r23 = new VideoPinchView(r3, r12, this);
        this.f = r23;
        r23.setTag("video_pinch_view_tag");
    L55:
        VideoPinchView r24 = this.f;
        if (r24 != null) goto L58;
    L60:
        boolean r25 = false;
    L61:
        if (r25 == true) goto L76;
        VideoPinchView r26 = this.f;
        if (r26 == null) goto L65;
        r26.b(r12, this);
    L65:
        VideoPinchView r27 = this.f;
        if (r27 == null) goto L68;
        r27.setEnterMethod(PinchEnterMethod.PINCH);
    L68:
        ViewGroup.LayoutParams r28 = new ViewGroup.LayoutParams(-1, -1);
        VideoPinchView r29 = this.f;
        if (r29 == null) goto L72;
        r29.setLayoutParams(r28);
    L72:
        ViewGroup r30 = p(r3);
        if (r30 == null) goto L75;
        r30.addView(this.f);
    L75:
        q(PinchEnterMethod.PINCH);
        r("constant");
    L76:
        this.j.v = null;
        goto L77
    L58:
        if (r24.e() != true) goto L60;
        r25 = true;
        goto L61
    L42:
        if (this.m == false) goto L47;
    L37:
        if (r7.B() != true) goto L39;
        r9 = true;
        goto L40
    L17:
        r3 = null;
        goto L18
    L13:
        r2 = null;
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
    public final void n(sz3.c r7) {
        Intrinsics.checkNotNullParameter(r7, "model");
        r14.c r0 = r7.f;
        this.e = r0;
        this.d = r7;
        this.j.b = r0;
        this.k = false;
        boolean r3 = true;
        if (this.i == true) goto L40;
        this.i = true;
        this.g = r7.i;
        qz3.a r1 = r7.h;
        this.h = r1;
        if (r1 == null) goto L8;
        r1.c(r7.b, this.s);
    L8:
        qz3.a r2 = this.h;
        if (r2 == null) goto L15;
        sz3.c r4 = this.d;
        if (r4 == null) goto L13;
        LifecycleOwner r5 = r4.b;
    L14:
        r2.d(r5, this.y);
        goto L15
    L13:
        r5 = null;
    L15:
        qz3.b r6 = this.g;
        if (r6 == null) goto L18;
        r6.a(this.t);
    L18:
        qz3.b r8 = this.g;
        if (r8 == 0) goto L25;
        sz3.c r9 = this.d;
        if (r9 == null) goto L23;
        LifecycleOwner r10 = r9.b;
    L24:
        r8.b(r10, new k(this));
        goto L25
    L23:
        r10 = null;
    L25:
        qz3.b r11 = this.g;
        if (r11 == null) goto L28;
        r11.w(this.u);
    L28:
        sz3.c r12 = this.d;
        if (r12 == null) goto L37;
        LifecycleOwner r13 = r12.b;
        if (r13 == null) goto L37;
        PinchStateViewModel r14 = r12.m;
        if (r14 == null) goto L37;
        MutableLiveData<Boolean> r15 = r14.getEnterPinchEvent();
        if (r15 == null) goto L37;
        r15.observe(r13, this.w);
    L37:
        qz3.b r16 = this.g;
        if (r16 == 0) goto L40;
        r16.D(new l(this));
    L40:
        qz3.b r17 = this.g;
        if (r17 != null) goto L43;
    L45:
        r3 = false;
    L46:
        this.l = r3;
        Activity r18 = r7.getActivity();
        if (r18 == null) goto L49;
        u r19 = this.j;
        r19.getClass();
        Intrinsics.checkNotNullParameter(r18, "context");
        r19.e = new GestureDetector(r18, new q(r19));
        b r20 = new b(r18, new r(r19));
        r20.d = false;
        r19.d = r20;
    L49:
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r21 = this.a;
        if (r21 == null) goto L54;
        o r22 = r21.c;
        if (r22 == null) goto L54;
        r22.addPlayStateListener(this);
    L54:
        this.j.v = null;
        r7.q = new VideoPinchUtil$bindPinch$2(this);
        return;
    L43:
        if (r17.B() != true) goto L45;
        goto L45
    }

    public final ViewGroup p(Context r5) {
        sz3.c r0 = this.d;
        if (r0 == null) goto L5;
        ViewGroup r2 = r0.k;
    L6:
        if (r2 == null) goto L8;
        if (r0 != null) goto L25;
        return null;
    L25:
        return r0.k;
    L8:
        if ((r5 instanceof FragmentActivity) == false) goto L10;
        FragmentActivity r6 = (FragmentActivity) r5;
    L11:
        if (r6 == null) goto L19;
        Window r7 = r6.getWindow();
        if (r7 == null) goto L19;
        View r8 = r7.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L21;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r1 = ThreadMethodProxy.currentThread();
        if (r1 == com.larus.home.impl.utils.c.a) goto L21;
        com.larus.home.impl.utils.c.a(r1, "getDecorView");
    L21:
        if ((r8 instanceof ViewGroup) == true) goto L27;
        return null;
    L27:
        return (ViewGroup) r8;
    L19:
        r8 = null;
        goto L21
    L10:
        r6 = null;
        goto L11
    L5:
        r2 = null;
        goto L6
    }

    public final void q(String r9) {
        if (Intrinsics.areEqual(this.C, "graphic_detail") == false) goto L5;
        return;
    L5:
        this.D = r9;
        LinkedHashMap r3 = new LinkedHashMap();
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r0 = this.a;
        if (r0 == null) goto L11;
        o r1 = r0.c;
        if (r1 == null) goto L11;
        String r2 = r1.sceneId();
        if (r2 == null) goto L11;
    L12:
        r3.put("enter_from", r2);
        r14.c r4 = this.e;
        Object r5 = "";
        if (r4 == null) goto L16;
        String r6 = r4.c();
        if (r6 == null) goto L16;
    L17:
        r3.put("group_id", r6);
        r14.c r7 = this.e;
        if (r7 == null) goto L23;
        User r8 = r7.f();
        if (r8 == null) goto L23;
        String r10 = r8.u();
        if (r10 == null) goto L23;
    L24:
        r3.put("author_id", r10);
        r3.put("enter_method", r9);
        r14.c r11 = this.e;
        if (r11 == null) goto L27;
        r5 = Integer.valueOf(r11.i());
    L27:
        r3.put("aweme_type", r5);
        AosEventReporter.s(AosEventReporter.a, "enter_clear_screen_mode", r3, null, null, null, 28);
        return;
    L23:
        r10 = "";
    L16:
        r6 = "";
    L11:
        r2 = this.C;
        goto L12
    }

    public final void r(String r9) {
        Intrinsics.checkNotNullParameter(r9, "zoomType");
        if (this.a == null) goto L40;
        int r0 = com.bytedance.awemeopen.bizmodels.user.d.a;
        sz3.c r1 = this.d;
        if (r1 == null) goto L7;
        r14.c r2 = r1.f;
    L9:
        if (com.bytedance.awemeopen.bizmodels.user.d.b(r2) == true) goto L11;
        return;
    L11:
        if (Intrinsics.areEqual(this.C, "graphic_detail") == true) goto L42;
        LinkedHashMap r3 = new LinkedHashMap();
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r4 = this.a;
        if (r4 == null) goto L19;
        o r5 = r4.c;
        if (r5 == null) goto L19;
        String r6 = r5.sceneId();
        if (r6 == null) goto L19;
    L20:
        r3.put("enter_from", r6);
        r14.c r7 = this.e;
        Object r8 = "";
        if (r7 == null) goto L24;
        String r10 = r7.c();
        if (r10 == null) goto L24;
    L25:
        r3.put("group_id", r10);
        r14.c r11 = this.e;
        if (r11 == null) goto L31;
        User r12 = r11.f();
        if (r12 == null) goto L31;
        String r13 = r12.u();
        if (r13 == null) goto L31;
    L32:
        r3.put("author_id", r13);
        String r14 = this.D;
        if (r14 != null) goto L35;
        r14 = "";
    L35:
        r3.put("enter_method", r14);
        r14.c r15 = this.e;
        if (r15 == null) goto L38;
        r8 = Integer.valueOf(r15.i());
    L38:
        r3.put("aweme_type", r8);
        r3.put("zoom_type", r9);
        AosEventReporter.s(AosEventReporter.a, "pinch_zoom", r3, null, null, null, 28);
        return;
    L31:
        r13 = "";
    L24:
        r10 = "";
    L19:
        r6 = this.C;
        goto L20
    L42:
        return;
    L7:
        r2 = null;
        goto L9
    }

    public final void s(boolean r6) {
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L9;
        o r2 = r0.c;
        if (r2 == null) goto L9;
        DiscardFirstValueLiveData<Boolean> r3 = r2.getEnterPinchMode();
        if (r3 == null) goto L9;
        boolean r4 = Intrinsics.areEqual(r3.getValue(), Boolean.valueOf(r6));
    L10:
        if (r4 == false) goto L12;
        return;
    L12:
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r5 = this.a;
        if (r5 == null) goto L19;
        o r7 = r5.c;
        if (r7 == null) goto L19;
        DiscardFirstValueLiveData<Boolean> r8 = r7.getEnterPinchMode();
        if (r8 == null) goto L19;
        r8.setValue(Boolean.valueOf(r6));
    L19:
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r9 = this.a;
        View r10 = null;
        if (r9 == null) goto L24;
        View r11 = r9.a;
        if (r11 == null) goto L24;
        View r12 = r11.findViewById(2131372243);
    L26:
        if (r12 == null) goto L32;
        if (r6 == false) goto L30;
        int r13 = 8;
    L31:
        r12.setVisibility(r13);
        goto L32
    L30:
        r13 = 0;
    L32:
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r14 = this.a;
        if (r14 == null) goto L37;
        View r15 = r14.a;
        if (r15 == null) goto L37;
        View r16 = r15.findViewById(2131373353);
    L38:
        if (r16 == null) goto L49;
        if (r6 == true) goto L47;
        boolean r17 = com.bytedance.awemeopen.apps.framework.landscape.f.a;
        r14.c r18 = this.e;
        if (r18 == null) goto L44;
        Video r19 = r18.P();
    L46:
        if (com.bytedance.awemeopen.apps.framework.landscape.f.b(r19) == false) goto L47;
    L48:
        r16.setVisibility(r1);
        goto L49
    L44:
        r19 = null;
    L47:
        r1 = 8;
    L49:
        if (r6 == false) goto L59;
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r20 = this.a;
        if (r20 == null) goto L55;
        View r21 = r20.a;
        if (r21 == null) goto L55;
        r10 = r21.findViewById(2131381974);
    L55:
        if (r10 == null) goto L60;
        r10.setVisibility(8);
        return;
    L60:
        return;
    L59:
        return;
    L37:
        r16 = null;
    L24:
        r12 = null;
    L9:
        r4 = false;
        goto L10
    }

    public final void l(String r1, com.bytedance.awemeopen.infra.base.player.l r2) {
        Intrinsics.checkNotNullParameter(r2, "playerStatusInfo");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r7v1, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5, types: [android.view.ViewGroup, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v8 */
    public final void t(View r7, boolean r8) {
        sz3.c r0 = this.d;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.k != null) goto L8;
        return;
    L8:
        if (com.bytedance.awemeopen.apps.framework.feed.ui.information.a.l == true) goto L10;
        return;
    L10:
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r1 = this.a;
        boolean r2 = true;
        int r3 = 0;
        if (r1 == null) goto L19;
        o r4 = r1.c;
        if (r4 == null) goto L19;
        FeedPageConfig r5 = r4.getPageConfig();
        if (r5 == null) goto L19;
        if (r5.getEnableFeedBtmComment() != true) goto L19;
        boolean r6 = true;
    L21:
        if (r6 == true) goto L23;
    L24:
        sz3.c r9 = this.d;
        if (r9 == null) goto L29;
        ViewGroup r10 = r9.k;
        if (r10 == null) goto L29;
        View r11 = r10.findViewById(2131384730);
    L30:
        if (r11 == null) goto L32;
        boolean r12 = true;
    L33:
        if (r12 == true) goto L36;
        r2 = false;
    L36:
        if (r2 == false) goto L76;
        sz3.c r13 = this.d;
        if (r13 == null) goto L40;
        ViewGroup r14 = r13.k;
    L41:
        if (r14 == null) goto L76;
        if (r13 == null) goto L48;
        ViewGroup r15 = r13.k;
        if (r15 == null) goto L48;
        View r16 = r15.findViewById(2131372235);
        if (r16 == null) goto L48;
    L51:
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r17 = this.a;
        if (r17 == null) goto L56;
        View r18 = r17.a;
        if (r18 == null) goto L56;
        View r19 = r18.findViewById(2131372243);
    L57:
        if (r19 == null) goto L76;
        if (this.x != 0) goto L69;
        ViewGroup.LayoutParams r20 = r16.getLayoutParams();
        if ((r20 instanceof ViewGroup.MarginLayoutParams) == false) goto L64;
        ViewGroup.MarginLayoutParams r21 = (ViewGroup.MarginLayoutParams) r20;
    L65:
        if (r21 == null) goto L67;
        int r22 = r21.bottomMargin;
    L68:
        this.x = r22;
        goto L69
    L67:
        r22 = 0;
        goto L68
    L64:
        r21 = null;
    L69:
        if (r8 == true) goto L71;
        View r23 = r16;
    L72:
        n0.e(r23, 0);
        if (r8 == true) goto L75;
        r16 = r19;
    L75:
        n0.e(r16, this.x);
        goto L76
    L71:
        r23 = r19;
    L56:
        r19 = null;
    L48:
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r24 = this.a;
        if (r24 == null) goto L76;
        r16 = r24.a;
        goto L51
    L40:
        r14 = null;
    L76:
        if (r8 == true) goto L79;
        r3 = 4;
    L79:
        sz3.c r25 = this.d;
        if (r25 == null) goto L84;
        Activity r26 = r25.getActivity();
        if (r26 == null) goto L84;
        View r27 = r26.findViewById(2131363069);
    L85:
        if (r27 == null) goto L88;
        r27.setVisibility(r3);
    L88:
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r28 = this.a;
        if (r28 == null) goto L93;
        View r29 = r28.a;
        if (r29 == null) goto L93;
        View r30 = r29.findViewById(2131363068);
    L94:
        if (r30 == null) goto L97;
        r30.setVisibility(r3);
    L97:
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r31 = this.a;
        if (r31 == null) goto L102;
        View r32 = r31.a;
        if (r32 == null) goto L102;
        View r33 = r32.findViewById(2131383301);
    L103:
        if (r33 == null) goto L106;
        r33.setVisibility(r3);
    L106:
        if (r7 == 0) goto L108;
        ViewParent r34 = r7.getParent();
    L110:
        if ((r34 instanceof ViewGroup) == false) goto L112;
        r7 = (ViewGroup) r34;
    L113:
        if (r7 == 0) goto L116;
        r7.setClipChildren(r8);
    L116:
        if (r7 == 0) goto L119;
        r7.setClipToPadding(r8);
    L119:
        sz3.c r35 = this.d;
        if (r35 == null) goto L122;
        ViewGroup r36 = r35.k;
    L124:
        if (Intrinsics.areEqual(r7, r36) == true) goto L132;
        if (r7 != 0) goto L106;
        return;
    L132:
        return;
    L122:
        r36 = null;
        goto L124
    L112:
        r7 = 0;
        goto L113
    L108:
        r34 = null;
    L102:
        r33 = null;
    L93:
        r30 = null;
    L84:
        r27 = null;
        goto L85
    L32:
        r12 = false;
    L29:
        r11 = null;
        goto L30
    L23:
        if (AosExtConfig.b.getCommentConfig().c == true) goto L36;
    L19:
        r6 = false;
        goto L21
    }

    public final void g(String r1, boolean r2, String r3) {
        r14.c r4 = this.e;
        if (r4 == null) goto L5;
        String r5 = r4.c();
    L7:
        if (Intrinsics.areEqual(r1, r5) == false) goto L10;
        this.k = true;
        this.j.d(o());
        return;
    L10:
        return;
    L5:
        r5 = null;
        goto L7
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pinch.presenter.j
    public final boolean onFling(MotionEvent r7, MotionEvent r8, float r9, float r10) {
        Intrinsics.checkNotNullParameter(r8, "e2");
        if (this.b == false) goto L5;
    L92:
        return false;
    L5:
        if (this.l == false) goto L92;
        int r0 = com.bytedance.awemeopen.bizmodels.user.d.a;
        sz3.c r1 = this.d;
        r14.c r2 = null;
        if (r1 == null) goto L10;
        r14.c r3 = r1.f;
    L12:
        if (com.bytedance.awemeopen.bizmodels.user.d.b(r3) == false) goto L64;
        if (r7 == null) goto L64;
        float r4 = r8.getX() - r7.getX();
        float r11 = r8.getY() - r7.getY();
        sz3.c r12 = this.d;
        if (r12 == null) goto L17;
        r14.c r13 = r12.f;
    L19:
        if (com.bytedance.awemeopen.bizmodels.user.d.b(r13) == false) goto L64;
        if (Math.abs(r11) >= Math.abs(r4)) goto L64;
        if (r4 <= 0.0f) goto L37;
        sz3.c r14 = this.d;
        if (r14 == null) goto L34;
        Function0<Integer> r15 = r14.p;
        if (r15 == null) goto L34;
        Integer r16 = (Integer) r15.invoke();
        if (r16 == null) goto L34;
        if (r16.intValue() != 0) goto L34;
        boolean r17 = true;
    L35:
        if (r17 == true) goto L64;
    L34:
        r17 = false;
    L37:
        if (r4 >= 0.0f) goto L56;
        sz3.c r18 = this.d;
        if (r18 == null) goto L54;
        Function0<Integer> r19 = r18.p;
        if (r19 == null) goto L54;
        Integer r20 = (Integer) r19.invoke();
        r14.c r21 = this.e;
        if (r21 == null) goto L47;
        List r22 = r21.v();
        if (r22 == null) goto L47;
        int r23 = r22.size();
    L48:
        int r24 = r23 - 1;
        if (r20 == null) goto L54;
        if (r20.intValue() != r24) goto L54;
        boolean r25 = true;
    L55:
        if (r25 == true) goto L64;
    L47:
        r23 = 0;
    L54:
        r25 = false;
    L56:
        r14.c r26 = this.e;
        if (r26 == null) goto L61;
        List r27 = r26.v();
        if (r27 == null) goto L61;
        int r28 = r27.size();
    L62:
        if (r28 == 1) goto L64;
        return false;
    L61:
        r28 = 0;
        goto L62
    L17:
        r13 = null;
    L64:
        sz3.c r29 = this.d;
        if (r29 == null) goto L68;
        r2 = r29.f;
    L68:
        if (com.bytedance.awemeopen.bizmodels.user.d.b(r2) == true) goto L78;
        qz3.b r30 = this.g;
        if (r30 != null) goto L72;
    L74:
        boolean r31 = false;
    L75:
        if (r31 == false) goto L78;
        return true;
    L72:
        if (r30.A() != true) goto L74;
        r31 = true;
    L78:
        if (Math.abs(r10) >= Math.abs(r9)) goto L81;
        String r32 = "slide";
    L84:
        VideoPinchView r33 = this.f;
        if (r33 == null) goto L87;
        r33.f(r32);
    L87:
        VideoPinchView r34 = this.f;
        if (r34 == null) goto L90;
        VideoPinchView.g(r34);
    L90:
        this.b = false;
        return true;
    L81:
        if (r10 <= 0.0f) goto L83;
        r32 = PinchStableView.Gesture.PULL_DOWN;
        goto L84
    L83:
        r32 = PinchStableView.Gesture.PULL_UP;
        goto L84
    L10:
        r3 = null;
        goto L12
    }
}
