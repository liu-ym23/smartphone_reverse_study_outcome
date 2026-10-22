package com.bytedance.ee.bear.lark.announcement.moredialog;

import com.alibaba.fastjson.JSONObject;
import kotlin.jvm.internal.Intrinsics;
import r05.b;
import tb5.m;

/* JADX INFO: loaded from: classes16.dex */
public final class a implements b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MoreDialogPlugin.b f227266a;

    public a(MoreDialogPlugin.b r100) {
        this.f227266a = r100;
    }

    @Override // r05.b.a
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "id");
        MoreDialogPlugin.b r101 = this.f227266a;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "id");
        tt5.a.h(MoreDialogPlugin.TAG, "onClickMoreDialogItem: " + r100);
        JSONObject r102 = new JSONObject();
        r102.put("id", r100);
        m r103 = r101.f227262a;
        if (r103 == null) goto L6;
        r103.b(r102);
        return;
    }
}
