package com.bytedance.ee.bear.document.domaincharacteristicconfig;

import android.text.TextUtils;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.base.DocumentPluginV3;
import com.bytedance.ee.bear.document.y3;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.ss.android.lark.utils.LarkContext;
import e0c.k;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import s45.l;
import t45.c;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \n2\u00020\u0001:\u0002\n\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u0007H\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/document/domaincharacteristicconfig/OfficeMgDomainPlugin;", "Lcom/bytedance/ee/bear/document/base/DocumentPluginV3;", "<init>", "()V", "getBridgeHandlers", "", "handlersHolder", "", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "Companion", "MgDomainHandler", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeMgDomainPlugin extends DocumentPluginV3 {
    public static final a Companion = null;
    public static final String JSB_NAME = "biz.util.getMgDomainConfig";
    public static final String TAG = "MgDomainPlugin";

    public static final class a {
        public a() {
        }
    }

    public final class b implements i<MgDomainJsbRequest> {
        public final /* synthetic */ OfficeMgDomainPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(OfficeMgDomainPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r8, m r9) {
            MgDomainJsbRequest r10 = (MgDomainJsbRequest) r8;
            y3 r1 = this.a.getDocumentMetadata();     // Catch: Throwable -> L19
            if (r1 == null) goto L7;
            String r2 = r1.getUrl();     // Catch: Throwable -> L19
            if (r2 == null) goto L7;
        L8:
            c r3 = (c) k.a(LarkContext.getApplication(), c.class);     // Catch: Throwable -> L19
            l r4 = r3.m8(r2);     // Catch: Throwable -> L19
            MgDomainJsbResp r5 = new MgDomainJsbResp();     // Catch: Throwable -> L19
            String r6 = r3.m4(r4);     // Catch: Throwable -> L19
            String[] r7 = r3.U3(r4);     // Catch: Throwable -> L19
            if (r4 != null) goto L11;
        L14:
            r5.setSrcUrl(r2);     // Catch: Throwable -> L19
            r5.setSrcHost(r4.c);     // Catch: Throwable -> L19
            if (r9 == null) goto L17;
            r9.a(r5);     // Catch: Throwable -> L19
        L17:
            tt5.a.h("MgDomainPlugin", "done, resp=" + r5);     // Catch: Throwable -> L19
            return;
        L11:
            if (TextUtils.isEmpty(r6) == true) goto L14;
            if (r7 == null) goto L14;
            tt5.a.h("MgDomainPlugin", "render inject mg domain info");     // Catch: Throwable -> L19
            r5.setUnit(r4.a);     // Catch: Throwable -> L19
            r5.setDocsApiPrefix(r6);     // Catch: Throwable -> L19
            r5.setFrontierDomain(r7);     // Catch: Throwable -> L19
        L7:
            r2 = "";
        L19:
            th = move-exception;
            tt5.a.f("MgDomainPlugin", th, false);
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.document.base.DocumentPluginV3
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public OfficeMgDomainPlugin() {
    }

    public void getBridgeHandlers(Map<String, i<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "handlersHolder");
        r3.put("biz.util.getMgDomainConfig", new b(this));
    }
}
