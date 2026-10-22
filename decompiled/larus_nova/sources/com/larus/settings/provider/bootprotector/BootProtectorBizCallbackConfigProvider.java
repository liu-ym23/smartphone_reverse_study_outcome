package com.larus.settings.provider.bootprotector;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"Lcom/larus/settings/provider/bootprotector/BootProtectorBizCallbackConfigProvider;", "Lcom/bytedance/news/common/settings/api/annotation/IDefaultValueProvider;", "Lcom/larus/settings/provider/bootprotector/BootProtectorBizCallbackConfig;", "<init>", "()V", "create", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BootProtectorBizCallbackConfigProvider {
    public BootProtectorBizCallbackConfigProvider() {
    }

    public BootProtectorBizCallbackConfig create() {
        return new BootProtectorBizCallbackConfig(false, null, 3, null);
    }

    /* JADX INFO: renamed from: create, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m8564create() {
        return create();
    }
}
