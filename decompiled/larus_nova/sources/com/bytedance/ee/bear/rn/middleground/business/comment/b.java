package com.bytedance.ee.bear.rn.middleground.business.comment;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.ee.bear.middleground.comment.control.v;
import com.bytedance.ee.bear.rn.g;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class b implements vl5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommentSDK f236588a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g.a f236589b;

    public b(CommentSDK r100, v r101) {
        this.f236588a = r100;
        this.f236589b = r101;
    }

    @Override // vl5.a
    public final void a(vl5.c r100, JSONObject r101) {
        if (r100.f555679a != null) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual("comment", r101.getString("business")) == true) goto L7;
        return;
    L7:
        if (Intrinsics.areEqual(r101.getJSONObject("data").getString(WikiFolderPushPlugin.OPT), "sendCommentsData") == true) goto L9;
        return;
    L9:
        if (Intrinsics.areEqual(r101.getJSONObject("data").getJSONObject(LocationMonitorConst.IDENTIFIER).getString("token"), this.f236588a.f236581a) == false) goto L15;
        this.f236589b.a(JSON.toJSONString(r101, true));
        return;
    }
}
