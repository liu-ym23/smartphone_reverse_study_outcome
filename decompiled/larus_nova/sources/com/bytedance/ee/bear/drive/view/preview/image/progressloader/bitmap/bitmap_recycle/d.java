package com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.bitmap_recycle;

import android.graphics.Bitmap;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes16.dex */
public final class d implements b {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Bitmap.Config f224941j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f224942a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<Bitmap.Config> f224943b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f224944c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f224945d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f224946e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f224947f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f224948g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f224949h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f224950i;

    public static class a {
        public a() {
        }
    }

    static {
        f224941j = Bitmap.Config.ARGB_8888;
    }

    public final void a() {
        tt5.a.h("LruBitmapPool", "Hits=" + this.f224947f + ", misses=" + this.f224948g + ", puts=" + this.f224949h + ", evictions=" + this.f224950i + ", currentSize=" + this.f224946e + ", maxSize=" + this.f224945d + "\nStrategy=" + this.f224942a);
    }

    public final void b() {
        int r100 = this.f224945d;
        monitor-enter(this);
    L32:
    L29:
        th = move-exception;
        throw th;
    L5:
        if (this.f224946e <= r100) goto L27;
        g r101 = (g) this.f224942a;     // Catch: Throwable -> L29
        c<g.b, Bitmap> r102 = r101.f224956b;     // Catch: Throwable -> L29
        c.a r103 = r102.f224935a.f224940d;     // Catch: Throwable -> L29
    L7:
        Object r104 = null;
        if (r103.equals(r102.f224935a) == true) goto L18;
        Collection r105 = r103.f224938b;     // Catch: Throwable -> L29
        if (r105 == null) goto L12;
        int r106 = ((ArrayList) r105).size();     // Catch: Throwable -> L29
    L13:
        if (r106 <= 0) goto L15;
        r104 = ListProtector.remove(r103.f224938b, r106 - 1);     // Catch: Throwable -> L29
    L15:
        if (r104 != null) goto L18;
        c.a<K, V> r107 = r103.f224940d;     // Catch: Throwable -> L29
        r107.f224939c = r103.f224939c;     // Catch: Throwable -> L29
        r103.f224939c.f224940d = r107;     // Catch: Throwable -> L29
        ((HashMap) r102.f224936b).remove(r103.f224937a);     // Catch: Throwable -> L29
        ((f) r103.f224937a).offer();     // Catch: Throwable -> L29
        r103 = r103.f224940d;     // Catch: Throwable -> L29
        goto L7
    L12:
        r106 = 0;
    L18:
        Bitmap r108 = (Bitmap) r104;     // Catch: Throwable -> L29
        if (r108 == null) goto L21;
        r101.a(Integer.valueOf(q95.f.b(r108)), r108.getConfig());     // Catch: Throwable -> L29
    L21:
        if (r108 == null) goto L22;
        this.f224944c.getClass();     // Catch: Throwable -> L29
        int r109 = this.f224946e;     // Catch: Throwable -> L29
        ((g) this.f224942a).getClass();     // Catch: Throwable -> L29
        this.f224946e = r109 - q95.f.b(r108);     // Catch: Throwable -> L29
        r108.recycle();     // Catch: Throwable -> L29
        this.f224950i++;     // Catch: Throwable -> L29
        StringBuilder r110 = new StringBuilder();     // Catch: Throwable -> L29
        r110.append("Evicting bitmap=");     // Catch: Throwable -> L29
        ((g) this.f224942a).getClass();     // Catch: Throwable -> L29
        r110.append(g.c(q95.f.b(r108), r108.getConfig()));     // Catch: Throwable -> L29
        tt5.a.b("LruBitmapPool", r110.toString());     // Catch: Throwable -> L29
        a();     // Catch: Throwable -> L29
        goto L32
    L22:
        tt5.a.k("LruBitmapPool", "Size mismatch, resetting");     // Catch: Throwable -> L29
        a();     // Catch: Throwable -> L29
        this.f224946e = 0;     // Catch: Throwable -> L29
        monitor-exit(this);
        return;
    L27:
        monitor-exit(this);
    }

