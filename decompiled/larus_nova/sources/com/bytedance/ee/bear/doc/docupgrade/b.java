package com.bytedance.ee.bear.doc.docupgrade;

import com.bytedance.ee.bear.contract.c0;
import com.bytedance.ee.bear.list.dto.Document;
import kd5.b2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class b implements c0.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Document f217877a;

    @Override // com.bytedance.ee.bear.contract.c0.b
    public final void a(boolean r100) {
    }

    public b(Document r100) {
        this.f217877a = r100;
    }

    @Override // com.bytedance.ee.bear.contract.c0.b
    public final void b(Document r100, long r101, b2 r102) {
        Intrinsics.checkNotNullParameter(r102, "callback");
        r102.b(this.f217877a);
    }
}
