package com.bytedance.ee.bear.document.pageedit;

import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import tb5.m;

/* JADX INFO: loaded from: classes16.dex */
public final class c implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PageEditPlugin f220811a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ m f220812b;

    @Override // com.bytedance.ee.bear.document.pageedit.g
    public final void onCancel() {
        this.f220811a.setFragment(null);
    }

    public c(PageEditPlugin r100, m r101) {
        this.f220811a = r100;
        this.f220812b = r101;
    }

    @Override // com.bytedance.ee.bear.document.pageedit.g
    public final void a(String r100, ArrayList<PageEditPlugin.UserInfo> r101) {
        Intrinsics.checkNotNullParameter(r100, ReportConstant.COMMON_ACTION_TYPE);
        Intrinsics.checkNotNullParameter(r101, "userInfos");
        this.f220811a.setFragment(null);
        m r102 = this.f220812b;
        PageEditPlugin.DocInfoEditorParams r103 = new PageEditPlugin.DocInfoEditorParams();
        r103.setType(r100);
        r103.setData(r101);
        r102.a(r103);
    }
}
