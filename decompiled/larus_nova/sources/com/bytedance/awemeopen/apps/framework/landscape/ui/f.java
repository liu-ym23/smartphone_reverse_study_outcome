package com.bytedance.awemeopen.apps.framework.landscape.ui;

import android.app.Activity;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.o;
import com.bytedance.awemeopen.apps.framework.landscape.LandscapeCommentPresenter;
import com.larus.bmhome.share.panel.ShareChannel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r14.c f197200a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Activity f197201b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final o f197202c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.b f197203d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LandscapeCommentPresenter f197204e;

    public final Activity getActivity() {
        return this.f197201b;
    }

    public f(r14.c r100, Activity r101, o r102, com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.b r103) {
        Intrinsics.checkNotNullParameter(r100, ShareChannel.DOUYIN);
        Intrinsics.checkNotNullParameter(r102, "vm");
        Intrinsics.checkNotNullParameter(r103, "pageOwner");
        this.f197200a = r100;
        this.f197201b = r101;
        this.f197202c = r102;
        this.f197203d = r103;
    }
}
