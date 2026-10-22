package com.larus.home.impl.sdk;

import android.content.Context;
import com.bytedance.ai.api.AppletService;
import com.bytedance.ai.api.AppletV2Service;
import com.bytedance.ai.api.AppsInstalledStatusUtils;
import com.bytedance.ai.api.IAppletDebuggerService;
import com.google.gson.JsonObject;
import com.larus.audio.controller.GlobalAudioController;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import com.larus.platform.api.AppletDebuggerEntryState;
import com.obric.aiagent.assistant.idl.IFlowAppIntentIDL;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes29.dex */
public final class FlowAppletServiceImpl implements com.larus.platform.api.h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FlowAppletServiceImpl f346125a = null;

    static {
        f346125a = new FlowAppletServiceImpl();
    }

    public FlowAppletServiceImpl() {
    }

    public final String f() {
        AppletService r100 = (AppletService) ServiceManager.get().getService(AppletService.class);
        if (r100 == null) goto L5;
        String r101 = r100.i();
    L7:
        if (Intrinsics.areEqual(r101, "boe") == false) goto L10;
        return "748d2131f279d740f1410b244cb44d53";
    L10:
        if (Intrinsics.areEqual(r101, EffectConstants.CHANNEL_TEST) == false) goto L12;
        return "8bd80976c5c429740e3d49c46e93cf89";
    L12:
        return "f0422741984b436c95f7d24f92f34a97";
    L5:
        r101 = null;
        goto L7
    }

    public final Integer g() {
        IAppletDebuggerService r100 = (IAppletDebuggerService) ServiceManager.get().getService(IAppletDebuggerService.class);
        if (r100 == null) goto L5;
        r100.a();
        return Integer.valueOf(R.drawable.larus_applet_debug_cvs_avatar);
    L5:
        return null;
    }

    public final Map<String, String> h() {
        LinkedHashMap r100 = new LinkedHashMap();
        String r101 = "1";
        if (AppHost.f326268a.a().isAppBackground() == false) goto L5;
        Object r102 = "1";
    L6:
        r100.put("is_app_background", r102);
        boolean r103 = AppsInstalledStatusUtils.f33967a;
        if (AppsInstalledStatusUtils.f33967a == false) goto L9;
        Object r104 = "1";
    L10:
        r100.put("is_douyin_installed", r104);
        if (AppsInstalledStatusUtils.f33968b == true) goto L14;
        r101 = "0";
    L14:
        r100.put("is_luna_installed", r101);
        String r105 = GlobalAudioController.f289658a.g();
        if (r105 != null) goto L17;
        r105 = "";
    L17:
        r100.put("media_player_business_scene", r105);
        return r100;
    L9:
        r104 = "0";
        goto L10
    L5:
        r102 = "0";
        goto L6
    }

    public final String i() {
        AppletService r100 = (AppletService) ServiceManager.get().getService(AppletService.class);
        if (r100 == null) goto L5;
        String r101 = r100.k();
    L6:
        if (r101 != null) goto L9;
        return "";
    L9:
        return r101;
    L5:
        r101 = null;
        goto L6
    }

    public final kotlinx.coroutines.flow.i1<AppletDebuggerEntryState> j() {
        IAppletDebuggerService r100 = (IAppletDebuggerService) ServiceManager.get().getService(IAppletDebuggerService.class);
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f();
    }

    public final kotlinx.coroutines.flow.i1<Pair<String, JSONObject>> k() {
        AppletService r100 = (AppletService) ServiceManager.get().getService(AppletService.class);
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getEventFlow();
    }

    public final boolean e() {
        return xg9.b.a().getBoolean("lynx_url_add_gecko_access_key", false);
    }

    public final zp9.j d(com.larus.platform.api.e r100) {
        Intrinsics.checkNotNullParameter(r100, "messageContext");
        IAppletDebuggerService r101 = (IAppletDebuggerService) ServiceManager.get().getService(IAppletDebuggerService.class);
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.e(r100);
    }

    public final boolean l(String r100) {
        Intrinsics.checkNotNullParameter(r100, "code");
        AppletV2Service r101 = (AppletV2Service) ServiceManager.get().getService(AppletV2Service.class);
        if (r101 != null) goto L7;
        return false;
    L7:
        return Intrinsics.areEqual(r101.m(r100), Boolean.TRUE);
    }

    public final boolean m(wc9.e r100) {
        boolean r101 = false;
        if (r100 != null) goto L5;
        return false;
    L5:
        String r102 = r100.f559215r;
        if (r102 != null) goto L8;
    L9:
        r101 = true;
    L10:
        Object r103 = "";
        if (r101 == true) goto L23;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L15
        Object r105 = Result.m9449constructorimpl(new JSONObject(r102).optString("doubao_miniapp_debug_flag"));     // Catch: Throwable -> L15
    L18:
        if (Result.m9455isFailureimpl(r105) == true) goto L21;
        r103 = r105;
    L21:
        r103 = (String) r103;
    L15:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L23:
        return Intrinsics.areEqual(r103, "true");
    L8:
        if (r102.length() != 0) goto L10;
        goto L9
    }

    public final boolean n(String r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
        AppletV2Service r101 = (AppletV2Service) ServiceManager.get().getService(AppletV2Service.class);
        if (r101 != null) goto L7;
        return false;
    L7:
        return Intrinsics.areEqual(r101.l(r100), Boolean.TRUE);
    }

    public final Object p(Continuation<? super Unit> r100) {
        IAppletDebuggerService r101 = (IAppletDebuggerService) ServiceManager.get().getService(IAppletDebuggerService.class);
        if (r101 == null) goto L10;
        Object r102 = r101.b(r100);
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L8;
        return r102;
    L8:
        return Unit.INSTANCE;
    L10:
        return Unit.INSTANCE;
    }

    @Override // com.larus.platform.api.h0
    public final void a(String r100, JsonObject r101) {
        Intrinsics.checkNotNullParameter(r100, "eventKey");
        Intrinsics.checkNotNullParameter(r101, "eventJson");
        if (Intrinsics.areEqual(r100, "flow.action_bar_item_exposed") == false) goto L8;
        AppletService r102 = (AppletService) ServiceManager.get().getService(AppletService.class);
        if (r102 == null) goto L10;
        r102.a(r100, r101);
        return;
    L10:
        return;
    L8:
        int r103 = com.larus.bmhome.o.f313527a;
        Intrinsics.checkNotNullParameter(r100, "eventKey");
        Intrinsics.checkNotNullParameter(r101, "eventJson");
        Lazy r104 = l3.d.f507201a;
        l3.d.c(new l3.a(r100, r101, 4));
    }

    public final Object b(Context r100, Continuation<? super Boolean> r110) {
        if ((r110 instanceof FlowAppletServiceImpl$createAndOpenDebuggerSession$1) == false) goto L7;
        FlowAppletServiceImpl$createAndOpenDebuggerSession$1 r101 = (FlowAppletServiceImpl$createAndOpenDebuggerSession$1) r110;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        FlowAppletServiceImpl$createAndOpenDebuggerSession$1 r103 = r101;
        Object r111 = r103.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r103.label;
        boolean r106 = true;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        ResultKt.throwOnFailure(r111);
    L20:
        if (((Boolean) r111).booleanValue() == true) goto L24;
    L22:
        r106 = false;
    L24:
        return Boxing.boxBoolean(r106);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r111);
        IAppletDebuggerService r107 = (IAppletDebuggerService) ServiceManager.get().getService(IAppletDebuggerService.class);
        if (r107 == null) goto L22;
        r103.label = 1;
        r111 = IAppletDebuggerService.a.a(r107, r100, null, null, r103, 14);
        if (r111 != r104) goto L20;
        return r104;
    L7:
        r101 = new FlowAppletServiceImpl$createAndOpenDebuggerSession$1(this, r110);
        goto L8
    }

    public final boolean o(Context r100, String r101, com.larus.platform.api.e r102) {
        Intrinsics.checkNotNullParameter(r100, "androidContext");
        Intrinsics.checkNotNullParameter(r101, "action");
        Intrinsics.checkNotNullParameter(r102, "messageContext");
        IAppletDebuggerService r103 = (IAppletDebuggerService) ServiceManager.get().getService(IAppletDebuggerService.class);
        if (r103 != null) goto L5;
    L7:
        return false;
    L5:
        if (r103.c(r100, r101, r102) != true) goto L7;
        return true;
    }

    @Override // com.larus.platform.api.h0
    public final void c(String r110, String r111, Context r112, String r113, String r114, Map r115, Function0 r116) {
        Intrinsics.checkNotNullParameter("com.flow.remind", IFlowAppIntentIDL.PARAM_APPLET_ID);
        int r100 = com.larus.bmhome.o.f313527a;
        Intrinsics.checkNotNullParameter("com.flow.remind", IFlowAppIntentIDL.PARAM_APPLET_ID);
        AppletService r101 = (AppletService) ServiceManager.get().getService(AppletService.class);
        if (r101 == null) goto L6;
        r101.c(r110, r111, r112, r113, r114, r115, r116);
        return;
    }
}
