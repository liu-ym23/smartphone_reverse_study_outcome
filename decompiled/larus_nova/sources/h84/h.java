package h84;

import com.bytedance.bdinstall.c1;

/* JADX INFO: loaded from: classes3.dex */
public final class h implements e.c<String[]> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f484127a;

    @Override // h84.e.c
    public final String[] getCache() {
        return this.f484127a.f();
    }

    public h(e r100) {
        this.f484127a = r100;
    }

    @Override // h84.e.c
    public final boolean a(String[] r100) {
        String[] r101 = r100;
        if (r101 != null) goto L5;
    L7:
        return false;
    L5:
        if (r101.length <= 0) goto L7;
        return true;
    }

    @Override // h84.e.c
    public final void c(String[] r100) {
        e r101 = this.f484127a;
        r101.d(r100);
    }

    @Override // h84.e.c
    public final boolean b(String[] r110, String[] r111) {
        String[] r112 = r110;
        String[] r113 = r111;
        if (r112 != r113) goto L6;
        return true;
    L6:
        if (r112 == null) goto L26;
        if (r113 == null) goto L26;
        if (r112.length != r113.length) goto L26;
        int r100 = r112.length;
        int r101 = 0;
    L13:
        if (r101 >= r100) goto L34;
        String r102 = r112[r101];
        int r103 = r113.length;
        int r104 = 0;
        boolean r105 = false;
    L15:
        if (r104 >= r103) goto L23;
        if (c1.f(r113[r104], r102) == true) goto L21;
        if (r105 == true) goto L21;
        r105 = false;
    L22:
        r104 = r104 + 1;
    L21:
        r105 = true;
        goto L22
    L23:
        if (r105 == false) goto L26;
        r101 = r101 + 1;
        goto L13
    L34:
        return true;
    L26:
        return false;
    }

    @Override // h84.e.c
    public final String[] d(String[] r100, String[] r101, e r102) {
        return (String[]) r102.g(r100, r101, new h(r102));
    }
}
