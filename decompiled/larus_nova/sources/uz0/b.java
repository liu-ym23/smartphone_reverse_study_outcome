package uz0;

import com.bytedance.android.live.revenue.platform.network.api.dsl.RequestDSL;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@RequestDSL
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, String> f552164a;

    public b(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "fieldsMap");
        this.f552164a = r100;
    }

    @RequestDSL
    public final void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$setTo");
        if (r101 == null) goto L6;
        this.f552164a.put(r100, r101);
        return;
    }
}
