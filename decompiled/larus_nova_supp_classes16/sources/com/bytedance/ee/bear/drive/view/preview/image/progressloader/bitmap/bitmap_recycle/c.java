package com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.bitmap_recycle;

import com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.bitmap_recycle.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c<K extends f, V> {
    public final a<K, V> a;
    public final Map<K, a<K, V>> b;

    public static class a<K, V> {
        public final K a;
        public List<V> b;
        public a<K, V> c;
        public a<K, V> d;

        public a() {
            this(null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(g.b r1) {
            this.d = this;
            this.c = this;
            this.a = r1;
        }
    }

    public final String toString() {
        StringBuilder r0 = new StringBuilder("GroupedLinkedMap( ");
        a r1 = this.a.c;
        boolean r3 = false;
    L4:
        if (r1.equals(this.a) == true) goto L10;
        r0.append('{');
        r0.append(r1.a);
        r0.append(':');
        List<V> r4 = r1.b;
        if (r4 == null) goto L8;
        int r5 = ((ArrayList) r4).size();
    L9:
        r0.append(r5);
        r0.append("}, ");
        r1 = r1.c;
        r3 = true;
        goto L4
    L8:
        r5 = 0;
        goto L9
    L10:
        if (r3 == false) goto L12;
        r0.delete(r0.length() - 2, r0.length());
    L12:
        r0.append(" )");
        return r0.toString();
    }

    public c() {
        this.a = new a();
        this.b = new HashMap();
    }
}
