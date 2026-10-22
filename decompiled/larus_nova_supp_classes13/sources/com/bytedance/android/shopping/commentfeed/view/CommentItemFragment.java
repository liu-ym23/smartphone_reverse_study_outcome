package com.bytedance.android.shopping.commentfeed.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import bc3.d;
import bc3.e;
import com.bytedance.android.ec.model.response.ECCommentVideo;
import com.bytedance.android.ec.model.response.PromotionProductCommentDTO;
import com.bytedance.android.ec.model.response.PromotionProductCommentPhotoDTO;
import com.bytedance.android.ec.model.response.anchorv3.PromotionVideoInfo;
import com.bytedance.android.shopping.commentfeed.HorizontalRecyclerView;
import com.bytedance.android.shopping.commentfeed.adapter.CommentMediaAdapter;
import com.bytedance.android.shopping.commentfeed.model.CommentFragmentParams;
import com.bytedance.android.shopping.commentfeed.utils.CommentListViewModel;
import com.bytedance.android.shopping.commentfeed.viewholder.CommentBaseViewHolder;
import com.bytedance.android.shopping.commentfeed.widget.CommentImageIndicatorNumView;
import com.bytedance.android.shopping.commentfeed.widget.CommentIndicatorLayout;
import com.bytedance.android.shopping.commentfeed.widget.CommentIndicatorView;
import com.bytedance.android.shopping.commentfeed.widget.CommentItemDiggView;
import com.bytedance.android.shopping.commentfeed.widget.ECExpandableTextView;
import com.bytedance.android.shopping.commentfeed.widget.RecyclerViewPageChangeListener;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.ies.uikit.base.AbsFragment;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import yb3.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/commentfeed/view/CommentItemFragment;", "Lcom/bytedance/ies/uikit/base/AbsFragment;", "<init>", "()V", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommentItemFragment extends AbsFragment {
    public static final /* synthetic */ int w = 0;
    public final com.bytedance.commerce.base.viewmodel.a d;
    public HorizontalRecyclerView e;
    public TextView f;
    public ECExpandableTextView g;
    public CommentItemDiggView h;
    public CommentImageIndicatorNumView i;
    public CommentIndicatorLayout j;
    public View k;
    public String l;
    public final List<d> m;
    public final List<Object> n;
    public PromotionProductCommentDTO o;
    public int p;
    public long q;
    public CommentMediaAdapter r;
    public boolean s;
    public final HashSet<Integer> t;
    public final c u;
    public final b v;

    public static final class a {
    }

    public static final class b implements d {
        public final /* synthetic */ CommentItemFragment a;

        public b(CommentItemFragment r1) {
            this.a = r1;
        }

        @Override // bc3.d
        public final void onItemSelected(int r3) {
            HorizontalRecyclerView r0 = this.a.e;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("mediaContentRecyclerView");
        L5:
            r0.smoothScrollToPosition(r3);
        }
    }

    public static final class c implements e {
        public final /* synthetic */ CommentItemFragment a;

        @Override // bc3.e
        public final void a() {
            CommentItemFragment.S90(this.a, true);
        }

        @Override // bc3.e
        public final void b() {
            CommentItemFragment.S90(this.a, false);
        }

        public c(CommentItemFragment r1) {
            this.a = r1;
        }
    }

    static {
    }

    public CommentItemFragment() {
        CommentItemFragment$viewModel$2 r0 = CommentItemFragment$viewModel$2.INSTANCE;
        this.d = new com.bytedance.commerce.base.viewmodel.a(Reflection.getOrCreateKotlinClass(CommentListViewModel.class), new CommentItemFragment$$special$$inlined$activityViewModels$1(this), r0);
        this.l = "click";
        this.m = new ArrayList();
        this.n = new ArrayList();
        this.t = new HashSet();
        this.u = new c(this);
        this.v = new b(this);
    }

    public final void onDestroyView() {
        super.onDestroyView();
        ((ArrayList) this.m).clear();
        ((ArrayList) this.n).clear();
        CommentMediaAdapter r0 = this.r;
        if (r0 == null) goto L10;
        int r1 = r0.c.size();
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L14;
        CommentBaseViewHolder r3 = r0.c.valueAt(r2);
        if (r3 == null) goto L9;
        r3.V3();
    L9:
        r2 = r2 + 1;
        goto L5
    L14:
        return;
    }

    public final void onPause() {
        super.onPause();
        onVisibilityChange(false);
    }

    public final void onResume() {
        super.onResume();
        if (getUserVisibleHint() == false) goto L6;
        onVisibilityChange(true);
        return;
    }

    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        Bundle r4 = getArguments();
        Serializable r0 = null;
        if (r4 == null) goto L5;
        Serializable r5 = r4.getSerializable("comment_item");
    L7:
        if ((r5 instanceof CommentFragmentParams) == false) goto L10;
        r0 = r5;
    L10:
        CommentFragmentParams r1 = (CommentFragmentParams) r0;
        if (r1 == null) goto L14;
        this.o = r1.getComment();
        this.p = r1.getCurIndex();
        return;
    L14:
        return;
    L5:
        r5 = null;
        goto L7
    }

    public final void onVisibilityChange(boolean r9) {
        int r0 = 0;
        if (r9 == false) goto L11;
        this.q = System.currentTimeMillis();
        int r1 = this.p;
        CommentListViewModel r2 = (CommentListViewModel) this.d.getValue();
        if (r2 != null) goto L7;
    L8:
        this.l = "draw";
    L9:
        int r3 = yb3.e.a;
        Context r4 = getContext();
        String r5 = this.l;
        yb3.c r6 = new yb3.c();
        r6.a = r5;
        Unit r7 = Unit.INSTANCE;
        yb3.e.a(r6, r4);
    L41:
        this.s = r9;
        CommentMediaAdapter r8 = this.r;
        if (r8 == null) goto L62;
        int r10 = ((ArrayList) r8.a).size();
    L44:
        if (r0 >= r10) goto L73;
        RecyclerView.ViewHolder r11 = null;
        if (r9 == false) goto L54;
        RecyclerView.ViewHolder r12 = r8.e.findViewHolderForLayoutPosition(r0);
        if ((r12 instanceof CommentBaseViewHolder) == false) goto L51;
        r11 = r12;
    L51:
        CommentBaseViewHolder r13 = (CommentBaseViewHolder) r11;
        if (r13 == null) goto L61;
        r13.T3();
    L61:
        r0 = r0 + 1;
        goto L44
    L54:
        RecyclerView.ViewHolder r14 = r8.e.findViewHolderForLayoutPosition(r0);
        if ((r14 instanceof CommentBaseViewHolder) == false) goto L58;
        r11 = r14;
    L58:
        CommentBaseViewHolder r15 = (CommentBaseViewHolder) r11;
        if (r15 == null) goto L61;
        r15.U3();
        goto L61
    L73:
        return;
    L62:
        return;
    L7:
        if (r1 == r2.getFirstEnterCommentIndex()) goto L9;
    L11:
        if (this.s == false) goto L41;
        int r16 = yb3.e.a;
        Context r17 = getContext();
        long r18 = System.currentTimeMillis() - this.q;
        String r19 = this.l;
        f r20 = new f();
        r20.b = r19;
        r20.a = r18;
        Unit r21 = Unit.INSTANCE;
        yb3.e.a(r20, r17);
        Iterator<Integer> r22 = this.t.iterator();
        int r23 = 1;
    L14:
        if (r22.hasNext() == false) goto L18;
        int r24 = r22.next().intValue() + 1;
        if (r24 <= r23) goto L14;
        r23 = r24;
        goto L14
    L18:
        int r25 = yb3.e.a;
        Context r26 = getContext();
        CommentMediaAdapter r27 = this.r;
        if (r27 == null) goto L23;
        zb3.e r28 = (zb3.e) CollectionsKt.firstOrNull(r27.a);
        if (r28 == null) goto L23;
        int r29 = r28.getType();
    L24:
        PromotionProductCommentDTO r30 = this.o;
        String r31 = this.l;
        int r32 = this.p + 1;
        yb3.b r33 = new yb3.b();
        r33.g = r31;
        if (r29 != 2) goto L27;
        String r34 = "picture";
    L28:
        r33.a = r34;
        r33.c = Integer.valueOf(r32);
        if (r30 == null) goto L33;
        List r35 = r30.getPhotos();
        if (r35 == null) goto L33;
        int r36 = r35.size();
    L34:
        r33.d = Integer.valueOf(r36);
        if (r30 == null) goto L39;
        List r37 = r30.getVideos();
        if (r37 == null) goto L39;
        int r38 = r37.size();
    L40:
        r33.e = Integer.valueOf(r38);
        r33.f = Integer.valueOf(r23);
        Unit r39 = Unit.INSTANCE;
        yb3.e.a(r33, r26);
    L39:
        r38 = 0;
    L33:
        r36 = 0;
        goto L34
    L27:
        r34 = "video";
    L23:
        r29 = -1;
        goto L24
    }

    public final void setUserVisibleHint(boolean r2) {
        super/*androidx.fragment.app.Fragment*/.setUserVisibleHint(r2);
        if (isResumed() == false) goto L6;
        onVisibilityChange(r2);
        return;
    }

    public static final void S90(CommentItemFragment r4, boolean r5) {
        TextView r0 = r4.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("tvUserName");
    L5:
        int r1 = 8;
        if (r5 == false) goto L8;
        int r3 = 0;
    L9:
        r0.setVisibility(r3);
        ECExpandableTextView r2 = r4.g;
        if (r2 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("tvCommentContent");
    L12:
        if (r5 == false) goto L14;
        int r6 = 0;
    L15:
        r2.setVisibility(r6);
        CommentItemDiggView r7 = r4.h;
        if (r7 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("commentDiggView");
    L18:
        if (r5 == false) goto L20;
        r1 = 0;
    L20:
        r7.setVisibility(r1);
        return;
    L14:
        r6 = 8;
        goto L15
    L8:
        r3 = 8;
        goto L9
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void onViewCreated(View r22, Bundle r23) {
        Intrinsics.checkNotNullParameter(r22, FreqActions.ACTION_VIEW);
        super.onViewCreated(r22, r23);
        this.e = (HorizontalRecyclerView) r22.findViewById(2131370520);
        this.f = (TextView) r22.findViewById(2131370521);
        this.g = (ECExpandableTextView) r22.findViewById(2131370519);
        this.h = (CommentItemDiggView) r22.findViewById(2131370612);
        this.j = (CommentIndicatorLayout) r22.findViewById(2131370616);
        this.i = (CommentImageIndicatorNumView) r22.findViewById(2131370529);
        this.k = r22.findViewById(2131370512);
        PagerSnapHelper r1 = new PagerSnapHelper();
        HorizontalRecyclerView r2 = this.e;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mediaContentRecyclerView");
    L5:
        r1.attachToRecyclerView(r2);
        HorizontalRecyclerView r3 = this.e;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mediaContentRecyclerView");
    L8:
        r3.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        HorizontalRecyclerView r4 = this.e;
        if (r4 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mediaContentRecyclerView");
    L11:
        r4.addOnScrollListener(new RecyclerViewPageChangeListener(r1, new com.bytedance.android.shopping.commentfeed.view.c(this)));
        PromotionProductCommentDTO r5 = this.o;
        if (r5 == null) goto L139;
        TextView r6 = this.f;
        if (r6 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("tvUserName");
    L16:
        r6.setText("@" + r5.getUserName());
        ECExpandableTextView r7 = this.g;
        if (r7 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("tvCommentContent");
    L19:
        String r8 = r5.getContent();
        if (r8 != null) goto L22;
        r8 = "";
    L22:
        r7.setContentText(r8);
        CommentItemDiggView r9 = this.h;
        if (r9 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("commentDiggView");
    L25:
        CommentListViewModel r10 = (CommentListViewModel) this.d.getValue();
        Long r11 = r5.getId();
        if (r11 == null) goto L28;
        String r12 = String.valueOf(r11.longValue());
    L29:
        Boolean r13 = r5.getLiked();
        if (r13 == null) goto L32;
        boolean r14 = r13.booleanValue();
    L33:
        Long r15 = r5.getLikes();
        if (r15 == null) goto L36;
        long r16 = r15.longValue();
    L37:
        zb3.a r17 = new zb3.a(r12, r14, r16, this.l);
        r9.getClass();
        Intrinsics.checkNotNullParameter(r17, "diggData");
        r9.c = r17;
        r9.d = r10;
        r9.a(r17.b, r17.c);
        CommentImageIndicatorNumView r18 = this.i;
        if (r18 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("commentImageIndicatorNum");
    L40:
        r18.getClass();
        Intrinsics.checkNotNullParameter(r5, "comment");
        List r19 = r5.getPhotos();
        if (r19 == null) goto L43;
        int r20 = r19.size();
    L44:
        r18.b = r20;
        List r21 = r5.getVideos();
        if (r21 == null) goto L47;
        int r24 = r21.size();
    L49:
        if (r18.b <= 1) goto L53;
        if (r24 > 0) goto L53;
        r18.setVisibility(0);
        r18.a.setText(th.a.f(r18.getContext()).getString(2131914059, new Object[]{"1", String.valueOf(r18.b)}));
        com.bytedance.android.shopping.commentfeed.widget.a r25 = new com.bytedance.android.shopping.commentfeed.widget.a(r18);
        Intrinsics.checkNotNullParameter(r25, "listener");
        ((ArrayList) this.m).add(r25);
    L54:
        CommentIndicatorLayout r26 = this.j;
        if (r26 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("indicatorLayout");
    L57:
        b r27 = this.v;
        r26.getClass();
        Intrinsics.checkNotNullParameter(r5, "comment");
        Intrinsics.checkNotNullParameter(this, "itemFragment");
        List r28 = r5.getPhotos();
        if (r28 == null) goto L60;
        int r29 = r28.size();
    L61:
        r26.b = r29;
        List r30 = r5.getPhotos();
        if (r30 == null) goto L64;
        int r31 = r30.size();
    L65:
        List r110 = r5.getVideos();
        if (r110 == null) goto L68;
        int r111 = r110.size();
    L69:
        r26.c = r111;
        r26.b = r31 + r111;
        r26.removeAllViews();
        if (r26.b > 1) goto L72;
        r26.setVisibility(8);
    L95:
        HorizontalRecyclerView r32 = this.e;
        if (r32 != null) goto L98;
        Intrinsics.throwUninitializedPropertyAccessException("mediaContentRecyclerView");
    L98:
        CommentMediaAdapter r33 = new CommentMediaAdapter(this, r32, this.u);
        Intrinsics.checkNotNullParameter(r5, "comment");
        List r34 = r5.getVideos();
        if (r34 == null) goto L111;
        Iterator r35 = r34.iterator();
        int r112 = 0;
    L102:
        if (r35.hasNext() == false) goto L111;
        Object r36 = r35.next();
        int r113 = r112 + 1;
        if (r112 >= 0) goto L106;
        CollectionsKt.throwIndexOverflow();
    L106:
        PromotionVideoInfo r37 = (PromotionVideoInfo) r36;
        List r38 = r5.getVideosV2();
        if (r38 == null) goto L109;
        ECCommentVideo r114 = (ECCommentVideo) CollectionsKt.getOrNull(r38, r112);
    L110:
        ((ArrayList) r33.a).add(new zb3.f(r37, 0, null, false, r112, 0, 0, r114, 238));
        r112 = r113;
        goto L102
    L109:
        r114 = null;
    L111:
        List r39 = r5.getVideos();
        if (r39 == null) goto L114;
        int r40 = r39.size();
    L115:
        r33.b = r40;
        List r41 = r5.getPhotos();
        if (r41 == null) goto L124;
        Iterator r42 = r41.iterator();
        int r43 = 0;
    L119:
        if (r42.hasNext() == false) goto L124;
        Object r44 = r42.next();
        int r45 = r43 + 1;
        if (r43 >= 0) goto L123;
        CollectionsKt.throwIndexOverflow();
    L123:
        ((ArrayList) r33.a).add(new zb3.c((PromotionProductCommentPhotoDTO) r44, 0, null, false, r33.b + r43, 0, 0, 238));
        r43 = r45;
    L124:
        r33.notifyDataSetChanged();
        Unit r46 = Unit.INSTANCE;
        this.r = r33;
        HorizontalRecyclerView r47 = this.e;
        if (r47 != null) goto L127;
        Intrinsics.throwUninitializedPropertyAccessException("mediaContentRecyclerView");
    L127:
        r47.setAdapter(this.r);
        return;
    L114:
        r40 = 0;
        goto L115
    L72:
        ((ArrayList) r26.a).clear();
        r26.setVisibility(0);
        int r48 = r26.b;
        int r115 = 0;
    L73:
        if (r115 >= r48) goto L75;
        ((ArrayList) r26.a).add(new CommentIndicatorView(r26.getContext(), null, 6, 0));
        r115 = r115 + 1;
        goto L73
    L75:
        Iterator r49 = ((ArrayList) r26.a).iterator();
        int r116 = 0;
    L77:
        if (r49.hasNext() == false) goto L94;
        Object r117 = r49.next();
        int r118 = r116 + 1;
        if (r116 >= 0) goto L81;
        CollectionsKt.throwIndexOverflow();
    L81:
        CommentIndicatorView r119 = (CommentIndicatorView) r117;
        LinearLayout.LayoutParams r120 = new LinearLayout.LayoutParams(0, -2, 1.0f);
        if (r116 == (((ArrayList) r26.a).size() - 1)) goto L85;
        r120.setMargins(0, 0, com.bytedance.android.shopping.extensions.b.b(4), 0);
    L85:
        r119.setLayoutParams(r120);
        if (r116 >= r26.c) goto L88;
        boolean r121 = true;
    L89:
        if (r116 != 0) goto L92;
        if (r121 == true) goto L92;
        boolean r122 = true;
    L93:
        r119.setIndicatorSelected(r122);
        r119.c = r27;
        r119.b = r116;
        r26.addView(r119);
        r116 = r118;
    L92:
        r122 = false;
        goto L93
    L88:
        r121 = false;
        goto L89
    L94:
        Intrinsics.checkNotNullParameter(r26, "listener");
        ((ArrayList) this.m).add(r26);
        Intrinsics.checkNotNullParameter(r26, "listener");
        ((ArrayList) this.n).add(r26);
        goto L95
    L68:
        r111 = 0;
        goto L69
    L64:
        r31 = 0;
        goto L65
    L60:
        r29 = 0;
    L53:
        r18.setVisibility(4);
        goto L54
    L47:
        r24 = 0;
        goto L49
    L43:
        r20 = 0;
        goto L44
    L36:
        r16 = 0;
        goto L37
    L32:
        r14 = false;
        goto L33
    L28:
        r12 = null;
        goto L29
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131560532, r3, false);
    }
}
