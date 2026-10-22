package com.larus.office.plugins.inputv2.adapter;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.bottom.core.speaker.h;
import com.larus.bmhome.chat.component.bottom.core.speaker.l;
import com.larus.utils.logger.FLogger;
import dw8.o;
import dw8.q;
import dw8.r;
import dw8.s;
import dw8.t;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1;
import kotlinx.coroutines.flow.i1;
import va8.g0;
import va8.i;
import va8.p;

/* JADX INFO: loaded from: classes30.dex */
public final class g {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ int f362677s = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Fragment f362678a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s f362679b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final q f362680c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CopyOnWriteArraySet<r> f362681d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CopyOnWriteArraySet<t> f362682e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CopyOnWriteArraySet<i> f362683f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CopyOnWriteArraySet<o> f362684g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final CopyOnWriteArraySet<Function1<Boolean, Unit>> f362685h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Job f362686i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public va8.o f362687j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public e f362688k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public l f362689l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f362690m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f362691n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public dw8.a f362692o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f362693p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final b f362694q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final com.larus.office.plugins.inputv2.adapter.b f362695r;

    public static final class a {
    }

    public static final class b implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f362696a;

        public b(g r100) {
            this.f362696a = r100;
        }

        @Override // com.larus.bmhome.chat.component.bottom.core.speaker.h
        public final void a(com.larus.bmhome.chat.component.bottom.core.speaker.g r100) {
            Intrinsics.checkNotNullParameter(r100, "state");
            if (Intrinsics.areEqual(r100, com.larus.bmhome.chat.component.bottom.core.speaker.g.c.f299421a) == false) goto L6;
            this.f362696a.v(true);
            return;
        L6:
            if (Intrinsics.areEqual(r100, com.larus.bmhome.chat.component.bottom.core.speaker.g.a.f299419a) == false) goto L8;
        L17:
            this.f362696a.v(false);
            return;
        L8:
            if (Intrinsics.areEqual(r100, com.larus.bmhome.chat.component.bottom.core.speaker.g.b.f299420a) == true) goto L17;
            if ((r100 instanceof com.larus.bmhome.chat.component.bottom.core.speaker.g.e) == true) goto L17;
            if ((r100 instanceof com.larus.bmhome.chat.component.bottom.core.speaker.g.d) == false) goto L16;
            return;
        L16:
            throw new NoWhenBranchMatchedException();
        }
    }

    static {
    }

    public final boolean i() {
        if (this.f362693p == false) goto L5;
    L7:
        return false;
    L5:
        if (this.f362692o.f470327b == false) goto L7;
        return true;
    }

    public final void m() {
        if (this.f362693p == false) goto L5;
        return;
    L5:
        Job r100 = this.f362686i;
        if (r100 == null) goto L8;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
    L8:
        this.f362686i = null;
        r();
        if (this.f362692o.f470327b == false) goto L13;
        ICoreInputAbility r101 = (ICoreInputAbility) e(ICoreInputAbility.class);
        if (r101 == null) goto L13;
        r101.r7(new com.larus.office.plugins.inputv2.adapter.a());
    L13:
        s();
        this.f362693p = true;
        this.f362680c.UB(this.f362695r);     // Catch: Throwable -> L16
    L18:
        Iterator<t> r102 = this.f362682e.iterator();
    L20:
        if (r102.hasNext() == false) goto L26;
        t r103 = r102.next();
        s r104 = this.f362679b;     // Catch: Throwable -> L24
        Intrinsics.checkNotNull(r103);     // Catch: Throwable -> L24
        r104.K4(r103);     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        FLogger.f375446a.e("OfficeChatInputAdapter", "注销消息监听失败", th);
        goto L20
    L26:
        Iterator<i> r105 = this.f362683f.iterator();
    L28:
        if (r105.hasNext() == false) goto L34;
        i r106 = r105.next();
        s r107 = this.f362679b;     // Catch: Throwable -> L32
        Intrinsics.checkNotNull(r106);     // Catch: Throwable -> L32
        r107.Qr(r106);     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        FLogger.f375446a.e("OfficeChatInputAdapter", "注销窗口状态监听失败", th);
        goto L28
    L34:
        Iterator<o> r108 = this.f362684g.iterator();
    L36:
        if (r108.hasNext() == false) goto L72;
        o r109 = r108.next();
        s r110 = this.f362679b;     // Catch: Throwable -> L40
        Intrinsics.checkNotNull(r109);     // Catch: Throwable -> L40
        r110.UN(r109);     // Catch: Throwable -> L40
    L40:
        th = move-exception;
        FLogger.f375446a.e("OfficeChatInputAdapter", "注销窗口高度监听失败", th);
        goto L36
    L72:
        this.f362679b.gP(null);     // Catch: Throwable -> L44
    L70:
        this.f362679b.K2(null);     // Catch: Throwable -> L48
    L66:
        this.f362679b.ZR(null);     // Catch: Throwable -> L52
    L80:
        this.f362679b.K1(null);     // Catch: Throwable -> L56
    L58:
        this.f362682e.clear();
        this.f362683f.clear();
        this.f362684g.clear();
        this.f362685h.clear();
        dw8.a r111 = this.f362692o;
        if (r111.f470327b == false) goto L64;
        this.f362692o = new dw8.a(r111.f470326a, false);
        Iterator<r> r112 = this.f362681d.iterator();
    L62:
        if (r112.hasNext() == false) goto L64;
        r r113 = r112.next();
        Intrinsics.checkNotNull(r113);
        k(r113, this.f362692o);
    L64:
        this.f362681d.clear();
        return;
    L56:
        th = move-exception;
        FLogger.f375446a.e("OfficeChatInputAdapter", "清理 cmd biz type 失败", th);
    L52:
        th = move-exception;
        FLogger.f375446a.e("OfficeChatInputAdapter", "清理 AIChatHostConfig 失败", th);
    L48:
        th = move-exception;
        FLogger.f375446a.e("OfficeChatInputAdapter", "清理 ChatContextProvider 失败", th);
    L44:
        th = move-exception;
        FLogger.f375446a.e("OfficeChatInputAdapter", "清理会话删除 handler 失败", th);
    L16:
        th = move-exception;
        FLogger.f375446a.e("OfficeChatInputAdapter", "注销 Host 状态监听失败", th);
        goto L18
    }

    public final void r() {
        va8.o r100 = this.f362687j;
        e r101 = this.f362688k;
        this.f362687j = null;
        this.f362688k = null;
        if (r100 != null) goto L12;
        return;
    L12:
        r100.CE(new c());     // Catch: Throwable -> L9
        if (r101 == null) goto L14;
        r100.oR(r101);     // Catch: Throwable -> L9
        return;
    L14:
        return;
    L9:
        th = move-exception;
        FLogger.f375446a.e("OfficeChatInputAdapter", "解绑输入交互监听失败", th);
    }

    public final void s() {
        l r100 = this.f362689l;
        this.f362689l = null;
        this.f362690m = 0;
        if (r100 != null) goto L10;
    L8:
        v(false);
        return;
    L10:
        r100.B9(this.f362694q);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        FLogger.f375446a.e("OfficeChatInputAdapter", "解绑语音状态监听失败", th);
        goto L8
    }

    public final void b() {
        if (i() == true) goto L5;
        return;
    L5:
        if (this.f362685h.isEmpty() == false) goto L8;
        return;
    L8:
        if (this.f362689l != null) goto L10;
    L12:
        s();
        l r100 = (l) f(l.class);
        if (r100 != null) goto L20;
        return;
    L20:
        r100.e8(this.f362694q);     // Catch: Throwable -> L17
        this.f362689l = r100;     // Catch: Throwable -> L17
        this.f362690m = this.f362692o.f470326a;     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        FLogger.f375446a.e("OfficeChatInputAdapter", "绑定语音状态监听失败", th);
        return;
    L10:
        if (this.f362690m != this.f362692o.f470326a) goto L12;
    }

    public final void o() {
        if (i() == true) goto L5;
        return;
    L5:
        va8.o r100 = (va8.o) e(va8.o.class);
        if (r100 != null) goto L8;
        return;
    L8:
        g0 r101 = (g0) e(g0.class);
        if (r100.hh() == false) goto L17;
        if (r101 != null) goto L12;
    L14:
        boolean r102 = false;
    L15:
        if (r102 == false) goto L17;
        r100.Yv();
        return;
    L12:
        if (r101.YC() == true) goto L14;
        r102 = true;
    L17:
        r100.CJ(true, null, false);
        r100.E40();
    }

    public final void a(r r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        if (this.f362693p == false) goto L5;
        return;
    L5:
        if (this.f362681d.add(r100) == false) goto L10;
        k(r100, this.f362692o);
        return;
    }

    public final void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        String r101 = "折叠输入框失败, reason=" + r100;
        if (this.f362693p == true) goto L12;
        this.f362679b.D3();     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        FLogger.f375446a.e("OfficeChatInputAdapter", r101, th);
        return;
    }

    public final <T extends m1a.a> T e(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        if (this.f362693p == false) goto L10;
        return null;
    L10:
        return (T) this.f362680c.getAbility(r100);
    L7:
        th = move-exception;
        FLogger.f375446a.e("OfficeChatInputAdapter", "查询 Chat Ability 失败, clazz=".concat(r100.getName()), th);
        return null;
    }

    public final <T extends t1a.a> T f(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        if (this.f362693p == false) goto L10;
        return null;
    L10:
        return (T) this.f362680c.vw(r100);
    L7:
        th = move-exception;
        FLogger.f375446a.e("OfficeChatInputAdapter", "查询 Chat VAbility 失败, clazz=".concat(r100.getName()), th);
        return null;
    }

    public final <T extends t1a.a> T g(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        if (this.f362693p == false) goto L10;
        return null;
    L10:
        return (T) s1a.a.g(this.f362678a).getAbility(r100);
    L7:
        th = move-exception;
        FLogger.f375446a.e("OfficeChatInputAdapter", "查询 Office Ability 失败, clazz=".concat(r100.getName()), th);
        return null;
    }

    public final boolean h(long r100) {
        if (this.f362693p == true) goto L9;
        dw8.a r101 = this.f362692o;
        if (r101.f470327b == false) goto L9;
        if (r101.f470326a != r100) goto L9;
        return true;
    L9:
        return false;
    }

    public final void l(t r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        if (this.f362693p == false) goto L5;
        return;
    L5:
        if (this.f362682e.add(r100) == false) goto L15;
        this.f362679b.G5(r100);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        this.f362682e.remove(r100);
        FLogger.f375446a.e("OfficeChatInputAdapter", "注册消息监听失败", th);
        return;
    }

    public final void n(r r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f362681d.remove(r100);
    }

    public final void q(String r100) {
        if (i() == true) goto L5;
        return;
    L5:
        com.larus.bmhome.chat.component.bottom.reference.a r101 = (com.larus.bmhome.chat.component.bottom.reference.a) f(com.larus.bmhome.chat.component.bottom.reference.a.class);
        if (r101 != null) goto L8;
        return;
    L8:
        if (r100 != null) goto L10;
    L13:
        boolean r102 = true;
    L14:
        if (r102 == false) goto L16;
        r101.NR();
        return;
    L16:
        r101.Dk(r100);
        return;
    L10:
        if (r100.length() == 0) goto L13;
        r102 = false;
        goto L14
    }

    public final void t(t r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        if (this.f362682e.remove(r100) == true) goto L10;
        return;
    L10:
        this.f362679b.K4(r100);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        this.f362682e.add(r100);
        FLogger.f375446a.e("OfficeChatInputAdapter", "注销消息监听失败", th);
    }

    public final void u(qo9.d r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        if (this.f362684g.remove(r100) == true) goto L10;
        return;
    L10:
        this.f362679b.UN(r100);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        this.f362684g.add(r100);
        FLogger.f375446a.e("OfficeChatInputAdapter", "注销窗口高度监听失败", th);
    }

    public final void v(boolean r100) {
        if (this.f362691n != r100) goto L5;
        return;
    L5:
        this.f362691n = r100;
        Iterator<Function1<Boolean, Unit>> r101 = this.f362685h.iterator();
    L7:
        if (r101.hasNext() == false) goto L9;
        Function1<Boolean, Unit> r102 = r101.next();
        Intrinsics.checkNotNull(r102);
        j(r102, r100);
        goto L7
    }

    public static void j(Function1 r100, boolean r101) {
        r100.invoke(Boolean.valueOf(r101));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        FLogger.f375446a.e("OfficeChatInputAdapter", "通知语音状态失败, active=" + r101, th);
    }

    public static void k(r r100, dw8.a r101) {
        r100.a(r101);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        FLogger.f375446a.e("OfficeChatInputAdapter", "通知 Adapter 状态失败, generation=" + r101.f470326a + ", isReady=" + r101.f470327b, th);
    }

    public final void p(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        if (i() == true) goto L5;
        return;
    L5:
        p r102 = (p) e(p.class);
        if (r102 == null) goto L25;
        RecyclerView r103 = r102.Ly();
        if (r103 == null) goto L26;
        RecyclerView.LayoutManager r104 = r103.getLayoutManager();
        if ((r104 instanceof LinearLayoutManager) == false) goto L12;
        LinearLayoutManager r105 = (LinearLayoutManager) r104;
    L13:
        if (r105 != null) goto L15;
        return;
    L15:
        if (r101 == false) goto L21;
        if (r103.getScrollState() == 0) goto L21;
        FLogger.f375446a.i("OfficeChatInputAdapter", "跳过滚动到底部, reason=" + r100 + ", scrollState=" + r103.getScrollState());
        return;
    L21:
        if (r103.getScrollState() == 0) goto L23;
        r103.stopScroll();
    L23:
        r105.scrollToPositionWithOffset(0, 0);
        return;
    L12:
        r105 = null;
        goto L13
    L26:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v8, types: [com.larus.office.plugins.inputv2.adapter.b, dw8.r] */
    public g(Fragment r100, s r101, q r102) {
        this.f362678a = r100;
        this.f362679b = r101;
        this.f362680c = r102;
        this.f362681d = new CopyOnWriteArraySet();
        this.f362682e = new CopyOnWriteArraySet();
        this.f362683f = new CopyOnWriteArraySet();
        this.f362684g = new CopyOnWriteArraySet();
        this.f362685h = new CopyOnWriteArraySet();
        this.f362692o = new dw8.a(0, false);
        this.f362694q = new b(this);
        ?? r103 = new com.larus.office.plugins.inputv2.adapter.b(this);
        this.f362695r = r103;
        r102.Bb(r103);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v3, types: [com.larus.office.plugins.inputv2.adapter.e, kotlin.jvm.functions.Function1] */
    public final void d(ViewGroup r100, boolean r101, final com.larus.office.plugins.inputv2.coordinator.runtime.interaction.b r110, final Function0 r111, Function0 r112, final Function1 r113) {
        Intrinsics.checkNotNullParameter(r110, "onInputTouched");
        Intrinsics.checkNotNullParameter(r111, "onInputFocused");
        Intrinsics.checkNotNullParameter(r112, "onTextInputReady");
        Intrinsics.checkNotNullParameter(r113, "onFullScreenChanged");
        if (i() == true) goto L5;
        return;
    L5:
        final long r102 = this.f362692o.f470326a;
        va8.o r103 = (va8.o) e(va8.o.class);
        ICoreInputAbility r104 = (ICoreInputAbility) e(ICoreInputAbility.class);
        g0 r105 = (g0) e(g0.class);
        r();
        if (r103 == 0) goto L8;
        r103.CE(new d(this, r102, r110));
    L8:
        if (r103 == 0) goto L10;
        ?? r114 = new e(this, r102, r111);
        r103.GM(r114);
        this.f362687j = r103;
        this.f362688k = r114;
    L10:
        if (r101 == false) goto L15;
        if (r105 == null) goto L13;
        r105.CI();
    L13:
        if (r105 == null) goto L15;
        r105.Pb();
    L15:
        if (r100 == null) goto L20;
        if (r104 == null) goto L18;
        r104.m1(r100);
    L18:
        if (r104 == null) goto L20;
        r104.r7(new f(this, r102, r113));
    L20:
        Job r106 = this.f362686i;
        Job r107 = null;
        if (r106 == null) goto L23;
        Job.DefaultImpls.cancel$default(r106, null, 1, null);
    L23:
        if (r103 == 0) goto L27;
        i1<Integer> r108 = r103.cv();
        if (r108 == null) goto L27;
        r107 = kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(r108, new OfficeChatInputAdapter$configureInputInteractions$4(this, r102, r112, null)), LifecycleOwnerKt.getLifecycleScope(this.f362678a));
    L27:
        this.f362686i = r107;
    }
}
