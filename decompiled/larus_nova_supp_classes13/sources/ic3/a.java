package ic3;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a extends com.bytedance.android.ec.core.event.a {
    public final Map<String, String> a;

    public final void buildParams() {
        appendParam(this.a);
    }

    public a(String r2, Map<String, String> r3) {
        Intrinsics.checkNotNullParameter(r2, "event");
        Intrinsics.checkNotNullParameter(r3, "trackParams");
        super(r2);
        this.a = r3;
    }
}
