package com.bytedance.caijing.sdk.infra.base.api.container;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.webkit.WebView;
import cd4.f;
import cd4.i;
import cd4.j;
import cd4.o;
import com.bytedance.caijing.sdk.infra.base.core.di.ICJService;
import com.ss.android.lark.utils.statistics.PerfLog;
import hd4.a;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\u001c\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u00062\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J \u0010\u0010\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0006H\u0016J \u0010\u0016\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0006H\u0016J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0017H&J(\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\t\u001a\u00020\u00192\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\u0010\u0010!\u001a\u00020 2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J&\u0010$\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\u00062\u0014\u0010\u001d\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010 \u0012\u0004\u0012\u00020\u001e0#H\u0016J&\u0010%\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\u00062\u0014\u0010\u001d\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010 \u0012\u0004\u0012\u00020\u001e0#H\u0016J\n\u0010'\u001a\u0004\u0018\u00010&H&J\n\u0010)\u001a\u0004\u0018\u00010(H\u0016J\u0012\u0010-\u001a\u0004\u0018\u00010,2\u0006\u0010+\u001a\u00020*H\u0016J,\u00102\u001a\u00020\n2\b\u0010.\u001a\u0004\u0018\u00010\u00042\b\u0010/\u001a\u0004\u0018\u00010\u00062\u000e\u00101\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u000100H\u0016J\u0012\u00104\u001a\u00020\n2\b\u00103\u001a\u0004\u0018\u00010\u0013H\u0016¨\u00065"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/api/container/IContainerHostDepend;", "Lcom/bytedance/caijing/sdk/infra/base/core/di/ICJService;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/webkit/WebView;", "webView", "", "getHostUA", "getCJPayH5ExtraUAInfo", "schema", "", "openSchema", "Landroid/app/Activity;", "activity", "Lhd4/a;", "btmInfo", "appendSourceBtmTokenToSchema", "key", "biz", "", "getStorageItem", "data", "setStorageItem", "Lcom/bytedance/caijing/sdk/infra/base/api/container/ILivePluginHelper;", "getLivePluginHelper", "Landroid/net/Uri;", "", "cacheTime", "Lcd4/f;", "callback", "", "preRender", "Lorg/json/JSONObject;", "getH5Perfermance", "eventName", "Lkotlin/Function1;", "registerSpecificEventListener", "unregisterSpecificEventListener", "Lcd4/o;", "getPolarisHelper", "Lcd4/i;", "getBulletHelper", "Lod4/a;", "cjJSWorkerModel", "Lcd4/j;", "getHostJSWorker", "view", "url", "Lkotlin/Function0;", "onOverride", "shouldOverrideUrlLoading", "contextProviderFactory", "closeAnnieXLive", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0})
public interface IContainerHostDepend extends ICJService {
    String appendSourceBtmTokenToSchema(Activity r100, String r101, a r102);

    boolean closeAnnieXLive(Object r100);

    i getBulletHelper();

    String getCJPayH5ExtraUAInfo();

    JSONObject getH5Perfermance(WebView r100);

    j getHostJSWorker(od4.a r100);

    String getHostUA(Context r100, WebView r101);

    ILivePluginHelper getLivePluginHelper();

    o getPolarisHelper();

    Object getStorageItem(String r100, String r101);

    boolean openSchema(String r100, Context r101);

    void preRender(Uri r100, Context r101, long r102, f r103);

    void registerSpecificEventListener(String r100, Function1<? super JSONObject, Unit> r101);

    boolean setStorageItem(String r100, Object r101, String r102);

    boolean shouldOverrideUrlLoading(WebView r100, String r101, Function0<Unit> r102);

    void unregisterSpecificEventListener(String r100, Function1<? super JSONObject, Unit> r101);
}
