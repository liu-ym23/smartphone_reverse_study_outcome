package qx6;

import java.util.Iterator;
import kotlin.Result;
import kotlin.ResultKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f535150a = null;

    static {
        f535150a = new p();
    }

    public p() {
    }

    public static String a(String r100, String r101) {
        boolean r102 = true;
        if (r100 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L11;
        return r101;
    L11:
        if (r101 != null) goto L13;
    L16:
        if (r102 == false) goto L34;
        return r100;
    L34:
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L24
        JSONObject r105 = new JSONObject(r100);     // Catch: Throwable -> L24
        Iterator<String> r106 = r105.keys();     // Catch: Throwable -> L24
        JSONObject r107 = new JSONObject(r101);     // Catch: Throwable -> L24
    L20:
        if (r106.hasNext() == false) goto L22;
        String r108 = r106.next();     // Catch: Throwable -> L24
        r107.put(r108, r105.opt(r108));     // Catch: Throwable -> L24
        goto L20
    L22:
        Object r109 = Result.m9449constructorimpl(r107.toString());     // Catch: Throwable -> L24
    L27:
        if (Result.m9455isFailureimpl(r109) == false) goto L29;
        r109 = null;
    L29:
        String r110 = (String) r109;
        if (r110 != null) goto L33;
        return r100;
    L33:
        return r110;
    L24:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L27
    L13:
        if (r101.length() == 0) goto L16;
        r102 = false;
        goto L16
    L5:
        if (r100.length() == 0) goto L8;
        r103 = false;
        goto L9
    }
}
