package com.larus.uaigc.chat.block.widget.video;

import com.larus.platform.api.IVideoController;
import com.larus.platform.api.l4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class j implements l4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f370790a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LocalVideoSuccessViewBinder f370791b;

    public j(String r100, LocalVideoSuccessViewBinder r101) {
        this.f370790a = r100;
        this.f370791b = r101;
    }

    @Override // com.larus.platform.api.l4
    public final void a(String r100, com.larus.video.impl.sdk.a r101) {
        if (Intrinsics.areEqual(this.f370790a, r100) == false) goto L8;
        IVideoController r102 = this.f370791b.e();
        if (r102 == null) goto L9;
        IVideoController.a.a(r102, r101, 30720000, 26);
        return;
    L9:
        return;
    }
}
