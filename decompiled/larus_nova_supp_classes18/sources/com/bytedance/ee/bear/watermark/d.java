package com.bytedance.ee.bear.watermark;

import com.ss.android.lark.watermark.core.IGetWaterMarkResourceCallback;
import io.reactivex.SingleEmitter;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d implements IGetWaterMarkResourceCallback {
    public final /* synthetic */ SingleEmitter a;

    public final void onGetFailed() {
        if (this.a.isDisposed() == true) goto L6;
        tt5.a.d("WatermarkManager", "getWatermarkedImage, watermarked image failed");
        this.a.onError(new Exception("getWatermarkedImage failed"));
        return;
    }

    public d(SingleEmitter r1) {
        this.a = r1;
    }

    public final void onGetSuccess(String r2, ByteString r3) {
        if (this.a.isDisposed() == true) goto L6;
        tt5.a.h("WatermarkManager", "getWatermarkedImage, [image export] success, byteString length = " + r3.size());
        this.a.onSuccess(r3);
        return;
    }
}
