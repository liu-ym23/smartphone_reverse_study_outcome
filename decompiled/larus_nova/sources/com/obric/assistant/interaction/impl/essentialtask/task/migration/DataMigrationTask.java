package com.obric.assistant.interaction.impl.essentialtask.task.migration;

import android.content.Context;
import com.bytedance.keva.Keva;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.essentialtask.TaskUtils;
import com.obric.assistant.interaction.impl.essentialtask.base.EssentialTask;
import com.obric.assistant.interaction.impl.essentialtask.base.ExecuteResult;
import com.obric.assistant.zeus.plugin.IObricMigrationHandler;
import com.obric.datatransfer.logger.TransferLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.j;
import t9a.b;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0016\u0018\u0000 \u00172\u00020\u0001:\u0004\u0017\u0018\u0019\u001aB'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0002J\u000e\u0010\u000e\u001a\u00020\u000fH\u0094@¢\u0006\u0002\u0010\u0010J\b\u0010\u0011\u001a\u00020\u0012H\u0014J\u0010\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/obric/assistant/interaction/impl/essentialtask/task/migration/DataMigrationTask;", "Lcom/obric/assistant/interaction/impl/essentialtask/base/EssentialTask;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "pluginPkg", "", "oldPkg", "authority", "<init>", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "updateMigrationStatus", "", "status", "Lcom/obric/assistant/interaction/impl/essentialtask/task/migration/MigrationStatus;", "internalExecute", "Lcom/obric/assistant/interaction/impl/essentialtask/base/ExecuteResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "internalNeedExecute", "", "isMigrationHosting", "startMigrationHost", "successCount", "", "Companion", "Memory", "AiAgent", "ZeusMigrationHandler", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class DataMigrationTask extends EssentialTask {
    private static final String AI_AGENT_OLD_PKG = "com.obric.assistantaiagent";
    private static final String AI_AGENT_PLUGIN_PKG_NAME = "com.obric.aiagent.plugin";
    public static final Companion Companion = null;
    private static final String MEMORY_DATA_PLUGIN_PKG_NAME = "com.obric.memorydata.plugin";
    private static final String MEMORY_OLD_PKG = "com.obric.memorydata";
    private static final String OBRIC_HOST_PKG_NAME = "com.larus.nova";
    private static final String REPO_NAME = "zeus_migration_status";
    private static final String TAG = "data_migration";
    private static final Keva keva = null;
    private static final Lazy<TransferLoggerDependAdapter> loggerDependLazy = null;
    private final String authority;
    private volatile boolean isMigrationHosting;
    private final String oldPkg;
    private final String pluginPkg;

    /* JADX INFO: loaded from: classes5.dex */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/assistant/interaction/impl/essentialtask/task/migration/DataMigrationTask$AiAgent;", "Lcom/obric/assistant/interaction/impl/essentialtask/task/migration/DataMigrationTask;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AiAgent extends DataMigrationTask {
        public AiAgent(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            super(r100, "com.obric.aiagent.plugin", DataMigrationTask.AI_AGENT_OLD_PKG, "com.obric.aiagent.transfer");
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005H\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/obric/assistant/interaction/impl/essentialtask/task/migration/DataMigrationTask$Companion;", "", "<init>", "()V", "TAG", "", "MEMORY_DATA_PLUGIN_PKG_NAME", "AI_AGENT_PLUGIN_PKG_NAME", "MEMORY_OLD_PKG", "AI_AGENT_OLD_PKG", "OBRIC_HOST_PKG_NAME", "REPO_NAME", "keva", "Lcom/bytedance/keva/Keva;", "kotlin.jvm.PlatformType", "getMigrationStatus", "Lcom/obric/assistant/interaction/impl/essentialtask/task/migration/MigrationStatus;", "pluginPkg", "isPacificProduct", "", "loggerDependLazy", "Lkotlin/Lazy;", "Lcom/obric/assistant/interaction/impl/essentialtask/task/migration/TransferLoggerDependAdapter;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        private final boolean isPacificProduct() {
            Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L4
            Object r101 = Result.m9449constructorimpl(Boolean.valueOf(Intrinsics.areEqual(b.a().d(), "pacific")));     // Catch: Throwable -> L4
        L6:
            Throwable r102 = Result.m9452exceptionOrNullimpl(r101);
            if (r102 == null) goto L9;
            FLogger.f375446a.w(DataMigrationTask.TAG, "isPacificProduct failed: " + r102.getMessage(), r102);
        L9:
            Boolean r103 = Boolean.FALSE;
            if (Result.m9455isFailureimpl(r101) == false) goto L13;
            r101 = r103;
        L13:
            return ((Boolean) r101).booleanValue();
        L4:
            th = move-exception;
            Result.Companion r104 = Result.Companion;
            r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L6
        }

        public static final /* synthetic */ boolean access$isPacificProduct(Companion r100) {
            return r100.isPacificProduct();
        }

        private final MigrationStatus getMigrationStatus(String r100) {
            String r101 = DataMigrationTask.access$getKeva$cp().getString(r100, "IDLE");
            Intrinsics.checkNotNull(r101);     // Catch: IllegalArgumentException -> L5
            return MigrationStatus.valueOf(r101);
        L5:
            e = move-exception;
            FLogger.f375446a.w(DataMigrationTask.TAG, "migration status parsing error", e);
            return MigrationStatus.IDLE;
        }

        public static final /* synthetic */ MigrationStatus access$getMigrationStatus(Companion r100, String r101) {
            return r100.getMigrationStatus(r101);
        }
    }

    /* JADX INFO: loaded from: classes5.dex */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/assistant/interaction/impl/essentialtask/task/migration/DataMigrationTask$Memory;", "Lcom/obric/assistant/interaction/impl/essentialtask/task/migration/DataMigrationTask;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Memory extends DataMigrationTask {
        public Memory(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            super(r100, "com.obric.memorydata.plugin", DataMigrationTask.MEMORY_OLD_PKG, "com.obric.memorydata.transfer");
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\n"}, d2 = {"Lcom/obric/assistant/interaction/impl/essentialtask/task/migration/DataMigrationTask$ZeusMigrationHandler;", "Lcom/obric/assistant/zeus/plugin/IObricMigrationHandler;", "<init>", "()V", "isMigrationNeeded", "", "pluginPkg", "", "onInstallFinished", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ZeusMigrationHandler implements IObricMigrationHandler {
        public ZeusMigrationHandler() {
        }

        @Override // com.obric.assistant.zeus.plugin.IObricMigrationHandler
        public void onInstallFinished(String r100) {
            Intrinsics.checkNotNullParameter(r100, "pluginPkg");
        }

        @Override // com.obric.assistant.zeus.plugin.IObricMigrationHandler
        public boolean isMigrationNeeded(String r100) {
            Intrinsics.checkNotNullParameter(r100, "pluginPkg");
            if (Companion.access$isPacificProduct(DataMigrationTask.Companion) == true) goto L5;
            return false;
        L5:
            Iterator<T> r101 = TaskUtils.INSTANCE.getPlugins().iterator();
        L6:
            boolean r102 = false;
        L8:
            if (r101.hasNext() == false) goto L14;
            String r103 = (String) r101.next();
            if (r102 == true) goto L13;
            if (Companion.access$getMigrationStatus(DataMigrationTask.Companion, r103) == MigrationStatus.FINISHED) goto L6;
        L13:
            r102 = true;
            goto L8
        L14:
            return r102;
        }
    }

    public static /* synthetic */ TransferLoggerDependAdapter b() {
        return loggerDependLazy$lambda$3();
    }

    @Override // com.obric.assistant.interaction.impl.essentialtask.base.EssentialTask
    public Object internalExecute(Continuation<? super ExecuteResult> r100) {
        return internalExecute$suspendImpl(this, r100);
    }

    static {
        Companion = new Companion(null);
        keva = Keva.getRepo(REPO_NAME, 1);
        loggerDependLazy = LazyKt.lazy(new a());
    }

    private static final TransferLoggerDependAdapter loggerDependLazy$lambda$3() {
        return new TransferLoggerDependAdapter();
    }

    @Override // com.obric.assistant.interaction.impl.essentialtask.base.EssentialTask
    public boolean internalNeedExecute() {
        Companion r100 = Companion;
        boolean r101 = false;
        if (Companion.access$isPacificProduct(r100) == true) goto L6;
        return false;
    L6:
        if (Companion.access$getMigrationStatus(r100, this.pluginPkg) == MigrationStatus.FINISHED) goto L8;
        r101 = true;
    L8:
        if (r101 == false) goto L12;
        Lazy<TransferLoggerDependAdapter> r102 = loggerDependLazy;
        if (r102.isInitialized() == true) goto L12;
        com.obric.datatransfer.logger.a r103 = TransferLogger.f396682b;
        TransferLoggerDependAdapter r104 = r102.getValue();
        Intrinsics.checkNotNullParameter(r104, "depend");
        TransferLogger.f396682b = r104;
    L12:
        return r101;
    }

    public static final /* synthetic */ Keva access$getKeva$cp() {
        return keva;
    }

    public static final /* synthetic */ String access$getPluginPkg$p(DataMigrationTask r100) {
        return r100.pluginPkg;
    }

    private final void startMigrationHost(int r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L16
        FLogger r102 = FLogger.f375446a;     // Catch: Throwable -> L16
        r102.i(TAG, "startMigrationHost,successCount=" + r100 + ",isMigrationHosting=" + this.isMigrationHosting);     // Catch: Throwable -> L16
        if (this.isMigrationHosting == false) goto L6;
        return;
    L6:
        boolean r103 = true;
        this.isMigrationHosting = true;     // Catch: Throwable -> L16
        MigrationStatus r104 = Companion.access$getMigrationStatus(Companion, "com.larus.nova");     // Catch: Throwable -> L16
        MigrationStatus r105 = MigrationStatus.FINISHED;     // Catch: Throwable -> L16
        if (r104 != r105) goto L10;
        r103 = false;
    L10:
        r102.i(TAG, "startMigrationHost needMigration = " + r103);     // Catch: Throwable -> L16
        if (r100 <= 0) goto L14;
        if (r103 == false) goto L14;
        ObricHostDataMigrationUtil.INSTANCE.startMigration();     // Catch: Throwable -> L16
        updateMigrationStatus("com.larus.nova", r105);     // Catch: Throwable -> L16
    L14:
        this.isMigrationHosting = false;     // Catch: Throwable -> L16
        Object r106 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L16
    L18:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L24;
        FLogger.f375446a.e(TAG, "startMigrationHost fail:" + r107);
        return;
    L24:
        return;
    L16:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L18
    }

    public static final /* synthetic */ void access$startMigrationHost(DataMigrationTask r100, int r101) {
        r100.startMigrationHost(r101);
    }

    /* JADX WARN: Type inference failed for: r2v5, types: [com.obric.assistant.interaction.impl.essentialtask.task.migration.DataMigrationTask$internalExecute$2$1, java.lang.Object] */
    public static Object internalExecute$suspendImpl(final DataMigrationTask r100, Continuation<? super ExecuteResult> r101) {
        FLogger r102 = FLogger.f375446a;
        r102.i(TAG, "Starting migration for " + r100.pluginPkg);
        r100.updateMigrationStatus(r100.pluginPkg, MigrationStatus.IN_PROCESS);
        if (DataMigrationUtils.INSTANCE.isComponentEnabled(r100.getContext(), r100.oldPkg) == true) goto L6;
        r102.i(TAG, "old app " + r100.oldPkg + " not exists");
        r100.updateMigrationStatus(r100.pluginPkg, MigrationStatus.FINISHED);
        return new ExecuteResult.Succeed();
    L6:
        final com.obric.datatransfer.client.b r103 = new com.obric.datatransfer.client.b(r100.getContext(), r100.authority);
        final j r104 = new j(IntrinsicsKt.intercepted(r101), 1);
        r104.C();
        final ?? r105 = new DataMigrationTask$internalExecute$2$1(r100, r104);
        Intrinsics.checkNotNullParameter(r105, "callback");
        ThreadMethodProxy.start(new PthreadThreadV2(new com.obric.datatransfer.client.a(r103, r105), "transfer-file-list"));
        r104.i(DataMigrationTask$internalExecute$2$2.INSTANCE);
        Object r106 = r104.B();
        if (r106 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L9;
        DebugProbesKt.probeCoroutineSuspended(r101);
    L9:
        return r106;
    }

    private final void updateMigrationStatus(String r100, MigrationStatus r101) {
        keva.storeString(r100, r101.name());
    }

    public static final /* synthetic */ void access$updateMigrationStatus(DataMigrationTask r100, String r101, MigrationStatus r102) {
        r100.updateMigrationStatus(r101, r102);
    }

    public DataMigrationTask(Context r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "pluginPkg");
        Intrinsics.checkNotNullParameter(r102, "oldPkg");
        Intrinsics.checkNotNullParameter(r103, "authority");
        super(r100, r101 + ".migration");
        this.pluginPkg = r101;
        this.oldPkg = r102;
        this.authority = r103;
    }
}
