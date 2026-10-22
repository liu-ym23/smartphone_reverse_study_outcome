package com.bytedance.ee.bear.middleground.comment.card;

import android.app.Activity;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
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
import com.bytedance.ee.docsdk.impl.utils.keyboard.producer.BaseKeyboardHeightProducer;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.widget.recyclerview.CommonRecyclerView;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 e2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002efB\u0007¢\u0006\u0004\b\u0004\u0010\u0005Jn\u0010:\u001a\u00020\u001d2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010;\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0018\u00101\u001a\u0014\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u001d02J\"\u0010<\u001a\u00020\u001d2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u00122\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u001e\u0010=\u001a\u00020\u001d2\u0006\u0010>\u001a\u00020 2\u0006\u0010?\u001a\u00020 2\u0006\u0010@\u001a\u00020AJ\u0019\u0010B\u001a\u0004\u0018\u00010!2\b\u0010C\u001a\u0004\u0018\u00010 H\u0016¢\u0006\u0002\u0010DJ\u0006\u0010E\u001a\u00020\u001dJ\u0006\u0010F\u001a\u00020#J\u0014\u0010G\u001a\u00020\u001d2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u000e\u0010H\u001a\u00020 2\u0006\u0010I\u001a\u00020 J\u0010\u0010J\u001a\u00020\u001d2\b\u0010K\u001a\u0004\u0018\u00010LJ\u0010\u0010M\u001a\u00020\u001d2\u0006\u0010N\u001a\u00020#H\u0016J\u0010\u0010O\u001a\u00020\u001d2\u0006\u0010N\u001a\u00020#H\u0016J\r\u0010P\u001a\u00020 H\u0016¢\u0006\u0002\u0010QJ\"\u0010R\u001a\u00020\u001d2\u0006\u0010S\u001a\u00020!2\u0006\u0010C\u001a\u00020 2\b\b\u0002\u0010N\u001a\u00020#H\u0002J.\u0010T\u001a\u00020\u001d2\f\u0010U\u001a\b\u0012\u0004\u0012\u00020V0\u00072\u0006\u0010W\u001a\u00020\u00102\u0006\u0010X\u001a\u00020 2\u0006\u0010Y\u001a\u00020\bH\u0002J\u0018\u0010Z\u001a\u00020\u00022\u0006\u0010[\u001a\u00020\\2\u0006\u0010]\u001a\u00020 H\u0017J\u0010\u0010_\u001a\u00020\u001d2\u0006\u0010`\u001a\u00020#H\u0002J\b\u0010a\u001a\u00020 H\u0016J\u0010\u0010b\u001a\u0002042\u0006\u0010C\u001a\u00020 H\u0016J\u0018\u0010c\u001a\u00020\u001d2\u0006\u0010d\u001a\u00020\u00022\u0006\u0010C\u001a\u00020 H\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010$\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010)\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010&\"\u0004\b+\u0010(R\u001a\u0010,\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R \u00101\u001a\u0014\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u001d02X\u0082.¢\u0006\u0002\n\u0000R\u001a\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u0002040\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u00105\u001a\u000204X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u000e\u0010^\u001a\u000204X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006g"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/card/CommentPagerAdapter2;", "Lcom/bytedance/ee/bear/widgets/viewpager/VerticalPagerAdapter;", "Lcom/bytedance/ee/bear/middleground/comment/card/CommentPagerAdapter2$ViewHolder;", "Lcom/bytedance/ee/bear/middleground/comment/card/ICommentPagerAdapter;", "<init>", "()V", "cards", "", "Lcom/bytedance/ee/bear/middleground/comment/export/bean/CommentBean;", "config", "Lcom/bytedance/ee/bear/middleground/comment/uitls/Config;", "activity", "Landroid/app/Activity;", "per", "Lcom/bytedance/ee/bear/middleground/comment/export/ICommentPermission;", "language", "", "userIds", "", "mIListeners", "Lcom/bytedance/ee/bear/middleground/comment/control/ICommentListeners;", "actionControl", "Lcom/bytedance/ee/bear/middleground/comment/control/ICommentFunction;", "cardDataViewModel", "Lcom/bytedance/ee/bear/middleground/comment/card/CardDataViewModel;", "sharePermissionViewModel", "Lcom/bytedance/ee/bear/middleground/comment/share/SharePermissionViewModel;", "clickLink", "Lkotlin/Function0;", "", "currentPagers", "", "", "Landroidx/recyclerview/widget/RecyclerView;", "isPortrait", "", "onResolve", "getOnResolve", "()Lkotlin/jvm/functions/Function0;", "setOnResolve", "(Lkotlin/jvm/functions/Function0;)V", "onClickEmpty", "getOnClickEmpty", "setOnClickEmpty", "banSwitch", "getBanSwitch", "()Z", "setBanSwitch", "(Z)V", "switchItem", "Lkotlin/Function2;", "commentIdToItemIdMap", "", "itemIdCounter", "getItemIdCounter", "()J", "setItemIdCounter", "(J)V", "initPage", "IListeners", "updateData", "scrollToPosition", "outPosition", "innerPosition", "percentage", "", "getView", "position", "(Ljava/lang/Integer;)Landroidx/recyclerview/widget/RecyclerView;", "resetAllRvPadding", "onEditStatus", "reSetEditStatus", "findEditViewPosition", "currentIndex", "resetRvPosition", "vp", "Lcom/bytedance/ee/bear/widgets/viewpager/VerticalViewPager;", "notifyDataChange", "forceContentDiff", "notifyCurrentPosDataChange", "getCurrentPos", "()Ljava/lang/Integer;", "notifyItemPageDataChanged", "recyclerView", "addQueteHead", "commentList", "Lcom/bytedance/ee/bear/middleground/comment/export/bean/CommentBean$CommentDetail;", "commentId", "commentType", "commentBean", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "lastToastTime", "toastNoMoreComment", "onTop", "getItemCount", "getItemId", "onBindViewHolder", "holder", "Companion", "ViewHolder", "middleground-comment_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommentPagerAdapter2 extends VerticalPagerAdapter<ViewHolder> implements q1 {
    public List<CommentBean> b;
    public com.bytedance.ee.bear.middleground.comment.uitls.p c;
    public Activity d;
    public String e;
    public List<String> f;
    public com.bytedance.ee.bear.middleground.comment.control.z g;
    public com.bytedance.ee.bear.middleground.comment.control.y h;
    public d i;
    public SharePermissionViewModel j;
    public Function0<Unit> k;
    public final Map<Integer, RecyclerView> l;
    public boolean m;
    public Function0<Unit> n;
    public Function0<Unit> o;
    public boolean p;
    public Function2<? super Integer, ? super Boolean, Unit> q;
    public final Map<String, Long> r;
    public long s;
    public long t;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/card/CommentPagerAdapter2$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "<init>", "(Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;)V", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "middleground-comment_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        public final RecyclerView a;

        /* JADX WARN: Multi-variable type inference failed */
        public ViewHolder(DampLayout r2, NoTopFadingEdgeRecyclerView r3) {
            Intrinsics.checkNotNullParameter(r2, "view");
            Intrinsics.checkNotNullParameter(r3, "recyclerView");
            super(r2);
            this.a = r3;
        }
    }

    public static final class a {
    }

    static {
    }

    public final void A2() {
        Iterator r0 = ((LinkedHashMap) this.l).values().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((RecyclerView) r0.next()).setPadding(0, 0, 0, 0);
        goto L4
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.q1
    public final Integer E() {
        VerticalViewPager r0 = this.a;
        if (r0 == null) goto L5;
        int r1 = r0.getCurrentItem();
    L7:
        return Integer.valueOf(r1);
    L5:
        r1 = 0;
        goto L7
    }

    public final int getItemCount() {
        List<CommentBean> r0 = this.b;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.size();
    }

    public CommentPagerAdapter2() {
        this.l = new LinkedHashMap();
        this.m = true;
        this.r = new LinkedHashMap();
        setHasStableIds(true);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.q1
    public final RecyclerView P0(Integer r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        return (RecyclerView) ((LinkedHashMap) this.l).get(r2);
    }

    public final long getItemId(int r5) {
        List<CommentBean> r0 = this.b;
        if (r0 == null) goto L7;
        CommentBean r6 = (CommentBean) ListProtector.get(r0, r5);
        if (r6 == null) goto L7;
        String r7 = r6.getComment_id();
    L8:
        if (r7 != null) goto L10;
    L21:
        tt5.a.d(CardAdapter2.TAG, "commentId is empty!");
        return -1;
    L10:
        if (r7.length() != 0) goto L12;
        boolean r1 = true;
    L13:
        if (r1 == true) goto L21;
        if (this.r.containsKey(r7) == false) goto L18;
        Long r8 = (Long) ((LinkedHashMap) this.r).get(r7);
    L19:
        Intrinsics.checkNotNull(r8);
        return r8.longValue();
    L18:
        long r2 = this.s;
        this.s = 1 + r2;
        Long r3 = Long.valueOf(r2);
        this.r.put(r7, r3);
        r8 = Long.valueOf(r2);
        goto L19
    L12:
        r1 = false;
    L7:
        r7 = null;
        goto L8
    }

    public static final void y2(CommentPagerAdapter2 r5, boolean r6) {
        r5.getClass();
        if ((System.currentTimeMillis() - r5.t) <= BaseKeyboardHeightProducer.CONFIGURATION_CHANGED_WAIT_MAX_INTERVAL) goto L12;
        r5.t = System.currentTimeMillis();
        Activity r7 = r5.d;
        if (r7 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("activity");
        r7 = null;
    L7:
        if (r6 == false) goto L9;
        int r8 = 2131887622;
    L10:
        Toast.showText(r7, r8);
        return;
    L9:
        r8 = 2131887623;
        goto L10
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r4, int r5) {
        ViewHolder r6 = (ViewHolder) r4;
        Intrinsics.checkNotNullParameter(r6, "holder");
        ((LinkedHashMap) this.l).values().remove(r6.a);
        Integer r0 = Integer.valueOf(r5);
        this.l.put(r0, r6.a);
        z2(r6.a, r5, false);
    }

    /* JADX WARN: Type inference failed for: r0v17, types: [android.view.ViewGroup, com.bytedance.ee.bear.widgets.viewpager.DampLayout] */
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r22, int r23) {
        Intrinsics.checkNotNullParameter(r22, "parent");
        Activity r0 = this.d;
        com.bytedance.ee.bear.middleground.comment.uitls.p r9 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("activity");
        r0 = null;
    L5:
        CommonRecyclerView r7 = new NoTopFadingEdgeRecyclerView(r0);
        r7.h = false;
        final Activity r1 = this.d;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("activity");
        r1 = null;
    L8:
        r7.setLayoutManager(new AnonymousClass1(r1));
        r7.setOverScrollMode(2);
        com.bytedance.ee.bear.middleground.comment.uitls.p r2 = this.c;
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("config");
        com.bytedance.ee.bear.middleground.comment.uitls.p r12 = null;
    L12:
        List<String> r3 = this.f;
        if (r3 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("userIds");
        List<String> r13 = null;
    L16:
        com.bytedance.ee.bear.middleground.comment.control.z r4 = this.g;
        if (r4 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mIListeners");
        com.bytedance.ee.bear.middleground.comment.control.z r14 = null;
    L20:
        com.bytedance.ee.bear.middleground.comment.control.y r5 = this.h;
        if (r5 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("actionControl");
        com.bytedance.ee.bear.middleground.comment.control.y r15 = null;
    L24:
        SharePermissionViewModel r6 = this.j;
        if (r6 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("sharePermissionViewModel");
        SharePermissionViewModel r16 = null;
    L28:
        d r8 = this.i;
        if (r8 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("cardDataViewModel");
        d r17 = null;
    L32:
        String r10 = this.e;
        if (r10 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("language");
        String r18 = null;
    L36:
        Function0<Unit> r11 = this.k;
        if (r11 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("clickLink");
        Function0<Unit> r19 = null;
    L40:
        r7.setAdapter(new CardAdapter2(r12, r13, r14, r15, r16, r17, r18, r19));
        r7.setTouchViewListener(new g(this));
        Ref.FloatRef r20 = new Ref.FloatRef();
        Ref.FloatRef r21 = new Ref.FloatRef();
        Ref.LongRef r24 = new Ref.LongRef();
        r7.setVerticalFadingEdgeEnabled(true);
        r7.setFadingEdgeLength(com.bytedance.ee.util.ui.n.d(16));
        r7.setOnTouchListener(new h(r24, r20, r21, r7, this));
        if ((r7.getItemAnimator() instanceof SimpleItemAnimator) == false) goto L43;
        SimpleItemAnimator r25 = r7.getItemAnimator();
        Intrinsics.checkNotNull(r25, "null cannot be cast to non-null type androidx.recyclerview.widget.SimpleItemAnimator");
        r25.setSupportsChangeAnimations(false);
    L43:
        r7.setItemAnimator(null);
        r7.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r7.addOnScrollListener(new AnonymousClass4(this));
        VerticalViewPager r26 = this.a;
        if (r26 == null) goto L46;
        r26.setUserInputEnabled(false);
    L46:
        Activity r27 = this.d;
        if (r27 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("activity");
        r27 = null;
    L49:
        ?? r28 = new DampLayout(r27);
        r28.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r28.setOnHeaderOrFooterListener(new i(this));
        r28.addView(r7);
        ConstraintLayout.LayoutParams r29 = new ConstraintLayout.LayoutParams(-1, r28.a);
        r29.bottomToTop = 0;
        r28.addView(r28.c, r29);
        ConstraintLayout.LayoutParams r30 = new ConstraintLayout.LayoutParams(-1, r28.a);
        r30.topToBottom = 0;
        r28.addView(r28.d, r30);
        com.bytedance.ee.bear.middleground.comment.uitls.p r31 = this.c;
        if (r31 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("config");
    L53:
        r9.N.a(new ef5.z(r7));
        return new ViewHolder(r28, r7);
    L52:
        r9 = r31;
        goto L53
    L39:
        r19 = r11;
        goto L40
    L35:
        r18 = r10;
        goto L36
    L31:
        r17 = r8;
        goto L32
    L27:
        r16 = r6;
        goto L28
    L23:
        r15 = r5;
        goto L24
    L19:
        r14 = r4;
        goto L20
    L15:
        r13 = r3;
        goto L16
    L11:
        r12 = r2;
        goto L12
    }

    public final void B2(int r7, int r8, float r9) {
        RecyclerView r0 = (RecyclerView) ((LinkedHashMap) this.l).get(Integer.valueOf(r7));
        com.bytedance.ee.bear.middleground.comment.uitls.p r1 = null;
        if (r0 == null) goto L5;
        RecyclerView.Adapter r2 = r0.getAdapter();
    L7:
        if ((r2 instanceof CardAdapter2) == false) goto L9;
        CardAdapter2 r3 = (CardAdapter2) r2;
    L10:
        if (r3 != null) goto L13;
        return;
    L13:
        if (r9 >= 0.0f) goto L16;
        r9 = 0.0f;
    L18:
        com.bytedance.ee.bear.middleground.comment.uitls.p r5 = this.c;
        if (r5 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("config");
    L22:
        RecyclerViewScrollHelper.SetSmoothScroller r4 = new RecyclerViewScrollHelper.SetSmoothScroller(r1.getActivity());
        r4.setTargetPosition(r8);
        r4.a = -1;
        if (r9 >= 0.0f) goto L25;
    L28:
        r4.b = -r3.getHeightFromTop();
        RecyclerViewScrollHelper.b(P0(Integer.valueOf(r7)), r4);
        return;
    L25:
        if (r9 > 1.0f) goto L28;
        r4.d = r9;
        goto L28
    L21:
        r1 = r5;
        goto L22
    L16:
        if (r9 <= 1.0f) goto L18;
        r9 = 1.0f;
        goto L18
    L9:
        r3 = null;
        goto L10
    L5:
        r2 = null;
        goto L7
    }

    public final void z2(RecyclerView r17, int r18, boolean r19) {
        tt5.a.b("Comment#CommentPagerAdapter2", "notifyItemPageDataChanged: position = " + r18);
        RecyclerView.Adapter r2 = r17.getAdapter();
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter2");
        CardAdapter2 r3 = (CardAdapter2) r2;
        List<CommentBean> r4 = this.b;
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type kotlin.collections.List<com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean>");
        CommentBean r5 = (CommentBean) ListProtector.get(r4, r18);
        List<CommentBean.CommentDetail> r6 = r5.getComment_list();
        List<CommentBean.CommentDetail> r7 = r6;
        if (r6 != null) goto L5;
        r7 = new ArrayList();
    L5:
        boolean r11 = true;
        List<CommentBean.CommentDetail> r8 = r7;
        if (r5.getCommentType() != 1) goto L16;
        ArrayList r9 = new ArrayList();
        CommentBean.CommentDetail r10 = new CommentBean.CommentDetail();
        r10.setReaction(r5.getReactionList());
        r10.setCommentType(r5.getCommentType());
        r10.setReplyType(1);
        r10.setComment_id(r5.getComment_id());
        r10.setReply_id("fake_reply_id");
        List<Reaction> r12 = r5.getReactionList();
        if (r12 != null) goto L10;
    L12:
        boolean r13 = false;
    L13:
        if (r13 == false) goto L15;
        com.bytedance.ee.bear.middleground.comment.uitls.s.a r14 = ((com.bytedance.ee.bear.middleground.comment.export.n) org.koin.java.a.c(com.bytedance.ee.bear.middleground.comment.export.n.class, null, null, 6)).c();
        List<Reaction> r15 = r5.getReactionList();
        String r16 = ((Reaction) ListProtector.get(r5.getReactionList(), 0)).getReferType();
        String r20 = r10.getReply_id();
        r14.getClass();
        Intrinsics.checkNotNullParameter(r10, "commentDetail");
        com.bytedance.ee.bear.middleground.comment.uitls.s.c(r10, r15, r16, r20);
    L15:
        r9.add(r10);
        r5.setComment_list(r9);
        r8 = r9;
        goto L16
    L10:
        if ((!r12.isEmpty()) != true) goto L12;
        r13 = true;
    L16:
        com.bytedance.ee.bear.middleground.comment.uitls.p r21 = this.c;
        if (r21 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("config");
        r21 = null;
    L19:
        r21.N.a(new ef5.a(r5));
        if ((!r8.isEmpty()) == false) goto L33;
        if (((CommentBean.CommentDetail) ListProtector.get(r8, 0)).getReplyType() < 0) goto L33;
        String r22 = ((CommentBean.CommentDetail) ListProtector.get(r8, 0)).getComment_id();
        int r23 = ((CommentBean.CommentDetail) ListProtector.get(r8, 0)).getCommentType();
        CommentBean.CommentDetail r24 = new CommentBean.CommentDetail();
        r24.setComment_id(r22);
        r24.setReply_id("fake_reply_id_top_placeholder");
        r24.setCommentType(r23);
        r24.setReplyType(-2);
        CommentBean.CommentDetail r25 = (CommentBean.CommentDetail) CollectionsKt.firstOrNull(r8);
        if (r25 == null) goto L26;
        ErrorBean r26 = r25.getError();
    L27:
        r24.setError(r26);
        CommentBean.CommentDetail r27 = new CommentBean.CommentDetail();
        r27.setComment_id(r22);
        r27.setReply_id(r5.getQuote() + r5.isUnSubmitComment());
        r27.setContent(r5.getQuote());
        r27.setCommentType(r23);
        r27.setUser_id(r5.getUserId());
        r27.setReplyType(-1);
        CommentBean.CommentDetail r28 = (CommentBean.CommentDetail) CollectionsKt.firstOrNull(r8);
        if (r28 == null) goto L30;
        ErrorBean r29 = r28.getError();
    L31:
        r27.setError(r29);
        CommentBean.CommentDetail r30 = new CommentBean.CommentDetail();
        r30.setComment_id(r22);
        r30.setReply_id("fake_reply_id_bottom_placeholder");
        r30.setCommentType(r23);
        r30.setReplyType(-3);
        ListProtector.add(r8, 0, r24);
        ListProtector.add(r8, 1, r27);
        r8.add(r30);
    L37:
        List<CommentBean.CommentDetail> r110 = r3.getCommentDetails();
        r3.setQuote(r5.getQuote());
        r3.setParentToken(r5.getParentToken());
        r3.setParentType(r5.getParentType());
        r3.setPosition(r5.getPosition());
        r3.setBizParams(r5.getBizParams());
        r3.setOnResolve(this.n);
        r3.setOnClickEmpty(this.o);
        if (TextUtils.isEmpty(r5.getCurrentReplyId()) == true) goto L43;
        d r31 = this.i;
        if (r31 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("cardDataViewModel");
        r31 = null;
    L42:
        r31.i = r5.getCurrentReplyId();
    L43:
        com.bytedance.ee.bear.middleground.comment.uitls.p r32 = this.c;
        if (r32 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("config");
        r32 = null;
    L47:
        if (r32.getActivity().getResources().getConfiguration().orientation == 2) goto L49;
        boolean r33 = true;
    L50:
        int r34 = CommentDiffUtils.a;
        com.bytedance.ee.bear.middleground.comment.uitls.p r35 = this.c;
        if (r35 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("config");
        r35 = null;
    L54:
        if (this.m == r33) goto L56;
        boolean r36 = true;
    L57:
        String r37 = r5.getCurrentReplyId();
        if (r37 != null) goto L60;
        r37 = "";
    L60:
        String r38 = r37;
        com.bytedance.ee.bear.middleground.comment.uitls.p r39 = this.c;
        if (r39 != null) goto L63;
        Intrinsics.throwUninitializedPropertyAccessException("config");
        r39 = null;
    L63:
        CommentDiffUtils.a(r3, r35, r5, r19, r36, r38, r39.e0);
        r3.setCardPos(r18);
        com.bytedance.ee.bear.middleground.comment.uitls.p r1 = this.c;
        if (r1 != null) goto L67;
        Intrinsics.throwUninitializedPropertyAccessException("config");
        r1 = null;
    L67:
        if (r1.getActivity().getResources().getConfiguration().orientation != 2) goto L70;
        r11 = false;
    L70:
        this.m = r11;
        com.bytedance.ee.bear.middleground.comment.uitls.p r40 = this.c;
        if (r40 != null) goto L73;
        Intrinsics.throwUninitializedPropertyAccessException("config");
        r40 = null;
    L73:
        r40.N.a(new ef5.x(r17, r5, r110));
        return;
    L56:
        r36 = false;
        goto L57
    L49:
        r33 = false;
        goto L50
    L30:
        r29 = null;
        goto L31
    L26:
        r26 = null;
    L33:
        if (r8.size() <= 2) goto L37;
        if (((CommentBean.CommentDetail) ListProtector.get(r8, 0)).getReplyType() >= 0) goto L37;
        ((CommentBean.CommentDetail) ListProtector.get(r8, 1)).setComment_id(((CommentBean.CommentDetail) ListProtector.get(r8, 0)).getComment_id());
        ((CommentBean.CommentDetail) ListProtector.get(r8, 1)).setReply_id(r5.getQuote() + r5.isUnSubmitComment());
        ((CommentBean.CommentDetail) ListProtector.get(r8, 1)).setContent(r5.getQuote());
        ((CommentBean.CommentDetail) ListProtector.get(r8, 1)).setCommentType(((CommentBean.CommentDetail) ListProtector.get(r8, 0)).getCommentType());
        ((CommentBean.CommentDetail) ListProtector.get(r8, 1)).setUser_id(r5.getUserId());
        ((CommentBean.CommentDetail) ListProtector.get(r8, 1)).setReplyType(-1);
        goto L37
    }
}
