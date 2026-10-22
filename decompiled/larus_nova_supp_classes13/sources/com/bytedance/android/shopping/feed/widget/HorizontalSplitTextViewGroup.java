package com.bytedance.android.shopping.feed.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0004\u001a\u00020\u0003H\u0004R \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00058\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/shopping/feed/widget/HorizontalSplitTextViewGroup;", "T", "Landroid/widget/LinearLayout;", "Landroid/widget/TextView;", "getServiceView", "Ljava/util/Stack;", "a", "Ljava/util/Stack;", "getPool", "()Ljava/util/Stack;", "pool", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public class HorizontalSplitTextViewGroup<T> extends LinearLayout {
    public final Stack<TextView> a;

    public HorizontalSplitTextViewGroup(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public HorizontalSplitTextViewGroup(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final TextView getServiceView() {
        if (this.a.isEmpty() == false) goto L7;
        return new TextView(getContext());
    L7:
        return this.a.pop();
    }

    public final Stack<TextView> getPool() {
        return this.a;
    }

    public void b(List<? extends T> r3) {
        Iterator<T> r4 = com.bytedance.commerce.base.view.b.a(this).iterator();
    L4:
        if (r4.hasNext() == false) goto L10;
        View r0 = (View) r4.next();
        removeView(r0);
        Stack<TextView> r1 = this.a;
        if (r0 == null) goto L9;
        r1.add((TextView) r0);
        goto L4
    L9:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    }

    public HorizontalSplitTextViewGroup(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = new Stack();
        setShowDividers(2);
        setOrientation(0);
    }

    public /* synthetic */ HorizontalSplitTextViewGroup(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
