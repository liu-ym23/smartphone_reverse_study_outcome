package com.obric.aiagent.runtime;

import com.obric.aiagent.platform.IAIAgentPlatform;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/obric/aiagent/runtime/ObricAIAgentPlatformImpl;", "Lcom/obric/aiagent/platform/IAIAgentPlatform;", "<init>", "()V", "appContext", "Lcom/obric/aiagent/runtime/AppContextImpl;", "logger", "Lcom/obric/aiagent/runtime/LogDependImpl;", "tracer", "Lcom/obric/aiagent/runtime/TraceDependImpl;", "buildContext", "Lcom/obric/aiagent/runtime/BuildContextImpl;", "cloudConfig", "Lcom/obric/aiagent/runtime/CloudConfigImpl;", "getAppContext", "Lcom/obric/aiagent/platform/depend/IAppContext;", "getLogger", "Lcom/obric/aiagent/platform/depend/ILogDepend;", "getTracer", "Lcom/obric/aiagent/platform/depend/ITraceDepend;", "getBuildContext", "Lcom/obric/aiagent/platform/depend/IBuildContext;", "getCloudConfig", "Lcom/obric/aiagent/platform/depend/ICloudConfig;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricAIAgentPlatformImpl implements IAIAgentPlatform {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AppContextImpl f385093b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LogDependImpl f385094c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TraceDependImpl f385095d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final BuildContextImpl f385096e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CloudConfigImpl f385097f;

    @Override // com.obric.aiagent.platform.IAIAgentPlatform
    public final void b() {
    }

    @Override // com.obric.aiagent.platform.IAIAgentPlatform
    public final void d() {
    }

    @Override // com.obric.aiagent.platform.IAIAgentPlatform
    public final void f() {
    }

    public ObricAIAgentPlatformImpl() {
        this.f385093b = new AppContextImpl();
        this.f385094c = new LogDependImpl();
        this.f385095d = new TraceDependImpl();
        this.f385096e = new BuildContextImpl();
        this.f385097f = new CloudConfigImpl();
    }

    @Override // com.obric.aiagent.platform.IAIAgentPlatform
    public final CloudConfigImpl a() {
        return this.f385097f;
    }

    @Override // com.obric.aiagent.platform.IAIAgentPlatform
    public final BuildContextImpl c() {
        return this.f385096e;
    }

    @Override // com.obric.aiagent.platform.IAIAgentPlatform
    public final TraceDependImpl e() {
        return this.f385095d;
    }

    @Override // com.obric.aiagent.platform.IAIAgentPlatform
    public final AppContextImpl getAppContext() {
        return this.f385093b;
    }

    @Override // com.obric.aiagent.platform.IAIAgentPlatform
    public final LogDependImpl getLogger() {
        return this.f385094c;
    }
}
