package vv4;

import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.larkwebview.bridge.Status;
import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes16.dex */
public final class i implements tb5.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ at5.j f557391a;

    public i(at5.d r100) {
        this.f557391a = r100;
    }

    @Override // tb5.m
    public final void a(NonProguard r100) {
        this.f557391a.a(Status.SUCCESS, r100);
    }

    @Override // tb5.m
    public final void b(JSONObject r100) {
        this.f557391a.a(Status.SUCCESS, r100);
    }

    @Override // tb5.m
    public final void onCallBack(String r100) {
        this.f557391a.a(Status.SUCCESS, r100);
    }
}
