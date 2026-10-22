package com.bytedance.keva.ext.fast;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import androidx.camera.video.AudioStats;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import java.util.ArrayList;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes3.dex */
public interface KevaMultiProcessFastAIDL extends IInterface {

    /* JADX INFO: loaded from: classes19.dex */
    public static class Default implements KevaMultiProcessFastAIDL {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.bytedance.keva.ext.fast.KevaMultiProcessFastAIDL
        public ValueWrapper[] buildNewMap(String r100, boolean r101, boolean r102) throws RemoteException {
            return null;
        }

        @Override // com.bytedance.keva.ext.fast.KevaMultiProcessFastAIDL
        public void clear(String r100, boolean r101, boolean r102) throws RemoteException {
        }

        @Override // com.bytedance.keva.ext.fast.KevaMultiProcessFastAIDL
        public boolean contains(String r100, boolean r101, boolean r102, String r103) throws RemoteException {
            return false;
        }

        @Override // com.bytedance.keva.ext.fast.KevaMultiProcessFastAIDL
        public int count(String r100, boolean r101, boolean r102) throws RemoteException {
            return 0;
        }

        @Override // com.bytedance.keva.ext.fast.KevaMultiProcessFastAIDL
        public void dump(String r100, boolean r101, boolean r102) throws RemoteException {
        }

        @Override // com.bytedance.keva.ext.fast.KevaMultiProcessFastAIDL
        public void erase(String r100, boolean r101, boolean r102, String r103) throws RemoteException {
        }

        @Override // com.bytedance.keva.ext.fast.KevaMultiProcessFastAIDL
        public ValueWrapper[] getAll(String r100, boolean r101, boolean r102) throws RemoteException {
            return null;
        }

        @Override // com.bytedance.keva.ext.fast.KevaMultiProcessFastAIDL
        public boolean getBoolean(String r100, boolean r101, boolean r102, String r103, boolean r104) throws RemoteException {
            return false;
        }

        @Override // com.bytedance.keva.ext.fast.KevaMultiProcessFastAIDL
        public byte[] getBytes(String r100, boolean r101, boolean r102, String r103, byte[] r104) throws RemoteException {
            return null;
        }

        @Override // com.bytedance.keva.ext.fast.KevaMultiProcessFastAIDL
        public byte[] getBytesJustDisk(String r100, boolean r101, boolean r102, String r103, byte[] r104) throws RemoteException {
            return null;
        }

        @Override // com.bytedance.keva.ext.fast.KevaMultiProcessFastAIDL
        public double getDouble(String r100, boolean r101, boolean r102, String r103, double r104) throws RemoteException {
            return AudioStats.AUDIO_AMPLITUDE_NONE;
        }

        @Override // com.bytedance.keva.ext.fast.KevaMultiProcessFastAIDL
        public float getFloat(String r100, boolean r101, boolean r102, String r103, float r104) throws RemoteException {
            return 0.0f;
        }

        @Override // com.bytedance.keva.ext.fast.KevaMultiProcessFastAIDL
        public int getInt(String r100, boolean r101, boolean r102, String r103, int r104) throws RemoteException {
            return 0;
        }

        @Override // com.bytedance.keva.ext.fast.KevaMultiProcessFastAIDL
        public long getLong(String r100, boolean r101, boolean r102, String r103, long r104) throws RemoteException {
            return 0;
        }

        @Override // com.bytedance.keva.ext.fast.KevaMultiProcessFastAIDL
        public String getString(String r100, boolean r101, boolean r102, String r103, String r104) throws RemoteException {
            return null;
        }

        @Override // com.bytedance.keva.ext.fast.KevaMultiProcessFastAIDL
        public String[] getStringArray(String r100, boolean r101, boolean r102, String r103, String[] r104) throws RemoteException {
            return null;
        }

        @Override // com.bytedance.keva.ext.fast.KevaMultiProcessFastAIDL
        public String[] getStringArrayJustDisk(String r100, boolean r101, boolean r102, String r103, String[] r104) throws RemoteException {
            return null;
        }

        @Override // com.bytedance.keva.ext.fast.KevaMultiProcessFastAIDL
        public String getStringJustDisk(String r100, boolean r101, boolean r102, String r103, String r104) throws RemoteException {
            return null;
        }

        @Override // com.bytedance.keva.ext.fast.KevaMultiProcessFastAIDL
        public List<String> getStringSet(String r100, boolean r101, boolean r102, String r103, List<String> r104) throws RemoteException {
            return null;
        }

        @Override // com.bytedance.keva.ext.fast.KevaMultiProcessFastAIDL
        public List<String> getStringSetJustDisk(String r100, boolean r101, boolean r102, String r103, List<String> r104) throws RemoteException {
            return null;
        }

        @Override // com.bytedance.keva.ext.fast.KevaMultiProcessFastAIDL
        public void init(String r100, boolean r101, boolean r102) throws RemoteException {
        }

        @Override // com.bytedance.keva.ext.fast.KevaMultiProcessFastAIDL
        public void storeBoolean(String r100, boolean r101, boolean r102, String r103, boolean r104) throws RemoteException {
        }

        @Override // com.bytedance.keva.ext.fast.KevaMultiProcessFastAIDL
        public void storeBytes(String r100, boolean r101, boolean r102, String r103, byte[] r104) throws RemoteException {
        }

        @Override // com.bytedance.keva.ext.fast.KevaMultiProcessFastAIDL
        public void storeBytesJustDisk(String r100, boolean r101, boolean r102, String r103, byte[] r104) throws RemoteException {
        }

        @Override // com.bytedance.keva.ext.fast.KevaMultiProcessFastAIDL
        public void storeDouble(String r100, boolean r101, boolean r102, String r103, double r104) throws RemoteException {
        }

        @Override // com.bytedance.keva.ext.fast.KevaMultiProcessFastAIDL
        public void storeFloat(String r100, boolean r101, boolean r102, String r103, float r104) throws RemoteException {
        }

        @Override // com.bytedance.keva.ext.fast.KevaMultiProcessFastAIDL
        public void storeInt(String r100, boolean r101, boolean r102, String r103, int r104) throws RemoteException {
        }

        @Override // com.bytedance.keva.ext.fast.KevaMultiProcessFastAIDL
        public void storeLong(String r100, boolean r101, boolean r102, String r103, long r104) throws RemoteException {
        }

        @Override // com.bytedance.keva.ext.fast.KevaMultiProcessFastAIDL
        public void storeString(String r100, boolean r101, boolean r102, String r103, String r104) throws RemoteException {
        }

        @Override // com.bytedance.keva.ext.fast.KevaMultiProcessFastAIDL
        public void storeStringArray(String r100, boolean r101, boolean r102, String r103, String[] r104) throws RemoteException {
        }

        @Override // com.bytedance.keva.ext.fast.KevaMultiProcessFastAIDL
        public void storeStringArrayJustDisk(String r100, boolean r101, boolean r102, String r103, String[] r104) throws RemoteException {
        }

        @Override // com.bytedance.keva.ext.fast.KevaMultiProcessFastAIDL
        public void storeStringJustDisk(String r100, boolean r101, boolean r102, String r103, String r104) throws RemoteException {
        }

        @Override // com.bytedance.keva.ext.fast.KevaMultiProcessFastAIDL
        public void storeStringSet(String r100, boolean r101, boolean r102, String r103, List<String> r104) throws RemoteException {
        }

        @Override // com.bytedance.keva.ext.fast.KevaMultiProcessFastAIDL
        public void storeStringSetJustDisk(String r100, boolean r101, boolean r102, String r103, List<String> r104) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements KevaMultiProcessFastAIDL {
        private static final String DESCRIPTOR = "com.bytedance.keva.ext.fast.KevaMultiProcessFastAIDL";
        static final int TRANSACTION_buildNewMap = 34;
        static final int TRANSACTION_clear = 16;
        static final int TRANSACTION_contains = 32;
        static final int TRANSACTION_count = 18;
        static final int TRANSACTION_dump = 17;
        static final int TRANSACTION_erase = 15;
        static final int TRANSACTION_getAll = 33;
        static final int TRANSACTION_getBoolean = 23;
        static final int TRANSACTION_getBytes = 24;
        static final int TRANSACTION_getBytesJustDisk = 31;
        static final int TRANSACTION_getDouble = 21;
        static final int TRANSACTION_getFloat = 22;
        static final int TRANSACTION_getInt = 19;
        static final int TRANSACTION_getLong = 20;
        static final int TRANSACTION_getString = 27;
        static final int TRANSACTION_getStringArray = 26;
        static final int TRANSACTION_getStringArrayJustDisk = 29;
        static final int TRANSACTION_getStringJustDisk = 28;
        static final int TRANSACTION_getStringSet = 25;
        static final int TRANSACTION_getStringSetJustDisk = 30;
        static final int TRANSACTION_init = 1;
        static final int TRANSACTION_storeBoolean = 3;
        static final int TRANSACTION_storeBytes = 10;
        static final int TRANSACTION_storeBytesJustDisk = 14;
        static final int TRANSACTION_storeDouble = 6;
        static final int TRANSACTION_storeFloat = 2;
        static final int TRANSACTION_storeInt = 4;
        static final int TRANSACTION_storeLong = 5;
        static final int TRANSACTION_storeString = 7;
        static final int TRANSACTION_storeStringArray = 9;
        static final int TRANSACTION_storeStringArrayJustDisk = 12;
        static final int TRANSACTION_storeStringJustDisk = 11;
        static final int TRANSACTION_storeStringSet = 8;
        static final int TRANSACTION_storeStringSetJustDisk = 13;

        /* JADX INFO: loaded from: classes19.dex */
        public static class Proxy implements KevaMultiProcessFastAIDL {
            public static KevaMultiProcessFastAIDL sDefaultImpl;
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

            @Override // com.bytedance.keva.ext.fast.KevaMultiProcessFastAIDL
            public ValueWrapper[] buildNewMap(String r100, boolean r101, boolean r102) throws RemoteException {
                Parcel r103 = Parcel.obtain();
                Parcel r104 = Parcel.obtain();
                r103.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L21
                r103.writeString(r100);     // Catch: Throwable -> L21
                int r105 = 1;
                if (r101 == false) goto L6;
                int r106 = 1;
            L7:
                r103.writeInt(r106);     // Catch: Throwable -> L21
                if (r102 == true) goto L11;
                r105 = 0;
            L11:
                r103.writeInt(r105);     // Catch: Throwable -> L21
                if (INVOKEINTERFACE_com_bytedance_keva_ext_fast_KevaMultiProcessFastAIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 34, r103, r104, 0) == false) goto L14;
            L18:
                r104.readException();     // Catch: Throwable -> L21
                ValueWrapper[] r107 = (ValueWrapper[]) r104.createTypedArray(ValueWrapper.CREATOR);     // Catch: Throwable -> L21
                r104.recycle();
                r103.recycle();
                return r107;
            L14:
                if (Stub.getDefaultImpl() == null) goto L18;
                ValueWrapper[] r108 = Stub.getDefaultImpl().buildNewMap(r100, r101, r102);     // Catch: Throwable -> L21
                r104.recycle();
                r103.recycle();
                return r108;
            L6:
                r106 = 0;
            L21:
                th = move-exception;
                r104.recycle();
                r103.recycle();
                throw th;
            }

            @Override // com.bytedance.keva.ext.fast.KevaMultiProcessFastAIDL
            public void clear(String r100, boolean r101, boolean r102) throws RemoteException {
                Parcel r103 = Parcel.obtain();
                Parcel r104 = Parcel.obtain();
                r103.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L21
                r103.writeString(r100);     // Catch: Throwable -> L21
                int r105 = 1;
                if (r101 == false) goto L6;
                int r106 = 1;
            L7:
                r103.writeInt(r106);     // Catch: Throwable -> L21
                if (r102 == true) goto L11;
                r105 = 0;
            L11:
                r103.writeInt(r105);     // Catch: Throwable -> L21
                if (INVOKEINTERFACE_com_bytedance_keva_ext_fast_KevaMultiProcessFastAIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 16, r103, r104, 0) == false) goto L14;
            L18:
                r104.readException();     // Catch: Throwable -> L21
                r104.recycle();
                r103.recycle();
                return;
            L14:
                if (Stub.getDefaultImpl() == null) goto L18;
                Stub.getDefaultImpl().clear(r100, r101, r102);     // Catch: Throwable -> L21
                r104.recycle();
                r103.recycle();
                return;
            L6:
                r106 = 0;
            L21:
                th = move-exception;
                r104.recycle();
                r103.recycle();
                throw th;
            }

