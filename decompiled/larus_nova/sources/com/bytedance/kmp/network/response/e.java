package com.bytedance.kmp.network.response;

import android.support.v4.media.session.PlaybackStateCompat;
import kotlin.jvm.internal.Ref;
import okio.Buffer;
import okio.Source;

/* JADX INFO: loaded from: classes19.dex */
public abstract class e {
    public e() {
    }

    public abstract Buffer a();

    public final String c() {
        Buffer r100 = b(a());
        if (r100 != null) goto L12;
        return null;
    L12:
        String r101 = r100.readUtf8();     // Catch: Throwable -> L9
        r100.close();
        return r101;
    L9:
        th = move-exception;
        r100.close();
        throw th;
    }

    public static Buffer b(Source r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        Buffer r101 = new Buffer();
        Buffer r102 = new Buffer();
        Ref.LongRef r103 = new Ref.LongRef();     // Catch: Throwable -> L13 Exception -> L15
    L7:
        long r104 = r100.read(r102, PlaybackStateCompat.ACTION_PLAY_FROM_URI);     // Catch: Throwable -> L13 Exception -> L15
        r103.element = r104;     // Catch: Throwable -> L13 Exception -> L15
        if (r104 == (-1)) goto L10;
        r101.write(r102, r104);     // Catch: Throwable -> L13 Exception -> L15
        goto L7
    L10:
        r101.flush();     // Catch: Throwable -> L13 Exception -> L15
        r100.close();
        r102.close();
        return r101;
    L15:
        e = move-exception;
        r101.close();     // Catch: Throwable -> L13
        throw e;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        r100.close();
        r102.close();
        throw th;
    }
}
