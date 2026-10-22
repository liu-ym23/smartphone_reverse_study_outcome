package android.support.v4.media.session;

import android.app.PendingIntent;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import java.util.ArrayList;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public interface IMediaSession extends IInterface {

    public static abstract class Stub extends Binder implements IMediaSession {
        private static final String DESCRIPTOR = "android.support.v4.media.session.IMediaSession";
        static final int TRANSACTION_addQueueItem = 41;
        static final int TRANSACTION_addQueueItemAt = 42;
        static final int TRANSACTION_adjustVolume = 11;
        static final int TRANSACTION_fastForward = 22;
        static final int TRANSACTION_getExtras = 31;
        static final int TRANSACTION_getFlags = 9;
        static final int TRANSACTION_getLaunchPendingIntent = 8;
        static final int TRANSACTION_getMetadata = 27;
        static final int TRANSACTION_getPackageName = 6;
        static final int TRANSACTION_getPlaybackState = 28;
        static final int TRANSACTION_getQueue = 29;
        static final int TRANSACTION_getQueueTitle = 30;
        static final int TRANSACTION_getRatingType = 32;
        static final int TRANSACTION_getRepeatMode = 37;
        static final int TRANSACTION_getShuffleMode = 47;
        static final int TRANSACTION_getTag = 7;
        static final int TRANSACTION_getVolumeAttributes = 10;
        static final int TRANSACTION_isCaptioningEnabled = 45;
        static final int TRANSACTION_isShuffleModeEnabledRemoved = 38;
        static final int TRANSACTION_isTransportControlEnabled = 5;
        static final int TRANSACTION_next = 20;
        static final int TRANSACTION_pause = 18;
        static final int TRANSACTION_play = 13;
        static final int TRANSACTION_playFromMediaId = 14;
        static final int TRANSACTION_playFromSearch = 15;
        static final int TRANSACTION_playFromUri = 16;
        static final int TRANSACTION_prepare = 33;
        static final int TRANSACTION_prepareFromMediaId = 34;
        static final int TRANSACTION_prepareFromSearch = 35;
        static final int TRANSACTION_prepareFromUri = 36;
        static final int TRANSACTION_previous = 21;
        static final int TRANSACTION_rate = 25;
        static final int TRANSACTION_rateWithExtras = 51;
        static final int TRANSACTION_registerCallbackListener = 3;
        static final int TRANSACTION_removeQueueItem = 43;
        static final int TRANSACTION_removeQueueItemAt = 44;
        static final int TRANSACTION_rewind = 23;
        static final int TRANSACTION_seekTo = 24;
        static final int TRANSACTION_sendCommand = 1;
        static final int TRANSACTION_sendCustomAction = 26;
        static final int TRANSACTION_sendMediaButton = 2;
        static final int TRANSACTION_setCaptioningEnabled = 46;
        static final int TRANSACTION_setRepeatMode = 39;
        static final int TRANSACTION_setShuffleMode = 48;
        static final int TRANSACTION_setShuffleModeEnabledRemoved = 40;
        static final int TRANSACTION_setVolumeTo = 12;
        static final int TRANSACTION_skipToQueueItem = 17;
        static final int TRANSACTION_stop = 19;
        static final int TRANSACTION_unregisterCallbackListener = 4;

        public static class Proxy implements IMediaSession {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void fastForward() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, Stub.TRANSACTION_fastForward, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public Bundle getExtras() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, Stub.TRANSACTION_getExtras, r0, r1, 0);     // Catch: Throwable -> L10
                r1.readException();     // Catch: Throwable -> L10
                if (r1.readInt() == 0) goto L7;
                Bundle r2 = (Bundle) Bundle.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L10
            L8:
                r1.recycle();
                r0.recycle();
                return r2;
            L7:
                r2 = null;
            L10:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public long getFlags() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 9, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                long r2 = r1.readLong();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r2;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public PendingIntent getLaunchPendingIntent() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 8, r0, r1, 0);     // Catch: Throwable -> L10
                r1.readException();     // Catch: Throwable -> L10
                if (r1.readInt() == 0) goto L7;
                PendingIntent r2 = (PendingIntent) PendingIntent.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L10
            L8:
                r1.recycle();
                r0.recycle();
                return r2;
            L7:
                r2 = null;
            L10:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public MediaMetadataCompat getMetadata() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, Stub.TRANSACTION_getMetadata, r0, r1, 0);     // Catch: Throwable -> L10
                r1.readException();     // Catch: Throwable -> L10
                if (r1.readInt() == 0) goto L7;
                MediaMetadataCompat r2 = MediaMetadataCompat.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L10
            L8:
                r1.recycle();
                r0.recycle();
                return r2;
            L7:
                r2 = null;
            L10:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public String getPackageName() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 6, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                String r2 = r1.readString();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r2;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public PlaybackStateCompat getPlaybackState() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, Stub.TRANSACTION_getPlaybackState, r0, r1, 0);     // Catch: Throwable -> L10
                r1.readException();     // Catch: Throwable -> L10
                if (r1.readInt() == 0) goto L7;
                PlaybackStateCompat r2 = PlaybackStateCompat.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L10
            L8:
                r1.recycle();
                r0.recycle();
                return r2;
            L7:
                r2 = null;
            L10:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public List<MediaSessionCompat.QueueItem> getQueue() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, Stub.TRANSACTION_getQueue, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                ArrayList r2 = r1.createTypedArrayList(MediaSessionCompat.QueueItem.CREATOR);     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r2;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public CharSequence getQueueTitle() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 30, r0, r1, 0);     // Catch: Throwable -> L10
                r1.readException();     // Catch: Throwable -> L10
                if (r1.readInt() == 0) goto L7;
                CharSequence r2 = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(r1);     // Catch: Throwable -> L10
            L8:
                r1.recycle();
                r0.recycle();
                return r2;
            L7:
                r2 = null;
            L10:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public int getRatingType() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, Stub.TRANSACTION_getRatingType, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                int r2 = r1.readInt();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r2;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public int getRepeatMode() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, Stub.TRANSACTION_getRepeatMode, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                int r2 = r1.readInt();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r2;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public int getShuffleMode() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, Stub.TRANSACTION_getShuffleMode, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                int r2 = r1.readInt();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r2;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public String getTag() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 7, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                String r2 = r1.readString();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r2;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public ParcelableVolumeInfo getVolumeAttributes() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 10, r0, r1, 0);     // Catch: Throwable -> L10
                r1.readException();     // Catch: Throwable -> L10
                if (r1.readInt() == 0) goto L7;
                ParcelableVolumeInfo r2 = ParcelableVolumeInfo.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L10
            L8:
                r1.recycle();
                r0.recycle();
                return r2;
            L7:
                r2 = null;
            L10:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean isCaptioningEnabled() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean r4 = false;
                INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, Stub.TRANSACTION_isCaptioningEnabled, r0, r1, 0);     // Catch: Throwable -> L8
                r1.readException();     // Catch: Throwable -> L8
                if (r1.readInt() == 0) goto L6;
                r4 = true;
            L6:
                r1.recycle();
                r0.recycle();
                return r4;
            L8:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean isShuffleModeEnabledRemoved() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean r4 = false;
                INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, Stub.TRANSACTION_isShuffleModeEnabledRemoved, r0, r1, 0);     // Catch: Throwable -> L8
                r1.readException();     // Catch: Throwable -> L8
                if (r1.readInt() == 0) goto L6;
                r4 = true;
            L6:
                r1.recycle();
                r0.recycle();
                return r4;
            L8:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean isTransportControlEnabled() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean r4 = false;
                INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 5, r0, r1, 0);     // Catch: Throwable -> L8
                r1.readException();     // Catch: Throwable -> L8
                if (r1.readInt() == 0) goto L6;
                r4 = true;
            L6:
                r1.recycle();
                r0.recycle();
                return r4;
            L8:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void next() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, Stub.TRANSACTION_next, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void pause() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, Stub.TRANSACTION_pause, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void play() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, Stub.TRANSACTION_play, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepare() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 33, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void previous() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, Stub.TRANSACTION_previous, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void rewind() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, Stub.TRANSACTION_rewind, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void stop() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, Stub.TRANSACTION_stop, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
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

            @Override // android.support.v4.media.session.IMediaSession
            public void addQueueItem(MediaDescriptionCompat r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L10
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L10
            L7:
                INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, Stub.TRANSACTION_addQueueItem, r0, r1, 0);     // Catch: Throwable -> L10
                r1.readException();     // Catch: Throwable -> L10
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void rate(RatingCompat r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L10
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L10
            L7:
                INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, Stub.TRANSACTION_rate, r0, r1, 0);     // Catch: Throwable -> L10
                r1.readException();     // Catch: Throwable -> L10
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void registerCallbackListener(IMediaControllerCallback r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                if (r5 == null) goto L6;
                IBinder r6 = r5.asBinder();     // Catch: Throwable -> L10
            L7:
                r0.writeStrongBinder(r6);     // Catch: Throwable -> L10
                INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r0, r1, 0);     // Catch: Throwable -> L10
                r1.readException();     // Catch: Throwable -> L10
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r6 = null;
            L10:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void removeQueueItem(MediaDescriptionCompat r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L10
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L10
            L7:
                INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, Stub.TRANSACTION_removeQueueItem, r0, r1, 0);     // Catch: Throwable -> L10
                r1.readException();     // Catch: Throwable -> L10
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void removeQueueItemAt(int r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r5);     // Catch: Throwable -> L6
                INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, Stub.TRANSACTION_removeQueueItemAt, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void seekTo(long r4) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeLong(r4);     // Catch: Throwable -> L6
                INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, Stub.TRANSACTION_seekTo, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean sendMediaButton(KeyEvent r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                boolean r2 = true;
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L13
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L13
            L7:
                INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r0, r1, 0);     // Catch: Throwable -> L13
                r1.readException();     // Catch: Throwable -> L13
                if (r1.readInt() != 0) goto L11;
                r2 = false;
            L11:
                r1.recycle();
                r0.recycle();
                return r2;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L13
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setCaptioningEnabled(boolean r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                if (r5 == false) goto L6;
                int r6 = 1;
            L7:
                r0.writeInt(r6);     // Catch: Throwable -> L10
                INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, Stub.TRANSACTION_setCaptioningEnabled, r0, r1, 0);     // Catch: Throwable -> L10
                r1.readException();     // Catch: Throwable -> L10
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r6 = 0;
            L10:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setRepeatMode(int r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r5);     // Catch: Throwable -> L6
                INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, Stub.TRANSACTION_setRepeatMode, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setShuffleMode(int r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r5);     // Catch: Throwable -> L6
                INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, Stub.TRANSACTION_setShuffleMode, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setShuffleModeEnabledRemoved(boolean r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                if (r5 == false) goto L6;
                int r6 = 1;
            L7:
                r0.writeInt(r6);     // Catch: Throwable -> L10
                INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, Stub.TRANSACTION_setShuffleModeEnabledRemoved, r0, r1, 0);     // Catch: Throwable -> L10
                r1.readException();     // Catch: Throwable -> L10
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r6 = 0;
            L10:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void skipToQueueItem(long r4) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeLong(r4);     // Catch: Throwable -> L6
                INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, Stub.TRANSACTION_skipToQueueItem, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void unregisterCallbackListener(IMediaControllerCallback r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                if (r5 == null) goto L6;
                IBinder r6 = r5.asBinder();     // Catch: Throwable -> L10
            L7:
                r0.writeStrongBinder(r6);     // Catch: Throwable -> L10
                INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r0, r1, 0);     // Catch: Throwable -> L10
                r1.readException();     // Catch: Throwable -> L10
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r6 = null;
            L10:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void addQueueItemAt(MediaDescriptionCompat r5, int r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L10
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L10
            L7:
                r0.writeInt(r6);     // Catch: Throwable -> L10
                INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, Stub.TRANSACTION_addQueueItemAt, r0, r1, 0);     // Catch: Throwable -> L10
                r1.readException();     // Catch: Throwable -> L10
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void playFromMediaId(String r4, Bundle r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                r0.writeString(r4);     // Catch: Throwable -> L10
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L10
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L10
            L7:
                INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, Stub.TRANSACTION_playFromMediaId, r0, r1, 0);     // Catch: Throwable -> L10
                r1.readException();     // Catch: Throwable -> L10
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void playFromSearch(String r4, Bundle r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                r0.writeString(r4);     // Catch: Throwable -> L10
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L10
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L10
            L7:
                INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 15, r0, r1, 0);     // Catch: Throwable -> L10
                r1.readException();     // Catch: Throwable -> L10
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void playFromUri(Uri r5, Bundle r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L13
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L13
            L7:
                if (r6 == null) goto L9;
                r0.writeInt(1);     // Catch: Throwable -> L13
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L13
            L10:
                INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 16, r0, r1, 0);     // Catch: Throwable -> L13
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L9:
                r0.writeInt(0);     // Catch: Throwable -> L13
                goto L10
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L13
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepareFromMediaId(String r4, Bundle r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                r0.writeString(r4);     // Catch: Throwable -> L10
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L10
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L10
            L7:
                INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 34, r0, r1, 0);     // Catch: Throwable -> L10
                r1.readException();     // Catch: Throwable -> L10
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepareFromSearch(String r4, Bundle r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                r0.writeString(r4);     // Catch: Throwable -> L10
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L10
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L10
            L7:
                INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, Stub.TRANSACTION_prepareFromSearch, r0, r1, 0);     // Catch: Throwable -> L10
                r1.readException();     // Catch: Throwable -> L10
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepareFromUri(Uri r5, Bundle r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L13
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L13
            L7:
                if (r6 == null) goto L9;
                r0.writeInt(1);     // Catch: Throwable -> L13
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L13
            L10:
                INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, Stub.TRANSACTION_prepareFromUri, r0, r1, 0);     // Catch: Throwable -> L13
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L9:
                r0.writeInt(0);     // Catch: Throwable -> L13
                goto L10
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L13
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void rateWithExtras(RatingCompat r5, Bundle r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L13
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L13
            L7:
                if (r6 == null) goto L9;
                r0.writeInt(1);     // Catch: Throwable -> L13
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L13
            L10:
                INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, Stub.TRANSACTION_rateWithExtras, r0, r1, 0);     // Catch: Throwable -> L13
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L9:
                r0.writeInt(0);     // Catch: Throwable -> L13
                goto L10
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L13
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void sendCustomAction(String r4, Bundle r5) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                r0.writeString(r4);     // Catch: Throwable -> L10
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L10
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L10
            L7:
                INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, Stub.TRANSACTION_sendCustomAction, r0, r1, 0);     // Catch: Throwable -> L10
                r1.readException();     // Catch: Throwable -> L10
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void adjustVolume(int r4, int r5, String r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
                r0.writeInt(r5);     // Catch: Throwable -> L6
                r0.writeString(r6);     // Catch: Throwable -> L6
                INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 11, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void sendCommand(String r4, Bundle r5, MediaSessionCompat.ResultReceiverWrapper r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeString(r4);     // Catch: Throwable -> L13
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L13
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L13
            L7:
                if (r6 == null) goto L9;
                r0.writeInt(1);     // Catch: Throwable -> L13
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L13
            L10:
                INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r0, r1, 0);     // Catch: Throwable -> L13
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L9:
                r0.writeInt(0);     // Catch: Throwable -> L13
                goto L10
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L13
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setVolumeTo(int r4, int r5, String r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
                r0.writeInt(r5);     // Catch: Throwable -> L6
                r0.writeString(r6);     // Catch: Throwable -> L6
                INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, Stub.TRANSACTION_setVolumeTo, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_android_support_v4_media_session_IMediaSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r15, int r16, Parcel r17, Parcel r18, int r19) throws RemoteException {
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

        public static IMediaSession asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IMediaSession) == false) goto L12;
            return (IMediaSession) r0;
        L12:
            return new Proxy(r2);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r5, Parcel r6, Parcel r7, int r8) throws RemoteException {
            Bundle r1 = null;
            MediaDescriptionCompat r2 = null;
            MediaDescriptionCompat r3 = null;
            MediaDescriptionCompat r4 = null;
            Bundle r9 = null;
            Bundle r10 = null;
            Bundle r11 = null;
            Bundle r12 = null;
            RatingCompat r13 = null;
            Bundle r14 = null;
            Bundle r15 = null;
            Bundle r16 = null;
            KeyEvent r17 = null;
            MediaSessionCompat.ResultReceiverWrapper r18 = null;
            if (r5 != TRANSACTION_rateWithExtras) goto L5;
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L186;
            RatingCompat r19 = RatingCompat.CREATOR.createFromParcel(r6);
        L188:
            if (r6.readInt() == 0) goto L190;
            r1 = (Bundle) Bundle.CREATOR.createFromParcel(r6);
        L190:
            rateWithExtras(r19, r1);
            r7.writeNoException();
            return true;
        L186:
            r19 = null;
            goto L188
        L5:
            if (r5 == 1598968902) goto L181;
            boolean r0 = false;
            switch(r5) {
                case 1: goto L172;
                case 2: goto L167;
                case 3: goto L165;
                case 4: goto L163;
                case 5: goto L161;
                case 6: goto L159;
                case 7: goto L157;
                case 8: goto L152;
                case 9: goto L150;
                case 10: goto L145;
                case 11: goto L143;
                case 12: goto L141;
                case 13: goto L139;
                case 14: goto L134;
                case 15: goto L129;
                case 16: goto L120;
                case 17: goto L118;
                case 18: goto L116;
                case 19: goto L114;
                case 20: goto L112;
                case 21: goto L110;
                case 22: goto L108;
                case 23: goto L106;
                case 24: goto L104;
                case 25: goto L99;
                case 26: goto L94;
                case 27: goto L89;
                case 28: goto L84;
                case 29: goto L82;
                case 30: goto L77;
                case 31: goto L72;
                case 32: goto L70;
                case 33: goto L68;
                case 34: goto L63;
                case 35: goto L58;
                case 36: goto L49;
                case 37: goto L47;
                case 38: goto L45;
                case 39: goto L43;
                case 40: goto L38;
                case 41: goto L33;
                case 42: goto L28;
                case 43: goto L23;
                case 44: goto L21;
                case 45: goto L19;
                case 46: goto L14;
                case 47: goto L12;
                case 48: goto L10;
                default: goto L9;
            };
        L10:
            r6.enforceInterface(DESCRIPTOR);
            setShuffleMode(r6.readInt());
            r7.writeNoException();
            return true;
        L12:
            r6.enforceInterface(DESCRIPTOR);
            int r20 = getShuffleMode();
            r7.writeNoException();
            r7.writeInt(r20);
            return true;
        L14:
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L17;
            r0 = true;
        L17:
            setCaptioningEnabled(r0);
            r7.writeNoException();
            return true;
        L19:
            r6.enforceInterface(DESCRIPTOR);
            boolean r21 = isCaptioningEnabled();
            r7.writeNoException();
            r7.writeInt(r21 ? 1 : 0);
            return true;
        L21:
            r6.enforceInterface(DESCRIPTOR);
            removeQueueItemAt(r6.readInt());
            r7.writeNoException();
            return true;
        L23:
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L26;
            r2 = MediaDescriptionCompat.CREATOR.createFromParcel(r6);
        L26:
            removeQueueItem(r2);
            r7.writeNoException();
            return true;
        L28:
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L31;
            r3 = MediaDescriptionCompat.CREATOR.createFromParcel(r6);
        L31:
            addQueueItemAt(r3, r6.readInt());
            r7.writeNoException();
            return true;
        L33:
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L36;
            r4 = MediaDescriptionCompat.CREATOR.createFromParcel(r6);
        L36:
            addQueueItem(r4);
            r7.writeNoException();
            return true;
        L38:
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L41;
            r0 = true;
        L41:
            setShuffleModeEnabledRemoved(r0);
            r7.writeNoException();
            return true;
        L43:
            r6.enforceInterface(DESCRIPTOR);
            setRepeatMode(r6.readInt());
            r7.writeNoException();
            return true;
        L45:
            r6.enforceInterface(DESCRIPTOR);
            boolean r22 = isShuffleModeEnabledRemoved();
            r7.writeNoException();
            r7.writeInt(r22 ? 1 : 0);
            return true;
        L47:
            r6.enforceInterface(DESCRIPTOR);
            int r23 = getRepeatMode();
            r7.writeNoException();
            r7.writeInt(r23);
            return true;
        L49:
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L52;
            Uri r24 = (Uri) Uri.CREATOR.createFromParcel(r6);
        L54:
            if (r6.readInt() == 0) goto L56;
            r9 = (Bundle) Bundle.CREATOR.createFromParcel(r6);
        L56:
            prepareFromUri(r24, r9);
            r7.writeNoException();
            return true;
        L52:
            r24 = null;
            goto L54
        L58:
            r6.enforceInterface(DESCRIPTOR);
            String r25 = r6.readString();
            if (r6.readInt() == 0) goto L61;
            r10 = (Bundle) Bundle.CREATOR.createFromParcel(r6);
        L61:
            prepareFromSearch(r25, r10);
            r7.writeNoException();
            return true;
        L63:
            r6.enforceInterface(DESCRIPTOR);
            String r26 = r6.readString();
            if (r6.readInt() == 0) goto L66;
            r11 = (Bundle) Bundle.CREATOR.createFromParcel(r6);
        L66:
            prepareFromMediaId(r26, r11);
            r7.writeNoException();
            return true;
        L68:
            r6.enforceInterface(DESCRIPTOR);
            prepare();
            r7.writeNoException();
            return true;
        L70:
            r6.enforceInterface(DESCRIPTOR);
            int r27 = getRatingType();
            r7.writeNoException();
            r7.writeInt(r27);
            return true;
        L72:
            r6.enforceInterface(DESCRIPTOR);
            Bundle r28 = getExtras();
            r7.writeNoException();
            if (r28 == null) goto L75;
            r7.writeInt(1);
            r28.writeToParcel(r7, 1);
        L76:
            return true;
        L75:
            r7.writeInt(0);
            goto L76
        L77:
            r6.enforceInterface(DESCRIPTOR);
            CharSequence r29 = getQueueTitle();
            r7.writeNoException();
            if (r29 == null) goto L80;
            r7.writeInt(1);
            TextUtils.writeToParcel(r29, r7, 1);
        L81:
            return true;
        L80:
            r7.writeInt(0);
            goto L81
        L82:
            r6.enforceInterface(DESCRIPTOR);
            List<MediaSessionCompat.QueueItem> r30 = getQueue();
            r7.writeNoException();
            r7.writeTypedList(r30);
            return true;
        L84:
            r6.enforceInterface(DESCRIPTOR);
            PlaybackStateCompat r31 = getPlaybackState();
            r7.writeNoException();
            if (r31 == null) goto L87;
            r7.writeInt(1);
            r31.writeToParcel(r7, 1);
        L88:
            return true;
        L87:
            r7.writeInt(0);
            goto L88
        L89:
            r6.enforceInterface(DESCRIPTOR);
            MediaMetadataCompat r32 = getMetadata();
            r7.writeNoException();
            if (r32 == null) goto L92;
            r7.writeInt(1);
            r32.writeToParcel(r7, 1);
        L93:
            return true;
        L92:
            r7.writeInt(0);
            goto L93
        L94:
            r6.enforceInterface(DESCRIPTOR);
            String r33 = r6.readString();
            if (r6.readInt() == 0) goto L97;
            r12 = (Bundle) Bundle.CREATOR.createFromParcel(r6);
        L97:
            sendCustomAction(r33, r12);
            r7.writeNoException();
            return true;
        L99:
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L102;
            r13 = RatingCompat.CREATOR.createFromParcel(r6);
        L102:
            rate(r13);
            r7.writeNoException();
            return true;
        L104:
            r6.enforceInterface(DESCRIPTOR);
            seekTo(r6.readLong());
            r7.writeNoException();
            return true;
        L106:
            r6.enforceInterface(DESCRIPTOR);
            rewind();
            r7.writeNoException();
            return true;
        L108:
            r6.enforceInterface(DESCRIPTOR);
            fastForward();
            r7.writeNoException();
            return true;
        L110:
            r6.enforceInterface(DESCRIPTOR);
            previous();
            r7.writeNoException();
            return true;
        L112:
            r6.enforceInterface(DESCRIPTOR);
            next();
            r7.writeNoException();
            return true;
        L114:
            r6.enforceInterface(DESCRIPTOR);
            stop();
            r7.writeNoException();
            return true;
        L116:
            r6.enforceInterface(DESCRIPTOR);
            pause();
            r7.writeNoException();
            return true;
        L118:
            r6.enforceInterface(DESCRIPTOR);
            skipToQueueItem(r6.readLong());
            r7.writeNoException();
            return true;
        L120:
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L123;
            Uri r34 = (Uri) Uri.CREATOR.createFromParcel(r6);
        L125:
            if (r6.readInt() == 0) goto L127;
            r14 = (Bundle) Bundle.CREATOR.createFromParcel(r6);
        L127:
            playFromUri(r34, r14);
            r7.writeNoException();
            return true;
        L123:
            r34 = null;
            goto L125
        L129:
            r6.enforceInterface(DESCRIPTOR);
            String r35 = r6.readString();
            if (r6.readInt() == 0) goto L132;
            r15 = (Bundle) Bundle.CREATOR.createFromParcel(r6);
        L132:
            playFromSearch(r35, r15);
            r7.writeNoException();
            return true;
        L134:
            r6.enforceInterface(DESCRIPTOR);
            String r36 = r6.readString();
            if (r6.readInt() == 0) goto L137;
            r16 = (Bundle) Bundle.CREATOR.createFromParcel(r6);
        L137:
            playFromMediaId(r36, r16);
            r7.writeNoException();
            return true;
        L139:
            r6.enforceInterface(DESCRIPTOR);
            play();
            r7.writeNoException();
            return true;
        L141:
            r6.enforceInterface(DESCRIPTOR);
            setVolumeTo(r6.readInt(), r6.readInt(), r6.readString());
            r7.writeNoException();
            return true;
        L143:
            r6.enforceInterface(DESCRIPTOR);
            adjustVolume(r6.readInt(), r6.readInt(), r6.readString());
            r7.writeNoException();
            return true;
        L145:
            r6.enforceInterface(DESCRIPTOR);
            ParcelableVolumeInfo r37 = getVolumeAttributes();
            r7.writeNoException();
            if (r37 == null) goto L148;
            r7.writeInt(1);
            r37.writeToParcel(r7, 1);
        L149:
            return true;
        L148:
            r7.writeInt(0);
            goto L149
        L150:
            r6.enforceInterface(DESCRIPTOR);
            long r38 = getFlags();
            r7.writeNoException();
            r7.writeLong(r38);
            return true;
        L152:
            r6.enforceInterface(DESCRIPTOR);
            PendingIntent r39 = getLaunchPendingIntent();
            r7.writeNoException();
            if (r39 == null) goto L155;
            r7.writeInt(1);
            r39.writeToParcel(r7, 1);
        L156:
            return true;
        L155:
            r7.writeInt(0);
            goto L156
        L157:
            r6.enforceInterface(DESCRIPTOR);
            String r40 = getTag();
            r7.writeNoException();
            r7.writeString(r40);
            return true;
        L159:
            r6.enforceInterface(DESCRIPTOR);
            String r41 = getPackageName();
            r7.writeNoException();
            r7.writeString(r41);
            return true;
        L161:
            r6.enforceInterface(DESCRIPTOR);
            boolean r42 = isTransportControlEnabled();
            r7.writeNoException();
            r7.writeInt(r42 ? 1 : 0);
            return true;
        L163:
            r6.enforceInterface(DESCRIPTOR);
            unregisterCallbackListener(IMediaControllerCallback.Stub.asInterface(r6.readStrongBinder()));
            r7.writeNoException();
            return true;
        L165:
            r6.enforceInterface(DESCRIPTOR);
            registerCallbackListener(IMediaControllerCallback.Stub.asInterface(r6.readStrongBinder()));
            r7.writeNoException();
            return true;
        L167:
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L170;
            r17 = (KeyEvent) KeyEvent.CREATOR.createFromParcel(r6);
        L170:
            boolean r43 = sendMediaButton(r17);
            r7.writeNoException();
            r7.writeInt(r43 ? 1 : 0);
            return true;
        L172:
            r6.enforceInterface(DESCRIPTOR);
            String r44 = r6.readString();
            if (r6.readInt() == 0) goto L175;
            Bundle r45 = (Bundle) Bundle.CREATOR.createFromParcel(r6);
        L177:
            if (r6.readInt() == 0) goto L179;
            r18 = MediaSessionCompat.ResultReceiverWrapper.CREATOR.createFromParcel(r6);
        L179:
            sendCommand(r44, r45, r18);
            r7.writeNoException();
            return true;
        L175:
            r45 = null;
            goto L177
        L9:
            return super.onTransact(r5, r6, r7, r8);
        L181:
            r7.writeString(DESCRIPTOR);
            return true;
        }
    }

    void addQueueItem(MediaDescriptionCompat r1) throws RemoteException;

    void addQueueItemAt(MediaDescriptionCompat r1, int r2) throws RemoteException;

    void adjustVolume(int r1, int r2, String r3) throws RemoteException;

    void fastForward() throws RemoteException;

    Bundle getExtras() throws RemoteException;

    long getFlags() throws RemoteException;

    PendingIntent getLaunchPendingIntent() throws RemoteException;

    MediaMetadataCompat getMetadata() throws RemoteException;

    String getPackageName() throws RemoteException;

    PlaybackStateCompat getPlaybackState() throws RemoteException;

    List<MediaSessionCompat.QueueItem> getQueue() throws RemoteException;

    CharSequence getQueueTitle() throws RemoteException;

    int getRatingType() throws RemoteException;

    int getRepeatMode() throws RemoteException;

    int getShuffleMode() throws RemoteException;

    String getTag() throws RemoteException;

    ParcelableVolumeInfo getVolumeAttributes() throws RemoteException;

    boolean isCaptioningEnabled() throws RemoteException;

    boolean isShuffleModeEnabledRemoved() throws RemoteException;

    boolean isTransportControlEnabled() throws RemoteException;

    void next() throws RemoteException;

    void pause() throws RemoteException;

    void play() throws RemoteException;

    void playFromMediaId(String r1, Bundle r2) throws RemoteException;

    void playFromSearch(String r1, Bundle r2) throws RemoteException;

    void playFromUri(Uri r1, Bundle r2) throws RemoteException;

    void prepare() throws RemoteException;

    void prepareFromMediaId(String r1, Bundle r2) throws RemoteException;

    void prepareFromSearch(String r1, Bundle r2) throws RemoteException;

    void prepareFromUri(Uri r1, Bundle r2) throws RemoteException;

    void previous() throws RemoteException;

    void rate(RatingCompat r1) throws RemoteException;

    void rateWithExtras(RatingCompat r1, Bundle r2) throws RemoteException;

    void registerCallbackListener(IMediaControllerCallback r1) throws RemoteException;

    void removeQueueItem(MediaDescriptionCompat r1) throws RemoteException;

    void removeQueueItemAt(int r1) throws RemoteException;

    void rewind() throws RemoteException;

    void seekTo(long r1) throws RemoteException;

    void sendCommand(String r1, Bundle r2, MediaSessionCompat.ResultReceiverWrapper r3) throws RemoteException;

    void sendCustomAction(String r1, Bundle r2) throws RemoteException;

    boolean sendMediaButton(KeyEvent r1) throws RemoteException;

    void setCaptioningEnabled(boolean r1) throws RemoteException;

    void setRepeatMode(int r1) throws RemoteException;

    void setShuffleMode(int r1) throws RemoteException;

    void setShuffleModeEnabledRemoved(boolean r1) throws RemoteException;

    void setVolumeTo(int r1, int r2, String r3) throws RemoteException;

    void skipToQueueItem(long r1) throws RemoteException;

    void stop() throws RemoteException;

    void unregisterCallbackListener(IMediaControllerCallback r1) throws RemoteException;
}
