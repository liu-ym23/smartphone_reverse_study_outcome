package com.bytedance.android.shopping.commentv3.view;

import android.content.Context;
import android.util.AttributeSet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u000eB'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/shopping/commentv3/view/FilterCardSliceView;", "Lcom/bytedance/android/shopping/commentv3/view/CommentSliceView;", "Lcom/bytedance/android/shopping/commentv3/view/FilterCardSliceView$a;", "params", "", "setConfigParams", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FilterCardSliceView extends CommentSliceView {
    public a g;
    public boolean h;
    public int i;
    public final int j;

    public static final class a {
        public int a;
        public Function2<? super Boolean, ? super Integer, Unit> b;
        public Function0<Boolean> c;

        public a() {
            this(null);
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof a) == false) goto L12;
            a r4 = (a) r3;
            if (this.a == r4.a) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.c, r4.c) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public final int hashCode() {
            int r0 = this.a * 31;
            Function2<? super Boolean, ? super Integer, Unit> r1 = this.b;
            int r2 = 0;
            if (r1 == null) goto L5;
            int r3 = r1.hashCode();
        L6:
            int r4 = (r0 + r3) * 31;
            Function0<Boolean> r5 = this.c;
            if (r5 == null) goto L10;
            r2 = r5.hashCode();
        L10:
            return r4 + r2;
        L5:
            r3 = 0;
            goto L6
        }

        public final String toString() {
            return "ConfigParams(foldHeight=" + this.a + ", foldParamsCallback=" + this.b + ", foldStatusHooker=" + this.c + ")";
        }

        public a(Object r1) {
            this.a = com.bytedance.android.shopping.extensions.b.b(124);
            this.b = null;
            this.c = null;
        }
    }

    public FilterCardSliceView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public FilterCardSliceView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void setConfigParams(a r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        this.h = false;
        this.i = 0;
        this.g = r2;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r3, int r4) {
        super.onMeasure(r3, r4);
        boolean r0 = true;
        boolean r1 = false;
        if (getMeasuredHeight() <= this.i) goto L5;
    L10:
        boolean r5 = true;
    L11:
        if (r5 == false) goto L20;
        this.h = true;
        this.i = getMeasuredHeight();
        if (Math.abs(getMeasuredHeight() - this.g.a) > this.j) goto L16;
    L14:
        r0 = false;
    L17:
        Function2<? super Boolean, ? super Integer, Unit> r6 = this.g.b;
        if (r6 == null) goto L20;
        Unit r7 = (Unit) r6.invoke(Boolean.valueOf(r0), Integer.valueOf(getMeasuredHeight()));
        goto L20
    L16:
        if (getMeasuredHeight() <= this.g.a) goto L14;
    L20:
        Function0<Boolean> r8 = this.g.c;
        if (r8 == null) goto L25;
        Boolean r9 = (Boolean) r8.invoke();
        if (r9 == null) goto L25;
        r1 = r9.booleanValue();
    L25:
        if (r1 == true) goto L27;
        return;
    L27:
        if (getMeasuredHeight() <= (this.g.a + this.j)) goto L31;
        setMeasuredDimension(getMeasuredWidth(), this.g.a);
        return;
    L31:
        return;
    L5:
        if (getMeasuredHeight() > 0) goto L7;
    L9:
        r5 = false;
        goto L11
    L7:
        if (this.h == true) goto L9;
        goto L9
    }

    public FilterCardSliceView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.g = new a(null);
        this.j = 5;
    }

    public /* synthetic */ FilterCardSliceView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
