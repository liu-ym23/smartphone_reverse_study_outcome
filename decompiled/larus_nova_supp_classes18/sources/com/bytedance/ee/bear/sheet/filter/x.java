package com.bytedance.ee.bear.sheet.filter;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class x implements FilterPanelColorView.a {
    public final /* synthetic */ OfficeSubFilterColorFragment a;

    public x(OfficeSubFilterColorFragment r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.sheet.filter.FilterPanelColorView.a
    public final void a(String r4) {
        Intrinsics.checkNotNullParameter(r4, "color");
        this.a.U90("foregroundColor", new String[]{r4});
    }
}
