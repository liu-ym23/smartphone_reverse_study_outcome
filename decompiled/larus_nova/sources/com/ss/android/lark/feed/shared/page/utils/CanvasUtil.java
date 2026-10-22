package com.ss.android.lark.feed.shared.page.utils;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import com.larksuite.component.ui.avatar.v2.LarkAvatarView;
import com.ss.android.lark.feed.app.view.AdvanceAvatarView;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes35.dex */
public final class CanvasUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f421456a = 0;

    static {
    }

    public static boolean c(View r100) {
        if ((r100 instanceof ViewGroup) == true) goto L5;
        return false;
    L5:
        ViewGroup r101 = (ViewGroup) r100;
        int r102 = r101.getChildCount();
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L23;
        View r104 = r101.getChildAt(r103);
        Intrinsics.checkNotNull(r104);
        if (r104.getVisibility() != 0) goto L10;
        boolean r105 = true;
    L11:
        if (r105 == false) goto L22;
        if (r104.getWidth() <= 0) goto L22;
        if (r104.getHeight() <= 0) goto L22;
        if ((r104 instanceof LarkAvatarView) == true) goto L21;
        if (c(r104) == false) goto L22;
    L21:
        return true;
    L22:
        r103 = r103 + 1;
        goto L6
    L10:
        r105 = false;
        goto L11
    L23:
        return false;
    }

    public static void a(Canvas r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "avatarContainer");
        Iterator<Integer> r102 = RangesKt.until(0, r101.getChildCount()).iterator();
    L4:
        if (r102.hasNext() == false) goto L19;
        View r103 = r101.getChildAt(((IntIterator) r102).nextInt());
        Intrinsics.checkNotNull(r103);
        if (r103.getVisibility() != 0) goto L8;
        boolean r104 = true;
    L9:
        if (r104 == false) goto L4;
        float r105 = r103.getX();
        float r106 = r103.getY();
        int r107 = r100.save();
        r100.translate(r105, r106);
        if ((r103 instanceof AdvanceAvatarView) == false) goto L14;
        b(r100, r103);     // Catch: Throwable -> L16
    L15:
        r100.restoreToCount(r107);
        goto L4
    L14:
        r103.draw(r100);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        r100.restoreToCount(r107);
        throw th;
    L8:
        r104 = false;
        goto L9
    }

    public static void b(Canvas r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "view");
        Path r102 = new Path();
        r102.addOval(new RectF(0.0f, 0.0f, r101.getWidth(), r101.getHeight()), Path.Direction.CW);
        int r103 = r100.save();
        r100.clipPath(r102);
        r101.draw(r100);     // Catch: Throwable -> L6
        r100.restoreToCount(r103);
        return;
    L6:
        th = move-exception;
        r100.restoreToCount(r103);
        throw th;
    }

    public static void d(View r100, Canvas r101) {
        if ((r100 instanceof LarkAvatarView) == false) goto L6;
        b(r101, r100);
        return;
    L6:
        if ((r100 instanceof ViewGroup) == true) goto L8;
    L10:
        r100.draw(r101);
        return;
    L8:
        if (c(r100) == false) goto L10;
        e(r101, r100);
    }

    public static void e(Canvas r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "itemView");
        if ((r101 instanceof ViewGroup) == false) goto L5;
        final ViewGroup r102 = (ViewGroup) r101;
    L6:
        if (r102 == null) goto L22;
        Iterator r103 = CollectionsKt.sortedWith(RangesKt.until(0, r102.getChildCount()), ComparisonsKt.compareBy(new Function1[]{new CanvasUtil$redrawItemView$1$orderedChildIndices$1(r102), CanvasUtil$redrawItemView$1$orderedChildIndices$2.INSTANCE})).iterator();
    L9:
        if (r103.hasNext() == false) goto L30;
        View r104 = r102.getChildAt(((Number) r103.next()).intValue());
        Intrinsics.checkNotNull(r104);
        if (r104.getVisibility() != 0) goto L13;
        boolean r105 = true;
    L14:
        if (r105 == false) goto L9;
        float r106 = r104.getX();
        float r107 = r104.getY();
        int r108 = r100.save();
        r100.translate(r106, r107);
        d(r104, r100);     // Catch: Throwable -> L19
        r100.restoreToCount(r108);
    L19:
        th = move-exception;
        r100.restoreToCount(r108);
        throw th;
    L13:
        r105 = false;
        goto L14
    L30:
        return;
    L22:
        return;
    L5:
        r102 = null;
        goto L6
    }
}
