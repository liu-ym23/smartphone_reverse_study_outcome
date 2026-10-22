package com.bytedance.ee.bear.bitable.celleditor.editor.location;

import android.webkit.ValueCallback;

/* JADX INFO: loaded from: classes15.dex */
public final class f implements com.ss.android.lark.utils.h.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ValueCallback<Boolean> f209428a;

    public f(g r100) {
        this.f209428a = r100;
    }

    @Override // com.ss.android.lark.utils.h.e
    public final void a(boolean r100) {
        this.f209428a.onReceiveValue(Boolean.valueOf(r100));
    }
}
