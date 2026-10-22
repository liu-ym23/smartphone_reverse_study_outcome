package com.bytedance.lynx.webview.internal;

import com.bytedance.lynx.webview.glue.TTWebProviderWrapper;

/* JADX INFO: loaded from: classes21.dex */
public final class m implements TTWebProviderWrapper.EventCallback {
    public m() {
    }

    @Override // com.bytedance.lynx.webview.glue.TTWebProviderWrapper.EventCallback
    public final void sendEnsureTime(long r100) {
        EventStatistics.e(EventType.LOAD_TRACE_EVENT_ENSURE, Long.valueOf(r100));
    }
}
