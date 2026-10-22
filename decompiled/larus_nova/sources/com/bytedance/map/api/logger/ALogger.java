package com.bytedance.map.api.logger;

import com.ss.android.agilelogger.ALog;

/* JADX INFO: loaded from: classes21.dex */
final class ALogger implements ILogger {
    public ALogger() {
    }

    @Override // com.bytedance.map.api.logger.ILogger
    public void d(String r100) {
        ALog.d(MapLogger.TAG, r100);     // Catch: Throwable -> L4
        return;
    }

    @Override // com.bytedance.map.api.logger.ILogger
    public void e(String r100) {
        ALog.e(MapLogger.TAG, r100);     // Catch: Throwable -> L4
        return;
    }

    @Override // com.bytedance.map.api.logger.ILogger
    public void i(String r100) {
        ALog.i(MapLogger.TAG, r100);     // Catch: Throwable -> L4
        return;
    }

    @Override // com.bytedance.map.api.logger.ILogger
    public void v(String r100) {
        ALog.v(MapLogger.TAG, r100);     // Catch: Throwable -> L4
        return;
    }

    @Override // com.bytedance.map.api.logger.ILogger
    public void w(String r100) {
        ALog.w(MapLogger.TAG, r100);     // Catch: Throwable -> L4
        return;
    }
}
