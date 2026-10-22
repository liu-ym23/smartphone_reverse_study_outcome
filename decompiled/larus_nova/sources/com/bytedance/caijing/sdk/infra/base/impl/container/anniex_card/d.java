package com.bytedance.caijing.sdk.infra.base.impl.container.anniex_card;

import android.net.Uri;
import com.bytedance.ies.bullet.core.q;
import com.bytedance.ies.bullet.service.base.o;
import ed4.l;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class d extends q.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f202482a;

    public d(l r100) {
        this.f202482a = r100;
    }

    @Override // com.bytedance.ies.bullet.core.q.a, com.bytedance.ies.bullet.core.s
    public final void HP(Uri r100, o r101) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        Intrinsics.checkNotNullParameter(r100, "uri");
        l r102 = this.f202482a;
        if (r102 == null) goto L6;
        r102.onRuntimeReady(r100.toString(), null);
        return;
    }

    @Override // com.bytedance.ies.bullet.core.q.a, com.bytedance.ies.bullet.core.s
    public final void Ox(Uri r100, h16.e r101) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        Intrinsics.checkNotNullParameter(r100, "uri");
        l r102 = this.f202482a;
        if (r102 == null) goto L6;
        r102.onLoadStart(r100.toString(), null);
        return;
    }

    @Override // com.bytedance.ies.bullet.core.q.a, com.bytedance.ies.bullet.core.s
    public final void go(Uri r100, o r101) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        Intrinsics.checkNotNullParameter(r100, "uri");
        l r102 = this.f202482a;
        if (r102 == null) goto L6;
        r102.onLoadUriSuccess(r100.toString(), null);
        return;
    }

    @Override // com.bytedance.ies.bullet.core.q.a, com.bytedance.ies.bullet.core.s
    public final void onLoadFail(Uri r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        Intrinsics.checkNotNullParameter(r101, "e");
        super.onLoadFail(r100, r101);
        l r102 = this.f202482a;
        if (r102 == null) goto L6;
        r102.onLoadFail(r100.toString(), null, r101);
        return;
    }

    @Override // com.bytedance.ies.bullet.core.q.a, com.bytedance.ies.bullet.core.s
    public final void LG(Uri r100, o r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        Intrinsics.checkNotNullParameter(r100, "uri");
        l r103 = this.f202482a;
        if (r103 == null) goto L6;
        r103.onViewDestroy(r100.toString(), null, r102);
        return;
    }
}
