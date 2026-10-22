package nfa;

import android.app.Activity;
import android.app.ActivityManager;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.IAgentAppIntentIDL;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes33.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f518974a = null;

    static {
        f518974a = new a();
    }

    public a() {
    }

    public final void stopService() {
        AppHost.Companion r100 = AppHost.f326268a;
        if (r100.a().getCurrentActivity() == null) goto L14;
        IAgentAppIntentIDL r101 = com.obric.aiagent.assistant.idl.a.a(Reflection.getOrCreateKotlinClass(IAgentAppIntentIDL.class));
        if (r101 == null) goto L7;
        r101.terminateService();
    L7:
        Activity r102 = r100.a().getCurrentActivity();
        Intrinsics.checkNotNull(r102);
        Object r103 = r102.getSystemService("activity");
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type android.app.ActivityManager");
    L12:
        e = move-exception;
        e.printStackTrace();
        FLogger.f375446a.i("AppStopServiceManager", "stop service failed: " + e.getMessage());
        return;
    L9:
        if (((ActivityManager) r103).clearApplicationUserData() == false) goto L18;
        System.exit(0);     // Catch: Exception -> L12
        FLogger.f375446a.i("AppStopServiceManager", "stop service success，now exit doubao pc and aikernel service");     // Catch: Exception -> L12
        return;
    L18:
        return;
    L14:
        FLogger.f375446a.i("AppStopServiceManager", "stopService failed , currentActivity is null");
    }
}
