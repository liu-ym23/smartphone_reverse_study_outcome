package com.dtf.toyger.base.face;

import android.graphics.Bitmap;
import android.graphics.PointF;
import com.dtf.face.network.APICallback;
import com.dtf.toyger.base.ToygerAttr;
import faceverify.r;
import faceverify.s;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes22.dex */
public interface ToygerFaceCallback extends r<ToygerFaceState, ToygerFaceAttr> {
    @Override // faceverify.r
    /* synthetic */ PointF onAlignDepthPoint(PointF r100);

    /* synthetic */ void onAsyncUpload(int r100, byte[] r101, byte[] r102, boolean r103);

    /* synthetic */ boolean onComplete(int r100, byte[] r101, byte[] r102, boolean r103);

    /* synthetic */ void onEncodeFaceInfo(List<ToygerFaceInfo> r100, APICallback<String> r101);

    /* synthetic */ void onEncodeLoading();

    /* synthetic */ void onEncryptUploadInfo(Map<String, Object> r100);

    @Override // faceverify.r
    /* synthetic */ boolean onEvent(int r100, Map<String, Object> r101);

    /* synthetic */ boolean onHighQualityFrame(Bitmap r100, ToygerAttr r101);

    /* synthetic */ void onNativeDataUpdate(int r100, List<ToygerPairFaceInfo> r101, Map<String, String> r102);

    /* synthetic */ boolean onStateUpdated(s r100, ToygerAttr r101, Map r102);
}
