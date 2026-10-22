package qk5;

import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.bitable.jsapi.common.PhoneHelper;
import kotlin.jvm.internal.Intrinsics;
import na8.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements PhoneHelper.a {
    public final /* synthetic */ gk5.a a;

    public b(p r1) {
        this.a = r1;
    }

    public final void a(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "error");
        this.a.onCancel();
    }

    public final void b(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "error");
        nk5.b.b(this.a, r2);
    }

    public final void onSuccess(String r4) {
        Intrinsics.checkNotNullParameter(r4, "phoneNumber");
        this.a.onSuccess(new org.json.JSONObject().put("phoneNumber", r4));
    }
}
