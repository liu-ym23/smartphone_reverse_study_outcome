package com.bytedance.ies.android.base.runtime.depend;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;

/* JADX INFO: loaded from: classes19.dex */
@Deprecated(message = "已废弃", replaceWith = @ReplaceWith(expression = "com.bytedance.android.ad.sdk.api.location.IAdLocationDepend", imports = {}))
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/bytedance/ies/android/base/runtime/depend/IPointDepend;", "", "getCurrentPoint", "Lcom/bytedance/ies/android/base/runtime/depend/PointModel;", "runtime-api_release"}, k = 1, mv = {1, 1, 16})
public interface IPointDepend {
    PointModel getCurrentPoint();
}
