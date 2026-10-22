package com.bytedance.android.shopping.extensions;

import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.utils.q;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class ViewExtensionsKt {

    public static final class a extends ViewOutlineProvider {
        public final /* synthetic */ float a;
        public final /* synthetic */ float b;
        public final /* synthetic */ float c;
        public final /* synthetic */ float d;
        public final /* synthetic */ float e;

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View r9, Outline r10) {
            Intrinsics.checkNotNullParameter(r9, FreqActions.ACTION_VIEW);
            Intrinsics.checkNotNullParameter(r10, "outline");
            float r7 = Math.min(Math.min(r9.getWidth(), r9.getHeight()) / 2, this.a);
            float r0 = this.b;
            float r2 = 0;
            if (r0 <= r2) goto L5;
        L8:
            int r3 = 0;
        L10:
            if (r0 <= r2) goto L12;
        L15:
            int r4 = 0;
        L17:
            if (this.d <= r2) goto L19;
        L22:
            int r1 = r9.getWidth();
        L23:
            int r5 = r1;
            if (this.c <= r2) goto L26;
        L29:
            int r11 = r9.getHeight();
        L30:
            r10.setRoundRect(r3, r4, r5, r11, r7);
            return;
        L26:
            if (this.e > r2) goto L29;
            r11 = r9.getHeight() + ((int) r7);
            goto L30
        L19:
            if (this.e > r2) goto L22;
            r1 = r9.getWidth() + ((int) r7);
            goto L23
        L12:
            if (this.d > r2) goto L15;
            r4 = -((int) r7);
            goto L17
        L5:
            if (this.c > r2) goto L8;
            r3 = -((int) r7);
            goto L10
        }

        public a(float r1, float r2, float r3, float r4, float r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }
    }

    public static final void d(RecyclerView r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$scrollToTop");
        RecyclerView.Adapter r0 = r4.getAdapter();
        if (r0 == null) goto L22;
        Integer r1 = Integer.valueOf(r0.getItemCount());
        if (r1.intValue() <= 0) goto L7;
        boolean r2 = true;
    L8:
        LinearLayoutManager r3 = null;
        if (r2 == true) goto L12;
        r1 = null;
    L12:
        if (r1 == null) goto L23;
        r1.intValue();
        LinearLayoutManager r5 = r4.getLayoutManager();
        if ((r5 instanceof LinearLayoutManager) == false) goto L17;
        r3 = r5;
    L17:
        LinearLayoutManager r6 = r3;
        if (r6 == null) goto L20;
        r6.scrollToPositionWithOffset(0, 0);
        return;
    L20:
        r4.scrollToPosition(0);
        return;
    L23:
        return;
    L7:
        r2 = false;
        goto L8
    }

    public static void i(View r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$showWithAnimAlpha");
        r2.animate().cancel();
        r2.setVisibility(0);
        r2.animate().alpha(1.0f).setListener(null).setDuration(200).start();
    }

    public static final View b(ViewGroup r4, Function1 r5) {
        Intrinsics.checkNotNullParameter(r4, "$this$findFirst");
        Intrinsics.checkNotNullParameter(r5, "predict");
        int r0 = r4.getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        View r2 = r4.getChildAt(r1);
        if (((Boolean) r5.invoke(r2)).booleanValue() == true) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return r2;
    L8:
        return null;
    }

    public static final void h(TextView r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$setTextSizeDp");
        r1.setTextSize(1, r2);
    }

    public static final View j(ViewGroup r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "$this$trackSpecificViewWithRefId");
        Intrinsics.checkNotNullParameter(r4, "refId");
        IntRange r0 = RangesKt.until(0, r3.getChildCount());
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        IntIterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r1.add(r3.getChildAt(r2.nextInt()));
        goto L4
    L6:
        Iterator r5 = r1.iterator();
    L7:
        View r6 = null;
        if (r5.hasNext() == false) goto L21;
        View r7 = (View) r5.next();
        if (Intrinsics.areEqual(r7.getTag(), r4) == true) goto L11;
        if ((r7 instanceof ViewGroup) == false) goto L16;
        r6 = r7;
    L16:
        ViewGroup r8 = (ViewGroup) r6;
        if (r8 == null) goto L7;
        View r9 = j(r8, r4);
        if (r9 == null) goto L7;
        return r9;
    L11:
        return r7;
    L21:
        return null;
    }

    public static final View a(ViewGroup r1, final float r2, final float r3) {
        Intrinsics.checkNotNullParameter(r1, "$this$findChildUnder");
        return b(r1, new ViewExtensionsKt$findChildUnder$1(r2, r3));
    }

    public static void c(View r3, boolean r4, int r5) {
        if ((r5 & 1) == 0) goto L5;
        long r0 = 200;
    L7:
        if ((r5 & 2) == 0) goto L9;
        r4 = false;
    L9:
        Intrinsics.checkNotNullParameter(r3, "$this$hideWithAnimAlpha");
        r3.animate().cancel();
        r3.animate().alpha(0.0f).setDuration(r0).setListener(new l(r3, r4)).start();
        return;
    L5:
        r0 = 0;
        goto L7
    }

    public static final void e(TextView r2, Paint r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "$this$setFontWeight");
        if (r4 >= 0) goto L5;
        return;
    L5:
        if (r4 <= 1000) goto L8;
        return;
    L8:
        if (Build.VERSION.SDK_INT < 28) goto L19;
        if (r3 == null) goto L20;
        Typeface r5 = r3.getTypeface();
        Typeface r0 = r3.getTypeface();
        if (r0 != null) goto L13;
    L15:
        boolean r1 = false;
    L16:
        r3.setTypeface(Typeface.create(r5, r4, r1));
        return;
    L13:
        if (r0.getStyle() != 2) goto L15;
        r1 = true;
        goto L16
    L20:
        return;
    }

    public static /* synthetic */ void g(View r6, float r7, float r8, float r9, float r10) {
        f(r6, r7, r8, r9, r10, true);
    }

    public static final void f(View r6, float r7, float r8, float r9, float r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r6, "$this$setRadius");
        if (r11 == false) goto L5;
        r7 = q.a(Float.valueOf(r7));
    L5:
        float r2 = r7;
        if (r11 == false) goto L8;
        r8 = q.a(Float.valueOf(r8));
    L8:
        float r4 = r8;
        if (r11 == false) goto L11;
        r9 = q.a(Float.valueOf(r9));
    L11:
        float r5 = r9;
        if (r11 == false) goto L14;
        r10 = q.a(Float.valueOf(r10));
    L14:
        float r3 = r10;
        Float r12 = ArraysKt.maxOrNull(new float[]{r2, r4, r5, r3});
        if (r12 == null) goto L17;
        float r1 = r12.floatValue();
    L19:
        if (r1 <= 0) goto L21;
        r6.setClipToOutline(true);
        r6.setOutlineProvider(new a(r1, r2, r3, r4, r5));
        return;
    L21:
        r6.setClipToOutline(false);
        r6.setOutlineProvider(null);
        return;
    L17:
        r1 = 0.0f;
        goto L19
    }
}
