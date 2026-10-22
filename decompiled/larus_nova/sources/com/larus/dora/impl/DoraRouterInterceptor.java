package com.larus.dora.impl;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.bytedance.android.service.manager.pull.PullConfiguration;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.router.SmartRouter;
import com.google.gson.Gson;
import com.larus.caijing_pay.impl.config.CJHostRouterServiceImpl;
import com.larus.dora.api.DoraConfig;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.device.settings.gesture.options.OptionModel;
import com.larus.dora.impl.model.GestureSettingsKey;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.dora.impl.settings.DoraSetting;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.service.AccountService;
import com.larus.utils.y0;
import com.obric.assistant.spi.dora.IObricDoraService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ResultKt;
import kotlin.UByte;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes4.dex */
public final class DoraRouterInterceptor implements q97.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List<String> f331907c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final List<String> f331908d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final List<String> f331909e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final List<String> f331910f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Set<String> f331911g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f331912a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f331913b;

    public static final class a {
    }

    /* JADX INFO: loaded from: classes27.dex */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Boolean f331914a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Integer f331915b;

        public b() {
            this(null, null);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f331914a, r101.f331914a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f331915b, r101.f331915b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            Boolean r100 = this.f331914a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            Integer r104 = this.f331915b;
            if (r104 == null) goto L11;
            r101 = r104.hashCode();
        L11:
            return r103 + r101;
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "LynxVolumeSettingsInitData(isAdaptiveEnabled=" + this.f331914a + ", cueToneVolumeRaw=" + this.f331915b + ')';
        }

        public b(Boolean r100, Integer r101) {
            this.f331914a = r100;
            this.f331915b = r101;
        }
    }

    static {
        f331907c = CollectionsKt.listOf(new String[]{"//flow/dora/env_observe", "//dora_env_observe", "//flow/dora/obric_g_env_observe"});
        f331908d = CollectionsKt.listOf(new String[]{"//flow/dora/voice_settings", "//dora_sound_settings"});
        f331909e = CollectionsKt.listOf(new String[]{"//flow/dora/gesture_settings", "//dora_gesture_settings"});
        f331910f = CollectionsKt.listOf(new String[]{"//flow/dora/gesture_wakeup_setting", "//flow/dora/gesture_wakeup_left_setting", "//flow/dora/gesture_wakeup_right_setting", "//flow/dora/gesture_media_left_setting", "//flow/dora/gesture_media_right_setting", "//flow/dora/gesture_call_left_setting", "//flow/dora/gesture_call_right_setting"});
        f331911g = SetsKt.setOf(new String[]{"//flow/dora/obric_device_home", "//flow/dora/obric_device_list", "//flow/dora/obric_bind_device", "//flow/dora/obric_onboarding", "//flow/dora/obric_env_auth_onboarding"});
    }

    public DoraRouterInterceptor() {
        this.f331912a = LazyKt.lazy(new c0());
        this.f331913b = LazyKt.lazy(new d0());
    }

    @Override // q97.a
    public final boolean b(com.bytedance.router.c r100) {
        int r101 = com.larus.utils.k0.f375428a;
        if (r100 == null) goto L7;
        Uri r102 = r100.f267530d;
        if (r102 == null) goto L7;
        String r103 = r102.toString();
    L8:
        String r104 = com.larus.utils.k0.a(r103);
        g49.d.a("DoraRouterInterceptor", "Router matchInterceptRules -> " + r104);
        if (Intrinsics.areEqual(r104, "//flow/dora/dynamic_page") == false) goto L11;
    L22:
        return true;
    L11:
        if (CollectionsKt.contains(f331911g, r104) == true) goto L22;
        if (CollectionsKt.contains(f331907c, r104) == true) goto L22;
        if (CollectionsKt.contains(f331908d, r104) == true) goto L22;
        if (CollectionsKt.contains(f331909e, r104) == true) goto L22;
        if (CollectionsKt.contains(f331910f, r104) == true) goto L22;
        return false;
    L7:
        r103 = null;
        goto L8
    }

    public final Object d(Continuation<? super b> r100) {
        if ((r100 instanceof DoraRouterInterceptor$buildLynxVolumeSettingsInitData$1) == false) goto L7;
        DoraRouterInterceptor$buildLynxVolumeSettingsInitData$1 r101 = (DoraRouterInterceptor$buildLynxVolumeSettingsInitData$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        boolean r106 = true;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        ResultKt.throwOnFailure(r103);
    L17:
        int r107 = ((Number) r103).intValue();
        Integer r108 = Boxing.boxInt(kj4.a.g().z() & UByte.MAX_VALUE);
        Integer r109 = Boxing.boxInt(r107);
        int r110 = r109.intValue();
        if (r110 >= 0) goto L20;
    L22:
        boolean r111 = false;
    L23:
        Boolean r112 = null;
        if (r111 == true) goto L27;
        r109 = null;
    L27:
        if (r109 == null) goto L34;
        if (r109.intValue() == 1) goto L32;
        r106 = false;
    L32:
        r112 = Boxing.boxBoolean(r106);
    L34:
        return new b(r112, r108);
    L20:
        if (r110 >= 2) goto L22;
        r111 = true;
        goto L23
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        kj4.a r113 = kj4.a.g();
        r101.label = 1;
        r103 = DoraAdapterExtKt.l(r113);
        if (r103 != r104) goto L17;
        return r104;
    L7:
        r101 = new DoraRouterInterceptor$buildLynxVolumeSettingsInitData$1(this, r100);
        goto L8
    }

    public static final Object c(DoraRouterInterceptor r100, Continuation r101) {
        r100.getClass();
        if ((r101 instanceof DoraRouterInterceptor$buildLynxVolumeSettingsPageUrl$1) == false) goto L7;
        DoraRouterInterceptor$buildLynxVolumeSettingsPageUrl$1 r102 = (DoraRouterInterceptor$buildLynxVolumeSettingsPageUrl$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r104);
    L17:
        b r107 = (b) r104;
        Uri.Builder r108 = UriProtector.parse("sslocal://lynxview").buildUpon().appendQueryParameter("url", "https://lf-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/dora/client/resource/com_flow_dora_lynx/volume-setting/template.js").appendQueryParameter(CJHostRouterServiceImpl.URI_KEY_USE_ANNIEX, "1").appendQueryParameter("should_full_screen", "1").appendQueryParameter("hide_nav_bar", "1").appendQueryParameter("bdhm_bid", "doubao_dora_lynx").appendQueryParameter("bdhm_pid", "volume-setting");
        if (r107 == null) goto L21;
        r108.appendQueryParameter("initial_data", GsonProtectorUtils.toJson((Gson) r100.f331913b.getValue(), r107));
    L21:
        return r108.build().toString();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        r102.label = 1;
        r104 = r100.d(r102);
        if (r104 != r105) goto L17;
        return r105;
    L7:
        r102 = new DoraRouterInterceptor$buildLynxVolumeSettingsPageUrl$1(r100, r101);
        goto L8
    }

    public static void f(Context r100, int r101) {
        com.bytedance.router.i r102 = SmartRouter.buildRoute(r100, "//dora_gesture_wakeup");
        r102.f267554c.putExtra("device_side", r101);
        r102.f267555d = R.anim.larus_router_slide_in_right;
        r102.f267556e = R.anim.larus_router_no_anim;
        r102.d();
    }

    @Override // q97.a
    public final boolean a(Context r110, com.bytedance.router.c r111) {
        if (r110 == null) goto L180;
        if (r111 == null) goto L180;
        Uri r100 = r111.f267530d;
        Bundle r101 = null;
        if (r100 == null) goto L8;
        String r102 = y0.f(r100, DoraObricDeviceHomeViewModel.PARAM_PAGE_KEY);
    L9:
        int r103 = com.larus.utils.k0.f375428a;
        Uri r104 = r111.f267530d;
        if (r104 == null) goto L12;
        String r105 = r104.toString();
    L13:
        String r106 = com.larus.utils.k0.a(r105);
        Set<String> r107 = f331911g;
        if (CollectionsKt.contains(r107, r106) == false) goto L31;
        com.larus.dora.impl.device.s0 r108 = com.larus.dora.impl.device.s0.f334231a;
        Intent r109 = r111.f267528b;
        if (r109 == null) goto L18;
        Bundle r112 = r109.getExtras();
    L19:
        r108.getClass();
        if (com.larus.dora.impl.device.s0.b(r106, r112) == true) goto L31;
        if (AccountService.f365697a.isLogin().booleanValue() == true) goto L25;
        g49.d.e("DoraRouterInterceptor", "block Obric route before login: " + r106);
        return true;
    L25:
        Intent r113 = r111.f267528b;
        if (r113 == null) goto L28;
        r101 = r113.getExtras();
    L28:
        com.larus.dora.impl.device.s0.c(r110, r106, r101);
        g49.d.d("DoraRouterInterceptor", "intercept Obric route=" + r106);
        return true;
    L18:
        r112 = null;
    L31:
        if (CollectionsKt.contains(r107, r106) == false) goto L45;
        int r114 = m59.b.f512151a;
        if (r106 == null) goto L43;
        Intent r115 = r111.f267528b;
        if (r115 == null) goto L37;
        Bundle r116 = r115.getExtras();
    L39:
        if (m59.b.a(r110, r106, r116) == false) goto L45;
        g49.d.d("DoraRouterInterceptor", "intercept Obric route for resource loading: ".concat(r106));
        return true;
    L37:
        r116 = null;
        goto L39
    L43:
        throw new IllegalArgumentException("Required value was null.".toString());
    L45:
        if (CollectionsKt.contains(f331908d, r106) == false) goto L69;
        DoraSetting.f338023a.getClass();
        if (DoraConfig.f331707a.getBoolean("key_use_lynx_page", false) == true) goto L52;
        int r117 = com.larus.utils.l0.f375430a;
        if (((com.larus.dora.impl.settings.a) com.larus.utils.l0.a(new com.larus.dora.impl.settings.a(null), new com.larus.dora.impl.settings.w0())).f338025a == true) goto L52;
        boolean r118 = false;
    L53:
        if (r118 == false) goto L66;
        IDoraService r119 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r119 == null) goto L61;
        DeviceService r120 = r119.device();
        if (r120 == null) goto L61;
        if (r120.M() != true) goto L61;
        boolean r121 = true;
    L62:
        if (r121 == true) goto L66;
        g49.d.d("DoraRouterInterceptor", "redirect native sound settings to lynx page: " + r106);
        BuildersKt.launch$default((CoroutineScope) this.f331912a.getValue(), null, null, new DoraRouterInterceptor$openLynxVolumeSettingsPage$1(r110, this, null), 3, null);
        return true;
    L61:
        r121 = false;
    L66:
        g49.d.d("DoraRouterInterceptor", "use native sound settings for Dora G: " + r106);
        return false;
    L52:
        r118 = true;
        goto L53
    L69:
        if (CollectionsKt.contains(f331909e, r106) == false) goto L104;
        IDoraService r122 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r122 == null) goto L77;
        DeviceService r123 = r122.device();
        if (r123 == null) goto L77;
        if (r123.M() != true) goto L77;
        boolean r124 = true;
    L78:
        if (r124 == false) goto L81;
        g49.d.d("DoraRouterInterceptor", "keep native gesture settings page for G device: " + r106);
        return false;
    L81:
        DoraSetting.f338023a.getClass();
        Intrinsics.checkNotNullParameter("gesture-setting", "pageId");
        if (DoraConfig.f331707a.getBoolean("key_use_lynx_page", false) == true) goto L88;
        int r125 = com.larus.utils.l0.f375430a;
        com.larus.dora.impl.settings.a r126 = (com.larus.dora.impl.settings.a) com.larus.utils.l0.a(new com.larus.dora.impl.settings.a(null), new com.larus.dora.impl.settings.w0());
        if (r126.f338025a == true) goto L87;
    L89:
        boolean r127 = false;
    L90:
        if (r127 == true) goto L92;
        return false;
    L92:
        g49.d.d("DoraRouterInterceptor", "redirect native gesture settings to lynx page: " + r106);
        Uri r128 = r111.f267530d;
        Uri.Builder r129 = UriProtector.parse("sslocal://lynxview").buildUpon().appendQueryParameter("url", "https://lf-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/dora/client/resource/com_flow_dora_lynx/gesture-setting/template.js").appendQueryParameter(CJHostRouterServiceImpl.URI_KEY_USE_ANNIEX, "1").appendQueryParameter("should_full_screen", "1").appendQueryParameter("hide_nav_bar", "1").appendQueryParameter("bdhm_bid", "doubao_dora_lynx").appendQueryParameter("bdhm_pid", "gesture-setting");
        if (r128 == null) goto L97;
        String r130 = UriProtector.getQueryParameter(r128, "enter_method");
        if (r130 == null) goto L97;
        r129.appendQueryParameter("enter_method", r130);
    L97:
        if (r128 == null) goto L101;
        String r131 = UriProtector.getQueryParameter(r128, com.bytedance.android.ec.core.event.a.KEY_IS_FIRST);
        if (r131 == null) goto L101;
        r129.appendQueryParameter(com.bytedance.android.ec.core.event.a.KEY_IS_FIRST, r131);
    L101:
        com.bytedance.router.i r132 = SmartRouter.buildRoute(r110, r129.build().toString());
        r132.f267555d = R.anim.larus_router_slide_in_right;
        r132.f267556e = R.anim.larus_router_no_anim;
        r132.d();
        return true;
    L87:
        if (r126.f338026b.contains("gesture-setting") == true) goto L89;
    L88:
        r127 = true;
    L77:
        r124 = false;
        goto L78
    L104:
        if (CollectionsKt.contains(f331910f, r106) == false) goto L140;
        if (r106 != null) goto L107;
        r106 = "";
    L107:
        g49.d.d("DoraRouterInterceptor", "redirect lynx gesture detail schema to native page: ".concat(r106));
        switch(r106.hashCode()) {
            case -2094550538: goto L135;
            case -1839457990: goto L131;
            case -1408841169: goto L127;
            case -28863122: goto L123;
            case 61592680: goto L119;
            case 1847300477: goto L115;
            case 2030063255: goto L111;
            default: goto L138;
        };
    L138:
        return true;
    L111:
        if (r106.equals("//flow/dora/gesture_wakeup_right_setting") == false) goto L138;
        f(r110, 2);
        goto L138
    L115:
        if (r106.equals("//flow/dora/gesture_media_left_setting") == false) goto L138;
        e(r110, true, true);
        goto L138
    L119:
        if (r106.equals("//flow/dora/gesture_media_right_setting") == false) goto L138;
        e(r110, true, false);
        goto L138
    L123:
        if (r106.equals("//flow/dora/gesture_wakeup_left_setting") == false) goto L138;
        f(r110, 1);
        goto L138
    L127:
        if (r106.equals("//flow/dora/gesture_call_left_setting") == false) goto L138;
        e(r110, false, true);
        goto L138
    L131:
        if (r106.equals("//flow/dora/gesture_wakeup_setting") == false) goto L138;
        f(r110, 0);
        goto L138
    L135:
        if (r106.equals("//flow/dora/gesture_call_right_setting") == false) goto L138;
        e(r110, false, false);
        goto L138
    L140:
        if (AccountService.f365697a.isLogin().booleanValue() == true) goto L143;
        g49.d.e("DoraRouterInterceptor", "onInterceptRoute: account not login, " + r102);
        return true;
    L143:
        if (r102 == null) goto L169;
        switch(r102.hashCode()) {
            case -1645844070: goto L157;
            case -1418032906: goto L154;
            case -1222184209: goto L151;
            case 3343801: goto L148;
            default: goto L169;
        };
    L148:
        if (r102.equals(PullConfiguration.PROCESS_NAME_MAIN) == false) goto L169;
    L159:
        g49.d.d("DoraRouterInterceptor", "handleDoraRoute: ".concat(r102));
        if (Intrinsics.areEqual(r102, PullConfiguration.PROCESS_NAME_MAIN) == false) goto L166;
        IFlowSdkDepend r133 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r133 == null) goto L167;
        com.larus.home.impl.sdk.s r134 = r133.s0();
        if (r134 == null) goto L167;
        r134.N(null);
    L167:
        return true;
    L166:
        BuildersKt.launch$default((CoroutineScope) this.f331912a.getValue(), null, null, new DoraRouterInterceptor$handleDoraRoute$1(r102, this, r110, null), 3, null);
        goto L167
    L151:
        if (r102.equals("proactive_settings") == true) goto L159;
    L154:
        if (r102.equals("ai_lab") == false) goto L169;
    L157:
        if (r102.equals("general_settings") == true) goto L159;
    L169:
        if (CollectionsKt.contains(f331907c, r106) == false) goto L180;
        Intent r135 = r111.f267528b;
        if (r135 != null) goto L173;
    L175:
        boolean r136 = false;
    L176:
        if (r136 == false) goto L178;
        return false;
    L178:
        BuildersKt.launch$default((CoroutineScope) this.f331912a.getValue(), null, null, new DoraRouterInterceptor$handleEnvObserveRoute$1(r111, r110, null), 3, null);
        return true;
    L173:
        if (r135.getBooleanExtra("dora_router_interceptor_flag", false) != true) goto L175;
        r136 = true;
        goto L176
    L12:
        r105 = null;
        goto L13
    L8:
        r102 = null;
    L180:
        return false;
    }

    public static void e(Context r100, boolean r110, boolean r111) {
        if (r111 == false) goto L4;
        String r101 = r100.getString(R.string.larus_dora_gesture_double_click_left_cn);
    L5:
        Intrinsics.checkNotNull(r101);
        boolean r102 = true;
        if (r110 == false) goto L36;
        if (r111 == false) goto L9;
        GestureSettingsKey r112 = GestureSettingsKey.MEDIA_LEFT_DOUBLE_CLICK;
    L10:
        ArrayList r113 = CollectionsKt.arrayListOf(new OptionModel[]{new OptionModel(r100.getString(R.string.larus_dora_gesture_media_play_or_pause_cn), r112, (byte) 16), new OptionModel(r100.getString(R.string.larus_dora_gesture_media_previous_cn), r112, (byte) 19), new OptionModel(r100.getString(R.string.larus_dora_gesture_media_next_cn), r112, (byte) 20)});
        IDoraService r103 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r103 == null) goto L13;
        DeviceService r104 = r103.device();
    L14:
        if (r104 != null) goto L16;
    L18:
        boolean r105 = false;
    L19:
        if (r105 == false) goto L21;
        r113.add(new OptionModel(r100.getString(R.string.larus_dora_gesture_start_end_simul_interpret_cn), r112, (byte) 34));
    L21:
        if (r104 != null) goto L23;
    L25:
        boolean r106 = false;
    L26:
        if (r106 == false) goto L35;
        IObricDoraService r107 = (IObricDoraService) ServiceManager.get().getService(IObricDoraService.class);
        if (r107 != null) goto L30;
    L32:
        r102 = false;
    L33:
        if (r102 == true) goto L35;
        r113.add(new OptionModel(r100.getString(R.string.larus_dora_broadcast_tips_cn), r112, (byte) -1));
        goto L35
    L30:
        if (r107.t() != true) goto L32;
    L35:
        r113.add(new OptionModel(r100.getString(R.string.larus_dora_gesture_none_cn), r112, (byte) 0));
    L40:
        com.bytedance.router.i r108 = SmartRouter.buildRoute(r100, "//dora_options_activity");
        r108.f267554c.putExtra("options_title", r101);
        r108.f267554c.putExtra("options_data", r113);
        r108.f267555d = R.anim.larus_router_slide_in_right;
        r108.f267556e = R.anim.larus_router_no_anim;
        r108.d();
        return;
    L23:
        if (r104.q0(null) != true) goto L25;
        r106 = true;
        goto L26
    L16:
        if (r104.j0() != true) goto L18;
        r105 = true;
        goto L19
    L13:
        r104 = null;
        goto L14
    L9:
        r112 = GestureSettingsKey.MEDIA_RIGHT_DOUBLE_CLICK;
        goto L10
    L36:
        if (r111 == false) goto L38;
        GestureSettingsKey r114 = GestureSettingsKey.CALLING_LEFT_DOUBLE_CLICK;
    L39:
        r113 = CollectionsKt.arrayListOf(new OptionModel[]{new OptionModel(r100.getString(R.string.larus_dora_gesture_calling_hang_up_or_answer_cn), r114, (byte) 1), new OptionModel(r100.getString(R.string.larus_dora_gesture_calling_answer_cn), r114, (byte) 2), new OptionModel(r100.getString(R.string.larus_dora_gesture_calling_hang_up_cn), r114, (byte) 3), new OptionModel(r100.getString(R.string.larus_dora_gesture_none_cn), r114, (byte) 0)});
        goto L40
    L38:
        r114 = GestureSettingsKey.CALLING_RIGHT_DOUBLE_CLICK;
        goto L39
    L4:
        r101 = r100.getString(R.string.larus_dora_gesture_double_click_right_cn);
        goto L5
    }
}
