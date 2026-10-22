package com.ss.android.lark.passport.flow.core.widget;

import android.app.Activity;
import com.ss.android.lark.utils.ViewUtils;

/* JADX INFO: loaded from: classes37.dex */
public final class a implements CommonTitleBar.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommonTitleBar f437812a;

    @Override // com.ss.android.lark.passport.flow.core.widget.CommonTitleBar.b
    public final void a() {
    }

    @Override // com.ss.android.lark.passport.flow.core.widget.CommonTitleBar.b
    public final void c() {
    }

    @Override // com.ss.android.lark.passport.flow.core.widget.CommonTitleBar.b
    public final void d() {
    }

    @Override // com.ss.android.lark.passport.flow.core.widget.CommonTitleBar.b
    public final void b() {
        CommonTitleBar r100 = this.f437812a;
        if (r100.f437811r != null) goto L6;
        r100.f437811r = ViewUtils.getActivityByContext(r100.getContext());
    L6:
        Activity r101 = this.f437812a.f437811r;
        if (r101 == null) goto L10;
        r101.onBackPressed();
        return;
    }

    public a(CommonTitleBar r100) {
        this.f437812a = r100;
    }
}
