package com.ss.android.lark.screenprotect.screenshot;

import android.graphics.Bitmap;
import android.view.PixelCopy;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;

/* JADX INFO: loaded from: classes38.dex */
public final class j implements PixelCopy.OnPixelCopyFinishedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IGetDataCallback<Bitmap> f439824a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Bitmap f439825b;

    public j(ShareScreenshotPlugin$shareScreenshot$1$1 r100, Bitmap r101) {
        this.f439824a = r100;
        this.f439825b = r101;
    }

    @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
    public final void onPixelCopyFinished(int r100) {
        if (r100 != 0) goto L4;
        this.f439824a.onSuccess(this.f439825b);
        return;
    L4:
        this.f439824a.onError(new ErrorResult(r100));
    }
}
