package com.bytedance.android.shopping.widget.banner;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012R*\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/shopping/widget/banner/PrimeHorizontalRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "Lkotlin/Function0;", "", "a", "Lkotlin/jvm/functions/Function0;", "getTouchCallback", "()Lkotlin/jvm/functions/Function0;", "setTouchCallback", "(Lkotlin/jvm/functions/Function0;)V", "touchCallback", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class PrimeHorizontalRecyclerView extends RecyclerView {
    public Function0<Unit> a;
    public final int b;
    public float c;
    public float d;
    public boolean e;

    public PrimeHorizontalRecyclerView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public PrimeHorizontalRecyclerView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final Function0<Unit> getTouchCallback() {
        return this.a;
    }

    public final boolean onInterceptTouchEvent(MotionEvent r4) {
        Intrinsics.checkNotNullParameter(r4, "e");
        boolean r1 = true;
        if (r4.getActionMasked() != 1) goto L5;
    L8:
        this.e = false;
    L9:
        if (r1 == true) goto L11;
        r(r4);
        return super.onInterceptTouchEvent(r4);
    L11:
        return super.onInterceptTouchEvent(r4);
    L5:
        if (r4.getActionMasked() == 3) goto L8;
        r1 = this.e;
        goto L9
    }

    public final boolean onTouchEvent(MotionEvent r4) {
        Intrinsics.checkNotNullParameter(r4, "e");
        boolean r1 = true;
        if (r4.getActionMasked() != 1) goto L5;
    L8:
        this.e = false;
    L9:
        if (r1 == true) goto L11;
        r(r4);
        return super.onTouchEvent(r4);
    L11:
        return super.onTouchEvent(r4);
    L5:
        if (r4.getActionMasked() == 3) goto L8;
        r1 = this.e;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void r(MotionEvent r9) {
        int r0 = r9.getActionMasked();
        if (r0 != 0) goto L5;
        this.c = r9.getX();
        this.d = r9.getY();
        getParent().requestDisallowInterceptTouchEvent(true);
        setNestedScrollingEnabled(false);
        this.e = false;
        return;
    L5:
        if (r0 != 2) goto L23;
        float r1 = Math.abs(r9.getX() - this.c);
        float r10 = Math.abs(r9.getY() - this.d);
        int r4 = this.b;
        if (r1 < r4) goto L10;
    L11:
        this.e = true;
        double r5 = r10;
        if (Math.sqrt((r5 * r5) + ((double) (r1 * r1))) <= (r1 * 2)) goto L14;
        getParent().requestDisallowInterceptTouchEvent(false);
        setNestedScrollingEnabled(true);
        return;
    L14:
        Function0<Unit> r11 = this.a;
        if (r11 == null) goto L21;
        Unit r12 = (Unit) r11.invoke();
        return;
    L21:
        return;
    L10:
        if (r10 >= r4) goto L11;
        return;
    }

    public final void setTouchCallback(Function0<Unit> r1) {
        this.a = r1;
    }

    public PrimeHorizontalRecyclerView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.b = ViewConfiguration.get(r2).getScaledTouchSlop();
    }

    public /* synthetic */ PrimeHorizontalRecyclerView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
