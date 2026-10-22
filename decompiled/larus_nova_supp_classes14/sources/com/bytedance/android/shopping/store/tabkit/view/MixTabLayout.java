package com.bytedance.android.shopping.store.tabkit.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.bytedance.android.ec.core.utils.g1;
import com.bytedance.android.shopping.extensions.b;
import com.bytedance.android.ui.base.widget.tablayout.ECTabLayout;
import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\u000b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00128\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/view/MixTabLayout;", "Landroid/widget/FrameLayout;", "", "isTopBar", "", "setDefaultStyle", "Lcom/bytedance/android/ui/base/widget/tablayout/ECTabLayout;", "a", "Lcom/bytedance/android/ui/base/widget/tablayout/ECTabLayout;", "getNativeTabLayout", "()Lcom/bytedance/android/ui/base/widget/tablayout/ECTabLayout;", "nativeTabLayout", "Lcom/bytedance/android/shopping/store/tabkit/view/HybridTabLayout;", "b", "Lcom/bytedance/android/shopping/store/tabkit/view/HybridTabLayout;", "getHybridTabLayout", "()Lcom/bytedance/android/shopping/store/tabkit/view/HybridTabLayout;", "hybridTabLayout", "Landroid/util/AttributeSet;", "c", "Landroid/util/AttributeSet;", "getAttrs", "()Landroid/util/AttributeSet;", "attrs", "Landroid/content/Context;", "context", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class MixTabLayout extends FrameLayout {
    public final ECTabLayout a;
    public final HybridTabLayout b;
    public final AttributeSet c;

    public MixTabLayout(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public MixTabLayout(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final AttributeSet getAttrs() {
        return this.c;
    }

    public final HybridTabLayout getHybridTabLayout() {
        return this.b;
    }

    public final ECTabLayout getNativeTabLayout() {
        return this.a;
    }

    public ECTabLayout a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return new ECTabLayout(r2);
    }

    public HybridTabLayout b(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        HybridTabLayout r0 = new HybridTabLayout(r4, null);
        r0.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        r0.setClipChildren(false);
        return r0;
    }

    public final void setDefaultStyle(boolean r6) {
        Drawable r0 = null;
        if (r6 == false) goto L8;
        ECTabLayout r7 = this.a;
        FrameLayout.LayoutParams r2 = new FrameLayout.LayoutParams(-2, b.b(44));
        r2.leftMargin = b.b(16);
        r2.rightMargin = b.b(16);
        r2.gravity = 17;
        Unit r3 = Unit.INSTANCE;
        r7.setLayoutParams(r2);
        ECTabLayout r8 = this.a;
        int r4 = g1.a;
        Drawable r5 = g1.a.b(getContext(), 2131234849);
        if (r5 == null) goto L7;
        r0 = r5.mutate();
    L7:
        r8.setSelectedTabIndicator(r0);
        this.a.setTabMode(0);
        return;
    L8:
        this.a.setTabMaxWidth(Integer.MAX_VALUE);
        this.a.setTabGravity(0);
        this.a.setLayoutParams(new FrameLayout.LayoutParams(-1, b.b(48)));
        this.a.setSelectedTabIndicatorColor(0);
        this.a.setSelectedTabIndicator(null);
    }

    public MixTabLayout(Context r5, AttributeSet r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r6, r7);
        this.c = r6;
        setClipChildren(false);
        ECTabLayout r0 = a(r5);
        HybridTabLayout r1 = null;
        r0.setAnimation(null);
        r0.setNeedHideIndicatorWhenSingleTab(true);
        r0.setSelectedTabIndicatorHeight(b.b(4));
        r0.setSelectedTabIndicatorColor(0);
        r0.setTabPaddingStart(0);
        r0.setTabPaddingEnd(0);
        r0.setClipChildren(false);
        addView(r0);
        Unit r3 = Unit.INSTANCE;
        this.a = r0;
        HybridTabLayout r2 = b(r5);
        if (r2 == null) goto L5;
        addView(r2);
        r1 = r2;
    L5:
        this.b = r1;
        ExtensionsKt.gone(this);
        r5.obtainStyledAttributes(r6, new int[]{2130973927}).getString(0);
    }

    public /* synthetic */ MixTabLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
