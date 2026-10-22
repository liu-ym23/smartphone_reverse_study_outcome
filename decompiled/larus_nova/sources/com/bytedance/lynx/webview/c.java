package com.bytedance.lynx.webview;

import android.content.Context;
import com.bytedance.lynx.webview.internal.EventStatistics;
import com.bytedance.lynx.webview.internal.ProcessFeatureIndex;
import com.bytedance.lynx.webview.internal.TTWebContext;

/* JADX INFO: loaded from: classes21.dex */
public final class c {
    public static void a(Context r100, sg9.a r101) {
        if (TTWebContext.c(r100) != null) goto L5;
        return;
    L5:
        if (TTWebContext.h().u(ProcessFeatureIndex.ENABLE_UPLOAD_DATA.value()) == false) goto L17;
        int r102 = EventStatistics.f265113a;
        monitor-enter(EventStatistics.class);
        EventStatistics.f265120h = r101;     // Catch: Throwable -> L11
        monitor-exit(EventStatistics.class);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }
}
