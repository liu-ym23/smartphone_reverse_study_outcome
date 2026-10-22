package e84;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.bytedance.bdinstall.oaid.impl.IDeviceidInterface;

/* JADX INFO: loaded from: classes8.dex */
public final class h extends b<IDeviceidInterface> {

    public class a implements u.b<IDeviceidInterface, String> {
        public a() {
        }

        @Override // e84.u.b
        public final String a(IDeviceidInterface r100) throws Exception {
            IDeviceidInterface r101 = r100;
            if (r101 != null) goto L6;
            return null;
        L6:
            return r101.getOAID();
        }

        @Override // e84.u.b
        public final IDeviceidInterface b(IBinder r100) {
            return IDeviceidInterface.Stub.asInterface(r100);
        }
    }

    @Override // e84.m
    public final String getName() {
        return "Lenovo";
    }

    public h() {
        super("com.zui.deviceidservice");
    }

    @Override // e84.b
    public final u.b<IDeviceidInterface, String> c() {
        return new a();
    }

    @Override // e84.b
    public final Intent b(Context r100) {
        Intent r101 = new Intent();
        r101.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        return r101;
    }
}
