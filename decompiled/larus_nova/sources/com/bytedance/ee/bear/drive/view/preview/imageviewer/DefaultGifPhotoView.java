package com.bytedance.ee.bear.drive.view.preview.imageviewer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.ee.bear.drive.module.nativepreview.model.DriveComponentRenderVM;
import com.bytedance.ee.bear.drive.view.preview.imageviewer.photoview.GifPhotoView;
import com.bytedance.ee.bear.drive.view.preview.wrapper.z;
import com.bytedance.ee.util.ui.n;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.passportc.entity.UserSession;
import i75.m;
import java.io.IOException;
import pl.droidsonroids.gif.GifError;
import pl.droidsonroids.gif.g;
import pl.droidsonroids.gif.j;
import r95.d;
import r95.e;

/* JADX INFO: loaded from: classes16.dex */
public class DefaultGifPhotoView extends GifPhotoView implements d, m85.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.bytedance.ee.bear.drive.view.preview.imageviewer.b f224985d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public n65.b.a f224986e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public pl.droidsonroids.gif.d f224987f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public r95.c f224988g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public b f224989h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public DriveComponentRenderVM f224990i;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DefaultGifPhotoView f224991a;

        public final void a() {
            if (this.f224991a.f224987f.f529709b == false) goto L12;
            tt5.a.h("preview_image", "android-gif-drawable is playing gif");
            View r100 = (View) this.f224991a.getParent();
            if (r100 != null) goto L7;
            return;
        L7:
            if (this.f224991a.getDisplayRect() == null) goto L14;
            float r101 = this.f224991a.getDisplayRect().height();
            float r102 = this.f224991a.getDisplayRect().width();
            float r103 = m.a(r100.getHeight(), r100.getWidth(), r101, r102);
            this.f224991a.setDoubleTapScale(r103);
            n65.b.a r104 = this.f224991a.f224986e;
            if (r104 == null) goto L15;
            ((n65.a.C6901a) r104).a();
            return;
        L15:
            return;
        L14:
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(DefaultGifPhotoView r100) {
            this.f224991a = r100;
        }
    }

    public interface b {
    }

    @Override // r95.d
    public final /* synthetic */ void d() {
    }

    @Override // m85.a
    public String getReleaseKey() {
        return "DefaultGifPhotoView";
    }

    @Override // r95.d
    public String getViewTag() {
        return "DefaultGifPhotoView";
    }

    @Override // m85.a
    public final void onRelease() {
        if (this.f224987f != null) goto L5;
        return;
    L5:
        if ((!((e) this.f224989h).f536715a.isBlockViewChanging()) == false) goto L15;
        tt5.a.h("DefaultGifPhotoView", "recycle gif image view resource");
        this.f224987f.c();     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        tt5.a.f("DefaultGifPhotoView", th, false);
        return;
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f224990i.needBindReleaseListener() == true) goto L6;
        onRelease();
        return;
    }

    public DefaultGifPhotoView(Context r100) {
        super(r100);
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.imageviewer.photoview.GifPhotoView, r95.d
    public void setImageActionListener(n65.b.a r100) {
        this.f224986e = r100;
        super.setImageActionListener(r100);
    }

    @Override // r95.d
    public void setOnPhotoRequestListener(com.bytedance.ee.bear.drive.view.preview.imageviewer.b r100) {
        this.f224985d = r100;
    }

    public DefaultGifPhotoView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    @Override // r95.d
    public final void c(z r110, UserSession r111) {
        tt5.a.h("preview_image", "DefaultGifPhotoView show()");
        String r112 = z75.b.a(r110.f225836d, r111);
        r95.c r100 = this.f224988g;     // Catch: Throwable -> L20
        int r101 = 1;
    L5:
        if (((r100.f536713g * r100.f536714h) / (r101 * r101)) <= ((n.t() * n.v()) * 2)) goto L7;
        r101 = r101 * 2;     // Catch: Throwable -> L20
        goto L5
    L7:
        pl.droidsonroids.gif.e r102 = new pl.droidsonroids.gif.e();     // Catch: Throwable -> L20
        g r103 = r102.f529729b;     // Catch: Throwable -> L20
        r103.getClass();     // Catch: Throwable -> L20
        if (r101 >= 1) goto L10;
    L13:
        r103.f529730a = 1;     // Catch: Throwable -> L20
    L14:
        r102.f529728a = new j.b(r112);     // Catch: Throwable -> L20
        pl.droidsonroids.gif.d r113 = r102.a();     // Catch: Throwable -> L20
        this.f224987f = r113;     // Catch: Throwable -> L20
        setImageDrawable(r113);     // Catch: Throwable -> L20
        tt5.a.h("preview_image", " gif frames = " + this.f224987f.b());     // Catch: Throwable -> L20
        GifError r114 = this.f224987f.a();     // Catch: Throwable -> L20
        if (r114 == GifError.NO_ERROR) goto L18;
        tt5.a.k("preview_image", "GifDrawable fail, errorCode=" + r114.getErrorCode() + ", msg=" + r114.description);     // Catch: Throwable -> L20
        com.bytedance.ee.bear.drive.view.preview.imageviewer.b r104 = this.f224985d;     // Catch: Throwable -> L20
        StringBuilder r105 = new StringBuilder("GifDrawable render fail, errorCode is ");     // Catch: Throwable -> L20
        r105.append(r114.getErrorCode());     // Catch: Throwable -> L20
        r104.b("photo_view", new IOException(r105.toString()), false, true);     // Catch: Throwable -> L20
        return;
    L18:
        this.f224985d.a("photo_view");     // Catch: Throwable -> L20
        this.f224985d.onCompleted();     // Catch: Throwable -> L20
        post(new a(this));     // Catch: Throwable -> L20
        return;
    L10:
        if (r101 > 65535) goto L13;
        r103.f529730a = (char) r101;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        tt5.a.f("DefaultGifPhotoView", th, false);
        this.f224985d.b("photo_view", th, false, true);
    }

    public DefaultGifPhotoView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
