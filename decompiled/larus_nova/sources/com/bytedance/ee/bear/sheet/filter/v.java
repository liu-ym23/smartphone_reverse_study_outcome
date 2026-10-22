package com.bytedance.ee.bear.sheet.filter;

import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.alibaba.fastjson.JSON;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class v<T> implements ValueCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OfficeFilterPlugin f237876a;

    public v(OfficeFilterPlugin r100) {
        this.f237876a = r100;
    }

    @Override // android.webkit.ValueCallback
    public final void onReceiveValue(Object r100) {
        String r101 = (String) r100;
        if (TextUtils.isEmpty(r101) == true) goto L8;
        FilterPageData r102 = (FilterPageData) JSON.parseObject(r101, FilterPageData.class);
        FilterViewModel r103 = OfficeFilterPlugin.access$getFilterViewModel$p(this.f237876a);
        if (r103 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("filterViewModel");
        r103 = null;
    L7:
        r103.updateFilterPageData(r102);
    L8:
        tt5.a.b("FilterPlugin", "pagination batch data from JS");
    }
}
