package com.ss.android.lark.keyboard.keyboard2;

import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import androidx.transition.ChangeBounds;
import androidx.transition.TransitionManager;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.nova.R;
import com.larus.platform.api.creation.TplType;
import com.larus.utils.logger.FLogger;
import com.obric.trace.ObricActionBarTrackType;
import com.ss.android.lark.keyboard.event.HeightChange;
import com.ss.android.lark.keyboard.event.ImeState;
import com.ss.android.lark.keyboard.event.r;
import com.ss.android.lark.keyboard.ime.ExtensionImeKt;
import com.ss.android.lark.keyboard.ime.ImeStateDetail;
import com.ss.android.lark.keyboard.ime.ImeWrapper;
import com.ss.android.lark.keyboard.keyboard2.content.IKeyboardContent;
import com.ss.android.lark.keyboard.keyboard2.content.KeyboardMainContent;
import com.ss.android.lark.keyboard.utils.TransitionUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public abstract class BasicKeyboard implements com.ss.android.lark.keyboard.b, com.ss.android.lark.keyboard.ime.e, View.OnLayoutChangeListener, com.ss.android.lark.keyboard.ime.i, com.ss.android.lark.keyboard.ime.g {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final /* synthetic */ int f429434u = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<c.a<?>, c> f429435a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final KeyboardRootContainer f429436b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FrameLayout f429437c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ViewGroup f429438d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.ss.android.lark.keyboard.event.o f429439e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final KeyboardMainContent f429440f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.ss.android.lark.keyboard.keyboard2.content.b f429441g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final KeyboardImeWrapper f429442h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final KeyboardMenu f429443i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final k f429444j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f429445k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final List<Function0<Unit>> f429446l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Function0<Unit> f429447m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f429448n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f429449o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f429450p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f429451q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f429452r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f429453s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public TransitionWrapper f429454t;

    public static final class a {
    }

    public static final class b implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f429455a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BasicKeyboard f429456b;

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r100) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r100) {
            this.f429455a.removeOnAttachStateChangeListener(this);
            BasicKeyboard.P(this.f429456b);
        }

        public b(KeyboardRootContainer r100, BasicKeyboard r101) {
            this.f429455a = r100;
            this.f429456b = r101;
        }
    }

    static {
    }

    @Override // com.ss.android.lark.keyboard.ime.e
    public final void K(int r100, int r101, int r102, float r103, float r104) {
    }

    public abstract View T();

    @Override // com.ss.android.lark.keyboard.ime.e
    public final void g(int r100, int r101, int r102, int r103, float r104) {
    }

    @Override // com.ss.android.lark.keyboard.b
    public final d H() {
        c r100 = y(d.N1);
        if (r100 == null) goto L7;
        return (d) r100;
    L7:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // com.ss.android.lark.keyboard.ime.e
    public final void J() {
        this.f429447m.invoke();
    }

    @Override // com.ss.android.lark.keyboard.b
    public com.ss.android.lark.keyboard.keyboard2.b L() {
        c r100 = y(com.ss.android.lark.keyboard.keyboard2.b.K1);
        if (r100 == null) goto L7;
        return (com.ss.android.lark.keyboard.keyboard2.b) r100;
    L7:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final void U() {
        KeyboardRootContainer r100 = this.f429436b;
        r100.getClass();
        long r101 = System.currentTimeMillis();
        r100.measure(r100.f429496e, r100.f429497f);
        Log.d(ObricActionBarTrackType.KEY_BOARD, "keyboard remeasure, cost: " + (System.currentTimeMillis() - r101));
    }

    @Override // com.ss.android.lark.keyboard.b
    public final k l() {
        c r100 = y(k.f429556f);
        if (r100 == null) goto L7;
        return (k) r100;
    L7:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // com.ss.android.lark.keyboard.b
    public final com.ss.android.lark.keyboard.keyboard2.content.c v() {
        c r100 = y(com.ss.android.lark.keyboard.keyboard2.content.c.O1);
        if (r100 == null) goto L7;
        return (com.ss.android.lark.keyboard.keyboard2.content.c) r100;
    L7:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // com.ss.android.lark.keyboard.b
    public final com.ss.android.lark.keyboard.ime.a z() {
        c r100 = y(KeyboardImeWrapper.D);
        if (r100 == null) goto L7;
        return (com.ss.android.lark.keyboard.ime.a) r100;
    L7:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // com.ss.android.lark.keyboard.b
    public final com.ss.android.lark.keyboard.event.k e() {
        return this.f429439e;
    }

    public static final void P(BasicKeyboard r100) {
        r100.getClass();
        Log.i(ObricActionBarTrackType.KEY_BOARD, "attached");
        Iterator r101 = ((ArrayList) r100.f429446l).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((Function0) r101.next()).invoke();
        goto L4
    L6:
        Iterator r102 = ((LinkedHashMap) r100.f429435a).values().iterator();
    L8:
        if (r102.hasNext() == false) goto L10;
        ((c) r102.next()).d();
        goto L8
    L10:
        KeyboardRootContainer r103 = r100.f429436b;
        if (r103.isAttachedToWindow() == true) goto L13;
        Q(r100);
    L14:
        r100.f429436b.addOnLayoutChangeListener(r100);
        if (r100.f429450p == true) goto L17;
        return;
    L17:
        if (((Boolean) r100.f429452r.getValue()).booleanValue() == false) goto L23;
        r100.f429438d.removeAllViews();
        r100.f429438d.addView(r100.f429442h);
        r100.f429442h.l(r100);
        ExtensionImeKt.a(r100.f429442h, r100);
        r100.f429442h.n(r100);
        return;
    L23:
        return;
    L13:
        r103.addOnAttachStateChangeListener(new com.ss.android.lark.keyboard.keyboard2.a(r103, r100));
        goto L14
    }

    public static final void Q(BasicKeyboard r100) {
        r100.getClass();
        Log.i(ObricActionBarTrackType.KEY_BOARD, "detached");
        r100.f429442h.H(r100);
        ExtensionImeKt.b(r100.f429442h, r100);
        KeyboardImeWrapper r101 = r100.f429442h;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "interceptor");
        ((ArrayList) r101.f429350k).remove(r100);
        Iterator r102 = ((LinkedHashMap) r100.f429435a).values().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((c) r102.next()).j();
        goto L4
    L6:
        r100.f429436b.removeOnLayoutChangeListener(r100);
        r100.f429450p = true;
    }

    public final void S(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        r100.addView(this.f429436b);
        KeyboardRootContainer r101 = this.f429436b;
        if (r101.isAttachedToWindow() == false) goto L5;
        P(this);
        return;
    L5:
        r101.addOnAttachStateChangeListener(new b(r101, this));
    }

    public final void V(int r100) {
        int r101 = this.f429440f.f429515d.getHeight();
        int r102 = 0;
        if (this.f429436b.getVisibility() != 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L8;
        r102 = (this.f429437c.getHeight() - r101) + r100;
    L8:
        this.f429445k = r102;
        return;
    L5:
        r103 = false;
        goto L6
    }

    @Override // com.ss.android.lark.keyboard.ime.e
    public final void a(int r100) {
        if (this.f429449o == true) goto L5;
        this.f429436b.setMinimumHeight(0);
    L5:
        this.f429441g.l().c(r100);
        V(r100);
        Log.i(ObricActionBarTrackType.KEY_BOARD, "notifyKeyboardHeightChange: height is " + this.f429445k);
    }

    @Override // com.ss.android.lark.keyboard.ime.g
    public final boolean r(com.ss.android.lark.keyboard.ime.f r100) {
        Intrinsics.checkNotNullParameter(r100, "imeInsets");
        if (r100.f429387d == true) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == false) goto L33;
        View r102 = this.f429436b.getRootView().findFocus();
        if (r102 == null) goto L12;
    L15:
        if (r102 == null) goto L20;
        boolean r103 = !Intrinsics.areEqual(this.f429436b.findFocus(), r102);
        if (r103 == false) goto L19;
        Log.i(ObricActionBarTrackType.KEY_BOARD, "focus view is not in keyboard, intercept action");
    L19:
        return r103;
    L20:
        Log.i(ObricActionBarTrackType.KEY_BOARD, "focus view is null ,request focus");
        boolean r104 = this.f429444j.getContext().hasWindowFocus();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L25;
        FLogger.f375446a.i("DecorViewLancet", "hasWindowFocus");
        Thread r105 = ThreadMethodProxy.currentThread();
        if (r105 == com.larus.home.impl.utils.c.f346341a) goto L25;
        com.larus.home.impl.utils.c.a(r105, "hasWindowFocus");
    L25:
        if (r104 == false) goto L33;
        KeyboardImeWrapper r106 = this.f429442h;
        Function0<? extends View> r107 = r106.f429360u;
        View r108 = r106;
        if (r107 == null) goto L32;
        View r109 = r107.invoke();
        r108 = r106;
        if (r109 == null) goto L32;
        r108 = r109;
    L32:
        r108.requestFocus();
        goto L33
    L12:
        if (((Boolean) this.f429451q.getValue()).booleanValue() == false) goto L15;
        Log.i(ObricActionBarTrackType.KEY_BOARD, "focus view is null, intercept ime enter");
        return true;
    L33:
        return false;
    L5:
        if (r100.f429388e == false) goto L7;
        r101 = true;
        goto L8
    }

    @Override // com.ss.android.lark.keyboard.b
    public final <E extends c> E y(c.a<E> r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        c r101 = this.f429435a.get(r100);
        if ((r101 instanceof c) == true) goto L7;
        return null;
    L7:
        return (E) r101;
    }

    public final void R(c.a<?> r100, c r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "element");
        this.f429435a.put(r100, r101);
        r101.setKeyboard(this);
    }

    @Override // com.ss.android.lark.keyboard.ime.i
    public final void u(ImeState r100, ImeState r101) {
        Intrinsics.checkNotNullParameter(r100, "from");
        Intrinsics.checkNotNullParameter(r101, RemoteMessageConst.TO);
        this.f429442h.requestLayout();
        com.ss.android.lark.keyboard.event.k.a.a(this.f429439e, com.ss.android.lark.keyboard.event.e.a(r100, r101));
    }

    @Override // com.ss.android.lark.keyboard.ime.i
    public final void B(ImeStateDetail r100, ImeStateDetail r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "from");
        Intrinsics.checkNotNullParameter(r101, RemoteMessageConst.TO);
        if (r100 != r101) goto L5;
        return;
    L5:
        Log.d(ObricActionBarTrackType.KEY_BOARD, "notifyStateTransform: from " + r100 + ", to " + r101 + ", type: " + r102);
        ImeWrapper.a r103 = ImeWrapper.B;
        Intrinsics.checkNotNullParameter(r103, "<this>");
        if (r102 != 1) goto L8;
        com.ss.android.lark.keyboard.event.k.a.a(this.f429439e, com.ss.android.lark.keyboard.event.e.a(new com.ss.android.lark.keyboard.event.n(r100), new com.ss.android.lark.keyboard.event.n(r101)));
        return;
    L8:
        Intrinsics.checkNotNullParameter(r103, "<this>");
        if (r102 != 2) goto L13;
        com.ss.android.lark.keyboard.event.k.a.a(this.f429439e, com.ss.android.lark.keyboard.event.e.a(new r(r100), new r(r101)));
        return;
    }

    public BasicKeyboard(Context r100, KeyboardImeWrapper r101, KeyboardMenu r102, k r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "wrapper");
        Intrinsics.checkNotNullParameter(r102, TplType.MENU);
        Intrinsics.checkNotNullParameter(r103, "keyboardContext");
        this.f429435a = new LinkedHashMap();
        View r104 = LayoutInflater.from(r100).inflate(R.layout.kb_abs_keyboard, null, false);
        r104.setTag(R.id.kb_change_bounds_root_view, Boolean.TRUE);
        r104.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type com.ss.android.lark.keyboard.keyboard2.KeyboardRootContainer");
        KeyboardRootContainer r105 = (KeyboardRootContainer) r104;
        this.f429436b = r105;
        FrameLayout r106 = (FrameLayout) r105.findViewById(R.id.kb_content_container);
        this.f429437c = r106;
        ViewGroup r107 = (ViewGroup) r105.findViewById(R.id.ime_wrapper_container);
        this.f429438d = r107;
        this.f429439e = new com.ss.android.lark.keyboard.event.o(this);
        KeyboardMainContent r108 = new KeyboardMainContent(r100);
        this.f429440f = r108;
        com.ss.android.lark.keyboard.keyboard2.content.b r109 = new com.ss.android.lark.keyboard.keyboard2.content.b(r108);
        this.f429441g = r109;
        this.f429442h = r101;
        this.f429443i = r102;
        this.f429444j = r103;
        this.f429446l = new ArrayList();
        this.f429447m = BasicKeyboard$animateHeightChangeNotifier$1.INSTANCE;
        this.f429451q = LazyKt.lazy(BasicKeyboard$isFocuslessImeInsetsFilterEnabled$2.INSTANCE);
        this.f429452r = LazyKt.lazy(BasicKeyboard$isVoiceKeyboardWithEmoji$2.INSTANCE);
        R(com.ss.android.lark.keyboard.keyboard2.content.c.O1, r109);
        R(KeyboardImeWrapper.D, r101);
        R(d.N1, r102);
        R(k.f429556f, r103);
        Intrinsics.checkNotNullParameter(r106, "contentContainer");
        r109.f429532d = r106;
        KeyboardMainContent r110 = r109.f429529a;
        Intrinsics.checkNotNullParameter(r110, "content");
        r110.k(r109.r());
        Map<String, IKeyboardContent> r111 = r109.f429533e;
        r110.f429513b.getClass();
        r111.put("MainContent", r110);
        if (r109.f429537i == true) goto L5;
        ((ArrayList) r109.f429535g).add(r110);
    L6:
        r109.a(r109.f429529a.f429513b, true);
        r107.removeAllViews();
        r107.addView(r101);
        r101.l(this);
        ExtensionImeKt.a(r101, this);
        r101.n(this);
        View r112 = r102.f429468f;
        Intrinsics.checkNotNullParameter(r112, "menuView");
        r108.f429516e.removeAllViews();
        r108.f429516e.addView(r112);
        return;
    L5:
        r109.n(r110);
        goto L6
    }

    @Override // com.ss.android.lark.keyboard.ime.e
    public final void n(int r110, final int r111, final long r112, final Interpolator r210) {
        Intrinsics.checkNotNullParameter(r210, "interpolator");
        this.f429441g.l().c(r111);
        if (this.f429448n == true) goto L30;
        Log.d(ObricActionBarTrackType.KEY_BOARD, "setupHeightChangeTransition called");
        V(r111);
        final FrameLayout r100 = this.f429437c;
        if (TransitionUtils.a(r100) == false) goto L8;
    L10:
        boolean r101 = false;
    L11:
        if (r101 == true) goto L13;
        Log.e(ObricActionBarTrackType.KEY_BOARD, "setupHeightChangeTransition: current content has transition running, method return.");
        return;
    L13:
        KeyboardMainContent r102 = this.f429440f;
        KeyboardChangeBounds r113 = new KeyboardChangeBounds();
        KeyboardRootContainer r114 = this.f429436b;
        final Rect r115 = new Rect(r114.getLeft(), r114.getTop(), r114.getRight(), r114.getBottom());
        final Rect r103 = new Rect();
        Function3<View, Rect, Rect, Unit> r116 = new BasicKeyboard$prepareChangeBounds$1$1(this, r103, r115);
        Intrinsics.checkNotNullParameter(r116, "handleAction");
        r113.f429461d = r116;
        TransitionWrapper r104 = new TransitionWrapper(r102.j(r113));
        TransitionWrapper r105 = this.f429454t;
        if (r105 == null) goto L16;
        r105.cancel();
    L16:
        this.f429454t = r104;
        r104.excludeTarget(this.f429443i.f429468f, true);
        r104.setDuration(r112);
        r104.setInterpolator(r210);
        final int r106 = r100.getHeight();
        if (r111 >= r110) goto L19;
        KeyboardRootContainer r107 = this.f429436b;
        r107.setMinimumHeight(r107.getHeight());
    L19:
        if (r111 < r110) goto L21;
    L23:
        boolean r108 = false;
    L24:
        r104.addListener(new BasicKeyboard$setupHeightChangeTransition$1(this));
        if (r108 == false) goto L27;
        ChangeBounds r109 = new ChangeBounds();
        r109.excludeTarget(this.f429442h.getPanel(), true);
        r109.setDuration(r112);
        r109.setInterpolator(r210);
        TransitionManager.beginDelayedTransition(this.f429438d, r109);
    L27:
        TransitionManager.beginDelayedTransition(r100, r104);
        this.f429449o = true;
        this.f429453s = true;
        this.f429447m = new BasicKeyboard$setupHeightChangeTransition$2(this, r106, r111, r100, r112, r210);
        return;
    L21:
        if (this.f429442h.B() == true) goto L23;
        r108 = true;
        goto L24
    L8:
        if (ViewCompat.isLaidOut(r100) == false) goto L10;
        r101 = true;
        goto L11
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
        com.ss.android.lark.keyboard.keyboard2.b r109 = this.f429440f.e().L();
        if ((r109 instanceof mob.a) == false) goto L5;
        mob.a r110 = (mob.a) r109;
    L6:
        if (r110 == null) goto L8;
        r110.A();
    L8:
        boolean r111 = false;
        int r112 = this.f429436b.getHeight() - 0;
        Log.d(ObricActionBarTrackType.KEY_BOARD, "onGlobalLayout: height change " + this.f429445k + " -> " + r112);
        this.f429445k = r112;
        if (this.f429442h.T() == false) goto L11;
    L16:
        boolean r113 = true;
    L17:
        if (r113 == false) goto L20;
        return;
    L20:
        if (this.f429436b.getVisibility() != 0) goto L22;
        r111 = true;
    L22:
        if (r111 == false) goto L31;
        Log.i(ObricActionBarTrackType.KEY_BOARD, "notifyKeyboardHeightChange: height is " + this.f429445k);
        int r114 = this.f429445k;
        if (this.f429453s == false) goto L27;
        Log.d(ObricActionBarTrackType.KEY_BOARD, "NotifyHeightChange suppressed");
        return;
    L27:
        Log.i(ObricActionBarTrackType.KEY_BOARD, "notifyKeyboardHeightChange: height is " + r114);
        HeightChange r115 = HeightChange.f429287b.a();
        r115.f429288a = r114;
        com.ss.android.lark.keyboard.event.k.a.a(this.f429439e, r115);
        r115.recycle();
        return;
    L31:
        return;
    L11:
        if (this.f429448n == true) goto L16;
        if (this.f429449o == true) goto L16;
        r113 = false;
        goto L17
    L5:
        r110 = null;
        goto L6
    }
}
