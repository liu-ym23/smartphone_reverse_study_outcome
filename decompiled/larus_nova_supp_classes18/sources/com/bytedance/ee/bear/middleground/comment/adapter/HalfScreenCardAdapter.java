package com.bytedance.ee.bear.middleground.comment.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.middleground.comment.card.d;
import com.bytedance.ee.bear.middleground.comment.control.y;
import com.bytedance.ee.bear.middleground.comment.control.z;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.share.SharePermissionViewModel;
import com.bytedance.ee.bear.middleground.comment.uitls.p;
import ef5.a0;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001e\u001fBW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0006\u0012\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0018\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001aH\u0016¨\u0006 "}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/adapter/HalfScreenCardAdapter;", "Lcom/bytedance/ee/bear/middleground/comment/adapter/CardAdapter2;", "config", "Lcom/bytedance/ee/bear/middleground/comment/uitls/Config;", "userIds", "", "", "commentListeners", "Lcom/bytedance/ee/bear/middleground/comment/control/ICommentListeners;", "actionControl", "Lcom/bytedance/ee/bear/middleground/comment/control/ICommentFunction;", "sharePermissionViewModel", "Lcom/bytedance/ee/bear/middleground/comment/share/SharePermissionViewModel;", "cardDataViewModel", "Lcom/bytedance/ee/bear/middleground/comment/card/CardDataViewModel;", "language", "clickLink", "Lkotlin/Function0;", "", "<init>", "(Lcom/bytedance/ee/bear/middleground/comment/uitls/Config;Ljava/util/List;Lcom/bytedance/ee/bear/middleground/comment/control/ICommentListeners;Lcom/bytedance/ee/bear/middleground/comment/control/ICommentFunction;Lcom/bytedance/ee/bear/middleground/comment/share/SharePermissionViewModel;Lcom/bytedance/ee/bear/middleground/comment/card/CardDataViewModel;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "onCreateViewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "Companion", "ContentViewHolder", "middleground-comment_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HalfScreenCardAdapter extends CardAdapter2 {
    public static final a Companion = null;
    public static final String TAG = "HalfScreenCardAdapter";

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0019\u0010\u0007\u001a\n \b*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/adapter/HalfScreenCardAdapter$ContentViewHolder;", "Lcom/bytedance/ee/bear/middleground/comment/adapter/CardAdapter2$ContentViewHolder;", "Lcom/bytedance/ee/bear/middleground/comment/adapter/CardAdapter2;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/bytedance/ee/bear/middleground/comment/adapter/HalfScreenCardAdapter;Landroid/view/View;)V", "privateHint", "kotlin.jvm.PlatformType", "getPrivateHint", "()Landroid/view/View;", "middleground-comment_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class ContentViewHolder extends CardAdapter2.ContentViewHolder {
        public final View w;

        public static final class a implements View.OnClickListener {
            public final /* synthetic */ HalfScreenCardAdapter a;

            public a(HalfScreenCardAdapter r1) {
                this.a = r1;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r3) {
                this.a.getConfig().N.a(new a0(false));
            }
        }

        public ContentViewHolder(HalfScreenCardAdapter r2, View r3) {
            Intrinsics.checkNotNullParameter(r3, "itemView");
            super(r2, r3);
            View r4 = r3.findViewById(2131383050);
            r4.setOnClickListener(new a(r2));
            this.w = r4;
        }
    }

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter2
    public void onBindViewHolder(RecyclerView.ViewHolder r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "holder");
        super.onBindViewHolder(r3, r4);
        if ((r3 instanceof ContentViewHolder) == false) goto L17;
        View r5 = ((ContentViewHolder) r3).w;
        if (r4 != 0) goto L14;
        CommentBean.Extra r6 = getData().getExtra();
        int r0 = 0;
        if (r6 == null) goto L11;
        boolean r1 = true;
        if (r6.getVisibility() != 1) goto L11;
    L12:
        if (r1 == false) goto L14;
    L15:
        r5.setVisibility(r0);
        return;
    L11:
        r1 = false;
    L14:
        r0 = 8;
        goto L15
    }

    @Override // com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter2
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        if (r5 != CardAdapterHelper.ItemType.PART_CONTENT.getType()) goto L7;
        return new ContentViewHolder(this, LayoutInflater.from(getConfig().getActivity()).inflate(2131561511, r4, false));
    L7:
        return super.onCreateViewHolder(r4, r5);
    }

    public HalfScreenCardAdapter(p r2, List<String> r3, z r4, y r5, SharePermissionViewModel r6, d r7, String r8, Function0<Unit> r9) {
        Intrinsics.checkNotNullParameter(r2, "config");
        Intrinsics.checkNotNullParameter(r3, "userIds");
        Intrinsics.checkNotNullParameter(r4, "commentListeners");
        Intrinsics.checkNotNullParameter(r5, "actionControl");
        Intrinsics.checkNotNullParameter(r7, "cardDataViewModel");
        Intrinsics.checkNotNullParameter(r8, "language");
        super(r2, r3, r4, r5, r6, r7, r8, r9);
        tt5.a.h(TAG, "init");
    }
}
