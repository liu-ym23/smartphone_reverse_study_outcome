package com.larus.bmhome.double_post.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.chat.markdown.ugc.h;
import com.larus.bmhome.chat.q4;
import com.larus.bmhome.databinding.LarusCardAwemeRecommendEmptyBinding;
import com.larus.bmhome.databinding.LarusCardAwemeRecommendMixedEmptyBinding;
import com.larus.bmhome.double_post.viewholder.AwemeRecommendContentViewHolder;
import com.larus.bmhome.double_post.viewholder.AwemeRecommendEmptyViewHolder;
import com.larus.bmhome.double_post.viewholder.AwemeRecommendLoadMoreItemViewHolder;
import com.larus.bmhome.double_post.viewholder.AwemeRecommendMixedEmptyViewHolder;
import com.larus.bmhome.searchmixedmedia.SearchMixedMediaItemView;
import com.larus.bmhome.video.Content;
import com.larus.bmhome.video.ItemType;
import com.larus.common_res.common_ui.databinding.LarusItemAwemeLoadMoreBinding;
import com.larus.common_ui.paging.FPagingAdapter;
import com.larus.common_ui.venus.ShapeConstraintLayout;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import ip8.b;
import ip8.d;
import ip8.e;
import ip8.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 ;2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001;BC\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\r¢\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u001f\u001a\u00020\u000f2\b\u0010 \u001a\u0004\u0018\u00010\u001eH\u0016J\u0016\u0010!\u001a\u00020\u000f2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00020#H\u0016J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\bH\u0016J \u0010'\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\bH\u0016J\u0018\u0010*\u001a\u00020\u00032\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\bH\u0016J\u0010\u0010.\u001a\u00020\b2\u0006\u0010&\u001a\u00020\bH\u0016J\b\u0010/\u001a\u00020\u000fH\u0016J\u0016\u00100\u001a\u00020\u000b2\u000e\u00101\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010#J\u0010\u00102\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020\u0002H\u0002J\u0006\u00103\u001a\u00020\u000fJ\u0006\u00104\u001a\u00020\u000fJ\u0006\u00105\u001a\u00020\u000fJ\u0006\u00106\u001a\u00020\u000fJ\u0006\u00107\u001a\u00020\u000bJ\u0006\u00108\u001a\u00020\u000bJ\u0006\u00109\u001a\u00020\u000bJ\u000e\u0010:\u001a\u00020\b2\u0006\u0010)\u001a\u00020\u0002R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\t\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0018\u001a\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001aR\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/larus/bmhome/double_post/adapter/AwemeRecommendAdapter;", "Lcom/larus/common_ui/paging/FPagingAdapter;", "Lcom/larus/bmhome/video/Content;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/larus/bmhome/double_post/adapter/IAwemeRecommentAdapter;", "config", "Lcom/larus/common_ui/paging/FPagingAdapter$Config;", "coverWidth", "", "loadingSpaceHeight", "isMixedWithText", "", "viewCreateCallback", "Lkotlin/Function1;", "Lcom/larus/bmhome/double_post/viewholder/AwemeRecommendContentViewHolder;", "", "<init>", "(Lcom/larus/common_ui/paging/FPagingAdapter$Config;IIZLkotlin/jvm/functions/Function1;)V", "getCoverWidth", "()I", "setCoverWidth", "(I)V", "getLoadingSpaceHeight", "setLoadingSpaceHeight", "loadMoreItem", "getLoadMoreItem", "()Lcom/larus/bmhome/video/Content;", "loadMoreItem$delegate", "Lkotlin/Lazy;", "viewHolderAction", "Lcom/larus/bmhome/double_post/adapter/AwemeRecommendViewHolderAction;", "setViewHolderAction", "action", "refreshDataForContent", "content", "", "getItemId", "", "position", "onBindViewHolder", "holder", "data", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "getItemViewType", "distinctDatas", "isLoadMoreAllRepeatContent", "newData", "isDistinctItemType", "loadMoreFail", "addLoadMoreItem", "removeLoadMoreItem", "loadMoreEmpty", "isLoadMoreItemShow", "isLoadMoreErrorItemShow", "isLoadMoreEmptyItemShow", "findDataIndex", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AwemeRecommendAdapter extends FPagingAdapter<Content, RecyclerView.ViewHolder> implements g {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f311397l = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f311398f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f311399g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f311400h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Function1<AwemeRecommendContentViewHolder, Unit> f311401i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f311402j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public e f311403k;

    public static final class a {
    }

    static {
    }

    public AwemeRecommendAdapter() {
        throw null;
    }

    public final Content J2() {
        return (Content) this.f311402j.getValue();
    }

    @Override // com.larus.common_ui.paging.FPagingAdapter
    public final void z2() {
        if (((ArrayList) this.f327606b).isEmpty() == false) goto L5;
        return;
    L5:
        ArrayList r100 = new ArrayList();
        LinkedHashSet r101 = new LinkedHashSet();
        Iterator r102 = ((ArrayList) this.f327606b).iterator();
    L7:
        if (r102.hasNext() == false) goto L20;
        Content r103 = (Content) r102.next();
        if ((!CollectionsKt.contains((List) d.f495312a.getValue(), r103.getItemType())) == true) goto L10;
        r100.add(r103);
        goto L7
    L10:
        String r104 = r103.getItemId();
        if (r104 != null) goto L14;
        r104 = "";
    L14:
        if (o0.d(r104) == false) goto L18;
        if (r101.add(r104) == false) goto L18;
        r100.add(r103);
    L18:
        FLogger.f375446a.i("AwemeRecommendAdapter", "distinctDatas: itemId(" + r104 + ") is repeated, requestId(" + r103.getRequestId() + "))");
        goto L7
    L20:
        ((ArrayList) this.f327606b).clear();
        ((ArrayList) this.f327606b).addAll(r100);
    }

    public final void H2() {
        boolean r100 = M2();
        Map<String, String> r101 = J2().getClientExt();
        if (r101 == null) goto L5;
        r101.put("load_more_status", "3");
    L5:
        if (r100 == true) goto L7;
        y2(CollectionsKt.listOf(J2()));
        return;
    L7:
        notifyItemChanged(getItemCount() - 1);
    }

    public final boolean K2() {
        if (M2() == false) goto L11;
        Map<String, String> r100 = J2().getClientExt();
        if (r100 == null) goto L7;
        String r101 = r100.get("load_more_status");
    L9:
        if (Intrinsics.areEqual(r101, "2") == false) goto L11;
        return true;
    L7:
        r101 = null;
    L11:
        return false;
    }

    public final boolean L2() {
        if (M2() == false) goto L11;
        Map<String, String> r100 = J2().getClientExt();
        if (r100 == null) goto L7;
        String r101 = r100.get("load_more_status");
    L9:
        if (Intrinsics.areEqual(r101, "1") == false) goto L11;
        return true;
    L7:
        r101 = null;
    L11:
        return false;
    }

    public final boolean M2() {
        return Intrinsics.areEqual(A2(getItemCount() - 1), J2());
    }

    public final void O2() {
        boolean r100 = M2();
        Map<String, String> r101 = J2().getClientExt();
        if (r101 == null) goto L5;
        r101.put("load_more_status", "2");
    L5:
        if (r100 == false) goto L7;
        notifyItemChanged(getItemCount() - 1);
        return;
    L7:
        y2(CollectionsKt.listOf(J2()));
    }

    public final void P2() {
        if (M2() == false) goto L9;
        Map<String, String> r100 = J2().getClientExt();
        if (r100 == null) goto L7;
        r100.put("load_more_status", "2");
    L7:
        F2(getItemCount() - 1);
        return;
    }

    public final void loadMoreFail() {
        if (M2() == false) goto L8;
        Map<String, String> r100 = J2().getClientExt();
        if (r100 == null) goto L7;
        r100.put("load_more_status", "1");
    L7:
        notifyItemChanged(getItemCount() - 1);
        return;
    L8:
        Map<String, String> r101 = J2().getClientExt();
        if (r101 == null) goto L11;
        r101.put("load_more_status", "1");
    L11:
        y2(CollectionsKt.listOf(J2()));
    }

    public final int I2(Content r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Iterator r101 = ((ArrayList) this.f327606b).iterator();
        int r102 = 0;
    L4:
        if (r101.hasNext() == false) goto L9;
        if (Intrinsics.areEqual(((Content) r101.next()).getItemId(), r100.getItemId()) == true) goto L13;
        r102 = r102 + 1;
        goto L4
    L13:
        return r102;
    L9:
        return -1;
    }

    @Override // ip8.g
    public final void N0(List<Content> r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
        E2(r100);
    }

    @Override // ip8.g
    public final void W1(h r100) {
        this.f311403k = r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final long getItemId(int r100) {
        Content r101 = A2(r100);
        if (r101 == null) goto L8;
        String r102 = r101.getItemId();
        if (r102 == null) goto L8;
        return r102.hashCode();
    L8:
        return super.getItemId(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        Content r101 = A2(r100);
        if (r101 == null) goto L8;
        Integer r102 = r101.getItemType();
        if (r102 == null) goto L8;
        return r102.intValue();
    L8:
        return ItemType.UNDEFINED.getValue();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        LayoutInflater r102 = LayoutInflater.from(r100.getContext());
        if (r101 != ItemType.VIDEO.getValue()) goto L5;
    L30:
        RecyclerView.ViewHolder r103 = new AwemeRecommendContentViewHolder(new SearchMixedMediaItemView(r100.getContext(), null));
        Function1<AwemeRecommendContentViewHolder, Unit> r104 = this.f311401i;
        if (r104 == null) goto L34;
        r104.invoke((AwemeRecommendContentViewHolder) r103);
    L34:
        return r103;
    L5:
        if (r101 == ItemType.ARTICLE.getValue()) goto L30;
        if (r101 != ItemType.LOAD_MORE.getValue()) goto L19;
        View r105 = r102.inflate(R.layout.larus_item_aweme_load_more, r100, false);
        int r106 = R.id.error_lay;
        LinearLayout r107 = (LinearLayout) ViewBindings.findChildViewById(r105, R.id.error_lay);
        if (r107 == null) goto L17;
        r106 = R.id.loading;
        ProgressBar r108 = (ProgressBar) ViewBindings.findChildViewById(r105, R.id.loading);
        if (r108 == null) goto L17;
        r106 = R.id.space;
        View r109 = ViewBindings.findChildViewById(r105, R.id.space);
        if (r109 == null) goto L17;
        return new AwemeRecommendLoadMoreItemViewHolder(new LarusItemAwemeLoadMoreBinding((LinearLayout) r105, r107, r108, r109), this.f311399g);
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r105.getResources().getResourceName(r106)));
    L19:
        if (this.f311400h == false) goto L25;
        View r110 = r102.inflate(R.layout.larus_card_aweme_recommend_mixed_empty, r100, false);
        if (r110 == null) goto L24;
        r103 = new AwemeRecommendMixedEmptyViewHolder(new LarusCardAwemeRecommendMixedEmptyBinding((ShapeConstraintLayout) r110));
        goto L34
    L24:
        throw new NullPointerException("rootView");
    L25:
        View r111 = r102.inflate(R.layout.larus_card_aweme_recommend_empty, r100, false);
        if (r111 == null) goto L29;
        r103 = new AwemeRecommendEmptyViewHolder(new LarusCardAwemeRecommendEmptyBinding((ShapeConstraintLayout) r111));
        goto L34
    L29:
        throw new NullPointerException("rootView");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larus.common_ui.paging.FPagingAdapter
    public final void D2(RecyclerView.ViewHolder r100, Content r101, int r102) {
        Content r103 = r101;
        Intrinsics.checkNotNullParameter(r100, "holder");
        Intrinsics.checkNotNullParameter(r103, "data");
        if ((r100 instanceof lp8.h) == false) goto L6;
        ((lp8.h) r100).n2(r103, new b(this));
        return;
    }

    public AwemeRecommendAdapter(FPagingAdapter.a r100, int r101, boolean r102, q4 r103, int r104) {
        if ((r104 & 8) == 0) goto L6;
        r102 = false;
    L6:
        if ((r104 & 16) == 0) goto L8;
        r103 = null;
    L8:
        Intrinsics.checkNotNullParameter(r100, "config");
        super(r100);
        this.f311398f = r101;
        this.f311399g = 0;
        this.f311400h = r102;
        this.f311401i = r103;
        this.f311402j = LazyKt.lazy(new ip8.a());
    }
}
