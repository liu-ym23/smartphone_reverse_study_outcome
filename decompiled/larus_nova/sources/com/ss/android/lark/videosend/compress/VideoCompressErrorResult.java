package com.ss.android.lark.videosend.compress;

import com.larksuite.framework.callback.Entity.ErrorResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/videosend/compress/VideoCompressErrorResult;", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "errorCode", "", "debugMsg", "", "<init>", "(ILjava/lang/String;)V", "videoCompressResult", "Lcom/ss/android/lark/videosend/compress/VideoCompressResult;", "getVideoCompressResult", "()Lcom/ss/android/lark/videosend/compress/VideoCompressResult;", "setVideoCompressResult", "(Lcom/ss/android/lark/videosend/compress/VideoCompressResult;)V", "videosend_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VideoCompressErrorResult extends ErrorResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient VideoCompressResult f444891a;

    public final VideoCompressResult getVideoCompressResult() {
        return this.f444891a;
    }

    public final void setVideoCompressResult(VideoCompressResult r100) {
        this.f444891a = r100;
    }

    public VideoCompressErrorResult(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "debugMsg");
        super(r100, r101);
    }
}
