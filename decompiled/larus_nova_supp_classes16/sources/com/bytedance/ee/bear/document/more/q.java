package com.bytedance.ee.bear.document.more;

import com.ss.android.lark.utils.CarUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class q implements com.bytedance.ee.bear.more.protocol3.panel.e0 {
    public final /* synthetic */ i a;

    public q(i r1) {
        this.a = r1;
    }

    public final com.bytedance.ee.bear.more.protocol3.b a(com.bytedance.ee.bear.more.protocol3.panel.x r2, com.bytedance.ee.bear.more.protocol3.panel.e r3) {
        Intrinsics.checkNotNullParameter(r2, "<unused var>");
        Intrinsics.checkNotNullParameter(r3, "<unused var>");
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.docx.listen_to_doc_android") == true) goto L5;
        return null;
    L5:
        if (CarUtils.a() == false) goto L7;
        return null;
    L7:
        return ((ny4.a) org.koin.java.a.c(ny4.a.class, null, null, 6)).e(this.a.a);
    }
}
