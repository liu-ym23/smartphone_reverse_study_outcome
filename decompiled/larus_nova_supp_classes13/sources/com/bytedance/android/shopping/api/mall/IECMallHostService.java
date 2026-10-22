package com.bytedance.android.shopping.api.mall;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.bytedance.android.ec.hybrid.list.ability.a0;
import com.bytedance.android.shopping.api.mall.idl.MallBigScreenConfigModel;
import com.bytedance.forest.model.PreloadType;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001:\u00019J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J<\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\rH&J\b\u0010\u0011\u001a\u00020\u0004H&J\u0016\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012H'J \u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00122\u0006\u0010\u0014\u001a\u00020\u0006H'J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H&J\b\u0010\u0019\u001a\u00020\u0004H&J\u0016\u0010\u001c\u001a\u00020\u00042\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u001aH&J&\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00122\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u0006H&J\u0012\u0010#\u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020!H'J$\u0010)\u001a\u0004\u0018\u00010(2\u0006\u0010\b\u001a\u00020\u00062\b\u0010%\u001a\u0004\u0018\u00010$2\u0006\u0010'\u001a\u00020&H&J*\u0010-\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\r2\u0006\u0010+\u001a\u00020\r2\b\u0010,\u001a\u0004\u0018\u00010\u0006H&J\u0010\u0010.\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u0006H&J\u0018\u00103\u001a\u00020\u000b2\u0006\u00100\u001a\u00020/2\u0006\u00102\u001a\u000201H\u0016J\u0018\u00104\u001a\u00020\u000b2\u0006\u00100\u001a\u00020/2\u0006\u00102\u001a\u000201H\u0016J\n\u00106\u001a\u0004\u0018\u000105H&J\b\u00107\u001a\u00020\rH&J\u0010\u00108\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006:"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/IECMallHostService;", "", "Lcom/bytedance/android/shopping/api/mall/IECMallHostService$a;", "listener", "", "registerGeckoChangedListener", "", "url", "scene", "Lcom/bytedance/forest/model/PreloadType;", "preloadType", "", "maxAge", "", "asyncEnable", "useProcessor", "preloadResourceWithForest", "clearPendingPreloadTasks", "", "getAppBootMetrics", "apiKey", "getExtraRequestParams", "", "time", "onPrefetchTaskStart", "ensureLynxAvailable", "Lkotlin/Function0;", "bstAction", "safeRunBstAction", "Landroid/content/Context;", "context", "pageName", "getMallBigScreenAdapterParams", "Ly93/a;", "firstScreenAnalyseBean", "updateFirstScreenAnalyseBeanWithHost", "Lcom/bytedance/android/ec/hybrid/list/ECHybridListEngine;", "listEngine", "Landroidx/lifecycle/Lifecycle;", "lifecycle", "Lcom/bytedance/android/ec/hybrid/list/ability/a0;", "getLiveStatusAbility", "isInitialize", "isShow", "sceneId", "updateMallFeedScene", "containCurrentPage", "Landroid/app/Activity;", "activity", "Landroid/content/res/Configuration;", "newConfig", "getMallAdapterScreenWidth", "getMallAdapterScreenHeight", "Lcom/bytedance/android/shopping/api/mall/idl/MallBigScreenConfigModel;", "getBigScreenConfig", "hitSplitScreenAndFoldOpen", "preloadDeepFeedSchema", "a", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IECMallHostService {

    public interface a {
    }

    void clearPendingPreloadTasks();

    boolean containCurrentPage(String r1);

    void ensureLynxAvailable();

    Map<String, Object> getAppBootMetrics();

    MallBigScreenConfigModel getBigScreenConfig();

    Map<String, Object> getExtraRequestParams(String r1);

    a0 getLiveStatusAbility(String r1, ECHybridListEngine r2, Lifecycle r3);

    int getMallAdapterScreenHeight(Activity r1, Configuration r2);

    int getMallAdapterScreenWidth(Activity r1, Configuration r2);

    Map<String, Object> getMallBigScreenAdapterParams(Context r1, String r2);

    boolean hitSplitScreenAndFoldOpen();

    void onPrefetchTaskStart(long r1);

    void preloadDeepFeedSchema(String r1);

    void preloadResourceWithForest(String r1, String r2, PreloadType r3, int r4, boolean r5, boolean r6);

    void registerGeckoChangedListener(a r1);

    void safeRunBstAction(Function0<Unit> r1);

    y93.a updateFirstScreenAnalyseBeanWithHost(y93.a r1);

    void updateMallFeedScene(String r1, boolean r2, boolean r3, String r4);
}
