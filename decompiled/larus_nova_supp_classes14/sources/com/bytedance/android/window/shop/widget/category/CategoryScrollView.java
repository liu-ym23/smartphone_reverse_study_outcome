package com.bytedance.android.window.shop.widget.category;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0016\u0010\u0017R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/window/shop/widget/category/CategoryScrollView;", "Landroid/widget/HorizontalScrollView;", "", "a", "Ljava/lang/Integer;", "getXPosition", "()Ljava/lang/Integer;", "setXPosition", "(Ljava/lang/Integer;)V", "xPosition", "Lcom/bytedance/android/window/shop/widget/category/CategoryBarView;", "b", "Lcom/bytedance/android/window/shop/widget/category/CategoryBarView;", "getCategoryBarView", "()Lcom/bytedance/android/window/shop/widget/category/CategoryBarView;", "setCategoryBarView", "(Lcom/bytedance/android/window/shop/widget/category/CategoryBarView;)V", "categoryBarView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CategoryScrollView extends HorizontalScrollView {
    public static final /* synthetic */ int d = 0;
    public Integer a;
    public CategoryBarView b;
    public final List<Function5<View, Integer, Integer, Integer, Integer, Unit>> c;

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.b = (CategoryBarView) findViewById(2131365287);
    }

    public final CategoryBarView getCategoryBarView() {
        return this.b;
    }

    public final Integer getXPosition() {
        return this.a;
    }

    public final void setCategoryBarView(CategoryBarView r1) {
        this.b = r1;
    }

    public final void setXPosition(Integer r1) {
        this.a = r1;
    }

    public CategoryScrollView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.c = new ArrayList();
    }

    @Override // android.view.View
    public final void onScrollChanged(int r9, int r10, int r11, int r12) {
        super.onScrollChanged(r9, r10, r11, r12);
        Iterator<T> r0 = this.c.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((Function5) r0.next()).invoke(this, Integer.valueOf(r9), Integer.valueOf(r10), Integer.valueOf(r11), Integer.valueOf(r12));
        goto L4
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        Integer r6 = this.a;
        if (r6 == null) goto L6;
        scrollTo(r6.intValue(), 0);
        return;
    }
}
