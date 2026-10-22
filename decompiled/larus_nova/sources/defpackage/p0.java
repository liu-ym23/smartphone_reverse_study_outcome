package defpackage;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.larus.utils.logger.FLogger;
import com.obric.cae.libs.bluetooth.CaeBluetoothDeviceManager;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes42.dex */
public final class p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f527252a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f527253b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public CaeBluetoothDeviceManager f527254c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f527255d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f527256e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f527257f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final b f527258g;

    public static final class a {
    }

    public static final class b implements CaeBluetoothDeviceManager.CaeBluetoothServiceListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p0 f527259a;

        @Override // com.obric.cae.libs.bluetooth.CaeBluetoothDeviceManager.CaeBluetoothServiceListener
        public final void onServiceConnected() {
            FLogger.f375446a.i("Obric-SmartBluetoothBinderClient", "onServiceConnected");
            p0 r100 = this.f527259a;
            r100.f527255d = true;
            r100.f527257f = 0;
        }

        @Override // com.obric.cae.libs.bluetooth.CaeBluetoothDeviceManager.CaeBluetoothServiceListener
        public final void onServiceDisconnected() {
            FLogger r100 = FLogger.f375446a;
            r100.i("Obric-SmartBluetoothBinderClient", "onServiceDisconnected");
            final p0 r101 = this.f527259a;
            r101.f527255d = false;
            if (r101.f527256e == true) goto L5;
            r100.i("Obric-SmartBluetoothBinderClient", "scheduleRebind skip: already stopped");
            return;
        L5:
            long r102 = Math.min((1 << RangesKt.coerceAtMost(r101.f527257f, 5)) * 2000, 30000);
            r101.f527257f++;
            r100.i("Obric-SmartBluetoothBinderClient", "scheduleRebind after " + r102 + "ms retry=" + r101.f527257f);
            r101.f527253b.removeCallbacksAndMessages(null);
            r101.f527253b.postDelayed(new o0(r101), r102);
        }

        public b(p0 r100) {
            this.f527259a = r100;
        }
    }

    static {
    }

    public final void a() {
        FLogger.f375446a.i("Obric-SmartBluetoothBinderClient", "doBind retry=" + this.f527257f);
        CaeBluetoothDeviceManager r100 = CaeBluetoothDeviceManager.getInstance(this.f527252a);
        this.f527254c = r100;
        if (r100 == null) goto L5;
        r100.addServiceListener(this.f527258g);
    L5:
        CaeBluetoothDeviceManager r101 = this.f527254c;
        if (r101 == null) goto L9;
        r101.bindService();
        return;
    }

    public final void b() {
        FLogger.f375446a.i("Obric-SmartBluetoothBinderClient", "start.. hasStarted " + this.f527256e);
        if (this.f527256e == true) goto L5;
        this.f527257f = 0;
        a();
    L5:
        this.f527256e = true;
    }

    public final void c() {
        FLogger r100 = FLogger.f375446a;
        r100.i("Obric-SmartBluetoothBinderClient", "stop.. hasStarted " + this.f527256e);
        this.f527253b.removeCallbacksAndMessages(null);
        this.f527257f = 0;
        if (this.f527256e == false) goto L10;
        r100.i("Obric-SmartBluetoothBinderClient", "doUnbind");
        CaeBluetoothDeviceManager r101 = this.f527254c;
        if (r101 == null) goto L7;
        r101.removeServiceListener(this.f527258g);
    L7:
        CaeBluetoothDeviceManager r102 = this.f527254c;
        if (r102 == null) goto L10;
        r102.unbindService();
    L10:
        this.f527256e = false;
    }

    public p0(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        this.f527252a = r100;
        this.f527253b = new Handler(Looper.getMainLooper());
        this.f527258g = new b(this);
    }
}
