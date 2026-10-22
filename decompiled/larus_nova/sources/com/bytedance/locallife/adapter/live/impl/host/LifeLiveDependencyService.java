package com.bytedance.locallife.adapter.live.impl.host;

import com.bytedance.locallife.adapter.impl.host.poi.a;
import com.bytedance.locallife.adapter.live.impl.host.live.LifeLivePluginJsbService;
import com.bytedance.locallife.adapter.live.impl.host.live.LifeUserInteractService;
import com.bytedance.locallife.adapter.live.impl.host.live.b;
import com.bytedance.locallife.adapter.live.impl.host.live.c;
import com.bytedance.locallife.adapter.live.impl.host.live.d;
import com.bytedance.locallife.adapter.live.impl.host.live.e;
import com.bytedance.locallife.adapter.live.impl.host.live.f;
import com.bytedance.locallife.adapter.live.impl.init.LocalLifeLiveInitializer;
import com.bytedance.locallife.host.ILifeLiveHostService;
import com.bytedance.locallife.host.growth.ILifeUserGrowthService;
import it6.g;
import it6.h;
import it6.i;
import it6.j;
import it6.k;
import it6.l;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bI\u0010JJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0016R\u001b\u0010 \u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u0005\u0010\u001fR\u001b\u0010%\u001a\u00020!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u001e\u001a\u0004\b#\u0010$R\u001b\u0010*\u001a\u00020&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\u001e\u001a\u0004\b(\u0010)R\u001b\u0010.\u001a\u00020+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\u001e\u001a\u0004\b\u000b\u0010-R\u001b\u00103\u001a\u00020/8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u0010\u001e\u001a\u0004\b1\u00102R\u0014\u00105\u001a\u0002048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0014\u00108\u001a\u0002078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0014\u0010;\u001a\u00020:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0014\u0010>\u001a\u00020=8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u0014\u0010A\u001a\u00020@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u0014\u0010D\u001a\u00020C8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u0014\u0010G\u001a\u00020F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010H¨\u0006K"}, d2 = {"Lcom/bytedance/locallife/adapter/live/impl/host/LifeLiveDependencyService;", "Lcom/bytedance/locallife/host/ILifeLiveHostService;", "", "initialize", "Lit6/l;", "getLifeUserInteractService", "Lit6/i;", "getLiveFloatWindowService", "Lit6/j;", "getLiveMultiLinkService", "Lit6/f;", "getLifeLiveAdaptService", "Lit6/k;", "getLifeLivePluginJsbService", "Lrt6/a;", "getLifeNitaService", "Lku6/a;", "getLifeVirgoService", "Lcom/bytedance/locallife/host/growth/ILifeUserGrowthService;", "getLifeUserGrowthService", "Lvt6/b;", "getLifeGoodsDetailService", "Lit6/h;", "getLifeLiveDslService", "Lit6/g;", "getLifeLivedebugService", "Lit6/e;", "getLifeLiveAdService", "Lcom/bytedance/locallife/adapter/live/impl/host/live/LifeUserInteractService;", "lifeUserInteractService$delegate", "Lkotlin/Lazy;", "()Lcom/bytedance/locallife/adapter/live/impl/host/live/LifeUserInteractService;", "lifeUserInteractService", "Lcom/bytedance/locallife/adapter/live/impl/host/live/e;", "lifeLiveFloatWindowService$delegate", "getLifeLiveFloatWindowService", "()Lcom/bytedance/locallife/adapter/live/impl/host/live/e;", "lifeLiveFloatWindowService", "Lcom/bytedance/locallife/adapter/live/impl/host/live/f;", "lifeLiveMultiLinkService$delegate", "getLifeLiveMultiLinkService", "()Lcom/bytedance/locallife/adapter/live/impl/host/live/f;", "lifeLiveMultiLinkService", "Lcom/bytedance/locallife/adapter/live/impl/host/live/b;", "lifeLiveAdaptService$delegate", "()Lcom/bytedance/locallife/adapter/live/impl/host/live/b;", "lifeLiveAdaptService", "Lcom/bytedance/locallife/adapter/live/impl/host/live/LifeLivePluginJsbService;", "liveLivePluginJsbService$delegate", "getLiveLivePluginJsbService", "()Lcom/bytedance/locallife/adapter/live/impl/host/live/LifeLivePluginJsbService;", "liveLivePluginJsbService", "Lfm6/a;", "lifeNitaService", "Lfm6/a;", "Lbn6/a;", "lifeVirgoService", "Lbn6/a;", "Lyl6/a;", "lifeUserGrowthService", "Lyl6/a;", "Lcom/bytedance/locallife/adapter/impl/host/poi/a;", "lifeGoodsDetailService", "Lcom/bytedance/locallife/adapter/impl/host/poi/a;", "Lcom/bytedance/locallife/adapter/live/impl/host/live/d;", "lifeLiveDslService", "Lcom/bytedance/locallife/adapter/live/impl/host/live/d;", "Lcom/bytedance/locallife/adapter/live/impl/host/live/c;", "lifeLiveDebugService", "Lcom/bytedance/locallife/adapter/live/impl/host/live/c;", "Lcom/bytedance/locallife/adapter/live/impl/host/live/a;", "lifeLiveAdService", "Lcom/bytedance/locallife/adapter/live/impl/host/live/a;", "<init>", "()V", "locallife-adapter-live-impl_release"}, k = 1, mv = {1, 4, 3})
public class LifeLiveDependencyService implements ILifeLiveHostService {
    private final a lifeGoodsDetailService;
    private final com.bytedance.locallife.adapter.live.impl.host.live.a lifeLiveAdService;
    private final Lazy lifeLiveAdaptService$delegate;
    private final c lifeLiveDebugService;
    private final d lifeLiveDslService;
    private final Lazy lifeLiveFloatWindowService$delegate;
    private final Lazy lifeLiveMultiLinkService$delegate;
    private final fm6.a lifeNitaService;
    private final yl6.a lifeUserGrowthService;
    private final Lazy lifeUserInteractService$delegate;
    private final bn6.a lifeVirgoService;
    private final Lazy liveLivePluginJsbService$delegate;

