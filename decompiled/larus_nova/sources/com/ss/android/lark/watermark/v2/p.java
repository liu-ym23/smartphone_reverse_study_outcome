package com.ss.android.lark.watermark.v2;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.FrameLayout;
import com.ss.android.lark.watermark.core.IAttachResultCallback;
import com.ss.android.lark.watermark.core.IAttachToBitmapCallback;
import com.ss.android.lark.watermark.core.WatermarkPointContext;
import com.ss.android.lark.watermark.core.WatermarkType;
import com.ss.android.lark.watermark.dto.WatermarkData;
import com.ss.android.lark.watermark.dto.WatermarkInfo;

/* JADX INFO: loaded from: classes38.dex */
public interface p {
    void addWatermarkToBitmap(Bitmap r100, IAttachToBitmapCallback r101);

    void attachWatermark(Activity r100, IAttachResultCallback r101);

    void attachWatermark(Activity r100, boolean r101, IAttachResultCallback r102);

    void attachWatermark(FrameLayout r100, IAttachResultCallback r101);

    void attachWatermark(FrameLayout r100, boolean r101, IAttachResultCallback r102);

    void detachWatermark(Activity r100);

    void detachWatermark(FrameLayout r100);

    WatermarkInfo get();

    WatermarkData getWatermarkData(WatermarkType r100);

    void init(Context r100);

    void tryAddFileWatermarkToBitmap(Bitmap r100, IAttachToBitmapCallback r101, WatermarkType r102, WatermarkPointContext r103);

    void update(WatermarkInfo r100);
}
