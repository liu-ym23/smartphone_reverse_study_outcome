package f85;

import android.util.SparseArray;
import com.bytedance.ee.bear.drive.view.preview.wrapper.z;

/* JADX INFO: loaded from: classes16.dex */
public final class a extends w75.a {

    /* JADX INFO: renamed from: f85.a$a, reason: collision with other inner class name */
    public static class C5868a extends w75.b {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final String f475870m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final String f475871n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final String f475872o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final String f475873p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final String f475874q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public final int f475875r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public final int f475876s;

        @Override // w75.b
        public final String a() {
            return this.f475871n;
        }

        public C5868a(String r210, long r211, int[] r212, String r213, String r214, String r215, String r216, int r217) {
            this(r210, r211, r212, 0, r213, false, r214, "", "", r215, r216, "", 0, r217, "", null, 0);
        }

        public C5868a(String r110, long r111, int[] r112, int r113, String r114, boolean r115, String r210, String r211, String r212, String r213, String r214, String r215, int r216, int r217, String r218, SparseArray r219, int r310) {
            super(r210, r110, r111, r112, r113, r114, r115, r218, r219);
            String r100 = "";
            if (r211 != null) goto L5;
            String r101 = "";
        L6:
            this.f475870m = r101;
            if (r212 != null) goto L9;
            String r102 = "";
        L10:
            this.f475871n = r102;
            if (r213 != null) goto L13;
            String r103 = "";
        L14:
            this.f475872o = r103;
            if (r214 == null) goto L18;
            r100 = r214;
        L18:
            this.f475873p = r100;
            this.f475874q = r215;
            this.f475875r = r216;
            this.f558568l = r217;
            this.f475876s = r310;
            return;
        L13:
            r103 = r213;
            goto L14
        L9:
            r102 = r212;
            goto L10
        L5:
            r101 = r211;
            goto L6
        }
    }

    @Override // w75.a
    public final w75.b c() {
        return (C5868a) this.f558532a;
    }

    public final boolean j() {
        w75.b r100 = this.f558532a;
        if (((C5868a) r100) != null) goto L5;
    L7:
        return false;
    L5:
        if (((C5868a) r100).f475875r != 1) goto L7;
        return true;
    }

    @Override // w75.a
    public final z i() {
        z r100 = super.i();
        w75.b r101 = this.f558532a;
        r100.f225846n = ((C5868a) r101).f475873p;
        r100.f225852t = ((C5868a) r101).f475871n;
        return r100;
    }

    public a(C5868a r100) {
        super(r100);
    }
}
