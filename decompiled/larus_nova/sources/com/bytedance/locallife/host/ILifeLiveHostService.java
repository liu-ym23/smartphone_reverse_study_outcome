package com.bytedance.locallife.host;

import com.bytedance.android.life.service.annotation.ReturnSubService;
import com.bytedance.locallife.host.growth.ILifeUserGrowthService;
import it6.e;
import it6.f;
import it6.g;
import it6.h;
import it6.i;
import it6.j;
import it6.k;
import it6.l;
import kotlin.Metadata;
import rt6.a;
import vt6.b;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H'J\b\u0010\u0007\u001a\u00020\u0006H'J\b\u0010\t\u001a\u00020\bH'J\b\u0010\u000b\u001a\u00020\nH'J\b\u0010\r\u001a\u00020\fH'J\b\u0010\u000f\u001a\u00020\u000eH'J\b\u0010\u0011\u001a\u00020\u0010H'J\b\u0010\u0013\u001a\u00020\u0012H'J\b\u0010\u0015\u001a\u00020\u0014H'J\b\u0010\u0017\u001a\u00020\u0016H'J\b\u0010\u0019\u001a\u00020\u0018H'J\b\u0010\u001b\u001a\u00020\u001aH'¨\u0006\u001c"}, d2 = {"Lcom/bytedance/locallife/host/ILifeLiveHostService;", "", "", "initialize", "Lit6/l;", "getLifeUserInteractService", "Lit6/i;", "getLiveFloatWindowService", "Lit6/j;", "getLiveMultiLinkService", "Lit6/k;", "getLifeLivePluginJsbService", "Lrt6/a;", "getLifeNitaService", "Lit6/f;", "getLifeLiveAdaptService", "Lku6/a;", "getLifeVirgoService", "Lcom/bytedance/locallife/host/growth/ILifeUserGrowthService;", "getLifeUserGrowthService", "Lvt6/b;", "getLifeGoodsDetailService", "Lit6/h;", "getLifeLiveDslService", "Lit6/g;", "getLifeLivedebugService", "Lit6/e;", "getLifeLiveAdService", "locallife-host-api_release"}, k = 1, mv = {1, 4, 3})
public interface ILifeLiveHostService {
    @ReturnSubService
    b getLifeGoodsDetailService();

    @ReturnSubService
    /* JADX INFO: renamed from: getLifeLiveAdService */
    e mo8496getLifeLiveAdService();

    @ReturnSubService
    /* JADX INFO: renamed from: getLifeLiveAdaptService */
    f mo8494getLifeLiveAdaptService();

    @ReturnSubService
    h getLifeLiveDslService();

    @ReturnSubService
    k getLifeLivePluginJsbService();

    @ReturnSubService
    g getLifeLivedebugService();

    @ReturnSubService
    a getLifeNitaService();

    @ReturnSubService
    ILifeUserGrowthService getLifeUserGrowthService();

    @ReturnSubService
    /* JADX INFO: renamed from: getLifeUserInteractService */
    l mo8495getLifeUserInteractService();

    @ReturnSubService
    ku6.a getLifeVirgoService();

    @ReturnSubService
    i getLiveFloatWindowService();

    @ReturnSubService
    j getLiveMultiLinkService();

    void initialize();
}
