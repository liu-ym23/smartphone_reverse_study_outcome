package com.bytedance.ee.bear.templates.topic;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.templates.TemplateUtils;
import com.bytedance.ee.bear.templates.n;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.util.ArrayList;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h implements NetService.c<TopicDataResult> {
    public final int a;

    public final int getType() {
        return this.a;
    }

    public h(int r1) {
        this.a = r1;
    }

    public final Result parse(String r8) {
        Locale r0 = ((i0) org.koin.java.a.c(i0.class, null, null, 6)).c();
        boolean r1 = j.a.a.getNetworkState().a();
        JSONObject r9 = new JSONObject(r8).optJSONObject(WikiFolderPushPlugin.DATA);
        JSONObject r3 = r9.optJSONObject("banner");
        f r4 = new f();
        r4.a = r3.optString("image_url");
        r3.optString(ResourceData.KEY_OBJ_TOKEN);
        r3.optInt("obj_type");
        r3.optInt("template_id");
        r3.optInt("topic_id");
        JSONObject r10 = JSONObjectProtectorUtils.getJSONObject(r9, "templates");
        ArrayList r5 = new ArrayList();
        int r6 = this.a;
        if (r6 != sbb.e.e.b) goto L6;
        TemplateUtils r2 = TemplateUtils.a;
        Intrinsics.checkNotNull(r10);
        Intrinsics.checkNotNull(r0);
        r2.getClass();
        r5.addAll(TemplateUtils.a(r10, r0, r1));
    L10:
        TopicDataResult r11 = new TopicDataResult();
        ((Result) r11).data = new TopicData(r4, r5);
        return r11;
    L6:
        if (r10.has(String.valueOf(r6)) == false) goto L8;
        int r7 = n.a;
        JSONArray r12 = JSONObjectProtectorUtils.getJSONArray(r10, String.valueOf(this.a));
        Intrinsics.checkNotNull(r0);
        ArrayList r13 = n.b(r12, null, r0, r1);
    L9:
        r5 = r13;
        goto L10
    L8:
        r13 = new ArrayList();
        goto L9
    }
}
