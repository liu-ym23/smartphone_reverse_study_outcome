package xn5;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c<T extends Result> implements NetService.c {
    public static final c<T> a = null;

    static {
        a = new c();
    }

    public c() {
    }

    public final Result parse(String r2) {
        return new e().a(r2);
    }
}
