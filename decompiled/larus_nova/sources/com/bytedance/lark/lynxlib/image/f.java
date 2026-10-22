package com.bytedance.lark.lynxlib.image;

import android.graphics.drawable.Drawable;
import com.ss.android.lark.image.api.SimpleTarget;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class f extends SimpleTarget<Drawable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.lynx.tasm.ui.imageloader.a.InterfaceC3714a f253275a;

    @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
    public final void onResourceReady(Object r100) {
        Drawable r101 = (Drawable) r100;
        Intrinsics.checkNotNullParameter(r101, "resource");
        super.onResourceReady(r101);
        Log.i("LynxImageAdapter", "onResourceReady:");
        r101.setBounds(0, 0, r101.getIntrinsicWidth(), r101.getIntrinsicHeight());
        this.f253275a.a(r101, null);
    }

    public f(com.bytedance.lynx.tasm.ui.imageloader.a.InterfaceC3714a r100, int r101, int r102) {
        this.f253275a = r100;
        super(r101, r102);
    }
}
