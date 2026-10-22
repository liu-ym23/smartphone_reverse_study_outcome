package com.ss.android.ugc.aweme.search.hostapi;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.trade.host.api.search.b;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.ec.search.common.CommerceBaseResponse;
import com.ss.android.ugc.aweme.search.model.SearchEnterParam;
import com.ss.texturerender.TextureRenderKeys;
import dm3.a;
import em3.c;
import em3.d;
import em3.e;
import io.reactivex.Observable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bg\u0018\u00002\u00020\u0001J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0006\u001a\u00020\u0005H&J\n\u0010\b\u001a\u0004\u0018\u00010\u0007H&J\n\u0010\n\u001a\u0004\u0018\u00010\tH&J\n\u0010\u000b\u001a\u0004\u0018\u00010\u0007H&J\u0010\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\fH&J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH&J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0012\u001a\u00020\u0007H&J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0014H&J2\u0010\u001d\u001a\u00020\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u0002H&J\"\u0010 \u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0016\u001a\u00020\u00012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H&J\"\u0010'\u001a\u00020\u00102\b\u0010\"\u001a\u0004\u0018\u00010!2\u0006\u0010$\u001a\u00020#2\u0006\u0010&\u001a\u00020%H&J\u001a\u0010*\u001a\u0004\u0018\u00010\u00172\u0006\u0010(\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u0019H&J\u0011\u0010+\u001a\u0004\u0018\u00010\u0019H&¢\u0006\u0004\b+\u0010,J$\u0010.\u001a\u00020\u00102\b\u0010\"\u001a\u0004\u0018\u00010!2\b\u0010-\u001a\u0004\u0018\u00010\u00012\u0006\u0010)\u001a\u00020\u0019H&J\n\u00100\u001a\u0004\u0018\u00010/H\u0016J\u0012\u00101\u001a\u00020\u00102\b\u0010\"\u001a\u0004\u0018\u00010\u0007H&J\u0012\u00103\u001a\u00020\u00172\b\u00102\u001a\u0004\u0018\u00010\u0017H&J\b\u00104\u001a\u00020\u0017H&J\b\u00105\u001a\u00020\u0017H&J \u0010:\u001a\u00020\u00102\u0006\u00106\u001a\u00020\t2\u0006\u00107\u001a\u00020\u00172\u0006\u00109\u001a\u000208H\u0016J4\u0010@\u001a\u00020\u00102\b\u0010\"\u001a\u0004\u0018\u00010\u00072\u0006\u0010;\u001a\u00020\u00012\u0006\u0010<\u001a\u00020\u00172\b\u0010&\u001a\u0004\u0018\u00010=2\u0006\u0010?\u001a\u00020>H&J\n\u0010B\u001a\u0004\u0018\u00010AH\u0016J\u0010\u0010E\u001a\u00020\u00102\u0006\u0010D\u001a\u00020CH\u0016J\u0011\u0010G\u001a\u0004\u0018\u00010FH&¢\u0006\u0004\bG\u0010HJ\u0011\u0010I\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\bI\u0010,J\u0011\u0010J\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\bJ\u0010,J\b\u0010K\u001a\u00020\u0019H\u0016JJ\u0010S\u001a\u0014\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020R0Q\u0018\u00010P2\u0006\u0010L\u001a\u00020\u00192\u0012\u0010N\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010M2\u0012\u0010O\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00170MH\u0016J\u001a\u0010W\u001a\u00020\u00102\u0006\u0010T\u001a\u00020\u00012\b\u0010V\u001a\u0004\u0018\u00010UH&J \u0010Z\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010X\u001a\u00020\u00052\u0006\u0010Y\u001a\u00020\u0017H\u0016J\b\u0010[\u001a\u00020\u0005H&J\u001a\u0010]\u001a\u00020\u00102\b\u0010\"\u001a\u0004\u0018\u00010\u00072\u0006\u0010\\\u001a\u00020\u0017H&¨\u0006^"}, d2 = {"Lcom/ss/android/ugc/aweme/search/hostapi/ITradeSearchHostAbility;", "", "", "getServerTime", "()Ljava/lang/Long;", "", "getSaaSAsyncRenderFixValue", "Landroid/app/Activity;", "getTopActivity", "Landroid/content/Context;", "getApplicationContext", "getCurrentActivity", "", "getActivityStack", "Lcom/bytedance/android/trade/host/api/search/b;", "callback", "", "getMallOrderEntranceSchema", "curActivity", "getPreviousActivity", "Ldm3/a;", "getNetworkStateManager", "awemeInfo", "", LocationMonitorConst.IDENTIFIER, "", "pause", "eventType", "startPlayTime", "syncDetailPlayer", "Landroid/os/Bundle;", "bundle", "buildSharePlayerParams", "Landroidx/fragment/app/FragmentActivity;", "activity", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lcom/bytedance/android/trade/host/api/search/a;", "listener", "registerBackEvent", "pageHashCode", "isAdd", "syncSessionId", "isGuestMode", "()Ljava/lang/Boolean;", "searchEnterParam", "syncSearchEnterParam", "Lcom/ss/android/ugc/aweme/search/model/SearchEnterParam;", "getCurSearchEnterParam", "markCurSearchPage", "requestId", "getHostLogPb", "getCurrentSkinName", "getBulletVersion", PerfLog.PARAM_KEY_CONTEXT_ID, "scheme", "Lorg/json/JSONObject;", "params", "preloadPdpFull", "certification", "enterFrom", "Lem3/d;", "Lem3/c;", "config", "noStandardRequestPermission", "Lcom/ss/android/ugc/aweme/search/hostapi/ITradeSearchHostABService;", "getHostAB", "Landroid/content/res/AssetManager;", "assetManager", "supportAssetManager", "", "getDeviceScore", "()Ljava/lang/Float;", "disableResContext", "disableChunkRefresh", "isAIInputDelayAttachEnabled", "isPrefetch", "", "fieldMap", "headers", "Lio/reactivex/Observable;", "Lcom/bytedance/android/chunkstreamprediction/network/b;", "Lcom/ss/android/ugc/aweme/ec/search/common/CommerceBaseResponse;", "performObservableChunkRequest", TextureRenderKeys.KEY_IS_CERT, "Lem3/e;", "locationCallback", "tryToLocate", "pageAction", "pageId", "checkLoginWhenViewStatusChange", "getHomePageMallSource", "requestFrom", "startShowFloatInNextLifecycle", "trade-search-api_release"}, k = 1, mv = {1, 4, 3})
public interface ITradeSearchHostAbility {
    void buildSharePlayerParams(Bundle r100, Object r101, String r102);

    void checkLoginWhenViewStatusChange(Activity r100, int r101, String r102);

    Boolean disableChunkRefresh();

    Boolean disableResContext();

    List<Activity> getActivityStack();

    Context getApplicationContext();

    String getBulletVersion();

    SearchEnterParam getCurSearchEnterParam();

    Activity getCurrentActivity();

    String getCurrentSkinName();

    Float getDeviceScore();

    int getHomePageMallSource();

    ITradeSearchHostABService getHostAB();

    String getHostLogPb(String r100);

    void getMallOrderEntranceSchema(b r100);

    a getNetworkStateManager();

    Activity getPreviousActivity(Activity r100);

    int getSaaSAsyncRenderFixValue();

    Long getServerTime();

    Activity getTopActivity();

    boolean isAIInputDelayAttachEnabled();

    Boolean isGuestMode();

    void markCurSearchPage(Activity r100);

    void noStandardRequestPermission(Activity r100, Object r101, String r102, d r103, c r104);

    Observable<? extends com.bytedance.android.chunkstreamprediction.network.b<? extends CommerceBaseResponse>> performObservableChunkRequest(boolean r100, Map<String, ? extends Object> r101, Map<String, String> r102);

    void preloadPdpFull(Context r100, String r101, JSONObject r102);

    void registerBackEvent(FragmentActivity r100, LifecycleOwner r101, com.bytedance.android.trade.host.api.search.a r102);

    void startShowFloatInNextLifecycle(Activity r100, String r101);

    void supportAssetManager(AssetManager r100);

    void syncDetailPlayer(Object r100, String r101, boolean r102, String r103, long r104);

    void syncSearchEnterParam(FragmentActivity r100, Object r101, boolean r102);

    String syncSessionId(int r100, boolean r101);

    void tryToLocate(Object r100, e r101);
}
