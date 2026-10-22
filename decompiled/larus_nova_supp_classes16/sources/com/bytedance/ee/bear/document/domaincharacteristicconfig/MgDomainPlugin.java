package com.bytedance.ee.bear.document.domaincharacteristicconfig;

import android.text.TextUtils;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
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
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \n2\u00020\u0001:\u0002\n\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u0007H\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/document/domaincharacteristicconfig/MgDomainPlugin;", "Lcom/bytedance/ee/bear/document/DocumentPlugin;", "<init>", "()V", "getBridgeHandlers", "", "handlersHolder", "", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "Companion", "MgDomainHandler", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MgDomainPlugin extends DocumentPlugin {
    public static final a Companion = null;
    public static final String JSB_NAME = "biz.util.getMgDomainConfig";
    public static final String TAG = "MgDomainPlugin";

    public static final class a {
        public a() {
        }
    }

    public final class b implements i<MgDomainJsbRequest> {
        public final /* synthetic */ MgDomainPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(MgDomainPlugin r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // tb5.i, tb5.o
        public final void handle(Object r8, m r9) {
            MgDomainJsbRequest r10 = (MgDomainJsbRequest) r8;
            String r1 = ((DocumentPluginHost) this.a.getHost()).a().getOriginUrl();     // Catch: Throwable -> L17
            if (r1 != null) goto L6;
            r1 = ((DocumentPluginHost) this.a.getHost()).a().getUrl();     // Catch: Throwable -> L17
        L6:
            c r2 = (c) k.a(LarkContext.getApplication(), c.class);     // Catch: Throwable -> L17
            l r3 = r2.m8(r1);     // Catch: Throwable -> L17
            MgDomainJsbResp r4 = new MgDomainJsbResp();     // Catch: Throwable -> L17
            String r5 = r2.m4(r3);     // Catch: Throwable -> L17
            String[] r6 = r2.U3(r3);     // Catch: Throwable -> L17
            if (r3 != null) goto L9;
        L12:
            r4.setSrcUrl(r1);     // Catch: Throwable -> L17
            r4.setSrcHost(r3.c);     // Catch: Throwable -> L17
            if (r9 == null) goto L15;
            r9.a(r4);     // Catch: Throwable -> L17
        L15:
            tt5.a.h("MgDomainPlugin", "done, resp=" + r4);     // Catch: Throwable -> L17
            return;
        L9:
            if (TextUtils.isEmpty(r5) == true) goto L12;
            if (r6 == null) goto L12;
            tt5.a.h("MgDomainPlugin", "render inject mg domain info");     // Catch: Throwable -> L17
            r4.setUnit(r3.a);     // Catch: Throwable -> L17
            r4.setDocsApiPrefix(r5);     // Catch: Throwable -> L17
            r4.setFrontierDomain(r6);     // Catch: Throwable -> L17
        L17:
            th = move-exception;
            tt5.a.f("MgDomainPlugin", th, false);
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public MgDomainPlugin() {
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, yv4.a
    public void getBridgeHandlers(Map<String, i<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "handlersHolder");
        r3.put("biz.util.getMgDomainConfig", new b(this));
    }
}
