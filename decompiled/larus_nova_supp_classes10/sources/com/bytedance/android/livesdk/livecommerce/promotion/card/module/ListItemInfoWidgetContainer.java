package com.bytedance.android.livesdk.livecommerce.promotion.card.module;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotion/card/module/ListItemInfoWidgetContainer;", "Landroid/widget/LinearLayout;", "Lij2/b;", "Lij2/a;", "getCurrentWidget", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ListItemInfoWidgetContainer extends LinearLayout implements ij2.b {
    public ListItemInfoWidgetContainer(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ListItemInfoWidgetContainer(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // ij2.b
    public final void b() {
        d();
        removeAllViews();
    }

    @Override // ij2.b
    public final boolean c() {
        if (getVisibility() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final void d() {
        List r0 = com.bytedance.commerce.base.view.b.a(this);
        ArrayList r1 = new ArrayList();
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Object r3 = r2.next();
        if ((r3 instanceof ij2.a) == false) goto L4;
        r1.add(r3);
        goto L4
    L8:
        Iterator r4 = r1.iterator();
    L10:
        if (r4.hasNext() == false) goto L12;
        ((ij2.a) r4.next()).release();
        goto L10
    }

    @Override // ij2.b
    public ij2.a getCurrentWidget() {
        Object r0 = CollectionsKt.firstOrNull(com.bytedance.commerce.base.view.b.a(this));
        if ((r0 instanceof ij2.a) == true) goto L6;
        r0 = null;
    L6:
        return (ij2.a) r0;
    }

    @Override // ij2.b
    public final void hide() {
        if (getVisibility() == 8) goto L6;
        setVisibility(8);
        return;
    }

    @Override // ij2.b
    public final void show() {
        if (getVisibility() == 0) goto L6;
        setVisibility(0);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ij2.b
    public final void a(ij2.a r4) {
        Intrinsics.checkNotNullParameter(r4, "widget");
        if ((r4 instanceof View) == false) goto L6;
        addView((View) r4, new ViewGroup.LayoutParams(-1, -2));
        return;
    }

    public ListItemInfoWidgetContainer(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ ListItemInfoWidgetContainer(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
