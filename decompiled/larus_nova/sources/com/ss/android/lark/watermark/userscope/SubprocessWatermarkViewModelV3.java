package com.ss.android.lark.watermark.userscope;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.crash.Npth;
import com.bytedance.speech.speechengine.SpeechEngineDefines;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.watermark.dto.WatermarkData;
import com.ss.android.lark.watermark.dto.WatermarkInfo;
import com.ss.android.lark.watermark.v2.WatermarkStateMediatorLiveData;
import io.reactivex.Single;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@UserScope
public final class SubprocessWatermarkViewModelV3 implements com.ss.android.lark.watermark.v2.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WatermarkRepositoryV3 f445322a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ProcessSynchronizerV3 f445323b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MutableLiveData<WatermarkData> f445324c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final WatermarkStateMediatorLiveData f445325d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MutableLiveData<WatermarkData> f445326e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final WatermarkStateMediatorLiveData f445327f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final WatermarkStateMediatorLiveData f445328g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f445329h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f445330i;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.watermark.v2.k
    public final WatermarkInfo a() {
        return null;
    }

    @Override // com.ss.android.lark.watermark.v2.k
    public final void d(com.ss.android.lark.watermark.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
    }

    @Override // com.ss.android.lark.watermark.v2.k
    public final void h(com.ss.android.lark.watermark.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
    }

    @Override // com.ss.android.lark.watermark.v2.k
    public final boolean isInitialized() {
        return true;
    }

    @Override // com.ss.android.lark.watermark.v2.k
    public final WatermarkData c() {
        return WatermarkData.Companion.getEMPTY();
    }

    @Override // com.ss.android.lark.watermark.v2.k
    public final WatermarkData e() {
        return WatermarkData.Companion.getEMPTY();
    }

    @Override // com.ss.android.lark.watermark.v2.k
    public final WatermarkData i() {
        return WatermarkData.Companion.getEMPTY();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v2, types: [android.content.BroadcastReceiver] */
    /* JADX WARN: Type inference failed for: r5v28 */
    /* JADX WARN: Type inference failed for: r5v29 */
    /* JADX WARN: Type inference failed for: r5v3, types: [com.ss.android.lark.watermark.userscope.ProcessSynchronizerV3$WatermarkBroadcastReceiver] */
    /* JADX WARN: Type inference failed for: r5v30 */
    /* JADX WARN: Type inference failed for: r5v31 */
    /* JADX WARN: Type inference failed for: r5v32 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v9 */
    @Override // com.ss.android.lark.watermark.v2.k
    public final Single<Integer> initialize() {
        ProcessSynchronizerV3 r100 = this.f445323b;
        Function3<String, WatermarkData, Boolean, Unit> r101 = new AnonymousClass1(this);
        Function2<Integer, Boolean, Unit> r102 = new AnonymousClass2(this);
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "onChanged");
        Intrinsics.checkNotNullParameter(r102, "onStrategyChanged");
        if (r100.f445319c == null) goto L5;
        int r103 = 0;
    L91:
        return Single.just(Integer.valueOf(this.f445322a.b().getInt("global_watermark", r103)));
    L5:
        IntentFilter r110 = new IntentFilter("com.larksuite.android.wm");
        if (Build.VERSION.SDK_INT < 33) goto L46;
        ProcessSynchronizerV3.WatermarkBroadcastReceiver r111 = new ProcessSynchronizerV3.WatermarkBroadcastReceiver(r101, r102);
        Context r104 = r100.f445318b;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L95;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L95:
    L39:
        e = e;
        ProcessSynchronizerV3.WatermarkBroadcastReceiver r105 = r111;
    L41:
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L45;
        ReceiverRegisterCrashOptimizer.registerReceiver(r105, r110, 4);
    L44:
        r100.f445319c = r105;
    L83:
        WatermarkData r106 = (WatermarkData) r100.f445317a.getJSONObject("global_data", WatermarkData.class);
        if (r106 == null) goto L86;
        r101.invoke("global_data", r106, Boolean.TRUE);
    L86:
        WatermarkData r107 = (WatermarkData) r100.f445317a.getJSONObject("fallback_data", WatermarkData.class);
        if (r107 == null) goto L89;
        r101.invoke("fallback_data", r107, Boolean.TRUE);
    L89:
        r103 = 0;
        r102.invoke(Integer.valueOf(r100.f445317a.getInt(BdpAppEventConstant.PARAMS_STRATEGY_NAME, 0)), Boolean.TRUE);
        goto L91
    L45:
        throw e;
    L98:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L27;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r110) == false) goto L27;
        int r108 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r111, r110, 4, null, null, 3, r104).result;     // Catch: Exception -> L25
        if (r108 == 1) goto L24;
        if (r108 == 2) goto L23;
        r105 = r111;
        if (r108 == 3) goto L44;
        r104.registerReceiver(r105, r110, 4);     // Catch: Exception -> L37
    L97:
        goto L44
    L23:
        r105 = r111;
        new Intent();     // Catch: Exception -> L37
        goto L97
    L24:
        r105 = r111;
        r104.registerReceiver(r105, r110, 4);     // Catch: Exception -> L37
    L25:
        e = e;
        r105 = r111;
    L27:
        r105 = r111;
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L31;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L37
        r104.registerReceiver(r105, r110, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L37
        goto L97
    L31:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L33;
    L35:
        r104.registerReceiver(r105, r110, 4);     // Catch: Exception -> L37
        goto L97
    L33:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r110) == false) goto L35;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L37
        ContextCompat.registerReceiver(r104, r105, r110, null, ReceiverRegisterLancet.sProxyHandler, 4);     // Catch: Exception -> L37
    L37:
        e = e;
        goto L41
    L46:
        ?? r109 = 1;
        ProcessSynchronizerV3.WatermarkBroadcastReceiver r112 = new ProcessSynchronizerV3.WatermarkBroadcastReceiver(r101, r102);
        Context r113 = r100.f445318b;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L100;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L100:
    L77:
        e = e;
        r109 = r112;
    L79:
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L92;
        ReceiverRegisterCrashOptimizer.registerReceiver(r109, r110);
    L82:
        r100.f445319c = r109;
        goto L83
    L92:
        throw e;
    L103:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L65;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r110) == false) goto L65;
        int r114 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r112, r110, 0, null, null, 2, r113).result;     // Catch: Exception -> L63
        if (r114 == 1) goto L62;
        if (r114 == 2) goto L61;
        if (r114 == 3) goto L60;
        ProcessSynchronizerV3.WatermarkBroadcastReceiver r115 = r112;
        r113.registerReceiver(r115, r110);     // Catch: Exception -> L75
        r109 = r115;
    L102:
        goto L82
    L60:
        r109 = r112;
        goto L82
    L61:
        r109 = r112;
        new Intent();     // Catch: Exception -> L75
        goto L102
    L62:
        ProcessSynchronizerV3.WatermarkBroadcastReceiver r116 = r112;
        r113.registerReceiver(r116, r110);     // Catch: Exception -> L75
        r109 = r116;
    L63:
        e = e;
        r109 = r112;
    L65:
        ProcessSynchronizerV3.WatermarkBroadcastReceiver r117 = r112;
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L69;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L75
        r113.registerReceiver(r117, r110, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L75
        r109 = r117;
        goto L102
    L69:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L71;
    L73:
        r113.registerReceiver(r117, r110);     // Catch: Exception -> L75
        r109 = r117;
        goto L102
    L71:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r110) == false) goto L73;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L75
        ContextCompat.registerReceiver(r113, r117, r110, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L75
        r109 = r117;
    L75:
        e = e;
        goto L79
    }

    @Override // com.ss.android.lark.watermark.v2.k
    public final void reset() {
        ProcessSynchronizerV3 r100 = this.f445323b;
        ProcessSynchronizerV3.WatermarkBroadcastReceiver r101 = r100.f445319c;
        if (r101 == null) goto L13;
        Context r102 = r100.f445318b;
        ReceiverRegisterLancet.loge(r101, false);
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L15;
        r102.unregisterReceiver(r101);
        goto L13
    L15:
    L10:
        e = move-exception;
        Npth.addTag("unregisterReceiver", r101.toString());
        e.printStackTrace();
        goto L13
    L7:
        if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(r101, r102) == false) goto L13;
        r102.unregisterReceiver(r101);     // Catch: Exception -> L10
    L13:
        r100.f445319c = null;
    }

    @Override // com.ss.android.lark.watermark.v2.k
    public final int s() {
        int r100 = this.f445329h;
        if (r100 == (-1)) goto L5;
        return r100;
    L5:
        return this.f445322a.b().getInt("global_watermark", 0);
    }

    @Override // com.ss.android.lark.watermark.v2.k
    public final WatermarkStateMediatorLiveData b() {
        return this.f445327f;
    }

    @Override // com.ss.android.lark.watermark.v2.k
    public final WatermarkStateMediatorLiveData f() {
        return this.f445325d;
    }

    @Override // com.ss.android.lark.watermark.v2.k
    public final LiveData<com.ss.android.lark.watermark.v2.v> g() {
        return this.f445328g;
    }

    @Inject
    public SubprocessWatermarkViewModelV3(WatermarkRepositoryV3 r100, ProcessSynchronizerV3 r101) {
        Intrinsics.checkNotNullParameter(r100, "repositoryV3");
        Intrinsics.checkNotNullParameter(r101, "subprocessSynchronizerV3");
        this.f445322a = r100;
        this.f445323b = r101;
        MutableLiveData<WatermarkData> r102 = new MutableLiveData();
        this.f445324c = r102;
        this.f445325d = com.ss.android.lark.watermark.v2.l.b(r102, "Global");
        MutableLiveData<WatermarkData> r103 = new MutableLiveData();
        this.f445326e = r103;
        this.f445327f = com.ss.android.lark.watermark.v2.l.b(r103, "Partial");
        this.f445328g = com.ss.android.lark.watermark.v2.l.b(new MutableLiveData(), SpeechEngineDefines.RECORDER_TYPE_FILE);
        this.f445329h = -1;
        this.f445330i = LazyKt.lazy(SubprocessWatermarkViewModelV3$timeTicker$2.INSTANCE);
    }
}
