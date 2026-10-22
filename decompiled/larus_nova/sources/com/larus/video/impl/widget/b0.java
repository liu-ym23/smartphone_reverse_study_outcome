package com.larus.video.impl.widget;

import com.larus.platform.api.IVideoController;
import com.larus.platform.api.l4;
import com.larus.platform.uimodel.MediaEntity;
import com.larus.video.impl.TikTokVideoViewHolder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class b0 implements l4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MediaEntity f376001a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ VideoViewHolder f376002b;

    public b0(MediaEntity r100, TikTokVideoViewHolder r101) {
        this.f376001a = r100;
        this.f376002b = r101;
    }

    @Override // com.larus.platform.api.l4
    public final void a(String r100, com.larus.video.impl.sdk.a r101) {
        MediaEntity r102 = this.f376001a;
        if (r102 == null) goto L5;
        String r103 = r102.getVideo_model();
    L7:
        if (Intrinsics.areEqual(r103, r100) == false) goto L10;
        IVideoController.a.a(this.f376002b.f375981b, r101, 0, 30);
        return;
    L10:
        return;
    L5:
        r103 = null;
        goto L7
    }
}
