package com.obric.livecard.api;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import com.obric.livecard.api.entity.IslandSession;
import com.obric.livecard.api.entity.IslandWidget;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes5.dex */
public interface IIslandService extends IInterface {

    /* JADX INFO: loaded from: classes33.dex */
    public static class Default implements IIslandService {
        public Default() {
        }

        @Override // com.obric.livecard.api.IIslandService
        public void addIIslandStatusCallback(IIslandStatusCallback r100) throws RemoteException {
        }

        @Override // com.obric.livecard.api.IIslandService
        public void addOnTopCardChangedListener(ITopSessionChangedCallback r100) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.livecard.api.IIslandService
        public void collapseNotificationPanel() throws RemoteException {
        }

        @Override // com.obric.livecard.api.IIslandService
        public void createSession(IslandSession r100, String r101, IIslandCardCallback r102) throws RemoteException {
        }

        @Override // com.obric.livecard.api.IIslandService
        public void destroySession(IslandSession r100) throws RemoteException {
        }

        @Override // com.obric.livecard.api.IIslandService
        public void doCollapse() throws RemoteException {
        }

        @Override // com.obric.livecard.api.IIslandService
        public Bundle getIslandVersion() throws RemoteException {
            return null;
        }

        @Override // com.obric.livecard.api.IIslandService
        public Bundle getPriority(IslandSession r100) throws RemoteException {
            return null;
        }

        @Override // com.obric.livecard.api.IIslandService
        public void onLauncherFocused() throws RemoteException {
        }

        @Override // com.obric.livecard.api.IIslandService
        public void onNotificationVisible(boolean r100) throws RemoteException {
        }

        @Override // com.obric.livecard.api.IIslandService
        public void onSysUIFlagsChanged(long r100) throws RemoteException {
        }

        @Override // com.obric.livecard.api.IIslandService
        public void onVolumeButtonClick() throws RemoteException {
        }

        @Override // com.obric.livecard.api.IIslandService
        public void refreshScene(IslandSession r100) throws RemoteException {
        }

        @Override // com.obric.livecard.api.IIslandService
        public void removeIIslandStatusCallback(IIslandStatusCallback r100) throws RemoteException {
        }

        @Override // com.obric.livecard.api.IIslandService
        public void removeOnTopCardChangedListener(ITopSessionChangedCallback r100) throws RemoteException {
        }

        @Override // com.obric.livecard.api.IIslandService
        public void sendEvent(IslandSession r100, IslandWidget r101, String r102, String r103) throws RemoteException {
        }

        @Override // com.obric.livecard.api.IIslandService
        public void setKeyguardLocked(boolean r100) throws RemoteException {
        }

        @Override // com.obric.livecard.api.IIslandService
        public void setPriority(IslandSession r100) throws RemoteException {
        }

        @Override // com.obric.livecard.api.IIslandService
        public void setVisible(boolean r100) throws RemoteException {
        }

        @Override // com.obric.livecard.api.IIslandService
        public void tryExpand(IslandSession r100, boolean r101) throws RemoteException {
        }

        @Override // com.obric.livecard.api.IIslandService
        public void updateAudioAmplitude(IslandSession r100, float r101) throws RemoteException {
        }

        @Override // com.obric.livecard.api.IIslandService
        public void updateSessionFlags(IslandSession r100) throws RemoteException {
        }

        @Override // com.obric.livecard.api.IIslandService
        public void updateWidget(IslandSession r100, IslandWidget r101) throws RemoteException {
        }

