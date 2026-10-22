package com.ss.android.lark.movable.attatchment;

import com.larksuite.component.ui.imageview.LKUIRoundedImageView2;
import com.ss.android.lark.image.ImageLoader;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class h implements p {
    public h() {
    }

    @Override // com.ss.android.lark.movable.attatchment.p
    public final boolean a() {
        return false;
    }

    @Override // com.ss.android.lark.movable.attatchment.p
    public final void b(String r100, LKUIRoundedImageView2 r101, int r102, int r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "imageView");
        Intrinsics.checkNotNullParameter(r104, "urlType");
        ImageLoader.with(r101.getContext()).override(r102, r103).load(r100).into(r101);
    }
}
