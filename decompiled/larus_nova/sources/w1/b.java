package w1;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.bes.bessdk.service.base.BesServiceConfig;
import com.bes.sdk.message.BaseMessage;
import com.bes.sdk.ota.RemoteOTAConfig;
import com.bes.sdk.utils.DeviceProtocol;
import com.bes.sdk.utils.OTAStatus;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.dora.impl.device.ota.DoraOTAManagement;
import com.larus.dora.impl.device.ota.DoraOTAManagement$startDataTransfer$1;
import com.miui.easygo.constant.EasyGoConstant;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadTimer;
import com.ss.android.ugc.dex.maindexslimming.annotation.MainDexIgnore;
import com.ss.bduploader.BDVideoUploaderBase;
import fna.g;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import kotlin.UByte;

/* JADX INFO: loaded from: classes39.dex */
public final class b extends x1.a {
    public final int A;
    public final boolean B;
    public final int C;
    public final int D;
    public long E;
    public final long F;
    public final int G;
    public final boolean H;
    public String I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public boolean f557860J;
    public boolean K;
    public PthreadTimer L;
    public w1.a M;
    public Boolean N;
    public BluetoothLeScanner O;
    public boolean P;
    public final c Q;
    public final d R;
    public int S;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Object f557861l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public RemoteOTAConfig f557862m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public OTAStatus f557863n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public a2.a f557864o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f557865p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public a2.b f557866q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f557867r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f557868s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f557869t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f557870u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f557871v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f557872w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f557873x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final boolean f557874y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f557875z;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f557876a;

        @Override // java.lang.Runnable
        public final void run() {
            Thread.sleep(10);     // Catch: Throwable -> L6 InterruptedException -> L8
            b r100 = this.f557876a;     // Catch: Throwable -> L6 InterruptedException -> L8
            r100.f557868s = 0;     // Catch: Throwable -> L6 InterruptedException -> L8
            w1.a r101 = r100.M;     // Catch: Throwable -> L6 InterruptedException -> L8
            if (r101 == null) goto L10;
            r101.f557854u += r101.f557857x;     // Catch: Throwable -> L6 InterruptedException -> L8
        L10:
            r100.x();     // Catch: Throwable -> L6 InterruptedException -> L8
        L21:
            return;
        L8:
            e = move-exception;
            e.printStackTrace();     // Catch: Throwable -> L6
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L17;
            return;
        L17:
            throw th;
        }

