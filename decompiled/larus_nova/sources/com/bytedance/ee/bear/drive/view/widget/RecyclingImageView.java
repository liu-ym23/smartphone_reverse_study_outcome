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

/* JADX INFO: loaded from: classes16.dex */
public class RecyclingImageView extends ImageView {

    public static class a extends BitmapDrawable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f225959a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f225960b;

        public final synchronized void a() {
            monitor-enter(this);
        L12:
            th = move-exception;
            throw th;
        L4:
            if (this.f225959a <= 0) goto L6;
        L10:
            monitor-exit(this);
            return;
        L6:
            if (this.f225960b == false) goto L10;
            if (b() == false) goto L10;
            getBitmap().recycle();     // Catch: Throwable -> L12
            tt5.a.b("RecyclingImageView", "the drawable cache and display ref counts = 0. recycle. ");     // Catch: Throwable -> L12
            goto L10
        }

        public final synchronized boolean b() {
            monitor-enter(this);
            Bitmap r100 = getBitmap();     // Catch: Throwable -> L11
            if (r100 == null) goto L8;
            if (r100.isRecycled() == true) goto L8;
            boolean r101 = true;
        L9:
            monitor-exit(this);
            return r101;
        L8:
            r101 = false;
        L11:
            th = move-exception;
            throw th;
        }

        public a(Resources r100, Bitmap r101) {
            super(r100, r101);
            this.f225959a = 0;
        }
    }

    public RecyclingImageView(Context r100) {
        super(r100);
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap r100) {
        setImageDrawable(new a(getResources(), r100));
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable r100) {
        Drawable r101 = getDrawable();
        if ((r100 instanceof BitmapDrawable) == false) goto L5;
        r100 = new a(getResources(), ((BitmapDrawable) r100).getBitmap());
    L5:
        super.setImageDrawable(r100);
        a(r100, true);
        a(r101, false);
    }

    public RecyclingImageView(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    public static void a(Drawable r100, boolean r101) {
        if ((r100 instanceof a) == false) goto L16;
        a r102 = (a) r100;
        monitor-enter(r102);
        if (r101 == false) goto L9;
        r102.f225959a++;     // Catch: Throwable -> L12
        r102.f225960b = true;     // Catch: Throwable -> L12
    L10:
        monitor-exit(r102);     // Catch: Throwable -> L12
        r102.a();
        return;
    L9:
        r102.f225959a--;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    L16:
        if ((r100 instanceof LayerDrawable) == false) goto L24;
        LayerDrawable r103 = (LayerDrawable) r100;
        int r104 = r103.getNumberOfLayers();
        int r105 = 0;
    L18:
        if (r105 >= r104) goto L25;
        a(r103.getDrawable(r105), r101);
        r105 = r105 + 1;
        goto L18
    L25:
        return;
    }

    public final void b(Bitmap r100, LruBitmapPool r101) {
        BitmapDrawable r102 = new BitmapDrawable(getResources(), r100);
        if (r101 != null) goto L5;
        setImageDrawable(r102);
        return;
    L5:
        Drawable r103 = getDrawable();
        super.setImageDrawable(r102);
        if ((r103 instanceof BitmapDrawable) == false) goto L12;
        Bitmap r104 = ((BitmapDrawable) r103).getBitmap();
        if (r104 == null) goto L13;
        tt5.a.b("RecyclingImageView", "put previous bitmap into bitmap pool. ");
        r101.put(r104);
        return;
    L13:
        return;
    }

    public RecyclingImageView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
