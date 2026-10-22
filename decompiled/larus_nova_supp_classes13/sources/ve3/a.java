package ve3;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements com.bytedance.android.shopping.ligo.monitor.a {
    public final String a;

    public a() {
        this.a = "good_list";
    }

    @Override // com.bytedance.android.shopping.ligo.monitor.a
    public final String a() {
        return this.a;
    }

    @Override // com.bytedance.android.shopping.ligo.monitor.a
    public final void b(String r2, Map<String, String> r3) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        com.bytedance.android.shopping.ligo.monitor.a.C0073a.a(r2, r3);
    }
}
