package com.bytedance.ee.bear.rn.middleground.business.secret;

import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.rn.l;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.space.sync.RnSyncPushManager;
import kotlin.jvm.internal.Intrinsics;
import vl5.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements vl5.a {
    public final /* synthetic */ a a;
    public final /* synthetic */ l.a b;

    public b(a r1, RnSyncPushManager.c r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // vl5.a
    public final void a(c r4, JSONObject r5) {
        if (r4.a != null) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual("base", r5.getString("business")) == false) goto L26;
        JSONObject r0 = r5.getJSONObject(WikiFolderPushPlugin.DATA);
        if (r0 == null) goto L9;
        String r1 = r0.getString(WikiFolderPushPlugin.OPT);
    L11:
        if (Intrinsics.areEqual(r1, this.a.a + this.a.b) == false) goto L27;
        JSONObject r2 = r5.getJSONObject(WikiFolderPushPlugin.DATA);
        if (r2 == null) goto L21;
        JSONObject r3 = r2.getJSONObject("body");
        if (r3 == null) goto L21;
        JSONObject r6 = r3.getJSONObject(WikiFolderPushPlugin.DATA);
        if (r6 == null) goto L21;
        boolean r7 = true;
        if (r6.containsKey("update_sec") != true) goto L21;
    L22:
        if (r7 == false) goto L28;
        this.b.didReceivePush(r5.toJSONString());
        return;
    L28:
        return;
    L21:
        r7 = false;
        goto L22
    L27:
        return;
    L9:
        r1 = null;
        goto L11
    }
}
