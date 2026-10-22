package cp4;

import com.alibaba.gaiax.render.view.GXViewKey;

/* JADX INFO: loaded from: classes15.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f464683a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f464684b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f464685c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f464686d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ep4.a f464687e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f464688f;

    public final int hashCode() {
        b r100 = this.f464683a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f464684b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        b r102 = this.f464683a;
        if (r102 == null) goto L14;
        if (r102.equals(r101.f464683a) == false) goto L15;
    L16:
        String r103 = this.f464684b;
        if (r103 == null) goto L20;
        return r103.equals(r101.f464684b);
    L20:
        if (r101.f464684b == null) goto L25;
        return false;
    L25:
        return true;
    L15:
        return false;
    L14:
        if (r101.f464683a == null) goto L16;
        goto L15
    }

    public c(b r100, String r101) {
        this(r100, r101, "", GXViewKey.VIEW_TYPE_CONTAINER_GRID, null, false);
    }

    public c(b r100, String r101, String r102, String r103, ep4.a r104, boolean r105) {
        this.f464683a = r100;
        this.f464684b = r101;
        this.f464685c = r102;
        this.f464686d = r103;
        this.f464687e = r104;
        this.f464688f = r105;
    }
}
