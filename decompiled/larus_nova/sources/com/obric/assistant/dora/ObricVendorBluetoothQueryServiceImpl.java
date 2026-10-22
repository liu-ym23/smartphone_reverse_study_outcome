package com.obric.assistant.dora;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import com.byted.cast.linkcommon.cybergarage.upnp.device.ST;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.spi.dora.IObricVendorBluetoothQueryService;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0003J\n\u0010\f\u001a\u0004\u0018\u00010\tH\u0003¨\u0006\u000e"}, d2 = {"Lcom/obric/assistant/dora/ObricVendorBluetoothQueryServiceImpl;", "Lcom/obric/assistant/spi/dora/IObricVendorBluetoothQueryService;", "<init>", "()V", "queryVendorBluetoothSppStatus", "Lcom/obric/assistant/spi/dora/VendorBluetoothSppStatus;", "isSppAvailable", "", "device", "Landroid/bluetooth/BluetoothDevice;", ST.UUID_DEVICE, "Ljava/util/UUID;", "getConnectedBluetoothHeadsetDevice", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricVendorBluetoothQueryServiceImpl implements IObricVendorBluetoothQueryService {

    public static final class a {
    }

    static {
    }

    public ObricVendorBluetoothQueryServiceImpl() {
    }

    @Override // com.obric.assistant.spi.dora.IObricVendorBluetoothQueryService
    public final lga.a a() {
        BluetoothAdapter r100 = BluetoothAdapter.getDefaultAdapter();
        boolean r101 = false;
        if (r100 != null) goto L6;
    L18:
        BluetoothDevice r102 = null;
    L24:
        if (r102 != null) goto L26;
        return null;
    L26:
        UUID r103 = UUID.fromString("00002499-0000-1000-8000-00805f9b34fb");
        UUID r104 = UUID.fromString("00101020-4C42-0065-636E-614465747942");
        Intrinsics.checkNotNull(r103);
        boolean r105 = b(r102, r103);
        if (r105 == true) goto L30;
        Intrinsics.checkNotNull(r104);
        r101 = b(r102, r104);
    L30:
        String r106 = r102.getAddress();
        if (r106 != null) goto L34;
        r106 = "";
    L34:
        return new lga.a(r106, r105, r101);
    L6:
        if (r100.isEnabled() == false) goto L18;
        CountDownLatch r107 = new CountDownLatch(1);
        BluetoothDevice[] r108 = new BluetoothDevice[1];
        Result.Companion r109 = Result.Companion;     // Catch: Throwable -> L11
        Object r110 = Result.m9449constructorimpl(Boolean.valueOf(r100.getProfileProxy(AppHost.f326268a.getApplication(), new h(r107, r108, r100), 1)));     // Catch: Throwable -> L11
    L13:
        Boolean r111 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r110) == false) goto L17;
        r110 = r111;
    L17:
        if (((Boolean) r110).booleanValue() == false) goto L18;
        Result.m9449constructorimpl(Boolean.valueOf(r107.await(500, TimeUnit.MILLISECONDS)));     // Catch: Throwable -> L21
    L23:
        r102 = r108[0];
    L21:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L11:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r110 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    }

    public static boolean b(BluetoothDevice r100, UUID r101) {
        if (kj4.a.g().isReady() == 0) goto L40;
        FLogger.f375446a.w("ObricVendorBluetooth", "isSppAvailable: DoraAdapter is not ready");
        return false;
    L40:
        BluetoothSocket r102 = r100.createRfcommSocketToServiceRecord(r101);     // Catch: Throwable -> L19
        if (r102 != null) goto L10;
        FLogger.f375446a.w("ObricVendorBluetooth", "isSppAvailable: createRfcommSocketToServiceRecord return null");     // Catch: Throwable -> L17
        return false;
    L10:
        r102.connect();     // Catch: Throwable -> L17
        r102.close();     // Catch: Throwable -> L13
        return true;
    L13:
        th = move-exception;
        FLogger.f375446a.e("ObricVendorBluetooth", "isSppAvailable: close socket error", th);
        return true;
    L17:
        th = th;
    L42:
        FLogger.f375446a.e("ObricVendorBluetooth", "isSppAvailable exception", th);     // Catch: Throwable -> L28
        if (r102 != null) goto L38;
    L27:
        return false;
    L38:
        r102.close();     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        FLogger.f375446a.e("ObricVendorBluetooth", "isSppAvailable: close socket error", th);
    L28:
        th = move-exception;
        if (r102 != null) goto L35;
    L34:
        throw th;
    L35:
        r102.close();     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        FLogger.f375446a.e("ObricVendorBluetooth", "isSppAvailable: close socket error", th);
    L19:
        th = th;
        r102 = null;
        goto L42
    }
}
