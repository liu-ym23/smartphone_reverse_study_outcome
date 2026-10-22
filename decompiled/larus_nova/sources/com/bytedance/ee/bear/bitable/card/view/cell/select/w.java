package com.bytedance.ee.bear.bitable.card.view.cell.select;

import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.bytedance.ee.bear.widgets.colorpicker.CommonColorSchemeView;

/* JADX INFO: loaded from: classes15.dex */
public final class w implements CommonColorSchemeView.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t f208186a;

    public w(t r100) {
        this.f208186a = r100;
    }

    @Override // com.bytedance.ee.bear.widgets.colorpicker.CommonColorSchemeView.a
    public final void G30(String r100) {
        t.w(this.f208186a, r100, BitableAnalytic.SelectSceneClickType.CHANGE_SATURATION);
    }

    @Override // com.bytedance.ee.bear.widgets.colorpicker.CommonColorSchemeView.a
    public final void Kr(String r100) {
        t.w(this.f208186a, r100, BitableAnalytic.SelectSceneClickType.CHANGE_COLOR);
    }
}
