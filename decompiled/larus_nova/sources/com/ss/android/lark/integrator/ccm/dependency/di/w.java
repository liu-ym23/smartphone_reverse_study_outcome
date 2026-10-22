package com.ss.android.lark.integrator.ccm.dependency.di;

import com.larksuite.framework.callback.UIGetDataCallback;
import com.ss.android.lark.image.ImageModule;

/* JADX INFO: loaded from: classes36.dex */
public final class w implements com.bytedance.ee.bear.lark.dependency.o {
    public w() {
    }

    @Override // com.bytedance.ee.bear.lark.dependency.o
    public final void a(wb5.e r100, final UIGetDataCallback r110) {
        new ImageModule().b(r100.getContext(), r100.f559004b, r100.f559005c, true, r100.f559006d, r100.f559007e, new ImageDependencyImpl$1(this, r110));
    }
}
