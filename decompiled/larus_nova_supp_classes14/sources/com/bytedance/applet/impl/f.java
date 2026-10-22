package com.bytedance.applet.impl;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.fragment.app.Fragment;
import com.bytedance.ai.applet.app.AppletFullScreenActivity;
import com.bytedance.ai.applet.app.foundation.AppletModelContextProvider;
import com.bytedance.ai.applet.components.input.AppletChatInputController;
import com.bytedance.ai.applet.components.input.AppletChatPanelState;
import com.larus.bmhome.ability.FloatChatWindowEventType;
import com.larus.bmhome.ability.FloatChatWindowState;
import com.larus.business.floatchat.api.AIChatActionBarItemLocation;
import com.larus.business.floatchat.api.AIChatInputConfig;
import com.larus.business.floatchat.api.IAIFloatChatService;
import com.larus.business.floatchat.impl.AIFloatChatFragment;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f implements AppletChatInputController {
    public final Fragment a;
    public final dw8.s b;
    public final Map<AppletChatInputController.g, dw8.t> c;
    public final Set<AppletChatInputController.c> d;
    public final Handler e;
    public Integer f;
    public r2.f g;
    public Long h;
    public String i;
    public AIChatInputConfig j;
    public AppletChatInputController.a k;
    public final b l;
    public final Fragment m;
    public final com.bytedance.applet.impl.c n;
    public final com.bytedance.applet.impl.d o;
    public final d p;
    public final e q;
    public boolean r;

    public static final class a {
    }

    public static final class b implements dw8.g {
        public final /* synthetic */ f a;

        public b(f r1) {
            this.a = r1;
        }

        public final void a(AIChatActionBarItemLocation r3, String r4, int r5) {
            Intrinsics.checkNotNullParameter(r3, "location");
            Intrinsics.checkNotNullParameter(r4, "actionBarKey");
            AppletChatInputController.a r0 = this.a.k;
            if (r0 == null) goto L14;
            int r6 = g.a.b[r3.ordinal()];
            if (r6 != 1) goto L7;
            AppletChatInputController.ActionBarItemLocation r7 = AppletChatInputController.ActionBarItemLocation.PRIMARY_BAR;
        L12:
            r0.b(r7, r4, r5);
            return;
        L7:
            if (r6 != 2) goto L10;
            r7 = AppletChatInputController.ActionBarItemLocation.DETAIL_PANEL;
            goto L12
        L10:
            throw new NoWhenBranchMatchedException();
        }

        public final void b(AIChatActionBarItemLocation r3, String r4, int r5) {
            Intrinsics.checkNotNullParameter(r3, "location");
            Intrinsics.checkNotNullParameter(r4, "actionBarKey");
            AppletChatInputController.a r0 = this.a.k;
            if (r0 == null) goto L14;
            int r6 = g.a.b[r3.ordinal()];
            if (r6 != 1) goto L7;
            AppletChatInputController.ActionBarItemLocation r7 = AppletChatInputController.ActionBarItemLocation.PRIMARY_BAR;
        L12:
            r0.a(r7, r4, r5);
            return;
        L7:
            if (r6 != 2) goto L10;
            r7 = AppletChatInputController.ActionBarItemLocation.DETAIL_PANEL;
            goto L12
        L10:
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class c implements dw8.t {
        public Long a;
        public final /* synthetic */ AppletChatInputController.g b;

        public final void ba(String r2, va8.t0 r3) {
            Intrinsics.checkNotNullParameter(r2, "queryMsgId");
            Intrinsics.checkNotNullParameter(r3, "payload");
        }

        public final void p(Message r2) {
            Intrinsics.checkNotNullParameter(r2, "message");
        }

        public final void y() {
            this.a = null;
            this.b.y();
        }

        public final void t() {
            long r0 = SystemClock.elapsedRealtime();
            Long r2 = this.a;
            if (r2 != null) goto L5;
        L8:
            this.a = Long.valueOf(r0);
            this.b.t();
            return;
        L5:
            if ((r0 - r2.longValue()) >= 300) goto L8;
            FLogger.a.d("AppletChatInputControllerImpl", "onTextInputActivated debounced, intervalMs=" + (r0 - r2.longValue()));
        }

        public c(AppletChatInputController.g r1) {
            this.b = r1;
        }

        public final void F1(Message r4) {
            Intrinsics.checkNotNullParameter(r4, "message");
            String r0 = r4.getLocalMessageId();
            if (r0 != null) goto L5;
        L8:
            boolean r1 = true;
        L9:
            if (r1 == false) goto L12;
            FLogger.a.e("AppletChatInputControllerImpl", "onSendMessage localMessageId is null or empty, messageId=" + r4.getMessageId() + ", messageStatusLocal=" + r4.getMessageStatusLocal());
            return;
        L12:
            this.b.L(r0);
            return;
        L5:
            if (r0.length() == 0) goto L8;
            r1 = false;
            goto L9
        }

        public final void oa(Message r8) {
            Intrinsics.checkNotNullParameter(r8, "message");
            String r0 = r8.getMessageId();
            boolean r1 = true;
            if (r0 != null) goto L5;
        L8:
            boolean r3 = true;
        L10:
            if (r3 == false) goto L13;
            FLogger.a.e("AppletChatInputControllerImpl", "onSendMessageResult messageId is null or empty, localMessageId=" + r8.getLocalMessageId() + ", messageStatusLocal=" + r8.getMessageStatusLocal());
            return;
        L13:
            String r4 = r8.getLocalMessageId();
            if (r4 != null) goto L16;
        L19:
            if (r1 == false) goto L22;
            FLogger.a.e("AppletChatInputControllerImpl", "onSendMessageResult localMessageId is null or empty, messageId=" + r0 + ", messageStatusLocal=" + r8.getMessageStatusLocal());
            return;
        L22:
            this.b.A0(r4, r0);
            return;
        L16:
            if (r4.length() == 0) goto L19;
            r1 = false;
            goto L19
        L5:
            if (r0.length() == 0) goto L8;
            r3 = false;
            goto L10
        }

        public final void za(Message r4) {
            Intrinsics.checkNotNullParameter(r4, "message");
            String r0 = r4.getMessageId();
            if (r0 != null) goto L5;
        L8:
            boolean r1 = true;
        L9:
            if (r1 == false) goto L12;
            FLogger.a.e("AppletChatInputControllerImpl", "onReceiveMessageEnd messageId is null or empty, localMessageId=" + r4.getLocalMessageId() + ", messageStatusLocal=" + r4.getMessageStatusLocal());
            return;
        L12:
            this.b.M0(r0);
            return;
        L5:
            if (r0.length() == 0) goto L8;
            r1 = false;
            goto L9
        }
    }

    public static final class d implements va8.i {
        public final /* synthetic */ f a;

        public final void LS(float r1) {
        }

        public d(f r1) {
            this.a = r1;
        }

        public final void am(va8.h r2) {
            Intrinsics.checkNotNullParameter(r2, "snapshot");
            if (Intrinsics.areEqual(r2.d, FloatChatWindowEventType.Init.getFrom()) == true) goto L6;
            this.a.b();
            return;
        }
    }

    static {
    }

    public final void a() {
        if (this.d.isEmpty() == false) goto L6;
        return;
    L6:
        if (this.r == false) goto L8;
        r2.f r0 = u6();
    L9:
        if (r0 != null) goto L12;
        return;
    L12:
        if (Intrinsics.areEqual(r0, this.g) == false) goto L14;
        return;
    L14:
        this.g = r0;
        this.h = Long.valueOf(SystemClock.elapsedRealtime());
        FLogger.a.i("AppletChatInputControllerImpl", "onChatPanelInfoChanged, visible=" + this.r + ", panelInfo=" + r0);
        Iterator r1 = CollectionsKt.toList(this.d).iterator();
    L16:
        if (r1.hasNext() == false) goto L18;
        ((AppletChatInputController.c) r1.next()).P0(r0);
        goto L16
    L18:
        return;
    L8:
        r0 = new r2.f(0, AppletChatPanelState.INVISIBLE);
        goto L9
    }

    public final void b() {
        this.e.removeCallbacks(this.n);
        if (this.r == true) goto L5;
        return;
    L5:
        if ((!this.d.isEmpty()) == false) goto L9;
        this.e.postDelayed(this.n, 100);
        return;
    }

    public final void t7() {
        dw8.s r0 = this.b;
        if (r0 == null) goto L6;
        r0.D3();
        return;
    }

    public final r2.f u6() {
        dw8.s r0 = this.b;
        if (r0 == null) goto L20;
        dw8.n r1 = r0.u6();
        if (r1 == null) goto L22;
        int r2 = RangesKt.coerceAtLeast(r1.a, 0);
        FloatChatWindowState r3 = r1.b;
        int r4 = g.a.a[r3.ordinal()];
        if (r4 != 1) goto L10;
        AppletChatPanelState r5 = AppletChatPanelState.COLLAPSED;
    L19:
        return new r2.f(r2, r5);
    L10:
        if (r4 != 2) goto L12;
        r5 = AppletChatPanelState.PREVIEW;
        goto L19
    L12:
        if (r4 != 3) goto L15;
        r5 = AppletChatPanelState.EXPANDED;
        goto L19
    L15:
        throw new NoWhenBranchMatchedException();
    L22:
        return null;
    L20:
        return null;
    }

    /* JADX WARN: Type inference failed for: r0v10, types: [com.bytedance.applet.impl.e] */
    /* JADX WARN: Type inference failed for: r0v7, types: [com.bytedance.applet.impl.c] */
    /* JADX WARN: Type inference failed for: r0v8, types: [com.bytedance.applet.impl.d] */
    public f() {
        IAIFloatChatService r0 = (IAIFloatChatService) ServiceManager.get().getService(IAIFloatChatService.class);
        AIFloatChatFragment r2 = null;
        if (r0 == null) goto L5;
        Bundle r3 = new Bundle();
        r3.putBoolean("adapt_padding", true);
        Unit r4 = Unit.INSTANCE;
        AIFloatChatFragment r1 = r0.a(r3);
    L6:
        this.a = r1;
        if ((r1 instanceof dw8.s) == false) goto L9;
        r2 = r1;
    L9:
        this.b = r2;
        this.c = new LinkedHashMap();
        this.d = new LinkedHashSet();
        this.e = new Handler(Looper.getMainLooper());
        this.j = new AIChatInputConfig(0, null, 0, false, null, 0, null, 4095);
        this.l = new b(this);
        if (r1 != null) goto L12;
        r1 = new Fragment();
    L12:
        this.m = r1;
        this.n = new com.bytedance.applet.impl.c(this);
        this.o = new com.bytedance.applet.impl.d(this);
        this.p = new d(this);
        this.q = new e(this);
        this.r = true;
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final Fragment getFragment() {
        return this.m;
    }

    public final boolean getVisibility() {
        return this.r;
    }

    public final void A7(AppletFullScreenActivity.b r1) {
        this.k = r1;
    }

    public final void q7(String r4) {
        Intrinsics.checkNotNullParameter(r4, "conversationId");
        if (Intrinsics.areEqual(r4, this.i) == false) goto L6;
        FLogger.a.i("AppletChatInputControllerImpl", "onConversationChange unchanged, skip, conversationId=" + r4);
        return;
    L6:
        this.i = r4;
        dw8.s r0 = this.b;
        if (r0 == null) goto L10;
        r0.q7(r4);
        return;
    }

    public final void r7(AppletModelContextProvider r3) {
        dw8.s r0 = this.b;
        if (r0 == null) goto L9;
        if (r3 == null) goto L6;
        h r1 = new h(r3);
    L7:
        r0.K2(r1);
        return;
    L6:
        r1 = null;
        goto L7
    }

    public final void s7(AppletChatInputController.c r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        if (this.d.remove(r3) == true) goto L5;
        return;
    L5:
        if ((!this.d.isEmpty()) == true) goto L22;
        this.e.removeCallbacks(this.n);
        dw8.s r4 = this.b;
        if (r4 == null) goto L10;
        r4.Qr(this.p);
    L10:
        dw8.s r5 = this.b;
        if (r5 == null) goto L13;
        r5.UN(this.o);
    L13:
        dw8.q r6 = this.a;
        if ((r6 instanceof dw8.q) == false) goto L16;
        dw8.q r7 = r6;
    L17:
        if (r7 == null) goto L19;
        r7.UB(this.q);
    L19:
        this.f = null;
        this.g = null;
        this.h = null;
        return;
    L16:
        r7 = null;
        goto L17
    }

    public final void setVisibility(boolean r3) {
        this.r = r3;
        this.e.removeCallbacks(this.n);
        dw8.s r0 = this.b;
        if (r0 == null) goto L5;
        r0.s70(r3, true);
    L5:
        a();
    }

    public final void u7(AppletChatInputController.g r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        dw8.t r3 = this.c.remove(r2);
        if (r3 == null) goto L8;
        dw8.s r0 = this.b;
        if (r0 == null) goto L9;
        r0.K4(r3);
        return;
    L9:
        return;
    }

    public final void v7(r2.c r23) {
        Intrinsics.checkNotNullParameter(r23, "config");
        dw8.s r2 = this.b;
        if (r2 == null) goto L34;
        b r3 = this.l;
        if (this.k == null) goto L7;
        boolean r4 = true;
    L8:
        if (r4 == true) goto L11;
        r3 = null;
    L11:
        List r1 = r23.a;
        int r5 = 10;
        ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator r7 = r1.iterator();
    L13:
        if (r7.hasNext() == false) goto L27;
        r2.e r8 = (r2.e) r7.next();
        String r9 = r8.a;
        String r10 = r8.b;
        String r11 = r8.c;
        String r12 = r8.d;
        r2.b.b r13 = r8.e;
        if ((r13 instanceof r2.b.b) == false) goto L18;
        Iterator r20 = r7;
        dw8.c r14 = new dw8.c.b(g.a(r13.a));
    L24:
        r6.add(new dw8.f(r9, r10, r11, r12, r14));
        r7 = r20;
        r5 = 10;
        goto L13
    L18:
        if ((r13 instanceof r2.b.a) == false) goto L26;
        r2.b.a r15 = (r2.b.a) r13;
        List r16 = r15.a;
        ArrayList r17 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, r5));
        Iterator r18 = r16.iterator();
    L21:
        if (r18.hasNext() == false) goto L23;
        r2.d r19 = (r2.d) r18.next();
        Iterator r21 = r7;
        r17.add(new dw8.e(r19.a, r19.b, r19.c, r19.d, g.a(r19.e)));
        r7 = r21;
        r18 = r18;
        goto L21
    L23:
        r20 = r7;
        r14 = new dw8.c.a(r17, r15.b);
        goto L24
    L26:
        throw new NoWhenBranchMatchedException();
    L27:
        r2.I8(new dw8.d(r6, r3));
        return;
    L7:
        r4 = false;
        goto L8
    }

    public final void w7(AppletChatInputController.c r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        if (this.d.add(r3) == true) goto L5;
        return;
    L5:
        if (this.d.size() <= 1) goto L8;
        return;
    L8:
        if (this.r == false) goto L10;
        r2.f r4 = u6();
    L11:
        dw8.q r0 = null;
        if (r4 == null) goto L14;
        Integer r1 = Integer.valueOf(r4.a);
    L15:
        this.f = r1;
        this.g = r4;
        Fragment r5 = this.a;
        if ((r5 instanceof dw8.q) == false) goto L18;
        r0 = (dw8.q) r5;
    L18:
        if (r0 == null) goto L20;
        r0.Bb(this.q);
    L20:
        dw8.s r6 = this.b;
        if (r6 == null) goto L23;
        r6.YI(this.p);
    L23:
        dw8.s r7 = this.b;
        if (r7 == null) goto L28;
        r7.QL(this.o);
        return;
    L28:
        return;
    L14:
        r1 = null;
        goto L15
    L10:
        r4 = new r2.f(0, AppletChatPanelState.INVISIBLE);
        goto L11
    }

    public final void y7(AppletChatInputController.d r9) {
        Intrinsics.checkNotNullParameter(r9, "config");
        List r0 = AIChatInputConfig.m;
        ArrayList r6 = new ArrayList();
        Iterator r1 = r0.iterator();
    L3:
        boolean r2 = true;
        if (r1.hasNext() == false) goto L13;
        Object r3 = r1.next();
        AIChatInputConfig.PlusAction r4 = (AIChatInputConfig.PlusAction) r3;
        if (r9.a == false) goto L8;
    L10:
        r2 = false;
    L11:
        if (r2 == true) goto L3;
        r6.add(r3);
        goto L3
    L8:
        if (r4 != AIChatInputConfig.PlusAction.CAMERA) goto L10;
    L13:
        AIChatInputConfig r5 = this.j;
        if (r9.a == false) goto L16;
        int r7 = 1;
    L17:
        boolean r8 = r9.b;
        AIChatInputConfig r10 = AIChatInputConfig.a(r5, r9.c, r9.d, r7, r8, r6, 3985);
        this.j = r10;
        dw8.s r11 = this.b;
        if (r11 == null) goto L26;
        r11.k8(r10);
        return;
    L26:
        return;
    L16:
        r7 = 8;
        goto L17
    }

    public final void z7(AppletChatInputController.g r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        dw8.t r0 = this.c.remove(r3);
        if (r0 == null) goto L7;
        dw8.s r1 = this.b;
        if (r1 == null) goto L7;
        r1.K4(r0);
    L7:
        c r2 = new c(r3);
        this.c.put(r3, r2);
        dw8.s r4 = this.b;
        if (r4 == null) goto L11;
        r4.G5(r2);
        return;
    }

    public final void I1(boolean r2, boolean r3) {
        dw8.s r0 = this.b;
        if (r0 == null) goto L6;
        r0.I1(r2, r3);
        return;
    }

    public final void x7(String r9, String r10) {
        if (Intrinsics.areEqual(this.j.b, r9) == true) goto L5;
    L7:
        AIChatInputConfig r11 = AIChatInputConfig.a(this.j, r9, r10, 0, false, null, 4089);
        this.j = r11;
        dw8.s r12 = this.b;
        if (r12 == null) goto L11;
        r12.k8(r11);
        return;
    L11:
        return;
    L5:
        if (Intrinsics.areEqual(this.j.c, r10) == false) goto L7;
    }
}
