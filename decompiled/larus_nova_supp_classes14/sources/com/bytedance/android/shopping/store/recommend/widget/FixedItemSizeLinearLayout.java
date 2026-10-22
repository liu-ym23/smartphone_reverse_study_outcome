package com.bytedance.android.shopping.store.recommend.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0019\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010R*\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/shopping/store/recommend/widget/FixedItemSizeLinearLayout;", "Landroid/widget/LinearLayout;", "", "value", "a", "I", "getItemCount", "()I", "setItemCount", "(I)V", "itemCount", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FixedItemSizeLinearLayout extends LinearLayout {
    public static final int c = 0;
    public int a;
    public int b;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ FixedItemSizeLinearLayout a;
        public final /* synthetic */ View b;

        public b(FixedItemSizeLinearLayout r1, View r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.addView(this.b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        c = com.bytedance.android.shopping.extensions.b.b(9);
    }

    public final int getItemCount() {
        return this.a;
    }

    @Override // android.view.ViewGroup
    public final void addView(View r3) {
        if (this.b == 0) goto L5;
        int r1 = this.b;
        LinearLayout.LayoutParams r0 = new LinearLayout.LayoutParams(r1, r1);
        r0.rightMargin = c;
        Unit r2 = Unit.INSTANCE;
        addView(r3, r0);
        return;
    L5:
        post(new b(this, r3));
    }

    public final void setItemCount(int r2) {
        if (r2 == this.a) goto L7;
        if (r2 <= 0) goto L8;
        this.a = r2;
        requestLayout();
        return;
    L8:
        return;
    }

    public FixedItemSizeLinearLayout(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r3, "attrs");
        super(r2, r3);
        setOrientation(0);
        this.a = 3;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r5, int r6) {
        int r0 = View.MeasureSpec.getSize(r5);
        if (r0 != 0) goto L6;
        super.onMeasure(r5, r6);
        return;
    L6:
        int r1 = this.a;
        int r2 = (r0 - ((r1 - 1) * c)) / r1;
        this.b = r2;
        super.onMeasure(r5, View.MeasureSpec.makeMeasureSpec(r2, View.MeasureSpec.getMode(r6)));
    }
}
