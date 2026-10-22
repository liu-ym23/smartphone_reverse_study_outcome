package com.bytedance.bdp.appbase.settings;

import com.bytedance.android.livesdkapi.LiveCommonConstants;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
@Deprecated(message = "jiangling: 后续会干掉，请求时参数比miniapp/minigame的少，导致settings不完整")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0007J\b\u0010\r\u001a\u00020\u000eH\u0007J\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0004H\u0007J\b\u0010\u0010\u001a\u00020\u0011H\u0007J\u001e\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0004H\u0016J(\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\fH\u0016J \u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001cH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u001e"}, d2 = {"Lcom/bytedance/bdp/appbase/settings/BdpInnerSettingsHelper;", "Lcom/bytedance/bdp/appbase/settings/IAppSettingsHandler;", "()V", "TAG", "", "mBdpSettings", "Lcom/bytedance/bdp/appbase/settings/BdpAppSettings;", "getMBdpSettings", "()Lcom/bytedance/bdp/appbase/settings/BdpAppSettings;", "mBdpSettings$delegate", "Lkotlin/Lazy;", "getSettingTime", "", "getSettings", "Lorg/json/JSONObject;", "key", LiveCommonConstants.REASON_ON_DEDTROY, "", "onQueryParams", "", "bdpAppId", "onUpdateSettings", "oldSettings", "newSettings", "from", "settingTime", "updateSettings", "force", "", "isAuto", "bdp-infrastructure_release"}, k = 1, mv = {1, 1, 18})
public final class BdpInnerSettingsHelper implements IAppSettingsHandler {
    public static final BdpInnerSettingsHelper INSTANCE = null;
    private static final String TAG = "BdpInnerSettingsHelper";
    private static final Lazy mBdpSettings$delegate = null;

    private BdpInnerSettingsHelper() {
    }

    private final BdpAppSettings getMBdpSettings() {
        return (BdpAppSettings) mBdpSettings$delegate.getValue();
    }

    @Override // com.bytedance.bdp.appbase.settings.IAppSettingsHandler
    public Map<String, String> onQueryParams(String r100) {
        return null;
    }

    @Override // com.bytedance.bdp.appbase.settings.IAppSettingsHandler
    public void onUpdateSettings(JSONObject r100, JSONObject r101, String r102, long r103) {
    }

    static {
        INSTANCE = new BdpInnerSettingsHelper();
        mBdpSettings$delegate = LazyKt.lazy(BdpInnerSettingsHelper$mBdpSettings$2.INSTANCE);
    }

    @JvmStatic
    public static final long getSettingTime() {
        return INSTANCE.getMBdpSettings().getSettingsTime();
    }

    @JvmStatic
    public static final JSONObject getSettings() {
        return INSTANCE.getMBdpSettings().getSettings();
    }

    @JvmStatic
    public static final void onDestroy() {
        INSTANCE.getMBdpSettings().onDestroy();
    }

    @JvmStatic
    public static final JSONObject getSettings(String r100) {
        return INSTANCE.getMBdpSettings().getSettings(r100);
    }

    @JvmStatic
    public static final void updateSettings(String r100, boolean r101, boolean r102) {
        g94.b.d(TAG, new Object[]{"updateSettings", r100, Boolean.valueOf(r102)});
        INSTANCE.getMBdpSettings().updateSettings(r101, r100, r102);
    }
}
