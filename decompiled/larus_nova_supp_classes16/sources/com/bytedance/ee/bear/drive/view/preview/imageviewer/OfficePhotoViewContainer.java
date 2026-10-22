package com.bytedance.ee.bear.drive.view.preview.imageviewer;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.ee.bear.drive.module.nativepreview.model.DriveComponentRenderVM;
import com.bytedance.ee.bear.drive.view.preview.wrapper.PreviewViewModel;
import com.bytedance.ee.bear.drive.view.preview.wrapper.z;
import com.bytedance.ee.util.io.FileUtils;
import g85.f;
import i75.m;
import java.io.IOException;
import pl.droidsonroids.gif.GifAnimationMetaData;
import r95.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class OfficePhotoViewContainer extends FrameLayout {
    public final Context a;
    public PreviewViewModel b;
    public DriveComponentRenderVM c;
    public a95.a d;
    public f e;
    public d f;
    public z g;
    public boolean h;
    public b i;

    public class a extends b.a {
        public final /* synthetic */ OfficePhotoViewContainer a;

        @Override // com.bytedance.ee.bear.drive.view.preview.imageviewer.b.a, com.bytedance.ee.bear.drive.view.preview.imageviewer.b
        public final void onCompleted() {
            b r0 = this.a.i;
            if (r0 == null) goto L6;
            r0.onCompleted();
            return;
        }

        public a(OfficePhotoViewContainer r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.drive.view.preview.imageviewer.b.a, com.bytedance.ee.bear.drive.view.preview.imageviewer.b
        public final void a(String r2) {
            b r0 = this.a.i;
            if (r0 == null) goto L6;
            r0.a(r2);
            return;
        }

        @Override // com.bytedance.ee.bear.drive.view.preview.imageviewer.b
        public final void b(String r3, Throwable r4, boolean r5, boolean r6) {
            OfficePhotoViewContainer r0 = this.a;
            if (r0.h == true) goto L6;
            if (r6 == false) goto L6;
            r0.h = true;
            r0.a();
        L6:
            b r1 = this.a.i;
            if (r1 == null) goto L10;
            r1.b(r3, r4, r5, r6);
            return;
        }
    }

    public View getView() {
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a() {
        if (this.g != null) goto L5;
        return;
    L5:
        if (this.d == null) goto L49;
        BitmapFactory.Options r0 = new BitmapFactory.Options();
        boolean r1 = true;
        r0.inJustDecodeBounds = true;
        String r2 = z75.b.a(this.g.d, this.d.b);
        BitmapFactory.decodeFile(r2, r0);
        f r3 = this.e;
        if (r3 == null) goto L12;
        g85.b r4 = (g85.b) r3;
        if (r4.h(this.g.c) == false) goto L12;
        boolean r5 = true;
    L13:
        if (r5 == true) goto L44;
        int r6 = 0;
        int r7 = 0;
        int r8 = 0;
    L25:
        if (m.b(r0.outWidth, r0.outHeight) == false) goto L27;
    L33:
        boolean r9 = true;
    L34:
        boolean r10 = this.g.i;
        if (r0.outWidth > 0) goto L37;
    L39:
        r1 = false;
    L40:
        r95.c r11 = new r95.c();
        r11.a = r5;
        r11.b = r10;
        r11.c = r9;
        r11.d = r1;
        r11.e = r0;
        r11.f = r7;
        r11.g = r8;
        r11.h = r6;
        d r12 = com.bytedance.ee.bear.drive.view.preview.imageviewer.a.a(this.a, r11, this.b, this.c, this.h);
        this.f = r12;
        removeAllViews();
        addView((View) r12, new FrameLayout.LayoutParams(-1, -1));
        this.f.setOnPhotoRequestListener(new a(this));
        this.f.c(this.g, this.d.b);
        return;
    L37:
        if (r0.outHeight <= 0) goto L39;
    L27:
        if (FileUtils.y(r2) >= 31457280) goto L29;
        boolean r13 = true;
    L30:
        if (r13 == true) goto L33;
        r9 = false;
        goto L34
    L29:
        r13 = false;
        goto L30
    L44:
        GifAnimationMetaData r14 = new GifAnimationMetaData(r2);     // Catch: IOException -> L20
        r7 = r14.getNumberOfFrames();     // Catch: IOException -> L20
        r8 = r14.getWidth();     // Catch: IOException -> L19
        r6 = r14.getHeight();     // Catch: IOException -> L18
    L22:
        r5 = false;
        r6 = 0;
    L21:
        r8 = 0;
    L20:
        r7 = 0;
    L12:
        r5 = false;
        goto L13
    }

    public OfficePhotoViewContainer(Context r2) {
        super(r2);
        this.h = false;
        this.a = r2;
        this.e = o75.b.a().getMimeTypeManager();
    }

    public void setDowngrade(boolean r1) {
        this.h = r1;
    }

    public void setOnPhotoRequestListener(b r1) {
        this.i = r1;
    }

    public void setUserAbility(a95.a r1) {
        this.d = r1;
    }

    public OfficePhotoViewContainer(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.h = false;
        this.a = r1;
        this.e = o75.b.a().getMimeTypeManager();
    }
}
