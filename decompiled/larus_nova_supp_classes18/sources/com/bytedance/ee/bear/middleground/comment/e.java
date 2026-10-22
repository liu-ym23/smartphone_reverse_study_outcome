package com.bytedance.ee.bear.middleground.comment;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e<T> implements s {
    public final /* synthetic */ boolean a;

    public e() {
        this.a = true;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.s
    public final void a(Object r2) {
        com.bytedance.ee.bear.middleground.comment.uitls.p r3 = (com.bytedance.ee.bear.middleground.comment.uitls.p) r2;
        Intrinsics.checkNotNullParameter(r3, "config");
        r3.B = this.a;
    }
}
