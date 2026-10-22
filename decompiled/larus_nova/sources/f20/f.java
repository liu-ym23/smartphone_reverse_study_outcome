package f20;

import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewholder.AbsOpenFeatureTabListItemViewHolder;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<? extends a<?, ?>> f475110a;

    public f(List<? extends a<?, ?>> r100) {
        Intrinsics.checkNotNullParameter(r100, "delegates");
        this.f475110a = r100;
    }

    public final a<Object, AbsOpenFeatureTabListItemViewHolder<Object>> a(Object r100) {
        Iterator<? extends a<?, ?>> r101 = this.f475110a.iterator();     // Catch: Exception -> L8
    L4:
        if (r101.hasNext() == false) goto L11;
        a<?, ?> r102 = r101.next();     // Catch: Exception -> L8
        if (r102.accept(r100) == false) goto L4;
        return r102;
    L11:
        return new b();
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }
}
