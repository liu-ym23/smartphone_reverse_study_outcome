package com.bytedance.ee.bear.document.print;

import com.bytedance.ee.util.info.AppInfoUtils;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes16.dex */
public final class n {
    public static int a(int r100) {
        if (Boolean.TRUE.equals(AppInfoUtils.f()) == false) goto L12;
        if (r100 != R.drawable.ud_icon_doc_comment_colorful) goto L8;
        return R.drawable.ud_icon_doc_comment_v2_colorful;
    L8:
        if (r100 != R.drawable.ud_icon_file_doc_colorful) goto L14;
        return R.drawable.ud_icon_file_doc_v2_colorful;
    L14:
        return r100;
    L12:
        return kac.a.b(r100);
    }
}
