package com.obric.assistant.spi.account;

import gga.a;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u000b\u001a\u00020\u0003H\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\u0005H\u0016J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0010"}, d2 = {"Lcom/obric/assistant/spi/account/IObricAccountSPIService;", "", "shouldShowRemoveButton", "", "secUserId", "", "isEnterprise", "shouldShowAccountSettingLogout", "shouldShowAccountSettingPhoneEntry", "shouldShowAccountSettingPlatformEntry", "platform", "shouldOnlyShowEnterpriseLoginWhenAddAccount", "getActionBarModelMenuPolicy", "Lcom/obric/assistant/spi/account/ObricActionBarModelMenuPolicy;", "getCurrentPersonalAccountUid", "getLocalAccountUidBySecUserId", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IObricAccountSPIService {
    String a();

    boolean b(String r100);

    boolean c();

    String d(String r100);

    a e();

    boolean f(String r100, boolean r101);

    boolean g();

    boolean h();
}
