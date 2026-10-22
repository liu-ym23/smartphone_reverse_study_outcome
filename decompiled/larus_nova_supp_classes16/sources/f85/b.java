package f85;

import android.util.SparseArray;
import com.bytedance.ee.bear.drive.view.preview.wrapper.z;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b extends w75.a {

    public static class a extends w75.b {
        public final String m;
        public final String n;
        public final String o;
        public final String p;

        public a() {
            throw null;
        }

        @Override // w75.b
        public final String a() {
            return this.p;
        }

        public a(String r13, long r14, int[] r16, int r17, String r18, boolean r19, String r20, String r21, String r22, String r23, String r24, SparseArray r26) {
            super(r21, r13, r14, r16, r17, r18, r19, "", r26);
            this.m = r20;
            this.n = r22;
            this.o = r23;
            this.p = r24;
        }
    }

    @Override // w75.a
    public final w75.b c() {
        return (a) this.a;
    }

    @Override // w75.a
    public final z i() {
        z r0 = super.i();
        w75.b r1 = this.a;
        r0.p = ((a) r1).m;
        r0.r = ((a) r1).n;
        r0.t = ((a) r1).p;
        return r0;
    }

    public b(a r1) {
        super(r1);
    }
}
