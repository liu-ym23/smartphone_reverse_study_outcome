package com.ss.android.lark.integrator.ccm.dependency.di;

import android.app.Activity;
import com.ss.android.lark.utils.LarkContext;

/* JADX INFO: loaded from: classes36.dex */
public final class c implements com.bytedance.ee.bear.lark.dependency.d {
    public c() {
    }

    @Override // com.bytedance.ee.bear.lark.dependency.d
    public final boolean a() {
        return ((com.bytedance.ee.bear.lark.dependency.g) LarkContext.spiByDwarf(com.bytedance.ee.bear.lark.dependency.g.class)).C0();
    }

    @Override // com.bytedance.ee.bear.lark.dependency.d
    public final Activity getCurrentActivity() {
        return ((com.bytedance.ee.bear.lark.dependency.g) LarkContext.spiByDwarf(com.bytedance.ee.bear.lark.dependency.g.class)).getTopActivity();
    }
}
