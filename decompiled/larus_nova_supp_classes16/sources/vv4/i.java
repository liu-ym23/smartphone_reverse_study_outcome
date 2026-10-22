package vv4;

import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.larkwebview.bridge.Status;
import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class i implements tb5.m {
    public final /* synthetic */ at5.j a;

    public i(at5.d r1) {
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
