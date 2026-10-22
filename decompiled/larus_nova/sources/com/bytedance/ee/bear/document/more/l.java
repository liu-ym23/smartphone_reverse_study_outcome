package com.bytedance.ee.bear.document.more;

import com.bytedance.ee.bear.document.icon.IconMoreItemV2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class l implements com.bytedance.ee.bear.more.protocol3.panel.e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f220351a;

    public l(i r100) {
        this.f220351a = r100;
    }

    @Override // com.bytedance.ee.bear.more.protocol3.panel.e0
    public final com.bytedance.ee.bear.more.protocol3.b a(com.bytedance.ee.bear.more.protocol3.panel.x r100, com.bytedance.ee.bear.more.protocol3.panel.e r101) {
        Intrinsics.checkNotNullParameter(r100, "<unused var>");
        Intrinsics.checkNotNullParameter(r101, "<unused var>");
        return new IconMoreItemV2(this.f220351a.f220339a);
    }
}
