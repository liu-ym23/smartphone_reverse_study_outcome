package com.bytedance.applet.impl;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ai.api.AppletBottomSheetButtonRole;
import com.bytedance.ai.api.AppletExtService;
import com.bytedance.ai.api.AppletV2Service;
import com.bytedance.ai.api.ToastIconType;
import com.bytedance.ai.api.model.view.AIFragmentBase;
import com.bytedance.ai.applet.app.AppletAppActivity;
import com.bytedance.ai.applet.components.input.AppletChatInputController;
import com.bytedance.ai.applet.douyinAuth.DouyinGeneralAuthHelper;
import com.bytedance.ai.applet.granting.GrantingAction;
import com.bytedance.ai.bridge.method.bottomsheet.DoubaoBottomSheetButtonRole;
import com.bytedance.ai.bridge.method.bottomsheet.DoubaoBottomSheetCancelSource;
import com.bytedance.ai.lite.widget.cache.LiteWidgetResourceLoader;
import com.bytedance.ai.widget.cache.WidgetResourceLoader;
import com.bytedance.ai.widget.contianer.WidgetContainer;
import com.bytedance.ai.widget.models.ConversationWidgetData;
import com.bytedance.applet.context.ContextManager;
import com.bytedance.applet.debugger.AppletDebuggerActivity;
import com.bytedance.applet.model.floating.FloatingSpeakerConfigImplKt;
import com.bytedance.applet.utils.MessageUtils;
import com.bytedance.applet.view.AppletFragment;
import com.bytedance.ies.xbridge.event.Event;
import com.bytedance.ies.xbridge.event.EventCenter;
import com.bytedance.router.SmartRouter;
import com.google.gson.JsonObject;
import com.larus.bmhome.chat.d4;
import com.larus.bmhome.chat.j4;
import com.larus.common.apphost.AppHost;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class MainlandAppletServiceImpl$MainlandAIAbilities extends com.bytedance.applet.base.a {
    public final g2.a a;

    @Override // com.bytedance.applet.base.a
    public final void A() {
    }

    @Override // com.bytedance.applet.base.a
    public final Activity O() {
        Iterator r0 = AppHost.a.a().g().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if ((((Activity) r1) instanceof j4) == false) goto L4;
    L10:
        return (Activity) r1;
    L8:
        r1 = null;
        goto L10
    }

    @Override // com.bytedance.applet.base.a
    public final Map<String, Object> P() {
        com.larus.platform.service.g r0 = com.larus.platform.service.g.a;
        if (r0.b().length() <= 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
        LinkedHashMap r2 = new LinkedHashMap();
        r2.put("flow_app_variant", r0.b());
        return r2;
    L8:
        return null;
    L5:
        r1 = false;
        goto L6
    }

    @Override // com.bytedance.applet.base.a
    public final String e() {
        Lazy r0 = i2.f.i;
        i2.f r1 = i2.f.a.a();
        if (r1 == null) goto L7;
        k2.s r2 = r1.f;
        if (r2 == null) goto L7;
        return r2.getPageID();
    L7:
        return null;
    }

    @Override // com.bytedance.applet.base.a
    public final Map<String, Object> getSettings() {
        hq9.m r0 = z2.a.getAppsFrameworkConfig();
        return MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("appsMusicEnable", Boolean.valueOf(r0.e)), TuplesKt.to("appsMultiworkEntranceEnable", Boolean.valueOf(r0.d))});
    }

    @Override // com.bytedance.applet.base.a
    public final Activity m() {
        List r0 = AppHost.a.a().g();
        ListIterator r1 = r0.listIterator(r0.size());
    L4:
        if (r1.hasPrevious() == false) goto L8;
        Object r2 = r1.previous();
        if ((((Activity) r2) instanceof AppletDebuggerActivity) == false) goto L4;
    L10:
        return (Activity) r2;
    L8:
        r2 = null;
        goto L10
    }

    @Override // com.bytedance.applet.base.a
    public final Activity z() {
        List r0 = AppHost.a.a().g();
        ListIterator r1 = r0.listIterator(r0.size());
    L4:
        if (r1.hasPrevious() == false) goto L14;
        Object r2 = r1.previous();
        Activity r3 = (Activity) r2;
        if ((r3 instanceof d4) == false) goto L8;
    L11:
        boolean r4 = true;
    L12:
        if (r4 == false) goto L4;
    L16:
        return (Activity) r2;
    L8:
        if ((r3 instanceof ci8.a) == true) goto L11;
        r4 = false;
        goto L12
    L14:
        r2 = null;
        goto L16
    }

    public MainlandAppletServiceImpl$MainlandAIAbilities() {
        this.a = FloatingSpeakerConfigImplKt.b;
    }

    @Override // com.bytedance.applet.base.a
    public final g2.a h() {
        return this.a;
    }

    @Override // com.bytedance.applet.base.a
    public final WidgetResourceLoader B(ConversationWidgetData r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        String r0 = r2.getLiteTemplateUrl();
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L13;
        return new WidgetResourceLoader(r2);
    L13:
        return new LiteWidgetResourceLoader(r2);
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    @Override // com.bytedance.applet.base.a
    public final void C(f2.g r2) {
        Intrinsics.checkNotNullParameter(r2, "lifecycle");
        CopyOnWriteArrayList r0 = ji8.a.a;
        q1 r1 = new q1(r2);
        Intrinsics.checkNotNullParameter(r1, "observer");
        ji8.a.a.add(r1);
    }

    @Override // com.bytedance.applet.base.a
    public final String I(String r3) {
        Intrinsics.checkNotNullParameter(r3, "cvsID");
        return (String) BuildersKt.runBlocking$default(null, new MainlandAppletServiceImpl$MainlandAIAbilities$conversationIdToBotId$1(r3, null), 1, null);
    }

    @Override // com.bytedance.applet.base.a
    public final int R(String r2) {
        Intrinsics.checkNotNullParameter(r2, "conversationId");
        CopyOnWriteArrayList r0 = ji8.a.a;
        Intrinsics.checkNotNullParameter(r2, "cId");
        Set r3 = (Set) ((LinkedHashMap) ji8.a.b).get(r2);
        if (r3 != null) goto L7;
        return 0;
    L7:
        return r3.size();
    }

    @Override // com.bytedance.applet.base.a
    public final void b(boolean r10) {
        if (Intrinsics.areEqual(kw3.a.a, Boolean.valueOf(r10)) == false) goto L5;
        FLogger.a.i("NightModeNotifier", "skip unchanged theme, isNightMode=" + r10);
        return;
    L5:
        Boolean r0 = kw3.a.a;
        if (r10 == false) goto L8;
        String r2 = "dark";
    L9:
        kw3.a.a = Boolean.valueOf(r10);
        FLogger r3 = FLogger.a;
        r3.i("NightModeNotifier", "theme changed, previousIsNightMode=" + r0 + ", isNightMode=" + r10 + ", appTheme=" + r2);
        EventCenter.enqueueEvent(new Event("onThemeChange", System.currentTimeMillis(), new f66.d(new JSONObject(MapsKt.mapOf(TuplesKt.to("appTheme", r2))))));
        r3.i("NightModeNotifier", "published onThemeChange to XBridge EventCenter");
        Lazy r11 = l3.d.a;
        JsonObject r12 = new JsonObject();
        r12.addProperty("appTheme", r2);
        Unit r1 = Unit.INSTANCE;
        l3.d.c(new l3.a("onThemeChange", r12, 4));
        r3.i("NightModeNotifier", "published onThemeChange to AIBridgeEventCenter");
        return;
    L8:
        r2 = "light";
        goto L9
    }

    @Override // com.bytedance.applet.base.a
    public final void c(Function2<? super Boolean, ? super String, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "callback");
        AppletV2Service r0 = (AppletV2Service) ServiceManager.get().getService(AppletV2Service.class);
        if (r0 == null) goto L6;
        r0.c(r3);
        return;
    }

    @Override // com.bytedance.applet.base.a
    public final AIFragmentBase g(String r3) {
        Intrinsics.checkNotNullParameter(r3, "appId");
        AppletExtService r0 = (AppletExtService) ServiceManager.get().getService(AppletExtService.class);
        AIFragmentBase r1 = null;
        if (r0 == null) goto L5;
        Fragment r4 = r0.m(r3);
    L7:
        if ((r4 instanceof AIFragmentBase) == false) goto L9;
        r1 = (AIFragmentBase) r4;
    L9:
        if (r1 == null) goto L11;
        return r1;
    L11:
        return new AppletFragment();
    L5:
        r4 = null;
        goto L7
    }

    @Override // com.bytedance.applet.base.a
    public final AppletChatInputController p(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return new f();
    }

    @Override // com.bytedance.applet.base.a
    public final View.OnLongClickListener s(WidgetContainer r3) {
        Intrinsics.checkNotNullParameter(r3, "widgetContainer");
        AppletExtService r0 = (AppletExtService) ServiceManager.get().getService(AppletExtService.class);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.l(r3);
    }

    @Override // com.bytedance.applet.base.a
    public final boolean x(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        if ((r2 instanceof j4) == false) goto L5;
    L12:
        return true;
    L5:
        if ((r2 instanceof d4) == true) goto L12;
        if ((r2 instanceof ci8.a) == true) goto L12;
        if ((r2 instanceof AppletDebuggerActivity) == true) goto L12;
        return false;
    }

    @Override // com.bytedance.applet.base.a
    public final void D(Context r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AppletExtService r0 = (AppletExtService) ServiceManager.get().getService(AppletExtService.class);
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        if (r1 == true) goto L10;
        com.bytedance.router.i r6 = SmartRouter.buildRoute(r4, "//flow/applet");
        r6.c.putExtras(r5);
        r6.d = 2130772401;
        r6.e = 2130772399;
        r6.d();
        return;
    L10:
        return;
    L5:
        if (r0.p(r4, r5) != true) goto L7;
        r1 = true;
        goto L7
    }

    @Override // com.bytedance.applet.base.a
    public final void E(String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "queryMsgId");
        AppletV2Service r0 = (AppletV2Service) ServiceManager.get().getService(AppletV2Service.class);
        if (r0 == null) goto L6;
        r0.n(r3, r4);
        return;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [com.bytedance.applet.impl.k1] */
    @Override // com.bytedance.applet.base.a
    public final void F(u2.i r12, final Function1<? super GrantingAction, Unit> r13) {
        Intrinsics.checkNotNullParameter(r12, "config");
        Intrinsics.checkNotNullParameter(r13, "completion");
        AppletV2Service r0 = (AppletV2Service) ServiceManager.get().getService(AppletV2Service.class);
        if (r0 == null) goto L6;
        Intrinsics.checkNotNullParameter(r12, "<this>");
        Integer r3 = r12.a;
        String r4 = r12.b;
        String r5 = r12.c;
        String r6 = r12.d;
        String r7 = r12.e;
        String r8 = r12.f;
        String r10 = r12.g;
        r0.i(new com.bytedance.ai.api.p(r3, r4, r5, r6, r7, r8, r12.h, r10), new k1(r13));
        return;
    }

    @Override // com.bytedance.applet.base.a
    public final Object G(String r2, Continuation<? super Boolean> r3) {
        return MessageUtils.a.i(r2, r3);
    }

    /* JADX WARN: Type inference failed for: r6v2, types: [com.bytedance.applet.impl.o1] */
    @Override // com.bytedance.applet.base.a
    public final void H(com.bytedance.ai.applet.login.i r6, final Function1<? super GrantingAction, Unit> r7) {
        Intrinsics.checkNotNullParameter(r6, "config");
        Intrinsics.checkNotNullParameter(r7, "completion");
        AppletV2Service r0 = (AppletV2Service) ServiceManager.get().getService(AppletV2Service.class);
        if (r0 == null) goto L6;
        Intrinsics.checkNotNullParameter(r6, "<this>");
        r0.h(new com.bytedance.ai.api.g(r6.a, r6.b, r6.c, r6.d), new o1(r7));
        return;
    }

    @Override // com.bytedance.applet.base.a
    public final Object J(String r7, Continuation<? super Bitmap> r8) {
        return ImageLoaderKt.n(r7, "Applet", null, null, r8, 124);
    }

    @Override // com.bytedance.applet.base.a
    public final void K(Context r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "url");
        com.larus.platform.service.q.a.e(r4, BundleKt.bundleOf(new Pair[]{TuplesKt.to("link_url", r5)}), null);
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [com.bytedance.applet.impl.p1] */
    @Override // com.bytedance.applet.base.a
    public final void M(m3.d r12, final m3.e r13) {
        Intrinsics.checkNotNullParameter(r12, "config");
        Intrinsics.checkNotNullParameter(r13, "completion");
        AppletV2Service r0 = (AppletV2Service) ServiceManager.get().getService(AppletV2Service.class);
        if (r0 == null) goto L24;
        Intrinsics.checkNotNullParameter(r12, "<this>");
        m3.a r2 = r12.a;
        if (r2 == null) goto L7;
        Intrinsics.checkNotNullParameter(r2, "<this>");
        com.bytedance.ai.api.b r3 = new com.bytedance.ai.api.b(r2.a, r2.b);
    L8:
        com.bytedance.ai.api.b r5 = r3;
        String r6 = r12.b;
        String r7 = r12.c;
        List r4 = r12.d;
        ArrayList r8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator r9 = r4.iterator();
    L10:
        if (r9.hasNext() == false) goto L23;
        m3.c r10 = (m3.c) r9.next();
        Intrinsics.checkNotNullParameter(r10, "<this>");
        DoubaoBottomSheetButtonRole r11 = r10.a;
        Intrinsics.checkNotNullParameter(r11, "<this>");
        int r14 = z1.a.b[r11.ordinal()];
        if (r14 != 1) goto L14;
        AppletBottomSheetButtonRole r15 = AppletBottomSheetButtonRole.AGREE_MAIN;
    L22:
        r8.add(new com.bytedance.ai.api.d(r15, r10.b));
        goto L10
    L14:
        if (r14 != 2) goto L16;
        r15 = AppletBottomSheetButtonRole.AGREE_SUB;
        goto L22
    L16:
        if (r14 != 3) goto L19;
        r15 = AppletBottomSheetButtonRole.REJECT;
        goto L22
    L19:
        throw new NoWhenBranchMatchedException();
    L23:
        m3.b r16 = r12.e;
        Intrinsics.checkNotNullParameter(r16, "<this>");
        r0.p(new com.bytedance.ai.api.e(r5, r6, r7, r8, new com.bytedance.ai.api.c(r16.a)), new p1(r13));
        return;
    L7:
        r3 = null;
        goto L8
    L24:
        int r17 = com.bytedance.ai.bridge.method.bottomsheet.a.d;
        r13.invoke(com.bytedance.ai.bridge.method.bottomsheet.a.a.a(DoubaoBottomSheetCancelSource.HOST_UNAVAILABLE));
    }

    @Override // com.bytedance.applet.base.a
    public final Boolean N(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "appId");
        Intrinsics.checkNotNullParameter(r3, "packageName");
        return Boolean.FALSE;
    }

    @Override // com.bytedance.applet.base.a
    public final void k(String r3, String r4) {
        ContextManager.a.getClass();
        Iterator<com.larus.bmhome.chat.api.t0> r0 = ContextManager.d.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().a(r3, r4);
        goto L4
    }

    @Override // com.bytedance.applet.base.a
    public final Object l(String r4, Continuation<? super Boolean> r5) {
        return BuildersKt.withContext(Dispatchers.getIO(), new MainlandAppletServiceImpl$MainlandAIAbilities$isPin$2(r4, null), r5);
    }

    @Override // com.bytedance.applet.base.a
    public final void q(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "toastIconType");
        Intrinsics.checkNotNullParameter(r4, "toastContent");
        String r5 = r3.toUpperCase(Locale.ROOT);
        switch(r5.hashCode()) {
            case -2032180703: goto L18;
            case -1149187101: goto L14;
            case -368591510: goto L10;
            case 1842428796: goto L6;
            default: goto L21;
        };
    L21:
        ToastIconType r6 = ToastIconType.DEFAULT;
    L22:
        AppletV2Service r0 = (AppletV2Service) ServiceManager.get().getService(AppletV2Service.class);
        if (r0 == null) goto L26;
        r0.k(r6, r4);
        return;
    L26:
        return;
    L6:
        if (r5.equals("WARNING") == false) goto L21;
        r6 = ToastIconType.WARNING;
        goto L22
    L10:
        if (r5.equals("FAILURE") == false) goto L21;
        r6 = ToastIconType.FAILURE;
        goto L22
    L14:
        if (r5.equals("SUCCESS") == false) goto L21;
        r6 = ToastIconType.SUCCESS;
        goto L22
    L18:
        if (r5.equals("DEFAULT") == false) goto L21;
        r6 = ToastIconType.DEFAULT;
        goto L22
    }

    @Override // com.bytedance.applet.base.a
    public final void r(String r3, com.bytedance.ai.applet.douyinAuth.b r4) {
        Intrinsics.checkNotNullParameter("aw730v27vx2bu2qw", "clientKey");
        Intrinsics.checkNotNullParameter(r3, "scope");
        Intrinsics.checkNotNullParameter(r4, "completion");
        AppletV2Service r0 = (AppletV2Service) ServiceManager.get().getService(AppletV2Service.class);
        if (r0 == null) goto L6;
        r0.e(r3, new n1(r4));
        return;
    }

    @Override // com.bytedance.applet.base.a
    public final void a(Context r3, String r4, com.bytedance.ai.bridge.method.authorize.b r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "appletId");
        Intrinsics.checkNotNullParameter(r5, "completion");
        AppletV2Service r0 = (AppletV2Service) ServiceManager.get().getService(AppletV2Service.class);
        if (r0 != null) goto L6;
        r5.invoke("applet settings host is unavailable");
        return;
    L6:
        r0.a(r3, r4, r5);
    }

    @Override // com.bytedance.applet.base.a
    public final void n(String r2, String r3, DouyinGeneralAuthHelper.a r4) {
        Intrinsics.checkNotNullParameter(r2, "clientKey");
        Intrinsics.checkNotNullParameter(r3, "scope");
        Intrinsics.checkNotNullParameter(r4, "completion");
        AppletV2Service r5 = (AppletV2Service) ServiceManager.get().getService(AppletV2Service.class);
        if (r5 == null) goto L6;
        r5.f(r3, new m1(r4));
        return;
    }

    @Override // com.bytedance.applet.base.a
    public final void y(Context r3, String r4, Function1<? super Boolean, Unit> r5) {
        Intrinsics.checkNotNullParameter(r4, "permissionName");
        Intrinsics.checkNotNullParameter(r5, "completion");
        if (r3 != null) goto L9;
        AppHost.Companion r6 = AppHost.a;
        Activity r0 = r6.a().getCurrentActivity();
        if (r0 == null) goto L7;
        r3 = r0;
        goto L9
    L7:
        r3 = (Context) CollectionsKt.lastOrNull(r6.a().g());
    L9:
        if ((r3 instanceof FragmentActivity) == false) goto L11;
        FragmentActivity r7 = (FragmentActivity) r3;
    L12:
        AppletV2Service r1 = (AppletV2Service) ServiceManager.get().getService(AppletV2Service.class);
        if (r1 == null) goto L16;
        r1.g(r7, r4, r5);
        return;
    L16:
        return;
    L11:
        r7 = null;
        goto L12
    }

    @Override // com.bytedance.applet.base.a
    public final void t(String r3, String r4, String r5, Function1<? super Boolean, Unit> r6) {
        Intrinsics.checkNotNullParameter(r3, "msgId");
        Intrinsics.checkNotNullParameter(r4, "cardId");
        Intrinsics.checkNotNullParameter(r5, "contentDataStr");
        Intrinsics.checkNotNullParameter(r6, "completion");
        AppletV2Service r0 = (AppletV2Service) ServiceManager.get().getService(AppletV2Service.class);
        if (r0 == null) goto L6;
        r0.j(r3, r4, r5, r6);
        return;
    }

    @Override // com.bytedance.applet.base.a
    public final void d(AppletAppActivity r8, int r9, String r10, String r11, Map r12) {
        Intrinsics.checkNotNullParameter(r8, "context");
        AppletV2Service r1 = (AppletV2Service) ServiceManager.get().getService(AppletV2Service.class);
        if (r1 == null) goto L6;
        r1.d(r8, r9, r10, r11, r12);
        return;
    }

    /* JADX WARN: Type inference failed for: r8v1, types: [com.bytedance.applet.impl.l1] */
    @Override // com.bytedance.applet.base.a
    public final void Q(String r18, String r19, boolean r20, Map r21, u2.i r22, final DouyinGeneralAuthHelper.b r23) {
        Intrinsics.checkNotNullParameter(r18, "clientKey");
        Intrinsics.checkNotNullParameter(r19, "scope");
        Intrinsics.checkNotNullParameter(r21, "trackInfo");
        Intrinsics.checkNotNullParameter(r22, "config");
        Intrinsics.checkNotNullParameter(r23, "completion");
        AppletV2Service r3 = (AppletV2Service) ServiceManager.get().getService(AppletV2Service.class);
        if (r3 == null) goto L6;
        Intrinsics.checkNotNullParameter(r22, "<this>");
        Integer r9 = r22.a;
        String r10 = r22.b;
        String r11 = r22.c;
        String r12 = r22.d;
        String r13 = r22.e;
        String r14 = r22.f;
        String r2 = r22.g;
        r3.o(r21, new com.bytedance.ai.api.p(r9, r10, r11, r12, r13, r14, r22.h, r2), r20, r19, new l1(r23));
        return;
    }
}
