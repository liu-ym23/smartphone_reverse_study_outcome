package p12;

import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.gift.model.y3;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class d<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f527320a = null;

    static {
        f527320a = new d();
    }

    public d() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        ExtraResponse r101 = (ExtraResponse) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        return (y3) r101.data;
    }
}
