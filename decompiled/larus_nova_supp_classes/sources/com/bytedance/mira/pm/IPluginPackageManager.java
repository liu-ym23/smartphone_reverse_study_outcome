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
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public interface IPluginPackageManager extends IInterface {

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
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_bytedance_mira_pm_IPluginPackageManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 8, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                ArrayList<String> r2 = r1.createStringArrayList();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r2;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                List<String> r3 = Stub.getDefaultImpl().getExistedPluginPackageNames();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r3;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.bytedance.mira.pm.IPluginPackageManager
            public List<String> getInstalledPackageNames() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_bytedance_mira_pm_IPluginPackageManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 9, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                ArrayList<String> r2 = r1.createStringArrayList();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r2;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                List<String> r3 = Stub.getDefaultImpl().getInstalledPackageNames();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r3;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.bytedance.mira.pm.IPluginPackageManager
            public List<Plugin> getPluginList() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_bytedance_mira_pm_IPluginPackageManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                ArrayList r2 = r1.createTypedArrayList(Plugin.CREATOR);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r2;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                List<Plugin> r3 = Stub.getDefaultImpl().getPluginList();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r3;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // com.bytedance.mira.pm.IPluginPackageManager
            public boolean checkPluginInstalled(String r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r0.writeString(r6);     // Catch: Throwable -> L15
                boolean r4 = false;
                if (INVOKEINTERFACE_com_bytedance_mira_pm_IPluginPackageManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 7, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L13;
                r4 = true;
            L13:
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r7 = Stub.getDefaultImpl().checkPluginInstalled(r6);     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r7;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.bytedance.mira.pm.IPluginPackageManager
            public String generateContextPackageName(String r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeString(r6);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_bytedance_mira_pm_IPluginPackageManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 10, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                String r7 = r1.readString();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r7;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                String r8 = Stub.getDefaultImpl().generateContextPackageName(r6);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r8;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.bytedance.mira.pm.IPluginPackageManager
            public int getInstalledPluginVersion(String r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeString(r6);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_bytedance_mira_pm_IPluginPackageManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int r7 = r1.readInt();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r7;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r8 = Stub.getDefaultImpl().getInstalledPluginVersion(r6);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r8;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.bytedance.mira.pm.IPluginPackageManager
            public Plugin getPlugin(String r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeString(r6);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_bytedance_mira_pm_IPluginPackageManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L17
                if (r1.readInt() == 0) goto L14;
                Plugin r7 = (Plugin) Plugin.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L17
            L15:
                r1.recycle();
                r0.recycle();
                return r7;
            L14:
                r7 = null;
                goto L15
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Plugin r8 = Stub.getDefaultImpl().getPlugin(r6);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r8;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.bytedance.mira.pm.IPluginPackageManager
            public int getPluginStatus(String r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeString(r6);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_bytedance_mira_pm_IPluginPackageManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int r7 = r1.readInt();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r7;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r8 = Stub.getDefaultImpl().getPluginStatus(r6);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r8;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.bytedance.mira.pm.IPluginPackageManager
            public boolean isPluginPackage(String r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r0.writeString(r6);     // Catch: Throwable -> L15
                boolean r4 = false;
                if (INVOKEINTERFACE_com_bytedance_mira_pm_IPluginPackageManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 5, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L13;
                r4 = true;
            L13:
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r7 = Stub.getDefaultImpl().isPluginPackage(r6);     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r7;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.bytedance.mira.pm.IPluginPackageManager
            public boolean resolve(Plugin r7) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                boolean r2 = true;
                if (r7 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L20
                r7.writeToParcel(r0, 0);     // Catch: Throwable -> L20
            L8:
                if (INVOKEINTERFACE_com_bytedance_mira_pm_IPluginPackageManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 16, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L20
                if (r1.readInt() != 0) goto L18;
                r2 = false;
            L18:
                r1.recycle();
                r0.recycle();
                return r2;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                boolean r8 = Stub.getDefaultImpl().resolve(r7);     // Catch: Throwable -> L20
                r1.recycle();
                r0.recycle();
                return r8;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L20
            L20:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.bytedance.mira.pm.IPluginPackageManager
            public boolean shareResources(String r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r0.writeString(r6);     // Catch: Throwable -> L15
                boolean r4 = false;
                if (INVOKEINTERFACE_com_bytedance_mira_pm_IPluginPackageManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 6, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L13;
                r4 = true;
            L13:
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r7 = Stub.getDefaultImpl().shareResources(r6);     // Catch: Throwable -> L15
                r1.recycle();
                r0.recycle();
                return r7;
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.bytedance.mira.pm.IPluginPackageManager
            public int deletePackage(String r6, int r7) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeString(r6);     // Catch: Throwable -> L13
                r0.writeInt(r7);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_bytedance_mira_pm_IPluginPackageManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 15, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                int r8 = r1.readInt();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r8;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r9 = Stub.getDefaultImpl().deletePackage(r6, r7);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r9;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.bytedance.mira.pm.IPluginPackageManager
            public ActivityInfo getActivityInfo(ComponentName r6, int r7) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L21
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L21
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L21
            L7:
                r0.writeInt(r7);     // Catch: Throwable -> L21
                if (INVOKEINTERFACE_com_bytedance_mira_pm_IPluginPackageManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, Stub.TRANSACTION_getActivityInfo, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L21
                if (r1.readInt() == 0) goto L18;
                ActivityInfo r8 = (ActivityInfo) ActivityInfo.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L21
            L19:
                r1.recycle();
                r0.recycle();
                return r8;
            L18:
                r8 = null;
                goto L19
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                ActivityInfo r9 = Stub.getDefaultImpl().getActivityInfo(r6, r7);     // Catch: Throwable -> L21
                r1.recycle();
                r0.recycle();
                return r9;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L21
            L21:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.bytedance.mira.pm.IPluginPackageManager
            public ApplicationInfo getApplicationInfo(String r6, int r7) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeString(r6);     // Catch: Throwable -> L17
                r0.writeInt(r7);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_bytedance_mira_pm_IPluginPackageManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 18, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L17
                if (r1.readInt() == 0) goto L14;
                ApplicationInfo r8 = (ApplicationInfo) ApplicationInfo.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L17
            L15:
                r1.recycle();
                r0.recycle();
                return r8;
            L14:
                r8 = null;
                goto L15
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                ApplicationInfo r9 = Stub.getDefaultImpl().getApplicationInfo(r6, r7);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r9;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.bytedance.mira.pm.IPluginPackageManager
            public PackageInfo getPackageInfo(String r6, int r7) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeString(r6);     // Catch: Throwable -> L17
                r0.writeInt(r7);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_bytedance_mira_pm_IPluginPackageManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 17, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L17
                if (r1.readInt() == 0) goto L14;
                PackageInfo r8 = (PackageInfo) PackageInfo.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L17
            L15:
                r1.recycle();
                r0.recycle();
                return r8;
            L14:
                r8 = null;
                goto L15
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                PackageInfo r9 = Stub.getDefaultImpl().getPackageInfo(r6, r7);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r9;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.bytedance.mira.pm.IPluginPackageManager
            public ProviderInfo getProviderInfo(ComponentName r6, int r7) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L21
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L21
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L21
            L7:
                r0.writeInt(r7);     // Catch: Throwable -> L21
                if (INVOKEINTERFACE_com_bytedance_mira_pm_IPluginPackageManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, Stub.TRANSACTION_getProviderInfo, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L21
                if (r1.readInt() == 0) goto L18;
                ProviderInfo r8 = (ProviderInfo) ProviderInfo.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L21
            L19:
                r1.recycle();
                r0.recycle();
                return r8;
            L18:
                r8 = null;
                goto L19
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                ProviderInfo r9 = Stub.getDefaultImpl().getProviderInfo(r6, r7);     // Catch: Throwable -> L21
                r1.recycle();
                r0.recycle();
                return r9;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L21
            L21:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.bytedance.mira.pm.IPluginPackageManager
            public ActivityInfo getReceiverInfo(ComponentName r6, int r7) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L21
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L21
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L21
            L7:
                r0.writeInt(r7);     // Catch: Throwable -> L21
                if (INVOKEINTERFACE_com_bytedance_mira_pm_IPluginPackageManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, Stub.TRANSACTION_getReceiverInfo, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L21
                if (r1.readInt() == 0) goto L18;
                ActivityInfo r8 = (ActivityInfo) ActivityInfo.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L21
            L19:
                r1.recycle();
                r0.recycle();
                return r8;
            L18:
                r8 = null;
                goto L19
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                ActivityInfo r9 = Stub.getDefaultImpl().getReceiverInfo(r6, r7);     // Catch: Throwable -> L21
                r1.recycle();
                r0.recycle();
                return r9;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L21
            L21:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.bytedance.mira.pm.IPluginPackageManager
            public List<ReceiverInfo> getReceivers(String r6, int r7) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeString(r6);     // Catch: Throwable -> L13
                r0.writeInt(r7);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_bytedance_mira_pm_IPluginPackageManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, Stub.TRANSACTION_getReceivers, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                ArrayList r8 = r1.createTypedArrayList(ReceiverInfo.CREATOR);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r8;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                List<ReceiverInfo> r9 = Stub.getDefaultImpl().getReceivers(r6, r7);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r9;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.bytedance.mira.pm.IPluginPackageManager
            public ServiceInfo getServiceInfo(ComponentName r6, int r7) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L21
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L21
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L21
            L7:
                r0.writeInt(r7);     // Catch: Throwable -> L21
                if (INVOKEINTERFACE_com_bytedance_mira_pm_IPluginPackageManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, Stub.TRANSACTION_getServiceInfo, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L21
                if (r1.readInt() == 0) goto L18;
                ServiceInfo r8 = (ServiceInfo) ServiceInfo.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L21
            L19:
                r1.recycle();
                r0.recycle();
                return r8;
            L18:
                r8 = null;
                goto L19
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                ServiceInfo r9 = Stub.getDefaultImpl().getServiceInfo(r6, r7);     // Catch: Throwable -> L21
                r1.recycle();
                r0.recycle();
                return r9;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L21
            L21:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.bytedance.mira.pm.IPluginPackageManager
            public ProviderInfo resolveContentProvider(String r6, int r7) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeString(r6);     // Catch: Throwable -> L17
                r0.writeInt(r7);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_bytedance_mira_pm_IPluginPackageManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, Stub.TRANSACTION_resolveContentProvider, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L17
                if (r1.readInt() == 0) goto L14;
                ProviderInfo r8 = (ProviderInfo) ProviderInfo.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L17
            L15:
                r1.recycle();
                r0.recycle();
                return r8;
            L14:
                r8 = null;
                goto L15
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                ProviderInfo r9 = Stub.getDefaultImpl().resolveContentProvider(r6, r7);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r9;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.bytedance.mira.pm.IPluginPackageManager
            public List<ProviderInfo> getProviders(String r6, String r7, int r8) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeString(r6);     // Catch: Throwable -> L13
                r0.writeString(r7);     // Catch: Throwable -> L13
                r0.writeInt(r8);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_bytedance_mira_pm_IPluginPackageManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, Stub.TRANSACTION_getProviders, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                ArrayList r9 = r1.createTypedArrayList(ProviderInfo.CREATOR);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r9;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                List<ProviderInfo> r10 = Stub.getDefaultImpl().getProviders(r6, r7, r8);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return r10;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.bytedance.mira.pm.IPluginPackageManager
            public int installPackage(String r6, boolean r7, int r8) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeString(r6);     // Catch: Throwable -> L17
                if (r7 == false) goto L6;
                int r3 = 1;
            L7:
                r0.writeInt(r3);     // Catch: Throwable -> L17
                r0.writeInt(r8);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_bytedance_mira_pm_IPluginPackageManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 11, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                int r9 = r1.readInt();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r9;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                int r10 = Stub.getDefaultImpl().installPackage(r6, r7, r8);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r10;
            L6:
                r3 = 0;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.bytedance.mira.pm.IPluginPackageManager
            public List<ResolveInfo> queryIntentActivities(Intent r6, String r7, int r8) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L17
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L17
            L7:
                r0.writeString(r7);     // Catch: Throwable -> L17
                r0.writeInt(r8);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_bytedance_mira_pm_IPluginPackageManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, Stub.TRANSACTION_queryIntentActivities, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                ArrayList r9 = r1.createTypedArrayList(ResolveInfo.CREATOR);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r9;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                List<ResolveInfo> r10 = Stub.getDefaultImpl().queryIntentActivities(r6, r7, r8);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r10;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.bytedance.mira.pm.IPluginPackageManager
            public List<ResolveInfo> queryIntentServices(Intent r6, String r7, int r8) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L17
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L17
            L7:
                r0.writeString(r7);     // Catch: Throwable -> L17
                r0.writeInt(r8);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_bytedance_mira_pm_IPluginPackageManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, Stub.TRANSACTION_queryIntentServices, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                ArrayList r9 = r1.createTypedArrayList(ResolveInfo.CREATOR);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r9;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                List<ResolveInfo> r10 = Stub.getDefaultImpl().queryIntentServices(r6, r7, r8);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r10;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.bytedance.mira.pm.IPluginPackageManager
            public ResolveInfo resolveIntent(Intent r6, String r7, int r8) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L21
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L21
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L21
            L7:
                r0.writeString(r7);     // Catch: Throwable -> L21
                r0.writeInt(r8);     // Catch: Throwable -> L21
                if (INVOKEINTERFACE_com_bytedance_mira_pm_IPluginPackageManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, Stub.TRANSACTION_resolveIntent, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L21
                if (r1.readInt() == 0) goto L18;
                ResolveInfo r9 = (ResolveInfo) ResolveInfo.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L21
            L19:
                r1.recycle();
                r0.recycle();
                return r9;
            L18:
                r9 = null;
                goto L19
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                ResolveInfo r10 = Stub.getDefaultImpl().resolveIntent(r6, r7, r8);     // Catch: Throwable -> L21
                r1.recycle();
                r0.recycle();
                return r10;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L21
            L21:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.bytedance.mira.pm.IPluginPackageManager
            public ResolveInfo resolveService(Intent r6, String r7, int r8) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L21
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L21
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L21
            L7:
                r0.writeString(r7);     // Catch: Throwable -> L21
                r0.writeInt(r8);     // Catch: Throwable -> L21
                if (INVOKEINTERFACE_com_bytedance_mira_pm_IPluginPackageManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, Stub.TRANSACTION_resolveService, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L21
                if (r1.readInt() == 0) goto L18;
                ResolveInfo r9 = (ResolveInfo) ResolveInfo.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L21
            L19:
                r1.recycle();
                r0.recycle();
                return r9;
            L18:
                r9 = null;
                goto L19
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                ResolveInfo r10 = Stub.getDefaultImpl().resolveService(r6, r7, r8);     // Catch: Throwable -> L21
                r1.recycle();
                r0.recycle();
                return r10;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L21
            L21:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.bytedance.mira.pm.IPluginPackageManager
            public boolean syncInstallPackage(String r7, boolean r8, int r9) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                r0.writeString(r7);     // Catch: Throwable -> L20
                boolean r2 = true;
                if (r8 == false) goto L6;
                int r4 = 1;
            L7:
                r0.writeInt(r4);     // Catch: Throwable -> L20
                r0.writeInt(r9);     // Catch: Throwable -> L20
                if (INVOKEINTERFACE_com_bytedance_mira_pm_IPluginPackageManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 12, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L20
                if (r1.readInt() != 0) goto L18;
                r2 = false;
            L18:
                r1.recycle();
                r0.recycle();
                return r2;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                boolean r10 = Stub.getDefaultImpl().syncInstallPackage(r7, r8, r9);     // Catch: Throwable -> L20
                r1.recycle();
                r0.recycle();
                return r10;
            L6:
                r4 = 0;
            L20:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_bytedance_mira_pm_IPluginPackageManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r15, int r16, Parcel r17, Parcel r18, int r19) throws RemoteException {
                if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
                long r2 = SystemClock.uptimeMillis();
                boolean r0 = r15.transact(r16, r17, r18, r19);     // Catch: Throwable -> L12
                long r8 = SystemClock.uptimeMillis() - r2;
                if (r8 < 100) goto L11;
                BinderPerformanceReporter.report(r8, r15.getClass().getName(), r16, r19, new Throwable("Slow main-thread Binder transaction"));
            L11:
                return r0;
            L12:
                th = move-exception;
                long r9 = SystemClock.uptimeMillis() - r2;
                if (r9 < 100) goto L22;
                if (r15 != null) goto L17;
                String r1 = XmlPullParser.NO_NAMESPACE;
            L18:
                BinderPerformanceReporter.report(r9, r1, r16, r19, new Throwable("Slow main-thread Binder transaction"));
                throw th;
            L17:
                r1 = r15.getClass().getName();
                goto L18
            L22:
                throw th;
            L5:
                return r15.transact(r16, r17, r18, r19);
            }

            @Override // com.bytedance.mira.pm.IPluginPackageManager
            public int installCompatPackage(String r10, String r11, String r12, boolean r13, int r14) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeString(r10);     // Catch: Throwable -> L17
                r0.writeString(r11);     // Catch: Throwable -> L17
                r0.writeString(r12);     // Catch: Throwable -> L17
                if (r13 == false) goto L6;
                int r3 = 1;
            L7:
                r0.writeInt(r3);     // Catch: Throwable -> L17
                r0.writeInt(r14);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_bytedance_mira_pm_IPluginPackageManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 13, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                int r15 = r1.readInt();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r15;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                int r16 = Stub.getDefaultImpl().installCompatPackage(r10, r11, r12, r13, r14);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r16;
            L6:
                r3 = 0;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.bytedance.mira.pm.IPluginPackageManager
            public boolean syncInstallCompatPackage(String r12, String r13, String r14, boolean r15, int r16) throws RemoteException {
                Parcel r1 = Parcel.obtain();
                Parcel r2 = Parcel.obtain();
                r1.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L24
                r1.writeString(r12);     // Catch: Throwable -> L24
                r1.writeString(r13);     // Catch: Throwable -> L24
                r1.writeString(r14);     // Catch: Throwable -> L24
                boolean r3 = true;
                if (r15 == false) goto L6;
                int r7 = 1;
            L7:
                r1.writeInt(r7);     // Catch: Throwable -> L24
                r1.writeInt(r16);     // Catch: Throwable -> L24
            L22:
                th = th;
            L26:
                r2.recycle();
                r1.recycle();
                throw th;
            L10:
                if (INVOKEINTERFACE_com_bytedance_mira_pm_IPluginPackageManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 14, r1, r2, 0) == false) goto L12;
            L16:
                r2.readException();     // Catch: Throwable -> L22
                if (r2.readInt() != 0) goto L20;
                r3 = false;
            L20:
                r2.recycle();
                r1.recycle();
                return r3;
            L12:
                if (Stub.getDefaultImpl() == null) goto L16;
                boolean r0 = Stub.getDefaultImpl().syncInstallCompatPackage(r12, r13, r14, r15, r16);     // Catch: Throwable -> L22
                r2.recycle();
                r1.recycle();
                return r0;
            L6:
                r7 = 0;
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

        public static IPluginPackageManager asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IPluginPackageManager) == false) goto L12;
            return (IPluginPackageManager) r0;
        L12:
            return new Proxy(r2);
        }

        public static boolean setDefaultImpl(IPluginPackageManager r1) {
            if (Proxy.sDefaultImpl != null) goto L7;
            if (r1 == null) goto L9;
            Proxy.sDefaultImpl = r1;
            return true;
        L9:
            return false;
        L7:
            return false;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r9, Parcel r10, Parcel r11, int r12) throws RemoteException {
            if (r9 == 1598968902) goto L137;
            Plugin r0 = null;
            boolean r3 = false;
            switch(r9) {
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
            r10.enforceInterface(DESCRIPTOR);
            List<ProviderInfo> r13 = getProviders(r10.readString(), r10.readString(), r10.readInt());
            r11.writeNoException();
            r11.writeTypedList(r13);
            return true;
        L10:
            r10.enforceInterface(DESCRIPTOR);
            List<ReceiverInfo> r14 = getReceivers(r10.readString(), r10.readInt());
            r11.writeNoException();
            r11.writeTypedList(r14);
            return true;
        L12:
            r10.enforceInterface(DESCRIPTOR);
            if (r10.readInt() == 0) goto L15;
            r0 = (Intent) Intent.CREATOR.createFromParcel(r10);
        L15:
            List<ResolveInfo> r15 = queryIntentServices(r0, r10.readString(), r10.readInt());
            r11.writeNoException();
            r11.writeTypedList(r15);
            return true;
        L17:
            r10.enforceInterface(DESCRIPTOR);
            if (r10.readInt() == 0) goto L20;
            r0 = (Intent) Intent.CREATOR.createFromParcel(r10);
        L20:
            List<ResolveInfo> r16 = queryIntentActivities(r0, r10.readString(), r10.readInt());
            r11.writeNoException();
            r11.writeTypedList(r16);
            return true;
        L22:
            r10.enforceInterface(DESCRIPTOR);
            ProviderInfo r17 = resolveContentProvider(r10.readString(), r10.readInt());
            r11.writeNoException();
            if (r17 == null) goto L25;
            r11.writeInt(1);
            r17.writeToParcel(r11, 1);
        L26:
            return true;
        L25:
            r11.writeInt(0);
            goto L26
        L27:
            r10.enforceInterface(DESCRIPTOR);
            if (r10.readInt() == 0) goto L30;
            r0 = (Intent) Intent.CREATOR.createFromParcel(r10);
        L30:
            ResolveInfo r18 = resolveService(r0, r10.readString(), r10.readInt());
            r11.writeNoException();
            if (r18 == null) goto L33;
            r11.writeInt(1);
            r18.writeToParcel(r11, 1);
        L34:
            return true;
        L33:
            r11.writeInt(0);
            goto L34
        L35:
            r10.enforceInterface(DESCRIPTOR);
            if (r10.readInt() == 0) goto L38;
            r0 = (Intent) Intent.CREATOR.createFromParcel(r10);
        L38:
            ResolveInfo r19 = resolveIntent(r0, r10.readString(), r10.readInt());
            r11.writeNoException();
            if (r19 == null) goto L41;
            r11.writeInt(1);
            r19.writeToParcel(r11, 1);
        L42:
            return true;
        L41:
            r11.writeInt(0);
            goto L42
        L43:
            r10.enforceInterface(DESCRIPTOR);
            if (r10.readInt() == 0) goto L46;
            r0 = (ComponentName) ComponentName.CREATOR.createFromParcel(r10);
        L46:
            ProviderInfo r20 = getProviderInfo(r0, r10.readInt());
            r11.writeNoException();
            if (r20 == null) goto L49;
            r11.writeInt(1);
            r20.writeToParcel(r11, 1);
        L50:
            return true;
        L49:
            r11.writeInt(0);
            goto L50
        L51:
            r10.enforceInterface(DESCRIPTOR);
            if (r10.readInt() == 0) goto L54;
            r0 = (ComponentName) ComponentName.CREATOR.createFromParcel(r10);
        L54:
            ActivityInfo r21 = getReceiverInfo(r0, r10.readInt());
            r11.writeNoException();
            if (r21 == null) goto L57;
            r11.writeInt(1);
            r21.writeToParcel(r11, 1);
        L58:
            return true;
        L57:
            r11.writeInt(0);
            goto L58
        L59:
            r10.enforceInterface(DESCRIPTOR);
            if (r10.readInt() == 0) goto L62;
            r0 = (ComponentName) ComponentName.CREATOR.createFromParcel(r10);
        L62:
            ServiceInfo r22 = getServiceInfo(r0, r10.readInt());
            r11.writeNoException();
            if (r22 == null) goto L65;
            r11.writeInt(1);
            r22.writeToParcel(r11, 1);
        L66:
            return true;
        L65:
            r11.writeInt(0);
            goto L66
        L67:
            r10.enforceInterface(DESCRIPTOR);
            if (r10.readInt() == 0) goto L70;
            r0 = (ComponentName) ComponentName.CREATOR.createFromParcel(r10);
        L70:
            ActivityInfo r23 = getActivityInfo(r0, r10.readInt());
            r11.writeNoException();
            if (r23 == null) goto L73;
            r11.writeInt(1);
            r23.writeToParcel(r11, 1);
        L74:
            return true;
        L73:
            r11.writeInt(0);
            goto L74
        L75:
            r10.enforceInterface(DESCRIPTOR);
            ApplicationInfo r24 = getApplicationInfo(r10.readString(), r10.readInt());
            r11.writeNoException();
            if (r24 == null) goto L78;
            r11.writeInt(1);
            r24.writeToParcel(r11, 1);
        L79:
            return true;
        L78:
            r11.writeInt(0);
            goto L79
        L80:
            r10.enforceInterface(DESCRIPTOR);
            PackageInfo r25 = getPackageInfo(r10.readString(), r10.readInt());
            r11.writeNoException();
            if (r25 == null) goto L83;
            r11.writeInt(1);
            r25.writeToParcel(r11, 1);
        L84:
            return true;
        L83:
            r11.writeInt(0);
            goto L84
        L85:
            r10.enforceInterface(DESCRIPTOR);
            if (r10.readInt() == 0) goto L88;
            r0 = (Plugin) Plugin.CREATOR.createFromParcel(r10);
        L88:
            boolean r26 = resolve(r0);
            r11.writeNoException();
            r11.writeInt(r26 ? 1 : 0);
            return true;
        L90:
            r10.enforceInterface(DESCRIPTOR);
            int r28 = deletePackage(r10.readString(), r10.readInt());
            r11.writeNoException();
            r11.writeInt(r28);
            return true;
        L92:
            r10.enforceInterface(DESCRIPTOR);
            String r29 = r10.readString();
            String r4 = r10.readString();
            String r5 = r10.readString();
            if (r10.readInt() == 0) goto L95;
            boolean r6 = true;
        L96:
            boolean r30 = syncInstallCompatPackage(r29, r4, r5, r6, r10.readInt());
            r11.writeNoException();
            r11.writeInt(r30 ? 1 : 0);
            return true;
        L95:
            r6 = false;
            goto L96
        L98:
            r10.enforceInterface(DESCRIPTOR);
            String r31 = r10.readString();
            String r7 = r10.readString();
            String r8 = r10.readString();
            if (r10.readInt() == 0) goto L101;
            boolean r32 = true;
        L102:
            int r33 = installCompatPackage(r31, r7, r8, r32, r10.readInt());
            r11.writeNoException();
            r11.writeInt(r33);
            return true;
        L101:
            r32 = false;
            goto L102
        L104:
            r10.enforceInterface(DESCRIPTOR);
            String r34 = r10.readString();
            if (r10.readInt() == 0) goto L107;
            r3 = true;
        L107:
            boolean r35 = syncInstallPackage(r34, r3, r10.readInt());
            r11.writeNoException();
            r11.writeInt(r35 ? 1 : 0);
            return true;
        L109:
            r10.enforceInterface(DESCRIPTOR);
            String r36 = r10.readString();
            if (r10.readInt() == 0) goto L112;
            r3 = true;
        L112:
            int r37 = installPackage(r36, r3, r10.readInt());
            r11.writeNoException();
            r11.writeInt(r37);
            return true;
        L114:
            r10.enforceInterface(DESCRIPTOR);
            String r38 = generateContextPackageName(r10.readString());
            r11.writeNoException();
            r11.writeString(r38);
            return true;
        L116:
            r10.enforceInterface(DESCRIPTOR);
            List<String> r39 = getInstalledPackageNames();
            r11.writeNoException();
            r11.writeStringList(r39);
            return true;
        L118:
            r10.enforceInterface(DESCRIPTOR);
            List<String> r40 = getExistedPluginPackageNames();
            r11.writeNoException();
            r11.writeStringList(r40);
            return true;
        L120:
            r10.enforceInterface(DESCRIPTOR);
            boolean r41 = checkPluginInstalled(r10.readString());
            r11.writeNoException();
            r11.writeInt(r41 ? 1 : 0);
            return true;
        L122:
            r10.enforceInterface(DESCRIPTOR);
            boolean r42 = shareResources(r10.readString());
            r11.writeNoException();
            r11.writeInt(r42 ? 1 : 0);
            return true;
        L124:
            r10.enforceInterface(DESCRIPTOR);
            boolean r43 = isPluginPackage(r10.readString());
            r11.writeNoException();
            r11.writeInt(r43 ? 1 : 0);
            return true;
        L126:
            r10.enforceInterface(DESCRIPTOR);
            int r44 = getInstalledPluginVersion(r10.readString());
            r11.writeNoException();
            r11.writeInt(r44);
            return true;
        L128:
            r10.enforceInterface(DESCRIPTOR);
            int r45 = getPluginStatus(r10.readString());
            r11.writeNoException();
            r11.writeInt(r45);
            return true;
        L130:
            r10.enforceInterface(DESCRIPTOR);
            Plugin r46 = getPlugin(r10.readString());
            r11.writeNoException();
            if (r46 == null) goto L133;
            r11.writeInt(1);
            r46.writeToParcel(r11, 1);
        L134:
            return true;
        L133:
            r11.writeInt(0);
            goto L134
        L135:
            r10.enforceInterface(DESCRIPTOR);
            List<Plugin> r47 = getPluginList();
            r11.writeNoException();
            r11.writeTypedList(r47);
            return true;
        L7:
            return super.onTransact(r9, r10, r11, r12);
        L137:
            r11.writeString(DESCRIPTOR);
            return true;
        }
    }

    boolean checkPluginInstalled(String r1) throws RemoteException;

    int deletePackage(String r1, int r2) throws RemoteException;

    String generateContextPackageName(String r1) throws RemoteException;

    ActivityInfo getActivityInfo(ComponentName r1, int r2) throws RemoteException;

    ApplicationInfo getApplicationInfo(String r1, int r2) throws RemoteException;

    List<String> getExistedPluginPackageNames() throws RemoteException;

    List<String> getInstalledPackageNames() throws RemoteException;

    int getInstalledPluginVersion(String r1) throws RemoteException;

    PackageInfo getPackageInfo(String r1, int r2) throws RemoteException;

    Plugin getPlugin(String r1) throws RemoteException;

    List<Plugin> getPluginList() throws RemoteException;

    int getPluginStatus(String r1) throws RemoteException;

    ProviderInfo getProviderInfo(ComponentName r1, int r2) throws RemoteException;

    List<ProviderInfo> getProviders(String r1, String r2, int r3) throws RemoteException;

    ActivityInfo getReceiverInfo(ComponentName r1, int r2) throws RemoteException;

    List<ReceiverInfo> getReceivers(String r1, int r2) throws RemoteException;

    ServiceInfo getServiceInfo(ComponentName r1, int r2) throws RemoteException;

    int installCompatPackage(String r1, String r2, String r3, boolean r4, int r5) throws RemoteException;

    int installPackage(String r1, boolean r2, int r3) throws RemoteException;

    boolean isPluginPackage(String r1) throws RemoteException;

    List<ResolveInfo> queryIntentActivities(Intent r1, String r2, int r3) throws RemoteException;

    List<ResolveInfo> queryIntentServices(Intent r1, String r2, int r3) throws RemoteException;

    boolean resolve(Plugin r1) throws RemoteException;

    ProviderInfo resolveContentProvider(String r1, int r2) throws RemoteException;

    ResolveInfo resolveIntent(Intent r1, String r2, int r3) throws RemoteException;

    ResolveInfo resolveService(Intent r1, String r2, int r3) throws RemoteException;

    boolean shareResources(String r1) throws RemoteException;

    boolean syncInstallCompatPackage(String r1, String r2, String r3, boolean r4, int r5) throws RemoteException;

    boolean syncInstallPackage(String r1, boolean r2, int r3) throws RemoteException;
}
