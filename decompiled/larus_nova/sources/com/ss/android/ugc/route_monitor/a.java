package com.ss.android.ugc.route_monitor;

import com.ss.android.ugc.route_monitor.utils.Logger;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.zip.Inflater;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes40.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f454385a = 0;

    static {
    }

    @JvmStatic
    public static final String a(byte[] r100) {
        Inflater r101 = new Inflater();
        r101.reset();
        r101.setInput(r100, 0, r100.length);
        ByteArrayOutputStream r102 = new ByteArrayOutputStream(r100.length);
        byte[] r103 = new byte[1024];     // Catch: Throwable -> L12 Exception -> L14
    L5:
        if (r101.finished() == true) goto L7;
        r102.write(r103, 0, r101.inflate(r103));     // Catch: Throwable -> L12 Exception -> L14
        goto L5
    L7:
        r100 = r102.toByteArray();     // Catch: Throwable -> L12 Exception -> L14
    L27:
        r102.close();     // Catch: IOException -> L10
    L18:
        r101.end();
        return new String(r100, Charset.forName("UTF-8"));
    L10:
        e = move-exception;
        Logger.f454747c.d(e);
        goto L18
    L14:
        e = move-exception;
        Logger.f454747c.d(e);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        r102.close();     // Catch: IOException -> L22
    L24:
        throw th;
    L22:
        e = move-exception;
        Logger.f454747c.d(e);
        goto L24
    }
}
