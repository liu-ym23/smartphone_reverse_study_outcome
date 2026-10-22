package com.bytedance.caijing.sdk.infra.base.api.hybridkit;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.android.ttcjpaysdk.container.base.lifecycle.ILifecycleEngine;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.caijing.sdk.infra.base.core.di.ICJService;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import org.json.JSONObject;
import xd4.a;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J:\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH&J$\u0010\u0012\u001a\u00020\u00112\u001a\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rj\n\u0012\u0004\u0012\u00020\u000e\u0018\u0001`\u000fH&JL\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u0013\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0005\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00022\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u00062\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0006H&J\u0010\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u0002H&J\b\u0010\u001c\u001a\u00020\u000bH&J\u0010\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u0002H&J\u0018\u0010\"\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010!\u001a\u00020 H&J\b\u0010#\u001a\u00020\u0002H&J\b\u0010$\u001a\u00020\u000bH&¨\u0006%"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/api/hybridkit/HybridKitHostService;", "Lcom/bytedance/caijing/sdk/infra/base/core/di/ICJService;", "", "jsbName", "Landroid/app/Activity;", PerfLog.PARAM_KEY_CONTEXT_ID, "", "", "param", "Lxd4/a;", "callBack", "", "callNative", "Ljava/util/ArrayList;", "Lcom/android/ttcjpaysdk/container/base/lifecycle/ILifecycleEngine;", "Lkotlin/collections/ArrayList;", NewBroadcastMonitor.STAGE.LIFECYCLE, "", "initEngine", "engineContext", "Landroid/content/Context;", "scheme", "globalProps", "header", "Landroid/view/View;", "getView", BaseHttpRequestInfo.KEY_USER_AGENT, "initUA", "load", "url", "loadUrl", "name", "Lorg/json/JSONObject;", "data", "sendJsEvent", "getContainerId", "release", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0})
public interface HybridKitHostService extends ICJService {
    void callNative(String r100, Activity r101, Map<String, ? extends Object> r102, a r103);

    String getContainerId();

    View getView(Object r100, Context r101, String r102, Map<String, ? extends Object> r103, Map<String, String> r104);

    boolean initEngine(ArrayList<ILifecycleEngine> r100);

    void initUA(String r100);

    void load();

    void loadUrl(String r100);

    void release();

    void sendJsEvent(String r100, JSONObject r101);
}
