package com.ss.android.lark.movable.attatchment;

import android.content.Context;
import android.content.res.Resources;
import com.larksuite.framework.utils.UIUtils;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.ImageUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes36.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f432643a = 0;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f432644a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f432645b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f432646c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f432644a == r101.f432644a) goto L12;
            return false;
        L12:
            if (this.f432645b == r101.f432645b) goto L15;
            return false;
        L15:
            if (this.f432646c == r101.f432646c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f432644a * 31) + this.f432645b) * 31;
            if (this.f432646c == false) goto L5;
            int r101 = 1231;
        L7:
            return r100 + r101;
        L5:
            r101 = 1237;
            goto L7
        }

        public final String toString() {
            return "Size(width=" + this.f432644a + ", height=" + this.f432645b + ", clamped=" + this.f432646c + ')';
        }

        public a(int r100, int r101, boolean r102) {
            this.f432644a = r100;
            this.f432645b = r101;
            this.f432646c = r102;
        }
    }

    static {
    }

    public static a a(Context r110, int r111, int r112, String r113) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r113, "source");
        if (r111 <= 1) goto L32;
        if (r112 <= 1) goto L32;
        Resources r100 = r110.getResources();
        int r101 = Math.min(WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics()).widthPixels, UIUtils.dp2px(r110, 680.0f));
        int r102 = UIUtils.dp2px(r110, 240.0f);
        if (r111 != 0) goto L9;
    L15:
        boolean r103 = false;
    L17:
        if (r103 == false) goto L19;
        int[] r104 = {UIUtils.dp2px(r110, 150.0f), r102};
    L24:
        int r114 = RangesKt.coerceAtLeast(r104[0], 1);
        int r105 = RangesKt.coerceAtLeast(r104[1], 1);
        if (r114 != r111) goto L29;
        if (r105 != r112) goto L29;
        return new a(r111, r112, false);
    L29:
        Log.w("MovableAttachmentImageSizeGuard", "movable attachment image size clamped, source=" + r113 + ", width=" + r111 + ", height=" + r112 + ", clampedWidth=" + r114 + ", clampedHeight=" + r105 + ", maxWidth=" + r101 + ", maxHeight=" + r102);
        return new a(r114, r105, true);
    L19:
        if (r111 > r101) goto L23;
        if (r112 > r102) goto L23;
        r104 = new int[]{r111, r112};
    L23:
        r104 = ImageUtils.g(r111, r112, r101, r102, 1, 1);
        goto L24
    L9:
        if ((r112 / r111) < 3) goto L15;
        if (r111 <= UIUtils.dp2px(r110, 200.0f)) goto L15;
        if (r101 <= UIUtils.dp2px(r110, 150.0f)) goto L15;
        r103 = true;
    L32:
        return new a(RangesKt.coerceAtLeast(r111, 1), RangesKt.coerceAtLeast(r112, 1), true);
    }
}
