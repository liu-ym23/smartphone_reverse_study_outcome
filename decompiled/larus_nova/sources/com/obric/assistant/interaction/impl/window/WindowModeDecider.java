package com.obric.assistant.interaction.impl.window;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.provider.Settings;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.debug.api.IObricDebugService;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\nJ\b\u0010\u0012\u001a\u00020\nH\u0002J\u0006\u0010\u0013\u001a\u00020\nJ\b\u0010\u0014\u001a\u00020\nH\u0002J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\f\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/WindowModeDecider;", "", "<init>", "()V", "TAG", "", "KEY_FEATURE_WINDOW_MODE", "CONFIG_REFRESH_INTERVAL_MS", "", "isWindowModeEnabledCache", "", "Ljava/lang/Boolean;", "lastConfigUpdateTime", "configUpdateLock", "shouldUseWindowMode", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "isWindowFeatureEnabled", "getWindowFeatureEnableConfig", "isNewGlobalPanelBlockedByPermission", "isRomSupported", "hasOverlayPermission", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WindowModeDecider {
    private static final long CONFIG_REFRESH_INTERVAL_MS = 1800000;
    public static final WindowModeDecider INSTANCE = null;
    private static final String KEY_FEATURE_WINDOW_MODE = "obric_feature_window_mode";
    private static final String TAG = "WindowModeDecider";
    private static final Object configUpdateLock = null;
    private static volatile Boolean isWindowModeEnabledCache;
    private static volatile long lastConfigUpdateTime;

    private WindowModeDecider() {
    }

    static {
        INSTANCE = new WindowModeDecider();
        configUpdateLock = new Object();
    }

    private final boolean getWindowFeatureEnableConfig() {
        Object r100 = configUpdateLock;
        monitor-enter(r100);
        long r101 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L18
        if (r101 >= lastConfigUpdateTime) goto L7;
    L10:
        isWindowModeEnabledCache = Boolean.valueOf(t9a.b.a().c(KEY_FEATURE_WINDOW_MODE));     // Catch: Throwable -> L18
        lastConfigUpdateTime = r101;     // Catch: Throwable -> L18
    L11:
        Boolean r102 = isWindowModeEnabledCache;     // Catch: Throwable -> L18
        if (r102 == null) goto L15;
        boolean r103 = r102.booleanValue();     // Catch: Throwable -> L18
    L16:
        monitor-exit(r100);
        return r103;
    L15:
        r103 = true;
        goto L16
    L7:
        if ((r101 - lastConfigUpdateTime) > 1800000) goto L10;
        if (isWindowModeEnabledCache != null) goto L11;
    L18:
        th = move-exception;
        throw th;
    }

    private final boolean isRomSupported() {
        if (Build.VERSION.SDK_INT < 23) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isWindowFeatureEnabled() {
        if (AppHost.f326268a.isDebug() == false) goto L7;
        return true;
    L7:
        return getWindowFeatureEnableConfig();
    }

    public final boolean isNewGlobalPanelBlockedByPermission() {
        if (isWindowFeatureEnabled() == true) goto L5;
    L7:
        return false;
    L5:
        if (hasOverlayPermission(AppHost.f326268a.getApplication()) == true) goto L7;
        return true;
    }

    private final boolean hasOverlayPermission(Context r100) {
        if (Build.VERSION.SDK_INT >= 23) goto L7;
        return true;
    L7:
        return Settings.canDrawOverlays(r100.getApplicationContext());
    }

    public final boolean shouldUseWindowMode(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        IObricDebugService r101 = (IObricDebugService) ServiceManager.get().getService(IObricDebugService.class);     // Catch: Exception -> L25
        if (r101 != null) goto L6;
    L8:
        boolean r102 = false;
    L9:
        if (r102 == false) goto L13;
        FLogger.f375446a.i(TAG, "window mode disabled: O Common test switch disabled");     // Catch: Exception -> L25
        return false;
    L13:
        if (isRomSupported() == true) goto L17;
        FLogger.f375446a.i(TAG, "window mode disabled: rom not supported, sdk=" + Build.VERSION.SDK_INT);     // Catch: Exception -> L25
        return false;
    L17:
        if (hasOverlayPermission(r100) == true) goto L21;
        FLogger.f375446a.i(TAG, "window mode disabled: overlay permission denied");     // Catch: Exception -> L25
        return false;
    L21:
        if (isWindowFeatureEnabled() == true) goto L24;
        FLogger.f375446a.i(TAG, "window mode disabled: cloud feature disabled");     // Catch: Exception -> L25
        return false;
    L24:
        return true;
    L6:
        if (r101.a() != true) goto L8;
        r102 = true;
    L25:
        e = move-exception;
        FLogger.f375446a.e(TAG, "shouldUseWindowMode error, fallback to Activity mode", e);
        return true;
    }
}
