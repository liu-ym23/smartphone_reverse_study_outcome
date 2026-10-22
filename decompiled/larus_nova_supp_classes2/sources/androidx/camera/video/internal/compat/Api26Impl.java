package androidx.camera.video.internal.compat;

import android.media.MediaMuxer;
import java.io.FileDescriptor;
import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class Api26Impl {
    private Api26Impl() {
    }

    public static MediaMuxer createMediaMuxer(FileDescriptor r1, int r2) throws IOException {
        return new MediaMuxer(r1, r2);
    }
}
