package com.bytedance.mira.am;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes3.dex */
public interface IPluginActivityManager extends IInterface {

    /* JADX INFO: loaded from: classes21.dex */
    public static class Default implements IPluginActivityManager {
        public Default() {
        }

        @Override // com.bytedance.mira.am.IPluginActivityManager
        public void activityCreated(ActivityInfo r100, ActivityInfo r101) throws RemoteException {
        }

        @Override // com.bytedance.mira.am.IPluginActivityManager
        public void activityDestroy(ActivityInfo r100, ActivityInfo r101) throws RemoteException {
        }

        @Override // com.bytedance.mira.am.IPluginActivityManager
        public void activityOnNewIntent(ActivityInfo r100, ActivityInfo r101, Intent r102) throws RemoteException {
        }

        @Override // com.bytedance.mira.am.IPluginActivityManager
        public void applicationCreated(ApplicationInfo r100, String r101, int r102, IApplicationThread r103) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.bytedance.mira.am.IPluginActivityManager
        public ServiceInfo getTargetService(ServiceInfo r100) throws RemoteException {
            return null;
        }

        @Override // com.bytedance.mira.am.IPluginActivityManager
        public boolean isStubActivity(ActivityInfo r100) throws RemoteException {
            return false;
        }

        @Override // com.bytedance.mira.am.IPluginActivityManager
        public boolean isStubProvider(ProviderInfo r100) throws RemoteException {
            return false;
        }

        @Override // com.bytedance.mira.am.IPluginActivityManager
        public boolean isStubReceiver(ActivityInfo r100) throws RemoteException {
            return false;
        }

        @Override // com.bytedance.mira.am.IPluginActivityManager
        public boolean isStubService(ServiceInfo r100) throws RemoteException {
            return false;
        }

        @Override // com.bytedance.mira.am.IPluginActivityManager
        public void receiverFinished(ActivityInfo r100, ActivityInfo r101) throws RemoteException {
        }

        @Override // com.bytedance.mira.am.IPluginActivityManager
        public void runInStubProcess(String r100, String r101) throws RemoteException {
        }

        @Override // com.bytedance.mira.am.IPluginActivityManager
        public ActivityInfo selectStubActivity(ActivityInfo r100) throws RemoteException {
            return null;
        }

        @Override // com.bytedance.mira.am.IPluginActivityManager
        public ProviderInfo selectStubProvider(ProviderInfo r100) throws RemoteException {
            return null;
        }

        @Override // com.bytedance.mira.am.IPluginActivityManager
        public ActivityInfo selectStubReceiver(ActivityInfo r100) throws RemoteException {
            return null;
        }

        @Override // com.bytedance.mira.am.IPluginActivityManager
        public ServiceInfo selectStubService(ServiceInfo r100) throws RemoteException {
            return null;
        }

        @Override // com.bytedance.mira.am.IPluginActivityManager
        public void serviceCreated(ServiceInfo r100, ServiceInfo r101) throws RemoteException {
        }

        @Override // com.bytedance.mira.am.IPluginActivityManager
        public void serviceDestroy(ServiceInfo r100, ServiceInfo r101) throws RemoteException {
        }