        public a(b r100) {
            this.f557876a = r100;
        }
    }

    /* JADX INFO: renamed from: w1.b$b, reason: collision with other inner class name */
    public class C8056b extends PthreadThreadV2 {

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public final /* synthetic */ b f557877v;

        public final void l() {
            super.run();
            Thread.sleep(3000);     // Catch: InterruptedException -> L7
            x1.a.c(this.f557877v.f562080a, "scanSuccess: --------" + this.f557877v.P);     // Catch: InterruptedException -> L7
            b r100 = this.f557877v;     // Catch: InterruptedException -> L7
            if (r100.P == true) goto L12;
            x1.a.c(r100.f562080a, "!scanSuccess: --------");     // Catch: InterruptedException -> L7
            this.f557877v.u();     // Catch: InterruptedException -> L7
            return;
        L12:
            return;
        L7:
            e = move-exception;
            e.printStackTrace();
        }

        @Override // com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2, java.lang.Thread, java.lang.Runnable
        public final void run() {
            l();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public C8056b(b r100) {
            this.f557877v = r100;
            super("BesOtaService$2");
        }
    }

    public class c extends ScanCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f557878a;

        public c(b r100) {
            this.f557878a = r100;
        }

        @Override // android.bluetooth.le.ScanCallback
        public final void onScanFailed(int r100) {
            super.onScanFailed(r100);
            x1.a.c(this.f557878a.f562080a, "onScanFailed: ---------fail");
            this.f557878a.u();
        }

        @Override // android.bluetooth.le.ScanCallback
        public final void onScanResult(int r110, ScanResult r111) {
            this.f557878a.P = true;
            byte[] r112 = r111.getScanRecord().getBytes();
            StringBuilder r100 = new StringBuilder("");
            int r101 = 0;
            if (r112 != null) goto L5;
        L15:
            String r113 = null;
        L16:
            String r102 = "03ff";
            String[] r103 = r113.split("03ff");
            if (r113.contains("03ff03ff") == false) goto L35;
            String[] r114 = r113.split("03ff03ff");
            if (r114.length <= 1) goto L41;
            String r115 = r114[1];
            int r104 = 0;
        L22:
            if (r104 >= r115.length()) goto L27;
            int r105 = r104 + 1;
            if (r115.substring(r104, r105).equals("0") == false) goto L25;
            r104 = r105;
            goto L22
        L25:
            boolean r116 = false;
        L28:
            if (r116 == true) goto L41;
            String r117 = r103[r103.length - 1];
            if (r117.length() >= 4) goto L33;
            return;
        L33:
            r102 = r117.substring(0, 4);
            goto L41
        L27:
            r116 = true;
        L41:
            if (r102.equals(this.f557878a.I) == false) goto L63;
            b r118 = this.f557878a;
            BluetoothLeScanner r106 = r118.O;
            c r119 = r118.Q;
            if (g.d() == true) goto L45;
            r106.stopScan(r119);
        L49:
            this.f557878a.O = null;
            BluetoothDevice r120 = r111.getDevice();
            if (r120 != null) goto L52;
            return;
        L52:
            if (this.f557878a.f562081b.getDeviceProtocol() != DeviceProtocol.PROTOCOL_BLE) goto L54;
            this.f557878a.f562081b.getDevice().setBleAddress(r120.getAddress());
        L55:
            b r121 = this.f557878a;
            r121.m(r121.f562081b);
            return;
        L54:
            this.f557878a.f562081b.getDevice().setDeviceMAC(r120.getAddress());
            goto L55
        L45:
            r106.stopScan(r119);
            if (r119 == null) goto L48;
            r101 = r119.hashCode();
        L48:
            ina.a.c(r101);
            goto L49
        L63:
            return;
        L35:
            if (r103.length <= 1) goto L62;
            String r122 = r103[r103.length - 1];
            if (r122.length() >= 4) goto L39;
            return;
        L39:
            r102 = r122.substring(0, 4);
            goto L41
        L62:
            return;
        L5:
            if (r112.length <= 0) goto L15;
            int r107 = 0;
        L9:
            if (r107 >= r112.length) goto L14;
            String r108 = Integer.toHexString(r112[r107] & UByte.MAX_VALUE);
            if (r108.length() >= 2) goto L13;
            r100.append(0);
        L13:
            r100.append(r108);
            r107 = r107 + 1;
            goto L9
        L14:
            r113 = r100.toString();
            goto L16
        }
    }

    public class d extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f557879a;

        @Override // android.os.Handler
        public final void handleMessage(Message r110) {
            super.handleMessage(r110);
            x1.a.c(this.f557879a.f562080a, "handleMessage: -----" + r110.what);
            b r100 = this.f557879a;
            boolean r101 = r100.f562087h;
            if (r101 == true) goto L5;
            return;
        L5:
            if (r100.K == true) goto L121;
            int r111 = r110.what;
            if (r111 != 2323) goto L10;
            r100.i();
            return;
        L10:
            if (r111 != 2324) goto L12;
            boolean r112 = r100.x();     // Catch: Throwable -> L80
            if (r112 == false) goto L82;
            b r102 = this.f557879a;     // Catch: Throwable -> L80
            if (r102.f557867r <= 0) goto L82;
            w1.a r103 = r102.M;     // Catch: Throwable -> L80
            if (r103 == null) goto L82;
            r103.f557854u += r103.f557857x;     // Catch: Throwable -> L80
            r102.o();     // Catch: Throwable -> L80
        L92:
            return;
        L82:
            if (r112 == true) goto L92;
            b r113 = this.f557879a;     // Catch: Throwable -> L80
            if (r113.f557867r <= 0) goto L92;
            if (r113.M == null) goto L92;
            r113.o();     // Catch: Throwable -> L80
        L80:
            th = move-exception;
            x1.a.c(this.f557879a.f562080a, "OTADataError: " + Log.getStackTraceString(th));
            b r114 = this.f557879a;
            r114.f557863n = OTAStatus.STATUS_FAILED;
            r114.e(2375);
            return;
        L12:
            if (r111 != 2400) goto L14;
            x1.a.d(r100.R, 3000, 2400);
            b r115 = this.f557879a;
            w1.a r104 = r115.M;
            if (r104 == null) goto L118;
            r115.s(r104.f(r115.f557862m.getLocalPath()));
            return;
        L118:
            return;
        L14:
            switch(r111) {
                case 2384: goto L61;
                case 2385: goto L60;
                case 2386: goto L57;
                case 2387: goto L42;
                case 2388: goto L40;
                case 2389: goto L37;
                case 2390: goto L34;
                case 2391: goto L26;
                case 2392: goto L18;
                case 2393: goto L17;
                default: goto L15;
            };
        L15:
            switch(r111) {
                case 2475: goto L69;
                case 2476: goto L68;
                case 2477: goto L67;
                default: goto L122;
            };
        L67:
            r100.e(2477);
            return;
        L68:
            r100.e(2476);
            return;
        L69:
            r100.e(2475);
            return;
        L122:
            return;
        L17:
            r100.A();
            return;
        L18:
            int r116 = r100.f557873x;
            if (r116 > 1) goto L21;
            r100.f557873x = r116 + 1;
            r100.z();
            return;
        L21:
            if (r100.A != 0) goto L23;
            r100.r();
            return;
        L23:
            r100.e(2474);
            return;
        L26:
            int r117 = r100.f557871v;
            if (r117 <= 1) goto L30;
            r100.e(2471);
            return;
        L30:
            r100.f557871v = r117 + 1;
            w1.a r118 = r100.M;
            if (r118 == null) goto L33;
            r118.f557859z = true;
            r100.o();
            return;
        L33:
            r100.e(2471);
            return;
        L34:
            w1.a r119 = r100.M;
            if (r119 == null) goto L103;
            r100.s(r119.e(r100.f557862m.getLocalPath(), this.f557879a.f562084e));
            x1.a.d(this.f557879a.R, 3000, 2477);
            return;
        L103:
            return;
        L37:
            w1.a r120 = r100.M;
            if (r120 == null) goto L105;
            r100.s(r120.c(r100.f562084e));
            x1.a.d(this.f557879a.R, 3000, 2475);
            return;
        L105:
            return;
        L40:
            r100.f(2388, "");
            this.f557879a.w();
            return;
        L60:
            r100.f(2385, "");
            this.f557879a.y();
            return;
        L61:
            int r105 = r100.f557870u;
            if (r105 <= 2) goto L64;
            r100.e(r111);
            return;
        L64:
            if (r101 == false) goto L66;
            r100.f557870u = r105 + 1;
            r100.r();
            return;
        L66:
            r100.f557870u = 0;
            return;
        L42:
            if (r100.I.length() <= 0) goto L45;
            this.f557879a.i();
            return;
        L45:
            b r121 = this.f557879a;
            if (r121.A != 1) goto L55;
            int r106 = r121.f557872w;
            if (r106 <= 2) goto L50;
        L53:
            r121.f557872w = 0;
            r121.f557863n = OTAStatus.STATUS_FAILED;
            r121.e(2387);
            b r122 = this.f557879a;
            r122.f557863n = OTAStatus.STATUS_CANCELED;
            r122.q();
            return;
        L50:
            if (r121.f562087h == false) goto L53;
            r121.f557872w = r106 + 1;
            r121.v();
            return;
        L55:
            r121.A();
            return;
        L57:
            if (r100.I.length() <= 0) goto L59;
            this.f557879a.u();
            return;
        L59:
            b r123 = this.f557879a;
            r123.m(r123.f562081b);
            return;
        }

        public d(b r100, Looper r101) {
            this.f557879a = r100;
            super(r101);
        }
    }

    public final void u() {
        int r100 = 0;
        this.f557867r = 0;
        this.f557863n = OTAStatus.STATUS_REBOOT;
        x1.a.c(this.f562080a, "scanToReConnected: -----------");
        BluetoothLeScanner r101 = this.O;
        if (r101 == null) goto L13;
        c r102 = this.Q;
        if (g.d() == true) goto L7;
        r101.stopScan(r102);
    L12:
        this.O = null;
        goto L13
    L7:
        r101.stopScan(r102);
        if (r102 == null) goto L10;
        int r103 = r102.hashCode();
    L11:
        ina.a.c(r103);
        goto L12
    L10:
        r103 = 0;
    L13:
        this.P = false;
        ThreadMethodProxy.start(new C8056b(this));
        BluetoothLeScanner r104 = v1.a.a(this.f562084e).getBluetoothLeScanner();
        this.O = r104;
        ScanSettings r105 = new ScanSettings.Builder().setScanMode(2).build();
        c r106 = this.Q;
        if (g.d() == true) goto L16;
        r104.startScan(null, r105, r106);
        return;
    L16:
        r104.startScan(null, r105, r106);
        if (r106 == null) goto L19;
        r100 = r106.hashCode();
    L19:
        ina.a.b(r100);
    }

    public final void A() {
        w1.a r100 = this.M;
        if (r100 != null) goto L5;
        return;
    L5:
        int r101 = this.C;
        byte r102 = 1;
        byte[] r103 = {-99};
        byte[] r104 = r100.f557842i;
        byte[] r105 = new byte[1];
        if (r100.f557835b != 1) goto L8;
        r104 = y1.a.f(1);
    L8:
        if (r101 == 1) goto L14;
        r102 = 2;
        if (r101 == 2) goto L14;
        r102 = 0;
    L14:
        r105[0] = r102;
        byte[] r106 = y1.a.c(r103, r104, r100.f557842i, r105);
        if (r100.f557837d == false) goto L17;
        r106 = r100.b(r106);
    L17:
        s(r106);
        x1.a.d(this.R, 3000, 2388);
    }

    public final void D() {
        x1.a.c(this.f562080a, "startOta: ------------");
        this.f557867r = 0;
        OTAStatus r100 = OTAStatus.STATUS_STARTED;
        this.f557863n = r100;
        p(r100);
        Thread.sleep(200);     // Catch: InterruptedException -> L5
    L7:
        A();
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public final void E() {
        x1.a.c(this.f562080a, "stopSppRoleSwitchTimer----");
        PthreadTimer r100 = this.L;
        if (r100 == null) goto L6;
        r100.cancel();
        this.L = null;
        return;
    }

    public final void o() {
        if (this.f557863n != OTAStatus.STATUS_PAUSED) goto L6;
        return;
    L6:
        if (this.A != 1) goto L10;
        if (this.H == false) goto L10;
    L13:
        long r100 = this.E;
        d r101 = this.R;
        r101.sendMessageDelayed(r101.obtainMessage(2324), r100);
        return;
    L10:
        if (this.f562081b.getDeviceProtocol() == DeviceProtocol.PROTOCOL_SPP) goto L12;
    L14:
        x();
        return;
    L12:
        if (this.f557874y == true) goto L14;
        goto L13
    }

    public final void q() {
        x1.a.c(this.f562080a, "destoryVariable: --------------");
        if (((Boolean) y1.d.a(this.f562084e, "BES_BLE_OTA_AUTO_TEST", Boolean.FALSE)).booleanValue() == false) goto L5;
        i();
    L5:
        w1.a r100 = this.M;
        if (r100 == null) goto L8;
        r100.f557851r = null;
        r100.f557852s = 0;
        r100.f557854u = 0;
        r100.f557856w = 0;
        r100.f557857x = 0;
        r100.f557858y = 0;
        r100.f557859z = false;
        r100.A = "";
        r100.f557855v = 0;
        this.M = null;
    L8:
        this.I = "";
        this.f557862m = null;
        this.f557864o = null;
        this.f557866q = null;
        this.f557867r = 0;
    }

    public final void r() {
        if (this.M != null) goto L5;
        return;
    L5:
        x1.a.c(this.f562080a, "getCurrentVersion");
        this.f557863n = OTAStatus.STATUS_STARTED;
        w1.a r100 = this.M;
        r100.getClass();
        byte[] r101 = {-114};
        byte[] r102 = r100.f557842i;
        if (r100.f557835b != 1) goto L8;
        r102 = y1.a.f(r100.f557841h.length);
    L8:
        byte[] r103 = y1.a.c(r101, r102, r100.f557841h, r100.f557842i);
        if (r100.f557837d == false) goto L11;
        r103 = r100.b(r103);
    L11:
        s(r103);
        x1.a.d(this.R, 5000, 2384);
    }

    public final void v() {
        x1.a.c(this.f562080a, "sendGetProtocolVersionData");
        w1.a r100 = this.M;
        if (r100 != null) goto L5;
        return;
    L5:
        byte r101 = this.B;
        byte[] r102 = {-103};
        byte[] r103 = r100.f557842i;
        byte[] r104 = new byte[4];
        if (r100.f557835b != 1) goto L8;
        r103 = y1.a.f(4);
    L8:
        r104[3] = r101;
        byte[] r105 = y1.a.c(r102, r103, r100.f557842i, r104);
        if (r100.f557837d == false) goto L11;
        r105 = r100.b(r105);
    L11:
        s(r105);
        x1.a.d(this.R, 3000, 2387);
        x1.a.c(this.f562080a, "addTimeOutMsg MSG_GET_PROTOCOL_VERSION_TIME_OUT: ---------" + this.R);
    }

    public final void w() {
        if (this.I.length() <= 0) goto L6;
        y();
        return;
    L6:
        w1.a r100 = this.M;
        if (r100 != null) goto L9;
        return;
    L9:
        byte[] r101 = {-101};
        byte[] r102 = r100.f557842i;
        if (r100.f557835b != 1) goto L12;
        r102 = y1.a.f(0);
    L12:
        byte[] r103 = r100.f557842i;
        byte[] r104 = y1.a.c(r101, r102, r103, r103);
        if (r100.f557837d == false) goto L15;
        r104 = r100.b(r104);
    L15:
        s(r104);
        x1.a.d(this.R, 3000, 2385);
    }

    public final boolean x() {
        if (this.f557860J == false) goto L5;
    L109:
        return false;
    L5:
        if (this.f562087h == false) goto L109;
        if (this.K == true) goto L109;
        Object r100 = this.f557861l;
        monitor-enter(r100);
        RemoteOTAConfig r101 = this.f557862m;     // Catch: Throwable -> L106
        if (r101 == null) goto L104;
        w1.a r102 = this.M;     // Catch: Throwable -> L106
        if (r102 == null) goto L104;
        String r103 = r101.getLocalPath();     // Catch: Throwable -> L106
        if (this.f562081b.getDeviceProtocol() != DeviceProtocol.PROTOCOL_BLE) goto L19;
    L22:
        boolean r104 = true;
    L23:
        byte[] r105 = r102.d(r103, r104);     // Catch: Throwable -> L106
        int r106 = 4;
        if (this.f562081b.getTotaConnect().booleanValue() == false) goto L26;
        int r107 = 4;
    L28:
        if (this.D != 6) goto L30;
        int r108 = 1;
    L32:
        if (r105[r107 + r108] == (-123)) goto L35;
        this.f557867r = 0;     // Catch: Throwable -> L106
    L35:
        if (this.f562081b.getUSER_FLAG().intValue() != 1) goto L72;
        if (this.f562081b.getTotaConnect().booleanValue() == false) goto L72;
        if (this.f562081b.getTotaConnect().booleanValue() == false) goto L41;
        int r109 = 4;
    L43:
        if (this.D != 6) goto L45;
        int r110 = 1;
    L47:
        if (r105[r109 + r110] != (-123)) goto L72;
        if (this.f562081b.getTotaConnect().booleanValue() == false) goto L51;
        int r111 = 5;
    L53:
        if (this.D != 6) goto L55;
        int r112 = 1;
    L57:
        if (r105[r111 + r112] != 0) goto L72;
        if (this.f562081b.getTotaConnect().booleanValue() == false) goto L61;
        int r113 = 6;
    L63:
        if (this.D != 6) goto L65;
        int r114 = 1;
    L67:
        if (r105[r113 + r114] != 0) goto L72;
        this.f557867r = 0;     // Catch: Throwable -> L106
        monitor-exit(r100);     // Catch: Throwable -> L106
        return false;
    L65:
        r114 = 0;
        goto L67
    L61:
        r113 = 2;
        goto L63
    L55:
        r112 = 0;
        goto L57
    L51:
        r111 = 1;
        goto L53
    L45:
        r110 = 0;
        goto L47
    L41:
        r109 = 0;
    L72:
        if (this.f562081b.getTotaConnect().booleanValue() == true) goto L76;
        r106 = 0;
    L76:
        if (this.D != 6) goto L78;
        int r115 = 1;
    L80:
        if (r105[r106 + r115] != (-126)) goto L82;
        x1.a.d(this.R, 5000, 2391);     // Catch: Throwable -> L106
    L82:
        w1.a r116 = this.M;     // Catch: Throwable -> L106
        if (r116 != null) goto L86;
        monitor-exit(r100);     // Catch: Throwable -> L106
        return false;
    L86:
        String r117 = r116.a();     // Catch: Throwable -> L106
        this.f557865p = r117;     // Catch: Throwable -> L106
        if (r117.length() <= 0) goto L93;
        int r118 = Float.valueOf(this.f557865p).intValue();     // Catch: Throwable -> L106
        a2.b r119 = this.f557866q;     // Catch: Throwable -> L106
        if (r119 == null) goto L91;
        this.f562081b.getDevice();     // Catch: Throwable -> L106
        r119.a(r118);     // Catch: Throwable -> L106
    L91:
        f(2336, this.f557865p);     // Catch: Throwable -> L106
    L93:
        if (this.f557867r != 0) goto L95;
    L101:
        boolean r120 = s(r105);     // Catch: Throwable -> L106
        monitor-exit(r100);     // Catch: Throwable -> L106
        return r120;
    L95:
        if (this.A != 1) goto L101;
        if (this.H == false) goto L101;
        boolean r121 = t(r105);     // Catch: Throwable -> L106
        monitor-exit(r100);     // Catch: Throwable -> L106
        return r121;
    L78:
        r115 = 0;
        goto L80
    L30:
        r108 = 0;
        goto L32
    L26:
        r107 = 0;
        goto L28
    L19:
        if (this.f562081b.getDeviceProtocol() == DeviceProtocol.PROTOCOL_GATT_BR_EDR) goto L22;
        r104 = false;
    L104:
        monitor-exit(r100);     // Catch: Throwable -> L106
        return false;
    L106:
        th = move-exception;
        throw th;
    }

    public final void y() {
        w1.a r100 = this.M;
        if (r100 != null) goto L5;
        return;
    L5:
        byte[] r101 = {-112};
        byte[] r102 = r100.f557842i;
        if (r100.f557835b != 1) goto L8;
        r102 = y1.a.f(1);
    L8:
        byte[] r103 = y1.a.c(r101, r102, r100.f557842i, r100.f557844k);
        if (r100.f557837d == false) goto L11;
        r103 = r100.b(r103);
    L11:
        s(r103);
        x1.a.d(this.R, 3000, 2389);
    }

    public final void z() {
        x1.a.c(this.f562080a, "sendSetUserData");
        w1.a r100 = this.M;
        if (r100 != null) goto L5;
        return;
    L5:
        int r101 = this.D;
        byte[] r102 = {-105};
        byte[] r103 = r100.f557842i;
        byte[] r104 = new byte[1];
        if (r100.f557835b != 1) goto L8;
        r103 = y1.a.f(1);
    L8:
        byte r105 = (byte) r101;
        if (r101 != 6) goto L11;
        r100.D = true;
    L11:
        r104[0] = r105;
        byte[] r106 = y1.a.c(r102, r103, r100.f557842i, r104);
        if (r100.f557837d == false) goto L14;
        r106 = r100.b(r106);
    L14:
        s(r106);
        x1.a.d(this.R, 5000, 2392);
    }

    public final void B(RemoteOTAConfig r100) {
        x1.a.c(this.f562080a, "setOtaConfig: -----" + r100.getLocalPath());
        if (new PolarisFileWrapper(r100.getLocalPath()).exists() == true) goto L7;
        e(2368);
        OTAStatus r101 = OTAStatus.STATUS_FAILED;
        this.f557863n = r101;
        p(r101);
        return;
    L7:
        if (this.G == 4) goto L9;
    L15:
        this.f557862m = r100;
        return;
    L9:
        if (r100.getWhatsNewContent("") != null) goto L12;
        return;
    L12:
        if (new PolarisFileWrapper(r100.getWhatsNewContent("")).exists() == true) goto L15;
        e(2368);
        OTAStatus r102 = OTAStatus.STATUS_FAILED;
        this.f557863n = r102;
        p(r102);
    }

    @Override // z1.a.InterfaceC8408a
    public final void a(BaseMessage r110) {
        byte[] r100 = (byte[]) r110.getMsgContent();
        int r101 = 0;
        byte r102 = r100[0];
        String r103 = "";
        if (r102 != 0) goto L8;
        if (r100[1] != 0) goto L8;
    L100:
        if (this.f562081b.getTotaConnect().booleanValue() == false) goto L104;
        if (this.f562085f == true) goto L104;
        return;
    L104:
        if (this.M == null) goto L512;
        byte[] r104 = (byte[]) r110.getMsgContent();
        x1.a.c(this.f562080a, "onDataReceived encode: ----" + y1.a.k(r104));
        if (this.f557874y == true) goto L112;
        if (r104[0] != (-117)) goto L112;
        return;
    L112:
        if (this.f562081b.getTotaConnect().booleanValue() == true) goto L114;
    L116:
        char r105 = 0;
    L117:
        w1.a r111 = this.M;
        Context r106 = this.f562084e;
        int r107 = this.f557867r;
        boolean r108 = this.f557874y;
        r111.f557834a = r106;
        byte r109 = r104[r105];
        if (r109 != (-113)) goto L138;
        int r112 = r111.f557840g;
        int r113 = (r112 + 1) + r111.f557841h.length;
        byte r114 = r104[r113];
        if (r114 != 0) goto L129;
        r111.f557843j = 2352;
        if (r111.f557835b != 1) goto L133;
        byte[] r115 = new byte[4];
        System.arraycopy(r104, 1, r115, 0, r112);
        if (y1.a.d(r115) <= 15) goto L133;
        int r116 = (r113 + 8) + 1;
        int r117 = r104.length - r116;
        byte[] r118 = new byte[r117];
        System.arraycopy(r104, r116, r118, 0, r104.length - r116);
        StringBuffer r119 = new StringBuffer();
        int r120 = 0;
    L126:
        if (r120 >= r117) goto L128;
        r119.append((char) r118[r120]);
        r120 = r120 + 1;
        goto L126
    L128:
        r111.f557848o = r119.toString().replace("-", " ");
    L133:
        byte[] r121 = new byte[4];
        int r122 = r113 + 1;
        System.arraycopy(r104, r122, r121, 0, 4);
        r111.f557846m = y1.a.k(r121).replace(",", ".");
        byte[] r123 = new byte[4];
        System.arraycopy(r104, r122 + 4, r123, 0, 4);
        r111.f557847n = y1.a.k(r123).replace(",", ".");
        if (2307 <= r107) goto L273;
        int r124 = 2307;
    L281:
        if (r124 == 0) goto L283;
        this.f557867r = r124;
    L283:
        x1.a.c(this.f562080a, "onDataReceived: -----" + this.f557867r);
        if (r124 != 2338) goto L290;
        int r125 = this.M.H;
        if (r125 != 0) goto L288;
        this.E = this.F;
        return;
    L288:
        this.E = r125;
        return;
    L290:
        if (r124 != 2307) goto L312;
        this.R.removeMessages(2384);
        if (this.K == false) goto L295;
        this.K = false;
        D();
        return;
    L295:
        this.f557870u = 0;
        if (this.I.length() > 0) goto L298;
    L301:
        w1.a r126 = this.M;
        int r127 = r126.f557843j;
        if (r127 != 2352) goto L305;
        String r128 = "stereo:" + r126.f557846m + "\n" + r126.f557848o;
        r126.f557848o = "";
        r103 = r128;
    L310:
        f(r124, r103);
        return;
    L305:
        if (r127 != 2353) goto L308;
        r103 = "TWS left:" + r126.f557846m;
        goto L310
    L308:
        if (r127 != 2354) goto L310;
        r103 = "TWS right:" + r126.f557847n;
        goto L310
    L298:
        if (this.f557863n == OTAStatus.STATUS_SUCCEED) goto L301;
        D();
        return;
    L312:
        if (r124 != 2322) goto L315;
        this.R.removeMessages(2393);
        f(r124, "");
        A();
        return;
    L315:
        if (r124 != 2305) goto L318;
        this.R.removeMessages(2387);
        this.f557872w = 0;
        f(r124, "");
        z();
        return;
    L318:
        if (r124 != 2306) goto L321;
        this.R.removeMessages(2392);
        this.f557873x = 0;
        f(r124, "");
        r();
        return;
    L321:
        if (r124 != 2308) goto L324;
        this.R.removeMessages(2388);
        f(r124, "");
        w();
        return;
    L324:
        if (r124 != 2309) goto L327;
        this.R.removeMessages(2388);
        f(r124, "");
        w();
        return;
    L327:
        if (r124 != 2310) goto L330;
        this.R.removeMessages(2385);
        String r129 = this.M.A;
        this.I = r129;
        f(r124, r129);
        y();
        return;
    L330:
        if (r124 != 2311) goto L365;
        this.R.removeMessages(2389);
        f(r124, "");
        String[] r130 = this.M.f557850q.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);
        String[] r131 = "0.0.0.1".split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);
        int r132 = Math.max(r130.length, r131.length);
        int r133 = 0;
    L332:
        if (r133 >= r132) goto L346;
        if (r133 >= r130.length) goto L336;
        int r134 = CastIntegerProtector.parseInt(r130[r133]);
    L338:
        if (r133 >= r131.length) goto L340;
        int r135 = CastIntegerProtector.parseInt(r131[r133]);
    L341:
        if (r134 < r135) goto L342;
        if (r134 > r135) goto L344;
        r133 = r133 + 1;
        goto L332
    L344:
        int r136 = 1;
    L347:
        x1.a.c(this.f562080a, "protocolVersion: " + this.M.f557850q + ", result: " + r136);
        if (r136 != 1) goto L363;
        w1.a r137 = this.M;
        Context r138 = this.f562084e;
        String r139 = this.f557862m.getLocalPath();
        r137.getClass();
        PolarisFileInputStreamWrapper r140 = new PolarisFileInputStreamWrapper(r139);     // Catch: Exception -> L356
        int r141 = r140.available();     // Catch: Exception -> L356
        byte[] r142 = new byte[r141];     // Catch: Exception -> L356
        r140.read(r142, 0, r141);     // Catch: Exception -> L356
        r140.close();     // Catch: Exception -> L356
        byte[] r143 = new byte[0];     // Catch: Exception -> L356
        MessageDigest r144 = MessageDigest.getInstance("SHA-256");     // Catch: NoSuchAlgorithmException -> L353 Exception -> L356
        r144.update(r142);     // Catch: NoSuchAlgorithmException -> L353 Exception -> L356
        r143 = r144.digest();     // Catch: NoSuchAlgorithmException -> L353 Exception -> L356
    L497:
    L358:
        r137.f557845l = r143;
        r137.f557834a = r138;
        byte[] r145 = {-96};
        byte[] r146 = r137.f557842i;
        if (r137.f557835b != 1) goto L361;
        int r147 = 32;
        r146 = y1.a.f(r137.f557841h.length + 32);
    L362:
        byte[] r148 = new byte[r147];
        byte[] r149 = r137.f557845l;
        System.arraycopy(r149, 0, r148, 0, r149.length);
        s(y1.a.c(r145, r146, r137.f557841h, r148));
        x1.a.d(this.R, 3000, 2478);
        return;
    L361:
        r147 = 32;
        goto L362
    L353:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L356
    L356:
        e = move-exception;
        e.printStackTrace();
        r143 = null;
        goto L358
    L363:
        s(this.M.c(this.f562084e));
        x1.a.d(this.R, 3000, 2475);
        return;
    L342:
        r136 = -1;
        goto L347
    L340:
        r135 = 0;
        goto L341
    L336:
        r134 = 0;
        goto L338
    L346:
        r136 = 0;
        goto L347
    L365:
        if (r124 != 2312) goto L368;
        this.R.removeMessages(2478);
        f(r124, "");
        s(this.M.c(this.f562084e));
        x1.a.d(this.R, 3000, 2475);
        return;
    L368:
        if (r124 != 2313) goto L376;
        this.R.removeMessages(2475);
        String r150 = (String) y1.d.a(this.f562084e, "BES_OTA_IS_MULTIDEVICE_UPGRADE", "");
        boolean r151 = ((Boolean) y1.d.a(this.f562084e, "BES_BLE_OTA_AUTO_TEST", Boolean.FALSE)).booleanValue();
        if (r150.equals("BES_OTA_IS_MULTIDEVICE_UPGRADE") == true) goto L374;
        if (r151 == true) goto L374;
        f(r124, "");
        s(this.M.f(this.f557862m.getLocalPath()));
        x1.a.d(this.R, 3000, 2400);
        return;
    L374:
        s(this.M.f(this.f557862m.getLocalPath()));
        x1.a.d(this.R, 3000, 2400);
        return;
    L376:
        if (r124 != 2314) goto L379;
        s(this.M.f(this.f557862m.getLocalPath()));
        x1.a.d(this.R, 3000, 2400);
        return;
    L379:
        if (r124 != 2320) goto L385;
        this.R.removeMessages(2475);
        this.R.removeMessages(2400);
        f(r124, "");
        if (this.D != 6) goto L383;
        this.M.f(this.f557862m.getLocalPath());
    L383:
        x1.a.d(this.R, 3000, 2390);
        s(this.M.e(this.f557862m.getLocalPath(), this.f562084e));
        return;
    L385:
        if (r124 != 2324) goto L388;
        w1.a r152 = this.M;
        r152.f557854u += r152.f557857x;
        o();
        return;
    L388:
        if (r124 != 2321) goto L391;
        this.R.removeMessages(2390);
        this.R.removeMessages(2477);
        this.f557860J = false;
        this.f557867r = 2324;
        this.f557863n = OTAStatus.STATUS_UPDATING;
        f(r124, "");
        o();
        return;
    L391:
        if (r124 != 2326) goto L394;
        this.R.removeMessages(2391);
        f(r124, "crc check package ok");
        this.f557871v = 0;
        this.f557875z = 0;
        this.f557867r = 2324;
        o();
        return;
    L394:
        if (r124 != 2327) goto L397;
        this.R.removeMessages(2391);
        this.f557863n = OTAStatus.STATUS_VERIFYING;
        o();
        return;
    L397:
        if (r124 != 2323) goto L405;
        f(r124, "");
        if (this.I.length() <= 0) goto L402;
        this.f557860J = true;
    L402:
        if (this.f557863n != OTAStatus.STATUS_SUCCEED) goto L533;
        d r153 = this.R;
        r153.sendMessageDelayed(r153.obtainMessage(2323), 3000);
        return;
    L533:
        return;
    L405:
        if (r124 != 2337) goto L411;
        f(r124, "");
        if (this.K == false) goto L409;
        return;
    L409:
        this.K = true;
        x1.a.c(this.f562080a, "startSppRoleSwitchTimer----");
        E();
        this.S = 0;
        this.L = new PthreadTimer("BesOtaService");
        this.L.schedule(new w1.c(this), 0, 1000);
        return;
    L411:
        if (r124 != 2328) goto L436;
        if (this.A != (-1)) goto L423;
        this.f557863n = OTAStatus.STATUS_SUCCEED;
        x1.c r154 = this.f562082c;
        if (r154 == null) goto L417;
        r154.c(r124, this.f562081b.getDevice());
    L417:
        Context r155 = this.f562084e;
        StringBuilder r156 = new StringBuilder("BES_OTA_RANDOM_CODE_LEFT");
        if (this.f562081b.getDeviceProtocol() != DeviceProtocol.PROTOCOL_BLE) goto L420;
        String r157 = this.f562081b.getDevice().getBleAddress();
    L421:
        r156.append(r157);
        y1.d.c(r155, r156.toString());
        return;
    L420:
        r157 = this.f562081b.getDevice().getDeviceMAC();
        goto L421
    L423:
        this.f557863n = OTAStatus.STATUS_VERIFIED;
        f(r124, "");
        if (this.N.booleanValue() == false) goto L428;
        x1.c r158 = this.f562082c;
        if (r158 == null) goto L536;
        r158.c(r124, this.f562081b.getDevice());
        return;
    L536:
        return;
    L428:
        w1.a r159 = this.M;
        r159.getClass();
        byte[] r160 = {-110};
        byte[] r161 = r159.f557842i;
        if (r159.f557835b != 1) goto L431;
        r161 = y1.a.f(r159.f557841h.length);
    L431:
        byte[] r162 = y1.a.c(r160, r161, r159.f557841h, r159.f557842i);
        if (r159.f557837d == false) goto L434;
        r162 = r159.b(r162);
    L434:
        s(r162);
        x1.a.d(this.R, 3000, 2476);
        return;
    L436:
        if (r124 != 2329) goto L446;
        this.R.removeMessages(2476);
        this.f557863n = OTAStatus.STATUS_SUCCEED;
        x1.c r163 = this.f562082c;
        if (r163 == null) goto L440;
        r163.c(r124, this.f562081b.getDevice());
    L440:
        Context r164 = this.f562084e;
        StringBuilder r165 = new StringBuilder("BES_OTA_RANDOM_CODE_LEFT");
        if (this.f562081b.getDeviceProtocol() != DeviceProtocol.PROTOCOL_BLE) goto L443;
        String r166 = this.f562081b.getDevice().getBleAddress();
    L444:
        r165.append(r166);
        y1.d.c(r164, r165.toString());
        return;
    L443:
        r166 = this.f562081b.getDevice().getDeviceMAC();
        goto L444
    L446:
        if (r124 != 2371) goto L451;
        if (this.f557875z >= 5) goto L451;
        this.R.removeMessages(2391);
        this.f557875z++;
        f(r124, "" + this.f557875z);
        w1.a r167 = this.M;
        r167.getClass();
        r167.f557854u = r167.f557855v;
        this.f557867r = 2324;
        o();
        return;
    L451:
        if (r124 != 2304) goto L453;
        x1.a.c(this.f562080a, "onDataReceived: OTA_CMD_RETURN------------OTA_CMD_RETURN");
        return;
    L453:
        byte r168 = r104[0];
        if (r168 != 0) goto L461;
        if (r104[1] != 16) goto L461;
        if (r104[2] != 16) goto L461;
        return;
    L461:
        if (r168 != 99) goto L468;
        if (r104[1] != 111) goto L468;
        if (r104[2] != 110) goto L468;
        return;
    L468:
        if (r124 != 2368) goto L470;
    L483:
        int r169 = 2371;
    L484:
        if (r124 != r169) goto L487;
        this.R.removeMessages(2391);
    L495:
        OTAStatus r170 = OTAStatus.STATUS_FAILED;
        this.f557863n = r170;
        p(r170);
        e(r124);
        q();
        return;
    L487:
        if (r124 != 2374) goto L490;
        this.R.removeMessages(2392);
        this.f557873x = 0;
        goto L495
    L490:
        if (r124 != 2370) goto L493;
        this.R.removeMessages(2390);
        this.R.removeMessages(2477);
        goto L495
    L493:
        if (r124 != 2373) goto L495;
        this.R.removeMessages(2476);
        goto L495
    L470:
        if (r124 == 2369) goto L483;
        if (r124 == 2370) goto L483;
        r169 = 2371;
        if (r124 == 2371) goto L484;
        if (r124 == 2372) goto L483;
        if (r124 == 2373) goto L483;
        if (r124 == 2374) goto L483;
        if (r124 == 2449) goto L483;
        return;
    L273:
        r124 = MainDexIgnore.IGNORE_METHODS;
        goto L281
    L129:
        if (r114 != 1) goto L131;
        r111.f557843j = 2353;
        goto L133
    L131:
        if (r114 != 2) goto L133;
        r111.f557843j = 2354;
        goto L133
    L138:
        if (r109 != (-111)) goto L152;
        r111.f557851r = null;
        r111.f557852s = 0;
        r111.f557854u = 0;
        r111.f557856w = 0;
        r111.f557857x = 0;
        r111.f557858y = 0;
        r111.f557859z = false;
        r111.A = "";
        r111.f557855v = 0;
        int r171 = r111.f557840g + 1;
        if (r104.length <= r171) goto L148;
        if (r104[r171] != 1) goto L148;
        if (2311 <= r107) goto L273;
        r124 = 2311;
    L148:
        if (2369 <= r107) goto L273;
        r124 = 2369;
        goto L281
    L152:
        if (r109 != (-115)) goto L162;
        int r172 = r111.f557840g + 1;
        byte[] r173 = new byte[4];
        System.arraycopy(r104, r172, r173, 0, 4);
        int r174 = y1.a.d(r173);
        r111.f557854u = r174;
        if (r174 <= 0) goto L158;
        r111.f557856w = r174;
        r111.f557855v = r174;
        r111.f557849p = ((Integer) y1.d.a(r111.f557834a, "BES_OTA_CURRENT_MTU", Integer.valueOf(r111.f557849p))).intValue();
        if (2320 <= r107) goto L273;
    L172:
        r124 = 2320;
        goto L281
    L158:
        byte[] r175 = new byte[32];
        System.arraycopy(r104, r172 + 4, r175, 0, 32);
        y1.d.b(r111.f557834a, "BES_OTA_RANDOM_CODE_LEFT" + r111.f557839f, y1.a.k(r175));
        if (2313 <= r107) goto L273;
    L215:
        r124 = 2313;
        goto L281
    L162:
        if (r109 != (-127)) goto L174;
        int r176 = (r111.f557840g + 1) + r111.f557841h.length;
        byte[] r177 = new byte[2];
        System.arraycopy(r104, r176, r177, 0, 2);
        y1.a.k(r177).replace(",", ".");
        byte[] r178 = new byte[2];
        int r179 = r176 + 2;
        System.arraycopy(r104, r179, r178, 0, 2);
        y1.a.k(r178).replace(",", ".");
        byte[] r180 = new byte[4];
        System.arraycopy(r104, r179 + 2, r180, 0, 2);
        if (r111.f557854u > 0) goto L166;
    L168:
        int r181 = y1.a.d(r180);
        r111.f557849p = r181;
        y1.d.b(r111.f557834a, "BES_OTA_CURRENT_MTU", Integer.valueOf(r181));
    L170:
        if (2320 > r107) goto L172;
    L166:
        if (r111.D == false) goto L168;
    L174:
        if (r109 != (-121)) goto L185;
        int r182 = r111.f557840g + 1;
        if (r104.length <= r182) goto L181;
        if (r104[r182] != 1) goto L181;
        r124 = 2321;
    L181:
        if (2370 <= r107) goto L273;
        r124 = 2370;
        goto L281
    L185:
        if (r109 != (-125)) goto L203;
        int r183 = r111.f557840g + 1;
        y1.a.k(r111.I);
        if (r104[1] <= 4) goto L192;
        byte[] r184 = new byte[4];
        System.arraycopy(r104, r183 + 1, r184, 0, 4);
        y1.a.k(r184);
        if (y1.a.h(r111.I, r184) == false) goto L280;
        r111.I = new byte[4];
    L280:
        r124 = 0;
    L192:
        if (r104.length > r183) goto L194;
    L201:
        r124 = 2371;
        goto L281
    L194:
        if (r104[r183] != 1) goto L201;
        r111.f557858y++;
        int r185 = r111.f557854u;
        r111.f557855v = r185;
        r111.f557859z = false;
        int r186 = r111.f557851r.length;
        if (r111.D == false) goto L198;
        r186 = r111.F;
    L198:
        if (r185 != r186) goto L200;
        r124 = 2327;
        goto L281
    L200:
        r124 = 2326;
        goto L281
    L203:
        if (r109 != (-124)) goto L224;
        int r187 = r111.f557840g + 1;
        if (r104.length <= r187) goto L218;
        if (r104[r187] != 1) goto L218;
        if (r111.D == false) goto L216;
        int r188 = r111.f557854u;
        if (r188 == r111.f557851r.length) goto L216;
        if (r188 <= 0) goto L215;
        r124 = 2314;
    L216:
        r124 = 2328;
    L218:
        if (r104.length > r187) goto L220;
    L222:
        r124 = 2372;
        goto L281
    L220:
        if (r104[r187] != 7) goto L222;
        r124 = 2449;
        goto L281
    L224:
        if (r109 != (-109)) goto L238;
        int r189 = r111.f557840g + 1;
        if (r104.length <= r189) goto L234;
        if (r104[r189] != 1) goto L234;
        if (2329 <= r107) goto L273;
        r124 = 2329;
    L234:
        if (2373 <= r107) goto L273;
        r124 = 2373;
        goto L281
    L238:
        if (r109 != (-107)) goto L241;
        r124 = 2323;
        goto L281
    L241:
        if (r109 != (-106)) goto L244;
        r124 = 2337;
        goto L281
    L244:
        if (r109 != (-102)) goto L247;
        r111.f557835b = 1;
        byte[] r190 = new byte[4];
        System.arraycopy(r104, r111.f557840g + 1, r190, 0, 4);
        r111.f557850q = (r190[0] + "." + r190[1] + "." + r190[2] + "." + r190[3]).replace(",", ".");
        r190.toString();
        r111.g(r111.f557835b, r111.B, r111.f557836c, r111.f557837d, r111.f557838e, r111.f557839f);
        r124 = 2305;
        goto L281
    L247:
        if (r109 != (-104)) goto L255;
        int r191 = r111.f557840g + 1;
        if (r104.length > r191) goto L251;
    L253:
        r124 = 2374;
        goto L281
    L251:
        if (r104[r191] != 1) goto L253;
        r124 = 2306;
        goto L281
    L255:
        if (r109 != (-98)) goto L267;
        int r192 = r111.f557840g + 1;
        if (r104.length <= r192) goto L262;
        if (r104[r192] != 1) goto L262;
        r124 = 2308;
    L262:
        if (r104.length <= r192) goto L280;
        if (r104[r192] != 2) goto L280;
        r124 = 2309;
        goto L281
    L267:
        if (r109 != (-100)) goto L270;
        String r193 = y1.a.k(r104).replace(",", "");
        r111.A = r193.substring(r193.length() - 4);
        r124 = 2310;
        goto L281
    L270:
        if (r109 != (-117)) goto L275;
        if (r108 == false) goto L273;
        r124 = 2324;
        goto L281
    L275:
        if (r109 != 127) goto L278;
        byte[] r194 = new byte[4];
        System.arraycopy(r104, r111.f557840g + 1, r194, 0, 4);
        r111.H = y1.a.d(r194);
        r124 = 2338;
        goto L281
    L278:
        if (r109 != (-95)) goto L280;
        r124 = 2312;
        goto L281
    L114:
        if (r104.length <= 4) goto L116;
        byte[] r195 = new byte[r104.length - 4];
        r105 = 0;
        System.arraycopy(r104, 4, r195, 0, r104.length - 4);
        r104 = r195;
        goto L117
    L512:
        return;
    L8:
        if (this.f562089j == false) goto L14;
        if (r102 != (-97)) goto L12;
        byte[] r196 = new byte[r100.length - 5];
        System.arraycopy(r100, 5, r196, 0, r100.length - 5);
        r100 = r196;
        goto L14
    L12:
        x1.a.c(this.f562080a, "onDataReceived isCommandSetFunction: -----" + y1.a.k(r100));
    L14:
        if (this.f562081b.getTotaConnect().booleanValue() == false) goto L85;
        if (this.f562085f == true) goto L85;
        x1.d r197 = this.f562086g;
        if (this.f562081b.getUseTotaV2().booleanValue() == false) goto L20;
        r100 = this.f562086g.b(r100, false);
    L20:
        r197.getClass();
        y1.a.k(r100);
        if (r100.length < 2) goto L74;
        byte r198 = r100[0];
        if (r198 == 2) goto L26;
    L61:
        if (r198 != 0) goto L74;
        if ((r100[1] & UByte.MAX_VALUE) != 16) goto L74;
        if (r100.length > 15) goto L67;
    L73:
        char r199 = 771;
    L76:
        if (r199 != 769) goto L79;
        this.f562090k.removeMessages(1025);
        byte[] r200 = this.f562086g.f562096d;
        byte[] r201 = new byte[(r200.length + 4) + 1];
        System.arraycopy(r200, 0, r201, 5, r200.length);
        r201[0] = 3;
        r201[1] = 16;
        r201[2] = 33;
        r201[3] = 0;
        r201[4] = 32;
        l(r201);
    L98:
        this.f562090k.removeMessages(1028);
        goto L100
    L79:
        if (r199 != 770) goto L82;
        n();
        goto L98
    L82:
        if (r199 != 771) goto L98;
        this.f562085f = false;
        g(false);
        goto L98
    L67:
        if (r100[12] != 115) goto L73;
        if (r100[13] != 117) goto L73;
        if (r100[14] != 99) goto L73;
        r199 = 770;
        goto L76
    L26:
        if ((r100[1] & UByte.MAX_VALUE) != 16) goto L61;
        int r202 = CastIntegerProtector.parseInt(y1.a.k(new byte[]{r100[3], r100[2]}).replace(",", ""), 16) - 1;
        byte[] r1100 = new byte[r202];
        r197.f562094b = r1100;
        System.arraycopy(r100, 5, r1100, 0, r202);
        byte[] r203 = r197.f562094b;
        byte[] r204 = r197.f562093a;
        if (r203.length <= r204.length) goto L31;
        byte[] r1101 = new byte[r203.length];
        System.arraycopy(r204, 0, r1101, 0, r204.length);
        r204 = r1101;
    L33:
        byte[] r1102 = new byte[r203.length];
        int r1103 = 0;
    L35:
        if (r1103 >= r203.length) goto L52;
        int r1104 = r203[r1103];
        int r1105 = r204[r1103];
        int r205 = r1103 % 6;
        if (r205 == 0) goto L49;
        if (r205 == 1) goto L48;
        if (r205 == 2) goto L47;
        if (r205 == 3) goto L46;
        if (r205 == 4) goto L45;
        if (r205 == 5) goto L44;
        byte r206 = 0;
    L51:
        r1102[r1103] = r206;
        r1103 = r1103 + 1;
        r101 = 0;
        goto L35
    L44:
        r1104 = r1104 * r1104;
        r1105 = r1105 * r1105;
        goto L49
    L45:
        int r207 = r1104 ^ r1105;
    L50:
        r206 = (byte) r207;
        goto L51
    L46:
        r207 = r1104 | r1105;
        goto L50
    L47:
        r207 = r1104 & r1105;
        goto L50
    L48:
        r207 = r1104 * r1105;
    L49:
        r207 = r1104 + r1105;
        goto L50
    L52:
        byte[] r208 = new byte[r101];
        MessageDigest r209 = MessageDigest.getInstance("SHA-256");     // Catch: NoSuchAlgorithmException -> L55
        r209.update(r1102);     // Catch: NoSuchAlgorithmException -> L55
        r208 = r209.digest();     // Catch: NoSuchAlgorithmException -> L55
    L57:
        r197.f562096d = r208;
        int r210 = 16;
        byte[] r211 = new byte[16];
        int r1106 = 0;
    L58:
        if (r1106 >= r210) goto L60;
        r211[r1106] = r208[r1106 * 2];
        r1106 = r1106 + 1;
        r210 = 16;
        goto L58
    L60:
        r197.f562095c = r211;
        r199 = 769;
    L55:
        e = move-exception;
        e.printStackTrace();
        goto L57
    L31:
        if (r203.length >= r204.length) goto L33;
        byte[] r1107 = new byte[r204.length];
        System.arraycopy(r203, 0, r1107, 0, r203.length);
        r203 = r1107;
    L74:
        r199 = 0;
    L85:
        if (this.f562085f == false) goto L98;
        if (r100[8] != (-1)) goto L92;
        if (r100[9] != 127) goto L92;
        r110.setMsgContent(this.f562086g.b(r100, false));
    L92:
        if (((Boolean) y1.d.a(this.f562084e, "BES_TOTA_ENCRYPTION_KEY", Boolean.TRUE)).booleanValue() == false) goto L98;
        if (this.f562081b.getUseTotaV2().booleanValue() == false) goto L96;
        byte[] r212 = this.f562086g.b(r100, true);
    L97:
        r110.setMsgContent(r212);
        goto L98
    L96:
        r212 = this.f562086g.c(r100);
        goto L97
    }

    @Override // z1.a.InterfaceC8408a
    public final void b(int r100) {
        if (r100 != 667) goto L14;
        if (this.f557867r == 2324) goto L7;
        return;
    L7:
        if (this.f557874y == false) goto L9;
        return;
    L9:
        if (this.A >= 1) goto L11;
    L12:
        ThreadMethodProxy.start(new PthreadThreadV2(new a(this), "BesOtaService"));
        return;
    L11:
        if (this.H == false) goto L12;
        return;
    L14:
        if (this.f557867r == 2324) goto L16;
        return;
    L16:
        if (this.f557874y == false) goto L18;
        return;
    L18:
        if (this.A >= 1) goto L20;
    L21:
        int r101 = this.f557868s + 1;
        this.f557868s = r101;
        if (r101 != 3) goto L25;
        e(BDVideoUploaderBase.KeyIsVideoMetaData);
        return;
    L25:
        x();
        return;
    L20:
        if (this.H == false) goto L21;
    }

    @Override // x1.a
    public final void g(boolean r100) {
        x1.c r101 = this.f562082c;
        if (r101 == null) goto L5;
        r101.b(r100, this.f562081b.getDevice());
    L5:
        x1.a.c(this.f562080a, "callBackTotaConnectState: ------" + r100);
        if (r100 != true) goto L25;
        this.f557860J = false;
        this.f557869t = 0;
        x1.a.c(this.f562080a, "onStatusChanged: -----true");
        f(666, "");
        if (this.I.length() <= 0) goto L23;
        if (this.f562081b.getDeviceProtocol() != DeviceProtocol.PROTOCOL_SPP) goto L23;
        E();
    L23:
        Thread.sleep(1000);     // Catch: InterruptedException -> L15
    L17:
        int r102 = this.A;
        if (r102 != 1) goto L20;
        v();
        return;
    L20:
        if (r102 != 0) goto L27;
        z();
        return;
    L27:
        return;
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L17
    }

    @Override // x1.a, z1.a.InterfaceC8408a
    public final void onStatusChanged(int r110) {
        x1.a.c(this.f562080a, "onStatusChanged---Base");
        if (r110 != 666) goto L5;
        this.f562087h = true;
    L7:
        if (this.f562081b.getTotaConnect().booleanValue() == false) goto L13;
        if (this.f562085f == true) goto L13;
        if (r110 != 666) goto L13;
        x1.d r100 = this.f562086g;
        r100.getClass();
        int r101 = new Random().nextInt(112) + 16;
        r100.f562093a = new byte[r101];
        new Random(new Random().nextInt(10000)).nextBytes(r100.f562093a);
        byte[] r102 = new byte[r101 + 5];
        byte[] r103 = y1.a.f(r101 + 1);
        System.arraycopy(r100.f562093a, 0, r102, 5, r101);
        r102[0] = 1;
        r102[1] = 16;
        r102[2] = r103[0];
        r102[3] = r103[1];
        r102[4] = (byte) r101;
        l(r102);
        x1.a.d(this.f562090k, 5000, 1025);
    L13:
        if (r110 != 444) goto L15;
        this.f562085f = false;
    L15:
        x1.a.c(this.f562080a, "onStatusChanged: ------" + r110);
        if (r110 == 666) goto L18;
    L29:
        if (r110 == 666) goto L73;
        x1.a.c(this.f562080a, "onStatusChanged: -----false +" + this.f557863n);
        OTAStatus r111 = this.f557863n;
        OTAStatus r104 = OTAStatus.STATUS_CANCELED;
        if (r111 == r104) goto L74;
        OTAStatus r105 = OTAStatus.STATUS_FAILED;
        if (r111 != r105) goto L36;
        return;
    L36:
        if (this.K == false) goto L40;
        m(this.f562081b);
        return;
    L40:
        if (r111 == OTAStatus.STATUS_UNKNOWN) goto L60;
        OTAStatus r106 = OTAStatus.STATUS_SUCCEED;
        if (r111 == r106) goto L56;
        if (r111 == r104) goto L56;
        if (r111 == r105) goto L56;
        if (this.I.length() <= 0) goto L56;
        x1.a.c(this.f562080a, "onStatusChanged: -----------" + this.I);
        if (this.f562081b.getDeviceProtocol() != DeviceProtocol.PROTOCOL_BLE) goto L51;
        u();
        return;
    L51:
        if (this.f562081b.getDeviceProtocol() != DeviceProtocol.PROTOCOL_SPP) goto L53;
    L54:
        x1.a.c(this.f562080a, "onStatusChanged: ---------mDeviceProtocol == DeviceProtocol.PROTOCOL_SPP");
        m(this.f562081b);
        return;
    L53:
        if (this.f562081b.getDeviceProtocol() == DeviceProtocol.PROTOCOL_GATT_BR_EDR) goto L54;
        return;
    L56:
        if (this.f557863n == r106) goto L69;
        x1.a.c(this.f562080a, "onStatusChanged: ------------22222");
        f(444, "");
        return;
    L69:
        return;
    L60:
        int r112 = this.f557869t + 1;
        this.f557869t = r112;
        if (r112 != 3) goto L64;
        f(444, "");
        return;
    L64:
        m(this.f562081b);
        return;
    L74:
        return;
    L73:
        return;
    L18:
        if (this.f562081b.getTotaConnect().booleanValue() == true) goto L29;
        this.f557860J = false;
        this.f557869t = 0;
        x1.a.c(this.f562080a, "onStatusChanged: -----true");
        f(666, "");
        if (this.I.length() > 0) goto L22;
    L24:
        int r113 = this.A;
        if (r113 != 1) goto L27;
        v();
        return;
    L27:
        if (r113 != 0) goto L71;
        z();
        return;
    L71:
        return;
    L22:
        if (this.f562081b.getDeviceProtocol() != DeviceProtocol.PROTOCOL_SPP) goto L24;
        E();
        goto L24
    L5:
        this.f562087h = false;
        goto L7
    }

    public final void p(OTAStatus r100) {
        a2.b r101 = this.f557866q;
        if (r101 == null) goto L6;
        r101.b(r100, this.f562081b.getDevice());
        return;
    }

    public final boolean s(byte[] r100) {
        if (this.f557863n != OTAStatus.STATUS_PAUSED) goto L7;
        return false;
    L7:
        return l(r100);
    }

    public final boolean t(byte[] r100) {
        boolean r101 = false;
        if (this.f557863n != OTAStatus.STATUS_PAUSED) goto L6;
        return false;
    L6:
        if (this.f562087h == false) goto L42;
        boolean r102 = ((Boolean) y1.d.a(this.f562084e, "BES_TOTA_ENCRYPTION_KEY", Boolean.TRUE)).booleanValue();
        Context r103 = this.f562084e;
        DeviceProtocol r104 = this.f562081b.getDeviceProtocol();
        if (this.f562085f == false) goto L16;
        if (r102 == false) goto L16;
        if (this.f562081b.getUseTotaV2().booleanValue() == false) goto L14;
        x1.d r105 = this.f562086g;
        r100 = r105.a(r105.d(r100));
    L18:
        BluetoothDevice r106 = j();
        if (r103 != null) goto L21;
        Object r107 = u1.a.f548212a;
        goto L42
    L21:
        Object r108 = u1.a.f548212a;
        monitor-enter(r108);
    L43:
        th = move-exception;
        throw th;
    L24:
        if (r104 != DeviceProtocol.PROTOCOL_BLE) goto L26;
    L40:
        r101 = u1.b.n(r103, null).r(r100, r106);     // Catch: Throwable -> L43
        monitor-exit(r108);     // Catch: Throwable -> L43
    L46:
        goto L42
    L26:
        if (r104 == DeviceProtocol.PROTOCOL_GATT_BR_EDR) goto L40;
        if (r104 != DeviceProtocol.PROTOCOL_SPP) goto L34;
        r101 = u1.c.n(r103, null).t(r100, r106);     // Catch: Throwable -> L43
        monitor-exit(r108);     // Catch: Throwable -> L43
        goto L46
    L34:
        if (r104 != DeviceProtocol.PROTOCOL_USB) goto L38;
        r101 = u1.d.f(r103).h(r100);     // Catch: Throwable -> L43
        monitor-exit(r108);     // Catch: Throwable -> L43
        goto L46
    L38:
        monitor-exit(r108);     // Catch: Throwable -> L43
        goto L46
    L14:
        r100 = this.f562086g.d(r100);
    L16:
        if (this.f562081b.getUseTotaV2().booleanValue() == false) goto L18;
        r100 = this.f562086g.a(r100);
    L42:
        return r101;
    }

    public final boolean C(a2.a r100, DoraOTAManagement.b r101) {
        x1.a.c(this.f562080a, "startDataTransfer");
        if (this.f557867r != 2313) goto L9;
        w1.a r102 = this.M;
        if (r102 == null) goto L7;
        s(r102.f(this.f557862m.getLocalPath()));
    L7:
        x1.a.d(this.R, 3000, 2400);
        return true;
    L9:
        this.f557864o = r100;
        this.f557866q = r101;
        RemoteOTAConfig r103 = this.f557862m;
        if (r103 != null) goto L12;
    L17:
        boolean r104 = false;
    L18:
        if (r104 == true) goto L21;
        e(2368);
        OTAStatus r105 = OTAStatus.STATUS_FAILED;
        this.f557863n = r105;
        p(r105);
        return false;
    L21:
        boolean r106 = ((Boolean) y1.d.a(this.f562084e, "BES_BLE_OTA_AUTO_TEST", Boolean.FALSE)).booleanValue();
        if (this.f557864o.f1405a == 0) goto L24;
        if (r106 == true) goto L24;
    L30:
        if (this.f557867r == 2324) goto L32;
    L34:
        D();
        return true;
    L32:
        if (this.f557863n == OTAStatus.STATUS_PAUSED) goto L34;
        return false;
    L24:
        Context r107 = this.f562084e;
        StringBuilder r108 = new StringBuilder("BES_OTA_RANDOM_CODE_LEFT");
        if (this.f562081b.getDeviceProtocol() != DeviceProtocol.PROTOCOL_BLE) goto L27;
        String r109 = this.f562081b.getDevice().getBleAddress();
    L28:
        r108.append(r109);
        y1.d.c(r107, r108.toString());
        goto L30
    L27:
        r109 = this.f562081b.getDevice().getDeviceMAC();
        goto L28
    L12:
        if (r103.getLocalPath() == null) goto L17;
        if (new PolarisFileWrapper(this.f557862m.getLocalPath()).exists() == false) goto L17;
        r104 = true;
        goto L18
    }

    public b(BesServiceConfig r110, DoraOTAManagement$startDataTransfer$1 r111, Context r112) {
        super(r110, r111, r112);
        this.f557861l = new Object();
        this.f557863n = OTAStatus.STATUS_UNKNOWN;
        this.f557865p = "0.00";
        this.f557867r = 0;
        this.f557868s = 0;
        this.f557869t = 0;
        this.f557870u = 0;
        this.f557871v = 0;
        this.f557872w = 0;
        this.f557873x = 0;
        this.f557874y = false;
        this.f557875z = 0;
        this.A = 1;
        this.B = true;
        this.C = 1;
        this.D = 1;
        this.E = 10;
        this.F = 0;
        this.G = 0;
        this.H = false;
        this.I = "";
        this.f557860J = false;
        this.K = false;
        this.N = Boolean.FALSE;
        this.P = false;
        this.Q = new c(this);
        this.R = new d(this, this.f562088i.getLooper());
        this.S = 0;
        x1.a.c(this.f562080a, "init");
        if (this.f562081b.getDeviceProtocol() != DeviceProtocol.PROTOCOL_BLE) goto L5;
        String r100 = this.f562081b.getDevice().getBleAddress();
    L6:
        String r101 = r100;
        if (r101 != null) goto L9;
    L11:
        int r102 = r110.getUSER_FLAG().intValue();
        this.A = r102;
        boolean r103 = r110.getIsWithoutResponse().booleanValue();
        this.H = r103;
        this.N = r110.getIsSilenceOTA();
        w1.a r104 = new w1.a();
        this.M = r104;
        DeviceProtocol r105 = r110.getDeviceProtocol();
        DeviceProtocol r106 = DeviceProtocol.PROTOCOL_SPP;
        if (r105 != r106) goto L14;
        boolean r107 = true;
    L15:
        r104.g(r102, r107, r103, this.f562081b.getTotaConnect().booleanValue(), r110.getUseTotaV2().booleanValue(), r101);
        boolean r108 = ((Boolean) y1.d.a(r112, "BES_default_INTERVAL", Boolean.TRUE)).booleanValue();
        long r109 = CastLongProtector.parseLong((String) y1.d.a(r112, "BES_BLE_INTERVAL", "50"));
        long r113 = CastLongProtector.parseLong((String) y1.d.a(r112, "BES_SPP_INTERVAL", BDLocationException.ERROR_SDK_NO_PERMISSION));
        if (r110.getDeviceProtocol() != r106) goto L19;
        this.E = 30;
    L26:
        this.F = this.E;
        if (r102 >= 1) goto L30;
        this.f557874y = r110.getCurAckType().booleanValue();
    L30:
        if (r102 != (-1)) goto L45;
        int r114 = r110.getImageSideSelection().intValue();
        this.G = r114;
        w1.a r115 = this.M;
        if (r114 != 4) goto L34;
        r114 = 1;
    L34:
        if (r114 != 0) goto L36;
        r115.f557844k[0] = 0;
        goto L45
    L36:
        if (r114 != 1) goto L39;
        r115.f557844k[0] = 1;
        goto L45
    L39:
        if (r114 != 2) goto L42;
        r115.f557844k[0] = 16;
        goto L45
    L42:
        if (r114 != 3) goto L44;
        r115.f557844k[0] = 17;
        goto L45
    L44:
        r115.getClass();
    L45:
        this.D = r110.getCurUser().intValue();
        this.C = r110.getCurUpgateType().intValue();
        x1.a.c(this.f562080a, "BesOtaService Protocol: --------" + r110.getDeviceProtocol());
        x1.a.c(this.f562080a, "sppSendDataDelay " + this.E);
        m(r110);
        return;
    L19:
        if (r110.getDeviceProtocol() != DeviceProtocol.PROTOCOL_USB) goto L23;
        this.E = 5;
        if (r108 == true) goto L26;
        this.E = r113;
        goto L26
    L23:
        this.E = 50;
        if (r108 == true) goto L26;
        this.E = r109;
        goto L26
    L14:
        r107 = false;
        goto L15
    L9:
        if (r101.length() <= 0) goto L11;
        v1.a.a(r112).getRemoteDevice(r101);
        goto L11
    L5:
        r100 = this.f562081b.getDevice().getDeviceMAC();
        goto L6
    }
}
