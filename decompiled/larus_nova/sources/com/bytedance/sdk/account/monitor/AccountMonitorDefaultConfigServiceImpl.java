package com.bytedance.sdk.account.monitor;

import com.bytedance.sdk.account.monitor.settings.IAccountMonitorDefaultConfigService;
import com.bytedance.sdk.account.monitor.settings.MonitorControlSettings;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\b\u001a\u00020\u00072\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0002\b\u0005H\u0002R\u001b\u0010\r\u001a\u00020\u00078VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/bytedance/sdk/account/monitor/AccountMonitorDefaultConfigServiceImpl;", "Lcom/bytedance/sdk/account/monitor/settings/IAccountMonitorDefaultConfigService;", "Lkotlin/Function1;", "Lcom/bytedance/sdk/account/monitor/AccountMonitorDefaultConfigServiceImpl$a;", "", "Lkotlin/ExtensionFunctionType;", "build", "Lcom/bytedance/sdk/account/monitor/settings/b;", "buildConfig", "defaultMonitorConfig$delegate", "Lkotlin/Lazy;", "getDefaultMonitorConfig", "()Lcom/bytedance/sdk/account/monitor/settings/b;", "defaultMonitorConfig", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "account-sdk-core_release"}, k = 1, mv = {1, 4, 0})
public final class AccountMonitorDefaultConfigServiceImpl implements IAccountMonitorDefaultConfigService {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private final Lazy defaultMonitorConfig$delegate;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.bytedance.sdk.account.monitor.settings.b f269175a;

        public a(int r100) {
            this.f269175a = new com.bytedance.sdk.account.monitor.settings.b(true, r100, "<account default>");
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(AccountMonitorDefaultConfigServiceImpl.class), "defaultMonitorConfig", "getDefaultMonitorConfig()Lcom/bytedance/sdk/account/monitor/settings/MonitorConfig;"))};
    }

    @Override // com.bytedance.sdk.account.monitor.settings.IAccountMonitorDefaultConfigService
    public com.bytedance.sdk.account.monitor.settings.b getDefaultMonitorConfig() {
        Lazy r100 = this.defaultMonitorConfig$delegate;
        KProperty r101 = $$delegatedProperties[0];
        return (com.bytedance.sdk.account.monitor.settings.b) r100.getValue();
    }

    @Override // com.bytedance.sdk.account.monitor.settings.IAccountMonitorDefaultConfigService
    public int getDefaultSeed() {
        MonitorControlSettings.f269195k.getClass();
        Lazy r100 = MonitorControlSettings.f269192h;
        KProperty r101 = MonitorControlSettings.f269191g[0];
        return ((Number) r100.getValue()).intValue();
    }

    public AccountMonitorDefaultConfigServiceImpl() {
        this.defaultMonitorConfig$delegate = LazyKt.lazy(new AccountMonitorDefaultConfigServiceImpl$defaultMonitorConfig$2(this));
    }

    private final com.bytedance.sdk.account.monitor.settings.b buildConfig(Function1<? super a, Unit> r100) {
        a r101 = new a(UInt.m9544constructorimpl(getDefaultSeed()));
        r100.invoke(r101);
        return r101.f269175a;
    }

    public static final /* synthetic */ com.bytedance.sdk.account.monitor.settings.b access$buildConfig(AccountMonitorDefaultConfigServiceImpl r100, Function1 r101) {
        return r100.buildConfig(r101);
    }
}
