package com.bytedance.locallife.adapter.impl.host;

import com.bytedance.android.life.service.annotation.ReturnSubService;
import com.bytedance.locallife.host.ILifeHostPerfService;
import im6.a;
import im6.c;
import im6.d;
import im6.f;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import ut6.b;
import ut6.e;
import ut6.g;
import ut6.h;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b!\u0010\"J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016R\u001b\u0010\u0010\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u0003\u0010\u000fR\u001b\u0010\u0014\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0005\u0010\u0013R\u001b\u0010\u0018\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0007\u0010\u0017R\u001b\u0010\u001c\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000e\u001a\u0004\b\t\u0010\u001bR\u001b\u0010 \u001a\u00020\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u000e\u001a\u0004\b\u000b\u0010\u001f¨\u0006#"}, d2 = {"Lcom/bytedance/locallife/adapter/impl/host/LifeHostPerfService;", "Lcom/bytedance/locallife/host/ILifeHostPerfService;", "Lut6/e;", "getLifePerformanceService", "Lut6/a;", "getLifeCacheOptService", "Lut6/c;", "getLifeJatoOptService", "Lut6/d;", "getLifeLynxOptService", "Lut6/f;", "getLifeTempoOptService", "Lim6/d;", "lifePerformanceService$delegate", "Lkotlin/Lazy;", "()Lim6/d;", "lifePerformanceService", "Lim6/a;", "lifeCacheOptService$delegate", "()Lim6/a;", "lifeCacheOptService", "Lim6/b;", "lifeJatoOptService$delegate", "()Lim6/b;", "lifeJatoOptService", "Lim6/c;", "lifeLynxOptService$delegate", "()Lim6/c;", "lifeLynxOptService", "Lim6/f;", "lifeTempoOptService$delegate", "()Lim6/f;", "lifeTempoOptService", "<init>", "()V", "locallife-adapter-impl_release"}, k = 1, mv = {1, 4, 3})
public class LifeHostPerfService implements ILifeHostPerfService {
    private final Lazy lifeCacheOptService$delegate;
    private final Lazy lifeJatoOptService$delegate;
    private final Lazy lifeLynxOptService$delegate;
    private final Lazy lifePerformanceService$delegate;
    private final Lazy lifeTempoOptService$delegate;

    @Override // com.bytedance.locallife.host.ILifeHostPerfService
    @ReturnSubService
    public g getLifeECRService() {
        return null;
    }

    @Override // com.bytedance.locallife.host.ILifeHostPerfService
    @ReturnSubService
    public b getLifeGenericPerfService() {
        return null;
    }

    @Override // com.bytedance.locallife.host.ILifeHostPerfService
    @ReturnSubService
    public h getScanPerformanceMonitorService() {
        return null;
    }

    private final a getLifeCacheOptService() {
        return (a) this.lifeCacheOptService$delegate.getValue();
    }

    private final im6.b getLifeJatoOptService() {
        return (im6.b) this.lifeJatoOptService$delegate.getValue();
    }

    private final c getLifeLynxOptService() {
        return (c) this.lifeLynxOptService$delegate.getValue();
    }

    private final d getLifePerformanceService() {
        return (d) this.lifePerformanceService$delegate.getValue();
    }

    private final f getLifeTempoOptService() {
        return (f) this.lifeTempoOptService$delegate.getValue();
    }

    public LifeHostPerfService() {
        this.lifePerformanceService$delegate = LazyKt.lazy(LifeHostPerfService$lifePerformanceService$2.INSTANCE);
        this.lifeCacheOptService$delegate = LazyKt.lazy(LifeHostPerfService$lifeCacheOptService$2.INSTANCE);
        this.lifeJatoOptService$delegate = LazyKt.lazy(LifeHostPerfService$lifeJatoOptService$2.INSTANCE);
        this.lifeLynxOptService$delegate = LazyKt.lazy(LifeHostPerfService$lifeLynxOptService$2.INSTANCE);
        this.lifeTempoOptService$delegate = LazyKt.lazy(LifeHostPerfService$lifeTempoOptService$2.INSTANCE);
    }

    @Override // com.bytedance.locallife.host.ILifeHostPerfService
    /* JADX INFO: renamed from: getLifeCacheOptService, reason: collision with other method in class */
    public ut6.a mo8489getLifeCacheOptService() {
        return getLifeCacheOptService();
    }

    @Override // com.bytedance.locallife.host.ILifeHostPerfService
    /* JADX INFO: renamed from: getLifeJatoOptService, reason: collision with other method in class */
    public ut6.c mo8490getLifeJatoOptService() {
        return getLifeJatoOptService();
    }

    @Override // com.bytedance.locallife.host.ILifeHostPerfService
    /* JADX INFO: renamed from: getLifeLynxOptService, reason: collision with other method in class */
    public ut6.d mo8491getLifeLynxOptService() {
        return getLifeLynxOptService();
    }

    @Override // com.bytedance.locallife.host.ILifeHostPerfService
    /* JADX INFO: renamed from: getLifePerformanceService, reason: collision with other method in class */
    public e mo8492getLifePerformanceService() {
        return getLifePerformanceService();
    }

    @Override // com.bytedance.locallife.host.ILifeHostPerfService
    /* JADX INFO: renamed from: getLifeTempoOptService, reason: collision with other method in class */
    public ut6.f mo8493getLifeTempoOptService() {
        return getLifeTempoOptService();
    }
}
