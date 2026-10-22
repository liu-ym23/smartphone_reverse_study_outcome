package gr3;

import com.bytedance.android.window.shop.holder.ShopWindowItemHolder;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashSet<d> f482354a;

    public e() {
        this.f482354a = new LinkedHashSet();
    }

    public final void a(ShopWindowItemHolder<? extends com.bytedance.android.window.shop.repository.tab.entity.f> r100, com.bytedance.android.window.shop.repository.tab.entity.f r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        Intrinsics.checkNotNullParameter(r101, "vo");
        Iterator<T> r103 = this.f482354a.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((d) r103.next()).a(r100, r101, r102);
        goto L4
    }
}
