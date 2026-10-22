package x1;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.os.Handler;
import com.bes.bessdk.BesSdkConstants;
import com.bes.bessdk.service.base.BesServiceConfig;
import com.bes.sdk.device.HmDevice;
import com.bes.sdk.utils.DeviceProtocol;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.dora.impl.device.ota.DoraOTAManagement$startDataTransfer$1;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;

/* JADX INFO: loaded from: classes39.dex */
public class a implements z1.a.InterfaceC8408a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f562080a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BesServiceConfig f562081b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f562082c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public z1.a f562083d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Context f562084e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f562085f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final d f562086g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f562087h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final PthreadHandlerThreadV2 f562088i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f562089j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public b f562090k;

    /* JADX INFO: renamed from: x1.a$a, reason: collision with other inner class name */
    public class RunnableC8178a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f562091a;

        @Override // java.lang.Runnable
        public final void run() {
            Thread.sleep(2000);     // Catch: Throwable -> L5 InterruptedException -> L7
        L9:
            this.f562091a.h();     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L14;
            return;
        L14:
            throw th;
        L7:
            e = move-exception;
            e.printStackTrace();     // Catch: Throwable -> L5
            goto L9
        }

        public RunnableC8178a(w1.b r100) {
            this.f562091a = r100;
        }
    }

    public void g(boolean r100) {
        throw null;
    }

    public final void n() {
        this.f562087h = true;
        this.f562085f = true;
        Context r100 = this.f562084e;
        DeviceProtocol r101 = this.f562081b.getDeviceProtocol();
        byte[] r102 = this.f562086g.f562095c;
        BluetoothDevice r103 = j();
        Object r104 = u1.a.f548212a;
        monitor-enter(r104);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (r101 != DeviceProtocol.PROTOCOL_BLE) goto L7;
    L12:
        u1.b r105 = u1.b.n(r100, null);     // Catch: Throwable -> L16
        y1.a.a(u1.b.f548221m, r102, r105.j(r103));     // Catch: Throwable -> L16
    L13:
        monitor-exit(r104);     // Catch: Throwable -> L16
        g(this.f562085f);
        return;
    L7:
        if (r101 == DeviceProtocol.PROTOCOL_GATT_BR_EDR) goto L12;
        if (r101 != DeviceProtocol.PROTOCOL_SPP) goto L13;
        u1.c.n(r100, null).r(r102, r103);     // Catch: Throwable -> L16
        goto L13
    }

    @Override // z1.a.InterfaceC8408a
    public void onStatusChanged(int r100) {
        throw null;
    }

    public final void h() {
        if (this.f562081b.getDeviceProtocol() != DeviceProtocol.PROTOCOL_BLE) goto L8;
        if (this.f562081b.getDevice().getBleAddress() == null) goto L8;
        c(this.f562080a, "startConnect: -------ble");
        u1.b r100 = u1.b.n(this.f562084e, this.f562081b);
        this.f562083d = r100;
        r100.e(this.f562081b.getDevice(), this);
        return;
    L8:
        if (this.f562081b.getDeviceProtocol() != DeviceProtocol.PROTOCOL_SPP) goto L13;
        if (this.f562081b.getDevice().getDeviceMAC() == null) goto L13;
        u1.c r101 = u1.c.n(this.f562084e, this.f562081b);
        this.f562083d = r101;
        r101.e(this.f562081b.getDevice(), this);
        return;
    L13:
        if (this.f562081b.getDeviceProtocol() != DeviceProtocol.PROTOCOL_GATT_BR_EDR) goto L18;
        if (this.f562081b.getDevice().getDeviceMAC() == null) goto L18;
        u1.b r102 = u1.b.n(this.f562084e, this.f562081b);
        this.f562083d = r102;
        r102.e(this.f562081b.getDevice(), this);
        return;
    L18:
        if (this.f562081b.getDeviceProtocol() == DeviceProtocol.PROTOCOL_USB) goto L20;
    L26:
        e(1029);
        return;
    L20:
        if (this.f562081b.getDevice().getDeviceVid() == null) goto L26;
        if (this.f562081b.getDevice().getDevicePid() == null) goto L26;
        u1.d r103 = u1.d.f(this.f562084e);
        this.f562083d = r103;
        r103.e(this.f562081b.getDevice(), this);
        throw null;
    }

    public final void i() {
        z1.a r100 = this.f562083d;
        if (r100 == null) goto L6;
        r100.a(this.f562081b.getDevice());
        return;
    }

    public final BluetoothDevice j() {
        if (this.f562081b.getDeviceProtocol() != DeviceProtocol.PROTOCOL_USB) goto L6;
        return null;
    L6:
        HmDevice r100 = this.f562081b.getDevice();
        if (this.f562081b.getDeviceProtocol() != DeviceProtocol.PROTOCOL_BLE) goto L9;
        String r101 = r100.getBleAddress();
    L11:
        return v1.a.a(this.f562084e).getRemoteDevice(r101);
    L9:
        r101 = r100.getDeviceMAC();
        goto L11
    }

    public final void e(int r100) {
        c r101 = this.f562082c;
        if (r101 == null) goto L6;
        r101.d(r100, this.f562081b.getDevice());
        return;
    }

    public final BesSdkConstants.BesConnectState k(BesServiceConfig r100) {
        Context r101 = this.f562084e;
        Object r102 = u1.a.f548212a;
        monitor-enter(r102);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (r100.getDeviceProtocol() != DeviceProtocol.PROTOCOL_BLE) goto L7;
    L16:
        BesSdkConstants.BesConnectState r103 = u1.b.n(r101, null).m(r100);     // Catch: Throwable -> L19
        monitor-exit(r102);     // Catch: Throwable -> L19
        return r103;
    L7:
        if (r100.getDeviceProtocol() == DeviceProtocol.PROTOCOL_GATT_BR_EDR) goto L16;
        if (r100.getDeviceProtocol() != DeviceProtocol.PROTOCOL_SPP) goto L14;
        BesSdkConstants.BesConnectState r104 = u1.c.n(r101, null).m(r100);     // Catch: Throwable -> L19
        monitor-exit(r102);     // Catch: Throwable -> L19
        return r104;
    L14:
        monitor-exit(r102);     // Catch: Throwable -> L19
        return BesSdkConstants.BesConnectState.BES_CONFIG_ERROR;
    }

    public final boolean l(byte[] r100) {
        if (this.f562087h == true) goto L6;
        return false;
    L6:
        if (this.f562089j == true) goto L8;
        boolean r101 = ((Boolean) y1.d.a(this.f562084e, "BES_TOTA_ENCRYPTION_KEY", Boolean.TRUE)).booleanValue();
        Context r102 = this.f562084e;
        DeviceProtocol r103 = this.f562081b.getDeviceProtocol();
        if (this.f562085f == false) goto L21;
        if (r101 == false) goto L21;
        if (this.f562081b.getUseTotaV2().booleanValue() == false) goto L19;
        d r104 = this.f562086g;
        r100 = r104.a(r104.d(r100));
    L24:
        return u1.a.c(r102, r103, r100, j());
    L19:
        r100 = this.f562086g.d(r100);
    L21:
        if (this.f562081b.getUseTotaV2().booleanValue() == false) goto L24;
        r100 = this.f562086g.a(r100);
        goto L24
    L8:
        if (this.f562085f == false) goto L10;
        d r105 = this.f562086g;
        byte[] r106 = r105.a(r105.d(r100));
    L12:
        return u1.a.c(this.f562084e, this.f562081b.getDeviceProtocol(), y1.a.b(y1.a.b(new byte[]{-97}, y1.a.f(r106.length)), r106), j());
    L10:
        r106 = this.f562086g.a(r100);
        goto L12
    }

    public final void m(BesServiceConfig r100) {
        c(this.f562080a, "startConnect: -------");
        this.f562081b = r100;
        this.f562085f = false;
        if (r100.getDeviceProtocol() != DeviceProtocol.PROTOCOL_USB) goto L6;
        h();
        return;
    L6:
        BesSdkConstants.BesConnectState r101 = k(this.f562081b);
        c(this.f562080a, "startConnect: -------" + r101);
        if (this.f562086g == null) goto L15;
        if (this.f562081b.getTotaConnect().booleanValue() == false) goto L15;
        if (r101 != BesSdkConstants.BesConnectState.BES_CONNECT) goto L15;
        c(this.f562080a, "startConnect: ----TOTA---BES_CONNECT");
        u1.a.b(this.f562084e, this.f562081b.getDeviceProtocol(), (w1.b) this, j());
        this.f562086g.f562095c = u1.a.a(this.f562084e, this.f562081b.getDeviceProtocol(), j());
        n();
        return;
    L15:
        if (r101 != BesSdkConstants.BesConnectState.BES_CONNECT) goto L19;
        u1.a.b(this.f562084e, this.f562081b.getDeviceProtocol(), (w1.b) this, j());
        this.f562087h = true;
        f(666, "");
        this.f562081b.getDevice();
        this.f562081b.getDeviceProtocol();
        onStatusChanged(666);
        return;
    L19:
        if (r101 != BesSdkConstants.BesConnectState.BES_CONNECT_TOTA) goto L37;
        c(this.f562080a, "startConnect: -------DISCONNECT_First");
        HmDevice r102 = this.f562081b.getDevice();
        Object r103 = u1.a.f548212a;
        monitor-enter(r103);
    L34:
        th = move-exception;
        throw th;
    L23:
        if (r102.getPreferredProtocol() != DeviceProtocol.PROTOCOL_BLE) goto L25;
    L30:
        u1.b.n(null, null).a(r102);     // Catch: Throwable -> L34
    L31:
        monitor-exit(r103);     // Catch: Throwable -> L34
        ThreadMethodProxy.start(new PthreadThreadV2(new RunnableC8178a((w1.b) this), "esBaseService"));
        return;
    L25:
        if (r102.getPreferredProtocol() == DeviceProtocol.PROTOCOL_GATT_BR_EDR) goto L30;
        if (r102.getPreferredProtocol() != DeviceProtocol.PROTOCOL_SPP) goto L31;
        u1.c.n(null, null).a(r102);     // Catch: Throwable -> L34
        goto L31
    L37:
        h();
    }

    public static void c(String r100, String r101) {
        y1.b.b(r100, "LOG: --" + r101);
    }

    public final void f(int r100, String r101) {
        c r102 = this.f562082c;
        if (r102 == null) goto L6;
        r102.a(r100, r101, this.f562081b.getDevice());
        return;
    }

    public a(BesServiceConfig r100, DoraOTAManagement$startDataTransfer$1 r101, Context r102) {
        String r103 = getClass().getSimpleName();
        this.f562080a = r103;
        this.f562085f = false;
        this.f562087h = false;
        this.f562089j = false;
        this.f562090k = null;
        this.f562084e = r102;
        this.f562081b = r100;
        if (r100.getTotaConnect().booleanValue() == false) goto L7;
        d r104 = new d();
        this.f562086g = r104;
        if (k(this.f562081b) != BesSdkConstants.BesConnectState.BES_CONNECT) goto L8;
        r104.f562095c = u1.a.a(r102, this.f562081b.getDeviceProtocol(), j());
    L8:
        this.f562089j = r100.getIsUserOtaService().booleanValue();
        if (r102 != null) goto L11;
        return;
    L11:
        if (this.f562081b.getDeviceProtocol() != null) goto L13;
        return;
    L13:
        if (this.f562081b.getDevice() != null) goto L16;
        return;
    L16:
        if (this.f562088i != null) goto L19;
        PthreadHandlerThreadV2 r105 = new PthreadHandlerThreadV2("BESHandler");
        this.f562088i = r105;
        ThreadMethodProxy.start(r105);
    L19:
        if (this.f562088i != null) goto L21;
        y1.b.a(r103, "mHandlerThread == null");
    L22:
        this.f562082c = r101;
        return;
    L21:
        w1.b r106 = (w1.b) this;
        this.f562090k = new b(r106, this.f562088i.getLooper());
        goto L22
    L7:
        this.f562086g = null;
        goto L8
    }

    public static void d(Handler r100, long r101, int r102) {
        r100.sendMessageDelayed(r100.obtainMessage(r102), r101);
    }
}
