package com.bytedance.ee.bear.wikiv2.create;

import android.view.View;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BaseEntity;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BizDomain;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionRequest;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.chad.library.adapter.base.BaseQuickAdapter;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d implements BaseQuickAdapter.OnItemClickListener {
    public final /* synthetic */ WikiCreateSelectView.b a;
    public final /* synthetic */ List<com.bytedance.ee.bear.creationmenu.g> b;
    public final /* synthetic */ WikiCreateSelectView c;

    public d(WikiCreateSelectView.b r1, List<com.bytedance.ee.bear.creationmenu.g> r2, WikiCreateSelectView r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void onItemClick(BaseQuickAdapter r3, View r4, int r5) {
        if (this.a.b == true) goto L5;
        return;
    L5:
        com.bytedance.ee.bear.creationmenu.g r6 = (com.bytedance.ee.bear.creationmenu.g) ListProtector.get(this.b, r5);
        if (r6.a == false) goto L13;
        if (r6.b == false) goto L13;
        WikiCreateSelectView.c r7 = this.c.getDelegate();
        if (r7 == null) goto L17;
        r7.a(((com.bytedance.ee.bear.creationmenu.g) ListProtector.get(this.b, r5)).c.id());
        return;
    L17:
        return;
    L13:
        if (r6.b == true) goto L15;
        PermissionRequest r8 = new PermissionRequest(new BaseEntity("", sbb.e.l, BizDomain.FileBizDomainCCM, ""), "UPLOAD");
        PermissionResponse r9 = ((ph5.b) org.koin.java.a.c(ph5.b.class, null, null, 6)).f(r8, null);
        r9.getCallback().a(this.c.getContext(), r9);
        return;
    L15:
        Toast.showFailureText(r4.getContext(), 2131887951);
    }
}
