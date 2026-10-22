package com.ss.android.downloadlib.am.m2;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import com.ss.android.download.api.runtime.IAdSDKSettingsProvider;
import com.ss.android.downloadlib.addownload.DownloadAdRuntimeProvider;
import com.ss.android.socialbase.appdownloader.util.DecryptUtils;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public interface IAidlService extends IInterface {

    public static abstract class Stub extends Binder implements IAidlService {
        private static String DESCRIPTOR = "";

        public static class Proxy implements IAidlService {
            private IBinder mRemote;

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public Proxy(IBinder r100) {
                if (TextUtils.isEmpty(Stub.access$000()) == false) goto L15;
                IAdSDKSettingsProvider r101 = (IAdSDKSettingsProvider) DownloadAdRuntimeProvider.getInnerService(IAdSDKSettingsProvider.class);
                if (r101 == null) goto L7;
                JSONObject r102 = r101.getTTDownloaderAdSettings();
            L8:
                String r103 = "";
                if (r102 == null) goto L11;
                String r104 = r102.optString("s");
            L12:
                if (r102 == null) goto L14;
                r103 = r102.optString("r");
            L14:
                Stub.access$002(DecryptUtils.decrypt(r103, r104));
                goto L15
            L11:
                r104 = "";
                goto L12
            L7:
                r102 = null;
            L15:
                this.mRemote = r100;
            }

            @Override // com.ss.android.downloadlib.am.m2.IAidlService
            public void doAction(AidlMsg r100, ICallback r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.access$000());     // Catch: Throwable -> L13
                if (r100 == null) goto L6;
                r102.writeInt(1);     // Catch: Throwable -> L13
                r100.writeToParcel(r102, 0);     // Catch: Throwable -> L13
            L7:
                if (r101 == null) goto L9;
                IBinder r104 = r101.asBinder();     // Catch: Throwable -> L13
            L10:
                r102.writeStrongBinder(r104);     // Catch: Throwable -> L13
                INVOKEINTERFACE_com_ss_android_downloadlib_am_m2_IAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r102, r103, 0);     // Catch: Throwable -> L13
                r103.readException();     // Catch: Throwable -> L13
                r103.recycle();
                r102.recycle();
                return;
            L9:
                r104 = null;
                goto L10
            L6:
                r102.writeInt(0);     // Catch: Throwable -> L13
            L13:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_ss_android_downloadlib_am_m2_IAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
                if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
                long r100 = SystemClock.uptimeMillis();
                boolean r101 = r110.transact(r111, r112, r113, r114);     // Catch: Throwable -> L12
                long r102 = SystemClock.uptimeMillis() - r100;
                if (r102 < 100) goto L11;
                BinderPerformanceReporter.report(r102, r110.getClass().getName(), r111, r114, new Throwable("Slow main-thread Binder transaction"));
            L11:
                return r101;
            L12:
                th = move-exception;
                long r103 = SystemClock.uptimeMillis() - r100;
                if (r103 < 100) goto L22;
                if (r110 != null) goto L17;
                String r104 = "";
            L18:
                BinderPerformanceReporter.report(r103, r104, r111, r114, new Throwable("Slow main-thread Binder transaction"));
                throw th;
            L17:
                r104 = r110.getClass().getName();
                goto L18
            L22:
                throw th;
            L5:
                return r110.transact(r111, r112, r113, r114);
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            if (TextUtils.isEmpty(DESCRIPTOR) == false) goto L12;
            IAdSDKSettingsProvider r100 = (IAdSDKSettingsProvider) DownloadAdRuntimeProvider.getInnerService(IAdSDKSettingsProvider.class);
            if (r100 == null) goto L7;
            JSONObject r101 = r100.getTTDownloaderAdSettings();
        L8:
            if (r101 == null) goto L10;
            String r102 = r101.optString("s");
        L11:
            DESCRIPTOR = DecryptUtils.decrypt(r101.optString("r"), r102);
            goto L12
        L10:
            r102 = "";
            goto L11
        L7:
            r101 = null;
        L12:
            attachInterface(this, DESCRIPTOR);
        }

        public static /* synthetic */ String access$000() {
            return DESCRIPTOR;
        }

        public static /* synthetic */ String access$002(String r100) {
            DESCRIPTOR = r100;
            return r100;
        }

        public static IAidlService asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L13;
            if ((r101 instanceof IAidlService) == false) goto L13;
            return (IAidlService) r101;
        L13:
            return new Proxy(r100);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r100, Parcel r101, Parcel r102, int r103) throws RemoteException {
            if (r100 == 1598968902) goto L13;
            if (r100 != 1) goto L6;
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L10;
            AidlMsg r104 = AidlMsg.CREATOR.createFromParcel(r101);
        L11:
            doAction(r104, ICallback.Stub.asInterface(r101.readStrongBinder()));
            r102.writeNoException();
            return true;
        L10:
            r104 = null;
            goto L11
        L6:
            return super.onTransact(r100, r101, r102, r103);
        L13:
            r102.writeString(DESCRIPTOR);
            return true;
        }
    }

    void doAction(AidlMsg r100, ICallback r101) throws RemoteException;
}
