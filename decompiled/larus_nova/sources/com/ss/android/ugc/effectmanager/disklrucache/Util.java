package com.ss.android.ugc.effectmanager.disklrucache;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes40.dex */
final class Util {
    static final Charset US_ASCII = null;
    static final Charset UTF_8 = null;

    static {
        US_ASCII = Charset.forName("US-ASCII");
        UTF_8 = Charset.forName("UTF-8");
    }

    private Util() {
    }

    public static void closeQuietly(Closeable r100) {
        if (r100 != null) goto L9;
        return;
    L9:
        r100.close();     // Catch: RuntimeException -> L5 Exception -> L8
        goto L12
    L11:
        return;
    L5:
        e = move-exception;
        throw e;
    }

    public static void deleteContents(File r100) throws IOException {
        File[] r101 = r100.listFiles();
        if (r101 == null) goto L16;
        int r102 = r101.length;
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L14;
        File r104 = r101[r103];
        if (r104.isDirectory() == false) goto L10;
        deleteContents(r104);
    L10:
        if (r104.delete() == false) goto L13;
        r103 = r103 + 1;
        goto L5
    L13:
        throw new IOException("failed to delete file: " + r104);
    L14:
        return;
    L16:
        throw new IOException("not a readable directory: " + r100);
    }

    public static String readFully(Reader r100) throws IOException {
        StringWriter r101 = new StringWriter();     // Catch: Throwable -> L9
        char[] r102 = new char[1024];     // Catch: Throwable -> L9
    L3:
        int r103 = r100.read(r102);     // Catch: Throwable -> L9
        if (r103 == (-1)) goto L6;
        r101.write(r102, 0, r103);     // Catch: Throwable -> L9
        goto L3
    L6:
        String r104 = r101.toString();     // Catch: Throwable -> L9
        r100.close();
        return r104;
    L9:
        th = move-exception;
        r100.close();
        throw th;
    }
}
