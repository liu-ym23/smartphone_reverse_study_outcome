package com.bytedance.lark.lynxlib.image;

import android.content.Context;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.api.IRequestCreator;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes19.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f253276a = 0;

    static {
    }

    public g() {
    }

    public static final void a(Context r100, String r101, com.bytedance.lynx.tasm.ui.imageloader.a.c r102, com.bytedance.lynx.tasm.ui.imageloader.a.InterfaceC3714a r103, float r104, float r105) {
        Log.i("LynxImageAdapter", "load image with ImageLoader");
        IRequestCreator r106 = ImageLoader.with(r100).load(i.a(r101)).dontAnimate(false);
        int r107 = (int) r104;
        int r108 = (int) r105;
        r106.override(r107, r108).transform(new a(r102)).listener(new e(r103)).into(new f(r103, r107, r108));
    }
}
