package com.bytedance.ee.bear.middleground.comment.detail;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
import com.bytedance.ee.bear.middleground.comment.control.t;
import com.bytedance.ee.bear.middleground.comment.control.y;
import com.bytedance.ee.bear.middleground.comment.control.z;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentInputRequest;
import com.bytedance.ee.bear.middleground.comment.input.t1;
import com.bytedance.ee.bear.middleground.comment.uitls.p;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.widget.recyclerview.PointRecoderRecyclerView;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import sa5.m;

/* JADX INFO: loaded from: classes18.dex */
public final class c {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ int f231262r = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p f231263a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final z f231264b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final y f231265c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f231266d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> f231267e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function2<String, List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity>, Unit> f231268f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function0<Unit> f231269g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function0<Unit> f231270h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final View f231271i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final View f231272j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final View f231273k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final View f231274l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public kf5.b f231275m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public com.bytedance.ee.bear.middleground.comment.detail.a f231276n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public CardAdapter f231277o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f231278p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final d f231279q;

    public static final class a {
    }

    static {
    }

    public final void a() {
        sa5.b r100 = (sa5.b) m.a.a(this.f231263a.getActivity(), sa5.b.class);
        if (r100 == null) goto L5;
        r100.d(this.f231279q);
    L5:
        this.f231265c.u();
        this.f231264b.f1().invoke(this.f231266d);
        com.bytedance.ee.bear.middleground.comment.detail.a r101 = this.f231276n;
        kf5.b r102 = null;
        if (r101 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r101 = null;
    L8:
        r101.b();
        View r103 = this.f231271i;
        if (r103 == null) goto L11;
        ViewParent r104 = r103.getParent();
    L13:
        if ((r104 instanceof ViewGroup) == false) goto L15;
        ViewGroup r105 = (ViewGroup) r104;
    L16:
        if (r105 == null) goto L18;
        r105.removeView(this.f231271i);
    L18:
        kf5.b r106 = this.f231275m;
        if (r106 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("createComment");
        r106 = null;
    L22:
        if (r106.isShowing() == false) goto L29;
        tt5.a.h("Comment#DetailComment", "dismiss DetailComment, so dismiss inputComment");
        kf5.b r107 = this.f231275m;
        if (r107 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("createComment");
    L27:
        kf5.a.a(r102, false, false, 3);
        return;
    L26:
        r102 = r107;
        goto L27
    L29:
        return;
    L15:
        r105 = null;
        goto L16
    L11:
        r104 = null;
        goto L13
    }

    public c(p r210, z r310, t r311, y r312, String r313, CommentBean r314, String r315, List r316, Function2 r317, Function0 r318, String r319, String r410, String r411, Integer r412, boolean r413) {
        DetailComment$3 r100 = DetailComment$3.INSTANCE;
        Intrinsics.checkNotNullParameter(r210, "configComment");
        Intrinsics.checkNotNullParameter(r310, "commentListeners");
        Intrinsics.checkNotNullParameter(r311, "dataControl");
        Intrinsics.checkNotNullParameter(r312, "actionControl");
        Intrinsics.checkNotNullParameter(r313, "commentId");
        Intrinsics.checkNotNullParameter(r314, "commentBean");
        Intrinsics.checkNotNullParameter(r315, "defaultText");
        Intrinsics.checkNotNullParameter(r317, "closeFull");
        Intrinsics.checkNotNullParameter(r318, JSEventListener.ACTION_RESOLVE);
        Intrinsics.checkNotNullParameter(r100, "clickLink");
        this.f231263a = r210;
        this.f231264b = r310;
        this.f231265c = r312;
        this.f231266d = r313;
        this.f231267e = r316;
        this.f231268f = r317;
        this.f231269g = r318;
        this.f231270h = r100;
        View r101 = LayoutInflater.from(r210.getActivity()).inflate(R.layout.comment_detail_layout, null);
        this.f231271i = r101;
        int r102 = r210.f232242r.keyBoardRawHeight();
        this.f231278p = r102;
        tt5.a.h("Comment#DetailComment", "keyBoard height: " + r102);
        if (r101 == null) goto L5;
        r101.post(new b(this));
    L5:
        if (r101 == null) goto L7;
        View r110 = r101.findViewById(R.id.img_down_arrow);
    L8:
        this.f231273k = r110;
        if (r101 == null) goto L11;
        View r111 = r101.findViewById(R.id.rl_title);
    L12:
        this.f231272j = r111;
        if (r101 == null) goto L15;
        View r103 = r101.findViewById(R.id.tv_opt_comment);
    L16:
        this.f231274l = r103;
        if (r101 == null) goto L19;
        PointRecoderRecyclerView r104 = (PointRecoderRecyclerView) r101.findViewById(R.id.comment_list);
    L20:
        r210.f232232h.getClass();
        com.bytedance.ee.bear.middleground.comment.p.a();
        com.bytedance.ee.bear.middleground.comment.detail.a r105 = new com.bytedance.ee.bear.middleground.comment.detail.a();
        this.f231276n = r105;
        r105.e(r210, r311, r313, r314);
        com.bytedance.ee.bear.middleground.comment.detail.a r106 = this.f231276n;
        if (r106 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r106 = null;
    L24:
        if (r106.f231258d == false) goto L29;
        com.bytedance.ee.bear.middleground.comment.detail.a r107 = this.f231276n;
        if (r107 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r107 = null;
    L28:
        r107.getClass();
    L29:
        com.bytedance.ee.bear.middleground.comment.detail.a r108 = this.f231276n;
        if (r108 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        com.bytedance.ee.bear.middleground.comment.detail.a r112 = null;
    L33:
        CommentInputRequest r109 = r112.d(r315, r316, r319, r410, r411, r412);
        r109.isShowAreaSelectBtn = r413;
        PointRecoderRecyclerView r211 = r104;
        View r212 = r103;
        View r213 = r111;
        View r214 = r110;
        this.f231275m = t1.a(r210, r310, r311, null, r109, new DetailComment$initInputComment$1(this), new DetailComment$initInputComment$2(this), false, null, null, null, 7944);
        com.bytedance.ee.bear.middleground.comment.detail.a r113 = this.f231276n;
        if (r113 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r113 = null;
    L37:
        if (r113.f231258d == false) goto L41;
        View r114 = r212;
        if (r114 == null) goto L53;
        r114.setVisibility(8);
    L53:
        com.bytedance.ee.bear.middleground.comment.detail.a r115 = null;
        String r116 = ((i0) org.koin.java.a.c(i0.class, null, null, 6)).a();
        r210.f232232h.getClass();
        r210.f232232h.getClass();
        List r117 = CollectionsKt.listOf(new String[]{com.bytedance.ee.bear.middleground.comment.p.a(), null});
        com.bytedance.ee.bear.middleground.comment.detail.a r118 = this.f231276n;
        if (r118 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r118 = null;
    L56:
        CardAdapter r119 = new CardAdapter(r210, r116, r117, r310, r312, r118.f231258d, new DetailComment$initDefaultData$1(this));
        this.f231277o = r119;
        if (r211 == null) goto L59;
        r211.setAdapter(r119);
    L59:
        if (r211 == null) goto L61;
        r211.setLayoutManager(new LinearLayoutManager(r210.getActivity()));
    L61:
        CardAdapter r120 = this.f231277o;
        if (r120 == null) goto L68;
        com.bytedance.ee.bear.middleground.comment.detail.a r121 = this.f231276n;
        if (r121 != null) goto L66;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
    L67:
        r120.setData(r115.f231260f);
        goto L68
    L66:
        r115 = r121;
    L68:
        CardAdapter r122 = this.f231277o;
        if (r122 == null) goto L72;
        r122.notifyDataSetChanged();
    L72:
        if (r213 == null) goto L75;
        r213.setOnClickListener(e.f231281a);
    L75:
        if (r214 == null) goto L77;
        r214.setOnClickListener(new f(this));
    L77:
        if (r114 == null) goto L79;
        r114.setOnClickListener(new g(this));
    L79:
        if (r211 == null) goto L81;
        r211.setTouchViewListener(new h(this));
    L81:
        this.f231279q = new d(this);
        return;
    L41:
        r114 = r212;
        if (r314.getComment_list().size() <= 0) goto L44;
        String r123 = ((CommentBean.CommentDetail) ListProtector.get(r314.getComment_list(), 0)).getUser_id();
    L46:
        if (r210.f232245u == false) goto L48;
    L51:
        if (r114 == null) goto L53;
        r114.setVisibility(8);
        goto L53
    L48:
        if (r312.t(r123, r314.getParticipantList()) == false) goto L51;
        if (r114 == null) goto L53;
        r114.setVisibility(0);
        goto L53
    L44:
        r123 = "";
        goto L46
    L32:
        r112 = r108;
        goto L33
    L19:
        r104 = null;
        goto L20
    L15:
        r103 = null;
        goto L16
    L11:
        r111 = null;
        goto L12
    L7:
        r110 = null;
        goto L8
    }
}
