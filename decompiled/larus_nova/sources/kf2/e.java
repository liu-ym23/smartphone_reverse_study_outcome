package kf2;

import android.util.Pair;
import com.bytedance.android.live.network.response.BaseListResponse;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class e<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f503149a = null;

    static {
        f503149a = new e();
    }

    public e() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        BaseListResponse r101 = (BaseListResponse) r100;
        Intrinsics.checkNotNullParameter(r101, "response");
        ArrayList r102 = new ArrayList();
        List<T> r103 = r101.data;
        if (r103 == null) goto L6;
        r102.addAll(r103);
    L6:
        return Pair.create(r102, r101.extra);
    }
}
