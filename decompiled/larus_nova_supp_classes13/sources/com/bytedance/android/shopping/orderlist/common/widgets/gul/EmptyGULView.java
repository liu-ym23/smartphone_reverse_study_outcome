package com.bytedance.android.shopping.orderlist.common.widgets.gul;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import jg3.b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/common/widgets/gul/EmptyGULView;", "Landroid/widget/FrameLayout;", "Ljg3/b;", "Landroid/view/View;", "getView", "", "height", "", "setGULHeight", "getGULVerticalOffset", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class EmptyGULView extends FrameLayout implements b {
    @Override // jg3.b
    public final boolean a() {
        return false;
    }

    @Override // jg3.b
    public final boolean b() {
        return true;
    }

    @Override // jg3.b
    public final boolean c() {
        return false;
    }

    @Override // jg3.b
    public final void e(String r2) {
        Intrinsics.checkNotNullParameter(r2, "tag");
    }

    @Override // jg3.b
    public int getGULVerticalOffset() {
        return 0;
    }

    @Override // jg3.b
    public View getView() {
        return this;
    }

    @Override // jg3.b
    public final boolean isLoading() {
        return false;
    }

    @Override // jg3.b
    public final void release() {
    }

    @Override // android.view.View, jg3.b
    public final void scrollBy(int r1, int r2) {
    }

    @Override // jg3.b
    public void setGULHeight(int r1) {
    }

    @Override // jg3.b
    public final void show() {
    }

    @Override // jg3.b
    public final void t0() {
    }

    public /* synthetic */ EmptyGULView(Context r3) {
        this(r3, null, 0);
    }

    @Override // jg3.b
    public final void d(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "disposableCallback");
        r2.invoke();
    }

    @Override // jg3.b
    public final void f(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "disposableCallback");
        r2.invoke();
    }

    public EmptyGULView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }
}
