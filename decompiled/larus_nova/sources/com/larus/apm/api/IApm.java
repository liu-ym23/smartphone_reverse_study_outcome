package com.larus.apm.api;

import android.app.Application;
import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u0003H&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH&J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0005H&¨\u0006\u0013"}, d2 = {"Lcom/larus/apm/api/IApm;", "", "initLogAndALog", "", "debug", "", "maxALogDirSizeMb", "", "application", "Landroid/app/Application;", "initApm", "addLogObserver", "observer", "Lcom/larus/apm/api/ApmLogObserver;", "isMainProcess", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "registerDolaCloudControlConsumer", "isMinorMode", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IApm {
    void a(boolean r100, int r101, Application r102);

    void b(boolean r100);

    void c();

    boolean isMainProcess(Context r100);
}
