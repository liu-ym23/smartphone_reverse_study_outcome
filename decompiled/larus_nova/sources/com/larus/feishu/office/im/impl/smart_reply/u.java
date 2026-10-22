package com.larus.feishu.office.im.impl.smart_reply;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.floatchat.IFloatChatService;
import com.larus.im.bean.message.Message;
import com.larus.nova.R;
import com.larus.ui.arch.modulizer.di.ContainerFilter;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import okio.ByteString;

/* JADX INFO: loaded from: classes29.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Fragment f343402a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f343403b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f343404c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f343405d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final v f343406e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function0<FlowSmartReplyAIContainerView> f343407f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function0<aya.b> f343408g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function0<aya.a> f343409h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public FrameLayout f343410i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Fragment f343411j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f343412k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public va8.g0 f343413l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final SmartReplyFloatChatController$foldStatusChangeListener$1 f343414m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public l f343415n;

    public final void b(Fragment r100) {
        l r101 = (l) s1a.a.g(r100).getAbility(l.class);
        l r102 = this.f343415n;
        if (r102 != r101) goto L5;
        return;
    L5:
        if (r102 == null) goto L7;
        r102.PK(this.f343406e);
    L7:
        this.f343415n = r101;
        if (r101 == null) goto L11;
        r101.E30(this.f343406e);
        return;
    }

    public final FrameLayout c(ViewGroup r100) {
        FrameLayout r101 = this.f343410i;
        if (r101 == null) goto L5;
        return r101;
    L5:
        FrameLayout r102 = (FrameLayout) r100.findViewWithTag(this.f343404c);
        if (r102 == null) goto L9;
        r102.setClipChildren(false);
        r102.setClipToPadding(false);
        r102.setVisibility(0);
        this.f343410i = r102;
        return r102;
    L9:
        Context r103 = r100.getContext();
        if (r103 != null) goto L13;
        return null;
    L13:
        FrameLayout r104 = new FrameLayout(r103);
        r104.setId(View.generateViewId());
        r104.setTag(this.f343404c);
        r104.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r104.setClipChildren(false);
        r104.setClipToPadding(false);
        r104.setVisibility(0);
        r100.addView(r104);
        this.f343410i = r104;
        return r104;
    }

    public final void g(Bundle r100) {
        Fragment r101 = this.f343411j;
        if (r101 == null) goto L16;
        t1a.b r102 = s1a.a.g(r101);
        if (r102 == null) goto L16;
        com.larus.bmhome.chat.component.cvs.y r103 = (com.larus.bmhome.chat.component.cvs.y) r102.getAbility(com.larus.bmhome.chat.component.cvs.y.class);
        if (r103 == null) goto L16;
        String r104 = r100.getString("argConversationId");
        String r105 = "";
        if (r104 != null) goto L11;
        r104 = "";
    L11:
        String r106 = r100.getString("argBotId");
        if (r106 == null) goto L15;
        r105 = r106;
    L15:
        r103.updateConversationId(r104, r105);
    L16:
        Fragment r107 = this.f343411j;
        if (r107 == null) goto L24;
        t1a.b r108 = s1a.a.g(r107);
        if (r108 == null) goto L25;
        u7 r109 = (u7) r108.getAbility(u7.class);
        if (r109 == null) goto L26;
        r109.cE();
        return;
    L26:
        return;
    L25:
        return;
    }

    public static final Object a(u r100, Continuation r101) {
        FlowSmartReplyAIContainerView r102 = r100.f343407f.invoke();
        if (r102 == null) goto L6;
        Message r103 = r102.getBindMessage();
        if (r103 == null) goto L6;
    L13:
        return r103;
    L6:
        aya.b r104 = r100.f343408g.invoke();
        r103 = null;
        if (r104 == null) goto L13;
        int r105 = FlowSmartReplyAIContainerView.f343262n;
        ByteString r106 = r104.f16772a;
        String r107 = r104.f16774c;
        Object r108 = BuildersKt.withContext(Dispatchers.getIO(), new FlowSmartReplyAIContainerView$Companion$parseMessage$2(r106, r107, null), r101);
        if (r108 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L14;
        r103 = (Message) r108;
        goto L13
    L14:
        return r108;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v10, types: [com.larus.feishu.office.im.impl.smart_reply.t] */
    public final Fragment d(ViewGroup r110, Bundle r111, String r112) {
        Fragment r100 = this.f343411j;
        if (r100 == null) goto L7;
        boolean r101 = true;
        if (r100.isAdded() != true) goto L7;
    L8:
        if (r101 == false) goto L17;
        Fragment r113 = this.f343411j;
        if (r113 == null) goto L13;
        b(r113);
    L13:
        if (Intrinsics.areEqual(this.f343412k, r112) == true) goto L16;
        g(r111);
        this.f343412k = r112;
    L16:
        return this.f343411j;
    L17:
        FrameLayout r114 = c(r110);
        FrameLayout.LayoutParams r102 = null;
        if (r114 != null) goto L20;
        return null;
    L20:
        Fragment r103 = this.f343411j;
        if (r103 != null) goto L23;
        r103 = this.f343402a.getChildFragmentManager().findFragmentByTag(this.f343405d);
    L23:
        if (r103 == null) goto L28;
        this.f343411j = r103;
        b(r103);
        if (Intrinsics.areEqual(this.f343412k, r112) == true) goto L27;
        g(r111);
        this.f343412k = r112;
    L27:
        return r103;
    L28:
        IFloatChatService r104 = (IFloatChatService) ServiceManager.get().getService(IFloatChatService.class);
        if (r104 != null) goto L32;
        FLogger.f375446a.e(this.f343403b, "ensureFloatChatFragment floatChatService is null");
        return null;
    L32:
        Fragment r115 = IFloatChatService.a.a(r104, r111, false, ContainerFilter.SMART_REPLY, Integer.valueOf(R.layout.larus_layout_smart_reply_float_chat), null, 16);
        this.f343411j = r115;
        this.f343412k = r112;
        FragmentTransaction r116 = this.f343402a.getChildFragmentManager().beginTransaction();
        int r117 = r114.getId();
        String r105 = this.f343405d;
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r116, r115, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, r105, r117) == true) goto L36;
        r116 = r116.add(r117, r115, r105);
    L36:
        r116.commitNowAllowingStateLoss();
        b(r115);
        va8.g0 r118 = this.f343413l;
        if (r118 == null) goto L39;
        r118.Zh(this.f343414m);
    L39:
        va8.g0 r119 = (va8.g0) s1a.a.g(r115).getAbility(va8.g0.class);
        this.f343413l = r119;
        if (r119 == null) goto L42;
        r119.Dj(this.f343414m);
    L42:
        mi8.b r120 = (mi8.b) s1a.a.g(r115).getAbility(mi8.b.class);
        if (r120 == 0) goto L45;
        r120.qY(new t(this));
    L45:
        View r121 = r115.getView();
        if (r121 == null) goto L53;
        ViewGroup.LayoutParams r122 = r121.getLayoutParams();
        if ((r122 instanceof FrameLayout.LayoutParams) == false) goto L50;
        r102 = (FrameLayout.LayoutParams) r122;
    L50:
        if (r102 != null) goto L52;
        r102 = new FrameLayout.LayoutParams(-1, -2);
    L52:
        r102.gravity = 80;
        r121.setLayoutParams(r102);
    L53:
        return r115;
    L7:
        r101 = false;
        goto L8
    }

    public final void f(ViewGroup r100, Bundle r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "hostRoot");
        Intrinsics.checkNotNullParameter(r101, "bundleData");
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L9
        if (d(r100, r101, r102) != null) goto L6;
        FLogger.f375446a.e(this.f343403b, "preloadFloatChat floatChatFragment is null");     // Catch: Throwable -> L9
    L7:
        Object r104 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L11:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L17;
        FLogger.f375446a.e(this.f343403b, "preloadFloatChat failed", r105);
        return;
    L17:
        return;
    L6:
        FLogger.f375446a.i(this.f343403b, "preloadFloatChat success: " + r102);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    /* JADX WARN: Type inference failed for: r5v1, types: [com.larus.feishu.office.im.impl.smart_reply.SmartReplyFloatChatController$foldStatusChangeListener$1] */
    public u(Fragment r100, FlowSmartReplyFloatExpandExtension.a r101, h r102, i r103, j r104) {
        Intrinsics.checkNotNullParameter(r100, "host");
        Intrinsics.checkNotNullParameter("FlowFloatExpandExtensionFactory", "loggerTag");
        Intrinsics.checkNotNullParameter("flow_float_expand_nine_chat_container", "containerTag");
        Intrinsics.checkNotNullParameter("flow_float_expand_nine_chat_fragment", "fragmentTag");
        Intrinsics.checkNotNullParameter(r101, "transitionListener");
        Intrinsics.checkNotNullParameter(r102, "currentViewProvider");
        Intrinsics.checkNotNullParameter(r103, "currentContextProvider");
        Intrinsics.checkNotNullParameter(r104, "actionHandlerProvider");
        this.f343402a = r100;
        this.f343403b = "FlowFloatExpandExtensionFactory";
        this.f343404c = "flow_float_expand_nine_chat_container";
        this.f343405d = "flow_float_expand_nine_chat_fragment";
        this.f343406e = r101;
        this.f343407f = r102;
        this.f343408g = r103;
        this.f343409h = r104;
        this.f343414m = new SmartReplyFloatChatController$foldStatusChangeListener$1(this);
    }

    public final void e(ViewGroup r100, Bundle r101, String r102, String r103, FlowSmartReplyAIContainerView r104) {
        Intrinsics.checkNotNullParameter(r100, "hostRoot");
        Intrinsics.checkNotNullParameter(r101, "bundleData");
        Intrinsics.checkNotNullParameter(r103, "from");
        if (d(r100, r101, r102) != null) goto L6;
        FLogger.f375446a.e(this.f343403b, "expand floatChatFragment is null");
        return;
    L6:
        FrameLayout r105 = this.f343410i;
        if (r105 == null) goto L9;
        r105.bringToFront();
    L9:
        if (r104 == null) goto L13;
        int[] r106 = new int[2];
        r104.getLocationOnScreen(r106);
        int r107 = r106[1];
        l r108 = this.f343415n;
        if (r108 == null) goto L13;
        r108.yB(r107);
    L13:
        va8.g0 r109 = this.f343413l;
        if (r109 != null) goto L17;
        FLogger.f375446a.e(this.f343403b, "expand foldAbility is null");
        return;
    L17:
        r109.expand(r103);
    }
}
