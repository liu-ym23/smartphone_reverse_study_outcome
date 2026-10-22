package com.bytedance.bdp.bdpbase.ipc;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.SystemClock;
import com.bytedance.bdp.appbase.base.bdptask.BdpPool;
import com.bytedance.bdp.appbase.base.bdptask.BdpTrace;
import com.bytedance.bdp.appbase.base.bdptask.TracePoint;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes11.dex */
interface ITransfer extends IInterface {

    public static abstract class Stub extends Binder implements ITransfer {
        private static final String DESCRIPTOR = "com.bytedance.bdp.bdpbase.ipc.ITransfer";
        static final int TRANSACTION_EXECUTE = 1;
        static final int TRANSACTION_REGISTER = 2;
        static final int TRANSACTION_UN_REGISTER = 3;

        public static class Proxy implements ITransfer {
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

            @Override // com.bytedance.bdp.bdpbase.ipc.ITransfer
            public Response<Object> execute(Request r110) throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L58
                int r102 = 0;
                if (r110 == null) goto L6;
                r100.writeInt(1);     // Catch: Throwable -> L58
                r100.writeLong(System.nanoTime());     // Catch: Throwable -> L58
                r110.writeToParcel(r100, 0);     // Catch: Throwable -> L58
            L7:
                Parcelable[] r111 = null;
                if (BdpTrace.ENABLE == false) goto L20;
                if (r110 == null) goto L12;
                long r112 = r110.f201122i;     // Catch: Throwable -> L58
            L14:
                if (r110 == null) goto L16;
                String r113 = r110.f201114a + ":" + r110.f201116c;     // Catch: Throwable -> L58
            L17:
                BdpTrace.appendTrace(new TracePoint("IPC Client target=" + r113 + ",reqId=" + r112, "", 3));     // Catch: Throwable -> L58
                LinkedList<TracePoint> r103 = BdpTrace.a();     // Catch: Throwable -> L58
                if (r103 == null) goto L20;
                List r104 = new LinkedList(r103);     // Catch: Throwable -> L58
            L21:
                if (r104 != null) goto L23;
                r104 = Collections.emptyList();     // Catch: Throwable -> L58
            L23:
                r100.writeInt(1);     // Catch: Throwable -> L58
                r100.writeParcelableArray((TracePoint[]) r104.toArray(new TracePoint[r104.size()]), 0);     // Catch: Throwable -> L58
                if (r110 != null) goto L26;
            L30:
                int r105 = r100.dataSize();     // Catch: Throwable -> L58
                if (r105 <= 921600) goto L35;
                Response<Object> r106 = new Response(507, "Request data too large! size is: " + r105 + ", request id: 0", null, 0, false);     // Catch: Throwable -> L58
                r101.recycle();
                r100.recycle();
                return r106;
            L35:
                INVOKEINTERFACE_com_bytedance_bdp_bdpbase_ipc_ITransfer$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r100, r101, 0);     // Catch: Throwable -> L58
                long r107 = r101.readLong();     // Catch: Throwable -> L58
                r101.readException();     // Catch: Throwable -> L58
                if (r101.readInt() == 0) goto L38;
                long r114 = r101.readLong();     // Catch: Throwable -> L58
                Response<Object> r108 = Response.CREATOR.createFromParcel(r101);     // Catch: Throwable -> L58
                r108.f201131g = System.nanoTime() - r114;     // Catch: Throwable -> L58
                r108.f201130f = r107;     // Catch: Throwable -> L58
            L40:
                if (r101.readInt() == 0) goto L56;
                ClassLoader r109 = com.bytedance.bdp.bdpbase.util.b.a();     // Catch: Throwable -> L58
                Parcelable.Creator<Request> r115 = Request.CREATOR;     // Catch: Throwable -> L58
                int r116 = r101.readInt();     // Catch: Throwable -> L58
                if (r116 < 0) goto L47;
                r111 = (Parcelable[]) Array.newInstance(TracePoint.class, r116);     // Catch: Throwable -> L58
            L45:
                if (r102 >= r116) goto L47;
                r111[r102] = r101.readParcelable(r109);     // Catch: Throwable -> L58
                r102 = r102 + 1;     // Catch: Throwable -> L58
            L47:
                TracePoint[] r117 = (TracePoint[]) r111;     // Catch: Throwable -> L58
                if (r117 == null) goto L56;
                List r118 = Arrays.asList(r117);     // Catch: Throwable -> L58
                LinkedList<TracePoint> r119 = BdpTrace.a();     // Catch: Throwable -> L58
                if (r119 == null) goto L56;
                int r120 = r118.size();     // Catch: Throwable -> L58
            L52:
                r120 = r120 - 1;     // Catch: Throwable -> L58
                if (r120 < 0) goto L56;
                com.bytedance.bdp.appbase.base.bdptask.k.c(r119, (TracePoint) ListProtector.get(r118, r120));     // Catch: Throwable -> L58
            L56:
                r101.recycle();
                r100.recycle();
                return r108;
            L38:
                r108 = null;
                goto L40
            L26:
                if (r110.f201118e == false) goto L30;
                INVOKEINTERFACE_com_bytedance_bdp_bdpbase_ipc_ITransfer$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r100, null, 1);     // Catch: Throwable -> L58
                r101.recycle();
                r100.recycle();
                return null;
            L16:
                r113 = "";
                goto L17
            L12:
                r112 = 0;
            L20:
                r104 = null;
                goto L21
            L6:
                r100.writeInt(0);     // Catch: Throwable -> L58
            L58:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.bytedance.bdp.bdpbase.ipc.ITransfer
            public void register(ICallback r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                if (r100 == null) goto L6;
                IBinder r103 = r100.asBinder();     // Catch: Throwable -> L10
            L7:
                r101.writeStrongBinder(r103);     // Catch: Throwable -> L10
                INVOKEINTERFACE_com_bytedance_bdp_bdpbase_ipc_ITransfer$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r101, r102, 0);     // Catch: Throwable -> L10
                r102.readException();     // Catch: Throwable -> L10
                r102.recycle();
                r101.recycle();
                return;
            L6:
                r103 = null;
            L10:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.bytedance.bdp.bdpbase.ipc.ITransfer
            public void unRegister(ICallback r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                if (r100 == null) goto L6;
                IBinder r103 = r100.asBinder();     // Catch: Throwable -> L10
            L7:
                r101.writeStrongBinder(r103);     // Catch: Throwable -> L10
                INVOKEINTERFACE_com_bytedance_bdp_bdpbase_ipc_ITransfer$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r101, r102, 0);     // Catch: Throwable -> L10
                r102.readException();     // Catch: Throwable -> L10
                r102.recycle();
                r101.recycle();
                return;
            L6:
                r103 = null;
            L10:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_bytedance_bdp_bdpbase_ipc_ITransfer$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        public class a implements Callable<Boolean> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f201103a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Parcel f201104b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Parcel f201105c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ int f201106d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ Stub f201107e;

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Boolean call() throws Exception {
                return Boolean.valueOf(Stub.access$000(this.f201107e, this.f201103a, this.f201104b, this.f201105c, this.f201106d));
            }

