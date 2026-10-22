package com.ss.android.lark.officesdk.integrator.im.sdk.service;

import com.ss.android.lark.chat.entity.image.ImageSet;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class e implements okb.f {
    public e() {
    }

    @Override // okb.f
    public final String a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return r100;
    }

    @Override // okb.f
    public final void b(List<? extends ImageSet> r100) {
        Intrinsics.checkNotNullParameter(r100, "imageSetList");
    }

    @Override // okb.f
    public final void isFirstOpenAlbum() {
    }
}
