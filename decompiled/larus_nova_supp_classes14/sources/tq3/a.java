package tq3;

import com.bytedance.android.window.shop.repository.dto.q;
import com.bytedance.android.window.shop.repository.tab.entity.f;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a extends f {
    public static final fo.a<a> k = null;
    public final List<q.c> j;

    /* JADX INFO: renamed from: tq3.a$a, reason: collision with other inner class name */
    public static final class C0174a {
    }

    static {
        k = new fo.a("shopWindowCouponVO_for_update", new a[0]);
    }

    public a(List<q.c> r2) {
        Intrinsics.checkNotNullParameter(r2, "couponList");
        super(102);
        this.j = r2;
    }
}
