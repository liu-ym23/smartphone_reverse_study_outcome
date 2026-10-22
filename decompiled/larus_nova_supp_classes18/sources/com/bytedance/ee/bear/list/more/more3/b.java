package com.bytedance.ee.bear.list.more.more3;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements com.bytedance.ee.bear.more.protocol3.panel.x {
    public final Fragment a;
    public final com.bytedance.ee.bear.more.protocol3.h b;
    public final com.bytedance.ee.bear.more.protocol3.panel.t c;

    @Override // com.bytedance.ee.bear.more.protocol3.panel.x
    public final com.bytedance.ee.bear.more.protocol3.panel.z f6() {
        return null;
    }

    @Override // com.bytedance.ee.bear.more.protocol3.panel.x
    public final void a() {
        this.b.c();
    }

    @Override // com.bytedance.ee.bear.more.protocol3.panel.x
    public final void d6() {
        this.b.g();
    }

    @Override // com.bytedance.ee.bear.more.protocol3.panel.x
    public Activity getActivity() {
        return com.bytedance.ee.bear.more.protocol3.panel.x.a.getActivity(this);
    }

    @Override // com.bytedance.ee.bear.more.protocol3.panel.x
    public final Fragment getHostFragment() {
        return this.a;
    }

    @Override // com.bytedance.ee.bear.more.protocol3.panel.x
    public final com.bytedance.ee.bear.more.protocol3.panel.q e6(String r2) {
        Intrinsics.checkNotNullParameter(r2, "itemId");
        return this.c.a(r2);
    }

    public b(Fragment r2, com.bytedance.ee.bear.more.protocol3.h r3, com.bytedance.ee.bear.more.protocol3.panel.e r4) {
        Intrinsics.checkNotNullParameter(r2, "hostFragment");
        Intrinsics.checkNotNullParameter(r3, "provider");
        Intrinsics.checkNotNullParameter(r4, "registry");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
