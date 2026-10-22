package com.obric.assistant.interaction.impl.essentialtask;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.essentialtask.task.migration.DataMigrationTask;
import com.obric.assistant.zeus.plugin.IObricMigrationHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/assistant/interaction/impl/essentialtask/ObricMigrationHandlerImpl;", "Lcom/obric/assistant/zeus/plugin/IObricMigrationHandler;", "<init>", "()V", "delegate", "Lcom/obric/assistant/interaction/impl/essentialtask/task/migration/DataMigrationTask$ZeusMigrationHandler;", "isMigrationNeeded", "", "pluginPkg", "", "onInstallFinished", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricMigrationHandlerImpl implements IObricMigrationHandler {
    private static final Companion Companion = null;
    private static final String TAG = "ObricMigrationHandler";
    private final DataMigrationTask.ZeusMigrationHandler delegate;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/assistant/interaction/impl/essentialtask/ObricMigrationHandlerImpl$Companion;", "", "<init>", "()V", "TAG", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public ObricMigrationHandlerImpl() {
        this.delegate = new DataMigrationTask.ZeusMigrationHandler();
    }

    @Override // com.obric.assistant.zeus.plugin.IObricMigrationHandler
    public boolean isMigrationNeeded(String r100) {
        Intrinsics.checkNotNullParameter(r100, "pluginPkg");
        boolean r101 = this.delegate.isMigrationNeeded(r100);
        FLogger.f375446a.i(TAG, "isMigrationNeeded, pluginPkg=" + r100 + ", result=" + r101);
        return r101;
    }

    @Override // com.obric.assistant.zeus.plugin.IObricMigrationHandler
    public void onInstallFinished(String r100) {
        Intrinsics.checkNotNullParameter(r100, "pluginPkg");
        FLogger.f375446a.i(TAG, "onInstallFinished, pluginPkg=" + r100);
        this.delegate.onInstallFinished(r100);
    }
}
