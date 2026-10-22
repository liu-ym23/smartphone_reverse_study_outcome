package com.bytedance.sdk.account.settings;

import android.util.EventsUtils;
import com.bytedance.news.common.service.manager.IService;
import kotlin.Metadata;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/bytedance/sdk/account/settings/ISettingsGetter;", "Lcom/bytedance/news/common/service/manager/IService;", "getSettings", "Lorg/json/JSONObject;", "moduleName", XmlPullParser.NO_NAMESPACE, "account-sdk-settings_release"}, k = 1, mv = {1, 1, EventsUtils.FEAT_TYPE_PERF_APP_USAGE})
public interface ISettingsGetter extends IService {
    JSONObject getSettings(String r1);
}
