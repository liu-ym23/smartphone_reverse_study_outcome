package com.ss.android.lark.chat.preview.components.view;

import android.view.View;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class d implements a.InterfaceC4870a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<View> f416188a;

    @Override // com.ss.android.lark.chat.preview.components.view.a.InterfaceC4870a
    public final void a() {
        WeakReference<View> r100 = this.f416188a;
        if (r100 == null) goto L8;
        View r101 = r100.get();
        if (r101 == null) goto L9;
        r101.postInvalidate();
        return;
    L9:
        return;
    }

    @Override // com.ss.android.lark.chat.preview.components.view.a.InterfaceC4870a
    public final void onLoadFailed() {
        WeakReference<View> r100 = this.f416188a;
        if (r100 == null) goto L8;
        View r101 = r100.get();
        if (r101 == null) goto L9;
        r101.postInvalidate();
        return;
    L9:
        return;
    }

    public d(WeakReference<View> r100) {
        Intrinsics.checkNotNullParameter(r100, "refs");
        this.f416188a = r100;
    }
}
