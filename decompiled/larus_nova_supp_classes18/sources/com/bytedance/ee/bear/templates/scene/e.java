package com.bytedance.ee.bear.templates.scene;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.templates.TemplateUtils;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.util.ArrayList;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e implements NetService.c<TopicDataResult> {
    public e() {
    }

    public final Result parse(String r6) {
        Locale r0 = ((i0) org.koin.java.a.c(i0.class, null, null, 6)).c();
        boolean r1 = j.a.a.getNetworkState().a();
        JSONObject r7 = JSONObjectProtectorUtils.getJSONObject(new JSONObject(r6).optJSONObject(WikiFolderPushPlugin.DATA), "templates");
        TemplateUtils r3 = TemplateUtils.a;
        Intrinsics.checkNotNull(r7);
        Intrinsics.checkNotNull(r0);
        r3.getClass();
        ArrayList r8 = TemplateUtils.a(r7, r0, r1);
        TopicDataResult r2 = new TopicDataResult();
        ((Result) r2).data = new TopicData(r8, false, 2, null);
        return r2;
    }
}
