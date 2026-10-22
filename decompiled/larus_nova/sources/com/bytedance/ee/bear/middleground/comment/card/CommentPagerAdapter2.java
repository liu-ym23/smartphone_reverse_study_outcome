package com.bytedance.ee.bear.middleground.comment.card;

import android.app.Activity;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.bytedance.android.livesdk.livecommerce.largemode.model.LayoutSizeLargeModeConfig;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter2;
import com.bytedance.ee.bear.middleground.comment.export.CommentDiffUtils;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.ErrorBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.Reaction;
import com.bytedance.ee.bear.middleground.comment.share.SharePermissionViewModel;
import com.bytedance.ee.bear.middleground.comment.uitls.RecyclerViewScrollHelper;
import com.bytedance.ee.bear.middleground.comment.widget.NoTopFadingEdgeRecyclerView;
import com.bytedance.ee.bear.widgets.viewpager.DampLayout;
import com.bytedance.ee.bear.widgets.viewpager.VerticalPagerAdapter;
import com.bytedance.ee.bear.widgets.viewpager.VerticalViewPager;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 e2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002efB\u0007¢\u0006\u0004\b\u0004\u0010\u0005Jn\u0010:\u001a\u00020\u001d2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010;\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0018\u00101\u001a\u0014\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u001d02J\"\u0010<\u001a\u00020\u001d2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u00122\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u001e\u0010=\u001a\u00020\u001d2\u0006\u0010>\u001a\u00020 2\u0006\u0010?\u001a\u00020 2\u0006\u0010@\u001a\u00020AJ\u0019\u0010B\u001a\u0004\u0018\u00010!2\b\u0010C\u001a\u0004\u0018\u00010 H\u0016¢\u0006\u0002\u0010DJ\u0006\u0010E\u001a\u00020\u001dJ\u0006\u0010F\u001a\u00020#J\u0014\u0010G\u001a\u00020\u001d2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u000e\u0010H\u001a\u00020 2\u0006\u0010I\u001a\u00020 J\u0010\u0010J\u001a\u00020\u001d2\b\u0010K\u001a\u0004\u0018\u00010LJ\u0010\u0010M\u001a\u00020\u001d2\u0006\u0010N\u001a\u00020#H\u0016J\u0010\u0010O\u001a\u00020\u001d2\u0006\u0010N\u001a\u00020#H\u0016J\r\u0010P\u001a\u00020 H\u0016¢\u0006\u0002\u0010QJ\"\u0010R\u001a\u00020\u001d2\u0006\u0010S\u001a\u00020!2\u0006\u0010C\u001a\u00020 2\b\b\u0002\u0010N\u001a\u00020#H\u0002J.\u0010T\u001a\u00020\u001d2\f\u0010U\u001a\b\u0012\u0004\u0012\u00020V0\u00072\u0006\u0010W\u001a\u00020\u00102\u0006\u0010X\u001a\u00020 2\u0006\u0010Y\u001a\u00020\bH\u0002J\u0018\u0010Z\u001a\u00020\u00022\u0006\u0010[\u001a\u00020\\2\u0006\u0010]\u001a\u00020 H\u0017J\u0010\u0010_\u001a\u00020\u001d2\u0006\u0010`\u001a\u00020#H\u0002J\b\u0010a\u001a\u00020 H\u0016J\u0010\u0010b\u001a\u0002042\u0006\u0010C\u001a\u00020 H\u0016J\u0018\u0010c\u001a\u00020\u001d2\u0006\u0010d\u001a\u00020\u00022\u0006\u0010C\u001a\u00020 H\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010$\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010)\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010&\"\u0004\b+\u0010(R\u001a\u0010,\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R \u00101\u001a\u0014\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u001d02X\u0082.¢\u0006\u0002\n\u0000R\u001a\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u0002040\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u00105\u001a\u000204X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u000e\u0010^\u001a\u000204X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006g"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/card/CommentPagerAdapter2;", "Lcom/bytedance/ee/bear/widgets/viewpager/VerticalPagerAdapter;", "Lcom/bytedance/ee/bear/middleground/comment/card/CommentPagerAdapter2$ViewHolder;", "Lcom/bytedance/ee/bear/middleground/comment/card/ICommentPagerAdapter;", "<init>", "()V", "cards", "", "Lcom/bytedance/ee/bear/middleground/comment/export/bean/CommentBean;", "config", "Lcom/bytedance/ee/bear/middleground/comment/uitls/Config;", "activity", "Landroid/app/Activity;", "per", "Lcom/bytedance/ee/bear/middleground/comment/export/ICommentPermission;", "language", "", "userIds", "", "mIListeners", "Lcom/bytedance/ee/bear/middleground/comment/control/ICommentListeners;", "actionControl", "Lcom/bytedance/ee/bear/middleground/comment/control/ICommentFunction;", "cardDataViewModel", "Lcom/bytedance/ee/bear/middleground/comment/card/CardDataViewModel;", "sharePermissionViewModel", "Lcom/bytedance/ee/bear/middleground/comment/share/SharePermissionViewModel;", "clickLink", "Lkotlin/Function0;", "", "currentPagers", "", "", "Landroidx/recyclerview/widget/RecyclerView;", "isPortrait", "", "onResolve", "getOnResolve", "()Lkotlin/jvm/functions/Function0;", "setOnResolve", "(Lkotlin/jvm/functions/Function0;)V", "onClickEmpty", "getOnClickEmpty", "setOnClickEmpty", "banSwitch", "getBanSwitch", "()Z", "setBanSwitch", "(Z)V", "switchItem", "Lkotlin/Function2;", "commentIdToItemIdMap", "", "itemIdCounter", "getItemIdCounter", "()J", "setItemIdCounter", "(J)V", "initPage", "IListeners", "updateData", "scrollToPosition", "outPosition", "innerPosition", LayoutSizeLargeModeConfig.TYPE_PERCENTAGE, "", "getView", "position", "(Ljava/lang/Integer;)Landroidx/recyclerview/widget/RecyclerView;", "resetAllRvPadding", "onEditStatus", "reSetEditStatus", "findEditViewPosition", "currentIndex", "resetRvPosition", "vp", "Lcom/bytedance/ee/bear/widgets/viewpager/VerticalViewPager;", "notifyDataChange", "forceContentDiff", "notifyCurrentPosDataChange", "getCurrentPos", "()Ljava/lang/Integer;", "notifyItemPageDataChanged", "recyclerView", "addQueteHead", "commentList", "Lcom/bytedance/ee/bear/middleground/comment/export/bean/CommentBean$CommentDetail;", "commentId", "commentType", "commentBean", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "lastToastTime", "toastNoMoreComment", "onTop", "getItemCount", "getItemId", "onBindViewHolder", "holder", "Companion", "ViewHolder", "middleground-comment_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommentPagerAdapter2 extends VerticalPagerAdapter<ViewHolder> implements q1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<CommentBean> f230754b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bytedance.ee.bear.middleground.comment.uitls.p f230755c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Activity f230756d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f230757e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<String> f230758f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.bytedance.ee.bear.middleground.comment.control.z f230759g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public com.bytedance.ee.bear.middleground.comment.control.y f230760h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public d f230761i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public SharePermissionViewModel f230762j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Function0<Unit> f230763k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Map<Integer, RecyclerView> f230764l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f230765m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Function0<Unit> f230766n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Function0<Unit> f230767o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f230768p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Function2<? super Integer, ? super Boolean, Unit> f230769q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Map<String, Long> f230770r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f230771s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f230772t;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/card/CommentPagerAdapter2$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "<init>", "(Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;)V", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "middleground-comment_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final RecyclerView f230773a;

        public ViewHolder(DampLayout r100, NoTopFadingEdgeRecyclerView r101) {
            Intrinsics.checkNotNullParameter(r100, "view");
            Intrinsics.checkNotNullParameter(r101, "recyclerView");
            super(r100);
            this.f230773a = r101;
        }
    }

    public static final class a {
    }

    static {
    }

    public final void A2() {
        Iterator r100 = ((LinkedHashMap) this.f230764l).values().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((RecyclerView) r100.next()).setPadding(0, 0, 0, 0);
        goto L4
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.q1
    public final Integer E() {
        VerticalViewPager r100 = this.f240421a;
        if (r100 == null) goto L5;
        int r101 = r100.getCurrentItem();
    L7:
        return Integer.valueOf(r101);
    L5:
        r101 = 0;
        goto L7
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        List<CommentBean> r100 = this.f230754b;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.size();
    }

    public CommentPagerAdapter2() {
        this.f230764l = new LinkedHashMap();
        this.f230765m = true;
        this.f230770r = new LinkedHashMap();
        setHasStableIds(true);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.q1
    public final RecyclerView P0(Integer r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return (RecyclerView) ((LinkedHashMap) this.f230764l).get(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final long getItemId(int r100) {
        List<CommentBean> r101 = this.f230754b;
        if (r101 == null) goto L7;
        CommentBean r102 = (CommentBean) ListProtector.get(r101, r100);
        if (r102 == null) goto L7;
        String r103 = r102.getComment_id();
    L8:
        if (r103 != null) goto L10;
    L21:
        tt5.a.d(CardAdapter2.TAG, "commentId is empty!");
        return -1;
    L10:
        if (r103.length() != 0) goto L12;
        boolean r104 = true;
    L13:
        if (r104 == true) goto L21;
        if (this.f230770r.containsKey(r103) == false) goto L18;
        Long r105 = (Long) ((LinkedHashMap) this.f230770r).get(r103);
    L19:
        Intrinsics.checkNotNull(r105);
        return r105.longValue();
    L18:
        long r106 = this.f230771s;
        this.f230771s = 1 + r106;
        Long r107 = Long.valueOf(r106);
        this.f230770r.put(r103, r107);
        r105 = Long.valueOf(r106);
        goto L19
    L12:
        r104 = false;
    L7:
        r103 = null;
        goto L8
    }

    public static final void y2(CommentPagerAdapter2 r100, boolean r101) {
        r100.getClass();
        if ((System.currentTimeMillis() - r100.f230772t) <= 2000) goto L12;
        r100.f230772t = System.currentTimeMillis();
        Activity r102 = r100.f230756d;
        if (r102 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("activity");
        r102 = null;
    L7:
        if (r101 == false) goto L9;
        int r103 = R.string.Doc_Comment_IsFirstComment;
    L10:
        Toast.showText(r102, r103);
        return;
    L9:
        r103 = R.string.Doc_Comment_NoMoreComments;
        goto L10
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        ViewHolder r102 = (ViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        ((LinkedHashMap) this.f230764l).values().remove(r102.f230773a);
        Integer r103 = Integer.valueOf(r101);
        this.f230764l.put(r103, r102.f230773a);
        z2(r102.f230773a, r101, false);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r210, int r211) {
        Intrinsics.checkNotNullParameter(r210, "parent");
        Activity r100 = this.f230756d;
        com.bytedance.ee.bear.middleground.comment.uitls.p r101 = null;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("activity");
        r100 = null;
    L5:
        NoTopFadingEdgeRecyclerView r102 = new NoTopFadingEdgeRecyclerView(r100);
        r102.f448123h = false;
        final Activity r103 = this.f230756d;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("activity");
        r103 = null;
    L8:
        r102.setLayoutManager(new AnonymousClass1(r103));
        r102.setOverScrollMode(2);
        com.bytedance.ee.bear.middleground.comment.uitls.p r104 = this.f230755c;
        if (r104 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("config");
        com.bytedance.ee.bear.middleground.comment.uitls.p r110 = null;
    L12:
        List<String> r105 = this.f230758f;
        if (r105 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("userIds");
        List<String> r111 = null;
    L16:
        com.bytedance.ee.bear.middleground.comment.control.z r106 = this.f230759g;
        if (r106 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mIListeners");
        com.bytedance.ee.bear.middleground.comment.control.z r112 = null;
    L20:
        com.bytedance.ee.bear.middleground.comment.control.y r107 = this.f230760h;
        if (r107 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("actionControl");
        com.bytedance.ee.bear.middleground.comment.control.y r113 = null;
    L24:
        SharePermissionViewModel r108 = this.f230762j;
        if (r108 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("sharePermissionViewModel");
        SharePermissionViewModel r114 = null;
    L28:
        d r109 = this.f230761i;
        if (r109 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("cardDataViewModel");
        d r115 = null;
    L32:
        String r116 = this.f230757e;
        if (r116 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("language");
        String r117 = null;
    L36:
        Function0<Unit> r118 = this.f230763k;
        if (r118 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("clickLink");
        Function0<Unit> r119 = null;
    L40:
        r102.setAdapter(new CardAdapter2(r110, r111, r112, r113, r114, r115, r117, r119));
        r102.setTouchViewListener(new g(this));
        Ref.FloatRef r120 = new Ref.FloatRef();
        Ref.FloatRef r121 = new Ref.FloatRef();
        Ref.LongRef r122 = new Ref.LongRef();
        r102.setVerticalFadingEdgeEnabled(true);
        r102.setFadingEdgeLength(com.bytedance.ee.util.ui.n.d(16));
        r102.setOnTouchListener(new h(r122, r120, r121, r102, this));
        if ((r102.getItemAnimator() instanceof SimpleItemAnimator) == false) goto L43;
        RecyclerView.ItemAnimator r123 = r102.getItemAnimator();
        Intrinsics.checkNotNull(r123, "null cannot be cast to non-null type androidx.recyclerview.widget.SimpleItemAnimator");
        ((SimpleItemAnimator) r123).setSupportsChangeAnimations(false);
    L43:
        r102.setItemAnimator(null);
        r102.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r102.addOnScrollListener(new AnonymousClass4(this));
        VerticalViewPager r124 = this.f240421a;
        if (r124 == null) goto L46;
        r124.setUserInputEnabled(false);
    L46:
        Activity r125 = this.f230756d;
        if (r125 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("activity");
        r125 = null;
    L49:
        DampLayout r126 = new DampLayout(r125);
        r126.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r126.setOnHeaderOrFooterListener(new i(this));
        r126.addView(r102);
        ConstraintLayout.LayoutParams r127 = new ConstraintLayout.LayoutParams(-1, r126.f240354a);
        r127.bottomToTop = 0;
        r126.addView(r126.f240356c, r127);
        ConstraintLayout.LayoutParams r128 = new ConstraintLayout.LayoutParams(-1, r126.f240354a);
        r128.topToBottom = 0;
        r126.addView(r126.f240357d, r128);
        com.bytedance.ee.bear.middleground.comment.uitls.p r129 = this.f230755c;
        if (r129 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("config");
    L53:
        r101.N.a(new ef5.z(r102));
        return new ViewHolder(r126, r102);
    L52:
        r101 = r129;
        goto L53
    L39:
        r119 = r118;
        goto L40
    L35:
        r117 = r116;
        goto L36
    L31:
        r115 = r109;
        goto L32
    L27:
        r114 = r108;
        goto L28
    L23:
        r113 = r107;
        goto L24
    L19:
        r112 = r106;
        goto L20
    L15:
        r111 = r105;
        goto L16
    L11:
        r110 = r104;
        goto L12
    }

    public final void B2(int r100, int r101, float r102) {
        RecyclerView r103 = (RecyclerView) ((LinkedHashMap) this.f230764l).get(Integer.valueOf(r100));
        com.bytedance.ee.bear.middleground.comment.uitls.p r104 = null;
        if (r103 == null) goto L5;
        RecyclerView.Adapter r105 = r103.getAdapter();
    L7:
        if ((r105 instanceof CardAdapter2) == false) goto L9;
        CardAdapter2 r106 = (CardAdapter2) r105;
    L10:
        if (r106 != null) goto L13;
        return;
    L13:
        if (r102 >= 0.0f) goto L16;
        r102 = 0.0f;
    L18:
        com.bytedance.ee.bear.middleground.comment.uitls.p r107 = this.f230755c;
        if (r107 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("config");
    L22:
        RecyclerViewScrollHelper.SetSmoothScroller r108 = new RecyclerViewScrollHelper.SetSmoothScroller(r104.getActivity());
        r108.setTargetPosition(r101);
        r108.f232188a = -1;
        if (r102 >= 0.0f) goto L25;
    L28:
        r108.f232189b = -r106.getHeightFromTop();
        RecyclerViewScrollHelper.b(P0(Integer.valueOf(r100)), r108);
        return;
    L25:
        if (r102 > 1.0f) goto L28;
        r108.f232191d = r102;
        goto L28
    L21:
        r104 = r107;
        goto L22
    L16:
        if (r102 <= 1.0f) goto L18;
        r102 = 1.0f;
        goto L18
    L9:
        r106 = null;
        goto L10
    L5:
        r105 = null;
        goto L7
    }

    public final void z2(RecyclerView r110, int r111, boolean r112) {
        tt5.a.b("Comment#CommentPagerAdapter2", "notifyItemPageDataChanged: position = " + r111);
        RecyclerView.Adapter r100 = r110.getAdapter();
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter2");
        CardAdapter2 r101 = (CardAdapter2) r100;
        List<CommentBean> r102 = this.f230754b;
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.collections.List<com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean>");
        CommentBean r103 = (CommentBean) ListProtector.get(r102, r111);
        List<CommentBean.CommentDetail> r104 = r103.getComment_list();
        List<CommentBean.CommentDetail> r105 = r104;
        if (r104 != null) goto L5;
        r105 = new ArrayList();
    L5:
        boolean r113 = true;
        List<CommentBean.CommentDetail> r106 = r105;
        if (r103.getCommentType() != 1) goto L16;
        ArrayList r107 = new ArrayList();
        CommentBean.CommentDetail r108 = new CommentBean.CommentDetail();
        r108.setReaction(r103.getReactionList());
        r108.setCommentType(r103.getCommentType());
        r108.setReplyType(1);
        r108.setComment_id(r103.getComment_id());
        r108.setReply_id("fake_reply_id");
        List<Reaction> r109 = r103.getReactionList();
        if (r109 != null) goto L10;
    L12:
        boolean r114 = false;
    L13:
        if (r114 == false) goto L15;
        com.bytedance.ee.bear.middleground.comment.uitls.s.a r115 = ((com.bytedance.ee.bear.middleground.comment.export.n) org.koin.java.a.c(com.bytedance.ee.bear.middleground.comment.export.n.class, null, null, 6)).c();
        List<Reaction> r116 = r103.getReactionList();
        String r117 = ((Reaction) ListProtector.get(r103.getReactionList(), 0)).getReferType();
        String r118 = r108.getReply_id();
        r115.getClass();
        Intrinsics.checkNotNullParameter(r108, "commentDetail");
        com.bytedance.ee.bear.middleground.comment.uitls.s.c(r108, r116, r117, r118);
    L15:
        r107.add(r108);
        r103.setComment_list(r107);
        r106 = r107;
        goto L16
    L10:
        if ((!r109.isEmpty()) != true) goto L12;
        r114 = true;
    L16:
        com.bytedance.ee.bear.middleground.comment.uitls.p r119 = this.f230755c;
        if (r119 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("config");
        r119 = null;
    L19:
        r119.N.a(new ef5.a(r103));
        if ((!r106.isEmpty()) == false) goto L33;
        if (((CommentBean.CommentDetail) ListProtector.get(r106, 0)).getReplyType() < 0) goto L33;
        String r120 = ((CommentBean.CommentDetail) ListProtector.get(r106, 0)).getComment_id();
        int r121 = ((CommentBean.CommentDetail) ListProtector.get(r106, 0)).getCommentType();
        CommentBean.CommentDetail r122 = new CommentBean.CommentDetail();
        r122.setComment_id(r120);
        r122.setReply_id("fake_reply_id_top_placeholder");
        r122.setCommentType(r121);
        r122.setReplyType(-2);
        CommentBean.CommentDetail r123 = (CommentBean.CommentDetail) CollectionsKt.firstOrNull(r106);
        if (r123 == null) goto L26;
        ErrorBean r124 = r123.getError();
    L27:
        r122.setError(r124);
        CommentBean.CommentDetail r125 = new CommentBean.CommentDetail();
        r125.setComment_id(r120);
        r125.setReply_id(r103.getQuote() + r103.isUnSubmitComment());
        r125.setContent(r103.getQuote());
        r125.setCommentType(r121);
        r125.setUser_id(r103.getUserId());
        r125.setReplyType(-1);
        CommentBean.CommentDetail r126 = (CommentBean.CommentDetail) CollectionsKt.firstOrNull(r106);
        if (r126 == null) goto L30;
        ErrorBean r127 = r126.getError();
    L31:
        r125.setError(r127);
        CommentBean.CommentDetail r128 = new CommentBean.CommentDetail();
        r128.setComment_id(r120);
        r128.setReply_id("fake_reply_id_bottom_placeholder");
        r128.setCommentType(r121);
        r128.setReplyType(-3);
        ListProtector.add(r106, 0, r122);
        ListProtector.add(r106, 1, r125);
        r106.add(r128);
    L37:
        List<CommentBean.CommentDetail> r129 = r101.getCommentDetails();
        r101.setQuote(r103.getQuote());
        r101.setParentToken(r103.getParentToken());
        r101.setParentType(r103.getParentType());
        r101.setPosition(r103.getPosition());
        r101.setBizParams(r103.getBizParams());
        r101.setOnResolve(this.f230766n);
        r101.setOnClickEmpty(this.f230767o);
        if (TextUtils.isEmpty(r103.getCurrentReplyId()) == true) goto L43;
        d r130 = this.f230761i;
        if (r130 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("cardDataViewModel");
        r130 = null;
    L42:
        r130.f230967i = r103.getCurrentReplyId();
    L43:
        com.bytedance.ee.bear.middleground.comment.uitls.p r131 = this.f230755c;
        if (r131 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("config");
        r131 = null;
    L47:
        if (r131.getActivity().getResources().getConfiguration().orientation == 2) goto L49;
        boolean r132 = true;
    L50:
        int r133 = CommentDiffUtils.f231330a;
        com.bytedance.ee.bear.middleground.comment.uitls.p r134 = this.f230755c;
        if (r134 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("config");
        r134 = null;
    L54:
        if (this.f230765m == r132) goto L56;
        boolean r135 = true;
    L57:
        String r136 = r103.getCurrentReplyId();
        if (r136 != null) goto L60;
        r136 = "";
    L60:
        String r137 = r136;
        com.bytedance.ee.bear.middleground.comment.uitls.p r138 = this.f230755c;
        if (r138 != null) goto L63;
        Intrinsics.throwUninitializedPropertyAccessException("config");
        r138 = null;
    L63:
        CommentDiffUtils.a(r101, r134, r103, r112, r135, r137, r138.f232227e0);
        r101.setCardPos(r111);
        com.bytedance.ee.bear.middleground.comment.uitls.p r139 = this.f230755c;
        if (r139 != null) goto L67;
        Intrinsics.throwUninitializedPropertyAccessException("config");
        r139 = null;
    L67:
        if (r139.getActivity().getResources().getConfiguration().orientation != 2) goto L70;
        r113 = false;
    L70:
        this.f230765m = r113;
        com.bytedance.ee.bear.middleground.comment.uitls.p r140 = this.f230755c;
        if (r140 != null) goto L73;
        Intrinsics.throwUninitializedPropertyAccessException("config");
        r140 = null;
    L73:
        r140.N.a(new ef5.x(r110, r103, r129));
        return;
    L56:
        r135 = false;
        goto L57
    L49:
        r132 = false;
        goto L50
    L30:
        r127 = null;
        goto L31
    L26:
        r124 = null;
    L33:
        if (r106.size() <= 2) goto L37;
        if (((CommentBean.CommentDetail) ListProtector.get(r106, 0)).getReplyType() >= 0) goto L37;
        ((CommentBean.CommentDetail) ListProtector.get(r106, 1)).setComment_id(((CommentBean.CommentDetail) ListProtector.get(r106, 0)).getComment_id());
        ((CommentBean.CommentDetail) ListProtector.get(r106, 1)).setReply_id(r103.getQuote() + r103.isUnSubmitComment());
        ((CommentBean.CommentDetail) ListProtector.get(r106, 1)).setContent(r103.getQuote());
        ((CommentBean.CommentDetail) ListProtector.get(r106, 1)).setCommentType(((CommentBean.CommentDetail) ListProtector.get(r106, 0)).getCommentType());
        ((CommentBean.CommentDetail) ListProtector.get(r106, 1)).setUser_id(r103.getUserId());
        ((CommentBean.CommentDetail) ListProtector.get(r106, 1)).setReplyType(-1);
        goto L37
    }
}
