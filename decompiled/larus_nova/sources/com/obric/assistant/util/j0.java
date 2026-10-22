package com.obric.assistant.util;

import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.ability.PageStateChangedReason;
import com.obric.assistant.component.ObricChatPageStateComponent;
import com.obric.assistant.data.ObricFloatChatPageData;
import com.obric.assistant.data.ObricFloatChatPageState;
import com.obric.assistant.interaction.api.IKeyguardStateKt;
import com.obric.assistant.interaction.base.feedback.VibratorSmtFeedbackEffect;
import com.obric.assistant.interaction.base.util.SystemHiddenApiHelper;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class j0 {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final /* synthetic */ int f393726x = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final va8.l f393727a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final hca.d f393728b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final va8.c f393729c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final p f393730d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f393731e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f393732f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f393733g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f393734h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f393735i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f393736j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f393737k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f393738l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f393739m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f393740n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public n1 f393741o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Integer f393742p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Integer f393743q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f393744r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public MessageListHeightDecoration f393745s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Handler f393746t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Lazy f393747u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f393748v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f393749w;

    public static final class a {
    }

    static {
    }

    public final void i(int r100) {
        this.f393730d.i(r100);
    }

    public final void j(int r100, boolean r101) {
        this.f393730d.j(r100, r101);
    }

    public final void k(boolean r100, boolean r101) {
        this.f393730d.k(r100, r101);
    }

    public final void l(boolean r100) {
        this.f393730d.l(r100);
    }

    public final void m() {
        this.f393730d.m();
    }

    public final void n() {
        this.f393730d.n();
    }

    public final void o(boolean r100) {
        this.f393730d.p(r100);
    }

    public final void q(boolean r100) {
        this.f393730d.r(r100);
    }

    public final void t(boolean r100) {
        this.f393730d.s(r100);
    }

    public final void u(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        this.f393730d.t(r100);
    }

    public final b1 d() {
        this.f393730d.getClass();
        return new b1();
    }

    public final FrameLayout e() {
        return (FrameLayout) this.f393732f.getValue();
    }

    public final RecyclerView f() {
        return (RecyclerView) this.f393731e.getValue();
    }

    public final ObricFloatChatPageState g() {
        return this.f393728b.getPageState();
    }

    public final void h() {
        FLogger.f375446a.i("AutoIncreaseUtils", "interruptMoveAction");
        this.f393737k = true;
    }

    public final void p() {
        FLogger.f375446a.i("AutoIncreaseUtils", "onReceiveAutoIncreaseMsg, pageState is " + g());
        com.larus.utils.t0.e(new f0(this));
    }

    public final a1 s() {
        this.f393730d.getClass();
        return new a1();
    }

    public final z0 v() {
        this.f393730d.getClass();
        return new z0();
    }

    public final void x() {
        FLogger.f375446a.i("AutoIncreaseUtils", "tryAddLastItemHeightItemDecoration, layoutListener is " + this.f393741o + ", messageList is " + f());
        if (this.f393741o != null) goto L6;
        this.f393741o = new n1(new u(this), new a0(this), new b0(this), null, 24);
    L6:
        if (this.f393745s != null) goto L19;
        this.f393745s = new MessageListHeightDecoration(new c0(this), null, 6);
        RecyclerView r100 = f();
        if (r100 == null) goto L19;
        int r101 = r100.getItemDecorationCount();
        boolean r102 = false;
        int r103 = 0;
    L10:
        if (r103 >= r101) goto L15;
        if (Intrinsics.areEqual(r100.getItemDecorationAt(r103), this.f393745s) == true) goto L13;
        r103 = r103 + 1;
        goto L10
    L13:
        r102 = true;
    L15:
        if (r102 == true) goto L19;
        MessageListHeightDecoration r104 = this.f393745s;
        if (r104 == null) goto L19;
        r100.addItemDecoration(r104);
    L19:
        n1 r105 = this.f393741o;
        if (r105 == null) goto L30;
        RecyclerView r106 = f();
        if (r106 == null) goto L24;
        r106.removeOnLayoutChangeListener(r105);
    L24:
        RecyclerView r107 = f();
        if (r107 == null) goto L31;
        r107.addOnLayoutChangeListener(r105);
        return;
    L31:
        return;
    }

    public final void c(String r100) {
        if (this.f393743q == null) goto L5;
    L6:
        FLogger.f375446a.i("AutoIncreaseUtils", "clearPendingAutoIncreaseTopEmptyHeight, reason = " + r100 + ", pendingAutoIncreaseTopEmptyHeight = " + this.f393743q + ", pendingAutoIncreaseMsgCreateTime = " + this.f393744r);
    L7:
        this.f393743q = null;
        this.f393744r = Long.MAX_VALUE;
        return;
    L5:
        if (this.f393744r == Long.MAX_VALUE) goto L7;
        goto L6
    }

    public final void r(final Message r100) {
        FLogger r101 = FLogger.f375446a;
        r101.i("AutoIncreaseUtils", "onSendMessage, message is " + r100);
        if (r100 != null) goto L5;
    L8:
        if (r100 == null) goto L10;
        xg9.b.a().storeLong("last_msg_create_time", r100.getCreateTime());
        r101.i("AutoIncreaseUtils", "onSendMessage store createTime, createTime = " + r100.getCreateTime());
    L10:
        com.larus.utils.t0.e(new d0(this, r100));
        return;
    L5:
        if (com.larus.bmhome.chat.bean.d.T(r100) == false) goto L8;
        r101.i("AutoIncreaseUtils", "onSendMessage, empty message");
    }

    public final void w(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        FLogger.f375446a.i("AutoIncreaseUtils", "resetFirstMsgCreateTime, reason = ".concat(r100));
        this.f393738l = Long.MAX_VALUE;
        c("resetFirstMsgCreateTime:".concat(r100));
    }

    public j0(va8.l r100, ObricChatPageStateComponent r101, final va8.c r102) {
        Intrinsics.checkNotNullParameter(r101, "callback");
        p r103 = new p(r100, new n(r101), new g0(), new h0(r102));
        Intrinsics.checkNotNullParameter(r101, "pageStateCallback");
        Intrinsics.checkNotNullParameter(r103, "autoDismissDelegate");
        this.f393727a = r100;
        this.f393728b = r101;
        this.f393729c = r102;
        this.f393730d = r103;
        this.f393731e = LazyKt.lazy(new i0(this));
        this.f393732f = LazyKt.lazy(new v(this));
        this.f393733g = LazyKt.lazy(new w(this));
        this.f393734h = LazyKt.lazy(new x(this));
        this.f393736j = true;
        this.f393738l = Long.MAX_VALUE;
        this.f393739m = Long.MAX_VALUE;
        this.f393744r = Long.MAX_VALUE;
        this.f393746t = new Handler(Looper.getMainLooper());
        this.f393747u = LazyKt.lazy(new y());
        RecyclerView r104 = f();
        if (r104 == null) goto L6;
        r104.addOnScrollListener(new AutoIncreaseUtils$3(this));
        return;
    }

    public static final void a(j0 r100, float r101, float r102, boolean r103) {
        r100.getClass();
        ObricFloatChatPageData.a r104 = ObricFloatChatPageData.Companion;
        ObricFloatChatPageState r105 = r100.g();
        r104.getClass();
        if ((r105 instanceof vda.f) == false) goto L6;
        return;
    L6:
        if ((r100.g() instanceof vda.c) == true) goto L8;
        r100.f393728b.o2(r100.f393735i);
    L8:
        boolean r106 = true;
        if (r103 == true) goto L11;
        int r107 = (int) r101;
        r100.f393728b.o2(r100.f393735i + r107);
        int r108 = -m2.f393771c;
        int r109 = m2.f393772d;
        if (r108 > r107) goto L53;
        if (r107 > r109) goto L53;
    L54:
        if (r106 == false) goto L56;
    L60:
        r100.f393736j = r106;
        return;
    L56:
        if (r100.f393736j == false) goto L60;
        if (r107 < r108) goto L60;
        if (r107 <= r109) goto L60;
        SystemHiddenApiHelper.INSTANCE.performVibratorSmtFeedback(VibratorSmtFeedbackEffect.EFFECT_SOFT);
    L53:
        r106 = false;
        goto L54
    L11:
        if (r102 >= (-1500.0f)) goto L16;
        if (r101 >= 0.0f) goto L16;
        r100.f393728b.T7(Float.valueOf(r102), true, "");
        return;
    L16:
        if (r102 <= 1500.0f) goto L21;
        if (r101 <= 0.0f) goto L21;
        r100.f393728b.T8(r102, false);
        return;
    L21:
        if (r101 <= 0.0f) goto L31;
        if (r101 >= m2.f393772d) goto L29;
        Integer r110 = r100.f393742p;
        if (r110 == null) goto L27;
        int r111 = r110.intValue();
    L28:
        b(r100, false, r111, false, 5);
    L48:
        r100.f393742p = null;
        return;
    L27:
        r111 = r100.f393735i;
        goto L28
    L29:
        r100.f393728b.T8(r102, false);
        goto L48
    L31:
        if (Math.abs(r101) >= m2.f393771c) goto L38;
        Integer r112 = r100.f393742p;
        if (r112 == null) goto L35;
        int r113 = r112.intValue();
    L36:
        b(r100, false, r113, false, 5);
        goto L48
    L35:
        r113 = r100.f393735i;
        goto L36
    L38:
        if (r100.g().getHeight() > m2.f393770b) goto L40;
    L47:
        r100.f393728b.T7(Float.valueOf(r102), true, "");
        goto L48
    L40:
        if (IKeyguardStateKt.getKeyguardState().isDeviceLocked() == false) goto L47;
        Integer r114 = r100.f393742p;
        if (r114 == null) goto L45;
        int r115 = r114.intValue();
    L46:
        b(r100, false, r115, true, 1);
        goto L48
    L45:
        r115 = r100.f393735i;
        goto L46
    }

    public static void b(j0 r100, boolean r101, int r102, boolean r110, int r111) {
        if ((r111 & 1) == 0) goto L5;
        boolean r103 = true;
    L7:
        if ((r111 & 4) == 0) goto L9;
        boolean r104 = false;
    L10:
        r100.f393728b.i2(r103, r102, null, r104, false, PageStateChangedReason.OTHER);
        return;
    L9:
        r104 = r110;
        goto L10
    L5:
        r103 = r101;
        goto L7
    }
}
