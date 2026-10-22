package com.bytedance.ee.bear.drive.view.preview.imageviewer;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.bytedance.ee.bear.drive.view.preview.imageviewer.photoview.PhotoView;
import com.bytedance.ee.bear.drive.view.preview.wrapper.z;
import com.bytedance.ee.util.ui.n;
import com.ss.android.lark.passportc.entity.UserSession;
import r95.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class DefaultDrivePhotoView extends PhotoView implements d {
    public b c;
    public final r95.c d;

    public class a implements RequestListener<Drawable> {
        public final /* synthetic */ String a;
        public final /* synthetic */ DefaultDrivePhotoView b;

        public a(DefaultDrivePhotoView r1, String r2) {
            this.b = r1;
            this.a = r2;
        }

        public final boolean onLoadFailed(GlideException r1, Object r2, Target<Drawable> r3, boolean r4) {
            tt5.a.e("preview_image", "glide onLoadFailed(), error=", r1, false);
            b r5 = this.b.c;
            if (r5 == null) goto L5;
            r5.b(this.a, r1, false, false);
        L5:
            return false;
        }

        public final boolean onResourceReady(Object r1, Object r2, Target r3, DataSource r4, boolean r5) {
            Drawable r6 = (Drawable) r1;
            tt5.a.d("preview_image", "glide onResourceReady()");
            b r7 = this.b.c;
            if (r7 == null) goto L5;
            r7.a(this.a);
            this.b.c.onCompleted();
        L5:
            this.b.post(new r95.a(this));
            return false;
        }
    }

    @Override // r95.d
    public final /* synthetic */ void d() {
    }

    @Override // r95.d
    public String getViewTag() {
        return "DefaultDrivePhotoView";
    }

    @Override // r95.d
    public void setOnPhotoRequestListener(b r1) {
        this.c = r1;
    }

    public DefaultDrivePhotoView(Context r1, r95.c r2) {
        super(r1);
        this.d = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // r95.d
    public final void c(z r8, UserSession r9) {
        tt5.a.h("preview_image", "default drive photo view show()");
        BitmapFactory.Options r1 = this.d.e;
        int r2 = r1.outHeight;
        int r3 = r1.outWidth;
        if ((r2 * r3) <= ((n.t() * n.v()) * 2)) goto L9;
        int r4 = 1;
    L6:
        if (((r1.outWidth * r1.outHeight) / (r4 * r4)) <= ((n.t() * n.v()) * 2)) goto L8;
        r4 = r4 * 2;
        goto L6
    L8:
        r2 = r1.outHeight / r4;
        r3 = r1.outWidth / r4;
        tt5.a.h("preview_image", "default drive photo view show(), openType = DriveDevPointConstant.COMPRESSION_PREVIEW factor =" + r4);
        String r0 = "compression_image";
    L10:
        Glide.with(getContext()).load(z75.b.a(r8.d, r9)).override(r3, r2).listener(new a(this, r0)).into(this);
        return;
    L9:
        r0 = "photo_view";
        goto L10
    }
}
