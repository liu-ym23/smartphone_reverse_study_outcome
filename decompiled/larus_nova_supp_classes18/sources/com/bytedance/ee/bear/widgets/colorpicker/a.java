package com.bytedance.ee.bear.widgets.colorpicker;

import android.view.View;
import com.bytedance.ee.bear.widgets.t;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a extends t {
    public final /* synthetic */ CommonColorPicker.SelectColorAdapter c;
    public final /* synthetic */ String d;

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r3) {
        Intrinsics.checkNotNullParameter(r3, "v");
        CommonColorPicker.SelectColorAdapter r4 = this.c;
        String[] r0 = r4.a;
        String r1 = this.d;
        r4.a = r0;
        r4.b = r1;
        r4.notifyDataSetChanged();
        CommonColorPicker.c r5 = this.c.c;
        if (r5 == null) goto L6;
        r5.a(this.d);
        return;
    }

    public a(CommonColorPicker.SelectColorAdapter r1, String r2) {
        this.c = r1;
        this.d = r2;
    }
}
