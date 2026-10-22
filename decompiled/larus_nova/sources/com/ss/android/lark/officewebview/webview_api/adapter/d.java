package com.ss.android.lark.officewebview.webview_api.adapter;

import com.larus.nova.R;
import com.ss.android.lark.officewebview.base.OfficeWebView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class d {
    public static final OfficeWebViewAdapter a(OfficeWebView r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Object r101 = r100.getTag(R.id.common_webview_adapter);
        if ((r101 instanceof OfficeWebViewAdapter) == false) goto L5;
        OfficeWebViewAdapter r102 = (OfficeWebViewAdapter) r101;
    L6:
        if (r102 == null) goto L8;
        return r102;
    L8:
        OfficeWebViewAdapter r103 = new OfficeWebViewAdapter(r100);
        r100.setTag(R.id.common_webview_adapter, r103);
        return r103;
    L5:
        r102 = null;
        goto L6
    }
}
