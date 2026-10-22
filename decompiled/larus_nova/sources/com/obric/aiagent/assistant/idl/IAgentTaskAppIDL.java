package com.obric.aiagent.assistant.idl;

import android.app.PendingIntent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.assistant.idl.bean.ShortcutRecommendItem;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import java.util.ArrayList;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes4.dex */
public interface IAgentTaskAppIDL extends IInterface {

    /* JADX INFO: loaded from: classes6.dex */
    public static class Default implements IAgentTaskAppIDL {
        public Default() {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentTaskAppIDL
        public void addTaskManagerShortcut(PendingIntent r100) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentTaskAppIDL
        public List<ShortcutRecommendItem> getShortcutRecommendItems(int r100) throws RemoteException {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentTaskAppIDL
        public boolean hasShortcutForMessage(String r100) throws RemoteException {
            return false;
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentTaskAppIDL
        public void openEventTaskDetailPage(String r100, String r101) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentTaskAppIDL
        public void runShortcutTaskFromRecommendPanel(String r100, String r101) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentTaskAppIDL
        public boolean shouldShowAddTaskManagerIconGuide() throws RemoteException {
            return false;
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentTaskAppIDL
        public void testRunConditionTask(String r100, String r101) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IAgentTaskAppIDL {
        private static final String DESCRIPTOR = "com.obric.aiagent.assistant.idl.IAgentTaskAppIDL";
        static final int TRANSACTION_addTaskManagerShortcut = 3;
        static final int TRANSACTION_getShortcutRecommendItems = 6;
        static final int TRANSACTION_hasShortcutForMessage = 5;
        static final int TRANSACTION_openEventTaskDetailPage = 1;
        static final int TRANSACTION_runShortcutTaskFromRecommendPanel = 7;
        static final int TRANSACTION_shouldShowAddTaskManagerIconGuide = 4;
        static final int TRANSACTION_testRunConditionTask = 2;

        public static class Proxy implements IAgentTaskAppIDL {
            public static IAgentTaskAppIDL sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentTaskAppIDL
            public boolean shouldShowAddTaskManagerIconGuide() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                boolean r102 = false;
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentTaskAppIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r100, r101, 0) == false) goto L6;
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
                boolean r103 = Stub.getDefaultImpl().shouldShowAddTaskManagerIconGuide();     // Catch: Throwable -> L15
                r101.recycle();
                r100.recycle();
                return r103;
            L15:
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

            @Override // com.obric.aiagent.assistant.idl.IAgentTaskAppIDL
            public void addTaskManagerShortcut(PendingIntent r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L16
                r100.writeToParcel(r101, 0);     // Catch: Throwable -> L16
            L8:
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentTaskAppIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r101, null, 1) == false) goto L10;
            L14:
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().addTaskManagerShortcut(r100);     // Catch: Throwable -> L16
                r101.recycle();
                return;
            L6:
                r101.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentTaskAppIDL
            public List<ShortcutRecommendItem> getShortcutRecommendItems(int r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r101.writeInt(r100);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentTaskAppIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 6, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L13
                ArrayList r103 = r102.createTypedArrayList(ShortcutRecommendItem.CREATOR);     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return r103;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                List<ShortcutRecommendItem> r104 = Stub.getDefaultImpl().getShortcutRecommendItems(r100);     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return r104;
            L13:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentTaskAppIDL
            public boolean hasShortcutForMessage(String r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r101.writeString(r100);     // Catch: Throwable -> L15
                boolean r103 = false;
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentTaskAppIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 5, r101, r102, 0) == false) goto L6;
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
                boolean r104 = Stub.getDefaultImpl().hasShortcutForMessage(r100);     // Catch: Throwable -> L15
                r102.recycle();
                r101.recycle();
                return r104;
            L15:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentTaskAppIDL
            public void openEventTaskDetailPage(String r100, String r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r102.writeString(r100);     // Catch: Throwable -> L12
                r102.writeString(r101);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentTaskAppIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r102, null, 1) == false) goto L6;
            L10:
                r102.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().openEventTaskDetailPage(r100, r101);     // Catch: Throwable -> L12
                r102.recycle();
                return;
            L12:
                th = move-exception;
                r102.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentTaskAppIDL
            public void runShortcutTaskFromRecommendPanel(String r100, String r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r102.writeString(r100);     // Catch: Throwable -> L12
                r102.writeString(r101);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentTaskAppIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 7, r102, null, 1) == false) goto L6;
            L10:
                r102.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().runShortcutTaskFromRecommendPanel(r100, r101);     // Catch: Throwable -> L12
                r102.recycle();
                return;
            L12:
                th = move-exception;
                r102.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentTaskAppIDL
            public void testRunConditionTask(String r100, String r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r102.writeString(r100);     // Catch: Throwable -> L12
                r102.writeString(r101);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentTaskAppIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r102, null, 1) == false) goto L6;
            L10:
                r102.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().testRunConditionTask(r100, r101);     // Catch: Throwable -> L12
                r102.recycle();
                return;
            L12:
                th = move-exception;
                r102.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentTaskAppIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IAgentTaskAppIDL getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IAgentTaskAppIDL asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof IAgentTaskAppIDL) == false) goto L12;
            return (IAgentTaskAppIDL) r101;
        L12:
            return new Proxy(r100);
        }

        public static boolean setDefaultImpl(IAgentTaskAppIDL r100) {
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
        public boolean onTransact(int r100, Parcel r101, Parcel r102, int r103) throws RemoteException {
            if (r100 == 1598968902) goto L25;
            switch(r100) {
                case 1: goto L23;
                case 2: goto L21;
                case 3: goto L15;
                case 4: goto L13;
                case 5: goto L11;
                case 6: goto L9;
                case 7: goto L7;
                default: goto L6;
            };
        L7:
            r101.enforceInterface(DESCRIPTOR);
            runShortcutTaskFromRecommendPanel(r101.readString(), r101.readString());
            return true;
        L9:
            r101.enforceInterface(DESCRIPTOR);
            List<ShortcutRecommendItem> r104 = getShortcutRecommendItems(r101.readInt());
            r102.writeNoException();
            r102.writeTypedList(r104);
            return true;
        L11:
            r101.enforceInterface(DESCRIPTOR);
            boolean r105 = hasShortcutForMessage(r101.readString());
            r102.writeNoException();
            r102.writeInt(r105 ? 1 : 0);
            return true;
        L13:
            r101.enforceInterface(DESCRIPTOR);
            boolean r106 = shouldShowAddTaskManagerIconGuide();
            r102.writeNoException();
            r102.writeInt(r106 ? 1 : 0);
            return true;
        L15:
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L18;
            PendingIntent r107 = (PendingIntent) PendingIntent.CREATOR.createFromParcel(r101);
        L19:
            addTaskManagerShortcut(r107);
            return true;
        L18:
            r107 = null;
            goto L19
        L21:
            r101.enforceInterface(DESCRIPTOR);
            testRunConditionTask(r101.readString(), r101.readString());
            return true;
        L23:
            r101.enforceInterface(DESCRIPTOR);
            openEventTaskDetailPage(r101.readString(), r101.readString());
            return true;
        L6:
            return super.onTransact(r100, r101, r102, r103);
        L25:
            r102.writeString(DESCRIPTOR);
            return true;
        }
    }

    void addTaskManagerShortcut(PendingIntent r100) throws RemoteException;

    List<ShortcutRecommendItem> getShortcutRecommendItems(int r100) throws RemoteException;

    boolean hasShortcutForMessage(String r100) throws RemoteException;

    void openEventTaskDetailPage(String r100, String r101) throws RemoteException;

    void runShortcutTaskFromRecommendPanel(String r100, String r101) throws RemoteException;

    boolean shouldShowAddTaskManagerIconGuide() throws RemoteException;

    void testRunConditionTask(String r100, String r101) throws RemoteException;
}
