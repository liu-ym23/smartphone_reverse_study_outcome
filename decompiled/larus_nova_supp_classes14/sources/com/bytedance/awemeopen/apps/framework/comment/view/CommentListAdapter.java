package com.bytedance.awemeopen.apps.framework.comment.view;

import android.content.res.Resources;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.awemeopen.apps.framework.comment.CommentPageParam;
import com.bytedance.awemeopen.apps.framework.comment.j;
import com.bytedance.awemeopen.apps.framework.comment.view.holder.BaseCommentViewHolder;
import com.bytedance.awemeopen.apps.framework.comment.view.holder.CommentReplyButtonViewHolder;
import com.bytedance.awemeopen.apps.framework.comment.view.holder.CommentReplyViewHolder;
import com.bytedance.awemeopen.apps.framework.comment.view.holder.CommentViewHolder;
import com.bytedance.awemeopen.apps.framework.framework.loadmoreadapter.BaseAdapter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import sy3.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/comment/view/CommentListAdapter;", "Lcom/bytedance/awemeopen/apps/framework/framework/loadmoreadapter/BaseAdapter;", "Lo14/a;", "a", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class CommentListAdapter extends BaseAdapter<o14.a> {
    public static final Set<Integer> r = null;
    public final j o;
    public CommentPageParam p;
    public final Lazy q;

    public static final class a {
    }

    static {
        r = SetsKt.setOf(new Integer[]{1, 2, 3, 4});
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.loadmoreadapter.RecyclerViewWithFooterAdapter
    public final int getBasicItemViewType(int r3) {
        List<T> r0 = this.l;
        Integer r1 = null;
        if (r0 == 0) goto L5;
        o14.a r4 = (o14.a) ListProtector.get(r0, r3);
    L6:
        if (r4 == null) goto L8;
        r1 = Integer.valueOf(r4.a);
    L8:
        if (r1 != null) goto L11;
    L13:
        if (r1 != null) goto L16;
    L18:
        if (r1 != null) goto L21;
    L23:
        return 0;
    L21:
        if (r1.intValue() != 11) goto L23;
        return 11;
    L16:
        if (r1.intValue() != 1) goto L18;
        return 1;
    L11:
        if (r1.intValue() != 2) goto L13;
        return 2;
    L5:
        r4 = null;
        goto L6
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.loadmoreadapter.LoadMoreRecyclerViewAdapter, com.bytedance.awemeopen.apps.framework.framework.loadmoreadapter.RecyclerViewWithFooterAdapter
    public final RecyclerView.ViewHolder onCreateFooterViewHolder(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        return super.onCreateFooterViewHolder(r2);
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.loadmoreadapter.LoadMoreRecyclerViewAdapter
    public final int z2(View r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        Resources r0 = Resources.getSystem();
        return MathKt.roundToInt(TypedValue.applyDimension(1, 45, WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics())));
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.loadmoreadapter.RecyclerViewWithFooterAdapter
    public final void onBindBasicViewHolder(RecyclerView.ViewHolder r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "holder");
        int r0 = getItemViewType(r4);
        if (r0 == 2) goto L13;
        if (r0 == 11) goto L10;
        if ((r3 instanceof CommentViewHolder) == false) goto L16;
        ((CommentViewHolder) r3).T3((o14.a) ListProtector.get(this.l, r4));
        return;
    L16:
        return;
    L10:
        if ((r3 instanceof CommentReplyButtonViewHolder) == false) goto L18;
        CommentReplyButtonViewHolder r5 = (CommentReplyButtonViewHolder) r3;
        Object r6 = ListProtector.get(this.l, r4);
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type com.bytedance.awemeopen.apps.framework.comment.data.CommentReplyButton");
        ky3.b r7 = (ky3.b) r6;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r7, "replyButton");
        r5.i = r7;
        r5.U3();
        return;
    L18:
        return;
    L13:
        if ((r3 instanceof CommentReplyViewHolder) == false) goto L20;
        ((CommentReplyViewHolder) r3).T3((o14.a) ListProtector.get(this.l, r4));
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.loadmoreadapter.RecyclerViewWithFooterAdapter
    public final RecyclerView.ViewHolder onCreateBasicViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        if (r5 == 2) goto L9;
        if (r5 == 11) goto L11;
        return new CommentViewHolder(LayoutInflater.from(r4.getContext()).inflate(2131558586, r4, false), this.o, this.p, (i) this.q.getValue());
    L11:
        return new CommentReplyButtonViewHolder(LayoutInflater.from(r4.getContext()).inflate(2131558588, r4, false), this.o, this.p);
    L9:
        return new CommentReplyViewHolder(LayoutInflater.from(r4.getContext()).inflate(2131558587, r4, false), this.o, this.p, (i) this.q.getValue());
    }

    public CommentListAdapter(j r2, CommentPageParam r3, final boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "mCallback");
        Intrinsics.checkNotNullParameter(r3, "pageParam");
        this.o = r2;
        this.p = r3;
        this.q = LazyKt.lazy(new CommentListAdapter$commentViewConfig$2(r4));
    }

    public final void C2(String r6, int r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r6, "cid");
        if (getBasicItemCount() != 0) goto L5;
        return;
    L5:
        Iterator r0 = this.l.iterator();
        int r2 = 0;
    L7:
        if (r0.hasNext() == false) goto L12;
        if (Intrinsics.areEqual(((o14.a) r0.next()).cid, r6) == true) goto L13;
        r2 = r2 + 1;
    L13:
        if (r2 == (-1)) goto L37;
        if (r8 == false) goto L33;
        o14.a r9 = (o14.a) ListProtector.get(this.l, r2);
        if (r7 != 1) goto L18;
        r9.z(1);
        r9.s(r9.d() + 1);
        r9.y(false);
    L31:
        if (r9.d() >= 0) goto L33;
        r9.s(0);
        goto L33
    L18:
        if (r7 != 2) goto L20;
        r9.z(0);
        r9.s(r9.d() - 1);
        goto L31
    L20:
        if (r7 != 3) goto L22;
        r9.y(true);
        if (r9.q() != 1) goto L31;
        r9.z(0);
        r9.s(r9.d() - 1);
        goto L31
    L22:
        if (r7 != 4) goto L31;
        r9.y(false);
    L33:
        notifyItemChanged(r2, new b(r7));
        return;
    L37:
        return;
    L12:
        r2 = -1;
        goto L13
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r6, int r7, List<?> r8) {
        Intrinsics.checkNotNullParameter(r6, "holder");
        Intrinsics.checkNotNullParameter(r8, "payloads");
        if (getItemViewType(r7) != Integer.MIN_VALUE) goto L6;
        onBindFooterViewHolder(r6);
        return;
    L6:
        if (r8.isEmpty() == false) goto L8;
        onBindBasicViewHolder(r6, r7);
        return;
    L8:
        int r0 = r8.size();
        int r1 = 0;
    L9:
        if (r1 >= r0) goto L28;
        Object r2 = ListProtector.get(r8, r1);
        if ((r2 instanceof b) == false) goto L13;
        b r3 = (b) r2;
    L14:
        if (r3 == null) goto L20;
        if ((r6 instanceof BaseCommentViewHolder) == false) goto L20;
        if (r.contains(Integer.valueOf(r3.getType())) == false) goto L20;
        ((BaseCommentViewHolder) r6).Y3((o14.a) ListProtector.get(this.l, r7), true);
    L20:
        r1 = r1 + 1;
        goto L9
    L13:
        r3 = null;
        goto L14
    }
}
