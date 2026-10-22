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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d implements b {
    public static final Bitmap.Config j = null;
    public final e a;
    public final Set<Bitmap.Config> b;
    public final a c;
    public final int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;

    public static class a {
        public a() {
        }
    }

    static {
        j = Bitmap.Config.ARGB_8888;
    }

    public final void a() {
        tt5.a.h("LruBitmapPool", "Hits=" + this.f + ", misses=" + this.g + ", puts=" + this.h + ", evictions=" + this.i + ", currentSize=" + this.e + ", maxSize=" + this.d + "\nStrategy=" + this.a);
    }

    public final void b() {
        int r0 = this.d;
        monitor-enter(this);
    L32:
    L29:
        th = move-exception;
        throw th;
    L5:
        if (this.e <= r0) goto L27;
        g r1 = (g) this.a;     // Catch: Throwable -> L29
        c<g.b, Bitmap> r2 = r1.b;     // Catch: Throwable -> L29
        c.a r3 = r2.a.d;     // Catch: Throwable -> L29
    L7:
        Object r6 = null;
        if (r3.equals(r2.a) == true) goto L18;
        Collection r4 = r3.b;     // Catch: Throwable -> L29
        if (r4 == null) goto L12;
        int r5 = ((ArrayList) r4).size();     // Catch: Throwable -> L29
    L13:
        if (r5 <= 0) goto L15;
        r6 = ListProtector.remove(r3.b, r5 - 1);     // Catch: Throwable -> L29
    L15:
        if (r6 != null) goto L18;
        c.a<K, V> r7 = r3.d;     // Catch: Throwable -> L29
        r7.c = r3.c;     // Catch: Throwable -> L29
        r3.c.d = r7;     // Catch: Throwable -> L29
        ((HashMap) r2.b).remove(r3.a);     // Catch: Throwable -> L29
        ((f) r3.a).offer();     // Catch: Throwable -> L29
        r3 = r3.d;     // Catch: Throwable -> L29
        goto L7
    L12:
        r5 = 0;
    L18:
        Bitmap r8 = (Bitmap) r6;     // Catch: Throwable -> L29
        if (r8 == null) goto L21;
        r1.a(Integer.valueOf(q95.f.b(r8)), r8.getConfig());     // Catch: Throwable -> L29
    L21:
        if (r8 == null) goto L22;
        this.c.getClass();     // Catch: Throwable -> L29
        int r9 = this.e;     // Catch: Throwable -> L29
        ((g) this.a).getClass();     // Catch: Throwable -> L29
        this.e = r9 - q95.f.b(r8);     // Catch: Throwable -> L29
        r8.recycle();     // Catch: Throwable -> L29
        this.i++;     // Catch: Throwable -> L29
        StringBuilder r10 = new StringBuilder();     // Catch: Throwable -> L29
        r10.append("Evicting bitmap=");     // Catch: Throwable -> L29
        ((g) this.a).getClass();     // Catch: Throwable -> L29
        r10.append(g.c(q95.f.b(r8), r8.getConfig()));     // Catch: Throwable -> L29
        tt5.a.b("LruBitmapPool", r10.toString());     // Catch: Throwable -> L29
        a();     // Catch: Throwable -> L29
        goto L32
    L22:
        tt5.a.k("LruBitmapPool", "Size mismatch, resetting");     // Catch: Throwable -> L29
        a();     // Catch: Throwable -> L29
        this.e = 0;     // Catch: Throwable -> L29
        monitor-exit(this);
        return;
    L27:
        monitor-exit(this);
    }

    public d(int r3) {
        g r4 = new g();
        HashSet r0 = new HashSet();
        r0.addAll(Arrays.asList(Bitmap.Config.values()));
        r0.add(null);
        Set<Bitmap.Config> r1 = Collections.unmodifiableSet(r0);
        this.d = 16384;
        this.a = r4;
        this.b = r1;
        this.c = new a();
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.bitmap_recycle.b
    public final synchronized boolean put(Bitmap r5) {
        monitor-enter(this);
        if (r5 == null) goto L22;
        if (r5.isMutable() == false) goto L17;
        ((g) this.a).getClass();     // Catch: Throwable -> L15
        if (q95.f.b(r5) > this.d) goto L17;
        if (this.b.contains(r5.getConfig()) == false) goto L17;
        ((g) this.a).getClass();     // Catch: Throwable -> L15
        int r1 = q95.f.b(r5);     // Catch: Throwable -> L15
        ((g) this.a).e(r5);     // Catch: Throwable -> L15
        this.c.getClass();     // Catch: Throwable -> L15
        this.h++;     // Catch: Throwable -> L15
        this.e += r1;     // Catch: Throwable -> L15
        StringBuilder r2 = new StringBuilder("Put bitmap in pool=");     // Catch: Throwable -> L15
        ((g) this.a).getClass();     // Catch: Throwable -> L15
        r2.append(g.c(q95.f.b(r5), r5.getConfig()));     // Catch: Throwable -> L15
        tt5.a.h("LruBitmapPool", r2.toString());     // Catch: Throwable -> L15
        a();     // Catch: Throwable -> L15
        b();     // Catch: Throwable -> L15
        monitor-exit(this);
        return true;
    L17:
        StringBuilder r3 = new StringBuilder("Reject bitmap from pool, bitmap: ");     // Catch: Throwable -> L15
        ((g) this.a).getClass();     // Catch: Throwable -> L15
        r3.append(g.c(q95.f.b(r5), r5.getConfig()));     // Catch: Throwable -> L15
        r3.append(", is mutable: ");     // Catch: Throwable -> L15
        r3.append(r5.isMutable());     // Catch: Throwable -> L15
        r3.append(", is allowed config: ");     // Catch: Throwable -> L15
        r3.append(this.b.contains(r5.getConfig()));     // Catch: Throwable -> L15
        tt5.a.h("LruBitmapPool", r3.toString());     // Catch: Throwable -> L15
        monitor-exit(this);
        return false;
    L22:
        throw new NullPointerException("Bitmap must not be null");     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.bitmap_recycle.b
    public final synchronized Bitmap get(int r1, int r2, Bitmap.Config r3) {
        monitor-enter(this);
        Bitmap r4 = getDirty(r1, r2, r3);     // Catch: Throwable -> L8
        if (r4 == null) goto L6;
        r4.eraseColor(0);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return r4;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.bitmap_recycle.b
    public final synchronized Bitmap getDirty(int r12, int r13, Bitmap.Config r14) {
        monitor-enter(this);
        e r2 = this.a;     // Catch: Throwable -> L37
        if (r14 == null) goto L7;
        Bitmap.Config r3 = r14;
    L8:
        Bitmap r4 = ((g) r2).b(r12, r13, r3);     // Catch: Throwable -> L37
        int r5 = 4;
        if (r4 != null) goto L22;
        StringBuilder r8 = new StringBuilder("Missing bitmap=");     // Catch: Throwable -> L37
        ((g) this.a).getClass();     // Catch: Throwable -> L37
        int r1 = q95.f.a;     // Catch: Throwable -> L37
        int r6 = r12 * r13;     // Catch: Throwable -> L37
        if (r14 != null) goto L13;
        Bitmap.Config r9 = Bitmap.Config.ARGB_8888;     // Catch: Throwable -> L37
    L14:
        int r10 = q95.f.a.a[r9.ordinal()];     // Catch: Throwable -> L37
        if (r10 == 1) goto L20;
        if (r10 == 2) goto L19;
        if (r10 == 3) goto L19;
        int r11 = 4;
    L21:
        r8.append(g.c(r6 * r11, r14));     // Catch: Throwable -> L37
        tt5.a.b("LruBitmapPool", r8.toString());     // Catch: Throwable -> L37
        this.g++;     // Catch: Throwable -> L37
    L23:
        StringBuilder r7 = new StringBuilder("Get bitmap=");     // Catch: Throwable -> L37
        ((g) this.a).getClass();     // Catch: Throwable -> L37
        int r16 = r12 * r13;     // Catch: Throwable -> L37
        if (r14 != null) goto L26;
        Bitmap.Config r17 = Bitmap.Config.ARGB_8888;     // Catch: Throwable -> L37
    L27:
        int r18 = q95.f.a.a[r17.ordinal()];     // Catch: Throwable -> L37
        if (r18 == 1) goto L33;
        if (r18 == 2) goto L32;
        if (r18 == 3) goto L32;
    L34:
        r7.append(g.c(r16 * r5, r14));     // Catch: Throwable -> L37
        tt5.a.h("LruBitmapPool", r7.toString());     // Catch: Throwable -> L37
        a();     // Catch: Throwable -> L37
        monitor-exit(this);
        return r4;
    L32:
        r5 = 2;
        goto L34
    L33:
        r5 = 1;
        goto L34
    L26:
        r17 = r14;
    L19:
        r11 = 2;
        goto L21
    L20:
        r11 = 1;
        goto L21
    L13:
        r9 = r14;
        goto L14
    L22:
        this.f++;     // Catch: Throwable -> L37
        int r19 = this.e;     // Catch: Throwable -> L37
        ((g) this.a).getClass();     // Catch: Throwable -> L37
        this.e = r19 - q95.f.b(r4);     // Catch: Throwable -> L37
        this.c.getClass();     // Catch: Throwable -> L37
        r4.setHasAlpha(true);     // Catch: Throwable -> L37
        goto L23
    L7:
        r3 = j;     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        throw th;
    }
}
