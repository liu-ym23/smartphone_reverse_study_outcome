package com.larus.im.callback;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/im/callback/IIMCallbackExt;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/larus/im/callback/IIMCallback;", "onLocalFinish", "", "result", "(Ljava/lang/Object;)V", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IIMCallbackExt<T> extends IIMCallback<T> {
    void onLocalFinish(T r100);
}
