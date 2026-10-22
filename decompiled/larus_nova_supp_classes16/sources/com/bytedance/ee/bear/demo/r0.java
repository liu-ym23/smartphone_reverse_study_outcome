package com.bytedance.ee.bear.demo;

import android.content.Intent;
import android.view.View;
import com.larksuite.component.air.WindowInsetsCompatAirActivity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class r0 implements View.OnClickListener {
    public final /* synthetic */ OfficeCCMDemoActivity a;

    public r0(OfficeCCMDemoActivity r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        WindowInsetsCompatAirActivity r4 = this.a;
        int r0 = OfficeDoubaoUiDemoActivity.g;
        Intrinsics.checkNotNullParameter(r4, "context");
        r4.startActivity(new Intent(r4, OfficeDoubaoUiDemoActivity.class));
    }
}
