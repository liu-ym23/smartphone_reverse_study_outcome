package com.obric.assistant;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0014\u0010\f\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/obric/assistant/ObricPackageSignatureCache;", "Lcom/obric/assistant/IObricPackageSignatureCacheService;", "<init>", "()V", "service", "getService", "()Lcom/obric/assistant/IObricPackageSignatureCacheService;", "service$delegate", "Lkotlin/Lazy;", "getOrCompute", "", "pkgName", "refresh", "remove", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricPackageSignatureCache implements IObricPackageSignatureCacheService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ObricPackageSignatureCache f385175a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f385176b = null;

    private ObricPackageSignatureCache() {
    }

    static {
        f385175a = new ObricPackageSignatureCache();
        f385176b = LazyKt.lazy(new o1());
    }

    @Override // com.obric.assistant.IObricPackageSignatureCacheService
    public final String getOrCompute(String r100) {
        IObricPackageSignatureCacheService r101 = (IObricPackageSignatureCacheService) f385176b.getValue();
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.getOrCompute(r100);
    }

    @Override // com.obric.assistant.IObricPackageSignatureCacheService
    public final String refresh(String r100) {
        IObricPackageSignatureCacheService r101 = (IObricPackageSignatureCacheService) f385176b.getValue();
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.refresh(r100);
    }

    @Override // com.obric.assistant.IObricPackageSignatureCacheService
    public final void remove(String r100) {
        IObricPackageSignatureCacheService r101 = (IObricPackageSignatureCacheService) f385176b.getValue();
        if (r101 == null) goto L6;
        r101.remove(r100);
        return;
    }
}
