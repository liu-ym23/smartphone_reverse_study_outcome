package com.bytedance.android.livesdk.livecommerce.promotion.card.module;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import w83.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotion/card/module/ListItemBottomCarryNewView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ListItemBottomCarryNewView extends FrameLayout {
    public Lazy<? extends i> a;
    public ll.a b;

    public ListItemBottomCarryNewView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ListItemBottomCarryNewView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void a() {
        Lazy<? extends i> r0 = this.a;
        if (r0 != null) goto L5;
    L11:
        setVisibility(8);
        return;
    L5:
        if (r0.isInitialized() != true) goto L11;
        Lazy<? extends i> r1 = this.a;
        if (r1 == null) goto L11;
        i r2 = (i) r1.getValue();
        if (r2 == null) goto L11;
        r2.b(this);
        goto L11
    }

    public final void b() {
        Lazy<? extends i> r0 = this.a;
        if (r0 != null) goto L5;
    L11:
        setVisibility(8);
        return;
    L5:
        if (r0.isInitialized() != true) goto L11;
        Lazy<? extends i> r1 = this.a;
        if (r1 == null) goto L11;
        i r2 = (i) r1.getValue();
        if (r2 == null) goto L11;
        r2.d(this);
        goto L11
    }

    public ListItemBottomCarryNewView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ ListItemBottomCarryNewView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
