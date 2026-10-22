package com.bytedance.sdk.account.settings;

import com.bytedance.sdk.account.impl.z;
import com.ss.android.account.k;
import com.ss.texturerender.TextureRenderKeys;
import kotlin.Metadata;
import org.json.JSONObject;
import wqa.f;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/bytedance/sdk/account/settings/SettingsGetterImpl;", "Lcom/bytedance/sdk/account/settings/ISettingsGetter;", "()V", "getSettings", "Lorg/json/JSONObject;", TextureRenderKeys.KEY_MODULE_NAME, "", "account-sdk-core_release"}, k = 1, mv = {1, 1, 15})
public final class SettingsGetterImpl implements ISettingsGetter {
    public SettingsGetterImpl() {
    }

    @Override // com.bytedance.sdk.account.settings.ISettingsGetter
    public JSONObject getSettings(String r100) {
        f r101 = k.f406318b;
        if (r101 == null) goto L8;
        JSONObject r102 = z.a(r101.getApplicationContext()).getAccountSettingsConfig();
        if (r102 != null) goto L7;
        return null;
    L7:
        return r102.optJSONObject(r100);
    L8:
        return null;
    }
}
