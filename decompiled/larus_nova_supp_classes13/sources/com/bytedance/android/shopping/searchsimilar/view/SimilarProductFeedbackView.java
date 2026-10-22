package com.bytedance.android.shopping.searchsimilar.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.android.shopping.searchsimilar.adapter.SimilarProductCardAdapter;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/searchsimilar/view/SimilarProductFeedbackView;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SimilarProductFeedbackView extends LinearLayout {
    public final LinearLayout a;
    public int b;
    public SimilarProductCardAdapter c;
    public RecyclerView d;

    public SimilarProductFeedbackView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public SimilarProductFeedbackView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void a(View r3) {
        Intrinsics.checkNotNullParameter(r3, FreqActions.ACTION_VIEW);
        this.b = -1;
        RecyclerView r0 = this.d;
        if (r0 == null) goto L5;
        this.b = r0.getChildAdapterPosition(r3);
    L5:
        HashSet r4 = l63.a.a;
        int r5 = l63.a.b;
        SimilarProductCardAdapter r1 = this.c;
        if (r1 != null) goto L8;
        return;
    L8:
        if (r5 == this.b) goto L15;
        if (r5 >= 0) goto L11;
        return;
    L11:
        if (r5 >= r1.getItemCount()) goto L17;
        r1.notifyItemChanged(r5, 1);
        return;
    L17:
        return;
    }

    public final void b(boolean r2, View r3) {
        Intrinsics.checkNotNullParameter(r3, FreqActions.ACTION_VIEW);
        if (r2 == false) goto L5;
        setVisibility(0);
        a(r3);
        HashSet r4 = l63.a.a;
        l63.a.b = this.b;
        return;
    L5:
        setVisibility(8);
    }

    public SimilarProductFeedbackView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.b = -1;
        LayoutInflater.from(r2).inflate(2131560661, this);
        this.a = (LinearLayout) findViewById(2131371019);
    }

    public /* synthetic */ SimilarProductFeedbackView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
