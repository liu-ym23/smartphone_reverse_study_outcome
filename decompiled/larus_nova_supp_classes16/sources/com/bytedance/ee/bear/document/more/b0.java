package com.bytedance.ee.bear.document.more;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.document.export.more.ExportMoreItemV2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b0 implements com.bytedance.ee.bear.more.protocol3.panel.e0 {
    public final /* synthetic */ i a;

    public b0(i r1) {
        this.a = r1;
    }

    public final com.bytedance.ee.bear.more.protocol3.b a(com.bytedance.ee.bear.more.protocol3.panel.x r3, com.bytedance.ee.bear.more.protocol3.panel.e r4) {
        Intrinsics.checkNotNullParameter(r3, "<unused var>");
        Intrinsics.checkNotNullParameter(r4, "<unused var>");
        FragmentActivity r5 = i.a(this.a);
        if (r5 != null) goto L7;
        return null;
    L7:
        return new ExportMoreItemV2(r5, this.a.a, false);
    }
}
