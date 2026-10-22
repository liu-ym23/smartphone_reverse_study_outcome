package com.bytedance.ee.bear.middleground.comment.card.aside;

import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.middleground.comment.Comment;
import com.bytedance.ee.bear.middleground.comment.Comment$inputCommentFunction$1;
import com.bytedance.ee.bear.middleground.comment.card.q1;
import com.bytedance.ee.bear.middleground.comment.control.t;
import com.bytedance.ee.bear.middleground.comment.control.y;
import com.bytedance.ee.bear.middleground.comment.control.z;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentInputRequest;
import com.bytedance.ee.bear.middleground.comment.export.bean.FocusInputBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.ScrollCommentBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.SmartReplyDataForInsert;
import com.bytedance.ee.bear.middleground.comment.export.o;
import com.bytedance.ee.bear.middleground.comment.share.SharePermissionViewModel;
import com.bytedance.ee.bear.middleground.comment.uitls.p;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.widget.recyclerview.CommonRecyclerView;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class AsideComment extends com.bytedance.ee.bear.middleground.comment.card.b {
    public final p e;
    public final z f;
    public final y g;
    public final SharePermissionViewModel h;
    public final View i;
    public final CommonRecyclerView j;
    public final TextView k;
    public final View l;
    public final AsidePageAdapter m;
    public final com.bytedance.ee.bear.middleground.comment.card.d n;
    public Job o;
    public final a p;
    public AsideComment$dismiss$2 q;

    public static final class a {
        public final RecyclerView a;
        public final Channel<C0058a> b;
        public final StateFlowImpl c;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.comment.card.aside.AsideComment$a$a, reason: collision with other inner class name */
        public static final class C0058a {
            public final String a;
            public final Function1<Continuation<? super Unit>, Object> b;

            public C0058a(String r2, Function1<? super Continuation<? super Unit>, ? extends Object> r3) {
                Intrinsics.checkNotNullParameter(r2, "tag");
                Intrinsics.checkNotNullParameter(r3, "task");
                this.a = r2;
                this.b = r3;
            }
        }

        public a(p r9, CommonRecyclerView r10) {
            Intrinsics.checkNotNullParameter(r9, "config");
            Intrinsics.checkNotNullParameter(r10, "cardRecyclerView");
            this.a = r10;
            this.b = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
            this.c = j1.a(Integer.valueOf(r10.getScrollState()));
            r10.addOnScrollListener(new AsideComment$CommentHandler$1(this));
            Fragment r11 = r9.b;
            if (r11 == null) goto L8;
            LifecycleCoroutineScope r2 = LifecycleOwnerKt.getLifecycleScope(r11);
            if (r2 == null) goto L9;
            BuildersKt.launch$default(r2, Dispatchers.getMain().getImmediate(), null, new AsideComment$CommentHandler$2(this, null), 2, null);
            return;
        L9:
            return;
        }

        public static final Object a(a r5, Continuation r6) {
            r5.getClass();
            if ((r6 instanceof AsideComment$CommentHandler$awaitScrollIdle$1) == false) goto L7;
            AsideComment$CommentHandler$awaitScrollIdle$1 r0 = (AsideComment$CommentHandler$awaitScrollIdle$1) r6;
            int r1 = r0.label;
            if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
            r0.label = r1 - Integer.MIN_VALUE;
        L8:
            Object r7 = r0.result;
            Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r3 = r0.label;
            if (r3 == 0) goto L16;
            if (r3 == 1) goto L15;
            if (r3 != 2) goto L14;
            ResultKt.throwOnFailure(r7);
        L23:
            return Unit.INSTANCE;
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L15:
            ResultKt.throwOnFailure(r7);
        L19:
            RecyclerView r8 = r5.a;
            r0.label = 2;
            if (com.bytedance.ee.bear.middleground.comment.card.aside.b.a(r8, r0) != r2) goto L23;
            return r2;
        L16:
            ResultKt.throwOnFailure(r7);
            final StateFlowImpl r9 = r5.c;
            Flow<Integer> r4 = new AsideComment$CommentHandler$awaitScrollIdle$$inlined$filter$1(r9);
            r0.label = 1;
            if (kotlinx.coroutines.flow.e.s(r4, r0) != r2) goto L19;
            return r2;
        L7:
            r0 = new AsideComment$CommentHandler$awaitScrollIdle$1(r5, r6);
            goto L8
        }

        public final void b(String r3, Function1<? super Continuation<? super Unit>, ? extends Object> r4) {
            Intrinsics.checkNotNullParameter(r3, "tag");
            Intrinsics.checkNotNullParameter(r4, "task");
            this.b.trySend-JP2dKIU(new C0058a(r3, r4));
        }
    }

    public static final class b {
    }

    public static final class c implements Runnable {
        public final /* synthetic */ View a;
        public final /* synthetic */ AsideComment b;

        public c(View r1, AsideComment r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            Rect r0 = new Rect();
            this.a.getGlobalVisibleRect(r0);
            if ((this.b.i.getBottom() - 30) >= r0.bottom) goto L8;
            AsidePageAdapter r1 = this.b.m;
            RecyclerView r2 = r1.P0(r1.o);
            if (r2 == null) goto L9;
            r2.scrollBy(0, this.a.getHeight());
            return;
        L9:
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final void E7(String r2) {
        Intrinsics.checkNotNullParameter(r2, "commentId");
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final void IX() {
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final void LM() {
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final void RL(com.bytedance.ee.bear.middleground.comment.export.bean.a r1) {
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final void bG(String r1, List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r2, SmartReplyDataForInsert r3) {
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final void eX(com.bytedance.ee.bear.middleground.comment.export.bean.a r1) {
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final String UT() {
        return this.n.f(this.m.o);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final boolean isShowing() {
        if (this.i.getParent() == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.b, com.bytedance.ee.bear.middleground.comment.card.p1
    public final void t2() {
        this.m.A2();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final View getRootView() {
        return this.i;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final q1 jV() {
        return this.m;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final com.bytedance.ee.bear.middleground.comment.card.d z7() {
        return this.n;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.bytedance.ee.bear.middleground.comment.card.aside.AsideComment$dismiss$2, java.lang.Runnable] */
    @Override // com.bytedance.ee.bear.middleground.comment.card.b, com.bytedance.ee.bear.middleground.comment.card.p1
    public final void Ni(final boolean r4) {
        AsideComment$dismiss$2 r0 = this.q;
        if (r0 == null) goto L5;
        com.bytedance.ee.util.ui.j.e(r0);
    L5:
        this.f.z0().invoke(Boolean.FALSE);
        ?? r1 = new AsideComment$dismiss$2(this, r4);
        this.q = r1;
        com.bytedance.ee.util.ui.j.d(r1, 250);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final void Qa(FocusInputBean r12) {
        Intrinsics.checkNotNullParameter(r12, "focusInputBean");
        Intrinsics.checkNotNullParameter(r12, "focusInputBean");
        if (this.e.q.getComment() == true) goto L6;
        tt5.a.k("Comment#AsideComment", "focusInput: not comment permission");
        return;
    L6:
        tt5.a.h("Comment#AsideComment", "focusInput: " + r12);
        String r0 = r12.getCommentId();
        if (r0 == null) goto L22;
        CommentBean r2 = c(r0);
        if (r2 == null) goto L25;
        int r1 = r12.getType();
        if (r1 != 0) goto L14;
        tt5.a.k("Comment#AsideComment", "unsupported type");
        return;
    L14:
        if (r1 != 1) goto L16;
        int r3 = com.bytedance.ee.bear.middleground.comment.input.utils.c.a;
        com.bytedance.ee.bear.middleground.comment.input.utils.c.a(r2, r12.getReplyId(), this.e, this.f, r12.getFrom());
        return;
    L16:
        if (r1 != 2) goto L26;
        int r13 = com.bytedance.ee.bear.middleground.comment.input.utils.b.a;
        this.m.y2(com.bytedance.ee.bear.middleground.comment.input.utils.b.a(r2, this.e, 2, null, null, null, null, null, 504));
        return;
    L26:
        return;
    L25:
        return;
    }

    public final CommentBean c(String r2) {
        int r3 = this.n.i(r2);
        if (r3 != (-1)) goto L7;
        tt5.a.h("Comment#AsideComment", "insertToReply: commentId fail");
        return null;
    L7:
        return this.n.e(Integer.valueOf(r3));
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final void hc(ScrollCommentBean r4) {
        Intrinsics.checkNotNullParameter(r4, "scrollCommentBean");
        this.p.b("commentCardScrollTo", new AsideComment$commentCardScrollTo$1(this, r4, null));
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final void qN(boolean r6) {
        this.h.d();
        AsidePageAdapter r0 = this.m;
        Iterator r1 = ((LinkedHashMap) r0.m).keySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L16;
        int r2 = ((Number) r1.next()).intValue();
        List<CommentBean> r3 = r0.c;
        if (r3 == null) goto L8;
        int r4 = r3.size();
    L9:
        if (r2 >= r4) goto L4;
        Map<Integer, AsidePageAdapter.ViewHolder> r5 = r0.m;
        LinkedHashMap r7 = (LinkedHashMap) r5;
        AsidePageAdapter.ViewHolder r8 = (AsidePageAdapter.ViewHolder) r7.get(Integer.valueOf(r2));
        if (r8 == null) goto L24;
        RecyclerView r9 = r8.f;
        if (r9 == null) goto L25;
        r0.C2(r9, r2, r6);
        goto L4
    L25:
        return;
    L24:
        return;
    L8:
        r4 = 0;
        goto L9
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final void r20(View r4) {
        Intrinsics.checkNotNullParameter(r4, "itemView");
        r4.postDelayed(new c(r4, this), 200);
    }

    public static final /* synthetic */ void b(AsideComment r0, boolean r1) {
        super.Ni(r1);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final void Q6(String r2, Integer r3) {
        Intrinsics.checkNotNullParameter(r2, "commentId");
        this.n.s(r2, r3);
        this.n.g = r3;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.b, com.bytedance.ee.bear.middleground.comment.card.p1
    public final void fj(String r8, Integer r9) {
        Intrinsics.checkNotNullParameter(r8, "targetId");
        super.fj(r8, r9);
        AsideComment$dismiss$2 r0 = this.q;
        if (r0 == null) goto L5;
        com.bytedance.ee.util.ui.j.e(r0);
    L5:
        int r1 = com.bytedance.ee.bear.middleground.comment.card.a.a;
        this.n.s(r8, r9);
        this.h.n();
        MutableLiveData<List<CommentBean>> r10 = this.n.f;
        if (r10 == null) goto L8;
        r10.removeObservers(this.e.getActivity());
    L8:
        Job r11 = this.o;
        ViewGroup r2 = null;
        if (r11 == null) goto L11;
        Job.DefaultImpls.cancel$default(r11, null, 1, null);
    L11:
        Fragment r12 = this.e.b;
        if (r12 == null) goto L16;
        LifecycleCoroutineScope r3 = LifecycleOwnerKt.getLifecycleScope(r12);
        if (r3 == null) goto L16;
        Job r13 = BuildersKt.launch$default(r3, null, null, new AsideComment$show$2(this, null), 3, null);
    L17:
        this.o = r13;
        tt5.a.h("Comment#AsideComment", "show card comment");
        com.bytedance.ee.bear.middleground.comment.uitls.h r4 = this.e.d0;
        r4.c = false;
        r4.d("view_docs_message_sub_page", null, "", "", true);
        this.n.g = r9;
        ViewParent r14 = this.i.getParent();
        if ((r14 instanceof ViewGroup) == false) goto L20;
        r2 = (ViewGroup) r14;
    L20:
        if (r2 == null) goto L22;
        r2.removeView(this.i);
    L22:
        this.i.setLayoutParams(new FrameLayout.LayoutParams(y9c.d.a(296), -1));
        FrameLayout r15 = this.e.d;
        if (r15 == null) goto L25;
        View r16 = this.i;
        r15.addView(r16, r16.getLayoutParams());
    L25:
        Function1<Boolean, Unit> r17 = this.f.n();
        if (r17 == null) goto L28;
        r17.invoke(Boolean.TRUE);
    L28:
        this.e.N.a(new ef5.i(this.n.k));
        return;
    L16:
        r13 = null;
        goto L17
    }

    public AsideComment(p r18, Comment r19, t r20, y r21) {
        SharePermissionViewModel r5 = new SharePermissionViewModel(r18);
        Intrinsics.checkNotNullParameter(r18, "config");
        Intrinsics.checkNotNullParameter(r19, "commentListeners");
        Intrinsics.checkNotNullParameter(r20, "dataControl");
        Intrinsics.checkNotNullParameter(r21, "actionControl");
        Intrinsics.checkNotNullParameter(r5, "sharePermissionViewModel");
        super(r18, r19, r20, r21);
        this.e = r18;
        this.f = r19;
        this.g = r21;
        this.h = r5;
        z r11 = null;
        View r9 = LayoutInflater.from(r18.getActivity()).inflate(2131558726, null);
        this.i = r9;
        this.k = (TextView) r9.findViewById(2131367333);
        View r10 = r9.findViewById(2131366972);
        this.l = r10;
        r10.setOnClickListener(new com.bytedance.ee.bear.middleground.comment.card.aside.c(this));
        CommonRecyclerView r12 = r9.findViewById(2131369306);
        this.j = r12;
        a r13 = new a(r18, r12);
        this.p = r13;
        r12.h = false;
        DefaultItemAnimator r14 = r12.getItemAnimator();
        if ((r14 instanceof DefaultItemAnimator) == false) goto L5;
        DefaultItemAnimator r15 = r14;
    L6:
        if (r15 == null) goto L8;
        r15.setSupportsChangeAnimations(false);
    L8:
        r12.setItemAnimator(null);
        final FragmentActivity r16 = r18.getActivity();
        r12.setLayoutManager(new AnonymousClass2(r16));
        r12.addItemDecoration(new AnonymousClass3(this));
        AsidePageAdapter r17 = new AsidePageAdapter(r12, r13);
        this.m = r17;
        final Ref.BooleanRef r110 = new Ref.BooleanRef();
        r12.addOnItemTouchListener(new AnonymousClass4(r110, this));
        r12.addOnScrollListener(new AnonymousClass5(this, r110));
        com.bytedance.ee.bear.middleground.comment.card.d r111 = new com.bytedance.ee.bear.middleground.comment.card.d();
        this.n = r111;
        r111.k(r18.i, r20);
        FragmentActivity r3 = r18.getActivity();
        o r112 = r18.q;
        String r22 = ((i0) org.koin.java.a.c(i0.class, null, null, 6)).a();
        Function0<Unit> r113 = new AnonymousClass6(this);
        Intrinsics.checkNotNullParameter(r18, "config");
        Intrinsics.checkNotNullParameter(r3, "activity");
        Intrinsics.checkNotNullParameter(r112, "per");
        Intrinsics.checkNotNullParameter(r22, "language");
        Intrinsics.checkNotNullParameter(r19, "listeners");
        Intrinsics.checkNotNullParameter(r21, "actionControl");
        Intrinsics.checkNotNullParameter(r111, "cardDataViewModel");
        Intrinsics.checkNotNullParameter(r5, "sharePermissionViewModel");
        Intrinsics.checkNotNullParameter(r113, "clickLink");
        r17.d = r18;
        r17.e = r3;
        r17.f = r22;
        r17.h = r19;
        r17.i = r21;
        r17.j = r111;
        r17.k = r5;
        r17.l = r113;
        if (r18.getActivity().getResources().getConfiguration().orientation == 2) goto L11;
        boolean r4 = true;
    L12:
        r17.n = r4;
        RecyclerView r6 = r17.a;
        Map<Integer, AsidePageAdapter.ViewHolder> r7 = r17.m;
        z r8 = r17.h;
        if (r8 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mIListeners");
    L16:
        r17.s = new AlignAndScrollManager(r18, r6, r7, r11);
        r12.setAdapter(r17);
        r9.setOnClickListener(new d(this));
        r12.setOnClickListener(new e(this));
        Comment$inputCommentFunction$1 r1 = r19.s;
        Function1<CommentInputRequest, Unit> r23 = new AnonymousClass9(this);
        r1.getClass();
        Intrinsics.checkNotNullParameter(r23, "<set-?>");
        r1.a = r23;
        Comment$inputCommentFunction$1 r2 = r19.s;
        Function1<CommentInputRequest, Unit> r24 = new AnonymousClass10(this);
        r2.getClass();
        Intrinsics.checkNotNullParameter(r24, "<set-?>");
        r2.b = r24;
        return;
    L15:
        r11 = r8;
        goto L16
    L11:
        r4 = false;
        goto L12
    L5:
        r15 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final void XC(String r11, String r12, String r13, String r14) {
        Intrinsics.checkNotNullParameter(r11, "content");
        Intrinsics.checkNotNullParameter(r12, "commentId");
        Intrinsics.checkNotNullParameter(r13, "replyId");
        Intrinsics.checkNotNullParameter(r14, "aiReplyId");
        CommentBean r1 = c(r12);
        if (r1 != null) goto L5;
        return;
    L5:
        SmartReplyDataForInsert r7 = new SmartReplyDataForInsert();
        r7.setAiReplyId(r14);
        r7.setReplyId(r13);
        r7.setCommentId(r12);
        r7.setText(r11);
        int r15 = com.bytedance.ee.bear.middleground.comment.input.utils.b.a;
        CommentInputRequest r16 = com.bytedance.ee.bear.middleground.comment.input.utils.b.a(r1, this.e, 2, null, r11, null, r7, null, 360);
        this.m.y2(r16);
    }
}
