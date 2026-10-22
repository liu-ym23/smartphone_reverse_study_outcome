package com.bytedance.ee.bear.more.protocol3.checker;

import com.bytedance.ee.bear.more.protocol3.j;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class BizChecker extends j {
    public final Lambda e;

    @Override // com.bytedance.ee.bear.more.protocol3.j
    public final boolean e() {
        return ((Boolean) this.e.invoke()).booleanValue();
    }

    public BizChecker(final boolean r2) {
        this.e = new AnonymousClass1(r2);
    }

    public BizChecker(String r2, final boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "disableReason");
        this.b = r2;
        this.e = new AnonymousClass2(r3);
    }
}
