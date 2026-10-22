package kotlinx.coroutines;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class d0 {
    public static final f0 a = null;

    /* JADX WARN: Multi-variable type inference failed */
    static {
        int r1 = kotlinx.coroutines.internal.d0.a;
        String r0 = System.getProperty("kotlinx.coroutines.main.delay");     // Catch: SecurityException -> L5
    L6:
        if (r0 == null) goto L8;
        boolean r2 = Boolean.parseBoolean(r0);
    L9:
        if (r2 == true) goto L11;
        f0 r3 = c0.h;
    L15:
        a = r3;
        return;
    L11:
        MainCoroutineDispatcher r4 = Dispatchers.getMain();
        r4.getImmediate();
        if ((r4 instanceof f0) == true) goto L14;
        r3 = c0.h;
        goto L15
    L14:
        r3 = (f0) r4;
        goto L15
    L8:
        r2 = false;
    L5:
        r0 = null;
        goto L6
    }
}
