package zu4;

import com.bytedance.ee.bear.bitable.statistic.BitableTraceType;
import com.bytedance.ee.bear.bitable.statistic.f;
import com.bytedance.ee.bear.bitable.statistic.g;
import com.bytedance.ee.bear.bitable.statistic.k;
import java.io.Serializable;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class b implements g {
    public b() {
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.g
    public final void a(long r100) {
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.g
    public final void e() {
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.n
    public final String getTraceId() {
        return "";
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.g, com.bytedance.ee.bear.bitable.statistic.n
    public /* bridge */ /* synthetic */ BitableTraceType getType() {
        return f.a(this);
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.n
    public final String h() {
        return null;
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.g
    public final void i(k r100) {
        Intrinsics.checkNotNullParameter(r100, "consumer");
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.n
    public final Map<String, Serializable> c(boolean r100) {
        return MapsKt.emptyMap();
    }
}
