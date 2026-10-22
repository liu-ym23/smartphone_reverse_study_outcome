package xu2;

/* JADX INFO: loaded from: classes11.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f565082a = 0;

    static {
    }

    public static long a(Long r100) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        if (r100.longValue() > 0) goto L7;
        return 0;
    L7:
        if (r100.longValue() < System.currentTimeMillis()) goto L9;
        return 0;
    L9:
        return System.currentTimeMillis() - r100.longValue();
    }
}
