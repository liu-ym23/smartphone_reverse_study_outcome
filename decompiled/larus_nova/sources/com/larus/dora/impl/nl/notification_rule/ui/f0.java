package com.larus.dora.impl.nl.notification_rule.ui;

import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class f0 implements SwipeLayout.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NotificationRuleAdapter f336350a;

    public f0(NotificationRuleAdapter r100) {
        this.f336350a = r100;
    }

    @Override // com.larus.dora.impl.nl.notification_rule.ui.SwipeLayout.b
    public final void a(SwipeLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "layout");
        WeakReference<SwipeLayout> r101 = this.f336350a.f336313f;
        if (r101 == null) goto L5;
        SwipeLayout r102 = r101.get();
    L7:
        if (Intrinsics.areEqual(r102, r100) == false) goto L10;
        this.f336350a.f336313f = null;
        return;
    L10:
        return;
    L5:
        r102 = null;
        goto L7
    }

    @Override // com.larus.dora.impl.nl.notification_rule.ui.SwipeLayout.b
    public final void b(SwipeLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "layout");
        NotificationRuleAdapter r101 = this.f336350a;
        r101.f336313f = new WeakReference(r100);
    }

    @Override // com.larus.dora.impl.nl.notification_rule.ui.SwipeLayout.b
    public final void c(SwipeLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "layout");
        WeakReference<SwipeLayout> r101 = this.f336350a.f336313f;
        if (r101 == null) goto L5;
        SwipeLayout r102 = r101.get();
    L6:
        if (r102 != null) goto L8;
        return;
    L8:
        if (Intrinsics.areEqual(r102, r100) == true) goto L12;
        r102.a();
        return;
    L12:
        return;
    L5:
        r102 = null;
        goto L6
    }
}
