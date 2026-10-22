package ej3;

import com.bytedance.android.ec.store.repository.dto.m;
import com.bytedance.android.ec.store.repository.vo.r;
import dj3.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f implements com.bytedance.android.shopping.store.hybridproduct.extension.d {
    public static final a g = null;
    public List<r> a;
    public List<r> b;
    public Boolean c;
    public List<com.bytedance.android.ec.store.repository.dto.c> d;
    public String e;
    public Map<String, k> f;

    public static final class a {
        public a() {
        }

        public static f a(dj3.g r7) {
            f r0 = new f();
            Map<String, k> r1 = null;
            if (r7 == null) goto L5;
            List<com.bytedance.android.ec.store.repository.dto.c> r2 = r7.c();
        L6:
            r0.d = r2;
            if (r7 == null) goto L14;
            List<m> r3 = r7.f();
            if (r3 == null) goto L14;
            List<m> r4 = r3;
            ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
            Iterator<T> r6 = r4.iterator();
        L12:
            if (r6.hasNext() == false) goto L15;
            m r8 = (m) r6.next();
            int r9 = r.t;
            r5.add(r.a.a(r8));
        L15:
            r0.a = r5;
            if (r7 == null) goto L23;
            List<m> r10 = r7.b();
            if (r10 == null) goto L23;
            List<m> r11 = r10;
            ArrayList r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10));
            Iterator<T> r13 = r11.iterator();
        L21:
            if (r13.hasNext() == false) goto L24;
            m r14 = (m) r13.next();
            int r15 = r.t;
            r r16 = r.a.a(r14);
            r.d(r16);
            r12.add(r16);
        L24:
            r0.b = r12;
            if (r7 == null) goto L27;
            Boolean r17 = Boolean.valueOf(r7.a());
        L28:
            r0.c = r17;
            if (r7 != null) goto L31;
        L33:
            if (r7 == null) goto L35;
            r1 = r7.g();
        L35:
            r0.f = r1;
            return r0;
        L31:
            if (r7.e() != true) goto L33;
            r0.e = r7.d();
            goto L33
        L27:
            r17 = null;
        L23:
            r12 = null;
        L14:
            r5 = null;
            goto L15
        L5:
            r2 = null;
            goto L6
        }
    }

    public f() {
    }

    public final int modelType() {
        return 17;
    }

    static {
        g = new a();
    }
}
