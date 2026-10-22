package android.support.v4.media.session;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.AudioAttributes;
import android.media.MediaDescription;
import android.media.MediaMetadata;
import android.media.Rating;
import android.media.VolumeProvider;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.os.ResultReceiver;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
class MediaSessionCompatApi21 {
    static final String TAG = "MediaSessionCompatApi21";

    public interface Callback {
        void onCommand(String r1, Bundle r2, ResultReceiver r3);

        void onCustomAction(String r1, Bundle r2);

        void onFastForward();

        boolean onMediaButtonEvent(Intent r1);

        void onPause();

        void onPlay();

        void onPlayFromMediaId(String r1, Bundle r2);

        void onPlayFromSearch(String r1, Bundle r2);

        void onRewind();

        void onSeekTo(long r1);

        void onSetRating(Object r1);

        void onSetRating(Object r1, Bundle r2);

        void onSkipToNext();

        void onSkipToPrevious();

        void onSkipToQueueItem(long r1);

        void onStop();
    }

    public static class CallbackProxy<T extends Callback> extends MediaSession.Callback {
        protected final T mCallback;

        @Override // android.media.session.MediaSession.Callback
        public void onFastForward() {
            this.mCallback.onFastForward();
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPause() {
            this.mCallback.onPause();
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPlay() {
            this.mCallback.onPlay();
        }

        @Override // android.media.session.MediaSession.Callback
        public void onRewind() {
            this.mCallback.onRewind();
        }

        @Override // android.media.session.MediaSession.Callback
        public void onSkipToNext() {
            this.mCallback.onSkipToNext();
        }

        @Override // android.media.session.MediaSession.Callback
        public void onSkipToPrevious() {
            this.mCallback.onSkipToPrevious();
        }

        @Override // android.media.session.MediaSession.Callback
        public void onStop() {
            this.mCallback.onStop();
        }

        public CallbackProxy(T r1) {
            this.mCallback = r1;
        }

        @Override // android.media.session.MediaSession.Callback
        public boolean onMediaButtonEvent(Intent r2) {
            if (this.mCallback.onMediaButtonEvent(r2) == false) goto L5;
        L8:
            return true;
        L5:
            if (super.onMediaButtonEvent(r2) == true) goto L8;
            return false;
        }

        @Override // android.media.session.MediaSession.Callback
        public void onSeekTo(long r2) {
            this.mCallback.onSeekTo(r2);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onSetRating(Rating r2) {
            this.mCallback.onSetRating(r2);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onSkipToQueueItem(long r2) {
            this.mCallback.onSkipToQueueItem(r2);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onCustomAction(String r2, Bundle r3) {
            MediaSessionCompat.ensureClassLoader(r3);
            this.mCallback.onCustomAction(r2, r3);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPlayFromMediaId(String r2, Bundle r3) {
            MediaSessionCompat.ensureClassLoader(r3);
            this.mCallback.onPlayFromMediaId(r2, r3);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPlayFromSearch(String r2, Bundle r3) {
            MediaSessionCompat.ensureClassLoader(r3);
            this.mCallback.onPlayFromSearch(r2, r3);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onCommand(String r2, Bundle r3, ResultReceiver r4) {
            MediaSessionCompat.ensureClassLoader(r3);
            this.mCallback.onCommand(r2, r3, r4);
        }
    }

    public static class QueueItem {
        private QueueItem() {
        }

        public static Object getDescription(Object r0) {
            return ((MediaSession.QueueItem) r0).getDescription();
        }

        public static long getQueueId(Object r2) {
            return ((MediaSession.QueueItem) r2).getQueueId();
        }

        public static Object createItem(Object r1, long r2) {
            return new MediaSession.QueueItem((MediaDescription) r1, r2);
        }
    }

    private MediaSessionCompatApi21() {
    }

    public static Object createCallback(Callback r1) {
        return new CallbackProxy(r1);
    }

    public static Parcelable getSessionToken(Object r0) {
        return ((MediaSession) r0).getSessionToken();
    }

    public static boolean hasCallback(Object r3) {
        Field r1 = r3.getClass().getDeclaredField("mCallback");     // Catch: Throwable -> L9
        if (r1 == null) goto L12;
        r1.setAccessible(true);     // Catch: Throwable -> L9
        if (r1.get(r3) == null) goto L13;
        return true;
    L13:
        return false;
    L12:
        return false;
    L14:
        return false;
    }

    public static boolean isActive(Object r0) {
        return ((MediaSession) r0).isActive();
    }

    public static void release(Object r0) {
        ((MediaSession) r0).release();
    }

    public static Object verifySession(Object r1) {
        if ((r1 instanceof MediaSession) == false) goto L6;
        return r1;
    L6:
        throw new IllegalArgumentException("mediaSession is not a valid MediaSession object");
    }

    public static Object verifyToken(Object r1) {
        if ((r1 instanceof MediaSession.Token) == false) goto L6;
        return r1;
    L6:
        throw new IllegalArgumentException("token is not a valid MediaSession.Token object");
    }

    public static Object createSession(Context r1, String r2) {
        return new MediaSession(r1, r2);
    }

    public static void setActive(Object r0, boolean r1) {
        ((MediaSession) r0).setActive(r1);
    }

    public static void setExtras(Object r0, Bundle r1) {
        ((MediaSession) r0).setExtras(r1);
    }

    public static void setFlags(Object r0, int r1) {
        ((MediaSession) r0).setFlags(r1);
    }

    public static void setMediaButtonReceiver(Object r0, PendingIntent r1) {
        ((MediaSession) r0).setMediaButtonReceiver(r1);
    }

    public static void setMetadata(Object r0, Object r1) {
        ((MediaSession) r0).setMetadata((MediaMetadata) r1);
    }

    public static void setPlaybackState(Object r0, Object r1) {
        ((MediaSession) r0).setPlaybackState((PlaybackState) r1);
    }

    public static void setPlaybackToLocal(Object r1, int r2) {
        AudioAttributes.Builder r0 = new AudioAttributes.Builder();
        r0.setLegacyStreamType(r2);
        ((MediaSession) r1).setPlaybackToLocal(r0.build());
    }

    public static void setPlaybackToRemote(Object r0, Object r1) {
        ((MediaSession) r0).setPlaybackToRemote((VolumeProvider) r1);
    }

    public static void setQueue(Object r2, List<Object> r3) {
        if (r3 != null) goto L5;
        ((MediaSession) r2).setQueue(null);
        return;
    L5:
        ArrayList r0 = new ArrayList();
        Iterator<Object> r4 = r3.iterator();
    L7:
        if (r4.hasNext() == false) goto L9;
        r0.add((MediaSession.QueueItem) r4.next());
        goto L7
    L9:
        ((MediaSession) r2).setQueue(r0);
    }

    public static void setQueueTitle(Object r0, CharSequence r1) {
        ((MediaSession) r0).setQueueTitle(r1);
    }

    public static void setSessionActivity(Object r0, PendingIntent r1) {
        ((MediaSession) r0).setSessionActivity(r1);
    }

    public static void sendSessionEvent(Object r0, String r1, Bundle r2) {
        ((MediaSession) r0).sendSessionEvent(r1, r2);
    }

    public static void setCallback(Object r0, Object r1, Handler r2) {
        ((MediaSession) r0).setCallback((MediaSession.Callback) r1, r2);
    }
}
