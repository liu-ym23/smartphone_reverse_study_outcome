package com.bytedance.ee.bear.widgets.colorpicker;

import android.view.View;
import com.bytedance.ee.bear.widgets.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b extends t {
    public final /* synthetic */ String c;
    public final /* synthetic */ CommonColorSchemeView.SelectSpecificColorAdapter d;

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r3) {
        CommonColorSchemeView.SelectSpecificColorAdapter r4 = this.d;
        String[] r0 = r4.a;
        String r1 = this.c;
        r4.a = r0;
        r4.b = r1;
        r4.notifyDataSetChanged();
        CommonColorSchemeView.SelectSpecificColorAdapter.a r5 = this.d.c;
        if (r5 == null) goto L8;
        String r2 = this.c;
        CommonColorSchemeView.a r6 = ((dp5.b) r5).a.d;
        if (r6 == null) goto L9;
        r6.G30(r2);
        return;
    L9:
        return;
    }

    public b(CommonColorSchemeView.SelectSpecificColorAdapter r1, String r2) {
        this.d = r1;
        this.c = r2;
    }
}
