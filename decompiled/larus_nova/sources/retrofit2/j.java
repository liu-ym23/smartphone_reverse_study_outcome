package retrofit2;

import okhttp3.ResponseBody;

/* JADX INFO: loaded from: classes41.dex */
public final class j<ResponseT, ReturnT> extends t<ReturnT> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s f537499a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final okhttp3.Call.a f537500b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CallAdapter<ResponseT, ReturnT> f537501c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g<ResponseBody, ResponseT> f537502d;

    @Override // retrofit2.t
    public final ReturnT a(Object[] r100) {
        return this.f537501c.adapt(new l(this.f537499a, r100, this.f537500b, this.f537502d));
    }

    public j(s r100, okhttp3.Call.a r101, CallAdapter<ResponseT, ReturnT> r102, g<ResponseBody, ResponseT> r103) {
        this.f537499a = r100;
        this.f537500b = r101;
        this.f537501c = r102;
        this.f537502d = r103;
    }
}
