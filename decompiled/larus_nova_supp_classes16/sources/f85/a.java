package f85;

import android.util.SparseArray;
import com.bytedance.ee.bear.drive.view.preview.wrapper.z;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a extends w75.a {

    /* JADX INFO: renamed from: f85.a$a, reason: collision with other inner class name */
    public static class C0229a extends w75.b {
        public final String m;
        public final String n;
        public final String o;
        public final String p;
        public final String q;
        public final int r;
        public final int s;

        @Override // w75.b
        public final String a() {
            return this.n;
        }

        public C0229a(String r20, long r21, int[] r23, String r24, String r26, String r27, String r28, int r29) {
            this(r20, r21, r23, 0, r24, false, r26, "", "", r27, r28, "", 0, r29, "", null, 0);
        }

        public C0229a(String r13, long r14, int[] r16, int r17, String r18, boolean r19, String r20, String r21, String r22, String r23, String r24, String r26, int r27, int r28, String r29, SparseArray r210, int r30) {
            super(r20, r13, r14, r16, r17, r18, r19, r29, r210);
            String r0 = "";
            if (r21 != null) goto L5;
            String r1 = "";
        L6:
            this.m = r1;
            if (r22 != null) goto L9;
            String r2 = "";
        L10:
            this.n = r2;
            if (r23 != null) goto L13;
            String r3 = "";
        L14:
            this.o = r3;
            if (r24 == null) goto L18;
            r0 = r24;
        L18:
            this.p = r0;
            this.q = r26;
            this.r = r27;
            this.l = r28;
            this.s = r30;
            return;
        L13:
            r3 = r23;
            goto L14
        L9:
            r2 = r22;
            goto L10
        L5:
            r1 = r21;
            goto L6
        }
    }

    @Override // w75.a
    public final w75.b c() {
        return (C0229a) this.a;
    }

    public final boolean j() {
        w75.b r0 = this.a;
        if (((C0229a) r0) != null) goto L5;
    L7:
        return false;
    L5:
        if (((C0229a) r0).r != 1) goto L7;
        return true;
    }

    @Override // w75.a
    public final z i() {
        z r0 = super.i();
        w75.b r1 = this.a;
        r0.n = ((C0229a) r1).p;
        r0.t = ((C0229a) r1).n;
        return r0;
    }

    public a(C0229a r1) {
        super(r1);
    }
}
