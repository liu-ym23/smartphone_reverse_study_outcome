package com.bytedance.ee.bear.block.jira;

import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import kotlin.jvm.internal.Intrinsics;
import tb5.m;

/* JADX INFO: loaded from: classes16.dex */
public final class d implements JiraViewModel.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f216594a;

    public d(m r100) {
        this.f216594a = r100;
    }

    @Override // com.bytedance.ee.bear.block.jira.JiraViewModel.a
    public final void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, WikiFolderPushPlugin.BLOCK_ID);
        Intrinsics.checkNotNullParameter(r101, "actionId");
        JSONObject r102 = new JSONObject();
        r102.put(WikiFolderPushPlugin.BLOCK_ID, r100);
        r102.put("actionId", r101);
        tt5.a.b("JiraPlugin", "callback: data = " + r102);
        m r103 = this.f216594a;
        if (r103 == null) goto L6;
        r103.b(r102);
        return;
    }
}
