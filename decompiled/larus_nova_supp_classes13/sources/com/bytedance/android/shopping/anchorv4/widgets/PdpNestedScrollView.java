package com.bytedance.android.shopping.anchorv4.widgets;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002R*\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/widgets/PdpNestedScrollView;", "Lcom/bytedance/android/shopping/anchorv4/widgets/BasePdpNestedScrollView;", "", "getMainFeedDefaultVisibleHeight", "Lkotlin/Function0;", "h", "Lkotlin/jvm/functions/Function0;", "getCoverAreaHeight", "()Lkotlin/jvm/functions/Function0;", "setCoverAreaHeight", "(Lkotlin/jvm/functions/Function0;)V", "coverAreaHeight", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PdpNestedScrollView extends BasePdpNestedScrollView {
    public Function0<Integer> h;

    public static final class a implements View.OnLayoutChangeListener {
        public final /* synthetic */ RecyclerView a;
        public final /* synthetic */ PdpNestedScrollView b;

        public a(RecyclerView r1, PdpNestedScrollView r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            if (this.a.getHeight() <= 0) goto L10;
            this.a.removeOnLayoutChangeListener(this);
            PdpNestedScrollView r10 = this.b;
            r10.smoothScrollTo(0, PdpNestedScrollView.f(r10));
            RecyclerView r11 = this.b.getRvTop();
            if (r11 != null) goto L7;
            return;
        L7:
            if (r11.canScrollVertically(1) != true) goto L12;
            PdpNestedScrollView r12 = this.b;
            r12.e(r12.getRvTop());
            return;
        L12:
            return;
        }
    }

    public final void i() {
        RecyclerView r0 = this.b;
        if (r0 == null) goto L5;
        r0.stopScroll();
    L5:
        RecyclerView r1 = this.c;
        if (r1 == null) goto L8;
        r1.stopScroll();
    L8:
        e(getRvTop());
        RecyclerView r2 = getRvBottom();
        if (r2 == null) goto L11;
        r2.scrollToPosition(0);
    L11:
        RecyclerView r3 = getRvBottom();
        if (r3 != null) goto L14;
        return;
    L14:
        if (r3.getHeight() <= 0) goto L16;
        scrollTo(0, getMainFeedDefaultVisibleHeight());
        return;
    L16:
        r3.addOnLayoutChangeListener(new a(r3, this));
    }

    private final int getMainFeedDefaultVisibleHeight() {
        RecyclerView r0 = getRvTop();
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.getHeight();
    L6:
        Function0<Integer> r3 = this.h;
        if (r3 == null) goto L12;
        Integer r4 = (Integer) r3.invoke();
        if (r4 == null) goto L12;
        r1 = r4.intValue();
    L12:
        return r2 - r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final boolean g() {
        RecyclerView r0 = getRvTop();
        if (r0 != null) goto L5;
    L6:
        RecyclerView r1 = getRvTop();
        if (r1 != null) goto L9;
    L11:
        return false;
    L9:
        if (r1.canScrollVertically(-1) != true) goto L11;
        return true;
    L5:
        if (r0.canScrollVertically(1) != true) goto L6;
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean h() {
        if (getScrollY() >= getMainFeedDefaultVisibleHeight()) goto L5;
        return true;
    L5:
        return false;
    }

    public final Function0<Integer> getCoverAreaHeight() {
        return this.h;
    }

    public PdpNestedScrollView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }

    public static final /* synthetic */ int f(PdpNestedScrollView r0) {
        return r0.getMainFeedDefaultVisibleHeight();
    }

    public final void setCoverAreaHeight(Function0<Integer> r1) {
        this.h = r1;
    }
}
