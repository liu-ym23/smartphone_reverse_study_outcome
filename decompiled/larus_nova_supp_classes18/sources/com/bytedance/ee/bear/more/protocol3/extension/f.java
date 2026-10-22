package com.bytedance.ee.bear.more.protocol3.extension;

import com.bytedance.ee.bear.retention.RetentionSettingVisible;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ a a;

    public f(a r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        RetentionSettingVisible r4 = (RetentionSettingVisible) r3;
        tt5.a.h("DefMoreInfoBehavior", "retentionFlow ok. ");
        a r0 = this.a;
        oj5.a r1 = r0.c();
        if (r1 == null) goto L5;
        r1.m = r4.isCanSetRetentionLabel();
    L6:
        r0.e(r1);
        return;
    L5:
        r1 = null;
        goto L6
    }
}
