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
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.cert.manager.constants.BytedCertConstant;
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

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/comment/view/CommentListAdapter;", "Lcom/bytedance/awemeopen/apps/framework/framework/loadmoreadapter/BaseAdapter;", "Lo14/a;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class CommentListAdapter extends BaseAdapter<o14.a> {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final Set<Integer> f194187r = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final j f194188o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public CommentPageParam f194189p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f194190q;

    public static final class a {
    }

    static {
        f194187r = SetsKt.setOf(new Integer[]{1, 2, 3, 4});
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.loadmoreadapter.RecyclerViewWithFooterAdapter
    public final int getBasicItemViewType(int r100) {
        List<T> r101 = this.f196963l;
        Integer r102 = null;
        if (r101 == 0) goto L5;
        o14.a r103 = (o14.a) ListProtector.get(r101, r100);
    L6:
        if (r103 == null) goto L8;
        r102 = Integer.valueOf(r103.f521700a);
    L8:
        if (r102 != null) goto L11;
    L13:
        if (r102 != null) goto L16;
    L18:
        if (r102 != null) goto L21;
    L23:
        return 0;
    L21:
        if (r102.intValue() != 11) goto L23;
        return 11;
    L16:
        if (r102.intValue() != 1) goto L18;
        return 1;
    L11:
        if (r102.intValue() != 2) goto L13;
        return 2;
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.loadmoreadapter.LoadMoreRecyclerViewAdapter, com.bytedance.awemeopen.apps.framework.framework.loadmoreadapter.RecyclerViewWithFooterAdapter
    public final RecyclerView.ViewHolder onCreateFooterViewHolder(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return super.onCreateFooterViewHolder(r100);
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.loadmoreadapter.LoadMoreRecyclerViewAdapter
    public final int z2(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Resources r101 = Resources.getSystem();
        return MathKt.roundToInt(TypedValue.applyDimension(1, 45, WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics())));
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.loadmoreadapter.RecyclerViewWithFooterAdapter
    public final void onBindBasicViewHolder(RecyclerView.ViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        int r102 = getItemViewType(r101);
        if (r102 == 2) goto L13;
        if (r102 == 11) goto L10;
        if ((r100 instanceof CommentViewHolder) == false) goto L16;
        ((CommentViewHolder) r100).T3((o14.a) ListProtector.get(this.f196963l, r101));
        return;
    L16:
        return;
    L10:
        if ((r100 instanceof CommentReplyButtonViewHolder) == false) goto L18;
        CommentReplyButtonViewHolder r103 = (CommentReplyButtonViewHolder) r100;
        Object r104 = ListProtector.get(this.f196963l, r101);
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type com.bytedance.awemeopen.apps.framework.comment.data.CommentReplyButton");
        ky3.b r105 = (ky3.b) r104;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r105, "replyButton");
        r103.f194309i = r105;
        r103.U3();
        return;
    L18:
        return;
    L13:
        if ((r100 instanceof CommentReplyViewHolder) == false) goto L20;
        ((CommentReplyViewHolder) r100).T3((o14.a) ListProtector.get(this.f196963l, r101));
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.loadmoreadapter.RecyclerViewWithFooterAdapter
    public final RecyclerView.ViewHolder onCreateBasicViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        if (r101 == 2) goto L9;
        if (r101 == 11) goto L11;
        return new CommentViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.aos_aweme_comment_item_comment, r100, false), this.f194188o, this.f194189p, (i) this.f194190q.getValue());
    L11:
        return new CommentReplyButtonViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.aos_aweme_comment_item_reply_button, r100, false), this.f194188o, this.f194189p);
    L9:
        return new CommentReplyViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.aos_aweme_comment_item_reply, r100, false), this.f194188o, this.f194189p, (i) this.f194190q.getValue());
    }

    public CommentListAdapter(j r100, CommentPageParam r101, final boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "mCallback");
        Intrinsics.checkNotNullParameter(r101, "pageParam");
        this.f194188o = r100;
        this.f194189p = r101;
        this.f194190q = LazyKt.lazy(new CommentListAdapter$commentViewConfig$2(r102));
    }

    public final void C2(String r100, int r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "cid");
        if (getBasicItemCount() != 0) goto L5;
        return;
    L5:
        Iterator r103 = this.f196963l.iterator();
        int r104 = 0;
    L7:
        if (r103.hasNext() == false) goto L12;
        if (Intrinsics.areEqual(((o14.a) r103.next()).cid, r100) == true) goto L13;
        r104 = r104 + 1;
    L13:
        if (r104 == (-1)) goto L37;
        if (r102 == false) goto L33;
        o14.a r105 = (o14.a) ListProtector.get(this.f196963l, r104);
        if (r101 != 1) goto L18;
        r105.z(1);
        r105.s(r105.d() + 1);
        r105.y(false);
    L31:
        if (r105.d() >= 0) goto L33;
        r105.s(0);
        goto L33
    L18:
        if (r101 != 2) goto L20;
        r105.z(0);
        r105.s(r105.d() - 1);
        goto L31
    L20:
        if (r101 != 3) goto L22;
        r105.y(true);
        if (r105.q() != 1) goto L31;
        r105.z(0);
        r105.s(r105.d() - 1);
        goto L31
    L22:
        if (r101 != 4) goto L31;
        r105.y(false);
    L33:
        notifyItemChanged(r104, new b(r101));
        return;
    L37:
        return;
    L12:
        r104 = -1;
        goto L13
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101, List<?> r102) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        Intrinsics.checkNotNullParameter(r102, "payloads");
        if (getItemViewType(r101) != Integer.MIN_VALUE) goto L6;
        onBindFooterViewHolder(r100);
        return;
    L6:
        if (r102.isEmpty() == false) goto L8;
        onBindBasicViewHolder(r100, r101);
        return;
    L8:
        int r103 = r102.size();
        int r104 = 0;
    L9:
        if (r104 >= r103) goto L28;
        Object r105 = ListProtector.get(r102, r104);
        if ((r105 instanceof b) == false) goto L13;
        b r106 = (b) r105;
    L14:
        if (r106 == null) goto L20;
        if ((r100 instanceof BaseCommentViewHolder) == false) goto L20;
        if (f194187r.contains(Integer.valueOf(r106.getType())) == false) goto L20;
        ((BaseCommentViewHolder) r100).Y3((o14.a) ListProtector.get(this.f196963l, r101), true);
    L20:
        r104 = r104 + 1;
        goto L9
    L13:
        r106 = null;
        goto L14
    }
}
