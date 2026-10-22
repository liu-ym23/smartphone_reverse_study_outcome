package com.bytedance.awemeopen.apps.framework.feed.pinch.presenter;

import android.app.Activity;
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
import java.util.LinkedHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class FeedPinchPresenter extends g04.a<jz3.a> {
    public long A;
    public final com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a e;
    public r14.c f;
    public qz3.c g;
    public qz3.d h;
    public com.bytedance.awemeopen.apps.framework.feed.pinch.utils.m i;
    public boolean j;
    public e k;
    public f l;
    public h m;
    public FeedSpeedControlViewModel n;
    public g o;
    public boolean p;
    public int q;
    public final FeedPinchPresenter$viewpagerTouchListener$1 r;
    public CopyOnWriteArrayList<o54.a> s;
    public boolean t;
    public int u;
    public i v;
    public boolean w;
    public final Lazy x;
    public final d y;
    public int z;

    @Override // g04.a
    public final void g() {
        ViewGroup r0 = this.e.b;
        VerticalViewPager r2 = null;
        if ((r0 instanceof VerticalViewPager) == false) goto L5;
        VerticalViewPager r1 = (VerticalViewPager) r0;
    L6:
        if (r1 == null) goto L14;
        int r3 = r1.getChildCount();
        int r4 = 0;
    L9:
        if (r4 >= r3) goto L14;
        View r5 = r1.getChildAt(r4);
        if (r5 == null) goto L13;
        r5.setVisibility(0);
        r5.setAlpha(1.0f);
    L13:
        r4 = r4 + 1;
    L14:
        com.bytedance.awemeopen.apps.framework.feed.pinch.utils.m r6 = this.i;
        if (r6 == null) goto L17;
        r6.r = true;
    L17:
        ViewGroup r7 = this.e.b;
        if ((r7 instanceof VerticalViewPager) == false) goto L20;
        r2 = (VerticalViewPager) r7;
    L20:
        if (r2 == null) goto L26;
        this.z = r2.getCurrentItem();
        return;
    L26:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // g04.a
    public final void h() {
        View r0 = this.a;
        VerticalViewPager r2 = null;
        if ((r0 instanceof VideoViewHolderRootView) == false) goto L5;
        VideoViewHolderRootView r1 = (VideoViewHolderRootView) r0;
    L6:
        if (r1 == null) goto L9;
        r1.setPinchListener(null);
    L9:
        com.bytedance.awemeopen.apps.framework.feed.pinch.utils.m r3 = this.i;
        if (r3 == null) goto L12;
        r3.u();
    L12:
        com.bytedance.awemeopen.apps.framework.feed.pinch.utils.m r4 = this.i;
        if (r4 == null) goto L16;
        r4.q = null;
    L16:
        CopyOnWriteArrayList<o54.a> r5 = this.s;
        if (r5 == null) goto L19;
        r5.clear();
    L19:
        this.s = null;
        ViewGroup r6 = this.e.b;
        if ((r6 instanceof VerticalViewPager) == false) goto L22;
        r2 = (VerticalViewPager) r6;
    L22:
        if (r2 == null) goto L24;
        r2.v(this.r);
    L24:
        e r7 = this.k;
        if (r7 == null) goto L34;
        com.bytedance.awemeopen.apps.framework.feed.pinch.utils.m r8 = this.i;
        if (r8 == null) goto L34;
        sz3.c r9 = r8.d;
        if (r9 == null) goto L34;
        qz3.b r10 = r9.i;
        if (r10 == null) goto L34;
        r10.r(r7);
    L34:
        if (this.l == null) goto L36;
        DiscardFirstValueLiveData<Boolean> r11 = this.e.c.getEnterPinchMode();
        f r12 = this.l;
        Intrinsics.checkNotNull(r12);
        r11.removeObserver(r12);
    L36:
        g r13 = this.o;
        if (r13 == null) goto L43;
        FeedSpeedControlViewModel r14 = this.n;
        if (r14 == null) goto L43;
        MutableLiveData<Pair<String, Boolean>> r15 = r14.getFastSpeedModeEvent();
        if (r15 == null) goto L43;
        r15.removeObserver(r13);
    L43:
        h r16 = this.m;
        if (r16 == null) goto L52;
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r17 = this.e;
        if (r17 == null) goto L52;
        com.bytedance.awemeopen.apps.framework.framework.viewpager.o r18 = r17.c;
        if (r18 == null) goto L52;
        DiscardFirstValueLiveData<Boolean> r19 = r18.getLoadMoreUiShow();
        if (r19 == null) goto L52;
        r19.removeObserver(r16);
    L52:
        i r20 = this.v;
        if (r20 == null) goto L57;
        MutableLiveData<Integer> r21 = this.e.c.getSlidesProgressPosition();
        if (r21 == null) goto L57;
        r21.removeObserver(r20);
    L57:
        qz3.d r22 = this.h;
        if (r22 == null) goto L61;
        r22.h(this.y);
        return;
    L61:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // g04.a
    public final void i() {
        com.bytedance.awemeopen.apps.framework.feed.pinch.utils.m r0 = this.i;
        boolean r1 = true;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        Integer r3 = null;
        if (r2 == false) goto L13;
        qz3.d r4 = this.h;
        if (r4 == null) goto L13;
        r4.x(null, false, 0.0f);
    L13:
        qz3.d r5 = this.h;
        if (r5 != null) goto L16;
    L18:
        r1 = false;
    L19:
        if (r1 == false) goto L39;
        ViewGroup r6 = this.e.b;
        if ((r6 instanceof VerticalViewPager) == false) goto L23;
        VerticalViewPager r7 = (VerticalViewPager) r6;
    L24:
        if (r7 == null) goto L26;
        r3 = Integer.valueOf(r7.getCurrentItem());
    L26:
        if (r3 != null) goto L28;
    L35:
        String r8 = "slide";
    L36:
        qz3.d r9 = this.h;
        if (r9 == null) goto L39;
        r9.z(new sz3.a(Boolean.TRUE, r8));
        goto L39
    L28:
        if (this.z < 0) goto L35;
        if (r3.intValue() <= this.z) goto L33;
        r8 = PinchStableView.Gesture.PULL_UP;
        goto L36
    L33:
        if (r3.intValue() >= this.z) goto L35;
        r8 = PinchStableView.Gesture.PULL_DOWN;
        goto L36
    L23:
        r7 = null;
    L39:
        com.bytedance.awemeopen.apps.framework.feed.pinch.utils.m r10 = this.i;
        if (r10 == null) goto L43;
        r10.r = false;
        return;
    L43:
        return;
    L16:
        if (r5.B() != true) goto L18;
    L5:
        if (r0.b != true) goto L7;
        r2 = true;
        goto L8
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.bytedance.awemeopen.apps.framework.feed.pinch.presenter.d] */
    /* JADX WARN: Type inference failed for: r2v2, types: [com.bytedance.awemeopen.apps.framework.feed.pinch.presenter.FeedPinchPresenter$viewpagerTouchListener$1] */
    public FeedPinchPresenter(com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r2) {
        Intrinsics.checkNotNullParameter(r2, "feedGroupParameters");
        super(r2.a);
        this.e = r2;
        this.p = true;
        this.r = new FeedPinchPresenter$viewpagerTouchListener$1(this);
        this.u = -1;
        this.x = LazyKt.lazy(new FeedPinchPresenter$photoFeedPagerPresenter$2(this));
        this.y = new d(this);
        this.z = -1;
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
    public final void f(jz3.a r8) {
        jz3.a r9 = r8;
        Intrinsics.checkNotNullParameter(r9, "data");
        boolean r1 = false;
        if (r9.a.c().length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L127;
        this.f = r9.a;
        View r2 = this.a;
        LifecycleOwner r4 = null;
        if ((r2 instanceof VideoViewHolderRootView) == false) goto L11;
        VideoViewHolderRootView r3 = (VideoViewHolderRootView) r2;
    L12:
        if (r3 == null) goto L15;
        r3.setPinchListener(new c(this));
    L15:
        this.h = new qz3.d();
        this.g = new qz3.c();
        com.bytedance.awemeopen.apps.framework.feed.pinch.utils.m r5 = new com.bytedance.awemeopen.apps.framework.feed.pinch.utils.m();
        r5.a = this.e;
        this.i = r5;
        r14.c r6 = this.f;
        Intrinsics.checkNotNull(r6);
        int r7 = com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.c.a(r6);
        if (r7 == 1) goto L18;
    L19:
        if (r7 == 3) goto L21;
    L23:
        boolean r10 = false;
    L24:
        this.t = r10;
        r14.c r11 = this.f;
        if (r11 != null) goto L27;
    L29:
        boolean r12 = false;
    L30:
        if (r12 == false) goto L63;
        View r13 = iz3.a.b(this.e);
        if (r13 == null) goto L36;
        ViewGroup r14 = (FrameLayout) r13.findViewById(2131387740);
        if (r14 == null) goto L36;
    L40:
        final sz3.c r15 = new sz3.c();
        r15.f = this.f;
        r15.g = r9;
        r15.h = this.g;
        r15.i = this.h;
        r15.j = new FeedPinchPresenter$bindSlides$pinchParams$1$1(this);
        r15.o = Boolean.valueOf(this.t);
        r15.a = this.e.getActivity();
        r15.e = this.e.c.sceneId();
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r16 = this.e;
        r15.b = r16.e.d;
        r15.c = r16.c;
        r15.k = r14;
        PinchStateViewModel.a r17 = PinchStateViewModel.Companion;
        LifecycleOwner r18 = r16.getActivity();
        if ((r18 instanceof LifecycleOwner) == false) goto L43;
        LifecycleOwner r19 = r18;
    L44:
        if (r19 != null) goto L46;
        r19 = this.e.e.d;
    L46:
        r17.getClass();
        r15.m = PinchStateViewModel.a.a(r19);
        r15.p = new FeedPinchPresenter$bindSlides$pinchParams$1$2(this);
        com.bytedance.awemeopen.apps.framework.feed.pinch.utils.m r20 = this.i;
        if (r20 == null) goto L49;
        r20.n(r15);
    L49:
        this.v = new i(this);
        MutableLiveData<Integer> r21 = this.e.c.getSlidesProgressPosition();
        if (r21 == null) goto L52;
        LifecycleOwner r22 = this.e.e.d;
        i r23 = this.v;
        Intrinsics.checkNotNull(r23);
        r21.observe(r22, r23);
    L52:
        qz3.d r24 = this.h;
        if (r24 == null) goto L55;
        r24.i(this.e.e.d, this.y);
    L55:
        final PhotoFeedProgressPresenter r25 = (PhotoFeedProgressPresenter) c(PhotoFeedProgressPresenter.class);
        if (r25 == null) goto L79;
        Intrinsics.checkNotNullParameter(r15, "pinchParams");
        r25.r = r15;
        ?? r26 = new PhotoFeedProgressPresenter$observePinchEvent$1(r25);
        r25.s = r26;
        qz3.b r27 = r15.i;
        if (r27 == 0) goto L60;
        LifecycleOwner r28 = r15.b;
        Intrinsics.checkNotNull(r26);
        r27.C(r28, r26);
    L60:
        ?? r29 = new com.bytedance.awemeopen.apps.framework.feed.pages.recommend.presenter.photo.o(r25);
        r25.t = r29;
        qz3.b r30 = r15.i;
        if (r30 == 0) goto L79;
        LifecycleOwner r31 = r15.b;
        Intrinsics.checkNotNull(r29);
        r30.i(r31, r29);
    L79:
        com.bytedance.awemeopen.apps.framework.feed.pinch.utils.m r32 = this.i;
        if (r32 == null) goto L83;
        r32.q = new FeedPinchPresenter$bindPinch$2(this);
    L83:
        ViewGroup r33 = this.e.b;
        if ((r33 instanceof VerticalViewPager) == false) goto L86;
        final VerticalViewPager r34 = (VerticalViewPager) r33;
    L87:
        if (r34 == null) goto L89;
        r34.c(this.r);
    L89:
        if (r34 == null) goto L91;
        boolean r35 = r34.P0;
    L92:
        this.j = r35;
        o54.a r36 = this.e.getActivity();
        if ((r36 instanceof o54.a) == false) goto L95;
        o54.a r37 = r36;
    L96:
        if (r37 == null) goto L109;
        Intrinsics.checkNotNullParameter(r37, "pinchObserver");
        if (this.s != null) goto L100;
        this.s = new CopyOnWriteArrayList();
    L100:
        CopyOnWriteArrayList<o54.a> r38 = this.s;
        if (r38 != null) goto L103;
    L105:
        if (r1 == false) goto L109;
        CopyOnWriteArrayList<o54.a> r39 = this.s;
        if (r39 == null) goto L109;
        r39.add(r37);
        goto L109
    L103:
        if (r38.contains(r37) == true) goto L105;
        r1 = true;
    L109:
        LifecycleOwner r40 = r15.b;
        FeedSpeedControlViewModel.a r41 = FeedSpeedControlViewModel.Companion;
        Activity r42 = r15.getActivity();
        if ((r42 instanceof LifecycleOwner) == false) goto L112;
        r4 = (LifecycleOwner) r42;
    L112:
        if (r4 != null) goto L114;
        r4 = r40;
    L114:
        r41.getClass();
        this.n = FeedSpeedControlViewModel.a.a(r4, "");
        ?? r43 = new e(r34, this);
        this.k = r43;
        this.l = new f(this);
        this.o = new g(this, r15, r34);
        this.m = new h(this);
        if (r40 == null) goto L126;
        qz3.b r44 = r15.i;
        if (r44 == 0) goto L119;
        Intrinsics.checkNotNull(r43);
        r44.u(r40, r43);
    L119:
        DiscardFirstValueLiveData<Boolean> r45 = this.e.c.getEnterPinchMode();
        f r46 = this.l;
        Intrinsics.checkNotNull(r46);
        r45.observe(r40, r46);
        FeedSpeedControlViewModel r47 = this.n;
        if (r47 == null) goto L124;
        MutableLiveData<Pair<String, Boolean>> r48 = r47.getFastSpeedModeEvent();
        if (r48 == null) goto L124;
        g r49 = this.o;
        Intrinsics.checkNotNull(r49);
        r48.observe(r40, r49);
    L124:
        DiscardFirstValueLiveData<Boolean> r50 = this.e.c.getLoadMoreUiShow();
        h r51 = this.m;
        Intrinsics.checkNotNull(r51);
        r50.observe(r40, r51);
        return;
    L126:
        return;
    L95:
        r37 = null;
        goto L96
    L91:
        r35 = false;
        goto L92
    L86:
        r34 = null;
        goto L87
    L43:
        r19 = null;
    L36:
        View r52 = this.e.e.b;
        if ((r52 instanceof ViewGroup) == false) goto L39;
        r14 = (ViewGroup) r52;
        goto L40
    L39:
        r14 = null;
        goto L40
    L63:
        View r53 = this.e.e.b;
        if ((r53 instanceof ViewGroup) == false) goto L66;
        ViewGroup r54 = (ViewGroup) r53;
    L67:
        r15 = new sz3.c();
        r15.f = this.f;
        r15.g = r9;
        r15.h = this.g;
        r15.i = this.h;
        r15.j = new FeedPinchPresenter$bindVideo$pinchParams$1$1(this);
        r15.o = Boolean.valueOf(this.t);
        r15.a = this.e.getActivity();
        r15.e = this.e.c.sceneId();
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r55 = this.e;
        r15.b = r55.e.d;
        r15.c = r55.c;
        r15.k = r54;
        r15.l = ((FullVideoView) this.a.findViewById(2131375746)).getVideoView().getCustomPlayer();
        PinchStateViewModel.a r56 = PinchStateViewModel.Companion;
        LifecycleOwner r57 = this.e.getActivity();
        if ((r57 instanceof LifecycleOwner) == false) goto L70;
        LifecycleOwner r58 = r57;
    L71:
        if (r58 != null) goto L73;
        r58 = this.e.e.d;
    L73:
        r56.getClass();
        r15.m = PinchStateViewModel.a.a(r58);
        com.bytedance.awemeopen.apps.framework.feed.pinch.utils.m r59 = this.i;
        if (r59 == null) goto L76;
        r59.n(r15);
    L76:
        qz3.d r60 = this.h;
        if (r60 == null) goto L79;
        r60.i(this.e.e.d, this.y);
        goto L79
    L70:
        r58 = null;
        goto L71
    L66:
        r54 = null;
        goto L67
    L27:
        if (com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.c.a(r11) != 3) goto L29;
        r12 = true;
        goto L30
    L21:
        if (com.bytedance.awemeopen.apps.framework.feed.ui.information.a.m == false) goto L23;
    L22:
        r10 = true;
        goto L24
    L18:
        if (com.bytedance.awemeopen.apps.framework.feed.ui.information.a.k == true) goto L22;
    L11:
        r3 = null;
        goto L12
    L127:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void m(boolean r7) {
        int r0 = 0;
        if (r7 == false) goto L5;
        int r1 = 4;
    L6:
        ViewGroup r2 = this.e.b;
        if ((r2 instanceof VerticalViewPager) == false) goto L9;
        VerticalViewPager r3 = (VerticalViewPager) r2;
    L10:
        if (r3 != null) goto L12;
        return;
    L12:
        int r4 = r3.getChildCount();
    L13:
        if (r0 >= r4) goto L24;
        View r5 = r3.getChildAt(r0);
        boolean r6 = Intrinsics.areEqual(this.a, r5);
        if (r5 == null) goto L23;
        if (r6 == false) goto L18;
        if (r7 == true) goto L23;
    L18:
        r5.setVisibility(r1);
        if (r7 == false) goto L21;
        float r8 = 0.0f;
    L22:
        r5.setAlpha(r8);
        goto L23
    L21:
        r8 = 1.0f;
    L23:
        r0 = r0 + 1;
        goto L13
    L24:
        return;
    L9:
        r3 = null;
        goto L10
    L5:
        r1 = 0;
        goto L6
    }

    public final void n(boolean r8, String r9) {
        LinkedHashMap r2 = new LinkedHashMap();
        r2.put("enter_from", this.e.c.sceneId());
        r14.c r0 = this.f;
        if (r0 == null) goto L6;
        String r1 = r0.c();
        if (r1 == null) goto L6;
    L7:
        r2.put("group_id", r1);
        r14.c r3 = this.f;
        if (r3 == null) goto L13;
        User r4 = r3.f();
        if (r4 == null) goto L13;
        String r5 = r4.u();
        if (r5 == null) goto L13;
    L14:
        r2.put("author_id", r5);
        if (r8 == false) goto L19;
        if (r9 != null) goto L18;
        r9 = "";
    L18:
        r2.put("enter_method", r9);
    L41:
        if (r8 == false) goto L43;
        this.A = System.currentTimeMillis();
    L44:
        com.bytedance.awemeopen.apps.framework.feed.pinch.utils.m r10 = this.i;
        float r11 = 1.0f;
        if (r10 == null) goto L51;
        sz3.c r12 = r10.d;
        if (r12 == null) goto L51;
        com.bytedance.awemeopen.infra.base.player.g r13 = r12.l;
        if (r13 == null) goto L51;
        float r14 = r13.getPlaySpeed();
    L52:
        r2.put("to_status", Float.valueOf(r14));
        com.bytedance.awemeopen.apps.framework.feed.pinch.utils.m r15 = this.i;
        if (r15 == null) goto L55;
        r11 = r15.j.w;
    L55:
        r2.put("zoom_size", Float.valueOf(r11));
        AosEventReporter.s(AosEventReporter.a, "pure_clear_screen_mode", r2, null, null, null, 28);
        return;
    L51:
        r14 = 1.0f;
        goto L52
    L43:
        r2.put("duration", Long.valueOf(System.currentTimeMillis() - this.A));
        goto L44
    L19:
        if (r9 == null) goto L38;
        int r6 = r9.hashCode();
        if (r6 == (-1377687758)) goto L35;
        if (r6 == (-1272607767)) goto L31;
        if (r6 != 1089111664) goto L38;
        if (r9.equals(PinchStableView.Gesture.PULL_DOWN) == false) goto L38;
    L33:
        r9 = "slide";
    L40:
        r2.put("exit_method", r9);
        goto L41
    L31:
        if (r9.equals(PinchStableView.Gesture.PULL_UP) == true) goto L33;
    L35:
        if (r9.equals("button") == false) goto L38;
        r9 = "back_click";
    L38:
        if (r9 != null) goto L40;
        r9 = "";
    L13:
        r5 = "";
    L6:
        r1 = "";
        goto L7
    }
}
