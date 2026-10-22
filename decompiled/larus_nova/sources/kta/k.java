package kta;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.zui.deviceidservice.IDeviceidInterface;

/* JADX INFO: loaded from: classes34.dex */
public final class k extends c<IDeviceidInterface> {

    public class a implements w.b<IDeviceidInterface, String> {
        public a() {
        }

        @Override // kta.w.b
        public final String a(IDeviceidInterface r100) throws Exception {
            IDeviceidInterface r101 = r100;
            if (r101 != null) goto L6;
            return null;
        L6:
            return r101.getOAID();
        }

        @Override // kta.w.b
        public final IDeviceidInterface b(IBinder r100) {
            return IDeviceidInterface.Stub.asInterface(r100);
        }
    }

    public k() {
        super("com.zui.deviceidservice");
    }

    @Override // kta.c
    public final w.b<IDeviceidInterface, String> c() {
        return new a();
    }

    @Override // kta.c
    public final Intent b(Context r100) {
        Intent r101 = new Intent();
        r101.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        return r101;
    }
}
