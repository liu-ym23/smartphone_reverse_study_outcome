package com.ss.android.lark.watermark.core;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import kotlin.Metadata;
import okio.ByteString;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0003H&¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/watermark/core/IGetWaterMarkResourceCallback;", "", "onGetSuccess", "", "path", "", HTTP.CONTENT_RANGE_BYTES, "Lokio/ByteString;", "onGetFailed", "watermark-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IGetWaterMarkResourceCallback {
    void onGetFailed();

    void onGetSuccess(String r100, ByteString r101);
}
