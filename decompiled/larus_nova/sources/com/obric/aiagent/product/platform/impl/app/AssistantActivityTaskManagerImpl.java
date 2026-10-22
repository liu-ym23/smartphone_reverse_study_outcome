package com.obric.aiagent.product.platform.impl.app;

import android.app.ActivityManager;
import android.content.Context;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.product.platform.api.app.IObricActivityTaskManager;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\nH\u0016J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\rH\u0016J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0010H\u0016J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0014H\u0016¨\u0006\u0016"}, d2 = {"Lcom/obric/aiagent/product/platform/impl/app/AssistantActivityTaskManagerImpl;", "Lcom/obric/aiagent/product/platform/api/app/IObricActivityTaskManager;", "<init>", "()V", "registerAppSwitchListener", "", "listener", "Lcom/obric/aiagent/product/platform/api/app/ObricAppSwitchListener;", "unregisterAppSwitchListener", "registerActivitySwitchListener", "Lcom/obric/aiagent/product/platform/api/app/ObricActivitySwitchListener;", "unregisterActivitySwitchListener", "registerFocusListener", "Lcom/obric/aiagent/product/platform/api/app/ObricFocusListener;", "unregisterFocusListener", "registerSystemAnimationListener", "Lcom/obric/aiagent/product/platform/api/app/ObricSystemAnimationListener;", "unregisterSystemAnimationListener", "finishAndRemoveAllTask", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "Companion", "product-platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AssistantActivityTaskManagerImpl implements IObricActivityTaskManager {

    /* JADX INFO: loaded from: classes32.dex */
    public static final class a {
    }

    static {
    }

    public AssistantActivityTaskManagerImpl() {
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityTaskManager
    public final boolean a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Object r101 = r100.getSystemService("activity");     // Catch: Throwable -> L17
        if ((r101 instanceof ActivityManager) == false) goto L6;
        ActivityManager r102 = (ActivityManager) r101;     // Catch: Throwable -> L17
    L7:
        if (r102 != null) goto L10;
        ILogDepend.f384986a.e("CommonActivityManager", "get ActivityManagerService failed");     // Catch: Throwable -> L17
        return false;
    L10:
        ILogDepend.f384986a.i("AssistantActivityTaskManagerImpl", "finishAndRemoveAllTask on Android 5.0+");     // Catch: Throwable -> L17
        Iterator<T> r103 = r102.getAppTasks().iterator();     // Catch: Throwable -> L17
    L12:
        if (r103.hasNext() == false) goto L15;
        ((ActivityManager.AppTask) r103.next()).finishAndRemoveTask();     // Catch: Throwable -> L17
        goto L12
    L15:
        return true;
    L6:
        r102 = null;
    L17:
        th = move-exception;
        ILogDepend.f384986a.e("AssistantActivityTaskManagerImpl", "finishAndRemoveAllTask failed", th);
        return false;
    }
}
