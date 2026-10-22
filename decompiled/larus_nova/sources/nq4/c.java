package nq4;

import com.bytedance.ee.bear.bitable.card.viewmodel.fetch.async.AsyncFetchResult;
import io.reactivex.FlowableEmitter;
import kotlin.jvm.internal.Intrinsics;
import nq4.d;

/* JADX INFO: loaded from: classes15.dex */
public final class c<T extends d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b<T> f520124a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FlowableEmitter<AsyncFetchResult<T>> f520125b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bytedance.ee.bear.bitable.card.viewmodel.fetch.async.emit.a f520126c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Runnable f520127d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Runnable f520128e;

    public final String toString() {
        return "AsyncFetchTask(request=" + this.f520124a + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(b<? extends T> r100, FlowableEmitter<AsyncFetchResult<T>> r101) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r101, "emitter");
        this.f520124a = r100;
        this.f520125b = r101;
    }
}