        @Override // com.obric.livecard.api.IIslandService
        public void updateWidgetAnimation(IslandSession r100, IslandWidget r101) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IIslandService {
        private static final String DESCRIPTOR = "com.obric.livecard.api.IIslandService";
        static final int TRANSACTION_addIIslandStatusCallback = 8;
        static final int TRANSACTION_addOnTopCardChangedListener = 18;
        static final int TRANSACTION_collapseNotificationPanel = 22;
        static final int TRANSACTION_createSession = 1;
        static final int TRANSACTION_destroySession = 2;
        static final int TRANSACTION_doCollapse = 7;
        static final int TRANSACTION_getIslandVersion = 16;
        static final int TRANSACTION_getPriority = 20;
        static final int TRANSACTION_onLauncherFocused = 11;
        static final int TRANSACTION_onNotificationVisible = 13;
        static final int TRANSACTION_onSysUIFlagsChanged = 15;
        static final int TRANSACTION_onVolumeButtonClick = 10;
        static final int TRANSACTION_refreshScene = 23;
        static final int TRANSACTION_removeIIslandStatusCallback = 9;
        static final int TRANSACTION_removeOnTopCardChangedListener = 19;
        static final int TRANSACTION_sendEvent = 5;
        static final int TRANSACTION_setKeyguardLocked = 12;
        static final int TRANSACTION_setPriority = 21;
        static final int TRANSACTION_setVisible = 6;
        static final int TRANSACTION_tryExpand = 14;
        static final int TRANSACTION_updateAudioAmplitude = 24;
        static final int TRANSACTION_updateSessionFlags = 17;
        static final int TRANSACTION_updateWidget = 3;
        static final int TRANSACTION_updateWidgetAnimation = 4;

        public static class Proxy implements IIslandService {
            public static IIslandService sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.livecard.api.IIslandService
            public void collapseNotificationPanel() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_livecard_api_IIslandService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 22, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().collapseNotificationPanel();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return;
            L13:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.livecard.api.IIslandService
            public void doCollapse() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_livecard_api_IIslandService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 7, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().doCollapse();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return;
            L13:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.livecard.api.IIslandService
            public Bundle getIslandVersion() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_livecard_api_IIslandService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 16, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L17
                if (r101.readInt() == 0) goto L14;
                Bundle r102 = (Bundle) Bundle.CREATOR.createFromParcel(r101);     // Catch: Throwable -> L17
            L15:
                r101.recycle();
                r100.recycle();
                return r102;
            L14:
                r102 = null;
                goto L15
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Bundle r103 = Stub.getDefaultImpl().getIslandVersion();     // Catch: Throwable -> L17
                r101.recycle();
                r100.recycle();
                return r103;
            L17:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.livecard.api.IIslandService
            public void onLauncherFocused() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_livecard_api_IIslandService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 11, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onLauncherFocused();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return;
            L13:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.livecard.api.IIslandService
            public void onVolumeButtonClick() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_livecard_api_IIslandService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 10, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onVolumeButtonClick();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return;
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

            @Override // com.obric.livecard.api.IIslandService
            public void addIIslandStatusCallback(IIslandStatusCallback r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r100 == null) goto L6;
                IBinder r103 = r100.asBinder();     // Catch: Throwable -> L17
            L7:
                r101.writeStrongBinder(r103);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_livecard_api_IIslandService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 8, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().addIIslandStatusCallback(r100);     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return;
            L6:
                r103 = null;
            L17:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.obric.livecard.api.IIslandService
            public void addOnTopCardChangedListener(ITopSessionChangedCallback r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r100 == null) goto L6;
                IBinder r103 = r100.asBinder();     // Catch: Throwable -> L17
            L7:
                r101.writeStrongBinder(r103);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_livecard_api_IIslandService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 18, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().addOnTopCardChangedListener(r100);     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return;
            L6:
                r103 = null;
            L17:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.obric.livecard.api.IIslandService
            public void destroySession(IslandSession r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L19
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L19
                r100.writeToParcel(r101, 0);     // Catch: Throwable -> L19
            L8:
                if (INVOKEINTERFACE_com_obric_livecard_api_IIslandService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L19
                if (r102.readInt() == 0) goto L17;
                r100.readFromParcel(r102);     // Catch: Throwable -> L19
            L17:
                r102.recycle();
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().destroySession(r100);     // Catch: Throwable -> L19
                r102.recycle();
                r101.recycle();
                return;
            L6:
                r101.writeInt(0);     // Catch: Throwable -> L19
            L19:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.obric.livecard.api.IIslandService
            public Bundle getPriority(IslandSession r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L21
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L21
                r100.writeToParcel(r101, 0);     // Catch: Throwable -> L21
            L8:
                if (INVOKEINTERFACE_com_obric_livecard_api_IIslandService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 20, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L21
                if (r102.readInt() == 0) goto L18;
                Bundle r103 = (Bundle) Bundle.CREATOR.createFromParcel(r102);     // Catch: Throwable -> L21
            L19:
                r102.recycle();
                r101.recycle();
                return r103;
            L18:
                r103 = null;
                goto L19
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Bundle r104 = Stub.getDefaultImpl().getPriority(r100);     // Catch: Throwable -> L21
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

            @Override // com.obric.livecard.api.IIslandService
            public void onNotificationVisible(boolean r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r100 == false) goto L6;
                int r103 = 1;
            L7:
                r101.writeInt(r103);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_livecard_api_IIslandService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 13, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onNotificationVisible(r100);     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return;
            L6:
                r103 = 0;
            L17:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.obric.livecard.api.IIslandService
            public void onSysUIFlagsChanged(long r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r101.writeLong(r100);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_livecard_api_IIslandService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 15, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onSysUIFlagsChanged(r100);     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return;
            L13:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.obric.livecard.api.IIslandService
            public void refreshScene(IslandSession r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L17
                r100.writeToParcel(r101, 0);     // Catch: Throwable -> L17
            L8:
                if (INVOKEINTERFACE_com_obric_livecard_api_IIslandService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 23, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().refreshScene(r100);     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return;
            L6:
                r101.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.obric.livecard.api.IIslandService
            public void removeIIslandStatusCallback(IIslandStatusCallback r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r100 == null) goto L6;
                IBinder r103 = r100.asBinder();     // Catch: Throwable -> L17
            L7:
                r101.writeStrongBinder(r103);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_livecard_api_IIslandService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 9, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().removeIIslandStatusCallback(r100);     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return;
            L6:
                r103 = null;
            L17:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.obric.livecard.api.IIslandService
            public void removeOnTopCardChangedListener(ITopSessionChangedCallback r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r100 == null) goto L6;
                IBinder r103 = r100.asBinder();     // Catch: Throwable -> L17
            L7:
                r101.writeStrongBinder(r103);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_livecard_api_IIslandService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 19, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().removeOnTopCardChangedListener(r100);     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return;
            L6:
                r103 = null;
            L17:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.obric.livecard.api.IIslandService
            public void setKeyguardLocked(boolean r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r100 == false) goto L6;
                int r103 = 1;
            L7:
                r101.writeInt(r103);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_livecard_api_IIslandService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 12, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().setKeyguardLocked(r100);     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return;
            L6:
                r103 = 0;
            L17:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.obric.livecard.api.IIslandService
            public void setPriority(IslandSession r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L17
                r100.writeToParcel(r101, 0);     // Catch: Throwable -> L17
            L8:
                if (INVOKEINTERFACE_com_obric_livecard_api_IIslandService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 21, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().setPriority(r100);     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return;
            L6:
                r101.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.obric.livecard.api.IIslandService
            public void setVisible(boolean r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r100 == false) goto L6;
                int r103 = 1;
            L7:
                r101.writeInt(r103);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_livecard_api_IIslandService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 6, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().setVisible(r100);     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return;
            L6:
                r103 = 0;
            L17:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.obric.livecard.api.IIslandService
            public void updateSessionFlags(IslandSession r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L17
                r100.writeToParcel(r101, 0);     // Catch: Throwable -> L17
            L8:
                if (INVOKEINTERFACE_com_obric_livecard_api_IIslandService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 17, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().updateSessionFlags(r100);     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return;
            L6:
                r101.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.obric.livecard.api.IIslandService
            public void tryExpand(IslandSession r100, boolean r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                int r104 = 1;
                if (r100 == null) goto L6;
                r102.writeInt(1);     // Catch: Throwable -> L20
                r100.writeToParcel(r102, 0);     // Catch: Throwable -> L20
            L7:
                if (r101 == true) goto L10;
                r104 = 0;
            L10:
                r102.writeInt(r104);     // Catch: Throwable -> L20
                if (INVOKEINTERFACE_com_obric_livecard_api_IIslandService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 14, r102, r103, 0) == false) goto L13;
            L17:
                r103.readException();     // Catch: Throwable -> L20
                r103.recycle();
                r102.recycle();
                return;
            L13:
                if (Stub.getDefaultImpl() == null) goto L17;
                Stub.getDefaultImpl().tryExpand(r100, r101);     // Catch: Throwable -> L20
                r103.recycle();
                r102.recycle();
                return;
            L6:
                r102.writeInt(0);     // Catch: Throwable -> L20
            L20:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Override // com.obric.livecard.api.IIslandService
            public void updateAudioAmplitude(IslandSession r100, float r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r100 == null) goto L6;
                r102.writeInt(1);     // Catch: Throwable -> L17
                r100.writeToParcel(r102, 0);     // Catch: Throwable -> L17
            L7:
                r102.writeFloat(r101);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_livecard_api_IIslandService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 24, r102, r103, 0) == false) goto L10;
            L14:
                r103.readException();     // Catch: Throwable -> L17
                r103.recycle();
                r102.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().updateAudioAmplitude(r100, r101);     // Catch: Throwable -> L17
                r103.recycle();
                r102.recycle();
                return;
            L6:
                r102.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Override // com.obric.livecard.api.IIslandService
            public void updateWidget(IslandSession r100, IslandWidget r101) throws RemoteException {
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
                if (INVOKEINTERFACE_com_obric_livecard_api_IIslandService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r102, r103, 0) == false) goto L13;
            L17:
                r103.readException();     // Catch: Throwable -> L20
                r103.recycle();
                r102.recycle();
                return;
            L13:
                if (Stub.getDefaultImpl() == null) goto L17;
                Stub.getDefaultImpl().updateWidget(r100, r101);     // Catch: Throwable -> L20
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

            @Override // com.obric.livecard.api.IIslandService
            public void updateWidgetAnimation(IslandSession r100, IslandWidget r101) throws RemoteException {
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
                if (INVOKEINTERFACE_com_obric_livecard_api_IIslandService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r102, r103, 0) == false) goto L13;
            L17:
                r103.readException();     // Catch: Throwable -> L20
                r103.recycle();
                r102.recycle();
                return;
            L13:
                if (Stub.getDefaultImpl() == null) goto L17;
                Stub.getDefaultImpl().updateWidgetAnimation(r100, r101);     // Catch: Throwable -> L20
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

            @Override // com.obric.livecard.api.IIslandService
            public void createSession(IslandSession r100, String r101, IIslandCardCallback r102) throws RemoteException {
                Parcel r103 = Parcel.obtain();
                Parcel r104 = Parcel.obtain();
                r103.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L23
                if (r100 == null) goto L6;
                r103.writeInt(1);     // Catch: Throwable -> L23
                r100.writeToParcel(r103, 0);     // Catch: Throwable -> L23
            L7:
                r103.writeString(r101);     // Catch: Throwable -> L23
                if (r102 == null) goto L10;
                IBinder r105 = r102.asBinder();     // Catch: Throwable -> L23
            L11:
                r103.writeStrongBinder(r105);     // Catch: Throwable -> L23
                if (INVOKEINTERFACE_com_obric_livecard_api_IIslandService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r103, r104, 0) == false) goto L14;
            L18:
                r104.readException();     // Catch: Throwable -> L23
                if (r104.readInt() == 0) goto L21;
                r100.readFromParcel(r104);     // Catch: Throwable -> L23
            L21:
                r104.recycle();
                r103.recycle();
                return;
            L14:
                if (Stub.getDefaultImpl() == null) goto L18;
                Stub.getDefaultImpl().createSession(r100, r101, r102);     // Catch: Throwable -> L23
                r104.recycle();
                r103.recycle();
                return;
            L10:
                r105 = null;
                goto L11
            L6:
                r103.writeInt(0);     // Catch: Throwable -> L23
            L23:
                th = move-exception;
                r104.recycle();
                r103.recycle();
                throw th;
            }

            @Override // com.obric.livecard.api.IIslandService
            public void sendEvent(IslandSession r100, IslandWidget r101, String r102, String r103) throws RemoteException {
                Parcel r104 = Parcel.obtain();
                Parcel r105 = Parcel.obtain();
                r104.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                if (r100 == null) goto L6;
                r104.writeInt(1);     // Catch: Throwable -> L20
                r100.writeToParcel(r104, 0);     // Catch: Throwable -> L20
            L7:
                if (r101 == null) goto L9;
                r104.writeInt(1);     // Catch: Throwable -> L20
                r101.writeToParcel(r104, 0);     // Catch: Throwable -> L20
            L10:
                r104.writeString(r102);     // Catch: Throwable -> L20
                r104.writeString(r103);     // Catch: Throwable -> L20
                if (INVOKEINTERFACE_com_obric_livecard_api_IIslandService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 5, r104, r105, 0) == false) goto L13;
            L17:
                r105.readException();     // Catch: Throwable -> L20
                r105.recycle();
                r104.recycle();
                return;
            L13:
                if (Stub.getDefaultImpl() == null) goto L17;
                Stub.getDefaultImpl().sendEvent(r100, r101, r102, r103);     // Catch: Throwable -> L20
                r105.recycle();
                r104.recycle();
                return;
            L9:
                r104.writeInt(0);     // Catch: Throwable -> L20
                goto L10
            L6:
                r104.writeInt(0);     // Catch: Throwable -> L20
            L20:
                th = move-exception;
                r105.recycle();
                r104.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_obric_livecard_api_IIslandService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        public static IIslandService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IIslandService asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof IIslandService) == false) goto L12;
            return (IIslandService) r101;
        L12:
            return new Proxy(r100);
        }

        public static boolean setDefaultImpl(IIslandService r100) {
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
            if (r100 == 1598968902) goto L125;
            boolean r104 = false;
            IslandSession r105 = null;
            IslandSession r106 = null;
            IslandSession r107 = null;
            IslandSession r108 = null;
            IslandSession r109 = null;
            IslandSession r110 = null;
            IslandSession r111 = null;
            IslandWidget r112 = null;
            IslandWidget r113 = null;
            IslandWidget r114 = null;
            IslandSession r115 = null;
            switch(r100) {
                case 1: goto L117;
                case 2: goto L109;
                case 3: goto L100;
                case 4: goto L91;
                case 5: goto L82;
                case 6: goto L77;
                case 7: goto L75;
                case 8: goto L73;
                case 9: goto L71;
                case 10: goto L69;
                case 11: goto L67;
                case 12: goto L62;
                case 13: goto L57;
                case 14: goto L49;
                case 15: goto L47;
                case 16: goto L42;
                case 17: goto L37;
                case 18: goto L35;
                case 19: goto L33;
                case 20: goto L25;
                case 21: goto L20;
                case 22: goto L18;
                case 23: goto L13;
                case 24: goto L8;
                default: goto L7;
            };
        L8:
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L11;
            r106 = IslandSession.CREATOR.createFromParcel(r101);
        L11:
            updateAudioAmplitude(r106, r101.readFloat());
            r102.writeNoException();
            return true;
        L13:
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L16;
            r107 = IslandSession.CREATOR.createFromParcel(r101);
        L16:
            refreshScene(r107);
            r102.writeNoException();
            return true;
        L18:
            r101.enforceInterface(DESCRIPTOR);
            collapseNotificationPanel();
            r102.writeNoException();
            return true;
        L20:
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L23;
            r108 = IslandSession.CREATOR.createFromParcel(r101);
        L23:
            setPriority(r108);
            r102.writeNoException();
            return true;
        L25:
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L28;
            r109 = IslandSession.CREATOR.createFromParcel(r101);
        L28:
            Bundle r116 = getPriority(r109);
            r102.writeNoException();
            if (r116 == null) goto L31;
            r102.writeInt(1);
            r116.writeToParcel(r102, 1);
        L32:
            return true;
        L31:
            r102.writeInt(0);
            goto L32
        L33:
            r101.enforceInterface(DESCRIPTOR);
            removeOnTopCardChangedListener(ITopSessionChangedCallback.Stub.asInterface(r101.readStrongBinder()));
            r102.writeNoException();
            return true;
        L35:
            r101.enforceInterface(DESCRIPTOR);
            addOnTopCardChangedListener(ITopSessionChangedCallback.Stub.asInterface(r101.readStrongBinder()));
            r102.writeNoException();
            return true;
        L37:
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L40;
            r110 = IslandSession.CREATOR.createFromParcel(r101);
        L40:
            updateSessionFlags(r110);
            r102.writeNoException();
            return true;
        L42:
            r101.enforceInterface(DESCRIPTOR);
            Bundle r117 = getIslandVersion();
            r102.writeNoException();
            if (r117 == null) goto L45;
            r102.writeInt(1);
            r117.writeToParcel(r102, 1);
        L46:
            return true;
        L45:
            r102.writeInt(0);
            goto L46
        L47:
            r101.enforceInterface(DESCRIPTOR);
            onSysUIFlagsChanged(r101.readLong());
            r102.writeNoException();
            return true;
        L49:
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L53;
            r111 = IslandSession.CREATOR.createFromParcel(r101);
        L53:
            if (r101.readInt() == 0) goto L55;
            r104 = true;
        L55:
            tryExpand(r111, r104);
            r102.writeNoException();
            return true;
        L57:
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L60;
            r104 = true;
        L60:
            onNotificationVisible(r104);
            r102.writeNoException();
            return true;
        L62:
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L65;
            r104 = true;
        L65:
            setKeyguardLocked(r104);
            r102.writeNoException();
            return true;
        L67:
            r101.enforceInterface(DESCRIPTOR);
            onLauncherFocused();
            r102.writeNoException();
            return true;
        L69:
            r101.enforceInterface(DESCRIPTOR);
            onVolumeButtonClick();
            r102.writeNoException();
            return true;
        L71:
            r101.enforceInterface(DESCRIPTOR);
            removeIIslandStatusCallback(IIslandStatusCallback.Stub.asInterface(r101.readStrongBinder()));
            r102.writeNoException();
            return true;
        L73:
            r101.enforceInterface(DESCRIPTOR);
            addIIslandStatusCallback(IIslandStatusCallback.Stub.asInterface(r101.readStrongBinder()));
            r102.writeNoException();
            return true;
        L75:
            r101.enforceInterface(DESCRIPTOR);
            doCollapse();
            r102.writeNoException();
            return true;
        L77:
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L80;
            r104 = true;
        L80:
            setVisible(r104);
            r102.writeNoException();
            return true;
        L82:
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L85;
            IslandSession r118 = IslandSession.CREATOR.createFromParcel(r101);
        L87:
            if (r101.readInt() == 0) goto L89;
            r112 = IslandWidget.CREATOR.createFromParcel(r101);
        L89:
            sendEvent(r118, r112, r101.readString(), r101.readString());
            r102.writeNoException();
            return true;
        L85:
            r118 = null;
            goto L87
        L91:
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L94;
            IslandSession r119 = IslandSession.CREATOR.createFromParcel(r101);
        L96:
            if (r101.readInt() == 0) goto L98;
            r113 = IslandWidget.CREATOR.createFromParcel(r101);
        L98:
            updateWidgetAnimation(r119, r113);
            r102.writeNoException();
            return true;
        L94:
            r119 = null;
            goto L96
        L100:
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L103;
            IslandSession r120 = IslandSession.CREATOR.createFromParcel(r101);
        L105:
            if (r101.readInt() == 0) goto L107;
            r114 = IslandWidget.CREATOR.createFromParcel(r101);
        L107:
            updateWidget(r120, r114);
            r102.writeNoException();
            return true;
        L103:
            r120 = null;
            goto L105
        L109:
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L112;
            r115 = IslandSession.CREATOR.createFromParcel(r101);
        L112:
            destroySession(r115);
            r102.writeNoException();
            if (r115 == null) goto L115;
            r102.writeInt(1);
            r115.writeToParcel(r102, 1);
        L116:
            return true;
        L115:
            r102.writeInt(0);
            goto L116
        L117:
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L120;
            r105 = IslandSession.CREATOR.createFromParcel(r101);
        L120:
            createSession(r105, r101.readString(), IIslandCardCallback.Stub.asInterface(r101.readStrongBinder()));
            r102.writeNoException();
            if (r105 == null) goto L123;
            r102.writeInt(1);
            r105.writeToParcel(r102, 1);
        L124:
            return true;
        L123:
            r102.writeInt(0);
            goto L124
        L7:
            return super.onTransact(r100, r101, r102, r103);
        L125:
            r102.writeString(DESCRIPTOR);
            return true;
        }
    }

    void addIIslandStatusCallback(IIslandStatusCallback r100) throws RemoteException;

    void addOnTopCardChangedListener(ITopSessionChangedCallback r100) throws RemoteException;

    void collapseNotificationPanel() throws RemoteException;

    void createSession(IslandSession r100, String r101, IIslandCardCallback r102) throws RemoteException;

    void destroySession(IslandSession r100) throws RemoteException;

    void doCollapse() throws RemoteException;

    Bundle getIslandVersion() throws RemoteException;

    Bundle getPriority(IslandSession r100) throws RemoteException;

    void onLauncherFocused() throws RemoteException;

    void onNotificationVisible(boolean r100) throws RemoteException;

    void onSysUIFlagsChanged(long r100) throws RemoteException;

    void onVolumeButtonClick() throws RemoteException;

    void refreshScene(IslandSession r100) throws RemoteException;

    void removeIIslandStatusCallback(IIslandStatusCallback r100) throws RemoteException;

    void removeOnTopCardChangedListener(ITopSessionChangedCallback r100) throws RemoteException;

    void sendEvent(IslandSession r100, IslandWidget r101, String r102, String r103) throws RemoteException;

    void setKeyguardLocked(boolean r100) throws RemoteException;

    void setPriority(IslandSession r100) throws RemoteException;

    void setVisible(boolean r100) throws RemoteException;

    void tryExpand(IslandSession r100, boolean r101) throws RemoteException;

    void updateAudioAmplitude(IslandSession r100, float r101) throws RemoteException;

    void updateSessionFlags(IslandSession r100) throws RemoteException;

    void updateWidget(IslandSession r100, IslandWidget r101) throws RemoteException;

    void updateWidgetAnimation(IslandSession r100, IslandWidget r101) throws RemoteException;
}
