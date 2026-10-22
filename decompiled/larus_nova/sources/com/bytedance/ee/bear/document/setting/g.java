package com.bytedance.ee.bear.document.setting;

import android.widget.CompoundButton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class g implements CompoundButton.OnCheckedChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DocumentSettingActivity f221756a;

    public g(DocumentSettingActivity r100) {
        this.f221756a = r100;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "buttonView");
        if (r100.isPressed() == true) goto L5;
        return;
    L5:
        DocumentSettingActivity r102 = this.f221756a;
        int r103 = DocumentSettingActivity.f221732i;
        r102.C1().leaderAuthClick(r101);
        tt5.a.b("DocumentSettingActivity", "onCheckedChanged " + r101);
    }
}
