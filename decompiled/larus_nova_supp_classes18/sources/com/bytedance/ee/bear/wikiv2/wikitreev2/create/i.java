package com.bytedance.ee.bear.wikiv2.wikitreev2.create;

import android.os.Bundle;
import com.bytedance.ee.bear.contract.AnalyticConstant;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.SpaceInfo;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeCtrlView;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i<T> implements Consumer {
    public final /* synthetic */ int a;
    public final /* synthetic */ String b;
    public final /* synthetic */ WikiCreateToFragment c;

    public i(int r1, String r2, WikiCreateToFragment r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r5) {
        TreeNode r6 = (TreeNode) r5;
        jw4.a.g("create", Integer.valueOf(this.a));
        Bundle r0 = new Bundle();
        r0.putString("ccm_open_type", AnalyticConstant.OpenType.WIKI_CREATE_NEW.getType());
        String r1 = this.b;
        WikiTreeCtrlView r2 = this.c.o;
        if (r2 == null) goto L8;
        SpaceInfo r3 = r2.getSpaceInfo();
        if (r3 == null) goto L8;
        String r4 = r3.getSpaceName();
        if (r4 == null) goto L8;
    L9:
        com.bytedance.ee.bear.wikiv2.wikitreev2.main.o.a(r1, r4, r6.wiki_token, r0, Boolean.FALSE);
        this.c.ba0();
        return;
    L8:
        r4 = "";
        goto L9
    }
}
