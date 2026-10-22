package kotlinx.coroutines.internal;

import java.util.Iterator;
import java.util.List;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class t {
    public static final MainCoroutineDispatcher a = null;

    static {
        int r1 = d0.a;
        MainCoroutineDispatcher r2 = null;
        String r0 = System.getProperty("kotlinx.coroutines.fast.service.loader");     // Catch: SecurityException -> L5
    L6:
        if (r0 == null) goto L34;
        Boolean.parseBoolean(r0);
    L34:
        List<? extends r> r3 = SequencesKt.toList(SequencesKt.asSequence(s.a()));     // Catch: Throwable -> L30
        Iterator r4 = r3.iterator();     // Catch: Throwable -> L30
        if (r4.hasNext() == true) goto L11;
        Object r5 = null;
    L20:
        r r6 = (r) r5;     // Catch: Throwable -> L30
        if (r6 == null) goto L29;
        r2 = r6.a(r3);     // Catch: Throwable -> L24
    L25:
        if (r2 == null) goto L29;
        a = r2;
        return;
    L24:
        r6.c();     // Catch: Throwable -> L30
    L29:
        throw new IllegalStateException("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'");     // Catch: Throwable -> L30
    L11:
        r5 = r4.next();     // Catch: Throwable -> L30
        if (r4.hasNext() == false) goto L20;
        int r7 = ((r) r5).b();     // Catch: Throwable -> L30
    L15:
        Object r8 = r4.next();     // Catch: Throwable -> L30
        int r9 = ((r) r8).b();     // Catch: Throwable -> L30
        if (r7 >= r9) goto L19;
        r5 = r8;
        r7 = r9;
    L19:
        if (r4.hasNext() == true) goto L15;
    L30:
        th = move-exception;
        throw th;
    L5:
        r0 = null;
        goto L6
    }
}
