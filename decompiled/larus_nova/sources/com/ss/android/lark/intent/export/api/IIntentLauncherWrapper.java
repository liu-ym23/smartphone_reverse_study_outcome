package com.ss.android.lark.intent.export.api;

import android.content.Context;
import com.ss.android.lark.intent.export.entity.output.IntentOutput;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/intent/export/api/IIntentLauncherWrapper;", "", "launchIntent", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "intent", "Lcom/ss/android/lark/intent/export/entity/output/IntentOutput;", "intent-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IIntentLauncherWrapper {
    void launchIntent(Context r100, IntentOutput r101);
}
