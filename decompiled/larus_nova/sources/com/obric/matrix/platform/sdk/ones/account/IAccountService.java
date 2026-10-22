package com.obric.matrix.platform.sdk.ones.account;

import android.app.PendingIntent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes5.dex */
public interface IAccountService extends IInterface {
    public static final String DESCRIPTOR = "com.obric.matrix.platform.sdk.ones.account.IAccountService";

    /* JADX INFO: loaded from: classes33.dex */
    public static class Default implements IAccountService {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
        public void checkPassword(String r100, IAccountActionCallback r101) throws RemoteException {
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
        public void forceUpdateAccount() throws RemoteException {
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
        public void login(PendingIntent r100) throws RemoteException {
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
        public void loginWithPassword(String r100, String r101, IAccountActionCallback r102) throws RemoteException {
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
        public void logout(IAccountActionCallback r100) throws RemoteException {
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
        public void quickLogin(String r100, String r101, IAccountActionCallback r102) throws RemoteException {
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
        public void resetPassword(String r100, String r101, String r102, IAccountActionCallback r103) throws RemoteException {
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
        public void sendCode(String r100, int r101, IAccountActionCallback r102) throws RemoteException {
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
        public void setInitPassword(String r100, IAccountActionCallback r101) throws RemoteException {
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
        public void ticketResetPassword(String r100, String r101, IAccountActionCallback r102) throws RemoteException {
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
        public void updatePassword(String r100, String r101, IAccountActionCallback r102) throws RemoteException {
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
        public void updateUserInfo(Bundle r100, String r101, IAccountActionCallback r102) throws RemoteException {
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
        public void uploadAvatar(String r100, IAccountActionCallback r101) throws RemoteException {
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
        public void verifyPassword(String r100, String r101, IAccountActionCallback r102) throws RemoteException {
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
        public void verifyPasswordWithoutLogin(String r100, String r101, IAccountActionCallback r102) throws RemoteException {
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
        public void verifySmsCode(String r100, String r101, int r102, IAccountActionCallback r103) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IAccountService {
        static final int TRANSACTION_checkPassword = 12;
        static final int TRANSACTION_forceUpdateAccount = 3;
        static final int TRANSACTION_login = 1;
        static final int TRANSACTION_loginWithPassword = 8;
        static final int TRANSACTION_logout = 2;
        static final int TRANSACTION_quickLogin = 5;
        static final int TRANSACTION_resetPassword = 14;
        static final int TRANSACTION_sendCode = 4;
        static final int TRANSACTION_setInitPassword = 11;
        static final int TRANSACTION_ticketResetPassword = 10;
        static final int TRANSACTION_updatePassword = 13;
        static final int TRANSACTION_updateUserInfo = 6;
        static final int TRANSACTION_uploadAvatar = 7;
        static final int TRANSACTION_verifyPassword = 15;
        static final int TRANSACTION_verifyPasswordWithoutLogin = 16;
        static final int TRANSACTION_verifySmsCode = 9;

        public static class Proxy implements IAccountService {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return IAccountService.DESCRIPTOR;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
            public void forceUpdateAccount() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(IAccountService.DESCRIPTOR);     // Catch: Throwable -> L6
                INVOKEINTERFACE_com_obric_matrix_platform_sdk_ones_account_IAccountService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r100, r101, 0);     // Catch: Throwable -> L6
                r101.readException();     // Catch: Throwable -> L6
                r101.recycle();
                r100.recycle();
                return;
            L6:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public Proxy(IBinder r100) {
                this.mRemote = r100;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
            public void login(PendingIntent r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(IAccountService.DESCRIPTOR);     // Catch: Throwable -> L10
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L10
                r100.writeToParcel(r101, 0);     // Catch: Throwable -> L10
            L7:
                INVOKEINTERFACE_com_obric_matrix_platform_sdk_ones_account_IAccountService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r101, r102, 0);     // Catch: Throwable -> L10
                r102.readException();     // Catch: Throwable -> L10
                r102.recycle();
                r101.recycle();
                return;
            L6:
                r101.writeInt(0);     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
            public void logout(IAccountActionCallback r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(IAccountService.DESCRIPTOR);     // Catch: Throwable -> L6
                r101.writeStrongInterface(r100);     // Catch: Throwable -> L6
                INVOKEINTERFACE_com_obric_matrix_platform_sdk_ones_account_IAccountService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r101, r102, 0);     // Catch: Throwable -> L6
                r102.readException();     // Catch: Throwable -> L6
                r102.recycle();
                r101.recycle();
                return;
            L6:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
            public void checkPassword(String r100, IAccountActionCallback r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(IAccountService.DESCRIPTOR);     // Catch: Throwable -> L6
                r102.writeString(r100);     // Catch: Throwable -> L6
                r102.writeStrongInterface(r101);     // Catch: Throwable -> L6
                INVOKEINTERFACE_com_obric_matrix_platform_sdk_ones_account_IAccountService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 12, r102, r103, 0);     // Catch: Throwable -> L6
                r103.readException();     // Catch: Throwable -> L6
                r103.recycle();
                r102.recycle();
                return;
            L6:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
            public void setInitPassword(String r100, IAccountActionCallback r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(IAccountService.DESCRIPTOR);     // Catch: Throwable -> L6
                r102.writeString(r100);     // Catch: Throwable -> L6
                r102.writeStrongInterface(r101);     // Catch: Throwable -> L6
                INVOKEINTERFACE_com_obric_matrix_platform_sdk_ones_account_IAccountService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 11, r102, r103, 0);     // Catch: Throwable -> L6
                r103.readException();     // Catch: Throwable -> L6
                r103.recycle();
                r102.recycle();
                return;
            L6:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
            public void uploadAvatar(String r100, IAccountActionCallback r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(IAccountService.DESCRIPTOR);     // Catch: Throwable -> L6
                r102.writeString(r100);     // Catch: Throwable -> L6
                r102.writeStrongInterface(r101);     // Catch: Throwable -> L6
                INVOKEINTERFACE_com_obric_matrix_platform_sdk_ones_account_IAccountService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 7, r102, r103, 0);     // Catch: Throwable -> L6
                r103.readException();     // Catch: Throwable -> L6
                r103.recycle();
                r102.recycle();
                return;
            L6:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
            public void loginWithPassword(String r100, String r101, IAccountActionCallback r102) throws RemoteException {
                Parcel r103 = Parcel.obtain();
                Parcel r104 = Parcel.obtain();
                r103.writeInterfaceToken(IAccountService.DESCRIPTOR);     // Catch: Throwable -> L6
                r103.writeString(r100);     // Catch: Throwable -> L6
                r103.writeString(r101);     // Catch: Throwable -> L6
                r103.writeStrongInterface(r102);     // Catch: Throwable -> L6
                INVOKEINTERFACE_com_obric_matrix_platform_sdk_ones_account_IAccountService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 8, r103, r104, 0);     // Catch: Throwable -> L6
                r104.readException();     // Catch: Throwable -> L6
                r104.recycle();
                r103.recycle();
                return;
            L6:
                th = move-exception;
                r104.recycle();
                r103.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
            public void quickLogin(String r100, String r101, IAccountActionCallback r102) throws RemoteException {
                Parcel r103 = Parcel.obtain();
                Parcel r104 = Parcel.obtain();
                r103.writeInterfaceToken(IAccountService.DESCRIPTOR);     // Catch: Throwable -> L6
                r103.writeString(r100);     // Catch: Throwable -> L6
                r103.writeString(r101);     // Catch: Throwable -> L6
                r103.writeStrongInterface(r102);     // Catch: Throwable -> L6
                INVOKEINTERFACE_com_obric_matrix_platform_sdk_ones_account_IAccountService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 5, r103, r104, 0);     // Catch: Throwable -> L6
                r104.readException();     // Catch: Throwable -> L6
                r104.recycle();
                r103.recycle();
                return;
            L6:
                th = move-exception;
                r104.recycle();
                r103.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
            public void sendCode(String r100, int r101, IAccountActionCallback r102) throws RemoteException {
                Parcel r103 = Parcel.obtain();
                Parcel r104 = Parcel.obtain();
                r103.writeInterfaceToken(IAccountService.DESCRIPTOR);     // Catch: Throwable -> L6
                r103.writeString(r100);     // Catch: Throwable -> L6
                r103.writeInt(r101);     // Catch: Throwable -> L6
                r103.writeStrongInterface(r102);     // Catch: Throwable -> L6
                INVOKEINTERFACE_com_obric_matrix_platform_sdk_ones_account_IAccountService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r103, r104, 0);     // Catch: Throwable -> L6
                r104.readException();     // Catch: Throwable -> L6
                r104.recycle();
                r103.recycle();
                return;
            L6:
                th = move-exception;
                r104.recycle();
                r103.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
            public void ticketResetPassword(String r100, String r101, IAccountActionCallback r102) throws RemoteException {
                Parcel r103 = Parcel.obtain();
                Parcel r104 = Parcel.obtain();
                r103.writeInterfaceToken(IAccountService.DESCRIPTOR);     // Catch: Throwable -> L6
                r103.writeString(r100);     // Catch: Throwable -> L6
                r103.writeString(r101);     // Catch: Throwable -> L6
                r103.writeStrongInterface(r102);     // Catch: Throwable -> L6
                INVOKEINTERFACE_com_obric_matrix_platform_sdk_ones_account_IAccountService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 10, r103, r104, 0);     // Catch: Throwable -> L6
                r104.readException();     // Catch: Throwable -> L6
                r104.recycle();
                r103.recycle();
                return;
            L6:
                th = move-exception;
                r104.recycle();
                r103.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
            public void updatePassword(String r100, String r101, IAccountActionCallback r102) throws RemoteException {
                Parcel r103 = Parcel.obtain();
                Parcel r104 = Parcel.obtain();
                r103.writeInterfaceToken(IAccountService.DESCRIPTOR);     // Catch: Throwable -> L6
                r103.writeString(r100);     // Catch: Throwable -> L6
                r103.writeString(r101);     // Catch: Throwable -> L6
                r103.writeStrongInterface(r102);     // Catch: Throwable -> L6
                INVOKEINTERFACE_com_obric_matrix_platform_sdk_ones_account_IAccountService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 13, r103, r104, 0);     // Catch: Throwable -> L6
                r104.readException();     // Catch: Throwable -> L6
                r104.recycle();
                r103.recycle();
                return;
            L6:
                th = move-exception;
                r104.recycle();
                r103.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
            public void updateUserInfo(Bundle r100, String r101, IAccountActionCallback r102) throws RemoteException {
                Parcel r103 = Parcel.obtain();
                Parcel r104 = Parcel.obtain();
                r103.writeInterfaceToken(IAccountService.DESCRIPTOR);     // Catch: Throwable -> L10
                if (r100 == null) goto L6;
                r103.writeInt(1);     // Catch: Throwable -> L10
                r100.writeToParcel(r103, 0);     // Catch: Throwable -> L10
            L7:
                r103.writeString(r101);     // Catch: Throwable -> L10
                r103.writeStrongInterface(r102);     // Catch: Throwable -> L10
                INVOKEINTERFACE_com_obric_matrix_platform_sdk_ones_account_IAccountService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 6, r103, r104, 0);     // Catch: Throwable -> L10
                r104.readException();     // Catch: Throwable -> L10
                r104.recycle();
                r103.recycle();
                return;
            L6:
                r103.writeInt(0);     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                r104.recycle();
                r103.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
            public void verifyPassword(String r100, String r101, IAccountActionCallback r102) throws RemoteException {
                Parcel r103 = Parcel.obtain();
                Parcel r104 = Parcel.obtain();
                r103.writeInterfaceToken(IAccountService.DESCRIPTOR);     // Catch: Throwable -> L6
                r103.writeString(r100);     // Catch: Throwable -> L6
                r103.writeString(r101);     // Catch: Throwable -> L6
                r103.writeStrongInterface(r102);     // Catch: Throwable -> L6
                INVOKEINTERFACE_com_obric_matrix_platform_sdk_ones_account_IAccountService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 15, r103, r104, 0);     // Catch: Throwable -> L6
                r104.readException();     // Catch: Throwable -> L6
                r104.recycle();
                r103.recycle();
                return;
            L6:
                th = move-exception;
                r104.recycle();
                r103.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
            public void verifyPasswordWithoutLogin(String r100, String r101, IAccountActionCallback r102) throws RemoteException {
                Parcel r103 = Parcel.obtain();
                Parcel r104 = Parcel.obtain();
                r103.writeInterfaceToken(IAccountService.DESCRIPTOR);     // Catch: Throwable -> L6
                r103.writeString(r100);     // Catch: Throwable -> L6
                r103.writeString(r101);     // Catch: Throwable -> L6
                r103.writeStrongInterface(r102);     // Catch: Throwable -> L6
                INVOKEINTERFACE_com_obric_matrix_platform_sdk_ones_account_IAccountService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 16, r103, r104, 0);     // Catch: Throwable -> L6
                r104.readException();     // Catch: Throwable -> L6
                r104.recycle();
                r103.recycle();
                return;
            L6:
                th = move-exception;
                r104.recycle();
                r103.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
            public void resetPassword(String r100, String r101, String r102, IAccountActionCallback r103) throws RemoteException {
                Parcel r104 = Parcel.obtain();
                Parcel r105 = Parcel.obtain();
                r104.writeInterfaceToken(IAccountService.DESCRIPTOR);     // Catch: Throwable -> L6
                r104.writeString(r100);     // Catch: Throwable -> L6
                r104.writeString(r101);     // Catch: Throwable -> L6
                r104.writeString(r102);     // Catch: Throwable -> L6
                r104.writeStrongInterface(r103);     // Catch: Throwable -> L6
                INVOKEINTERFACE_com_obric_matrix_platform_sdk_ones_account_IAccountService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 14, r104, r105, 0);     // Catch: Throwable -> L6
                r105.readException();     // Catch: Throwable -> L6
                r105.recycle();
                r104.recycle();
                return;
            L6:
                th = move-exception;
                r105.recycle();
                r104.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountService
            public void verifySmsCode(String r100, String r101, int r102, IAccountActionCallback r103) throws RemoteException {
                Parcel r104 = Parcel.obtain();
                Parcel r105 = Parcel.obtain();
                r104.writeInterfaceToken(IAccountService.DESCRIPTOR);     // Catch: Throwable -> L6
                r104.writeString(r100);     // Catch: Throwable -> L6
                r104.writeString(r101);     // Catch: Throwable -> L6
                r104.writeInt(r102);     // Catch: Throwable -> L6
                r104.writeStrongInterface(r103);     // Catch: Throwable -> L6
                INVOKEINTERFACE_com_obric_matrix_platform_sdk_ones_account_IAccountService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 9, r104, r105, 0);     // Catch: Throwable -> L6
                r105.readException();     // Catch: Throwable -> L6
                r105.recycle();
                r104.recycle();
                return;
            L6:
                th = move-exception;
                r105.recycle();
                r104.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_obric_matrix_platform_sdk_ones_account_IAccountService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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
            attachInterface(this, IAccountService.DESCRIPTOR);
        }

        public static IAccountService asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(IAccountService.DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof IAccountService) == false) goto L12;
            return (IAccountService) r101;
        L12:
            return new Proxy(r100);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r100, Parcel r101, Parcel r102, int r103) throws RemoteException {
            if (r100 < 1) goto L8;
            if (r100 > 16777215) goto L8;
            r101.enforceInterface(IAccountService.DESCRIPTOR);
        L8:
            if (r100 != 1598968902) goto L11;
            r102.writeString(IAccountService.DESCRIPTOR);
            return true;
        L11:
            Object r104 = null;
            switch(r100) {
                case 1: goto L33;
                case 2: goto L32;
                case 3: goto L31;
                case 4: goto L30;
                case 5: goto L29;
                case 6: goto L25;
                case 7: goto L24;
                case 8: goto L23;
                case 9: goto L22;
                case 10: goto L21;
                case 11: goto L20;
                case 12: goto L19;
                case 13: goto L18;
                case 14: goto L17;
                case 15: goto L16;
                case 16: goto L15;
                default: goto L14;
            };
        L15:
            verifyPasswordWithoutLogin(r101.readString(), r101.readString(), IAccountActionCallback.Stub.asInterface(r101.readStrongBinder()));
            r102.writeNoException();
        L37:
            return true;
        L16:
            verifyPassword(r101.readString(), r101.readString(), IAccountActionCallback.Stub.asInterface(r101.readStrongBinder()));
            r102.writeNoException();
            goto L37
        L17:
            resetPassword(r101.readString(), r101.readString(), r101.readString(), IAccountActionCallback.Stub.asInterface(r101.readStrongBinder()));
            r102.writeNoException();
            goto L37
        L18:
            updatePassword(r101.readString(), r101.readString(), IAccountActionCallback.Stub.asInterface(r101.readStrongBinder()));
            r102.writeNoException();
            goto L37
        L19:
            checkPassword(r101.readString(), IAccountActionCallback.Stub.asInterface(r101.readStrongBinder()));
            r102.writeNoException();
            goto L37
        L20:
            setInitPassword(r101.readString(), IAccountActionCallback.Stub.asInterface(r101.readStrongBinder()));
            r102.writeNoException();
            goto L37
        L21:
            ticketResetPassword(r101.readString(), r101.readString(), IAccountActionCallback.Stub.asInterface(r101.readStrongBinder()));
            r102.writeNoException();
            goto L37
        L22:
            verifySmsCode(r101.readString(), r101.readString(), r101.readInt(), IAccountActionCallback.Stub.asInterface(r101.readStrongBinder()));
            r102.writeNoException();
            goto L37
        L23:
            loginWithPassword(r101.readString(), r101.readString(), IAccountActionCallback.Stub.asInterface(r101.readStrongBinder()));
            r102.writeNoException();
            goto L37
        L24:
            uploadAvatar(r101.readString(), IAccountActionCallback.Stub.asInterface(r101.readStrongBinder()));
            r102.writeNoException();
            goto L37
        L25:
            Parcelable.Creator r105 = Bundle.CREATOR;
            if (r101.readInt() == 0) goto L28;
            r104 = r105.createFromParcel(r101);
        L28:
            updateUserInfo((Bundle) r104, r101.readString(), IAccountActionCallback.Stub.asInterface(r101.readStrongBinder()));
            r102.writeNoException();
            goto L37
        L29:
            quickLogin(r101.readString(), r101.readString(), IAccountActionCallback.Stub.asInterface(r101.readStrongBinder()));
            r102.writeNoException();
            goto L37
        L30:
            sendCode(r101.readString(), r101.readInt(), IAccountActionCallback.Stub.asInterface(r101.readStrongBinder()));
            r102.writeNoException();
            goto L37
        L31:
            forceUpdateAccount();
            r102.writeNoException();
            goto L37
        L32:
            logout(IAccountActionCallback.Stub.asInterface(r101.readStrongBinder()));
            r102.writeNoException();
            goto L37
        L33:
            Parcelable.Creator r106 = PendingIntent.CREATOR;
            if (r101.readInt() == 0) goto L36;
            r104 = r106.createFromParcel(r101);
        L36:
            login((PendingIntent) r104);
            r102.writeNoException();
            goto L37
        L14:
            return super.onTransact(r100, r101, r102, r103);
        }
    }

    void checkPassword(String r100, IAccountActionCallback r101) throws RemoteException;

    void forceUpdateAccount() throws RemoteException;

    void login(PendingIntent r100) throws RemoteException;

    void loginWithPassword(String r100, String r101, IAccountActionCallback r102) throws RemoteException;

    void logout(IAccountActionCallback r100) throws RemoteException;

    void quickLogin(String r100, String r101, IAccountActionCallback r102) throws RemoteException;

    void resetPassword(String r100, String r101, String r102, IAccountActionCallback r103) throws RemoteException;

    void sendCode(String r100, int r101, IAccountActionCallback r102) throws RemoteException;

    void setInitPassword(String r100, IAccountActionCallback r101) throws RemoteException;

    void ticketResetPassword(String r100, String r101, IAccountActionCallback r102) throws RemoteException;

    void updatePassword(String r100, String r101, IAccountActionCallback r102) throws RemoteException;

    void updateUserInfo(Bundle r100, String r101, IAccountActionCallback r102) throws RemoteException;

    void uploadAvatar(String r100, IAccountActionCallback r101) throws RemoteException;

    void verifyPassword(String r100, String r101, IAccountActionCallback r102) throws RemoteException;

    void verifyPasswordWithoutLogin(String r100, String r101, IAccountActionCallback r102) throws RemoteException;

    void verifySmsCode(String r100, String r101, int r102, IAccountActionCallback r103) throws RemoteException;
}
