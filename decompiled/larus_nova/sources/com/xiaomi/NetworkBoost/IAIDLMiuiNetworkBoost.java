package com.xiaomi.NetworkBoost;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;
import me.ele.lancet.base.annotations.Skip;
import pqc.b;
import pqc.c;
import pqc.d;
import pqc.e;
import pqc.f;
import pqc.g;
import pqc.h;
import pqc.i;
import pqc.j;

/* JADX INFO: loaded from: classes41.dex */
public interface IAIDLMiuiNetworkBoost extends IInterface {

    public static abstract class Stub extends Binder implements IAIDLMiuiNetworkBoost {

        public static class a implements IAIDLMiuiNetworkBoost {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static IAIDLMiuiNetworkBoost f462969b;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f462970a;

            public a(IBinder r100) {
                this.f462970a = r100;
            }

            public static /* synthetic */ void a(Parcel r100, String r101, String r102) {
                r100.writeString(r101);
                r100.writeString(r102);
            }

            public static /* synthetic */ void a(Parcel r100, Map r101, int r102) {
                r101.put(r100.readString(), r100.readString());
            }

            public static /* synthetic */ void b(Parcel r100, Map r101, int r102) {
                r101.put(r100.readString(), r100.readString());
            }

            public static /* synthetic */ void c(Parcel r100, Map r101, int r102) {
                r101.put(r100.readString(), r100.readString());
            }

            public static /* synthetic */ void d(Parcel r100, Map r101, int r102) {
                r101.put(r100.readString(), r100.readString());
            }