            @Override // java.util.concurrent.Callable
            public /* bridge */ /* synthetic */ Boolean call() throws Exception {
                return call();
            }

            public a(Stub r100, int r101, Parcel r102, Parcel r103, int r104) {
                this.f201107e = r100;
                this.f201103a = r101;
                this.f201104b = r102;
                this.f201105c = r103;
                this.f201106d = r104;
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ITransfer asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof ITransfer) == false) goto L12;
            return (ITransfer) r101;
        L12:
            return new Proxy(r100);
        }

        private boolean doTransact(int r110, Parcel r111, Parcel r112, int r113) throws RemoteException {
            if (r110 != 1) goto L5;
            r111.enforceInterface(DESCRIPTOR);
            LinkedList r100 = null;
            if (r111.readInt() == 0) goto L20;
            long r101 = r111.readLong();
            Request r114 = Request.CREATOR.createFromParcel(r111);
            r112.writeLong(System.nanoTime() - r101);
        L21:
            LinkedList r102 = new LinkedList();
            if (r111.readInt() == 0) goto L35;
            ClassLoader r103 = com.bytedance.bdp.bdpbase.util.b.a();
            Parcelable.Creator<Request> r104 = Request.CREATOR;
            int r105 = r111.readInt();
            if (r105 >= 0) goto L26;
            Parcelable[] r106 = null;
        L29:
            TracePoint[] r107 = (TracePoint[]) r106;
            if (r107 == null) goto L35;
            int r115 = r107.length;
            int r108 = 0;
        L32:
            if (r108 >= r115) goto L35;
            r102.addLast(r107[r108]);
            r108 = r108 + 1;
            goto L32
        L26:
            r106 = (Parcelable[]) Array.newInstance(TracePoint.class, r105);
            int r109 = 0;
        L27:
            if (r109 >= r105) goto L29;
            r106[r109] = r111.readParcelable(r103);
            r109 = r109 + 1;
        L35:
            if (BdpTrace.ENABLE == false) goto L50;
            BdpTrace.b(r102);
            if (r114 == null) goto L39;
            long r116 = r114.f201122i;
        L40:
            String r117 = "";
            if (r114 == null) goto L43;
            String r118 = r114.f201114a + ":" + r114.f201116c;
        L45:
            if (r102.size() <= 0) goto L49;
            TracePoint r119 = (TracePoint) r102.getFirst();
            if (r119.event != 3) goto L49;
            r117 = r119.getEventKey();
        L49:
            BdpTrace.appendTrace(new TracePoint("IPC Server target=" + r118 + ",reqId=" + r116, r117, 1));
            goto L50
        L43:
            r118 = "";
            goto L45
        L39:
            r116 = 0;
        L50:
            Response<Object> r120 = execute(r114);
            if (BdpTrace.ENABLE == false) goto L62;
            LinkedList<TracePoint> r121 = BdpTrace.a();
            if (r121 == null) goto L56;
            r100 = new LinkedList(r121);
        L56:
            if (r102.isEmpty() == true) goto L62;
            if (r100 == null) goto L62;
            if (r100.isEmpty() == true) goto L62;
            r100.removeLastOccurrence((TracePoint) r102.removeLast());
        L62:
            if ((r113 & 1) == 0) goto L64;
            return true;
        L64:
            r112.writeNoException();
            if (r120 == null) goto L67;
            r112.writeInt(1);
            r112.writeLong(System.nanoTime());
            r120.writeToParcel(r112, 1);
        L68:
            if (r100 == null) goto L70;
            r112.writeInt(1);
            r112.writeParcelableArray((TracePoint[]) r100.toArray(new TracePoint[r100.size()]), 1);
        L71:
            return true;
        L70:
            r112.writeInt(0);
            goto L71
        L67:
            r112.writeInt(0);
            goto L68
        L20:
            r114 = null;
            goto L21
        L5:
            if (r110 == 2) goto L15;
            if (r110 != 3) goto L8;
            r111.enforceInterface(DESCRIPTOR);
            unRegister(ICallback.Stub.asInterface(r111.readStrongBinder()));
            r112.writeNoException();
            return true;
        L8:
            if (r110 != 1598968902) goto L10;
            r112.writeString(DESCRIPTOR);
            return true;
        L10:
            return super.onTransact(r110, r111, r112, r113);
        L15:
            r111.enforceInterface(DESCRIPTOR);
            register(ICallback.Stub.asInterface(r111.readStrongBinder()));
            r112.writeNoException();
            return true;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r100, Parcel r101, Parcel r110, int r111) throws RemoteException {
            return ((Boolean) BdpPool.directRun("", new a(this, r100, r101, r110, r111))).booleanValue();
        }

        public static /* synthetic */ boolean access$000(Stub r100, int r101, Parcel r102, Parcel r103, int r104) throws RemoteException {
            return r100.doTransact(r101, r102, r103, r104);
        }
    }

    Response<Object> execute(Request r100) throws RemoteException;

    void register(ICallback r100) throws RemoteException;

    void unRegister(ICallback r100) throws RemoteException;
}
