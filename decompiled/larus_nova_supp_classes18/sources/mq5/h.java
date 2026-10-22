package mq5;

import com.bytedance.ee.bear.wikiv2.sidebar.home.ResultCode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.WikiRelation;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h<T, R> implements Function {
    public static final h<T, R> a = null;

    static {
        a = new h();
    }

    public h() {
    }

    public final Object apply(Object r3) {
        Throwable r4 = (Throwable) r3;
        Intrinsics.checkNotNullParameter(r4, "throwable");
        tt5.a.d("PersonalTreeDataManager", "requestPersonal, err: " + r4);
        return Flowable.just(kq5.d.a(new c(ResultCode.DEC2), new WikiRelation()));
    }
}
