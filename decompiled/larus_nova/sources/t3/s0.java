package t3;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.os.Build;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class s0 extends BluetoothGattCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<y> f544368a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f544369b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile Function1<? super Result<Unit>, Unit> f544370c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile Function1<? super Result<? extends List<g0>>, Unit> f544371d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile Function1<? super Result<Integer>, Unit> f544372e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile Function1<? super Result<Integer>, Unit> f544373f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Runnable f544374g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Runnable f544375h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Runnable f544376i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Runnable f544377j;

    public final void a(Object r100) {
        Function1<? super Result<Unit>, Unit> r101 = this.f544370c;
        if (r101 != null) goto L5;
        return;
    L5:
        Runnable r102 = this.f544374g;
        if (r102 == null) goto L8;
        e0.f544279a.getClass();
        e0.f544281c.removeCallbacks(r102);
    L8:
        this.f544374g = null;
        this.f544370c = null;
        r101.invoke(Result.m9448boximpl(r100));
    }

    public s0(WeakReference<y> r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "clientRef");
        Intrinsics.checkNotNullParameter(r101, "deviceId");
        this.f544368a = r100;
        this.f544369b = r101;
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public final void onCharacteristicChanged(BluetoothGatt r100, BluetoothGattCharacteristic r101) {
        Intrinsics.checkNotNullParameter(r100, "gatt");
        Intrinsics.checkNotNullParameter(r101, "characteristic");
        b(r100, r101, r101.getValue());
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public final void onServicesDiscovered(BluetoothGatt r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "gatt");
        if (this.f544368a.get() != null) goto L6;
        return;
    L6:
        if (r101 != 0) goto L21;
        Result.Companion r102 = Result.Companion;
        a(Result.m9449constructorimpl(Unit.INSTANCE));
        Function1<? super Result<? extends List<g0>>, Unit> r103 = this.f544371d;
        if (r103 == null) goto L31;
        Runnable r104 = this.f544375h;
        if (r104 == null) goto L12;
        e0.f544279a.getClass();
        e0.f544281c.removeCallbacks(r104);
    L12:
        this.f544375h = null;
        this.f544371d = null;
        List<BluetoothGattService> r105 = r100.getServices();
        ArrayList r106 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));
        Iterator<T> r107 = r105.iterator();
    L14:
        if (r107.hasNext() == false) goto L20;
        BluetoothGattService r108 = (BluetoothGattService) r107.next();
        String r109 = r108.getUuid().toString();
        if (r108.getType() != 0) goto L18;
        boolean r110 = true;
    L19:
        r106.add(new g0(r109, r110));
        goto L14
    L18:
        r110 = false;
        goto L19
    L20:
        r103.invoke(Result.m9448boximpl(Result.m9449constructorimpl(r106)));
        return;
    L31:
        return;
    L21:
        Result.Companion r111 = Result.Companion;
        a(Result.m9449constructorimpl(ResultKt.createFailure(new IllegalStateException("discover services failed: " + r101))));
        Function1<? super Result<? extends List<g0>>, Unit> r112 = this.f544371d;
        if (r112 == null) goto L33;
        Runnable r113 = this.f544375h;
        if (r113 == null) goto L26;
        e0.f544279a.getClass();
        e0.f544281c.removeCallbacks(r113);
    L26:
        this.f544375h = null;
        this.f544371d = null;
        r112.invoke(Result.m9448boximpl(Result.m9449constructorimpl(ResultKt.createFailure(new IllegalStateException("discover services failed: " + r101)))));
        return;
    }

    public final void b(BluetoothGatt r100, BluetoothGattCharacteristic r101, byte[] r102) {
        y r103 = this.f544368a.get();
        if (r103 != null) goto L5;
        return;
    L5:
        String r104 = this.f544369b;
        String r105 = r101.getUuid().toString();
        Intrinsics.checkNotNullParameter(r104, "deviceId");
        Intrinsics.checkNotNullParameter(r105, "characteristicId");
        if (r103.f544425l.contains(y.c(r104, r105)) == true) goto L8;
        return;
    L8:
        e0.f544279a.getClass();
        String r106 = e0.h(r100, r101);
        if (r106 != null) goto L11;
        return;
    L11:
        r103.l(this.f544369b, r106, r101.getUuid().toString(), r102);
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public final void onCharacteristicChanged(BluetoothGatt r100, BluetoothGattCharacteristic r101, byte[] r102) {
        Intrinsics.checkNotNullParameter(r100, "gatt");
        Intrinsics.checkNotNullParameter(r101, "characteristic");
        Intrinsics.checkNotNullParameter(r102, "value");
        b(r100, r101, r102);
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public final void onCharacteristicRead(BluetoothGatt r100, BluetoothGattCharacteristic r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "gatt");
        Intrinsics.checkNotNullParameter(r101, "characteristic");
        c(r100, r101, r101.getValue(), r102);
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public final void onConnectionStateChange(BluetoothGatt r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "gatt");
        y r103 = this.f544368a.get();
        if (r103 != null) goto L5;
        return;
    L5:
        String r104 = this.f544369b;
        Intrinsics.checkNotNullParameter(r104, "deviceId");
        t0 r105 = r103.f544424k.get(r104);
        if (r101 == 0) goto L9;
        Result.Companion r106 = Result.Companion;
        a(Result.m9449constructorimpl(ResultKt.createFailure(new IllegalStateException("connect gatt failed: " + r101))));
        r103.d(this.f544369b, new IllegalStateException("connect gatt failed: " + r101));
        r103.m(this.f544369b, false);
        return;
    L9:
        if (r102 != 0) goto L11;
        if (r105 == null) goto L21;
        r105.f544385d = false;
    L21:
        r103.m(this.f544369b, false);
        if (this.f544370c == null) goto L24;
        Result.Companion r107 = Result.Companion;
        a(Result.m9449constructorimpl(ResultKt.createFailure(new IllegalStateException("bluetooth disconnected"))));
    L24:
        r103.d(this.f544369b, new IllegalStateException("bluetooth disconnected"));
        return;
    L11:
        if (r102 == 2) goto L14;
        return;
    L14:
        if (r105 == null) goto L16;
        r105.f544385d = true;
    L16:
        r103.m(this.f544369b, true);
        Result.Companion r108 = Result.Companion;
        a(Result.m9449constructorimpl(Unit.INSTANCE));
        if (Build.VERSION.SDK_INT <= 33) goto L26;
        r100.setPreferredPhy(3, 3, 0);
        return;
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public final void onMtuChanged(BluetoothGatt r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "gatt");
        y r103 = this.f544368a.get();
        if (r103 != null) goto L5;
        return;
    L5:
        String r104 = this.f544369b;
        Intrinsics.checkNotNullParameter(r104, "deviceId");
        t0 r105 = r103.f544424k.get(r104);
        Function1<? super Result<Integer>, Unit> r106 = this.f544372e;
        if (r106 != null) goto L8;
        return;
    L8:
        Runnable r107 = this.f544376i;
        if (r107 == null) goto L11;
        e0.f544279a.getClass();
        e0.f544281c.removeCallbacks(r107);
    L11:
        this.f544376i = null;
        this.f544372e = null;
        if (r102 != 0) goto L16;
        if (r105 == null) goto L15;
        r105.f544386e = r101;
    L15:
        Result.Companion r108 = Result.Companion;
        r106.invoke(Result.m9448boximpl(Result.m9449constructorimpl(Integer.valueOf(r101))));
        return;
    L16:
        Result.Companion r109 = Result.Companion;
        r106.invoke(Result.m9448boximpl(Result.m9449constructorimpl(ResultKt.createFailure(new IllegalStateException("request mtu failed: " + r102)))));
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public final void onReadRemoteRssi(BluetoothGatt r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "gatt");
        y r103 = this.f544368a.get();
        if (r103 != null) goto L5;
        return;
    L5:
        String r104 = this.f544369b;
        Intrinsics.checkNotNullParameter(r104, "deviceId");
        t0 r105 = r103.f544424k.get(r104);
        Function1<? super Result<Integer>, Unit> r106 = this.f544373f;
        if (r106 != null) goto L8;
        return;
    L8:
        Runnable r107 = this.f544377j;
        if (r107 == null) goto L11;
        e0.f544279a.getClass();
        e0.f544281c.removeCallbacks(r107);
    L11:
        this.f544377j = null;
        this.f544373f = null;
        if (r102 != 0) goto L16;
        if (r105 == null) goto L15;
        r105.f544387f = r101;
    L15:
        Result.Companion r108 = Result.Companion;
        r106.invoke(Result.m9448boximpl(Result.m9449constructorimpl(Integer.valueOf(r101))));
        return;
    L16:
        Result.Companion r109 = Result.Companion;
        r106.invoke(Result.m9448boximpl(Result.m9449constructorimpl(ResultKt.createFailure(new IllegalStateException("read rssi failed: " + r102)))));
    }

    public final void c(BluetoothGatt r100, BluetoothGattCharacteristic r101, byte[] r102, int r103) {
        y r104 = this.f544368a.get();
        if (r104 != null) goto L5;
        return;
    L5:
        String r105 = this.f544369b;
        String r106 = r101.getUuid().toString();
        Intrinsics.checkNotNullParameter(r105, "deviceId");
        Intrinsics.checkNotNullParameter(r106, "characteristicId");
        String r107 = y.c(r105, r106);
        AtomicInteger r108 = r104.f544426m.get(r107);
        if (r108 != null) goto L9;
        boolean r109 = false;
    L12:
        if (r109 == true) goto L14;
        return;
    L14:
        if (r103 == 0) goto L16;
        return;
    L16:
        e0.f544279a.getClass();
        String r110 = e0.h(r100, r101);
        if (r110 != null) goto L19;
        return;
    L19:
        r104.l(this.f544369b, r110, r101.getUuid().toString(), r102);
        return;
    L9:
        if (r108.decrementAndGet() > 0) goto L11;
        r104.f544426m.remove(r107);
    L11:
        r109 = true;
        goto L12
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public final void onCharacteristicRead(BluetoothGatt r100, BluetoothGattCharacteristic r101, byte[] r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "gatt");
        Intrinsics.checkNotNullParameter(r101, "characteristic");
        Intrinsics.checkNotNullParameter(r102, "value");
        c(r100, r101, r102, r103);
    }
}
