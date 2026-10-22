package android.support.v4.media.session;

import android.media.session.MediaController;
import android.net.Uri;
import android.os.Bundle;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
class MediaControllerCompatApi23 {

    public static class TransportControls {
        private TransportControls() {
        }

        public static void playFromUri(Object r0, Uri r1, Bundle r2) {
            ((MediaController.TransportControls) r0).playFromUri(r1, r2);
        }
    }

    private MediaControllerCompatApi23() {
    }
}
