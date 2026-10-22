package com.ttnet.org.chromium.net.impl;

/* JADX INFO: loaded from: classes5.dex */
public final class NoOpLogger extends CronetLogger {
    @Override // com.ttnet.org.chromium.net.impl.CronetLogger
    public void logCronetEngineCreation(int r100, CronetLogger.CronetEngineBuilderInfo r101, CronetLogger.CronetVersion r102, CronetLogger.CronetSource r103) {
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetLogger
    public void logCronetTrafficInfo(int r100, CronetLogger.CronetTrafficInfo r101) {
    }

    public NoOpLogger() {
    }
}
