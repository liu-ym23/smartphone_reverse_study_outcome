package com.bytedance.android.window.shop.widget.popup;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import androidx.lifecycle.LifecycleOwner;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.OverlaySource;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import dr3.f;
import dr3.g;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class WindowPopupWindowManager {
    public static final /* synthetic */ int a = 0;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/window/shop/widget/popup/WindowPopupWindowManager$PopupPosition;", "", "", "desc", "Ljava/lang/String;", "getDesc", "()Ljava/lang/String;", "Companion", "a", "ABOVE", "BELOW", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum PopupPosition extends Enum<PopupPosition> {
        public static final PopupPosition ABOVE = null;
        public static final PopupPosition BELOW = null;
        public static final a Companion = null;
        public static final /* synthetic */ PopupPosition[] a = null;
        public static final Map<String, PopupPosition> b = null;
        private final String desc;

        public static final class a {
            public a() {
            }
        }

        static {
            int r3 = 0;
            PopupPosition r1 = new PopupPosition("ABOVE", 0, "above");
            ABOVE = r1;
            PopupPosition r2 = new PopupPosition("BELOW", 1, "below");
            BELOW = r2;
            a = new PopupPosition[]{r1, r2};
            Companion = new a();
            PopupPosition[] r0 = values();
            LinkedHashMap r4 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(r0.length), 16));
            int r5 = r0.length;
        L3:
            if (r3 >= r5) goto L5;
            PopupPosition r6 = r0[r3];
            r4.put(r6.desc, r6);
            r3 = r3 + 1;
            goto L3
        L5:
            b = r4;
        }

        public static PopupPosition valueOf(String r1) {
            return (PopupPosition) r27.a.a(PopupPosition.class, r1);
        }

        public static PopupPosition[] values() {
            return (PopupPosition[]) a.clone();
        }

        public static final /* synthetic */ Map access$getMap$cp() {
            return b;
        }

        public final String getDesc() {
            return this.desc;
        }

        public PopupPosition(String r1, int r2, String r3) {
            super(r1, r2);
            this.desc = r3;
        }
    }

    public static final class a {
        public Runnable a;

        public a() {
            this.a = null;
        }
    }

    public static final class b {
        public final int a;
        public final int b;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof b) == false) goto L10;
            b r4 = (b) r3;
            if (this.a == r4.a) goto L8;
            return false;
        L8:
            if (this.b == r4.b) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            return (this.a * 31) + this.b;
        }

        public final String toString() {
            return "PositionControl(innerOffsetX=" + this.a + ", outerOffsetX=" + this.b + ")";
        }

        public b(int r1, int r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ PopupWindow a;

        public c(PopupWindow r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            PopupWindow r0 = this.a;     // Catch: Throwable -> L4
            PopupWindowLancet.handleDismissBeforeOrigin(r0);     // Catch: Throwable -> L4
            r0.dismiss();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ a a;

        public d(a r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Runnable r0 = this.a.a;     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            r0.run();     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(View r19, final f r20, LifecycleOwner r21, PopupPosition r22) {
        Intrinsics.checkNotNullParameter(r19, "targetView");
        Intrinsics.checkNotNullParameter(r20, "content");
        Intrinsics.checkNotNullParameter(r21, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r22, "relativePosition");
        a r3 = new a();
        ViewGroup r5 = r20.e(r19.getContext(), new d(r3));
        r5.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        fr3.a.C0125a r7 = ((fr3.a.c) r20.b).d;
        float r8 = RangesKt.coerceAtLeast(RangesKt.coerceAtLeast(RangesKt.coerceAtLeast(r7.a, r7.b), r7.d), r7.c);
        int r9 = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(((fr3.a.d) ((fr3.a.c) r20.b).e).c));
        E r10 = ((fr3.a.c) r20.b).e;
        int r11 = ((fr3.a.d) r10).d;
        int r12 = ((fr3.a.d) r10).f;
        int[] r13 = {0, 0};
        r19.getLocationInWindow(r13);
        int r14 = r13[0];
        Resources r15 = r19.getResources();
        int r16 = ((WindowDisplayMetricsOverride.apply(r15, r15.getDisplayMetrics()).widthPixels - r14) - r5.getMeasuredWidth()) - r9;
        int r17 = r19.getWidth() / r12;
        if (r16 < 0) goto L8;
        int r18 = (r19.getMeasuredWidth() / r12) + r14;
        int r23 = dr3.a.f;
        int r24 = com.bytedance.android.shopping.extensions.b.b(Float.valueOf(r8));
        int r25 = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r11));
        if (r18 >= ((r24 + dr3.a.f) + ((r25 * 3) / 2))) goto L7;
        b r26 = new b(r17 - r9, (-r14) + r9);
    L9:
        int r27 = dr3.a.f;
        if (r22 != PopupPosition.BELOW) goto L12;
        boolean r110 = true;
    L13:
        int r111 = r26.a;
        fr3.a.c r28 = (fr3.a.c) r20.b;
        Intrinsics.checkNotNullParameter(r5, "childView");
        Intrinsics.checkNotNullParameter(r28, "uiConfig");
        int r112 = r28.c;
        fr3.a.C0125a r113 = r28.d;
        dr3.a r114 = new dr3.a(r5, new dr3.a.C0117a(r110, r111, r112, (int) RangesKt.coerceAtLeast(RangesKt.coerceAtLeast(RangesKt.coerceAtLeast(r113.a, r113.b), r113.d), r113.c), com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(((fr3.a.d) r28.e).b)), com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(((fr3.a.d) r28.e).d))));
        r114.setWillNotDraw(false);
        boolean r6 = r114.e.a;
        FrameLayout.LayoutParams r29 = new FrameLayout.LayoutParams(-2, -2);
        if (r6 == false) goto L16;
        r29.gravity = 81;
        r29.topMargin = r114.a + r114.e.e;
    L17:
        r114.addView(r114.d, r29);
        r114.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        final PopupWindow r30 = new PopupWindow();
        r30.setWidth(-2);
        r30.setHeight(-2);
        r30.setContentView(r114);
        if (((fr3.a.d) ((fr3.a.c) r20.b).e).e == false) goto L20;
        r30.setOutsideTouchable(true);
    L20:
        r3.a = new c(r30);
        r21.getLifecycle().addObserver(new WindowPopupWindowManager$show$2(r30, r20));
        int r1 = g.a[r22.ordinal()];
        if (r1 != 1) goto L23;
        int r2 = r26.b;
        int r4 = -(r19.getMeasuredHeight() + r30.getContentView().getMeasuredHeight());
        OverlaySource r31 = PopupWindowLancet.resolveSource(r19);
        if (PopupWindowLancet.rewriteShowAsDropDownIfNeeded(r30, r19, r31) == true) goto L37;
        r30.showAsDropDown(r19, r2, r4, 8388611);
        PopupWindowLancet.trackAfterShow(r30, r31, r19);
        return;
    L37:
        return;
    L23:
        if (r1 != 2) goto L35;
        int r32 = r26.b;
        OverlaySource r33 = PopupWindowLancet.resolveSource(r19);
        if (PopupWindowLancet.rewriteShowAsDropDownIfNeeded(r30, r19, r33) == true) goto L36;
        r30.showAsDropDown(r19, r32, 0, 8388611);
        PopupWindowLancet.trackAfterShow(r30, r33, r19);
        return;
    L36:
        return;
    L35:
        return;
    L16:
        r29.gravity = 49;
        r29.bottomMargin = r114.a + r114.e.e;
        goto L17
    L12:
        r110 = false;
        goto L13
    L7:
        r26 = new b(r17 - r9, r9 + 0);
        goto L9
    L8:
        int r34 = -r9;
        r26 = new b((r17 - r16) - r34, r16 + r34);
        goto L9
    }
}
