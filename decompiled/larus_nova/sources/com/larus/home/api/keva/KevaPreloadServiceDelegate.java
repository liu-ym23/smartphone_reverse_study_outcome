package com.larus.home.api.keva;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\bH\u0016J\u001a\u0010\t\u001a\u00020\b2\u0010\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000bH\u0016J\b\u0010\r\u001a\u00020\bH\u0016J\b\u0010\u000e\u001a\u00020\bH\u0016R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00018BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/larus/home/api/keva/KevaPreloadServiceDelegate;", "Lcom/larus/home/api/keva/IKevaPreloadService;", "<init>", "()V", "delegate", "getDelegate", "()Lcom/larus/home/api/keva/IKevaPreloadService;", "preloadKevaRepoAuto", "", "preloadKevaRepos", "repoNames", "", "", "updateABSettings", "onFirstFeedFirstFrame", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KevaPreloadServiceDelegate implements IKevaPreloadService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final KevaPreloadServiceDelegate f344091a = null;

    static {
        f344091a = new KevaPreloadServiceDelegate();
    }

    private KevaPreloadServiceDelegate() {
    }

    public static IKevaPreloadService e() {
        return (IKevaPreloadService) ServiceManager.get().getService(IKevaPreloadService.class);
    }

    @Override // com.larus.home.api.keva.IKevaPreloadService
    public final void a() {
        IKevaPreloadService r100 = e();
        if (r100 == null) goto L6;
        r100.a();
        return;
    }

    @Override // com.larus.home.api.keva.IKevaPreloadService
    public final void b() {
        IKevaPreloadService r100 = e();
        if (r100 == null) goto L6;
        r100.b();
        return;
    }

    @Override // com.larus.home.api.keva.IKevaPreloadService
    public final void c() {
        IKevaPreloadService r100 = e();
        if (r100 == null) goto L6;
        r100.c();
        return;
    }

    @Override // com.larus.home.api.keva.IKevaPreloadService
    public final void d(List<String> r100) {
        IKevaPreloadService r101 = e();
        if (r101 == null) goto L6;
        r101.d(r100);
        return;
    }
}
