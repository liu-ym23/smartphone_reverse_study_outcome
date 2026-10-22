package com.bytedance.ee.bear.middleground.permission.secret;

import android.view.View;
import com.bytedance.ee.bear.secret.SecretApprovalInstanceModel;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ SecretApprovalInstanceModel.Instance a;
    public final /* synthetic */ ApprovalRecordFragment.a b;
    public final /* synthetic */ ApprovalRecordFragment c;

    public b(SecretApprovalInstanceModel.Instance r1, ApprovalRecordFragment.a r2, ApprovalRecordFragment r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r19) {
        SecretApprovalInstanceModel.Instance r1 = this.a;
        if (r1 == null) goto L14;
        ApprovalRecordFragment.a r2 = this.b;
        ApprovalRecordFragment r3 = this.c;
        b0.d(r1.getInstance_code());
        int r4 = r2.getData().size();
        boolean r5 = true;
        if (r4 == 1) goto L8;
        r5 = false;
    L8:
        String r6 = r3.m;
        String r7 = com.bytedance.ee.bear.middleground.permission.c.a;
        Intrinsics.checkNotNullParameter("check_progress", "click");
        Intrinsics.checkNotNullParameter("none", "target");
        Intrinsics.checkNotNullParameter(r6, "viewFrom");
        JSONObject r8 = new JSONObject();
        String r9 = com.bytedance.ee.bear.middleground.permission.c.f;
        int r10 = com.bytedance.ee.bear.middleground.permission.c.g;
        if (com.bytedance.ee.bear.middleground.permission.c.c == false) goto L11;
        String r11 = ThumbGlideUrl.SOURCE_VC;
    L12:
        com.bytedance.ee.bear.middleground.permission.c.a(r8, r9, r10, r11, com.bytedance.ee.bear.middleground.permission.c.h, com.bytedance.ee.bear.middleground.permission.c.d, com.bytedance.ee.bear.middleground.permission.c.e, com.bytedance.ee.bear.middleground.permission.c.a, com.bytedance.ee.bear.middleground.permission.c.b, com.bytedance.ee.bear.middleground.permission.c.i);
        r8.put("is_single_apply", r5);
        r8.put("view_from", r6);
        r8.put("click", "check_progress");
        r8.put("target", "none");
        com.bytedance.ee.bear.middleground.permission.c.c("ccm_permission_security_resubmit_toast_click", r8);
        return;
    L11:
        r11 = "none";
        goto L12
    }
}
