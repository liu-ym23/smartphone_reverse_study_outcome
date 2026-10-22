package tb5;

import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.larkwebview.bridge.Status;
import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes16.dex */
public final class l implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ at5.j f545261a;

    public l(at5.d r100) {
        this.f545261a = r100;
    }

    @Override // tb5.m
    public final void a(NonProguard r100) {
        this.f545261a.a(Status.SUCCESS, r100);
    }

    @Override // tb5.m
    public final void b(JSONObject r100) {
        this.f545261a.a(Status.SUCCESS, r100);
    }

    @Override // tb5.m
    public final void onCallBack(String r100) {
        this.f545261a.a(Status.SUCCESS, r100);
    }
}
