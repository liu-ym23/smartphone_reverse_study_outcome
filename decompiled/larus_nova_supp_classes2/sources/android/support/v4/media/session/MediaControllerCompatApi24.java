package android.support.v4.media.session;

import android.media.session.MediaController;
import android.net.Uri;
import android.os.Bundle;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
class MediaControllerCompatApi24 {

    public static class TransportControls {
        private TransportControls() {
        }

        public static void prepare(Object r0) {
            ((MediaController.TransportControls) r0).prepare();
        }

        public static void prepareFromMediaId(Object r0, String r1, Bundle r2) {
            ((MediaController.TransportControls) r0).prepareFromMediaId(r1, r2);
        }

        public static void prepareFromSearch(Object r0, String r1, Bundle r2) {
            ((MediaController.TransportControls) r0).prepareFromSearch(r1, r2);
        }

        public static void prepareFromUri(Object r0, Uri r1, Bundle r2) {
            ((MediaController.TransportControls) r0).prepareFromUri(r1, r2);
        }
    }

    private MediaControllerCompatApi24() {
    }
}
