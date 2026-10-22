package com.bytedance.ee.bear.middleground.comment.detail;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
import com.bytedance.ee.bear.middleground.comment.control.t;
import com.bytedance.ee.bear.middleground.comment.control.y;
import com.bytedance.ee.bear.middleground.comment.control.z;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentInputRequest;
import com.bytedance.ee.bear.middleground.comment.input.t1;
import com.bytedance.ee.bear.middleground.comment.uitls.p;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.widget.recyclerview.PointRecoderRecyclerView;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import sa5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c {
    public static final /* synthetic */ int r = 0;
    public final p a;
    public final z b;
    public final y c;
    public final String d;
    public final List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> e;
    public final Function2<String, List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity>, Unit> f;
    public final Function0<Unit> g;
    public final Function0<Unit> h;
    public final View i;
    public final View j;
    public final View k;
    public final View l;
    public kf5.b m;
    public com.bytedance.ee.bear.middleground.comment.detail.a n;
    public CardAdapter o;
    public final int p;
    public final d q;

    public static final class a {
    }

    static {
    }

    public final void a() {
        sa5.b r0 = (sa5.b) m.a.a(this.a.getActivity(), sa5.b.class);
        if (r0 == null) goto L5;
        r0.d(this.q);
    L5:
        this.c.u();
        this.b.f1().invoke(this.d);
        com.bytedance.ee.bear.middleground.comment.detail.a r1 = this.n;
        kf5.b r2 = null;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r1 = null;
    L8:
        r1.b();
        View r3 = this.i;
        if (r3 == null) goto L11;
        ViewParent r4 = r3.getParent();
    L13:
        if ((r4 instanceof ViewGroup) == false) goto L15;
        ViewGroup r5 = (ViewGroup) r4;
    L16:
        if (r5 == null) goto L18;
        r5.removeView(this.i);
    L18:
        kf5.b r6 = this.m;
        if (r6 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("createComment");
        r6 = null;
    L22:
        if (r6.isShowing() == false) goto L29;
        tt5.a.h("Comment#DetailComment", "dismiss DetailComment, so dismiss inputComment");
        kf5.b r7 = this.m;
        if (r7 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("createComment");
    L27:
        kf5.a.a(r2, false, false, 3);
        return;
    L26:
        r2 = r7;
        goto L27
    L29:
        return;
    L15:
        r5 = null;
        goto L16
    L11:
        r4 = null;
        goto L13
    }

    public c(p r29, z r30, t r31, y r32, String r33, CommentBean r34, String r35, List r36, Function2 r37, Function0 r38, String r39, String r40, String r41, Integer r42, boolean r43) {
        DetailComment$3 r5 = DetailComment$3.INSTANCE;
        Intrinsics.checkNotNullParameter(r29, "configComment");
        Intrinsics.checkNotNullParameter(r30, "commentListeners");
        Intrinsics.checkNotNullParameter(r31, "dataControl");
        Intrinsics.checkNotNullParameter(r32, "actionControl");
        Intrinsics.checkNotNullParameter(r33, "commentId");
        Intrinsics.checkNotNullParameter(r34, "commentBean");
        Intrinsics.checkNotNullParameter(r35, "defaultText");
        Intrinsics.checkNotNullParameter(r37, "closeFull");
        Intrinsics.checkNotNullParameter(r38, "resolve");
        Intrinsics.checkNotNullParameter(r5, "clickLink");
        this.a = r29;
        this.b = r30;
        this.c = r32;
        this.d = r33;
        this.e = r36;
        this.f = r37;
        this.g = r38;
        this.h = r5;
        View r2 = LayoutInflater.from(r29.getActivity()).inflate(2131559860, null);
        this.i = r2;
        int r4 = r29.r.keyBoardRawHeight();
        this.p = r4;
        tt5.a.h("Comment#DetailComment", "keyBoard height: " + r4);
        if (r2 == null) goto L5;
        r2.post(new b(this));
    L5:
        if (r2 == null) goto L7;
        View r11 = r2.findViewById(2131375141);
    L8:
        this.k = r11;
        if (r2 == null) goto L11;
        View r10 = r2.findViewById(2131384717);
    L12:
        this.j = r10;
        if (r2 == null) goto L15;
        View r9 = r2.findViewById(2131391037);
    L16:
        this.l = r9;
        if (r2 == null) goto L19;
        PointRecoderRecyclerView r8 = (PointRecoderRecyclerView) r2.findViewById(2131367383);
    L20:
        r29.h.getClass();
        com.bytedance.ee.bear.middleground.comment.p.a();
        com.bytedance.ee.bear.middleground.comment.detail.a r3 = new com.bytedance.ee.bear.middleground.comment.detail.a();
        this.n = r3;
        r3.e(r29, r31, r33, r34);
        com.bytedance.ee.bear.middleground.comment.detail.a r1 = this.n;
        if (r1 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r1 = null;
    L24:
        if (r1.d == false) goto L29;
        com.bytedance.ee.bear.middleground.comment.detail.a r6 = this.n;
        if (r6 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r6 = null;
    L28:
        r6.getClass();
    L29:
        com.bytedance.ee.bear.middleground.comment.detail.a r7 = this.n;
        if (r7 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        com.bytedance.ee.bear.middleground.comment.detail.a r16 = null;
    L33:
        CommentInputRequest r12 = r16.d(r35, r36, r39, r40, r41, r42);
        r12.isShowAreaSelectBtn = r43;
        PointRecoderRecyclerView r24 = r8;
        View r25 = r9;
        View r26 = r10;
        View r27 = r11;
        this.m = t1.a(r29, r30, r31, null, r12, new DetailComment$initInputComment$1(this), new DetailComment$initInputComment$2(this), false, null, null, null, 7944);
        com.bytedance.ee.bear.middleground.comment.detail.a r13 = this.n;
        if (r13 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r13 = null;
    L37:
        if (r13.d == false) goto L41;
        View r14 = r25;
        if (r14 == null) goto L53;
        r14.setVisibility(8);
    L53:
        com.bytedance.ee.bear.middleground.comment.detail.a r15 = null;
        String r17 = ((i0) org.koin.java.a.c(i0.class, null, null, 6)).a();
        r29.h.getClass();
        r29.h.getClass();
        List r18 = CollectionsKt.listOf(new String[]{com.bytedance.ee.bear.middleground.comment.p.a(), null});
        com.bytedance.ee.bear.middleground.comment.detail.a r19 = this.n;
        if (r19 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r19 = null;
    L56:
        CardAdapter r20 = new CardAdapter(r29, r17, r18, r30, r32, r19.d, new DetailComment$initDefaultData$1(this));
        this.o = r20;
        if (r24 == null) goto L59;
        r24.setAdapter(r20);
    L59:
        if (r24 == null) goto L61;
        r24.setLayoutManager(new LinearLayoutManager(r29.getActivity()));
    L61:
        CardAdapter r21 = this.o;
        if (r21 == null) goto L68;
        com.bytedance.ee.bear.middleground.comment.detail.a r22 = this.n;
        if (r22 != null) goto L66;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
    L67:
        r21.setData(r15.f);
        goto L68
    L66:
        r15 = r22;
    L68:
        CardAdapter r23 = this.o;
        if (r23 == null) goto L72;
        r23.notifyDataSetChanged();
    L72:
        if (r26 == null) goto L75;
        r26.setOnClickListener(e.a);
    L75:
        if (r27 == null) goto L77;
        r27.setOnClickListener(new f(this));
    L77:
        if (r14 == null) goto L79;
        r14.setOnClickListener(new g(this));
    L79:
        if (r24 == null) goto L81;
        r24.setTouchViewListener(new h(this));
    L81:
        this.q = new d(this);
        return;
    L41:
        r14 = r25;
        if (r34.getComment_list().size() <= 0) goto L44;
        String r28 = ((CommentBean.CommentDetail) ListProtector.get(r34.getComment_list(), 0)).getUser_id();
    L46:
        if (r29.u == false) goto L48;
    L51:
        if (r14 == null) goto L53;
        r14.setVisibility(8);
        goto L53
    L48:
        if (r32.t(r28, r34.getParticipantList()) == false) goto L51;
        if (r14 == null) goto L53;
        r14.setVisibility(0);
        goto L53
    L44:
        r28 = "";
        goto L46
    L32:
        r16 = r7;
        goto L33
    L19:
        r8 = null;
        goto L20
    L15:
        r9 = null;
        goto L16
    L11:
        r10 = null;
        goto L12
    L7:
        r11 = null;
        goto L8
    }
}
