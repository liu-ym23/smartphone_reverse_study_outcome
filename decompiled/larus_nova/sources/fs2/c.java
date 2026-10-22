package fs2;

/* JADX INFO: loaded from: classes11.dex */
public final class c {
    public static b a() {
        vm0.a r100 = om0.c.k();
        if (r100 == null) goto L5;
        b r101 = (b) r100.getValue(new vm0.b("live_task_opt", new b(), new b(), b.class));
    L6:
        if (r101 == null) goto L8;
        return r101;
    L8:
        return new b();
    L5:
        r101 = null;
        goto L6
    }

    static {
    }
}
