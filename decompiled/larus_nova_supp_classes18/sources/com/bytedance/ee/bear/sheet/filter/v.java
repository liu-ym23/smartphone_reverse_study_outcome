package com.bytedance.ee.bear.sheet.filter;

import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.alibaba.fastjson.JSON;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class v<T> implements ValueCallback {
    public final /* synthetic */ OfficeFilterPlugin a;

    public v(OfficeFilterPlugin r1) {
        this.a = r1;
    }

    @Override // android.webkit.ValueCallback
    public final void onReceiveValue(Object r2) {
        String r3 = (String) r2;
        if (TextUtils.isEmpty(r3) == true) goto L8;
        FilterPageData r4 = (FilterPageData) JSON.parseObject(r3, FilterPageData.class);
        FilterViewModel r0 = OfficeFilterPlugin.access$getFilterViewModel$p(this.a);
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("filterViewModel");
        r0 = null;
    L7:
        r0.updateFilterPageData(r4);
    L8:
        tt5.a.b("FilterPlugin", "pagination batch data from JS");
    }
}
