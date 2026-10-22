package com.bytedance.ee.bear.middleground.permission.apply;

import android.view.View;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class r0 implements View.OnFocusChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r0 f233069a = null;

    static {
        f233069a = new r0();
    }

    public r0() {
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View r100, boolean r101) {
        if (r101 == false) goto L5;
        int r102 = com.bytedance.ee.bear.bitable.pro.d.f215166a;
        JSONObject r103 = new JSONObject();
        r103.put("click", "comment");
        com.bytedance.ee.bear.bitable.pro.d.b("ccm_bitable_premium_permission_application_click", r103);
        return;
    }
}
