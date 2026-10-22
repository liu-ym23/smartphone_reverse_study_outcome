package com.bytedance.ee.bear.rn.middleground.business.reaction;

import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.middleground.comment.Comment;
import com.bytedance.ee.bear.rn.k;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import kotlin.jvm.internal.Intrinsics;
import vl5.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements vl5.a {
    public final /* synthetic */ ReactionSDK a;
    public final /* synthetic */ k.a b;

    public a(ReactionSDK r1, Comment.g r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // vl5.a
    public final void a(c r4, JSONObject r5) {
        if (r4.a != null) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual("comment", r5.getString("business")) == false) goto L18;
        Integer r0 = r5.getJSONObject(WikiFolderPushPlugin.DATA).getJSONObject("identifier").getInteger(ResourceData.KEY_TYPE);
        int r2 = this.a.b.b;
        if (r0 != null) goto L10;
        return;
    L10:
        if (r0.intValue() == r2) goto L12;
        return;
    L12:
        if (Intrinsics.areEqual(r5.getJSONObject(WikiFolderPushPlugin.DATA).getJSONObject("identifier").getString(ResourceData.KEY_TOKEN), this.a.a) == true) goto L14;
        return;
    L14:
        if (Intrinsics.areEqual(r5.getJSONObject(WikiFolderPushPlugin.DATA).getString(WikiFolderPushPlugin.OPT), "updateReactionDetail") == false) goto L21;
        this.b.e(r5.getJSONObject(WikiFolderPushPlugin.DATA).getString("body"));
        return;
    L21:
        return;
    }
}
