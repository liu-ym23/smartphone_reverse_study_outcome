package zu4;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.bitable.statistic.BitableTraceType;
import com.bytedance.ee.bear.bitable.statistic.h;
import java.io.Serializable;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements com.bytedance.ee.bear.bitable.statistic.c {
    public a() {
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.c
    public final void a(long r1) {
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.n
    public final void b(Boolean r1) {
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.c
    public final void d(h r2) {
        Intrinsics.checkNotNullParameter(r2, "consumer");
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.c
    public final void f(RecyclerView r2) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.c
    public final void g() {
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.n
    public final String getTraceId() {
        return "";
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.c, com.bytedance.ee.bear.bitable.statistic.n
    public /* bridge */ /* synthetic */ BitableTraceType getType() {
        return com.bytedance.ee.bear.bitable.statistic.b.a(this);
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.n
    public final String h() {
        return null;
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.c
    public final void start() {
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.c
    public final void stop() {
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.n
    public final Map<String, Serializable> c(boolean r1) {
        return MapsKt.emptyMap();
    }
}
