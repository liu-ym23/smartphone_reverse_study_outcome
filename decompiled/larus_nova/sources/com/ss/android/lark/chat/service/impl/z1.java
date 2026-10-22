package com.ss.android.lark.chat.service.impl;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.media.v1.GetPreviewVideoSourceRequest;
import com.bytedance.lark.pb.media.v1.GetPreviewVideoSourceResponse;
import com.ss.android.lark.chat.video.InnerVideoPreviewFragment$playVideo$1;
import com.ss.android.lark.passportc.dwarf.UserScope;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@UserScope
public final class z1 implements m6b.n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.lark.rustclient.api.l f416598a;

    @Inject
    public z1(com.bytedance.lark.rustclient.api.l r100) {
        Intrinsics.checkNotNullParameter(r100, "rustClient");
        this.f416598a = r100;
    }

    @Override // m6b.n
    public final void Z2(String r110, boolean r111, InnerVideoPreviewFragment$playVideo$1 r112) {
        Intrinsics.checkNotNullParameter(r110, "url");
        Intrinsics.checkNotNullParameter(r112, "callback");
        GetPreviewVideoSourceRequest.Builder r100 = new GetPreviewVideoSourceRequest.Builder().url(r110).force_update(Boolean.valueOf(r111));
        Intrinsics.checkNotNull(r100);
        com.bytedance.lark.rustclient.api.d r113 = new com.bytedance.lark.rustclient.api.d(r100, GetPreviewVideoSourceResponse.ADAPTER, Command.GET_PREVIEW_VIDEO_SOURCE, null, null, null, null, 248);
        com.ss.android.lark.im.sdk.utils.e.a(com.bytedance.lark.rustclient.api.t.b(this.f416598a.h(r113).a()).map(y1.f416596a), r112);
    }
}
