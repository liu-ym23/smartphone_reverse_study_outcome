package com.bytedance.ee.bear.block.jira;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class b implements com.bytedance.ee.bear.facade.common.widget.d.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JiraActionFragment f216589a;

    public b(JiraActionFragment r100) {
        this.f216589a = r100;
    }

    @Override // com.bytedance.ee.bear.facade.common.widget.d.b
    public final void a(int r100) {
        if (r100 != 0) goto L15;
        JiraViewModel r101 = this.f216589a.f216573h;
        JiraViewModel r102 = null;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("jiraViewModel");
        r101 = null;
    L6:
        r101.setActive(false);
        JiraViewModel r103 = this.f216589a.f216573h;
        if (r103 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("jiraViewModel");
        r103 = null;
    L9:
        r103.callback("Cancel");
        JiraViewModel r104 = this.f216589a.f216573h;
        if (r104 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("jiraViewModel");
    L13:
        r102.setActive(false);
        return;
    L12:
        r102 = r104;
        goto L13
    }
}
