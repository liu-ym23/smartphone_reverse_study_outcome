package com.ss.android.lark.integrator.ccm.dependency.di;

import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.ss.android.lark.integrator.ccm.spacekit.SpacekitSdkWrapper;
import com.ss.android.lark.utils.LarkContext;

/* JADX INFO: loaded from: classes36.dex */
@ClaymoreImpl(com.bytedance.ee.bear.lark.dependency.b0.class)
public class PreloadDependencyImpl implements com.bytedance.ee.bear.lark.dependency.b0 {
    public PreloadDependencyImpl() {
    }

    @Override // com.bytedance.ee.bear.lark.dependency.b0
    public void preloadDocSdk(int r100) {
        cmb.f.a().getClass();
        SpacekitSdkWrapper r101 = SpacekitSdkWrapper.b.f427892a;
        if (r101 == null) goto L6;
        LarkContext.getApplication();
        r101.i(r100);
        return;
    }
}
