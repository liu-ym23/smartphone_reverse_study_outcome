package com.bytedance.ee.bear.document.more;

import com.bytedance.ee.bear.more.moreprotocol.CommonMoreItemId;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class u0 implements com.bytedance.ee.bear.more.protocol3.panel.e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f220376a;

    public u0(i r100) {
        this.f220376a = r100;
    }

    @Override // com.bytedance.ee.bear.more.protocol3.panel.e0
    public final com.bytedance.ee.bear.more.protocol3.b a(com.bytedance.ee.bear.more.protocol3.panel.x r100, com.bytedance.ee.bear.more.protocol3.panel.e r101) {
        Intrinsics.checkNotNullParameter(r100, "<unused var>");
        Intrinsics.checkNotNullParameter(r101, "<unused var>");
        return this.f220376a.b(CommonMoreItemId.DELETE, null);
    }
}
