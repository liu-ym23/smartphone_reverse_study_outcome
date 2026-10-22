package com.bytedance.android.shopping.anchorv4.voavhs.head.more;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R*\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/head/more/AnchorV4LoadMoreRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "", "expand", "", "setScrollState", "Lkotlin/Function0;", "b", "Lkotlin/jvm/functions/Function0;", "getScrollToEndCallback", "()Lkotlin/jvm/functions/Function0;", "setScrollToEndCallback", "(Lkotlin/jvm/functions/Function0;)V", "scrollToEndCallback", "", "c", "Ljava/lang/Float;", "getActionDownX", "()Ljava/lang/Float;", "setActionDownX", "(Ljava/lang/Float;)V", "actionDownX", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4LoadMoreRecyclerView extends RecyclerView {
    public boolean a;
    public Function0<Unit> b;
    public Float c;

    public AnchorV4LoadMoreRecyclerView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public AnchorV4LoadMoreRecyclerView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final Float getActionDownX() {
        return this.c;
    }

    public final Function0<Unit> getScrollToEndCallback() {
        return this.b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean dispatchTouchEvent(MotionEvent r4) {
        Intrinsics.checkNotNullParameter(r4, "ev");
        int r0 = r4.getAction();
        if (r0 != 0) goto L5;
        this.c = Float.valueOf(r4.getX());
    L18:
        return super/*android.view.ViewGroup*/.dispatchTouchEvent(r4);
    L5:
        if (r0 == 1) goto L10;
        if (r0 != 3) goto L18;
    L10:
        if (this.a == false) goto L18;
        if ((!Intrinsics.areEqual(this.c, r4.getX())) == false) goto L18;
        Function0<Unit> r1 = this.b;
        if (r1 == null) goto L18;
        Unit r2 = (Unit) r1.invoke();
        goto L18
    }

    public final void setActionDownX(Float r1) {
        this.c = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setScrollState(final boolean r3) {
        if (this.a == r3) goto L6;
        this.a = r3;
        final Context r1 = getContext();
        LinearLayoutManager r0 = new AnonymousClass1(r3, r1);
        r0.setOrientation(0);
        Unit r4 = Unit.INSTANCE;
        setLayoutManager(r0);
        return;
    }

    public final void setScrollToEndCallback(Function0<Unit> r1) {
        this.b = r1;
    }

    public AnchorV4LoadMoreRecyclerView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = true;
    }

    public /* synthetic */ AnchorV4LoadMoreRecyclerView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
