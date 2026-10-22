package com.obric.miniapp.lynx;

import com.obric.oui.segmentedtab.OTabSegmentedLayout;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes33.dex */
public final class y1 implements OTabSegmentedLayout.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LynxOUIButtonGroupUI f398335a;

    @Override // com.obric.oui.segmentedtab.OTabSegmentedLayout.e
    public final void a() {
    }

    public y1(LynxOUIButtonGroupUI r100) {
        this.f398335a = r100;
    }

    @Override // com.obric.oui.segmentedtab.OTabSegmentedLayout.e
    public final void onSelect(int r100) {
        LynxOUIButtonGroupUI r101 = this.f398335a;
        r101.f397875e = r100;
        if (r101.f397886p == true) goto L6;
        r101.M(r100, (String) CollectionsKt.getOrNull(r101.f397874d, r100));
        return;
    }
}
