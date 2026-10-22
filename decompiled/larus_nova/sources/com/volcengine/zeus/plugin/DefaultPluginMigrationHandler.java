package com.volcengine.zeus.plugin;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\t"}, d2 = {"Lcom/volcengine/zeus/plugin/DefaultPluginMigrationHandler;", "Lcom/volcengine/zeus/plugin/PluginMigrationHandler;", "()V", "isMigrationNeeded", "", "pluginPkg", "", "onInstallFinished", "", "zeus-core_release"}, k = 1, mv = {1, 4, 2})
public final class DefaultPluginMigrationHandler implements PluginMigrationHandler {
    public DefaultPluginMigrationHandler() {
    }

    @Override // com.volcengine.zeus.plugin.PluginMigrationHandler
    public boolean isMigrationNeeded(String r100) {
        Intrinsics.checkNotNullParameter(r100, "pluginPkg");
        return false;
    }

    @Override // com.volcengine.zeus.plugin.PluginMigrationHandler
    public void onInstallFinished(String r100) {
        Intrinsics.checkNotNullParameter(r100, "pluginPkg");
    }
}
