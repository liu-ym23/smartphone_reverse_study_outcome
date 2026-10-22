package com.obric.assistant.interaction.impl.essentialtask.task;

import android.content.Context;
import com.obric.assistant.interaction.impl.essentialtask.base.EssentialTask;
import com.obric.assistant.interaction.impl.essentialtask.base.ExecuteResult;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.volcengine.zeus.Zeus;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u0007H\u0094@¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0014¨\u0006\u000b"}, d2 = {"Lcom/obric/assistant/interaction/impl/essentialtask/task/InstallDownloadPluginTask;", "Lcom/obric/assistant/interaction/impl/essentialtask/base/EssentialTask;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "internalExecute", "Lcom/obric/assistant/interaction/impl/essentialtask/base/ExecuteResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "internalNeedExecute", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InstallDownloadPluginTask extends EssentialTask {
    @Override // com.obric.assistant.interaction.impl.essentialtask.base.EssentialTask
    public boolean internalNeedExecute() {
        return true;
    }

    public InstallDownloadPluginTask(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, "install_download_plugin");
    }

    @Override // com.obric.assistant.interaction.impl.essentialtask.base.EssentialTask
    public Object internalExecute(Continuation<? super ExecuteResult> r100) {
        Zeus.installFromDownloadDir();
        return new ExecuteResult.Succeed();
    }
}
