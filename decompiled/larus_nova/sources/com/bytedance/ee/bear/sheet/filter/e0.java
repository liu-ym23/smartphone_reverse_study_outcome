package com.bytedance.ee.bear.sheet.filter;

import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class e0 implements FilterPanelColorView.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SubFilterColorFragment f237847a;

    @Override // com.bytedance.ee.bear.sheet.filter.FilterPanelColorView.c
    public final void a() {
        UDCheckBox r100 = this.f237847a.f237789p;
        FilterPanelColorView r101 = null;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("noneOption");
        r100 = null;
    L5:
        r100.setChecked(false);
        FilterPanelColorView r102 = this.f237847a.f237791r;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("backgroundColorView");
    L9:
        r101.setChecked(false);
        return;
    L8:
        r101 = r102;
        goto L9
    }

    public e0(SubFilterColorFragment r100) {
        this.f237847a = r100;
    }
}
