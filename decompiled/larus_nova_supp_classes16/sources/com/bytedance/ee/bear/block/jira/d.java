package com.bytedance.ee.bear.block.jira;

import com.alibaba.fastjson.JSONObject;
import kotlin.jvm.internal.Intrinsics;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d implements JiraViewModel.a {
    public final /* synthetic */ m a;

    public d(m r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.block.jira.JiraViewModel.a
    public final void a(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "blockId");
        Intrinsics.checkNotNullParameter(r5, "actionId");
        JSONObject r2 = new JSONObject();
        r2.put("blockId", r4);
        r2.put("actionId", r5);
        tt5.a.b("JiraPlugin", "callback: data = " + r2);
        m r6 = this.a;
        if (r6 == null) goto L6;
        r6.b(r2);
        return;
    }
}
