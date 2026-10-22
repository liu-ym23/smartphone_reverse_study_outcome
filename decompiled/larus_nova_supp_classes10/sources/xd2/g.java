package xd2;

import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ Function1 a;

    public g(Function1 r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Function1 r0 = this.a;
        r0.invoke((com.bytedance.android.live.network.response.e) r2);
    }
}
