package com.bytedance.ee.bear.rn.middleground.business.comment;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.rn.g;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import kotlin.jvm.internal.Intrinsics;
import uf5.p0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c implements vl5.a {
    public final /* synthetic */ CommentSDK a;
    public final /* synthetic */ g.a b;

    public c(CommentSDK r1, p0 r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // vl5.a
    public final void a(vl5.c r4, JSONObject r5) {
        if (r4.a != null) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual("comment", r5.getString("business")) == true) goto L7;
        return;
    L7:
        if (Intrinsics.areEqual(r5.getJSONObject(WikiFolderPushPlugin.DATA).getString(WikiFolderPushPlugin.OPT), "updateMessage") == false) goto L19;
        Integer r0 = r5.getJSONObject(WikiFolderPushPlugin.DATA).getJSONObject("identifier").getInteger(ResourceData.KEY_TYPE);
        int r2 = this.a.b.b;
        if (r0 != null) goto L12;
        return;
    L12:
        if (r0.intValue() == r2) goto L14;
        return;
    L14:
        if (Intrinsics.areEqual(r5.getJSONObject(WikiFolderPushPlugin.DATA).getJSONObject("identifier").getString(ResourceData.KEY_TOKEN), this.a.a) == false) goto L21;
        this.b.a(JSON.toJSONString(r5, true));
        return;
    L21:
        return;
    }
}
