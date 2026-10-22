package com.bytedance.ee.bear.document.more;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.document.print.PrintMoreItemV2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c0 implements com.bytedance.ee.bear.more.protocol3.panel.e0 {
    public final /* synthetic */ i a;

    public c0(i r1) {
        this.a = r1;
    }

    public final com.bytedance.ee.bear.more.protocol3.b a(com.bytedance.ee.bear.more.protocol3.panel.x r2, com.bytedance.ee.bear.more.protocol3.panel.e r3) {
        Intrinsics.checkNotNullParameter(r2, "<unused var>");
        Intrinsics.checkNotNullParameter(r3, "<unused var>");
        FragmentActivity r4 = i.a(this.a);
        if (r4 != null) goto L6;
        return null;
    L6:
        if (PrintMoreItemV2.isPrintEnabled() == true) goto L8;
        return null;
    L8:
        return new PrintMoreItemV2(r4, this.a.a);
    }
}
