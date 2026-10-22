package kta;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.provider.Settings;
import android.text.TextUtils;
import com.bytedance.bdinstall.oaid.impl.IDeviceIdManager;

/* JADX INFO: loaded from: classes34.dex */
public final class e extends c<IDeviceIdManager> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f506103c;

    public class a implements w.b<IDeviceIdManager, String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f506104a;

        public a(e r100) {
            this.f506104a = r100;
        }

        @Override // kta.w.b
        public final String a(IDeviceIdManager r100) throws Exception {
            IDeviceIdManager r101 = r100;
            if (r101 != null) goto L6;
            return null;
        L6:
            return r101.getOAID(this.f506104a.f506103c.getPackageName());
        }

        @Override // kta.w.b
        public final IDeviceIdManager b(IBinder r100) {
            return IDeviceIdManager.Stub.asInterface(r100);
        }
    }

    @Override // kta.c
    public final w.b<IDeviceIdManager, String> c() {
        return new a(this);
    }

    public e(Context r100) {
        super("com.coolpad.deviceidsupport");
        this.f506103c = r100;
    }

    @Override // kta.c
    public final Intent b(Context r100) {
        Intent r101 = new Intent();
        r101.setComponent(new ComponentName("com.coolpad.deviceidsupport", "com.coolpad.deviceidsupport.DeviceIdService"));
        return r101;
    }

    @Override // kta.c, kta.o
    public final o.a getOaid(Context r100) {
        String r101 = Settings.Global.getString(r100.getContentResolver(), "coolos.oaid");     // Catch: Throwable -> L6
        if (TextUtils.isEmpty(r101) == true) goto L9;
        o.a r102 = new o.a();     // Catch: Throwable -> L6
        r102.f506112a = r101;     // Catch: Throwable -> L6
        return r102;
    L9:
        return super.getOaid(r100);
    L6:
        th = move-exception;
        th.printStackTrace();
        goto L9
    }
}
