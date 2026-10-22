package com.bytedance.ee.bear.block.jira;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JiraActionAdapter f216587a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f216588b;

    public a(JiraActionAdapter r100, String r101) {
        this.f216587a = r100;
        this.f216588b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        JiraActionAdapter.b r101 = this.f216587a.f216566d;
        if (r101 == null) goto L6;
        Intrinsics.checkNotNull(r101);
        r101.a(this.f216588b);
        return;
    }
}
