package com.obric.assistant.util;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.widget.TextView;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.KtvSingChallengeViewModel;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.AutoEndConversationScene;
import com.obric.assistant.data.ObricFloatChatPageData;
import com.obric.assistant.data.ObricFloatChatPageState;
import com.obric.assistant.interaction.api.IKeyguardStateKt;
import com.obric.assistant.state.api.multitask.IObricTaskFlowActiveStateService;
import com.obric.assistant.state.api.multitask.producer.ObricInteractionStateProducerDelegate;
import com.obric.assistant.state.api.multitask.state.ObricInteractionStateType;
import com.obric.assistant.state.api.v2.core.IObricStateDispatcherService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes33.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final va8.l f393791a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s f393792b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Boolean> f393793c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<TextView> f393794d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f393795e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final r f393796f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Handler f393797g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public KeepScreenOnDelegate f393798h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile boolean f393799i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f393800j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f393801k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public zga.e f393802l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f393803m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f393804n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f393805o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f393806p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public h f393807q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Runnable f393808r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public i f393809s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public oba.b f393810t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public TextView f393811u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final b f393812v;

    public static final class a {
    }

    public static final class b implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p f393813a;

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
        }

        public b(p r100) {
            this.f393813a = r100;
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r100) {
            p r101 = this.f393813a;
            ObricInteractionStateType r102 = ObricInteractionStateType.INPUT_TEXT_ACTIVE;
            if (r100 != null) goto L5;
        L8:
            boolean r103 = true;
        L9:
            p.u(r101, r102, !r103);
            return;
        L5:
            if (r100.length() == 0) goto L8;
            r103 = false;
            goto L9
        }
    }

    static {
    }

    public final void e() {
        this.f393804n = false;
        TextView r100 = this.f393811u;
        if (r100 == null) goto L5;
        r100.removeTextChangedListener(this.f393812v);
    L5:
        this.f393811u = null;
        A();
        b(MapMonitorConst.EVENT_DESTROY);
        this.f393797g.removeCallbacksAndMessages(null);
        ObricInteractionStateProducerDelegate.f392949b.a(this.f393795e);
        FLogger.f375446a.i("AutoDismissDelegate", "destroyed, ownerId=" + this.f393795e);
    }

    public final void A() {
        this.f393800j++;
        zga.e r100 = this.f393802l;
        this.f393802l = null;
        boolean r101 = false;
        this.f393803m = false;
        FLogger r102 = FLogger.f375446a;
        StringBuilder r103 = new StringBuilder("keep-screen delegate destroyed, ownerId=");
        r103.append(this.f393795e);
        r103.append(", existed=");
        if (this.f393798h == null) goto L5;
        boolean r104 = true;
    L6:
        r103.append(r104);
        r102.i("AutoDismissDelegate", r103.toString());
        KeepScreenOnDelegate r105 = this.f393798h;
        if (r105 == null) goto L9;
        r105.e();
    L9:
        this.f393798h = null;
        if (r100 != null) goto L23;
    L18:
        FLogger r106 = FLogger.f375446a;
        StringBuilder r107 = new StringBuilder("active-state observer unregistered, ownerId=");
        r107.append(this.f393795e);
        r107.append(", hadObserver=");
        if (r100 == null) goto L21;
        r101 = true;
    L21:
        r107.append(r101);
        r106.i("AutoDismissDelegate", r107.toString());
        return;
    L23:
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L13
        Lazy r109 = zga.g.f572110a;     // Catch: Throwable -> L13
        Intrinsics.checkNotNullParameter(r100, "observer");     // Catch: Throwable -> L13
        ((IObricTaskFlowActiveStateService) zga.g.f572110a.getValue()).a(r100);     // Catch: Throwable -> L13
        Object r110 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L13
    L15:
        Throwable r111 = Result.m9452exceptionOrNullimpl(r110);
        if (r111 == null) goto L18;
        FLogger.f375446a.e("AutoDismissDelegate", "active-state observer unregistration failed, ownerId=" + this.f393795e, r111);
    L13:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r110 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    L5:
        r104 = false;
        goto L6
    }

    public final void a() {
        oba.b r100 = this.f393810t;
        Unit r101 = null;
        this.f393810t = null;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L8
        if (r100 == null) goto L6;
        r100.cancel();     // Catch: Throwable -> L8
        r101 = Unit.INSTANCE;     // Catch: Throwable -> L8
    L6:
        Object r103 = Result.m9449constructorimpl(r101);     // Catch: Throwable -> L8
    L10:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L16;
        FLogger.f375446a.e("AutoDismissDelegate", "cancel attention check failed, ownerId=" + this.f393795e, r104);
        return;
    L16:
        return;
    L8:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    public final void m() {
        FLogger.f375446a.i("AutoDismissDelegate", "onPagePause");
        v(new com.obric.assistant.util.b(this));
    }

    public final void n() {
        FLogger.f375446a.i("AutoDismissDelegate", "onPageResume");
        v(new g(this));
    }

    @AutoEndConversationScene
    public static int d() {
        return !IKeyguardStateKt.getKeyguardState().isKeyguardLocked() ? 1 : 0;
    }

    public final void y() {
        long r100 = c(d());
        if (r100 != (-1)) goto L7;
        b("initial follow system lock time");
        this.f393806p = false;
        return;
    L7:
        if (r100 != 3500) goto L9;
        r100 = KtvSingChallengeViewModel.CHALLENGE_ON_GOING_INTERVAL;
    L9:
        w(r100, true, "initial schedule");
    }

    public static long c(@AutoEndConversationScene int r100) {
        if (r100 != 0) goto L4;
        long r101 = 10000;
    L5:
        Long r102 = Long.valueOf(com.obric.assistant.t1.f393353a.M1(r100));
        long r103 = r102.longValue();
        if (r103 != (-1)) goto L8;
    L11:
        boolean r104 = true;
    L12:
        if (r104 == true) goto L15;
        r102 = null;
    L15:
        if (r102 != null) goto L17;
        return r101;
    L17:
        return r102.longValue();
    L8:
        if (r103 >= 0) goto L11;
        r104 = false;
        goto L12
    L4:
        r101 = 20000;
        goto L5
    }

    public static boolean h(ObricFloatChatPageState r100) {
        ObricFloatChatPageData.Companion.getClass();
        if ((r100 instanceof vda.a) == false) goto L5;
    L8:
        return true;
    L5:
        if ((r100 instanceof vda.e) == true) goto L8;
        return false;
    }

    public final void b(String r100) {
        i r101 = this.f393809s;
        if (r101 == null) goto L5;
        this.f393797g.removeCallbacks(r101);
    L5:
        this.f393809s = null;
        Runnable r102 = this.f393808r;
        if (r102 == null) goto L8;
        this.f393797g.removeCallbacks(r102);
    L8:
        this.f393808r = null;
        h r103 = this.f393807q;
        if (r103 == null) goto L11;
        this.f393797g.removeCallbacks(r103);
    L11:
        this.f393807q = null;
        a();
        this.f393801k++;
        Object r104 = t.f393840a;
        t.a(this.f393795e);
        FLogger.f375446a.i("AutoDismissDelegate", "dismiss canceled, ownerId=" + this.f393795e + ", reason=" + r100);
    }

    public final KeepScreenOnDelegate f(boolean r100) {
        if (this.f393793c.invoke().booleanValue() == true) goto L9;
        FLogger.f375446a.i("AutoDismissDelegate", "keep-screen delegate unavailable for non-window host, ownerId=" + this.f393795e);
        KeepScreenOnDelegate r101 = this.f393798h;
        if (r101 == null) goto L7;
        r101.e();
    L7:
        this.f393798h = null;
        return null;
    L9:
        KeepScreenOnDelegate r102 = this.f393798h;
        if (r102 != null) goto L15;
        if (r100 == false) goto L15;
        FLogger.f375446a.i("AutoDismissDelegate", "keep-screen delegate created, ownerId=" + this.f393795e);
        KeepScreenOnDelegate r103 = new KeepScreenOnDelegate(this.f393791a, this.f393793c, this.f393794d);
        this.f393798h = r103;
        return r103;
    L15:
        return r102;
    }

    public final void i(int r100) {
        FLogger.f375446a.i("AutoDismissDelegate", "onActionBarScrollStateChanged state:" + r100);
        if (r100 != 0) goto L5;
        u(this, ObricInteractionStateType.ACTION_BAR_SCROLLING, false);
        return;
    L5:
        if (r100 != 1) goto L11;
        u(this, ObricInteractionStateType.ACTION_BAR_SCROLLING, true);
        return;
    }

    public final void l(boolean r100) {
        FLogger.f375446a.i("AutoDismissDelegate", "onMessageModifyPanelVisibleChange visible:" + r100);
        u(this, ObricInteractionStateType.MESSAGE_MODIFY_VISIBLE, r100);
    }

    public final void o(final ObricFloatChatPageState r100) {
        Intrinsics.checkNotNullParameter(r100, "pageState");
        FLogger.f375446a.i("AutoDismissDelegate", "onPageStateChange pageState:" + r100);
        v(new f(this, r100));
    }

    public final void p(boolean r100) {
        FLogger.f375446a.i("AutoDismissDelegate", "onPopupOrDialogShow show:" + r100);
        u(this, ObricInteractionStateType.POPUP_OR_DIALOG_VISIBLE, r100);
    }

    public final void q(boolean r100) {
        FLogger.f375446a.i("AutoDismissDelegate", "onScrollStateChange isScrolling:" + r100);
        u(this, ObricInteractionStateType.MESSAGE_LIST_SCROLLING, r100);
    }

    public final void r(boolean r100) {
        FLogger.f375446a.i("AutoDismissDelegate", "onSecondaryMenuVisibleChange visible:" + r100);
        u(this, ObricInteractionStateType.SECONDARY_MENU_VISIBLE, r100);
    }

    public final void s(boolean r100) {
        FLogger.f375446a.i("AutoDismissDelegate", "onTaskSkillPanelVisibleChanged visible:" + r100);
        u(this, ObricInteractionStateType.TASK_SKILL_PANEL_VISIBLE, r100);
    }

    public final void t(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        FLogger.f375446a.i("AutoDismissDelegate", "onTouchIntercept event:" + r100);
        v(new l(this));
    }

    public final void v(final Function0<Unit> r100) {
        if (this.f393799i == false) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L8;
        r100.invoke();
        return;
    L8:
        this.f393797g.post(new k(this, r100));
    }

    public final void x(String r100) {
        long r101 = c(d());
        if (r101 != (-1)) goto L6;
        b("follow system lock time:" + r100);
        return;
    L6:
        w(r101, false, r100);
    }

    public final boolean z(String r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L4
        Lazy r102 = zga.g.f572110a;     // Catch: Throwable -> L4
        r r103 = this.f393796f;     // Catch: Throwable -> L4
        Intrinsics.checkNotNullParameter(r103, "filter");     // Catch: Throwable -> L4
        Object r104 = Result.m9449constructorimpl(Boolean.valueOf(((IObricTaskFlowActiveStateService) zga.g.f572110a.getValue()).b(r103)));     // Catch: Throwable -> L4
    L6:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L10;
        FLogger.f375446a.e("AutoDismissDelegate", "active state check failed " + r100 + ", ownerId=" + this.f393795e, r105);
        r104 = Boolean.TRUE;
    L10:
        boolean r106 = ((Boolean) r104).booleanValue();
        FLogger.f375446a.i("AutoDismissDelegate", "active state checked, ownerId=" + this.f393795e + ", active=" + r106 + ", reason=" + r100);
        return r106;
    L4:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L6
    }

    public final boolean g(long r100, zga.e r101) {
        if (this.f393799i == false) goto L5;
    L13:
        return false;
    L5:
        if (r100 != this.f393801k) goto L13;
        if (this.f393802l != r101) goto L13;
        if (this.f393804n == false) goto L13;
        if (h(this.f393792b.getPageState()) == false) goto L13;
        return true;
    }

    public final void j(int r100, boolean r101) {
        FLogger r102 = FLogger.f375446a;
        r102.i("AutoDismissDelegate", "onBottomPanelVisibleChanged type:" + r100 + " visible:" + r101);
        if (r100 != 0) goto L5;
        ObricInteractionStateType r103 = ObricInteractionStateType.INSTRUCTION_PANEL_VISIBLE;
    L16:
        u(this, r103, r101);
        return;
    L5:
        if (r100 != 1) goto L7;
        r103 = ObricInteractionStateType.KEYBOARD_VISIBLE;
        goto L16
    L7:
        if (r100 != 2) goto L9;
        r103 = ObricInteractionStateType.ATTACHMENT_PANEL_VISIBLE;
        goto L16
    L9:
        if (r100 == 3) goto L12;
        r102.w("AutoDismissDelegate", "ignore unknown bottom panel type:" + r100);
        return;
    L12:
        r103 = ObricInteractionStateType.BOTTOM_MENU_VISIBLE;
        goto L16
    }

    public final void k(boolean r100, boolean r101) {
        FLogger.f375446a.i("AutoDismissDelegate", "onInputReplyPanelVisibleChange visible:" + r100 + " inVisibleState:" + r101);
        u(this, ObricInteractionStateType.INPUT_REPLY_VISIBLE, r100);
    }

    public static void u(p r100, ObricInteractionStateType r101, boolean r102) {
        Map<String, ? extends Object> r103 = MapsKt.emptyMap();
        if (r100.f393799i == true) goto L10;
        if (r102 == false) goto L7;
        ObricInteractionStateProducerDelegate.f392949b.b(r100.f393795e, r101, r103);
    L8:
        FLogger.f375446a.i("AutoDismissDelegate", "interaction forwarded, ownerId=" + r100.f393795e + ",type=" + r101 + ",active=" + r102);
        return;
    L7:
        ObricInteractionStateProducerDelegate.f392949b.c(r100.f393795e, r101, r103);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v26, types: [com.obric.assistant.util.i, java.lang.Runnable] */
    /* JADX WARN: Type inference failed for: r5v1, types: [com.obric.assistant.util.h, java.lang.Runnable] */
    public final void w(final long r210, final boolean r211, String r212) {
        b("reschedule:" + r212);
        String r100 = "before schedule:" + r212;
        boolean r101 = h(this.f393792b.getPageState());
        if (this.f393799i == false) goto L5;
    L12:
        boolean r102 = false;
    L13:
        if (r102 == false) goto L15;
        Boolean r103 = Boolean.valueOf(z(r100));
    L16:
        if (r102 == true) goto L18;
    L20:
        boolean r104 = false;
    L21:
        FLogger r110 = FLogger.f375446a;
        StringBuilder r105 = new StringBuilder("dismiss scheduling checked, ownerId=");
        r105.append(this.f393795e);
        r105.append(", allowed=");
        r105.append(r104);
        r105.append(", reason=");
        r105.append(r100);
        r105.append(", destroyed=");
        r105.append(this.f393799i);
        r105.append(", pageResumed=");
        r105.append(this.f393804n);
        r105.append(", pageEligible=");
        r105.append(this.f393805o);
        r105.append(", currentPageEligible=");
        r105.append(r101);
        r105.append(", observerRegistered=");
        if (this.f393802l == null) goto L24;
        boolean r106 = true;
    L25:
        r105.append(r106);
        r105.append(", active=");
        r105.append(r103);
        r110.i("AutoDismissDelegate", r105.toString());
        if (r104 == true) goto L28;
        return;
    L28:
        this.f393806p = false;
        final long r107 = this.f393801k + 1;
        this.f393801k = r107;
        final zga.e r108 = this.f393802l;
        final int r109 = d();
        ?? r111 = new h(this, r107, r108, r109, r210, r211);
        this.f393807q = r111;
        Object r112 = t.f393840a;
        String r113 = this.f393795e;
        Intrinsics.checkNotNullParameter(r113, "ownerId");
        Object r114 = t.f393840a;
        monitor-enter(r114);
        Set<String> r115 = t.f393841b;     // Catch: Throwable -> L42
        boolean r116 = r115.isEmpty();     // Catch: Throwable -> L42
        if (r115.add(r113) == false) goto L34;
        if (r116 == false) goto L34;
        boolean r117 = true;
    L35:
        monitor-exit(r114);
        if (r117 == false) goto L40;
        IObricStateDispatcherService r118 = (IObricStateDispatcherService) ServiceManager.get().getService(IObricStateDispatcherService.class);
        if (r118 == null) goto L40;
        r118.l();
    L40:
        this.f393797g.postDelayed(r111, r210);
        q r119 = new q(r107, this, SystemClock.uptimeMillis() + r210, r211, r212);
        this.f393808r = r119;
        this.f393797g.postDelayed(r119, 1000);
        ?? r120 = new i(this, r107, r108);
        this.f393809s = r120;
        this.f393797g.postDelayed(r120, RangesKt.coerceAtLeast(r210 - 3000, 0));
        r110.i("AutoDismissDelegate", "dismiss cycle scheduled, ownerId=" + this.f393795e + ", delayMs=" + r210 + ", initial=" + r211 + ", reason=" + r212);
        return;
    L34:
        r117 = false;
    L42:
        th = move-exception;
        throw th;
    L24:
        r106 = false;
        goto L25
    L18:
        if (Intrinsics.areEqual(r103, Boolean.FALSE) == false) goto L20;
        r104 = true;
        goto L21
    L15:
        r103 = null;
        goto L16
    L5:
        if (this.f393804n == false) goto L12;
        if (this.f393802l == null) goto L12;
        if (this.f393805o == false) goto L12;
        if (r101 == false) goto L12;
        r102 = true;
        goto L13
    }

    /* JADX WARN: Multi-variable type inference failed */
    public p(va8.l r100, s r101, Function0<Boolean> r102, Function0<? extends TextView> r103) {
        Intrinsics.checkNotNullParameter(r101, "pageStateCallback");
        Intrinsics.checkNotNullParameter(r102, "isWindowHostProvider");
        Intrinsics.checkNotNullParameter(r103, "inputTextViewProvider");
        this.f393791a = r100;
        this.f393792b = r101;
        this.f393793c = r102;
        this.f393794d = r103;
        String r104 = UUID.randomUUID().toString();
        this.f393795e = r104;
        Intrinsics.checkNotNullParameter(r104, "ownerId");
        this.f393796f = new r(r104);
        this.f393797g = new Handler(Looper.getMainLooper());
        this.f393806p = true;
        this.f393812v = new b(this);
    }
}
