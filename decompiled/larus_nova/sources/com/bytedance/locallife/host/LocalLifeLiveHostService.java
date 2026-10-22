package com.bytedance.locallife.host;

import com.bytedance.locallife.adapter.live.impl.host.LifeLiveDependencyService;
import it6.b;
import it6.c;
import it6.i;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import ms6.e;
import ms6.f;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\nH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\t\u001a\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/bytedance/locallife/host/LocalLifeLiveHostService;", "Lcom/bytedance/locallife/adapter/live/impl/host/LifeLiveDependencyService;", "<init>", "()V", "lifeLiveAdService", "Lcom/bytedance/locallife/host/live/HostLifeLiveAdService;", "getLifeLiveAdService", "()Lcom/bytedance/locallife/host/live/HostLifeLiveAdService;", "lifeLiveAdService$delegate", "Lkotlin/Lazy;", "Lcom/bytedance/locallife/host/live/ILifeLiveAdService;", "lifeLiveFloatWindowService", "Lcom/bytedance/locallife/host/live/HostLifeLiveFloatWindowService;", "getLifeLiveFloatWindowService", "()Lcom/bytedance/locallife/host/live/HostLifeLiveFloatWindowService;", "lifeLiveFloatWindowService$delegate", "getLiveFloatWindowService", "Lcom/bytedance/locallife/host/live/ILifeLiveFloatWindowService;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LocalLifeLiveHostService extends LifeLiveDependencyService {
    private final Lazy lifeLiveAdService$delegate;
    private final Lazy lifeLiveFloatWindowService$delegate;

    public static /* synthetic */ b a() {
        return lifeLiveAdService_delegate$lambda$0();
    }

    public static /* synthetic */ c b() {
        return lifeLiveFloatWindowService_delegate$lambda$1();
    }

    private final b getLifeLiveAdService() {
        return (b) this.lifeLiveAdService$delegate.getValue();
    }

    private final c getLifeLiveFloatWindowService() {
        return (c) this.lifeLiveFloatWindowService$delegate.getValue();
    }

    private static final b lifeLiveAdService_delegate$lambda$0() {
        return new b();
    }

    private static final c lifeLiveFloatWindowService_delegate$lambda$1() {
        return new c();
    }

    public LocalLifeLiveHostService() {
        this.lifeLiveAdService$delegate = LazyKt.lazy(new e());
        this.lifeLiveFloatWindowService$delegate = LazyKt.lazy(new f());
    }

    @Override // com.bytedance.locallife.adapter.live.impl.host.LifeLiveDependencyService, com.bytedance.locallife.host.ILifeLiveHostService
    public i getLiveFloatWindowService() {
        return getLifeLiveFloatWindowService();
    }

    @Override // com.bytedance.locallife.adapter.live.impl.host.LifeLiveDependencyService, com.bytedance.locallife.host.ILifeLiveHostService
    /* JADX INFO: renamed from: getLifeLiveAdService, reason: collision with other method in class */
    public it6.e mo8496getLifeLiveAdService() {
        return getLifeLiveAdService();
    }
}
