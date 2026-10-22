package com.bytedance.bdp.appbase.netapi.base;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H'¨\u0006\u0007"}, d2 = {"Lcom/bytedance/bdp/appbase/netapi/base/RequestCallback;", ExifInterface.GPS_DIRECTION_TRUE, "", "onResult", "", "result", "Lcom/bytedance/bdp/appbase/netapi/base/NetResult;", "bdp-infrastructure_release"}, k = 1, mv = {1, 1, 18})
public interface RequestCallback<T> {
    void onResult(NetResult<T> r100);
}
