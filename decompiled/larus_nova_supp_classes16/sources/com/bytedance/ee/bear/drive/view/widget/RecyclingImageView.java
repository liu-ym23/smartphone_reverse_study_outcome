package com.bytedance.ee.bear.drive.view.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class RecyclingImageView extends ImageView {

    public static class a extends BitmapDrawable {
        public int a;
        public boolean b;

        public final synchronized void a() {
            monitor-enter(this);
        L12:
            th = move-exception;
            throw th;
        L4:
            if (this.a <= 0) goto L6;
        L10:
            monitor-exit(this);
            return;
        L6:
            if (this.b == false) goto L10;
            if (b() == false) goto L10;
            getBitmap().recycle();     // Catch: Throwable -> L12
            tt5.a.b("RecyclingImageView", "the drawable cache and display ref counts = 0. recycle. ");     // Catch: Throwable -> L12
            goto L10
        }

        public final synchronized boolean b() {
            monitor-enter(this);
            Bitmap r0 = getBitmap();     // Catch: Throwable -> L11
            if (r0 == null) goto L8;
            if (r0.isRecycled() == true) goto L8;
            boolean r1 = true;
        L9:
            monitor-exit(this);
            return r1;
        L8:
            r1 = false;
        L11:
            th = move-exception;
            throw th;
        }

        public a(Resources r1, Bitmap r2) {
            super(r1, r2);
            this.a = 0;
        }
    }

    public RecyclingImageView(Context r1) {
        super(r1);
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap r3) {
        setImageDrawable(new a(getResources(), r3));
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable r4) {
        Drawable r0 = getDrawable();
        if ((r4 instanceof BitmapDrawable) == false) goto L5;
        r4 = new a(getResources(), ((BitmapDrawable) r4).getBitmap());
    L5:
        super.setImageDrawable(r4);
        a(r4, true);
        a(r0, false);
    }

    public RecyclingImageView(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public static void a(Drawable r3, boolean r4) {
        if ((r3 instanceof a) == false) goto L16;
        a r0 = (a) r3;
        monitor-enter(r0);
        if (r4 == false) goto L9;
        r0.a++;     // Catch: Throwable -> L12
        r0.b = true;     // Catch: Throwable -> L12
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
        r0.a();
        return;
    L9:
        r0.a--;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    L16:
        if ((r3 instanceof LayerDrawable) == false) goto L24;
        LayerDrawable r5 = (LayerDrawable) r3;
        int r1 = r5.getNumberOfLayers();
        int r2 = 0;
    L18:
        if (r2 >= r1) goto L25;
        a(r5.getDrawable(r2), r4);
        r2 = r2 + 1;
        goto L18
    L25:
        return;
    }

    public final void b(Bitmap r3, LruBitmapPool r4) {
        BitmapDrawable r0 = new BitmapDrawable(getResources(), r3);
        if (r4 != null) goto L5;
        setImageDrawable(r0);
        return;
    L5:
        Drawable r5 = getDrawable();
        super.setImageDrawable(r0);
        if ((r5 instanceof BitmapDrawable) == false) goto L12;
        Bitmap r6 = ((BitmapDrawable) r5).getBitmap();
        if (r6 == null) goto L13;
        tt5.a.b("RecyclingImageView", "put previous bitmap into bitmap pool. ");
        r4.put(r6);
        return;
    L13:
        return;
    }

    public RecyclingImageView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }
}
