package htc;

/* JADX INFO: loaded from: classes41.dex */
public final class i implements gtc.e.a {
    public i() {
    }

    @Override // gtc.e.a
    public final boolean a(gtc.g.f r100) {
        String r101 = r100.name();
        if ("class-name".equals(r101) == false) goto L5;
    L7:
        return false;
    L5:
        if ("function".equals(r101) == true) goto L7;
        return true;
    }
}
