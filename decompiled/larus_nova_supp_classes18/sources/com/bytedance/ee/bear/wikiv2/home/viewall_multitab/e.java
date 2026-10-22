package com.bytedance.ee.bear.wikiv2.home.viewall_multitab;

import com.bytedance.ee.bear.wikiv2.home.api.SpaceBean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e implements WikiSpaceListRvView.a {
    public final /* synthetic */ WikiSpaceListView a;

    public e(WikiSpaceListView r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.wikiv2.home.viewall_multitab.WikiSpaceListRvView.a
    public final void a(SpaceBean r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "space");
        WikiSpaceListView.b r0 = this.a.getViewDelegate();
        if (r0 == null) goto L6;
        r0.a(r2, r3);
        return;
    }
}
