package ok7;

import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.ug.sdk.luckydog.api.settings.ILuckyDogCommonSettingsService;
import com.bytedance.ug.sdk.luckydog.api.settings.commonsettings.api.ILuckyDogSettingsService;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
@XBridgeMethod(name = "luckycatRequestSettingsInfo", owner = "pengweitao")
public final class h extends XCoreBridgeMethod implements com.bytedance.sdk.xbridge.cn.protocol.h {
    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final String getName() {
        return "luckycatRequestSettingsInfo";
    }

    public h() {
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final void handle(XReadableMap r100, com.bytedance.ies.xbridge.XBridgeMethod.Callback r110, XBridgePlatformType r111) {
        com.bytedance.ies.xbridge.model.params.a.Companion.getClass();
        int r101 = com.bytedance.ies.xbridge.model.params.a.C3558a.a(r100, "settings_type");
        fk7.d r112 = fk7.c.b(ILuckyDogSettingsService.class);
        if ((r101 & 1) == 0) goto L8;
        if ((r112 instanceof ILuckyDogSettingsService) == false) goto L8;
        ((ILuckyDogSettingsService) r112).updateSettingIfNeededFromScene(ILuckyDogCommonSettingsService.Channel.STATIC, "fe_fetch");
    L8:
        if ((r101 & 2) == 0) goto L13;
        if ((r112 instanceof ILuckyDogSettingsService) == false) goto L13;
        ((ILuckyDogSettingsService) r112).updateSettingIfNeededFromScene(ILuckyDogCommonSettingsService.Channel.DYNAMIC, "fe_fetch");
    L13:
        if ((r101 & 4) != 0) goto L15;
    L17:
        XCoreBridgeMethod.onSuccess$default(this, r110, new HashMap(), null, 4, null);
        return;
    L15:
        if ((r112 instanceof ILuckyDogSettingsService) == false) goto L17;
        ((ILuckyDogSettingsService) r112).updateSettingIfNeededFromScene(ILuckyDogCommonSettingsService.Channel.POLL, "fe_fetch");
        goto L17
    }
}
