package com.suite.lark.platform.component.widget_biz_searchfilter.searchfilterv2;

import android.view.View;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes36.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FilterViewV2 f461029a;

    public b(FilterViewV2 r100) {
        this.f461029a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Log.d("LarkWidget.FilterViewV2", "mResetTv onClick.");
        FilterViewV2.d r101 = this.f461029a.f460997e;
        if (r101 == null) goto L6;
        r101.a();
        return;
    }
}
