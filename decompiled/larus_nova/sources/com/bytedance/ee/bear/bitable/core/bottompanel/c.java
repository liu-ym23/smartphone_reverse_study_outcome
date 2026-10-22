package com.bytedance.ee.bear.bitable.core.bottompanel;

import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class c implements ocb.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final pcb.a f210158a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f210159b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f210160c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a.InterfaceC3024a f210161d;

    public c(pcb.a r100, b r101) {
        Intrinsics.checkNotNullParameter(r100, ShortVideoSegments.KEY_PROP_PROVIDER);
        Intrinsics.checkNotNullParameter(r101, "ability");
        this.f210158a = r100;
        this.f210159b = r101;
    }

    @Override // ocb.a
    public final void onKeyboardHeightChanged(pcb.a r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "khp");
        if (this.f210160c == true) goto L5;
        return;
    L5:
        if (r100 != this.f210158a) goto L15;
        if (r101 > 0) goto L8;
        a.InterfaceC3024a r103 = this.f210161d;
        this.f210161d = null;
        if (r103 == null) goto L18;
        r103.close();
        return;
    L18:
        return;
    L8:
        if (this.f210161d != null) goto L16;
        this.f210161d = this.f210159b.Yc("Keyboard");
        return;
    L16:
        return;
    }
}
