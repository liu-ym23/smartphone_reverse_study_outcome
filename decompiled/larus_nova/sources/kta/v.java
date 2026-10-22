package kta;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.samsung.android.deviceidservice.IDeviceIdService;

/* JADX INFO: loaded from: classes34.dex */
public final class v extends c<IDeviceIdService> {

    public class a implements w.b<IDeviceIdService, String> {
        public a() {
        }

        @Override // kta.w.b
        public final String a(IDeviceIdService r100) throws Exception {
            return r100.getOAID();
        }

        @Override // kta.w.b
        public final IDeviceIdService b(IBinder r100) {
            return IDeviceIdService.Stub.asInterface(r100);
        }
    }

    public v() {
        super("com.samsung.android.deviceidservice");
    }

    @Override // kta.c
    public final w.b<IDeviceIdService, String> c() {
        return new a();
    }

    @Override // kta.c
    public final Intent b(Context r100) {
        Intent r101 = new Intent();
        r101.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        return r101;
    }
}
