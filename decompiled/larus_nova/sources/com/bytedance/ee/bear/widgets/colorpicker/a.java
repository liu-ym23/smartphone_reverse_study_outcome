package com.bytedance.ee.bear.widgets.colorpicker;

import android.view.View;
import com.bytedance.ee.bear.widgets.t;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class a extends t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ CommonColorPicker.SelectColorAdapter f240185c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f240186d;

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        CommonColorPicker.SelectColorAdapter r101 = this.f240185c;
        String[] r102 = r101.f240163a;
        String r103 = this.f240186d;
        r101.f240163a = r102;
        r101.f240164b = r103;
        r101.notifyDataSetChanged();
        CommonColorPicker.c r104 = this.f240185c.f240165c;
        if (r104 == null) goto L6;
        r104.a(this.f240186d);
        return;
    }

    public a(CommonColorPicker.SelectColorAdapter r100, String r101) {
        this.f240185c = r100;
        this.f240186d = r101;
    }
}
