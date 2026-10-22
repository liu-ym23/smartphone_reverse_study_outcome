package com.bytedance.ee.bear.sheet.filter;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c0 implements FilterPanelColorView.a {
    public final /* synthetic */ SubFilterColorFragment a;

    public c0(SubFilterColorFragment r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.sheet.filter.FilterPanelColorView.a
    public final void a(String r4) {
        Intrinsics.checkNotNullParameter(r4, "color");
        this.a.U90("foregroundColor", new String[]{r4});
    }
}
