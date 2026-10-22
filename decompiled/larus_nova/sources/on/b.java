package on;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class b extends a {
    @Override // on.a
    public final void d() {
        dm.a.a("测试播放范围").a("before:top:" + this.f524328b.top + ";right:" + this.f524328b.right + ";bottom:" + this.f524328b.bottom + ";left:" + this.f524328b.left);
        dm.a.a("测试播放范围").a("after:top:" + this.f524328b.top + ";right:" + this.f524328b.right + ";bottom:" + this.f524328b.bottom + ";left:" + this.f524328b.left);
    }

    public b(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        super(r100);
    }
}