            @Override // com.bytedance.keva.ext.fast.KevaMultiProcessFastAIDL
            public int count(String r100, boolean r101, boolean r102) throws RemoteException {
                Parcel r103 = Parcel.obtain();
                Parcel r104 = Parcel.obtain();
                r103.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L21
                r103.writeString(r100);     // Catch: Throwable -> L21
                int r105 = 1;
                if (r101 == false) goto L6;
                int r106 = 1;
            L7:
                r103.writeInt(r106);     // Catch: Throwable -> L21
                if (r102 == true) goto L11;
                r105 = 0;
            L11:
                r103.writeInt(r105);     // Catch: Throwable -> L21
                if (INVOKEINTERFACE_com_bytedance_keva_ext_fast_KevaMultiProcessFastAIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 18, r103, r104, 0) == false) goto L14;
            L18:
                r104.readException();     // Catch: Throwable -> L21
                int r107 = r104.readInt();     // Catch: Throwable -> L21
                r104.recycle();
                r103.recycle();
                return r107;
            L14:
                if (Stub.getDefaultImpl() == null) goto L18;
                int r108 = Stub.getDefaultImpl().count(r100, r101, r102);     // Catch: Throwable -> L21
                r104.recycle();
                r103.recycle();
                return r108;
            L6:
                r106 = 0;
            L21:
                th = move-exception;
                r104.recycle();
                r103.recycle();
                throw th;
            }

