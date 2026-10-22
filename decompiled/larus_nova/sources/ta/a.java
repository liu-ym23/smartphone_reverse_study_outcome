package ta;

import com.alipay.sdk.m.p.e;
import com.bytedance.android.anniex.optimize.JSBPreHandleManager;
import com.bytedance.sdk.xbridge.cn.protocol.f;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import me7.d;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class a implements f<JSONObject, JSONObject> {
    public a() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.f
    public final void a(d r100) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Lazy r101 = JSBPreHandleManager.f41023a;
        le7.a<?> r102 = r100.f513517b;
        String r103 = r102.f508943a;
        String r104 = r102.d();
        Intrinsics.checkNotNullParameter(r103, e.f25671s);
        Intrinsics.checkNotNullParameter(r104, "url");
    }
}
