package com.bytedance.ee.bear.rn.middleground.business.comment;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.ee.bear.rn.g;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import kotlin.jvm.internal.Intrinsics;
import uf5.p0;

/* JADX INFO: loaded from: classes18.dex */
public final class c implements vl5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommentSDK f236590a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g.a f236591b;

    public c(CommentSDK r100, p0 r101) {
        this.f236590a = r100;
        this.f236591b = r101;
    }

    @Override // vl5.a
    public final void a(vl5.c r100, JSONObject r101) {
        if (r100.f555679a != null) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual("comment", r101.getString("business")) == true) goto L7;
        return;
    L7:
        if (Intrinsics.areEqual(r101.getJSONObject("data").getString(WikiFolderPushPlugin.OPT), "updateMessage") == false) goto L19;
        Integer r102 = r101.getJSONObject("data").getJSONObject(LocationMonitorConst.IDENTIFIER).getInteger("type");
        int r103 = this.f236590a.f236582b.f541317b;
        if (r102 != null) goto L12;
        return;
    L12:
        if (r102.intValue() == r103) goto L14;
        return;
    L14:
        if (Intrinsics.areEqual(r101.getJSONObject("data").getJSONObject(LocationMonitorConst.IDENTIFIER).getString("token"), this.f236590a.f236581a) == false) goto L21;
        this.f236591b.a(JSON.toJSONString(r101, true));
        return;
    L21:
        return;
    }
}
