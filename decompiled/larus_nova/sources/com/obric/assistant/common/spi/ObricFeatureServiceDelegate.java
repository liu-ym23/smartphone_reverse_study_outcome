package com.obric.assistant.common.spi;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0006\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0007\u001a\u00020\bH\u0096\u0001J\t\u0010\t\u001a\u00020\bH\u0096\u0001J\t\u0010\n\u001a\u00020\bH\u0096\u0001J\t\u0010\u000b\u001a\u00020\bH\u0096\u0001¨\u0006\f"}, d2 = {"Lcom/obric/assistant/common/spi/ObricFeatureServiceDelegate;", "Lcom/obric/assistant/common/spi/IObricFeatureService;", "<init>", "()V", "getObricKeepAliveLevel", "", "getObricProductName", "isEmulatorOs", "", "isFeatureEnable", "isObricFeatureEnable", "isObricOs", "obric_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricFeatureServiceDelegate implements IObricFeatureService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ObricFeatureServiceDelegate f387839b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IObricFeatureService f387840a;

    static {
        f387839b = new ObricFeatureServiceDelegate();
    }

    @Override // com.obric.assistant.common.spi.IObricFeatureService
    public final boolean a() {
        return this.f387840a.a();
    }

    @Override // com.obric.assistant.common.spi.IObricFeatureService
    public final boolean b() {
        return this.f387840a.b();
    }

    @Override // com.obric.assistant.common.spi.IObricFeatureService
    public final boolean c() {
        return this.f387840a.c();
    }

    @Override // com.obric.assistant.common.spi.IObricFeatureService
    public final String d() {
        return this.f387840a.d();
    }

    @Override // com.obric.assistant.common.spi.IObricFeatureService
    public final boolean e() {
        return this.f387840a.e();
    }

    @Override // com.obric.assistant.common.spi.IObricFeatureService
    public final String f() {
        return this.f387840a.f();
    }

    private ObricFeatureServiceDelegate() {
        IObricFeatureService r100 = (IObricFeatureService) ServiceManager.get().getService(IObricFeatureService.class);
        if (r100 != null) goto L5;
        r100 = new DefaultFeatureServiceImpl();
    L5:
        this.f387840a = r100;
    }
}
