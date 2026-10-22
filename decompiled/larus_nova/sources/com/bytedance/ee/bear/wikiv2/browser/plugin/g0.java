package com.bytedance.ee.bear.wikiv2.browser.plugin;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.Base64;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import java.io.ByteArrayOutputStream;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class g0 extends SimpleTarget<Bitmap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ThumbGlideUrl f240551a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ tb5.m f240552b;

    @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
    public final void onLoadFailed(Drawable r100) {
        tt5.a.h(WikiFolderThumbnailPlugin.TAG, "onLoadFailed isDefault is " + this.f240551a.isIcon());
        Result r101 = new Result(-1, new ThumbnailData(this.f240551a.isIcon(), ""));
        tb5.m r102 = this.f240552b;
        if (r102 == null) goto L6;
        r102.a(r101);
        return;
    }

    public g0(ThumbGlideUrl r100, tb5.m r101) {
        this.f240551a = r100;
        this.f240552b = r101;
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void onResourceReady(Object r100, Transition r101) {
        Bitmap r102 = (Bitmap) r100;
        Intrinsics.checkNotNullParameter(r102, "resource");
        tt5.a.h(WikiFolderThumbnailPlugin.TAG, "onResourceReady isDefault is " + this.f240551a.isIcon());     // Catch: Throwable -> L7
        ThumbGlideUrl r103 = this.f240551a;     // Catch: Throwable -> L7
        tb5.m r104 = this.f240552b;     // Catch: Throwable -> L7
        ByteArrayOutputStream r105 = new ByteArrayOutputStream();     // Catch: Throwable -> L7
        r102.compress(Bitmap.CompressFormat.PNG, 100, r105);     // Catch: Throwable -> L7
        Result r106 = new Result(0, new ThumbnailData(r103.isIcon(), Base64.encodeToString(r105.toByteArray(), 0)));     // Catch: Throwable -> L7
        if (r104 == null) goto L12;
        r104.a(r106);     // Catch: Throwable -> L7
        return;
    L12:
        return;
    L7:
        th = move-exception;
        tt5.a.d(WikiFolderThumbnailPlugin.TAG, "set thumbnail fail " + th.getMessage());
        iu5.d.a(WikiFolderThumbnailPlugin.TAG, th);
    }
}
