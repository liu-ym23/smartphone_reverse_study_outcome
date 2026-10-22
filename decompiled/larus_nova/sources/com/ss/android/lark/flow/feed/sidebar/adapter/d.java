package com.ss.android.lark.flow.feed.sidebar.adapter;

import com.ss.android.lark.feed.shared.page.r;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class d implements zeb.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f423506a;

    @Override // zeb.a
    public final boolean a() {
        r r100 = this.f423506a.f423504c;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("feedItemsListener");
        r100 = null;
    L6:
        return r100.a();
    }

    @Override // zeb.a
    public final void b() {
        r r100 = this.f423506a.f423504c;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("feedItemsListener");
        r100 = null;
    L5:
        r100.b();
    }

    @Override // zeb.a
    public final void pauseDataChange() {
        r r100 = this.f423506a.f423504c;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("feedItemsListener");
        r100 = null;
    L5:
        r100.pauseDataChange();
    }

    public d(b r100) {
        this.f423506a = r100;
    }
}
