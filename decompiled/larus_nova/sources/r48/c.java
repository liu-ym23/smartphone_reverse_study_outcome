package r48;

/* JADX INFO: loaded from: classes4.dex */
public final class c extends t57.c {
    @Override // t57.a
    public final String b() {
        return "HoraeArrayMapException";
    }

    @Override // t57.c
    public final void f() {
    }

    public c() {
    }

    @Override // p57.g
    public final boolean a(Thread r100, Throwable r101) throws Throwable {
        if ((r101 instanceof ArrayIndexOutOfBoundsException) == true) goto L5;
        return false;
    L5:
        StackTraceElement[] r102 = r101.getStackTrace();
        int r103 = r102.length;
        int r104 = 0;
    L6:
        if (r104 >= r103) goto L18;
        StackTraceElement r105 = r102[r104];
        if ("android.app.ActivityThread".equals(r105.getClassName()) == false) goto L13;
        if ("handleTrimMemory".equals(r105.getMethodName()) == false) goto L13;
        return true;
    L13:
        if ("android.app.ActivityThread".equals(r105.getClassName()) == false) goto L17;
        if ("collectComponentCallbacks".equals(r105.getMethodName()) == false) goto L17;
        return true;
    L17:
        r104 = r104 + 1;
        goto L6
    L18:
        return false;
    }
}
