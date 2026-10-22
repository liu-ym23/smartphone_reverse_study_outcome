package com.vivo.libra;

import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemClock;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes41.dex */
public interface ILibraSdk extends IInterface {

    /* JADX INFO: renamed from: com.vivo.libra.ILibraSdk$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class BBinder extends Binder {
        private final Map<String, List<CallBack>> eventMap;

        public static /* synthetic */ List a(String r100) {
            return lambda$addLister$0(r100);
        }

        public List<String> clearLister() {
            if (this.eventMap.isEmpty() == false) goto L6;
            return null;
        L6:
            Map<String, List<CallBack>> r100 = this.eventMap;
            monitor-enter(r100);
            ArrayList r101 = new ArrayList(this.eventMap.keySet());     // Catch: Throwable -> L11
            this.eventMap.clear();     // Catch: Throwable -> L11
            monitor-exit(r100);     // Catch: Throwable -> L11
            return r101;
        L11:
            th = move-exception;
            throw th;
        }

        public String[] getAllEvent() {
            return (String[]) this.eventMap.keySet().toArray(new String[0]);
        }

        public BBinder() {
            this.eventMap = new HashMap();
        }

        private static /* synthetic */ List lambda$addLister$0(String r100) {
            return new ArrayList();
        }

        public List<String> getLister(CallBack r100) {
            ArrayList r101 = null;
            if (this.eventMap.isEmpty() == false) goto L5;
            return null;
        L5:
            Map<String, List<CallBack>> r102 = this.eventMap;
            monitor-enter(r102);
            ArrayList r103 = new ArrayList();     // Catch: Throwable -> L19
            Iterator<Map.Entry<String, List<CallBack>>> r104 = this.eventMap.entrySet().iterator();     // Catch: Throwable -> L19
        L9:
            if (r104.hasNext() == false) goto L14;
            Map.Entry<String, List<CallBack>> r105 = r104.next();     // Catch: Throwable -> L19
            if (r105.getValue().contains(r100) == false) goto L9;
            r103.add(r105.getKey());     // Catch: Throwable -> L19
            goto L9
        L14:
            if (r103.isEmpty() == true) goto L17;
            r101 = r103;
        L17:
            monitor-exit(r102);     // Catch: Throwable -> L19
            return r101;
        L19:
            th = move-exception;
            throw th;
        }

        public boolean inMap(String r100) {
            return this.eventMap.containsKey(r100);
        }

        public void addLister(String r100, CallBack r101) {
            Map<String, List<CallBack>> r102 = this.eventMap;
            monitor-enter(r102);
            List<CallBack> r103 = this.eventMap.computeIfAbsent(r100, new a());     // Catch: Throwable -> L11
            if (r103.contains(r101) == false) goto L8;
            monitor-exit(r102);     // Catch: Throwable -> L11
            return;
        L8:
            r103.add(r101);     // Catch: Throwable -> L11
            monitor-exit(r102);     // Catch: Throwable -> L11
            return;
        L11:
            th = move-exception;
            throw th;
        }

