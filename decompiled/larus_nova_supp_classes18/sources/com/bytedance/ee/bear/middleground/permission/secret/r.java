package com.bytedance.ee.bear.middleground.permission.secret;

import android.view.View;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class r extends com.bytedance.ee.bear.widgets.t {
    public final /* synthetic */ UDCheckBox c;

    public r(UDCheckBox r1) {
        this.c = r1;
    }

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r3) {
        String r4 = SecretLevelAdapter.y2();
        StringBuilder r0 = new StringBuilder("setSearchTipsStatus: onClicked, isChecked = ");
        r0.append(!this.c.isChecked());
        Log.i(r4, r0.toString());
        UDCheckBox r5 = this.c;
        r5.setChecked(!r5.isChecked());
    }
}
