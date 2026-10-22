package com.bytedance.ee.bear.demo;

import android.content.Intent;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class s0 implements View.OnClickListener {
    public final /* synthetic */ OfficeCCMDemoActivity a;

    public s0(OfficeCCMDemoActivity r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        Intent r4 = new Intent(this.a, OfficeCCMDemoContainerActivity.class);
        r4.putExtra("demo_url", "https://doubao.com/docx/DBj7d1HkyoZBbFxRDQ5c6FfKnxb");
        this.a.startActivity(r4);
    }
}
