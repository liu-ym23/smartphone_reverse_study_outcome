package e84;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.bytedance.bdinstall.oaid.impl.IDeviceIdService;

/* JADX INFO: loaded from: classes8.dex */
public final class t extends b<IDeviceIdService> {

    public class a implements u.b<IDeviceIdService, String> {
        public a() {
        }

        @Override // e84.u.b
        public final String a(IDeviceIdService r100) throws Exception {
            return r100.getOAID();
        }

        @Override // e84.u.b
        public final IDeviceIdService b(IBinder r100) {
            return IDeviceIdService.Stub.asInterface(r100);
        }
    }

    @Override // e84.m
    public final String getName() {
        return "Samsung";
    }

    public t() {
        super("com.samsung.android.deviceidservice");
    }

    @Override // e84.b
    public final u.b<IDeviceIdService, String> c() {
        return new a();
    }

    @Override // e84.b
    public final Intent b(Context r100) {
        Intent r101 = new Intent();
        r101.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        return r101;
    }
}
