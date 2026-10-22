package com.obric.assistant.interaction.impl.essentialtask.task.migration;

import android.content.Context;
import android.util.EventsUtils;
import com.bytedance.keva.Keva;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.essentialtask.TaskUtils;
import com.obric.assistant.interaction.impl.essentialtask.base.EssentialTask;
import com.obric.assistant.interaction.impl.essentialtask.base.ExecuteResult;
import com.obric.assistant.zeus.plugin.IObricMigrationHandler;
import com.obric.datatransfer.logger.TransferLogger;
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
import org.xmlpull.v1.XmlPullParser;
import t9a.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0016\u0018\u0000 \u00172\u00020\u0001:\u0004\u0017\u0018\u0019\u001aB'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0002J\u000e\u0010\u000e\u001a\u00020\u000fH\u0094@¢\u0006\u0002\u0010\u0010J\b\u0010\u0011\u001a\u00020\u0012H\u0014J\u0010\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/obric/assistant/interaction/impl/essentialtask/task/migration/DataMigrationTask;", "Lcom/obric/assistant/interaction/impl/essentialtask/base/EssentialTask;", "context", "Landroid/content/Context;", "pluginPkg", XmlPullParser.NO_NAMESPACE, "oldPkg", "authority", "<init>", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "updateMigrationStatus", XmlPullParser.NO_NAMESPACE, "status", "Lcom/obric/assistant/interaction/impl/essentialtask/task/migration/MigrationStatus;", "internalExecute", "Lcom/obric/assistant/interaction/impl/essentialtask/base/ExecuteResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "internalNeedExecute", XmlPullParser.NO_NAMESPACE, "isMigrationHosting", "startMigrationHost", "successCount", XmlPullParser.NO_NAMESPACE, "Companion", "Memory", "AiAgent", "ZeusMigrationHandler", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
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

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005H\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/obric/assistant/interaction/impl/essentialtask/task/migration/DataMigrationTask$Companion;", XmlPullParser.NO_NAMESPACE, "<init>", "()V", "TAG", XmlPullParser.NO_NAMESPACE, "MEMORY_DATA_PLUGIN_PKG_NAME", "AI_AGENT_PLUGIN_PKG_NAME", "MEMORY_OLD_PKG", "AI_AGENT_OLD_PKG", "OBRIC_HOST_PKG_NAME", "REPO_NAME", "keva", "Lcom/bytedance/keva/Keva;", "kotlin.jvm.PlatformType", "getMigrationStatus", "Lcom/obric/assistant/interaction/impl/essentialtask/task/migration/MigrationStatus;", "pluginPkg", "isPacificProduct", XmlPullParser.NO_NAMESPACE, "loggerDependLazy", "Lkotlin/Lazy;", "Lcom/obric/assistant/interaction/impl/essentialtask/task/migration/TransferLoggerDependAdapter;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private final boolean isPacificProduct() {
            Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
            Object r1 = Result.m49constructorimpl(Boolean.valueOf(Intrinsics.areEqual(b.a().d(), "pacific")));     // Catch: Throwable -> L4
        L6:
            Throwable r2 = Result.m52exceptionOrNullimpl(r1);
            if (r2 == null) goto L9;
            FLogger.a.w(DataMigrationTask.TAG, "isPacificProduct failed: " + r2.getMessage(), r2);
        L9:
            Boolean r3 = Boolean.FALSE;
            if (Result.m55isFailureimpl(r1) == false) goto L13;
            r1 = r3;
        L13:
            return ((Boolean) r1).booleanValue();
        L4:
            th = move-exception;
            Result.Companion r4 = Result.Companion;
            r1 = Result.m49constructorimpl(ResultKt.createFailure(th));
            goto L6
        }

        public static final /* synthetic */ boolean access$isPacificProduct(Companion r0) {
            return r0.isPacificProduct();
        }

        private final MigrationStatus getMigrationStatus(String r4) {
            String r5 = DataMigrationTask.access$getKeva$cp().getString(r4, "IDLE");
            Intrinsics.checkNotNull(r5);     // Catch: IllegalArgumentException -> L5
            return MigrationStatus.valueOf(r5);
        L5:
            e = move-exception;
            FLogger.a.w(DataMigrationTask.TAG, "migration status parsing error", e);
            return MigrationStatus.IDLE;
        }

        public static final /* synthetic */ MigrationStatus access$getMigrationStatus(Companion r0, String r1) {
            return r0.getMigrationStatus(r1);
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\n"}, d2 = {"Lcom/obric/assistant/interaction/impl/essentialtask/task/migration/DataMigrationTask$ZeusMigrationHandler;", "Lcom/obric/assistant/zeus/plugin/IObricMigrationHandler;", "<init>", "()V", "isMigrationNeeded", XmlPullParser.NO_NAMESPACE, "pluginPkg", XmlPullParser.NO_NAMESPACE, "onInstallFinished", XmlPullParser.NO_NAMESPACE, "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
    public static final class ZeusMigrationHandler implements IObricMigrationHandler {
        public ZeusMigrationHandler() {
        }

        @Override // com.obric.assistant.zeus.plugin.IObricMigrationHandler
        public void onInstallFinished(String r2) {
            Intrinsics.checkNotNullParameter(r2, "pluginPkg");
        }

        @Override // com.obric.assistant.zeus.plugin.IObricMigrationHandler
        public boolean isMigrationNeeded(String r4) {
            Intrinsics.checkNotNullParameter(r4, "pluginPkg");
            if (Companion.access$isPacificProduct(DataMigrationTask.Companion) == true) goto L5;
            return false;
        L5:
            Iterator<T> r5 = TaskUtils.INSTANCE.getPlugins().iterator();
        L6:
            boolean r1 = false;
        L8:
            if (r5.hasNext() == false) goto L14;
            String r2 = (String) r5.next();
            if (r1 == true) goto L13;
            if (Companion.access$getMigrationStatus(DataMigrationTask.Companion, r2) == MigrationStatus.FINISHED) goto L6;
        L13:
            r1 = true;
            goto L8
        L14:
            return r1;
        }
    }

    public static /* synthetic */ TransferLoggerDependAdapter b() {
        return loggerDependLazy$lambda$3();
    }

    @Override // com.obric.assistant.interaction.impl.essentialtask.base.EssentialTask
    public Object internalExecute(Continuation<? super ExecuteResult> r1) {
        return internalExecute$suspendImpl(this, r1);
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
        Companion r0 = Companion;
        boolean r2 = false;
        if (Companion.access$isPacificProduct(r0) == true) goto L6;
        return false;
    L6:
        if (Companion.access$getMigrationStatus(r0, this.pluginPkg) == MigrationStatus.FINISHED) goto L8;
        r2 = true;
    L8:
        if (r2 == false) goto L12;
        Lazy<TransferLoggerDependAdapter> r1 = loggerDependLazy;
        if (r1.isInitialized() == true) goto L12;
        com.obric.datatransfer.logger.a r3 = TransferLogger.b;
        com.obric.datatransfer.logger.a r4 = r1.getValue();
        Intrinsics.checkNotNullParameter(r4, "depend");
        TransferLogger.b = r4;
    L12:
        return r2;
    }

    public static final /* synthetic */ Keva access$getKeva$cp() {
        return keva;
    }

    public static final /* synthetic */ String access$getPluginPkg$p(DataMigrationTask r0) {
        return r0.pluginPkg;
    }

    private final void startMigrationHost(int r9) {
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L16
        FLogger r5 = FLogger.a;     // Catch: Throwable -> L16
        r5.i(TAG, "startMigrationHost,successCount=" + r9 + ",isMigrationHosting=" + this.isMigrationHosting);     // Catch: Throwable -> L16
        if (this.isMigrationHosting == false) goto L6;
        return;
    L6:
        boolean r3 = true;
        this.isMigrationHosting = true;     // Catch: Throwable -> L16
        MigrationStatus r6 = Companion.access$getMigrationStatus(Companion, OBRIC_HOST_PKG_NAME);     // Catch: Throwable -> L16
        MigrationStatus r7 = MigrationStatus.FINISHED;     // Catch: Throwable -> L16
        if (r6 != r7) goto L10;
        r3 = false;
    L10:
        r5.i(TAG, "startMigrationHost needMigration = " + r3);     // Catch: Throwable -> L16
        if (r9 <= 0) goto L14;
        if (r3 == false) goto L14;
        ObricHostDataMigrationUtil.INSTANCE.startMigration();     // Catch: Throwable -> L16
        updateMigrationStatus(OBRIC_HOST_PKG_NAME, r7);     // Catch: Throwable -> L16
    L14:
        this.isMigrationHosting = false;     // Catch: Throwable -> L16
        Object r10 = Result.m49constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L16
    L18:
        Throwable r11 = Result.m52exceptionOrNullimpl(r10);
        if (r11 == null) goto L24;
        FLogger.a.e(TAG, "startMigrationHost fail:" + r11);
        return;
    L24:
        return;
    L16:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        r10 = Result.m49constructorimpl(ResultKt.createFailure(th));
        goto L18
    }

    public static final /* synthetic */ void access$startMigrationHost(DataMigrationTask r0, int r1) {
        r0.startMigrationHost(r1);
    }

    public static Object internalExecute$suspendImpl(DataMigrationTask r5, Continuation<? super ExecuteResult> r6) {
        FLogger r0 = FLogger.a;
        r0.i(TAG, "Starting migration for " + r5.pluginPkg);
        r5.updateMigrationStatus(r5.pluginPkg, MigrationStatus.IN_PROCESS);
        if (DataMigrationUtils.INSTANCE.isComponentEnabled(r5.getContext(), r5.oldPkg) == true) goto L6;
        r0.i(TAG, "old app " + r5.oldPkg + " not exists");
        r5.updateMigrationStatus(r5.pluginPkg, MigrationStatus.FINISHED);
        return new ExecuteResult.Succeed();
    L6:
        com.obric.datatransfer.client.b r1 = new com.obric.datatransfer.client.b(r5.getContext(), r5.authority);
        j r2 = new j(IntrinsicsKt.intercepted(r6), 1);
        r2.C();
        internalExecute.2.1 r3 = new internalExecute.2.1(r5, r2);
        Intrinsics.checkNotNullParameter(r3, "callback");
        ThreadMethodProxy.start(new PthreadThreadV2(new com.obric.datatransfer.client.a(r1, r3), "transfer-file-list"));
        r2.i(internalExecute.2.2.INSTANCE);
        Object r7 = r2.B();
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L9;
        DebugProbesKt.probeCoroutineSuspended(r6);
    L9:
        return r7;
    }

    private final void updateMigrationStatus(String r2, MigrationStatus r3) {
        keva.storeString(r2, r3.name());
    }

    public static final /* synthetic */ void access$updateMigrationStatus(DataMigrationTask r0, String r1, MigrationStatus r2) {
        r0.updateMigrationStatus(r1, r2);
    }

    public DataMigrationTask(Context r3, String r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "pluginPkg");
        Intrinsics.checkNotNullParameter(r5, "oldPkg");
        Intrinsics.checkNotNullParameter(r6, "authority");
        super(r3, r4 + ".migration");
        this.pluginPkg = r4;
        this.oldPkg = r5;
        this.authority = r6;
    }
}
