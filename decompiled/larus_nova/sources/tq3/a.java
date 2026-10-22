package tq3;

import com.bytedance.android.window.shop.repository.dto.q;
import com.bytedance.android.window.shop.repository.tab.entity.f;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class a extends f {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final fo.a<a> f547127k = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<q.c> f547128j;

    /* JADX INFO: renamed from: tq3.a$a, reason: collision with other inner class name */
    public static final class C7760a {
    }

    static {
        f547127k = new fo.a("shopWindowCouponVO_for_update", new a[0]);
    }

    public a(List<q.c> r100) {
        Intrinsics.checkNotNullParameter(r100, "couponList");
        super(102);
        this.f547128j = r100;
    }
}
