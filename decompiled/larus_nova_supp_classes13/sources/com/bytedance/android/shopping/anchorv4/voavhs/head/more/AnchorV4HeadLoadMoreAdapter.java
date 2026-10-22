package com.bytedance.android.shopping.anchorv4.voavhs.head.more;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.anchorv4.dto.base.Action;
import com.bytedance.android.shopping.anchorv4.dto.base.ImageModel;
import com.bytedance.android.shopping.anchorv4.voavhs.head.ScrollMoreText;
import com.bytedance.android.shopping.anchorv4.voavhs.head.base.d;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0003\u0004\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/head/more/AnchorV4HeadLoadMoreAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/head/more/AnchorV4HeadLoadMoreAdapter$LoadMoreViewHolder;", "ActualLoadMoreViewHolder", "EmptyLoadMoreViewHolder", "LoadMoreViewHolder", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4HeadLoadMoreAdapter extends RecyclerView.Adapter<LoadMoreViewHolder> {
    public final View a;
    public final ScrollMoreText b;
    public final d c;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/head/more/AnchorV4HeadLoadMoreAdapter$ActualLoadMoreViewHolder;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/head/more/AnchorV4HeadLoadMoreAdapter$LoadMoreViewHolder;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ActualLoadMoreViewHolder extends LoadMoreViewHolder {
        public final View a;

        public ActualLoadMoreViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "loadMoreView");
            super(r2);
            this.a = r2;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/head/more/AnchorV4HeadLoadMoreAdapter$EmptyLoadMoreViewHolder;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/head/more/AnchorV4HeadLoadMoreAdapter$LoadMoreViewHolder;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class EmptyLoadMoreViewHolder extends LoadMoreViewHolder {
        public final View a;

        public EmptyLoadMoreViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "headViewHolder");
            super(r2);
            this.a = r2;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/head/more/AnchorV4HeadLoadMoreAdapter$LoadMoreViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static class LoadMoreViewHolder extends RecyclerView.ViewHolder {
        public LoadMoreViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
        }
    }

    public final int getItemCount() {
        return 2;
    }

    public final int getItemViewType(int r1) {
        if (r1 != 0) goto L4;
        return 0;
    L4:
        return 1;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r4, int r5) {
        LoadMoreViewHolder r6 = (LoadMoreViewHolder) r4;
        Intrinsics.checkNotNullParameter(r6, "holder");
        if ((r6 instanceof ActualLoadMoreViewHolder) == false) goto L36;
        Action r7 = this.b.getAction();
        if (r7 == null) goto L7;
        String r8 = r7.getId();
    L9:
        if (r8 == null) goto L30;
        int r1 = r8.hashCode();
        if (r1 == (-1644511110)) goto L24;
        if (r1 != (-1449688354)) goto L30;
        if (r8.equals("action_head_view_open_store_page") == false) goto L30;
        d r9 = this.c;
        if (r9 == null) goto L37;
        c63.d r10 = r9.t();
        if (r10 == null) goto L38;
        r10.C();
        return;
    L38:
        return;
    L37:
        return;
    L24:
        if (r8.equals("action_find_same_goods") == false) goto L30;
        d r11 = this.c;
        if (r11 == null) goto L40;
        c63.d r12 = r11.t();
        if (r12 == null) goto L41;
        r12.G(2, null, this.b.getFindSameType());
        return;
    L41:
        return;
    L40:
        return;
    L30:
        d r13 = this.c;
        if (r13 == null) goto L43;
        c63.d r14 = r13.t();
        if (r14 == null) goto L44;
        r14.G(2, null, this.b.getFindSameType());
        return;
    L44:
        return;
    L43:
        return;
    L7:
        r8 = null;
        goto L9
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "parent");
        ECUrlModel r1 = null;
        if (r6 != 0) goto L14;
        View r7 = th.a.d(r5.getContext(), 2131560487, r5, 4);
        if (this.a.getParent() == null) goto L13;
        ECUrlModel r8 = this.a.getParent();
        if ((r8 instanceof ViewGroup) == false) goto L10;
        r1 = r8;
    L10:
        ViewGroup r2 = (ViewGroup) r1;
        if (r2 == null) goto L13;
        r2.removeView(this.a);
    L13:
        ((ViewGroup) r7.findViewById(2131374441)).addView(this.a);
        Unit r9 = Unit.INSTANCE;
        return new EmptyLoadMoreViewHolder(r7);
    L14:
        View r10 = th.a.d(r5.getContext(), 2131560499, r5, 4);
        View r11 = (View) CollectionsKt.firstOrNull(com.bytedance.commerce.base.view.b.a(r10));
        if (r11 == null) goto L50;
        ViewGroup.LayoutParams r0 = r11.getLayoutParams();
        int r3 = -2;
        if (r0 == null) goto L26;
        ImageModel r4 = this.b.getIcon();
        if (r4 == null) goto L24;
        ECUrlModel r12 = r4.getRemote();
        if (r12 == null) goto L24;
        int r13 = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r12.getWidth()));
    L25:
        r0.width = r13;
    L24:
        r13 = -2;
    L26:
        ViewGroup.LayoutParams r14 = r11.getLayoutParams();
        if (r14 == null) goto L35;
        ImageModel r15 = this.b.getIcon();
        if (r15 == null) goto L33;
        ECUrlModel r16 = r15.getRemote();
        if (r16 == null) goto L33;
        int r17 = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r16.getHeight()));
    L34:
        r14.height = r17;
    L33:
        r17 = -2;
    L35:
        ImageModel r18 = this.b.getIcon();
        if (r18 == null) goto L38;
        r1 = r18.getRemote();
    L38:
        ImageModel r19 = this.b.getIcon();
        if (r19 == null) goto L43;
        ECUrlModel r20 = r19.getRemote();
        if (r20 == null) goto L43;
        int r21 = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r20.getWidth()));
    L44:
        ImageModel r22 = this.b.getIcon();
        if (r22 == null) goto L49;
        ECUrlModel r23 = r22.getRemote();
        if (r23 == null) goto L49;
        r3 = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r23.getHeight()));
    L49:
        y.l(r1, r21, r3, new b(r10, r11));
    L43:
        r21 = -2;
    L50:
        Unit r24 = Unit.INSTANCE;
        return new ActualLoadMoreViewHolder(r10);
    }

    public AnchorV4HeadLoadMoreAdapter(View r2, ScrollMoreText r3, d r4) {
        Intrinsics.checkNotNullParameter(r2, "headView");
        Intrinsics.checkNotNullParameter(r3, "scrollMoreText");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
