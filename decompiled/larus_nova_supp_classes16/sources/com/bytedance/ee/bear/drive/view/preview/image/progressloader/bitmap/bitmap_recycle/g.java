package com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.bitmap_recycle;

import android.graphics.Bitmap;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class g implements e {
    public static final Bitmap.Config[] d = null;
    public static final Bitmap.Config[] e = null;
    public static final Bitmap.Config[] f = null;
    public static final Bitmap.Config[] g = null;
    public final c a;
    public final com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.bitmap_recycle.c<b, Bitmap> b;
    public final Map<Bitmap.Config, NavigableMap<Integer, Integer>> c;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Bitmap.Config.values().length];
            a = r0;
            r0[Bitmap.Config.ARGB_8888.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            a[Bitmap.Config.RGB_565.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            a[Bitmap.Config.ARGB_4444.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            a[Bitmap.Config.ALPHA_8.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public static final class b implements f {
        public final c a;
        public int b;
        public Bitmap.Config c;

        public final int hashCode() {
            int r0 = this.b * 31;
            Bitmap.Config r1 = this.c;
            if (r1 == null) goto L5;
            int r2 = r1.hashCode();
        L7:
            return r0 + r2;
        L5:
            r2 = 0;
            goto L7
        }

        @Override // com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.bitmap_recycle.f
        public final void offer() {
            this.a.a(this);
        }

        public final String toString() {
            return g.c(this.b, this.c);
        }

        public b(c r1) {
            this.a = r1;
        }

        public final boolean equals(Object r4) {
            if ((r4 instanceof b) == false) goto L14;
            b r5 = (b) r4;
            if (this.b != r5.b) goto L15;
            Bitmap.Config r0 = this.c;
            Bitmap.Config r6 = r5.c;
            if (r0 != null) goto L11;
            if (r6 != null) goto L16;
        L12:
            return true;
        L16:
            return false;
        L11:
            if (r0.equals(r6) == true) goto L12;
            return false;
        L15:
            return false;
        L14:
            return false;
        }
    }

    public static class c extends com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.bitmap_recycle.a<b> {
        public final f b() {
            return new b(this);
        }

        public c() {
        }
    }

    static {
        d = new Bitmap.Config[]{Bitmap.Config.ARGB_8888, null};
        e = new Bitmap.Config[]{Bitmap.Config.RGB_565};
        f = new Bitmap.Config[]{Bitmap.Config.ARGB_4444};
        g = new Bitmap.Config[]{Bitmap.Config.ALPHA_8};
    }

    public final String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("SizeConfigStrategy{groupedMap=");
        r0.append(this.b);
        r0.append(", sortedSizes=(");
        Iterator r1 = ((HashMap) this.c).entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L7;
        Map.Entry r2 = (Map.Entry) r1.next();
        r0.append(r2.getKey());
        r0.append('[');
        r0.append(r2.getValue());
        r0.append("], ");
        goto L4
    L7:
        if (((HashMap) this.c).isEmpty() == true) goto L9;
        r0.replace(r0.length() - 2, r0.length(), "");
    L9:
        r0.append(")}");
        return r0.toString();
    }

    public g() {
        this.a = new c();
        this.b = new com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.bitmap_recycle.c();
        this.c = new HashMap();
    }

    public final NavigableMap<Integer, Integer> d(Bitmap.Config r3) {
        NavigableMap<Integer, Integer> r0 = (NavigableMap) ((HashMap) this.c).get(r3);
        if (r0 != null) goto L6;
        TreeMap r1 = new TreeMap();
        ((HashMap) this.c).put(r3, r1);
        return r1;
    L6:
        return r0;
    }

    public final void e(Bitmap r6) {
        int r0 = q95.f.b(r6);
        c r1 = this.a;
        Bitmap.Config r2 = r6.getConfig();
        f r3 = (f) ((ArrayDeque) r1.a).poll();
        if (r3 != null) goto L5;
        r3 = r1.b();
    L5:
        b r4 = (b) r3;
        r4.b = r0;
        r4.c = r2;
        com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.bitmap_recycle.c<b, Bitmap> r5 = this.b;
        com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.bitmap_recycle.c.a r7 = (com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.bitmap_recycle.c.a) ((HashMap) r5.b).get(r4);
        if (r7 != null) goto L8;
        r7 = new com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.bitmap_recycle.c.a(r4);
        com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.bitmap_recycle.c.a<K, V> r8 = r7.d;
        r8.c = r7.c;
        r7.c.d = r8;
        com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.bitmap_recycle.c.a<K, Bitmap> r9 = r5.a;
        r7.d = r9.d;
        r7.c = r9;
        r9.d = r7;
        r7.d.c = r7;
        ((HashMap) r5.b).put(r4, r7);
    L10:
        if (r7.b != null) goto L12;
        r7.b = new ArrayList();
    L12:
        ((ArrayList) r7.b).add(r6);
        NavigableMap<Integer, Integer> r10 = d(r6.getConfig());
        Integer r11 = (Integer) r10.get(Integer.valueOf(r4.b));
        Integer r12 = Integer.valueOf(r4.b);
        int r13 = 1;
        if (r11 == null) goto L16;
        r13 = 1 + r11.intValue();
    L16:
        r10.put(r12, Integer.valueOf(r13));
        return;
    L8:
        r4.offer();
        goto L10
    }

    public static String c(int r2, Bitmap.Config r3) {
        return "[" + r2 + "](" + r3 + ")";
    }

    public final void a(Integer r4, Bitmap.Config r5) {
        NavigableMap<Integer, Integer> r6 = d(r5);
        Integer r0 = (Integer) r6.get(r4);
        if (r0.intValue() != 1) goto L5;
        r6.remove(r4);
        return;
    L5:
        r6.put(r4, Integer.valueOf(r0.intValue() - 1));
    }

    public final Bitmap b(int r11, int r12, Bitmap.Config r13) {
        int r0 = q95.f.a;
        int r1 = r11 * r12;
        if (r13 != null) goto L5;
        Bitmap.Config r2 = Bitmap.Config.ARGB_8888;
    L6:
        int r3 = q95.f.a.a[r2.ordinal()];
        if (r3 == 1) goto L12;
        if (r3 == 2) goto L11;
        if (r3 == 3) goto L11;
        int r4 = 4;
    L13:
        int r5 = r1 * r4;
        c r6 = this.a;
        f r7 = (f) ((ArrayDeque) r6.a).poll();
        if (r7 != null) goto L16;
        r7 = r6.b();
    L16:
        b r8 = (b) r7;
        r8.b = r5;
        r8.c = r13;
        int r9 = a.a[r13.ordinal()];
        int r10 = 0;
        if (r9 == 1) goto L25;
        if (r9 == 2) goto L24;
        if (r9 == 3) goto L23;
        if (r9 == 4) goto L22;
        Bitmap.Config[] r14 = {r13};
    L26:
        int r16 = r14.length;
        int r17 = 0;
    L27:
        if (r17 >= r16) goto L43;
        Bitmap.Config r18 = r14[r17];
        Integer r19 = d(r18).ceilingKey(Integer.valueOf(r5));
        if (r19 == null) goto L42;
        if (r19.intValue() > (r5 * 8)) goto L42;
        if (r19.intValue() != r5) goto L38;
        if (r18 == null) goto L38;
        if (r18.equals(r13) == true) goto L43;
    L38:
        this.a.a(r8);
        c r110 = this.a;
        int r20 = r19.intValue();
        f r21 = (f) ((ArrayDeque) r110.a).poll();
        if (r21 != null) goto L41;
        r21 = r110.b();
    L41:
        r8 = (b) r21;
        r8.b = r20;
        r8.c = r18;
    L42:
        r17 = r17 + 1;
    L43:
        com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.bitmap_recycle.c<b, Bitmap> r111 = this.b;
        com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.bitmap_recycle.c.a r22 = (com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.bitmap_recycle.c.a) ((HashMap) r111.b).get(r8);
        if (r22 != null) goto L46;
        com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.bitmap_recycle.c.a r23 = new com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.bitmap_recycle.c.a(r8);
        ((HashMap) r111.b).put(r8, r23);
        com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.bitmap_recycle.c.a r24 = r23;
    L47:
        com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.bitmap_recycle.c.a<K, V> r26 = r24.d;
        r26.c = r24.c;
        r24.c.d = r26;
        com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.bitmap_recycle.c.a<K, Bitmap> r112 = r111.a;
        r24.d = r112;
        com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.bitmap_recycle.c.a<K, V> r113 = r112.c;
        r24.c = r113;
        r113.d = r24;
        r24.d.c = r24;
        Collection r114 = r24.b;
        if (r114 == null) goto L50;
        r10 = ((ArrayList) r114).size();
    L50:
        if (r10 <= 0) goto L52;
        Object r115 = ListProtector.remove(r24.b, r10 - 1);
    L53:
        Bitmap r116 = (Bitmap) r115;
        if (r116 == null) goto L60;
        a(Integer.valueOf(q95.f.b(r116)), r116.getConfig());
        if (r116.getConfig() == null) goto L58;
        Bitmap.Config r27 = r116.getConfig();
    L59:
        r116.reconfigure(r11, r12, r27);
        goto L60
    L58:
        r27 = Bitmap.Config.ARGB_8888;
    L60:
        return r116;
    L52:
        r115 = null;
        goto L53
    L46:
        r8.offer();
        r24 = r22;
        goto L47
    L22:
        r14 = g;
        goto L26
    L23:
        r14 = f;
        goto L26
    L24:
        r14 = e;
        goto L26
    L25:
        r14 = d;
    L11:
        r4 = 2;
        goto L13
    L12:
        r4 = 1;
        goto L13
    L5:
        r2 = r13;
        goto L6
    }
}
