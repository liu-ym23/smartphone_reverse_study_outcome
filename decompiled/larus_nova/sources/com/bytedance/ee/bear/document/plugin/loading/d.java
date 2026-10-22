package com.bytedance.ee.bear.document.plugin.loading;

import com.bytedance.ee.bear.document.editionmanager.data.TokenResult;
import com.bytedance.ee.util.ui.j;

/* JADX INFO: loaded from: classes16.dex */
public final class d implements c15.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OfficeLoadingPlugin.b f220852a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ OfficeLoadingPlugin f220853b;

    @Override // c15.a
    public final void a(TokenResult r100) {
        OfficeLoadingPlugin.b r101 = this.f220852a;
        if (r100 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        OfficeLoadingPlugin.access$setEditionTokenInPath$p(r101.f220840a, r102);
        j.c(new e(r101.f220840a));
        return;
    L5:
        if (r100.getReal_sub_type() != 4) goto L7;
        r102 = true;
        goto L8
    }

    @Override // c15.a
    public final void onFail(int r100) {
        tt5.a.d("LoaddingPlugin", "checkEditionToken failed, code=" + r100);
        OfficeLoadingPlugin.access$setEditionTokenInPath$p(this.f220853b, false);
    }

    public d(OfficeLoadingPlugin.b r100, OfficeLoadingPlugin r101) {
        this.f220852a = r100;
        this.f220853b = r101;
    }
}
