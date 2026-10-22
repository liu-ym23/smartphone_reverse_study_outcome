package hx0;

import com.bytedance.android.livesdk.revenue.log.d;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public abstract class a<T> implements d<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, String> f487466a;

    public abstract void c(Map r100, gx0.a r101);

    public a() {
        this.f487466a = new LinkedHashMap();
    }

    @Override // com.bytedance.android.livesdk.revenue.log.d
    public final void a(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "map");
        r100.putAll(this.f487466a);
    }

    @Override // com.bytedance.android.livesdk.revenue.log.d
    public final void b(gx0.a r100) {
        c(this.f487466a, r100);
    }
}
