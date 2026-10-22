package com.ss.android.lark.widget.span;

import android.view.View;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes38.dex */
public final class u implements v.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference<View> f448782a;

    @Override // com.ss.android.lark.widget.span.v.b
    public final void a() {
        WeakReference<View> r100 = this.f448782a;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.get() == null) goto L9;
        this.f448782a.get().invalidate();
        return;
    }

    @Override // com.ss.android.lark.widget.span.v.b
    public final void onLoadFailed() {
        WeakReference<View> r100 = this.f448782a;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.get() == null) goto L9;
        this.f448782a.get().invalidate();
        return;
    }

    public u(View r100) {
        this.f448782a = new WeakReference(r100);
    }
}
