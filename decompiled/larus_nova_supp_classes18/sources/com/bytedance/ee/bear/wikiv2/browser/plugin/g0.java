package com.bytedance.ee.bear.wikiv2.browser.plugin;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.Base64;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import java.io.ByteArrayOutputStream;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g0 extends SimpleTarget<Bitmap> {
    public final /* synthetic */ ThumbGlideUrl a;
    public final /* synthetic */ tb5.m b;

    public final void onLoadFailed(Drawable r4) {
        tt5.a.h(WikiFolderThumbnailPlugin.TAG, "onLoadFailed isDefault is " + this.a.isIcon());
        Result r5 = new Result(-1, new ThumbnailData(this.a.isIcon(), ""));
        tb5.m r0 = this.b;
        if (r0 == null) goto L6;
        r0.a(r5);
        return;
    }

    public g0(ThumbGlideUrl r1, tb5.m r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onResourceReady(Object r6, Transition r7) {
        Bitmap r8 = (Bitmap) r6;
        Intrinsics.checkNotNullParameter(r8, "resource");
        tt5.a.h(WikiFolderThumbnailPlugin.TAG, "onResourceReady isDefault is " + this.a.isIcon());     // Catch: Throwable -> L7
        ThumbGlideUrl r0 = this.a;     // Catch: Throwable -> L7
        tb5.m r1 = this.b;     // Catch: Throwable -> L7
        ByteArrayOutputStream r2 = new ByteArrayOutputStream();     // Catch: Throwable -> L7
        r8.compress(Bitmap.CompressFormat.PNG, 100, r2);     // Catch: Throwable -> L7
        Result r9 = new Result(0, new ThumbnailData(r0.isIcon(), Base64.encodeToString(r2.toByteArray(), 0)));     // Catch: Throwable -> L7
        if (r1 == null) goto L12;
        r1.a(r9);     // Catch: Throwable -> L7
        return;
    L12:
        return;
    L7:
        th = move-exception;
        tt5.a.d(WikiFolderThumbnailPlugin.TAG, "set thumbnail fail " + th.getMessage());
        iu5.d.a(WikiFolderThumbnailPlugin.TAG, th);
    }
}
