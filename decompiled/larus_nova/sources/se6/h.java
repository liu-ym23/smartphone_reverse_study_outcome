package se6;

import com.bytedance.lark.pb.tool.v1.OnFetchResponse;
import com.bytedance.lark.sdk.LarkResponse;
import com.ss.android.lark.log.Log;
import java.util.concurrent.CountDownLatch;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes20.dex */
public final class h implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<LarkResponse> f541575a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CountDownLatch f541576b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int[] f541577c;

    @Override // se6.j
    public final void b(OnFetchResponse.OnProgressResponse r100) {
        Intrinsics.checkNotNullParameter(r100, "response");
    }

    @Override // se6.j
    public final void a(OnFetchResponse.OnErrorResponse r100) {
        Intrinsics.checkNotNullParameter(r100, "response");
        Log.d("LarkNet", "netRequest, onErrorResponse called");
    }

    @Override // se6.j
    public final void c(OnFetchResponse.OnSuccessResponse r100) {
        Intrinsics.checkNotNullParameter(r100, "response");
        Log.d("LarkNet", "netRequest, onSuccessResponse called");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // se6.j
    public final void d(LarkResponse r100) {
        Intrinsics.checkNotNullParameter(r100, "response");
        this.f541575a.element = r100;
        this.f541576b.countDown();
        Log.i("LarkNet", "netRequest, onFetchResponse called");
    }

    @Override // se6.j
    public final void e(OnFetchResponse.OnHeaderResponse r100) {
        Intrinsics.checkNotNullParameter(r100, "response");
        Log.d("LarkNet", "netRequest, onHeaderResponse called");
    }

    @Override // se6.j
    public final void f(OnFetchResponse.OnBodyResponse r100) {
        Intrinsics.checkNotNullParameter(r100, "response");
        int[] r101 = this.f541577c;
        r101[0] = r101[0] + 1;
    }

    @Override // se6.j
    public final void g(OnFetchResponse.OnCancelResponse r100) {
        Intrinsics.checkNotNullParameter(r100, "response");
        Log.d("LarkNet", "netRequest, onCancelResponse called");
    }

    public h(Ref.ObjectRef<LarkResponse> r100, CountDownLatch r101, int[] r102) {
        this.f541575a = r100;
        this.f541576b = r101;
        this.f541577c = r102;
    }
}
