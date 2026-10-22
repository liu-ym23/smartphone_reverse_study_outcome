package g37;

import com.bytedance.ai.settings.IAISDKSettings$$Impl;
import com.bytedance.android.monitorV2.settings.IMonitorSettings$$Impl;
import com.bytedance.ies.bullet.settings.data.IBulletSettings$$Impl;
import com.bytedance.interaction.game.base.settings.model.IInteractiveSettings$$Impl;
import com.bytedance.news.common.settings.api.annotation.ISettings;
import com.bytedance.security.android.aopcheck.settings.MobiusAOPCheckSettings$$Impl;
import com.larus.common.location.impl.settings.LocationSettings$$Impl;
import com.larus.dora.impl.settings.IDoraSettings$$Impl;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeSettings$$Impl;
import com.larus.praise.settings.IPraiseSdkSettings$$Impl;
import com.larus.settings.btm.IBtmSettings$$Impl;
import com.larus.settings.btm.IEcomBcmSettings$$Impl;
import com.larus.settings.consent.IConsentSettings$$Impl;
import com.larus.settings.ivy.IHybridSettings$$Impl;
import com.larus.settings.ivy.lottieAdapter.ILottieAdapterSettings$$Impl;
import com.larus.settings.ivy.webView.IFlowWebViewSettings$$Impl;
import com.larus.settings.mainbot.IMainBotSettings$$Impl;
import com.larus.settings.performance.IPerfSettings$$Impl;
import com.larus.settings.protector.IProtectorSettings$$Impl;
import com.larus.settings.tutor.ITutorSettings$$Impl;
import com.larus.settings.value.INovaSetting$$Impl;
import com.larus.update.settings.IUpdateSdkSettings$$Impl;
import com.obric.assistant.IObricCloudSettings$$Impl;
import com.obric.miniapp.settings.IMiniAppSettings$$Impl;
import com.ss.android.ad.applinksdk.settings.AppLinkSettingsSelf$$Impl;

/* JADX INFO: loaded from: classes21.dex */
public final class e {
    public static ISettings a(String r100, final h37.f r101) {
        if ("com.bytedance.ai.settings.IAISDKSettings".equals(r100) == false) goto L7;
        return new IAISDKSettings$$Impl(r101);
    L7:
        if ("com.bytedance.android.monitorV2.settings.IMonitorSettings".equals(r100) == false) goto L11;
        return new IMonitorSettings$$Impl(r101);
    L11:
        if ("com.bytedance.ies.bullet.settings.data.IBulletSettings".equals(r100) == false) goto L15;
        return new IBulletSettings$$Impl(r101);
    L15:
        if ("com.bytedance.interaction.game.base.settings.model.IInteractiveSettings".equals(r100) == false) goto L19;
        return new IInteractiveSettings$$Impl(r101);
    L19:
        if ("com.bytedance.security.android.aopcheck.settings.MobiusAOPCheckSettings".equals(r100) == false) goto L23;
        return new MobiusAOPCheckSettings$$Impl(r101);
    L23:
        if ("com.ss.android.ad.applinksdk.settings.AppLinkSettingsSelf".equals(r100) == false) goto L27;
        return new AppLinkSettingsSelf$$Impl(r101);
    L27:
        if ("com.obric.assistant.IObricCloudSettings".equals(r100) == false) goto L31;
        return new IObricCloudSettings$$Impl(r101);
    L31:
        if ("com.obric.miniapp.settings.IMiniAppSettings".equals(r100) == false) goto L35;
        return new IMiniAppSettings$$Impl(r101);
    L35:
        if ("com.larus.praise.settings.IPraiseSdkSettings".equals(r100) == false) goto L39;
        return new IPraiseSdkSettings$$Impl(r101);
    L39:
        if ("com.larus.dora.impl.settings.IDoraSettings".equals(r100) == false) goto L43;
        return new IDoraSettings$$Impl(r101);
    L43:
        if ("com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeSettings".equals(r100) == false) goto L47;
        return new DoraObricDeviceHomeSettings$$Impl(r101);
    L47:
        if ("com.larus.update.settings.IUpdateSdkSettings".equals(r100) == false) goto L51;
        return new IUpdateSdkSettings$$Impl(r101);
    L51:
        if ("com.larus.common.location.impl.settings.LocationSettings".equals(r100) == false) goto L55;
        return new LocationSettings$$Impl(r101);
    L55:
        if ("com.larus.settings.btm.IBtmSettings".equals(r100) == false) goto L59;
        return new IBtmSettings$$Impl(r101);
    L59:
        if ("com.larus.settings.btm.IEcomBcmSettings".equals(r100) == false) goto L63;
        return new IEcomBcmSettings$$Impl(r101);
    L63:
        if ("com.larus.settings.consent.IConsentSettings".equals(r100) == false) goto L67;
        return new IConsentSettings$$Impl(r101);
    L67:
        if ("com.larus.settings.ivy.IHybridSettings".equals(r100) == false) goto L71;
        return new IHybridSettings$$Impl(r101);
    L71:
        if ("com.larus.settings.ivy.lottieAdapter.ILottieAdapterSettings".equals(r100) == false) goto L75;
        return new ILottieAdapterSettings$$Impl(r101);
    L75:
        if ("com.larus.settings.ivy.webView.IFlowWebViewSettings".equals(r100) == false) goto L79;
        return new IFlowWebViewSettings$$Impl(r101);
    L79:
        if ("com.larus.settings.mainbot.IMainBotSettings".equals(r100) == false) goto L83;
        return new IMainBotSettings$$Impl(r101);
    L83:
        if ("com.larus.settings.performance.IPerfSettings".equals(r100) == false) goto L87;
        return new IPerfSettings$$Impl(r101);
    L87:
        if ("com.larus.settings.protector.IProtectorSettings".equals(r100) == false) goto L91;
        return new IProtectorSettings$$Impl(r101);
    L91:
        if ("com.larus.settings.tutor.ITutorSettings".equals(r100) == false) goto L95;
        return new ITutorSettings$$Impl(r101);
    L95:
        if ("com.larus.settings.value.INovaSetting".equals(r100) == true) goto L97;
        return null;
    L97:
        return new INovaSetting$$Impl(r101);
    }
}
