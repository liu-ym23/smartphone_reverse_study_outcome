package com.larus.im.callback;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bg\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0015\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/larus/im/callback/IIMCallback;", ExifInterface.GPS_DIRECTION_TRUE, "", "mustInMain", "", "onSuccess", "", "result", "(Ljava/lang/Object;)V", "onFailure", "error", "Lcom/larus/im/callback/IIMError;", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IIMCallback<T> {
    boolean mustInMain();

    void onFailure(IIMError r100);

    void onSuccess(T r100);
}
