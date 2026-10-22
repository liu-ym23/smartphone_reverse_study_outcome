package e84;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.provider.Settings;
import android.text.TextUtils;
import com.bytedance.bdinstall.oaid.impl.IDeviceIdManager;

/* JADX INFO: loaded from: classes8.dex */
public final class d extends b<IDeviceIdManager> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f471302c;

    public class a implements u.b<IDeviceIdManager, String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f471303a;

        public a(d r100) {
            this.f471303a = r100;
        }

        @Override // e84.u.b
        public final String a(IDeviceIdManager r100) throws Exception {
            IDeviceIdManager r101 = r100;
            if (r101 != null) goto L6;
            return null;
        L6:
            return r101.getOAID(this.f471303a.f471302c.getPackageName());
        }

        @Override // e84.u.b
        public final IDeviceIdManager b(IBinder r100) {
            return IDeviceIdManager.Stub.asInterface(r100);
        }
    }

    @Override // e84.m
    public final String getName() {
        return "coolpad";
    }

    @Override // e84.b
    public final u.b<IDeviceIdManager, String> c() {
        return new a(this);
    }

    public d(Context r100) {
        super("com.coolpad.deviceidsupport");
        this.f471302c = r100;
    }

    @Override // e84.b
    public final Intent b(Context r100) {
        Intent r101 = new Intent();
        r101.setComponent(new ComponentName("com.coolpad.deviceidsupport", "com.coolpad.deviceidsupport.DeviceIdService"));
        return r101;
    }

    @Override // e84.b, e84.m
    public final m.a getOaid(Context r100) {
        String r101 = Settings.Global.getString(r100.getContentResolver(), "coolos.oaid");     // Catch: Throwable -> L6
        if (TextUtils.isEmpty(r101) == true) goto L9;
        m.a r102 = new m.a();     // Catch: Throwable -> L6
        r102.f471323a = r101;     // Catch: Throwable -> L6
        return r102;
    L9:
        return super.getOaid(r100);
    L6:
        th = move-exception;
        th.printStackTrace();
        goto L9
    }
}
