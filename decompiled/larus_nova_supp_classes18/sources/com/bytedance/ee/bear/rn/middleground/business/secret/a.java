package com.bytedance.ee.bear.rn.middleground.business.secret;

import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.bytedance.ee.bear.rn.RnSyncManager;
import com.bytedance.ee.bear.rn.l;
import com.bytedance.ee.bear.rn.middleground.business.base.BaseProtocol;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ee.space.sync.RnSyncPushManager;
import idb.f;
import io.reactivex.Flowable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements l {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public b e;
    public final yl5.a f;
    public final SimplePropertyPreFilter g;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.rn.middleground.business.secret.a$a, reason: collision with other inner class name */
    public static final class C0142a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.rn.l
    public final void a() {
        if (this.f.a() > 0) goto L7;
        final String r0 = c("unRegisterList");
        Flowable<String> r1 = yl5.b.b(new SecretPushSDK$unRegisterPushListenerInternal$1(r0));
        if (r1 == null) goto L7;
        r1.subscribe();
    L7:
        b r2 = this.e;
        this.e = null;
        if (r2 == null) goto L11;
        RnSyncManager r3 = RnSyncManager.a;
        RnSyncManager.q(r2);
        return;
    }

    @Override // com.bytedance.ee.bear.rn.l
    public final void b(RnSyncPushManager.c r3) {
        Intrinsics.checkNotNullParameter(r3, "observer");
        if (this.f.b() > 1) goto L7;
        final String r0 = c("registerList");
        Flowable<String> r1 = yl5.b.b(new SecretPushSDK$registerPushListenerInternal$1(r0));
        if (r1 == null) goto L7;
        r1.subscribe();
    L7:
        b r2 = new b(this, r3);
        this.e = r2;
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
        r0.setBody(new BaseProtocol.Body.FileDeletePushList(r12, r3, r4, r5, r6, r7, "SEC_UPDATE", r9));
        String r13 = r0.setPropertyFilter(this.g).getJsonString();
        tt5.a.b("SecretPushSDK", "getJsonString: " + r13);
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
        this.f = new yl5.a("secret:" + r8 + ':' + r9);
        this.g = new SimplePropertyPreFilter(BaseProtocol.Body.ReliablePushList.class, new String[]{ResourceData.KEY_TYPE, "tag", "serviceType", "route_key", "route_type", "resource_type", "useNewIO"});
    }
}