            @Override // com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost
            public final boolean abortScan() {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost");     // Catch: Throwable -> L15
                boolean r102 = false;
                if (INVOKEINTERFACE_com_xiaomi_NetworkBoost_IAIDLMiuiNetworkBoost$Stub$a_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f462970a, 12, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L15
                if (r101.readInt() == 0) goto L13;
                r102 = true;
            L13:
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r103 = Stub.getDefaultImpl().abortScan();     // Catch: Throwable -> L15
                r101.recycle();
                r100.recycle();
                return r103;
            L15:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost
            public final boolean activeScan(int[] r100) {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost");     // Catch: Throwable -> L15
                r101.writeIntArray(r100);     // Catch: Throwable -> L15
                boolean r103 = false;
                if (INVOKEINTERFACE_com_xiaomi_NetworkBoost_IAIDLMiuiNetworkBoost$Stub$a_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f462970a, 11, r101, r102, 0) == false) goto L6;
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
                boolean r104 = Stub.getDefaultImpl().activeScan(r100);     // Catch: Throwable -> L15
                r102.recycle();
                r101.recycle();
                return r104;
            L15:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f462970a;
            }

            @Override // com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost
            public final boolean connectSlaveWifi(int r100) {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost");     // Catch: Throwable -> L15
                r101.writeInt(r100);     // Catch: Throwable -> L15
                boolean r103 = false;
                if (INVOKEINTERFACE_com_xiaomi_NetworkBoost_IAIDLMiuiNetworkBoost$Stub$a_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f462970a, 5, r101, r102, 0) == false) goto L6;
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
                boolean r104 = Stub.getDefaultImpl().connectSlaveWifi(r100);     // Catch: Throwable -> L15
                r102.recycle();
                r101.recycle();
                return r104;
            L15:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost
            public final boolean disableWifiSelectionOpt(IAIDLMiuiNetSelectCallback r100) {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost");     // Catch: Throwable -> L19
                if (r100 == null) goto L6;
                IBinder r103 = r100.asBinder();     // Catch: Throwable -> L19
            L7:
                r101.writeStrongBinder(r103);     // Catch: Throwable -> L19
                boolean r104 = false;
                if (INVOKEINTERFACE_com_xiaomi_NetworkBoost_IAIDLMiuiNetworkBoost$Stub$a_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f462970a, 33, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L19
                if (r102.readInt() == 0) goto L17;
                r104 = true;
            L17:
                r102.recycle();
                r101.recycle();
                return r104;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                boolean r105 = Stub.getDefaultImpl().disableWifiSelectionOpt(r100);     // Catch: Throwable -> L19
                r102.recycle();
                r101.recycle();
                return r105;
            L6:
                r103 = null;
            L19:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost
            public final boolean disableWifiSelectionOptByUid(IAIDLMiuiNetSelectCallback r100, int r101) {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost");     // Catch: Throwable -> L19
                if (r100 == null) goto L6;
                IBinder r104 = r100.asBinder();     // Catch: Throwable -> L19
            L7:
                r102.writeStrongBinder(r104);     // Catch: Throwable -> L19
                r102.writeInt(r101);     // Catch: Throwable -> L19
                boolean r105 = false;
                if (INVOKEINTERFACE_com_xiaomi_NetworkBoost_IAIDLMiuiNetworkBoost$Stub$a_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f462970a, 29, r102, r103, 0) == false) goto L10;
            L14:
                r103.readException();     // Catch: Throwable -> L19
                if (r103.readInt() == 0) goto L17;
                r105 = true;
            L17:
                r103.recycle();
                r102.recycle();
                return r105;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                boolean r106 = Stub.getDefaultImpl().disableWifiSelectionOptByUid(r100, r101);     // Catch: Throwable -> L19
                r103.recycle();
                r102.recycle();
                return r106;
            L6:
                r104 = null;
            L19:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Override // com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost
            public final boolean disconnectSlaveWifi() {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost");     // Catch: Throwable -> L15
                boolean r102 = false;
                if (INVOKEINTERFACE_com_xiaomi_NetworkBoost_IAIDLMiuiNetworkBoost$Stub$a_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f462970a, 6, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L15
                if (r101.readInt() == 0) goto L13;
                r102 = true;
            L13:
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r103 = Stub.getDefaultImpl().disconnectSlaveWifi();     // Catch: Throwable -> L15
                r101.recycle();
                r100.recycle();
                return r103;
            L15:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost
            public final boolean enableWifiSelectionOpt(IAIDLMiuiNetSelectCallback r100, int r101) {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost");     // Catch: Throwable -> L19
                if (r100 == null) goto L6;
                IBinder r104 = r100.asBinder();     // Catch: Throwable -> L19
            L7:
                r102.writeStrongBinder(r104);     // Catch: Throwable -> L19
                r102.writeInt(r101);     // Catch: Throwable -> L19
                boolean r105 = false;
                if (INVOKEINTERFACE_com_xiaomi_NetworkBoost_IAIDLMiuiNetworkBoost$Stub$a_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f462970a, 30, r102, r103, 0) == false) goto L10;
            L14:
                r103.readException();     // Catch: Throwable -> L19
                if (r103.readInt() == 0) goto L17;
                r105 = true;
            L17:
                r103.recycle();
                r102.recycle();
                return r105;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                boolean r106 = Stub.getDefaultImpl().enableWifiSelectionOpt(r100, r101);     // Catch: Throwable -> L19
                r103.recycle();
                r102.recycle();
                return r106;
            L6:
                r104 = null;
            L19:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Override // com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost
            public final boolean enableWifiSelectionOptByUid(IAIDLMiuiNetSelectCallback r100, int r101, int r102) {
                Parcel r103 = Parcel.obtain();
                Parcel r104 = Parcel.obtain();
                r103.writeInterfaceToken("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost");     // Catch: Throwable -> L19
                if (r100 == null) goto L6;
                IBinder r105 = r100.asBinder();     // Catch: Throwable -> L19
            L7:
                r103.writeStrongBinder(r105);     // Catch: Throwable -> L19
                r103.writeInt(r101);     // Catch: Throwable -> L19
                r103.writeInt(r102);     // Catch: Throwable -> L19
                boolean r106 = false;
                if (INVOKEINTERFACE_com_xiaomi_NetworkBoost_IAIDLMiuiNetworkBoost$Stub$a_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f462970a, 28, r103, r104, 0) == false) goto L10;
            L14:
                r104.readException();     // Catch: Throwable -> L19
                if (r104.readInt() == 0) goto L17;
                r106 = true;
            L17:
                r104.recycle();
                r103.recycle();
                return r106;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                boolean r107 = Stub.getDefaultImpl().enableWifiSelectionOptByUid(r100, r101, r102);     // Catch: Throwable -> L19
                r104.recycle();
                r103.recycle();
                return r107;
            L6:
                r105 = null;
            L19:
                th = move-exception;
                r104.recycle();
                r103.recycle();
                throw th;
            }

            @Override // com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost
            public final Map<String, String> getAvailableIfaces() {
                Parcel r100 = Parcel.obtain();
                final Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost");     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_xiaomi_NetworkBoost_IAIDLMiuiNetworkBoost$Stub$a_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f462970a, 7, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L17
                int r102 = r101.readInt();     // Catch: Throwable -> L17
                if (r102 >= 0) goto L13;
                final HashMap r103 = null;
            L14:
                IntStream.range(0, r102).forEach(new h(r101, r103));     // Catch: Throwable -> L17
                r101.recycle();
                r100.recycle();
                return r103;
            L13:
                r103 = new HashMap();     // Catch: Throwable -> L17
                goto L14
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Map<String, String> r104 = Stub.getDefaultImpl().getAvailableIfaces();     // Catch: Throwable -> L17
                r101.recycle();
                r100.recycle();
                return r104;
            L17:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost
            public final Map<String, String> getQoEByAvailableIfaceName(String r100) {
                Parcel r101 = Parcel.obtain();
                final Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost");     // Catch: Throwable -> L17
                r101.writeString(r100);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_xiaomi_NetworkBoost_IAIDLMiuiNetworkBoost$Stub$a_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f462970a, 19, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L17
                int r103 = r102.readInt();     // Catch: Throwable -> L17
                if (r103 >= 0) goto L13;
                final HashMap r104 = null;
            L14:
                IntStream.range(0, r103).forEach(new f(r102, r104));     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return r104;
            L13:
                r104 = new HashMap();     // Catch: Throwable -> L17
                goto L14
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Map<String, String> r105 = Stub.getDefaultImpl().getQoEByAvailableIfaceName(r100);     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return r105;
            L17:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost
            public final NetLinkLayerQoE getQoEByAvailableIfaceNameV1(String r100) {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost");     // Catch: Throwable -> L15
                r101.writeString(r100);     // Catch: Throwable -> L15
                if (INVOKEINTERFACE_com_xiaomi_NetworkBoost_IAIDLMiuiNetworkBoost$Stub$a_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f462970a, 22, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L15
                if (r102.readInt() == 0) goto L14;
                NetLinkLayerQoE r103 = NetLinkLayerQoE.CREATOR.createFromParcel(r102);     // Catch: Throwable -> L15
            L8:
                r102.recycle();
                r101.recycle();
                return r103;
            L14:
                r103 = null;
                goto L8
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r103 = Stub.getDefaultImpl().getQoEByAvailableIfaceNameV1(r100);     // Catch: Throwable -> L15
            L15:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost
            public final int getServiceVersion() {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost");     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_xiaomi_NetworkBoost_IAIDLMiuiNetworkBoost$Stub$a_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f462970a, 21, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L12
                int r102 = r101.readInt();     // Catch: Throwable -> L12
            L8:
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r102 = Stub.getDefaultImpl().getServiceVersion();     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost
            public final boolean isCelluarDSDAState() {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost");     // Catch: Throwable -> L15
                boolean r102 = false;
                if (INVOKEINTERFACE_com_xiaomi_NetworkBoost_IAIDLMiuiNetworkBoost$Stub$a_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f462970a, 35, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L15
                if (r101.readInt() == 0) goto L13;
                r102 = true;
            L13:
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r103 = Stub.getDefaultImpl().isCelluarDSDAState();     // Catch: Throwable -> L15
                r101.recycle();
                r100.recycle();
                return r103;
            L15:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost
            public final int isSlaveWifiEnabledAndOthersOpt(int r100) {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost");     // Catch: Throwable -> L12
                r101.writeInt(r100);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_xiaomi_NetworkBoost_IAIDLMiuiNetworkBoost$Stub$a_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f462970a, 38, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L12
                int r103 = r102.readInt();     // Catch: Throwable -> L12
            L8:
                r102.recycle();
                r101.recycle();
                return r103;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r103 = Stub.getDefaultImpl().isSlaveWifiEnabledAndOthersOpt(r100);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost
            public final int isSlaveWifiEnabledAndOthersOptByUid(int r100, int r101) {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost");     // Catch: Throwable -> L12
                r102.writeInt(r100);     // Catch: Throwable -> L12
                r102.writeInt(r101);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_xiaomi_NetworkBoost_IAIDLMiuiNetworkBoost$Stub$a_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f462970a, 39, r102, r103, 0) == false) goto L6;
            L10:
                r103.readException();     // Catch: Throwable -> L12
                int r104 = r103.readInt();     // Catch: Throwable -> L12
            L8:
                r103.recycle();
                r102.recycle();
                return r104;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r104 = Stub.getDefaultImpl().isSlaveWifiEnabledAndOthersOptByUid(r100, r101);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Override // com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost
            public final boolean isSupportDualCelluarData() {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost");     // Catch: Throwable -> L15
                boolean r102 = false;
                if (INVOKEINTERFACE_com_xiaomi_NetworkBoost_IAIDLMiuiNetworkBoost$Stub$a_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f462970a, 34, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L15
                if (r101.readInt() == 0) goto L13;
                r102 = true;
            L13:
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r103 = Stub.getDefaultImpl().isSupportDualCelluarData();     // Catch: Throwable -> L15
                r101.recycle();
                r100.recycle();
                return r103;
            L15:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost
            public final boolean isSupportDualWifi() {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost");     // Catch: Throwable -> L15
                boolean r102 = false;
                if (INVOKEINTERFACE_com_xiaomi_NetworkBoost_IAIDLMiuiNetworkBoost$Stub$a_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f462970a, 3, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L15
                if (r101.readInt() == 0) goto L13;
                r102 = true;
            L13:
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r103 = Stub.getDefaultImpl().isSupportDualWifi();     // Catch: Throwable -> L15
                r101.recycle();
                r100.recycle();
                return r103;
            L15:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost
            public final boolean isSupportMediaPlayerPolicy() {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost");     // Catch: Throwable -> L15
                boolean r102 = false;
                if (INVOKEINTERFACE_com_xiaomi_NetworkBoost_IAIDLMiuiNetworkBoost$Stub$a_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f462970a, 37, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L15
                if (r101.readInt() == 0) goto L13;
                r102 = true;
            L13:
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r103 = Stub.getDefaultImpl().isSupportMediaPlayerPolicy();     // Catch: Throwable -> L15
                r101.recycle();
                r100.recycle();
                return r103;
            L15:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost
            public final boolean registerCallback(IAIDLMiuiNetworkCallback r100) {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost");     // Catch: Throwable -> L19
                if (r100 == null) goto L6;
                IBinder r103 = r100.asBinder();     // Catch: Throwable -> L19
            L7:
                r101.writeStrongBinder(r103);     // Catch: Throwable -> L19
                boolean r104 = false;
                if (INVOKEINTERFACE_com_xiaomi_NetworkBoost_IAIDLMiuiNetworkBoost$Stub$a_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f462970a, 9, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L19
                if (r102.readInt() == 0) goto L17;
                r104 = true;
            L17:
                r102.recycle();
                r101.recycle();
                return r104;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                boolean r105 = Stub.getDefaultImpl().registerCallback(r100);     // Catch: Throwable -> L19
                r102.recycle();
                r101.recycle();
                return r105;
            L6:
                r103 = null;
            L19:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost
            public final boolean registerNetLinkCallback(IAIDLMiuiNetQoECallback r100, int r101) {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost");     // Catch: Throwable -> L19
                if (r100 == null) goto L6;
                IBinder r104 = r100.asBinder();     // Catch: Throwable -> L19
            L7:
                r102.writeStrongBinder(r104);     // Catch: Throwable -> L19
                r102.writeInt(r101);     // Catch: Throwable -> L19
                boolean r105 = false;
                if (INVOKEINTERFACE_com_xiaomi_NetworkBoost_IAIDLMiuiNetworkBoost$Stub$a_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f462970a, 23, r102, r103, 0) == false) goto L10;
            L14:
                r103.readException();     // Catch: Throwable -> L19
                if (r103.readInt() == 0) goto L17;
                r105 = true;
            L17:
                r103.recycle();
                r102.recycle();
                return r105;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                boolean r106 = Stub.getDefaultImpl().registerNetLinkCallback(r100, r101);     // Catch: Throwable -> L19
                r103.recycle();
                r102.recycle();
                return r106;
            L6:
                r104 = null;
            L19:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Override // com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost
            public final boolean registerNetLinkCallbackByUid(IAIDLMiuiNetQoECallback r100, int r101, int r102) {
                Parcel r103 = Parcel.obtain();
                Parcel r104 = Parcel.obtain();
                r103.writeInterfaceToken("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost");     // Catch: Throwable -> L19
                if (r100 == null) goto L6;
                IBinder r105 = r100.asBinder();     // Catch: Throwable -> L19
            L7:
                r103.writeStrongBinder(r105);     // Catch: Throwable -> L19
                r103.writeInt(r101);     // Catch: Throwable -> L19
                r103.writeInt(r102);     // Catch: Throwable -> L19
                boolean r106 = false;
                if (INVOKEINTERFACE_com_xiaomi_NetworkBoost_IAIDLMiuiNetworkBoost$Stub$a_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f462970a, 25, r103, r104, 0) == false) goto L10;
            L14:
                r104.readException();     // Catch: Throwable -> L19
                if (r104.readInt() == 0) goto L17;
                r106 = true;
            L17:
                r104.recycle();
                r103.recycle();
                return r106;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                boolean r107 = Stub.getDefaultImpl().registerNetLinkCallbackByUid(r100, r101, r102);     // Catch: Throwable -> L19
                r104.recycle();
                r103.recycle();
                return r107;
            L6:
                r105 = null;
            L19:
                th = move-exception;
                r104.recycle();
                r103.recycle();
                throw th;
            }

            @Override // com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost
            public final boolean registerWifiLinkCallback(IAIDLMiuiWlanQoECallback r100) {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost");     // Catch: Throwable -> L19
                if (r100 == null) goto L6;
                IBinder r103 = r100.asBinder();     // Catch: Throwable -> L19
            L7:
                r101.writeStrongBinder(r103);     // Catch: Throwable -> L19
                boolean r104 = false;
                if (INVOKEINTERFACE_com_xiaomi_NetworkBoost_IAIDLMiuiNetworkBoost$Stub$a_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f462970a, 17, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L19
                if (r102.readInt() == 0) goto L17;
                r104 = true;
            L17:
                r102.recycle();
                r101.recycle();
                return r104;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                boolean r105 = Stub.getDefaultImpl().registerWifiLinkCallback(r100);     // Catch: Throwable -> L19
                r102.recycle();
                r101.recycle();
                return r105;
            L6:
                r103 = null;
            L19:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost
            public final void reportBssidScore(Map<String, String> r100) {
                final Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost");     // Catch: Throwable -> L16
                if (r100 != null) goto L6;
                r101.writeInt(-1);     // Catch: Throwable -> L16
            L8:
                if (INVOKEINTERFACE_com_xiaomi_NetworkBoost_IAIDLMiuiNetworkBoost$Stub$a_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f462970a, 32, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L16
            L12:
                r102.recycle();
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().reportBssidScore(r100);     // Catch: Throwable -> L16
                goto L12
            L6:
                r101.writeInt(r100.size());     // Catch: Throwable -> L16
                r100.forEach(new j(r101));     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost
            public final Map<String, String> requestAppTrafficStatistics(int r110, long r111, long r112) {
                Parcel r100 = Parcel.obtain();
                final Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost");     // Catch: Throwable -> L21
                r100.writeInt(r110);     // Catch: Throwable -> L21
                r100.writeLong(r111);     // Catch: Throwable -> L21
                r100.writeLong(r112);     // Catch: Throwable -> L21
            L19:
                th = th;
            L23:
                r101.recycle();
                r100.recycle();
                throw th;
            L6:
                if (INVOKEINTERFACE_com_xiaomi_NetworkBoost_IAIDLMiuiNetworkBoost$Stub$a_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f462970a, 8, r100, r101, 0) == false) goto L8;
            L12:
                r101.readException();     // Catch: Throwable -> L19
                int r102 = r101.readInt();     // Catch: Throwable -> L19
                if (r102 >= 0) goto L15;
                final HashMap r103 = null;
            L16:
                IntStream.range(0, r102).forEach(new g(r101, r103));     // Catch: Throwable -> L19
                r101.recycle();
                r100.recycle();
                return r103;
            L15:
                r103 = new HashMap();     // Catch: Throwable -> L19
                goto L16
            L8:
                if (Stub.getDefaultImpl() == null) goto L12;
                Map<String, String> r104 = Stub.getDefaultImpl().requestAppTrafficStatistics(r110, r111, r112);     // Catch: Throwable -> L19
                r101.recycle();
                r100.recycle();
                return r104;
            L21:
                th = th;
                goto L23
            }

            @Override // com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost
            public final Map<String, String> requestAppTrafficStatisticsByUid(int r110, long r111, long r112, int r113) {
                Parcel r100 = Parcel.obtain();
                final Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost");     // Catch: Throwable -> L21
                r100.writeInt(r110);     // Catch: Throwable -> L21
                r100.writeLong(r111);     // Catch: Throwable -> L21
                r100.writeLong(r112);     // Catch: Throwable -> L21
                r100.writeInt(r113);     // Catch: Throwable -> L21
            L19:
                th = th;
            L23:
                r101.recycle();
                r100.recycle();
                throw th;
            L6:
                if (INVOKEINTERFACE_com_xiaomi_NetworkBoost_IAIDLMiuiNetworkBoost$Stub$a_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f462970a, 27, r100, r101, 0) == false) goto L8;
            L12:
                r101.readException();     // Catch: Throwable -> L19
                int r102 = r101.readInt();     // Catch: Throwable -> L19
                if (r102 >= 0) goto L15;
                final HashMap r103 = null;
            L16:
                IntStream.range(0, r102).forEach(new i(r101, r103));     // Catch: Throwable -> L19
                r101.recycle();
                r100.recycle();
                return r103;
            L15:
                r103 = new HashMap();     // Catch: Throwable -> L19
                goto L16
            L8:
                if (Stub.getDefaultImpl() == null) goto L12;
                Map<String, String> r104 = Stub.getDefaultImpl().requestAppTrafficStatisticsByUid(r110, r111, r112, r113);     // Catch: Throwable -> L19
                r101.recycle();
                r100.recycle();
                return r104;
            L21:
                th = th;
                goto L23
            }

            @Override // com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost
            public final boolean resumeBackgroundScan() {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost");     // Catch: Throwable -> L15
                boolean r102 = false;
                if (INVOKEINTERFACE_com_xiaomi_NetworkBoost_IAIDLMiuiNetworkBoost$Stub$a_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f462970a, 14, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L15
                if (r101.readInt() == 0) goto L13;
                r102 = true;
            L13:
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r103 = Stub.getDefaultImpl().resumeBackgroundScan();     // Catch: Throwable -> L15
                r101.recycle();
                r100.recycle();
                return r103;
            L15:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost
            public final boolean resumeWifiPowerSave() {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost");     // Catch: Throwable -> L15
                boolean r102 = false;
                if (INVOKEINTERFACE_com_xiaomi_NetworkBoost_IAIDLMiuiNetworkBoost$Stub$a_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f462970a, 16, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L15
                if (r101.readInt() == 0) goto L13;
                r102 = true;
            L13:
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r103 = Stub.getDefaultImpl().resumeWifiPowerSave();     // Catch: Throwable -> L15
                r101.recycle();
                r100.recycle();
                return r103;
            L15:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost
            public final void sendMediaPlayerPolicyEvent(int r100, int r101, String r102) {
                Parcel r103 = Parcel.obtain();
                Parcel r104 = Parcel.obtain();
                r103.writeInterfaceToken("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost");     // Catch: Throwable -> L12
                r103.writeInt(r100);     // Catch: Throwable -> L12
                r103.writeInt(r101);     // Catch: Throwable -> L12
                r103.writeString(r102);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_xiaomi_NetworkBoost_IAIDLMiuiNetworkBoost$Stub$a_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f462970a, 40, r103, r104, 0) == false) goto L6;
            L10:
                r104.readException();     // Catch: Throwable -> L12
            L8:
                r104.recycle();
                r103.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().sendMediaPlayerPolicyEvent(r100, r101, r102);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r104.recycle();
                r103.recycle();
                throw th;
            }

            @Override // com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost
            public final boolean setDualCelluarDataEnable(boolean r100) {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost");     // Catch: Throwable -> L15
                r101.writeInt(r100 ? 1 : 0);     // Catch: Throwable -> L15
                boolean r103 = false;
                if (INVOKEINTERFACE_com_xiaomi_NetworkBoost_IAIDLMiuiNetworkBoost$Stub$a_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f462970a, 36, r101, r102, 0) == false) goto L6;
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
                boolean r104 = Stub.getDefaultImpl().setDualCelluarDataEnable(r100);     // Catch: Throwable -> L15
                r102.recycle();
                r101.recycle();
                return r104;
            L15:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost
            public final boolean setSlaveWifiEnable(boolean r100) {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost");     // Catch: Throwable -> L15
                r101.writeInt(r100 ? 1 : 0);     // Catch: Throwable -> L15
                boolean r103 = false;
                if (INVOKEINTERFACE_com_xiaomi_NetworkBoost_IAIDLMiuiNetworkBoost$Stub$a_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f462970a, 4, r101, r102, 0) == false) goto L6;
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
                boolean r104 = Stub.getDefaultImpl().setSlaveWifiEnable(r100);     // Catch: Throwable -> L15
                r102.recycle();
                r101.recycle();
                return r104;
            L15:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost
            public final boolean setSockPrio(int r100, int r101) {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost");     // Catch: Throwable -> L15
                r102.writeInt(r100);     // Catch: Throwable -> L15
                r102.writeInt(r101);     // Catch: Throwable -> L15
                boolean r104 = false;
                if (INVOKEINTERFACE_com_xiaomi_NetworkBoost_IAIDLMiuiNetworkBoost$Stub$a_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f462970a, 1, r102, r103, 0) == false) goto L6;
            L10:
                r103.readException();     // Catch: Throwable -> L15
                if (r103.readInt() == 0) goto L13;
                r104 = true;
            L13:
                r103.recycle();
                r102.recycle();
                return r104;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r105 = Stub.getDefaultImpl().setSockPrio(r100, r101);     // Catch: Throwable -> L15
                r103.recycle();
                r102.recycle();
                return r105;
            L15:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Override // com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost
            public final boolean setTCPCongestion(int r100, String r101) {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost");     // Catch: Throwable -> L15
                r102.writeInt(r100);     // Catch: Throwable -> L15
                r102.writeString(r101);     // Catch: Throwable -> L15
                boolean r104 = false;
                if (INVOKEINTERFACE_com_xiaomi_NetworkBoost_IAIDLMiuiNetworkBoost$Stub$a_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f462970a, 2, r102, r103, 0) == false) goto L6;
            L10:
                r103.readException();     // Catch: Throwable -> L15
                if (r103.readInt() == 0) goto L13;
                r104 = true;
            L13:
                r103.recycle();
                r102.recycle();
                return r104;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r105 = Stub.getDefaultImpl().setTCPCongestion(r100, r101);     // Catch: Throwable -> L15
                r103.recycle();
                r102.recycle();
                return r105;
            L15:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Override // com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost
            public final boolean setTrafficTransInterface(int r100, String r101) {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost");     // Catch: Throwable -> L15
                r102.writeInt(r100);     // Catch: Throwable -> L15
                r102.writeString(r101);     // Catch: Throwable -> L15
                boolean r104 = false;
                if (INVOKEINTERFACE_com_xiaomi_NetworkBoost_IAIDLMiuiNetworkBoost$Stub$a_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f462970a, 20, r102, r103, 0) == false) goto L6;
            L10:
                r103.readException();     // Catch: Throwable -> L15
                if (r103.readInt() == 0) goto L13;
                r104 = true;
            L13:
                r103.recycle();
                r102.recycle();
                return r104;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r105 = Stub.getDefaultImpl().setTrafficTransInterface(r100, r101);     // Catch: Throwable -> L15
                r103.recycle();
                r102.recycle();
                return r105;
            L15:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Override // com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost
            public final boolean suspendBackgroundScan() {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost");     // Catch: Throwable -> L15
                boolean r102 = false;
                if (INVOKEINTERFACE_com_xiaomi_NetworkBoost_IAIDLMiuiNetworkBoost$Stub$a_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f462970a, 13, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L15
                if (r101.readInt() == 0) goto L13;
                r102 = true;
            L13:
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r103 = Stub.getDefaultImpl().suspendBackgroundScan();     // Catch: Throwable -> L15
                r101.recycle();
                r100.recycle();
                return r103;
            L15:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost
            public final boolean suspendWifiPowerSave() {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost");     // Catch: Throwable -> L15
                boolean r102 = false;
                if (INVOKEINTERFACE_com_xiaomi_NetworkBoost_IAIDLMiuiNetworkBoost$Stub$a_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f462970a, 15, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L15
                if (r101.readInt() == 0) goto L13;
                r102 = true;
            L13:
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r103 = Stub.getDefaultImpl().suspendWifiPowerSave();     // Catch: Throwable -> L15
                r101.recycle();
                r100.recycle();
                return r103;
            L15:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost
            public final void triggerWifiSelection() {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost");     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_xiaomi_NetworkBoost_IAIDLMiuiNetworkBoost$Stub$a_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f462970a, 31, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L12
            L8:
                r101.recycle();
                r100.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().triggerWifiSelection();     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost
            public final boolean unregisterCallback(IAIDLMiuiNetworkCallback r100) {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost");     // Catch: Throwable -> L19
                if (r100 == null) goto L6;
                IBinder r103 = r100.asBinder();     // Catch: Throwable -> L19
            L7:
                r101.writeStrongBinder(r103);     // Catch: Throwable -> L19
                boolean r104 = false;
                if (INVOKEINTERFACE_com_xiaomi_NetworkBoost_IAIDLMiuiNetworkBoost$Stub$a_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f462970a, 10, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L19
                if (r102.readInt() == 0) goto L17;
                r104 = true;
            L17:
                r102.recycle();
                r101.recycle();
                return r104;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                boolean r105 = Stub.getDefaultImpl().unregisterCallback(r100);     // Catch: Throwable -> L19
                r102.recycle();
                r101.recycle();
                return r105;
            L6:
                r103 = null;
            L19:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost
            public final boolean unregisterNetLinkCallback(IAIDLMiuiNetQoECallback r100) {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost");     // Catch: Throwable -> L19
                if (r100 == null) goto L6;
                IBinder r103 = r100.asBinder();     // Catch: Throwable -> L19
            L7:
                r101.writeStrongBinder(r103);     // Catch: Throwable -> L19
                boolean r104 = false;
                if (INVOKEINTERFACE_com_xiaomi_NetworkBoost_IAIDLMiuiNetworkBoost$Stub$a_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f462970a, 24, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L19
                if (r102.readInt() == 0) goto L17;
                r104 = true;
            L17:
                r102.recycle();
                r101.recycle();
                return r104;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                boolean r105 = Stub.getDefaultImpl().unregisterNetLinkCallback(r100);     // Catch: Throwable -> L19
                r102.recycle();
                r101.recycle();
                return r105;
            L6:
                r103 = null;
            L19:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost
            public final boolean unregisterNetLinkCallbackByUid(IAIDLMiuiNetQoECallback r100, int r101) {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost");     // Catch: Throwable -> L19
                if (r100 == null) goto L6;
                IBinder r104 = r100.asBinder();     // Catch: Throwable -> L19
            L7:
                r102.writeStrongBinder(r104);     // Catch: Throwable -> L19
                r102.writeInt(r101);     // Catch: Throwable -> L19
                boolean r105 = false;
                if (INVOKEINTERFACE_com_xiaomi_NetworkBoost_IAIDLMiuiNetworkBoost$Stub$a_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f462970a, 26, r102, r103, 0) == false) goto L10;
            L14:
                r103.readException();     // Catch: Throwable -> L19
                if (r103.readInt() == 0) goto L17;
                r105 = true;
            L17:
                r103.recycle();
                r102.recycle();
                return r105;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                boolean r106 = Stub.getDefaultImpl().unregisterNetLinkCallbackByUid(r100, r101);     // Catch: Throwable -> L19
                r103.recycle();
                r102.recycle();
                return r106;
            L6:
                r104 = null;
            L19:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Override // com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost
            public final boolean unregisterWifiLinkCallback(IAIDLMiuiWlanQoECallback r100) {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost");     // Catch: Throwable -> L19
                if (r100 == null) goto L6;
                IBinder r103 = r100.asBinder();     // Catch: Throwable -> L19
            L7:
                r101.writeStrongBinder(r103);     // Catch: Throwable -> L19
                boolean r104 = false;
                if (INVOKEINTERFACE_com_xiaomi_NetworkBoost_IAIDLMiuiNetworkBoost$Stub$a_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f462970a, 18, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L19
                if (r102.readInt() == 0) goto L17;
                r104 = true;
            L17:
                r102.recycle();
                r101.recycle();
                return r104;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                boolean r105 = Stub.getDefaultImpl().unregisterWifiLinkCallback(r100);     // Catch: Throwable -> L19
                r102.recycle();
                r101.recycle();
                return r105;
            L6:
                r103 = null;
            L19:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_xiaomi_NetworkBoost_IAIDLMiuiNetworkBoost$Stub$a_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        public Stub() {
            attachInterface(this, "com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost");
        }

        public static /* synthetic */ void a(Parcel r100, String r101, String r102) {
            r100.writeString(r101);
            r100.writeString(r102);
        }

        public static /* synthetic */ void a(Parcel r100, Map r101, int r102) {
            r101.put(r100.readString(), r100.readString());
        }

        public static IAIDLMiuiNetworkBoost asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost");
            if (r101 == null) goto L12;
            if ((r101 instanceof IAIDLMiuiNetworkBoost) == false) goto L12;
            return (IAIDLMiuiNetworkBoost) r101;
        L12:
            return new a(r100);
        }

        public static /* synthetic */ void b(Parcel r100, String r101, String r102) {
            r100.writeString(r101);
            r100.writeString(r102);
        }

        public static /* synthetic */ void c(Parcel r100, String r101, String r102) {
            r100.writeString(r101);
            r100.writeString(r102);
        }

        public static /* synthetic */ void d(Parcel r100, String r101, String r102) {
            r100.writeString(r101);
            r100.writeString(r102);
        }

        public static IAIDLMiuiNetworkBoost getDefaultImpl() {
            return a.f462969b;
        }

        public static boolean setDefaultImpl(IAIDLMiuiNetworkBoost r100) {
            if (a.f462969b != null) goto L10;
            if (r100 == null) goto L7;
            a.f462969b = r100;
            return true;
        L7:
            return false;
        L10:
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r110, final Parcel r111, final Parcel r112, int r113) {
            if (r110 == 1598968902) goto L113;
            boolean r100 = false;
            switch(r110) {
                case 1: goto L111;
                case 2: goto L109;
                case 3: goto L107;
                case 4: goto L102;
                case 5: goto L100;
                case 6: goto L98;
                case 7: goto L93;
                case 8: goto L88;
                case 9: goto L86;
                case 10: goto L84;
                case 11: goto L82;
                case 12: goto L80;
                case 13: goto L78;
                case 14: goto L76;
                case 15: goto L74;
                case 16: goto L72;
                case 17: goto L70;
                case 18: goto L68;
                case 19: goto L63;
                case 20: goto L61;
                case 21: goto L59;
                case 22: goto L54;
                case 23: goto L52;
                case 24: goto L50;
                case 25: goto L48;
                case 26: goto L46;
                case 27: goto L41;
                case 28: goto L39;
                case 29: goto L37;
                case 30: goto L35;
                case 31: goto L33;
                case 32: goto L27;
                case 33: goto L25;
                case 34: goto L23;
                case 35: goto L21;
                case 36: goto L16;
                case 37: goto L14;
                case 38: goto L12;
                case 39: goto L10;
                case 40: goto L8;
                default: goto L7;
            };
        L8:
            r111.enforceInterface("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost");
            sendMediaPlayerPolicyEvent(r111.readInt(), r111.readInt(), r111.readString());
            r112.writeNoException();
            return true;
        L10:
            r111.enforceInterface("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost");
            int r114 = isSlaveWifiEnabledAndOthersOptByUid(r111.readInt(), r111.readInt());
            r112.writeNoException();
            r112.writeInt(r114);
            return true;
        L12:
            r111.enforceInterface("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost");
            int r115 = isSlaveWifiEnabledAndOthersOpt(r111.readInt());
            r112.writeNoException();
            r112.writeInt(r115);
            return true;
        L14:
            r111.enforceInterface("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost");
            boolean r116 = isSupportMediaPlayerPolicy();
            r112.writeNoException();
            r112.writeInt(r116 ? 1 : 0);
            return true;
        L16:
            r111.enforceInterface("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost");
            if (r111.readInt() == 0) goto L19;
            r100 = true;
        L19:
            boolean r117 = setDualCelluarDataEnable(r100);
            r112.writeNoException();
            r112.writeInt(r117 ? 1 : 0);
            return true;
        L21:
            r111.enforceInterface("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost");
            boolean r118 = isCelluarDSDAState();
            r112.writeNoException();
            r112.writeInt(r118 ? 1 : 0);
            return true;
        L23:
            r111.enforceInterface("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost");
            boolean r119 = isSupportDualCelluarData();
            r112.writeNoException();
            r112.writeInt(r119 ? 1 : 0);
            return true;
        L25:
            r111.enforceInterface("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost");
            boolean r120 = disableWifiSelectionOpt(IAIDLMiuiNetSelectCallback.Stub.asInterface(r111.readStrongBinder()));
            r112.writeNoException();
            r112.writeInt(r120 ? 1 : 0);
            return true;
        L27:
            r111.enforceInterface("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost");
            int r121 = r111.readInt();
            if (r121 >= 0) goto L30;
            final HashMap r122 = null;
        L31:
            IntStream.range(0, r121).forEach(new pqc.a(r111, r122));
            reportBssidScore(r122);
            r112.writeNoException();
            return true;
        L30:
            r122 = new HashMap();
            goto L31
        L33:
            r111.enforceInterface("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost");
            triggerWifiSelection();
            r112.writeNoException();
            return true;
        L35:
            r111.enforceInterface("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost");
            boolean r123 = enableWifiSelectionOpt(IAIDLMiuiNetSelectCallback.Stub.asInterface(r111.readStrongBinder()), r111.readInt());
            r112.writeNoException();
            r112.writeInt(r123 ? 1 : 0);
            return true;
        L37:
            r111.enforceInterface("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost");
            boolean r124 = disableWifiSelectionOptByUid(IAIDLMiuiNetSelectCallback.Stub.asInterface(r111.readStrongBinder()), r111.readInt());
            r112.writeNoException();
            r112.writeInt(r124 ? 1 : 0);
            return true;
        L39:
            r111.enforceInterface("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost");
            boolean r125 = enableWifiSelectionOptByUid(IAIDLMiuiNetSelectCallback.Stub.asInterface(r111.readStrongBinder()), r111.readInt(), r111.readInt());
            r112.writeNoException();
            r112.writeInt(r125 ? 1 : 0);
            return true;
        L41:
            r111.enforceInterface("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost");
            Map<String, String> r126 = requestAppTrafficStatisticsByUid(r111.readInt(), r111.readLong(), r111.readLong(), r111.readInt());
            r112.writeNoException();
            if (r126 != null) goto L44;
            r112.writeInt(-1);
        L45:
            return true;
        L44:
            r112.writeInt(r126.size());
            r126.forEach(new b(r112));
            goto L45
        L46:
            r111.enforceInterface("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost");
            boolean r127 = unregisterNetLinkCallbackByUid(IAIDLMiuiNetQoECallback.Stub.asInterface(r111.readStrongBinder()), r111.readInt());
            r112.writeNoException();
            r112.writeInt(r127 ? 1 : 0);
            return true;
        L48:
            r111.enforceInterface("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost");
            boolean r128 = registerNetLinkCallbackByUid(IAIDLMiuiNetQoECallback.Stub.asInterface(r111.readStrongBinder()), r111.readInt(), r111.readInt());
            r112.writeNoException();
            r112.writeInt(r128 ? 1 : 0);
            return true;
        L50:
            r111.enforceInterface("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost");
            boolean r129 = unregisterNetLinkCallback(IAIDLMiuiNetQoECallback.Stub.asInterface(r111.readStrongBinder()));
            r112.writeNoException();
            r112.writeInt(r129 ? 1 : 0);
            return true;
        L52:
            r111.enforceInterface("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost");
            boolean r130 = registerNetLinkCallback(IAIDLMiuiNetQoECallback.Stub.asInterface(r111.readStrongBinder()), r111.readInt());
            r112.writeNoException();
            r112.writeInt(r130 ? 1 : 0);
            return true;
        L54:
            r111.enforceInterface("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost");
            NetLinkLayerQoE r131 = getQoEByAvailableIfaceNameV1(r111.readString());
            r112.writeNoException();
            if (r131 == null) goto L57;
            r112.writeInt(1);
            r131.writeToParcel(r112, 1);
        L58:
            return true;
        L57:
            r112.writeInt(0);
            goto L58
        L59:
            r111.enforceInterface("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost");
            int r132 = getServiceVersion();
            r112.writeNoException();
            r112.writeInt(r132);
            return true;
        L61:
            r111.enforceInterface("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost");
            boolean r133 = setTrafficTransInterface(r111.readInt(), r111.readString());
            r112.writeNoException();
            r112.writeInt(r133 ? 1 : 0);
            return true;
        L63:
            r111.enforceInterface("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost");
            Map<String, String> r134 = getQoEByAvailableIfaceName(r111.readString());
            r112.writeNoException();
            if (r134 != null) goto L66;
            r112.writeInt(-1);
        L67:
            return true;
        L66:
            r112.writeInt(r134.size());
            r134.forEach(new c(r112));
            goto L67
        L68:
            r111.enforceInterface("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost");
            boolean r135 = unregisterWifiLinkCallback(IAIDLMiuiWlanQoECallback.Stub.asInterface(r111.readStrongBinder()));
            r112.writeNoException();
            r112.writeInt(r135 ? 1 : 0);
            return true;
        L70:
            r111.enforceInterface("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost");
            boolean r136 = registerWifiLinkCallback(IAIDLMiuiWlanQoECallback.Stub.asInterface(r111.readStrongBinder()));
            r112.writeNoException();
            r112.writeInt(r136 ? 1 : 0);
            return true;
        L72:
            r111.enforceInterface("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost");
            boolean r137 = resumeWifiPowerSave();
            r112.writeNoException();
            r112.writeInt(r137 ? 1 : 0);
            return true;
        L74:
            r111.enforceInterface("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost");
            boolean r138 = suspendWifiPowerSave();
            r112.writeNoException();
            r112.writeInt(r138 ? 1 : 0);
            return true;
        L76:
            r111.enforceInterface("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost");
            boolean r139 = resumeBackgroundScan();
            r112.writeNoException();
            r112.writeInt(r139 ? 1 : 0);
            return true;
        L78:
            r111.enforceInterface("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost");
            boolean r140 = suspendBackgroundScan();
            r112.writeNoException();
            r112.writeInt(r140 ? 1 : 0);
            return true;
        L80:
            r111.enforceInterface("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost");
            boolean r141 = abortScan();
            r112.writeNoException();
            r112.writeInt(r141 ? 1 : 0);
            return true;
        L82:
            r111.enforceInterface("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost");
            boolean r142 = activeScan(r111.createIntArray());
            r112.writeNoException();
            r112.writeInt(r142 ? 1 : 0);
            return true;
        L84:
            r111.enforceInterface("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost");
            boolean r143 = unregisterCallback(IAIDLMiuiNetworkCallback.Stub.asInterface(r111.readStrongBinder()));
            r112.writeNoException();
            r112.writeInt(r143 ? 1 : 0);
            return true;
        L86:
            r111.enforceInterface("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost");
            boolean r144 = registerCallback(IAIDLMiuiNetworkCallback.Stub.asInterface(r111.readStrongBinder()));
            r112.writeNoException();
            r112.writeInt(r144 ? 1 : 0);
            return true;
        L88:
            r111.enforceInterface("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost");
            Map<String, String> r145 = requestAppTrafficStatistics(r111.readInt(), r111.readLong(), r111.readLong());
            r112.writeNoException();
            if (r145 != null) goto L91;
            r112.writeInt(-1);
        L92:
            return true;
        L91:
            r112.writeInt(r145.size());
            r145.forEach(new d(r112));
            goto L92
        L93:
            r111.enforceInterface("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost");
            Map<String, String> r146 = getAvailableIfaces();
            r112.writeNoException();
            if (r146 != null) goto L96;
            r112.writeInt(-1);
        L97:
            return true;
        L96:
            r112.writeInt(r146.size());
            r146.forEach(new e(r112));
            goto L97
        L98:
            r111.enforceInterface("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost");
            boolean r147 = disconnectSlaveWifi();
            r112.writeNoException();
            r112.writeInt(r147 ? 1 : 0);
            return true;
        L100:
            r111.enforceInterface("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost");
            boolean r148 = connectSlaveWifi(r111.readInt());
            r112.writeNoException();
            r112.writeInt(r148 ? 1 : 0);
            return true;
        L102:
            r111.enforceInterface("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost");
            if (r111.readInt() == 0) goto L105;
            r100 = true;
        L105:
            boolean r149 = setSlaveWifiEnable(r100);
            r112.writeNoException();
            r112.writeInt(r149 ? 1 : 0);
            return true;
        L107:
            r111.enforceInterface("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost");
            boolean r150 = isSupportDualWifi();
            r112.writeNoException();
            r112.writeInt(r150 ? 1 : 0);
            return true;
        L109:
            r111.enforceInterface("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost");
            boolean r151 = setTCPCongestion(r111.readInt(), r111.readString());
            r112.writeNoException();
            r112.writeInt(r151 ? 1 : 0);
            return true;
        L111:
            r111.enforceInterface("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost");
            boolean r152 = setSockPrio(r111.readInt(), r111.readInt());
            r112.writeNoException();
            r112.writeInt(r152 ? 1 : 0);
            return true;
        L7:
            return super.onTransact(r110, r111, r112, r113);
        L113:
            r112.writeString("com.xiaomi.NetworkBoost.IAIDLMiuiNetworkBoost");
            return true;
        }
    }

    boolean abortScan();

    boolean activeScan(int[] r100);

    boolean connectSlaveWifi(int r100);

    boolean disableWifiSelectionOpt(IAIDLMiuiNetSelectCallback r100);

    boolean disableWifiSelectionOptByUid(IAIDLMiuiNetSelectCallback r100, int r101);

    boolean disconnectSlaveWifi();

    boolean enableWifiSelectionOpt(IAIDLMiuiNetSelectCallback r100, int r101);

    boolean enableWifiSelectionOptByUid(IAIDLMiuiNetSelectCallback r100, int r101, int r102);

    Map<String, String> getAvailableIfaces();

    Map<String, String> getQoEByAvailableIfaceName(String r100);

    NetLinkLayerQoE getQoEByAvailableIfaceNameV1(String r100);

    int getServiceVersion();

    boolean isCelluarDSDAState();

    int isSlaveWifiEnabledAndOthersOpt(int r100);

    int isSlaveWifiEnabledAndOthersOptByUid(int r100, int r101);

    boolean isSupportDualCelluarData();

    boolean isSupportDualWifi();

    boolean isSupportMediaPlayerPolicy();

    boolean registerCallback(IAIDLMiuiNetworkCallback r100);

    boolean registerNetLinkCallback(IAIDLMiuiNetQoECallback r100, int r101);

    boolean registerNetLinkCallbackByUid(IAIDLMiuiNetQoECallback r100, int r101, int r102);

    boolean registerWifiLinkCallback(IAIDLMiuiWlanQoECallback r100);

    void reportBssidScore(Map<String, String> r100);

    Map<String, String> requestAppTrafficStatistics(int r100, long r101, long r102);

    Map<String, String> requestAppTrafficStatisticsByUid(int r100, long r101, long r102, int r103);

    boolean resumeBackgroundScan();

    boolean resumeWifiPowerSave();

    void sendMediaPlayerPolicyEvent(int r100, int r101, String r102);

    boolean setDualCelluarDataEnable(boolean r100);

    boolean setSlaveWifiEnable(boolean r100);

    boolean setSockPrio(int r100, int r101);

    boolean setTCPCongestion(int r100, String r101);

    boolean setTrafficTransInterface(int r100, String r101);

    boolean suspendBackgroundScan();

    boolean suspendWifiPowerSave();

    void triggerWifiSelection();

    boolean unregisterCallback(IAIDLMiuiNetworkCallback r100);

    boolean unregisterNetLinkCallback(IAIDLMiuiNetQoECallback r100);

    boolean unregisterNetLinkCallbackByUid(IAIDLMiuiNetQoECallback r100, int r101);

    boolean unregisterWifiLinkCallback(IAIDLMiuiWlanQoECallback r100);
}
