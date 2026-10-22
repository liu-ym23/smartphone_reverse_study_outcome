package android.support.v4.media.session;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.media.RemoteControlClient;
import android.media.session.MediaSession;
import android.net.Uri;
import android.os.BadParcelableException;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import androidx.compose.material3.MenuKt;
import androidx.core.app.BundleCompat;
import androidx.media.MediaSessionManager;
import androidx.media.VolumeProviderCompat;
import androidx.media.session.MediaButtonReceiver;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class MediaSessionCompat {
    public static final String ACTION_ARGUMENT_CAPTIONING_ENABLED = "android.support.v4.media.session.action.ARGUMENT_CAPTIONING_ENABLED";
    public static final String ACTION_ARGUMENT_EXTRAS = "android.support.v4.media.session.action.ARGUMENT_EXTRAS";
    public static final String ACTION_ARGUMENT_MEDIA_ID = "android.support.v4.media.session.action.ARGUMENT_MEDIA_ID";
    public static final String ACTION_ARGUMENT_QUERY = "android.support.v4.media.session.action.ARGUMENT_QUERY";
    public static final String ACTION_ARGUMENT_RATING = "android.support.v4.media.session.action.ARGUMENT_RATING";
    public static final String ACTION_ARGUMENT_REPEAT_MODE = "android.support.v4.media.session.action.ARGUMENT_REPEAT_MODE";
    public static final String ACTION_ARGUMENT_SHUFFLE_MODE = "android.support.v4.media.session.action.ARGUMENT_SHUFFLE_MODE";
    public static final String ACTION_ARGUMENT_URI = "android.support.v4.media.session.action.ARGUMENT_URI";
    public static final String ACTION_FLAG_AS_INAPPROPRIATE = "android.support.v4.media.session.action.FLAG_AS_INAPPROPRIATE";
    public static final String ACTION_FOLLOW = "android.support.v4.media.session.action.FOLLOW";
    public static final String ACTION_PLAY_FROM_URI = "android.support.v4.media.session.action.PLAY_FROM_URI";
    public static final String ACTION_PREPARE = "android.support.v4.media.session.action.PREPARE";
    public static final String ACTION_PREPARE_FROM_MEDIA_ID = "android.support.v4.media.session.action.PREPARE_FROM_MEDIA_ID";
    public static final String ACTION_PREPARE_FROM_SEARCH = "android.support.v4.media.session.action.PREPARE_FROM_SEARCH";
    public static final String ACTION_PREPARE_FROM_URI = "android.support.v4.media.session.action.PREPARE_FROM_URI";
    public static final String ACTION_SET_CAPTIONING_ENABLED = "android.support.v4.media.session.action.SET_CAPTIONING_ENABLED";
    public static final String ACTION_SET_RATING = "android.support.v4.media.session.action.SET_RATING";
    public static final String ACTION_SET_REPEAT_MODE = "android.support.v4.media.session.action.SET_REPEAT_MODE";
    public static final String ACTION_SET_SHUFFLE_MODE = "android.support.v4.media.session.action.SET_SHUFFLE_MODE";
    public static final String ACTION_SKIP_AD = "android.support.v4.media.session.action.SKIP_AD";
    public static final String ACTION_UNFOLLOW = "android.support.v4.media.session.action.UNFOLLOW";
    public static final String ARGUMENT_MEDIA_ATTRIBUTE = "android.support.v4.media.session.ARGUMENT_MEDIA_ATTRIBUTE";
    public static final String ARGUMENT_MEDIA_ATTRIBUTE_VALUE = "android.support.v4.media.session.ARGUMENT_MEDIA_ATTRIBUTE_VALUE";
    private static final String DATA_CALLING_PACKAGE = "data_calling_pkg";
    private static final String DATA_CALLING_PID = "data_calling_pid";
    private static final String DATA_CALLING_UID = "data_calling_uid";
    private static final String DATA_EXTRAS = "data_extras";
    public static final int FLAG_HANDLES_MEDIA_BUTTONS = 1;
    public static final int FLAG_HANDLES_QUEUE_COMMANDS = 4;
    public static final int FLAG_HANDLES_TRANSPORT_CONTROLS = 2;
    public static final String KEY_EXTRA_BINDER = "android.support.v4.media.session.EXTRA_BINDER";
    public static final String KEY_SESSION_TOKEN2_BUNDLE = "android.support.v4.media.session.SESSION_TOKEN2_BUNDLE";
    public static final String KEY_TOKEN = "android.support.v4.media.session.TOKEN";
    private static final int MAX_BITMAP_SIZE_IN_DP = 320;
    public static final int MEDIA_ATTRIBUTE_ALBUM = 1;
    public static final int MEDIA_ATTRIBUTE_ARTIST = 0;
    public static final int MEDIA_ATTRIBUTE_PLAYLIST = 2;
    static final String TAG = "MediaSessionCompat";
    static int sMaxBitmapSize;
    private final ArrayList<OnActiveChangeListener> mActiveListeners;
    private final MediaControllerCompat mController;
    private final MediaSessionImpl mImpl;

    public static abstract class Callback {
        private CallbackHandler mCallbackHandler;
        final Object mCallbackObj;
        private boolean mMediaPlayPauseKeyPending;
        WeakReference<MediaSessionImpl> mSessionImpl;

        public class CallbackHandler extends Handler {
            private static final int MSG_MEDIA_PLAY_PAUSE_KEY_DOUBLE_TAP_TIMEOUT = 1;
            final /* synthetic */ Callback this$0;

            @Override // android.os.Handler
            public void handleMessage(Message r3) {
                if (r3.what != 1) goto L6;
                this.this$0.handleMediaPlayPauseKeySingleTapIfPending((MediaSessionManager.RemoteUserInfo) r3.obj);
                return;
            }

            public CallbackHandler(Callback r1, Looper r2) {
                this.this$0 = r1;
                super(r2);
            }
        }

        public class StubApi21 implements MediaSessionCompatApi21.Callback {
            final /* synthetic */ Callback this$0;

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onSetRating(Object r1, Bundle r2) {
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onFastForward() {
                this.this$0.onFastForward();
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onPause() {
                this.this$0.onPause();
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onPlay() {
                this.this$0.onPlay();
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onRewind() {
                this.this$0.onRewind();
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onSkipToNext() {
                this.this$0.onSkipToNext();
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onSkipToPrevious() {
                this.this$0.onSkipToPrevious();
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onStop() {
                this.this$0.onStop();
            }

            public StubApi21(Callback r1) {
                this.this$0 = r1;
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public boolean onMediaButtonEvent(Intent r2) {
                return this.this$0.onMediaButtonEvent(r2);
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onSeekTo(long r2) {
                this.this$0.onSeekTo(r2);
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onSetRating(Object r2) {
                this.this$0.onSetRating(RatingCompat.fromRating(r2));
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onSkipToQueueItem(long r2) {
                this.this$0.onSkipToQueueItem(r2);
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onCustomAction(String r4, Bundle r5) {
                Bundle r0 = r5.getBundle(MediaSessionCompat.ACTION_ARGUMENT_EXTRAS);
                MediaSessionCompat.ensureClassLoader(r0);
                if (r4.equals(MediaSessionCompat.ACTION_PLAY_FROM_URI) == false) goto L6;
                Uri r6 = (Uri) r5.getParcelable(MediaSessionCompat.ACTION_ARGUMENT_URI);
                this.this$0.onPlayFromUri(r6, r0);
                return;
            L6:
                if (r4.equals(MediaSessionCompat.ACTION_PREPARE) == false) goto L9;
                this.this$0.onPrepare();
                return;
            L9:
                if (r4.equals(MediaSessionCompat.ACTION_PREPARE_FROM_MEDIA_ID) == false) goto L12;
                String r7 = r5.getString(MediaSessionCompat.ACTION_ARGUMENT_MEDIA_ID);
                this.this$0.onPrepareFromMediaId(r7, r0);
                return;
            L12:
                if (r4.equals(MediaSessionCompat.ACTION_PREPARE_FROM_SEARCH) == false) goto L15;
                String r8 = r5.getString(MediaSessionCompat.ACTION_ARGUMENT_QUERY);
                this.this$0.onPrepareFromSearch(r8, r0);
                return;
            L15:
                if (r4.equals(MediaSessionCompat.ACTION_PREPARE_FROM_URI) == false) goto L18;
                Uri r9 = (Uri) r5.getParcelable(MediaSessionCompat.ACTION_ARGUMENT_URI);
                this.this$0.onPrepareFromUri(r9, r0);
                return;
            L18:
                if (r4.equals(MediaSessionCompat.ACTION_SET_CAPTIONING_ENABLED) == false) goto L21;
                boolean r10 = r5.getBoolean(MediaSessionCompat.ACTION_ARGUMENT_CAPTIONING_ENABLED);
                this.this$0.onSetCaptioningEnabled(r10);
                return;
            L21:
                if (r4.equals(MediaSessionCompat.ACTION_SET_REPEAT_MODE) == false) goto L24;
                int r11 = r5.getInt(MediaSessionCompat.ACTION_ARGUMENT_REPEAT_MODE);
                this.this$0.onSetRepeatMode(r11);
                return;
            L24:
                if (r4.equals(MediaSessionCompat.ACTION_SET_SHUFFLE_MODE) == false) goto L27;
                int r12 = r5.getInt(MediaSessionCompat.ACTION_ARGUMENT_SHUFFLE_MODE);
                this.this$0.onSetShuffleMode(r12);
                return;
            L27:
                if (r4.equals(MediaSessionCompat.ACTION_SET_RATING) == false) goto L29;
                RatingCompat r13 = (RatingCompat) r5.getParcelable(MediaSessionCompat.ACTION_ARGUMENT_RATING);
                this.this$0.onSetRating(r13, r0);
                return;
            L29:
                this.this$0.onCustomAction(r4, r5);
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onPlayFromMediaId(String r2, Bundle r3) {
                this.this$0.onPlayFromMediaId(r2, r3);
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onPlayFromSearch(String r2, Bundle r3) {
                this.this$0.onPlayFromSearch(r2, r3);
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onCommand(String r5, Bundle r6, ResultReceiver r7) {
                QueueItem r1 = null;
                IBinder r2 = null;
                r1 = null;
                if (r5.equals(MediaControllerCompat.COMMAND_GET_EXTRA_BINDER) == false) goto L13;
                MediaSessionImplApi21 r8 = (MediaSessionImplApi21) this.this$0.mSessionImpl.get();     // Catch: BadParcelableException -> L37
                if (r8 == null) goto L39;
                Bundle r9 = new Bundle();     // Catch: BadParcelableException -> L37
                Token r10 = r8.getSessionToken();     // Catch: BadParcelableException -> L37
                IMediaSession r0 = r10.getExtraBinder();     // Catch: BadParcelableException -> L37
                if (r0 == null) goto L10;
                r2 = r0.asBinder();     // Catch: BadParcelableException -> L37
            L10:
                BundleCompat.putBinder(r9, MediaSessionCompat.KEY_EXTRA_BINDER, r2);     // Catch: BadParcelableException -> L37
                r9.putBundle(MediaSessionCompat.KEY_SESSION_TOKEN2_BUNDLE, r10.getSessionToken2Bundle());     // Catch: BadParcelableException -> L37
                r7.send(0, r9);     // Catch: BadParcelableException -> L37
                return;
            L39:
                return;
            L13:
                if (r5.equals(MediaControllerCompat.COMMAND_ADD_QUEUE_ITEM) == false) goto L17;
                this.this$0.onAddQueueItem((MediaDescriptionCompat) r6.getParcelable(MediaControllerCompat.COMMAND_ARGUMENT_MEDIA_DESCRIPTION));     // Catch: BadParcelableException -> L37
                return;
            L17:
                if (r5.equals(MediaControllerCompat.COMMAND_ADD_QUEUE_ITEM_AT) == false) goto L20;
                this.this$0.onAddQueueItem((MediaDescriptionCompat) r6.getParcelable(MediaControllerCompat.COMMAND_ARGUMENT_MEDIA_DESCRIPTION), r6.getInt(MediaControllerCompat.COMMAND_ARGUMENT_INDEX));     // Catch: BadParcelableException -> L37
                return;
            L20:
                if (r5.equals(MediaControllerCompat.COMMAND_REMOVE_QUEUE_ITEM) == false) goto L23;
                this.this$0.onRemoveQueueItem((MediaDescriptionCompat) r6.getParcelable(MediaControllerCompat.COMMAND_ARGUMENT_MEDIA_DESCRIPTION));     // Catch: BadParcelableException -> L37
                return;
            L23:
                if (r5.equals(MediaControllerCompat.COMMAND_REMOVE_QUEUE_ITEM_AT) == false) goto L35;
                MediaSessionImplApi21 r11 = (MediaSessionImplApi21) this.this$0.mSessionImpl.get();     // Catch: BadParcelableException -> L37
                if (r11 != null) goto L27;
                return;
            L27:
                if (r11.mQueue == null) goto L45;
                int r12 = r6.getInt(MediaControllerCompat.COMMAND_ARGUMENT_INDEX, -1);     // Catch: BadParcelableException -> L37
                if (r12 >= 0) goto L31;
            L33:
                if (r1 == null) goto L46;
                this.this$0.onRemoveQueueItem(r1.getDescription());     // Catch: BadParcelableException -> L37
                return;
            L46:
                return;
            L31:
                if (r12 >= r11.mQueue.size()) goto L33;
                r1 = (QueueItem) ListProtector.get(r11.mQueue, r12);     // Catch: BadParcelableException -> L37
                goto L33
            L45:
                return;
            L35:
                this.this$0.onCommand(r5, r6, r7);     // Catch: BadParcelableException -> L37
                return;
            }
        }

        public class StubApi23 extends StubApi21 implements MediaSessionCompatApi23.Callback {
            final /* synthetic */ Callback this$0;

            public StubApi23(Callback r1) {
                this.this$0 = r1;
                super(r1);
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi23.Callback
            public void onPlayFromUri(Uri r2, Bundle r3) {
                this.this$0.onPlayFromUri(r2, r3);
            }
        }

        public class StubApi24 extends StubApi23 implements MediaSessionCompatApi24.Callback {
            final /* synthetic */ Callback this$0;

            @Override // android.support.v4.media.session.MediaSessionCompatApi24.Callback
            public void onPrepare() {
                this.this$0.onPrepare();
            }

            public StubApi24(Callback r1) {
                this.this$0 = r1;
                super(r1);
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi24.Callback
            public void onPrepareFromMediaId(String r2, Bundle r3) {
                this.this$0.onPrepareFromMediaId(r2, r3);
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi24.Callback
            public void onPrepareFromSearch(String r2, Bundle r3) {
                this.this$0.onPrepareFromSearch(r2, r3);
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi24.Callback
            public void onPrepareFromUri(Uri r2, Bundle r3) {
                this.this$0.onPrepareFromUri(r2, r3);
            }
        }

        public void onAddQueueItem(MediaDescriptionCompat r1) {
        }

        public void onAddQueueItem(MediaDescriptionCompat r1, int r2) {
        }

        public void onCommand(String r1, Bundle r2, ResultReceiver r3) {
        }

        public void onCustomAction(String r1, Bundle r2) {
        }

        public void onFastForward() {
        }

        public void onPause() {
        }

        public void onPlay() {
        }

        public void onPlayFromMediaId(String r1, Bundle r2) {
        }

        public void onPlayFromSearch(String r1, Bundle r2) {
        }

        public void onPlayFromUri(Uri r1, Bundle r2) {
        }

        public void onPrepare() {
        }

        public void onPrepareFromMediaId(String r1, Bundle r2) {
        }

        public void onPrepareFromSearch(String r1, Bundle r2) {
        }

        public void onPrepareFromUri(Uri r1, Bundle r2) {
        }

        public void onRemoveQueueItem(MediaDescriptionCompat r1) {
        }

        public void onRemoveQueueItemAt(int r1) {
        }

        public void onRewind() {
        }

        public void onSeekTo(long r1) {
        }

        public void onSetCaptioningEnabled(boolean r1) {
        }

        public void onSetRating(RatingCompat r1) {
        }

        public void onSetRating(RatingCompat r1, Bundle r2) {
        }

        public void onSetRepeatMode(int r1) {
        }

        public void onSetShuffleMode(int r1) {
        }

        public void onSkipToNext() {
        }

        public void onSkipToPrevious() {
        }

        public void onSkipToQueueItem(long r1) {
        }

        public void onStop() {
        }

        public Callback() {
            this.mCallbackHandler = null;
            int r0 = Build.VERSION.SDK_INT;
            if (r0 < 24) goto L6;
            this.mCallbackObj = MediaSessionCompatApi24.createCallback(new StubApi24(this));
            return;
        L6:
            if (r0 < 23) goto L8;
            this.mCallbackObj = MediaSessionCompatApi23.createCallback(new StubApi23(this));
            return;
        L8:
            this.mCallbackObj = MediaSessionCompatApi21.createCallback(new StubApi21(this));
        }

        public void handleMediaPlayPauseKeySingleTapIfPending(MediaSessionManager.RemoteUserInfo r12) {
            if (this.mMediaPlayPauseKeyPending == true) goto L5;
            return;
        L5:
            boolean r0 = false;
            this.mMediaPlayPauseKeyPending = false;
            this.mCallbackHandler.removeMessages(1);
            MediaSessionImpl r1 = this.mSessionImpl.get();
            if (r1 != null) goto L8;
            return;
        L8:
            PlaybackStateCompat r3 = r1.getPlaybackState();
            if (r3 != null) goto L11;
            long r6 = 0;
        L12:
            if (r3 != null) goto L14;
        L16:
            boolean r4 = false;
        L18:
            if ((516 & r6) == 0) goto L20;
            boolean r8 = true;
        L22:
            if ((r6 & 514) == 0) goto L24;
            r0 = true;
        L24:
            r1.setCurrentControllerInfo(r12);
            if (r4 == false) goto L28;
            if (r0 == false) goto L28;
            onPause();
        L31:
            r1.setCurrentControllerInfo(null);
            return;
        L28:
            if (r4 == true) goto L31;
            if (r8 == false) goto L31;
            onPlay();
            goto L31
        L20:
            r8 = false;
            goto L22
        L14:
            if (r3.getState() != 3) goto L16;
            r4 = true;
            goto L18
        L11:
            r6 = r3.getActions();
            goto L12
        }

        public boolean onMediaButtonEvent(Intent r9) {
            if (Build.VERSION.SDK_INT < 27) goto L5;
            return false;
        L5:
            MediaSessionImpl r0 = this.mSessionImpl.get();
            if (r0 != null) goto L8;
        L35:
            return false;
        L8:
            if (this.mCallbackHandler == null) goto L35;
            KeyEvent r10 = (KeyEvent) r9.getParcelableExtra("android.intent.extra.KEY_EVENT");
            if (r10 == null) goto L35;
            if (r10.getAction() != 0) goto L35;
            MediaSessionManager.RemoteUserInfo r1 = r0.getCurrentControllerInfo();
            int r3 = r10.getKeyCode();
            if (r3 == 79) goto L22;
            if (r3 == 85) goto L22;
            handleMediaPlayPauseKeySingleTapIfPending(r1);
            return false;
        L22:
            if (r10.getRepeatCount() <= 0) goto L25;
            handleMediaPlayPauseKeySingleTapIfPending(r1);
        L34:
            return true;
        L25:
            if (this.mMediaPlayPauseKeyPending == false) goto L33;
            this.mCallbackHandler.removeMessages(1);
            this.mMediaPlayPauseKeyPending = false;
            PlaybackStateCompat r11 = r0.getPlaybackState();
            if (r11 != null) goto L29;
            long r4 = 0;
        L31:
            if ((r4 & 32) == 0) goto L34;
            onSkipToNext();
            goto L34
        L29:
            r4 = r11.getActions();
            goto L31
        L33:
            this.mMediaPlayPauseKeyPending = true;
            CallbackHandler r12 = this.mCallbackHandler;
            r12.sendMessageDelayed(r12.obtainMessage(1, r1), ViewConfiguration.getDoubleTapTimeout());
            goto L34
        }

        public void setSessionImpl(MediaSessionImpl r2, Handler r3) {
            this.mSessionImpl = new WeakReference(r2);
            CallbackHandler r4 = this.mCallbackHandler;
            if (r4 == null) goto L5;
            r4.removeCallbacksAndMessages(null);
        L5:
            this.mCallbackHandler = new CallbackHandler(this, r3.getLooper());
        }
    }

    public interface MediaSessionImpl {
        String getCallingPackage();

        MediaSessionManager.RemoteUserInfo getCurrentControllerInfo();

        Object getMediaSession();

        PlaybackStateCompat getPlaybackState();

        Object getRemoteControlClient();

        Token getSessionToken();

        boolean isActive();

        void release();

        void sendSessionEvent(String r1, Bundle r2);

        void setActive(boolean r1);

        void setCallback(Callback r1, Handler r2);

        void setCaptioningEnabled(boolean r1);

        void setCurrentControllerInfo(MediaSessionManager.RemoteUserInfo r1);

        void setExtras(Bundle r1);

        void setFlags(int r1);

        void setMediaButtonReceiver(PendingIntent r1);

        void setMetadata(MediaMetadataCompat r1);

        void setPlaybackState(PlaybackStateCompat r1);

        void setPlaybackToLocal(int r1);

        void setPlaybackToRemote(VolumeProviderCompat r1);

        void setQueue(List<QueueItem> r1);

        void setQueueTitle(CharSequence r1);

        void setRatingType(int r1);

        void setRepeatMode(int r1);

        void setSessionActivity(PendingIntent r1);

        void setShuffleMode(int r1);
    }

    public static class MediaSessionImplApi18 extends MediaSessionImplBase {
        private static boolean sIsMbrPendingIntentSupported = true;

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase
        public int getRccTransportControlFlagsFromActions(long r5) {
            int r0 = super.getRccTransportControlFlagsFromActions(r5);
            if ((r5 & 256) != 0) goto L5;
            return r0;
        L5:
            return r0 | 256;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase
        public void setRccState(PlaybackStateCompat r11) {
            long r0 = r11.getPosition();
            float r2 = r11.getPlaybackSpeed();
            long r3 = r11.getLastPositionUpdateTime();
            long r5 = SystemClock.elapsedRealtime();
            if (r11.getState() != 3) goto L14;
            long r7 = 0;
            if (r0 <= 0) goto L14;
            if (r3 <= 0) goto L13;
            r7 = r5 - r3;
            if (r2 <= MenuKt.ClosedAlphaTarget) goto L13;
            if (r2 == 1.0f) goto L13;
            r7 = (long) (r7 * r2);
        L13:
            r0 = r0 + r7;
        L14:
            this.mRcc.setPlaybackState(getRccStateFromState(r11.getState()), r0, r2);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase
        public void registerMediaButtonEventReceiver(PendingIntent r2, ComponentName r3) {
            if (sIsMbrPendingIntentSupported == false) goto L8;
            this.mAudioManager.registerMediaButtonEventReceiver(r2);     // Catch: NullPointerException -> L6
        L6:
            sIsMbrPendingIntentSupported = false;
        L8:
            if (sIsMbrPendingIntentSupported == true) goto L13;
            super.registerMediaButtonEventReceiver(r2, r3);
            return;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase, android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setCallback(Callback r1, Handler r2) {
            super.setCallback(r1, r2);
            if (r1 != null) goto L5;
            this.mRcc.setPlaybackPositionUpdateListener(null);
            return;
        L5:
            RemoteControlClient.OnPlaybackPositionUpdateListener r3 = new AnonymousClass1(this);
            this.mRcc.setPlaybackPositionUpdateListener(r3);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase
        public void unregisterMediaButtonEventReceiver(PendingIntent r2, ComponentName r3) {
            if (sIsMbrPendingIntentSupported == false) goto L5;
            this.mAudioManager.unregisterMediaButtonEventReceiver(r2);
            return;
        L5:
            super.unregisterMediaButtonEventReceiver(r2, r3);
        }

        public MediaSessionImplApi18(Context r1, String r2, ComponentName r3, PendingIntent r4) {
            super(r1, r2, r3, r4);
        }
    }

    public static class MediaSessionImplApi19 extends MediaSessionImplApi18 {
        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase
        public RemoteControlClient.MetadataEditor buildRccMetadata(Bundle r9) {
            RemoteControlClient.MetadataEditor r0 = super.buildRccMetadata(r9);
            PlaybackStateCompat r1 = this.mState;
            if (r1 != null) goto L5;
            long r4 = 0;
        L7:
            if ((r4 & 128) == 0) goto L9;
            r0.addEditableKey(268435457);
        L9:
            if (r9 != null) goto L12;
            return r0;
        L12:
            if (r9.containsKey(MediaMetadataCompat.METADATA_KEY_YEAR) == false) goto L15;
            r0.putLong(8, r9.getLong(MediaMetadataCompat.METADATA_KEY_YEAR));
        L15:
            if (r9.containsKey(MediaMetadataCompat.METADATA_KEY_RATING) == false) goto L18;
            r0.putObject(101, r9.getParcelable(MediaMetadataCompat.METADATA_KEY_RATING));
        L18:
            if (r9.containsKey(MediaMetadataCompat.METADATA_KEY_USER_RATING) == false) goto L20;
            r0.putObject(268435457, r9.getParcelable(MediaMetadataCompat.METADATA_KEY_USER_RATING));
        L20:
            return r0;
        L5:
            r4 = r1.getActions();
            goto L7
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi18, android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase
        public int getRccTransportControlFlagsFromActions(long r5) {
            int r0 = super.getRccTransportControlFlagsFromActions(r5);
            if ((r5 & 128) != 0) goto L5;
            return r0;
        L5:
            return r0 | 512;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi18, android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase, android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setCallback(Callback r1, Handler r2) {
            super.setCallback(r1, r2);
            if (r1 != null) goto L5;
            this.mRcc.setMetadataUpdateListener(null);
            return;
        L5:
            RemoteControlClient.OnMetadataUpdateListener r3 = new AnonymousClass1(this);
            this.mRcc.setMetadataUpdateListener(r3);
        }

        public MediaSessionImplApi19(Context r1, String r2, ComponentName r3, PendingIntent r4) {
            super(r1, r2, r3, r4);
        }
    }

    public static class MediaSessionImplApi21 implements MediaSessionImpl {
        boolean mCaptioningEnabled;
        boolean mDestroyed;
        final RemoteCallbackList<IMediaControllerCallback> mExtraControllerCallbacks;
        MediaMetadataCompat mMetadata;
        PlaybackStateCompat mPlaybackState;
        List<QueueItem> mQueue;
        int mRatingType;
        int mRepeatMode;
        final Object mSessionObj;
        int mShuffleMode;
        final Token mToken;

        public class ExtraSession extends IMediaSession.Stub {
            final /* synthetic */ MediaSessionImplApi21 this$0;

            @Override // android.support.v4.media.session.IMediaSession
            public List<QueueItem> getQueue() {
                return null;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean isShuffleModeEnabledRemoved() {
                return false;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setShuffleModeEnabledRemoved(boolean r1) throws RemoteException {
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void fastForward() throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public Bundle getExtras() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public long getFlags() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public PendingIntent getLaunchPendingIntent() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public MediaMetadataCompat getMetadata() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public String getPackageName() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public PlaybackStateCompat getPlaybackState() {
                MediaSessionImplApi21 r0 = this.this$0;
                return MediaSessionCompat.getStateWithUpdatedPosition(r0.mPlaybackState, r0.mMetadata);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public CharSequence getQueueTitle() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public int getRatingType() {
                return this.this$0.mRatingType;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public int getRepeatMode() {
                return this.this$0.mRepeatMode;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public int getShuffleMode() {
                return this.this$0.mShuffleMode;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public String getTag() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public ParcelableVolumeInfo getVolumeAttributes() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean isCaptioningEnabled() {
                return this.this$0.mCaptioningEnabled;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean isTransportControlEnabled() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void next() throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void pause() throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void play() throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepare() throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void previous() throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void rewind() throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void stop() throws RemoteException {
                throw new AssertionError();
            }

            public ExtraSession(MediaSessionImplApi21 r1) {
                this.this$0 = r1;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void addQueueItem(MediaDescriptionCompat r1) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void rate(RatingCompat r1) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void registerCallbackListener(IMediaControllerCallback r5) {
                MediaSessionImplApi21 r0 = this.this$0;
                if (r0.mDestroyed == true) goto L9;
                String r1 = r0.getCallingPackage();
                if (r1 != null) goto L7;
                r1 = "android.media.session.MediaController";
            L7:
                MediaSessionManager.RemoteUserInfo r2 = new MediaSessionManager.RemoteUserInfo(r1, Binder.getCallingPid(), Binder.getCallingUid());
                this.this$0.mExtraControllerCallbacks.register(r5, r2);
                return;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void removeQueueItem(MediaDescriptionCompat r1) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void removeQueueItemAt(int r1) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void seekTo(long r1) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean sendMediaButton(KeyEvent r1) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setCaptioningEnabled(boolean r1) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setRepeatMode(int r1) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setShuffleMode(int r1) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void skipToQueueItem(long r1) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void unregisterCallbackListener(IMediaControllerCallback r2) {
                this.this$0.mExtraControllerCallbacks.unregister(r2);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void addQueueItemAt(MediaDescriptionCompat r1, int r2) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void playFromMediaId(String r1, Bundle r2) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void playFromSearch(String r1, Bundle r2) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void playFromUri(Uri r1, Bundle r2) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepareFromMediaId(String r1, Bundle r2) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepareFromSearch(String r1, Bundle r2) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepareFromUri(Uri r1, Bundle r2) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void rateWithExtras(RatingCompat r1, Bundle r2) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void sendCustomAction(String r1, Bundle r2) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void adjustVolume(int r1, int r2, String r3) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void sendCommand(String r1, Bundle r2, ResultReceiverWrapper r3) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setVolumeTo(int r1, int r2, String r3) {
                throw new AssertionError();
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public MediaSessionManager.RemoteUserInfo getCurrentControllerInfo() {
            return null;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public Object getRemoteControlClient() {
            return null;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void release() {
            this.mDestroyed = true;
            MediaSessionCompatApi21.release(this.mSessionObj);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setCurrentControllerInfo(MediaSessionManager.RemoteUserInfo r1) {
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public String getCallingPackage() {
            if (Build.VERSION.SDK_INT >= 24) goto L7;
            return null;
        L7:
            return MediaSessionCompatApi24.getCallingPackage(this.mSessionObj);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public boolean isActive() {
            return MediaSessionCompatApi21.isActive(this.mSessionObj);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public Object getMediaSession() {
            return this.mSessionObj;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public PlaybackStateCompat getPlaybackState() {
            return this.mPlaybackState;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public Token getSessionToken() {
            return this.mToken;
        }

        public MediaSessionImplApi21(Object r3) {
            this.mDestroyed = false;
            this.mExtraControllerCallbacks = new RemoteCallbackList();
            Object r4 = MediaSessionCompatApi21.verifySession(r3);
            this.mSessionObj = r4;
            this.mToken = new Token(MediaSessionCompatApi21.getSessionToken(r4), new ExtraSession(this));
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setActive(boolean r2) {
            MediaSessionCompatApi21.setActive(this.mSessionObj, r2);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setCaptioningEnabled(boolean r3) {
            if (this.mCaptioningEnabled == r3) goto L16;
            this.mCaptioningEnabled = r3;
            int r0 = this.mExtraControllerCallbacks.beginBroadcast() - 1;
        L5:
            if (r0 < 0) goto L9;
            ((IMediaControllerCallback) this.mExtraControllerCallbacks.getBroadcastItem(r0)).onCaptioningEnabledChanged(r3);     // Catch: RemoteException -> L11
        L8:
            r0 = r0 - 1;
            goto L5
        L9:
            this.mExtraControllerCallbacks.finishBroadcast();
            return;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setExtras(Bundle r2) {
            MediaSessionCompatApi21.setExtras(this.mSessionObj, r2);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setFlags(int r2) {
            MediaSessionCompatApi21.setFlags(this.mSessionObj, r2);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setMediaButtonReceiver(PendingIntent r2) {
            MediaSessionCompatApi21.setMediaButtonReceiver(this.mSessionObj, r2);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setMetadata(MediaMetadataCompat r2) {
            this.mMetadata = r2;
            Object r0 = this.mSessionObj;
            if (r2 != null) goto L5;
            Object r3 = null;
        L6:
            MediaSessionCompatApi21.setMetadata(r0, r3);
            return;
        L5:
            r3 = r2.getMediaMetadata();
            goto L6
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setPlaybackState(PlaybackStateCompat r3) {
            this.mPlaybackState = r3;
            int r0 = this.mExtraControllerCallbacks.beginBroadcast() - 1;
        L3:
            if (r0 < 0) goto L7;
            ((IMediaControllerCallback) this.mExtraControllerCallbacks.getBroadcastItem(r0)).onPlaybackStateChanged(r3);     // Catch: RemoteException -> L13
        L6:
            r0 = r0 - 1;
            goto L3
        L7:
            this.mExtraControllerCallbacks.finishBroadcast();
            Object r1 = this.mSessionObj;
            if (r3 != null) goto L10;
            Object r4 = null;
        L11:
            MediaSessionCompatApi21.setPlaybackState(r1, r4);
            return;
        L10:
            r4 = r3.getPlaybackState();
            goto L11
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setPlaybackToLocal(int r2) {
            MediaSessionCompatApi21.setPlaybackToLocal(this.mSessionObj, r2);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setPlaybackToRemote(VolumeProviderCompat r2) {
            MediaSessionCompatApi21.setPlaybackToRemote(this.mSessionObj, r2.getVolumeProvider());
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setQueue(List<QueueItem> r3) {
            this.mQueue = r3;
            if (r3 == null) goto L8;
            ArrayList r0 = new ArrayList();
            Iterator<QueueItem> r4 = r3.iterator();
        L6:
            if (r4.hasNext() == false) goto L9;
            r0.add(r4.next().getQueueItem());
        L9:
            MediaSessionCompatApi21.setQueue(this.mSessionObj, r0);
            return;
        L8:
            r0 = null;
            goto L9
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setQueueTitle(CharSequence r2) {
            MediaSessionCompatApi21.setQueueTitle(this.mSessionObj, r2);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setRatingType(int r3) {
            if (Build.VERSION.SDK_INT >= 22) goto L5;
            this.mRatingType = r3;
            return;
        L5:
            MediaSessionCompatApi22.setRatingType(this.mSessionObj, r3);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setRepeatMode(int r3) {
            if (this.mRepeatMode == r3) goto L16;
            this.mRepeatMode = r3;
            int r0 = this.mExtraControllerCallbacks.beginBroadcast() - 1;
        L5:
            if (r0 < 0) goto L9;
            ((IMediaControllerCallback) this.mExtraControllerCallbacks.getBroadcastItem(r0)).onRepeatModeChanged(r3);     // Catch: RemoteException -> L11
        L8:
            r0 = r0 - 1;
            goto L5
        L9:
            this.mExtraControllerCallbacks.finishBroadcast();
            return;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setSessionActivity(PendingIntent r2) {
            MediaSessionCompatApi21.setSessionActivity(this.mSessionObj, r2);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setShuffleMode(int r3) {
            if (this.mShuffleMode == r3) goto L16;
            this.mShuffleMode = r3;
            int r0 = this.mExtraControllerCallbacks.beginBroadcast() - 1;
        L5:
            if (r0 < 0) goto L9;
            ((IMediaControllerCallback) this.mExtraControllerCallbacks.getBroadcastItem(r0)).onShuffleModeChanged(r3);     // Catch: RemoteException -> L11
        L8:
            r0 = r0 - 1;
            goto L5
        L9:
            this.mExtraControllerCallbacks.finishBroadcast();
            return;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void sendSessionEvent(String r3, Bundle r4) {
            if (Build.VERSION.SDK_INT >= 23) goto L10;
            int r0 = this.mExtraControllerCallbacks.beginBroadcast() - 1;
        L5:
            if (r0 < 0) goto L9;
            ((IMediaControllerCallback) this.mExtraControllerCallbacks.getBroadcastItem(r0)).onEvent(r3, r4);     // Catch: RemoteException -> L12
        L8:
            r0 = r0 - 1;
            goto L5
        L9:
            this.mExtraControllerCallbacks.finishBroadcast();
        L10:
            MediaSessionCompatApi21.sendSessionEvent(this.mSessionObj, r3, r4);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setCallback(Callback r3, Handler r4) {
            Object r0 = this.mSessionObj;
            if (r3 != null) goto L5;
            Object r1 = null;
        L6:
            MediaSessionCompatApi21.setCallback(r0, r1, r4);
            if (r3 == null) goto L10;
            r3.setSessionImpl(this, r4);
            return;
        L10:
            return;
        L5:
            r1 = r3.mCallbackObj;
            goto L6
        }

        public MediaSessionImplApi21(Context r2, String r3, Bundle r4) {
            this.mDestroyed = false;
            this.mExtraControllerCallbacks = new RemoteCallbackList();
            Object r5 = MediaSessionCompatApi21.createSession(r2, r3);
            this.mSessionObj = r5;
            this.mToken = new Token(MediaSessionCompatApi21.getSessionToken(r5), new ExtraSession(this), r4);
        }
    }

    public static class MediaSessionImplApi28 extends MediaSessionImplApi21 {
        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi21, android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setCurrentControllerInfo(MediaSessionManager.RemoteUserInfo r1) {
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi21, android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public final MediaSessionManager.RemoteUserInfo getCurrentControllerInfo() {
            return new MediaSessionManager.RemoteUserInfo(((MediaSession) this.mSessionObj).getCurrentControllerInfo());
        }

        public MediaSessionImplApi28(Object r1) {
            super(r1);
        }

        public MediaSessionImplApi28(Context r1, String r2, Bundle r3) {
            super(r1, r2, r3);
        }
    }

    public static class MediaSessionImplBase implements MediaSessionImpl {
        static final int RCC_PLAYSTATE_NONE = 0;
        final AudioManager mAudioManager;
        volatile Callback mCallback;
        boolean mCaptioningEnabled;
        private final Context mContext;
        final RemoteCallbackList<IMediaControllerCallback> mControllerCallbacks;
        boolean mDestroyed;
        Bundle mExtras;
        int mFlags;
        private MessageHandler mHandler;
        boolean mIsActive;
        private boolean mIsMbrRegistered;
        private boolean mIsRccRegistered;
        int mLocalStream;
        final Object mLock;
        private final ComponentName mMediaButtonReceiverComponentName;
        private final PendingIntent mMediaButtonReceiverIntent;
        MediaMetadataCompat mMetadata;
        final String mPackageName;
        List<QueueItem> mQueue;
        CharSequence mQueueTitle;
        int mRatingType;
        final RemoteControlClient mRcc;
        private MediaSessionManager.RemoteUserInfo mRemoteUserInfo;
        int mRepeatMode;
        PendingIntent mSessionActivity;
        int mShuffleMode;
        PlaybackStateCompat mState;
        private final MediaSessionStub mStub;
        final String mTag;
        private final Token mToken;
        private VolumeProviderCompat.Callback mVolumeCallback;
        VolumeProviderCompat mVolumeProvider;
        int mVolumeType;

        public static final class Command {
            public final String command;
            public final Bundle extras;
            public final ResultReceiver stub;

            public Command(String r1, Bundle r2, ResultReceiver r3) {
                this.command = r1;
                this.extras = r2;
                this.stub = r3;
            }
        }

        public class MediaSessionStub extends IMediaSession.Stub {
            final /* synthetic */ MediaSessionImplBase this$0;

            @Override // android.support.v4.media.session.IMediaSession
            public boolean isShuffleModeEnabledRemoved() {
                return false;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void play() throws RemoteException {
                postToHandler(7);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepare() throws RemoteException {
                postToHandler(3);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setShuffleModeEnabledRemoved(boolean r1) throws RemoteException {
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void fastForward() throws RemoteException {
                postToHandler(16);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public Bundle getExtras() {
                Object r0 = this.this$0.mLock;
                monitor-enter(r0);
                Bundle r1 = this.this$0.mExtras;     // Catch: Throwable -> L7
                monitor-exit(r0);     // Catch: Throwable -> L7
                return r1;
            L7:
                th = move-exception;
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public long getFlags() {
                Object r0 = this.this$0.mLock;
                monitor-enter(r0);
                long r1 = this.this$0.mFlags;     // Catch: Throwable -> L7
                monitor-exit(r0);     // Catch: Throwable -> L7
                return r1;
            L7:
                th = move-exception;
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public PendingIntent getLaunchPendingIntent() {
                Object r0 = this.this$0.mLock;
                monitor-enter(r0);
                PendingIntent r1 = this.this$0.mSessionActivity;     // Catch: Throwable -> L7
                monitor-exit(r0);     // Catch: Throwable -> L7
                return r1;
            L7:
                th = move-exception;
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public MediaMetadataCompat getMetadata() {
                return this.this$0.mMetadata;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public String getPackageName() {
                return this.this$0.mPackageName;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public PlaybackStateCompat getPlaybackState() {
                Object r0 = this.this$0.mLock;
                monitor-enter(r0);
                MediaSessionImplBase r1 = this.this$0;     // Catch: Throwable -> L8
                PlaybackStateCompat r2 = r1.mState;     // Catch: Throwable -> L8
                MediaMetadataCompat r3 = r1.mMetadata;     // Catch: Throwable -> L8
                monitor-exit(r0);     // Catch: Throwable -> L8
                return MediaSessionCompat.getStateWithUpdatedPosition(r2, r3);
            L8:
                th = move-exception;
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public List<QueueItem> getQueue() {
                Object r0 = this.this$0.mLock;
                monitor-enter(r0);
                List<QueueItem> r1 = this.this$0.mQueue;     // Catch: Throwable -> L7
                monitor-exit(r0);     // Catch: Throwable -> L7
                return r1;
            L7:
                th = move-exception;
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public CharSequence getQueueTitle() {
                return this.this$0.mQueueTitle;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public int getRatingType() {
                return this.this$0.mRatingType;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public int getRepeatMode() {
                return this.this$0.mRepeatMode;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public int getShuffleMode() {
                return this.this$0.mShuffleMode;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public String getTag() {
                return this.this$0.mTag;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public ParcelableVolumeInfo getVolumeAttributes() {
                Object r0 = this.this$0.mLock;
                monitor-enter(r0);
                MediaSessionImplBase r1 = this.this$0;     // Catch: Throwable -> L11
                int r3 = r1.mVolumeType;     // Catch: Throwable -> L11
                int r4 = r1.mLocalStream;     // Catch: Throwable -> L11
                VolumeProviderCompat r2 = r1.mVolumeProvider;     // Catch: Throwable -> L11
                int r5 = 2;
                if (r3 != 2) goto L7;
                int r6 = r2.getVolumeControl();     // Catch: Throwable -> L11
                int r7 = r2.getMaxVolume();     // Catch: Throwable -> L11
                int r8 = r2.getCurrentVolume();     // Catch: Throwable -> L11
                int r9 = r7;
                r5 = r6;
            L8:
                monitor-exit(r0);     // Catch: Throwable -> L11
                return new ParcelableVolumeInfo(r3, r4, r5, r9, r8);
            L7:
                int r10 = r1.mAudioManager.getStreamMaxVolume(r4);     // Catch: Throwable -> L11
                r9 = r10;
                r8 = this.this$0.mAudioManager.getStreamVolume(r4);     // Catch: Throwable -> L11
            L11:
                th = move-exception;
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean isCaptioningEnabled() {
                return this.this$0.mCaptioningEnabled;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean isTransportControlEnabled() {
                if ((this.this$0.mFlags & 2) == 0) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void next() throws RemoteException {
                postToHandler(14);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void pause() throws RemoteException {
                postToHandler(12);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void previous() throws RemoteException {
                postToHandler(15);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void rewind() throws RemoteException {
                postToHandler(17);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void stop() throws RemoteException {
                postToHandler(13);
            }

            public MediaSessionStub(MediaSessionImplBase r1) {
                this.this$0 = r1;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void addQueueItem(MediaDescriptionCompat r2) {
                postToHandler(25, r2);
            }

            public void postToHandler(int r7) {
                this.this$0.postToHandler(r7, 0, 0, null, null);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void rate(RatingCompat r2) throws RemoteException {
                postToHandler(19, r2);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void registerCallbackListener(IMediaControllerCallback r5) {
                if (this.this$0.mDestroyed == true) goto L9;
                MediaSessionManager.RemoteUserInfo r0 = new MediaSessionManager.RemoteUserInfo("android.media.session.MediaController", Binder.getCallingPid(), Binder.getCallingUid());
                this.this$0.mControllerCallbacks.register(r5, r0);
                return;
            L9:
                r5.onSessionDestroyed();     // Catch: Exception -> L8
                return;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void removeQueueItem(MediaDescriptionCompat r2) {
                postToHandler(27, r2);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void removeQueueItemAt(int r2) {
                postToHandler(28, r2);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void seekTo(long r2) throws RemoteException {
                postToHandler(18, Long.valueOf(r2));
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean sendMediaButton(KeyEvent r3) {
                boolean r1 = true;
                if ((this.this$0.mFlags & 1) != 0) goto L6;
                r1 = false;
            L6:
                if (r1 == false) goto L8;
                postToHandler(21, r3);
            L8:
                return r1;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setCaptioningEnabled(boolean r2) throws RemoteException {
                postToHandler(29, Boolean.valueOf(r2));
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setRepeatMode(int r2) throws RemoteException {
                postToHandler(23, r2);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setShuffleMode(int r2) throws RemoteException {
                postToHandler(30, r2);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void skipToQueueItem(long r2) {
                postToHandler(11, Long.valueOf(r2));
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void unregisterCallbackListener(IMediaControllerCallback r2) {
                this.this$0.mControllerCallbacks.unregister(r2);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void addQueueItemAt(MediaDescriptionCompat r2, int r3) {
                postToHandler(26, r2, r3);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void playFromMediaId(String r2, Bundle r3) throws RemoteException {
                postToHandler(8, r2, r3);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void playFromSearch(String r2, Bundle r3) throws RemoteException {
                postToHandler(9, r2, r3);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void playFromUri(Uri r2, Bundle r3) throws RemoteException {
                postToHandler(10, r2, r3);
            }

            public void postToHandler(int r7, int r8) {
                this.this$0.postToHandler(r7, r8, 0, null, null);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepareFromMediaId(String r2, Bundle r3) throws RemoteException {
                postToHandler(4, r2, r3);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepareFromSearch(String r2, Bundle r3) throws RemoteException {
                postToHandler(5, r2, r3);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepareFromUri(Uri r2, Bundle r3) throws RemoteException {
                postToHandler(6, r2, r3);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void rateWithExtras(RatingCompat r2, Bundle r3) throws RemoteException {
                postToHandler(31, r2, r3);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void sendCustomAction(String r2, Bundle r3) throws RemoteException {
                postToHandler(20, r2, r3);
            }

            public void postToHandler(int r7, Object r8) {
                this.this$0.postToHandler(r7, 0, 0, r8, null);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void adjustVolume(int r1, int r2, String r3) {
                this.this$0.adjustVolume(r1, r2);
            }

            public void postToHandler(int r7, Object r8, int r9) {
                this.this$0.postToHandler(r7, r9, 0, r8, null);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void sendCommand(String r2, Bundle r3, ResultReceiverWrapper r4) {
                postToHandler(1, new Command(r2, r3, r4.mResultReceiver));
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setVolumeTo(int r1, int r2, String r3) {
                this.this$0.setVolumeTo(r1, r2);
            }

            public void postToHandler(int r7, Object r8, Bundle r9) {
                this.this$0.postToHandler(r7, 0, 0, r8, r9);
            }
        }

        public class MessageHandler extends Handler {
            private static final int KEYCODE_MEDIA_PAUSE = 127;
            private static final int KEYCODE_MEDIA_PLAY = 126;
            private static final int MSG_ADD_QUEUE_ITEM = 25;
            private static final int MSG_ADD_QUEUE_ITEM_AT = 26;
            private static final int MSG_ADJUST_VOLUME = 2;
            private static final int MSG_COMMAND = 1;
            private static final int MSG_CUSTOM_ACTION = 20;
            private static final int MSG_FAST_FORWARD = 16;
            private static final int MSG_MEDIA_BUTTON = 21;
            private static final int MSG_NEXT = 14;
            private static final int MSG_PAUSE = 12;
            private static final int MSG_PLAY = 7;
            private static final int MSG_PLAY_MEDIA_ID = 8;
            private static final int MSG_PLAY_SEARCH = 9;
            private static final int MSG_PLAY_URI = 10;
            private static final int MSG_PREPARE = 3;
            private static final int MSG_PREPARE_MEDIA_ID = 4;
            private static final int MSG_PREPARE_SEARCH = 5;
            private static final int MSG_PREPARE_URI = 6;
            private static final int MSG_PREVIOUS = 15;
            private static final int MSG_RATE = 19;
            private static final int MSG_RATE_EXTRA = 31;
            private static final int MSG_REMOVE_QUEUE_ITEM = 27;
            private static final int MSG_REMOVE_QUEUE_ITEM_AT = 28;
            private static final int MSG_REWIND = 17;
            private static final int MSG_SEEK_TO = 18;
            private static final int MSG_SET_CAPTIONING_ENABLED = 29;
            private static final int MSG_SET_REPEAT_MODE = 23;
            private static final int MSG_SET_SHUFFLE_MODE = 30;
            private static final int MSG_SET_VOLUME = 22;
            private static final int MSG_SKIP_TO_ITEM = 11;
            private static final int MSG_STOP = 13;
            final /* synthetic */ MediaSessionImplBase this$0;

            @Override // android.os.Handler
            public void handleMessage(Message r8) {
                Callback r0 = this.this$0.mCallback;
                if (r0 != null) goto L5;
                return;
            L5:
                Bundle r1 = r8.getData();
                MediaSessionCompat.ensureClassLoader(r1);
                this.this$0.setCurrentControllerInfo(new MediaSessionManager.RemoteUserInfo(r1.getString(MediaSessionCompat.DATA_CALLING_PACKAGE), r1.getInt(MediaSessionCompat.DATA_CALLING_PID), r1.getInt(MediaSessionCompat.DATA_CALLING_UID)));
                Bundle r2 = r1.getBundle(MediaSessionCompat.DATA_EXTRAS);
                MediaSessionCompat.ensureClassLoader(r2);
            L52:
                th = move-exception;
                this.this$0.setCurrentControllerInfo(null);
                throw th;
            L7:
                switch(r8.what) {
                    case 1: goto L49;
                    case 2: goto L48;
                    case 3: goto L47;
                    case 4: goto L46;
                    case 5: goto L45;
                    case 6: goto L44;
                    case 7: goto L43;
                    case 8: goto L42;
                    case 9: goto L41;
                    case 10: goto L40;
                    case 11: goto L39;
                    case 12: goto L38;
                    case 13: goto L37;
                    case 14: goto L36;
                    case 15: goto L35;
                    case 16: goto L34;
                    case 17: goto L33;
                    case 18: goto L32;
                    case 19: goto L31;
                    case 20: goto L30;
                    case 21: goto L27;
                    case 22: goto L26;
                    case 23: goto L25;
                    case 24: goto L50;
                    case 25: goto L24;
                    case 26: goto L23;
                    case 27: goto L22;
                    case 28: goto L12;
                    case 29: goto L11;
                    case 30: goto L10;
                    case 31: goto L9;
                    default: goto L50;
                };     // Catch: Throwable -> L52
            L9:
                r0.onSetRating((RatingCompat) r8.obj, r2);     // Catch: Throwable -> L52
                goto L50
            L10:
                r0.onSetShuffleMode(r8.arg1);     // Catch: Throwable -> L52
                goto L50
            L11:
                r0.onSetCaptioningEnabled(((Boolean) r8.obj).booleanValue());     // Catch: Throwable -> L52
                goto L50
            L12:
                List<QueueItem> r3 = this.this$0.mQueue;     // Catch: Throwable -> L52
                if (r3 == null) goto L50;
                int r4 = r8.arg1;     // Catch: Throwable -> L52
                if (r4 >= 0) goto L17;
            L19:
                QueueItem r9 = null;
            L20:
                if (r9 == null) goto L50;
                r0.onRemoveQueueItem(r9.getDescription());     // Catch: Throwable -> L52
                goto L50
            L17:
                if (r4 >= r3.size()) goto L19;
                r9 = this.this$0.mQueue.get(r8.arg1);     // Catch: Throwable -> L52
                goto L20
            L22:
                r0.onRemoveQueueItem((MediaDescriptionCompat) r8.obj);     // Catch: Throwable -> L52
                goto L50
            L23:
                r0.onAddQueueItem((MediaDescriptionCompat) r8.obj, r8.arg1);     // Catch: Throwable -> L52
                goto L50
            L24:
                r0.onAddQueueItem((MediaDescriptionCompat) r8.obj);     // Catch: Throwable -> L52
                goto L50
            L25:
                r0.onSetRepeatMode(r8.arg1);     // Catch: Throwable -> L52
                goto L50
            L26:
                this.this$0.setVolumeTo(r8.arg1, 0);     // Catch: Throwable -> L52
                goto L50
            L27:
                KeyEvent r10 = (KeyEvent) r8.obj;     // Catch: Throwable -> L52
                Intent r5 = new Intent("android.intent.action.MEDIA_BUTTON");     // Catch: Throwable -> L52
                r5.putExtra("android.intent.extra.KEY_EVENT", r10);     // Catch: Throwable -> L52
                if (r0.onMediaButtonEvent(r5) == true) goto L50;
                onMediaButtonEvent(r10, r0);     // Catch: Throwable -> L52
                goto L50
            L30:
                r0.onCustomAction((String) r8.obj, r2);     // Catch: Throwable -> L52
                goto L50
            L31:
                r0.onSetRating((RatingCompat) r8.obj);     // Catch: Throwable -> L52
                goto L50
            L32:
                r0.onSeekTo(((Long) r8.obj).longValue());     // Catch: Throwable -> L52
                goto L50
            L33:
                r0.onRewind();     // Catch: Throwable -> L52
                goto L50
            L34:
                r0.onFastForward();     // Catch: Throwable -> L52
                goto L50
            L35:
                r0.onSkipToPrevious();     // Catch: Throwable -> L52
                goto L50
            L36:
                r0.onSkipToNext();     // Catch: Throwable -> L52
                goto L50
            L37:
                r0.onStop();     // Catch: Throwable -> L52
                goto L50
            L38:
                r0.onPause();     // Catch: Throwable -> L52
                goto L50
            L39:
                r0.onSkipToQueueItem(((Long) r8.obj).longValue());     // Catch: Throwable -> L52
                goto L50
            L40:
                r0.onPlayFromUri((Uri) r8.obj, r2);     // Catch: Throwable -> L52
                goto L50
            L41:
                r0.onPlayFromSearch((String) r8.obj, r2);     // Catch: Throwable -> L52
                goto L50
            L42:
                r0.onPlayFromMediaId((String) r8.obj, r2);     // Catch: Throwable -> L52
                goto L50
            L43:
                r0.onPlay();     // Catch: Throwable -> L52
                goto L50
            L44:
                r0.onPrepareFromUri((Uri) r8.obj, r2);     // Catch: Throwable -> L52
                goto L50
            L45:
                r0.onPrepareFromSearch((String) r8.obj, r2);     // Catch: Throwable -> L52
                goto L50
            L46:
                r0.onPrepareFromMediaId((String) r8.obj, r2);     // Catch: Throwable -> L52
                goto L50
            L47:
                r0.onPrepare();     // Catch: Throwable -> L52
                goto L50
            L48:
                this.this$0.adjustVolume(r8.arg1, 0);     // Catch: Throwable -> L52
                goto L50
            L49:
                Command r11 = (Command) r8.obj;     // Catch: Throwable -> L52
                r0.onCommand(r11.command, r11.extras, r11.stub);     // Catch: Throwable -> L52
            L50:
                this.this$0.setCurrentControllerInfo(null);
            }

            public MessageHandler(MediaSessionImplBase r1, Looper r2) {
                this.this$0 = r1;
                super(r2);
            }

            private void onMediaButtonEvent(KeyEvent r8, Callback r9) {
                if (r8 != null) goto L4;
                return;
            L4:
                if (r8.getAction() != 0) goto L52;
                PlaybackStateCompat r0 = this.this$0.mState;
                if (r0 != null) goto L9;
                long r3 = 0;
            L10:
                int r10 = r8.getKeyCode();
                if (r10 == KEYCODE_MEDIA_PLAY) goto L35;
                if (r10 == KEYCODE_MEDIA_PAUSE) goto L32;
                switch(r10) {
                    case 86: goto L29;
                    case 87: goto L26;
                    case 88: goto L23;
                    case 89: goto L20;
                    case 90: goto L17;
                    default: goto L53;
                };
            L53:
                return;
            L17:
                if ((r3 & 64) == 0) goto L39;
                r9.onFastForward();
                return;
            L39:
                return;
            L20:
                if ((r3 & 8) == 0) goto L41;
                r9.onRewind();
                return;
            L41:
                return;
            L23:
                if ((r3 & 16) == 0) goto L43;
                r9.onSkipToPrevious();
                return;
            L43:
                return;
            L26:
                if ((r3 & 32) == 0) goto L45;
                r9.onSkipToNext();
                return;
            L45:
                return;
            L29:
                if ((r3 & 1) == 0) goto L47;
                r9.onStop();
                return;
            L47:
                return;
            L32:
                if ((r3 & 2) == 0) goto L49;
                r9.onPause();
                return;
            L49:
                return;
            L35:
                if ((r3 & 4) == 0) goto L51;
                r9.onPlay();
                return;
            L51:
                return;
            L9:
                r3 = r0.getActions();
                goto L10
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public String getCallingPackage() {
            return null;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public Object getMediaSession() {
            return null;
        }

        public int getRccStateFromState(int r1) {
            switch(r1) {
                case 0: goto L23;
                case 1: goto L21;
                case 2: goto L19;
                case 3: goto L17;
                case 4: goto L15;
                case 5: goto L13;
                case 6: goto L11;
                case 7: goto L9;
                case 8: goto L11;
                case 9: goto L7;
                case 10: goto L5;
                case 11: goto L5;
                default: goto L3;
            };
        L3:
            return -1;
        L5:
            return 6;
        L7:
            return 7;
        L9:
            return 9;
        L11:
            return 8;
        L13:
            return 5;
        L15:
            return 4;
        L17:
            return 3;
        L19:
            return 2;
        L21:
            return 1;
        L23:
            return 0;
        }

        public int getRccTransportControlFlagsFromActions(long r7) {
            if ((1 & r7) == 0) goto L5;
            int r0 = 32;
        L7:
            if ((2 & r7) == 0) goto L10;
            r0 = r0 | 16;
        L10:
            if ((4 & r7) == 0) goto L13;
            r0 = r0 | 4;
        L13:
            if ((8 & r7) == 0) goto L16;
            r0 = r0 | 2;
        L16:
            if ((16 & r7) == 0) goto L19;
            r0 = r0 | 1;
        L19:
            if ((32 & r7) == 0) goto L22;
            r0 = r0 | 128;
        L22:
            if ((64 & r7) == 0) goto L25;
            r0 = r0 | 64;
        L25:
            if ((r7 & 512) != 0) goto L27;
            return r0;
        L27:
            return r0 | 8;
        L5:
            r0 = 0;
            goto L7
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public Object getRemoteControlClient() {
            return null;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void release() {
            this.mIsActive = false;
            this.mDestroyed = true;
            update();
            sendSessionDestroyed();
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setMediaButtonReceiver(PendingIntent r1) {
        }

        private void sendSessionDestroyed() {
            int r0 = this.mControllerCallbacks.beginBroadcast() - 1;
        L3:
            if (r0 < 0) goto L7;
            ((IMediaControllerCallback) this.mControllerCallbacks.getBroadcastItem(r0)).onSessionDestroyed();     // Catch: RemoteException -> L9
        L6:
            r0 = r0 - 1;
            goto L3
        L7:
            this.mControllerCallbacks.finishBroadcast();
            this.mControllerCallbacks.kill();
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public MediaSessionManager.RemoteUserInfo getCurrentControllerInfo() {
            Object r0 = this.mLock;
            monitor-enter(r0);
            MediaSessionManager.RemoteUserInfo r1 = this.mRemoteUserInfo;     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public PlaybackStateCompat getPlaybackState() {
            Object r0 = this.mLock;
            monitor-enter(r0);
            PlaybackStateCompat r1 = this.mState;     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        public boolean update() {
            if (this.mIsActive == false) goto L23;
            boolean r0 = this.mIsMbrRegistered;
            if (r0 == false) goto L7;
        L9:
            if (r0 == true) goto L11;
        L13:
            boolean r1 = this.mIsRccRegistered;
            if (r1 == false) goto L16;
        L18:
            if (r1 == true) goto L20;
            return false;
        L20:
            if ((this.mFlags & 2) != 0) goto L31;
            this.mRcc.setPlaybackState(0);
            this.mAudioManager.unregisterRemoteControlClient(this.mRcc);
            this.mIsRccRegistered = false;
            return false;
        L31:
            return false;
        L16:
            if ((this.mFlags & 2) == 0) goto L18;
            this.mAudioManager.registerRemoteControlClient(this.mRcc);
            this.mIsRccRegistered = true;
            return true;
        L11:
            if ((this.mFlags & 1) != 0) goto L13;
            unregisterMediaButtonEventReceiver(this.mMediaButtonReceiverIntent, this.mMediaButtonReceiverComponentName);
            this.mIsMbrRegistered = false;
            goto L13
        L7:
            if ((this.mFlags & 1) == 0) goto L9;
            registerMediaButtonEventReceiver(this.mMediaButtonReceiverIntent, this.mMediaButtonReceiverComponentName);
            this.mIsMbrRegistered = true;
            goto L13
        L23:
            if (this.mIsMbrRegistered == false) goto L26;
            unregisterMediaButtonEventReceiver(this.mMediaButtonReceiverIntent, this.mMediaButtonReceiverComponentName);
            this.mIsMbrRegistered = false;
        L26:
            if (this.mIsRccRegistered == false) goto L33;
            this.mRcc.setPlaybackState(0);
            this.mAudioManager.unregisterRemoteControlClient(this.mRcc);
            this.mIsRccRegistered = false;
            return false;
        L33:
            return false;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public Token getSessionToken() {
            return this.mToken;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public boolean isActive() {
            return this.mIsActive;
        }

        private void sendCaptioningEnabled(boolean r3) {
            int r0 = this.mControllerCallbacks.beginBroadcast() - 1;
        L3:
            if (r0 < 0) goto L7;
            ((IMediaControllerCallback) this.mControllerCallbacks.getBroadcastItem(r0)).onCaptioningEnabledChanged(r3);     // Catch: RemoteException -> L9
        L6:
            r0 = r0 - 1;
            goto L3
        L7:
            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendExtras(Bundle r3) {
            int r0 = this.mControllerCallbacks.beginBroadcast() - 1;
        L3:
            if (r0 < 0) goto L7;
            ((IMediaControllerCallback) this.mControllerCallbacks.getBroadcastItem(r0)).onExtrasChanged(r3);     // Catch: RemoteException -> L9
        L6:
            r0 = r0 - 1;
            goto L3
        L7:
            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendMetadata(MediaMetadataCompat r3) {
            int r0 = this.mControllerCallbacks.beginBroadcast() - 1;
        L3:
            if (r0 < 0) goto L7;
            ((IMediaControllerCallback) this.mControllerCallbacks.getBroadcastItem(r0)).onMetadataChanged(r3);     // Catch: RemoteException -> L9
        L6:
            r0 = r0 - 1;
            goto L3
        L7:
            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendQueue(List<QueueItem> r3) {
            int r0 = this.mControllerCallbacks.beginBroadcast() - 1;
        L3:
            if (r0 < 0) goto L7;
            ((IMediaControllerCallback) this.mControllerCallbacks.getBroadcastItem(r0)).onQueueChanged(r3);     // Catch: RemoteException -> L9
        L6:
            r0 = r0 - 1;
            goto L3
        L7:
            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendQueueTitle(CharSequence r3) {
            int r0 = this.mControllerCallbacks.beginBroadcast() - 1;
        L3:
            if (r0 < 0) goto L7;
            ((IMediaControllerCallback) this.mControllerCallbacks.getBroadcastItem(r0)).onQueueTitleChanged(r3);     // Catch: RemoteException -> L9
        L6:
            r0 = r0 - 1;
            goto L3
        L7:
            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendRepeatMode(int r3) {
            int r0 = this.mControllerCallbacks.beginBroadcast() - 1;
        L3:
            if (r0 < 0) goto L7;
            ((IMediaControllerCallback) this.mControllerCallbacks.getBroadcastItem(r0)).onRepeatModeChanged(r3);     // Catch: RemoteException -> L9
        L6:
            r0 = r0 - 1;
            goto L3
        L7:
            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendShuffleMode(int r3) {
            int r0 = this.mControllerCallbacks.beginBroadcast() - 1;
        L3:
            if (r0 < 0) goto L7;
            ((IMediaControllerCallback) this.mControllerCallbacks.getBroadcastItem(r0)).onShuffleModeChanged(r3);     // Catch: RemoteException -> L9
        L6:
            r0 = r0 - 1;
            goto L3
        L7:
            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendState(PlaybackStateCompat r3) {
            int r0 = this.mControllerCallbacks.beginBroadcast() - 1;
        L3:
            if (r0 < 0) goto L7;
            ((IMediaControllerCallback) this.mControllerCallbacks.getBroadcastItem(r0)).onPlaybackStateChanged(r3);     // Catch: RemoteException -> L9
        L6:
            r0 = r0 - 1;
            goto L3
        L7:
            this.mControllerCallbacks.finishBroadcast();
        }

        public RemoteControlClient.MetadataEditor buildRccMetadata(Bundle r7) {
            RemoteControlClient.MetadataEditor r0 = this.mRcc.editMetadata(true);
            if (r7 != null) goto L6;
            return r0;
        L6:
            if (r7.containsKey(MediaMetadataCompat.METADATA_KEY_ART) == false) goto L12;
            Bitmap r2 = (Bitmap) r7.getParcelable(MediaMetadataCompat.METADATA_KEY_ART);
            if (r2 == null) goto L10;
            r2 = r2.copy(r2.getConfig(), false);
        L10:
            r0.putBitmap(100, r2);
        L18:
            if (r7.containsKey(MediaMetadataCompat.METADATA_KEY_ALBUM) == false) goto L21;
            r0.putString(1, r7.getString(MediaMetadataCompat.METADATA_KEY_ALBUM));
        L21:
            if (r7.containsKey(MediaMetadataCompat.METADATA_KEY_ALBUM_ARTIST) == false) goto L24;
            r0.putString(13, r7.getString(MediaMetadataCompat.METADATA_KEY_ALBUM_ARTIST));
        L24:
            if (r7.containsKey(MediaMetadataCompat.METADATA_KEY_ARTIST) == false) goto L27;
            r0.putString(2, r7.getString(MediaMetadataCompat.METADATA_KEY_ARTIST));
        L27:
            if (r7.containsKey(MediaMetadataCompat.METADATA_KEY_AUTHOR) == false) goto L30;
            r0.putString(3, r7.getString(MediaMetadataCompat.METADATA_KEY_AUTHOR));
        L30:
            if (r7.containsKey(MediaMetadataCompat.METADATA_KEY_COMPILATION) == false) goto L33;
            r0.putString(15, r7.getString(MediaMetadataCompat.METADATA_KEY_COMPILATION));
        L33:
            if (r7.containsKey(MediaMetadataCompat.METADATA_KEY_COMPOSER) == false) goto L36;
            r0.putString(4, r7.getString(MediaMetadataCompat.METADATA_KEY_COMPOSER));
        L36:
            if (r7.containsKey(MediaMetadataCompat.METADATA_KEY_DATE) == false) goto L39;
            r0.putString(5, r7.getString(MediaMetadataCompat.METADATA_KEY_DATE));
        L39:
            if (r7.containsKey(MediaMetadataCompat.METADATA_KEY_DISC_NUMBER) == false) goto L42;
            r0.putLong(14, r7.getLong(MediaMetadataCompat.METADATA_KEY_DISC_NUMBER));
        L42:
            if (r7.containsKey(MediaMetadataCompat.METADATA_KEY_DURATION) == false) goto L45;
            r0.putLong(9, r7.getLong(MediaMetadataCompat.METADATA_KEY_DURATION));
        L45:
            if (r7.containsKey(MediaMetadataCompat.METADATA_KEY_GENRE) == false) goto L48;
            r0.putString(6, r7.getString(MediaMetadataCompat.METADATA_KEY_GENRE));
        L48:
            if (r7.containsKey(MediaMetadataCompat.METADATA_KEY_TITLE) == false) goto L51;
            r0.putString(7, r7.getString(MediaMetadataCompat.METADATA_KEY_TITLE));
        L51:
            if (r7.containsKey(MediaMetadataCompat.METADATA_KEY_TRACK_NUMBER) == false) goto L54;
            r0.putLong(0, r7.getLong(MediaMetadataCompat.METADATA_KEY_TRACK_NUMBER));
        L54:
            if (r7.containsKey(MediaMetadataCompat.METADATA_KEY_WRITER) == false) goto L56;
            r0.putString(11, r7.getString(MediaMetadataCompat.METADATA_KEY_WRITER));
        L56:
            return r0;
        L12:
            if (r7.containsKey(MediaMetadataCompat.METADATA_KEY_ALBUM_ART) == false) goto L18;
            Bitmap r3 = (Bitmap) r7.getParcelable(MediaMetadataCompat.METADATA_KEY_ALBUM_ART);
            if (r3 == null) goto L16;
            r3 = r3.copy(r3.getConfig(), false);
        L16:
            r0.putBitmap(100, r3);
            goto L18
        }

        public void sendVolumeInfoChanged(ParcelableVolumeInfo r3) {
            int r0 = this.mControllerCallbacks.beginBroadcast() - 1;
        L3:
            if (r0 < 0) goto L7;
            ((IMediaControllerCallback) this.mControllerCallbacks.getBroadcastItem(r0)).onVolumeInfoChanged(r3);     // Catch: RemoteException -> L9
        L6:
            r0 = r0 - 1;
            goto L3
        L7:
            this.mControllerCallbacks.finishBroadcast();
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setActive(boolean r2) {
            if (r2 != this.mIsActive) goto L5;
            return;
        L5:
            this.mIsActive = r2;
            if (update() == false) goto L9;
            setMetadata(this.mMetadata);
            setPlaybackState(this.mState);
            return;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setCaptioningEnabled(boolean r2) {
            if (this.mCaptioningEnabled == r2) goto L6;
            this.mCaptioningEnabled = r2;
            sendCaptioningEnabled(r2);
            return;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setCurrentControllerInfo(MediaSessionManager.RemoteUserInfo r2) {
            Object r0 = this.mLock;
            monitor-enter(r0);
            this.mRemoteUserInfo = r2;     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setExtras(Bundle r1) {
            this.mExtras = r1;
            sendExtras(r1);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setFlags(int r2) {
            Object r0 = this.mLock;
            monitor-enter(r0);
            this.mFlags = r2;     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            update();
            return;
        L8:
            th = move-exception;
            throw th;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setMetadata(MediaMetadataCompat r3) {
            if (r3 == null) goto L4;
            r3 = new MediaMetadataCompat.Builder(r3, MediaSessionCompat.sMaxBitmapSize).build();
        L4:
            Object r0 = this.mLock;
            monitor-enter(r0);
            this.mMetadata = r3;     // Catch: Throwable -> L16
            monitor-exit(r0);     // Catch: Throwable -> L16
            sendMetadata(r3);
            if (this.mIsActive == true) goto L11;
            return;
        L11:
            if (r3 != null) goto L13;
            Bundle r4 = null;
        L14:
            buildRccMetadata(r4).apply();
            return;
        L13:
            r4 = r3.getBundle();
        L16:
            th = move-exception;
            throw th;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setPlaybackState(PlaybackStateCompat r4) {
            Object r0 = this.mLock;
            monitor-enter(r0);
            this.mState = r4;     // Catch: Throwable -> L13
            monitor-exit(r0);     // Catch: Throwable -> L13
            sendState(r4);
            if (this.mIsActive == true) goto L9;
            return;
        L9:
            if (r4 != null) goto L11;
            this.mRcc.setPlaybackState(0);
            this.mRcc.setTransportControlFlags(0);
            return;
        L11:
            setRccState(r4);
            this.mRcc.setTransportControlFlags(getRccTransportControlFlagsFromActions(r4.getActions()));
            return;
        L13:
            th = move-exception;
            throw th;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setPlaybackToLocal(int r7) {
            VolumeProviderCompat r0 = this.mVolumeProvider;
            if (r0 == null) goto L5;
            r0.setCallback(null);
        L5:
            this.mLocalStream = r7;
            this.mVolumeType = 1;
            int r1 = this.mVolumeType;
            int r2 = this.mLocalStream;
            sendVolumeInfoChanged(new ParcelableVolumeInfo(r1, r2, 2, this.mAudioManager.getStreamMaxVolume(r2), this.mAudioManager.getStreamVolume(this.mLocalStream)));
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setPlaybackToRemote(VolumeProviderCompat r8) {
            if (r8 == null) goto L9;
            VolumeProviderCompat r0 = this.mVolumeProvider;
            if (r0 == null) goto L6;
            r0.setCallback(null);
        L6:
            this.mVolumeType = 2;
            this.mVolumeProvider = r8;
            sendVolumeInfoChanged(new ParcelableVolumeInfo(this.mVolumeType, this.mLocalStream, this.mVolumeProvider.getVolumeControl(), this.mVolumeProvider.getMaxVolume(), this.mVolumeProvider.getCurrentVolume()));
            r8.setCallback(this.mVolumeCallback);
            return;
        L9:
            throw new IllegalArgumentException("volumeProvider may not be null");
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setQueue(List<QueueItem> r1) {
            this.mQueue = r1;
            sendQueue(r1);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setQueueTitle(CharSequence r1) {
            this.mQueueTitle = r1;
            sendQueueTitle(r1);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setRatingType(int r1) {
            this.mRatingType = r1;
        }

        public void setRccState(PlaybackStateCompat r2) {
            this.mRcc.setPlaybackState(getRccStateFromState(r2.getState()));
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setRepeatMode(int r2) {
            if (this.mRepeatMode == r2) goto L6;
            this.mRepeatMode = r2;
            sendRepeatMode(r2);
            return;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setSessionActivity(PendingIntent r2) {
            Object r0 = this.mLock;
            monitor-enter(r0);
            this.mSessionActivity = r2;     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setShuffleMode(int r2) {
            if (this.mShuffleMode == r2) goto L6;
            this.mShuffleMode = r2;
            sendShuffleMode(r2);
            return;
        }

        private void sendEvent(String r3, Bundle r4) {
            int r0 = this.mControllerCallbacks.beginBroadcast() - 1;
        L3:
            if (r0 < 0) goto L7;
            ((IMediaControllerCallback) this.mControllerCallbacks.getBroadcastItem(r0)).onEvent(r3, r4);     // Catch: RemoteException -> L9
        L6:
            r0 = r0 - 1;
            goto L3
        L7:
            this.mControllerCallbacks.finishBroadcast();
        }

        public void adjustVolume(int r3, int r4) {
            if (this.mVolumeType != 2) goto L7;
            VolumeProviderCompat r5 = this.mVolumeProvider;
            if (r5 == null) goto L9;
            r5.onAdjustVolume(r3);
            return;
        L9:
            return;
        L7:
            this.mAudioManager.adjustStreamVolume(this.mLocalStream, r3, r4);
        }

        public void registerMediaButtonEventReceiver(PendingIntent r1, ComponentName r2) {
            this.mAudioManager.registerMediaButtonEventReceiver(r2);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void sendSessionEvent(String r1, Bundle r2) {
            sendEvent(r1, r2);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setCallback(Callback r3, Handler r4) {
            this.mCallback = r3;
            if (r3 == null) goto L17;
            if (r4 != null) goto L6;
            r4 = new Handler();
        L6:
            Object r5 = this.mLock;
            monitor-enter(r5);
            MessageHandler r0 = this.mHandler;     // Catch: Throwable -> L14
            if (r0 == null) goto L11;
            r0.removeCallbacksAndMessages(null);     // Catch: Throwable -> L14
        L11:
            this.mHandler = new MessageHandler(this, r4.getLooper());     // Catch: Throwable -> L14
            this.mCallback.setSessionImpl(this, r4);     // Catch: Throwable -> L14
            monitor-exit(r5);     // Catch: Throwable -> L14
            return;
        L14:
            th = move-exception;
            throw th;
        }

        public void setVolumeTo(int r3, int r4) {
            if (this.mVolumeType != 2) goto L7;
            VolumeProviderCompat r5 = this.mVolumeProvider;
            if (r5 == null) goto L9;
            r5.onSetVolumeTo(r3);
            return;
        L9:
            return;
        L7:
            this.mAudioManager.setStreamVolume(this.mLocalStream, r3, r4);
        }

        public void unregisterMediaButtonEventReceiver(PendingIntent r1, ComponentName r2) {
            this.mAudioManager.unregisterMediaButtonEventReceiver(r2);
        }

        public MediaSessionImplBase(Context r3, String r4, ComponentName r5, PendingIntent r6) {
            this.mLock = new Object();
            this.mControllerCallbacks = new RemoteCallbackList();
            this.mDestroyed = false;
            this.mIsActive = false;
            this.mIsMbrRegistered = false;
            this.mIsRccRegistered = false;
            this.mVolumeCallback = new AnonymousClass1(this);
            if (r5 == null) goto L7;
            this.mContext = r3;
            this.mPackageName = r3.getPackageName();
            this.mAudioManager = (AudioManager) r3.getSystemService("audio");
            this.mTag = r4;
            this.mMediaButtonReceiverComponentName = r5;
            this.mMediaButtonReceiverIntent = r6;
            MediaSessionStub r7 = new MediaSessionStub(this);
            this.mStub = r7;
            this.mToken = new Token(r7);
            this.mRatingType = 0;
            this.mVolumeType = 1;
            this.mLocalStream = 3;
            this.mRcc = new RemoteControlClient(r6);
            return;
        L7:
            throw new IllegalArgumentException("MediaButtonReceiver component may not be null.");
        }

        public void postToHandler(int r3, int r4, int r5, Object r6, Bundle r7) {
            Object r0 = this.mLock;
            monitor-enter(r0);
            MessageHandler r1 = this.mHandler;     // Catch: Throwable -> L12
            if (r1 == null) goto L10;
            Message r8 = r1.obtainMessage(r3, r4, r5, r6);     // Catch: Throwable -> L12
            Bundle r9 = new Bundle();     // Catch: Throwable -> L12
            r9.putString(MediaSessionCompat.DATA_CALLING_PACKAGE, "android.media.session.MediaController");     // Catch: Throwable -> L12
            r9.putInt(MediaSessionCompat.DATA_CALLING_PID, Binder.getCallingPid());     // Catch: Throwable -> L12
            r9.putInt(MediaSessionCompat.DATA_CALLING_UID, Binder.getCallingUid());     // Catch: Throwable -> L12
            if (r7 == null) goto L9;
            r9.putBundle(MediaSessionCompat.DATA_EXTRAS, r7);     // Catch: Throwable -> L12
        L9:
            r8.setData(r9);     // Catch: Throwable -> L12
            r8.sendToTarget();     // Catch: Throwable -> L12
        L10:
            monitor-exit(r0);     // Catch: Throwable -> L12
            return;
        L12:
            th = move-exception;
            throw th;
        }
    }

    public interface OnActiveChangeListener {
        void onActiveChanged();
    }

    public static final class QueueItem implements Parcelable {
        public static final Parcelable.Creator<QueueItem> CREATOR = null;
        public static final int UNKNOWN_ID = -1;
        private final MediaDescriptionCompat mDescription;
        private final long mId;
        private Object mItem;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        static {
            CREATOR = new AnonymousClass1();
        }

        public Object getQueueItem() {
            Object r0 = this.mItem;
            if (r0 != null) goto L6;
            Object r1 = MediaSessionCompatApi21.QueueItem.createItem(this.mDescription.getMediaDescription(), this.mId);
            this.mItem = r1;
            return r1;
        L6:
            return r0;
        }

        public String toString() {
            return "MediaSession.QueueItem {Description=" + this.mDescription + ", Id=" + this.mId + " }";
        }

        public MediaDescriptionCompat getDescription() {
            return this.mDescription;
        }

        public long getQueueId() {
            return this.mId;
        }

        public QueueItem(Parcel r3) {
            this.mDescription = MediaDescriptionCompat.CREATOR.createFromParcel(r3);
            this.mId = r3.readLong();
        }

        public static QueueItem fromQueueItem(Object r4) {
            if (r4 != null) goto L4;
            return null;
        L4:
            return new QueueItem(r4, MediaDescriptionCompat.fromMediaDescription(MediaSessionCompatApi21.QueueItem.getDescription(r4)), MediaSessionCompatApi21.QueueItem.getQueueId(r4));
        }

        public static List<QueueItem> fromQueueItemList(List<?> r2) {
            if (r2 == null) goto L8;
            ArrayList r0 = new ArrayList();
            Iterator<?> r3 = r2.iterator();
        L5:
            if (r3.hasNext() == false) goto L7;
            r0.add(fromQueueItem(r3.next()));
            goto L5
        L7:
            return r0;
        L8:
            return null;
        }

        public QueueItem(MediaDescriptionCompat r2, long r3) {
            this(null, r2, r3);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r3, int r4) {
            this.mDescription.writeToParcel(r3, r4);
            r3.writeLong(this.mId);
        }

        private QueueItem(Object r4, MediaDescriptionCompat r5, long r6) {
            if (r5 == null) goto L11;
            if (r6 == (-1)) goto L9;
            this.mDescription = r5;
            this.mId = r6;
            this.mItem = r4;
            return;
        L9:
            throw new IllegalArgumentException("Id cannot be QueueItem.UNKNOWN_ID");
        L11:
            throw new IllegalArgumentException("Description cannot be null.");
        }
    }

    public static final class ResultReceiverWrapper implements Parcelable {
        public static final Parcelable.Creator<ResultReceiverWrapper> CREATOR = null;
        ResultReceiver mResultReceiver;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        static {
            CREATOR = new AnonymousClass1();
        }

        public ResultReceiverWrapper(Parcel r2) {
            this.mResultReceiver = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(r2);
        }

        public ResultReceiverWrapper(ResultReceiver r1) {
            this.mResultReceiver = r1;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r2, int r3) {
            this.mResultReceiver.writeToParcel(r2, r3);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface SessionFlags {
    }

    public static final class Token implements Parcelable {
        public static final Parcelable.Creator<Token> CREATOR = null;
        private IMediaSession mExtraBinder;
        private final Object mInner;
        private Bundle mSessionToken2Bundle;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        static {
            CREATOR = new AnonymousClass1();
        }

        public int hashCode() {
            Object r0 = this.mInner;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.hashCode();
        }

        public Bundle toBundle() {
            Bundle r0 = new Bundle();
            r0.putParcelable(MediaSessionCompat.KEY_TOKEN, this);
            IMediaSession r1 = this.mExtraBinder;
            if (r1 == null) goto L5;
            BundleCompat.putBinder(r0, MediaSessionCompat.KEY_EXTRA_BINDER, r1.asBinder());
        L5:
            Bundle r2 = this.mSessionToken2Bundle;
            if (r2 == null) goto L8;
            r0.putBundle(MediaSessionCompat.KEY_SESSION_TOKEN2_BUNDLE, r2);
        L8:
            return r0;
        }

        public IMediaSession getExtraBinder() {
            return this.mExtraBinder;
        }

        public Bundle getSessionToken2Bundle() {
            return this.mSessionToken2Bundle;
        }

        public Object getToken() {
            return this.mInner;
        }

        public Token(Object r2) {
            this(r2, null, null);
        }

        public static Token fromBundle(Bundle r4) {
            if (r4 != null) goto L5;
            return null;
        L5:
            IMediaSession r1 = IMediaSession.Stub.asInterface(BundleCompat.getBinder(r4, MediaSessionCompat.KEY_EXTRA_BINDER));
            Bundle r2 = r4.getBundle(MediaSessionCompat.KEY_SESSION_TOKEN2_BUNDLE);
            Token r5 = (Token) r4.getParcelable(MediaSessionCompat.KEY_TOKEN);
            if (r5 != null) goto L9;
            return null;
        L9:
            return new Token(r5.mInner, r1, r2);
        }

        public static Token fromToken(Object r1) {
            return fromToken(r1, null);
        }

        public boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof Token) == true) goto L8;
            return false;
        L8:
            Token r5 = (Token) r4;
            Object r1 = this.mInner;
            if (r1 == null) goto L11;
            Object r6 = r5.mInner;
            if (r6 != null) goto L19;
            return false;
        L19:
            return r1.equals(r6);
        L11:
            if (r5.mInner == null) goto L20;
            return false;
        L20:
            return true;
        }

        public void setExtraBinder(IMediaSession r1) {
            this.mExtraBinder = r1;
        }

        public void setSessionToken2Bundle(Bundle r1) {
            this.mSessionToken2Bundle = r1;
        }

        public Token(Object r2, IMediaSession r3) {
            this(r2, r3, null);
        }

        public static Token fromToken(Object r1, IMediaSession r2) {
            if (r1 != null) goto L4;
            return null;
        L4:
            return new Token(MediaSessionCompatApi21.verifyToken(r1), r2);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r2, int r3) {
            r2.writeParcelable((Parcelable) this.mInner, r3);
        }

        public Token(Object r1, IMediaSession r2, Bundle r3) {
            this.mInner = r1;
            this.mExtraBinder = r2;
            this.mSessionToken2Bundle = r3;
        }
    }

    public String getCallingPackage() {
        return this.mImpl.getCallingPackage();
    }

    public final MediaSessionManager.RemoteUserInfo getCurrentControllerInfo() {
        return this.mImpl.getCurrentControllerInfo();
    }

    public Object getMediaSession() {
        return this.mImpl.getMediaSession();
    }

    public Object getRemoteControlClient() {
        return this.mImpl.getRemoteControlClient();
    }

    public Token getSessionToken() {
        return this.mImpl.getSessionToken();
    }

    public boolean isActive() {
        return this.mImpl.isActive();
    }

    public void release() {
        this.mImpl.release();
    }

    public MediaControllerCompat getController() {
        return this.mController;
    }

    public static DisplayMetrics INVOKEVIRTUAL_android_support_v4_media_session_MediaSessionCompat_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r1) {
        return WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
    }

    public static void ensureClassLoader(Bundle r1) {
        if (r1 == null) goto L5;
        r1.setClassLoader(MediaSessionCompat.class.getClassLoader());
        return;
    }

    public void addOnActiveChangeListener(OnActiveChangeListener r2) {
        if (r2 == null) goto L6;
        this.mActiveListeners.add(r2);
        return;
    L6:
        throw new IllegalArgumentException("Listener may not be null");
    }

    public void removeOnActiveChangeListener(OnActiveChangeListener r2) {
        if (r2 == null) goto L6;
        this.mActiveListeners.remove(r2);
        return;
    L6:
        throw new IllegalArgumentException("Listener may not be null");
    }

    public void setActive(boolean r2) {
        this.mImpl.setActive(r2);
        Iterator<OnActiveChangeListener> r3 = this.mActiveListeners.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        r3.next().onActiveChanged();
        goto L4
    }

    public void setCallback(Callback r2) {
        setCallback(r2, null);
    }

    public void setCaptioningEnabled(boolean r2) {
        this.mImpl.setCaptioningEnabled(r2);
    }

    public void setExtras(Bundle r2) {
        this.mImpl.setExtras(r2);
    }

    public void setFlags(int r2) {
        this.mImpl.setFlags(r2);
    }

    public void setMediaButtonReceiver(PendingIntent r2) {
        this.mImpl.setMediaButtonReceiver(r2);
    }

    public void setMetadata(MediaMetadataCompat r2) {
        this.mImpl.setMetadata(r2);
    }

    public void setPlaybackState(PlaybackStateCompat r2) {
        this.mImpl.setPlaybackState(r2);
    }

    public void setPlaybackToLocal(int r2) {
        this.mImpl.setPlaybackToLocal(r2);
    }

    public void setPlaybackToRemote(VolumeProviderCompat r2) {
        if (r2 == null) goto L6;
        this.mImpl.setPlaybackToRemote(r2);
        return;
    L6:
        throw new IllegalArgumentException("volumeProvider may not be null!");
    }

    public void setQueue(List<QueueItem> r2) {
        this.mImpl.setQueue(r2);
    }

    public void setQueueTitle(CharSequence r2) {
        this.mImpl.setQueueTitle(r2);
    }

    public void setRatingType(int r2) {
        this.mImpl.setRatingType(r2);
    }

    public void setRepeatMode(int r2) {
        this.mImpl.setRepeatMode(r2);
    }

    public void setSessionActivity(PendingIntent r2) {
        this.mImpl.setSessionActivity(r2);
    }

    public void setShuffleMode(int r2) {
        this.mImpl.setShuffleMode(r2);
    }

    private MediaSessionCompat(Context r2, MediaSessionImpl r3) {
        this.mActiveListeners = new ArrayList();
        this.mImpl = r3;
        if (MediaSessionCompatApi21.hasCallback(r3.getMediaSession()) == true) goto L5;
        setCallback(new AnonymousClass3(this));
    L5:
        this.mController = new MediaControllerCompat(r2, this);
    }

    public static MediaSessionCompat fromMediaSession(Context r2, Object r3) {
        if (r2 == null) goto L6;
        if (r3 != null) goto L5;
        return null;
    L5:
        return new MediaSessionCompat(r2, new MediaSessionImplApi21(r3));
    L6:
        return null;
    }

    public static PlaybackStateCompat getStateWithUpdatedPosition(PlaybackStateCompat r14, MediaMetadataCompat r15) {
        if (r14 == null) goto L30;
        long r2 = -1;
        if (r14.getPosition() != (-1)) goto L7;
        return r14;
    L7:
        if (r14.getState() != 3) goto L9;
    L12:
        long r0 = r14.getLastPositionUpdateTime();
        if (r0 <= 0) goto L32;
        long r12 = SystemClock.elapsedRealtime();
        long r1 = ((long) (r14.getPlaybackSpeed() * (r12 - r0))) + r14.getPosition();
        if (r15 == null) goto L20;
        if (r15.containsKey(MediaMetadataCompat.METADATA_KEY_DURATION) == false) goto L20;
        r2 = r15.getLong(MediaMetadataCompat.METADATA_KEY_DURATION);
    L20:
        if (r2 < 0) goto L25;
        if (r1 <= r2) goto L25;
        long r9 = r2;
    L29:
        return new PlaybackStateCompat.Builder(r14).setState(r14.getState(), r9, r14.getPlaybackSpeed(), r12).build();
    L25:
        if (r1 >= 0) goto L27;
        r9 = 0;
        goto L29
    L27:
        r9 = r1;
        goto L29
    L32:
        return r14;
    L9:
        if (r14.getState() == 4) goto L12;
        if (r14.getState() == 5) goto L12;
        return r14;
    L30:
        return r14;
    }

    public void sendSessionEvent(String r2, Bundle r3) {
        if (TextUtils.isEmpty(r2) == true) goto L7;
        this.mImpl.sendSessionEvent(r2, r3);
        return;
    L7:
        throw new IllegalArgumentException("event cannot be null or empty");
    }

    public void setCallback(Callback r2, Handler r3) {
        if (r2 != null) goto L4;
        this.mImpl.setCallback(null, null);
        return;
    L4:
        MediaSessionImpl r0 = this.mImpl;
        if (r3 != null) goto L8;
        r3 = new Handler();
    L8:
        r0.setCallback(r2, r3);
    }

    public MediaSessionCompat(Context r2, String r3) {
        this(r2, r3, null, null);
    }

    public MediaSessionCompat(Context r7, String r8, Bundle r9) {
        this(r7, r8, null, null, r9);
    }

    public MediaSessionCompat(Context r7, String r8, ComponentName r9, PendingIntent r10) {
        this(r7, r8, r9, r10, null);
    }

    private MediaSessionCompat(Context r2, String r3, ComponentName r4, PendingIntent r5, Bundle r6) {
        this.mActiveListeners = new ArrayList();
        if (r2 == null) goto L22;
        if (TextUtils.isEmpty(r3) == true) goto L20;
        if (r4 != null) goto L8;
        r4 = MediaButtonReceiver.getMediaButtonReceiverComponent(r2);
    L8:
        if (r4 == null) goto L12;
        if (r5 != null) goto L12;
        Intent r7 = new Intent("android.intent.action.MEDIA_BUTTON");
        r7.setComponent(r4);
        r5 = PendingIntent.getBroadcast(r2, 0, r7, 0);
    L12:
        if (Build.VERSION.SDK_INT < 28) goto L14;
        MediaSessionImplApi28 r8 = new MediaSessionImplApi28(r2, r3, r6);
        this.mImpl = r8;
        setCallback(new AnonymousClass1(this));
        r8.setMediaButtonReceiver(r5);
    L15:
        this.mController = new MediaControllerCompat(r2, this);
        if (sMaxBitmapSize != 0) goto L23;
        sMaxBitmapSize = (int) (TypedValue.applyDimension(1, 320.0f, INVOKEVIRTUAL_android_support_v4_media_session_MediaSessionCompat_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r2.getResources())) + 0.5f);
        return;
    L23:
        return;
    L14:
        MediaSessionImplApi21 r9 = new MediaSessionImplApi21(r2, r3, r6);
        this.mImpl = r9;
        setCallback(new AnonymousClass2(this));
        r9.setMediaButtonReceiver(r5);
        goto L15
    L20:
        throw new IllegalArgumentException("tag must not be null or empty");
    L22:
        throw new IllegalArgumentException("context must not be null");
    }
}
