package com.bytedance.android.livesdk.liveinit.community;

import com.bytedance.android.live.broadcast.BroadcastInitService;
import com.bytedance.android.live.broadcast.api.scope.global.IBroadcastInitService;
import com.bytedance.android.live.plugin_api.LivePluginSPIManager;
import com.bytedance.android.live.pushstream.IPushStreamService;
import com.bytedance.android.livesdk.init.AbsLiveInitUnit;
import com.bytedance.android.livesdk.init.LiveInitPoint;
import com.bytedance.android.livesdk.init.LiveInitUnitKey;
import com.bytedance.android.livesdkapi.service.ILiveBroadcastSDKService;
import jc1.k;
import kotlin.Metadata;
import tb1.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/liveinit/community/LiveBroadcastInitUnit;", "Lcom/bytedance/android/livesdk/init/AbsLiveInitUnit;", "()V", "CLASS_AVResourceService", "", "CLASS_BroadcastDialogManager", "CLASS_BroadcastDialogManagerDummy", "CLASS_BroadcastMiniGameService", "CLASS_BroadcastService", "CLASS_BroadcastServiceDummy", "CLASS_RoomStatusService", "CLASS_ScopeCollectBroadcastService", "CLASS_ScopeCollectServiceDummy", "getUnitKey", "Lcom/bytedance/android/livesdk/init/LiveInitUnitKey;", "initPoint", "Lcom/bytedance/android/livesdk/init/LiveInitPoint;", "initialize", "", "livesdk-init_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveBroadcastInitUnit extends AbsLiveInitUnit {
    private static final String CLASS_AVResourceService = "com.bytedance.android.live.broadcast.refactoring.framework.impl.service.LiveAVResourceService";
    private static final String CLASS_BroadcastDialogManager = "com.bytedance.android.live.broadcast.viewmodel.dialog.BroadcastDialogManager";
    private static final String CLASS_BroadcastDialogManagerDummy = "com.bytedance.android.live.broadcast.api.dummy.BroadcastDialogManagerDummy";
    private static final String CLASS_BroadcastMiniGameService = "com.bytedance.android.live.broadcast.BroadcastMiniGameService";
    private static final String CLASS_BroadcastService = "com.bytedance.android.live.broadcast.BroadcastService";
    private static final String CLASS_BroadcastServiceDummy = "com.bytedance.android.live.broadcast.api.dummy.BroadcastServiceDummy";
    private static final String CLASS_RoomStatusService = "com.bytedance.android.live.broadcast.refactoring.framework.impl.service.LiveRoomStatusService";
    private static final String CLASS_ScopeCollectBroadcastService = "com.bytedance.android.live.broadcast.ScopeCollectBroadcastService";
    private static final String CLASS_ScopeCollectServiceDummy = "com.bytedance.android.live.broadcast.api.dummy.ScopeCollectServiceDummy";
    public static final LiveBroadcastInitUnit INSTANCE = null;

    public static final class a implements LivePluginSPIManager.a {
        public a() {
        }

        public final void afterReady() {
            com.bytedance.android.livesdk.liveinit.a.c(LiveBroadcastInitUnit.CLASS_RoomStatusService, null);
            com.bytedance.android.livesdk.liveinit.a.c(LiveBroadcastInitUnit.CLASS_AVResourceService, null);
            com.bytedance.android.livesdk.liveinit.a.c(LiveBroadcastInitUnit.CLASS_BroadcastService, LiveBroadcastInitUnit.CLASS_BroadcastServiceDummy);
            com.bytedance.android.livesdk.liveinit.a.c(LiveBroadcastInitUnit.CLASS_ScopeCollectBroadcastService, LiveBroadcastInitUnit.CLASS_ScopeCollectServiceDummy);
            com.bytedance.android.livesdk.liveinit.a.c(LiveBroadcastInitUnit.CLASS_BroadcastDialogManager, LiveBroadcastInitUnit.CLASS_BroadcastDialogManagerDummy);
        }
    }

    public static final class b implements LivePluginSPIManager.a {
        public b() {
        }

        public final void afterReady() {
            com.bytedance.android.livesdk.liveinit.a.c(LiveBroadcastInitUnit.CLASS_BroadcastMiniGameService, null);
        }
    }

    static {
        INSTANCE = new LiveBroadcastInitUnit();
    }

    public void initialize() {
        if (rf2.a.a() == false) goto L5;
        return;
    L5:
        k.l(IBroadcastInitService.class, new BroadcastInitService());
        k.m(IPushStreamService.class, AnonymousClass1.INSTANCE);
        LivePluginSPIManager r0 = LivePluginSPIManager.e;
        a r1 = new a();
        r0.getClass();
        LivePluginSPIManager.d(r1);
        if (c.a == true) goto L8;
    L10:
        k.m(ILiveBroadcastSDKService.class, AnonymousClass4.INSTANCE);
        return;
    L8:
        if (c.c == true) goto L10;
        LivePluginSPIManager.d(new b());
        goto L10
    }

    private LiveBroadcastInitUnit() {
    }

    public LiveInitUnitKey getUnitKey() {
        return LiveInitUnitKey.LiveBroadcastInitUnit;
    }

    public LiveInitPoint initPoint() {
        return LiveInitPoint.COMPLETE_INIT;
    }
}
