package com.bytedance.android.shopping.store.home.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR0\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/shopping/store/home/view/MoveDelegateFrameLayout;", "Landroid/widget/FrameLayout;", "Landroid/view/View;", "a", "Landroid/view/View;", "getDelegateView", "()Landroid/view/View;", "setDelegateView", "(Landroid/view/View;)V", "delegateView", "Lkotlin/Pair;", "", "b", "Lkotlin/Pair;", "getOffsetLocation", "()Lkotlin/Pair;", "setOffsetLocation", "(Lkotlin/Pair;)V", "offsetLocation", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MoveDelegateFrameLayout extends FrameLayout {
    public View a;
    public Pair<Float, Float> b;
    public float c;
    public float d;
    public boolean e;

    public final View getDelegateView() {
        return this.a;
    }

    public final Pair<Float, Float> getOffsetLocation() {
        return this.b;
    }

    public final void a(MotionEvent r4) {
        Pair<Float, Float> r0 = this.b;
        float r1 = 0.0f;
        if (r0 == null) goto L7;
        Float r2 = (Float) r0.getFirst();
        if (r2 == null) goto L7;
        float r3 = r2.floatValue();
    L8:
        Pair<Float, Float> r5 = this.b;
        if (r5 == null) goto L13;
        Float r6 = (Float) r5.getSecond();
        if (r6 == null) goto L13;
        r1 = r6.floatValue();
    L13:
        r4.offsetLocation(r3, r1);
        return;
    L7:
        r3 = 0.0f;
        goto L8
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r4) {
        Intrinsics.checkNotNullParameter(r4, "ev");
        if (this.a == null) goto L27;
        if (r4.getAction() != 2) goto L16;
        if (this.c == r4.getX()) goto L9;
    L10:
        a(r4);
        View r0 = this.a;
        if (r0 == null) goto L13;
        r0.dispatchTouchEvent(r4);
    L13:
        this.e = true;
    L14:
        return true;
    L9:
        if (this.d == r4.getY()) goto L14;
    L16:
        if (r4.getAction() != 0) goto L19;
        this.c = r4.getX();
        this.d = r4.getY();
        this.e = false;
        goto L27
    L19:
        if (r4.getAction() != 1) goto L27;
        if (this.e == false) goto L27;
        a(r4);
        View r1 = this.a;
        if (r1 == null) goto L25;
        r1.dispatchTouchEvent(r4);
    L25:
        r4.setAction(3);
    L27:
        return super.dispatchTouchEvent(r4);
    }

    public final void setDelegateView(View r1) {
        this.a = r1;
    }

    public final void setOffsetLocation(Pair<Float, Float> r1) {
        this.b = r1;
    }

    public MoveDelegateFrameLayout(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public MoveDelegateFrameLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }
}
