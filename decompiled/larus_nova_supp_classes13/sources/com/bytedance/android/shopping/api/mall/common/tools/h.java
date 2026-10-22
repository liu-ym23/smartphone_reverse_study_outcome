package com.bytedance.android.shopping.api.mall.common.tools;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.hybrid.data.entity.ECHybridLynxPreDecodeConfigDTO;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ecom.service_annotation.ReturnSubService;
import io.reactivex.Observable;
import java.util.HashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class h implements IHybridHostService {
    public static final h b = null;
    public final /* synthetic */ IHybridHostService a;

    @ReturnSubService
    public final yj.p IHybridHostRouterService() {
        return this.a.IHybridHostRouterService();
    }

    public final Map<String, Long> addABSearchTimeMills(String r2) {
        Intrinsics.checkNotNullParameter(r2, "stage");
        return this.a.addABSearchTimeMills(r2);
    }

    public final Object addLiveFloatManagerListener(yj.y r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        return this.a.addLiveFloatManagerListener(r2);
    }

    public final void attachDropFrameMonitorTo(String r2, RecyclerView r3) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r3, "recyclerView");
        this.a.attachDropFrameMonitorTo(r2, r3);
    }

    public final boolean enableJsbAsync() {
        return this.a.enableJsbAsync();
    }

    public final void ensureNotReachHere(String r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        this.a.ensureNotReachHere(r2);
    }

    public final boolean forbidMallLoadInAbSchema() {
        return this.a.forbidMallLoadInAbSchema();
    }

    public final t07.a geIlynxKitService() {
        return this.a.geIlynxKitService();
    }

    public final Observable<Boolean> getAppBackgroundStateObservable() {
        return this.a.getAppBackgroundStateObservable();
    }

    @ReturnSubService
    public final yj.x getECPluginService() {
        return this.a.getECPluginService();
    }

    public final yj.g getHostAB() {
        return this.a.getHostAB();
    }

    public final <T> T getHostABValue(String r2, T r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "defaultValue");
        return (T) this.a.getHostABValue(r2, r3);
    }

    public final yj.f getHybridECSdkService() {
        return this.a.getHybridECSdkService();
    }

    public final yj.t getHybridLynxHostService() {
        return this.a.getHybridLynxHostService();
    }

    public final yj.c getIECVideoPreloadManager() {
        this.a.getIECVideoPreloadManager();
        return null;
    }

    @ReturnSubService
    public final yj.h getIHybridHostALogService() {
        return this.a.getIHybridHostALogService();
    }

    @ReturnSubService
    public final yj.i getIHybridHostAppInfo() {
        return this.a.getIHybridHostAppInfo();
    }

    @ReturnSubService
    public final yj.j getIHybridHostECSchemaMonitorService() {
        this.a.getIHybridHostECSchemaMonitorService();
        return null;
    }

    @ReturnSubService
    public final yj.k getIHybridHostEventService() {
        return this.a.getIHybridHostEventService();
    }

    @ReturnSubService
    public final yj.l getIHybridHostFrescoService() {
        return this.a.getIHybridHostFrescoService();
    }

    @ReturnSubService
    public final yj.m getIHybridHostKVService() {
        this.a.getIHybridHostKVService();
        return null;
    }

    @ReturnSubService
    public final yj.n getIHybridHostNetService() {
        return this.a.getIHybridHostNetService();
    }

    @ReturnSubService
    public final yj.r getIHybridHostUIService() {
        return this.a.getIHybridHostUIService();
    }

    @ReturnSubService
    public final yj.s getIHybridHostUserService() {
        return this.a.getIHybridHostUserService();
    }

    @ReturnSubService
    public final yj.u getIHybridPluginService() {
        return this.a.getIHybridPluginService();
    }

    public final Integer getLocationPermissionParam() {
        return this.a.getLocationPermissionParam();
    }

    public final View getLoginGuideView(Context r2, Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "clickListener");
        return this.a.getLoginGuideView(r2, r3);
    }

    public final Map<Integer, ECHybridLynxPreDecodeConfigDTO> getLynxCardPreDecodeData() {
        return this.a.getLynxCardPreDecodeData();
    }

    @ReturnSubService
    public final yj.w getMallOptService() {
        this.a.getMallOptService();
        return null;
    }

    @ReturnSubService
    public final yj.v getMallScrollService() {
        this.a.getMallScrollService();
        return null;
    }

    public final Boolean getRecommendStatus() {
        return this.a.getRecommendStatus();
    }

    public final yj.q getServiceProvider() {
        return this.a.getServiceProvider();
    }

    public final boolean getStorageTheme(String r2) {
        Intrinsics.checkNotNullParameter(r2, "pageName");
        return this.a.getStorageTheme(r2);
    }

    public final yj.e gylLoadMoreContainer(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        return this.a.gylLoadMoreContainer(r2);
    }

    public final void installDesktopApp(String r2, String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "sceneName");
        Intrinsics.checkNotNullParameter(r3, "enterFrom");
        Intrinsics.checkNotNullParameter(r4, "guideStyleType");
        Intrinsics.checkNotNullParameter(r5, "needLoading");
        this.a.installDesktopApp(r2, r3, r4, r5);
    }

    public final boolean isFoldDevice() {
        return this.a.isFoldDevice();
    }

    public final boolean isInMallTab(Activity r2) {
        return this.a.isInMallTab(r2);
    }

    public final boolean isInnerPushShowing() {
        return this.a.isInnerPushShowing();
    }

    public final boolean isLargeDevice() {
        return this.a.isLargeDevice();
    }

    public final boolean isMallTopTabSupported() {
        return this.a.isMallTopTabSupported();
    }

    public final boolean isPadDevice() {
        return this.a.isPadDevice();
    }

    public final boolean isSearchNewAbSchema(String r2) {
        return this.a.isSearchNewAbSchema(r2);
    }

    public final boolean isShowingFloatLive() {
        return this.a.isShowingFloatLive();
    }

    public final boolean liveSdkInitFinished() {
        return this.a.liveSdkInitFinished();
    }

    public final boolean needCheckLoginState() {
        return this.a.needCheckLoginState();
    }

    public final void notifyPreloadDeepFeedSlc() {
        this.a.notifyPreloadDeepFeedSlc();
    }

    public final void preloadFloatLive(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        this.a.preloadFloatLive(r2);
    }

    public final void recordPerformanceTimestamp(String r2) {
        this.a.recordPerformanceTimestamp(r2);
    }

    public final void refreshTabTheme(String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "pageName");
        this.a.refreshTabTheme(r2, r3);
    }

    public final void removeLiveFloatManagerListener(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.a.removeLiveFloatManagerListener(r2);
    }

    public final void reportThreadPoolInfo(JSONObject r2) {
        this.a.reportThreadPoolInfo(r2);
    }

    public final boolean resumeMallAfterFinish() {
        return this.a.resumeMallAfterFinish();
    }

    public final void showOrHideFloatLive(boolean r13, Fragment r14, FrameLayout r15, String r16, long r17, boolean r19, HashMap<String, String> r20, RelativeLayout.LayoutParams r21, boolean r22) {
        Intrinsics.checkNotNullParameter(r14, "fragment");
        Intrinsics.checkNotNullParameter(r15, "rootView");
        this.a.showOrHideFloatLive(r13, r14, r15, r16, r17, r19, r20, r21, r22);
    }

    public final void toggleLiveAudio(boolean r2) {
        this.a.toggleLiveAudio(r2);
    }

    public final void ttWebWarmUpAsync(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a.ttWebWarmUpAsync(r2);
    }

    public final void updateBadgeStyle(boolean r2) {
        this.a.updateBadgeStyle(r2);
    }

    public final void updateThemeStorage(Context r2, String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "pageName");
        this.a.updateThemeStorage(r2, r3, r4);
    }

    static {
        b = new h();
    }

    public h() {
        IHybridHostService r0 = com.bytedance.android.ec.hybrid.a.h();
        Intrinsics.checkNotNull(r0);
        this.a = r0;
    }
}
