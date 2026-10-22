package com.obric.assistant.interaction.impl.essentialtask.task.migration;

import com.volcengine.zeus.plugin.PluginMigrationHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\n"}, d2 = {"Lcom/obric/assistant/interaction/impl/essentialtask/task/migration/NopMigrationTask;", "Lcom/volcengine/zeus/plugin/PluginMigrationHandler;", "<init>", "()V", "isMigrationNeeded", "", "pluginPkg", "", "onInstallFinished", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NopMigrationTask implements PluginMigrationHandler {
    public static final NopMigrationTask INSTANCE = null;

    static {
        INSTANCE = new NopMigrationTask();
    }

    private NopMigrationTask() {
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
