package com.lynx.animax.drawable;

import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.hardware.HardwareBuffer;
import android.os.Build;
import android.view.View;
import com.lynx.animax.util.AnimaXLog;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes32.dex */
public class BitmapBufferGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference<BitmapBuffer> f380276a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentLinkedQueue<BitmapBuffer> f380277b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f380278c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final WeakReference<View> f380279d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f380280e;

    public final void a() {
    L2:
        BitmapBuffer r100 = this.f380277b.poll();
        if (r100 == null) goto L5;
        r100.a();
        goto L2
    L5:
        BitmapBuffer r101 = this.f380276a.getAndSet(null);
        if (r101 == null) goto L10;
        r101.a();
        return;
    }

    public BitmapBuffer getBitmapBufferForOffscreenRendering() {
        return this.f380277b.peek();
    }

    public void onBufferUpdate() {
        BitmapBuffer r100 = this.f380277b.peek();
        if (r100 == null) goto L23;
        BitmapBuffer.BufferState r101 = r100.f380274c.get();
        BitmapBuffer.BufferState r102 = BitmapBuffer.BufferState.Ready;
        if (r101 != r102) goto L25;
        BitmapBuffer r103 = this.f380276a.getAndSet(r100);
        if (r103 == null) goto L11;
        BitmapBuffer.BufferState r104 = BitmapBuffer.BufferState.NotReady;
        r103.f380274c.set(r104);
        this.f380277b.offer(r103);
    L11:
        if (r100.f380274c.get() == r102) goto L18;
        if (r103 == null) goto L14;
        this.f380277b.remove(r103);
        r103.a();
    L14:
        BitmapBuffer r105 = this.f380276a.getAndSet(null);
        if (r105 == null) goto L22;
        r105.a();
        return;
    L22:
        return;
    L18:
        this.f380277b.remove(r100);
        View r106 = this.f380279d.get();
        if (r106 == null) goto L24;
        r106.postInvalidate();
        return;
    L24:
        return;
    L25:
        return;
    }

    public BitmapBufferGroup(View r100) {
        this.f380276a = new AtomicReference();
        this.f380279d = new WeakReference(r100);
        this.f380280e = true;
        this.f380277b = new ConcurrentLinkedQueue();
        this.f380278c = 3;
    }

    public final BitmapBuffer c(BitmapBuffer r100) {
        BitmapBuffer r101 = this.f380276a.get();
        if (r101 != null) goto L5;
        return r100;
    L5:
        if (r101.f380274c.get() != BitmapBuffer.BufferState.Ready) goto L12;
        if (r100 == null) goto L10;
        BitmapBuffer.BufferState r102 = BitmapBuffer.BufferState.NotReady;
        r100.f380274c.set(r102);
        this.f380277b.offer(r100);
    L10:
        return this.f380276a.getAndSet(null);
    L12:
        return r100;
    }

    public final void b(int r110, int r111) {
        if (r110 <= 0) goto L55;
        if (r111 <= 0) goto L64;
        a();
        if (r110 <= 0) goto L63;
        if (r111 <= 0) goto L65;
        int r112 = 0;
    L12:
        if (r112 >= this.f380278c) goto L66;
        ConcurrentLinkedQueue<BitmapBuffer> r113 = this.f380277b;
        boolean r100 = this.f380280e;
        int r101 = Build.VERSION.SDK_INT;
        boolean r114 = true;
        if (r101 < 26) goto L21;
        if (r100 == false) goto L20;
        if (r101 < 29) goto L18;
        boolean r102 = true;
    L19:
        if (r102 == false) goto L21;
    L18:
        r102 = false;
    L20:
        boolean r103 = true;
    L22:
        Bitmap r115 = null;
        if (r103 == false) goto L41;
        if (r110 <= 0) goto L41;
        if (r111 <= 0) goto L41;
        if (r100 == false) goto L30;
        long r104 = 304;
    L56:
        HardwareBuffer r105 = HardwareBuffer.create(r110, r111, 1, 1, r104);     // Catch: Exception -> L39
    L43:
        if (Build.VERSION.SDK_INT >= 29) goto L46;
        r114 = false;
    L46:
        if (r114 == false) goto L52;
        if (r105 == null) goto L52;
        r115 = Bitmap.wrapHardwareBuffer(r105, ColorSpace.get(ColorSpace.Named.SRGB));     // Catch: Exception -> L50
    L50:
        e = move-exception;
        AnimaXLog.a("BitmapBuffer", "Failed to wrap HardwareBuffer: " + e.getMessage());
        r105.close();
        r105 = null;
    L52:
        if (r115 != null) goto L54;
        r115 = Bitmap.createBitmap(r110, r111, Bitmap.Config.ARGB_8888);
    L54:
        r113.offer(new BitmapBuffer(r115, r105));
        r112 = r112 + 1;
    L39:
        e = move-exception;
        AnimaXLog.a("BitmapBuffer", "Failed to create HardwareBuffer: " + e.getMessage());
        goto L41
    L30:
        if (r101 < 29) goto L32;
        boolean r106 = true;
    L33:
        if (r106 == false) goto L35;
        r104 = 768;
        goto L56
    L35:
        r104 = 515;
        goto L56
    L32:
        r106 = false;
    L41:
        r105 = null;
    L21:
        r103 = false;
        goto L22
    L66:
        return;
    L65:
        return;
    L63:
        return;
    L64:
        return;
    }
}
