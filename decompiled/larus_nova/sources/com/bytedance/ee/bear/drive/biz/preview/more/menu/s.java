package com.bytedance.ee.bear.drive.biz.preview.more.menu;

import com.bytedance.ee.bear.drive.biz.preview.more.menu.share.DriveShareMoreItemV2;
import com.bytedance.ee.bear.more.protocol3.panel.e0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class s implements e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f223603a;

    public s(a r100) {
        this.f223603a = r100;
    }

    @Override // com.bytedance.ee.bear.more.protocol3.panel.e0
    public final com.bytedance.ee.bear.more.protocol3.b a(com.bytedance.ee.bear.more.protocol3.panel.x r100, com.bytedance.ee.bear.more.protocol3.panel.e r101) {
        Intrinsics.checkNotNullParameter(r100, "<unused var>");
        Intrinsics.checkNotNullParameter(r101, "<unused var>");
        return new DriveShareMoreItemV2(this.f223603a.f223566a);
    }
}
