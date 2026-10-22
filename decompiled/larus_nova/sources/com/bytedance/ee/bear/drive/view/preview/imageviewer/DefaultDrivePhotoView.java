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

/* JADX INFO: loaded from: classes16.dex */
public class DefaultDrivePhotoView extends PhotoView implements d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f224981c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final r95.c f224982d;

    public class a implements RequestListener<Drawable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f224983a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ DefaultDrivePhotoView f224984b;

        public a(DefaultDrivePhotoView r100, String r101) {
            this.f224984b = r100;
            this.f224983a = r101;
        }

        @Override // com.bumptech.glide.request.RequestListener
        public final boolean onLoadFailed(GlideException r100, Object r101, Target<Drawable> r102, boolean r103) {
            tt5.a.e("preview_image", "glide onLoadFailed(), error=", r100, false);
            b r104 = this.f224984b.f224981c;
            if (r104 == null) goto L5;
            r104.b(this.f224983a, r100, false, false);
        L5:
            return false;
        }

        @Override // com.bumptech.glide.request.RequestListener
        public final boolean onResourceReady(Drawable r100, Object r101, Target<Drawable> r102, DataSource r103, boolean r104) {
            tt5.a.d("preview_image", "glide onResourceReady()");
            b r105 = this.f224984b.f224981c;
            if (r105 == null) goto L5;
            r105.a(this.f224983a);
            this.f224984b.f224981c.onCompleted();
        L5:
            this.f224984b.post(new r95.a(this));
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
    public void setOnPhotoRequestListener(b r100) {
        this.f224981c = r100;
    }

    public DefaultDrivePhotoView(Context r100, r95.c r101) {
        super(r100);
        this.f224982d = r101;
    }

    @Override // r95.d
    public final void c(z r100, UserSession r101) {
        tt5.a.h("preview_image", "default drive photo view show()");
        BitmapFactory.Options r102 = this.f224982d.f536711e;
        int r103 = r102.outHeight;
        int r104 = r102.outWidth;
        if ((r103 * r104) <= ((n.t() * n.v()) * 2)) goto L9;
        int r105 = 1;
    L6:
        if (((r102.outWidth * r102.outHeight) / (r105 * r105)) <= ((n.t() * n.v()) * 2)) goto L8;
        r105 = r105 * 2;
        goto L6
    L8:
        r103 = r102.outHeight / r105;
        r104 = r102.outWidth / r105;
        tt5.a.h("preview_image", "default drive photo view show(), openType = DriveDevPointConstant.COMPRESSION_PREVIEW factor =" + r105);
        String r106 = "compression_image";
    L10:
        Glide.with(getContext()).load(z75.b.a(r100.f225836d, r101)).override(r104, r103).listener(new a(this, r106)).into(this);
        return;
    L9:
        r106 = "photo_view";
        goto L10
    }
}
