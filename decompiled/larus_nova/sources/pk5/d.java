package pk5;

import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.bitable.jsapi.common.LocationHelper;
import kotlin.jvm.internal.Intrinsics;
import na8.p;

/* JADX INFO: loaded from: classes18.dex */
public final class d implements LocationHelper.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ gk5.a f529664a;

    public d(p r100) {
        this.f529664a = r100;
    }

    @Override // com.bytedance.ee.bear.bitable.jsapi.common.LocationHelper.b
    public final void a(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "response");
        nk5.b.e(this.f529664a, r100);
    }

    @Override // com.bytedance.ee.bear.bitable.jsapi.common.LocationHelper.b
    public final void b(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "response");
        nk5.b.b(this.f529664a, r100);
    }
}
