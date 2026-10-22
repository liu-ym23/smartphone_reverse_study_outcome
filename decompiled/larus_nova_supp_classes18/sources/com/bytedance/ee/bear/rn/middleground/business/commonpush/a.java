package com.bytedance.ee.bear.rn.middleground.business.commonpush;

import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.rn.RnSyncManager;
import com.bytedance.ee.bear.rn.h;
import com.bytedance.ee.bear.rn.middleground.protocol.Protocol;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import io.reactivex.Flowable;
import kotlin.jvm.internal.Intrinsics;
import sbb.e;
import vl5.c;
import yl5.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements h {
    public final String a;
    public final e b;
    public final String c;
    public C0140a d;
    public final yl5.a e;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.rn.middleground.business.commonpush.a$a, reason: collision with other inner class name */
    public static final class C0140a implements vl5.a {
        public final /* synthetic */ a a;
        public final /* synthetic */ h.a b;

        public C0140a(a r1, h.a r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // vl5.a
        public final void a(c r4, JSONObject r5) {
            if (r4.a != null) goto L5;
            return;
        L5:
            if (Intrinsics.areEqual("common", r5.getString("business")) == false) goto L34;
            JSONObject r0 = r5.getJSONObject(WikiFolderPushPlugin.DATA);
            if (r0 == null) goto L16;
            JSONObject r1 = r0.getJSONObject("identifier");
            if (r1 == null) goto L16;
            Integer r2 = r1.getInteger(ResourceData.KEY_TYPE);
            int r3 = this.a.b.b;
            if (r2 == null) goto L16;
            if (r2.intValue() != r3) goto L16;
            boolean r6 = true;
        L17:
            if (r6 == false) goto L35;
            JSONObject r7 = r5.getJSONObject(WikiFolderPushPlugin.DATA);
            String r8 = null;
            if (r7 == null) goto L23;
            JSONObject r9 = r7.getJSONObject("identifier");
            if (r9 == null) goto L23;
            String r10 = r9.getString(ResourceData.KEY_TOKEN);
        L25:
            if (Intrinsics.areEqual(r10, this.a.a) == false) goto L36;
            JSONObject r11 = r5.getJSONObject(WikiFolderPushPlugin.DATA);
            Intrinsics.checkNotNull(r11);
            if (Intrinsics.areEqual(r11.getString(WikiFolderPushPlugin.OPT), this.a.c) == false) goto L37;
            h.a r12 = this.b;
            JSONObject r13 = r5.getJSONObject(WikiFolderPushPlugin.DATA);
            if (r13 == null) goto L31;
            r8 = r13.getString("body");
        L31:
            r12.didReceivePush(r8);
            return;
        L37:
            return;
        L36:
            return;
        L23:
            r10 = null;
            goto L25
        L35:
            return;
        L16:
            r6 = false;
            goto L17
        }
    }

    @Override // com.bytedance.ee.bear.rn.h
    public final void a() {
        if (this.e.a() != 0) goto L7;
        CommonPushProtocol.EndSync r0 = new CommonPushProtocol.EndSync();
        r0.setIdentifier(new Protocol.Entity.Identifier(this.b.b, this.a, false, null, 12, null));
        final String r1 = r0.getJsonString();
        Flowable<String> r2 = b.b(new CommonPushSDK$endSync$1(r1));
        if (r2 == null) goto L7;
        r2.subscribe();
    L7:
        C0140a r3 = this.d;
        this.d = null;
        if (r3 == null) goto L11;
        RnSyncManager r4 = RnSyncManager.a;
        RnSyncManager.q(r3);
        return;
    }

    @Override // com.bytedance.ee.bear.rn.h
    public final void b(h.a r10) {
        Intrinsics.checkNotNullParameter(r10, "observer");
        if (this.e.b() > 1) goto L7;
        CommonPushProtocol.BeginSync r0 = new CommonPushProtocol.BeginSync();
        r0.setIdentifier(new Protocol.Entity.Identifier(this.b.b, this.a, false, null, 12, null));
        final String r1 = r0.getJsonString();
        Flowable<String> r2 = b.b(new CommonPushSDK$beginSync$1(r1));
        if (r2 == null) goto L7;
        r2.subscribe();
    L7:
        C0140a r3 = new C0140a(this, r10);
        this.d = r3;
        RnSyncManager r11 = RnSyncManager.a;
        RnSyncManager.h(r3);
    }

    public a(String r3, e r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "docToken");
        Intrinsics.checkNotNullParameter(r4, "documentType");
        Intrinsics.checkNotNullParameter(r5, WikiFolderPushPlugin.OPT);
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.e = new yl5.a("common:" + r3 + ':' + r4.b + ':' + r4.getType());
    }
}
