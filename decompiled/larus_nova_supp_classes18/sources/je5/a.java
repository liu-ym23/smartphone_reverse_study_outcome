package je5;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.bytedance.ies.xbridge.s;
import com.bytedance.supervisor.token.Token;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a extends XCoreBridgeMethod {
    public final String a;

    /* JADX INFO: renamed from: je5.a$a, reason: collision with other inner class name */
    public static final class C0250a {
    }

    static {
    }

    public a() {
        this.a = "ccm.setPrimaryClip";
    }

    public final String getName() {
        return this.a;
    }

    public final void handle(XReadableMap r9, XBridgeMethod.Callback r10, XBridgePlatformType r11) {
        Intrinsics.checkNotNullParameter(r9, "params");
        Intrinsics.checkNotNullParameter(r10, "callback");
        Intrinsics.checkNotNullParameter(r11, ResourceData.KEY_TYPE);
        if (((Context) provideContext(Context.class)) != null) goto L6;
        tt5.a.d("ccm-lynx: CCMClipBoardMethod", "handle()...context is null");
        return;
    L6:
        String r12 = s.f(r9, WikiFolderPushPlugin.DATA, "");
        if (TextUtils.isEmpty(r12) == false) goto L10;
        tt5.a.d("ccm-lynx: CCMClipBoardMethod", "data is empty");
        return;
    L10:
        XCoreBridgeMethod.onSuccess$default(this, r10, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("isSuccess", Boolean.valueOf(((fu5.a) org.koin.java.a.c(fu5.a.class, null, null, 6)).n(r12, false, new Token("LARK-PSDA-ccm_android_lynx_set_primary_clip"))))}), null, 4, null);
    }
}
