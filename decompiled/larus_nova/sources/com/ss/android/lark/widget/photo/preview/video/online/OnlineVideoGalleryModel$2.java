package com.ss.android.lark.widget.photo.preview.video.online;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chat.entity.media.MediaExtra;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.photo.preview.utils.DownloadCheckUtil;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
class OnlineVideoGalleryModel$2 implements IGetDataCallback<String> {
    final /* synthetic */ g this$0;
    final /* synthetic */ MediaExtra val$mediaExtra;
    final /* synthetic */ IGetDataCallback val$wrapCallback;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ErrorResult f447297a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ OnlineVideoGalleryModel$2 f447298b;

        @Override // java.lang.Runnable
        public final void run() {
            this.f447298b.val$wrapCallback.onError(this.f447297a);     // Catch: Throwable -> L4
            this.f447298b.this$0.f447355b = false;     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(OnlineVideoGalleryModel$2 r100, ErrorResult r101) {
            this.f447298b = r100;
            this.f447297a = r101;
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.larksuite.framework.callback.IGetDataCallback
    public void onError(ErrorResult r100) {
        Log.e("OnlineVideoGalleryModel", "downLoadMessageVideo error:" + r100);
        if (r100.getErrorCode() == com.ss.android.lark.widget.photopicker.f.a().e()) goto L5;
        UICallbackExecutor.executeDelayed(new a(this, r100), 200);
        return;
    L5:
        this.val$wrapCallback.onError(r100);
        this.this$0.f447355b = false;
    }

    public void onSuccess(String r100) {
        int r101 = DownloadCheckUtil.f447128a;
        Intrinsics.checkNotNullParameter(r100, "path");
        com.ss.android.lark.widget.photopicker.f.a().o();
        throw null;
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onError(ErrorResult r100) {
        onError(r100);
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onSuccess(Object r100) {
        onSuccess((String) r100);
    }

    public OnlineVideoGalleryModel$2(g r100, IGetDataCallback r101, MediaExtra r102) {
        this.this$0 = r100;
        this.val$wrapCallback = r101;
        this.val$mediaExtra = r102;
    }
}
