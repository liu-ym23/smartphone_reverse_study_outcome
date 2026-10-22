package lz6;

import com.bytedance.locallife.host.ILifeLiveHostService;
import com.bytedance.locallife.host.growth.ILifeUserGrowthService;

/* JADX INFO: loaded from: classes21.dex */
public final class e0 implements ILifeLiveHostService {
    public e0() {
    }

    @Override // com.bytedance.locallife.host.ILifeLiveHostService
    public final ILifeUserGrowthService getLifeUserGrowthService() {
        return null;
    }

    @Override // com.bytedance.locallife.host.ILifeLiveHostService
    public final ku6.a getLifeVirgoService() {
        return null;
    }

    @Override // com.bytedance.locallife.host.ILifeLiveHostService
    public final void initialize() {
    }

    @Override // com.bytedance.locallife.host.ILifeLiveHostService
    public final vt6.b getLifeGoodsDetailService() {
        return new w();
    }

    @Override // com.bytedance.locallife.host.ILifeLiveHostService
    /* JADX INFO: renamed from: getLifeLiveAdService */
    public final it6.e mo8496getLifeLiveAdService() {
        return new z();
    }

    @Override // com.bytedance.locallife.host.ILifeLiveHostService
    /* JADX INFO: renamed from: getLifeLiveAdaptService */
    public final it6.f mo8494getLifeLiveAdaptService() {
        return new a0();
    }

    @Override // com.bytedance.locallife.host.ILifeLiveHostService
    public final it6.h getLifeLiveDslService() {
        return new c0();
    }

    @Override // com.bytedance.locallife.host.ILifeLiveHostService
    public final it6.k getLifeLivePluginJsbService() {
        return new g0();
    }

    @Override // com.bytedance.locallife.host.ILifeLiveHostService
    public final it6.g getLifeLivedebugService() {
        return new b0();
    }

    @Override // com.bytedance.locallife.host.ILifeLiveHostService
    public final rt6.a getLifeNitaService() {
        return new h0();
    }

    @Override // com.bytedance.locallife.host.ILifeLiveHostService
    /* JADX INFO: renamed from: getLifeUserInteractService */
    public final it6.l mo8495getLifeUserInteractService() {
        return new j0();
    }

    @Override // com.bytedance.locallife.host.ILifeLiveHostService
    public final it6.i getLiveFloatWindowService() {
        return new d0();
    }

    @Override // com.bytedance.locallife.host.ILifeLiveHostService
    public final it6.j getLiveMultiLinkService() {
        return new f0();
    }
}
