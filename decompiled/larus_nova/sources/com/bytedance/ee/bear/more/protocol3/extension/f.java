package com.bytedance.ee.bear.more.protocol3.extension;

import com.bytedance.ee.bear.retention.RetentionSettingVisible;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes18.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f234830a;

    public f(a r100) {
        this.f234830a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        RetentionSettingVisible r101 = (RetentionSettingVisible) r100;
        tt5.a.h("DefMoreInfoBehavior", "retentionFlow ok. ");
        a r102 = this.f234830a;
        oj5.a r103 = r102.c();
        if (r103 == null) goto L5;
        r103.f523542m = r101.isCanSetRetentionLabel();
    L6:
        r102.e(r103);
        return;
    L5:
        r103 = null;
        goto L6
    }
}