        public boolean removeLister(String r100, CallBack r101) {
            Map<String, List<CallBack>> r102 = this.eventMap;
            monitor-enter(r102);
            List<CallBack> r103 = this.eventMap.get(r100);     // Catch: Throwable -> L21
            if (r103 != null) goto L7;
        L18:
            monitor-exit(r102);     // Catch: Throwable -> L21
            return false;
        L7:
            if (r101 != null) goto L12;
            this.eventMap.remove(r100);     // Catch: Throwable -> L21
            monitor-exit(r102);     // Catch: Throwable -> L21
            return true;
        L12:
            if (r103.remove(r101) == false) goto L18;
            if (r103.isEmpty() == false) goto L18;
            this.eventMap.remove(r100);     // Catch: Throwable -> L21
            monitor-exit(r102);     // Catch: Throwable -> L21
            return true;
        L21:
            th = move-exception;
            throw th;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r100, Parcel r101, Parcel r102, int r103) throws RemoteException {
            if (r100 != 1) goto L19;
            String r104 = r101.readString();
            int r105 = r101.readInt();
            Bundle r106 = r101.readBundle(BBinder.class.getClassLoader());
            Map<String, List<CallBack>> r107 = this.eventMap;
            monitor-enter(r107);
            List<CallBack> r108 = this.eventMap.get(r104);     // Catch: Throwable -> L15
            if (r108 == null) goto L12;
            Iterator<CallBack> r109 = r108.iterator();     // Catch: Throwable -> L15
        L10:
            if (r109.hasNext() == false) goto L12;
            r109.next().onCallBack(r104, r105, r106);     // Catch: Throwable -> L15
        L12:
            monitor-exit(r107);     // Catch: Throwable -> L15
            r102.writeNoException();
            return true;
        L15:
            th = move-exception;
            throw th;
        L19:
            return super.onTransact(r100, r101, r102, r103);
        }
    }

    public static final class Proxy implements ILibraSdk {
        private static final String DESCRIPTOR = "metric_sdk_server";
        private static final String TAG = "libra_sdk";
        private static Proxy sProxy;
        private BBinder mBBinder;
        private final Map<String, String> mEvents;
        private String mHashCode;
        private final LibraDeathRecipient mLibraDeathRecipient;
        private IBinder mRemote;
        private final Map<String, String> mSupports;
        private final Runnable mTryRun;

        public final class LibraDeathRecipient implements IBinder.DeathRecipient {
            final /* synthetic */ Proxy this$0;

            @Override // android.os.IBinder.DeathRecipient
            public void binderDied() {
                Proxy.access$100(this.this$0).unlinkToDeath(this, 0);
                new Handler().postDelayed(Proxy.access$200(this.this$0), 1000);
            }

            private LibraDeathRecipient(Proxy r100) {
                this.this$0 = r100;
            }

            public /* synthetic */ LibraDeathRecipient(Proxy r100, AnonymousClass1 r101) {
                this(r100);
            }
        }

        public static /* synthetic */ void a(Proxy r100) {
            r100.tryReconnect();
        }

        public static ILibraSdk asInterfaces() {
            monitor-enter(DESCRIPTOR);
        L12:
            th = move-exception;
            throw th;
        L5:
            if (sProxy != null) goto L9;
            IBinder r100 = ServiceManager.checkService(DESCRIPTOR);     // Catch: Throwable -> L12
            if (r100 == null) goto L9;
            sProxy = new Proxy(r100);     // Catch: Throwable -> L12
        L9:
            Proxy r101 = sProxy;     // Catch: Throwable -> L12
            monitor-exit(DESCRIPTOR);     // Catch: Throwable -> L12
            return r101;
        }

        private boolean tryReconnect() {
            IBinder r100 = ServiceManager.checkService(DESCRIPTOR);
            if (r100 == null) goto L18;
            this.mRemote = r100;
            if (checkPermission(this.mHashCode) == false) goto L18;
            String[] r101 = this.mBBinder.getAllEvent();
            if (r101 == null) goto L18;
            if (r101.length <= 0) goto L18;
            Parcel r102 = Parcel.obtain();
            Parcel r103 = Parcel.obtain();
            r102.writeStrongBinder(this.mBBinder);     // Catch: Throwable -> L14 Exception -> L17
            r102.writeStringArray(r101);     // Catch: Throwable -> L14 Exception -> L17
            INVOKEINTERFACE_com_vivo_libra_ILibraSdk$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r102, r103, 0);     // Catch: Throwable -> L14 Exception -> L17
            r103.readException();     // Catch: Throwable -> L14 Exception -> L17
            r103.readString();     // Catch: Throwable -> L14 Exception -> L17
            r102.recycle();
            r103.recycle();
            return true;
        L17:
            r102.recycle();
            r103.recycle();
        L14:
            th = move-exception;
            r102.recycle();
            r103.recycle();
            throw th;
        L18:
            return false;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.mRemote;
        }

        public Proxy(IBinder r100) {
            this.mHashCode = null;
            this.mBBinder = null;
            this.mEvents = new HashMap();
            this.mSupports = new HashMap();
            this.mLibraDeathRecipient = new LibraDeathRecipient(this, null);
            this.mTryRun = new b(this);
            this.mRemote = r100;
        }

        public static /* synthetic */ IBinder access$100(Proxy r100) {
            return r100.mRemote;
        }

        public static /* synthetic */ Runnable access$200(Proxy r100) {
            return r100.mTryRun;
        }

        private int unregisterRemoteCallBack(List<String> r100) {
            if (getIntResult("isSupportUnregister") <= 0) goto L34;
            monitor-enter(this);
            Parcel r101 = Parcel.obtain();     // Catch: Throwable -> L31
            Parcel r102 = Parcel.obtain();     // Catch: Throwable -> L31
            r101.writeStringArray((String[]) r100.toArray(new String[0]));     // Catch: Throwable -> L16 Exception -> L18 RemoteException -> L20
            INVOKEINTERFACE_com_vivo_libra_ILibraSdk$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 5, r101, r102, 0);     // Catch: Throwable -> L16 Exception -> L18 RemoteException -> L20
            r102.readException();     // Catch: Throwable -> L16 Exception -> L18 RemoteException -> L20
            String r103 = r102.readString();     // Catch: Throwable -> L16 Exception -> L18 RemoteException -> L20
            if (r103 == null) goto L14;
            if (r103.isEmpty() == true) goto L14;
            r101.recycle();     // Catch: Throwable -> L31
            r102.recycle();     // Catch: Throwable -> L31
            monitor-exit(this);     // Catch: Throwable -> L31
            return 1;
        L14:
            r101.recycle();     // Catch: Throwable -> L31
        L15:
            r102.recycle();     // Catch: Throwable -> L31
            monitor-exit(this);     // Catch: Throwable -> L31
        L16:
            th = move-exception;
            r101.recycle();     // Catch: Throwable -> L31
            r102.recycle();     // Catch: Throwable -> L31
            throw th;     // Catch: Throwable -> L31
        L18:
            r101.recycle();     // Catch: Throwable -> L31
        L21:
            if (tryReconnect() == false) goto L26;
            int r104 = unregisterRemoteCallBack(r100);     // Catch: Throwable -> L16
            r101.recycle();     // Catch: Throwable -> L31
            r102.recycle();     // Catch: Throwable -> L31
            return r104;
        L26:
            r101.recycle();     // Catch: Throwable -> L31
        L31:
            th = move-exception;
            throw th;
        L34:
            return 0;
        }

        @Override // com.vivo.libra.ILibraSdk
        public boolean checkPermission(String r100) {
            Parcel r101 = Parcel.obtain();
            Parcel r102 = Parcel.obtain();
            r101.writeString(r100);     // Catch: Throwable -> L23 RemoteException -> L25
            INVOKEINTERFACE_com_vivo_libra_ILibraSdk$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r101, r102, 0);     // Catch: Throwable -> L23 RemoteException -> L25
            r102.readException();     // Catch: Throwable -> L23 RemoteException -> L25
            boolean r103 = r102.readBoolean();     // Catch: Throwable -> L23 RemoteException -> L25
            if (r103 == false) goto L21;
            this.mHashCode = r100;     // Catch: Throwable -> L23 RemoteException -> L25
            this.mRemote.linkToDeath(this.mLibraDeathRecipient, 0);     // Catch: Throwable -> L23 RemoteException -> L25
            String[] r104 = r102.createStringArray();     // Catch: Throwable -> L23 RemoteException -> L25
            if (r104 != null) goto L8;
        L13:
            String[] r105 = r102.createStringArray();     // Catch: Throwable -> L23 RemoteException -> L25
            if (r105 == null) goto L21;
            if (r105.length <= 0) goto L21;
            int r106 = r105.length;     // Catch: Throwable -> L23 RemoteException -> L25
            int r107 = 0;
        L18:
            if (r107 >= r106) goto L20;
            String r108 = r105[r107];     // Catch: Throwable -> L23 RemoteException -> L25
            this.mEvents.put(r108, r108);     // Catch: Throwable -> L23 RemoteException -> L25
            r107 = r107 + 1;     // Catch: Throwable -> L23 RemoteException -> L25
            goto L18
        L20:
            Objects.toString(this.mEvents.keySet());     // Catch: Throwable -> L23 RemoteException -> L25
        L8:
            if (r104.length <= 0) goto L13;
            int r109 = r104.length;     // Catch: Throwable -> L23 RemoteException -> L25
            int r110 = 0;
        L10:
            if (r110 >= r109) goto L12;
            String r111 = r104[r110];     // Catch: Throwable -> L23 RemoteException -> L25
            this.mSupports.put(r111, r111);     // Catch: Throwable -> L23 RemoteException -> L25
            r110 = r110 + 1;     // Catch: Throwable -> L23 RemoteException -> L25
            goto L10
        L12:
            Objects.toString(this.mSupports.keySet());     // Catch: Throwable -> L23 RemoteException -> L25
        L21:
            r101.recycle();
            r102.recycle();
            return r103;
        L25:
            tryReconnect();     // Catch: Throwable -> L23
            r101.recycle();
            r102.recycle();
            return false;
        L23:
            th = move-exception;
            r101.recycle();
            r102.recycle();
            throw th;
        }

        @Override // com.vivo.libra.ILibraSdk
        public int getIntResult(String r100) {
            if (this.mSupports.containsKey(r100) == false) goto L19;
            Parcel r101 = Parcel.obtain();
            Parcel r102 = Parcel.obtain();
            r101.writeString(r100);     // Catch: Throwable -> L8 Exception -> L10 RemoteException -> L12
            INVOKEINTERFACE_com_vivo_libra_ILibraSdk$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r101, r102, 0);     // Catch: Throwable -> L8 Exception -> L10 RemoteException -> L12
            r102.readException();     // Catch: Throwable -> L8 Exception -> L10 RemoteException -> L12
            int r103 = r102.readInt();     // Catch: Throwable -> L8 Exception -> L10 RemoteException -> L12
            r102.recycle();
            r101.recycle();
            return r103;
        L8:
            th = move-exception;
            r102.recycle();
            r101.recycle();
            throw th;
        L13:
            if (tryReconnect() == false) goto L11;
            int r104 = getIntResult(r100);     // Catch: Throwable -> L8
            r102.recycle();
            r101.recycle();
            return r104;
        L11:
            r102.recycle();
            r101.recycle();
            return -2740;
        L19:
            return -2740;
        }

        @Override // com.vivo.libra.ILibraSdk
        public int getIntRetOne(String r100) {
            int r101 = getIntResult(r100);
            if (r101 != (-2740)) goto L6;
            return -1;
        L6:
            return r101;
        }

        @Override // com.vivo.libra.ILibraSdk
        public boolean hasEvent(String r100) {
            if (r100 != null) goto L6;
            return false;
        L6:
            return this.mEvents.containsKey(r100);
        }

        @Override // com.vivo.libra.ILibraSdk
        public boolean hasFun(String r100) {
            if (r100 != null) goto L6;
            return false;
        L6:
            return this.mSupports.containsKey(r100);
        }

        private boolean checkErrorArgs(List<String> r100, CallBack r101) {
            if (r100 == null) goto L18;
            if (r101 == null) goto L18;
            if (r100.isEmpty() == true) goto L18;
            int r102 = 0;
        L10:
            if (r102 >= r100.size()) goto L17;
            String r103 = (String) ListProtector.get(r100, r102);
            if (this.mEvents.containsKey(r103) == true) goto L15;
            r100.remove(r103);
            r102 = r102 - 1;
        L15:
            r102 = r102 + 1;
            goto L10
        L17:
            return r100.isEmpty();
        L18:
            return true;
        }

        private List<String> checkLocalEvent(List<String> r100, CallBack r101) {
            if (this.mBBinder != null) goto L5;
            return null;
        L5:
            Iterator<String> r102 = r100.iterator();
        L7:
            if (r102.hasNext() == false) goto L12;
            String r103 = r102.next();
            if (this.mBBinder.inMap(r103) == true) goto L7;
            boolean r104 = true;
        L13:
            if (r104 == false) goto L16;
            return null;
        L16:
            if (this.mRemote.pingBinder() == false) goto L22;
            Iterator<String> r105 = r100.iterator();
        L19:
            if (r105.hasNext() == false) goto L21;
            String r106 = r105.next();
            this.mBBinder.addLister(r106, r101);
            goto L19
        L21:
            return r100;
        L22:
            return null;
        L12:
            r104 = false;
            goto L13
        }

        @Override // com.vivo.libra.ILibraSdk
        public Bundle exec(String r100, Bundle r101) {
            if (this.mSupports.containsKey(r100) == false) goto L17;
            Parcel r102 = Parcel.obtain();
            Parcel r103 = Parcel.obtain();
            r102.writeString(r100);     // Catch: Throwable -> L8 Exception -> L19 RemoteException -> L11
            r102.writeBundle(r101);     // Catch: Throwable -> L8 Exception -> L19 RemoteException -> L11
            INVOKEINTERFACE_com_vivo_libra_ILibraSdk$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r102, r103, 0);     // Catch: Throwable -> L8 Exception -> L19 RemoteException -> L11
            r103.readException();     // Catch: Throwable -> L8 Exception -> L19 RemoteException -> L11
            Bundle r104 = r103.readBundle(Proxy.class.getClassLoader());     // Catch: Throwable -> L8 Exception -> L19 RemoteException -> L11
        L6:
            r103.recycle();
            r102.recycle();
            return r104;
        L8:
            th = move-exception;
            r103.recycle();
            r102.recycle();
            throw th;
        L12:
            if (tryReconnect() == false) goto L10;
            r104 = exec(r100, r101);     // Catch: Throwable -> L8
        L10:
            r103.recycle();
            r102.recycle();
            return null;
        L17:
            return null;
        }

        @Override // com.vivo.libra.ILibraSdk
        public void note(String r100, Bundle r101) {
            if (this.mSupports.containsKey("note") == false) goto L15;
            Parcel r102 = Parcel.obtain();
            r102.writeString(r100);     // Catch: Throwable -> L7 RemoteException -> L9
            r102.writeBundle(r101);     // Catch: Throwable -> L7 RemoteException -> L9
            INVOKEINTERFACE_com_vivo_libra_ILibraSdk$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r102, null, 0);     // Catch: Throwable -> L7 RemoteException -> L9
        L6:
            r102.recycle();
            return;
        L7:
            th = move-exception;
            r102.recycle();
            throw th;
        L10:
            if (tryReconnect() == false) goto L6;
            note(r100, r101);     // Catch: Throwable -> L7
            goto L6
        }

        @Override // com.vivo.libra.ILibraSdk
        public List<String> registerCallBack(List<String> r110, CallBack r111) {
            if (checkErrorArgs(r110, r111) == false) goto L5;
            return null;
        L5:
            List<String> r100 = checkLocalEvent(r110, r111);
            if (r100 == null) goto L8;
            return r100;
        L8:
            monitor-enter(this);
        L41:
            th = move-exception;
            throw th;
        L10:
            if (this.mBBinder != null) goto L12;
            this.mBBinder = new BBinder();     // Catch: Throwable -> L41
        L12:
            Parcel r101 = Parcel.obtain();     // Catch: Throwable -> L41
            Parcel r102 = Parcel.obtain();     // Catch: Throwable -> L41
            r101.writeStrongBinder(this.mBBinder);     // Catch: Throwable -> L26 Exception -> L28 RemoteException -> L30
            int r103 = 0;
            r101.writeStringArray((String[]) r110.toArray(new String[0]));     // Catch: Throwable -> L26 Exception -> L28 RemoteException -> L30
            INVOKEINTERFACE_com_vivo_libra_ILibraSdk$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r101, r102, 0);     // Catch: Throwable -> L26 Exception -> L28 RemoteException -> L30
            r102.readException();     // Catch: Throwable -> L26 Exception -> L28 RemoteException -> L30
            String r104 = r102.readString();     // Catch: Throwable -> L26 Exception -> L28 RemoteException -> L30
            if (r104 != null) goto L16;
        L24:
            r101.recycle();     // Catch: Throwable -> L41
        L25:
            r102.recycle();     // Catch: Throwable -> L41
            monitor-exit(this);     // Catch: Throwable -> L41
            return null;
        L16:
            if (r104.isEmpty() == true) goto L24;
            ArrayList r105 = new ArrayList();     // Catch: Throwable -> L26 Exception -> L28 RemoteException -> L30
            String[] r106 = r104.split(",");     // Catch: Throwable -> L26 Exception -> L28 RemoteException -> L30
            int r107 = r106.length;     // Catch: Throwable -> L26 Exception -> L28 RemoteException -> L30
        L18:
            if (r103 >= r107) goto L21;
            String r108 = r106[r103];     // Catch: Throwable -> L26 Exception -> L28 RemoteException -> L30
            r105.add(r108);     // Catch: Throwable -> L26 Exception -> L28 RemoteException -> L30
            this.mBBinder.addLister(r108, r111);     // Catch: Throwable -> L26 Exception -> L28 RemoteException -> L30
            r103 = r103 + 1;
            goto L18
            goto L31
        L21:
            r101.recycle();     // Catch: Throwable -> L41
            r102.recycle();     // Catch: Throwable -> L41
            monitor-exit(this);     // Catch: Throwable -> L41
            return r105;
        L26:
            th = move-exception;
            r101.recycle();     // Catch: Throwable -> L41
            r102.recycle();     // Catch: Throwable -> L41
            throw th;     // Catch: Throwable -> L41
        L28:
            r101.recycle();     // Catch: Throwable -> L41
        L31:
            if (tryReconnect() == false) goto L36;
            List<String> r112 = registerCallBack(r110, r111);     // Catch: Throwable -> L26
            r101.recycle();     // Catch: Throwable -> L41
            r102.recycle();     // Catch: Throwable -> L41
            return r112;
        L36:
            r101.recycle();     // Catch: Throwable -> L41
            goto L25
        }

        @Override // com.vivo.libra.ILibraSdk
        public int unregisterCallBack(List<String> r100, CallBack r101) {
            BBinder r102 = this.mBBinder;
            if (r102 != null) goto L7;
            return -1;
        L7:
            if (r100 != null) goto L10;
            if (r101 != null) goto L10;
            List<String> r103 = r102.clearLister();
        L25:
            if (r103 != null) goto L27;
        L31:
            return 0;
        L27:
            if (r103.isEmpty() == true) goto L31;
            return unregisterRemoteCallBack(r103);
        L10:
            if (r100 != null) goto L12;
            r100 = r102.getLister(r101);
        L12:
            if (r100 == null) goto L31;
            if (r100.isEmpty() == true) goto L31;
            ArrayList r104 = new ArrayList();
            Iterator<String> r105 = r100.iterator();
        L18:
            if (r105.hasNext() == false) goto L24;
            String r106 = r105.next();
            if (this.mBBinder.inMap(r106) == false) goto L18;
            if (this.mBBinder.removeLister(r106, r101) == false) goto L18;
            r104.add(r106);
            goto L18
        L24:
            r103 = r104;
            goto L25
        }

        @Skip({"com.obric.assistant.interaction.impl.performance"})
        public static boolean INVOKEINTERFACE_com_vivo_libra_ILibraSdk$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

    boolean checkPermission(String r100);

    Bundle exec(String r100, Bundle r101);

    int getIntResult(String r100);

    int getIntRetOne(String r100);

    boolean hasEvent(String r100);

    boolean hasFun(String r100);

    void note(String r100, Bundle r101);

    List<String> registerCallBack(List<String> r100, CallBack r101);

    int unregisterCallBack(List<String> r100, CallBack r101);
}
