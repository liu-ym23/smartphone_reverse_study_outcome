package com.bytedance.mira.pm;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.bytedance.mira.plugin.Plugin;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import java.util.ArrayList;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes.dex */
public interface IPluginPackageManager extends IInterface {

    /* JADX INFO: loaded from: classes21.dex */
    public static class Default implements IPluginPackageManager {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.bytedance.mira.pm.IPluginPackageManager
        public boolean checkPluginInstalled(String r100) throws RemoteException {
            return false;
        }

        @Override // com.bytedance.mira.pm.IPluginPackageManager
        public int deletePackage(String r100, int r101) throws RemoteException {
            return 0;
        }

        @Override // com.bytedance.mira.pm.IPluginPackageManager
        public String generateContextPackageName(String r100) throws RemoteException {
            return null;
        }

        @Override // com.bytedance.mira.pm.IPluginPackageManager
        public ActivityInfo getActivityInfo(ComponentName r100, int r101) throws RemoteException {
            return null;
        }

        @Override // com.bytedance.mira.pm.IPluginPackageManager
        public ApplicationInfo getApplicationInfo(String r100, int r101) throws RemoteException {
            return null;
        }

        @Override // com.bytedance.mira.pm.IPluginPackageManager
        public List<String> getExistedPluginPackageNames() throws RemoteException {
            return null;
        }

        @Override // com.bytedance.mira.pm.IPluginPackageManager
        public List<String> getInstalledPackageNames() throws RemoteException {
            return null;
        }

        @Override // com.bytedance.mira.pm.IPluginPackageManager
        public int getInstalledPluginVersion(String r100) throws RemoteException {
            return 0;
        }

        @Override // com.bytedance.mira.pm.IPluginPackageManager
        public PackageInfo getPackageInfo(String r100, int r101) throws RemoteException {
            return null;
        }

        @Override // com.bytedance.mira.pm.IPluginPackageManager
        public Plugin getPlugin(String r100) throws RemoteException {
            return null;
        }

        @Override // com.bytedance.mira.pm.IPluginPackageManager
        public List<Plugin> getPluginList() throws RemoteException {
            return null;
        }

        @Override // com.bytedance.mira.pm.IPluginPackageManager
        public int getPluginStatus(String r100) throws RemoteException {
            return 0;
        }

        @Override // com.bytedance.mira.pm.IPluginPackageManager
        public ProviderInfo getProviderInfo(ComponentName r100, int r101) throws RemoteException {
            return null;
        }

        @Override // com.bytedance.mira.pm.IPluginPackageManager
        public List<ProviderInfo> getProviders(String r100, String r101, int r102) throws RemoteException {
            return null;
        }

        @Override // com.bytedance.mira.pm.IPluginPackageManager
        public ActivityInfo getReceiverInfo(ComponentName r100, int r101) throws RemoteException {
            return null;
        }

        @Override // com.bytedance.mira.pm.IPluginPackageManager
        public List<ReceiverInfo> getReceivers(String r100, int r101) throws RemoteException {
            return null;
        }

        @Override // com.bytedance.mira.pm.IPluginPackageManager
        public ServiceInfo getServiceInfo(ComponentName r100, int r101) throws RemoteException {
            return null;
        }

        @Override // com.bytedance.mira.pm.IPluginPackageManager
        public int installCompatPackage(String r100, String r101, String r102, boolean r103, int r104) throws RemoteException {
            return 0;
        }

        @Override // com.bytedance.mira.pm.IPluginPackageManager
        public int installPackage(String r100, boolean r101, int r102) throws RemoteException {
            return 0;
        }

        @Override // com.bytedance.mira.pm.IPluginPackageManager
        public boolean isPluginPackage(String r100) throws RemoteException {
            return false;
        }

        @Override // com.bytedance.mira.pm.IPluginPackageManager
        public List<ResolveInfo> queryIntentActivities(Intent r100, String r101, int r102) throws RemoteException {
            return null;
        }

        @Override // com.bytedance.mira.pm.IPluginPackageManager
        public List<ResolveInfo> queryIntentServices(Intent r100, String r101, int r102) throws RemoteException {
            return null;
        }

        @Override // com.bytedance.mira.pm.IPluginPackageManager
        public boolean resolve(Plugin r100) throws RemoteException {
            return false;
        }

        @Override // com.bytedance.mira.pm.IPluginPackageManager
        public ProviderInfo resolveContentProvider(String r100, int r101) throws RemoteException {
            return null;
        }

        @Override // com.bytedance.mira.pm.IPluginPackageManager
        public ResolveInfo resolveIntent(Intent r100, String r101, int r102) throws RemoteException {
            return null;
        }

        @Override // com.bytedance.mira.pm.IPluginPackageManager
        public ResolveInfo resolveService(Intent r100, String r101, int r102) throws RemoteException {
            return null;
        }

        @Override // com.bytedance.mira.pm.IPluginPackageManager
        public boolean shareResources(String r100) throws RemoteException {
            return false;
        }

        @Override // com.bytedance.mira.pm.IPluginPackageManager
        public boolean syncInstallCompatPackage(String r100, String r101, String r102, boolean r103, int r104) throws RemoteException {
            return false;
        }

        @Override // com.bytedance.mira.pm.IPluginPackageManager
        public boolean syncInstallPackage(String r100, boolean r101, int r102) throws RemoteException {
            return false;
        }
    }

