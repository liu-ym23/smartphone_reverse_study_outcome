package com.bytedance.ee.bear.document.setting;

import android.widget.CompoundButton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class g implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ DocumentSettingActivity a;

    public g(DocumentSettingActivity r1) {
        this.a = r1;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "buttonView");
        if (r2.isPressed() == true) goto L5;
        return;
    L5:
        DocumentSettingActivity r4 = this.a;
        int r0 = DocumentSettingActivity.i;
        r4.C1().leaderAuthClick(r3);
        tt5.a.b("DocumentSettingActivity", "onCheckedChanged " + r3);
    }
}
