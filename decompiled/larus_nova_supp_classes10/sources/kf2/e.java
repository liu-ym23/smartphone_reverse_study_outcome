package kf2;

import android.util.Pair;
import com.bytedance.android.live.network.response.BaseListResponse;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class e<T, R> implements Function {
    public static final e a = null;

    static {
        a = new e();
    }

    public e() {
    }

    public final Object apply(Object r3) {
        BaseListResponse r4 = (BaseListResponse) r3;
        Intrinsics.checkNotNullParameter(r4, "response");
        ArrayList r0 = new ArrayList();
        List r1 = r4.data;
        if (r1 == null) goto L6;
        r0.addAll(r1);
    L6:
        return Pair.create(r0, r4.extra);
    }
}