    public static abstract class Stub extends Binder implements IPluginPackageManager {
        private static final String DESCRIPTOR = "com.bytedance.mira.pm.IPluginPackageManager";
        static final int TRANSACTION_checkPluginInstalled = 7;
        static final int TRANSACTION_deletePackage = 15;
        static final int TRANSACTION_generateContextPackageName = 10;
        static final int TRANSACTION_getActivityInfo = 19;
        static final int TRANSACTION_getApplicationInfo = 18;
        static final int TRANSACTION_getExistedPluginPackageNames = 8;
        static final int TRANSACTION_getInstalledPackageNames = 9;
        static final int TRANSACTION_getInstalledPluginVersion = 4;
        static final int TRANSACTION_getPackageInfo = 17;
        static final int TRANSACTION_getPlugin = 2;
        static final int TRANSACTION_getPluginList = 1;
        static final int TRANSACTION_getPluginStatus = 3;
        static final int TRANSACTION_getProviderInfo = 22;
        static final int TRANSACTION_getProviders = 29;
        static final int TRANSACTION_getReceiverInfo = 21;
        static final int TRANSACTION_getReceivers = 28;
        static final int TRANSACTION_getServiceInfo = 20;
        static final int TRANSACTION_installCompatPackage = 13;
        static final int TRANSACTION_installPackage = 11;
        static final int TRANSACTION_isPluginPackage = 5;
        static final int TRANSACTION_queryIntentActivities = 26;
        static final int TRANSACTION_queryIntentServices = 27;
        static final int TRANSACTION_resolve = 16;
        static final int TRANSACTION_resolveContentProvider = 25;
        static final int TRANSACTION_resolveIntent = 23;
        static final int TRANSACTION_resolveService = 24;
        static final int TRANSACTION_shareResources = 6;
        static final int TRANSACTION_syncInstallCompatPackage = 14;
        static final int TRANSACTION_syncInstallPackage = 12;

        public static class Proxy implements IPluginPackageManager {
            public static IPluginPackageManager sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.bytedance.mira.pm.IPluginPackageManager
            public List<String> getExistedPluginPackageNames() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_bytedance_mira_pm_IPluginPackageManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 8, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                ArrayList<String> r102 = r101.createStringArrayList();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                List<String> r103 = Stub.getDefaultImpl().getExistedPluginPackageNames();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r103;
            L13:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.bytedance.mira.pm.IPluginPackageManager
            public List<String> getInstalledPackageNames() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_bytedance_mira_pm_IPluginPackageManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 9, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                ArrayList<String> r102 = r101.createStringArrayList();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                List<String> r103 = Stub.getDefaultImpl().getInstalledPackageNames();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r103;
            L13:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.bytedance.mira.pm.IPluginPackageManager
            public List<Plugin> getPluginList() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_bytedance_mira_pm_IPluginPackageManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                ArrayList r102 = r101.createTypedArrayList(Plugin.CREATOR);     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                List<Plugin> r103 = Stub.getDefaultImpl().getPluginList();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r103;
            L13:
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

