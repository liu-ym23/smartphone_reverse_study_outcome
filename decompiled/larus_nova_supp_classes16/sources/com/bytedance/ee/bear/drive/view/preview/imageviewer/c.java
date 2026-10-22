package com.bytedance.ee.bear.drive.view.preview.imageviewer;

import android.graphics.BitmapFactory;
import com.bytedance.ee.bear.drive.view.preview.wrapper.a0;
import java.io.IOException;
import java.util.HashMap;
import r95.w;
import r95.x;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c extends b.a {
    public final /* synthetic */ PhotoViewContainer a;

    @Override // com.bytedance.ee.bear.drive.view.preview.imageviewer.b.a, com.bytedance.ee.bear.drive.view.preview.imageviewer.b
    public final void onCompleted() {
        b r0 = this.a.m;
        if (r0 == null) goto L6;
        r0.onCompleted();
        return;
    }

    public c(PhotoViewContainer r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.imageviewer.b.a, com.bytedance.ee.bear.drive.view.preview.imageviewer.b
    public final void a(String r9) {
        PhotoViewContainer r0 = this.a;
        BitmapFactory.Options r1 = r0.j.e;
        tt5.a.h("preview_image", "preview succeed: " + PhotoViewContainer.c(r1, r9));
        c95.c r2 = r0.o;
        if (r2 == null) goto L6;
        r2.b(r9);
    L6:
        if (r0.f == null) goto L15;
        long r3 = 0;
        if (r1 != null) goto L10;
        long r4 = 0;
    L11:
        if (r1 == null) goto L14;
        r3 = r1.outHeight;
    L14:
        HashMap r5 = new HashMap();
        r5.put("loadImageStartTime", Long.valueOf(r0.l));
        r5.put("imageHeight", Long.valueOf(r3));
        r5.put("imageWidth", Long.valueOf(r4));
        r5.put("openMode", r9);
        r5.put("resultKey", "success");
        r0.f.liveInnerReportMsg().a(new a0(10, r5));
        goto L15
    L10:
        r4 = r1.outWidth;
    L15:
        PhotoViewContainer r6 = this.a;
        r6.d.setCommentClickListener(new w(r6));
        r6.e.g = new x(r6);
        b r7 = this.a.m;
        if (r7 == null) goto L19;
        r7.a(r9);
        return;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.imageviewer.b
    public final void b(String r9, Throwable r10, boolean r11, boolean r12) {
        PhotoViewContainer r0 = this.a;
        if (r0.r == true) goto L23;
        if (r12 == false) goto L23;
        BitmapFactory.Options r1 = r0.j.e;
        tt5.a.h("preview_image", "preview failed: " + PhotoViewContainer.c(r1, r9) + ", error: " + r10);
        if ((r10 instanceof IOException) == true) goto L8;
    L10:
        c95.c r2 = r0.o;
        if (r2 == null) goto L14;
        r2.a(r9, r10);
    L14:
        if (r0.f == null) goto L23;
        long r3 = 0;
        if (r1 != null) goto L18;
        long r4 = 0;
    L19:
        if (r1 == null) goto L22;
        r3 = r1.outHeight;
    L22:
        HashMap r5 = new HashMap();
        r5.put("loadImageStartTime", Long.valueOf(r0.l));
        r5.put("imageHeight", Long.valueOf(r3));
        r5.put("imageWidth", Long.valueOf(r4));
        r5.put("openMode", r9);
        r5.put("resultKey", "nativeFail");
        r0.f.liveInnerReportMsg().a(new a0(10, r5));
        goto L23
    L18:
        r4 = r1.outWidth;
        goto L19
    L8:
        if ("Image format not supported".equalsIgnoreCase(r10.getMessage()) == false) goto L10;
    L23:
        b r6 = this.a.m;
        if (r6 == null) goto L27;
        r6.b(r9, r10, r11, r12);
        return;
    }
}
