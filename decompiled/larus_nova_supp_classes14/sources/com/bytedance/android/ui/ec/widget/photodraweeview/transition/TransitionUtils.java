package com.bytedance.android.ui.ec.widget.photodraweeview.transition;

import android.graphics.Rect;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0015\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0007¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/ui/ec/widget/photodraweeview/transition/TransitionUtils;", "", "()V", "calculateStartRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "photoWidth", "", "photoHeight", "fix", "", "photoWidthHeight", "", "ui-ec-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TransitionUtils {
    public static final TransitionUtils INSTANCE = null;

    private TransitionUtils() {
    }

    static {
        INSTANCE = new TransitionUtils();
    }

    @JvmStatic
    public static final Rect calculateStartRect(View r7, int[] r8) {
        Intrinsics.checkNotNullParameter(r7, "view");
        Intrinsics.checkNotNullParameter(r8, "photoWidthHeight");
        return calculateStartRect$default(r7, r8[0], r8[1], false, 8, null);
    }

    @JvmStatic
    public static final Rect calculateStartRect(View r8, int r9, int r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r8, "view");
        int[] r1 = new int[2];
        int r2 = r8.getWidth();
        int r3 = r8.getHeight();
        r8.getLocationOnScreen(r1);
        int[] r4 = {r1[0] + (r2 / 2), r1[1] + (r3 / 2)};
        Rect r6 = new Rect();
        if (r11 == false) goto L6;
        if (r10 <= r9) goto L6;
        boolean r12 = true;
    L7:
        if (r12 == false) goto L9;
        int r13 = r4[0];
        int r14 = ((int) (r3 * (r9 / r10))) / 2;
        int r15 = r1[1];
        r6.set(r13 - r14, r15, r13 + r14, r3 + r15);
    L10:
        return r6;
    L9:
        int r16 = (int) (r2 * (r10 / r9));
        int r17 = r1[0];
        int r18 = r4[1];
        int r19 = r16 / 2;
        r6.set(r17, r18 - r19, r2 + r17, r18 + r19);
    L6:
        r12 = false;
        goto L7
    }

    public static /* synthetic */ Rect calculateStartRect$default(View r0, int r1, int r2, boolean r3, int r4, Object r5) {
        if ((r4 & 8) == 0) goto L6;
        r3 = false;
    L6:
        return calculateStartRect(r0, r1, r2, r3);
    }
}
