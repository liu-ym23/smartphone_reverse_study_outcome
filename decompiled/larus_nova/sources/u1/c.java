package u1;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.util.Log;
import com.bes.bessdk.BesSdkConstants;
import com.bes.bessdk.service.base.BesServiceConfig;
import com.bes.sdk.device.HmDevice;
import com.bes.sdk.message.BaseMessage;
import com.bes.sdk.utils.DeviceProtocol;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes39.dex */
public final class c implements z1.a {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static volatile c f548229k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f548230a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f548231b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<BesServiceConfig> f548232c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<BluetoothSocket> f548233d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<z1.a.InterfaceC8408a> f548234e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<HmDevice> f548235f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<b> f548236g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<byte[]> f548237h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public b f548238i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f548239j;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final BluetoothDevice f548240a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final UUID f548241b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ c f548242c;

        public final void a() {
            c r100 = this.f548242c;     // Catch: IOException -> L19
            r100.b(r100.f548230a, "run: ------" + this.f548241b);     // Catch: IOException -> L19
            BluetoothSocket r101 = this.f548240a.createInsecureRfcommSocketToServiceRecord(this.f548241b);     // Catch: IOException -> L19
            r101.connect();     // Catch: IOException -> L19
            c r102 = this.f548242c;     // Catch: IOException -> L19
            InputStream r103 = r101.getInputStream();     // Catch: IOException -> L19
            OutputStream r104 = r101.getOutputStream();     // Catch: IOException -> L19
            BluetoothDevice r105 = this.f548240a;     // Catch: IOException -> L19
            r102.f548238i = new b(r102, r103, r104, r105);     // Catch: IOException -> L19
            int r106 = this.f548242c.i(r105);     // Catch: IOException -> L19
            List<BluetoothSocket> r107 = this.f548242c.f548233d;     // Catch: IOException -> L19
            monitor-enter(r107);     // Catch: IOException -> L19
            y1.a.a(this.f548242c.f548233d, r101, r106);     // Catch: Throwable -> L16
            monitor-exit(r107);     // Catch: Throwable -> L16
            List<b> r108 = this.f548242c.f548236g;     // Catch: IOException -> L19
            monitor-enter(r108);     // Catch: IOException -> L19
            c r109 = this.f548242c;     // Catch: Throwable -> L13
            y1.a.a(r109.f548236g, r109.f548238i, r106);     // Catch: Throwable -> L13
            monitor-exit(r108);     // Catch: Throwable -> L13
            c r110 = this.f548242c;     // Catch: IOException -> L19
            r110.f548239j = 100;     // Catch: IOException -> L19
            r110.p(true, this.f548240a);     // Catch: IOException -> L19
            ThreadMethodProxy.start(new PthreadThreadV2(this.f548242c.f548238i, "SppConnector$ConnectRunnable"));     // Catch: IOException -> L19
            return;
        L13:
            th = move-exception;
            throw th;     // Catch: IOException -> L19
        L16:
            th = move-exception;
            throw th;     // Catch: IOException -> L19
        L19:
            e = move-exception;
            y1.b.a(this.f548242c.f548230a, "ConnectRunnable run " + Log.getStackTraceString(e));
            c r111 = this.f548242c;
            r111.b(r111.f548230a, "reConnectTimes: ------" + this.f548242c.f548239j);
            c r112 = this.f548242c;
            int r113 = r112.f548239j;
            if (r113 <= 2) goto L23;
            r112.p(false, this.f548240a);
            return;
        L23:
            r112.f548239j = r113 + 1;
            HmDevice r114 = r112.h(this.f548240a);
            if (r114 == null) goto L33;
            this.f548242c.s(null, r114);
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(c r100, BluetoothDevice r101, UUID r102) {
            this.f548242c = r100;
            this.f548240a = r101;
            this.f548241b = r102;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final OutputStream f548243a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final InputStream f548244b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final BluetoothDevice f548245c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ c f548246d;

        public final void a() {
            byte[] r100 = new byte[1048576];     // Catch: Throwable -> L6 IOException -> L8
        L4:
            int r101 = this.f548244b.read(r100);     // Catch: Throwable -> L6 IOException -> L8
            c r102 = this.f548246d;     // Catch: Throwable -> L6 IOException -> L8
            byte[] r103 = new byte[r101];     // Catch: Throwable -> L6 IOException -> L8
            System.arraycopy(r100, 0, r103, 0, r101);     // Catch: Throwable -> L6 IOException -> L8
            c.c(r102, r103, this.f548245c);     // Catch: Throwable -> L6 IOException -> L8
        L6:
            th = move-exception;
            InputStream r104 = this.f548244b;     // Catch: IOException -> L21
            if (r104 == null) goto L23;
            r104.close();     // Catch: IOException -> L21
        L23:
            throw th;
        L21:
            e = move-exception;
            y1.b.a(this.f548246d.f548230a, "ConnectedRunnable run1 " + Log.getStackTraceString(e));
        L8:
            e = move-exception;
            y1.b.a(this.f548246d.f548230a, "ConnectedRunnable run " + Log.getStackTraceString(e));     // Catch: Throwable -> L6
            this.f548246d.p(false, this.f548245c);     // Catch: Throwable -> L6
            InputStream r105 = this.f548244b;     // Catch: IOException -> L14
            if (r105 == null) goto L31;
            r105.close();     // Catch: IOException -> L14
            return;
        L31:
            return;
        L14:
            e = move-exception;
            y1.b.a(this.f548246d.f548230a, "ConnectedRunnable run1 " + Log.getStackTraceString(e));
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(c r100, InputStream r101, OutputStream r102, BluetoothDevice r103) {
            this.f548246d = r100;
            this.f548244b = r101;
            this.f548243a = r102;
            this.f548245c = r103;
        }
    }

    public c() {
        this.f548230a = c.class.getSimpleName();
        this.f548239j = 0;
        this.f548232c = new CopyOnWriteArrayList();
        this.f548233d = new CopyOnWriteArrayList();
        this.f548234e = new CopyOnWriteArrayList();
        this.f548235f = new CopyOnWriteArrayList();
        this.f548236g = new CopyOnWriteArrayList();
        this.f548237h = new CopyOnWriteArrayList();
    }

    @Override // z1.a
    public final void a(HmDevice r100) {
        b(this.f548230a, "disconnect------spp");
        d(g(r100));
    }

    public final void d(BluetoothDevice r100) {
        BluetoothSocket r101 = f(r100);     // Catch: IOException -> L27
        if (r101 == null) goto L5;
        r101.close();     // Catch: IOException -> L27
    L5:
        int r102 = i(r100);     // Catch: IOException -> L27
        List<BesServiceConfig> r103 = this.f548232c;     // Catch: IOException -> L27
        monitor-enter(r103);     // Catch: IOException -> L27
        y1.a.g(this.f548232c, r102);     // Catch: Throwable -> L24
        monitor-exit(r103);     // Catch: Throwable -> L24
        List<BluetoothSocket> r104 = this.f548233d;     // Catch: IOException -> L27
        monitor-enter(r104);     // Catch: IOException -> L27
        y1.a.g(this.f548233d, r102);     // Catch: Throwable -> L21
        monitor-exit(r104);     // Catch: Throwable -> L21
        List<b> r105 = this.f548236g;     // Catch: IOException -> L27
        monitor-enter(r105);     // Catch: IOException -> L27
        y1.a.g(this.f548236g, r102);     // Catch: Throwable -> L18
        monitor-exit(r105);     // Catch: Throwable -> L18
    L37:
        return;
    L18:
        th = move-exception;
        throw th;     // Catch: IOException -> L27
    L21:
        th = move-exception;
        throw th;     // Catch: IOException -> L27
    L24:
        th = move-exception;
        throw th;     // Catch: IOException -> L27
    L27:
        e = move-exception;
        y1.b.a(this.f548230a, "close " + Log.getStackTraceString(e));
    }

    public final BluetoothSocket f(BluetoothDevice r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        int r101 = i(r100);
        List<BluetoothSocket> r102 = this.f548233d;
        monitor-enter(r102);
    L14:
        th = move-exception;
        throw th;
    L8:
        if (((CopyOnWriteArrayList) this.f548233d).size() <= r101) goto L12;
        BluetoothSocket r103 = (BluetoothSocket) ((CopyOnWriteArrayList) this.f548233d).get(r101);     // Catch: Throwable -> L14
        monitor-exit(r102);     // Catch: Throwable -> L14
        return r103;
    L12:
        monitor-exit(r102);     // Catch: Throwable -> L14
        return null;
    }

    public final BluetoothDevice g(HmDevice r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (r100.getPreferredProtocol() != DeviceProtocol.PROTOCOL_BLE) goto L8;
        String r101 = r100.getBleAddress();
    L10:
        return v1.a.a(this.f548231b).getRemoteDevice(r101);
    L8:
        r101 = r100.getDeviceMAC();
        goto L10
    }

    public final HmDevice h(BluetoothDevice r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        int r101 = i(r100);
        List<HmDevice> r102 = this.f548235f;
        monitor-enter(r102);
    L14:
        th = move-exception;
        throw th;
    L8:
        if (((CopyOnWriteArrayList) this.f548235f).size() <= r101) goto L12;
        HmDevice r103 = (HmDevice) ((CopyOnWriteArrayList) this.f548235f).get(r101);     // Catch: Throwable -> L14
        monitor-exit(r102);     // Catch: Throwable -> L14
        return r103;
    L12:
        monitor-exit(r102);     // Catch: Throwable -> L14
        return null;
    }

    public final int i(BluetoothDevice r100) {
        if (r100 != null) goto L5;
        return 10000;
    L5:
        String r101 = r100.getAddress();
        if (r101 != null) goto L8;
        return 10000;
    L8:
        List<HmDevice> r102 = this.f548235f;
        monitor-enter(r102);
        int r103 = 0;
    L30:
    L27:
        th = move-exception;
        throw th;
    L12:
        if (r103 >= ((CopyOnWriteArrayList) this.f548235f).size()) goto L25;
        HmDevice r104 = (HmDevice) ((CopyOnWriteArrayList) this.f548235f).get(r103);     // Catch: Throwable -> L27
        if (r104 != null) goto L17;
    L24:
        r103 = r103 + 1;     // Catch: Throwable -> L27
        goto L30
    L17:
        if (r104.getPreferredProtocol() != DeviceProtocol.PROTOCOL_BLE) goto L19;
        String r105 = r104.getBleAddress();     // Catch: Throwable -> L27
    L21:
        if (r101.equals(r105) == false) goto L24;
        monitor-exit(r102);     // Catch: Throwable -> L27
        return r103;
    L19:
        r105 = r104.getDeviceMAC();     // Catch: Throwable -> L27
        goto L21
    L25:
        monitor-exit(r102);     // Catch: Throwable -> L27
        return 10000;
    }

    public final z1.a.InterfaceC8408a j(BluetoothDevice r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        int r101 = i(r100);
        List<z1.a.InterfaceC8408a> r102 = this.f548234e;
        monitor-enter(r102);
    L14:
        th = move-exception;
        throw th;
    L8:
        if (((CopyOnWriteArrayList) this.f548234e).size() <= r101) goto L12;
        z1.a.InterfaceC8408a r103 = (z1.a.InterfaceC8408a) ((CopyOnWriteArrayList) this.f548234e).get(r101);     // Catch: Throwable -> L14
        monitor-exit(r102);     // Catch: Throwable -> L14
        return r103;
    L12:
        monitor-exit(r102);     // Catch: Throwable -> L14
        return null;
    }

    public final BesServiceConfig k(BluetoothDevice r100) {
        int r101 = i(r100);
        List<BesServiceConfig> r102 = this.f548232c;
        monitor-enter(r102);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (((CopyOnWriteArrayList) this.f548232c).size() <= r101) goto L9;
        BesServiceConfig r103 = (BesServiceConfig) ((CopyOnWriteArrayList) this.f548232c).get(r101);     // Catch: Throwable -> L12
        monitor-exit(r102);     // Catch: Throwable -> L12
        return r103;
    L9:
        monitor-exit(r102);     // Catch: Throwable -> L12
        return null;
    }

    public final byte[] l(BluetoothDevice r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        int r101 = i(r100);
        List<byte[]> r102 = this.f548237h;
        monitor-enter(r102);
    L14:
        th = move-exception;
        throw th;
    L8:
        if (((CopyOnWriteArrayList) this.f548237h).size() <= r101) goto L12;
        byte[] r103 = (byte[]) ((CopyOnWriteArrayList) this.f548237h).get(r101);     // Catch: Throwable -> L14
        monitor-exit(r102);     // Catch: Throwable -> L14
        return r103;
    L12:
        monitor-exit(r102);     // Catch: Throwable -> L14
        return null;
    }

    public final BesSdkConstants.BesConnectState m(BesServiceConfig r100) {
        if (r100.getDevice() == null) goto L43;
        if (r100.getServiceUUID() == null) goto L43;
        BluetoothDevice r101 = g(r100.getDevice());
        BesServiceConfig r102 = k(r101);
        if (o(r100) == true) goto L41;
        if (f(r101) == null) goto L41;
        if (r101 == null) goto L21;
        int r103 = i(r101);
        List<b> r104 = this.f548236g;
        monitor-enter(r104);
    L37:
        th = move-exception;
        throw th;
    L16:
        if (((CopyOnWriteArrayList) this.f548236g).size() <= r103) goto L20;
        b r105 = (b) ((CopyOnWriteArrayList) this.f548236g).get(r103);     // Catch: Throwable -> L37
        monitor-exit(r104);     // Catch: Throwable -> L37
    L22:
        if (r105 == null) goto L41;
        if (r102 == null) goto L41;
        if (r102.getTotaConnect().booleanValue() == false) goto L29;
        if (l(r101) == null) goto L41;
    L29:
        if (r100.getServiceUUID().toString().equals(r102.getServiceUUID().toString()) == false) goto L33;
        return BesSdkConstants.BesConnectState.BES_CONNECT;
    L33:
        if (r102.getTotaConnect().booleanValue() == false) goto L36;
        return BesSdkConstants.BesConnectState.BES_CONNECT_TOTA;
    L36:
        return BesSdkConstants.BesConnectState.BES_CONNECT_NOTOTA;
    L20:
        monitor-exit(r104);     // Catch: Throwable -> L37
    L21:
        r105 = null;
    L41:
        return BesSdkConstants.BesConnectState.BES_NO_CONNECT;
    L43:
        return BesSdkConstants.BesConnectState.BES_CONFIG_ERROR;
    }

    public final boolean o(BesServiceConfig r100) {
        HmDevice r101 = r100.getDevice();
        if (r101 != null) goto L5;
        return false;
    L5:
        String r102 = r101.getDeviceMAC();
        if (r102 != null) goto L9;
        return false;
    L9:
        if (r100.getDeviceProtocol() != DeviceProtocol.PROTOCOL_SPP) goto L11;
        boolean r103 = true;
    L12:
        List<HmDevice> r104 = this.f548235f;
        monitor-enter(r104);
        int r105 = 0;
    L29:
    L26:
        th = move-exception;
        throw th;
    L16:
        if (r105 >= ((CopyOnWriteArrayList) this.f548235f).size()) goto L24;
        HmDevice r106 = (HmDevice) ((CopyOnWriteArrayList) this.f548235f).get(r105);     // Catch: Throwable -> L26
        if (r103 == false) goto L23;
        if (r102.equals(r106.getDeviceMAC()) == false) goto L23;
        monitor-exit(r104);     // Catch: Throwable -> L26
        return false;
    L23:
        r105 = r105 + 1;     // Catch: Throwable -> L26
        goto L29
    L24:
        monitor-exit(r104);     // Catch: Throwable -> L26
        return true;
    L11:
        r103 = false;
        goto L12
    }

    public static c n(Context r100, BesServiceConfig r101) {
        if (f548229k == null) goto L5;
    L14:
        if (r100 == null) goto L16;
        c r102 = f548229k;
        r102.f548231b = r100.getApplicationContext();
    L16:
        if (r101 != null) goto L18;
    L64:
        if (r101 == null) goto L74;
        BluetoothDevice r103 = f548229k.g(r101.getDevice());
        int r104 = f548229k.i(r103);
        List<BesServiceConfig> r105 = f548229k.f548232c;
        monitor-enter(r105);
        y1.a.a(f548229k.f548232c, r101, r104);     // Catch: Throwable -> L70
        monitor-exit(r105);     // Catch: Throwable -> L70
    L70:
        th = move-exception;
        throw th;
    L74:
        return f548229k;
    L18:
        if (r101.getDevice() == null) goto L64;
        if (f548229k.o(r101) == false) goto L64;
        List<HmDevice> r106 = f548229k.f548235f;
        monitor-enter(r106);
        List<HmDevice> r107 = f548229k.f548235f;     // Catch: Throwable -> L61
        CopyOnWriteArrayList r108 = (CopyOnWriteArrayList) r107;     // Catch: Throwable -> L61
        r108.add(r101.getDevice());     // Catch: Throwable -> L61
        monitor-exit(r106);     // Catch: Throwable -> L61
        List<BesServiceConfig> r109 = f548229k.f548232c;
        monitor-enter(r109);
        ((CopyOnWriteArrayList) f548229k.f548232c).add(r101);     // Catch: Throwable -> L58
        monitor-exit(r109);     // Catch: Throwable -> L58
        List<z1.a.InterfaceC8408a> r110 = f548229k.f548234e;
        monitor-enter(r110);
        ((CopyOnWriteArrayList) f548229k.f548234e).add(null);     // Catch: Throwable -> L55
        monitor-exit(r110);     // Catch: Throwable -> L55
        List<BluetoothSocket> r111 = f548229k.f548233d;
        monitor-enter(r111);
        ((CopyOnWriteArrayList) f548229k.f548233d).add(null);     // Catch: Throwable -> L52
        monitor-exit(r111);     // Catch: Throwable -> L52
        List<b> r112 = f548229k.f548236g;
        monitor-enter(r112);
        ((CopyOnWriteArrayList) f548229k.f548236g).add(null);     // Catch: Throwable -> L49
        monitor-exit(r112);     // Catch: Throwable -> L49
        List<byte[]> r113 = f548229k.f548237h;
        monitor-enter(r113);
        ((CopyOnWriteArrayList) f548229k.f548237h).add(null);     // Catch: Throwable -> L46
        monitor-exit(r113);     // Catch: Throwable -> L46
    L46:
        th = move-exception;
        throw th;
    L49:
        th = move-exception;
        throw th;
    L52:
        th = move-exception;
        throw th;
    L55:
        th = move-exception;
        throw th;
    L58:
        th = move-exception;
        throw th;
    L61:
        th = move-exception;
        throw th;
    L5:
        monitor-enter(c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f548229k != null) goto L9;
        f548229k = new c();     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
        goto L14
    }

    public final void b(String r100, String r101) {
        y1.b.b(r100, "LOG: " + r101);
    }

    public final void e(HmDevice r100, z1.a.InterfaceC8408a r101) {
        if (r100 == null) goto L9;
        if (r101 != null) goto L5;
        return;
    L5:
        if (this.f548231b == null) goto L11;
        this.f548239j = 0;
        s(r101, r100);
        return;
    L11:
        return;
    }

    public final void p(boolean r100, BluetoothDevice r101) {
        z1.a.InterfaceC8408a r102 = j(r101);
        if (r102 == null) goto L9;
        h(r101);
        if (r100 == false) goto L7;
        int r103 = 666;
    L8:
        DeviceProtocol r104 = DeviceProtocol.PROTOCOL_UNKNOWN;
        r102.onStatusChanged(r103);
        goto L9
    L7:
        r103 = 444;
    L9:
        if (r100 == true) goto L12;
        d(r101);
        return;
    }

    public final void q(z1.a.InterfaceC8408a r100, BluetoothDevice r101) {
        if (r100 == null) goto L13;
        if (r101 == null) goto L16;
        int r102 = i(r101);
        List<z1.a.InterfaceC8408a> r103 = this.f548234e;
        monitor-enter(r103);
        y1.a.a(this.f548234e, r100, r102);     // Catch: Throwable -> L10
        monitor-exit(r103);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    L16:
        return;
    }

    public final void r(byte[] r100, BluetoothDevice r101) {
        int r102 = i(r101);
        List<byte[]> r103 = this.f548237h;
        monitor-enter(r103);
        y1.a.a(this.f548237h, r100, r102);     // Catch: Throwable -> L7
        monitor-exit(r103);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void s(z1.a.InterfaceC8408a r100, HmDevice r101) {
        b(this.f548230a, "startConnect: -----spp");
        BluetoothDevice r102 = v1.a.a(this.f548231b).getRemoteDevice(r101.getDeviceMAC());
        BesServiceConfig r103 = k(r102);
        if (r103 != null) goto L6;
        p(false, r102);
        return;
    L6:
        ThreadMethodProxy.start(new PthreadThreadV2(new a(this, r102, r103.getServiceUUID()), "/SppConnector"));
        if (r100 == null) goto L16;
        int r104 = i(r102);
        List<z1.a.InterfaceC8408a> r105 = this.f548234e;
        monitor-enter(r105);
        y1.a.a(this.f548234e, r100, r104);     // Catch: Throwable -> L13
        monitor-exit(r105);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public final boolean t(byte[] r100, BluetoothDevice r101) {
        String r102 = this.f548230a;
        StringBuilder r103 = new StringBuilder("spp write: ------- data.length ");
        r103.append(r100.length);
        r103.append(" ");
        int r104 = Math.min(r100.length, 15);
        StringBuffer r105 = new StringBuffer();
        int r106 = 0;
    L4:
        if (r106 >= r104) goto L6;
        r105.append(String.format("%02x", new Object[]{Byte.valueOf(r100[r106])}));
        r105.append(",");
        r106 = r106 + 1;
        goto L4
    L6:
        r103.append(r105.toString());
        b(r102, r103.toString());
        b r107 = this.f548238i;
        if (r107 == null) goto L16;
        r107.f548243a.write(r100);     // Catch: IOException -> L10
        r107.f548243a.flush();     // Catch: IOException -> L10
        return true;
    L10:
        e = move-exception;
        y1.b.a(r107.f548246d.f548230a, "ConnectedRunnable write " + Log.getStackTraceString(e));
        r107.f548246d.p(false, r107.f548245c);
        return false;
    L16:
        return false;
    }

    public static void c(c r100, byte[] r101, BluetoothDevice r102) {
        r100.b(r100.f548230a, "spp onReceive: -------" + r102.getAddress());
        r100.b(r100.f548230a, "spp onReceive: -------" + r101.length);
        r100.b(r100.f548230a, "spp onReceive: ------" + y1.a.k(r101));
        y1.b.b(r100.f548230a, "spp onReceive: ------" + y1.a.k(r101));
        z1.a.InterfaceC8408a r103 = r100.j(r102);
        if (r103 == null) goto L39;
        byte[] r104 = r100.l(r102);
        if (r104 == null) goto L8;
        r100.b(r100.f548230a, "spp onReceive: aesKey------" + y1.a.k(r104));
    L8:
        if (r104 != null) goto L10;
    L33:
        BaseMessage r105 = new BaseMessage();
        r105.setPush(true);
        r105.setMsgContent(r101);
        r103.a(r105);
        return;
    L10:
        if (r104.length <= 0) goto L33;
        String r106 = y1.a.k(r101);
        int r107 = 0;
        if (r101[0] != (-97)) goto L14;
        String r108 = "54,41,49,4c,9f,";
        boolean r109 = true;
    L15:
        String[] r110 = r106.split(r108);
        r100.b(r100.f548230a, "spp onReceive: dataArr------" + r110);
        r100.b(r100.f548230a, "spp onReceive: dataArr------" + r110.length);
        if (r110.length <= 1) goto L33;
    L18:
        if (r107 >= r110.length) goto L40;
        if (r107 != 0) goto L22;
        String r111 = r110[r107] + "54,41,49,4c,";
    L32:
        r100.b(r100.f548230a, "spp onReceive: lastData------" + r111);
        BaseMessage r112 = new BaseMessage();
        r112.setPush(true);
        r112.setMsgContent(y1.a.j(r111));
        r103.a(r112);
        r107 = r107 + 1;
        goto L18
    L22:
        String r113 = "48,45,41,44,";
        if (r107 != (r110.length - 1)) goto L28;
        StringBuilder r114 = new StringBuilder();
        if (r109 == false) goto L27;
        r113 = "9f,";
    L27:
        r114.append(r113);
        r114.append(r110[r107]);
        r111 = r114.toString();
        goto L32
    L28:
        StringBuilder r115 = new StringBuilder();
        if (r109 == false) goto L31;
        r113 = "9f,";
    L31:
        r115.append(r113);
        r115.append(r110[r107]);
        r115.append("54,41,49,4c,");
        r111 = r115.toString();
        goto L32
    L40:
        return;
    L14:
        r108 = "54,41,49,4c,48,45,41,44,";
        r109 = false;
        goto L15
    }
}
