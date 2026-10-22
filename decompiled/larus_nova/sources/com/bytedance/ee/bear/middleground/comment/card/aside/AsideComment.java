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
import com.larus.nova.R;
import com.ss.android.lark.widget.recyclerview.CommonRecyclerView;
import com.ss.ttm.player.MediaPlayer;
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

/* JADX INFO: loaded from: classes18.dex */
public final class AsideComment extends com.bytedance.ee.bear.middleground.comment.card.b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final p f230881e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final z f230882f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final y f230883g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final SharePermissionViewModel f230884h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final View f230885i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final CommonRecyclerView f230886j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final TextView f230887k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final View f230888l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final AsidePageAdapter f230889m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final com.bytedance.ee.bear.middleground.comment.card.d f230890n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Job f230891o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final a f230892p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public AsideComment$dismiss$2 f230893q;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final RecyclerView f230902a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Channel<C3305a> f230903b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final StateFlowImpl f230904c;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.comment.card.aside.AsideComment$a$a, reason: collision with other inner class name */
        public static final class C3305a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f230905a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final Function1<Continuation<? super Unit>, Object> f230906b;

            /* JADX WARN: Multi-variable type inference failed */
            public C3305a(String r100, Function1<? super Continuation<? super Unit>, ? extends Object> r101) {
                Intrinsics.checkNotNullParameter(r100, "tag");
                Intrinsics.checkNotNullParameter(r101, "task");
                this.f230905a = r100;
                this.f230906b = r101;
            }
        }

        public a(p r100, CommonRecyclerView r110) {
            Intrinsics.checkNotNullParameter(r100, "config");
            Intrinsics.checkNotNullParameter(r110, "cardRecyclerView");
            this.f230902a = r110;
            this.f230903b = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
            this.f230904c = j1.a(Integer.valueOf(r110.getScrollState()));
            r110.addOnScrollListener(new AsideComment$CommentHandler$1(this));
            Fragment r101 = r100.f232220b;
            if (r101 == null) goto L8;
            LifecycleCoroutineScope r102 = LifecycleOwnerKt.getLifecycleScope(r101);
            if (r102 == null) goto L9;
            BuildersKt.launch$default(r102, Dispatchers.getMain().getImmediate(), null, new AsideComment$CommentHandler$2(this, null), 2, null);
            return;
        L9:
            return;
        }

        public static final Object a(a r100, Continuation r101) {
            r100.getClass();
            if ((r101 instanceof AsideComment$CommentHandler$awaitScrollIdle$1) == false) goto L7;
            AsideComment$CommentHandler$awaitScrollIdle$1 r102 = (AsideComment$CommentHandler$awaitScrollIdle$1) r101;
            int r103 = r102.label;
            if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
            r102.label = r103 - Integer.MIN_VALUE;
        L8:
            Object r104 = r102.result;
            Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r106 = r102.label;
            if (r106 == 0) goto L16;
            if (r106 == 1) goto L15;
            if (r106 != 2) goto L14;
            ResultKt.throwOnFailure(r104);
        L23:
            return Unit.INSTANCE;
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L15:
            ResultKt.throwOnFailure(r104);
        L19:
            RecyclerView r107 = r100.f230902a;
            r102.label = 2;
            if (com.bytedance.ee.bear.middleground.comment.card.aside.b.a(r107, r102) != r105) goto L23;
            return r105;
        L16:
            ResultKt.throwOnFailure(r104);
            final StateFlowImpl r108 = r100.f230904c;
            Flow<Integer> r109 = new AsideComment$CommentHandler$awaitScrollIdle$$inlined$filter$1(r108);
            r102.label = 1;
            if (kotlinx.coroutines.flow.e.s(r109, r102) != r105) goto L19;
            return r105;
        L7:
            r102 = new AsideComment$CommentHandler$awaitScrollIdle$1(r100, r101);
            goto L8
        }

        public final void b(String r100, Function1<? super Continuation<? super Unit>, ? extends Object> r101) {
            Intrinsics.checkNotNullParameter(r100, "tag");
            Intrinsics.checkNotNullParameter(r101, "task");
            this.f230903b.mo10962trySendJP2dKIU(new C3305a(r100, r101));
        }
    }

    public static final class b {
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f230907a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AsideComment f230908b;

        public c(View r100, AsideComment r101) {
            this.f230907a = r100;
            this.f230908b = r101;
        }

        public final void a() {
            Rect r100 = new Rect();
            this.f230907a.getGlobalVisibleRect(r100);
            if ((this.f230908b.f230885i.getBottom() - 30) >= r100.bottom) goto L8;
            AsidePageAdapter r101 = this.f230908b.f230889m;
            RecyclerView r102 = r101.P0(r101.f230927o);
            if (r102 == null) goto L9;
            r102.scrollBy(0, this.f230907a.getHeight());
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
    public final void E7(String r100) {
        Intrinsics.checkNotNullParameter(r100, "commentId");
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final void IX() {
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final void LM() {
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final void RL(com.bytedance.ee.bear.middleground.comment.export.bean.a r100) {
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final void bG(String r100, List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r101, SmartReplyDataForInsert r102) {
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final void eX(com.bytedance.ee.bear.middleground.comment.export.bean.a r100) {
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final String UT() {
        return this.f230890n.f(this.f230889m.f230927o);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final boolean isShowing() {
        if (this.f230885i.getParent() == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.b, com.bytedance.ee.bear.middleground.comment.card.p1
    public final void t2() {
        this.f230889m.A2();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final View getRootView() {
        return this.f230885i;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final q1 jV() {
        return this.f230889m;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final com.bytedance.ee.bear.middleground.comment.card.d z7() {
        return this.f230890n;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.bytedance.ee.bear.middleground.comment.card.aside.AsideComment$dismiss$2, java.lang.Runnable] */
    @Override // com.bytedance.ee.bear.middleground.comment.card.b, com.bytedance.ee.bear.middleground.comment.card.p1
    public final void Ni(final boolean r100) {
        AsideComment$dismiss$2 r101 = this.f230893q;
        if (r101 == null) goto L5;
        com.bytedance.ee.util.ui.j.e(r101);
    L5:
        this.f230882f.z0().invoke(Boolean.FALSE);
        ?? r102 = new AsideComment$dismiss$2(this, r100);
        this.f230893q = r102;
        com.bytedance.ee.util.ui.j.d(r102, 250);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final void Qa(FocusInputBean r110) {
        Intrinsics.checkNotNullParameter(r110, "focusInputBean");
        Intrinsics.checkNotNullParameter(r110, "focusInputBean");
        if (this.f230881e.f232241q.getComment() == true) goto L6;
        tt5.a.k("Comment#AsideComment", "focusInput: not comment permission");
        return;
    L6:
        tt5.a.h("Comment#AsideComment", "focusInput: " + r110);
        String r100 = r110.getCommentId();
        if (r100 == null) goto L22;
        CommentBean r101 = c(r100);
        if (r101 == null) goto L25;
        int r102 = r110.getType();
        if (r102 != 0) goto L14;
        tt5.a.k("Comment#AsideComment", "unsupported type");
        return;
    L14:
        if (r102 != 1) goto L16;
        int r103 = com.bytedance.ee.bear.middleground.comment.input.utils.c.f232007a;
        com.bytedance.ee.bear.middleground.comment.input.utils.c.a(r101, r110.getReplyId(), this.f230881e, this.f230882f, r110.getFrom());
        return;
    L16:
        if (r102 != 2) goto L26;
        int r111 = com.bytedance.ee.bear.middleground.comment.input.utils.b.f232006a;
        this.f230889m.y2(com.bytedance.ee.bear.middleground.comment.input.utils.b.a(r101, this.f230881e, 2, null, null, null, null, null, 504));
        return;
    L26:
        return;
    L25:
        return;
    }

    public final CommentBean c(String r100) {
        int r101 = this.f230890n.i(r100);
        if (r101 != (-1)) goto L7;
        tt5.a.h("Comment#AsideComment", "insertToReply: commentId fail");
        return null;
    L7:
        return this.f230890n.e(Integer.valueOf(r101));
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final void hc(ScrollCommentBean r100) {
        Intrinsics.checkNotNullParameter(r100, "scrollCommentBean");
        this.f230892p.b("commentCardScrollTo", new AsideComment$commentCardScrollTo$1(this, r100, null));
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final void qN(boolean r100) {
        this.f230884h.d();
        AsidePageAdapter r101 = this.f230889m;
        Iterator r102 = ((LinkedHashMap) r101.f230925m).keySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L16;
        int r103 = ((Number) r102.next()).intValue();
        List<CommentBean> r104 = r101.f230915c;
        if (r104 == null) goto L8;
        int r105 = r104.size();
    L9:
        if (r103 >= r105) goto L4;
        Map<Integer, AsidePageAdapter.ViewHolder> r106 = r101.f230925m;
        LinkedHashMap r107 = (LinkedHashMap) r106;
        AsidePageAdapter.ViewHolder r108 = (AsidePageAdapter.ViewHolder) r107.get(Integer.valueOf(r103));
        if (r108 == null) goto L24;
        RecyclerView r109 = r108.f230938f;
        if (r109 == null) goto L25;
        r101.C2(r109, r103, r100);
        goto L4
    L25:
        return;
    L24:
        return;
    L8:
        r105 = 0;
        goto L9
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final void r20(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        r100.postDelayed(new c(r100, this), 200);
    }

    public static final /* synthetic */ void b(AsideComment r100, boolean r101) {
        super.Ni(r101);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final void Q6(String r100, Integer r101) {
        Intrinsics.checkNotNullParameter(r100, "commentId");
        this.f230890n.s(r100, r101);
        this.f230890n.f230965g = r101;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.b, com.bytedance.ee.bear.middleground.comment.card.p1
    public final void fj(String r100, Integer r101) {
        Intrinsics.checkNotNullParameter(r100, "targetId");
        super.fj(r100, r101);
        AsideComment$dismiss$2 r102 = this.f230893q;
        if (r102 == null) goto L5;
        com.bytedance.ee.util.ui.j.e(r102);
    L5:
        int r103 = com.bytedance.ee.bear.middleground.comment.card.a.f230868a;
        this.f230890n.s(r100, r101);
        this.f230884h.n();
        MutableLiveData<List<CommentBean>> r104 = this.f230890n.f230964f;
        if (r104 == null) goto L8;
        r104.removeObservers(this.f230881e.getActivity());
    L8:
        Job r105 = this.f230891o;
        ViewGroup r106 = null;
        if (r105 == null) goto L11;
        Job.DefaultImpls.cancel$default(r105, null, 1, null);
    L11:
        Fragment r107 = this.f230881e.f232220b;
        if (r107 == null) goto L16;
        LifecycleCoroutineScope r108 = LifecycleOwnerKt.getLifecycleScope(r107);
        if (r108 == null) goto L16;
        Job r109 = BuildersKt.launch$default(r108, null, null, new AsideComment$show$2(this, null), 3, null);
    L17:
        this.f230891o = r109;
        tt5.a.h("Comment#AsideComment", "show card comment");
        com.bytedance.ee.bear.middleground.comment.uitls.h r110 = this.f230881e.f232225d0;
        r110.f232205c = false;
        r110.d("view_docs_message_sub_page", null, "", "", true);
        this.f230890n.f230965g = r101;
        ViewParent r111 = this.f230885i.getParent();
        if ((r111 instanceof ViewGroup) == false) goto L20;
        r106 = (ViewGroup) r111;
    L20:
        if (r106 == null) goto L22;
        r106.removeView(this.f230885i);
    L22:
        this.f230885i.setLayoutParams(new FrameLayout.LayoutParams(y9c.d.a(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_BUFFER_THRESHOLD_CONTROL), -1));
        FrameLayout r112 = this.f230881e.f232224d;
        if (r112 == null) goto L25;
        View r113 = this.f230885i;
        r112.addView(r113, r113.getLayoutParams());
    L25:
        Function1<Boolean, Unit> r114 = this.f230882f.n();
        if (r114 == null) goto L28;
        r114.invoke(Boolean.TRUE);
    L28:
        this.f230881e.N.a(new ef5.i(this.f230890n.f230969k));
        return;
    L16:
        r109 = null;
        goto L17
    }

    public AsideComment(p r110, Comment r111, t r210, y r211) {
        SharePermissionViewModel r100 = new SharePermissionViewModel(r110);
        Intrinsics.checkNotNullParameter(r110, "config");
        Intrinsics.checkNotNullParameter(r111, "commentListeners");
        Intrinsics.checkNotNullParameter(r210, "dataControl");
        Intrinsics.checkNotNullParameter(r211, "actionControl");
        Intrinsics.checkNotNullParameter(r100, "sharePermissionViewModel");
        super(r110, r111, r210, r211);
        this.f230881e = r110;
        this.f230882f = r111;
        this.f230883g = r211;
        this.f230884h = r100;
        z r112 = null;
        View r101 = LayoutInflater.from(r110.getActivity()).inflate(R.layout.aside_comment_page_layout, null);
        this.f230885i = r101;
        this.f230887k = (TextView) r101.findViewById(R.id.comment_count);
        View r113 = r101.findViewById(R.id.close);
        this.f230888l = r113;
        r113.setOnClickListener(new com.bytedance.ee.bear.middleground.comment.card.aside.c(this));
        CommonRecyclerView r114 = (CommonRecyclerView) r101.findViewById(R.id.doc_comment_page);
        this.f230886j = r114;
        a r115 = new a(r110, r114);
        this.f230892p = r115;
        r114.f448123h = false;
        RecyclerView.ItemAnimator r116 = r114.getItemAnimator();
        if ((r116 instanceof DefaultItemAnimator) == false) goto L5;
        DefaultItemAnimator r117 = (DefaultItemAnimator) r116;
    L6:
        if (r117 == null) goto L8;
        r117.setSupportsChangeAnimations(false);
    L8:
        r114.setItemAnimator(null);
        final FragmentActivity r118 = r110.getActivity();
        r114.setLayoutManager(new AnonymousClass2(r118));
        r114.addItemDecoration(new AnonymousClass3(this));
        AsidePageAdapter r119 = new AsidePageAdapter(r114, r115);
        this.f230889m = r119;
        final Ref.BooleanRef r120 = new Ref.BooleanRef();
        r114.addOnItemTouchListener(new AnonymousClass4(r120, this));
        r114.addOnScrollListener(new AnonymousClass5(this, r120));
        com.bytedance.ee.bear.middleground.comment.card.d r121 = new com.bytedance.ee.bear.middleground.comment.card.d();
        this.f230890n = r121;
        r121.k(r110.f232233i, r210);
        FragmentActivity r102 = r110.getActivity();
        o r122 = r110.f232241q;
        String r103 = ((i0) org.koin.java.a.c(i0.class, null, null, 6)).a();
        Function0<Unit> r123 = new AnonymousClass6(this);
        Intrinsics.checkNotNullParameter(r110, "config");
        Intrinsics.checkNotNullParameter(r102, "activity");
        Intrinsics.checkNotNullParameter(r122, "per");
        Intrinsics.checkNotNullParameter(r103, "language");
        Intrinsics.checkNotNullParameter(r111, "listeners");
        Intrinsics.checkNotNullParameter(r211, "actionControl");
        Intrinsics.checkNotNullParameter(r121, "cardDataViewModel");
        Intrinsics.checkNotNullParameter(r100, "sharePermissionViewModel");
        Intrinsics.checkNotNullParameter(r123, "clickLink");
        r119.f230916d = r110;
        r119.f230917e = r102;
        r119.f230918f = r103;
        r119.f230920h = r111;
        r119.f230921i = r211;
        r119.f230922j = r121;
        r119.f230923k = r100;
        r119.f230924l = r123;
        if (r110.getActivity().getResources().getConfiguration().orientation == 2) goto L11;
        boolean r104 = true;
    L12:
        r119.f230926n = r104;
        RecyclerView r105 = r119.f230913a;
        Map<Integer, AsidePageAdapter.ViewHolder> r106 = r119.f230925m;
        z r107 = r119.f230920h;
        if (r107 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mIListeners");
    L16:
        r119.f230931s = new AlignAndScrollManager(r110, r105, r106, r112);
        r114.setAdapter(r119);
        r101.setOnClickListener(new d(this));
        r114.setOnClickListener(new e(this));
        Comment$inputCommentFunction$1 r108 = r111.f230050s;
        Function1<CommentInputRequest, Unit> r109 = new AnonymousClass9(this);
        r108.getClass();
        Intrinsics.checkNotNullParameter(r109, "<set-?>");
        r108.f230083a = r109;
        Comment$inputCommentFunction$1 r124 = r111.f230050s;
        Function1<CommentInputRequest, Unit> r125 = new AnonymousClass10(this);
        r124.getClass();
        Intrinsics.checkNotNullParameter(r125, "<set-?>");
        r124.f230084b = r125;
        return;
    L15:
        r112 = r107;
        goto L16
    L11:
        r104 = false;
        goto L12
    L5:
        r117 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final void XC(String r110, String r111, String r112, String r113) {
        Intrinsics.checkNotNullParameter(r110, "content");
        Intrinsics.checkNotNullParameter(r111, "commentId");
        Intrinsics.checkNotNullParameter(r112, "replyId");
        Intrinsics.checkNotNullParameter(r113, "aiReplyId");
        CommentBean r100 = c(r111);
        if (r100 != null) goto L5;
        return;
    L5:
        SmartReplyDataForInsert r101 = new SmartReplyDataForInsert();
        r101.setAiReplyId(r113);
        r101.setReplyId(r112);
        r101.setCommentId(r111);
        r101.setText(r110);
        int r114 = com.bytedance.ee.bear.middleground.comment.input.utils.b.f232006a;
        CommentInputRequest r115 = com.bytedance.ee.bear.middleground.comment.input.utils.b.a(r100, this.f230881e, 2, null, r110, null, r101, null, 360);
        this.f230889m.y2(r115);
    }
}
