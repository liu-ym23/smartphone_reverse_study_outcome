package com.bytedance.ee.bear.sheet.filter;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class c0 implements FilterPanelColorView.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SubFilterColorFragment f237843a;

    public c0(SubFilterColorFragment r100) {
        this.f237843a = r100;
    }

    @Override // com.bytedance.ee.bear.sheet.filter.FilterPanelColorView.a
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "color");
        this.f237843a.U90("foregroundColor", new String[]{r100});
    }
}
