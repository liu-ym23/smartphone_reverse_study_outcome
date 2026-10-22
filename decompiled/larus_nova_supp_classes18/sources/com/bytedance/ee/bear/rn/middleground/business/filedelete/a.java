package com.bytedance.ee.bear.rn.middleground.business.filedelete;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.bytedance.ee.bear.rn.RnSyncManager;
import com.bytedance.ee.bear.rn.i;
import com.bytedance.ee.bear.rn.middleground.business.base.BaseProtocol;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import idb.f;
import io.reactivex.Flowable;
import kotlin.jvm.internal.Intrinsics;
import vl5.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements i {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public bu5.a e;
    public b f;
    public final yl5.a g;
    public final SimplePropertyPreFilter h;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.rn.middleground.business.filedelete.a$a, reason: collision with other inner class name */
    public static final class C0141a {
    }

    public static final class b implements vl5.a {
        public final /* synthetic */ a a;
        public final /* synthetic */ bu5.a b;

        public b(a r1, bu5.a r2) {
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
            if (r7 == true) goto L28;
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

    static {
    }

    @Override // com.bytedance.ee.bear.rn.i
    public final void a() {
        if (this.g.a() > 0) goto L7;
        final String r0 = c("unRegisterList");
        Flowable<String> r1 = yl5.b.b(new FileDeletePushSDK$unRegisterPushListenerInternal$1(r0));
        if (r1 == null) goto L7;
        r1.subscribe();
    L7:
        b r2 = this.f;
        this.f = null;
        if (r2 == null) goto L11;
        RnSyncManager r3 = RnSyncManager.a;
        RnSyncManager.q(r2);
        return;
    }

    @Override // com.bytedance.ee.bear.rn.i
    public final void b(bu5.a r3) {
        Intrinsics.checkNotNullParameter(r3, "observer");
        if (this.g.b() > 1) goto L7;
        final String r0 = c("registerList");
        Flowable<String> r1 = yl5.b.b(new FileDeletePushSDK$registerPushListenerInternal$1(r0));
        if (r1 == null) goto L7;
        r1.subscribe();
    L7:
        this.e = r3;
        b r2 = new b(this, r3);
        this.f = r2;
        RnSyncManager r4 = RnSyncManager.a;
        RnSyncManager.h(r2);
    }

    public final String c(String r12) {
        BaseProtocol.FileDeleteList r0 = new BaseProtocol.FileDeleteList();
        String r3 = this.a + this.b;
        String r4 = this.a + this.b;
        String r5 = this.b;
        String r6 = this.c;
        String r7 = this.d;
        if (f.a().isCurrentEnable("ccm.rn_msgbox_save_io_instance") == true) goto L5;
    L7:
        boolean r9 = false;
    L8:
        r0.setBody(new BaseProtocol.Body.FileDeletePushList(r12, r3, r4, r5, r6, r7, "DELETE", r9));
        String r13 = r0.setPropertyFilter(this.h).getJsonString();
        tt5.a.b("FileDeletePushSDK", "getJsonString: " + r13);
        return r13;
    L5:
        if (f.a().isCurrentEnable("ccm.mobile.inject_fg_to_rn_enabled") == false) goto L7;
        r9 = true;
        goto L8
    }

    public a(String r8, String r9, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r8, "tagPrefix");
        Intrinsics.checkNotNullParameter(r9, "tagSuffix");
        Intrinsics.checkNotNullParameter(r10, "routeType");
        Intrinsics.checkNotNullParameter(r11, "resourceType");
        this.a = r8;
        this.b = r9;
        this.c = r10;
        this.d = r11;
        this.g = new yl5.a("base:" + r8 + ':' + r9);
        this.h = new SimplePropertyPreFilter(BaseProtocol.Body.ReliablePushList.class, new String[]{ResourceData.KEY_TYPE, "tag", "serviceType", "route_key", "route_type", "resource_type", "useNewIO"});
    }
}
