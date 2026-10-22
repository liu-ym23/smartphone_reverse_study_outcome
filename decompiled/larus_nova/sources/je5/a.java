package je5;

import android.content.Context;
import android.text.TextUtils;
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

/* JADX INFO: loaded from: classes18.dex */
public final class a extends XCoreBridgeMethod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f498823a;

    /* JADX INFO: renamed from: je5.a$a, reason: collision with other inner class name */
    public static final class C6424a {
    }

    static {
    }

    public a() {
        this.f498823a = "ccm.setPrimaryClip";
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final String getName() {
        return this.f498823a;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final void handle(XReadableMap r100, XBridgeMethod.Callback r110, XBridgePlatformType r111) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r110, "callback");
        Intrinsics.checkNotNullParameter(r111, "type");
        if (((Context) provideContext(Context.class)) != null) goto L6;
        tt5.a.d("ccm-lynx: CCMClipBoardMethod", "handle()...context is null");
        return;
    L6:
        String r101 = s.f(r100, "data", "");
        if (TextUtils.isEmpty(r101) == false) goto L10;
        tt5.a.d("ccm-lynx: CCMClipBoardMethod", "data is empty");
        return;
    L10:
        XCoreBridgeMethod.onSuccess$default(this, r110, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("isSuccess", Boolean.valueOf(((fu5.a) org.koin.java.a.c(fu5.a.class, null, null, 6)).n(r101, false, new Token("LARK-PSDA-ccm_android_lynx_set_primary_clip"))))}), null, 4, null);
    }
}
