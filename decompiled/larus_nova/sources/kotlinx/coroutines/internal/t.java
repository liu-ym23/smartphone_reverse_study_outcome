package kotlinx.coroutines.internal;

import java.util.Iterator;
import java.util.List;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: classes.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MainCoroutineDispatcher f504980a = null;

    static {
        int r100 = d0.f504940a;
        MainCoroutineDispatcher r101 = null;
        String r102 = System.getProperty("kotlinx.coroutines.fast.service.loader");     // Catch: SecurityException -> L5
    L6:
        if (r102 == null) goto L34;
        Boolean.parseBoolean(r102);
    L34:
        List<? extends r> r103 = SequencesKt.toList(SequencesKt.asSequence(s.a()));     // Catch: Throwable -> L30
        Iterator r104 = r103.iterator();     // Catch: Throwable -> L30
        if (r104.hasNext() == true) goto L11;
        Object r105 = null;
    L20:
        r r106 = (r) r105;     // Catch: Throwable -> L30
        if (r106 == null) goto L29;
        r101 = r106.a(r103);     // Catch: Throwable -> L24
    L25:
        if (r101 == null) goto L29;
        f504980a = r101;
        return;
    L24:
        r106.c();     // Catch: Throwable -> L30
    L29:
        throw new IllegalStateException("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'");     // Catch: Throwable -> L30
    L11:
        r105 = r104.next();     // Catch: Throwable -> L30
        if (r104.hasNext() == false) goto L20;
        int r107 = ((r) r105).b();     // Catch: Throwable -> L30
    L15:
        Object r108 = r104.next();     // Catch: Throwable -> L30
        int r109 = ((r) r108).b();     // Catch: Throwable -> L30
        if (r107 >= r109) goto L19;
        r105 = r108;
        r107 = r109;
    L19:
        if (r104.hasNext() == true) goto L15;
    L30:
        th = move-exception;
        throw th;
    L5:
        r102 = null;
        goto L6
    }
}
