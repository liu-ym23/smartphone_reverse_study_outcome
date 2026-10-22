package com.obric.assistant.zeus.plugin;

import com.larus.utils.logger.FLogger;
import com.volcengine.zeus.plugin.PluginMigrationHandler;
import com.volcengine.zeus.plugin.PluginMigrationHandlerFactory;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class n implements PluginMigrationHandlerFactory {
    public final IObricMigrationHandler a;

    public n(IObricMigrationHandler r2) {
        Intrinsics.checkNotNullParameter(r2, "handler");
        this.a = r2;
    }

    @Override // com.volcengine.zeus.plugin.PluginMigrationHandlerFactory
    public final PluginMigrationHandler create(String r4) {
        Intrinsics.checkNotNullParameter(r4, "pluginPkg");
        FLogger.a.i("migration_factory", "create handler for " + r4);
        return new m(this.a);
    }
}
