package com.bytedance.awemeopen.apps.framework.landscape.ui;

import android.app.Activity;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.o;
import com.bytedance.awemeopen.apps.framework.landscape.LandscapeCommentPresenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f {
    public final r14.c a;
    public final Activity b;
    public final o c;
    public final com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.b d;
    public LandscapeCommentPresenter e;

    public final Activity getActivity() {
        return this.b;
    }

    public f(r14.c r2, Activity r3, o r4, com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.b r5) {
        Intrinsics.checkNotNullParameter(r2, "aweme");
        Intrinsics.checkNotNullParameter(r4, "vm");
        Intrinsics.checkNotNullParameter(r5, "pageOwner");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
