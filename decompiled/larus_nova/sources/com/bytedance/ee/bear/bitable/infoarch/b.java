package com.bytedance.ee.bear.bitable.infoarch;

import android.view.View;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.route.h;
import com.ss.android.lark.utils.LarkContext;
import e0c.k;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import tb5.m;

/* JADX INFO: loaded from: classes15.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f213181a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TableRowsInfo f213182b;

    public b(m r100, TableRowsInfo r101) {
        this.f213181a = r100;
        this.f213182b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        tt5.a.h("BitableTableRowsLimitHandler", "onclick detail");
        m r101 = this.f213181a;
        if (r101 == null) goto L5;
        r101.b(new JSONObject(MapsKt.mapOf(TuplesKt.to("action", "check_row_limit_info"))));
    L5:
        String r102 = this.f213182b.getUrl();
        if (r102 != null) goto L8;
    L11:
        boolean r103 = true;
    L12:
        if (r103 == true) goto L15;
        ((h) k.a(LarkContext.getApplication(), h.class)).u5(r102);
        return;
    L15:
        return;
    L8:
        if (r102.length() == 0) goto L11;
        r103 = false;
        goto L12
    }
}
