package yr9;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.os.PowerManager;
import com.bytedance.apm.battery.config.BatteryTypeInf;

/* JADX INFO: loaded from: classes31.dex */
public final class a extends as9.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final PowerManager f568930f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public C8375a f568931g;

    /* JADX INFO: renamed from: yr9.a$a, reason: collision with other inner class name */
    public class C8375a implements PowerManager.OnThermalStatusChangedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f568932a;

        public C8375a(a r100) {
            this.f568932a = r100;
        }

        @Override // android.os.PowerManager.OnThermalStatusChangedListener
        public final void onThermalStatusChanged(int r100) {
            a r101 = this.f568932a;
            monitor-enter(r101);
            a r102 = this.f568932a;     // Catch: Throwable -> L9
            as9.a.InterfaceC0219a r103 = r102.f16138a;     // Catch: Throwable -> L9
            if (r103 == null) goto L7;
            r102.f16141d = r100;     // Catch: Throwable -> L9
            r103.onStatusGenerate(r100, -1.0f);     // Catch: Throwable -> L9
            boolean r104 = bs9.a.f20322a;     // Catch: Throwable -> L9
        L7:
            monitor-exit(r101);     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            throw th;
        }
    }

    @Override // as9.a
    public final boolean a() {
        if (Build.VERSION.SDK_INT < 29) goto L14;
        PowerManager r100 = this.f568930f;
        if (r100 == null) goto L14;
        if (this.f568931g != null) goto L20;
        this.f568931g = new C8375a(this);
    L20:
        r100.addThermalStatusListener(this.f568931g);     // Catch: Exception -> L12 Throwable -> L16
        return true;
    L18:
        this.f568931g = null;     // Catch: Throwable -> L17
    L22:
        return true;
    L14:
        return false;
    }

    @Override // as9.a
    public final int c() {
        if (this.f16138a != null) goto L13;
        if (Build.VERSION.SDK_INT < 29) goto L10;
        PowerManager r100 = this.f568930f;
        if (r100 == null) goto L10;
        return r100.getCurrentThermalStatus();
    L10:
        return -1;
    L13:
        return this.f16141d;
    }

    @Override // as9.a
    public final void e() {
        if (Build.VERSION.SDK_INT < 29) goto L9;
        PowerManager r100 = this.f568930f;
        if (r100 == null) goto L9;
        C8375a r101 = this.f568931g;
        if (r101 == null) goto L9;
        r100.removeThermalStatusListener(r101);
    L9:
        this.f568931g = null;
    }

    public a(Context r100, Looper r101) {
        super(r100, r101);
        PowerManager r102 = (PowerManager) r100.getSystemService(BatteryTypeInf.BATTERY_POWER_LOCK);
        this.f568930f = r102;
        if (Build.VERSION.SDK_INT < 29) goto L7;
        if (r102 == null) goto L7;
        int r103 = r102.getCurrentThermalStatus();     // Catch: Exception -> L10
    L8:
        this.f16141d = r103;
        return;
    L7:
        r103 = -1;
        goto L8
    }
}
