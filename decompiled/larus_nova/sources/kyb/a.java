package kyb;

/* JADX INFO: loaded from: classes37.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f506724a = 0;

    static {
    }

    public static String a(Object... r100) {
        StringBuilder r101 = new StringBuilder();
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L10;
        Object r104 = r100[r103];
        r101.append(" ");
        if (r104 == null) goto L7;
        r101.append(r104);
    L8:
        r103 = r103 + 1;
        goto L3
    L7:
        r101.append("null");
        goto L8
    L10:
        return r101.toString();
    }
}
