package com.larus.office.base.plugins.toolbar.submenu;

import com.larus.office.base.plugins.toolbar.model.Item;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class c implements BaseSubToolbarAdapter.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseSubToolbarV2Fragment<com.larus.office.base.plugins.toolbar.model.a> f360970a;

    public c(BaseSubToolbarV2Fragment<com.larus.office.base.plugins.toolbar.model.a> r100) {
        this.f360970a = r100;
    }

    @Override // com.larus.office.base.plugins.toolbar.submenu.BaseSubToolbarAdapter.b
    public final void a(Item r100) {
        if (r100 == null) goto L5;
        BaseSubToolbarV2Fragment<com.larus.office.base.plugins.toolbar.model.a> r101 = this.f360970a;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "itemV2");
        r101.Y90(r100, r100.getValue());
        return;
    }
}
