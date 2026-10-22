package com.bytedance.ee.bear.document.pageedit;

import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c implements g {
    public final /* synthetic */ PageEditPlugin a;
    public final /* synthetic */ m b;

    @Override // com.bytedance.ee.bear.document.pageedit.g
    public final void onCancel() {
        this.a.setFragment(null);
    }

    public c(PageEditPlugin r1, m r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // com.bytedance.ee.bear.document.pageedit.g
    public final void a(String r3, ArrayList<PageEditPlugin.UserInfo> r4) {
        Intrinsics.checkNotNullParameter(r3, "actionType");
        Intrinsics.checkNotNullParameter(r4, "userInfos");
        this.a.setFragment(null);
        m r0 = this.b;
        PageEditPlugin.DocInfoEditorParams r1 = new PageEditPlugin.DocInfoEditorParams();
        r1.setType(r3);
        r1.setData(r4);
        r0.a(r1);
    }
}
