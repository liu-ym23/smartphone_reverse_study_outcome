package com.larus.vesdk.impl.effectplatform;

import bytekn.foundation.logger.ILogger;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class b implements ILogger {

    public static final class a {
    }

    static {
    }

    public b() {
    }

    @Override // bytekn.foundation.logger.ILogger
    public final boolean getEnabled() {
        return false;
    }

    @Override // bytekn.foundation.logger.ILogger
    public final void setEnabled(boolean r100) {
    }

    @Override // bytekn.foundation.logger.ILogger
    public final void logDebug(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "message");
        FLogger.f375446a.d("EffectPlatformLogger", r100 + "- " + r101);
    }

    @Override // bytekn.foundation.logger.ILogger
    public final void logError(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "message");
        FLogger.f375446a.e("EffectPlatformLogger", r100 + "- " + r101);
    }

    @Override // bytekn.foundation.logger.ILogger
    public final void logWarn(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "message");
        FLogger.f375446a.w("EffectPlatformLogger", r100 + "- " + r101);
    }

    @Override // bytekn.foundation.logger.ILogger
    public final void logError(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "message");
        Intrinsics.checkNotNullParameter(r102, com.bytedance.android.ec.core.event.a.KEY_EXCEPTION);
        FLogger.f375446a.e("EffectPlatformLogger", r100 + "- " + r101, r102);
    }
}
