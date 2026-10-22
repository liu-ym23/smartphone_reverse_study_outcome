package com.bytedance.ies.xbridge.base.runtime.depend;

import i66.b;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H&J\u001a\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u0005\u001a\u00020\u0004H&¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ies/xbridge/base/runtime/depend/IReportADLogResultCallback;", "", "Li66/b;", "result", "", "msg", "", "onSuccess", "", "code", "onFailure", "anniex_release"}, k = 1, mv = {1, 4, 3})
public interface IReportADLogResultCallback {
    void onFailure(int r100, String r101);

    void onSuccess(b r100, String r101);
}
