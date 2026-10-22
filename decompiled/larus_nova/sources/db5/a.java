package db5;

/* JADX INFO: loaded from: classes16.dex */
public class a implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f467804a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public bo4.a[] f467805b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public j[] f467806c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public k[] f467807d;

    public a() {
        this("", new bo4.a[0], new j[0]);
    }

    public a a() {
        a r100 = (a) super.clone();     // Catch: CloneNotSupportedException -> L17
        bo4.a[] r101 = this.f467805b;     // Catch: CloneNotSupportedException -> L17
        if (r101 == null) goto L9;
        r100.f467805b = (bo4.a[]) r101.clone();     // Catch: CloneNotSupportedException -> L17
        int r102 = 0;
    L6:
        bo4.a[] r103 = this.f467805b;     // Catch: CloneNotSupportedException -> L17
        if (r102 >= r103.length) goto L9;
        r100.f467805b[r102] = r103[r102].a();     // Catch: CloneNotSupportedException -> L17
        r102 = r102 + 1;     // Catch: CloneNotSupportedException -> L17
    L9:
        j[] r104 = this.f467806c;     // Catch: CloneNotSupportedException -> L17
        if (r104 == null) goto L16;
        r100.f467806c = (j[]) r104.clone();     // Catch: CloneNotSupportedException -> L17
        int r105 = 0;
    L12:
        j[] r106 = this.f467806c;     // Catch: CloneNotSupportedException -> L17
        if (r105 >= r106.length) goto L16;
        r100.f467806c[r105] = r106[r105].a();     // Catch: CloneNotSupportedException -> L17
        r105 = r105 + 1;
    L16:
        return r100;
    L17:
        e = move-exception;
        tt5.a.e("AtContent", "colen AtContent failed", e, false);
        return new a();
    }

    public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        return a();
    }

    public a(String r100, bo4.a[] r101, j[] r102) {
        this.f467804a = r100;
        this.f467805b = r101;
        this.f467806c = r102;
        this.f467807d = new k[0];
    }
}
