package com.obric.assistant.zeus.plugin;

import com.larus.utils.logger.FLogger;
import com.volcengine.zeus.plugin.PluginMigrationHandler;
import com.volcengine.zeus.plugin.PluginMigrationHandlerFactory;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class n implements PluginMigrationHandlerFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IObricMigrationHandler f395055a;

    public n(IObricMigrationHandler r100) {
        Intrinsics.checkNotNullParameter(r100, "handler");
        this.f395055a = r100;
    }

    @Override // com.volcengine.zeus.plugin.PluginMigrationHandlerFactory
    public final PluginMigrationHandler create(String r100) {
        Intrinsics.checkNotNullParameter(r100, "pluginPkg");
        FLogger.f375446a.i("migration_factory", "create handler for " + r100);
        return new m(this.f395055a);
    }
}
