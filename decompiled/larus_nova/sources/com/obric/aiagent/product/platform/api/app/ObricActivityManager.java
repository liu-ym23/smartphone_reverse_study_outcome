package com.obric.aiagent.product.platform.api.app;

import android.content.Context;
import android.content.Intent;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.aweme.framework.services.SingletonProvider;
import com.tencent.open.SocialConstants;
import iaa.b;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import x9a.a;

/* JADX INFO: loaded from: classes6.dex */
public final class ObricActivityManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f385005a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final IObricActivityManager f385006b = null;

    @Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\bH\u0017J\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\bH\u0017J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\bH\u0017J\u000f\u0010\u0010\u001a\u0004\u0018\u00010\u000eH\u0017¢\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\u000eH\u0017J \u0010\u0013\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0017J#\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u00142\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u001bH\u0017¢\u0006\u0002\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\u0014H\u0017J \u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010!\u001a\u00020\"H\u0017J\u0010\u0010#\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020$H\u0017J\u0010\u0010%\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020$H\u0017J \u0010&\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010(\u001a\u00020\u000eH\u0017J\u0010\u0010)\u001a\u00020\u001e2\u0006\u0010*\u001a\u00020\u000eH\u0017J\u0010\u0010+\u001a\u00020\u001e2\u0006\u0010,\u001a\u00020\u000eH\u0017J\u001b\u0010-\u001a\u00020\u001e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u001bH\u0017¢\u0006\u0002\u0010.J\u0010\u0010/\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u000200H\u0017J\u0010\u00101\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u000200H\u0017J\u0010\u00102\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u000203H\u0017J\u0010\u00104\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u000203H\u0017J\u0010\u00105\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u000200H\u0017J\u0010\u00106\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u000200H\u0017J\u0010\u00107\u001a\u00020\u000e2\u0006\u00108\u001a\u000209H\u0017J\u0016\u0010:\u001a\u00020\u001e2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00050<H\u0017J\u0010\u0010=\u001a\u00020\u001e2\u0006\u0010>\u001a\u00020?H\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Lcom/obric/aiagent/product/platform/api/app/ObricActivityManager$Companion;", "Lcom/obric/aiagent/product/platform/api/app/IObricActivityManager;", "<init>", "()V", "TAG", "", "instance", "FLAG_SM_TASK_NOT_TRIMMABLE", "", "getAutoDisplayId", "getCurrentTaskInfo", "Landroid/app/ActivityManager$RunningTaskInfo;", "displayId", "isPackageVisibleOnDisplay", "", "packageName", "isAutoActionTopActivityInSystemAnimation", "()Ljava/lang/Boolean;", "supportsAutoVirtualDisplayRecordSet", "beginAutoVirtualDisplayRecordSet", "", "userId", "listener", "Lcom/obric/aiagent/product/platform/api/app/ObricAutoVirtualDisplayRecordSetListener;", "addAutoVirtualDisplayRecordPackages", "sessionId", "packageNames", "", "(J[Ljava/lang/String;)Z", "endAutoVirtualDisplayRecordSet", "", "requestTopActivityAssistData", "requestId", SocialConstants.PARAM_RECEIVER, "Landroid/app/ITopActivityAssistDataReceiver;", "registerTaskStackListenerEx", "Lcom/obric/aiagent/product/platform/api/app/ObricTaskStackListener;", "unregisterTaskStackListenerEx", "moveTaskToDisplay", DBDefinition.TASK_ID, "isTop", "tryToMute", "shouldMute", "enableCallUser", "enable", "addDisablePackage", "([Ljava/lang/String;)V", "registerBackNavigationInVirtualDisplayListenerEx", "Lcom/obric/aiagent/product/platform/api/app/ObricBackNavigationListener;", "unregisterBackNavigationInVirtualDisplayListenerEx", "registerObricDisplayInfoCallback", "Lcom/obric/aiagent/product/platform/api/app/ObricDisplayInfoCallback;", "unregisterObricDisplayInfoCallback", "registerBackNavigationListener", "unregisterBackNavigationListener", "forceStopPackageOfCaller", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "setMuteWhitelist", "whiteList", "", "addExtraTaskNotTrimFlag", "intent", "Landroid/content/Intent;", "product-platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion implements IObricActivityManager {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }

        @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
        @JvmStatic
        public final boolean a(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            IObricActivityManager r101 = ObricActivityManager.f385006b;
            if (r101 != null) goto L7;
            return false;
        L7:
            return r101.a(r100);
        }

        @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
        @JvmStatic
        public final void b(Intent r100) {
            Intrinsics.checkNotNullParameter(r100, "intent");
            IObricActivityManager r101 = ObricActivityManager.f385006b;
            if (r101 == null) goto L6;
            r101.b(r100);
            return;
        }
    }

    static {
        f385005a = new Companion(0);
        b.f488963a.getClass();     // Catch: Throwable -> L9
        if (b.d() == false) goto L6;
        ServiceManager.get().bind(IObricActivityManager.class, new SingletonProvider(new a()));     // Catch: Throwable -> L9
    L7:
        ILogDepend.f384986a.i("ObricActivityManager", "bind ActivityManager assistantApi= " + b.d());     // Catch: Throwable -> L9
    L11:
        IObricActivityManager r100 = (IObricActivityManager) ServiceManager.get().getService(IObricActivityManager.class, false);
        f385006b = r100;
        ILogDepend.f384986a.i("ObricActivityManager", "ObricActivityManager instance: " + r100);
        return;
    L6:
        ServiceManager.get().bind(IObricActivityManager.class, new SingletonProvider(new x9a.b()));     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        ILogDepend.f384986a.e("ObricActivityManager", "bind CommonActivityManager failed", th);
        goto L11
    }
}
