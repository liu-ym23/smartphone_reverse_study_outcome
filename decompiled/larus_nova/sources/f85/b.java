package f85;

import android.util.SparseArray;
import com.bytedance.ee.bear.drive.view.preview.wrapper.z;

/* JADX INFO: loaded from: classes16.dex */
public final class b extends w75.a {

    public static class a extends w75.b {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final String f475877m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final String f475878n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final String f475879o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final String f475880p;

        public a() {
            throw null;
        }

        @Override // w75.b
        public final String a() {
            return this.f475880p;
        }

        public a(String r110, long r111, int[] r112, int r113, String r114, boolean r115, String r210, String r211, String r212, String r213, String r214, SparseArray r215) {
            super(r211, r110, r111, r112, r113, r114, r115, "", r215);
            this.f475877m = r210;
            this.f475878n = r212;
            this.f475879o = r213;
            this.f475880p = r214;
        }
    }

    @Override // w75.a
    public final w75.b c() {
        return (a) this.f558532a;
    }

    @Override // w75.a
    public final z i() {
        z r100 = super.i();
        w75.b r101 = this.f558532a;
        r100.f225848p = ((a) r101).f475877m;
        r100.f225850r = ((a) r101).f475878n;
        r100.f225852t = ((a) r101).f475880p;
        return r100;
    }

    public b(a r100) {
        super(r100);
    }
}
