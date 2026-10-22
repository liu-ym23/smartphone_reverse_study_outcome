package com.ss.android.lark.videosend.compress;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class h implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MediaCompressUploadTask f444953a;

    @Override // com.ss.android.lark.videosend.compress.l
    public final void onSuccess() {
        Log.i("MediaCompressUploadTask", "compress upload success");
        this.f444953a.f444880a.f444928c.g(System.currentTimeMillis() - this.f444953a.f444882c);
    }

    public h(MediaCompressUploadTask r100) {
        this.f444953a = r100;
    }

    @Override // com.ss.android.lark.videosend.compress.l
    public final void onError(ErrorResult r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
        Log.e("MediaCompressUploadTask", "compress upload error: " + r100);
        this.f444953a.f444880a.f444928c.f(r100);
    }
}
