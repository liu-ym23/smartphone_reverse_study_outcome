package com.larus.login.api;

import androidx.fragment.app.FragmentActivity;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00018BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/larus/login/api/LoginInitServiceDelegate;", "Lcom/larus/login/api/ILoginInitService;", "<init>", "()V", "delegate", "getDelegate", "()Lcom/larus/login/api/ILoginInitService;", "preloadLoginPageNitaView", "", "preloadPhoneOneKeyInfo", "initWhiteListChecker", "activity", "Landroidx/fragment/app/FragmentActivity;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LoginInitServiceDelegate implements ILoginInitService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LoginInitServiceDelegate f356988a = null;

    static {
        f356988a = new LoginInitServiceDelegate();
    }

    private LoginInitServiceDelegate() {
    }

    @Override // com.larus.login.api.ILoginInitService
    public final void a() {
        ILoginInitService r100 = (ILoginInitService) ServiceManager.get().getService(ILoginInitService.class);
        if (r100 == null) goto L6;
        r100.a();
        return;
    }

    @Override // com.larus.login.api.ILoginInitService
    public final void b(FragmentActivity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        ILoginInitService r101 = (ILoginInitService) ServiceManager.get().getService(ILoginInitService.class);
        if (r101 == null) goto L6;
        r101.b(r100);
        return;
    }
}
