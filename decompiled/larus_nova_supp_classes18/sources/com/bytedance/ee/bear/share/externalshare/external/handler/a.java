package com.bytedance.ee.bear.share.externalshare.external.handler;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements com.bytedance.ee.bear.middleground_permission_export.model.a {
    public final /* synthetic */ Function0<Unit> a;

    public a(Function0<Unit> r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.a
    public final void onComplete() {
        this.a.invoke();
    }
}
