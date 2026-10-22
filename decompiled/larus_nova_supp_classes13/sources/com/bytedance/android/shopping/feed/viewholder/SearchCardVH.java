package com.bytedance.android.shopping.feed.viewholder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.core.widget.flow.FlowLayout;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.anchorv3.repository.dto.InnerFlowPageStyleDTO;
import com.bytedance.android.shopping.anchorv3.repository.dto.PageStyle;
import com.bytedance.android.shopping.feed.adapter.ProductFeedAdapter;
import com.bytedance.android.shopping.feed.event.FeedProductEventTracker;
import com.bytedance.android.shopping.feed.event.h0;
import com.bytedance.android.shopping.feed.event.i0;
import com.bytedance.android.shopping.feed.event.q0;
import com.bytedance.android.shopping.feed.event.r0;
import com.bytedance.android.shopping.feed.resourcecard.model.SearchItem;
import com.bytedance.android.shopping.feed.view.SearchCardHashTagView;
import com.bytedance.android.shopping.feed.view.SearchCardView;
import com.bytedance.android.shopping.feed.view.SearchPictureCardView;
import com.bytedance.android.shopping.feed.view.r;
import com.bytedance.android.shopping.feed.view.s;
import com.bytedance.android.shopping.feed.view.t;
import com.bytedance.android.shopping.feed.viewmodel.ProductFeedViewModel;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.jedi.ext.adapter.JediSimpleViewHolder;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import yd3.p;
import yd3.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/feed/viewholder/SearchCardVH;", "Lcom/bytedance/jedi/ext/adapter/JediSimpleViewHolder;", "Lcom/bytedance/android/shopping/feed/adapter/ProductFeedAdapter$b;", "Lrd3/a;", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SearchCardVH extends JediSimpleViewHolder<ProductFeedAdapter.b<rd3.a>> {
    public SearchCardVH(ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r5, "viewGroup");
        super(new SearchCardView(r5.getContext(), null, 6, 0));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a4(Object r18) {
        ProductFeedAdapter.b r1 = (ProductFeedAdapter.b) r18;
        Intrinsics.checkNotNullParameter(r1, "item");
        dm.a.a("lgz_log_debug").a("SearchCardVH bind");
        View r2 = ((RecyclerView.ViewHolder) this).itemView;
        if ((r2 instanceof SearchCardView) == true) goto L5;
        r2 = null;
    L5:
        SearchCardView r3 = (SearchCardView) r2;
        int r4 = 2;
        if (r3 == null) goto L75;
        rd3.a r5 = (rd3.a) r1.b;
        if (r5 == null) goto L57;
        ProductFeedViewModel r11 = r5.c;
        if (r11 == null) goto L57;
        InnerFlowPageStyleDTO r12 = r11.getInnerFlowPageStyle();
        if (r12 == null) goto L57;
        PageStyle r13 = r12.getPageStyle();
        if (r13 == null) goto L57;
        if (r13.searchCardWithPicture() != true) goto L57;
        r3.setVisibility(0);
        p r6 = r5.i();
        if (r6 == null) goto L75;
        q r7 = r6.o();
        if (r7 == null) goto L75;
        ArrayList<SearchItem> r8 = r7.c();
        if (r8 == null) goto L75;
        Iterator<T> r9 = r8.iterator();
        int r14 = 0;
    L25:
        if (r9.hasNext() == false) goto L75;
        Object r15 = r9.next();
        int r16 = r14 + 1;
        if (r14 >= 0) goto L29;
        CollectionsKt.throwIndexOverflow();
    L29:
        SearchItem r17 = (SearchItem) r15;
        if (r3.getChildCount() >= 3) goto L56;
        if (r14 == 0) goto L37;
        if (r14 == 1) goto L36;
        if (r14 == r4) goto L35;
        SearchPictureCardView r19 = null;
    L38:
        if (r19 == null) goto L40;
        r19.setVisibility(0);
    L40:
        if (r14 <= 0) goto L48;
        if (r19 == null) goto L48;
        ViewGroup.LayoutParams r110 = r19.getLayoutParams();
        if ((r110 instanceof ViewGroup.MarginLayoutParams) == true) goto L45;
        r110 = null;
    L45:
        ViewGroup.MarginLayoutParams r111 = (ViewGroup.MarginLayoutParams) r110;
        if (r111 == null) goto L48;
        r111.leftMargin = com.bytedance.android.shopping.extensions.b.b(7);
        r19.setLayoutParams(r111);
    L48:
        String r112 = r17.getKeyword();
        ECUrlModel r113 = r17.getImg();
        if (r112 == null) goto L53;
        if (r113 == null) goto L53;
        if (r19 == null) goto L53;
        Intrinsics.checkNotNullParameter(r112, "keyword");
        Intrinsics.checkNotNullParameter(r113, "imgUrl");
        y.a(r19.a, r113);
        r19.a.setCornerRadius(com.bytedance.android.shopping.extensions.b.b(8));
        r19.a.setBorderColor(ColorProtector.parseColor("#0D161823"));
        r19.a.setBorderWidth(com.bytedance.android.shopping.extensions.b.b(Double.valueOf(0.5d)));
        r19.b.setText(r112);
    L53:
        if (r19 == null) goto L55;
        r19.setOnClickListener(new t(r17, r3, r5));
    L55:
        FeedProductEventTracker r10 = FeedProductEventTracker.a;
        Context r114 = r3.getContext();
        r10.getClass();
        FeedProductEventTracker.y(r114, r5, r17);
        goto L56
    L35:
        r19 = r3.d;
        goto L38
    L36:
        r19 = r3.c;
        goto L38
    L37:
        r19 = r3.b;
    L56:
        r14 = r16;
        r4 = 2;
    L57:
        if (r5 == null) goto L74;
        ProductFeedViewModel r20 = r5.c;
        if (r20 == null) goto L74;
        InnerFlowPageStyleDTO r21 = r20.getInnerFlowPageStyle();
        if (r21 == null) goto L74;
        PageStyle r22 = r21.getPageStyle();
        if (r22 == null) goto L74;
        if (r22.searchCardWithHashTag() != true) goto L74;
        r3.setVisibility(0);
        r3.a.removeAllViews();
        FlowLayout r23 = new SearchCardHashTagView(r3.getContext(), null, 6, 0);
        p r24 = r5.i();
        if (r24 == null) goto L73;
        q r25 = r24.o();
        if (r25 == null) goto L73;
        ArrayList<SearchItem> r26 = r25.c();
        if (r26 == null) goto L73;
        Intrinsics.checkNotNullParameter(r5, "anchorInflowFeedItem");
        Intrinsics.checkNotNullParameter(r26, "keywordList");
        r23.setMaxLine(3);
        int r27 = com.bytedance.android.shopping.extensions.b.b(8);
        int r28 = com.bytedance.android.shopping.extensions.b.b(8);
        r23.g = r27;
        r23.f = r28;
        r23.setAdapter(new r(r23, r5, r26, r26));
        r23.setOnTagClickListener(new s(r23, r26, r5));
    L73:
        ViewGroup r29 = r3.a;
        ViewGroup.MarginLayoutParams r30 = new ViewGroup.MarginLayoutParams(-1, -2);
        r30.topMargin = com.bytedance.android.shopping.extensions.b.b(10);
        Unit r31 = Unit.INSTANCE;
        r29.addView(r23, r30);
    L74:
        r3.setVisibility(8);
    L75:
        rd3.a r32 = (rd3.a) r1.b;
        if (r32 == null) goto L78;
        r32.f = getAdapterPosition();
    L78:
        FeedProductEventTracker r33 = FeedProductEventTracker.a;
        Context r34 = ((RecyclerView.ViewHolder) this).itemView.getContext();
        rd3.a r35 = (rd3.a) r1.b;
        r33.getClass();
        Single r36 = Single.fromCallable(new h0(2, r34, CollectionsKt.listOf(PdpOpenThirdParam.KEY_PRODUCT_ID), r35)).subscribeOn(Schedulers.computation()).observeOn(Schedulers.io());
        q0 r37 = q0.a;
        r0 r38 = r0.a;
        r36.subscribe(r37, r38);
        Single.fromCallable(new i0(4, r34, r35)).subscribeOn(Schedulers.computation()).observeOn(Schedulers.io()).subscribe(r37, r38);
    }
}
