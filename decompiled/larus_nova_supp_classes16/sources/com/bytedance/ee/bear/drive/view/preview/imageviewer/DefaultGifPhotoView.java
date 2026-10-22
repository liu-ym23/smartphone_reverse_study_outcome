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
import pl.droidsonroids.gif.f;
import pl.droidsonroids.gif.g;
import pl.droidsonroids.gif.j;
import r95.d;
import r95.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class DefaultGifPhotoView extends GifPhotoView implements d, m85.a {
    public com.bytedance.ee.bear.drive.view.preview.imageviewer.b d;
    public n65.b.a e;
    public pl.droidsonroids.gif.d f;
    public r95.c g;
    public b h;
    public DriveComponentRenderVM i;

    public class a implements Runnable {
        public final /* synthetic */ DefaultGifPhotoView a;

        public final void a() {
            if (this.a.f.b == false) goto L12;
            tt5.a.h("preview_image", "android-gif-drawable is playing gif");
            View r0 = (View) this.a.getParent();
            if (r0 != null) goto L7;
            return;
        L7:
            if (this.a.getDisplayRect() == null) goto L14;
            float r1 = this.a.getDisplayRect().height();
            float r2 = this.a.getDisplayRect().width();
            float r3 = m.a(r0.getHeight(), r0.getWidth(), r1, r2);
            this.a.setDoubleTapScale(r3);
            n65.b.a r4 = this.a.e;
            if (r4 == null) goto L15;
            ((n65.a.C0260a) r4).a();
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

        public a(DefaultGifPhotoView r1) {
            this.a = r1;
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
        if (this.f != null) goto L5;
        return;
    L5:
        if ((!((e) this.h).a.isBlockViewChanging()) == false) goto L15;
        tt5.a.h("DefaultGifPhotoView", "recycle gif image view resource");
        this.f.c();     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        tt5.a.f("DefaultGifPhotoView", th, false);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.widget.ImageView*/.onDetachedFromWindow();
        if (this.i.needBindReleaseListener() == true) goto L6;
        onRelease();
        return;
    }

    public DefaultGifPhotoView(Context r1) {
        super(r1);
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.imageviewer.photoview.GifPhotoView, r95.d
    public void setImageActionListener(n65.b.a r1) {
        this.e = r1;
        super.setImageActionListener(r1);
    }

    @Override // r95.d
    public void setOnPhotoRequestListener(com.bytedance.ee.bear.drive.view.preview.imageviewer.b r1) {
        this.d = r1;
    }

    public DefaultGifPhotoView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // r95.d
    public final void c(z r11, UserSession r12) {
        tt5.a.h("preview_image", "DefaultGifPhotoView show()");
        String r13 = z75.b.a(r11.d, r12);
        r95.c r6 = this.g;     // Catch: Throwable -> L20
        int r8 = 1;
    L5:
        if (((r6.g * r6.h) / (r8 * r8)) <= ((n.t() * n.v()) * 2)) goto L7;
        r8 = r8 * 2;     // Catch: Throwable -> L20
        goto L5
    L7:
        pl.droidsonroids.gif.e r7 = new pl.droidsonroids.gif.e();     // Catch: Throwable -> L20
        g r9 = ((f) r7).b;     // Catch: Throwable -> L20
        r9.getClass();     // Catch: Throwable -> L20
        if (r8 >= 1) goto L10;
    L13:
        r9.a = 1;     // Catch: Throwable -> L20
    L14:
        ((f) r7).a = new j.b(r13);     // Catch: Throwable -> L20
        pl.droidsonroids.gif.d r14 = r7.a();     // Catch: Throwable -> L20
        this.f = r14;     // Catch: Throwable -> L20
        setImageDrawable(r14);     // Catch: Throwable -> L20
        tt5.a.h("preview_image", " gif frames = " + this.f.b());     // Catch: Throwable -> L20
        GifError r16 = this.f.a();     // Catch: Throwable -> L20
        if (r16 == GifError.NO_ERROR) goto L18;
        tt5.a.k("preview_image", "GifDrawable fail, errorCode=" + r16.getErrorCode() + ", msg=" + r16.description);     // Catch: Throwable -> L20
        com.bytedance.ee.bear.drive.view.preview.imageviewer.b r2 = this.d;     // Catch: Throwable -> L20
        StringBuilder r4 = new StringBuilder("GifDrawable render fail, errorCode is ");     // Catch: Throwable -> L20
        r4.append(r16.getErrorCode());     // Catch: Throwable -> L20
        r2.b("photo_view", new IOException(r4.toString()), false, true);     // Catch: Throwable -> L20
        return;
    L18:
        this.d.a("photo_view");     // Catch: Throwable -> L20
        this.d.onCompleted();     // Catch: Throwable -> L20
        post(new a(this));     // Catch: Throwable -> L20
        return;
    L10:
        if (r8 > 65535) goto L13;
        r9.a = (char) r8;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        tt5.a.f("DefaultGifPhotoView", th, false);
        this.d.b("photo_view", th, false, true);
    }

    public DefaultGifPhotoView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }
}
