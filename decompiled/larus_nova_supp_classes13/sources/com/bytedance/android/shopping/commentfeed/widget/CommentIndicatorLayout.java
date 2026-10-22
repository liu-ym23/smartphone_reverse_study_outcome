package com.bytedance.android.shopping.commentfeed.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import bc3.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B'\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/shopping/commentfeed/widget/CommentIndicatorLayout;", "Landroid/widget/LinearLayout;", "Lbc3/d;", "", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommentIndicatorLayout extends LinearLayout implements d {
    public final List<CommentIndicatorView> a;
    public int b;
    public int c;

    public CommentIndicatorLayout(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CommentIndicatorLayout(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // bc3.d
    public final void onItemSelected(int r7) {
        Iterator r0 = ((ArrayList) this.a).iterator();
        int r2 = 0;
    L4:
        if (r0.hasNext() == false) goto L19;
        Object r3 = r0.next();
        int r4 = r2 + 1;
        if (r2 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        CommentIndicatorView r5 = (CommentIndicatorView) r3;
        if (r2 != r7) goto L15;
        int r6 = this.c;
        if (r6 <= 0) goto L14;
        if (r7 >= r6) goto L14;
        r5.setIndicatorSelected(false);
    L18:
        r2 = r4;
    L14:
        r5.setIndicatorSelected(true);
        goto L18
    L15:
        if (r2 >= r7) goto L17;
        r5.setIndicatorSelected(true);
        goto L18
    L17:
        r5.setIndicatorSelected(false);
        goto L18
    }

    public CommentIndicatorLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = new ArrayList();
        setOrientation(0);
    }

    public /* synthetic */ CommentIndicatorLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
