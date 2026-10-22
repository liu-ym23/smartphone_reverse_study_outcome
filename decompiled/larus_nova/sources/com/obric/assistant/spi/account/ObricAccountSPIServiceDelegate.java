package com.obric.assistant.spi.account;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import gga.a;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\u0015\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\t\u0010\n\u001a\u00020\u000bH\u0096\u0001J\t\u0010\f\u001a\u00020\u000bH\u0096\u0001J\t\u0010\r\u001a\u00020\u000bH\u0096\u0001J\u0013\u0010\u000e\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\u001b\u0010\u0010\u001a\u00020\u000b2\b\u0010\t\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0011\u001a\u00020\u000bH\u0096\u0001¨\u0006\u0012"}, d2 = {"Lcom/obric/assistant/spi/account/ObricAccountSPIServiceDelegate;", "Lcom/obric/assistant/spi/account/IObricAccountSPIService;", "<init>", "()V", "getActionBarModelMenuPolicy", "Lcom/obric/assistant/spi/account/ObricActionBarModelMenuPolicy;", "getCurrentPersonalAccountUid", "", "getLocalAccountUidBySecUserId", "secUserId", "shouldOnlyShowEnterpriseLoginWhenAddAccount", "", "shouldShowAccountSettingLogout", "shouldShowAccountSettingPhoneEntry", "shouldShowAccountSettingPlatformEntry", "platform", "shouldShowRemoveButton", "isEnterprise", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricAccountSPIServiceDelegate implements IObricAccountSPIService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ObricAccountSPIServiceDelegate f392812b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IObricAccountSPIService f392813a;

    static {
        f392812b = new ObricAccountSPIServiceDelegate();
    }

    @Override // com.obric.assistant.spi.account.IObricAccountSPIService
    public final String a() {
        return this.f392813a.a();
    }

    @Override // com.obric.assistant.spi.account.IObricAccountSPIService
    public final boolean b(String r100) {
        return this.f392813a.b(r100);
    }

    @Override // com.obric.assistant.spi.account.IObricAccountSPIService
    public final boolean c() {
        return this.f392813a.c();
    }

    @Override // com.obric.assistant.spi.account.IObricAccountSPIService
    public final String d(String r100) {
        return this.f392813a.d(r100);
    }

    @Override // com.obric.assistant.spi.account.IObricAccountSPIService
    public final a e() {
        return this.f392813a.e();
    }

    @Override // com.obric.assistant.spi.account.IObricAccountSPIService
    public final boolean f(String r100, boolean r101) {
        return this.f392813a.f(r100, r101);
    }

    @Override // com.obric.assistant.spi.account.IObricAccountSPIService
    public final boolean g() {
        return this.f392813a.g();
    }

    @Override // com.obric.assistant.spi.account.IObricAccountSPIService
    public final boolean h() {
        return this.f392813a.h();
    }

    private ObricAccountSPIServiceDelegate() {
        this.f392813a = (IObricAccountSPIService) ServiceManager.get().getService(IObricAccountSPIService.class);
    }
}
