package com.bytedance.ee.bear.bitable.infoarch;

import android.content.DialogInterface;
import com.alibaba.fastjson.JSONObject;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import tb5.m;

/* JADX INFO: loaded from: classes15.dex */
public final class c implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f213200a;

    public c(m r100) {
        this.f213200a = r100;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        tt5.a.h("BitableTableRowsLimitHandler", "onclick gotIt");
        m r102 = this.f213200a;
        if (r102 == null) goto L6;
        r102.b(new JSONObject(MapsKt.mapOf(TuplesKt.to("action", "known"))));
        return;
    }
}
