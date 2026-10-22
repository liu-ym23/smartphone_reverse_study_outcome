package xpc;

import android.os.Binder;
import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes41.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public xpc.a f564788a;

    public class a extends Binder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f564789a;

        public a() {
            this.f564789a = b.f564790a;
        }

        @Override // android.os.Binder
        public final boolean onTransact(int r100, Parcel r101, Parcel r102, int r103) throws RemoteException {
            if (r100 != 1) goto L5;
            int r104 = r101.readInt();
            Bundle r105 = new Bundle();
            r105.readFromParcel(r101);
            xpc.a r106 = this.f564789a.f564788a;
            if (r106 == null) goto L9;
            r106.a(r104, r105);
        L9:
            r102.writeNoException();
            return true;
        L5:
            return super.onTransact(r100, r101, r102, r103);
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f564790a = null;

        static {
            f564790a = new c();
        }
    }

    public c() {
    }

    public static String a(int r100) {
        int r101 = 1;
        Object[] r102 = xpc.b.f564784d.b("turbo", new Object[]{7, 0, Integer.valueOf(r100), null});     // Catch: Exception -> L8
        if (r102.length <= 0) goto L7;
        r101 = r102[0];     // Catch: Exception -> L8
    L7:
        return String.valueOf(r101);
    }
}
