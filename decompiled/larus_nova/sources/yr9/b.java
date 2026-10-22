package yr9;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Looper;
import android.util.Log;
import android.util.Pair;
import androidx.core.content.ContextCompat;
import com.bytedance.android.livesdkapi.performance.IPerformanceStrategyManager;
import com.bytedance.crash.Npth;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import java.util.ArrayList;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes31.dex */
public final class b extends as9.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public a f568933f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f568934g;

    public class a extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f568935a;

        public a(b r100) {
            this.f568935a = r100;
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context r100, Intent r101) {
            if (r101 != null) goto L4;
            return;
        L4:
            boolean r102 = false;
            float r103 = r101.getIntExtra(IPerformanceStrategyManager.KEY_FLOAT_TEMPERATURE, 0) / 10.0f;
            b r104 = this.f568935a;
            float r105 = r104.f16140c;
            float r106 = r104.f568934g;
            boolean r107 = bs9.a.f20322a;
            if (r106 <= 0.0f) goto L8;
            r103 = r106;
        L8:
            if (r103 != r105) goto L11;
            return;
        L11:
            if (Math.abs(r105 - r103) < 0.5f) goto L13;
            b r108 = this.f568935a;
            if (r103 <= r108.f16140c) goto L17;
            r102 = true;
        L17:
            r108.f16141d = r108.d(r103, r102);
            b r109 = this.f568935a;
            r109.f16140c = r103;
            as9.a.InterfaceC0219a r110 = r109.f16138a;
            if (r110 == null) goto L21;
            r110.onStatusGenerate(r109.f16141d, r103);
            return;
        L21:
            return;
        }
    }

    @Override // as9.a
    public final boolean a() {
        if (this.f568933f == null) goto L12;
    L11:
        return true;
    L12:
        a r100 = new a(this);     // Catch: Exception -> L9
        this.f568933f = r100;     // Catch: Exception -> L9
        Intent r101 = h(this.f16139b, r100, new IntentFilter("android.intent.action.BATTERY_CHANGED"));     // Catch: Exception -> L9
        if (r101 != null) goto L7;
        return false;
    L7:
        float r102 = r101.getIntExtra(IPerformanceStrategyManager.KEY_FLOAT_TEMPERATURE, 0) / 10.0f;     // Catch: Exception -> L9
        this.f16140c = r102;     // Catch: Exception -> L9
        this.f16141d = d(r102, true);     // Catch: Exception -> L9
    L9:
        e = move-exception;
        Log.getStackTraceString(e);
        boolean r103 = bs9.a.f20322a;
        goto L11
    }

    @Override // as9.a
    public final float b() {
        if (this.f16138a != null) goto L7;
        return i();
    L7:
        return this.f16140c;
    }

    @Override // as9.a
    public final int c() {
        if (this.f16138a != null) goto L7;
        return d(i(), true);
    L7:
        return this.f16141d;
    }

    @Override // as9.a
    public final void e() {
        a r100 = this.f568933f;
        if (r100 == null) goto L19;
        Context r101 = this.f16139b;
        ReceiverRegisterLancet.loge(r100, false);
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L17;
        r101.unregisterReceiver(r100);
    L15:
        this.f568933f = null;
        return;
    L17:
    L10:
        e = move-exception;
        if (r100 == null) goto L13;
        Npth.addTag("unregisterReceiver", r100.toString());
    L13:
        e.printStackTrace();
        goto L15
    L7:
        if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(r100, r101) == false) goto L15;
        r101.unregisterReceiver(r100);     // Catch: Exception -> L10
        goto L15
    }

    public final float i() {
        Intent r100 = h(this.f16139b, null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (r100 != null) goto L7;
        return 0.0f;
    L7:
        return r100.getIntExtra(IPerformanceStrategyManager.KEY_FLOAT_TEMPERATURE, 0) / 10.0f;
    }

    public b(Context r100, Looper r101) {
        super(r100, r101);
        this.f568934g = -1.0f;
        List<Pair<Float, Float>> r102 = this.f16142e;
        ArrayList r103 = (ArrayList) r102;
        r103.add(new Pair(Float.valueOf(35.0f), Float.valueOf(34.0f)));
        List<Pair<Float, Float>> r104 = this.f16142e;
        ArrayList r105 = (ArrayList) r104;
        r105.add(new Pair(Float.valueOf(38.0f), Float.valueOf(37.0f)));
        List<Pair<Float, Float>> r106 = this.f16142e;
        ArrayList r107 = (ArrayList) r106;
        r107.add(new Pair(Float.valueOf(41.0f), Float.valueOf(40.0f)));
        List<Pair<Float, Float>> r108 = this.f16142e;
        ArrayList r109 = (ArrayList) r108;
        r109.add(new Pair(Float.valueOf(45.0f), Float.valueOf(43.0f)));
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent h(Context r100, a r101, IntentFilter r110) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L41;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L41:
    L35:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L39;
        throw e;
    L39:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r101, r110);
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L24;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r110) == false) goto L24;
        ReceiverRegisterAnrOptimizer.ResultWrapper r102 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r101, r110, 0, null, null, 2, r100);     // Catch: Exception -> L35
        int r103 = r102.result;     // Catch: Exception -> L35
        if (r103 == 1) goto L22;
        if (r103 == 2) goto L20;
        if (r103 == 3) goto L18;
        return r100.registerReceiver(r101, r110);
    L18:
        return r102.intent;
    L20:
        return new Intent();
    L22:
        return r100.registerReceiver(r101, r110);
    L24:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L28;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L35
        return r100.registerReceiver(r101, r110, null, ReceiverRegisterLancet.sReceiverHandler);
    L28:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() == null) goto L34;
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r110) == false) goto L34;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L35
        return ContextCompat.registerReceiver(r100, r101, r110, null, ReceiverRegisterLancet.sProxyHandler, 2);
    L34:
        return r100.registerReceiver(r101, r110);
    }
}
