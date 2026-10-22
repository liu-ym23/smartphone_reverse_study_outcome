package com.bytedance.ee.bear.sheet.filter;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class x implements FilterPanelColorView.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OfficeSubFilterColorFragment f237878a;

    public x(OfficeSubFilterColorFragment r100) {
        this.f237878a = r100;
    }

    @Override // com.bytedance.ee.bear.sheet.filter.FilterPanelColorView.a
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "color");
        this.f237878a.U90("foregroundColor", new String[]{r100});
    }
}
