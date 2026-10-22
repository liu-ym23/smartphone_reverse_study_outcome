package com.ss.android.lark.chat.chatwindow.biz.plugin;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.trace.ObricActionBarTrackType;
import com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowKeyboard;
import com.ss.android.lark.keyboard.event.ImeState;
import com.ss.android.lark.keyboard.ime.ExtensionImeKt;
import com.ss.android.lark.keyboard.ime.ImeStateDetail;
import com.ss.android.lark.keyboard.ime.ImeWrapper;
import com.ss.android.lark.keyboard.ime.i;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import v99.s;

/* JADX INFO: loaded from: classes35.dex */
public final class FlowChatMessageListViewObserverPlugin extends com.ss.android.lark.chat.chatwindow.biz.plugin.core.c {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f412272g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f412273h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public com.ss.android.lark.keyboard.ime.a f412274i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f412275j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f412276k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f412277l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f412278m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Integer f412279n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Integer f412280o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Pair<Integer, Integer> f412281p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Function2<Integer, Integer, Unit> f412282q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f412283r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final c f412284s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final d f412285t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final f f412286u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final e f412287v;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f412288a = null;

        static {
            int[] r100 = new int[ImeStateDetail.values().length];
            r100[ImeStateDetail.Enter.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[ImeStateDetail.Show.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f412288a = r100;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FlowChatMessageListViewObserverPlugin f412289a;

        public b(FlowChatMessageListViewObserverPlugin r100) {
            this.f412289a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f412289a.J(null);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements com.ss.android.lark.keyboard.ime.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FlowChatMessageListViewObserverPlugin f412290a;

        @Override // com.ss.android.lark.keyboard.ime.e
        public final void J() {
            this.f412290a.J(null);
        }

        public c(FlowChatMessageListViewObserverPlugin r100) {
            this.f412290a = r100;
        }

        @Override // com.ss.android.lark.keyboard.ime.e
        public final void a(int r100) {
            this.f412290a.J(Integer.valueOf(r100));
        }

        @Override // com.ss.android.lark.keyboard.ime.e
        public final void n(int r100, int r110, long r111, Interpolator r112) {
            Intrinsics.checkNotNullParameter(r112, "interpolator");
            FlowChatMessageListViewObserverPlugin r101 = this.f412290a;
            if (r101.f412275j == false) goto L17;
            r101.f412277l = r100;
            r101.f412278m = r110;
            r101.getClass();
            eya.b r102 = this.f412290a.I();
            if (r102 == null) goto L9;
            s.a r103 = r102.b7();
            if (r103 == null) goto L9;
            r103.b(this.f412290a.f412276k, r100, r110, r111, r112);
        L9:
            eya.b r104 = this.f412290a.I();
            if (r104 == null) goto L14;
            s.b r105 = r104.a7();
            if (r105 == null) goto L14;
            r105.b(this.f412290a.f412276k, r100, r110, r111, r112);
        L14:
            eya.b r106 = this.f412290a.I();
            if (r106 == null) goto L17;
            boolean r113 = this.f412290a.f412276k;
            r106.e7(r112);
        L17:
            this.f412290a.J(Integer.valueOf(r110));
        }

        @Override // com.ss.android.lark.keyboard.ime.e
        public final void K(int r100, int r101, int r102, float r110, float r111) {
            if (this.f412290a.f412275j == false) goto L13;
            Intrinsics.checkNotNullParameter(ImeWrapper.B, "<this>");
            if (r100 != 2) goto L16;
            eya.b r103 = this.f412290a.I();
            if (r103 == null) goto L14;
            s.b r104 = r103.a7();
            if (r104 == null) goto L15;
            r104.c(this.f412290a.f412276k, r101, r102, r110, r111);
            return;
        L15:
            return;
        L14:
            return;
        L16:
            return;
        }

        @Override // com.ss.android.lark.keyboard.ime.e
        public final void g(int r100, int r101, int r102, int r110, float r111) {
            if (this.f412290a.f412275j == false) goto L13;
            Intrinsics.checkNotNullParameter(ImeWrapper.B, "<this>");
            if (r100 != 2) goto L16;
            eya.b r103 = this.f412290a.I();
            if (r103 == null) goto L14;
            s.a r104 = r103.b7();
            if (r104 == null) goto L15;
            r104.c(this.f412290a.f412276k, r101, r102, r110, r111);
            return;
        L15:
            return;
        L14:
            return;
        L16:
            return;
        }
    }

    public static final class d implements i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FlowChatMessageListViewObserverPlugin f412291a;

        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f412292a = null;

            static {
                int[] r100 = new int[ImeStateDetail.values().length];
                r100[ImeStateDetail.Enter.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
            L13:
                r100[ImeStateDetail.Exit.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
            L19:
                r100[ImeStateDetail.Show.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
            L15:
                r100[ImeStateDetail.Hide.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
            L7:
                f412292a = r100;
            }
        }

        public d(FlowChatMessageListViewObserverPlugin r100) {
            this.f412291a = r100;
        }

        @Override // com.ss.android.lark.keyboard.ime.i
        public final void u(ImeState r100, ImeState r101) {
            Intrinsics.checkNotNullParameter(r100, "from");
            Intrinsics.checkNotNullParameter(r101, RemoteMessageConst.TO);
        }

        @Override // com.ss.android.lark.keyboard.ime.i
        public final void B(ImeStateDetail r100, ImeStateDetail r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "from");
            Intrinsics.checkNotNullParameter(r101, RemoteMessageConst.TO);
            Intrinsics.checkNotNullParameter(ImeWrapper.B, "<this>");
            if (r102 == 2) goto L5;
            return;
        L5:
            int r103 = a.f412292a[r101.ordinal()];
            if (r103 == 1) goto L50;
            boolean r104 = false;
            if (r103 != 2) goto L10;
            FlowChatMessageListViewObserverPlugin r105 = this.f412291a;
            r105.f412281p = null;
            r105.f412275j = true;
            r105.f412276k = false;
            return;
        L10:
            if (r103 != 3) goto L12;
        L16:
            FlowChatMessageListViewObserverPlugin r106 = this.f412291a;
            if (r106.f412275j == false) goto L38;
            r106.f412275j = false;
            if (r100 != ImeStateDetail.Enter) goto L23;
            if (r101 != ImeStateDetail.Show) goto L23;
        L27:
            eya.b r107 = r106.I();
            if (r107 == null) goto L32;
            s.a r108 = r107.b7();
            if (r108 == null) goto L32;
            FlowChatMessageListViewObserverPlugin r109 = this.f412291a;
            r108.a(r109.f412276k, r109.f412277l, r109.f412278m, r104);
        L32:
            eya.b r110 = this.f412291a.I();
            if (r110 == null) goto L38;
            s.b r111 = r110.a7();
            if (r111 == null) goto L38;
            FlowChatMessageListViewObserverPlugin r112 = this.f412291a;
            r111.a(r112.f412276k, r112.f412277l, r112.f412278m, r104);
        L23:
            if (r100 == ImeStateDetail.Exit) goto L25;
        L26:
            r104 = true;
            goto L27
        L25:
            if (r101 == ImeStateDetail.Hide) goto L27;
        L38:
            if (r101 != ImeStateDetail.Show) goto L43;
            FlowChatMessageListViewObserverPlugin r113 = this.f412291a;
            Pair<Integer, Integer> r114 = r113.f412281p;
            if (r114 == null) goto L42;
            FlowChatMessageListViewObserverPlugin.F(r113, r114.component1().intValue(), r114.component2().intValue());
        L42:
            this.f412291a.f412281p = null;
            return;
        L43:
            FlowChatMessageListViewObserverPlugin r115 = this.f412291a;
            r115.f412281p = null;
            Integer r116 = r115.f412280o;
            if (r116 == null) goto L48;
            int r117 = r116.intValue();
            com.ss.android.lark.keyboard.ime.a r118 = r115.f412274i;
            if (r118 == null) goto L48;
            r118.u(r117, true);
        L48:
            this.f412291a.f412280o = null;
            return;
        L12:
            if (r103 == 4) goto L16;
            throw new NoWhenBranchMatchedException();
        L50:
            FlowChatMessageListViewObserverPlugin r119 = this.f412291a;
            r119.f412275j = true;
            r119.f412276k = true;
        }
    }

    public static final class e implements ChatWindowKeyboard.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FlowChatMessageListViewObserverPlugin f412293a;

        @Override // com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowKeyboard.a
        public final void a() {
        }

        @Override // com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowKeyboard.a
        public final void d() {
        }

        @Override // com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowKeyboard.a
        public final void f() {
        }

        public e(FlowChatMessageListViewObserverPlugin r100) {
            this.f412293a = r100;
        }

        @Override // com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowKeyboard.a
        public final void g(com.ss.android.lark.keyboard.b r100) {
            Intrinsics.checkNotNullParameter(r100, ObricActionBarTrackType.KEY_BOARD);
            this.f412293a.G(r100.z());
        }
    }

    public static final class f implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FlowChatMessageListViewObserverPlugin f412294a;

        public f(FlowChatMessageListViewObserverPlugin r100) {
            this.f412294a = r100;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
            this.f412294a.J(null);
        }
    }

    public final eya.b I() {
        return (eya.b) this.f412283r.getValue();
    }

    public FlowChatMessageListViewObserverPlugin() {
        this.f412282q = new FlowChatMessageListViewObserverPlugin$bottomMenuHeightCallback$1(this);
        this.f412283r = LazyKt.lazy(new FlowChatMessageListViewObserverPlugin$plusExtension$2(this));
        this.f412284s = new c(this);
        this.f412285t = new d(this);
        this.f412286u = new f(this);
        this.f412287v = new e(this);
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.plugin.core.BaseChatPlugin
    public final void D() {
        eya.b r100 = I();
        if (r100 == null) goto L5;
        r100.f7(null);
    L5:
        this.f412281p = null;
        this.f412280o = null;
        View r101 = this.f412273h;
        if (r101 == null) goto L8;
        r101.removeOnLayoutChangeListener(this.f412286u);
    L8:
        this.f412273h = null;
        this.f412272g = null;
        com.ss.android.lark.keyboard.ime.a r102 = this.f412274i;
        if (r102 == null) goto L11;
        r102.H(this.f412284s);
    L11:
        com.ss.android.lark.keyboard.ime.a r103 = this.f412274i;
        if ((r103 instanceof ImeWrapper) == false) goto L14;
        ImeWrapper r104 = (ImeWrapper) r103;
    L15:
        if (r104 == null) goto L17;
        ExtensionImeKt.b(r104, this.f412285t);
    L17:
        this.f412274i = null;
        super.D();
        return;
    L14:
        r104 = null;
        goto L15
    }

    public final void G(com.ss.android.lark.keyboard.ime.a r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (Intrinsics.areEqual(r100, this.f412274i) == true) goto L27;
        com.ss.android.lark.keyboard.ime.a r101 = this.f412274i;
        if (r101 == null) goto L9;
        r101.H(this.f412284s);
    L9:
        com.ss.android.lark.keyboard.ime.a r102 = this.f412274i;
        if ((r102 instanceof ImeWrapper) == false) goto L12;
        ImeWrapper r103 = (ImeWrapper) r102;
    L13:
        if (r103 == null) goto L15;
        ExtensionImeKt.b(r103, this.f412285t);
    L15:
        this.f412274i = r100;
        eya.b r104 = I();
        if (r104 == null) goto L18;
        r104.f7(this.f412282q);
    L18:
        com.ss.android.lark.keyboard.ime.a r105 = this.f412274i;
        if (r105 == null) goto L21;
        r105.l(this.f412284s);
    L21:
        com.ss.android.lark.keyboard.ime.a r106 = this.f412274i;
        if (r106 == null) goto L24;
        ExtensionImeKt.a(r106, this.f412285t);
    L24:
        J(null);
        return;
    L12:
        r103 = null;
        goto L13
    }

    public final View H(View r100) {
        if (r100 != null) goto L20;
        return null;
    L20:
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L7
        Object r102 = Result.m9449constructorimpl(r100.findViewWithTag("flow_chat_message_list_view_observer"));     // Catch: Throwable -> L7
    L10:
        if (Result.m9455isFailureimpl(r102) == false) goto L12;
        r102 = null;
    L12:
        View r103 = (View) r102;
        if (r103 == null) goto L15;
        return r103;
    L15:
        int r104 = r100.getResources().getIdentifier("flow_chat_message_list_view_observer", "id", getContext().getPackageName());
        if (r104 != 0) goto L19;
        return null;
    L19:
        return r100.findViewById(r104);
    L7:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    public final void J(Integer r100) {
        if (this.f412317e == false) goto L5;
        return;
    L5:
        View r101 = this.f412273h;
        if (r101 != null) goto L10;
        r101 = B().getView();
        if (r101 != null) goto L10;
        return;
    L10:
        View r102 = this.f412272g;
        if (r102 != null) goto L15;
        r102 = H(r101);
        this.f412272g = r102;
        if (r102 != null) goto L15;
        return;
    L15:
        int r103 = (r101.getHeight() - r101.getPaddingTop()) - r101.getPaddingBottom();
        ViewGroup.LayoutParams r104 = r101.getLayoutParams();
        Integer r105 = null;
        if ((r104 instanceof ViewGroup.MarginLayoutParams) == false) goto L18;
        ViewGroup.MarginLayoutParams r106 = (ViewGroup.MarginLayoutParams) r104;
    L20:
        if (r106 == null) goto L22;
        int r107 = r106.topMargin;
    L23:
        int r108 = r103 - r107;
        ViewGroup.LayoutParams r109 = r101.getLayoutParams();
        if ((r109 instanceof ViewGroup.MarginLayoutParams) == false) goto L26;
        ViewGroup.MarginLayoutParams r110 = (ViewGroup.MarginLayoutParams) r109;
    L27:
        if (r110 == null) goto L29;
        int r111 = r110.bottomMargin;
    L30:
        int r112 = r108 - r111;
        if (r112 > 0) goto L33;
        return;
    L33:
        com.ss.android.lark.keyboard.ime.a r113 = this.f412274i;
        if (r100 == null) goto L36;
        int r114 = r100.intValue();
    L41:
        boolean r115 = true;
        if (r113 != null) goto L44;
    L46:
        boolean r116 = false;
    L47:
        if (r116 == true) goto L57;
        if (r113 != null) goto L50;
    L52:
        boolean r117 = false;
    L53:
        if (r117 == true) goto L57;
        if (r114 > 0) goto L57;
        boolean r118 = false;
    L58:
        if (r118 == false) goto L60;
        int r119 = r114;
    L61:
        if (r113 != null) goto L63;
    L65:
        r115 = false;
    L66:
        if (r115 == false) goto L70;
        Integer r120 = this.f412280o;
        if (r120 == null) goto L70;
        r119 = r120.intValue();
    L70:
        Integer r121 = this.f412279n;
        if (r121 != null) goto L74;
    L75:
        this.f412279n = Integer.valueOf(r119);
        eya.b r122 = I();
        if (r122 == null) goto L78;
        r122.S2(r119);
    L78:
        if (r118 == false) goto L80;
        r112 = RangesKt.coerceAtLeast(r112 - r114, 0);
    L80:
        ViewGroup.LayoutParams r123 = r102.getLayoutParams();
        if (r123 != null) goto L84;
        return;
    L84:
        if (r123.height != r112) goto L86;
        return;
    L86:
        r123.height = r112;
        r102.setLayoutParams(r123);
        r102.requestLayout();
        return;
    L74:
        if (r121.intValue() == r119) goto L78;
    L63:
        if (r113.B() != true) goto L65;
    L60:
        r119 = 0;
        goto L61
    L50:
        if (r113.B() != true) goto L52;
        r117 = true;
    L57:
        r118 = true;
        goto L58
    L44:
        if (r113.y() != true) goto L46;
        r116 = true;
        goto L47
    L36:
        if (r113 == null) goto L38;
        r105 = Integer.valueOf(r113.height());
    L38:
        if (r105 == null) goto L40;
        r114 = r105.intValue();
        goto L41
    L40:
        r114 = 0;
        goto L41
    L29:
        r111 = 0;
        goto L30
    L26:
        r110 = null;
        goto L27
    L22:
        r107 = 0;
        goto L23
    L18:
        r106 = null;
        goto L20
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.plugin.core.BaseChatPlugin
    public final void z(com.ss.android.lark.chat.chatwindow.chat.v2.component.c r100, i7b.a r101) {
        Intrinsics.checkNotNullParameter(r100, "chatApp");
        Intrinsics.checkNotNullParameter(r101, "initData");
        View r102 = B().getView();
        this.f412273h = r102;
        if (r102 == null) goto L5;
        r102.addOnLayoutChangeListener(this.f412286u);
    L5:
        this.f412272g = H(this.f412273h);
        ChatWindowKeyboard r103 = r100.n();
        if (r103 == null) goto L8;
        r103.m7(this.f412287v);
    L8:
        if (r103 == null) goto L12;
        com.ss.android.lark.keyboard.b r104 = r103.n();
        if (r104 == null) goto L12;
        G(r104.z());
    L12:
        View r105 = this.f412273h;
        if (r105 == null) goto L16;
        r105.post(new b(this));
        return;
    }

    public static final void F(FlowChatMessageListViewObserverPlugin r100, int r101, int r102) {
        if (r100.f412317e == true) goto L24;
        if (r101 <= 0) goto L25;
        if (r102 <= 0) goto L28;
        com.ss.android.lark.keyboard.ime.a r103 = r100.f412274i;
        if (r103 == null) goto L29;
        ImeStateDetail r104 = r103.getPanelState().b();
        int r105 = a.f412288a[r104.ordinal()];
        boolean r106 = true;
        if (r105 != 1) goto L13;
        r100.f412281p = TuplesKt.to(Integer.valueOf(r101), Integer.valueOf(r102));
        return;
    L13:
        if (r105 != 2) goto L30;
        r100.f412280o = Integer.valueOf(r102);
        if (r101 >= r102) goto L19;
        r106 = false;
    L19:
        r103.u(r101, r106);
        if (r101 < r102) goto L26;
        r100.f412280o = null;
        return;
    L26:
        return;
    L30:
        return;
    L29:
        return;
    L28:
        return;
    L25:
        return;
    }
}
