package com.obric.assistant.zeus.plugin;

import com.volcengine.zeus.plugin.PluginMigrationHandler;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class m implements PluginMigrationHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IObricMigrationHandler f395054a;

    public m(IObricMigrationHandler r100) {
        Intrinsics.checkNotNullParameter(r100, "handler");
        this.f395054a = r100;
    }

    @Override // com.volcengine.zeus.plugin.PluginMigrationHandler
    public final boolean isMigrationNeeded(String r100) {
        Intrinsics.checkNotNullParameter(r100, "pluginPkg");
        return this.f395054a.isMigrationNeeded(r100);
    }

    @Override // com.volcengine.zeus.plugin.PluginMigrationHandler
    public final void onInstallFinished(String r100) {
        Intrinsics.checkNotNullParameter(r100, "pluginPkg");
        this.f395054a.onInstallFinished(r100);
    }
}