            @Override // com.bytedance.mira.pm.IPluginPackageManager
            public boolean checkPluginInstalled(String r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r101.writeString(r100);     // Catch: Throwable -> L15
                boolean r103 = false;
                if (INVOKEINTERFACE_com_bytedance_mira_pm_IPluginPackageManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 7, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L15
                if (r102.readInt() == 0) goto L13;
                r103 = true;
            L13:
                r102.recycle();
                r101.recycle();
                return r103;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r104 = Stub.getDefaultImpl().checkPluginInstalled(r100);     // Catch: Throwable -> L15
                r102.recycle();
                r101.recycle();
                return r104;
            L15:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.bytedance.mira.pm.IPluginPackageManager
            public String generateContextPackageName(String r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r101.writeString(r100);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_bytedance_mira_pm_IPluginPackageManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 10, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L13
                String r103 = r102.readString();     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return r103;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                String r104 = Stub.getDefaultImpl().generateContextPackageName(r100);     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return r104;
            L13:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.bytedance.mira.pm.IPluginPackageManager
            public int getInstalledPluginVersion(String r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r101.writeString(r100);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_bytedance_mira_pm_IPluginPackageManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L13
                int r103 = r102.readInt();     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return r103;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r104 = Stub.getDefaultImpl().getInstalledPluginVersion(r100);     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return r104;
            L13:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.bytedance.mira.pm.IPluginPackageManager
            public Plugin getPlugin(String r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r101.writeString(r100);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_bytedance_mira_pm_IPluginPackageManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L17
                if (r102.readInt() == 0) goto L14;
                Plugin r103 = Plugin.CREATOR.createFromParcel(r102);     // Catch: Throwable -> L17
            L15:
                r102.recycle();
                r101.recycle();
                return r103;
            L14:
                r103 = null;
                goto L15
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Plugin r104 = Stub.getDefaultImpl().getPlugin(r100);     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return r104;
            L17:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.bytedance.mira.pm.IPluginPackageManager
            public int getPluginStatus(String r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r101.writeString(r100);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_bytedance_mira_pm_IPluginPackageManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L13
                int r103 = r102.readInt();     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return r103;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r104 = Stub.getDefaultImpl().getPluginStatus(r100);     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return r104;
            L13:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.bytedance.mira.pm.IPluginPackageManager
            public boolean isPluginPackage(String r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r101.writeString(r100);     // Catch: Throwable -> L15
                boolean r103 = false;
                if (INVOKEINTERFACE_com_bytedance_mira_pm_IPluginPackageManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 5, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L15
                if (r102.readInt() == 0) goto L13;
                r103 = true;
            L13:
                r102.recycle();
                r101.recycle();
                return r103;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r104 = Stub.getDefaultImpl().isPluginPackage(r100);     // Catch: Throwable -> L15
                r102.recycle();
                r101.recycle();
                return r104;
            L15:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.bytedance.mira.pm.IPluginPackageManager
            public boolean resolve(Plugin r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                boolean r103 = true;
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L20
                r100.writeToParcel(r101, 0);     // Catch: Throwable -> L20
            L8:
                if (INVOKEINTERFACE_com_bytedance_mira_pm_IPluginPackageManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 16, r101, r102, 0) == false) goto L10;
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
                boolean r104 = Stub.getDefaultImpl().resolve(r100);     // Catch: Throwable -> L20
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

            @Override // com.bytedance.mira.pm.IPluginPackageManager
            public boolean shareResources(String r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r101.writeString(r100);     // Catch: Throwable -> L15
                boolean r103 = false;
                if (INVOKEINTERFACE_com_bytedance_mira_pm_IPluginPackageManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 6, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L15
                if (r102.readInt() == 0) goto L13;
                r103 = true;
            L13:
                r102.recycle();
                r101.recycle();
                return r103;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r104 = Stub.getDefaultImpl().shareResources(r100);     // Catch: Throwable -> L15
                r102.recycle();
                r101.recycle();
                return r104;
            L15:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.bytedance.mira.pm.IPluginPackageManager
            public int deletePackage(String r100, int r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r102.writeString(r100);     // Catch: Throwable -> L13
                r102.writeInt(r101);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_bytedance_mira_pm_IPluginPackageManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 15, r102, r103, 0) == false) goto L6;
            L10:
                r103.readException();     // Catch: Throwable -> L13
                int r104 = r103.readInt();     // Catch: Throwable -> L13
                r103.recycle();
                r102.recycle();
                return r104;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r105 = Stub.getDefaultImpl().deletePackage(r100, r101);     // Catch: Throwable -> L13
                r103.recycle();
                r102.recycle();
                return r105;
            L13:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Override // com.bytedance.mira.pm.IPluginPackageManager
            public ActivityInfo getActivityInfo(ComponentName r100, int r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L21
                if (r100 == null) goto L6;
                r102.writeInt(1);     // Catch: Throwable -> L21
                r100.writeToParcel(r102, 0);     // Catch: Throwable -> L21
            L7:
                r102.writeInt(r101);     // Catch: Throwable -> L21
                if (INVOKEINTERFACE_com_bytedance_mira_pm_IPluginPackageManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 19, r102, r103, 0) == false) goto L10;
            L14:
                r103.readException();     // Catch: Throwable -> L21
                if (r103.readInt() == 0) goto L18;
                ActivityInfo r104 = (ActivityInfo) ActivityInfo.CREATOR.createFromParcel(r103);     // Catch: Throwable -> L21
            L19:
                r103.recycle();
                r102.recycle();
                return r104;
            L18:
                r104 = null;
                goto L19
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                ActivityInfo r105 = Stub.getDefaultImpl().getActivityInfo(r100, r101);     // Catch: Throwable -> L21
                r103.recycle();
                r102.recycle();
                return r105;
            L6:
                r102.writeInt(0);     // Catch: Throwable -> L21
            L21:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Override // com.bytedance.mira.pm.IPluginPackageManager
            public ApplicationInfo getApplicationInfo(String r100, int r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r102.writeString(r100);     // Catch: Throwable -> L17
                r102.writeInt(r101);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_bytedance_mira_pm_IPluginPackageManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 18, r102, r103, 0) == false) goto L6;
            L10:
                r103.readException();     // Catch: Throwable -> L17
                if (r103.readInt() == 0) goto L14;
                ApplicationInfo r104 = (ApplicationInfo) ApplicationInfo.CREATOR.createFromParcel(r103);     // Catch: Throwable -> L17
            L15:
                r103.recycle();
                r102.recycle();
                return r104;
            L14:
                r104 = null;
                goto L15
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                ApplicationInfo r105 = Stub.getDefaultImpl().getApplicationInfo(r100, r101);     // Catch: Throwable -> L17
                r103.recycle();
                r102.recycle();
                return r105;
            L17:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Override // com.bytedance.mira.pm.IPluginPackageManager
            public PackageInfo getPackageInfo(String r100, int r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r102.writeString(r100);     // Catch: Throwable -> L17
                r102.writeInt(r101);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_bytedance_mira_pm_IPluginPackageManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 17, r102, r103, 0) == false) goto L6;
            L10:
                r103.readException();     // Catch: Throwable -> L17
                if (r103.readInt() == 0) goto L14;
                PackageInfo r104 = (PackageInfo) PackageInfo.CREATOR.createFromParcel(r103);     // Catch: Throwable -> L17
            L15:
                r103.recycle();
                r102.recycle();
                return r104;
            L14:
                r104 = null;
                goto L15
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                PackageInfo r105 = Stub.getDefaultImpl().getPackageInfo(r100, r101);     // Catch: Throwable -> L17
                r103.recycle();
                r102.recycle();
                return r105;
            L17:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Override // com.bytedance.mira.pm.IPluginPackageManager
            public ProviderInfo getProviderInfo(ComponentName r100, int r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L21
                if (r100 == null) goto L6;
                r102.writeInt(1);     // Catch: Throwable -> L21
                r100.writeToParcel(r102, 0);     // Catch: Throwable -> L21
            L7:
                r102.writeInt(r101);     // Catch: Throwable -> L21
                if (INVOKEINTERFACE_com_bytedance_mira_pm_IPluginPackageManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 22, r102, r103, 0) == false) goto L10;
            L14:
                r103.readException();     // Catch: Throwable -> L21
                if (r103.readInt() == 0) goto L18;
                ProviderInfo r104 = (ProviderInfo) ProviderInfo.CREATOR.createFromParcel(r103);     // Catch: Throwable -> L21
            L19:
                r103.recycle();
                r102.recycle();
                return r104;
            L18:
                r104 = null;
                goto L19
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                ProviderInfo r105 = Stub.getDefaultImpl().getProviderInfo(r100, r101);     // Catch: Throwable -> L21
                r103.recycle();
                r102.recycle();
                return r105;
            L6:
                r102.writeInt(0);     // Catch: Throwable -> L21
            L21:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Override // com.bytedance.mira.pm.IPluginPackageManager
            public ActivityInfo getReceiverInfo(ComponentName r100, int r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L21
                if (r100 == null) goto L6;
                r102.writeInt(1);     // Catch: Throwable -> L21
                r100.writeToParcel(r102, 0);     // Catch: Throwable -> L21
            L7:
                r102.writeInt(r101);     // Catch: Throwable -> L21
                if (INVOKEINTERFACE_com_bytedance_mira_pm_IPluginPackageManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 21, r102, r103, 0) == false) goto L10;
            L14:
                r103.readException();     // Catch: Throwable -> L21
                if (r103.readInt() == 0) goto L18;
                ActivityInfo r104 = (ActivityInfo) ActivityInfo.CREATOR.createFromParcel(r103);     // Catch: Throwable -> L21
            L19:
                r103.recycle();
                r102.recycle();
                return r104;
            L18:
                r104 = null;
                goto L19
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                ActivityInfo r105 = Stub.getDefaultImpl().getReceiverInfo(r100, r101);     // Catch: Throwable -> L21
                r103.recycle();
                r102.recycle();
                return r105;
            L6:
                r102.writeInt(0);     // Catch: Throwable -> L21
            L21:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Override // com.bytedance.mira.pm.IPluginPackageManager
            public List<ReceiverInfo> getReceivers(String r100, int r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r102.writeString(r100);     // Catch: Throwable -> L13
                r102.writeInt(r101);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_bytedance_mira_pm_IPluginPackageManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 28, r102, r103, 0) == false) goto L6;
            L10:
                r103.readException();     // Catch: Throwable -> L13
                ArrayList r104 = r103.createTypedArrayList(ReceiverInfo.CREATOR);     // Catch: Throwable -> L13
                r103.recycle();
                r102.recycle();
                return r104;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                List<ReceiverInfo> r105 = Stub.getDefaultImpl().getReceivers(r100, r101);     // Catch: Throwable -> L13
                r103.recycle();
                r102.recycle();
                return r105;
            L13:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Override // com.bytedance.mira.pm.IPluginPackageManager
            public ServiceInfo getServiceInfo(ComponentName r100, int r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L21
                if (r100 == null) goto L6;
                r102.writeInt(1);     // Catch: Throwable -> L21
                r100.writeToParcel(r102, 0);     // Catch: Throwable -> L21
            L7:
                r102.writeInt(r101);     // Catch: Throwable -> L21
                if (INVOKEINTERFACE_com_bytedance_mira_pm_IPluginPackageManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 20, r102, r103, 0) == false) goto L10;
            L14:
                r103.readException();     // Catch: Throwable -> L21
                if (r103.readInt() == 0) goto L18;
                ServiceInfo r104 = (ServiceInfo) ServiceInfo.CREATOR.createFromParcel(r103);     // Catch: Throwable -> L21
            L19:
                r103.recycle();
                r102.recycle();
                return r104;
            L18:
                r104 = null;
                goto L19
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                ServiceInfo r105 = Stub.getDefaultImpl().getServiceInfo(r100, r101);     // Catch: Throwable -> L21
                r103.recycle();
                r102.recycle();
                return r105;
            L6:
                r102.writeInt(0);     // Catch: Throwable -> L21
            L21:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Override // com.bytedance.mira.pm.IPluginPackageManager
            public ProviderInfo resolveContentProvider(String r100, int r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r102.writeString(r100);     // Catch: Throwable -> L17
                r102.writeInt(r101);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_bytedance_mira_pm_IPluginPackageManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 25, r102, r103, 0) == false) goto L6;
            L10:
                r103.readException();     // Catch: Throwable -> L17
                if (r103.readInt() == 0) goto L14;
                ProviderInfo r104 = (ProviderInfo) ProviderInfo.CREATOR.createFromParcel(r103);     // Catch: Throwable -> L17
            L15:
                r103.recycle();
                r102.recycle();
                return r104;
            L14:
                r104 = null;
                goto L15
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                ProviderInfo r105 = Stub.getDefaultImpl().resolveContentProvider(r100, r101);     // Catch: Throwable -> L17
                r103.recycle();
                r102.recycle();
                return r105;
            L17:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Override // com.bytedance.mira.pm.IPluginPackageManager
            public List<ProviderInfo> getProviders(String r100, String r101, int r102) throws RemoteException {
                Parcel r103 = Parcel.obtain();
                Parcel r104 = Parcel.obtain();
                r103.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r103.writeString(r100);     // Catch: Throwable -> L13
                r103.writeString(r101);     // Catch: Throwable -> L13
                r103.writeInt(r102);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_bytedance_mira_pm_IPluginPackageManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 29, r103, r104, 0) == false) goto L6;
            L10:
                r104.readException();     // Catch: Throwable -> L13
                ArrayList r105 = r104.createTypedArrayList(ProviderInfo.CREATOR);     // Catch: Throwable -> L13
                r104.recycle();
                r103.recycle();
                return r105;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                List<ProviderInfo> r106 = Stub.getDefaultImpl().getProviders(r100, r101, r102);     // Catch: Throwable -> L13
                r104.recycle();
                r103.recycle();
                return r106;
            L13:
                th = move-exception;
                r104.recycle();
                r103.recycle();
                throw th;
            }

            @Override // com.bytedance.mira.pm.IPluginPackageManager
            public int installPackage(String r100, boolean r101, int r102) throws RemoteException {
                Parcel r103 = Parcel.obtain();
                Parcel r104 = Parcel.obtain();
                r103.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r103.writeString(r100);     // Catch: Throwable -> L17
                if (r101 == false) goto L6;
                int r105 = 1;
            L7:
                r103.writeInt(r105);     // Catch: Throwable -> L17
                r103.writeInt(r102);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_bytedance_mira_pm_IPluginPackageManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 11, r103, r104, 0) == false) goto L10;
            L14:
                r104.readException();     // Catch: Throwable -> L17
                int r106 = r104.readInt();     // Catch: Throwable -> L17
                r104.recycle();
                r103.recycle();
                return r106;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                int r107 = Stub.getDefaultImpl().installPackage(r100, r101, r102);     // Catch: Throwable -> L17
                r104.recycle();
                r103.recycle();
                return r107;
            L6:
                r105 = 0;
            L17:
                th = move-exception;
                r104.recycle();
                r103.recycle();
                throw th;
            }

            @Override // com.bytedance.mira.pm.IPluginPackageManager
            public List<ResolveInfo> queryIntentActivities(Intent r100, String r101, int r102) throws RemoteException {
                Parcel r103 = Parcel.obtain();
                Parcel r104 = Parcel.obtain();
                r103.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r100 == null) goto L6;
                r103.writeInt(1);     // Catch: Throwable -> L17
                r100.writeToParcel(r103, 0);     // Catch: Throwable -> L17
            L7:
                r103.writeString(r101);     // Catch: Throwable -> L17
                r103.writeInt(r102);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_bytedance_mira_pm_IPluginPackageManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 26, r103, r104, 0) == false) goto L10;
            L14:
                r104.readException();     // Catch: Throwable -> L17
                ArrayList r105 = r104.createTypedArrayList(ResolveInfo.CREATOR);     // Catch: Throwable -> L17
                r104.recycle();
                r103.recycle();
                return r105;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                List<ResolveInfo> r106 = Stub.getDefaultImpl().queryIntentActivities(r100, r101, r102);     // Catch: Throwable -> L17
                r104.recycle();
                r103.recycle();
                return r106;
            L6:
                r103.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r104.recycle();
                r103.recycle();
                throw th;
            }

