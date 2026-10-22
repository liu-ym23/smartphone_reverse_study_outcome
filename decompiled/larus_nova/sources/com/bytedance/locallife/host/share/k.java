package com.bytedance.locallife.host.share;

import com.larus.bmhome.share.panel.ShareChannel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class k implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t f258940a;

    public k(t r100) {
        this.f258940a = r100;
    }

    @Override // com.bytedance.locallife.host.share.r
    public final void onSuccess(String r100) {
        Intrinsics.checkNotNullParameter(r100, "channel");
        if (Intrinsics.areEqual(r100, "copy_link") == false) goto L5;
        this.f258940a.b();
    L12:
        this.f258940a.onDismiss();
        return;
    L5:
        t r101 = this.f258940a;
        HostLifeShareAdapter.f258919a.getClass();
        if (Intrinsics.areEqual(r100, "wechat") == false) goto L9;
        r100 = "weixin";
    L11:
        r101.a(r100, true);
        goto L12
    L9:
        if (Intrinsics.areEqual(r100, ShareChannel.WX_MOMENTS) == false) goto L11;
        r100 = "weixin_moments";
        goto L11
    }

    @Override // com.bytedance.locallife.host.share.r
    public final void onFailed(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "errorCode");
        Intrinsics.checkNotNullParameter(r101, "errorMessage");
        if (Intrinsics.areEqual(r100, "CANCELLED") == false) goto L5;
        this.f258940a.c();
    L6:
        this.f258940a.onDismiss();
        return;
    L5:
        this.f258940a.a("", false);
        goto L6
    }
}
