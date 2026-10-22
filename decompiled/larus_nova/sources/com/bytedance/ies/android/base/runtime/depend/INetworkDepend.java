package com.bytedance.ies.android.base.runtime.depend;

import com.alipay.sdk.m.p.e;
import com.bytedance.ies.android.base.runtime.network.RequestMethod;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import q06.a;
import q06.b;
import q06.c;

/* JADX INFO: loaded from: classes19.dex */
@Deprecated(message = "已废弃", replaceWith = @ReplaceWith(expression = "com.bytedance.android.ad.sdk.api.IAdNetworkDepend", imports = {}))
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u001a\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¨\u0006\n"}, d2 = {"Lcom/bytedance/ies/android/base/runtime/depend/INetworkDepend;", "", "Lcom/bytedance/ies/android/base/runtime/network/RequestMethod;", e.f25671s, "Lq06/c;", "request", "Lq06/b;", "requestForString", "Lq06/a;", "requestForStream", "runtime-api_release"}, k = 1, mv = {1, 4, 0})
public interface INetworkDepend {
    a requestForStream(RequestMethod r100, c r101);

    b requestForString(RequestMethod r100, c r101);
}
