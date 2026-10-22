package com.bytedance.ee.larkwebview.webview_api.adapter;

import com.bytedance.ee.larkwebview.base.LarkWebView;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class d {
    public static final LarkWebViewAdapter a(LarkWebView r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Object r101 = r100.getTag(R.id.common_webview_adapter);
        if ((r101 instanceof LarkWebViewAdapter) == false) goto L5;
        LarkWebViewAdapter r102 = (LarkWebViewAdapter) r101;
    L6:
        if (r102 == null) goto L8;
        return r102;
    L8:
        LarkWebViewAdapter r103 = new LarkWebViewAdapter(r100);
        r100.setTag(R.id.common_webview_adapter, r103);
        return r103;
    L5:
        r102 = null;
        goto L6
    }
}
