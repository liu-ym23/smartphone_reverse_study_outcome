package com.ss.android.lark.intent.export.api;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.ss.android.common.applog.EventVerify;
import com.ss.android.lark.intent.export.entity.output.IntentOutput;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003J\u001d\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00028\u0000H&¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/intent/export/api/IntentLauncher;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/ss/android/lark/intent/export/entity/output/IntentOutput;", "", EventVerify.TYPE_LAUNCH, "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "data", "(Landroid/content/Context;Lcom/ss/android/lark/intent/export/entity/output/IntentOutput;)Z", "intent-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IntentLauncher<T extends IntentOutput> {
    boolean launch(Context r100, T r101);
}
