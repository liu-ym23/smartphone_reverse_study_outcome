package k25;

import android.text.TextUtils;
import android.util.LruCache;
import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class l0 extends LruCache<a, m0> {

    public static class a {
        public final String a;
        public final String b;
        public final int c;

        public final int hashCode() {
            String r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = (r2 + this.c) * 31;
            String r4 = this.b;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return r3 + r1;
        L5:
            r2 = 0;
            goto L6
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (r5 != null) goto L8;
        L28:
            return false;
        L8:
            if (a.class != r5.getClass()) goto L28;
            a r6 = (a) r5;
            String r2 = this.a;
            if (r2 == null) goto L16;
            if (r2.equals(r6.a) == true) goto L19;
        L17:
            return false;
        L19:
            if (this.c == r6.c) goto L21;
            return false;
        L21:
            String r3 = this.b;
            String r7 = r6.b;
            if (r3 != null) goto L29;
            if (r7 == null) goto L30;
            return false;
        L30:
            return true;
        L29:
            return r3.equals(r7);
        L16:
            if (r6.a == null) goto L19;
            goto L17
        }

        public a(String r1, String r2, int r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public l0() {
        super(52428800);
    }

    public final void d(String r4) {
        Iterator<Map.Entry<a, m0>> r0 = snapshot().entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        a r1 = r0.next().getKey();
        if (TextUtils.equals(r4, r1.b) == false) goto L4;
        remove(r1);
        goto L4
    }

    public final void c(String r4, String r5) {
        Iterator<Map.Entry<a, m0>> r0 = snapshot().entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        a r1 = r0.next().getKey();
        if (TextUtils.equals(r4, r1.b) == false) goto L4;
        if (TextUtils.equals(r5, r1.a) == false) goto L4;
        remove(r1);
        goto L4
    }

    @Override // android.util.LruCache
    public final int sizeOf(a r1, m0 r2) {
        String r3 = r2.c;
        if (r3 != null) goto L6;
        return 0;
    L6:
        return r3.length();
    }

    public final m0 a(String r2, String r3, int r4) {
        m0 r5 = get(new a(r2, r3, r4));
        if (r5 != null) goto L5;
        return r5;
    L5:
        return new m0(r5);
    }

    public final m0 b(String r3, String r4, m0 r5) {
        m0 r0 = new m0(r5);
        put(new a(r3, r4, r5.p), r0);
        return r0;
    }

    @Override // android.util.LruCache
    public final void entryRemoved(boolean r1, a r2, m0 r3, m0 r4) {
        m0 r5 = r3;
        super.entryRemoved(r1, r2, r5, r4);
        if (r5 == null) goto L13;
        String r6 = r5.b;
        if (r6 == null) goto L14;
        int r7 = r6.indexOf(OfflineDoc.DASH_DELIMITER, r6.indexOf(OfflineDoc.DASH_DELIMITER) + 1) + 1;
        if (r7 > r6.length()) goto L12;
        tt5.a.h("OfflineMemCache", "entryRemoved, oldValue = [" + du5.b.g(r5.k) + ", " + du5.b.k(r6.substring(r7)) + "]");
        return;
    L12:
        return;
    L14:
        return;
    }
}
