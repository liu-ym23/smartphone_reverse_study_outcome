package com.bytedance.ee.bear.document.sendtoim;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.contract.x;
import com.bytedance.ee.bear.document.DocumentPluginV2;
import com.bytedance.ee.bear.document.orientation.BaseUnspecifiedOrientationPlugin;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \r2\u00020\u0001:\u0002\r\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u0007H\u0016J\u001a\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\u0010\f\u001a\u0004\u0018\u00010\b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ee/bear/document/sendtoim/SendToImPlugin;", "Lcom/bytedance/ee/bear/document/DocumentPluginV2;", "<init>", "()V", "getBridgeHandlers", "", "handlersHolder", "", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "sendToIm", "title", "content", "Companion", "SendToImHandler", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SendToImPlugin extends DocumentPluginV2 {
    public static final a Companion = null;
    private static final String TAG = "SendToImPlugin";

    public static final class a {
        public a() {
        }
    }

    public final class b implements i<SendToImBean> {
        public final /* synthetic */ SendToImPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(SendToImPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r2, m r3) {
            SendToImBean r4 = (SendToImBean) r2;
            Intrinsics.checkNotNullParameter(r3, "callback");
            tt5.a.h(SendToImPlugin.TAG, "JS request send to im, data = " + r4);
            if (r4 != null) goto L5;
            return;
        L5:
            if (r4.getUrl() != null) goto L7;
            return;
        L7:
            if (r4.getUrl().length() != 0) goto L9;
            boolean r5 = true;
        L10:
            if (r5 == true) goto L16;
            this.a.sendToIm(null, r4.getUrl());
            return;
        L16:
            return;
        L9:
            r5 = false;
            goto L10
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, com.bytedance.ee.bear.browser.plugin.BasePluginV2, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public SendToImPlugin() {
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, yv4.a
    public void getBridgeHandlers(Map<String, i<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "handlersHolder");
        r3.put("biz.common.sendToIm", new b(this));
    }

    public final void sendToIm(String r4, String r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        BaseUnspecifiedOrientationPlugin r0 = (BaseUnspecifiedOrientationPlugin) findPlugin(BaseUnspecifiedOrientationPlugin.class);
        if (r0 == null) goto L7;
        r0.forcePortrait();
    L7:
        ((x) org.koin.java.a.c(x.class, null, null, 6)).t(r4, r5);
    }
}
