package vj8;

import uj8.f;

/* JADX INFO: loaded from: classes26.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public vj8.a f555439a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f555440b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f555441c;

    public static final class a implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f555442a;

        @Override // uj8.f
        public final void a() {
            d r100 = this.f555442a;
            vj8.a r101 = r100.f555439a;
            if (r101 != null) goto L5;
            return;
        L5:
            b r102 = r100.f555440b;
            if (r102 == null) goto L9;
            r102.a(r101);
            return;
        }

        @Override // uj8.f
        public final void b() {
            d r100 = this.f555442a;
            vj8.a r101 = r100.f555439a;
            if (r101 != null) goto L5;
            return;
        L5:
            b r102 = r100.f555440b;
            if (r102 == null) goto L9;
            r102.c(r101);
            return;
        }

        public final boolean c() {
            d r100 = this.f555442a;
            vj8.a r101 = r100.f555439a;
            if (r101 != null) goto L5;
            return false;
        L5:
            b r102 = r100.f555440b;
            if (r102 != null) goto L8;
            return false;
        L8:
            if (r102.b(r101) != true) goto L12;
            return true;
        L12:
            return false;
        }

        public a(d r100) {
            this.f555442a = r100;
        }
    }

    public d() {
        this.f555441c = new a(this);
    }
}
