package pn6;

import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Request;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f529978a;

    @Override // pn6.b
    public final void b(nn6.a r100, Request r101, SsResponse<Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "poiDurationMonitor");
        Intrinsics.checkNotNullParameter(r101, "request");
        Intrinsics.checkNotNullParameter(r102, "ssResponse");
    }

    public a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "mUriPath");
        this.f529978a = true;
    }

    @Override // pn6.b
    public final boolean a(Request r100, SsResponse<Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r101, "ssResponse");
        return this.f529978a;
    }
}
