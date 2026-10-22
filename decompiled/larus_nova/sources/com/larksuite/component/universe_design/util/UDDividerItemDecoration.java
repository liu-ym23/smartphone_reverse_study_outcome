package com.larksuite.component.universe_design.util;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u0003J\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0007J\u000e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\fJ \u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0018\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0018\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J(\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/larksuite/component/universe_design/util/UDDividerItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "orientation", "", "<init>", "(I)V", "mDivider", "Landroid/graphics/drawable/Drawable;", "mOrientation", "mBounds", "Landroid/graphics/Rect;", "mDrawLastOne", "", "setOrientation", "", "setDrawable", "drawable", "setDrawLastOne", "drawLastOne", "onDraw", "c", "Landroid/graphics/Canvas;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "drawVertical", "canvas", "drawHorizontal", "getDrawCount", "getItemOffsets", "outRect", "view", "Landroid/view/View;", "Companion", "universe-ui-dialog_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UDDividerItemDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Drawable f285482a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f285483b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Rect f285484c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f285485d;

    public static final class a {
    }

    static {
    }

    public UDDividerItemDecoration() {
        this.f285483b = 1;
        this.f285484c = new Rect();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void onDraw(Canvas r100, RecyclerView r101, RecyclerView.State r110) {
        Intrinsics.checkNotNullParameter(r100, "c");
        Intrinsics.checkNotNullParameter(r101, "parent");
        Intrinsics.checkNotNullParameter(r110, "state");
        if (r101.getLayoutManager() != null) goto L5;
        return;
    L5:
        if (this.f285482a == null) goto L49;
        int r102 = 0;
        if (this.f285483b != 1) goto L23;
        r100.save();
        Drawable r111 = this.f285482a;
        if (r111 != null) goto L13;
        return;
    L13:
        if (r101.getClipToPadding() == false) goto L15;
        int r103 = r101.getPaddingLeft();
        int r104 = r101.getWidth() - r101.getPaddingRight();
        r100.clipRect(r103, r101.getPaddingTop(), r104, r101.getHeight() - r101.getPaddingBottom());
    L17:
        if (this.f285485d == false) goto L19;
        int r105 = r101.getChildCount();
    L20:
        if (r102 >= r105) goto L22;
        View r106 = r101.getChildAt(r102);
        r101.getDecoratedBoundsWithMargins(r106, this.f285484c);
        int r107 = this.f285484c.bottom + MathKt.roundToInt(r106.getTranslationY());
        r111.setBounds(r103, r107 - r111.getIntrinsicHeight(), r104, r107);
        r111.draw(r100);
        r102 = r102 + 1;
        goto L20
    L22:
        r100.restore();
        return;
    L19:
        r105 = r101.getChildCount() - 1;
        goto L20
    L15:
        r104 = r101.getWidth();
        r103 = 0;
        goto L17
    L23:
        r100.save();
        Drawable r112 = this.f285482a;
        if (r112 != null) goto L27;
        return;
    L27:
        if (r101.getClipToPadding() == false) goto L29;
        int r108 = r101.getPaddingTop();
        int r109 = r101.getHeight() - r101.getPaddingBottom();
        r100.clipRect(r101.getPaddingLeft(), r108, r101.getWidth() - r101.getPaddingRight(), r109);
    L31:
        if (this.f285485d == false) goto L33;
        int r113 = r101.getChildCount();
    L34:
        if (r102 >= r113) goto L39;
        View r114 = r101.getChildAt(r102);
        RecyclerView.LayoutManager r115 = r101.getLayoutManager();
        if (r115 == null) goto L38;
        r115.getDecoratedBoundsWithMargins(r114, this.f285484c);
    L38:
        int r116 = this.f285484c.right + MathKt.roundToInt(r114.getTranslationX());
        r112.setBounds(r116 - r112.getIntrinsicWidth(), r108, r116, r109);
        r112.draw(r100);
        r102 = r102 + 1;
        goto L34
    L39:
        r100.restore();
        return;
    L33:
        r113 = r101.getChildCount() - 1;
        goto L34
    L29:
        r109 = r101.getHeight();
        r108 = 0;
        goto L31
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        Intrinsics.checkNotNullParameter(r100, "outRect");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "parent");
        Intrinsics.checkNotNullParameter(r103, "state");
        Drawable r104 = this.f285482a;
        if (r104 != null) goto L7;
        r100.set(0, 0, 0, 0);
        return;
    L7:
        if (this.f285483b != 1) goto L9;
        Intrinsics.checkNotNull(r104);
        r100.set(0, 0, 0, r104.getIntrinsicHeight());
        return;
    L9:
        Intrinsics.checkNotNull(r104);
        r100.set(0, 0, r104.getIntrinsicWidth(), 0);
    }
}
