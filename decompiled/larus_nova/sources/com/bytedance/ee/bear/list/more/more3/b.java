package com.bytedance.ee.bear.list.more.more3;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class b implements com.bytedance.ee.bear.more.protocol3.panel.x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Fragment f228761a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.ee.bear.more.protocol3.h f228762b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.ee.bear.more.protocol3.panel.t f228763c;

    @Override // com.bytedance.ee.bear.more.protocol3.panel.x
    public final com.bytedance.ee.bear.more.protocol3.panel.z f6() {
        return null;
    }

    @Override // com.bytedance.ee.bear.more.protocol3.panel.x
    public final void a() {
        this.f228762b.c();
    }

    @Override // com.bytedance.ee.bear.more.protocol3.panel.x
    public final void d6() {
        this.f228762b.g();
    }

    @Override // com.bytedance.ee.bear.more.protocol3.panel.x
    public Activity getActivity() {
        return com.bytedance.ee.bear.more.protocol3.panel.x.a.getActivity(this);
    }

    @Override // com.bytedance.ee.bear.more.protocol3.panel.x
    public final Fragment getHostFragment() {
        return this.f228761a;
    }

    @Override // com.bytedance.ee.bear.more.protocol3.panel.x
    public final com.bytedance.ee.bear.more.protocol3.panel.q e6(String r100) {
        Intrinsics.checkNotNullParameter(r100, "itemId");
        return this.f228763c.a(r100);
    }

    public b(Fragment r100, com.bytedance.ee.bear.more.protocol3.h r101, com.bytedance.ee.bear.more.protocol3.panel.e r102) {
        Intrinsics.checkNotNullParameter(r100, "hostFragment");
        Intrinsics.checkNotNullParameter(r101, ShortVideoSegments.KEY_PROP_PROVIDER);
        Intrinsics.checkNotNullParameter(r102, "registry");
        this.f228761a = r100;
        this.f228762b = r101;
        this.f228763c = r102;
    }
}
