package com.bytedance.locallife.groupon.host;

import com.bytedance.android.life.service.annotation.ReturnSubService;
import ir6.a;
import kotlin.Metadata;
import mr6.b;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H'J\b\u0010\u0005\u001a\u00020\u0004H'J\b\u0010\u0007\u001a\u00020\u0006H'J\b\u0010\t\u001a\u00020\bH'J\b\u0010\u000b\u001a\u00020\nH'J\b\u0010\r\u001a\u00020\fH'J\b\u0010\u000f\u001a\u00020\u000eH'J\b\u0010\u0011\u001a\u00020\u0010H'J\b\u0010\u0013\u001a\u00020\u0012H'J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0014H'J\b\u0010\u0017\u001a\u00020\u0016H'J\b\u0010\u0019\u001a\u00020\u0018H'J\b\u0010\u001b\u001a\u00020\u001aH'J\b\u0010\u001d\u001a\u00020\u001cH'J\n\u0010\u001f\u001a\u0004\u0018\u00010\u001eH'J\b\u0010!\u001a\u00020 H'J\b\u0010#\u001a\u00020\"H'J\b\u0010%\u001a\u00020$H'J\b\u0010'\u001a\u00020&H'J\b\u0010)\u001a\u00020(H'J\b\u0010+\u001a\u00020*H'J\b\u0010-\u001a\u00020,H'J\b\u0010/\u001a\u00020.H'¨\u00060"}, d2 = {"Lcom/bytedance/locallife/groupon/host/ILifeGrouponService;", "", "Lir6/a;", "getGroupDebugService", "Lyr6/a;", "getGrouponUtilsService", "Llr6/a;", "getGrouponEventService", "Lxr6/a;", "getGrouponTabService", "Ler6/a;", "getGrouponClientAiService", "Lqr6/a;", "getGrouponLocationService", "Lrr6/a;", "getGrouponMobService", "Lgr6/a;", "getGrouponCityUtilsService", "Lmr6/b;", "getGrouponFeedService", "Lmr6/a;", "getGrouponFeedPrefService", "Lpr6/a;", "getGrouponOfflineStateMob", "Lor6/a;", "getGrouponHomepageService", "Lkr6/a;", "getGrouponDrainageService", "Ltr6/a;", "getGrouponPinTopService", "Lfr6/a;", "getGrouponAwemeService", "Lwr6/a;", "getGrouponSearchService", "Lrr6/b;", "getUserDataCollectService", "Lzr6/a;", "getGrouponWsService", "Lsr6/a;", "getGrouponPerformanceService", "Lnr6/a;", "getGrouponHalfScreenService", "Ljr6/a;", "getGrouponDiamondService", "Lhr6/a;", "getGrouponConfigService", "Lvr6/a;", "getGrouponLynxPreloadV2Service", "locallife-groupon-host-api_release"}, k = 1, mv = {1, 4, 3})
public interface ILifeGrouponService {
    @ReturnSubService
    a getGroupDebugService();

    @ReturnSubService
    fr6.a getGrouponAwemeService();

    @ReturnSubService
    gr6.a getGrouponCityUtilsService();

    @ReturnSubService
    er6.a getGrouponClientAiService();

    @ReturnSubService
    hr6.a getGrouponConfigService();

    @ReturnSubService
    jr6.a getGrouponDiamondService();

    @ReturnSubService
    kr6.a getGrouponDrainageService();

    @ReturnSubService
    lr6.a getGrouponEventService();

    @ReturnSubService
    mr6.a getGrouponFeedPrefService();

    @ReturnSubService
    b getGrouponFeedService();

    @ReturnSubService
    nr6.a getGrouponHalfScreenService();

    @ReturnSubService
    or6.a getGrouponHomepageService();

    @ReturnSubService
    qr6.a getGrouponLocationService();

    @ReturnSubService
    vr6.a getGrouponLynxPreloadV2Service();

    @ReturnSubService
    rr6.a getGrouponMobService();

    @ReturnSubService
    pr6.a getGrouponOfflineStateMob();

    @ReturnSubService
    sr6.a getGrouponPerformanceService();

    @ReturnSubService
    tr6.a getGrouponPinTopService();

    @ReturnSubService
    wr6.a getGrouponSearchService();

    @ReturnSubService
    xr6.a getGrouponTabService();

    @ReturnSubService
    yr6.a getGrouponUtilsService();

    @ReturnSubService
    zr6.a getGrouponWsService();

    @ReturnSubService
    rr6.b getUserDataCollectService();
}
