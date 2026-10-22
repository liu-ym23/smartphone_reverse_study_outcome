package com.bytedance.ee.bear.watermark;

import com.ss.android.lark.watermark.core.IGetWaterMarkResourceCallback;
import io.reactivex.SingleEmitter;
import okio.ByteString;

/* JADX INFO: loaded from: classes18.dex */
public final class d implements IGetWaterMarkResourceCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SingleEmitter f239830a;

    @Override // com.ss.android.lark.watermark.core.IGetWaterMarkResourceCallback
    public final void onGetFailed() {
        if (this.f239830a.isDisposed() == true) goto L6;
        tt5.a.d("WatermarkManager", "getWatermarkedImage, watermarked image failed");
        this.f239830a.onError(new Exception("getWatermarkedImage failed"));
        return;
    }

    public d(SingleEmitter r100) {
        this.f239830a = r100;
    }

    @Override // com.ss.android.lark.watermark.core.IGetWaterMarkResourceCallback
    public final void onGetSuccess(String r100, ByteString r101) {
        if (this.f239830a.isDisposed() == true) goto L6;
        tt5.a.h("WatermarkManager", "getWatermarkedImage, [image export] success, byteString length = " + r101.size());
        this.f239830a.onSuccess(r101);
        return;
    }
}
