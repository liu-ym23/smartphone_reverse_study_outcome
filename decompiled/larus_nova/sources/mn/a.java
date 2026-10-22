package mn;

import android.graphics.Rect;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a extends d {
    public a() {
    }

    @Override // mn.d
    public final void d(List<ln.c> r100, com.bytedance.android.ec.store.utils.playable.controller.a r101, Rect r102) {
        Intrinsics.checkNotNullParameter(r100, "itemsToPlay");
        Intrinsics.checkNotNullParameter(r101, "mgr");
        Intrinsics.checkNotNullParameter(r102, "area");
        dm.a.a("测试播放范围").a("AllSamePlayingStrategy:itemsToPlay个数:" + r100.size() + ",选择一个开始播放");
        r101.e(r100, CollectionsKt.emptyList());
    }
}
