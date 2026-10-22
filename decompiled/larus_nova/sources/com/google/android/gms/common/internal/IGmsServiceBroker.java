package com.google.android.gms.common.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes23.dex */
public interface IGmsServiceBroker extends IInterface {

    public static abstract class Stub extends Binder implements IGmsServiceBroker {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.google.android.gms.common.internal.IGmsServiceBroker");
        }

        @Override // android.os.Binder
        public final boolean onTransact(int r100, Parcel r101, Parcel r102, int r103) throws RemoteException {
            if (r100 > 16777215) goto L5;
            r101.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            IBinder r104 = r101.readStrongBinder();
            GetServiceRequest r105 = null;
            if (r104 != null) goto L9;
            IGmsCallbacks r106 = null;
        L14:
            if (r100 != 46) goto L21;
            if (r101.readInt() == 0) goto L18;
            r105 = GetServiceRequest.CREATOR.createFromParcel(r101);
        L18:
            getService(r106, r105);
            Preconditions.checkNotNull(r102);
            r102.writeNoException();
            return true;
        L21:
            if (r100 == 47) goto L23;
            r101.readInt();
            if (r100 == 4) goto L71;
            r101.readString();
            if (r100 != 1) goto L32;
            r101.readString();
            r101.createStringArray();
            r101.readString();
            if (r101.readInt() == 0) goto L71;
            Bundle r107 = (Bundle) Bundle.CREATOR.createFromParcel(r101);
            goto L71
        L32:
            if (r100 == 2) goto L65;
            if (r100 == 23) goto L65;
            if (r100 == 25) goto L65;
            if (r100 == 27) goto L65;
            if (r100 != 30) goto L42;
        L61:
            r101.createStringArray();
            r101.readString();
            if (r101.readInt() == 0) goto L71;
            Bundle r108 = (Bundle) Bundle.CREATOR.createFromParcel(r101);
            goto L71
        L42:
            if (r100 != 34) goto L44;
            r101.readString();
            goto L71
        L44:
            if (r100 == 41) goto L65;
            if (r100 == 43) goto L65;
            if (r100 == 37) goto L65;
            if (r100 == 38) goto L65;
            switch(r100) {
                case 5: goto L65;
                case 6: goto L65;
                case 7: goto L65;
                case 8: goto L65;
                case 9: goto L57;
                case 10: goto L56;
                case 11: goto L65;
                case 12: goto L65;
                case 13: goto L65;
                case 14: goto L65;
                case 15: goto L65;
                case 16: goto L65;
                case 17: goto L65;
                case 18: goto L65;
                case 19: goto L53;
                case 20: goto L61;
                default: goto L71;
            };
        L53:
            r101.readStrongBinder();
            if (r101.readInt() == 0) goto L71;
            Bundle r109 = (Bundle) Bundle.CREATOR.createFromParcel(r101);
            goto L71
        L56:
            r101.readString();
            r101.createStringArray();
            goto L71
        L57:
            r101.readString();
            r101.createStringArray();
            r101.readString();
            r101.readStrongBinder();
            r101.readString();
            if (r101.readInt() == 0) goto L71;
            Bundle r110 = (Bundle) Bundle.CREATOR.createFromParcel(r101);
        L65:
            if (r101.readInt() == 0) goto L71;
            Bundle r111 = (Bundle) Bundle.CREATOR.createFromParcel(r101);
        L71:
            throw new UnsupportedOperationException();
        L23:
            if (r101.readInt() == 0) goto L26;
            zzak r112 = zzak.CREATOR.createFromParcel(r101);
        L26:
            throw new UnsupportedOperationException();
        L9:
            IInterface r113 = r104.queryLocalInterface("com.google.android.gms.common.internal.IGmsCallbacks");
            if ((r113 instanceof IGmsCallbacks) == false) goto L12;
            r106 = (IGmsCallbacks) r113;
            goto L14
        L12:
            r106 = new zzab(r104);
            goto L14
        L5:
            return super.onTransact(r100, r101, r102, r103);
        }
    }

    void getService(IGmsCallbacks r100, GetServiceRequest r101) throws RemoteException;
}
