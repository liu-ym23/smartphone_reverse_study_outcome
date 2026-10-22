package com.ss.android.lark.officesdk.launcher;

import android.content.Context;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larksuite.framework.launch.task.AbstractLaunchTask;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/officesdk/launcher/InitOfficeSdkBdTuringTask;", "Lcom/larksuite/framework/launch/task/AbstractLaunchTask;", "", "<init>", "()V", "execute", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "officesdk-assemble_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InitOfficeSdkBdTuringTask extends AbstractLaunchTask<Object> {
    public InitOfficeSdkBdTuringTask() {
    }

    @Override // com.larksuite.framework.launch.task.AbstractLaunchTask, com.larksuite.framework.launch.task.ILaunchTask
    public final void a(Context r100) {
        tyb.a r101 = tyb.a.f548019a;
        UICallbackExecutor.execute(tyb.b.f548028a);
    }
}
