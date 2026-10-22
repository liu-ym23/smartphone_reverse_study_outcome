package com.obric.assistant.interaction.impl.essentialtask.task.migration;

import android.content.Context;
import com.obric.datatransfer.logger.TransferLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/assistant/interaction/impl/essentialtask/task/migration/DataMigrationUtils;", "", "<init>", "()V", "logger", "Lcom/obric/datatransfer/logger/TransferLogger;", "isComponentEnabled", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "packageName", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DataMigrationUtils {
    public static final DataMigrationUtils INSTANCE = null;
    private static final TransferLogger logger = null;

    private DataMigrationUtils() {
    }

    static {
        INSTANCE = new DataMigrationUtils();
        com.obric.datatransfer.logger.a r100 = TransferLogger.f396682b;
        logger = TransferLogger.a.a("DataMigrationUtils_flow");
    }

    public final boolean isComponentEnabled(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "packageName");
        int r102 = r100.getPackageManager().getApplicationEnabledSetting(r101);     // Catch: Exception -> L9
        if (r102 == 1) goto L7;
        if (r102 == 0) goto L7;
        return false;
    L7:
        return true;
    L9:
        e = move-exception;
        logger.b("Error checking component enabled state", e);
        return false;
    }
}
