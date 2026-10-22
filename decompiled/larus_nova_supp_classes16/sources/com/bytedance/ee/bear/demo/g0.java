package com.bytedance.ee.bear.demo;

import android.content.Intent;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class g0 implements View.OnClickListener {
    public final /* synthetic */ OfficeCCMDemoActivity a;

    public g0(OfficeCCMDemoActivity r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        Intent r4 = new Intent(this.a, OfficeCCMDemoContainerActivity.class);
        r4.putExtra("demo_url", "https://doubao.com/file/boxcn8j4BOvoLiy04PXblY");
        this.a.startActivity(r4);
    }
}
