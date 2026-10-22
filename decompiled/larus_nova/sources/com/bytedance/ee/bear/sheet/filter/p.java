package com.bytedance.ee.bear.sheet.filter;

import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.alibaba.fastjson.JSON;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class p<T> implements ValueCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FilterPlugin f237866a;

    public p(FilterPlugin r100) {
        this.f237866a = r100;
    }

    @Override // android.webkit.ValueCallback
    public final void onReceiveValue(Object r100) {
        String r101 = (String) r100;
        if (TextUtils.isEmpty(r101) == true) goto L8;
        FilterPageData r102 = (FilterPageData) JSON.parseObject(r101, FilterPageData.class);
        FilterViewModel r103 = FilterPlugin.access$getFilterViewModel$p(this.f237866a);
        if (r103 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("filterViewModel");
        r103 = null;
    L7:
        r103.updateFilterPageData(r102);
    L8:
        tt5.a.b("FilterPlugin", "pagination batch data from JS");
    }
}
