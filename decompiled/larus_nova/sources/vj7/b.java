package vj7;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.core.content.ContextCompat;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.bytedance.ug.sdk.luckycat.impl.manager.m;
import org.json.JSONObject;
import pi7.f;

/* JADX INFO: loaded from: classes22.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f555422a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile long f555423b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile long f555424c;

    public class a implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f555425a;

        @Override // pi7.f
        public final void onFailed(int r100) {
            this.f555425a.f555422a = false;
            m r101 = m.a.f271349a;
        }

        @Override // pi7.f
        public final void onSuccess(JSONObject r110) {
            this.f555425a.f555422a = false;
            b r100 = this.f555425a;
            r100.f555423b = r110.optLong("cur_time") * 1000;
            if (this.f555425a.f555423b != 0) goto L5;
            b r101 = this.f555425a;
            r101.f555423b = System.currentTimeMillis();
        L5:
            b r102 = this.f555425a;
            r102.f555424c = SystemClock.elapsedRealtime();
            m r103 = m.a.f271349a;
            long r104 = r110.optLong("next_time") * 1000;
            if (r104 <= 0) goto L25;
            b r105 = this.f555425a;
            if (r104 > 0) goto L10;
            r105.getClass();
            return;
        L10:
            if (r105.f555423b > 0) goto L12;
            long r106 = System.currentTimeMillis();
        L14:
            if (r106 > 0) goto L17;
            return;
        L17:
            if (r105.f555423b > 0) goto L19;
            long r107 = System.currentTimeMillis();
        L20:
            long r108 = r104 - r107;
            if (r108 <= 0) goto L26;
            new Handler(Looper.getMainLooper()).postDelayed(new c(r105), r108);
            return;
        L26:
            return;
        L19:
            r107 = r105.f555423b + (SystemClock.elapsedRealtime() - r105.f555424c);
            goto L20
        L12:
            r106 = r105.f555423b + (SystemClock.elapsedRealtime() - r105.f555424c);
            goto L14
        }

        public a(b r100, String r101) {
            this.f555425a = r100;
        }
    }

    /* JADX INFO: renamed from: vj7.b$b, reason: collision with other inner class name */
    public static class C8014b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f555426a = null;

        static {
            f555426a = new b();
        }
    }

    public b() {
        this.f555422a = false;
        vj7.a r100 = new vj7.a(this);
        IntentFilter r101 = new IntentFilter();
        r101.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        Context r102 = m.a.f271349a.f();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L34;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L34:
    L28:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L33;
        ReceiverRegisterCrashOptimizer.registerReceiver(r100, r101);
        return;
    L33:
        throw e;
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L19;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r101) == false) goto L19;
        int r103 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r100, r101, 0, null, null, 2, r102).result;     // Catch: Exception -> L28
        if (r103 != 1) goto L12;
        r102.registerReceiver(r100, r101);     // Catch: Exception -> L28
        return;
    L12:
        if (r103 != 2) goto L14;
        new Intent();     // Catch: Exception -> L28
        return;
    L14:
        if (r103 == 3) goto L35;
        r102.registerReceiver(r100, r101);     // Catch: Exception -> L28
        return;
    L35:
        return;
    L19:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L22;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L28
        r102.registerReceiver(r100, r101, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L28
        return;
    L22:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L24;
    L26:
        r102.registerReceiver(r100, r101);     // Catch: Exception -> L28
        return;
    L24:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r101) == false) goto L26;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L28
        ContextCompat.registerReceiver(r102, r100, r101, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L28
    }

    public final void a(String r100) {
        if (this.f555422a == false) goto L5;
        return;
    L5:
        this.f555422a = true;
        rj7.c.a(new qj7.f(new a(this, r100), r100));
    }
}
