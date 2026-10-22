package com.bytedance.ee.bear.share.externalshare.external.handler;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes18.dex */
public final class a implements com.bytedance.ee.bear.middleground_permission_export.model.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f237075a;

    public a(Function0<Unit> r100) {
        this.f237075a = r100;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.a
    public final void onComplete() {
        this.f237075a.invoke();
    }
}
