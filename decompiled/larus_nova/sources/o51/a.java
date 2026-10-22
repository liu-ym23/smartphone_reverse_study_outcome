package o51;

import android.graphics.Matrix;
import android.graphics.RectF;
import com.bytedance.android.live.revlink.link.core.service.q;
import com.huawei.hms.push.constant.RemoteMessageConst;
import f31.k;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes47.dex */
public final class a {
    public static final RectF b(List<q> r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$rectF");
        Iterator<T> r101 = r100.iterator();
        int r102 = Integer.MAX_VALUE;
        int r103 = Integer.MAX_VALUE;
        int r104 = Integer.MIN_VALUE;
        int r105 = Integer.MIN_VALUE;
    L4:
        if (r101.hasNext() == false) goto L7;
        q r106 = (q) r101.next();
        r102 = RangesKt.coerceAtMost(r102, r106.f98372b);
        r103 = RangesKt.coerceAtMost(r103, r106.f98373c);
        r104 = RangesKt.coerceAtLeast(r104, r106.f98372b + r106.f98374d);
        r105 = RangesKt.coerceAtLeast(r105, r106.f98373c + r106.f98375e);
        goto L4
    L7:
        return new RectF(r102, r103, r104, r105);
    }

    public static final RectF c(t51.b r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$rectF");
        return new RectF(r100.e(), r100.f(), r100.e() + r100.d(), r100.f() + r100.a());
    }

    public static final RectF d(List<? extends RectF> r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$total");
        Iterator<T> r101 = r100.iterator();
        float r102 = Float.MAX_VALUE;
        float r103 = Float.MAX_VALUE;
        float r104 = Float.MIN_VALUE;
        float r105 = Float.MIN_VALUE;
    L4:
        if (r101.hasNext() == false) goto L7;
        RectF r106 = (RectF) r101.next();
        r102 = RangesKt.coerceAtMost(r102, r106.left);
        r103 = RangesKt.coerceAtMost(r103, r106.top);
        r104 = RangesKt.coerceAtLeast(r104, r106.right);
        r105 = RangesKt.coerceAtLeast(r105, r106.bottom);
        goto L4
    L7:
        return new RectF(r102, r103, r104, r105);
    }

    public static final RectF e(List<k> r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$visibleRectF");
        Iterator<T> r101 = r100.iterator();
        int r102 = Integer.MAX_VALUE;
        int r103 = Integer.MAX_VALUE;
        int r104 = Integer.MIN_VALUE;
        int r105 = Integer.MIN_VALUE;
    L4:
        if (r101.hasNext() == false) goto L7;
        k r106 = (k) r101.next();
        r102 = RangesKt.coerceAtMost(r102, r106.f475350c);
        r103 = RangesKt.coerceAtMost(r103, r106.f475351d);
        r104 = RangesKt.coerceAtLeast(r104, r106.f475350c + r106.f475352e);
        r105 = RangesKt.coerceAtLeast(r105, r106.f475351d + r106.f475353f);
        goto L4
    L7:
        return new RectF(r102, r103, r104, r105);
    }

    public static final Matrix a(RectF r100, RectF r101) {
        Intrinsics.checkNotNullParameter(r100, "from");
        Intrinsics.checkNotNullParameter(r101, RemoteMessageConst.TO);
        Matrix r102 = new Matrix();
        r102.postTranslate(r101.left - r100.left, r101.top - r100.top);
        r102.postScale(r101.width() / r100.width(), r101.height() / r100.height(), r101.left, r101.top);
        return r102;
    }
}
