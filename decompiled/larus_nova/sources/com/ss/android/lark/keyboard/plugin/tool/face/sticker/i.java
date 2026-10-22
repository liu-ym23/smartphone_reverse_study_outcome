package com.ss.android.lark.keyboard.plugin.tool.face.sticker;

import android.content.Context;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes36.dex */
public final class i implements FaceNewAdapter.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FacePageNewFragment2 f429723a;

    public i(FacePageNewFragment2 r100) {
        this.f429723a = r100;
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.face.sticker.FaceNewAdapter.d
    public final void a(Context r100, int r101, int r102, String r103, ImageView r104, int r105) {
        FacePageNewFragment2 r106 = this.f429723a;
        int r107 = FacePageNewFragment2.f429672n;
        k r108 = r106.U90();
        if (r108 != null) goto L5;
        return;
    L5:
        r108.b();
    }
}
