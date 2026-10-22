package zi7;

/* JADX INFO: loaded from: classes22.dex */
public final class b extends ni7.a<a> implements a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f572264b = null;

    @Override // ni7.a
    public final String i0() {
        return "com.bytedance.ug.sdk.luckycat.url_replace.LuckyCatUrlReplaceServiceImpl";
    }

    static {
        f572264b = new b();
    }

    public b() {
    }

    @Override // zi7.a
    public final String x(String r100, boolean r101) {
        a r102 = h0();
        if (r102 == null) goto L8;
        String r103 = r102.x(r100, r101);
        if (r103 != null) goto L7;
        return r100;
    L7:
        return r103;
    L8:
        return r100;
    }
}
