package android.support.v4.media.session;

import android.media.session.MediaSession;
import android.net.Uri;
import android.os.Bundle;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
class MediaSessionCompatApi24 {
    private static final String TAG = "MediaSessionCompatApi24";

    public interface Callback extends MediaSessionCompatApi23.Callback {
        void onPrepare();

        void onPrepareFromMediaId(String r1, Bundle r2);

        void onPrepareFromSearch(String r1, Bundle r2);

        void onPrepareFromUri(Uri r1, Bundle r2);
    }

    public static class CallbackProxy<T extends Callback> extends MediaSessionCompatApi23.CallbackProxy<T> {
        @Override // android.media.session.MediaSession.Callback
        public void onPrepare() {
            ((Callback) this.mCallback).onPrepare();
        }

        public CallbackProxy(T r1) {
            super(r1);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPrepareFromMediaId(String r2, Bundle r3) {
            MediaSessionCompat.ensureClassLoader(r3);
            ((Callback) this.mCallback).onPrepareFromMediaId(r2, r3);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPrepareFromSearch(String r2, Bundle r3) {
            MediaSessionCompat.ensureClassLoader(r3);
            ((Callback) this.mCallback).onPrepareFromSearch(r2, r3);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPrepareFromUri(Uri r2, Bundle r3) {
            MediaSessionCompat.ensureClassLoader(r3);
            ((Callback) this.mCallback).onPrepareFromUri(r2, r3);
        }
    }

    private MediaSessionCompatApi24() {
    }

    public static Object createCallback(Callback r1) {
        return new CallbackProxy(r1);
    }

    public static String getCallingPackage(Object r4) {
        MediaSession r5 = (MediaSession) r4;
        return (String) r5.getClass().getMethod("getCallingPackage", new Class[0]).invoke(r5, new Object[0]);
    L5:
        return null;
    }
}
