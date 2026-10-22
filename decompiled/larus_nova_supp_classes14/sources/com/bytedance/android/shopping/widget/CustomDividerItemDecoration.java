package com.bytedance.android.shopping.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/shopping/widget/CustomDividerItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/content/Context;", "c", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CustomDividerItemDecoration extends RecyclerView.ItemDecoration {
    public Drawable a;
    public final Rect b;
    public final Context c;
    public final int d;

    public final Context getContext() {
        return this.c;
    }

    public CustomDividerItemDecoration(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.c = r2;
        this.d = 1;
        this.b = new Rect();
    }

    public final void onDraw(Canvas r8, RecyclerView r9, RecyclerView.State r10) {
        Intrinsics.checkNotNullParameter(r8, "c");
        Intrinsics.checkNotNullParameter(r9, "parent");
        Intrinsics.checkNotNullParameter(r10, "state");
        if (this.a == null) goto L63;
        if (r9.getLayoutManager() != null) goto L7;
        return;
    L7:
        if (this.d != 0) goto L36;
        r8.save();
        if (r9.getClipToPadding() == false) goto L11;
        int r11 = r9.getPaddingTop();
        int r1 = r9.getHeight() - r9.getPaddingBottom();
        r8.clipRect(r9.getPaddingLeft(), r11, r9.getWidth() - r9.getPaddingRight(), r1);
    L12:
        Iterator r2 = com.bytedance.commerce.base.view.b.a(r9).iterator();
        int r3 = 0;
    L14:
        if (r2.hasNext() == false) goto L34;
        Object r4 = r2.next();
        int r5 = r3 + 1;
        if (r3 >= 0) goto L18;
        CollectionsKt.throwIndexOverflow();
    L18:
        View r6 = (View) r4;
        if (r3 >= (r9.getChildCount() - 1)) goto L33;
        RecyclerView.LayoutManager r7 = r9.getLayoutManager();
        if (r7 == null) goto L23;
        r7.getDecoratedBoundsWithMargins(r6, this.b);
    L23:
        int r12 = this.b.right + MathKt.roundToInt(r6.getTranslationX());
        Drawable r13 = this.a;
        if (r13 == null) goto L26;
        int r14 = r13.getIntrinsicWidth();
    L27:
        int r15 = r12 - r14;
        Drawable r16 = this.a;
        if (r16 == null) goto L30;
        r16.setBounds(r15, r11, r12, r1);
    L30:
        Drawable r17 = this.a;
        if (r17 == null) goto L33;
        r17.draw(r8);
        goto L33
    L26:
        r14 = 0;
    L33:
        r3 = r5;
        goto L14
    L34:
        r8.restore();
        goto L36
    L11:
        r1 = r9.getHeight();
        r11 = 0;
    L36:
        if (this.d != 1) goto L73;
        r8.save();
        if (r9.getClipToPadding() == false) goto L40;
        int r18 = r9.getPaddingLeft();
        int r19 = r9.getWidth() - r9.getPaddingRight();
        r8.clipRect(r18, r9.getPaddingTop(), r19, r9.getHeight() - r9.getPaddingBottom());
    L41:
        Iterator r20 = com.bytedance.commerce.base.view.b.a(r9).iterator();
        int r21 = 0;
    L43:
        if (r20.hasNext() == false) goto L60;
        Object r22 = r20.next();
        int r23 = r21 + 1;
        if (r21 >= 0) goto L47;
        CollectionsKt.throwIndexOverflow();
    L47:
        View r24 = (View) r22;
        if (r21 >= (r9.getChildCount() - 1)) goto L59;
        r9.getDecoratedBoundsWithMargins(r24, this.b);
        int r25 = this.b.bottom + MathKt.roundToInt(r24.getTranslationY());
        Drawable r26 = this.a;
        if (r26 == null) goto L52;
        int r27 = r26.getIntrinsicHeight();
    L53:
        int r28 = r25 - r27;
        Drawable r29 = this.a;
        if (r29 == null) goto L56;
        r29.setBounds(r18, r28, r19, r25);
    L56:
        Drawable r30 = this.a;
        if (r30 == null) goto L59;
        r30.draw(r8);
        goto L59
    L52:
        r27 = 0;
    L59:
        r21 = r23;
        goto L43
    L60:
        r8.restore();
        return;
    L40:
        r19 = r9.getWidth();
        r18 = 0;
        goto L41
    L73:
        return;
    L63:
        throw new IllegalArgumentException("Drawable must not be null");
    }

    public final void getItemOffsets(Rect r2, View r3, RecyclerView r4, RecyclerView.State r5) {
        Intrinsics.checkNotNullParameter(r2, "outRect");
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r4, "parent");
        Intrinsics.checkNotNullParameter(r5, "state");
        Drawable r6 = this.a;
        if (r6 != null) goto L7;
        r2.set(0, 0, 0, 0);
        return;
    L7:
        if (this.d != 0) goto L13;
        if (r6 == null) goto L10;
        int r7 = r6.getIntrinsicWidth();
    L11:
        r2.set(0, 0, r7, 0);
        goto L13
    L10:
        r7 = 0;
    L13:
        if (this.d != 1) goto L20;
        Drawable r8 = this.a;
        if (r8 == null) goto L17;
        int r9 = r8.getIntrinsicHeight();
    L18:
        r2.set(0, 0, 0, r9);
        return;
    L17:
        r9 = 0;
        goto L18
    }
}
