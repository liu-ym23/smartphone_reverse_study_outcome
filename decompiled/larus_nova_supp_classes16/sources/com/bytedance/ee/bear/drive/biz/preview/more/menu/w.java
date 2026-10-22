package com.bytedance.ee.bear.drive.biz.preview.more.menu;

import com.bytedance.ee.bear.more.protocol3.panel.e0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class w implements e0 {
    public final /* synthetic */ a a;

    public w(a r1) {
        this.a = r1;
    }

    public final com.bytedance.ee.bear.more.protocol3.b a(com.bytedance.ee.bear.more.protocol3.panel.x r2, com.bytedance.ee.bear.more.protocol3.panel.e r3) {
        Intrinsics.checkNotNullParameter(r2, "<unused var>");
        Intrinsics.checkNotNullParameter(r3, "<unused var>");
        if (this.a.a.c.isVCFollowMode() == false) goto L6;
        return d0.c;
    L6:
        if (this.a.c() == false) goto L9;
        return ((com.bytedance.ee.bear.contract.route.parcelable.a) org.koin.java.a.c(com.bytedance.ee.bear.contract.route.parcelable.a.class, null, null, 6)).a(this.a.a);
    L9:
        return ((com.bytedance.ee.bear.contract.route.parcelable.a) org.koin.java.a.c(com.bytedance.ee.bear.contract.route.parcelable.a.class, null, null, 6)).s(this.a.a);
    }
}
