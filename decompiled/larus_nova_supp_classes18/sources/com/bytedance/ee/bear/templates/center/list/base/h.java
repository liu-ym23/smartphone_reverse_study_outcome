package com.bytedance.ee.bear.templates.center.list.base;

import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h<T> implements Observer {
    public final /* synthetic */ BaseTemplateListPresenter a;

    public h(BaseTemplateListPresenter r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        sbb.e r3 = (sbb.e) r2;
        BaseTemplateListPresenter r0 = this.a;
        Intrinsics.checkNotNull(r3);
        r0.S8(r3);
    }
}
