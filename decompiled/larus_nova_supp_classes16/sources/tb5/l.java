package tb5;

import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.larkwebview.bridge.Status;
import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class l implements m {
    public final /* synthetic */ at5.j a;

    public l(at5.d r1) {
        this.a = r1;
    }

    @Override // tb5.m
    public final void a(NonProguard r3) {
        this.a.a(Status.SUCCESS, r3);
    }

    @Override // tb5.m
    public final void b(JSONObject r3) {
        this.a.a(Status.SUCCESS, r3);
    }

    @Override // tb5.m
    public final void onCallBack(String r3) {
        this.a.a(Status.SUCCESS, r3);
    }
}