            @Override // com.bytedance.keva.ext.fast.KevaMultiProcessFastAIDL
            public void dump(String r100, boolean r101, boolean r102) throws RemoteException {
                Parcel r103 = Parcel.obtain();
                Parcel r104 = Parcel.obtain();
                r103.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L21
                r103.writeString(r100);     // Catch: Throwable -> L21
                int r105 = 1;
                if (r101 == false) goto L6;
                int r106 = 1;
            L7:
                r103.writeInt(r106);     // Catch: Throwable -> L21
                if (r102 == true) goto L11;
                r105 = 0;
            L11:
                r103.writeInt(r105);     // Catch: Throwable -> L21
                if (INVOKEINTERFACE_com_bytedance_keva_ext_fast_KevaMultiProcessFastAIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 17, r103, r104, 0) == false) goto L14;
            L18:
                r104.readException();     // Catch: Throwable -> L21
                r104.recycle();
                r103.recycle();
                return;
            L14:
                if (Stub.getDefaultImpl() == null) goto L18;
                Stub.getDefaultImpl().dump(r100, r101, r102);     // Catch: Throwable -> L21
                r104.recycle();
                r103.recycle();
                return;
            L6:
                r106 = 0;
            L21:
                th = move-exception;
                r104.recycle();
                r103.recycle();
                throw th;
            }

            @Override // com.bytedance.keva.ext.fast.KevaMultiProcessFastAIDL
            public ValueWrapper[] getAll(String r100, boolean r101, boolean r102) throws RemoteException {
                Parcel r103 = Parcel.obtain();
                Parcel r104 = Parcel.obtain();
                r103.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L21
                r103.writeString(r100);     // Catch: Throwable -> L21
                int r105 = 1;
                if (r101 == false) goto L6;
                int r106 = 1;
            L7:
                r103.writeInt(r106);     // Catch: Throwable -> L21
                if (r102 == true) goto L11;
                r105 = 0;
            L11:
                r103.writeInt(r105);     // Catch: Throwable -> L21
                if (INVOKEINTERFACE_com_bytedance_keva_ext_fast_KevaMultiProcessFastAIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 33, r103, r104, 0) == false) goto L14;
            L18:
                r104.readException();     // Catch: Throwable -> L21
                ValueWrapper[] r107 = (ValueWrapper[]) r104.createTypedArray(ValueWrapper.CREATOR);     // Catch: Throwable -> L21
                r104.recycle();
                r103.recycle();
                return r107;
            L14:
                if (Stub.getDefaultImpl() == null) goto L18;
                ValueWrapper[] r108 = Stub.getDefaultImpl().getAll(r100, r101, r102);     // Catch: Throwable -> L21
                r104.recycle();
                r103.recycle();
                return r108;
            L6:
                r106 = 0;
            L21:
                th = move-exception;
                r104.recycle();
                r103.recycle();
                throw th;
            }

            @Override // com.bytedance.keva.ext.fast.KevaMultiProcessFastAIDL
            public void init(String r100, boolean r101, boolean r102) throws RemoteException {
                Parcel r103 = Parcel.obtain();
                Parcel r104 = Parcel.obtain();
                r103.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L21
                r103.writeString(r100);     // Catch: Throwable -> L21
                if (r101 == false) goto L6;
                int r105 = 1;
            L7:
                r103.writeInt(r105);     // Catch: Throwable -> L21
                if (r102 == false) goto L10;
                int r106 = 1;
            L11:
                r103.writeInt(r106);     // Catch: Throwable -> L21
                if (INVOKEINTERFACE_com_bytedance_keva_ext_fast_KevaMultiProcessFastAIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r103, r104, 0) == false) goto L14;
            L18:
                r104.readException();     // Catch: Throwable -> L21
                r104.recycle();
                r103.recycle();
                return;
            L14:
                if (Stub.getDefaultImpl() == null) goto L18;
                Stub.getDefaultImpl().init(r100, r101, r102);     // Catch: Throwable -> L21
                r104.recycle();
                r103.recycle();
                return;
            L10:
                r106 = 0;
                goto L11
            L6:
                r105 = 0;
            L21:
                th = move-exception;
                r104.recycle();
                r103.recycle();
                throw th;
            }

            @Override // com.bytedance.keva.ext.fast.KevaMultiProcessFastAIDL
            public boolean contains(String r100, boolean r101, boolean r102, String r110) throws RemoteException {
                Parcel r103 = Parcel.obtain();
                Parcel r104 = Parcel.obtain();
                r103.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L24
                r103.writeString(r100);     // Catch: Throwable -> L24
                boolean r105 = true;
                if (r101 == false) goto L6;
                int r106 = 1;
            L7:
                r103.writeInt(r106);     // Catch: Throwable -> L24
                if (r102 == false) goto L10;
                int r107 = 1;
            L11:
                r103.writeInt(r107);     // Catch: Throwable -> L24
                r103.writeString(r110);     // Catch: Throwable -> L24
                if (INVOKEINTERFACE_com_bytedance_keva_ext_fast_KevaMultiProcessFastAIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 32, r103, r104, 0) == false) goto L14;
            L18:
                r104.readException();     // Catch: Throwable -> L24
                if (r104.readInt() != 0) goto L22;
                r105 = false;
            L22:
                r104.recycle();
                r103.recycle();
                return r105;
            L14:
                if (Stub.getDefaultImpl() == null) goto L18;
                boolean r108 = Stub.getDefaultImpl().contains(r100, r101, r102, r110);     // Catch: Throwable -> L24
                r104.recycle();
                r103.recycle();
                return r108;
            L10:
                r107 = 0;
                goto L11
            L6:
                r106 = 0;
            L24:
                th = move-exception;
                r104.recycle();
                r103.recycle();
                throw th;
            }

            @Override // com.bytedance.keva.ext.fast.KevaMultiProcessFastAIDL
            public void erase(String r100, boolean r101, boolean r102, String r103) throws RemoteException {
                Parcel r104 = Parcel.obtain();
                Parcel r105 = Parcel.obtain();
                r104.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L21
                r104.writeString(r100);     // Catch: Throwable -> L21
                int r106 = 1;
                if (r101 == false) goto L6;
                int r107 = 1;
            L7:
                r104.writeInt(r107);     // Catch: Throwable -> L21
                if (r102 == true) goto L11;
                r106 = 0;
            L11:
                r104.writeInt(r106);     // Catch: Throwable -> L21
                r104.writeString(r103);     // Catch: Throwable -> L21
                if (INVOKEINTERFACE_com_bytedance_keva_ext_fast_KevaMultiProcessFastAIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 15, r104, r105, 0) == false) goto L14;
            L18:
                r105.readException();     // Catch: Throwable -> L21
                r105.recycle();
                r104.recycle();
                return;
            L14:
                if (Stub.getDefaultImpl() == null) goto L18;
                Stub.getDefaultImpl().erase(r100, r101, r102, r103);     // Catch: Throwable -> L21
                r105.recycle();
                r104.recycle();
                return;
            L6:
                r107 = 0;
            L21:
                th = move-exception;
                r105.recycle();
                r104.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_bytedance_keva_ext_fast_KevaMultiProcessFastAIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

            @Override // com.bytedance.keva.ext.fast.KevaMultiProcessFastAIDL
            public boolean getBoolean(String r110, boolean r111, boolean r112, String r113, boolean r114) throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L28
                r100.writeString(r110);     // Catch: Throwable -> L28
                boolean r102 = true;
                if (r111 == false) goto L6;
                int r103 = 1;
            L7:
                r100.writeInt(r103);     // Catch: Throwable -> L28
                if (r112 == false) goto L10;
                int r104 = 1;
            L11:
                r100.writeInt(r104);     // Catch: Throwable -> L28
                r100.writeString(r113);     // Catch: Throwable -> L28
                if (r114 == false) goto L14;
                int r105 = 1;
            L15:
                r100.writeInt(r105);     // Catch: Throwable -> L28
                if (INVOKEINTERFACE_com_bytedance_keva_ext_fast_KevaMultiProcessFastAIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 23, r100, r101, 0) == false) goto L18;
            L22:
                r101.readException();     // Catch: Throwable -> L28
                if (r101.readInt() != 0) goto L26;
                r102 = false;
            L26:
                r101.recycle();
                r100.recycle();
                return r102;
            L18:
                if (Stub.getDefaultImpl() == null) goto L22;
                boolean r106 = Stub.getDefaultImpl().getBoolean(r110, r111, r112, r113, r114);     // Catch: Throwable -> L28
                r101.recycle();
                r100.recycle();
                return r106;
            L14:
                r105 = 0;
                goto L15
            L10:
                r104 = 0;
                goto L11
            L6:
                r103 = 0;
            L28:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.bytedance.keva.ext.fast.KevaMultiProcessFastAIDL
            public byte[] getBytes(String r110, boolean r111, boolean r112, String r113, byte[] r114) throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L21
                r100.writeString(r110);     // Catch: Throwable -> L21
                int r102 = 1;
                if (r111 == false) goto L6;
                int r103 = 1;
            L7:
                r100.writeInt(r103);     // Catch: Throwable -> L21
                if (r112 == true) goto L11;
                r102 = 0;
            L11:
                r100.writeInt(r102);     // Catch: Throwable -> L21
                r100.writeString(r113);     // Catch: Throwable -> L21
                r100.writeByteArray(r114);     // Catch: Throwable -> L21
                if (INVOKEINTERFACE_com_bytedance_keva_ext_fast_KevaMultiProcessFastAIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 24, r100, r101, 0) == false) goto L14;
            L18:
                r101.readException();     // Catch: Throwable -> L21
                byte[] r115 = r101.createByteArray();     // Catch: Throwable -> L21
                r101.recycle();
                r100.recycle();
                return r115;
            L14:
                if (Stub.getDefaultImpl() == null) goto L18;
                byte[] r116 = Stub.getDefaultImpl().getBytes(r110, r111, r112, r113, r114);     // Catch: Throwable -> L21
                r101.recycle();
                r100.recycle();
                return r116;
            L6:
                r103 = 0;
            L21:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.bytedance.keva.ext.fast.KevaMultiProcessFastAIDL
            public byte[] getBytesJustDisk(String r110, boolean r111, boolean r112, String r113, byte[] r114) throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L21
                r100.writeString(r110);     // Catch: Throwable -> L21
                int r102 = 1;
                if (r111 == false) goto L6;
                int r103 = 1;
            L7:
                r100.writeInt(r103);     // Catch: Throwable -> L21
                if (r112 == true) goto L11;
                r102 = 0;
            L11:
                r100.writeInt(r102);     // Catch: Throwable -> L21
                r100.writeString(r113);     // Catch: Throwable -> L21
                r100.writeByteArray(r114);     // Catch: Throwable -> L21
                if (INVOKEINTERFACE_com_bytedance_keva_ext_fast_KevaMultiProcessFastAIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 31, r100, r101, 0) == false) goto L14;
            L18:
                r101.readException();     // Catch: Throwable -> L21
                byte[] r115 = r101.createByteArray();     // Catch: Throwable -> L21
                r101.recycle();
                r100.recycle();
                return r115;
            L14:
                if (Stub.getDefaultImpl() == null) goto L18;
                byte[] r116 = Stub.getDefaultImpl().getBytesJustDisk(r110, r111, r112, r113, r114);     // Catch: Throwable -> L21
                r101.recycle();
                r100.recycle();
                return r116;
            L6:
                r103 = 0;
            L21:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.bytedance.keva.ext.fast.KevaMultiProcessFastAIDL
            public double getDouble(String r110, boolean r111, boolean r112, String r113, double r114) throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L25
                r100.writeString(r110);     // Catch: Throwable -> L25
                int r102 = 1;
                if (r111 == false) goto L6;
                int r103 = 1;
            L7:
                r100.writeInt(r103);     // Catch: Throwable -> L25
                if (r112 == true) goto L11;
                r102 = 0;
            L11:
                r100.writeInt(r102);     // Catch: Throwable -> L25
                r100.writeString(r113);     // Catch: Throwable -> L25
                r100.writeDouble(r114);     // Catch: Throwable -> L25
            L23:
                th = th;
            L27:
                r101.recycle();
                r100.recycle();
                throw th;
            L14:
                if (INVOKEINTERFACE_com_bytedance_keva_ext_fast_KevaMultiProcessFastAIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 21, r100, r101, 0) == false) goto L16;
            L20:
                r101.readException();     // Catch: Throwable -> L23
                double r104 = r101.readDouble();     // Catch: Throwable -> L23
                r101.recycle();
                r100.recycle();
                return r104;
            L16:
                if (Stub.getDefaultImpl() == null) goto L20;
                double r105 = Stub.getDefaultImpl().getDouble(r110, r111, r112, r113, r114);     // Catch: Throwable -> L23
                r101.recycle();
                r100.recycle();
                return r105;
            L6:
                r103 = 0;
            L25:
                th = th;
                goto L27
            }

            @Override // com.bytedance.keva.ext.fast.KevaMultiProcessFastAIDL
            public float getFloat(String r110, boolean r111, boolean r112, String r113, float r114) throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L21
                r100.writeString(r110);     // Catch: Throwable -> L21
                int r102 = 1;
                if (r111 == false) goto L6;
                int r103 = 1;
            L7:
                r100.writeInt(r103);     // Catch: Throwable -> L21
                if (r112 == true) goto L11;
                r102 = 0;
            L11:
                r100.writeInt(r102);     // Catch: Throwable -> L21
                r100.writeString(r113);     // Catch: Throwable -> L21
                r100.writeFloat(r114);     // Catch: Throwable -> L21
                if (INVOKEINTERFACE_com_bytedance_keva_ext_fast_KevaMultiProcessFastAIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 22, r100, r101, 0) == false) goto L14;
            L18:
                r101.readException();     // Catch: Throwable -> L21
                float r115 = r101.readFloat();     // Catch: Throwable -> L21
                r101.recycle();
                r100.recycle();
                return r115;
            L14:
                if (Stub.getDefaultImpl() == null) goto L18;
                float r116 = Stub.getDefaultImpl().getFloat(r110, r111, r112, r113, r114);     // Catch: Throwable -> L21
                r101.recycle();
                r100.recycle();
                return r116;
            L6:
                r103 = 0;
            L21:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.bytedance.keva.ext.fast.KevaMultiProcessFastAIDL
            public int getInt(String r110, boolean r111, boolean r112, String r113, int r114) throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L21
                r100.writeString(r110);     // Catch: Throwable -> L21
                int r102 = 1;
                if (r111 == false) goto L6;
                int r103 = 1;
            L7:
                r100.writeInt(r103);     // Catch: Throwable -> L21
                if (r112 == true) goto L11;
                r102 = 0;
            L11:
                r100.writeInt(r102);     // Catch: Throwable -> L21
                r100.writeString(r113);     // Catch: Throwable -> L21
                r100.writeInt(r114);     // Catch: Throwable -> L21
                if (INVOKEINTERFACE_com_bytedance_keva_ext_fast_KevaMultiProcessFastAIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 19, r100, r101, 0) == false) goto L14;
            L18:
                r101.readException();     // Catch: Throwable -> L21
                int r115 = r101.readInt();     // Catch: Throwable -> L21
                r101.recycle();
                r100.recycle();
                return r115;
            L14:
                if (Stub.getDefaultImpl() == null) goto L18;
                int r116 = Stub.getDefaultImpl().getInt(r110, r111, r112, r113, r114);     // Catch: Throwable -> L21
                r101.recycle();
                r100.recycle();
                return r116;
            L6:
                r103 = 0;
            L21:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.bytedance.keva.ext.fast.KevaMultiProcessFastAIDL
            public long getLong(String r110, boolean r111, boolean r112, String r113, long r114) throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L25
                r100.writeString(r110);     // Catch: Throwable -> L25
                int r102 = 1;
                if (r111 == false) goto L6;
                int r103 = 1;
            L7:
                r100.writeInt(r103);     // Catch: Throwable -> L25
                if (r112 == true) goto L11;
                r102 = 0;
            L11:
                r100.writeInt(r102);     // Catch: Throwable -> L25
                r100.writeString(r113);     // Catch: Throwable -> L25
                r100.writeLong(r114);     // Catch: Throwable -> L25
            L23:
                th = th;
            L27:
                r101.recycle();
                r100.recycle();
                throw th;
            L14:
                if (INVOKEINTERFACE_com_bytedance_keva_ext_fast_KevaMultiProcessFastAIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 20, r100, r101, 0) == false) goto L16;
            L20:
                r101.readException();     // Catch: Throwable -> L23
                long r104 = r101.readLong();     // Catch: Throwable -> L23
                r101.recycle();
                r100.recycle();
                return r104;
            L16:
                if (Stub.getDefaultImpl() == null) goto L20;
                long r105 = Stub.getDefaultImpl().getLong(r110, r111, r112, r113, r114);     // Catch: Throwable -> L23
                r101.recycle();
                r100.recycle();
                return r105;
            L6:
                r103 = 0;
            L25:
                th = th;
                goto L27
            }

            @Override // com.bytedance.keva.ext.fast.KevaMultiProcessFastAIDL
            public String getString(String r110, boolean r111, boolean r112, String r113, String r114) throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L21
                r100.writeString(r110);     // Catch: Throwable -> L21
                int r102 = 1;
                if (r111 == false) goto L6;
                int r103 = 1;
            L7:
                r100.writeInt(r103);     // Catch: Throwable -> L21
                if (r112 == true) goto L11;
                r102 = 0;
            L11:
                r100.writeInt(r102);     // Catch: Throwable -> L21
                r100.writeString(r113);     // Catch: Throwable -> L21
                r100.writeString(r114);     // Catch: Throwable -> L21
                if (INVOKEINTERFACE_com_bytedance_keva_ext_fast_KevaMultiProcessFastAIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 27, r100, r101, 0) == false) goto L14;
            L18:
                r101.readException();     // Catch: Throwable -> L21
                String r115 = r101.readString();     // Catch: Throwable -> L21
                r101.recycle();
                r100.recycle();
                return r115;
            L14:
                if (Stub.getDefaultImpl() == null) goto L18;
                String r116 = Stub.getDefaultImpl().getString(r110, r111, r112, r113, r114);     // Catch: Throwable -> L21
                r101.recycle();
                r100.recycle();
                return r116;
            L6:
                r103 = 0;
            L21:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.bytedance.keva.ext.fast.KevaMultiProcessFastAIDL
            public String[] getStringArray(String r110, boolean r111, boolean r112, String r113, String[] r114) throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L21
                r100.writeString(r110);     // Catch: Throwable -> L21
                int r102 = 1;
                if (r111 == false) goto L6;
                int r103 = 1;
            L7:
                r100.writeInt(r103);     // Catch: Throwable -> L21
                if (r112 == true) goto L11;
                r102 = 0;
            L11:
                r100.writeInt(r102);     // Catch: Throwable -> L21
                r100.writeString(r113);     // Catch: Throwable -> L21
                r100.writeStringArray(r114);     // Catch: Throwable -> L21
                if (INVOKEINTERFACE_com_bytedance_keva_ext_fast_KevaMultiProcessFastAIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 26, r100, r101, 0) == false) goto L14;
            L18:
                r101.readException();     // Catch: Throwable -> L21
                String[] r115 = r101.createStringArray();     // Catch: Throwable -> L21
                r101.recycle();
                r100.recycle();
                return r115;
            L14:
                if (Stub.getDefaultImpl() == null) goto L18;
                String[] r116 = Stub.getDefaultImpl().getStringArray(r110, r111, r112, r113, r114);     // Catch: Throwable -> L21
                r101.recycle();
                r100.recycle();
                return r116;
            L6:
                r103 = 0;
            L21:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.bytedance.keva.ext.fast.KevaMultiProcessFastAIDL
            public String[] getStringArrayJustDisk(String r110, boolean r111, boolean r112, String r113, String[] r114) throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L21
                r100.writeString(r110);     // Catch: Throwable -> L21
                int r102 = 1;
                if (r111 == false) goto L6;
                int r103 = 1;
            L7:
                r100.writeInt(r103);     // Catch: Throwable -> L21
                if (r112 == true) goto L11;
                r102 = 0;
            L11:
                r100.writeInt(r102);     // Catch: Throwable -> L21
                r100.writeString(r113);     // Catch: Throwable -> L21
                r100.writeStringArray(r114);     // Catch: Throwable -> L21
                if (INVOKEINTERFACE_com_bytedance_keva_ext_fast_KevaMultiProcessFastAIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 29, r100, r101, 0) == false) goto L14;
            L18:
                r101.readException();     // Catch: Throwable -> L21
                String[] r115 = r101.createStringArray();     // Catch: Throwable -> L21
                r101.recycle();
                r100.recycle();
                return r115;
            L14:
                if (Stub.getDefaultImpl() == null) goto L18;
                String[] r116 = Stub.getDefaultImpl().getStringArrayJustDisk(r110, r111, r112, r113, r114);     // Catch: Throwable -> L21
                r101.recycle();
                r100.recycle();
                return r116;
            L6:
                r103 = 0;
            L21:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.bytedance.keva.ext.fast.KevaMultiProcessFastAIDL
            public String getStringJustDisk(String r110, boolean r111, boolean r112, String r113, String r114) throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L21
                r100.writeString(r110);     // Catch: Throwable -> L21
                int r102 = 1;
                if (r111 == false) goto L6;
                int r103 = 1;
            L7:
                r100.writeInt(r103);     // Catch: Throwable -> L21
                if (r112 == true) goto L11;
                r102 = 0;
            L11:
                r100.writeInt(r102);     // Catch: Throwable -> L21
                r100.writeString(r113);     // Catch: Throwable -> L21
                r100.writeString(r114);     // Catch: Throwable -> L21
                if (INVOKEINTERFACE_com_bytedance_keva_ext_fast_KevaMultiProcessFastAIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 28, r100, r101, 0) == false) goto L14;
            L18:
                r101.readException();     // Catch: Throwable -> L21
                String r115 = r101.readString();     // Catch: Throwable -> L21
                r101.recycle();
                r100.recycle();
                return r115;
            L14:
                if (Stub.getDefaultImpl() == null) goto L18;
                String r116 = Stub.getDefaultImpl().getStringJustDisk(r110, r111, r112, r113, r114);     // Catch: Throwable -> L21
                r101.recycle();
                r100.recycle();
                return r116;
            L6:
                r103 = 0;
            L21:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.bytedance.keva.ext.fast.KevaMultiProcessFastAIDL
            public List<String> getStringSet(String r110, boolean r111, boolean r112, String r113, List<String> r114) throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L21
                r100.writeString(r110);     // Catch: Throwable -> L21
                int r102 = 1;
                if (r111 == false) goto L6;
                int r103 = 1;
            L7:
                r100.writeInt(r103);     // Catch: Throwable -> L21
                if (r112 == true) goto L11;
                r102 = 0;
            L11:
                r100.writeInt(r102);     // Catch: Throwable -> L21
                r100.writeString(r113);     // Catch: Throwable -> L21
                r100.writeStringList(r114);     // Catch: Throwable -> L21
                if (INVOKEINTERFACE_com_bytedance_keva_ext_fast_KevaMultiProcessFastAIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 25, r100, r101, 0) == false) goto L14;
            L18:
                r101.readException();     // Catch: Throwable -> L21
                ArrayList<String> r115 = r101.createStringArrayList();     // Catch: Throwable -> L21
                r101.recycle();
                r100.recycle();
                return r115;
            L14:
                if (Stub.getDefaultImpl() == null) goto L18;
                List<String> r116 = Stub.getDefaultImpl().getStringSet(r110, r111, r112, r113, r114);     // Catch: Throwable -> L21
                r101.recycle();
                r100.recycle();
                return r116;
            L6:
                r103 = 0;
            L21:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.bytedance.keva.ext.fast.KevaMultiProcessFastAIDL
            public List<String> getStringSetJustDisk(String r110, boolean r111, boolean r112, String r113, List<String> r114) throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L21
                r100.writeString(r110);     // Catch: Throwable -> L21
                int r102 = 1;
                if (r111 == false) goto L6;
                int r103 = 1;
            L7:
                r100.writeInt(r103);     // Catch: Throwable -> L21
                if (r112 == true) goto L11;
                r102 = 0;
            L11:
                r100.writeInt(r102);     // Catch: Throwable -> L21
                r100.writeString(r113);     // Catch: Throwable -> L21
                r100.writeStringList(r114);     // Catch: Throwable -> L21
                if (INVOKEINTERFACE_com_bytedance_keva_ext_fast_KevaMultiProcessFastAIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 30, r100, r101, 0) == false) goto L14;
            L18:
                r101.readException();     // Catch: Throwable -> L21
                ArrayList<String> r115 = r101.createStringArrayList();     // Catch: Throwable -> L21
                r101.recycle();
                r100.recycle();
                return r115;
            L14:
                if (Stub.getDefaultImpl() == null) goto L18;
                List<String> r116 = Stub.getDefaultImpl().getStringSetJustDisk(r110, r111, r112, r113, r114);     // Catch: Throwable -> L21
                r101.recycle();
                r100.recycle();
                return r116;
            L6:
                r103 = 0;
            L21:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.bytedance.keva.ext.fast.KevaMultiProcessFastAIDL
            public void storeBoolean(String r110, boolean r111, boolean r112, String r113, boolean r114) throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L25
                r100.writeString(r110);     // Catch: Throwable -> L25
                int r102 = 1;
                if (r111 == false) goto L6;
                int r103 = 1;
            L7:
                r100.writeInt(r103);     // Catch: Throwable -> L25
                if (r112 == false) goto L10;
                int r104 = 1;
            L11:
                r100.writeInt(r104);     // Catch: Throwable -> L25
                r100.writeString(r113);     // Catch: Throwable -> L25
                if (r114 == true) goto L15;
                r102 = 0;
            L15:
                r100.writeInt(r102);     // Catch: Throwable -> L25
                if (INVOKEINTERFACE_com_bytedance_keva_ext_fast_KevaMultiProcessFastAIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r100, r101, 0) == false) goto L18;
            L22:
                r101.readException();     // Catch: Throwable -> L25
                r101.recycle();
                r100.recycle();
                return;
            L18:
                if (Stub.getDefaultImpl() == null) goto L22;
                Stub.getDefaultImpl().storeBoolean(r110, r111, r112, r113, r114);     // Catch: Throwable -> L25
                r101.recycle();
                r100.recycle();
                return;
            L10:
                r104 = 0;
                goto L11
            L6:
                r103 = 0;
            L25:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.bytedance.keva.ext.fast.KevaMultiProcessFastAIDL
            public void storeBytes(String r110, boolean r111, boolean r112, String r113, byte[] r114) throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L21
                r100.writeString(r110);     // Catch: Throwable -> L21
                int r102 = 1;
                if (r111 == false) goto L6;
                int r103 = 1;
            L7:
                r100.writeInt(r103);     // Catch: Throwable -> L21
                if (r112 == true) goto L11;
                r102 = 0;
            L11:
                r100.writeInt(r102);     // Catch: Throwable -> L21
                r100.writeString(r113);     // Catch: Throwable -> L21
                r100.writeByteArray(r114);     // Catch: Throwable -> L21
                if (INVOKEINTERFACE_com_bytedance_keva_ext_fast_KevaMultiProcessFastAIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 10, r100, r101, 0) == false) goto L14;
            L18:
                r101.readException();     // Catch: Throwable -> L21
                r101.recycle();
                r100.recycle();
                return;
            L14:
                if (Stub.getDefaultImpl() == null) goto L18;
                Stub.getDefaultImpl().storeBytes(r110, r111, r112, r113, r114);     // Catch: Throwable -> L21
                r101.recycle();
                r100.recycle();
                return;
            L6:
                r103 = 0;
            L21:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.bytedance.keva.ext.fast.KevaMultiProcessFastAIDL
            public void storeBytesJustDisk(String r110, boolean r111, boolean r112, String r113, byte[] r114) throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L21
                r100.writeString(r110);     // Catch: Throwable -> L21
                int r102 = 1;
                if (r111 == false) goto L6;
                int r103 = 1;
            L7:
                r100.writeInt(r103);     // Catch: Throwable -> L21
                if (r112 == true) goto L11;
                r102 = 0;
            L11:
                r100.writeInt(r102);     // Catch: Throwable -> L21
                r100.writeString(r113);     // Catch: Throwable -> L21
                r100.writeByteArray(r114);     // Catch: Throwable -> L21
                if (INVOKEINTERFACE_com_bytedance_keva_ext_fast_KevaMultiProcessFastAIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 14, r100, r101, 0) == false) goto L14;
            L18:
                r101.readException();     // Catch: Throwable -> L21
                r101.recycle();
                r100.recycle();
                return;
            L14:
                if (Stub.getDefaultImpl() == null) goto L18;
                Stub.getDefaultImpl().storeBytesJustDisk(r110, r111, r112, r113, r114);     // Catch: Throwable -> L21
                r101.recycle();
                r100.recycle();
                return;
            L6:
                r103 = 0;
            L21:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.bytedance.keva.ext.fast.KevaMultiProcessFastAIDL
            public void storeDouble(String r110, boolean r111, boolean r112, String r113, double r114) throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L25
                r100.writeString(r110);     // Catch: Throwable -> L25
                int r102 = 1;
                if (r111 == false) goto L6;
                int r103 = 1;
            L7:
                r100.writeInt(r103);     // Catch: Throwable -> L25
                if (r112 == true) goto L11;
                r102 = 0;
            L11:
                r100.writeInt(r102);     // Catch: Throwable -> L25
                r100.writeString(r113);     // Catch: Throwable -> L25
                r100.writeDouble(r114);     // Catch: Throwable -> L25
            L23:
                th = th;
            L27:
                r101.recycle();
                r100.recycle();
                throw th;
            L14:
                if (INVOKEINTERFACE_com_bytedance_keva_ext_fast_KevaMultiProcessFastAIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 6, r100, r101, 0) == false) goto L16;
            L20:
                r101.readException();     // Catch: Throwable -> L23
                r101.recycle();
                r100.recycle();
                return;
            L16:
                if (Stub.getDefaultImpl() == null) goto L20;
                Stub.getDefaultImpl().storeDouble(r110, r111, r112, r113, r114);     // Catch: Throwable -> L23
                r101.recycle();
                r100.recycle();
                return;
            L6:
                r103 = 0;
            L25:
                th = th;
                goto L27
            }

            @Override // com.bytedance.keva.ext.fast.KevaMultiProcessFastAIDL
            public void storeFloat(String r110, boolean r111, boolean r112, String r113, float r114) throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L21
                r100.writeString(r110);     // Catch: Throwable -> L21
                int r102 = 1;
                if (r111 == false) goto L6;
                int r103 = 1;
            L7:
                r100.writeInt(r103);     // Catch: Throwable -> L21
                if (r112 == true) goto L11;
                r102 = 0;
            L11:
                r100.writeInt(r102);     // Catch: Throwable -> L21
                r100.writeString(r113);     // Catch: Throwable -> L21
                r100.writeFloat(r114);     // Catch: Throwable -> L21
                if (INVOKEINTERFACE_com_bytedance_keva_ext_fast_KevaMultiProcessFastAIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r100, r101, 0) == false) goto L14;
            L18:
                r101.readException();     // Catch: Throwable -> L21
                r101.recycle();
                r100.recycle();
                return;
            L14:
                if (Stub.getDefaultImpl() == null) goto L18;
                Stub.getDefaultImpl().storeFloat(r110, r111, r112, r113, r114);     // Catch: Throwable -> L21
                r101.recycle();
                r100.recycle();
                return;
            L6:
                r103 = 0;
            L21:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.bytedance.keva.ext.fast.KevaMultiProcessFastAIDL
            public void storeInt(String r110, boolean r111, boolean r112, String r113, int r114) throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L21
                r100.writeString(r110);     // Catch: Throwable -> L21
                int r102 = 1;
                if (r111 == false) goto L6;
                int r103 = 1;
            L7:
                r100.writeInt(r103);     // Catch: Throwable -> L21
                if (r112 == true) goto L11;
                r102 = 0;
            L11:
                r100.writeInt(r102);     // Catch: Throwable -> L21
                r100.writeString(r113);     // Catch: Throwable -> L21
                r100.writeInt(r114);     // Catch: Throwable -> L21
                if (INVOKEINTERFACE_com_bytedance_keva_ext_fast_KevaMultiProcessFastAIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r100, r101, 0) == false) goto L14;
            L18:
                r101.readException();     // Catch: Throwable -> L21
                r101.recycle();
                r100.recycle();
                return;
            L14:
                if (Stub.getDefaultImpl() == null) goto L18;
                Stub.getDefaultImpl().storeInt(r110, r111, r112, r113, r114);     // Catch: Throwable -> L21
                r101.recycle();
                r100.recycle();
                return;
            L6:
                r103 = 0;
            L21:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.bytedance.keva.ext.fast.KevaMultiProcessFastAIDL
            public void storeLong(String r110, boolean r111, boolean r112, String r113, long r114) throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L25
                r100.writeString(r110);     // Catch: Throwable -> L25
                int r102 = 1;
                if (r111 == false) goto L6;
                int r103 = 1;
            L7:
                r100.writeInt(r103);     // Catch: Throwable -> L25
                if (r112 == true) goto L11;
                r102 = 0;
            L11:
                r100.writeInt(r102);     // Catch: Throwable -> L25
                r100.writeString(r113);     // Catch: Throwable -> L25
                r100.writeLong(r114);     // Catch: Throwable -> L25
            L23:
                th = th;
            L27:
                r101.recycle();
                r100.recycle();
                throw th;
            L14:
                if (INVOKEINTERFACE_com_bytedance_keva_ext_fast_KevaMultiProcessFastAIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 5, r100, r101, 0) == false) goto L16;
            L20:
                r101.readException();     // Catch: Throwable -> L23
                r101.recycle();
                r100.recycle();
                return;
            L16:
                if (Stub.getDefaultImpl() == null) goto L20;
                Stub.getDefaultImpl().storeLong(r110, r111, r112, r113, r114);     // Catch: Throwable -> L23
                r101.recycle();
                r100.recycle();
                return;
            L6:
                r103 = 0;
            L25:
                th = th;
                goto L27
            }

            @Override // com.bytedance.keva.ext.fast.KevaMultiProcessFastAIDL
            public void storeString(String r110, boolean r111, boolean r112, String r113, String r114) throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L21
                r100.writeString(r110);     // Catch: Throwable -> L21
                int r102 = 1;
                if (r111 == false) goto L6;
                int r103 = 1;
            L7:
                r100.writeInt(r103);     // Catch: Throwable -> L21
                if (r112 == true) goto L11;
                r102 = 0;
            L11:
                r100.writeInt(r102);     // Catch: Throwable -> L21
                r100.writeString(r113);     // Catch: Throwable -> L21
                r100.writeString(r114);     // Catch: Throwable -> L21
                if (INVOKEINTERFACE_com_bytedance_keva_ext_fast_KevaMultiProcessFastAIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 7, r100, r101, 0) == false) goto L14;
            L18:
                r101.readException();     // Catch: Throwable -> L21
                r101.recycle();
                r100.recycle();
                return;
            L14:
                if (Stub.getDefaultImpl() == null) goto L18;
                Stub.getDefaultImpl().storeString(r110, r111, r112, r113, r114);     // Catch: Throwable -> L21
                r101.recycle();
                r100.recycle();
                return;
            L6:
                r103 = 0;
            L21:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.bytedance.keva.ext.fast.KevaMultiProcessFastAIDL
            public void storeStringArray(String r110, boolean r111, boolean r112, String r113, String[] r114) throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L21
                r100.writeString(r110);     // Catch: Throwable -> L21
                int r102 = 1;
                if (r111 == false) goto L6;
                int r103 = 1;
            L7:
                r100.writeInt(r103);     // Catch: Throwable -> L21
                if (r112 == true) goto L11;
                r102 = 0;
            L11:
                r100.writeInt(r102);     // Catch: Throwable -> L21
                r100.writeString(r113);     // Catch: Throwable -> L21
                r100.writeStringArray(r114);     // Catch: Throwable -> L21
                if (INVOKEINTERFACE_com_bytedance_keva_ext_fast_KevaMultiProcessFastAIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 9, r100, r101, 0) == false) goto L14;
            L18:
                r101.readException();     // Catch: Throwable -> L21
                r101.recycle();
                r100.recycle();
                return;
            L14:
                if (Stub.getDefaultImpl() == null) goto L18;
                Stub.getDefaultImpl().storeStringArray(r110, r111, r112, r113, r114);     // Catch: Throwable -> L21
                r101.recycle();
                r100.recycle();
                return;
            L6:
                r103 = 0;
            L21:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.bytedance.keva.ext.fast.KevaMultiProcessFastAIDL
            public void storeStringArrayJustDisk(String r110, boolean r111, boolean r112, String r113, String[] r114) throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L21
                r100.writeString(r110);     // Catch: Throwable -> L21
                int r102 = 1;
                if (r111 == false) goto L6;
                int r103 = 1;
            L7:
                r100.writeInt(r103);     // Catch: Throwable -> L21
                if (r112 == true) goto L11;
                r102 = 0;
            L11:
                r100.writeInt(r102);     // Catch: Throwable -> L21
                r100.writeString(r113);     // Catch: Throwable -> L21
                r100.writeStringArray(r114);     // Catch: Throwable -> L21
                if (INVOKEINTERFACE_com_bytedance_keva_ext_fast_KevaMultiProcessFastAIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 12, r100, r101, 0) == false) goto L14;
            L18:
                r101.readException();     // Catch: Throwable -> L21
                r101.recycle();
                r100.recycle();
                return;
            L14:
                if (Stub.getDefaultImpl() == null) goto L18;
                Stub.getDefaultImpl().storeStringArrayJustDisk(r110, r111, r112, r113, r114);     // Catch: Throwable -> L21
                r101.recycle();
                r100.recycle();
                return;
            L6:
                r103 = 0;
            L21:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.bytedance.keva.ext.fast.KevaMultiProcessFastAIDL
            public void storeStringJustDisk(String r110, boolean r111, boolean r112, String r113, String r114) throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L21
                r100.writeString(r110);     // Catch: Throwable -> L21
                int r102 = 1;
                if (r111 == false) goto L6;
                int r103 = 1;
            L7:
                r100.writeInt(r103);     // Catch: Throwable -> L21
                if (r112 == true) goto L11;
                r102 = 0;
            L11:
                r100.writeInt(r102);     // Catch: Throwable -> L21
                r100.writeString(r113);     // Catch: Throwable -> L21
                r100.writeString(r114);     // Catch: Throwable -> L21
                if (INVOKEINTERFACE_com_bytedance_keva_ext_fast_KevaMultiProcessFastAIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 11, r100, r101, 0) == false) goto L14;
            L18:
                r101.readException();     // Catch: Throwable -> L21
                r101.recycle();
                r100.recycle();
                return;
            L14:
                if (Stub.getDefaultImpl() == null) goto L18;
                Stub.getDefaultImpl().storeStringJustDisk(r110, r111, r112, r113, r114);     // Catch: Throwable -> L21
                r101.recycle();
                r100.recycle();
                return;
            L6:
                r103 = 0;
            L21:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.bytedance.keva.ext.fast.KevaMultiProcessFastAIDL
            public void storeStringSet(String r110, boolean r111, boolean r112, String r113, List<String> r114) throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L21
                r100.writeString(r110);     // Catch: Throwable -> L21
                int r102 = 1;
                if (r111 == false) goto L6;
                int r103 = 1;
            L7:
                r100.writeInt(r103);     // Catch: Throwable -> L21
                if (r112 == true) goto L11;
                r102 = 0;
            L11:
                r100.writeInt(r102);     // Catch: Throwable -> L21
                r100.writeString(r113);     // Catch: Throwable -> L21
                r100.writeStringList(r114);     // Catch: Throwable -> L21
                if (INVOKEINTERFACE_com_bytedance_keva_ext_fast_KevaMultiProcessFastAIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 8, r100, r101, 0) == false) goto L14;
            L18:
                r101.readException();     // Catch: Throwable -> L21
                r101.recycle();
                r100.recycle();
                return;
            L14:
                if (Stub.getDefaultImpl() == null) goto L18;
                Stub.getDefaultImpl().storeStringSet(r110, r111, r112, r113, r114);     // Catch: Throwable -> L21
                r101.recycle();
                r100.recycle();
                return;
            L6:
                r103 = 0;
            L21:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.bytedance.keva.ext.fast.KevaMultiProcessFastAIDL
            public void storeStringSetJustDisk(String r110, boolean r111, boolean r112, String r113, List<String> r114) throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L21
                r100.writeString(r110);     // Catch: Throwable -> L21
                int r102 = 1;
                if (r111 == false) goto L6;
                int r103 = 1;
            L7:
                r100.writeInt(r103);     // Catch: Throwable -> L21
                if (r112 == true) goto L11;
                r102 = 0;
            L11:
                r100.writeInt(r102);     // Catch: Throwable -> L21
                r100.writeString(r113);     // Catch: Throwable -> L21
                r100.writeStringList(r114);     // Catch: Throwable -> L21
                if (INVOKEINTERFACE_com_bytedance_keva_ext_fast_KevaMultiProcessFastAIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 13, r100, r101, 0) == false) goto L14;
            L18:
                r101.readException();     // Catch: Throwable -> L21
                r101.recycle();
                r100.recycle();
                return;
            L14:
                if (Stub.getDefaultImpl() == null) goto L18;
                Stub.getDefaultImpl().storeStringSetJustDisk(r110, r111, r112, r113, r114);     // Catch: Throwable -> L21
                r101.recycle();
                r100.recycle();
                return;
            L6:
                r103 = 0;
            L21:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static KevaMultiProcessFastAIDL getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static KevaMultiProcessFastAIDL asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof KevaMultiProcessFastAIDL) == false) goto L12;
            return (KevaMultiProcessFastAIDL) r101;
        L12:
            return new Proxy(r100);
        }

        public static boolean setDefaultImpl(KevaMultiProcessFastAIDL r100) {
            if (Proxy.sDefaultImpl != null) goto L10;
            if (r100 == null) goto L7;
            Proxy.sDefaultImpl = r100;
            return true;
        L7:
            return false;
        L10:
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        @Override // android.os.Binder
        public boolean onTransact(int r110, Parcel r111, Parcel r112, int r113) throws RemoteException {
            if (r110 == 1598968902) goto L348;
            boolean r100 = false;
            switch(r110) {
                case 1: goto L339;
                case 2: goto L329;
                case 3: goto L315;
                case 4: goto L305;
                case 5: goto L295;
                case 6: goto L285;
                case 7: goto L275;
                case 8: goto L265;
                case 9: goto L255;
                case 10: goto L245;
                case 11: goto L235;
                case 12: goto L225;
                case 13: goto L215;
                case 14: goto L205;
                case 15: goto L196;
                case 16: goto L187;
                case 17: goto L178;
                case 18: goto L169;
                case 19: goto L159;
                case 20: goto L149;
                case 21: goto L139;
                case 22: goto L129;
                case 23: goto L115;
                case 24: goto L105;
                case 25: goto L95;
                case 26: goto L85;
                case 27: goto L75;
                case 28: goto L65;
                case 29: goto L55;
                case 30: goto L45;
                case 31: goto L35;
                case 32: goto L26;
                case 33: goto L17;
                case 34: goto L8;
                default: goto L7;
            };
        L8:
            r111.enforceInterface(DESCRIPTOR);
            String r101 = r111.readString();
            if (r111.readInt() == 0) goto L11;
            boolean r102 = true;
        L13:
            if (r111.readInt() == 0) goto L15;
            r100 = true;
        L15:
            ValueWrapper[] r103 = buildNewMap(r101, r102, r100);
            r112.writeNoException();
            r112.writeTypedArray(r103, 1);
            return true;
        L11:
            r102 = false;
            goto L13
        L17:
            r111.enforceInterface(DESCRIPTOR);
            String r104 = r111.readString();
            if (r111.readInt() == 0) goto L20;
            boolean r105 = true;
        L22:
            if (r111.readInt() == 0) goto L24;
            r100 = true;
        L24:
            ValueWrapper[] r106 = getAll(r104, r105, r100);
            r112.writeNoException();
            r112.writeTypedArray(r106, 1);
            return true;
        L20:
            r105 = false;
            goto L22
        L26:
            r111.enforceInterface(DESCRIPTOR);
            String r107 = r111.readString();
            if (r111.readInt() == 0) goto L29;
            boolean r108 = true;
        L31:
            if (r111.readInt() == 0) goto L33;
            r100 = true;
        L33:
            boolean r109 = contains(r107, r108, r100, r111.readString());
            r112.writeNoException();
            r112.writeInt(r109 ? 1 : 0);
            return true;
        L29:
            r108 = false;
            goto L31
        L35:
            r111.enforceInterface(DESCRIPTOR);
            String r114 = r111.readString();
            if (r111.readInt() == 0) goto L38;
            boolean r115 = true;
        L40:
            if (r111.readInt() == 0) goto L42;
            boolean r116 = true;
        L43:
            boolean r117 = r115;
            boolean r118 = r116;
            byte[] r119 = getBytesJustDisk(r114, r117, r118, r111.readString(), r111.createByteArray());
            r112.writeNoException();
            r112.writeByteArray(r119);
            return true;
        L42:
            r116 = false;
            goto L43
        L38:
            r115 = false;
            goto L40
        L45:
            r111.enforceInterface(DESCRIPTOR);
            String r120 = r111.readString();
            if (r111.readInt() == 0) goto L48;
            boolean r121 = true;
        L50:
            if (r111.readInt() == 0) goto L52;
            boolean r122 = true;
        L53:
            boolean r123 = r121;
            boolean r124 = r122;
            List<String> r125 = getStringSetJustDisk(r120, r123, r124, r111.readString(), r111.createStringArrayList());
            r112.writeNoException();
            r112.writeStringList(r125);
            return true;
        L52:
            r122 = false;
            goto L53
        L48:
            r121 = false;
            goto L50
        L55:
            r111.enforceInterface(DESCRIPTOR);
            String r126 = r111.readString();
            if (r111.readInt() == 0) goto L58;
            boolean r127 = true;
        L60:
            if (r111.readInt() == 0) goto L62;
            boolean r128 = true;
        L63:
            boolean r129 = r127;
            boolean r130 = r128;
            String[] r131 = getStringArrayJustDisk(r126, r129, r130, r111.readString(), r111.createStringArray());
            r112.writeNoException();
            r112.writeStringArray(r131);
            return true;
        L62:
            r128 = false;
            goto L63
        L58:
            r127 = false;
            goto L60
        L65:
            r111.enforceInterface(DESCRIPTOR);
            String r132 = r111.readString();
            if (r111.readInt() == 0) goto L68;
            boolean r133 = true;
        L70:
            if (r111.readInt() == 0) goto L72;
            boolean r134 = true;
        L73:
            boolean r135 = r133;
            boolean r136 = r134;
            String r137 = getStringJustDisk(r132, r135, r136, r111.readString(), r111.readString());
            r112.writeNoException();
            r112.writeString(r137);
            return true;
        L72:
            r134 = false;
            goto L73
        L68:
            r133 = false;
            goto L70
        L75:
            r111.enforceInterface(DESCRIPTOR);
            String r138 = r111.readString();
            if (r111.readInt() == 0) goto L78;
            boolean r139 = true;
        L80:
            if (r111.readInt() == 0) goto L82;
            boolean r140 = true;
        L83:
            boolean r141 = r139;
            boolean r142 = r140;
            String r143 = getString(r138, r141, r142, r111.readString(), r111.readString());
            r112.writeNoException();
            r112.writeString(r143);
            return true;
        L82:
            r140 = false;
            goto L83
        L78:
            r139 = false;
            goto L80
        L85:
            r111.enforceInterface(DESCRIPTOR);
            String r144 = r111.readString();
            if (r111.readInt() == 0) goto L88;
            boolean r145 = true;
        L90:
            if (r111.readInt() == 0) goto L92;
            boolean r146 = true;
        L93:
            boolean r147 = r145;
            boolean r148 = r146;
            String[] r149 = getStringArray(r144, r147, r148, r111.readString(), r111.createStringArray());
            r112.writeNoException();
            r112.writeStringArray(r149);
            return true;
        L92:
            r146 = false;
            goto L93
        L88:
            r145 = false;
            goto L90
        L95:
            r111.enforceInterface(DESCRIPTOR);
            String r150 = r111.readString();
            if (r111.readInt() == 0) goto L98;
            boolean r151 = true;
        L100:
            if (r111.readInt() == 0) goto L102;
            boolean r152 = true;
        L103:
            boolean r153 = r151;
            boolean r154 = r152;
            List<String> r155 = getStringSet(r150, r153, r154, r111.readString(), r111.createStringArrayList());
            r112.writeNoException();
            r112.writeStringList(r155);
            return true;
        L102:
            r152 = false;
            goto L103
        L98:
            r151 = false;
            goto L100
        L105:
            r111.enforceInterface(DESCRIPTOR);
            String r156 = r111.readString();
            if (r111.readInt() == 0) goto L108;
            boolean r157 = true;
        L110:
            if (r111.readInt() == 0) goto L112;
            boolean r158 = true;
        L113:
            boolean r159 = r157;
            boolean r160 = r158;
            byte[] r161 = getBytes(r156, r159, r160, r111.readString(), r111.createByteArray());
            r112.writeNoException();
            r112.writeByteArray(r161);
            return true;
        L112:
            r158 = false;
            goto L113
        L108:
            r157 = false;
            goto L110
        L115:
            r111.enforceInterface(DESCRIPTOR);
            String r162 = r111.readString();
            if (r111.readInt() == 0) goto L118;
            boolean r163 = true;
        L120:
            if (r111.readInt() == 0) goto L122;
            boolean r164 = true;
        L123:
            String r165 = r111.readString();
            if (r111.readInt() == 0) goto L126;
            boolean r166 = true;
        L127:
            boolean r167 = getBoolean(r162, r163, r164, r165, r166);
            r112.writeNoException();
            r112.writeInt(r167 ? 1 : 0);
            return true;
        L126:
            r166 = false;
            goto L127
        L122:
            r164 = false;
            goto L123
        L118:
            r163 = false;
            goto L120
        L129:
            r111.enforceInterface(DESCRIPTOR);
            String r168 = r111.readString();
            if (r111.readInt() == 0) goto L132;
            boolean r169 = true;
        L134:
            if (r111.readInt() == 0) goto L136;
            boolean r170 = true;
        L137:
            boolean r171 = r169;
            boolean r172 = r170;
            float r173 = getFloat(r168, r171, r172, r111.readString(), r111.readFloat());
            r112.writeNoException();
            r112.writeFloat(r173);
            return true;
        L136:
            r170 = false;
            goto L137
        L132:
            r169 = false;
            goto L134
        L139:
            r111.enforceInterface(DESCRIPTOR);
            String r174 = r111.readString();
            if (r111.readInt() == 0) goto L142;
            boolean r175 = true;
        L144:
            if (r111.readInt() == 0) goto L146;
            boolean r176 = true;
        L147:
            boolean r177 = r175;
            boolean r178 = r176;
            double r179 = getDouble(r174, r177, r178, r111.readString(), r111.readDouble());
            r112.writeNoException();
            r112.writeDouble(r179);
            return true;
        L146:
            r176 = false;
            goto L147
        L142:
            r175 = false;
            goto L144
        L149:
            r111.enforceInterface(DESCRIPTOR);
            String r180 = r111.readString();
            if (r111.readInt() == 0) goto L152;
            boolean r181 = true;
        L154:
            if (r111.readInt() == 0) goto L156;
            boolean r182 = true;
        L157:
            boolean r183 = r181;
            boolean r184 = r182;
            long r185 = getLong(r180, r183, r184, r111.readString(), r111.readLong());
            r112.writeNoException();
            r112.writeLong(r185);
            return true;
        L156:
            r182 = false;
            goto L157
        L152:
            r181 = false;
            goto L154
        L159:
            r111.enforceInterface(DESCRIPTOR);
            String r186 = r111.readString();
            if (r111.readInt() == 0) goto L162;
            boolean r187 = true;
        L164:
            if (r111.readInt() == 0) goto L166;
            boolean r188 = true;
        L167:
            boolean r189 = r187;
            boolean r190 = r188;
            int r191 = getInt(r186, r189, r190, r111.readString(), r111.readInt());
            r112.writeNoException();
            r112.writeInt(r191);
            return true;
        L166:
            r188 = false;
            goto L167
        L162:
            r187 = false;
            goto L164
        L169:
            r111.enforceInterface(DESCRIPTOR);
            String r192 = r111.readString();
            if (r111.readInt() == 0) goto L172;
            boolean r193 = true;
        L174:
            if (r111.readInt() == 0) goto L176;
            r100 = true;
        L176:
            int r194 = count(r192, r193, r100);
            r112.writeNoException();
            r112.writeInt(r194);
            return true;
        L172:
            r193 = false;
            goto L174
        L178:
            r111.enforceInterface(DESCRIPTOR);
            String r195 = r111.readString();
            if (r111.readInt() == 0) goto L181;
            boolean r196 = true;
        L183:
            if (r111.readInt() == 0) goto L185;
            r100 = true;
        L185:
            dump(r195, r196, r100);
            r112.writeNoException();
            return true;
        L181:
            r196 = false;
            goto L183
        L187:
            r111.enforceInterface(DESCRIPTOR);
            String r197 = r111.readString();
            if (r111.readInt() == 0) goto L190;
            boolean r198 = true;
        L192:
            if (r111.readInt() == 0) goto L194;
            r100 = true;
        L194:
            clear(r197, r198, r100);
            r112.writeNoException();
            return true;
        L190:
            r198 = false;
            goto L192
        L196:
            r111.enforceInterface(DESCRIPTOR);
            String r199 = r111.readString();
            if (r111.readInt() == 0) goto L199;
            boolean r200 = true;
        L201:
            if (r111.readInt() == 0) goto L203;
            r100 = true;
        L203:
            erase(r199, r200, r100, r111.readString());
            r112.writeNoException();
            return true;
        L199:
            r200 = false;
            goto L201
        L205:
            r111.enforceInterface(DESCRIPTOR);
            String r201 = r111.readString();
            if (r111.readInt() == 0) goto L208;
            boolean r202 = true;
        L210:
            if (r111.readInt() == 0) goto L212;
            boolean r203 = true;
        L213:
            boolean r204 = r202;
            boolean r205 = r203;
            storeBytesJustDisk(r201, r204, r205, r111.readString(), r111.createByteArray());
            r112.writeNoException();
            return true;
        L212:
            r203 = false;
            goto L213
        L208:
            r202 = false;
            goto L210
        L215:
            r111.enforceInterface(DESCRIPTOR);
            String r206 = r111.readString();
            if (r111.readInt() == 0) goto L218;
            boolean r207 = true;
        L220:
            if (r111.readInt() == 0) goto L222;
            boolean r208 = true;
        L223:
            boolean r209 = r207;
            boolean r210 = r208;
            storeStringSetJustDisk(r206, r209, r210, r111.readString(), r111.createStringArrayList());
            r112.writeNoException();
            return true;
        L222:
            r208 = false;
            goto L223
        L218:
            r207 = false;
            goto L220
        L225:
            r111.enforceInterface(DESCRIPTOR);
            String r211 = r111.readString();
            if (r111.readInt() == 0) goto L228;
            boolean r212 = true;
        L230:
            if (r111.readInt() == 0) goto L232;
            boolean r213 = true;
        L233:
            boolean r214 = r212;
            boolean r215 = r213;
            storeStringArrayJustDisk(r211, r214, r215, r111.readString(), r111.createStringArray());
            r112.writeNoException();
            return true;
        L232:
            r213 = false;
            goto L233
        L228:
            r212 = false;
            goto L230
        L235:
            r111.enforceInterface(DESCRIPTOR);
            String r216 = r111.readString();
            if (r111.readInt() == 0) goto L238;
            boolean r217 = true;
        L240:
            if (r111.readInt() == 0) goto L242;
            boolean r218 = true;
        L243:
            boolean r219 = r217;
            boolean r220 = r218;
            storeStringJustDisk(r216, r219, r220, r111.readString(), r111.readString());
            r112.writeNoException();
            return true;
        L242:
            r218 = false;
            goto L243
        L238:
            r217 = false;
            goto L240
        L245:
            r111.enforceInterface(DESCRIPTOR);
            String r221 = r111.readString();
            if (r111.readInt() == 0) goto L248;
            boolean r222 = true;
        L250:
            if (r111.readInt() == 0) goto L252;
            boolean r223 = true;
        L253:
            boolean r224 = r222;
            boolean r225 = r223;
            storeBytes(r221, r224, r225, r111.readString(), r111.createByteArray());
            r112.writeNoException();
            return true;
        L252:
            r223 = false;
            goto L253
        L248:
            r222 = false;
            goto L250
        L255:
            r111.enforceInterface(DESCRIPTOR);
            String r226 = r111.readString();
            if (r111.readInt() == 0) goto L258;
            boolean r227 = true;
        L260:
            if (r111.readInt() == 0) goto L262;
            boolean r228 = true;
        L263:
            boolean r229 = r227;
            boolean r230 = r228;
            storeStringArray(r226, r229, r230, r111.readString(), r111.createStringArray());
            r112.writeNoException();
            return true;
        L262:
            r228 = false;
            goto L263
        L258:
            r227 = false;
            goto L260
        L265:
            r111.enforceInterface(DESCRIPTOR);
            String r231 = r111.readString();
            if (r111.readInt() == 0) goto L268;
            boolean r232 = true;
        L270:
            if (r111.readInt() == 0) goto L272;
            boolean r233 = true;
        L273:
            boolean r234 = r232;
            boolean r235 = r233;
            storeStringSet(r231, r234, r235, r111.readString(), r111.createStringArrayList());
            r112.writeNoException();
            return true;
        L272:
            r233 = false;
            goto L273
        L268:
            r232 = false;
            goto L270
        L275:
            r111.enforceInterface(DESCRIPTOR);
            String r236 = r111.readString();
            if (r111.readInt() == 0) goto L278;
            boolean r237 = true;
        L280:
            if (r111.readInt() == 0) goto L282;
            boolean r238 = true;
        L283:
            boolean r239 = r237;
            boolean r240 = r238;
            storeString(r236, r239, r240, r111.readString(), r111.readString());
            r112.writeNoException();
            return true;
        L282:
            r238 = false;
            goto L283
        L278:
            r237 = false;
            goto L280
        L285:
            r111.enforceInterface(DESCRIPTOR);
            String r241 = r111.readString();
            if (r111.readInt() == 0) goto L288;
            boolean r242 = true;
        L290:
            if (r111.readInt() == 0) goto L292;
            boolean r243 = true;
        L293:
            boolean r244 = r242;
            boolean r245 = r243;
            storeDouble(r241, r244, r245, r111.readString(), r111.readDouble());
            r112.writeNoException();
            return true;
        L292:
            r243 = false;
            goto L293
        L288:
            r242 = false;
            goto L290
        L295:
            r111.enforceInterface(DESCRIPTOR);
            String r246 = r111.readString();
            if (r111.readInt() == 0) goto L298;
            boolean r247 = true;
        L300:
            if (r111.readInt() == 0) goto L302;
            boolean r248 = true;
        L303:
            boolean r249 = r247;
            boolean r250 = r248;
            storeLong(r246, r249, r250, r111.readString(), r111.readLong());
            r112.writeNoException();
            return true;
        L302:
            r248 = false;
            goto L303
        L298:
            r247 = false;
            goto L300
        L305:
            r111.enforceInterface(DESCRIPTOR);
            String r251 = r111.readString();
            if (r111.readInt() == 0) goto L308;
            boolean r252 = true;
        L310:
            if (r111.readInt() == 0) goto L312;
            boolean r253 = true;
        L313:
            boolean r254 = r252;
            boolean r255 = r253;
            storeInt(r251, r254, r255, r111.readString(), r111.readInt());
            r112.writeNoException();
            return true;
        L312:
            r253 = false;
            goto L313
        L308:
            r252 = false;
            goto L310
        L315:
            r111.enforceInterface(DESCRIPTOR);
            String r256 = r111.readString();
            if (r111.readInt() == 0) goto L318;
            boolean r257 = true;
        L320:
            if (r111.readInt() == 0) goto L322;
            boolean r258 = true;
        L323:
            String r259 = r111.readString();
            if (r111.readInt() == 0) goto L326;
            boolean r1100 = true;
        L327:
            storeBoolean(r256, r257, r258, r259, r1100);
            r112.writeNoException();
            return true;
        L326:
            r1100 = false;
            goto L327
        L322:
            r258 = false;
            goto L323
        L318:
            r257 = false;
            goto L320
        L329:
            r111.enforceInterface(DESCRIPTOR);
            String r260 = r111.readString();
            if (r111.readInt() == 0) goto L332;
            boolean r261 = true;
        L334:
            if (r111.readInt() == 0) goto L336;
            boolean r262 = true;
        L337:
            boolean r263 = r261;
            boolean r264 = r262;
            storeFloat(r260, r263, r264, r111.readString(), r111.readFloat());
            r112.writeNoException();
            return true;
        L336:
            r262 = false;
            goto L337
        L332:
            r261 = false;
            goto L334
        L339:
            r111.enforceInterface(DESCRIPTOR);
            String r265 = r111.readString();
            if (r111.readInt() == 0) goto L342;
            boolean r266 = true;
        L344:
            if (r111.readInt() == 0) goto L346;
            r100 = true;
        L346:
            init(r265, r266, r100);
            r112.writeNoException();
            return true;
        L342:
            r266 = false;
            goto L344
        L7:
            return super.onTransact(r110, r111, r112, r113);
        L348:
            r112.writeString(DESCRIPTOR);
            return true;
        }
    }

    ValueWrapper[] buildNewMap(String r100, boolean r101, boolean r102) throws RemoteException;

    void clear(String r100, boolean r101, boolean r102) throws RemoteException;

    boolean contains(String r100, boolean r101, boolean r102, String r103) throws RemoteException;

    int count(String r100, boolean r101, boolean r102) throws RemoteException;

    void dump(String r100, boolean r101, boolean r102) throws RemoteException;

    void erase(String r100, boolean r101, boolean r102, String r103) throws RemoteException;

    ValueWrapper[] getAll(String r100, boolean r101, boolean r102) throws RemoteException;

    boolean getBoolean(String r100, boolean r101, boolean r102, String r103, boolean r104) throws RemoteException;

    byte[] getBytes(String r100, boolean r101, boolean r102, String r103, byte[] r104) throws RemoteException;

    byte[] getBytesJustDisk(String r100, boolean r101, boolean r102, String r103, byte[] r104) throws RemoteException;

    double getDouble(String r100, boolean r101, boolean r102, String r103, double r104) throws RemoteException;

    float getFloat(String r100, boolean r101, boolean r102, String r103, float r104) throws RemoteException;

    int getInt(String r100, boolean r101, boolean r102, String r103, int r104) throws RemoteException;

    long getLong(String r100, boolean r101, boolean r102, String r103, long r104) throws RemoteException;

    String getString(String r100, boolean r101, boolean r102, String r103, String r104) throws RemoteException;

    String[] getStringArray(String r100, boolean r101, boolean r102, String r103, String[] r104) throws RemoteException;

    String[] getStringArrayJustDisk(String r100, boolean r101, boolean r102, String r103, String[] r104) throws RemoteException;

    String getStringJustDisk(String r100, boolean r101, boolean r102, String r103, String r104) throws RemoteException;

    List<String> getStringSet(String r100, boolean r101, boolean r102, String r103, List<String> r104) throws RemoteException;

    List<String> getStringSetJustDisk(String r100, boolean r101, boolean r102, String r103, List<String> r104) throws RemoteException;

    void init(String r100, boolean r101, boolean r102) throws RemoteException;

    void storeBoolean(String r100, boolean r101, boolean r102, String r103, boolean r104) throws RemoteException;

    void storeBytes(String r100, boolean r101, boolean r102, String r103, byte[] r104) throws RemoteException;

    void storeBytesJustDisk(String r100, boolean r101, boolean r102, String r103, byte[] r104) throws RemoteException;

    void storeDouble(String r100, boolean r101, boolean r102, String r103, double r104) throws RemoteException;

    void storeFloat(String r100, boolean r101, boolean r102, String r103, float r104) throws RemoteException;

    void storeInt(String r100, boolean r101, boolean r102, String r103, int r104) throws RemoteException;

    void storeLong(String r100, boolean r101, boolean r102, String r103, long r104) throws RemoteException;

    void storeString(String r100, boolean r101, boolean r102, String r103, String r104) throws RemoteException;

    void storeStringArray(String r100, boolean r101, boolean r102, String r103, String[] r104) throws RemoteException;

    void storeStringArrayJustDisk(String r100, boolean r101, boolean r102, String r103, String[] r104) throws RemoteException;

    void storeStringJustDisk(String r100, boolean r101, boolean r102, String r103, String r104) throws RemoteException;

    void storeStringSet(String r100, boolean r101, boolean r102, String r103, List<String> r104) throws RemoteException;

    void storeStringSetJustDisk(String r100, boolean r101, boolean r102, String r103, List<String> r104) throws RemoteException;
}
