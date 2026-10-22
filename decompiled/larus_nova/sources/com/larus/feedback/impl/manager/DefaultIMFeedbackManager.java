package com.larus.feedback.impl.manager;

import com.bytedance.android.livesdkapi.app.AppConstants;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.common.apphost.AppHost;
import com.larus.feedback.impl.gateway.FlowFeedbackRemoteGateway;
import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.platform.api.d3;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.ss.ttvideoengine.strategrycenter.IStrategyStateSupplier;
import hq9.n3;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import q99.i;
import q99.j;

/* JADX INFO: loaded from: classes27.dex */
public final class DefaultIMFeedbackManager extends p99.d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f343082g = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i f343083b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f343084c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f343085d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f343086e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public d f343087f;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/feedback/impl/manager/DefaultIMFeedbackManager$PendingPhase;", "", "<init>", "(Ljava/lang/String;I)V", "WAIT_STREAM_END", "WAIT_PAUSE_TIMEOUT", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum PendingPhase extends Enum<PendingPhase> {
        public static final PendingPhase WAIT_PAUSE_TIMEOUT = null;
        public static final PendingPhase WAIT_STREAM_END = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ PendingPhase[] f343088a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f343089b = null;

        public static EnumEntries<PendingPhase> getEntries() {
            return f343089b;
        }

        static {
            PendingPhase r100 = new PendingPhase("WAIT_STREAM_END", 0);
            WAIT_STREAM_END = r100;
            PendingPhase r101 = new PendingPhase("WAIT_PAUSE_TIMEOUT", 1);
            WAIT_PAUSE_TIMEOUT = r101;
            PendingPhase[] r102 = {r100, r101};
            f343088a = r102;
            f343089b = EnumEntriesKt.enumEntries(r102);
        }

        public static PendingPhase[] values() {
            return (PendingPhase[]) f343088a.clone();
        }

        public static PendingPhase valueOf(String r100) {
            return (PendingPhase) r27.a.a(PendingPhase.class, r100);
        }

        public PendingPhase(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final q99.e f343090a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final PendingPhase f343091b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f343090a, r101.f343090a) == true) goto L12;
            return false;
        L12:
            if (this.f343091b == r101.f343091b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f343090a.hashCode() * 31) + this.f343091b.hashCode();
        }

        public final String toString() {
            return "PendingState(delivery=" + this.f343090a + ", phase=" + this.f343091b + ')';
        }

        public b(q99.e r100, PendingPhase r101) {
            Intrinsics.checkNotNullParameter(r100, "delivery");
            Intrinsics.checkNotNullParameter(r101, "phase");
            this.f343090a = r100;
            this.f343091b = r101;
        }
    }

    public static final class c implements IIMCallback<Message> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DefaultIMFeedbackManager f343092a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ q99.e f343093b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ q99.d f343094c;

        @Override // com.larus.im.callback.IIMCallback
        public final boolean mustInMain() {
            return true;
        }

        @Override // com.larus.im.callback.IIMCallback
        public final void onFailure(IIMError r100) {
            Intrinsics.checkNotNullParameter(r100, "error");
            FLogger.f375446a.d("DefaultIMFeedbackManager", "handleResolvedDelivery: find message fail, error = " + r100);
            this.f343092a.m(this.f343093b, this.f343094c);
        }

        @Override // com.larus.im.callback.IIMCallback
        public final void onSuccess(Message r110) {
            Message r111 = r110;
            Intrinsics.checkNotNullParameter(r111, "result");
            FLogger r100 = FLogger.f375446a;
            r100.d("DefaultIMFeedbackManager", "handleResolvedDelivery: find message success");
            DefaultIMFeedbackManager r101 = this.f343092a;
            q99.e r102 = this.f343093b;
            q99.d r103 = this.f343094c;
            r101.getClass();
            Integer r104 = r111.getFeedback();
            boolean r105 = true;
            if (r104 != null) goto L5;
        L10:
            boolean r106 = false;
        L11:
            if (r106 == false) goto L14;
            r100.d("DefaultIMFeedbackManager", "handleResolvedMessage: no-op, feedback = " + r111.getFeedback());
            return;
        L14:
            if (r111.getMessageStatusLocal() != 22) goto L16;
        L41:
            r100.d("DefaultIMFeedbackManager", "handleResolvedMessage: no-op, messageStatusLocal = " + r111.getMessageStatusLocal());
            return;
        L16:
            if (r111.getMessageStatusLocal() == 23) goto L41;
            i r107 = r101.f343083b;
            r107.getClass();
            Intrinsics.checkNotNullParameter(r111, "message");
            if (r107.f532166o.invoke(r111).booleanValue() == true) goto L22;
            r100.d("DefaultIMFeedbackManager", "handleResolvedMessage: no-op, message can't show like/dislike");
            return;
        L22:
            if (r111.getMessageStatusLocal() != 20) goto L24;
        L27:
            String r112 = r111.getMessageId();
            if (r112 != null) goto L32;
            r112 = r102.f532145b;
            if (r112 != null) goto L32;
            r112 = r103.e();
        L32:
            q99.e r113 = q99.e.a(r102, null, r112, null, 125);
            String r108 = r113.f532145b;
            if (r108 != null) goto L35;
        L38:
            if (r105 == false) goto L40;
            r100.d("DefaultIMFeedbackManager", "waitForStreamEnd: no-op, messageId = null");
            return;
        L40:
            r100.d("DefaultIMFeedbackManager", "waitForStreamEnd: messageId = " + r108);
            r101.l(false, "wait_for_stream_end");
            r101.f343084c = new b(r113, PendingPhase.WAIT_STREAM_END);
            return;
        L35:
            if (r108.length() == 0) goto L38;
            r105 = false;
            goto L38
        L24:
            if (com.larus.im.bean.message.a.w0(r111) == true) goto L27;
            r100.d("DefaultIMFeedbackManager", "handleResolvedMessage: try show popup");
            r101.m(r102, r103);
            return;
        L5:
            if (r104.intValue() <= 0) goto L7;
            boolean r109 = true;
        L8:
            if (r109 != true) goto L10;
            r106 = true;
            goto L11
        L7:
            r109 = false;
            goto L8
        }

        public c(DefaultIMFeedbackManager r100, q99.e r101, q99.d r102) {
            this.f343092a = r100;
            this.f343093b = r101;
            this.f343094c = r102;
        }
    }

    static {
    }

    @Override // p99.d
    public final void h() {
        l(false, "page_disappear");
    }

    public final void n() {
        b r100 = this.f343084c;
        if (r100 != null) goto L7;
        FLogger.f375446a.d("DefaultIMFeedbackManager", "handlePauseTimeout: no-op, pendingState = null");
        return;
    L7:
        if (r100.f343091b == PendingPhase.WAIT_PAUSE_TIMEOUT) goto L10;
        FLogger.f375446a.d("DefaultIMFeedbackManager", "handlePauseTimeout: no-op, phase = " + r100.f343091b);
        return;
    L10:
        q99.e r101 = r100.f343090a;
        boolean r102 = this.f343083b.b();
        boolean r103 = this.f343083b.f532158g.invoke().booleanValue();
        String r104 = null;
        if (r102 == false) goto L19;
        if (r103 == true) goto L19;
        FLogger r105 = FLogger.f375446a;
        StringBuilder r106 = new StringBuilder("handlePauseTimeout: show popup, messageId = ");
        r106.append(r101.f532145b);
        r106.append(", sectionId = ");
        q99.d r107 = r101.f532149f;
        if (r107 == null) goto L17;
        r104 = r107.h();
    L17:
        r106.append(r104);
        r105.d("DefaultIMFeedbackManager", r106.toString());
        p(r101);
        return;
    L19:
        FLogger r108 = FLogger.f375446a;
        StringBuilder r109 = new StringBuilder("handlePauseTimeout: no-op, isActive = ");
        r109.append(r102);
        r109.append(", isInputting = ");
        r109.append(r103);
        r109.append(", messageId = ");
        r109.append(r101.f532145b);
        r109.append(", sectionId = ");
        q99.d r110 = r101.f532149f;
        if (r110 == null) goto L22;
        r104 = r110.h();
    L22:
        r109.append(r104);
        r108.d("DefaultIMFeedbackManager", r109.toString());
    }

    @Override // p99.d
    public final i e() {
        return this.f343083b;
    }

    @Override // p99.d
    public final void f(q99.e r100) {
        Intrinsics.checkNotNullParameter(r100, "delivery");
        q99.d r101 = r100.f532149f;
        if (r101 != null) goto L7;
        Integer r102 = r100.f532146c;
        if (r102 == null) goto L9;
        query(new q99.c(r102.intValue()), new f(r100, this));
        return;
    L9:
        return;
    L7:
        o(r100, r101);
    }

    @Override // p99.d
    public final void g(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        b r101 = this.f343084c;
        if (r101 != null) goto L6;
        return;
    L6:
        if (r101.f343091b == PendingPhase.WAIT_STREAM_END) goto L8;
        return;
    L8:
        q99.e r102 = r101.f343090a;
        String r103 = r102.f532145b;
        if (r103 != null) goto L11;
        return;
    L11:
        String r104 = r100.getMessageId();
        String r105 = com.larus.im.bean.message.a.L(r100);
        if (Intrinsics.areEqual(r103, r104) == false) goto L14;
    L16:
        FLogger r106 = FLogger.f375446a;
        r106.d("DefaultIMFeedbackManager", "handleMessageStreamEnd: messageId = " + r104 + ", status = " + r100.getMessageStatusLocal());
        Integer r107 = r100.getFeedback();
        if (r107 == null) goto L24;
        boolean r108 = true;
        if (r107.intValue() <= 0) goto L21;
        boolean r109 = true;
    L22:
        if (r109 != true) goto L24;
    L25:
        if (r108 == false) goto L29;
        r106.d("DefaultIMFeedbackManager", "handleMessageStreamEnd: no-op, feedback = " + r100.getFeedback());
        l(false, "message_stream_end_already_feedback");
        return;
    L29:
        if (r100.getMessageStatusLocal() != 22) goto L31;
    L41:
        r106.d("DefaultIMFeedbackManager", "handleMessageStreamEnd: no-op, messageStatusLocal = " + r100.getMessageStatusLocal());
        l(false, "message_stream_end_invalid_status");
        return;
    L31:
        if (r100.getMessageStatusLocal() == 23) goto L41;
        i r110 = this.f343083b;
        r110.getClass();
        Intrinsics.checkNotNullParameter(r100, "message");
        if (r110.f532166o.invoke(r100).booleanValue() == true) goto L37;
        r106.d("DefaultIMFeedbackManager", "handleMessageStreamEnd: no-op, message can't show like/dislike");
        l(false, "message_stream_end_cant_show_like_dislike");
        return;
    L37:
        q99.d r111 = r102.f532149f;
        if (r111 == null) goto L43;
        m(r102, r111);
        return;
    L43:
        return;
    L21:
        r109 = false;
    L24:
        r108 = false;
        goto L25
    L14:
        if (Intrinsics.areEqual(r103, r105) == true) goto L16;
    }

    @Override // p99.d
    public final void i(boolean r100) {
        if (r100 == true) goto L4;
        return;
    L4:
        n();
    }

    @Override // p99.d
    public final void j(String r100) {
        Intrinsics.checkNotNullParameter(r100, "newSectionId");
        String r101 = this.f343085d;
        boolean r102 = false;
        if (r101 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L11;
    L17:
        this.f343085d = r100;
        return;
    L11:
        if (r100.length() <= 0) goto L13;
        r102 = true;
    L13:
        if (r102 == false) goto L17;
        if (Intrinsics.areEqual(this.f343085d, r100) == true) goto L17;
        l(true, "section_changed");
        goto L17
    L5:
        if (r101.length() == 0) goto L8;
        r103 = false;
        goto L9
    }

    @Override // p99.d
    public final void k(String r100) {
        if (r100 != null) goto L4;
    L5:
        l(false, "user_manual_feedback");
        return;
    L4:
        if (Intrinsics.areEqual(r100, this.f343085d) == true) goto L5;
    }

    public final void p(q99.e r110) {
        FLogger r111 = FLogger.f375446a;
        r111.d("DefaultIMFeedbackManager", "showPopupNow: delivery = " + r110);
        boolean r112 = false;
        l(false, "show_popup_now");
        q99.d r113 = r110.f532149f;
        if (r113 != null) goto L5;
        return;
    L5:
        String r100 = r113.h();
        if (r100 != null) goto L8;
        r100 = this.f343085d;
    L8:
        this.f343085d = r100;
        this.f343086e = true;
        i r101 = this.f343083b;
        Intrinsics.checkNotNullParameter(r110, "delivery");
        Intrinsics.checkNotNullParameter(r101, "host");
        q99.d r102 = r110.f532149f;
        if (r102 == null) goto L31;
        String r103 = r101.f532162k;
        if (r103 == null) goto L31;
        o99.a r104 = r101.f532168q;
        Function0<String> r105 = r101.f532163l;
        if (r105 == null) goto L17;
        String r106 = r105.invoke();
    L18:
        if (r106 != null) goto L21;
        r106 = "";
    L21:
        if (r106.length() != 0) goto L23;
        boolean r107 = true;
    L24:
        if (r107 == false) goto L26;
        r106 = "res://" + AppHost.f326268a.getApplication().getPackageName() + "/2131240119";
    L26:
        n3 r108 = a(r102, r106, r110, r101, r103, r101.f532161j, r104);
        Intrinsics.checkNotNullParameter(r108, "notificationRequest");
        if (d3.f365092a.c(r108) == false) goto L31;
        if (r104 == null) goto L30;
        r104.h();
    L30:
        r112 = true;
        goto L31
    L23:
        r107 = false;
        goto L24
    L17:
        r106 = null;
    L31:
        r111.d("DefaultIMFeedbackManager", "showPopupNow: showNotification result = " + r112);
        if (r112 == false) goto L35;
        Integer r109 = r110.f532146c;
        String r114 = r113.b();
        long r115 = System.currentTimeMillis();
        Map r116 = MapsKt.createMapBuilder();
        r116.put(MusicAppletPage.KEY_MESSAGE_ID, r110.f532145b);
        r116.put("section_id", this.f343085d);
        r116.put("conversation_id", r110.f532144a);
        Unit r117 = Unit.INSTANCE;
        j r118 = new j(r109, r114, r115, MapsKt.build(r116));
        Intrinsics.checkNotNullParameter(r118, "request");
        this.f528321a.c(r118);
        t99.a.c(r110.f532147d, null, r110.f532145b, this.f343083b.f532167p.invoke("feedback_popup_show", r110), 18);
        return;
    }

    public DefaultIMFeedbackManager(i r100, FlowFeedbackRemoteGateway r101) {
        Intrinsics.checkNotNullParameter(r100, "host");
        Intrinsics.checkNotNullParameter(r101, "remoteGateway");
        super(r101);
        this.f343083b = r100;
        this.f343085d = r100.a();
    }

    @Override // p99.c
    public final void b(q99.e r100, i r101) {
        Intrinsics.checkNotNullParameter(r100, "delivery");
        Intrinsics.checkNotNullParameter(r101, "host");
        super.b(r100, r101);
        t99.a.b(r100.f532147d, null, r100.f532145b, AppConstants.BUNDLE_DISLIKE, r101.f532167p.invoke("feedback_popup_click", r100), 34);
    }

    @Override // p99.c
    public final void c(q99.e r100, i r101) {
        Intrinsics.checkNotNullParameter(r100, "delivery");
        Intrinsics.checkNotNullParameter(r101, "host");
        super.c(r100, r101);
        t99.a.b(r100.f532147d, null, r100.f532145b, IStrategyStateSupplier.KEY_INFO_LIKE, r101.f532167p.invoke("feedback_popup_click", r100), 34);
    }

    public final void l(boolean r100, String r101) {
        FLogger r102 = FLogger.f375446a;
        StringBuilder r103 = new StringBuilder("clearPending: reason = ");
        r103.append(r101);
        r103.append(", hasTimer = ");
        if (this.f343087f == null) goto L5;
        boolean r104 = true;
    L6:
        r103.append(r104);
        r103.append(", pendingPhase = ");
        b r105 = this.f343084c;
        if (r105 == null) goto L9;
        PendingPhase r106 = r105.f343091b;
    L10:
        r103.append(r106);
        r103.append(", messageId = ");
        b r107 = this.f343084c;
        if (r107 == null) goto L15;
        q99.e r108 = r107.f343090a;
        if (r108 == null) goto L15;
        String r109 = r108.f532145b;
    L16:
        r103.append(r109);
        r103.append(", sectionId = ");
        b r110 = this.f343084c;
        if (r110 == null) goto L23;
        q99.e r111 = r110.f343090a;
        if (r111 == null) goto L23;
        q99.d r112 = r111.f532149f;
        if (r112 == null) goto L23;
        String r113 = r112.h();
    L24:
        r103.append(r113);
        r103.append(", resetShownState = ");
        r103.append(r100);
        r102.d("DefaultIMFeedbackManager", r103.toString());
        d r114 = this.f343087f;
        if (r114 == null) goto L27;
        t0.f375468a.removeCallbacks(r114);
    L27:
        this.f343087f = null;
        this.f343084c = null;
        if (r100 == false) goto L31;
        this.f343086e = false;
        return;
    L31:
        return;
    L23:
        r113 = null;
    L15:
        r109 = null;
        goto L16
    L9:
        r106 = null;
        goto L10
    L5:
        r104 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v4, types: [com.larus.feedback.impl.manager.d, java.lang.Runnable] */
    public final void m(q99.e r100, q99.d r101) {
        FLogger r102 = FLogger.f375446a;
        r102.d("DefaultIMFeedbackManager", "dispatchReady: delivery = " + r100 + ", model = " + r101);
        Integer r103 = r101.c();
        if (r103 != null) goto L6;
    L13:
        String r104 = r101.h();
        if (r104 != null) goto L16;
        r104 = this.f343085d;
    L16:
        this.f343085d = r104;
        if (r101.c() != null) goto L20;
        r102.d("DefaultIMFeedbackManager", "dispatchReady: no-op, feedbackScene = null");
        return;
    L20:
        Integer r105 = r101.c();
        if (r105 != null) goto L24;
    L46:
        p(r100);
        return;
    L24:
        if (r105.intValue() != 7) goto L46;
        l(false, "dispatch_ready_section_interact");
        this.f343084c = new b(r100, PendingPhase.WAIT_PAUSE_TIMEOUT);
        d r106 = this.f343087f;
        if (r106 == null) goto L28;
        r102.d("DefaultIMFeedbackManager", "startPauseTimer: replace existing timer");
        t0.f375468a.removeCallbacks(r106);
    L28:
        b r107 = this.f343084c;
        StringBuilder r108 = new StringBuilder("startPauseTimer: schedule 10000ms, phase = ");
        String r109 = null;
        if (r107 == null) goto L31;
        PendingPhase r110 = r107.f343091b;
    L32:
        r108.append(r110);
        r108.append(", messageId = ");
        if (r107 == null) goto L37;
        q99.e r111 = r107.f343090a;
        if (r111 == null) goto L37;
        String r112 = r111.f532145b;
    L38:
        r108.append(r112);
        r108.append(", sectionId = ");
        if (r107 == null) goto L45;
        q99.e r113 = r107.f343090a;
        if (r113 == null) goto L45;
        q99.d r114 = r113.f532149f;
        if (r114 == null) goto L45;
        r109 = r114.h();
    L45:
        r108.append(r109);
        r102.d("DefaultIMFeedbackManager", r108.toString());
        ?? r115 = new d(this);
        t0.f375468a.postDelayed(r115, 10000);
        this.f343087f = r115;
        return;
    L37:
        r112 = null;
        goto L38
    L31:
        r110 = null;
        goto L32
    L6:
        if (r103.intValue() != 7) goto L13;
        if (this.f343086e == false) goto L13;
        if (Intrinsics.areEqual(this.f343085d, r101.h()) == false) goto L13;
        r102.d("DefaultIMFeedbackManager", "handleResolvedDelivery: no-op, hasShownInCurrentSection = " + this.f343086e + ", currentSectionId = " + this.f343085d + ", sectionId = " + r101.h());
    }

    public final void o(q99.e r100, q99.d r101) {
        FLogger r102 = FLogger.f375446a;
        r102.d("DefaultIMFeedbackManager", "handleResolvedDelivery: delivery = " + r100 + ", model = " + r101);
        if (Intrinsics.areEqual(r101.f(), Boolean.TRUE) == true) goto L5;
    L15:
        r102.d("DefaultIMFeedbackManager", "handleResolvedDelivery: no-op, needShow = " + r101.f() + ", isActive = " + this.f343083b.b());
        return;
    L5:
        if (this.f343083b.b() == false) goto L15;
        String r103 = r100.f532145b;
        if (r103 != null) goto L10;
        r103 = r101.e();
    L10:
        q99.e r104 = q99.e.a(r100, null, r103, null, 125);
        if (r103 != null) goto L13;
        m(r104, r101);
        return;
    L13:
        com.larus.im.d.e().m(r103, new c(this, r104, r101));
    }

    @Override // p99.c
    public final void d(q99.e r100, i r101, q99.a r102) {
        Intrinsics.checkNotNullParameter(r100, "delivery");
        Intrinsics.checkNotNullParameter(r101, "host");
        Intrinsics.checkNotNullParameter(r102, "result");
        t99.a.a(r100.f532147d, r101.f532167p.invoke("complete_dislike_reason", r100));
    }
}
