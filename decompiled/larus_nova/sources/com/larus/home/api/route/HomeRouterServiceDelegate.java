package com.larus.home.api.route;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\bH\u0016J\b\u0010\r\u001a\u00020\bH\u0016J\b\u0010\u000e\u001a\u00020\bH\u0016J\b\u0010\u000f\u001a\u00020\bH\u0016J\b\u0010\u0010\u001a\u00020\bH\u0016J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00018BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0014"}, d2 = {"Lcom/larus/home/api/route/HomeRouterServiceDelegate;", "Lcom/larus/home/api/route/IHomeRouterService;", "<init>", "()V", "delegate", "getDelegate", "()Lcom/larus/home/api/route/IHomeRouterService;", "addInterceptorsAfterMinor", "", "addInterceptorsBeforeSocialInvite", "addInterceptorsAfterSocialInvite", "addInterceptorsAfterDigitalAvatarBeforeCanvas", "addInterceptorsAfterCanvas", "addInterceptorBasicMode", "addInterceptorVoiceClone", "addAggregateSearchRouterInterceptor", "addInterceptorAccountInfoSetting", "getCustomPath", "", "uriString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HomeRouterServiceDelegate implements IHomeRouterService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HomeRouterServiceDelegate f344101a = null;

    static {
        f344101a = new HomeRouterServiceDelegate();
    }

    private HomeRouterServiceDelegate() {
    }

    public static IHomeRouterService k() {
        return (IHomeRouterService) ServiceManager.get().getService(IHomeRouterService.class);
    }

    @Override // com.larus.home.api.route.IHomeRouterService
    public final void a() {
        IHomeRouterService r100 = k();
        if (r100 == null) goto L6;
        r100.a();
        return;
    }

    @Override // com.larus.home.api.route.IHomeRouterService
    public final void b() {
        IHomeRouterService r100 = k();
        if (r100 == null) goto L6;
        r100.b();
        return;
    }

    @Override // com.larus.home.api.route.IHomeRouterService
    public final void c() {
        IHomeRouterService r100 = k();
        if (r100 == null) goto L6;
        r100.c();
        return;
    }

    @Override // com.larus.home.api.route.IHomeRouterService
    public final void d() {
        IHomeRouterService r100 = k();
        if (r100 == null) goto L6;
        r100.d();
        return;
    }

    @Override // com.larus.home.api.route.IHomeRouterService
    public final void f() {
        IHomeRouterService r100 = k();
        if (r100 == null) goto L6;
        r100.f();
        return;
    }

    @Override // com.larus.home.api.route.IHomeRouterService
    public final void g() {
        IHomeRouterService r100 = k();
        if (r100 == null) goto L6;
        r100.g();
        return;
    }

    @Override // com.larus.home.api.route.IHomeRouterService
    public final void h() {
        IHomeRouterService r100 = k();
        if (r100 == null) goto L6;
        r100.h();
        return;
    }

    @Override // com.larus.home.api.route.IHomeRouterService
    public final void i() {
        IHomeRouterService r100 = k();
        if (r100 == null) goto L6;
        r100.i();
        return;
    }

    @Override // com.larus.home.api.route.IHomeRouterService
    public final void j() {
        IHomeRouterService r100 = k();
        if (r100 == null) goto L6;
        r100.j();
        return;
    }

    @Override // com.larus.home.api.route.IHomeRouterService
    public final String e(String r100) {
        IHomeRouterService r101 = k();
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.e(r100);
    }
}
