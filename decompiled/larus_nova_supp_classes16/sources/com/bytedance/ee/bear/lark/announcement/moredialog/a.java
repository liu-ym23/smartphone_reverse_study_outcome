package com.bytedance.ee.bear.lark.announcement.moredialog;

import com.alibaba.fastjson.JSONObject;
import kotlin.jvm.internal.Intrinsics;
import r05.b;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements b.a {
    public final /* synthetic */ MoreDialogPlugin.b a;

    public a(MoreDialogPlugin.b r1) {
        this.a = r1;
    }

    @Override // r05.b.a
    public final void a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "id");
        MoreDialogPlugin.b r1 = this.a;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r5, "id");
        tt5.a.h(MoreDialogPlugin.TAG, "onClickMoreDialogItem: " + r5);
        JSONObject r2 = new JSONObject();
        r2.put("id", r5);
        m r6 = r1.a;
        if (r6 == null) goto L6;
        r6.b(r2);
        return;
    }
}
