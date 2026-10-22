package com.bytedance.ee.bear.wikiv2.home2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements WikiHomeTopSpaceView.b {
    public final /* synthetic */ WikiHomeFragment2 a;

    public b(WikiHomeFragment2 r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.wikiv2.home2.WikiHomeTopSpaceView.b
    public final void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "spaceId");
        WikiHomeFragment2.V90(this.a, r2);
    }
}
