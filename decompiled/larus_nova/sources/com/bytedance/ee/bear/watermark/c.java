package com.bytedance.ee.bear.watermark;

import com.ss.android.lark.vfs.VFSPath;
import com.ss.android.lark.watermark.core.IGetWaterMarkResourceCallback;
import io.reactivex.SingleEmitter;
import okio.ByteString;

/* JADX INFO: loaded from: classes18.dex */
public final class c implements IGetWaterMarkResourceCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SingleEmitter f239829a;

    @Override // com.ss.android.lark.watermark.core.IGetWaterMarkResourceCallback
    public final void onGetFailed() {
        if (this.f239829a.isDisposed() == true) goto L6;
        tt5.a.d("WatermarkManager", "getWatermarkedImage, watermarked image failed");
        this.f239829a.onError(new Exception("getWatermarkedImage failed"));
        return;
    }

    public c(SingleEmitter r100) {
        this.f239829a = r100;
    }

    @Override // com.ss.android.lark.watermark.core.IGetWaterMarkResourceCallback
    public final void onGetSuccess(String r100, ByteString r101) {
        if (this.f239829a.isDisposed() == false) goto L5;
        return;
    L5:
        if (r100 != null) goto L7;
        tt5.a.d("WatermarkManager", "getWatermarkedImage, watermarked image path is null");
        this.f239829a.onError(new Exception("getWatermarkedImage, watermarked image path is null"));
        return;
    L7:
        tt5.a.h("WatermarkManager", "getWatermarkedImage, [image export] success, path = ".concat(r100));
        VFSPath r102 = ay4.d.a().z(r100);
        this.f239829a.onSuccess(r102);
    }
}