            @Override // com.bytedance.mira.pm.IPluginPackageManager
            public List<ResolveInfo> queryIntentServices(Intent r100, String r101, int r102) throws RemoteException {
                Parcel r103 = Parcel.obtain();
                Parcel r104 = Parcel.obtain();
                r103.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r100 == null) goto L6;
                r103.writeInt(1);     // Catch: Throwable -> L17
                r100.writeToParcel(r103, 0);     // Catch: Throwable -> L17
            L7:
                r103.writeString(r101);     // Catch: Throwable -> L17
                r103.writeInt(r102);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_bytedance_mira_pm_IPluginPackageManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 27, r103, r104, 0) == false) goto L10;
            L14:
                r104.readException();     // Catch: Throwable -> L17
                ArrayList r105 = r104.createTypedArrayList(ResolveInfo.CREATOR);     // Catch: Throwable -> L17
                r104.recycle();
                r103.recycle();
                return r105;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                List<ResolveInfo> r106 = Stub.getDefaultImpl().queryIntentServices(r100, r101, r102);     // Catch: Throwable -> L17
                r104.recycle();
                r103.recycle();
                return r106;
            L6:
                r103.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r104.recycle();
                r103.recycle();
                throw th;
            }

            @Override // com.bytedance.mira.pm.IPluginPackageManager
            public ResolveInfo resolveIntent(Intent r100, String r101, int r102) throws RemoteException {
                Parcel r103 = Parcel.obtain();
                Parcel r104 = Parcel.obtain();
                r103.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L21
                if (r100 == null) goto L6;
                r103.writeInt(1);     // Catch: Throwable -> L21
                r100.writeToParcel(r103, 0);     // Catch: Throwable -> L21
            L7:
                r103.writeString(r101);     // Catch: Throwable -> L21
                r103.writeInt(r102);     // Catch: Throwable -> L21
                if (INVOKEINTERFACE_com_bytedance_mira_pm_IPluginPackageManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 23, r103, r104, 0) == false) goto L10;
            L14:
                r104.readException();     // Catch: Throwable -> L21
                if (r104.readInt() == 0) goto L18;
                ResolveInfo r105 = (ResolveInfo) ResolveInfo.CREATOR.createFromParcel(r104);     // Catch: Throwable -> L21
            L19:
                r104.recycle();
                r103.recycle();
                return r105;
            L18:
                r105 = null;
                goto L19
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                ResolveInfo r106 = Stub.getDefaultImpl().resolveIntent(r100, r101, r102);     // Catch: Throwable -> L21
                r104.recycle();
                r103.recycle();
                return r106;
            L6:
                r103.writeInt(0);     // Catch: Throwable -> L21
            L21:
                th = move-exception;
                r104.recycle();
                r103.recycle();
                throw th;
            }

            @Override // com.bytedance.mira.pm.IPluginPackageManager
            public ResolveInfo resolveService(Intent r100, String r101, int r102) throws RemoteException {
                Parcel r103 = Parcel.obtain();
                Parcel r104 = Parcel.obtain();
                r103.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L21
                if (r100 == null) goto L6;
                r103.writeInt(1);     // Catch: Throwable -> L21
                r100.writeToParcel(r103, 0);     // Catch: Throwable -> L21
            L7:
                r103.writeString(r101);     // Catch: Throwable -> L21
                r103.writeInt(r102);     // Catch: Throwable -> L21
                if (INVOKEINTERFACE_com_bytedance_mira_pm_IPluginPackageManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 24, r103, r104, 0) == false) goto L10;
            L14:
                r104.readException();     // Catch: Throwable -> L21
                if (r104.readInt() == 0) goto L18;
                ResolveInfo r105 = (ResolveInfo) ResolveInfo.CREATOR.createFromParcel(r104);     // Catch: Throwable -> L21
            L19:
                r104.recycle();
                r103.recycle();
                return r105;
            L18:
                r105 = null;
                goto L19
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                ResolveInfo r106 = Stub.getDefaultImpl().resolveService(r100, r101, r102);     // Catch: Throwable -> L21
                r104.recycle();
                r103.recycle();
                return r106;
            L6:
                r103.writeInt(0);     // Catch: Throwable -> L21
            L21:
                th = move-exception;
                r104.recycle();
                r103.recycle();
                throw th;
            }

            @Override // com.bytedance.mira.pm.IPluginPackageManager
            public boolean syncInstallPackage(String r100, boolean r101, int r102) throws RemoteException {
                Parcel r103 = Parcel.obtain();
                Parcel r104 = Parcel.obtain();
                r103.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                r103.writeString(r100);     // Catch: Throwable -> L20
                boolean r105 = true;
                if (r101 == false) goto L6;
                int r106 = 1;
            L7:
                r103.writeInt(r106);     // Catch: Throwable -> L20
                r103.writeInt(r102);     // Catch: Throwable -> L20
                if (INVOKEINTERFACE_com_bytedance_mira_pm_IPluginPackageManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 12, r103, r104, 0) == false) goto L10;
            L14:
                r104.readException();     // Catch: Throwable -> L20
                if (r104.readInt() != 0) goto L18;
                r105 = false;
            L18:
                r104.recycle();
                r103.recycle();
                return r105;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                boolean r107 = Stub.getDefaultImpl().syncInstallPackage(r100, r101, r102);     // Catch: Throwable -> L20
                r104.recycle();
                r103.recycle();
                return r107;
            L6:
                r106 = 0;
            L20:
                th = move-exception;
                r104.recycle();
                r103.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_bytedance_mira_pm_IPluginPackageManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

            @Override // com.bytedance.mira.pm.IPluginPackageManager
            public int installCompatPackage(String r110, String r111, String r112, boolean r113, int r114) throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r100.writeString(r110);     // Catch: Throwable -> L17
                r100.writeString(r111);     // Catch: Throwable -> L17
                r100.writeString(r112);     // Catch: Throwable -> L17
                if (r113 == false) goto L6;
                int r102 = 1;
            L7:
                r100.writeInt(r102);     // Catch: Throwable -> L17
                r100.writeInt(r114);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_bytedance_mira_pm_IPluginPackageManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 13, r100, r101, 0) == false) goto L10;
            L14:
                r101.readException();     // Catch: Throwable -> L17
                int r115 = r101.readInt();     // Catch: Throwable -> L17
                r101.recycle();
                r100.recycle();
                return r115;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                int r116 = Stub.getDefaultImpl().installCompatPackage(r110, r111, r112, r113, r114);     // Catch: Throwable -> L17
                r101.recycle();
                r100.recycle();
                return r116;
            L6:
                r102 = 0;
            L17:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.bytedance.mira.pm.IPluginPackageManager
            public boolean syncInstallCompatPackage(String r110, String r111, String r112, boolean r113, int r114) throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L24
                r100.writeString(r110);     // Catch: Throwable -> L24
                r100.writeString(r111);     // Catch: Throwable -> L24
                r100.writeString(r112);     // Catch: Throwable -> L24
                boolean r102 = true;
                if (r113 == false) goto L6;
                int r103 = 1;
            L7:
                r100.writeInt(r103);     // Catch: Throwable -> L24
                r100.writeInt(r114);     // Catch: Throwable -> L24
            L22:
                th = th;
            L26:
                r101.recycle();
                r100.recycle();
                throw th;
            L10:
                if (INVOKEINTERFACE_com_bytedance_mira_pm_IPluginPackageManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 14, r100, r101, 0) == false) goto L12;
            L16:
                r101.readException();     // Catch: Throwable -> L22
                if (r101.readInt() != 0) goto L20;
                r102 = false;
            L20:
                r101.recycle();
                r100.recycle();
                return r102;
            L12:
                if (Stub.getDefaultImpl() == null) goto L16;
                boolean r104 = Stub.getDefaultImpl().syncInstallCompatPackage(r110, r111, r112, r113, r114);     // Catch: Throwable -> L22
                r101.recycle();
                r100.recycle();
                return r104;
            L6:
                r103 = 0;
            L24:
                th = th;
                goto L26
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IPluginPackageManager getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IPluginPackageManager asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof IPluginPackageManager) == false) goto L12;
            return (IPluginPackageManager) r101;
        L12:
            return new Proxy(r100);
        }

        public static boolean setDefaultImpl(IPluginPackageManager r100) {
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
        public boolean onTransact(int r100, Parcel r110, Parcel r111, int r112) throws RemoteException {
            if (r100 == 1598968902) goto L137;
            Plugin r101 = null;
            Intent r102 = null;
            Intent r103 = null;
            Intent r104 = null;
            Intent r105 = null;
            ComponentName r106 = null;
            ComponentName r107 = null;
            ComponentName r108 = null;
            ComponentName r109 = null;
            boolean r113 = false;
            switch(r100) {
                case 1: goto L135;
                case 2: goto L130;
                case 3: goto L128;
                case 4: goto L126;
                case 5: goto L124;
                case 6: goto L122;
                case 7: goto L120;
                case 8: goto L118;
                case 9: goto L116;
                case 10: goto L114;
                case 11: goto L109;
                case 12: goto L104;
                case 13: goto L98;
                case 14: goto L92;
                case 15: goto L90;
                case 16: goto L85;
                case 17: goto L80;
                case 18: goto L75;
                case 19: goto L67;
                case 20: goto L59;
                case 21: goto L51;
                case 22: goto L43;
                case 23: goto L35;
                case 24: goto L27;
                case 25: goto L22;
                case 26: goto L17;
                case 27: goto L12;
                case 28: goto L10;
                case 29: goto L8;
                default: goto L7;
            };
        L8:
            r110.enforceInterface(DESCRIPTOR);
            List<ProviderInfo> r114 = getProviders(r110.readString(), r110.readString(), r110.readInt());
            r111.writeNoException();
            r111.writeTypedList(r114);
            return true;
        L10:
            r110.enforceInterface(DESCRIPTOR);
            List<ReceiverInfo> r115 = getReceivers(r110.readString(), r110.readInt());
            r111.writeNoException();
            r111.writeTypedList(r115);
            return true;
        L12:
            r110.enforceInterface(DESCRIPTOR);
            if (r110.readInt() == 0) goto L15;
            r102 = (Intent) Intent.CREATOR.createFromParcel(r110);
        L15:
            List<ResolveInfo> r116 = queryIntentServices(r102, r110.readString(), r110.readInt());
            r111.writeNoException();
            r111.writeTypedList(r116);
            return true;
        L17:
            r110.enforceInterface(DESCRIPTOR);
            if (r110.readInt() == 0) goto L20;
            r103 = (Intent) Intent.CREATOR.createFromParcel(r110);
        L20:
            List<ResolveInfo> r117 = queryIntentActivities(r103, r110.readString(), r110.readInt());
            r111.writeNoException();
            r111.writeTypedList(r117);
            return true;
        L22:
            r110.enforceInterface(DESCRIPTOR);
            ProviderInfo r118 = resolveContentProvider(r110.readString(), r110.readInt());
            r111.writeNoException();
            if (r118 == null) goto L25;
            r111.writeInt(1);
            r118.writeToParcel(r111, 1);
        L26:
            return true;
        L25:
            r111.writeInt(0);
            goto L26
        L27:
            r110.enforceInterface(DESCRIPTOR);
            if (r110.readInt() == 0) goto L30;
            r104 = (Intent) Intent.CREATOR.createFromParcel(r110);
        L30:
            ResolveInfo r119 = resolveService(r104, r110.readString(), r110.readInt());
            r111.writeNoException();
            if (r119 == null) goto L33;
            r111.writeInt(1);
            r119.writeToParcel(r111, 1);
        L34:
            return true;
        L33:
            r111.writeInt(0);
            goto L34
        L35:
            r110.enforceInterface(DESCRIPTOR);
            if (r110.readInt() == 0) goto L38;
            r105 = (Intent) Intent.CREATOR.createFromParcel(r110);
        L38:
            ResolveInfo r120 = resolveIntent(r105, r110.readString(), r110.readInt());
            r111.writeNoException();
            if (r120 == null) goto L41;
            r111.writeInt(1);
            r120.writeToParcel(r111, 1);
        L42:
            return true;
        L41:
            r111.writeInt(0);
            goto L42
        L43:
            r110.enforceInterface(DESCRIPTOR);
            if (r110.readInt() == 0) goto L46;
            r106 = (ComponentName) ComponentName.CREATOR.createFromParcel(r110);
        L46:
            ProviderInfo r121 = getProviderInfo(r106, r110.readInt());
            r111.writeNoException();
            if (r121 == null) goto L49;
            r111.writeInt(1);
            r121.writeToParcel(r111, 1);
        L50:
            return true;
        L49:
            r111.writeInt(0);
            goto L50
        L51:
            r110.enforceInterface(DESCRIPTOR);
            if (r110.readInt() == 0) goto L54;
            r107 = (ComponentName) ComponentName.CREATOR.createFromParcel(r110);
        L54:
            ActivityInfo r122 = getReceiverInfo(r107, r110.readInt());
            r111.writeNoException();
            if (r122 == null) goto L57;
            r111.writeInt(1);
            r122.writeToParcel(r111, 1);
        L58:
            return true;
        L57:
            r111.writeInt(0);
            goto L58
        L59:
            r110.enforceInterface(DESCRIPTOR);
            if (r110.readInt() == 0) goto L62;
            r108 = (ComponentName) ComponentName.CREATOR.createFromParcel(r110);
        L62:
            ServiceInfo r123 = getServiceInfo(r108, r110.readInt());
            r111.writeNoException();
            if (r123 == null) goto L65;
            r111.writeInt(1);
            r123.writeToParcel(r111, 1);
        L66:
            return true;
        L65:
            r111.writeInt(0);
            goto L66
        L67:
            r110.enforceInterface(DESCRIPTOR);
            if (r110.readInt() == 0) goto L70;
            r109 = (ComponentName) ComponentName.CREATOR.createFromParcel(r110);
        L70:
            ActivityInfo r124 = getActivityInfo(r109, r110.readInt());
            r111.writeNoException();
            if (r124 == null) goto L73;
            r111.writeInt(1);
            r124.writeToParcel(r111, 1);
        L74:
            return true;
        L73:
            r111.writeInt(0);
            goto L74
        L75:
            r110.enforceInterface(DESCRIPTOR);
            ApplicationInfo r125 = getApplicationInfo(r110.readString(), r110.readInt());
            r111.writeNoException();
            if (r125 == null) goto L78;
            r111.writeInt(1);
            r125.writeToParcel(r111, 1);
        L79:
            return true;
        L78:
            r111.writeInt(0);
            goto L79
        L80:
            r110.enforceInterface(DESCRIPTOR);
            PackageInfo r126 = getPackageInfo(r110.readString(), r110.readInt());
            r111.writeNoException();
            if (r126 == null) goto L83;
            r111.writeInt(1);
            r126.writeToParcel(r111, 1);
        L84:
            return true;
        L83:
            r111.writeInt(0);
            goto L84
        L85:
            r110.enforceInterface(DESCRIPTOR);
            if (r110.readInt() == 0) goto L88;
            r101 = Plugin.CREATOR.createFromParcel(r110);
        L88:
            boolean r127 = resolve(r101);
            r111.writeNoException();
            r111.writeInt(r127 ? 1 : 0);
            return true;
        L90:
            r110.enforceInterface(DESCRIPTOR);
            int r128 = deletePackage(r110.readString(), r110.readInt());
            r111.writeNoException();
            r111.writeInt(r128);
            return true;
        L92:
            r110.enforceInterface(DESCRIPTOR);
            String r129 = r110.readString();
            String r130 = r110.readString();
            String r131 = r110.readString();
            if (r110.readInt() == 0) goto L95;
            boolean r132 = true;
        L96:
            boolean r133 = syncInstallCompatPackage(r129, r130, r131, r132, r110.readInt());
            r111.writeNoException();
            r111.writeInt(r133 ? 1 : 0);
            return true;
        L95:
            r132 = false;
            goto L96
        L98:
            r110.enforceInterface(DESCRIPTOR);
            String r134 = r110.readString();
            String r135 = r110.readString();
            String r136 = r110.readString();
            if (r110.readInt() == 0) goto L101;
            boolean r137 = true;
        L102:
            int r138 = installCompatPackage(r134, r135, r136, r137, r110.readInt());
            r111.writeNoException();
            r111.writeInt(r138);
            return true;
        L101:
            r137 = false;
            goto L102
        L104:
            r110.enforceInterface(DESCRIPTOR);
            String r139 = r110.readString();
            if (r110.readInt() == 0) goto L107;
            r113 = true;
        L107:
            boolean r140 = syncInstallPackage(r139, r113, r110.readInt());
            r111.writeNoException();
            r111.writeInt(r140 ? 1 : 0);
            return true;
        L109:
            r110.enforceInterface(DESCRIPTOR);
            String r141 = r110.readString();
            if (r110.readInt() == 0) goto L112;
            r113 = true;
        L112:
            int r142 = installPackage(r141, r113, r110.readInt());
            r111.writeNoException();
            r111.writeInt(r142);
            return true;
        L114:
            r110.enforceInterface(DESCRIPTOR);
            String r143 = generateContextPackageName(r110.readString());
            r111.writeNoException();
            r111.writeString(r143);
            return true;
        L116:
            r110.enforceInterface(DESCRIPTOR);
            List<String> r144 = getInstalledPackageNames();
            r111.writeNoException();
            r111.writeStringList(r144);
            return true;
        L118:
            r110.enforceInterface(DESCRIPTOR);
            List<String> r145 = getExistedPluginPackageNames();
            r111.writeNoException();
            r111.writeStringList(r145);
            return true;
        L120:
            r110.enforceInterface(DESCRIPTOR);
            boolean r146 = checkPluginInstalled(r110.readString());
            r111.writeNoException();
            r111.writeInt(r146 ? 1 : 0);
            return true;
        L122:
            r110.enforceInterface(DESCRIPTOR);
            boolean r147 = shareResources(r110.readString());
            r111.writeNoException();
            r111.writeInt(r147 ? 1 : 0);
            return true;
        L124:
            r110.enforceInterface(DESCRIPTOR);
            boolean r148 = isPluginPackage(r110.readString());
            r111.writeNoException();
            r111.writeInt(r148 ? 1 : 0);
            return true;
        L126:
            r110.enforceInterface(DESCRIPTOR);
            int r149 = getInstalledPluginVersion(r110.readString());
            r111.writeNoException();
            r111.writeInt(r149);
            return true;
        L128:
            r110.enforceInterface(DESCRIPTOR);
            int r150 = getPluginStatus(r110.readString());
            r111.writeNoException();
            r111.writeInt(r150);
            return true;
        L130:
            r110.enforceInterface(DESCRIPTOR);
            Plugin r151 = getPlugin(r110.readString());
            r111.writeNoException();
            if (r151 == null) goto L133;
            r111.writeInt(1);
            r151.writeToParcel(r111, 1);
        L134:
            return true;
        L133:
            r111.writeInt(0);
            goto L134
        L135:
            r110.enforceInterface(DESCRIPTOR);
            List<Plugin> r152 = getPluginList();
            r111.writeNoException();
            r111.writeTypedList(r152);
            return true;
        L7:
            return super.onTransact(r100, r110, r111, r112);
        L137:
            r111.writeString(DESCRIPTOR);
            return true;
        }
    }

    boolean checkPluginInstalled(String r100) throws RemoteException;

    int deletePackage(String r100, int r101) throws RemoteException;

    String generateContextPackageName(String r100) throws RemoteException;

    ActivityInfo getActivityInfo(ComponentName r100, int r101) throws RemoteException;

    ApplicationInfo getApplicationInfo(String r100, int r101) throws RemoteException;

    List<String> getExistedPluginPackageNames() throws RemoteException;

    List<String> getInstalledPackageNames() throws RemoteException;

    int getInstalledPluginVersion(String r100) throws RemoteException;

    PackageInfo getPackageInfo(String r100, int r101) throws RemoteException;

    Plugin getPlugin(String r100) throws RemoteException;

    List<Plugin> getPluginList() throws RemoteException;

    int getPluginStatus(String r100) throws RemoteException;

    ProviderInfo getProviderInfo(ComponentName r100, int r101) throws RemoteException;

    List<ProviderInfo> getProviders(String r100, String r101, int r102) throws RemoteException;

    ActivityInfo getReceiverInfo(ComponentName r100, int r101) throws RemoteException;

    List<ReceiverInfo> getReceivers(String r100, int r101) throws RemoteException;

    ServiceInfo getServiceInfo(ComponentName r100, int r101) throws RemoteException;

    int installCompatPackage(String r100, String r101, String r102, boolean r103, int r104) throws RemoteException;

    int installPackage(String r100, boolean r101, int r102) throws RemoteException;

    boolean isPluginPackage(String r100) throws RemoteException;

    List<ResolveInfo> queryIntentActivities(Intent r100, String r101, int r102) throws RemoteException;

    List<ResolveInfo> queryIntentServices(Intent r100, String r101, int r102) throws RemoteException;

    boolean resolve(Plugin r100) throws RemoteException;

    ProviderInfo resolveContentProvider(String r100, int r101) throws RemoteException;

    ResolveInfo resolveIntent(Intent r100, String r101, int r102) throws RemoteException;

    ResolveInfo resolveService(Intent r100, String r101, int r102) throws RemoteException;

    boolean shareResources(String r100) throws RemoteException;

    boolean syncInstallCompatPackage(String r100, String r101, String r102, boolean r103, int r104) throws RemoteException;

    boolean syncInstallPackage(String r100, boolean r101, int r102) throws RemoteException;
}
