package com.bytedance.android.shopping.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ViewFlipper;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\tR\u001f\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/widget/VerticalMarqueeView;", "Landroid/widget/ViewFlipper;", "", "Landroid/view/View;", "b", "Ljava/util/List;", "getViews", "()Ljava/util/List;", "views", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VerticalMarqueeView extends ViewFlipper {
    public final Function0<Unit> a;
    public final List<View> b;
    public final Function0<Unit> c;

    public static final class a {
    }

    static {
    }

    public VerticalMarqueeView() {
        throw null;
    }

    public VerticalMarqueeView(Context r3) {
        this(r3, null, 62);
    }

    public VerticalMarqueeView(Context r2, AttributeSet r3) {
        this(r2, r3, 60);
    }

    public final List<View> getViews() {
        return this.b;
    }

    public VerticalMarqueeView(Context r6, AttributeSet r7, int r8) {
        if ((r8 & 2) == 0) goto L6;
        r7 = null;
    L6:
        if ((r8 & 4) == 0) goto L8;
        List<View> r0 = CollectionsKt.emptyList();
    L10:
        if ((r8 & 8) == 0) goto L12;
        int r2 = 5000;
    L14:
        if ((r8 & 16) == 0) goto L16;
        long r3 = 3000;
    L17:
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6, r7);
        this.b = r0;
        this.c = null;
        Function0<Unit> r9 = new VerticalMarqueeView$delayAddViewCB$1(this);
        this.a = r9;
        setFlipInterval(r2);
        Animation r10 = AnimationUtils.loadAnimation(r6, 2130772249);
        r10.setAnimationListener(new p(this));
        Unit r1 = Unit.INSTANCE;
        setInAnimation(r10);
        setOutAnimation(AnimationUtils.loadAnimation(r6, 2130772250));
        postDelayed(new q(r9), r3);
        return;
    L16:
        r3 = 0;
        goto L17
    L12:
        r2 = 0;
        goto L14
    L8:
        r0 = null;
        goto L10
    }
}
