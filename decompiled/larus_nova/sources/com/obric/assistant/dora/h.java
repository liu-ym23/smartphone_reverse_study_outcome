package com.obric.assistant.dora;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHeadset;
import android.bluetooth.BluetoothProfile;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class h implements BluetoothProfile.ServiceListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CountDownLatch f389117a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BluetoothDevice[] f389118b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ BluetoothAdapter f389119c;

    @Override // android.bluetooth.BluetoothProfile.ServiceListener
    public final void onServiceDisconnected(int r100) {
        this.f389117a.countDown();
    }

    @Override // android.bluetooth.BluetoothProfile.ServiceListener
    public final void onServiceConnected(int r100, BluetoothProfile r101) {
        Intrinsics.checkNotNullParameter(r101, "proxy");
        BluetoothDevice[] r102 = this.f389118b;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L15
        BluetoothDevice r104 = null;
        if ((r101 instanceof BluetoothHeadset) == false) goto L6;
        BluetoothHeadset r105 = (BluetoothHeadset) r101;     // Catch: Throwable -> L15
    L7:
        if (r105 == null) goto L13;
        List<BluetoothDevice> r106 = r105.getConnectedDevices();     // Catch: Throwable -> L15
        if (r106 == null) goto L12;
        r104 = (BluetoothDevice) CollectionsKt.firstOrNull(r106);     // Catch: Throwable -> L15
    L12:
        r102[0] = r104;     // Catch: Throwable -> L15
    L13:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L15
    L24:
        this.f389119c.closeProfileProxy(r100, r101);     // Catch: Throwable -> L20
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L20
    L22:
        this.f389117a.countDown();
        return;
    L20:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L22
    L6:
        r105 = null;
    L15:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L24
    }

    public h(CountDownLatch r100, BluetoothDevice[] r101, BluetoothAdapter r102) {
        this.f389117a = r100;
        this.f389118b = r101;
        this.f389119c = r102;
    }
}
