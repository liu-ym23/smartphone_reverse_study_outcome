package gr3;

import com.bytedance.android.window.shop.holder.ShopWindowItemHolder;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e {
    public final LinkedHashSet<d> a;

    public e() {
        this.a = new LinkedHashSet();
    }

    public final void a(ShopWindowItemHolder<? extends com.bytedance.android.window.shop.repository.tab.entity.f> r3, com.bytedance.android.window.shop.repository.tab.entity.f r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "holder");
        Intrinsics.checkNotNullParameter(r4, "vo");
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((d) r0.next()).a(r3, r4, r5);
        goto L4
    }
}
