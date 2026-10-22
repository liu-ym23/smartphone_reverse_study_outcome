package com.obric.assistant.zeus.plugin;

import com.volcengine.zeus.plugin.PluginMigrationHandler;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class m implements PluginMigrationHandler {
    public final IObricMigrationHandler a;

    public m(IObricMigrationHandler r2) {
        Intrinsics.checkNotNullParameter(r2, "handler");
        this.a = r2;
    }

    @Override // com.volcengine.zeus.plugin.PluginMigrationHandler
    public final boolean isMigrationNeeded(String r2) {
        Intrinsics.checkNotNullParameter(r2, "pluginPkg");
        return this.a.isMigrationNeeded(r2);
    }

    @Override // com.volcengine.zeus.plugin.PluginMigrationHandler
    public final void onInstallFinished(String r2) {
        Intrinsics.checkNotNullParameter(r2, "pluginPkg");
        this.a.onInstallFinished(r2);
    }
}
