package i3c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.content.ContextCompat;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.settings.v1.UpdateTimezoneRequest;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.sdk.SdkSender;
import java.io.IOException;
import java.util.TimeZone;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes38.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f488115a;

    /* JADX INFO: renamed from: i3c.a$a, reason: collision with other inner class name */
    public class C6224a extends BroadcastReceiver {

        /* JADX INFO: renamed from: i3c.a$a$a, reason: collision with other inner class name */
        public class C6225a implements SdkSender.IParser<Boolean> {
            public C6225a() {
            }

            @Override // com.ss.android.lark.sdk.SdkSender.IParser
            public final Boolean parse(byte[] r100) throws IOException {
                return Boolean.TRUE;
            }
        }

        public C6224a() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context r100, Intent r101) {
            if (r101 != null) goto L4;
            return;
        L4:
            if ("android.intent.action.TIMEZONE_CHANGED".equals(r101.getAction()) == false) goto L8;
            UpdateTimezoneRequest.Builder r102 = new UpdateTimezoneRequest.Builder().timezone(TimeZone.getDefault().getID());
            SdkSender.asynSendRequestNonWrap(Command.UPDATE_TIMEZONE, r102, null, new C6225a());
            return;
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        IntentFilter r100 = new IntentFilter();     // Catch: Throwable -> L5
        r100.addAction("android.intent.action.TIMEZONE_CHANGED");     // Catch: Throwable -> L5
        a(this.f488115a.getApplicationContext(), new C6224a(), r100);     // Catch: Throwable -> L5 Exception -> L10
        goto L15
    L14:
        return;
    L15:
        return;
    L5:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L9;
        return;
    L9:
        throw th;
    }

    public a(Context r100) {
        this.f488115a = r100;
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void a(Context r100, C6224a r101, IntentFilter r110) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L39;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L39:
    L33:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L38;
        ReceiverRegisterCrashOptimizer.registerReceiver(r101, r110);
        return;
    L38:
        throw e;
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L22;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r110) == false) goto L22;
        int r102 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r101, r110, 0, null, null, 2, r100).result;     // Catch: Exception -> L33
        if (r102 != 1) goto L12;
        r100.registerReceiver(r101, r110);     // Catch: Exception -> L33
        return;
    L12:
        if (r102 != 2) goto L14;
        new Intent();     // Catch: Exception -> L33
        return;
    L14:
        if (r102 == 3) goto L40;
        r100.registerReceiver(r101, r110);     // Catch: Exception -> L33
        return;
    L40:
        return;
    L22:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L26;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L33
        r100.registerReceiver(r101, r110, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L33
        return;
    L26:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L28;
    L31:
        r100.registerReceiver(r101, r110);     // Catch: Exception -> L33
        return;
    L28:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r110) == false) goto L31;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L33
        ContextCompat.registerReceiver(r100, r101, r110, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L33
    }
}
