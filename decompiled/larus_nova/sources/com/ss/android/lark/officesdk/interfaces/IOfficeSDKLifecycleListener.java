package com.ss.android.lark.officesdk.interfaces;

import android.content.Context;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/officesdk/interfaces/IOfficeSDKLifecycleListener;", "", WidgetCostModule.TYPE_ON_START, "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "onResume", "onPause", "officesdk-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IOfficeSDKLifecycleListener {
    void onPause(Context r100);

    void onResume(Context r100);

    void onStart(Context r100);
}
