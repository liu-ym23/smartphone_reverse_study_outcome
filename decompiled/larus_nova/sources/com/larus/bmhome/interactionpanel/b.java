package com.larus.bmhome.interactionpanel;

import com.larus.bmhome.clarification.a2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class b implements a2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f312327a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f312328b;

    @Override // com.larus.bmhome.clarification.a2
    public final boolean a(m r100) {
        Intrinsics.checkNotNullParameter(r100, "entry");
        return this.f312327a.f312323b.g(r100.f312374a, this.f312328b);
    }

    public b(a r100, String r101) {
        this.f312327a = r100;
        this.f312328b = r101;
    }

    @Override // com.larus.bmhome.clarification.a2
    public final void b(m r100, boolean r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "entry");
        Intrinsics.checkNotNullParameter(r102, "reason");
        if (r101 == false) goto L5;
        this.f312327a.f312323b.d(r100.f312374a, this.f312328b, r102);
        return;
    L5:
        this.f312327a.f312323b.b(r100.f312374a, this.f312328b, InteractionPanelSubmitResult.FAILURE);
    }
}
