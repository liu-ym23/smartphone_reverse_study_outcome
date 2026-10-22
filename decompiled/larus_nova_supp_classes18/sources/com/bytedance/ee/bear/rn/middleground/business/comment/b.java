package com.bytedance.ee.bear.rn.middleground.business.comment;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.middleground.comment.control.v;
import com.bytedance.ee.bear.rn.g;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements vl5.a {
    public final /* synthetic */ CommentSDK a;
    public final /* synthetic */ g.a b;

    public b(CommentSDK r1, v r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // vl5.a
    public final void a(vl5.c r3, JSONObject r4) {
        if (r3.a != null) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual("comment", r4.getString("business")) == true) goto L7;
        return;
    L7:
        if (Intrinsics.areEqual(r4.getJSONObject(WikiFolderPushPlugin.DATA).getString(WikiFolderPushPlugin.OPT), "sendCommentsData") == true) goto L9;
        return;
    L9:
        if (Intrinsics.areEqual(r4.getJSONObject(WikiFolderPushPlugin.DATA).getJSONObject("identifier").getString(ResourceData.KEY_TOKEN), this.a.a) == false) goto L15;
        this.b.a(JSON.toJSONString(r4, true));
        return;
    }
}
