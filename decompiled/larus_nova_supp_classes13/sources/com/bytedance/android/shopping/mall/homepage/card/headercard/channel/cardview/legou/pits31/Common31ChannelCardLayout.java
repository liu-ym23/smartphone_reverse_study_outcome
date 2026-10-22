package com.bytedance.android.shopping.mall.homepage.card.headercard.channel.cardview.legou.pits31;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.view.ViewCompat;
import com.bytedance.android.ec.hybrid.list.util.c;
import com.facebook.drawee.view.SimpleDraweeView;
import gf3.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\b\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/headercard/channel/cardview/legou/pits31/Common31ChannelCardLayout;", "Landroid/widget/LinearLayout;", "", "Lcom/facebook/drawee/view/SimpleDraweeView;", "c", "Lcom/facebook/drawee/view/SimpleDraweeView;", "getTitleSdView", "()Lcom/facebook/drawee/view/SimpleDraweeView;", "titleSdView", "", "Lgf3/a;", "d", "Ljava/util/List;", "getProductContentList", "()Ljava/util/List;", "productContentList", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class Common31ChannelCardLayout extends LinearLayout {
    public final int a;
    public final int b;
    public final SimpleDraweeView c;
    public final List<a> d;

    public Common31ChannelCardLayout(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public Common31ChannelCardLayout(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final List<a> getProductContentList() {
        return this.d;
    }

    public final SimpleDraweeView getTitleSdView() {
        return this.c;
    }

    public final void a(List r13) {
        Intrinsics.checkNotNullParameter(r13, "itemViewList");
        int r0 = r13.size();
        double r3 = (161.75d - ((double) (r0 * 48))) / ((double) (r0 - 1));
        LinearLayout r1 = new LinearLayout(getContext());
        r1.setOrientation(0);
        Iterator r14 = r13.iterator();
        int r5 = 0;
    L4:
        if (r14.hasNext() == false) goto L12;
        Object r6 = r14.next();
        int r7 = r5 + 1;
        if (r5 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        a r8 = (a) r6;
        View r9 = r8.i();
        LinearLayout.LayoutParams r10 = new LinearLayout.LayoutParams(this.a, this.b);
        r10.gravity = 16;
        if (r5 == 0) goto L11;
        int r11 = c.a;
        r10.setMarginStart(c.c(Double.valueOf(r3), r1.getContext(), true));
    L11:
        Unit r12 = Unit.INSTANCE;
        r1.addView(r9, r10);
        ((ArrayList) this.d).add(r8);
        r5 = r7;
        goto L4
    L12:
        LinearLayout.LayoutParams r15 = new LinearLayout.LayoutParams(-1, -1);
        int r4 = c.a;
        r15.setMargins(0, c.c(6, getContext(), true), 0, 0);
        Unit r2 = Unit.INSTANCE;
        addView(r1, r15);
    }

    public Common31ChannelCardLayout(Context r6, AttributeSet r7, int r8) {
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6, r7, r8);
        int r9 = c.a;
        this.a = c.c(48, r6, true);
        this.b = c.c(62, r6, true);
        SimpleDraweeView r10 = new SimpleDraweeView(r6);
        this.c = r10;
        this.d = new ArrayList();
        setClipChildren(false);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        com.bytedance.android.shopping.mall.homepage.card.headercard.util.c.a(this, r6, r7);
        setPaddingRelative(c.c(8, r6, true), c.c(0, r6, true), c.c(8, r6, true), c.c(8, r6, true));
        setOrientation(1);
        r10.setId(ViewCompat.generateViewId());
        addView(r10, -1, c.c(24, r6, true));
    }

    public /* synthetic */ Common31ChannelCardLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
