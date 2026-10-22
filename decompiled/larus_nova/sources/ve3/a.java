package ve3;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a implements com.bytedance.android.shopping.ligo.monitor.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f554341a;

    public a() {
        this.f554341a = "good_list";
    }

    @Override // com.bytedance.android.shopping.ligo.monitor.a
    public final String a() {
        return this.f554341a;
    }

    @Override // com.bytedance.android.shopping.ligo.monitor.a
    public final void b(String r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        com.bytedance.android.shopping.ligo.monitor.a.C2612a.a(r100, r101);
    }
}
