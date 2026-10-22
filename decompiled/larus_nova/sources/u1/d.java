package u1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbEndpoint;
import android.hardware.usb.UsbInterface;
import android.hardware.usb.UsbManager;
import android.os.Handler;
import android.os.Looper;
import com.bes.sdk.device.HmDevice;
import com.bes.sdk.message.BaseMessage;
import com.bes.sdk.utils.DeviceProtocol;
import com.bytedance.crash.Npth;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.Objects;

/* JADX INFO: loaded from: classes39.dex */
public final class d implements z1.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f548247c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile d f548248d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Context f548249e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static z1.a.InterfaceC8408a f548250f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static UsbManager f548251g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static UsbDevice f548252h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static UsbInterface f548253i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static UsbEndpoint f548254j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static UsbEndpoint f548255k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static UsbDeviceConnection f548256l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f548257a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f548258b;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public byte[] f548259a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f548260b;

        /* JADX INFO: renamed from: u1.d$a$a, reason: collision with other inner class name */
        public class RunnableC7818a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ byte[] f548261a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a f548262b;

            @Override // java.lang.Runnable
            public final void run() {
                d r100 = this.f548262b.f548260b;     // Catch: Throwable -> L6
                byte[] r101 = this.f548261a;     // Catch: Throwable -> L6
                String r102 = d.f548247c;     // Catch: Throwable -> L6
                r100.getClass();     // Catch: Throwable -> L6
                BaseMessage r103 = new BaseMessage();     // Catch: Throwable -> L6
                r103.setPush(true);     // Catch: Throwable -> L6
                r103.setMsgContent(r101);     // Catch: Throwable -> L6
                z1.a.InterfaceC8408a r104 = d.f548250f;     // Catch: Throwable -> L6
                if (r104 == null) goto L9;
                r104.a(r103);     // Catch: Throwable -> L6
                return;
            L9:
                return;
            L6:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L13;
                throw th;
            }

            public RunnableC7818a(a r100, byte[] r101) {
                this.f548262b = r100;
                this.f548261a = r101;
            }
        }

        public final void a() {
        L2:
            d r100 = this.f548260b;
            r100.getClass();
            UsbDeviceConnection r101 = d.f548256l;
            if (r101 == null) goto L8;
            byte[] r102 = new byte[4096];
            int r103 = r101.bulkTransfer(d.f548254j, r102, 4096, 1000);
            if (r103 <= 0) goto L8;
            byte[] r104 = new byte[r103];
            r100.f548257a = r104;
            System.arraycopy(r102, 0, r104, 0, r103);
            y1.a.k(r100.f548257a);
            boolean r105 = true;
        L9:
            if (r105 == false) goto L2;
            d r106 = this.f548260b;
            String r107 = d.f548247c;
            r106.b(r107, "curReceiveData: -------" + this.f548260b.f548257a.length);
            this.f548260b.b(r107, "curReceiveData: -------" + y1.a.k(this.f548260b.f548257a));
            byte[] r108 = y1.a.b(this.f548259a, this.f548260b.f548257a);
            this.f548259a = r108;
            y1.a.k(r108);
            Handler r109 = new Handler(Looper.getMainLooper());
            byte[] r110 = this.f548259a;
            this.f548259a = new byte[0];
            r109.post(new RunnableC7818a(this, r110));
        L8:
            r105 = false;
            goto L9
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            throw null;     // Catch: Throwable -> L4
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(d r100) {
            this.f548260b = r100;
            this.f548259a = new byte[0];
        }
    }

    public class b extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f548263a;

        public b(d r100) {
            this.f548263a = r100;
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context r100, Intent r101) {
            if ("com.android.usb.USB_PERMISSION".equals(r101.getAction()) == false) goto L58;
            monitor-enter(this);
            Context r102 = d.f548249e;     // Catch: Throwable -> L55
            b r103 = this.f548263a.f548258b;     // Catch: Throwable -> L55
            boolean r104 = false;
            ReceiverRegisterLancet.loge(r103, false);     // Catch: Throwable -> L55
            if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L61;
            r102.unregisterReceiver(r103);     // Catch: Throwable -> L55
        L16:
            UsbDevice r105 = (UsbDevice) r101.getParcelableExtra("device");     // Catch: Throwable -> L55
            if (r101.getBooleanExtra("permission", false) == false) goto L52;
            this.f548263a.b(d.f548247c, "BroadcastReceiver: -----------同意权限");     // Catch: Throwable -> L55
            d.f548252h = r105;     // Catch: Throwable -> L55
            boolean r106 = d.d();     // Catch: Throwable -> L55
            int r107 = 0;
        L20:
            if (r107 >= d.f548253i.getEndpointCount()) goto L31;
            UsbEndpoint r108 = d.f548253i.getEndpoint(r107);     // Catch: Throwable -> L55
            if (r108 == null) goto L29;
            if (r108.getDirection() != 128) goto L27;
            d.f548254j = r108;     // Catch: Throwable -> L55
            goto L29
        L27:
            if (r108.getDirection() != 0) goto L29;
            d.f548255k = r108;     // Catch: Throwable -> L55
        L29:
            r107 = r107 + 1;     // Catch: Throwable -> L55
            goto L20
        L31:
            if (d.f548254j != null) goto L33;
        L35:
            boolean r109 = false;
        L36:
            UsbDevice r110 = d.f548252h;     // Catch: Throwable -> L55
            if (r110 == null) goto L46;
            UsbDeviceConnection r111 = d.f548251g.openDevice(r110);     // Catch: Throwable -> L55
            if (r111 == null) goto L46;
            if (r111.claimInterface(d.f548253i, true) == false) goto L45;
            d.f548256l = r111;     // Catch: Throwable -> L55
            r104 = true;
            goto L46
        L45:
            r111.close();     // Catch: Throwable -> L55
        L46:
            d r112 = this.f548263a;     // Catch: Throwable -> L55
            String r113 = d.f548247c;     // Catch: Throwable -> L55
            r112.b(r113, "getInterface: -----------" + r106);     // Catch: Throwable -> L55
            this.f548263a.b(r113, "getPoint: -----------" + r109);     // Catch: Throwable -> L55
            this.f548263a.b(r113, "openDevice: -----------" + r104);     // Catch: Throwable -> L55
            if (r106 == false) goto L51;
            if (r109 == false) goto L51;
            if (r104 == false) goto L51;
            z1.a.InterfaceC8408a r114 = d.f548250f;     // Catch: Throwable -> L55
            DeviceProtocol r115 = DeviceProtocol.PROTOCOL_UNKNOWN;     // Catch: Throwable -> L55
            r114.onStatusChanged(666);     // Catch: Throwable -> L55
        L53:
            monitor-exit(this);     // Catch: Throwable -> L55
            return;
        L51:
            z1.a.InterfaceC8408a r116 = d.f548250f;     // Catch: Throwable -> L55
            DeviceProtocol r117 = DeviceProtocol.PROTOCOL_UNKNOWN;     // Catch: Throwable -> L55
            r116.onStatusChanged(444);     // Catch: Throwable -> L55
            goto L53
        L33:
            if (d.f548255k == null) goto L35;
            r109 = true;
            goto L36
        L52:
            z1.a.InterfaceC8408a r118 = d.f548250f;     // Catch: Throwable -> L55
            DeviceProtocol r119 = DeviceProtocol.PROTOCOL_UNKNOWN;     // Catch: Throwable -> L55
            r118.onStatusChanged(444);     // Catch: Throwable -> L55
            goto L53
        L61:
        L11:
            e = move-exception;
            if (r103 == null) goto L14;
            Npth.addTag("unregisterReceiver", r103.toString());     // Catch: Throwable -> L55
        L14:
            e.printStackTrace();     // Catch: Throwable -> L55
            goto L16
        L8:
            if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(r103, r102) == false) goto L16;
            r102.unregisterReceiver(r103);     // Catch: Exception -> L11 Throwable -> L55
        L55:
            th = move-exception;
            throw th;
        }
    }

    @Override // z1.a
    public final void a(HmDevice r100) {
    }

    static {
        f548247c = d.class.getSimpleName();
    }

    public static void c() {
        if (f548249e != null) goto L6;
        return;
    }

    public d() {
        this.f548257a = new byte[0];
        new PthreadThreadV2(new a(this), "/UsbConnector");
        this.f548258b = new b(this);
    }

    public static boolean d() {
        c();
        if (f548252h == null) goto L17;
        int r100 = 0;
    L6:
        if (r100 >= f548252h.getInterfaceCount()) goto L24;
        c();
        UsbInterface r101 = f548252h.getInterface(r100);
        int r102 = 0;
    L9:
        if (r102 >= r101.getEndpointCount()) goto L16;
        c();
        UsbEndpoint r103 = r101.getEndpoint(r102);
        Objects.toString(r103);
        c();
        if (r103 == null) goto L15;
        r103.getEndpointNumber();
        c();
        if (r103.getEndpointNumber() != 4) goto L15;
        f548253i = r101;
        return true;
    L15:
        r102 = r102 + 1;
        goto L9
    L16:
        r100 = r100 + 1;
        goto L6
    L24:
        return false;
    L17:
        return false;
    }

    public static d f(Context r100) {
        if (f548248d == null) goto L5;
    L12:
        if (r100 == null) goto L15;
        f548249e = r100;
    L15:
        return f548248d;
    L5:
        monitor-enter(d.class);
        f548248d = new d();     // Catch: Throwable -> L9
        f548251g = (UsbManager) r100.getSystemService("usb");     // Catch: Throwable -> L9
        monitor-exit(d.class);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    public final boolean g(byte[] r100) {
        int r101 = r100.length;
        c();
        int r102 = f548256l.bulkTransfer(f548255k, r100, r100.length, 100);
        c();
        String r103 = f548247c;
        b(r103, "USB Write: --------" + r102);
        b(r103, "write length: --------" + r100.length);
        if (r102 <= 0) goto L6;
        return true;
    L6:
        return false;
    }

    public final boolean h(byte[] r100) {
        int r101 = r100.length;
        c();
        int r102 = f548256l.bulkTransfer(f548255k, r100, r100.length, 1000);
        c();
        String r103 = f548247c;
        b(r103, "USB writeWithoutResponse ncountWrite: --------" + r102);
        b(r103, "USB writeWithoutResponse length: --------" + r100.length);
        if (r102 <= 0) goto L6;
        return true;
    L6:
        return false;
    }

    public final void b(String r100, String r101) {
        if (f548249e != null) goto L6;
        return;
    }

    public final void e(HmDevice r100, z1.a.InterfaceC8408a r101) {
        f548250f = r101;
        f548254j = null;
        f548255k = null;
        throw null;
    }
}
