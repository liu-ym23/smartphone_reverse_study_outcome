package yc2;

import android.os.Bundle;
import com.bytedance.android.livesdkapi.service.IHostCommerceServiceLive;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import java.util.Iterator;
import jc1.k;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
@XBridgeMethod(biz = "webcast", name = "ecDirectSplash")
public final class b extends com.bytedance.ies.web.jsbridge2.g<JSONObject, Object> {
    public b() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.g
    public final Object invoke(JSONObject r100, CallContext r101) throws Exception {
        JSONObject r102 = r100;
        com.bytedance.android.livesdk.sharedpref.e<Boolean> r103 = com.bytedance.android.livesdk.sharedpref.b.f158167k;
        Boolean r104 = Boolean.TRUE;
        r103.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r103, r104);
        Bundle r105 = new Bundle();
        Iterator<String> r106 = r102.keys();
    L4:
        if (r106.hasNext() == false) goto L6;
        String r107 = r106.next();
        r105.putString(r107, r102.optString(r107));
        goto L4
    L6:
        r105.putLong("click_time", System.currentTimeMillis());
        IHostCommerceServiceLive r108 = (IHostCommerceServiceLive) k.f(IHostCommerceServiceLive.class);
        if (r108 == null) goto L9;
        r108.tryShowLiveFlashFragment(r101.getContext(), r105, null);
    L9:
        return null;
    }
}
