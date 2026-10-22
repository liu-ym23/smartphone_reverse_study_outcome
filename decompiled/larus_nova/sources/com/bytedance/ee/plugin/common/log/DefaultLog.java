package com.bytedance.ee.plugin.common.log;

import android.util.Log;

/* JADX INFO: loaded from: classes19.dex */
class DefaultLog implements ILog {
    public DefaultLog() {
    }

    @Override // com.bytedance.ee.plugin.common.log.ILog
    public void d(String r100) {
    }

    @Override // com.bytedance.ee.plugin.common.log.ILog
    public void e(String r100) {
    }

    @Override // com.bytedance.ee.plugin.common.log.ILog
    public void i(String r100) {
    }

    @Override // com.bytedance.ee.plugin.common.log.ILog
    public void e(Throwable r100) {
        Log.getStackTraceString(r100);
    }
}
