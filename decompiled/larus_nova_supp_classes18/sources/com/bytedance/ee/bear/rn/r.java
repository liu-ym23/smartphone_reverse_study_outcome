package com.bytedance.ee.bear.rn;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.jsbridge.Message;
import com.bytedance.ee.bear.jsbridge.v2.RNMessage;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.ss.android.lark.officesdk.di.core.DependencyContainer;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class r implements ul5.a {
    public r() {
    }

    @Override // ul5.a
    public final void a(String r8) {
        ub5.a r0 = RnSyncManager.l;
        if (r0 == null) goto L27;
        if (r8 != null) goto L6;
        com.ss.android.lark.officesdk.utils.di.j.a(r0.a, "prompt data is null");     // Catch: Throwable -> L23
        return;
    L6:
        RNMessage r1 = (RNMessage) JSON.parseObject(r8, RNMessage.class);     // Catch: Throwable -> L23
        if (r8.length() > 2097152) goto L9;
    L11:
        String r9 = r1.getCallbackID();     // Catch: Throwable -> L23
        if (r9 != null) goto L14;
        Intrinsics.checkNotNull(r1);     // Catch: Throwable -> L23
        r0.b(r1);     // Catch: Throwable -> L23
        return;
    L14:
        ub5.c r10 = (ub5.c) ((ConcurrentHashMap) r0.c).get(r9);     // Catch: Throwable -> L23
        if (r10 != null) goto L17;
        Intrinsics.checkNotNull(r1);     // Catch: Throwable -> L23
        r0.b(r1);     // Catch: Throwable -> L23
        return;
    L17:
        if (r1.getData() == null) goto L20;
        String.valueOf(r1.getData());     // Catch: Throwable -> L23
    L20:
        r10.onCallback();     // Catch: Throwable -> L23
        return;
    L9:
        if (Intrinsics.areEqual(r1.getApiName(), "openDoc") == true) goto L11;
        swb.o.a(r0.a, new Throwable(r8.length() + "  " + r1.getApiName()));     // Catch: Throwable -> L23
        return;
    L23:
        th = move-exception;
        com.ss.android.lark.officesdk.utils.di.j.c(r0.a, "error", th);
        swb.o.a(r0.a, th);
        return;
    }

    @Override // ul5.a
    public final void b(vl5.c r5) {
        String r0 = r5.a;
        if (r0 == null) goto L14;
        JSONObject r1 = JSON.parseObject(r0);
        if (Intrinsics.areEqual("base", r1.getString("business")) == true) goto L7;
    L10:
        Iterator<vl5.a> r2 = RnSyncManager.t.iterator();
    L12:
        if (r2.hasNext() == false) goto L16;
        r2.next().a(r5, r1);
        goto L12
    L16:
        return;
    L7:
        if (Intrinsics.areEqual(r1.getJSONObject(WikiFolderPushPlugin.DATA).getString(WikiFolderPushPlugin.OPT), "log") == false) goto L10;
        tt5.a.h("RnSyncManager", "js_rn_log: " + r1.getJSONObject(WikiFolderPushPlugin.DATA).getJSONObject("body").get("message"));
        return;
    }

    @Override // ul5.a
    public final void c(vl5.f r9) {
        tb5.p r0 = RnSyncManager.k;
        if (r0 == null) goto L19;
        String r10 = r9.a;
        Message r2 = Message.c(r10);     // Catch: Throwable -> L14
        if (r10.length() <= 2097152) goto L11;
        String r1 = "ReportCrashUtils_" + r0.a;     // Catch: Throwable -> L14
        Throwable r3 = new Throwable(r10.length() + "  " + r2.e);     // Catch: Throwable -> L14
        int r11 = com.ss.android.lark.officesdk.utils.di.j.a;     // Catch: Throwable -> L14
        Intrinsics.checkNotNullParameter(r1, "tag");     // Catch: Throwable -> L14
        Intrinsics.checkNotNullParameter(r1, "tag");     // Catch: Throwable -> L14
        DependencyContainer r12 = DependencyContainer.a;     // Catch: Throwable -> L14
        ntb.n r13 = DependencyContainer.a(ntb.n.class, null);     // Catch: Throwable -> L14
        if (r13 == null) goto L11;
        r13.g(r1, "", r3, true);     // Catch: Throwable -> L14
    L11:
        if (TextUtils.isEmpty(r2.b) == false) goto L20;
        r0.c(r2);     // Catch: Throwable -> L14
        return;
    L20:
        return;
    L14:
        th = move-exception;
        com.ss.android.lark.officesdk.utils.di.j.d(r0.a, th);
        swb.o.a(r0.a, th);
        return;
    }
}
