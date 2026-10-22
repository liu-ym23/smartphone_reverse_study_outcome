package eib;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import cib.f;
import com.ss.android.lark.forseti.widget.bean.ArrowDirection;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f472822a = 0;

    static {
    }

    @JvmStatic
    public static final dib.a a(Context r110, vua.a r111, int r112, int r113, int r114, int r115) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r111 == null) goto L5;
        View r100 = r111.f557367a;
    L6:
        if (r100 == null) goto L10;
        Rect r101 = new Rect();
        View r102 = r111.f557367a;
        if (r102 == null) goto L14;
        r102.getGlobalVisibleRect(r101);
    L14:
        int r103 = f.a(r110, 12.0f);
        int r104 = f.a(r110, 24.0f);
        int r105 = f.a(r110, 18.0f);
        int r106 = r101.top;
        int r107 = r115 - r101.bottom;
        int r108 = r101.left;
        int r109 = r114 - r101.right;
        int r116 = r101.centerX();
        int r117 = r101.centerY();
        int r118 = r113 + r105;
        if (r106 < r118) goto L18;
        int r119 = RangesKt.coerceIn(r116 - (r112 / 2), 0, RangesKt.coerceAtLeast((r114 - r112) - r103, 0));
        return new dib.a(r119, (r101.top - r113) - r105, ArrowDirection.BOTTOM, r116 - r119, r117);
    L18:
        if (r107 < r118) goto L21;
        int r120 = RangesKt.coerceIn(r116 - (r112 / 2), 0, RangesKt.coerceAtLeast((r114 - r112) - r103, 0));
        return new dib.a(r120, r101.bottom + r105, ArrowDirection.TOP, r116 - r120, r117);
    L21:
        int r121 = r112 + r105;
        if (r108 < r121) goto L25;
        int r122 = RangesKt.coerceIn(r117 - (r113 / 2), 0, RangesKt.coerceAtLeast((r115 - r113) - r104, 0));
        return new dib.a((r101.left - r112) - r105, r122, ArrowDirection.RIGHT, r116, r117 - r122);
    L25:
        if (r109 < r121) goto L28;
        int r123 = RangesKt.coerceIn(r117 - (r113 / 2), 0, RangesKt.coerceAtLeast((r115 - r113) - r104, 0));
        return new dib.a(r101.right + r105, r123, ArrowDirection.LEFT, r116, r117 - r123);
    L28:
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r124 = (r114 - r112) / 2;
        int r125 = (r115 - r113) / 2;
        return new dib.a(r124, r125, ArrowDirection.NONE, (r112 / 2) + r124, (r113 / 2) + r125);
    L10:
        if (r111 == null) goto L13;
        r101 = r111.f557368b;
        if (r101 != null) goto L14;
    L13:
        r101 = new Rect();
        goto L14
    L5:
        r100 = null;
        goto L6
    }
}
