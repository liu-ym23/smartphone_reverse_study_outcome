package com.bytedance.ee.bear.document.profile;

import com.bytedance.ee.bear.document.tips.TipCallBackData;
import com.bytedance.ee.bear.lark.dependency.c0;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements c0.a {
    public final /* synthetic */ m a;
    public final /* synthetic */ OfficeShowProfilePlugin.a b;

    @Override // com.bytedance.ee.bear.lark.dependency.c0.a
    public final void onCancel() {
        if (OfficeShowProfilePlugin.access$1000(this.b.a) == false) goto L6;
        this.a.onCallBack(OfficeShowProfilePlugin.a.a(this.b, "cancel"));
        return;
    }

    @Override // com.bytedance.ee.bear.lark.dependency.c0.a
    public final void onConfirm() {
        if (OfficeShowProfilePlugin.access$800(this.b.a) == false) goto L6;
        this.a.onCallBack(OfficeShowProfilePlugin.a.a(this.b, TipCallBackData.CONFIRM));
        return;
    }

    public a(OfficeShowProfilePlugin.a r1, m r2) {
        this.b = r1;
        this.a = r2;
    }
}
