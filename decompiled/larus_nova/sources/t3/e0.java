package t3;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.core.content.ContextCompat;
import com.byted.cast.linkcommon.cybergarage.upnp.device.ST;
import com.bytedance.ai.bridge.method.device.BluetoothMethodHelper$registerAdapterStateReceiver$1$receiver$1;
import com.bytedance.crash.Npth;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.ss.android.lark.batterymonitor.stragety.AbsBatteryStrategy;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes43.dex */
public final class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e0 f544279a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final UUID f544280b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Handler f544281c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ConcurrentHashMap.KeySetView<y, Boolean> f544282d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile BluetoothMethodHelper$registerAdapterStateReceiver$1$receiver$1 f544283e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Object f544284f = null;

    public e0() {
    }

    static {
        f544279a = new e0();
        f544280b = UUID.fromString("00002902-0000-1000-8000-00805f9b34fb");
        f544281c = new Handler(Looper.getMainLooper());
        f544282d = ConcurrentHashMap.newKeySet();
        f544284f = new Object();
    }

    public static String[] c() {
        if (Build.VERSION.SDK_INT < 31) goto L6;
        return new String[]{"android.permission.BLUETOOTH_SCAN", "android.permission.BLUETOOTH_CONNECT", "android.permission.ACCESS_FINE_LOCATION"};
    L6:
        return new String[]{"android.permission.BLUETOOTH", "android.permission.BLUETOOTH_ADMIN"};
    }

    public static String[] j() {
        if (Build.VERSION.SDK_INT < 31) goto L6;
        return new String[]{"android.permission.BLUETOOTH_SCAN", "android.permission.BLUETOOTH_CONNECT", "android.permission.ACCESS_FINE_LOCATION"};
    L6:
        return new String[]{"android.permission.BLUETOOTH", "android.permission.BLUETOOTH_ADMIN", "android.permission.ACCESS_FINE_LOCATION"};
    }

    public static BluetoothAdapter e(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Object r101 = r100.getSystemService("bluetooth");
        if ((r101 instanceof BluetoothManager) == false) goto L5;
        BluetoothManager r102 = (BluetoothManager) r101;
    L6:
        if (r102 != null) goto L8;
        return null;
    L8:
        return r102.getAdapter();
    L5:
        r102 = null;
        goto L6
    }

    public static UUID i(String r110) {
        Intrinsics.checkNotNullParameter(r110, ST.UUID_DEVICE);
        String r111 = StringsKt.removeSuffix(StringsKt.removePrefix(StringsKt.trim(r110).toString(), "{"), com.alipay.sdk.m.u.i.f25855d);
        boolean r100 = true;
        if (r111.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        Object r102 = null;
        if (r101 == false) goto L9;
        return null;
    L9:
        String r103 = StringsKt.replace$default(r111, "-", "", false, 4, null).toLowerCase(Locale.ROOT);
        int r104 = 0;
    L11:
        if (r104 >= r103.length()) goto L32;
        char r105 = r103.charAt(r104);
        if ('0' <= r105) goto L15;
    L17:
        boolean r106 = false;
    L18:
        if (r106 == false) goto L20;
    L28:
        boolean r107 = true;
    L29:
        if (r107 == false) goto L30;
        r104 = r104 + 1;
        goto L11
    L30:
        r100 = false;
        goto L32
    L20:
        if ('a' <= r105) goto L22;
    L24:
        boolean r108 = false;
    L25:
        if (r108 == true) goto L28;
        r107 = false;
        goto L29
    L22:
        if (r105 >= 'g') goto L24;
        r108 = true;
        goto L25
    L15:
        if (r105 >= ':') goto L17;
        r106 = true;
    L32:
        if (r100 == false) goto L62;
        int r109 = r103.length();
        if (r109 == 4) goto L61;
        if (r109 == 8) goto L70;
        if (r109 == 32) goto L69;
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L51
        Object r113 = Result.m9449constructorimpl(UUID.fromString(r111));     // Catch: Throwable -> L51
    L54:
        if (Result.m9455isFailureimpl(r113) == true) goto L68;
        r102 = r113;
    L68:
        return (UUID) r102;
    L51:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L54
    L69:
        return UUID.fromString(r103.substring(0, 8) + '-' + r103.substring(8, 12) + '-' + r103.substring(12, 16) + '-' + r103.substring(16, 20) + '-' + r103.substring(20, 32));
    L70:
        return UUID.fromString(r103.concat("-0000-1000-8000-00805f9b34fb"));
    L61:
        return UUID.fromString(AbsBatteryStrategy.AppFgCombination.APP_FG__CHARGE_IN__NETWORK_WIFI__SCREEN_ON + r103 + "-0000-1000-8000-00805f9b34fb");
    L62:
        Result.Companion r115 = Result.Companion;     // Catch: Throwable -> L35
        Object r116 = Result.m9449constructorimpl(UUID.fromString(r111));     // Catch: Throwable -> L35
    L38:
        if (Result.m9455isFailureimpl(r116) == true) goto L42;
        r102 = r116;
    L42:
        return (UUID) r102;
    L35:
        th = move-exception;
        Result.Companion r117 = Result.Companion;
        r116 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L38
    L5:
        r101 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [android.content.BroadcastReceiver, com.bytedance.ai.bridge.method.device.BluetoothMethodHelper$registerAdapterStateReceiver$1$receiver$1, java.lang.Object] */
    public static void d(e3.d r100, Context r101) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        y r102 = c0.a(r100);
        boolean r103 = false;
        if (f544283e != null) goto L34;
        Object r104 = f544284f;
        monitor-enter(r104);
    L41:
        th = move-exception;
        throw th;
    L8:
        if (f544283e == null) goto L11;
        monitor-exit(r104);
        goto L34
    L11:
        ?? r105 = new BluetoothMethodHelper$registerAdapterStateReceiver$1$receiver$1();     // Catch: Throwable -> L41
        IntentFilter r106 = new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED");     // Catch: Throwable -> L41
        Context r107 = r101.getApplicationContext();     // Catch: Throwable -> L41
    L18:
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L29
        ReceiverRegisterLancet.loge(r105, false);     // Catch: Throwable -> L29
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L48;
        r107.unregisterReceiver(r105);     // Catch: Throwable -> L29
    L27:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L29
    L31:
        f544283e = null;     // Catch: Throwable -> L41
    L32:
        Unit r109 = Unit.INSTANCE;     // Catch: Throwable -> L41
        monitor-exit(r104);
        goto L34
    L48:
    L24:
        e = move-exception;
        Npth.addTag("unregisterReceiver", r105.toString());     // Catch: Throwable -> L29
        e.printStackTrace();     // Catch: Throwable -> L29
        goto L27
    L21:
        if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(r105, r107) == false) goto L27;
        r107.unregisterReceiver(r105);     // Catch: Exception -> L24 Throwable -> L29
    L29:
        th = move-exception;
        Result.Companion r110 = Result.Companion;     // Catch: Throwable -> L41
        Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L41
        goto L31
    L13:
        if (Build.VERSION.SDK_INT < 33) goto L15;
        a(r107, r105, r106);     // Catch: RuntimeException -> L18 Throwable -> L41
    L16:
        f544283e = r105;     // Catch: RuntimeException -> L18 Throwable -> L41
        goto L32
    L15:
        b(r107, r105, r106);     // Catch: RuntimeException -> L18 Throwable -> L41
    L34:
        BluetoothAdapter r111 = e(r101);
        if (r111 != null) goto L37;
    L39:
        r102.k(r103, r102.f544417d, true);
        return;
    L37:
        if (r111.isEnabled() != true) goto L39;
        r103 = true;
        goto L39
    }

    public static BluetoothGattService g(BluetoothGatt r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "gatt");
        Intrinsics.checkNotNullParameter(r101, "serviceId");
        UUID r102 = i(r101);
        Object r103 = null;
        if (r102 == null) goto L13;
        BluetoothGattService r104 = r100.getService(r102);
        if (r104 != null) goto L27;
        Iterator<T> r105 = r100.getServices().iterator();
    L8:
        if (r105.hasNext() == false) goto L28;
        Object r106 = r105.next();
        if (Intrinsics.areEqual(((BluetoothGattService) r106).getUuid(), r102) == false) goto L8;
        r103 = r106;
    L28:
        return (BluetoothGattService) r103;
    L27:
        return r104;
    L13:
        Iterator<T> r107 = r100.getServices().iterator();
    L15:
        if (r107.hasNext() == false) goto L20;
        Object r108 = r107.next();
        if (StringsKt.equals(((BluetoothGattService) r108).getUuid().toString(), r101, true) == false) goto L15;
        r103 = r108;
    L20:
        return (BluetoothGattService) r103;
    }

    public static String h(BluetoothGatt r100, BluetoothGattCharacteristic r101) {
        Intrinsics.checkNotNullParameter(r100, "gatt");
        Intrinsics.checkNotNullParameter(r101, "characteristic");
        Iterator<BluetoothGattService> r102 = r100.getServices().iterator();
    L4:
        if (r102.hasNext() == false) goto L12;
        BluetoothGattService r103 = r102.next();
        Iterator<BluetoothGattCharacteristic> r104 = r103.getCharacteristics().iterator();
    L7:
        if (r104.hasNext() == false) goto L4;
        if (Intrinsics.areEqual(r104.next().getUuid(), r101.getUuid()) == false) goto L7;
        return r103.getUuid().toString();
    L12:
        return null;
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void a(Context r100, BluetoothMethodHelper$registerAdapterStateReceiver$1$receiver$1 r110, IntentFilter r111) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L40;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L40:
    L34:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L39;
        ReceiverRegisterCrashOptimizer.registerReceiver(r110, r111, 4);
        return;
    L39:
        throw e;
    L7:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L23;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r111) == false) goto L23;
        int r101 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r110, r111, 4, null, null, 3, r100).result;     // Catch: Exception -> L34
        if (r101 != 1) goto L13;
        r100.registerReceiver(r110, r111, 4);     // Catch: Exception -> L34
        return;
    L13:
        if (r101 != 2) goto L15;
        new Intent();     // Catch: Exception -> L34
        return;
    L15:
        if (r101 == 3) goto L41;
        r100.registerReceiver(r110, r111, 4);     // Catch: Exception -> L34
        return;
    L41:
        return;
    L23:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L27;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L34
        r100.registerReceiver(r110, r111, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L34
        return;
    L27:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L29;
    L32:
        r100.registerReceiver(r110, r111, 4);     // Catch: Exception -> L34
        return;
    L29:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r111) == false) goto L32;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L34
        ContextCompat.registerReceiver(r100, r110, r111, null, ReceiverRegisterLancet.sProxyHandler, 4);     // Catch: Exception -> L34
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void b(Context r100, BluetoothMethodHelper$registerAdapterStateReceiver$1$receiver$1 r101, IntentFilter r110) {
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

    public static BluetoothGattCharacteristic f(BluetoothGatt r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "gatt");
        Intrinsics.checkNotNullParameter(r101, "serviceId");
        Intrinsics.checkNotNullParameter(r102, "characteristicId");
        BluetoothGattService r103 = g(r100, r101);
        Object r104 = null;
        if (r103 != null) goto L5;
        return null;
    L5:
        UUID r105 = i(r102);
        if (r105 == null) goto L16;
        BluetoothGattCharacteristic r106 = r103.getCharacteristic(r105);
        if (r106 != null) goto L30;
        Iterator<T> r107 = r103.getCharacteristics().iterator();
    L11:
        if (r107.hasNext() == false) goto L31;
        Object r108 = r107.next();
        if (Intrinsics.areEqual(((BluetoothGattCharacteristic) r108).getUuid(), r105) == false) goto L11;
        r104 = r108;
    L31:
        return (BluetoothGattCharacteristic) r104;
    L30:
        return r106;
    L16:
        Iterator<T> r109 = r103.getCharacteristics().iterator();
    L18:
        if (r109.hasNext() == false) goto L23;
        Object r110 = r109.next();
        if (StringsKt.equals(((BluetoothGattCharacteristic) r110).getUuid().toString(), r102, true) == false) goto L18;
        r104 = r110;
    L23:
        return (BluetoothGattCharacteristic) r104;
    }
}
