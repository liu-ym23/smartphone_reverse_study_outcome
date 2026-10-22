package sq3;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class e extends com.bytedance.android.window.shop.repository.tab.entity.f {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<Integer> f542974j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public List<? extends b> f542975k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f542976l;

    public e(List<? extends b> r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "pendingVoList");
        super(2505);
        this.f542975k = r100;
        this.f542976l = r101;
        this.f542974j = CollectionsKt.mutableListOf(new Integer[]{7, 10, 10, Integer.MAX_VALUE});
    }
}
