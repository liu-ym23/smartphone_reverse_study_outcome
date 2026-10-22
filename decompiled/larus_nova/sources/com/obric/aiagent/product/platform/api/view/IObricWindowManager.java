package com.obric.aiagent.product.platform.api.view;

import android.os.IBinder;
import android.view.Window;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dJ*\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\tH&J\b\u0010\u000b\u001a\u00020\tH&J\b\u0010\f\u001a\u00020\tH&J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH&J0\u0010\u0011\u001a\u00020\t2\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u0001H&J\u0018\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u0015H&J\u0018\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u0015H&J\u0010\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0019H&J\u0010\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001cH&¨\u0006\u001e"}, d2 = {"Lcom/obric/aiagent/product/platform/api/view/IObricWindowManager;", "", "takeScreenshot", "Landroid/graphics/Bitmap;", "includePackages", "", "", "excludePackages", "isAutoActionRunning", "", "isAutoImeReady", "focusedWindowIsSecure", "isInputMethodShown", "registerInputMethodListener", "listener", "Lcom/obric/aiagent/product/platform/api/inputmethod/ObricInputMethodListener;", "unregisterInputMethodListener", "takeSurfaceControlScreenshot", "registerWindowGestureListener", "token", "Landroid/os/IBinder;", "Lcom/obric/aiagent/product/platform/api/view/ObricWindowGestureListener;", "unregisterWindowGestureListener", "setAssistantWindowInKeyguardMode", LiveEndPageData.TAG_WINDOW, "Landroid/view/Window;", "showGlobalActions", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "Companion", "product-platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IObricWindowManager {
    boolean a(IBinder r100, ObricWindowGestureListener r101);

    boolean b(IBinder r100, ObricWindowGestureListener r101);

    boolean c(Window r100);
}
