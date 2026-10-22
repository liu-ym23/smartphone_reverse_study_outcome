package com.bytedance.ee.bear.block.jira;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements com.bytedance.ee.bear.facade.common.widget.d.b {
    public final /* synthetic */ JiraActionFragment a;

    public b(JiraActionFragment r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.facade.common.widget.d.b
    public final void a(int r5) {
        if (r5 != 0) goto L15;
        JiraViewModel r6 = this.a.h;
        JiraViewModel r0 = null;
        if (r6 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("jiraViewModel");
        r6 = null;
    L6:
        r6.setActive(false);
        JiraViewModel r7 = this.a.h;
        if (r7 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("jiraViewModel");
        r7 = null;
    L9:
        r7.callback("Cancel");
        JiraViewModel r8 = this.a.h;
        if (r8 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("jiraViewModel");
    L13:
        r0.setActive(false);
        return;
    L12:
        r0 = r8;
        goto L13
    }
}
