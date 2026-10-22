package com.bytedance.ee.bear.drive.biz.preview.more.menu;

import com.bytedance.ee.bear.drive.biz.preview.more.menu.fileInfo.FileInfoItemV2;
import com.bytedance.ee.bear.more.protocol3.panel.e0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class h implements e0 {
    public final /* synthetic */ a a;

    public h(a r1) {
        this.a = r1;
    }

    public final com.bytedance.ee.bear.more.protocol3.b a(com.bytedance.ee.bear.more.protocol3.panel.x r2, com.bytedance.ee.bear.more.protocol3.panel.e r3) {
        Intrinsics.checkNotNullParameter(r2, "<unused var>");
        Intrinsics.checkNotNullParameter(r3, "<unused var>");
        return new FileInfoItemV2(this.a.a);
    }
}