        @Override // com.bytedance.mira.am.IPluginActivityManager
        public void shareStubProcess(List<String> r100) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IPluginActivityManager {
        private static final String DESCRIPTOR = "com.bytedance.mira.am.IPluginActivityManager";
        static final int TRANSACTION_activityCreated = 6;
        static final int TRANSACTION_activityDestroy = 8;
        static final int TRANSACTION_activityOnNewIntent = 7;
        static final int TRANSACTION_applicationCreated = 5;
        static final int TRANSACTION_getTargetService = 18;
        static final int TRANSACTION_isStubActivity = 12;
        static final int TRANSACTION_isStubProvider = 15;
        static final int TRANSACTION_isStubReceiver = 14;
        static final int TRANSACTION_isStubService = 13;
        static final int TRANSACTION_receiverFinished = 11;
        static final int TRANSACTION_runInStubProcess = 16;
        static final int TRANSACTION_selectStubActivity = 1;
        static final int TRANSACTION_selectStubProvider = 4;
        static final int TRANSACTION_selectStubReceiver = 2;
        static final int TRANSACTION_selectStubService = 3;
        static final int TRANSACTION_serviceCreated = 9;
        static final int TRANSACTION_serviceDestroy = 10;
        static final int TRANSACTION_shareStubProcess = 17;

        /* JADX INFO: loaded from: classes21.dex */
        public static class Proxy implements IPluginActivityManager {
            public static IPluginActivityManager sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public Proxy(IBinder r100) {
                this.mRemote = r100;
            }

            @Override // com.bytedance.mira.am.IPluginActivityManager
            public ServiceInfo getTargetService(ServiceInfo r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L21
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L21
                r100.writeToParcel(r101, 0);     // Catch: Throwable -> L21
            L8:
                if (INVOKEINTERFACE_com_bytedance_mira_am_IPluginActivityManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 18, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L21
                if (r102.readInt() == 0) goto L18;
                ServiceInfo r103 = (ServiceInfo) ServiceInfo.CREATOR.createFromParcel(r102);     // Catch: Throwable -> L21
            L19:
                r102.recycle();
                r101.recycle();
                return r103;
            L18:
                r103 = null;
                goto L19
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                ServiceInfo r104 = Stub.getDefaultImpl().getTargetService(r100);     // Catch: Throwable -> L21
                r102.recycle();
                r101.recycle();
                return r104;
            L6:
                r101.writeInt(0);     // Catch: Throwable -> L21
            L21:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.bytedance.mira.am.IPluginActivityManager
            public boolean isStubActivity(ActivityInfo r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                boolean r103 = true;
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L20
                r100.writeToParcel(r101, 0);     // Catch: Throwable -> L20
            L8:
                if (INVOKEINTERFACE_com_bytedance_mira_am_IPluginActivityManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 12, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L20
                if (r102.readInt() != 0) goto L18;
                r103 = false;
            L18:
                r102.recycle();
                r101.recycle();
                return r103;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                boolean r104 = Stub.getDefaultImpl().isStubActivity(r100);     // Catch: Throwable -> L20
                r102.recycle();
                r101.recycle();
                return r104;
            L6:
                r101.writeInt(0);     // Catch: Throwable -> L20
            L20:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.bytedance.mira.am.IPluginActivityManager
            public boolean isStubProvider(ProviderInfo r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                boolean r103 = true;
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L20
                r100.writeToParcel(r101, 0);     // Catch: Throwable -> L20
            L8:
                if (INVOKEINTERFACE_com_bytedance_mira_am_IPluginActivityManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 15, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L20
                if (r102.readInt() != 0) goto L18;
                r103 = false;
            L18:
                r102.recycle();
                r101.recycle();
                return r103;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                boolean r104 = Stub.getDefaultImpl().isStubProvider(r100);     // Catch: Throwable -> L20
                r102.recycle();
                r101.recycle();
                return r104;
            L6:
                r101.writeInt(0);     // Catch: Throwable -> L20
            L20:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.bytedance.mira.am.IPluginActivityManager
            public boolean isStubReceiver(ActivityInfo r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                boolean r103 = true;
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L20
                r100.writeToParcel(r101, 0);     // Catch: Throwable -> L20
            L8:
                if (INVOKEINTERFACE_com_bytedance_mira_am_IPluginActivityManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 14, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L20
                if (r102.readInt() != 0) goto L18;
                r103 = false;
            L18:
                r102.recycle();
                r101.recycle();
                return r103;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                boolean r104 = Stub.getDefaultImpl().isStubReceiver(r100);     // Catch: Throwable -> L20
                r102.recycle();
                r101.recycle();
                return r104;
            L6:
                r101.writeInt(0);     // Catch: Throwable -> L20
            L20:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.bytedance.mira.am.IPluginActivityManager
            public boolean isStubService(ServiceInfo r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                boolean r103 = true;
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L20
                r100.writeToParcel(r101, 0);     // Catch: Throwable -> L20
            L8:
                if (INVOKEINTERFACE_com_bytedance_mira_am_IPluginActivityManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 13, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L20
                if (r102.readInt() != 0) goto L18;
                r103 = false;
            L18:
                r102.recycle();
                r101.recycle();
                return r103;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                boolean r104 = Stub.getDefaultImpl().isStubService(r100);     // Catch: Throwable -> L20
                r102.recycle();
                r101.recycle();
                return r104;
            L6:
                r101.writeInt(0);     // Catch: Throwable -> L20
            L20:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.bytedance.mira.am.IPluginActivityManager
            public ActivityInfo selectStubActivity(ActivityInfo r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L21
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L21
                r100.writeToParcel(r101, 0);     // Catch: Throwable -> L21
            L8:
                if (INVOKEINTERFACE_com_bytedance_mira_am_IPluginActivityManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L21
                if (r102.readInt() == 0) goto L18;
                ActivityInfo r103 = (ActivityInfo) ActivityInfo.CREATOR.createFromParcel(r102);     // Catch: Throwable -> L21
            L19:
                r102.recycle();
                r101.recycle();
                return r103;
            L18:
                r103 = null;
                goto L19
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                ActivityInfo r104 = Stub.getDefaultImpl().selectStubActivity(r100);     // Catch: Throwable -> L21
                r102.recycle();
                r101.recycle();
                return r104;
            L6:
                r101.writeInt(0);     // Catch: Throwable -> L21
            L21:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.bytedance.mira.am.IPluginActivityManager
            public ProviderInfo selectStubProvider(ProviderInfo r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L21
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L21
                r100.writeToParcel(r101, 0);     // Catch: Throwable -> L21
            L8:
                if (INVOKEINTERFACE_com_bytedance_mira_am_IPluginActivityManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L21
                if (r102.readInt() == 0) goto L18;
                ProviderInfo r103 = (ProviderInfo) ProviderInfo.CREATOR.createFromParcel(r102);     // Catch: Throwable -> L21
            L19:
                r102.recycle();
                r101.recycle();
                return r103;
            L18:
                r103 = null;
                goto L19
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                ProviderInfo r104 = Stub.getDefaultImpl().selectStubProvider(r100);     // Catch: Throwable -> L21
                r102.recycle();
                r101.recycle();
                return r104;
            L6:
                r101.writeInt(0);     // Catch: Throwable -> L21
            L21:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.bytedance.mira.am.IPluginActivityManager
            public ActivityInfo selectStubReceiver(ActivityInfo r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L21
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L21
                r100.writeToParcel(r101, 0);     // Catch: Throwable -> L21
            L8:
                if (INVOKEINTERFACE_com_bytedance_mira_am_IPluginActivityManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L21
                if (r102.readInt() == 0) goto L18;
                ActivityInfo r103 = (ActivityInfo) ActivityInfo.CREATOR.createFromParcel(r102);     // Catch: Throwable -> L21
            L19:
                r102.recycle();
                r101.recycle();
                return r103;
            L18:
                r103 = null;
                goto L19
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                ActivityInfo r104 = Stub.getDefaultImpl().selectStubReceiver(r100);     // Catch: Throwable -> L21
                r102.recycle();
                r101.recycle();
                return r104;
            L6:
                r101.writeInt(0);     // Catch: Throwable -> L21
            L21:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.bytedance.mira.am.IPluginActivityManager
            public ServiceInfo selectStubService(ServiceInfo r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L21
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L21
                r100.writeToParcel(r101, 0);     // Catch: Throwable -> L21
            L8:
                if (INVOKEINTERFACE_com_bytedance_mira_am_IPluginActivityManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L21
                if (r102.readInt() == 0) goto L18;
                ServiceInfo r103 = (ServiceInfo) ServiceInfo.CREATOR.createFromParcel(r102);     // Catch: Throwable -> L21
            L19:
                r102.recycle();
                r101.recycle();
                return r103;
            L18:
                r103 = null;
                goto L19
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                ServiceInfo r104 = Stub.getDefaultImpl().selectStubService(r100);     // Catch: Throwable -> L21
                r102.recycle();
                r101.recycle();
                return r104;
            L6:
                r101.writeInt(0);     // Catch: Throwable -> L21
            L21:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.bytedance.mira.am.IPluginActivityManager
            public void shareStubProcess(List<String> r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r101.writeStringList(r100);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_bytedance_mira_am_IPluginActivityManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 17, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().shareStubProcess(r100);     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return;
            L13:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.bytedance.mira.am.IPluginActivityManager
            public void activityCreated(ActivityInfo r100, ActivityInfo r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                if (r100 == null) goto L6;
                r102.writeInt(1);     // Catch: Throwable -> L20
                r100.writeToParcel(r102, 0);     // Catch: Throwable -> L20
            L7:
                if (r101 == null) goto L9;
                r102.writeInt(1);     // Catch: Throwable -> L20
                r101.writeToParcel(r102, 0);     // Catch: Throwable -> L20
            L11:
                if (INVOKEINTERFACE_com_bytedance_mira_am_IPluginActivityManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 6, r102, r103, 0) == false) goto L13;
            L17:
                r103.readException();     // Catch: Throwable -> L20
                r103.recycle();
                r102.recycle();
                return;
            L13:
                if (Stub.getDefaultImpl() == null) goto L17;
                Stub.getDefaultImpl().activityCreated(r100, r101);     // Catch: Throwable -> L20
                r103.recycle();
                r102.recycle();
                return;
            L9:
                r102.writeInt(0);     // Catch: Throwable -> L20
                goto L11
            L6:
                r102.writeInt(0);     // Catch: Throwable -> L20
            L20:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Override // com.bytedance.mira.am.IPluginActivityManager
            public void activityDestroy(ActivityInfo r100, ActivityInfo r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                if (r100 == null) goto L6;
                r102.writeInt(1);     // Catch: Throwable -> L20
                r100.writeToParcel(r102, 0);     // Catch: Throwable -> L20
            L7:
                if (r101 == null) goto L9;
                r102.writeInt(1);     // Catch: Throwable -> L20
                r101.writeToParcel(r102, 0);     // Catch: Throwable -> L20
            L11:
                if (INVOKEINTERFACE_com_bytedance_mira_am_IPluginActivityManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 8, r102, r103, 0) == false) goto L13;
            L17:
                r103.readException();     // Catch: Throwable -> L20
                r103.recycle();
                r102.recycle();
                return;
            L13:
                if (Stub.getDefaultImpl() == null) goto L17;
                Stub.getDefaultImpl().activityDestroy(r100, r101);     // Catch: Throwable -> L20
                r103.recycle();
                r102.recycle();
                return;
            L9:
                r102.writeInt(0);     // Catch: Throwable -> L20
                goto L11
            L6:
                r102.writeInt(0);     // Catch: Throwable -> L20
            L20:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Override // com.bytedance.mira.am.IPluginActivityManager
            public void receiverFinished(ActivityInfo r100, ActivityInfo r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                if (r100 == null) goto L6;
                r102.writeInt(1);     // Catch: Throwable -> L20
                r100.writeToParcel(r102, 0);     // Catch: Throwable -> L20
            L7:
                if (r101 == null) goto L9;
                r102.writeInt(1);     // Catch: Throwable -> L20
                r101.writeToParcel(r102, 0);     // Catch: Throwable -> L20
            L11:
                if (INVOKEINTERFACE_com_bytedance_mira_am_IPluginActivityManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 11, r102, r103, 0) == false) goto L13;
            L17:
                r103.readException();     // Catch: Throwable -> L20
                r103.recycle();
                r102.recycle();
                return;
            L13:
                if (Stub.getDefaultImpl() == null) goto L17;
                Stub.getDefaultImpl().receiverFinished(r100, r101);     // Catch: Throwable -> L20
                r103.recycle();
                r102.recycle();
                return;
            L9:
                r102.writeInt(0);     // Catch: Throwable -> L20
                goto L11
            L6:
                r102.writeInt(0);     // Catch: Throwable -> L20
            L20:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Override // com.bytedance.mira.am.IPluginActivityManager
            public void runInStubProcess(String r100, String r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r102.writeString(r100);     // Catch: Throwable -> L13
                r102.writeString(r101);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_bytedance_mira_am_IPluginActivityManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 16, r102, r103, 0) == false) goto L6;
            L10:
                r103.readException();     // Catch: Throwable -> L13
                r103.recycle();
                r102.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().runInStubProcess(r100, r101);     // Catch: Throwable -> L13
                r103.recycle();
                r102.recycle();
                return;
            L13:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Override // com.bytedance.mira.am.IPluginActivityManager
            public void serviceCreated(ServiceInfo r100, ServiceInfo r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                if (r100 == null) goto L6;
                r102.writeInt(1);     // Catch: Throwable -> L20
                r100.writeToParcel(r102, 0);     // Catch: Throwable -> L20
            L7:
                if (r101 == null) goto L9;
                r102.writeInt(1);     // Catch: Throwable -> L20
                r101.writeToParcel(r102, 0);     // Catch: Throwable -> L20
            L11:
                if (INVOKEINTERFACE_com_bytedance_mira_am_IPluginActivityManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 9, r102, r103, 0) == false) goto L13;
            L17:
                r103.readException();     // Catch: Throwable -> L20
                r103.recycle();
                r102.recycle();
                return;
            L13:
                if (Stub.getDefaultImpl() == null) goto L17;
                Stub.getDefaultImpl().serviceCreated(r100, r101);     // Catch: Throwable -> L20
                r103.recycle();
                r102.recycle();
                return;
            L9:
                r102.writeInt(0);     // Catch: Throwable -> L20
                goto L11
            L6:
                r102.writeInt(0);     // Catch: Throwable -> L20
            L20:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Override // com.bytedance.mira.am.IPluginActivityManager
            public void serviceDestroy(ServiceInfo r100, ServiceInfo r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                if (r100 == null) goto L6;
                r102.writeInt(1);     // Catch: Throwable -> L20
                r100.writeToParcel(r102, 0);     // Catch: Throwable -> L20
            L7:
                if (r101 == null) goto L9;
                r102.writeInt(1);     // Catch: Throwable -> L20
                r101.writeToParcel(r102, 0);     // Catch: Throwable -> L20
            L11:
                if (INVOKEINTERFACE_com_bytedance_mira_am_IPluginActivityManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 10, r102, r103, 0) == false) goto L13;
            L17:
                r103.readException();     // Catch: Throwable -> L20
                r103.recycle();
                r102.recycle();
                return;
            L13:
                if (Stub.getDefaultImpl() == null) goto L17;
                Stub.getDefaultImpl().serviceDestroy(r100, r101);     // Catch: Throwable -> L20
                r103.recycle();
                r102.recycle();
                return;
            L9:
                r102.writeInt(0);     // Catch: Throwable -> L20
                goto L11
            L6:
                r102.writeInt(0);     // Catch: Throwable -> L20
            L20:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Override // com.bytedance.mira.am.IPluginActivityManager
            public void activityOnNewIntent(ActivityInfo r100, ActivityInfo r101, Intent r102) throws RemoteException {
                Parcel r103 = Parcel.obtain();
                Parcel r104 = Parcel.obtain();
                r103.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L23
                if (r100 == null) goto L6;
                r103.writeInt(1);     // Catch: Throwable -> L23
                r100.writeToParcel(r103, 0);     // Catch: Throwable -> L23
            L7:
                if (r101 == null) goto L9;
                r103.writeInt(1);     // Catch: Throwable -> L23
                r101.writeToParcel(r103, 0);     // Catch: Throwable -> L23
            L10:
                if (r102 == null) goto L12;
                r103.writeInt(1);     // Catch: Throwable -> L23
                r102.writeToParcel(r103, 0);     // Catch: Throwable -> L23
            L14:
                if (INVOKEINTERFACE_com_bytedance_mira_am_IPluginActivityManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 7, r103, r104, 0) == false) goto L16;
            L20:
                r104.readException();     // Catch: Throwable -> L23
                r104.recycle();
                r103.recycle();
                return;
            L16:
                if (Stub.getDefaultImpl() == null) goto L20;
                Stub.getDefaultImpl().activityOnNewIntent(r100, r101, r102);     // Catch: Throwable -> L23
                r104.recycle();
                r103.recycle();
                return;
            L12:
                r103.writeInt(0);     // Catch: Throwable -> L23
                goto L14
            L9:
                r103.writeInt(0);     // Catch: Throwable -> L23
                goto L10
            L6:
                r103.writeInt(0);     // Catch: Throwable -> L23
            L23:
                th = move-exception;
                r104.recycle();
                r103.recycle();
                throw th;
            }

            @Override // com.bytedance.mira.am.IPluginActivityManager
            public void applicationCreated(ApplicationInfo r100, String r101, int r102, IApplicationThread r103) throws RemoteException {
                Parcel r104 = Parcel.obtain();
                Parcel r105 = Parcel.obtain();
                r104.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L21
                if (r100 == null) goto L6;
                r104.writeInt(1);     // Catch: Throwable -> L21
                r100.writeToParcel(r104, 0);     // Catch: Throwable -> L21
            L7:
                r104.writeString(r101);     // Catch: Throwable -> L21
                r104.writeInt(r102);     // Catch: Throwable -> L21
                if (r103 == null) goto L10;
                IBinder r106 = r103.asBinder();     // Catch: Throwable -> L21
            L11:
                r104.writeStrongBinder(r106);     // Catch: Throwable -> L21
                if (INVOKEINTERFACE_com_bytedance_mira_am_IPluginActivityManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 5, r104, r105, 0) == false) goto L14;
            L18:
                r105.readException();     // Catch: Throwable -> L21
                r105.recycle();
                r104.recycle();
                return;
            L14:
                if (Stub.getDefaultImpl() == null) goto L18;
                Stub.getDefaultImpl().applicationCreated(r100, r101, r102, r103);     // Catch: Throwable -> L21
                r105.recycle();
                r104.recycle();
                return;
            L10:
                r106 = null;
                goto L11
            L6:
                r104.writeInt(0);     // Catch: Throwable -> L21
            L21:
                th = move-exception;
                r105.recycle();
                r104.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_bytedance_mira_am_IPluginActivityManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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
            attachInterface(this, DESCRIPTOR);
        }

        public static IPluginActivityManager getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IPluginActivityManager asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof IPluginActivityManager) == false) goto L12;
            return (IPluginActivityManager) r101;
        L12:
            return new Proxy(r100);
        }

        public static boolean setDefaultImpl(IPluginActivityManager r100) {
            if (Proxy.sDefaultImpl != null) goto L7;
            if (r100 == null) goto L9;
            Proxy.sDefaultImpl = r100;
            return true;
        L9:
            return false;
        L7:
            return false;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r100, Parcel r101, Parcel r102, int r103) throws RemoteException {
            if (r100 == 1598968902) goto L135;
            ActivityInfo r104 = null;
            ServiceInfo r105 = null;
            ProviderInfo r106 = null;
            ActivityInfo r107 = null;
            ServiceInfo r108 = null;
            ActivityInfo r109 = null;
            ActivityInfo r110 = null;
            ServiceInfo r111 = null;
            ServiceInfo r112 = null;
            ActivityInfo r113 = null;
            Intent r114 = null;
            ActivityInfo r115 = null;
            ApplicationInfo r116 = null;
            ProviderInfo r117 = null;
            ServiceInfo r118 = null;
            ActivityInfo r119 = null;
            switch(r100) {
                case 1: goto L127;
                case 2: goto L119;
                case 3: goto L111;
                case 4: goto L103;
                case 5: goto L98;
                case 6: goto L89;
                case 7: goto L76;
                case 8: goto L67;
                case 9: goto L58;
                case 10: goto L49;
                case 11: goto L40;
                case 12: goto L35;
                case 13: goto L30;
                case 14: goto L25;
                case 15: goto L20;
                case 16: goto L18;
                case 17: goto L16;
                case 18: goto L8;
                default: goto L7;
            };
        L8:
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L11;
            r105 = (ServiceInfo) ServiceInfo.CREATOR.createFromParcel(r101);
        L11:
            ServiceInfo r120 = getTargetService(r105);
            r102.writeNoException();
            if (r120 == null) goto L14;
            r102.writeInt(1);
            r120.writeToParcel(r102, 1);
        L15:
            return true;
        L14:
            r102.writeInt(0);
            goto L15
        L16:
            r101.enforceInterface(DESCRIPTOR);
            shareStubProcess(r101.createStringArrayList());
            r102.writeNoException();
            return true;
        L18:
            r101.enforceInterface(DESCRIPTOR);
            runInStubProcess(r101.readString(), r101.readString());
            r102.writeNoException();
            return true;
        L20:
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L23;
            r106 = (ProviderInfo) ProviderInfo.CREATOR.createFromParcel(r101);
        L23:
            boolean r121 = isStubProvider(r106);
            r102.writeNoException();
            r102.writeInt(r121 ? 1 : 0);
            return true;
        L25:
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L28;
            r107 = (ActivityInfo) ActivityInfo.CREATOR.createFromParcel(r101);
        L28:
            boolean r122 = isStubReceiver(r107);
            r102.writeNoException();
            r102.writeInt(r122 ? 1 : 0);
            return true;
        L30:
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L33;
            r108 = (ServiceInfo) ServiceInfo.CREATOR.createFromParcel(r101);
        L33:
            boolean r123 = isStubService(r108);
            r102.writeNoException();
            r102.writeInt(r123 ? 1 : 0);
            return true;
        L35:
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L38;
            r109 = (ActivityInfo) ActivityInfo.CREATOR.createFromParcel(r101);
        L38:
            boolean r124 = isStubActivity(r109);
            r102.writeNoException();
            r102.writeInt(r124 ? 1 : 0);
            return true;
        L40:
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L43;
            ActivityInfo r125 = (ActivityInfo) ActivityInfo.CREATOR.createFromParcel(r101);
        L45:
            if (r101.readInt() == 0) goto L47;
            r110 = (ActivityInfo) ActivityInfo.CREATOR.createFromParcel(r101);
        L47:
            receiverFinished(r125, r110);
            r102.writeNoException();
            return true;
        L43:
            r125 = null;
            goto L45
        L49:
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L52;
            ServiceInfo r126 = (ServiceInfo) ServiceInfo.CREATOR.createFromParcel(r101);
        L54:
            if (r101.readInt() == 0) goto L56;
            r111 = (ServiceInfo) ServiceInfo.CREATOR.createFromParcel(r101);
        L56:
            serviceDestroy(r126, r111);
            r102.writeNoException();
            return true;
        L52:
            r126 = null;
            goto L54
        L58:
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L61;
            ServiceInfo r127 = (ServiceInfo) ServiceInfo.CREATOR.createFromParcel(r101);
        L63:
            if (r101.readInt() == 0) goto L65;
            r112 = (ServiceInfo) ServiceInfo.CREATOR.createFromParcel(r101);
        L65:
            serviceCreated(r127, r112);
            r102.writeNoException();
            return true;
        L61:
            r127 = null;
            goto L63
        L67:
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L70;
            ActivityInfo r128 = (ActivityInfo) ActivityInfo.CREATOR.createFromParcel(r101);
        L72:
            if (r101.readInt() == 0) goto L74;
            r113 = (ActivityInfo) ActivityInfo.CREATOR.createFromParcel(r101);
        L74:
            activityDestroy(r128, r113);
            r102.writeNoException();
            return true;
        L70:
            r128 = null;
            goto L72
        L76:
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L79;
            ActivityInfo r129 = (ActivityInfo) ActivityInfo.CREATOR.createFromParcel(r101);
        L81:
            if (r101.readInt() == 0) goto L83;
            ActivityInfo r130 = (ActivityInfo) ActivityInfo.CREATOR.createFromParcel(r101);
        L85:
            if (r101.readInt() == 0) goto L87;
            r114 = (Intent) Intent.CREATOR.createFromParcel(r101);
        L87:
            activityOnNewIntent(r129, r130, r114);
            r102.writeNoException();
            return true;
        L83:
            r130 = null;
            goto L85
        L79:
            r129 = null;
            goto L81
        L89:
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L92;
            ActivityInfo r131 = (ActivityInfo) ActivityInfo.CREATOR.createFromParcel(r101);
        L94:
            if (r101.readInt() == 0) goto L96;
            r115 = (ActivityInfo) ActivityInfo.CREATOR.createFromParcel(r101);
        L96:
            activityCreated(r131, r115);
            r102.writeNoException();
            return true;
        L92:
            r131 = null;
            goto L94
        L98:
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L101;
            r116 = (ApplicationInfo) ApplicationInfo.CREATOR.createFromParcel(r101);
        L101:
            applicationCreated(r116, r101.readString(), r101.readInt(), IApplicationThread.Stub.asInterface(r101.readStrongBinder()));
            r102.writeNoException();
            return true;
        L103:
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L106;
            r117 = (ProviderInfo) ProviderInfo.CREATOR.createFromParcel(r101);
        L106:
            ProviderInfo r132 = selectStubProvider(r117);
            r102.writeNoException();
            if (r132 == null) goto L109;
            r102.writeInt(1);
            r132.writeToParcel(r102, 1);
        L110:
            return true;
        L109:
            r102.writeInt(0);
            goto L110
        L111:
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L114;
            r118 = (ServiceInfo) ServiceInfo.CREATOR.createFromParcel(r101);
        L114:
            ServiceInfo r133 = selectStubService(r118);
            r102.writeNoException();
            if (r133 == null) goto L117;
            r102.writeInt(1);
            r133.writeToParcel(r102, 1);
        L118:
            return true;
        L117:
            r102.writeInt(0);
            goto L118
        L119:
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L122;
            r119 = (ActivityInfo) ActivityInfo.CREATOR.createFromParcel(r101);
        L122:
            ActivityInfo r134 = selectStubReceiver(r119);
            r102.writeNoException();
            if (r134 == null) goto L125;
            r102.writeInt(1);
            r134.writeToParcel(r102, 1);
        L126:
            return true;
        L125:
            r102.writeInt(0);
            goto L126
        L127:
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L130;
            r104 = (ActivityInfo) ActivityInfo.CREATOR.createFromParcel(r101);
        L130:
            ActivityInfo r135 = selectStubActivity(r104);
            r102.writeNoException();
            if (r135 == null) goto L133;
            r102.writeInt(1);
            r135.writeToParcel(r102, 1);
        L134:
            return true;
        L133:
            r102.writeInt(0);
            goto L134
        L7:
            return super.onTransact(r100, r101, r102, r103);
        L135:
            r102.writeString(DESCRIPTOR);
            return true;
        }
    }

    void activityCreated(ActivityInfo r100, ActivityInfo r101) throws RemoteException;

    void activityDestroy(ActivityInfo r100, ActivityInfo r101) throws RemoteException;

    void activityOnNewIntent(ActivityInfo r100, ActivityInfo r101, Intent r102) throws RemoteException;

    void applicationCreated(ApplicationInfo r100, String r101, int r102, IApplicationThread r103) throws RemoteException;

    ServiceInfo getTargetService(ServiceInfo r100) throws RemoteException;

    boolean isStubActivity(ActivityInfo r100) throws RemoteException;

    boolean isStubProvider(ProviderInfo r100) throws RemoteException;

    boolean isStubReceiver(ActivityInfo r100) throws RemoteException;

    boolean isStubService(ServiceInfo r100) throws RemoteException;

    void receiverFinished(ActivityInfo r100, ActivityInfo r101) throws RemoteException;

    void runInStubProcess(String r100, String r101) throws RemoteException;

    ActivityInfo selectStubActivity(ActivityInfo r100) throws RemoteException;

    ProviderInfo selectStubProvider(ProviderInfo r100) throws RemoteException;

    ActivityInfo selectStubReceiver(ActivityInfo r100) throws RemoteException;

    ServiceInfo selectStubService(ServiceInfo r100) throws RemoteException;

    void serviceCreated(ServiceInfo r100, ServiceInfo r101) throws RemoteException;

    void serviceDestroy(ServiceInfo r100, ServiceInfo r101) throws RemoteException;

    void shareStubProcess(List<String> r100) throws RemoteException;
}
