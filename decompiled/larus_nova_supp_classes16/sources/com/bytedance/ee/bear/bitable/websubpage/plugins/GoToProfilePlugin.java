package com.bytedance.ee.bear.bitable.websubpage.plugins;

import android.text.TextUtils;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.docshost.k;
import com.bytedance.ee.bear.document.DocumentPluginV2;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \n2\u00020\u0001:\u0002\n\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u0007H\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/bitable/websubpage/plugins/GoToProfilePlugin;", "Lcom/bytedance/ee/bear/document/DocumentPluginV2;", "<init>", "()V", "getBridgeHandlers", "", "handlersHolder", "", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "Companion", "GoToProfileHandler", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GoToProfilePlugin extends DocumentPluginV2 {
    public static final a Companion = null;
    private static final String GOTOPROFILE_BRIDGE = "biz.bitable.goToProfile";
    private static final String TAG = "GoToProfilePlugin";

    public static final class a {
        public a() {
        }
    }

    public final class b implements i<String> {
        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b() {
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r4, m r5) {
            String r6 = (String) r4;
            if (r6 == null) goto L16;
            String r7 = new JSONObject(r6).optString("token");     // Catch: Exception -> L9
            if (TextUtils.isEmpty(r7) == true) goto L7;
            ((k) org.koin.java.a.c(k.class, null, null, 6)).e(r7, "");     // Catch: Exception -> L9
        L12:
            return;
        L7:
            tt5.a.h(GoToProfilePlugin.TAG, "can not go to profile with empty token");     // Catch: Exception -> L9
            Unit r8 = Unit.INSTANCE;     // Catch: Exception -> L9
        L9:
            e = move-exception;
            tt5.a.d(GoToProfilePlugin.TAG, "handle goto profile ex:" + e.getMessage());
            Unit r9 = Unit.INSTANCE;
            return;
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, com.bytedance.ee.bear.browser.plugin.BasePluginV2, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public GoToProfilePlugin() {
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, yv4.a
    public void getBridgeHandlers(Map<String, i<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "handlersHolder");
        super.getBridgeHandlers(r3);
        r3.put(GOTOPROFILE_BRIDGE, new b());
    }
}
