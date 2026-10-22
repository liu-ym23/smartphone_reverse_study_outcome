package mz0;

import com.bytedance.android.live.revenue.platform.log.api.LogDSLMaker;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@LogDSLMaker
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, String> f516449a;

    public o(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "map");
        this.f516449a = r100;
    }

    public final void b(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "map");
        this.f516449a.putAll(r100);
    }

    public final void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        this.f516449a.put(r100, r101);
    }
}
