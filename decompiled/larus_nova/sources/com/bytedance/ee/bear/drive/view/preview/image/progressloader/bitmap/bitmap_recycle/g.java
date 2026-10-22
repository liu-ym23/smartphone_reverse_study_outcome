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

/* JADX INFO: loaded from: classes16.dex */
public final class g implements e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Bitmap.Config[] f224951d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Bitmap.Config[] f224952e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Bitmap.Config[] f224953f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Bitmap.Config[] f224954g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f224955a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.bitmap_recycle.c<b, Bitmap> f224956b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<Bitmap.Config, NavigableMap<Integer, Integer>> f224957c;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f224958a = null;

        static {
            int[] r100 = new int[Bitmap.Config.values().length];
            f224958a = r100;
            r100[Bitmap.Config.ARGB_8888.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            f224958a[Bitmap.Config.RGB_565.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            f224958a[Bitmap.Config.ARGB_4444.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            f224958a[Bitmap.Config.ALPHA_8.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public static final class b implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f224959a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f224960b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Bitmap.Config f224961c;

        public final int hashCode() {
            int r100 = this.f224960b * 31;
            Bitmap.Config r101 = this.f224961c;
            if (r101 == null) goto L5;
            int r102 = r101.hashCode();
        L7:
            return r100 + r102;
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.bitmap_recycle.f
        public final void offer() {
            this.f224959a.a(this);
        }

        public final String toString() {
            return g.c(this.f224960b, this.f224961c);
        }

        public b(c r100) {
            this.f224959a = r100;
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof b) == false) goto L14;
            b r101 = (b) r100;
            if (this.f224960b != r101.f224960b) goto L15;
            Bitmap.Config r102 = this.f224961c;
            Bitmap.Config r103 = r101.f224961c;
            if (r102 != null) goto L11;
            if (r103 != null) goto L16;
        L12:
            return true;
        L16:
            return false;
        L11:
            if (r102.equals(r103) == true) goto L12;
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
        f224951d = new Bitmap.Config[]{Bitmap.Config.ARGB_8888, null};
        f224952e = new Bitmap.Config[]{Bitmap.Config.RGB_565};
        f224953f = new Bitmap.Config[]{Bitmap.Config.ARGB_4444};
        f224954g = new Bitmap.Config[]{Bitmap.Config.ALPHA_8};
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder();
        r100.append("SizeConfigStrategy{groupedMap=");
        r100.append(this.f224956b);
        r100.append(", sortedSizes=(");
        Iterator r101 = ((HashMap) this.f224957c).entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L7;
        Map.Entry r102 = (Map.Entry) r101.next();
        r100.append(r102.getKey());
        r100.append('[');
        r100.append(r102.getValue());
        r100.append("], ");
        goto L4
    L7:
        if (((HashMap) this.f224957c).isEmpty() == true) goto L9;
        r100.replace(r100.length() - 2, r100.length(), "");
    L9:
        r100.append(")}");
        return r100.toString();
    }

    public g() {
        this.f224955a = new c();
        this.f224956b = new com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.bitmap_recycle.c();
        this.f224957c = new HashMap();
    }

    public final NavigableMap<Integer, Integer> d(Bitmap.Config r100) {
        NavigableMap<Integer, Integer> r101 = (NavigableMap) ((HashMap) this.f224957c).get(r100);
        if (r101 != null) goto L6;
        TreeMap r102 = new TreeMap();
        ((HashMap) this.f224957c).put(r100, r102);
        return r102;
    L6:
        return r101;
    }

    public final void e(Bitmap r100) {
        int r101 = q95.f.b(r100);
        c r102 = this.f224955a;
        Bitmap.Config r103 = r100.getConfig();
        f r104 = (f) ((ArrayDeque) r102.f224934a).poll();
        if (r104 != null) goto L5;
        r104 = r102.b();
    L5:
        b r105 = (b) r104;
        r105.f224960b = r101;
        r105.f224961c = r103;
        com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.bitmap_recycle.c<b, Bitmap> r106 = this.f224956b;
        com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.bitmap_recycle.c.a r107 = (com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.bitmap_recycle.c.a) ((HashMap) r106.f224936b).get(r105);
        if (r107 != null) goto L8;
        r107 = new com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.bitmap_recycle.c.a(r105);
        com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.bitmap_recycle.c.a<K, V> r108 = r107.f224940d;
        r108.f224939c = r107.f224939c;
        r107.f224939c.f224940d = r108;
        com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.bitmap_recycle.c.a<K, Bitmap> r109 = r106.f224935a;
        r107.f224940d = r109.f224940d;
        r107.f224939c = r109;
        r109.f224940d = r107;
        r107.f224940d.f224939c = r107;
        ((HashMap) r106.f224936b).put(r105, r107);
    L10:
        if (r107.f224938b != null) goto L12;
        r107.f224938b = new ArrayList();
    L12:
        ((ArrayList) r107.f224938b).add(r100);
        NavigableMap<Integer, Integer> r110 = d(r100.getConfig());
        Integer r111 = (Integer) r110.get(Integer.valueOf(r105.f224960b));
        Integer r112 = Integer.valueOf(r105.f224960b);
        int r113 = 1;
        if (r111 == null) goto L16;
        r113 = 1 + r111.intValue();
    L16:
        r110.put(r112, Integer.valueOf(r113));
        return;
    L8:
        r105.offer();
        goto L10
    }

    public static String c(int r100, Bitmap.Config r101) {
        return "[" + r100 + "](" + r101 + ")";
    }

    public final void a(Integer r100, Bitmap.Config r101) {
        NavigableMap<Integer, Integer> r102 = d(r101);
        Integer r103 = (Integer) r102.get(r100);
        if (r103.intValue() != 1) goto L5;
        r102.remove(r100);
        return;
    L5:
        r102.put(r100, Integer.valueOf(r103.intValue() - 1));
    }

    public final Bitmap b(int r110, int r111, Bitmap.Config r112) {
        int r100 = q95.f.f532111a;
        int r101 = r110 * r111;
        if (r112 != null) goto L5;
        Bitmap.Config r102 = Bitmap.Config.ARGB_8888;
    L6:
        int r103 = q95.f.a.f532112a[r102.ordinal()];
        if (r103 == 1) goto L12;
        if (r103 == 2) goto L11;
        if (r103 == 3) goto L11;
        int r104 = 4;
    L13:
        int r105 = r101 * r104;
        c r106 = this.f224955a;
        f r107 = (f) ((ArrayDeque) r106.f224934a).poll();
        if (r107 != null) goto L16;
        r107 = r106.b();
    L16:
        b r108 = (b) r107;
        r108.f224960b = r105;
        r108.f224961c = r112;
        int r109 = a.f224958a[r112.ordinal()];
        int r113 = 0;
        if (r109 == 1) goto L25;
        if (r109 == 2) goto L24;
        if (r109 == 3) goto L23;
        if (r109 == 4) goto L22;
        Bitmap.Config[] r114 = {r112};
    L26:
        int r115 = r114.length;
        int r116 = 0;
    L27:
        if (r116 >= r115) goto L43;
        Bitmap.Config r117 = r114[r116];
        Integer r118 = d(r117).ceilingKey(Integer.valueOf(r105));
        if (r118 == null) goto L42;
        if (r118.intValue() > (r105 * 8)) goto L42;
        if (r118.intValue() != r105) goto L38;
        if (r117 == null) goto L38;
        if (r117.equals(r112) == true) goto L43;
    L38:
        this.f224955a.a(r108);
        c r119 = this.f224955a;
        int r120 = r118.intValue();
        f r121 = (f) ((ArrayDeque) r119.f224934a).poll();
        if (r121 != null) goto L41;
        r121 = r119.b();
    L41:
        r108 = (b) r121;
        r108.f224960b = r120;
        r108.f224961c = r117;
    L42:
        r116 = r116 + 1;
    L43:
        com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.bitmap_recycle.c<b, Bitmap> r122 = this.f224956b;
        com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.bitmap_recycle.c.a r123 = (com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.bitmap_recycle.c.a) ((HashMap) r122.f224936b).get(r108);
        if (r123 != null) goto L46;
        com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.bitmap_recycle.c.a r124 = new com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.bitmap_recycle.c.a(r108);
        ((HashMap) r122.f224936b).put(r108, r124);
        com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.bitmap_recycle.c.a r125 = r124;
    L47:
        com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.bitmap_recycle.c.a<K, V> r126 = r125.f224940d;
        r126.f224939c = r125.f224939c;
        r125.f224939c.f224940d = r126;
        com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.bitmap_recycle.c.a<K, Bitmap> r127 = r122.f224935a;
        r125.f224940d = r127;
        com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.bitmap_recycle.c.a<K, V> r128 = r127.f224939c;
        r125.f224939c = r128;
        r128.f224940d = r125;
        r125.f224940d.f224939c = r125;
        Collection r129 = r125.f224938b;
        if (r129 == null) goto L50;
        r113 = ((ArrayList) r129).size();
    L50:
        if (r113 <= 0) goto L52;
        Object r130 = ListProtector.remove(r125.f224938b, r113 - 1);
    L53:
        Bitmap r131 = (Bitmap) r130;
        if (r131 == null) goto L60;
        a(Integer.valueOf(q95.f.b(r131)), r131.getConfig());
        if (r131.getConfig() == null) goto L58;
        Bitmap.Config r132 = r131.getConfig();
    L59:
        r131.reconfigure(r110, r111, r132);
        goto L60
    L58:
        r132 = Bitmap.Config.ARGB_8888;
    L60:
        return r131;
    L52:
        r130 = null;
        goto L53
    L46:
        r108.offer();
        r125 = r123;
        goto L47
    L22:
        r114 = f224954g;
        goto L26
    L23:
        r114 = f224953f;
        goto L26
    L24:
        r114 = f224952e;
        goto L26
    L25:
        r114 = f224951d;
    L11:
        r104 = 2;
        goto L13
    L12:
        r104 = 1;
        goto L13
    L5:
        r102 = r112;
        goto L6
    }
}
