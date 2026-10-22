package com.bytedance.android.window.shop.widget.recyclerview;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import gr3.b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/window/shop/widget/recyclerview/RecyclerViewBackgroundDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "<init>", "()V", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RecyclerViewBackgroundDecoration extends RecyclerView.ItemDecoration {
    public int a;
    public final Rect b;
    public final Paint c;

    public static final class a {
    }

    static {
    }

    public RecyclerViewBackgroundDecoration() {
        this.b = new Rect();
        Paint r0 = new Paint();
        r0.setAntiAlias(true);
        r0.setStyle(Paint.Style.FILL_AND_STROKE);
        Unit r1 = Unit.INSTANCE;
        this.c = r0;
    }

    public final void onDraw(Canvas r8, RecyclerView r9, RecyclerView.State r10) {
        Intrinsics.checkNotNullParameter(r8, "c");
        Intrinsics.checkNotNullParameter(r9, "parent");
        Intrinsics.checkNotNullParameter(r10, "state");
        super.onDraw(r8, r9, r10);
        if (this.a != 0) goto L5;
        this.a = r9.getPaddingLeft();
        r9.getPaddingRight();
    L5:
        int r11 = r9.getChildCount();
        int r0 = 0;
    L6:
        if (r0 >= r11) goto L22;
        View r1 = r9.getChildAt(r0);
        Object r2 = r1.getTag(2131370945);
        Object r4 = null;
        if ((r2 instanceof gr3.a) == true) goto L10;
        r2 = null;
    L10:
        gr3.a r3 = (gr3.a) r2;
        if (r3 == null) goto L21;
        Object r5 = r1.getTag(2131370946);
        if ((r5 instanceof b) == false) goto L17;
        r4 = r5;
    L17:
        b r6 = (b) r4;
        if (r6 == null) goto L21;
        r9.getDecoratedBoundsWithMargins(r1, this.b);
        this.b.left += com.bytedance.android.shopping.extensions.b.b(Float.valueOf(12.0f));
        this.b.right -= com.bytedance.android.shopping.extensions.b.b(Float.valueOf(12.0f));
        r3.a(r8, this.b, this.c, r6);
    L21:
        r0 = r0 + 1;
        goto L6
    }
}
