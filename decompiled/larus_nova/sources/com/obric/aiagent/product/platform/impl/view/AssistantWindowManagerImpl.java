package com.obric.aiagent.product.platform.impl.view;

import android.app.IAssistantWindowGestureListener;
import android.os.IBinder;
import android.view.AssistantWindowManager;
import android.view.Window;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.obric.aiagent.product.platform.api.view.IObricWindowManager;
import com.obric.aiagent.product.platform.api.view.ObricWindowGestureListener;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000  2\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J0\u0010\u0013\u001a\u00020\u000b2\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0006\u0010\u0010\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\u0018H\u0016J\u0018\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\u0018H\u0016J\u0010\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016¨\u0006!"}, d2 = {"Lcom/obric/aiagent/product/platform/impl/view/AssistantWindowManagerImpl;", "Lcom/obric/aiagent/product/platform/api/view/IObricWindowManager;", "<init>", "()V", "takeScreenshot", "Landroid/graphics/Bitmap;", "includePackages", "", "", "excludePackages", "isAutoActionRunning", "", "isAutoImeReady", "focusedWindowIsSecure", "isInputMethodShown", "registerInputMethodListener", "listener", "Lcom/obric/aiagent/product/platform/api/inputmethod/ObricInputMethodListener;", "unregisterInputMethodListener", "takeSurfaceControlScreenshot", "", "registerWindowGestureListener", "token", "Landroid/os/IBinder;", "Lcom/obric/aiagent/product/platform/api/view/ObricWindowGestureListener;", "unregisterWindowGestureListener", "setAssistantWindowInKeyguardMode", LiveEndPageData.TAG_WINDOW, "Landroid/view/Window;", "showGlobalActions", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "Companion", "product-platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AssistantWindowManagerImpl implements IObricWindowManager {

    public static final class a {
    }

    static {
    }

    public AssistantWindowManagerImpl() {
    }

    @Override // com.obric.aiagent.product.platform.api.view.IObricWindowManager
    public final boolean c(Window r100) {
        Intrinsics.checkNotNullParameter(r100, LiveEndPageData.TAG_WINDOW);
        return AssistantWindowManager.setAssistantWindowInKeyguardMode(r100);
    }

    @Override // com.obric.aiagent.product.platform.api.view.IObricWindowManager
    public final boolean a(IBinder r100, ObricWindowGestureListener r101) {
        Intrinsics.checkNotNullParameter(r100, "token");
        Intrinsics.checkNotNullParameter(r101, "listener");
        Object r102 = r101.getAssistantStub();
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type android.app.IAssistantWindowGestureListener");
        return AssistantWindowManager.registerWindowGestureListener(r100, (IAssistantWindowGestureListener) r102);
    }

    @Override // com.obric.aiagent.product.platform.api.view.IObricWindowManager
    public final boolean b(IBinder r100, ObricWindowGestureListener r101) {
        Intrinsics.checkNotNullParameter(r100, "token");
        Intrinsics.checkNotNullParameter(r101, "listener");
        Object r102 = r101.getAssistantStub();
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type android.app.IAssistantWindowGestureListener");
        return AssistantWindowManager.unregisterWindowGestureListener(r100, (IAssistantWindowGestureListener) r102);
    }
}
