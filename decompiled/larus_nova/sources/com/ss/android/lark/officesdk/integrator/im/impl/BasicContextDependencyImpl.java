package com.ss.android.lark.officesdk.integrator.im.impl;

import android.content.Context;
import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.utils.LarkContext;

/* JADX INFO: loaded from: classes37.dex */
@ClaymoreImpl(pmb.a.class)
public class BasicContextDependencyImpl implements pmb.a {
    public BasicContextDependencyImpl() {
    }

    @Override // pmb.a
    public Context getContext() {
        return LarkContext.getApplication();
    }

    @Override // pmb.a
    public boolean isUsPackage() {
        return LarkAppContext.inst().buildConfig().isUsPackage();
    }
}
