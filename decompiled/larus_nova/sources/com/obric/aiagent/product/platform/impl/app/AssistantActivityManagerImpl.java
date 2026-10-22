package com.obric.aiagent.product.platform.impl.app;

import android.app.ActivityManager;
import android.content.AssistantIntentController;
import android.content.Context;
import android.content.Intent;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.product.platform.api.app.IObricActivityManager;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.tencent.open.SocialConstants;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 A2\u00020\u0001:\u0001AB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u0005H\u0016J\u000f\u0010\r\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0002\u0010\u000eJ \u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\nH\u0016J \u0010\u0014\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J#\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00152\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\f0\u001cH\u0016¢\u0006\u0002\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001a\u001a\u00020\u0015H\u0016J\u0010\u0010 \u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020!H\u0016J\u0010\u0010\"\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020!H\u0016J \u0010#\u001a\u00020\n2\u0006\u0010$\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\nH\u0016J\u0010\u0010&\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\nH\u0016J\u0010\u0010(\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020\nH\u0016J\u001b\u0010*\u001a\u00020\u001f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u001cH\u0016¢\u0006\u0002\u0010+J\u0010\u0010,\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020-H\u0016J\u0010\u0010.\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020-H\u0016J\u0010\u0010/\u001a\u00020\n2\u0006\u0010\u0017\u001a\u000200H\u0016J\u0010\u00101\u001a\u00020\n2\u0006\u0010\u0017\u001a\u000200H\u0016J\u0010\u00102\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020-H\u0016J\u0010\u00103\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020-H\u0016J\u001f\u00104\u001a\u00020\n2\u0006\u00105\u001a\u00020\f2\f\u00106\u001a\b\u0012\u0004\u0012\u00020\n07H\u0082\bJ\u0010\u00108\u001a\u00020\n2\u0006\u00109\u001a\u00020:H\u0016J\u0016\u0010;\u001a\u00020\u001f2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\f0=H\u0016J\u0010\u0010>\u001a\u00020\u001f2\u0006\u0010?\u001a\u00020@H\u0016¨\u0006B"}, d2 = {"Lcom/obric/aiagent/product/platform/impl/app/AssistantActivityManagerImpl;", "Lcom/obric/aiagent/product/platform/api/app/IObricActivityManager;", "<init>", "()V", "getAutoDisplayId", "", "getCurrentTaskInfo", "Landroid/app/ActivityManager$RunningTaskInfo;", "displayId", "isPackageVisibleOnDisplay", "", "packageName", "", "isAutoActionTopActivityInSystemAnimation", "()Ljava/lang/Boolean;", "requestTopActivityAssistData", "requestId", SocialConstants.PARAM_RECEIVER, "Landroid/app/ITopActivityAssistDataReceiver;", "supportsAutoVirtualDisplayRecordSet", "beginAutoVirtualDisplayRecordSet", "", "userId", "listener", "Lcom/obric/aiagent/product/platform/api/app/ObricAutoVirtualDisplayRecordSetListener;", "addAutoVirtualDisplayRecordPackages", "sessionId", "packageNames", "", "(J[Ljava/lang/String;)Z", "endAutoVirtualDisplayRecordSet", "", "registerTaskStackListenerEx", "Lcom/obric/aiagent/product/platform/api/app/ObricTaskStackListener;", "unregisterTaskStackListenerEx", "moveTaskToDisplay", DBDefinition.TASK_ID, "isTop", "tryToMute", "shouldMute", "enableCallUser", "enable", "addDisablePackage", "([Ljava/lang/String;)V", "registerBackNavigationInVirtualDisplayListenerEx", "Lcom/obric/aiagent/product/platform/api/app/ObricBackNavigationListener;", "unregisterBackNavigationInVirtualDisplayListenerEx", "registerObricDisplayInfoCallback", "Lcom/obric/aiagent/product/platform/api/app/ObricDisplayInfoCallback;", "unregisterObricDisplayInfoCallback", "registerBackNavigationListener", "unregisterBackNavigationListener", "safeFrameworkBooleanCall", "methodName", "block", "Lkotlin/Function0;", "forceStopPackageOfCaller", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "setMuteWhitelist", "whiteList", "", "addExtraTaskNotTrimFlag", "intent", "Landroid/content/Intent;", "Companion", "product-platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AssistantActivityManagerImpl implements IObricActivityManager {

    /* JADX INFO: loaded from: classes32.dex */
    public static final class a {
    }

    static {
    }

    public AssistantActivityManagerImpl() {
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
    public final boolean a(Context r110) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Object r111 = r110.getSystemService("activity");     // Catch: Throwable -> L19
        if ((r111 instanceof ActivityManager) == false) goto L6;
        ActivityManager r112 = (ActivityManager) r111;     // Catch: Throwable -> L19
    L7:
        if (r112 != null) goto L10;
        ILogDepend.f384986a.e("AssistantActivityManagerImpl", "get ActivityManagerService failed");     // Catch: Throwable -> L19
        return false;
    L10:
        String r100 = IAppContext.f384977a.getPackageName();     // Catch: Throwable -> L19
        if (r100.length() != 0) goto L13;
        boolean r101 = true;
    L14:
        if (r101 == false) goto L17;
        ILogDepend.f384986a.e("AssistantActivityManagerImpl", "packageName empty");     // Catch: Throwable -> L19
        return false;
    L17:
        Method r102 = r112.getClass().getDeclaredMethod("forceStopPackage", new Class[]{String.class});     // Catch: Throwable -> L19
        r102.setAccessible(true);     // Catch: Throwable -> L19
        ILogDepend.f384986a.i("AssistantActivityManagerImpl", "try forceStopPackage " + r100);     // Catch: Throwable -> L19
        r102.invoke(r112, new Object[]{r100});     // Catch: Throwable -> L19
        return true;
    L13:
        r101 = false;
        goto L14
    L6:
        r112 = null;
    L19:
        th = move-exception;
        ILogDepend.f384986a.e("AssistantActivityManagerImpl", "forceStopPackage exception", th);
        return false;
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
    public final void b(Intent r100) {
        Intrinsics.checkNotNullParameter(r100, "intent");
        AssistantIntentController.setAssistantFlags(r100, 16);     // Catch: Throwable -> L5
        ILogDepend.f384986a.i("AssistantActivityManagerImpl", "addExtraTaskNotTrimFlag called");     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        ILogDepend.f384986a.e("AssistantActivityManagerImpl", "addExtraTaskNotTrimFlag exception", th);
    }
}
