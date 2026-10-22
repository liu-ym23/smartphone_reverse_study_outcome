package com.bytedance.ies.android.base.runtime.depend;

import android.content.Context;
import android.os.Bundle;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
@Deprecated(message = "已废弃", replaceWith = @ReplaceWith(expression = "广告埋点使用com.bytedance.android.ad.sdk.api.IAdEventDepend，非广告埋点使用com.bytedance.android.ad.sdk.api.applog.IAppLogDepend", imports = {}))
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\rH\u0016JJ\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H&J\u001a\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH&J\u001a\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0018H&J(\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\n2\u0016\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010!H&J&\u0010\"\u001a\u00020\u00032\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0!2\b\b\u0002\u0010\u0007\u001a\u00020\bH&¨\u0006$"}, d2 = {"Lcom/bytedance/ies/android/base/runtime/depend/IAppLogDepend;", "", "appendCommonParams", "", "strBuilder", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "isApi", "", "getCategory", "", "isEventV3", "getLogThreadPool", "Ljava/util/concurrent/ExecutorService;", "onEventV1", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "tag", "category", "label", "value", "ext_value", "", "ext_json", "Lorg/json/JSONObject;", "onEventV3Bundle", "eventName", "bundle", "Landroid/os/Bundle;", "onEventV3Json", "logJson", "onEventV3Map", "map", "", "putCommonParams", "params", "runtime-api_release"}, k = 1, mv = {1, 1, 16})
public interface IAppLogDepend {
    void appendCommonParams(StringBuilder r100, boolean r101);

    String getCategory(boolean r100);

    ExecutorService getLogThreadPool();

    void onEventV1(Context r100, String r101, String r102, String r103, String r104, long r105, JSONObject r106);

    void onEventV3Bundle(String r100, Bundle r101);

    void onEventV3Json(String r100, JSONObject r101);

    void onEventV3Map(String r100, Map<String, String> r101);

    void putCommonParams(Map<String, String> r100, boolean r101);
}
