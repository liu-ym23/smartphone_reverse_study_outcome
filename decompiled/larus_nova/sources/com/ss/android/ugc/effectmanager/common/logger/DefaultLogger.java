package com.ss.android.ugc.effectmanager.common.logger;

import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J\u001c\u0010\b\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/ss/android/ugc/effectmanager/common/logger/DefaultLogger;", "Lcom/ss/android/ugc/effectmanager/common/logger/ILogger;", "()V", "DEFAULT_TAG", "", "d", "", "msg", "e", "t", "", RXScreenCaptureService.KEY_INDEX, "w", "effectmanager_release"}, k = 1, mv = {1, 1, 16})
public final class DefaultLogger implements ILogger {
    private static final String DEFAULT_TAG = "DefaultEPLog";
    public static final DefaultLogger INSTANCE = null;

    private DefaultLogger() {
    }

    @Override // com.ss.android.ugc.effectmanager.common.logger.ILogger
    public void e(String r100, Throwable r101) {
    }

    static {
        INSTANCE = new DefaultLogger();
    }

    @Override // com.ss.android.ugc.effectmanager.common.logger.ILogger
    public void d(String r100) {
        EPLog.INSTANCE.getSEnableLog();
    }

    @Override // com.ss.android.ugc.effectmanager.common.logger.ILogger
    public void i(String r100) {
        EPLog.INSTANCE.getSEnableLog();
    }

    @Override // com.ss.android.ugc.effectmanager.common.logger.ILogger
    public void w(String r100) {
        EPLog.INSTANCE.getSEnableLog();
    }
}
