package com.cmic.ida.sdk;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes22.dex */
public interface d1 extends IInterface {

    public static abstract class a extends Binder implements d1 {
        public a() {
            attachInterface(this, "com.hihonor.cloudservice.oaid.IOAIDCallBack");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r110, Parcel r111, Parcel r112, int r113) {
            if (r110 != 1) goto L5;
            r111.enforceInterface("com.hihonor.cloudservice.oaid.IOAIDCallBack");
            int r100 = r111.readInt();
            long r101 = r111.readLong();
            if (r111.readInt() == 0) goto L22;
            boolean r102 = true;
        L23:
            a(r100, r101, r102, r111.readFloat(), r111.readDouble(), r111.readString());
        L17:
            r112.writeNoException();
            return true;
        L22:
            r102 = false;
            goto L23
        L5:
            if (r110 != 2) goto L7;
            r111.enforceInterface("com.hihonor.cloudservice.oaid.IOAIDCallBack");
            int r114 = r111.readInt();
            if (r111.readInt() == 0) goto L15;
            Bundle r115 = (Bundle) Bundle.CREATOR.createFromParcel(r111);
        L16:
            a(r114, r115);
            goto L17
        L15:
            r115 = null;
            goto L16
        L7:
            if (r110 != 1598968902) goto L9;
            r112.writeString("com.hihonor.cloudservice.oaid.IOAIDCallBack");
            return true;
        L9:
            return super.onTransact(r110, r111, r112, r113);
        }
    }

    void a(int r100, long r101, boolean r102, float r103, double r104, String r105);

    void a(int r100, Bundle r101);
}
