package com.ss.android.lark.flow.feed.sidebar.human;

import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes36.dex */
public final class c implements qtb.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OfficeSidebarHumanFeedController f423578a;

    public c(OfficeSidebarHumanFeedController r100) {
        this.f423578a = r100;
    }

    @Override // qtb.c
    public final void onLoginFailed() {
        com.ss.android.lark.flow.feed.utils.b.d("OfficeSidebarHumanFeedController", "user login failed listener invoke");
        OfficeSidebarHumanFeedController r100 = this.f423578a;
        r100.f423539w = true;
        List<iza.c> r101 = r100.m(r100.f423532p, CollectionsKt.emptyList());
        r100.f423532p = CollectionsKt.emptyList();
        r100.f423524h.clear();
        r100.f423533q = false;
        r100.f423534r = Long.MIN_VALUE;
        r100.o();
        OfficeSidebarHumanFeedController.s(r100, r101);
        com.ss.android.lark.flow.feed.utils.b.d("OfficeSidebarHumanFeedController", "remove human data success");
    }
}
