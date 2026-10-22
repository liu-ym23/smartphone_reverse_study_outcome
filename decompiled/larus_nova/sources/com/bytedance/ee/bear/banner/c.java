package com.bytedance.ee.bear.banner;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.ee.bear.banner.bean.BannerScene;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class c implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f206457a;

    @Override // com.bytedance.ee.bear.banner.d
    public final mn4.a a() {
        a r100 = this.f206457a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.a();
    }

    @Override // com.bytedance.ee.bear.banner.d
    public final void d() {
        a r100 = this.f206457a;
        if (r100 == null) goto L6;
        r100.d();
        return;
    }

    @Override // com.bytedance.ee.bear.banner.d
    public final void destroy() {
        a r100 = this.f206457a;
        if (r100 == null) goto L6;
        r100.destroy();
        return;
    }

    public c() {
        this.f206457a = new a();
    }

    @Override // com.bytedance.ee.bear.banner.d
    public final void b(BannerScene r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        a r101 = this.f206457a;
        if (r101 == null) goto L6;
        Intrinsics.checkNotNullParameter(r100, "scene");
        r101.f206448f = r100;
        return;
    }

    @Override // com.bytedance.ee.bear.banner.d
    public final void c(ViewGroup r100, Context r101) {
        Intrinsics.checkNotNullParameter(r100, "bannerContainer");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        a r102 = this.f206457a;
        if (r102 == null) goto L6;
        r102.c(r100, r101);
        return;
    }
}
