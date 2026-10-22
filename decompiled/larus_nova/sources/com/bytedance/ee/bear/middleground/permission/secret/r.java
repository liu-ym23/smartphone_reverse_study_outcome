package com.bytedance.ee.bear.middleground.permission.secret;

import android.view.View;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes18.dex */
public final class r extends com.bytedance.ee.bear.widgets.t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ UDCheckBox f234129c;

    public r(UDCheckBox r100) {
        this.f234129c = r100;
    }

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r100) {
        String r101 = SecretLevelAdapter.y2();
        StringBuilder r102 = new StringBuilder("setSearchTipsStatus: onClicked, isChecked = ");
        r102.append(!this.f234129c.isChecked());
        Log.i(r101, r102.toString());
        UDCheckBox r103 = this.f234129c;
        r103.setChecked(!r103.isChecked());
    }
}
