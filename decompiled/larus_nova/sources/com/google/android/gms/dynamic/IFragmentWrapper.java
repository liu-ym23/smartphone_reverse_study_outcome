package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.common.h;

/* JADX INFO: loaded from: classes23.dex */
public interface IFragmentWrapper extends IInterface {

    public static abstract class Stub extends com.google.android.gms.internal.common.zzb implements IFragmentWrapper {
        public Stub() {
            super("com.google.android.gms.dynamic.IFragmentWrapper");
        }

        public static IFragmentWrapper asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            if ((r101 instanceof IFragmentWrapper) == false) goto L10;
            return (IFragmentWrapper) r101;
        L10:
            return new zza(r100);
        }

        @Override // com.google.android.gms.internal.common.zzb
        public final boolean zza(int r100, Parcel r101, Parcel r102, int r103) throws RemoteException {
            boolean r104 = false;
            switch(r100) {
                case 2: goto L45;
                case 3: goto L41;
                case 4: goto L40;
                case 5: goto L39;
                case 6: goto L38;
                case 7: goto L37;
                case 8: goto L36;
                case 9: goto L35;
                case 10: goto L34;
                case 11: goto L33;
                case 12: goto L32;
                case 13: goto L31;
                case 14: goto L30;
                case 15: goto L29;
                case 16: goto L28;
                case 17: goto L27;
                case 18: goto L26;
                case 19: goto L25;
                case 20: goto L24;
                case 21: goto L20;
                case 22: goto L16;
                case 23: goto L12;
                case 24: goto L8;
                case 25: goto L7;
                case 26: goto L6;
                case 27: goto L5;
                default: goto L4;
            };
        L4:
            return false;
        L5:
            IObjectWrapper r105 = IObjectWrapper.Stub.asInterface(r101.readStrongBinder());
            h.b(r101);
            zzr(r105);
            r102.writeNoException();
        L46:
            return true;
        L6:
            Intent r106 = (Intent) h.a(r101, Intent.CREATOR);
            int r107 = r101.readInt();
            h.b(r101);
            zzq(r106, r107);
            r102.writeNoException();
            goto L46
        L7:
            Intent r108 = (Intent) h.a(r101, Intent.CREATOR);
            h.b(r101);
            zzp(r108);
            r102.writeNoException();
            goto L46
        L8:
            int r109 = h.f274647a;
            if (r101.readInt() == 0) goto L11;
            r104 = true;
        L11:
            h.b(r101);
            zzo(r104);
            r102.writeNoException();
            goto L46
        L12:
            int r110 = h.f274647a;
            if (r101.readInt() == 0) goto L15;
            r104 = true;
        L15:
            h.b(r101);
            zzn(r104);
            r102.writeNoException();
            goto L46
        L16:
            int r111 = h.f274647a;
            if (r101.readInt() == 0) goto L19;
            r104 = true;
        L19:
            h.b(r101);
            zzm(r104);
            r102.writeNoException();
            goto L46
        L20:
            int r112 = h.f274647a;
            if (r101.readInt() == 0) goto L23;
            r104 = true;
        L23:
            h.b(r101);
            zzl(r104);
            r102.writeNoException();
            goto L46
        L24:
            IObjectWrapper r113 = IObjectWrapper.Stub.asInterface(r101.readStrongBinder());
            h.b(r101);
            zzk(r113);
            r102.writeNoException();
            goto L46
        L25:
            boolean r114 = zzA();
            r102.writeNoException();
            int r115 = h.f274647a;
            r102.writeInt(r114 ? 1 : 0);
            goto L46
        L26:
            boolean r116 = zzz();
            r102.writeNoException();
            int r117 = h.f274647a;
            r102.writeInt(r116 ? 1 : 0);
            goto L46
        L27:
            boolean r118 = zzy();
            r102.writeNoException();
            int r119 = h.f274647a;
            r102.writeInt(r118 ? 1 : 0);
            goto L46
        L28:
            boolean r120 = zzx();
            r102.writeNoException();
            int r121 = h.f274647a;
            r102.writeInt(r120 ? 1 : 0);
            goto L46
        L29:
            boolean r122 = zzw();
            r102.writeNoException();
            int r123 = h.f274647a;
            r102.writeInt(r122 ? 1 : 0);
            goto L46
        L30:
            boolean r124 = zzv();
            r102.writeNoException();
            int r125 = h.f274647a;
            r102.writeInt(r124 ? 1 : 0);
            goto L46
        L31:
            boolean r126 = zzu();
            r102.writeNoException();
            int r127 = h.f274647a;
            r102.writeInt(r126 ? 1 : 0);
            goto L46
        L32:
            IObjectWrapper r128 = zzi();
            r102.writeNoException();
            h.d(r102, r128);
            goto L46
        L33:
            boolean r129 = zzt();
            r102.writeNoException();
            int r130 = h.f274647a;
            r102.writeInt(r129 ? 1 : 0);
            goto L46
        L34:
            int r131 = zzc();
            r102.writeNoException();
            r102.writeInt(r131);
            goto L46
        L35:
            IFragmentWrapper r132 = zzf();
            r102.writeNoException();
            h.d(r102, r132);
            goto L46
        L36:
            String r133 = zzj();
            r102.writeNoException();
            r102.writeString(r133);
            goto L46
        L37:
            boolean r134 = zzs();
            r102.writeNoException();
            int r135 = h.f274647a;
            r102.writeInt(r134 ? 1 : 0);
            goto L46
        L38:
            IObjectWrapper r136 = zzh();
            r102.writeNoException();
            h.d(r102, r136);
            goto L46
        L39:
            IFragmentWrapper r137 = zze();
            r102.writeNoException();
            h.d(r102, r137);
            goto L46
        L40:
            int r138 = zzb();
            r102.writeNoException();
            r102.writeInt(r138);
            goto L46
        L41:
            Bundle r139 = zzd();
            r102.writeNoException();
            int r140 = h.f274647a;
            if (r139 != null) goto L44;
            r102.writeInt(0);
            goto L46
        L44:
            r102.writeInt(1);
            r139.writeToParcel(r102, 1);
            goto L46
        L45:
            IObjectWrapper r141 = zzg();
            r102.writeNoException();
            h.d(r102, r141);
            goto L46
        }
    }

    boolean zzA() throws RemoteException;

    int zzb() throws RemoteException;

    int zzc() throws RemoteException;

    Bundle zzd() throws RemoteException;

    IFragmentWrapper zze() throws RemoteException;

    IFragmentWrapper zzf() throws RemoteException;

    IObjectWrapper zzg() throws RemoteException;

    IObjectWrapper zzh() throws RemoteException;

    IObjectWrapper zzi() throws RemoteException;

    String zzj() throws RemoteException;

    void zzk(IObjectWrapper r100) throws RemoteException;

    void zzl(boolean r100) throws RemoteException;

    void zzm(boolean r100) throws RemoteException;

    void zzn(boolean r100) throws RemoteException;

    void zzo(boolean r100) throws RemoteException;

    void zzp(Intent r100) throws RemoteException;

    void zzq(Intent r100, int r101) throws RemoteException;

    void zzr(IObjectWrapper r100) throws RemoteException;

    boolean zzs() throws RemoteException;

    boolean zzt() throws RemoteException;

    boolean zzu() throws RemoteException;

    boolean zzv() throws RemoteException;

    boolean zzw() throws RemoteException;

    boolean zzx() throws RemoteException;

    boolean zzy() throws RemoteException;

    boolean zzz() throws RemoteException;
}