    private final b getLifeLiveAdaptService() {
        return (b) this.lifeLiveAdaptService$delegate.getValue();
    }

    private final e getLifeLiveFloatWindowService() {
        return (e) this.lifeLiveFloatWindowService$delegate.getValue();
    }

    private final f getLifeLiveMultiLinkService() {
        return (f) this.lifeLiveMultiLinkService$delegate.getValue();
    }

    private final LifeUserInteractService getLifeUserInteractService() {
        return (LifeUserInteractService) this.lifeUserInteractService$delegate.getValue();
    }

    private final LifeLivePluginJsbService getLiveLivePluginJsbService() {
        return (LifeLivePluginJsbService) this.liveLivePluginJsbService$delegate.getValue();
    }

    public LifeLiveDependencyService() {
        LazyThreadSafetyMode r100 = LazyThreadSafetyMode.PUBLICATION;
        this.lifeUserInteractService$delegate = LazyKt.lazy(r100, LifeLiveDependencyService$lifeUserInteractService$2.INSTANCE);
        this.lifeLiveFloatWindowService$delegate = LazyKt.lazy(r100, LifeLiveDependencyService$lifeLiveFloatWindowService$2.INSTANCE);
        this.lifeLiveMultiLinkService$delegate = LazyKt.lazy(r100, LifeLiveDependencyService$lifeLiveMultiLinkService$2.INSTANCE);
        this.lifeLiveAdaptService$delegate = LazyKt.lazy(r100, LifeLiveDependencyService$lifeLiveAdaptService$2.INSTANCE);
        this.liveLivePluginJsbService$delegate = LazyKt.lazy(r100, LifeLiveDependencyService$liveLivePluginJsbService$2.INSTANCE);
        this.lifeNitaService = new fm6.a();
        this.lifeVirgoService = new bn6.a();
        this.lifeUserGrowthService = new yl6.a();
        this.lifeGoodsDetailService = new a();
        this.lifeLiveDslService = new d();
        this.lifeLiveDebugService = new c();
        this.lifeLiveAdService = new com.bytedance.locallife.adapter.live.impl.host.live.a();
    }

    @Override // com.bytedance.locallife.host.ILifeLiveHostService
    public k getLifeLivePluginJsbService() {
        return getLiveLivePluginJsbService();
    }

    @Override // com.bytedance.locallife.host.ILifeLiveHostService
    public i getLiveFloatWindowService() {
        return getLifeLiveFloatWindowService();
    }

    @Override // com.bytedance.locallife.host.ILifeLiveHostService
    public j getLiveMultiLinkService() {
        return getLifeLiveMultiLinkService();
    }

    @Override // com.bytedance.locallife.host.ILifeLiveHostService
    public vt6.b getLifeGoodsDetailService() {
        return this.lifeGoodsDetailService;
    }

    @Override // com.bytedance.locallife.host.ILifeLiveHostService
    /* JADX INFO: renamed from: getLifeLiveAdService */
    public it6.e mo8496getLifeLiveAdService() {
        return this.lifeLiveAdService;
    }

    @Override // com.bytedance.locallife.host.ILifeLiveHostService
    public h getLifeLiveDslService() {
        return this.lifeLiveDslService;
    }

    @Override // com.bytedance.locallife.host.ILifeLiveHostService
    public g getLifeLivedebugService() {
        return this.lifeLiveDebugService;
    }

    @Override // com.bytedance.locallife.host.ILifeLiveHostService
    public rt6.a getLifeNitaService() {
        return this.lifeNitaService;
    }

    @Override // com.bytedance.locallife.host.ILifeLiveHostService
    public ILifeUserGrowthService getLifeUserGrowthService() {
        return this.lifeUserGrowthService;
    }

    @Override // com.bytedance.locallife.host.ILifeLiveHostService
    public ku6.a getLifeVirgoService() {
        return this.lifeVirgoService;
    }

    @Override // com.bytedance.locallife.host.ILifeLiveHostService
    public void initialize() {
        LocalLifeLiveInitializer.a();
    }

    @Override // com.bytedance.locallife.host.ILifeLiveHostService
    /* JADX INFO: renamed from: getLifeLiveAdaptService, reason: collision with other method in class */
    public it6.f mo8494getLifeLiveAdaptService() {
        return getLifeLiveAdaptService();
    }

    @Override // com.bytedance.locallife.host.ILifeLiveHostService
    /* JADX INFO: renamed from: getLifeUserInteractService, reason: collision with other method in class */
    public l mo8495getLifeUserInteractService() {
        return getLifeUserInteractService();
    }
}
