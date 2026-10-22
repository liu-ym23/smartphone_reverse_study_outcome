package com.bytedance.ee.bear.debug;

import android.view.View;
import com.bytedance.ee.bear.widgets.BaseTitleBar;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d extends BaseTitleBar.c {
    public final /* synthetic */ AppendParamsActivity k;

    public d(AppendParamsActivity r1) {
        this.k = r1;
        super(2131255142);
    }

    public final void performAction(View r3) {
        this.k.j.add(new AppendParamsActivity.b("", ""));
        this.k.k.notifyDataSetChanged();
    }
}
