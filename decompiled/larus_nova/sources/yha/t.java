package yha;

import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.larus.voicecall.api.VoiceCallServiceDelegate;
import com.obric.assistant.data.ObricFloatChatPageData;
import com.obric.assistant.data.ObricFloatChatPageState;
import com.obric.assistant.interaction.api.IAssistantChatWindow;
import com.obric.assistant.interaction.api.IAssistantChatWindowKt;
import com.obric.assistant.task.ObricTaskStatusManager;
import com.obric.assistant.util.MessageListHeightDecoration;
import com.obric.assistant.util.a1;
import com.obric.assistant.util.b1;
import com.obric.assistant.util.n1;
import com.obric.assistant.util.u0;
import com.obric.assistant.util.z0;
import com.obric.assistant.window.animation.ObricPageAutoIncreaseHelper$4;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;
import v19.i5;

/* JADX INFO: loaded from: classes33.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final va8.l f567651a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final laa.d f567652b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.obric.assistant.util.p f567653c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f567654d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f567655e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public n1 f567656f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f567657g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f567658h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f567659i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f567660j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Integer f567661k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Integer f567662l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f567663m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Handler f567664n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public MessageListHeightDecoration f567665o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f567666p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f567667q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f567668r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f567669s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final u f567670t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final v f567671u;

    public static final class a {
    }

    static {
    }

    public final void h(int r100) {
        this.f567653c.i(r100);
    }

    public final void i(int r100, boolean r101) {
        this.f567653c.j(r100, r101);
    }

    public final void k(boolean r100, boolean r101) {
        this.f567653c.k(r100, r101);
    }

    public final void l(boolean r100) {
        this.f567653c.l(r100);
    }

    public final void m() {
        this.f567653c.m();
    }

    public final void n() {
        this.f567653c.n();
    }

    public final void o(boolean r100) {
        this.f567653c.p(r100);
    }

    public final void p(boolean r100) {
        this.f567653c.r(r100);
    }

    public final void s(boolean r100) {
        this.f567653c.s(r100);
    }

    public final void t(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        this.f567653c.t(r100);
    }

    public final b1 c() {
        this.f567653c.getClass();
        return new b1();
    }

    public final FrameLayout d() {
        return (FrameLayout) this.f567658h.getValue();
    }

    public final int e() {
        ObricFloatChatPageData.a r100 = ObricFloatChatPageData.Companion;
        laa.d r101 = this.f567652b;
        if (r101 == null) goto L5;
        ObricFloatChatPageState r102 = r101.getPageState();
    L6:
        r100.getClass();
        if ((r102 instanceof vda.f) == false) goto L10;
        int r103 = aia.f.f3866a;
        return c7.b(4);
    L10:
        return i5.J();
    L5:
        r102 = null;
        goto L6
    }

    public final RecyclerView f() {
        return (RecyclerView) this.f567657g.getValue();
    }

    public final void j() {
        FLogger r100 = FLogger.f375446a;
        r100.i("ObricPageAutoIncreaseHelper", LiveCommonConstants.REASON_ON_DEDTROY);
        this.f567664n.removeCallbacksAndMessages(null);
        b(LiveCommonConstants.REASON_ON_DEDTROY);
        IAssistantChatWindow r101 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r101 == null) goto L5;
        r101.removeWindowAnimationListener(this.f567670t);
    L5:
        IAssistantChatWindow r102 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r102 == null) goto L8;
        r102.removeWindowLifecycleListener(this.f567671u);
    L8:
        final com.obric.assistant.util.p r103 = this.f567653c;
        r103.getClass();
        r100.i("AutoDismissDelegate", "onDestroy destroyed:" + r103.f393799i);
        if (r103.f393799i == true) goto L17;
        r103.f393799i = true;
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L14;
        r103.e();
        return;
    L14:
        r103.f393797g.post(new com.obric.assistant.util.e(r103));
        return;
    }

    public final a1 r() {
        this.f567653c.getClass();
        return new a1();
    }

    public final z0 u() {
        this.f567653c.getClass();
        return new z0();
    }

    /* JADX WARN: Type inference failed for: r2v5, types: [yha.g] */
    /* JADX WARN: Type inference failed for: r5v1, types: [yha.r] */
    public final void w() {
        FLogger.f375446a.i("ObricPageAutoIncreaseHelper", "tryAddLastItemHeightItemDecoration, layoutListener is " + this.f567656f + ", messageList is " + f());
        if (this.f567656f != null) goto L6;
        this.f567656f = new n1(new o(this), new p(this), new q(this), new r(this), 8);
    L6:
        if (this.f567665o != null) goto L19;
        this.f567665o = new MessageListHeightDecoration(new s(this), new g(this), 2);
        RecyclerView r100 = f();
        if (r100 == null) goto L19;
        int r101 = r100.getItemDecorationCount();
        boolean r102 = false;
        int r103 = 0;
    L10:
        if (r103 >= r101) goto L15;
        if (Intrinsics.areEqual(r100.getItemDecorationAt(r103), this.f567665o) == true) goto L13;
        r103 = r103 + 1;
        goto L10
    L13:
        r102 = true;
    L15:
        if (r102 == true) goto L19;
        MessageListHeightDecoration r104 = this.f567665o;
        if (r104 == null) goto L19;
        r100.addItemDecoration(r104);
    L19:
        n1 r105 = this.f567656f;
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

    public final void a(String r100) {
        if (this.f567662l == null) goto L5;
    L6:
        FLogger.f375446a.i("ObricPageAutoIncreaseHelper", "clearPendingAutoIncreaseTopEmptyHeight, reason = " + r100 + ", pendingAutoIncreaseTopEmptyHeight = " + this.f567662l + ", pendingAutoIncreaseMsgCreateTime = " + this.f567663m);
    L7:
        this.f567662l = null;
        this.f567663m = Long.MAX_VALUE;
        b(r100);
        return;
    L5:
        if (this.f567663m == Long.MAX_VALUE) goto L7;
        goto L6
    }

    public final void b(String r100) {
        if (this.f567668r == Long.MAX_VALUE) goto L5;
        FLogger.f375446a.i("ObricPageAutoIncreaseHelper", "clearPendingRefreshOnWindowOpen, reason = " + r100 + ", msgCreateTime = " + this.f567668r);
    L5:
        this.f567668r = Long.MAX_VALUE;
    }

    public final void g(Message r100) {
        long r101 = this.f567654d;
        IAssistantChatWindow r102 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r102 == null) goto L15;
        boolean r103 = r102.isShowing();
        if (r101 != Long.MAX_VALUE) goto L7;
        return;
    L7:
        if (r100.getCreateTime() < r101) goto L17;
        if (r103 == false) goto L11;
        return;
    L11:
        if (this.f567668r == r101) goto L13;
        FLogger.f375446a.i("ObricPageAutoIncreaseHelper", "markPendingRefreshOnWindowOpen, msgCreateTime = " + r101);
    L13:
        this.f567668r = r101;
        return;
    L17:
        return;
    }

    public final void q(final Message r100) {
        FLogger r101 = FLogger.f375446a;
        r101.i("ObricPageAutoIncreaseHelper", "onSendMessage, message is " + r100);
        ObricTaskStatusManager.f393357a.getClass();
        String r102 = ObricTaskStatusManager.b();
        laa.d r103 = this.f567652b;
        if (r103 == null) goto L7;
        boolean r104 = true;
        if (r103.aF() != true) goto L7;
    L8:
        if (r102 != null) goto L10;
    L14:
        if (r100 == null) goto L20;
        if (com.larus.bmhome.chat.bean.d.T(r100) == false) goto L20;
        r101.i("ObricPageAutoIncreaseHelper", "onSendMessage, empty message");
        return;
    L20:
        if (VoiceCallServiceDelegate.f377087a.e() == false) goto L23;
        r101.i("ObricPageAutoIncreaseHelper", "onSendMessage, realtime call mode, return");
        return;
    L23:
        laa.d r105 = this.f567652b;
        if (r105 == null) goto L26;
        ObricFloatChatPageState r106 = r105.getPageState();
    L27:
        ObricFloatChatPageData.Companion.getClass();
        if ((r106 instanceof vda.f) == false) goto L31;
        r101.i("ObricPageAutoIncreaseHelper", "landscape: " + r106 + ", return");
        return;
    L31:
        t0.e(new h(this, r100));
        return;
    L26:
        r106 = null;
        goto L27
    L10:
        if (Intrinsics.areEqual(r102, "start_complex_task") == true) goto L14;
        if (r104 == false) goto L14;
        r101.i("ObricPageAutoIncreaseHelper", "onSendMessage skip auto increase for complex task reply panel, openPanelType: " + r102 + ", isChatWindow: " + r104);
        return;
    L7:
        r104 = false;
        goto L8
    }

    public final void v(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        FLogger.f375446a.i("ObricPageAutoIncreaseHelper", "resetFirstMsgCreateTime, reason = ".concat(r100));
        this.f567654d = Long.MAX_VALUE;
        a("resetFirstMsgCreateTime:".concat(r100));
    }

    public t(va8.l r100, laa.d r101, com.obric.assistant.window.d r102, com.obric.assistant.window.o r103) {
        Intrinsics.checkNotNullParameter(r102, "isWindowHostProvider");
        Intrinsics.checkNotNullParameter(r103, "inputTextViewProvider");
        if (r101 != null) goto L5;
        com.obric.assistant.util.s r104 = null;
    L6:
        if (r104 != null) goto L8;
        r104 = new u0();
    L8:
        com.obric.assistant.util.p r105 = new com.obric.assistant.util.p(r100, r104, r102, r103);
        Intrinsics.checkNotNullParameter(r105, "autoDismissDelegate");
        this.f567651a = r100;
        this.f567652b = r101;
        this.f567653c = r105;
        this.f567654d = Long.MAX_VALUE;
        this.f567655e = Long.MAX_VALUE;
        this.f567657g = LazyKt.lazy(new k(this));
        this.f567658h = LazyKt.lazy(new l(this));
        this.f567659i = LazyKt.lazy(new m(this));
        this.f567660j = LazyKt.lazy(new n(this));
        this.f567663m = Long.MAX_VALUE;
        this.f567664n = new Handler(Looper.getMainLooper());
        this.f567668r = Long.MAX_VALUE;
        u r106 = new u(this);
        this.f567670t = r106;
        v r107 = new v(this);
        this.f567671u = r107;
        FLogger.f375446a.i("ObricPageAutoIncreaseHelper", "init");
        IAssistantChatWindow r108 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r108 == null) goto L11;
        r108.addWindowAnimationListener(r106);
    L11:
        IAssistantChatWindow r109 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r109 == null) goto L14;
        r109.addWindowLifecycleListener(r107);
    L14:
        RecyclerView r110 = f();
        if (r110 == null) goto L18;
        r110.addOnScrollListener(new ObricPageAutoIncreaseHelper$4(this));
        return;
    L18:
        return;
    L5:
        r104 = new com.obric.assistant.util.o(r101);
        goto L6
    }
}
