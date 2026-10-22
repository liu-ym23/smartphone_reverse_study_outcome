package com.bytedance.ee.bear.middleground.comment;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class d<T> implements s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f231256a;

    public d() {
        this.f231256a = true;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.s
    public final void a(Object r100) {
        com.bytedance.ee.bear.middleground.comment.uitls.p r101 = (com.bytedance.ee.bear.middleground.comment.uitls.p) r100;
        Intrinsics.checkNotNullParameter(r101, "config");
        r101.A = this.f231256a;
    }
}
