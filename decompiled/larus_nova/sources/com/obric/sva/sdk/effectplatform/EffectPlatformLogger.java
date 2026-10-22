package com.obric.sva.sdk.effectplatform;

import bytekn.foundation.logger.ILogger;
import com.obric.sva.sdk.utils.LogUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0018\u0010\u0010\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J \u0010\u0010\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016R$\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/obric/sva/sdk/effectplatform/EffectPlatformLogger;", "Lbytekn/foundation/logger/ILogger;", "<init>", "()V", "value", "", "enabled", "getEnabled", "()Z", "setEnabled", "(Z)V", "logDebug", "", "tag", "", "message", "logError", com.bytedance.android.ec.core.event.a.KEY_EXCEPTION, "", "logWarn", "Companion", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EffectPlatformLogger implements ILogger {
    public static final Companion Companion = null;
    private static final String TAG = "EffectPlatformLogger";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/sva/sdk/effectplatform/EffectPlatformLogger$Companion;", "", "<init>", "()V", "TAG", "", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public EffectPlatformLogger() {
    }

    @Override // bytekn.foundation.logger.ILogger
    public boolean getEnabled() {
        return false;
    }

    @Override // bytekn.foundation.logger.ILogger
    public void setEnabled(boolean r100) {
    }

    @Override // bytekn.foundation.logger.ILogger
    public void logDebug(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "message");
        LogUtils.d(TAG, r100 + "- " + r101, new Object[0]);
    }

    @Override // bytekn.foundation.logger.ILogger
    public void logError(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "message");
        LogUtils.e(TAG, r100 + "- " + r101, new Object[0]);
    }

    @Override // bytekn.foundation.logger.ILogger
    public void logWarn(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "message");
        LogUtils.e(TAG, r100 + "- " + r101, new Object[0]);
    }

    @Override // bytekn.foundation.logger.ILogger
    public void logError(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "message");
        Intrinsics.checkNotNullParameter(r102, com.bytedance.android.ec.core.event.a.KEY_EXCEPTION);
        LogUtils.e(TAG, r100 + "- " + r101, new Object[]{r102});
    }
}
