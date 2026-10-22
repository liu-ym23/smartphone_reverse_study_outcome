package com.bytedance.android.shopping.deepfeed;

import android.text.TextUtils;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.jedi.PullUpLoadMoreHelper;
import com.bytedance.android.ec.core.widget.LoadMoreStatusView;
import com.bytedance.android.shopping.deepfeed.ui.DeepFeedProductAdapter;
import com.bytedance.android.shopping.deepfeed.ui.DeepFeedProductRecyclerview;
import com.bytedance.android.shopping.inflow.common.base.LoadStatus;
import com.bytedance.android.shopping.jedi.LoadMoreRecyclerViewAdapter;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class j<T> implements Observer {
    public final /* synthetic */ DeepFeedProductFragment a;

    public j(DeepFeedProductFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r8) {
        LoadStatus r9 = (LoadStatus) r8;
        if (r9 == null) goto L43;
        int r10 = a.a[r9.ordinal()];
        if (r10 != 1) goto L7;
        DeepFeedProductFragment r11 = this.a;
        int r0 = DeepFeedProductFragment.k1;
        com.bytedance.android.shopping.deepfeed.event.d r12 = r11.ba0();
        int r1 = this.a.V;
        r12.getClass();
        r12.b = System.currentTimeMillis();
        r12.c = r1;
        DeepFeedProductAdapter r13 = this.a.n;
        if (r13 == null) goto L52;
        r13.showLoadMoreLoading();
        return;
    L52:
        return;
    L7:
        if (r10 != 2) goto L9;
        DeepFeedProductAdapter r14 = this.a.n;
        if (r14 == null) goto L50;
        r14.z2();
        return;
    L50:
        return;
    L9:
        if (r10 != 3) goto L11;
        DeepFeedProductFragment.S90(this.a);
        return;
    L11:
        if (r10 == 4) goto L15;
        DeepFeedProductAdapter r15 = this.a.n;
        if (r15 == null) goto L44;
        r15.resetLoadMoreState();
        return;
    L44:
        return;
    L15:
        DeepFeedProductFragment.S90(this.a);
        DeepFeedProductFragment r16 = this.a;
        DeepFeedProductRecyclerview r2 = r16.l;
        if (r2 == null) goto L46;
        DeepFeedProductAdapter r17 = r16.n;
        if (r17 == null) goto L47;
        String r3 = com.bytedance.android.shopping.extensions.j.c(2131913972);
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        LoadMoreRecyclerViewAdapter.LoadMoreViewHolder r5 = r17.q;
        if (r5 == null) goto L34;
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        LoadMoreStatusView r4 = ((RecyclerView.ViewHolder) r5).itemView;
        if (r4 == null) goto L33;
        LoadMoreStatusView r6 = r4;
        if (TextUtils.equals(r5.b.getText(), r3) == true) goto L26;
        r5.b.setText(r3);
    L26:
        r6.e();
        if (r5.a != null) goto L29;
        r5.a = new PullUpLoadMoreHelper(r2, r5.c.r);
    L29:
        PullUpLoadMoreHelper r7 = r5.a;
        if (r7 == null) goto L34;
        r7.a = true;
        goto L34
    L33:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.core.widget.LoadMoreStatusView");
    L34:
        r17.b = 2;
        return;
    L47:
        return;
    L46:
        return;
    }
}
