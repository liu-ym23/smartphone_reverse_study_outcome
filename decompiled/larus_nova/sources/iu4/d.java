package iu4;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;

/* JADX INFO: loaded from: classes15.dex */
public final class d<T extends Result> implements NetService.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d<T> f495797a = null;

    static {
        f495797a = new d();
    }

    public d() {
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final Result<String> parse(String r100) {
        Result<String> r101 = new Result();
        r101.data = r100;
        return r101;
    }
}
