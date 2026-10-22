package com.ss.android.lark.integrator.im.feed_shared.dependency;

import android.content.Context;
import com.ss.android.lark.im.base.browser.IImBrowserService;
import com.ss.android.lark.utils.LarkContext;

/* JADX INFO: loaded from: classes36.dex */
public final class c implements peb.b.c {
    public c() {
    }

    @Override // peb.b.c
    public final void a() {
    }

    @Override // peb.b.c
    public final void b(Context r100, String r101) {
        ((IImBrowserService) LarkContext.spiByDwarf(IImBrowserService.class)).openUrl(r100, r101);
    }
}
