package com.bytedance.ee.bear.drive.view.preview.imageviewer;

import android.content.Context;
import com.bytedance.ee.bear.drive.module.nativepreview.model.DriveComponentRenderVM;
import com.bytedance.ee.bear.drive.view.preview.wrapper.PreviewViewModel;
import r95.d;
import r95.e;
import r95.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public static d a(Context r3, r95.c r4, PreviewViewModel r5, DriveComponentRenderVM r6, boolean r7) {
        if (r4.b == false) goto L5;
        d r8 = new ProgressivePhotoView(r3, r5, r6);
    L18:
        tt5.a.h("preview_image", "DrivePhotoViewProvider.of() = " + r8.getViewTag());
        return r8;
    L5:
        boolean r0 = r4.a;
        if (r0 == true) goto L8;
    L11:
        if (r0 == false) goto L13;
    L16:
        d r9 = new DefaultDrivePhotoView(r3, r4);
    L17:
        r8 = r9;
        goto L18
    L13:
        if (r4.c == false) goto L16;
        if (r7 == true) goto L16;
        r9 = new h(r3, r4);
        goto L17
    L8:
        if (r4.f <= 1) goto L11;
        if (r7 == true) goto L11;
        DefaultGifPhotoView r10 = new DefaultGifPhotoView(r3);
        e r11 = new e(r5);
        r10.g = r4;
        r10.h = r11;
        r10.i = r6;
        r6.bindReleaseListener(r10);
        r8 = r10;
        goto L18
    }
}
