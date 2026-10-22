package xb3;

import com.bytedance.jedi.model.repository.Repository;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c extends Repository {
    public static final b b = null;
    public static final a c = null;
    public static int d;
    public static final c e = null;

    static {
        e = new c();
        b = new b();
        c = new a();
    }

    public c() {
    }

    public static Observable a(zb3.b r1) {
        Intrinsics.checkNotNullParameter(r1, "requestParam");
        return c.a(r1).subscribeOn(Schedulers.io());
    }
}
