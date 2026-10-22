package com.bytedance.ee.bear.rn.middleground.business.secret;

import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.bytedance.ee.bear.rn.RnSyncManager;
import com.bytedance.ee.bear.rn.l;
import com.bytedance.ee.bear.rn.middleground.business.base.BaseProtocol;
import com.bytedance.ee.space.sync.PushRoute$EType;
import com.bytedance.ee.space.sync.RnSyncPushManager;
import com.ss.cast.discovery.mdns.nsdhelper.NsdHelper;
import idb.f;
import io.reactivex.Flowable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class a implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f236619a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f236620b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f236621c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f236622d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b f236623e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final yl5.a f236624f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final SimplePropertyPreFilter f236625g;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.rn.middleground.business.secret.a$a, reason: collision with other inner class name */
    public static final class C3389a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.rn.l
    public final void a() {
        if (this.f236624f.a() > 0) goto L7;
        final String r100 = c("unRegisterList");
        Flowable<String> r101 = yl5.b.b(new SecretPushSDK$unRegisterPushListenerInternal$1(r100));
        if (r101 == null) goto L7;
        r101.subscribe();
    L7:
        b r102 = this.f236623e;
        this.f236623e = null;
        if (r102 == null) goto L11;
        RnSyncManager r103 = RnSyncManager.f236496a;
        RnSyncManager.q(r102);
        return;
    }

    @Override // com.bytedance.ee.bear.rn.l
    public final void b(RnSyncPushManager.c r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        if (this.f236624f.b() > 1) goto L7;
        final String r101 = c("registerList");
        Flowable<String> r102 = yl5.b.b(new SecretPushSDK$registerPushListenerInternal$1(r101));
        if (r102 == null) goto L7;
        r102.subscribe();
    L7:
        b r103 = new b(this, r100);
        this.f236623e = r103;
        RnSyncManager r104 = RnSyncManager.f236496a;
        RnSyncManager.h(r103);
    }

    public final String c(String r110) {
        BaseProtocol.FileDeleteList r100 = new BaseProtocol.FileDeleteList();
        String r101 = this.f236619a + this.f236620b;
        String r102 = this.f236619a + this.f236620b;
        String r103 = this.f236620b;
        String r104 = this.f236621c;
        String r105 = this.f236622d;
        if (f.a().isCurrentEnable("ccm.rn_msgbox_save_io_instance") == true) goto L5;
    L7:
        boolean r106 = false;
    L8:
        r100.setBody(new BaseProtocol.Body.FileDeletePushList(r110, r101, r102, r103, r104, r105, "SEC_UPDATE", r106));
        String r111 = r100.setPropertyFilter(this.f236625g).getJsonString();
        tt5.a.b("SecretPushSDK", "getJsonString: " + r111);
        return r111;
    L5:
        if (f.a().isCurrentEnable("ccm.mobile.inject_fg_to_rn_enabled") == false) goto L7;
        r106 = true;
        goto L8
    }

    public a(String r100, String r101, String r110, String r111) {
        Intrinsics.checkNotNullParameter(r100, "tagPrefix");
        Intrinsics.checkNotNullParameter(r101, "tagSuffix");
        Intrinsics.checkNotNullParameter(r110, "routeType");
        Intrinsics.checkNotNullParameter(r111, "resourceType");
        this.f236619a = r100;
        this.f236620b = r101;
        this.f236621c = r110;
        this.f236622d = r111;
        this.f236624f = new yl5.a("secret:" + r100 + ':' + r101);
        this.f236625g = new SimplePropertyPreFilter(BaseProtocol.Body.ReliablePushList.class, new String[]{"type", "tag", NsdHelper.serviceTypeKey, "route_key", PushRoute$EType.KEY_NAME, "resource_type", "useNewIO"});
    }
}
