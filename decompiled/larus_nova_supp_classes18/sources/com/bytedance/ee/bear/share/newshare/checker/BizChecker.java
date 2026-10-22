package com.bytedance.ee.bear.share.newshare.checker;

import com.bytedance.ee.bear.share.newshare.c;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class BizChecker extends c {
    public final Function0<Boolean> a;

    @Override // com.bytedance.ee.bear.share.newshare.c
    public final boolean c() {
        return ((Boolean) this.a.invoke()).booleanValue();
    }

    public BizChecker(final boolean r2) {
        this.a = new AnonymousClass1(r2);
    }
}
