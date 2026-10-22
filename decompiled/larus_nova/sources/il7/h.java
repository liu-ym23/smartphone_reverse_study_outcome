package il7;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import java.util.concurrent.atomic.AtomicBoolean;
import me.ele.lancet.base.annotations.Skip;
import rk7.u;

/* JADX INFO: loaded from: classes22.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f490332a;

    public static String c() {
        ek7.a r100 = rk7.f.c();
        if (r100 != null) goto L5;
        return "";
    L5:
        return r100.getSDKVersionName();
    }

    public static String b(Context r100) {
        if (r100 != null) goto L7;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogUtils", "getAppVersionName() context为空，return");
        return f490332a;
    L7:
        if (TextUtils.isEmpty(f490332a) == false) goto L9;
        AtomicBoolean r101 = u.f538372v;
        if (u.c.f538395a.e() == true) goto L23;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogUtils", "getAppVersionName() 没有同意隐私弹窗，return");
        return "";
    L23:
        f490332a = r100.getApplicationContext().getPackageManager().getPackageInfo(r100.getPackageName(), 0).versionName;     // Catch: PackageManager.NameNotFoundException -> L16
    L19:
        if (f490332a != null) goto L22;
        f490332a = "";
    L22:
        return f490332a;
    L16:
        e = move-exception;
        com.bytedance.ug.sdk.luckydog.api.log.d.b("", e.getMessage());
        goto L19
    L9:
        return f490332a;
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent a(Context r100, IntentFilter r110) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L42;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L42:
    L36:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L40;
        throw e;
    L40:
        return ReceiverRegisterCrashOptimizer.registerReceiver(null, r110);
    L7:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L25;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r110) == false) goto L25;
        ReceiverRegisterAnrOptimizer.ResultWrapper r101 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(null, r110, 0, null, null, 2, r100);     // Catch: Exception -> L36
        int r102 = r101.result;     // Catch: Exception -> L36
        if (r102 == 1) goto L23;
        if (r102 == 2) goto L21;
        if (r102 == 3) goto L19;
        return r100.registerReceiver(null, r110);
    L19:
        return r101.intent;
    L21:
        return new Intent();
    L23:
        return r100.registerReceiver(null, r110);
    L25:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L29;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L36
        return r100.registerReceiver(null, r110, null, ReceiverRegisterLancet.sReceiverHandler);
    L29:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() == null) goto L35;
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r110) == false) goto L35;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L36
        return ContextCompat.registerReceiver(r100, null, r110, null, ReceiverRegisterLancet.sProxyHandler, 2);
    L35:
        return r100.registerReceiver(null, r110);
    }
}
