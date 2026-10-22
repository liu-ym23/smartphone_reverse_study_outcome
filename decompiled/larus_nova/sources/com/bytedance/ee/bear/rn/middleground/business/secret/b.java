package com.bytedance.ee.bear.rn.middleground.business.secret;

import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.rn.l;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.space.sync.RnSyncPushManager;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import kotlin.jvm.internal.Intrinsics;
import vl5.c;

/* JADX INFO: loaded from: classes18.dex */
public final class b implements vl5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f236626a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l.a f236627b;

    public b(a r100, RnSyncPushManager.c r101) {
        this.f236626a = r100;
        this.f236627b = r101;
    }

    @Override // vl5.a
    public final void a(c r100, JSONObject r101) {
        if (r100.f555679a != null) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual("base", r101.getString("business")) == false) goto L26;
        JSONObject r102 = r101.getJSONObject("data");
        if (r102 == null) goto L9;
        String r103 = r102.getString(WikiFolderPushPlugin.OPT);
    L11:
        if (Intrinsics.areEqual(r103, this.f236626a.f236619a + this.f236626a.f236620b) == false) goto L27;
        JSONObject r104 = r101.getJSONObject("data");
        if (r104 == null) goto L21;
        JSONObject r105 = r104.getJSONObject(ContainerPosition.BODY);
        if (r105 == null) goto L21;
        JSONObject r106 = r105.getJSONObject("data");
        if (r106 == null) goto L21;
        boolean r107 = true;
        if (r106.containsKey("update_sec") != true) goto L21;
    L22:
        if (r107 == false) goto L28;
        this.f236627b.didReceivePush(r101.toJSONString());
        return;
    L28:
        return;
    L21:
        r107 = false;
        goto L22
    L27:
        return;
    L9:
        r103 = null;
        goto L11
    }
}
