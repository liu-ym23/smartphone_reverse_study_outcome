package com.ss.android.lark.integrator.ccm.dependency.di;

import android.content.Context;
import android.graphics.Bitmap;
import com.ss.android.lark.utils.LarkContext;

/* JADX INFO: loaded from: classes36.dex */
public final class p1 implements com.bytedance.ee.bear.lark.dependency.d0 {
    public p1() {
    }

    @Override // com.bytedance.ee.bear.lark.dependency.d0
    public final void a(String r100) {
        com.bytedance.ee.bear.lark.dependency.g r101 = (com.bytedance.ee.bear.lark.dependency.g) LarkContext.spiByDwarf(com.bytedance.ee.bear.lark.dependency.g.class);
        LarkContext.getApplication();
        r101.R0();
    }

    @Override // com.bytedance.ee.bear.lark.dependency.d0
    public final String decodeQRCode(String r100) {
        return ((com.bytedance.ee.bear.lark.dependency.g) LarkContext.spiByDwarf(com.bytedance.ee.bear.lark.dependency.g.class)).decodeQRCode(r100);
    }

    @Override // com.bytedance.ee.bear.lark.dependency.d0
    public final Bitmap e(String r100, int r101, int r102) {
        return ((com.bytedance.ee.bear.lark.dependency.g) LarkContext.spiByDwarf(com.bytedance.ee.bear.lark.dependency.g.class)).e(r100, r101, r102);
    }

    @Override // com.bytedance.ee.bear.lark.dependency.d0
    public final void b(Context r100, int[] r101, com.bytedance.ee.bear.lark.dependency.p0 r102, com.bytedance.ee.bear.lark.dependency.o0 r103) {
        ((com.bytedance.ee.bear.lark.dependency.g) LarkContext.spiByDwarf(com.bytedance.ee.bear.lark.dependency.g.class)).J0(r100, r101, r102);
    }
}
