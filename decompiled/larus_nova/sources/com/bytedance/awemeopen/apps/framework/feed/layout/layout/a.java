package com.bytedance.awemeopen.apps.framework.feed.layout.layout;

import android.app.Activity;
import android.content.Context;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.FeedPagerListViewModel;
import com.bytedance.awemeopen.apps.framework.utils.o;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class a extends o {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ AosFeedPagerListLayout<FeedPagerListViewModel> f194887d;

    @Override // com.bytedance.awemeopen.apps.framework.utils.o
    public final void a() {
        if ((this.f194887d.getContext() instanceof Activity) == false) goto L6;
        Context r100 = this.f194887d.getContext();
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type android.app.Activity");
        ((Activity) r100).finish();
        return;
    }

    public a(AosFeedPagerListLayout<FeedPagerListViewModel> r100) {
        this.f194887d = r100;
    }
}
