package vra;

/* JADX INFO: loaded from: classes34.dex */
public final class a implements ora.a {
    public a() {
    }

    @Override // ora.a
    public final String a(Object r100) {
        StringBuffer r101 = new StringBuffer("Thread: ");
        r101.append(((Thread) r100).getName());
        return r101.toString();
    }
}
