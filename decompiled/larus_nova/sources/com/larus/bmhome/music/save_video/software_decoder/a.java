package com.larus.bmhome.music.save_video.software_decoder;

import android.media.MediaExtractor;
import android.media.MediaMuxer;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f313149a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f313150b;

    static {
    }

    public a() {
    }

    public static final void a(MediaExtractor r100, MediaExtractor r101, MediaMuxer r102) {
        if (r102 != null) goto L11;
    L4:
        if (r102 == null) goto L6;
        r102.release();     // Catch: Exception -> L10
    L6:
        r100.release();     // Catch: Exception -> L10
        if (r101 == null) goto L13;
        r101.release();     // Catch: Exception -> L10
        return;
    L14:
        return;
    L13:
        return;
    L11:
        r102.stop();     // Catch: Exception -> L10
        goto L4
    }
}
