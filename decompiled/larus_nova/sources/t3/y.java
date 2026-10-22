package t3;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanRecord;
import android.bluetooth.le.ScanResult;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.ParcelUuid;
import android.util.Base64;
import androidx.core.content.ContextCompat;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.ai.applet.base.gson.ByteArrayTypeAdapter;
import com.bytedance.ai.bridge.method.device.BluetoothClient$makeBluetoothPair$receiver$1;
import com.bytedance.crash.Npth;
import com.bytedance.pitaya.api.PTYSocketStateCallback;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes43.dex */
public final class y implements e3.b {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f544413n = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<e3.d> f544414a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f544415b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f544416c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f544417d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile Boolean f544418e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile Boolean f544419f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ConcurrentHashMap<String, d0> f544420g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile boolean f544421h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile ScanCallback f544422i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile BluetoothClient$makeBluetoothPair$receiver$1 f544423j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ConcurrentHashMap<String, t0> f544424k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ConcurrentHashMap.KeySetView<String, Boolean> f544425l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ConcurrentHashMap<String, AtomicInteger> f544426m;

    public static final class a {
    }

    public static final class b<T> implements Comparator {
        public b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues(((d0) r100).f544267a, ((d0) r101).f544267a);
        }
    }

    static {
    }

    @Override // e3.b
    public final void a() {
        e3.d r100 = this.f544414a.get();
        if (r100 == null) goto L5;
        Context r101 = e3.e.b(r100);
    L6:
        p(r101, false);
        e0.f544279a.getClass();
        Intrinsics.checkNotNullParameter(this, "client");
        e0.f544282d.remove(this);
        q(r101);
        Iterator r102 = CollectionsKt.toList(this.f544424k.keySet()).iterator();
    L8:
        if (r102.hasNext() == false) goto L10;
        e(this, (String) r102.next());
        goto L8
    L10:
        this.f544424k.clear();
        this.f544420g.clear();
        this.f544418e = null;
        this.f544419f = null;
        this.f544416c = false;
        this.f544417d = false;
        return;
    L5:
        r101 = null;
        goto L6
    }

    public final Object o() {
        if (this.f544416c == false) goto L5;
        Result.Companion r100 = Result.Companion;
        return Result.m9449constructorimpl(Unit.INSTANCE);
    L5:
        Result.Companion r101 = Result.Companion;
        return Result.m9449constructorimpl(ResultKt.createFailure(new IllegalStateException("bluetooth adapter is not initialized")));
    }

    public y(e3.d r100) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        this.f544414a = new WeakReference(r100);
        d3.a0 r101 = r100.getContainerContext();
        if (r101 == null) goto L5;
        String r102 = r101.getContainerId();
    L6:
        if (r102 != null) goto L8;
        r102 = "";
    L8:
        this.f544415b = r102;
        this.f544420g = new ConcurrentHashMap();
        this.f544424k = new ConcurrentHashMap();
        this.f544425l = ConcurrentHashMap.newKeySet();
        this.f544426m = new ConcurrentHashMap();
        e0.f544279a.getClass();
        Intrinsics.checkNotNullParameter(this, "client");
        e0.f544282d.add(this);
        return;
    L5:
        r102 = null;
        goto L6
    }

    public final void h(ScanResult r110) {
        Intrinsics.checkNotNullParameter(r110, "result");
        if (this.f544417d == true) goto L5;
        return;
    L5:
        e0.f544279a.getClass();
        Intrinsics.checkNotNullParameter(r110, "result");
        ScanRecord r100 = r110.getScanRecord();
        String r101 = r110.getDevice().getAddress();
        if (r101 != null) goto L8;
        String r102 = "";
    L10:
        if (r102.length() != 0) goto L12;
        boolean r103 = true;
    L13:
        d0 r104 = null;
        LinkedHashMap r105 = null;
        r105 = null;
        if (r103 == false) goto L17;
    L53:
        if (r104 != null) goto L55;
        return;
    L55:
        this.f544420g.put(r104.f544267a, r104);
        if (this.f544421h == false) goto L58;
        n(CollectionsKt.sortedWith(this.f544420g.values(), new b()));
        return;
    L58:
        n(CollectionsKt.listOf(r104));
        return;
    L17:
        if (Build.VERSION.SDK_INT < 26) goto L19;
        boolean r106 = r110.isConnectable();
    L20:
        String r107 = r110.getDevice().getName();
        if (r107 != null) goto L23;
        r107 = "";
    L23:
        String r108 = r110.getDevice().getName();
        if (r108 != null) goto L26;
        String r109 = "";
    L27:
        int r111 = r110.getRssi();
        if (r100 == null) goto L30;
        byte[] r112 = r100.getBytes();
    L31:
        if (r100 == null) goto L38;
        List<ParcelUuid> r113 = r100.getServiceUuids();
        if (r113 == null) goto L38;
        List<ParcelUuid> r114 = r113;
        ArrayList r115 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r114, 10));
        Iterator<T> r116 = r114.iterator();
    L36:
        if (r116.hasNext() == false) goto L39;
        r115.add(((ParcelUuid) r116.next()).getUuid().toString());
    L39:
        if (r115 != null) goto L41;
        List r117 = CollectionsKt.emptyList();
    L42:
        if (r100 == null) goto L49;
        Map<ParcelUuid, byte[]> r118 = r100.getServiceData();
        if (r118 == null) goto L49;
        r105 = new LinkedHashMap(MapsKt.mapCapacity(r118.size()));
        Iterator<T> r119 = r118.entrySet().iterator();
    L47:
        if (r119.hasNext() == false) goto L49;
        Map.Entry r120 = (Map.Entry) r119.next();
        r105.put(((ParcelUuid) r120.getKey()).getUuid().toString(), r120.getValue());
    L49:
        if (r105 != null) goto L51;
        Map r121 = MapsKt.emptyMap();
    L52:
        r104 = new d0(r102, r107, r109, r111, r106, r112, r117, r121);
        goto L53
    L51:
        r121 = r105;
        goto L52
    L41:
        r117 = r115;
    L38:
        r115 = null;
        goto L39
    L30:
        r112 = null;
        goto L31
    L26:
        r109 = r108;
        goto L27
    L19:
        r106 = true;
        goto L20
    L12:
        r103 = false;
        goto L13
    L8:
        r102 = r101;
        goto L10
    }

    public final void n(List<d0> r110) {
        JsonArray r100 = new JsonArray();
        Iterator<T> r111 = r110.iterator();
    L4:
        if (r111.hasNext() == false) goto L23;
        d0 r101 = (d0) r111.next();
        JsonObject r102 = new JsonObject();
        r102.addProperty("deviceId", r101.f544267a);
        r102.addProperty("name", r101.f544268b);
        r102.addProperty("RSSI", Integer.valueOf(r101.f544270d));
        r102.addProperty("connectable", Boolean.valueOf(r101.f544271e));
        String r103 = r101.f544269c;
        if (r103 == null) goto L8;
        r102.addProperty("localName", r103);
    L8:
        byte[] r104 = r101.f544272f;
        if (r104 == null) goto L11;
        int r105 = ByteArrayTypeAdapter.f34508a;
        Intrinsics.checkNotNullParameter(r104, HTTP.CONTENT_RANGE_BYTES);
        Intrinsics.checkNotNullParameter(r104, HTTP.CONTENT_RANGE_BYTES);
        r102.add("advertisData", new JsonPrimitive(Base64.encodeToString(r104, 2)));
    L11:
        Map<String, byte[]> r106 = r101.f544274h;
        JsonObject r107 = new JsonObject();
        Iterator<T> r108 = r106.entrySet().iterator();
    L13:
        if (r108.hasNext() == false) goto L15;
        Map.Entry r109 = (Map.Entry) r108.next();
        String r112 = (String) r109.getKey();
        byte[] r113 = (byte[]) r109.getValue();
        int r114 = ByteArrayTypeAdapter.f34508a;
        Intrinsics.checkNotNullParameter(r113, HTTP.CONTENT_RANGE_BYTES);
        Intrinsics.checkNotNullParameter(r113, HTTP.CONTENT_RANGE_BYTES);
        r107.add(r112, new JsonPrimitive(Base64.encodeToString(r113, 2)));
        goto L13
    L15:
        r102.add("serviceData", r107);
        if ((!r101.f544273g.isEmpty()) == false) goto L22;
        JsonArray r115 = new JsonArray();
        Iterator<T> r116 = r101.f544273g.iterator();
    L19:
        if (r116.hasNext() == false) goto L21;
        r115.add((String) r116.next());
        goto L19
    L21:
        r102.add("advertisServiceUUIDs", r115);
    L22:
        r100.add(r102);
        goto L4
    L23:
        JsonObject r117 = new JsonObject();
        r117.add("devices", r100);
        l3.a r118 = new l3.a("doubao.onBluetoothDeviceFound", r117, 4);
        r118.f507200e = this.f544415b;
        l3.d.c(r118);
    }

    public final void q(Context r100) {
        BluetoothClient$makeBluetoothPair$receiver$1 r101 = this.f544423j;
        if (r101 != null) goto L5;
        return;
    L5:
        Unit r102 = null;
        this.f544423j = null;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L22
        if (r100 == null) goto L20;
        Context r104 = r100.getApplicationContext();     // Catch: Throwable -> L22
        if (r104 == null) goto L20;
        ReceiverRegisterLancet.loge(r101, false);     // Catch: Throwable -> L22
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L25;
        r104.unregisterReceiver(r101);     // Catch: Throwable -> L22
    L19:
        r102 = Unit.INSTANCE;     // Catch: Throwable -> L22
        goto L20
    L25:
    L16:
        e = move-exception;
        Npth.addTag("unregisterReceiver", r101.toString());     // Catch: Throwable -> L22
        e.printStackTrace();     // Catch: Throwable -> L22
        goto L19
    L13:
        if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(r101, r104) == false) goto L19;
        r104.unregisterReceiver(r101);     // Catch: Exception -> L16 Throwable -> L22
    L20:
        Result.m9449constructorimpl(r102);     // Catch: Throwable -> L22
        return;
    L22:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public static String c(String r100, String r101) {
        StringBuilder r102 = new StringBuilder();
        Locale r103 = Locale.ROOT;
        r102.append(r100.toLowerCase(r103));
        r102.append('|');
        r102.append(r101.toLowerCase(r103));
        return r102.toString();
    }

    public static /* synthetic */ void e(y r100, String r101) {
        r100.d(r101, new IllegalStateException("ble connection closed"));
    }

    public static Object g(t0 r110, String r111) {
        e0 r100 = e0.f544279a;
        BluetoothGatt r112 = r110.f544383b;
        r100.getClass();
        BluetoothGattService r113 = e0.g(r112, r111);
        if (r113 != null) goto L6;
        Result.Companion r114 = Result.Companion;
        return Result.m9449constructorimpl(ResultKt.createFailure(new IllegalStateException("ble service not found")));
    L6:
        Result.Companion r115 = Result.Companion;
        List<BluetoothGattCharacteristic> r116 = r113.getCharacteristics();
        ArrayList r117 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r116, 10));
        Iterator<T> r118 = r116.iterator();
    L8:
        if (r118.hasNext() == false) goto L11;
        BluetoothGattCharacteristic r101 = (BluetoothGattCharacteristic) r118.next();
        String r102 = r101.getUuid().toString();
        Intrinsics.checkNotNull(r101);
        boolean r103 = i(r101, 32);
        boolean r104 = i(r101, 16);
        r117.add(new k(r102, new j(i(r101, 2), i(r101, 8), r104, r103, i(r101, 4))));
        goto L8
    L11:
        return Result.m9449constructorimpl(r117);
    }

    public static boolean i(BluetoothGattCharacteristic r100, int r101) {
        if ((r100.getProperties() & r101) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [t3.l] */
    /* JADX WARN: Type inference failed for: r3v2, types: [t3.q] */
    public final void d(String r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "deviceId");
        Intrinsics.checkNotNullParameter(r101, "failure");
        t0 r102 = this.f544424k.remove(r100);
        if (r102 != null) goto L5;
        return;
    L5:
        final String r103 = r100.toLowerCase(Locale.ROOT) + '|';
        ConcurrentHashMap.KeySetView<String, Boolean> r104 = this.f544425l;
        final ?? r105 = new l(r103);
        r104.removeIf(new p(r105));
        Set<String> r106 = this.f544426m.keySet();
        final ?? r107 = new q(r103);
        r106.removeIf(new r(r107));
        s0 r108 = r102.f544384c;
        r108.getClass();
        Intrinsics.checkNotNullParameter(r101, "failure");
        Runnable r109 = r108.f544374g;
        if (r109 == null) goto L8;
        e0.f544279a.getClass();
        e0.f544281c.removeCallbacks(r109);
    L8:
        Runnable r110 = r108.f544375h;
        if (r110 == null) goto L11;
        e0.f544279a.getClass();
        e0.f544281c.removeCallbacks(r110);
    L11:
        Runnable r111 = r108.f544376i;
        if (r111 == null) goto L14;
        e0.f544279a.getClass();
        e0.f544281c.removeCallbacks(r111);
    L14:
        Runnable r112 = r108.f544377j;
        if (r112 == null) goto L17;
        e0.f544279a.getClass();
        e0.f544281c.removeCallbacks(r112);
    L17:
        r108.f544374g = null;
        r108.f544375h = null;
        r108.f544376i = null;
        r108.f544377j = null;
        Function1<? super Result<Unit>, Unit> r113 = r108.f544370c;
        Function1<? super Result<? extends List<g0>>, Unit> r114 = r108.f544371d;
        Function1<? super Result<Integer>, Unit> r115 = r108.f544372e;
        Function1<? super Result<Integer>, Unit> r116 = r108.f544373f;
        r108.f544370c = null;
        r108.f544371d = null;
        r108.f544372e = null;
        r108.f544373f = null;
        if (r113 == null) goto L20;
        Result.Companion r117 = Result.Companion;
        r113.invoke(Result.m9448boximpl(Result.m9449constructorimpl(ResultKt.createFailure(r101))));
    L20:
        if (r114 == null) goto L22;
        Result.Companion r118 = Result.Companion;
        r114.invoke(Result.m9448boximpl(Result.m9449constructorimpl(ResultKt.createFailure(r101))));
    L22:
        if (r115 == null) goto L24;
        Result.Companion r119 = Result.Companion;
        r115.invoke(Result.m9448boximpl(Result.m9449constructorimpl(ResultKt.createFailure(r101))));
    L24:
        if (r116 == null) goto L35;
        Result.Companion r120 = Result.Companion;
        r116.invoke(Result.m9448boximpl(Result.m9449constructorimpl(ResultKt.createFailure(r101))));
    L35:
        Result.Companion r121 = Result.Companion;     // Catch: Throwable -> L28
        r102.f544383b.disconnect();     // Catch: Throwable -> L28
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L28
    L37:
        r102.f544383b.close();     // Catch: Throwable -> L32
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L32
        return;
    L32:
        th = move-exception;
        Result.Companion r122 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return;
    L28:
        th = move-exception;
        Result.Companion r123 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L37
    }

    public final void f(String r100, final Function1<? super Result<? extends List<g0>>, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "deviceId");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Throwable r102 = Result.m9452exceptionOrNullimpl(o());
        if (r102 == null) goto L6;
        r101.invoke(Result.m9448boximpl(Result.m9449constructorimpl(ResultKt.createFailure(r102))));
        return;
    L6:
        final t0 r103 = this.f544424k.get(r100);
        if (r103 != null) goto L10;
        r101.invoke(Result.m9448boximpl(Result.m9449constructorimpl(ResultKt.createFailure(new IllegalStateException("ble connection not found")))));
        return;
    L10:
        r103.f544384c.f544371d = r101;
        Runnable r104 = new x(r103, r101);
        r103.f544384c.f544375h = r104;
        e0.f544279a.getClass();
        Handler r105 = e0.f544281c;
        r105.postDelayed(r104, 5000);
        if (r103.f544383b.discoverServices() == true) goto L14;
        r105.removeCallbacks(r104);
        r103.f544384c.f544371d = null;
        r101.invoke(Result.m9448boximpl(Result.m9449constructorimpl(ResultKt.createFailure(new IllegalStateException("discover services failed")))));
        return;
    }

    public final void m(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "deviceId");
        JsonObject r102 = new JsonObject();
        r102.addProperty("deviceId", r100);
        r102.addProperty(PTYSocketStateCallback.CONNECTED, Boolean.valueOf(r101));
        l3.a r103 = new l3.a("doubao.onBLEConnectionStateChange", r102, 4);
        r103.f507200e = this.f544415b;
        l3.d.c(r103);
    }

    public final void p(Context r100, boolean r101) {
        ScanCallback r102 = this.f544422i;
        Boolean r103 = null;
        this.f544422i = null;
        this.f544417d = false;
        if (r102 != null) goto L30;
    L21:
        if (r101 == false) goto L32;
        if (r100 == null) goto L27;
        e0.f544279a.getClass();
        BluetoothAdapter r104 = e0.e(r100);
        if (r104 == null) goto L26;
        r103 = Boolean.valueOf(r104.isEnabled());
    L26:
        boolean r105 = Intrinsics.areEqual(r103, Boolean.TRUE);
    L28:
        k(r105, false, false);
        return;
    L27:
        r105 = false;
        goto L28
    L32:
        return;
    L30:
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L19
        if (r100 == null) goto L7;
        e0.f544279a.getClass();     // Catch: Throwable -> L19
        BluetoothAdapter r107 = e0.e(r100);     // Catch: Throwable -> L19
    L8:
        if (r107 == null) goto L16;
        BluetoothLeScanner r108 = r107.getBluetoothLeScanner();     // Catch: Throwable -> L19
        if (r108 == null) goto L16;
        if (fna.g.d() == true) goto L14;
        r108.stopScan(r102);     // Catch: Throwable -> L19
    L15:
        Unit r109 = Unit.INSTANCE;     // Catch: Throwable -> L19
    L17:
        Result.m9449constructorimpl(r109);     // Catch: Throwable -> L19
        goto L21
    L14:
        r108.stopScan(r102);     // Catch: Throwable -> L19
        ina.a.c(r102.hashCode());     // Catch: Throwable -> L19
    L16:
        r109 = null;
        goto L17
    L7:
        r107 = null;
    L19:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L21
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void b(Context r100, BluetoothClient$makeBluetoothPair$receiver$1 r101, IntentFilter r110) {
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

    public final void k(boolean r100, boolean r101, boolean r102) {
        if (r102 == false) goto L4;
    L8:
        this.f544418e = Boolean.valueOf(r100);
        this.f544419f = Boolean.valueOf(r101);
        JsonObject r103 = new JsonObject();
        r103.addProperty("available", Boolean.valueOf(r100));
        r103.addProperty("discovering", Boolean.valueOf(r101));
        l3.a r104 = new l3.a("doubao.onBluetoothAdapterStateChange", r103, 4);
        r104.f507200e = this.f544415b;
        l3.d.c(r104);
        return;
    L4:
        if (Intrinsics.areEqual(this.f544418e, Boolean.valueOf(r100)) == false) goto L8;
        if (Intrinsics.areEqual(this.f544419f, Boolean.valueOf(r101)) == false) goto L8;
    }

    public final void l(String r100, String r101, String r102, byte[] r103) {
        Intrinsics.checkNotNullParameter(r100, "deviceId");
        Intrinsics.checkNotNullParameter(r101, "serviceId");
        Intrinsics.checkNotNullParameter(r102, "characteristicId");
        JsonObject r104 = new JsonObject();
        r104.addProperty("deviceId", r100);
        r104.addProperty("serviceId", r101);
        r104.addProperty("characteristicId", r102);
        if (r103 == null) goto L5;
        int r105 = ByteArrayTypeAdapter.f34508a;
        Intrinsics.checkNotNullParameter(r103, HTTP.CONTENT_RANGE_BYTES);
        Intrinsics.checkNotNullParameter(r103, HTTP.CONTENT_RANGE_BYTES);
        r104.add("value", new JsonPrimitive(Base64.encodeToString(r103, 2)));
    L5:
        l3.a r106 = new l3.a("doubao.onBLECharacteristicValueChange", r104, 4);
        r106.f507200e = this.f544415b;
        l3.d.c(r106);
    }

    public static final void j(AtomicBoolean r100, Ref.ObjectRef<Runnable> r101, y r102, Context r103, Function1<? super Result<Unit>, Unit> r104, Object r105) {
        if (r100.compareAndSet(false, true) == false) goto L10;
        e0.f544279a.getClass();
        Handler r106 = e0.f544281c;
        Runnable r107 = r101.element;
        if (r107 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("timeoutRunnable");
        Runnable r108 = null;
    L8:
        r106.removeCallbacks(r108);
        r102.q(r103);
        r104.invoke(Result.m9448boximpl(r105));
        return;
    L7:
        r108 = r107;
        goto L8
    }
}
