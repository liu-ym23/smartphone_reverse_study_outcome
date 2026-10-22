package nv7;

import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;

/* JADX INFO: loaded from: classes23.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Charset f520919a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Charset f520920b = null;

    static {
        f520919a = Charset.defaultCharset();
        f520920b = Charset.forName("SJIS");
        Charset.forName("GB2312");     // Catch: UnsupportedCharsetException -> L5
    L6:
        Charset r100 = Charset.forName("EUC_JP");
        Charset r101 = f520920b;
        Charset r102 = f520919a;
        if (r101.equals(r102) == true) goto L12;
        r100.equals(r102);
        return;
    }
}
