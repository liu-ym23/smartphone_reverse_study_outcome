package com.bytedance.ee.bear.rn.middleground.business.base;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.bytedance.ee.bear.rn.RnPushProtocol;
import com.bytedance.ee.bear.rn.RnSyncManager;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import io.reactivex.Flowable;
import kotlin.jvm.internal.Intrinsics;
import vl5.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements RnPushProtocol {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public bu5.a e;
    public b f;
    public final int g;
    public final yl5.a h;
    public final SimplePropertyPreFilter i;
    public final int j;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.rn.middleground.business.base.a$a, reason: collision with other inner class name */
    public static final class C0139a {
    }

    public static final class b implements vl5.a {
        public final /* synthetic */ a a;
        public final /* synthetic */ bu5.a b;

        public b(a r1, bu5.a r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // vl5.a
        public final void a(c r3, JSONObject r4) {
            if (r3.a != null) goto L5;
            return;
        L5:
            if (Intrinsics.areEqual("base", r4.getString("business")) == false) goto L15;
            JSONObject r5 = r4.getJSONObject(WikiFolderPushPlugin.DATA);
            if (r5 == null) goto L9;
            String r6 = r5.getString(WikiFolderPushPlugin.OPT);
        L11:
            if (Intrinsics.areEqual(r6, this.a.a + this.a.b) == false) goto L16;
            this.b.didReceivePush(r4.toJSONString());
            return;
        L16:
            return;
        L9:
            r6 = null;
            goto L11
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.rn.RnPushProtocol
    public final void a() {
        if (this.h.a() > 0) goto L7;
        final String r0 = c("unRegisterList");
        Flowable<String> r1 = yl5.b.b(new ReliableBasePushSDK$unRegisterPushListenerInternal$1(r0));
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

    @Override // com.bytedance.ee.bear.rn.RnPushProtocol
    public final void b(bu5.a r3) {
        Intrinsics.checkNotNullParameter(r3, "observer");
        if (this.h.b() > 1) goto L7;
        final String r0 = c("registerList");
        Flowable<String> r1 = yl5.b.b(new ReliableBasePushSDK$registerPushListenerInternal$1(r0));
        if (r1 == null) goto L7;
        r1.subscribe();
    L7:
        this.e = r3;
        b r2 = new b(this, r3);
        this.f = r2;
        RnSyncManager r4 = RnSyncManager.a;
        RnSyncManager.h(r2);
    }

    public final String c(String r15) {
        BaseProtocol.ReliablePushList r0 = new BaseProtocol.ReliablePushList();
        String r3 = this.a + this.b;
        String r4 = this.a + this.b;
        String r5 = this.b;
        String r6 = this.c;
        String r7 = this.d;
        int r8 = this.g;
        int r1 = this.j;
        if (r1 < 0) goto L5;
        BaseProtocol.Body.Extra r9 = new BaseProtocol.Body.Extra(Integer.valueOf(r1));
    L6:
        r0.setBody(new BaseProtocol.Body.ReliablePushList(r15, r3, r4, r5, r6, r7, r8, r9, false, 256, null));
        String r16 = r0.setPropertyFilter(this.i).getJsonString();
        tt5.a.b("ReliableBasePushSDK", "getJsonString: " + r16);
        return r16;
    L5:
        r9 = null;
        goto L6
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
        this.h = new yl5.a("base:" + r8 + ':' + r9);
        this.i = new SimplePropertyPreFilter(BaseProtocol.Body.ReliablePushList.class, new String[]{ResourceData.KEY_TYPE, "tag", "serviceType", "route_key", "route_type", "resource_type", "useNewIO"});
        this.j = -1;
    }

    public a(String r10, String r11, String r12, String r13, RnPushProtocol.RnPushExtraParam r14) {
        Intrinsics.checkNotNullParameter(r10, "tagPrefix");
        Intrinsics.checkNotNullParameter(r11, "tagSuffix");
        Intrinsics.checkNotNullParameter(r12, "routeType");
        Intrinsics.checkNotNullParameter(r13, "resourceType");
        this(r10, r11, r12, r13);
        if (r14 == null) goto L5;
        int r15 = r14.getVersion();
    L6:
        this.g = r15;
        this.i = new SimplePropertyPreFilter(BaseProtocol.Body.ReliablePushList.class, new String[]{ResourceData.KEY_TYPE, "tag", "serviceType", "route_key", "route_type", "resource_type", "messageBoxVersion", "extra", "useNewIO"});
        if (r14 == null) goto L9;
        int r16 = r14.getObjType();
    L10:
        this.j = r16;
        return;
    L9:
        r16 = -1;
        goto L10
    L5:
        r15 = 0;
        goto L6
    }
}
