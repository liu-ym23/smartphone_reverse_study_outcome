package com.larus.bitable.api;

import android.content.Context;
import android.os.Bundle;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\u0004J \u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\u000e\u001a\u00020\u0003H&¨\u0006\u000f"}, d2 = {"Lcom/larus/bitable/api/IBitableService;", "", "initSdkIfNeeded", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "openBitable", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "params", "Landroid/os/Bundle;", "page", "", "tryPrefetchData", "", "clearReference", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IBitableService {
    boolean c(Bundle r100);

    void d(Context r100, Bundle r101, String r102);
}
