package com.bytedance.ee.bear.wikiv2.home.viewall_multitab;

import com.bytedance.ee.bear.wikiv2.home.api.SpaceBean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class e implements WikiSpaceListRvView.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WikiSpaceListView f240782a;

    public e(WikiSpaceListView r100) {
        this.f240782a = r100;
    }

    @Override // com.bytedance.ee.bear.wikiv2.home.viewall_multitab.WikiSpaceListRvView.a
    public final void a(SpaceBean r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "space");
        WikiSpaceListView.b r102 = this.f240782a.getViewDelegate();
        if (r102 == null) goto L6;
        r102.a(r100, r101);
        return;
    }
}
