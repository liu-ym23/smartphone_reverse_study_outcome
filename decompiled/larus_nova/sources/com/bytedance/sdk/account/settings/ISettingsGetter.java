package com.bytedance.sdk.account.settings;

import com.bytedance.news.common.service.manager.IService;
import com.ss.texturerender.TextureRenderKeys;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/bytedance/sdk/account/settings/ISettingsGetter;", "Lcom/bytedance/news/common/service/manager/IService;", "getSettings", "Lorg/json/JSONObject;", TextureRenderKeys.KEY_MODULE_NAME, "", "account-sdk-settings_release"}, k = 1, mv = {1, 1, 15})
public interface ISettingsGetter extends IService {
    JSONObject getSettings(String r100);
}
