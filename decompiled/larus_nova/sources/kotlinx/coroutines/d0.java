package kotlinx.coroutines;

/* JADX INFO: loaded from: classes.dex */
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f0 f504706a = null;

    /* JADX WARN: Multi-variable type inference failed */
    static {
        int r100 = kotlinx.coroutines.internal.d0.f504940a;
        String r101 = System.getProperty("kotlinx.coroutines.main.delay");     // Catch: SecurityException -> L5
    L6:
        if (r101 == null) goto L8;
        boolean r102 = Boolean.parseBoolean(r101);
    L9:
        if (r102 == true) goto L11;
        f0 r103 = c0.f504641h;
    L15:
        f504706a = r103;
        return;
    L11:
        MainCoroutineDispatcher r104 = Dispatchers.getMain();
        r104.getImmediate();
        if ((r104 instanceof f0) == true) goto L14;
        r103 = c0.f504641h;
        goto L15
    L14:
        r103 = (f0) r104;
        goto L15
    L8:
        r102 = false;
    L5:
        r101 = null;
        goto L6
    }
}
