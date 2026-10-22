package com.bytedance.ee.bear.middleground.permission.batchauthorize;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.facade.common.BaseActivity;
import com.bytedance.ee.bear.middleground.permission.batchauthorize.model.livedata.AuthorizeStateNode;
import com.bytedance.ee.bear.sheet.inputbar.editor.SheetInputData;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements Observer<AuthorizeStateNode> {
    public final /* synthetic */ BatchAuthorizeActivity a;

    public a(BatchAuthorizeActivity r1) {
        this.a = r1;
    }

    /* JADX WARN: Type inference failed for: r0v11, types: [android.app.Activity, com.bytedance.ee.bear.middleground.permission.batchauthorize.BatchAuthorizeActivity] */
    /* JADX WARN: Type inference failed for: r0v7, types: [android.app.Activity, com.bytedance.ee.bear.middleground.permission.batchauthorize.BatchAuthorizeActivity] */
    public final void onChanged(Object r6) {
        AuthorizeStateNode r7 = (AuthorizeStateNode) r6;
        if (r7 == null) goto L24;
        int r0 = BatchAuthorizeActivity.a.a[r7.getState().ordinal()];
        if (r0 != 1) goto L8;
        this.a.e.setVisibility(8);
    L15:
        BaseActivity r1 = this.a;
        int r2 = r7.getHasPermissionCount();
        int r8 = r7.getNoPermissionCount();
        HashMap r3 = new HashMap();
        String r4 = "";
        if (r2 <= 0) goto L20;
        if (r8 <= 0) goto L19;
        r3.put("num1", r2 + "");
        r3.put("num2", r8 + "");
        r4 = xo5.a.d(r1, 2131887183, r3);
    L22:
        this.a.d.setText(r4);
        return;
    L19:
        r4 = xo5.a.c(r1, 2131887184, SheetInputData.InputData.FormatType.NUMBER, r2 + "");
        goto L22
    L20:
        if (r8 <= 0) goto L22;
        r4 = xo5.a.c(r1, 2131887185, SheetInputData.InputData.FormatType.NUMBER, r8 + "");
        goto L22
    L8:
        if (r0 != 2) goto L10;
        this.a.e.setVisibility(0);
        ?? r5 = this.a;
        r5.e.setText(r5.getString(2131889472));
        goto L15
    L10:
        if (r0 != 3) goto L15;
        this.a.e.setVisibility(0);
        ?? r9 = this.a;
        r9.e.setText(r9.getString(2131887191));
        goto L15
    }
}
