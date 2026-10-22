package android.support.v4.media.session;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import android.support.v4.media.MediaMetadataCompat;
import android.text.TextUtils;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public interface IMediaControllerCallback extends IInterface {

    public static abstract class Stub extends Binder implements IMediaControllerCallback {
        private static final String DESCRIPTOR = "android.support.v4.media.session.IMediaControllerCallback";
        static final int TRANSACTION_onCaptioningEnabledChanged = 11;
        static final int TRANSACTION_onEvent = 1;
        static final int TRANSACTION_onExtrasChanged = 7;
        static final int TRANSACTION_onMetadataChanged = 4;
        static final int TRANSACTION_onPlaybackStateChanged = 3;
        static final int TRANSACTION_onQueueChanged = 5;
        static final int TRANSACTION_onQueueTitleChanged = 6;
        static final int TRANSACTION_onRepeatModeChanged = 9;
        static final int TRANSACTION_onSessionDestroyed = 2;
        static final int TRANSACTION_onSessionReady = 13;
        static final int TRANSACTION_onShuffleModeChanged = 12;
        static final int TRANSACTION_onShuffleModeChangedRemoved = 10;
        static final int TRANSACTION_onVolumeInfoChanged = 8;

        public static class Proxy implements IMediaControllerCallback {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onSessionDestroyed() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                INVOKEINTERFACE_android_support_v4_media_session_IMediaControllerCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onSessionReady() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                INVOKEINTERFACE_android_support_v4_media_session_IMediaControllerCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, Stub.TRANSACTION_onSessionReady, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
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

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onCaptioningEnabledChanged(boolean r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                if (r5 == false) goto L6;
                int r6 = 1;
            L7:
                r0.writeInt(r6);     // Catch: Throwable -> L10
                INVOKEINTERFACE_android_support_v4_media_session_IMediaControllerCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 11, r0, null, 1);     // Catch: Throwable -> L10
                r0.recycle();
                return;
            L6:
                r6 = 0;
            L10:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onExtrasChanged(Bundle r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L10
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L10
            L7:
                INVOKEINTERFACE_android_support_v4_media_session_IMediaControllerCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 7, r0, null, 1);     // Catch: Throwable -> L10
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onMetadataChanged(MediaMetadataCompat r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L10
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L10
            L7:
                INVOKEINTERFACE_android_support_v4_media_session_IMediaControllerCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r0, null, 1);     // Catch: Throwable -> L10
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onPlaybackStateChanged(PlaybackStateCompat r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L10
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L10
            L7:
                INVOKEINTERFACE_android_support_v4_media_session_IMediaControllerCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r0, null, 1);     // Catch: Throwable -> L10
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onQueueChanged(List<MediaSessionCompat.QueueItem> r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeTypedList(r5);     // Catch: Throwable -> L6
                INVOKEINTERFACE_android_support_v4_media_session_IMediaControllerCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 5, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onQueueTitleChanged(CharSequence r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L10
                TextUtils.writeToParcel(r5, r0, 0);     // Catch: Throwable -> L10
            L7:
                INVOKEINTERFACE_android_support_v4_media_session_IMediaControllerCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 6, r0, null, 1);     // Catch: Throwable -> L10
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onRepeatModeChanged(int r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r5);     // Catch: Throwable -> L6
                INVOKEINTERFACE_android_support_v4_media_session_IMediaControllerCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 9, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onShuffleModeChanged(int r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r5);     // Catch: Throwable -> L6
                INVOKEINTERFACE_android_support_v4_media_session_IMediaControllerCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, Stub.TRANSACTION_onShuffleModeChanged, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onShuffleModeChangedRemoved(boolean r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                if (r5 == false) goto L6;
                int r6 = 1;
            L7:
                r0.writeInt(r6);     // Catch: Throwable -> L10
                INVOKEINTERFACE_android_support_v4_media_session_IMediaControllerCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 10, r0, null, 1);     // Catch: Throwable -> L10
                r0.recycle();
                return;
            L6:
                r6 = 0;
            L10:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onVolumeInfoChanged(ParcelableVolumeInfo r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L10
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L10
            L7:
                INVOKEINTERFACE_android_support_v4_media_session_IMediaControllerCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 8, r0, null, 1);     // Catch: Throwable -> L10
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onEvent(String r3, Bundle r4) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                r0.writeString(r3);     // Catch: Throwable -> L10
                if (r4 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L10
                r4.writeToParcel(r0, 0);     // Catch: Throwable -> L10
            L7:
                INVOKEINTERFACE_android_support_v4_media_session_IMediaControllerCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r0, null, 1);     // Catch: Throwable -> L10
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_android_support_v4_media_session_IMediaControllerCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r15, int r16, Parcel r17, Parcel r18, int r19) throws RemoteException {
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
                String r1 = "";
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
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IMediaControllerCallback asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IMediaControllerCallback) == false) goto L12;
            return (IMediaControllerCallback) r0;
        L12:
            return new Proxy(r2);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r5, Parcel r6, Parcel r7, int r8) throws RemoteException {
            if (r5 == 1598968902) goto L58;
            boolean r0 = false;
            Bundle r3 = null;
            ParcelableVolumeInfo r4 = null;
            Bundle r9 = null;
            CharSequence r10 = null;
            MediaMetadataCompat r11 = null;
            PlaybackStateCompat r12 = null;
            switch(r5) {
                case 1: goto L53;
                case 2: goto L51;
                case 3: goto L46;
                case 4: goto L41;
                case 5: goto L39;
                case 6: goto L34;
                case 7: goto L29;
                case 8: goto L24;
                case 9: goto L22;
                case 10: goto L17;
                case 11: goto L12;
                case 12: goto L10;
                case 13: goto L8;
                default: goto L7;
            };
        L8:
            r6.enforceInterface(DESCRIPTOR);
            onSessionReady();
            return true;
        L10:
            r6.enforceInterface(DESCRIPTOR);
            onShuffleModeChanged(r6.readInt());
            return true;
        L12:
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L15;
            r0 = true;
        L15:
            onCaptioningEnabledChanged(r0);
            return true;
        L17:
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L20;
            r0 = true;
        L20:
            onShuffleModeChangedRemoved(r0);
            return true;
        L22:
            r6.enforceInterface(DESCRIPTOR);
            onRepeatModeChanged(r6.readInt());
            return true;
        L24:
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L27;
            r4 = ParcelableVolumeInfo.CREATOR.createFromParcel(r6);
        L27:
            onVolumeInfoChanged(r4);
            return true;
        L29:
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L32;
            r9 = (Bundle) Bundle.CREATOR.createFromParcel(r6);
        L32:
            onExtrasChanged(r9);
            return true;
        L34:
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L37;
            r10 = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(r6);
        L37:
            onQueueTitleChanged(r10);
            return true;
        L39:
            r6.enforceInterface(DESCRIPTOR);
            onQueueChanged(r6.createTypedArrayList(MediaSessionCompat.QueueItem.CREATOR));
            return true;
        L41:
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L44;
            r11 = MediaMetadataCompat.CREATOR.createFromParcel(r6);
        L44:
            onMetadataChanged(r11);
            return true;
        L46:
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L49;
            r12 = PlaybackStateCompat.CREATOR.createFromParcel(r6);
        L49:
            onPlaybackStateChanged(r12);
            return true;
        L51:
            r6.enforceInterface(DESCRIPTOR);
            onSessionDestroyed();
            return true;
        L53:
            r6.enforceInterface(DESCRIPTOR);
            String r13 = r6.readString();
            if (r6.readInt() == 0) goto L56;
            r3 = (Bundle) Bundle.CREATOR.createFromParcel(r6);
        L56:
            onEvent(r13, r3);
            return true;
        L7:
            return super.onTransact(r5, r6, r7, r8);
        L58:
            r7.writeString(DESCRIPTOR);
            return true;
        }
    }

    void onCaptioningEnabledChanged(boolean r1) throws RemoteException;

    void onEvent(String r1, Bundle r2) throws RemoteException;

    void onExtrasChanged(Bundle r1) throws RemoteException;

    void onMetadataChanged(MediaMetadataCompat r1) throws RemoteException;

    void onPlaybackStateChanged(PlaybackStateCompat r1) throws RemoteException;

    void onQueueChanged(List<MediaSessionCompat.QueueItem> r1) throws RemoteException;

    void onQueueTitleChanged(CharSequence r1) throws RemoteException;

    void onRepeatModeChanged(int r1) throws RemoteException;

    void onSessionDestroyed() throws RemoteException;

    void onSessionReady() throws RemoteException;

    void onShuffleModeChanged(int r1) throws RemoteException;

    void onShuffleModeChangedRemoved(boolean r1) throws RemoteException;

    void onVolumeInfoChanged(ParcelableVolumeInfo r1) throws RemoteException;
}