    public d(int r100) {
        g r101 = new g();
        HashSet r102 = new HashSet();
        r102.addAll(Arrays.asList(Bitmap.Config.values()));
        r102.add(null);
        Set<Bitmap.Config> r103 = Collections.unmodifiableSet(r102);
        this.f224945d = 16384;
        this.f224942a = r101;
        this.f224943b = r103;
        this.f224944c = new a();
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.bitmap_recycle.b
    public final synchronized boolean put(Bitmap r100) {
        monitor-enter(this);
        if (r100 == null) goto L22;
        if (r100.isMutable() == false) goto L17;
        ((g) this.f224942a).getClass();     // Catch: Throwable -> L15
        if (q95.f.b(r100) > this.f224945d) goto L17;
        if (this.f224943b.contains(r100.getConfig()) == false) goto L17;
        ((g) this.f224942a).getClass();     // Catch: Throwable -> L15
        int r101 = q95.f.b(r100);     // Catch: Throwable -> L15
        ((g) this.f224942a).e(r100);     // Catch: Throwable -> L15
        this.f224944c.getClass();     // Catch: Throwable -> L15
        this.f224949h++;     // Catch: Throwable -> L15
        this.f224946e += r101;     // Catch: Throwable -> L15
        StringBuilder r102 = new StringBuilder("Put bitmap in pool=");     // Catch: Throwable -> L15
        ((g) this.f224942a).getClass();     // Catch: Throwable -> L15
        r102.append(g.c(q95.f.b(r100), r100.getConfig()));     // Catch: Throwable -> L15
        tt5.a.h("LruBitmapPool", r102.toString());     // Catch: Throwable -> L15
        a();     // Catch: Throwable -> L15
        b();     // Catch: Throwable -> L15
        monitor-exit(this);
        return true;
    L17:
        StringBuilder r103 = new StringBuilder("Reject bitmap from pool, bitmap: ");     // Catch: Throwable -> L15
        ((g) this.f224942a).getClass();     // Catch: Throwable -> L15
        r103.append(g.c(q95.f.b(r100), r100.getConfig()));     // Catch: Throwable -> L15
        r103.append(", is mutable: ");     // Catch: Throwable -> L15
        r103.append(r100.isMutable());     // Catch: Throwable -> L15
        r103.append(", is allowed config: ");     // Catch: Throwable -> L15
        r103.append(this.f224943b.contains(r100.getConfig()));     // Catch: Throwable -> L15
        tt5.a.h("LruBitmapPool", r103.toString());     // Catch: Throwable -> L15
        monitor-exit(this);
        return false;
    L22:
        throw new NullPointerException("Bitmap must not be null");     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.bitmap_recycle.b
    public final synchronized Bitmap get(int r100, int r101, Bitmap.Config r102) {
        monitor-enter(this);
        Bitmap r103 = getDirty(r100, r101, r102);     // Catch: Throwable -> L8
        if (r103 == null) goto L6;
        r103.eraseColor(0);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return r103;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.bitmap_recycle.b
    public final synchronized Bitmap getDirty(int r110, int r111, Bitmap.Config r112) {
        monitor-enter(this);
        e r100 = this.f224942a;     // Catch: Throwable -> L37
        if (r112 == null) goto L7;
        Bitmap.Config r101 = r112;
    L8:
        Bitmap r102 = ((g) r100).b(r110, r111, r101);     // Catch: Throwable -> L37
        int r103 = 4;
        if (r102 != null) goto L22;
        StringBuilder r104 = new StringBuilder("Missing bitmap=");     // Catch: Throwable -> L37
        ((g) this.f224942a).getClass();     // Catch: Throwable -> L37
        int r105 = q95.f.f532111a;     // Catch: Throwable -> L37
        int r106 = r110 * r111;     // Catch: Throwable -> L37
        if (r112 != null) goto L13;
        Bitmap.Config r107 = Bitmap.Config.ARGB_8888;     // Catch: Throwable -> L37
    L14:
        int r108 = q95.f.a.f532112a[r107.ordinal()];     // Catch: Throwable -> L37
        if (r108 == 1) goto L20;
        if (r108 == 2) goto L19;
        if (r108 == 3) goto L19;
        int r109 = 4;
    L21:
        r104.append(g.c(r106 * r109, r112));     // Catch: Throwable -> L37
        tt5.a.b("LruBitmapPool", r104.toString());     // Catch: Throwable -> L37
        this.f224948g++;     // Catch: Throwable -> L37
    L23:
        StringBuilder r113 = new StringBuilder("Get bitmap=");     // Catch: Throwable -> L37
        ((g) this.f224942a).getClass();     // Catch: Throwable -> L37
        int r114 = r110 * r111;     // Catch: Throwable -> L37
        if (r112 != null) goto L26;
        Bitmap.Config r115 = Bitmap.Config.ARGB_8888;     // Catch: Throwable -> L37
    L27:
        int r116 = q95.f.a.f532112a[r115.ordinal()];     // Catch: Throwable -> L37
        if (r116 == 1) goto L33;
        if (r116 == 2) goto L32;
        if (r116 == 3) goto L32;
    L34:
        r113.append(g.c(r114 * r103, r112));     // Catch: Throwable -> L37
        tt5.a.h("LruBitmapPool", r113.toString());     // Catch: Throwable -> L37
        a();     // Catch: Throwable -> L37
        monitor-exit(this);
        return r102;
    L32:
        r103 = 2;
        goto L34
    L33:
        r103 = 1;
        goto L34
    L26:
        r115 = r112;
    L19:
        r109 = 2;
        goto L21
    L20:
        r109 = 1;
        goto L21
    L13:
        r107 = r112;
        goto L14
    L22:
        this.f224947f++;     // Catch: Throwable -> L37
        int r117 = this.f224946e;     // Catch: Throwable -> L37
        ((g) this.f224942a).getClass();     // Catch: Throwable -> L37
        this.f224946e = r117 - q95.f.b(r102);     // Catch: Throwable -> L37
        this.f224944c.getClass();     // Catch: Throwable -> L37
        r102.setHasAlpha(true);     // Catch: Throwable -> L37
        goto L23
    L7:
        r101 = f224941j;     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        throw th;
    }
}
