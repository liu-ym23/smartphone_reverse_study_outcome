package com.bytedance.ee.bear.bitable.websubpage.plugins;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.DocumentPluginV2;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.bear.route.h;
import com.bytedance.ee.util.ui.n;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.utils.LarkContext;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \r2\u00020\u0001:\u0002\r\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u0007H\u0016J\u000e\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ee/bear/bitable/websubpage/plugins/OpenWebPagePlugin;", "Lcom/bytedance/ee/bear/document/DocumentPluginV2;", "<init>", "()V", "getBridgeHandlers", "", "handlersHolder", "", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "getMoreInfoHelpCenterUrl", "resId", "", "Companion", "OpenWebHandler", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OpenWebPagePlugin extends DocumentPluginV2 {
    public static final a Companion = null;
    private static final String FLAG_OPEN_MORE_GANTEE = "moreGantee";
    private static final String FLAG_OPEN_MORE_RECORD_LIMIT = "moreRecordLimit";
    private static final String OPENWEB_BRIDGE = "biz.bitable.openWebPage";
    private static final String TAG = "OpenWebPagePlugin";

    public static final class a {
        public a() {
        }
    }

    public final class b implements i<String> {
        public final /* synthetic */ OpenWebPagePlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(OpenWebPagePlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r4, m r5) {
            String r6 = (String) r4;
            if (r6 == null) goto L18;
            OpenWebPagePlugin r7 = this.a;
            String r8 = new JSONObject(r6).optString("flag");     // Catch: Exception -> L12
            if (TextUtils.equals(OpenWebPagePlugin.FLAG_OPEN_MORE_GANTEE, r8) == false) goto L9;
            ((h) org.koin.java.a.c(h.class, null, null, 6)).u5(r7.getMoreInfoHelpCenterUrl(2131886327));     // Catch: Exception -> L12
        L14:
            return;
        L9:
            if (TextUtils.equals(OpenWebPagePlugin.FLAG_OPEN_MORE_RECORD_LIMIT, r8) == false) goto L14;
            ((h) org.koin.java.a.c(h.class, null, null, 6)).u5(r7.getMoreInfoHelpCenterUrl(2131886329));     // Catch: Exception -> L12
        L12:
            tt5.a.d(OpenWebPagePlugin.TAG, "can not handle open webpage with empty data");
            return;
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, com.bytedance.ee.bear.browser.plugin.BasePluginV2, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public OpenWebPagePlugin() {
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, yv4.a
    public void getBridgeHandlers(Map<String, i<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "handlersHolder");
        super.getBridgeHandlers(r3);
        r3.put(OPENWEB_BRIDGE, new b(this));
    }

    public final String getMoreInfoHelpCenterUrl(int r8) {
        String r1 = n.x(LarkContext.getApplication(), r8);
        String r3 = ((s45.c) org.koin.java.a.c(s45.c.class, null, null, 6)).Ba("helpcenter");
        if (TextUtils.isEmpty(r3) == true) goto L10;
        Uri r9 = UriProtector.parse(r1);
        if (r9 == null) goto L11;
        String r2 = r9.getHost();
        if (r2 == null) goto L12;
        Intrinsics.checkNotNull(r3);
        return StringsKt.replaceFirst$default(r1, r2, r3, false, 4, null);
    L12:
        return r1;
    L11:
        return r1;
    L10:
        return r1;
    }
}
