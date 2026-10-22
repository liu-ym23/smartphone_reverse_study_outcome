package iu4;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;

/* JADX INFO: loaded from: classes15.dex */
public final class e<T extends Result> implements NetService.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e<T> f495798a = null;

    static {
        f495798a = new e();
    }

    public e() {
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final Result<String> parse(String r100) {
        Result<String> r101 = new Result();
        r101.data = r100;
        return r101;
    }
}
