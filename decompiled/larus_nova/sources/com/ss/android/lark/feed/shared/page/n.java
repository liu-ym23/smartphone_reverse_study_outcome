package com.ss.android.lark.feed.shared.page;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class n implements zeb.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f421445a;

    @Override // zeb.a
    public final boolean a() {
        r r100 = this.f421445a.f421427g;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("feedItemsListener");
        r100 = null;
    L6:
        return r100.a();
    }

    @Override // zeb.a
    public final void b() {
        r r100 = this.f421445a.f421427g;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("feedItemsListener");
        r100 = null;
    L5:
        r100.b();
    }

    @Override // zeb.a
    public final void pauseDataChange() {
        r r100 = this.f421445a.f421427g;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("feedItemsListener");
        r100 = null;
    L5:
        r100.pauseDataChange();
    }

    public n(k r100) {
        this.f421445a = r100;
    }
}
