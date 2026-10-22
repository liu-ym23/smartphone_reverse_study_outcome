package com.bytedance.ee.bear.share.newshare.checker;

import com.bytedance.ee.bear.share.newshare.c;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes18.dex */
public final class BizChecker extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Boolean> f237203a;

    @Override // com.bytedance.ee.bear.share.newshare.c
    public final boolean c() {
        return this.f237203a.invoke().booleanValue();
    }

    public BizChecker(final boolean r100) {
        this.f237203a = new AnonymousClass1(r100);
    }
}
