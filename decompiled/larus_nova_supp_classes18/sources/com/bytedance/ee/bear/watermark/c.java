package com.bytedance.ee.bear.watermark;

import com.ss.android.lark.vfs.VFSPath;
import com.ss.android.lark.watermark.core.IGetWaterMarkResourceCallback;
import io.reactivex.SingleEmitter;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c implements IGetWaterMarkResourceCallback {
    public final /* synthetic */ SingleEmitter a;

    public final void onGetFailed() {
        if (this.a.isDisposed() == true) goto L6;
        tt5.a.d("WatermarkManager", "getWatermarkedImage, watermarked image failed");
        this.a.onError(new Exception("getWatermarkedImage failed"));
        return;
    }

    public c(SingleEmitter r1) {
        this.a = r1;
    }

    public final void onGetSuccess(String r2, ByteString r3) {
        if (this.a.isDisposed() == false) goto L5;
        return;
    L5:
        if (r2 != null) goto L7;
        tt5.a.d("WatermarkManager", "getWatermarkedImage, watermarked image path is null");
        this.a.onError(new Exception("getWatermarkedImage, watermarked image path is null"));
        return;
    L7:
        tt5.a.h("WatermarkManager", "getWatermarkedImage, [image export] success, path = ".concat(r2));
        VFSPath r4 = ay4.d.a().z(r2);
        this.a.onSuccess(r4);
    }
}
