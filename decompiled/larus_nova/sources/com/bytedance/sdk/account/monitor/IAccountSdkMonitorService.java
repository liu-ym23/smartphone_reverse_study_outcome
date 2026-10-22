package com.bytedance.sdk.account.monitor;

import com.bytedance.news.common.service.manager.IService;
import java.util.Map;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\u001e\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&J\u001e\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\n\u001a\u00020\tH&¨\u0006\u000b"}, d2 = {"Lcom/bytedance/sdk/account/monitor/IAccountSdkMonitorService;", "Lcom/bytedance/news/common/service/manager/IService;", "Lzb7/a;", "", "", "event", "", "getMonitorCommonParams", "getOverrideCommonParams", "", "isDebug", "account-sdk-monitor_release"}, k = 1, mv = {1, 4, 0})
public interface IAccountSdkMonitorService extends IService, zb7.a {
    /* synthetic */ boolean ensureNotReachHere(Throwable r100, String r101, Map<String, String> r102);

    Map<String, Object> getMonitorCommonParams(String r100);

    Map<String, Object> getOverrideCommonParams(String r100);

    boolean isDebug();

    /* synthetic */ boolean onEvent(String r100, JSONObject r101);
}
