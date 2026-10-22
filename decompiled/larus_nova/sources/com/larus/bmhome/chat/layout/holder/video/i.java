package com.larus.bmhome.chat.layout.holder.video;

import com.larus.platform.api.IVideoController;
import com.larus.platform.api.l4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class i implements l4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f304086a;

    public i(String r100) {
        this.f304086a = r100;
    }

    @Override // com.larus.platform.api.l4
    public final void a(String r100, com.larus.video.impl.sdk.a r101) {
        if (Intrinsics.areEqual(this.f304086a, r100) == false) goto L8;
        IVideoController r102 = ps8.a.C7235a.a(ps8.d.f530467a, null, 7);
        if (r102 == null) goto L9;
        IVideoController.a.a(r102, r101, 30720000, 26);
        return;
    L9:
        return;
    }
}
