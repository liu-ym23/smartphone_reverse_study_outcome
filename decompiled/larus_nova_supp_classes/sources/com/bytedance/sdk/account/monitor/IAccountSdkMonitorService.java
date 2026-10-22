package com.bytedance.sdk.account.monitor;

import com.bytedance.news.common.service.manager.IService;
import java.util.Map;
import kotlin.Metadata;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import zb7.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\u001e\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&J\u001e\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\n\u001a\u00020\tH&¨\u0006\u000b"}, d2 = {"Lcom/bytedance/sdk/account/monitor/IAccountSdkMonitorService;", "Lcom/bytedance/news/common/service/manager/IService;", "Lzb7/a;", XmlPullParser.NO_NAMESPACE, XmlPullParser.NO_NAMESPACE, "event", XmlPullParser.NO_NAMESPACE, "getMonitorCommonParams", "getOverrideCommonParams", XmlPullParser.NO_NAMESPACE, "isDebug", "account-sdk-monitor_release"}, k = 1, mv = {1, 4, 0})
public interface IAccountSdkMonitorService extends IService, a {
    /* synthetic */ boolean ensureNotReachHere(Throwable r1, String r2, Map<String, String> r3);

    Map<String, Object> getMonitorCommonParams(String r1);

    Map<String, Object> getOverrideCommonParams(String r1);

    boolean isDebug();

    @Override // zb7.a
    /* synthetic */ boolean onEvent(String r1, JSONObject r2);
}
