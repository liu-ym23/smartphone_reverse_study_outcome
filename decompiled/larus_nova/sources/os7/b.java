package os7;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes22.dex */
public final class b implements a.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f526535a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a.d f526536b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ a.c f526537c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ a f526538d;

    @Override // os7.a.d
    public final void c(String[] r100) {
    }

    @Override // os7.a.d
    public final void b(int r100, String r101, String r102) {
        if (this.f526535a != 2) goto L6;
        this.f526536b.b(r100, r101, r102);
        return;
    }

    public b(a r100, int r101, a.d r102, a.C7107a r103) {
        this.f526538d = r100;
        this.f526535a = r101;
        this.f526536b = r102;
        this.f526537c = r103;
    }

    @Override // os7.a.d
    public final boolean a(int r100, String r101, String r102, String r103) {
        int r104 = this.f526535a;
        if (r104 != 2) goto L6;
        this.f526536b.a(r100, r101, r102, r103);
        ((ArrayList) this.f526538d.f526525i).add(r102);
        return false;
    L6:
        if (r104 != 1) goto L11;
        ((ArrayList) this.f526538d.f526524h).add(r102);
        return false;
    L11:
        return false;
    }

    @Override // os7.a.d
    public final void d(int r100, int r101, String r102, String[] r103) {
        int r104 = this.f526535a;
        if (r104 != 2) goto L6;
        a r105 = this.f526538d;
        r105.f526523g += r101;
        r105.a(this.f526536b, r102);
        return;
    L6:
        if (r104 != 1) goto L10;
        if (r100 != r101) goto L9;
        this.f526538d.f526523g += r101;
    L9:
        ((a.C7107a) this.f526537c).a(r104, r101, r100, this.f526536b);
        return;
    L10:
        if (r104 != 0) goto L15;
        this.f526538d.f526523g += r101;
        ((a.C7107a) this.f526537c).a(r104, r100, r101, this.f526536b);
        return;
    }
}
