package com.ss.android.lark.forwardv2.sharefile;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.framework.utils.m0;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.c1;
import com.ss.android.lark.utils.rxjava.RxScheduledExecutor;

/* JADX INFO: loaded from: classes36.dex */
public final class a<T> implements RxScheduledExecutor.Producer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FileShareEnhancedView f425045a;

    public a(FileShareEnhancedView r100) {
        this.f425045a = r100;
    }

    @Override // com.ss.android.lark.utils.rxjava.RxScheduledExecutor.Producer
    public final Object produce() {
        PolarisFileWrapper r100 = m0.b(LarkContext.getApplication(), this.f425045a.f425043a, true);
        if (r100 != null) goto L5;
    L8:
        String r101 = c1.d(LarkContext.getApplication(), this.f425045a.f425043a);
    L10:
        return new PolarisFileWrapper(r101);
    L5:
        if (r100.canRead() == false) goto L8;
        r101 = r100.getAbsolutePath();
        goto L10
    }
}
