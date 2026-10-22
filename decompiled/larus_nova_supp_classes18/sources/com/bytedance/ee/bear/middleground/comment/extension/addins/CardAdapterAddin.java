package com.bytedance.ee.bear.middleground.comment.extension.addins;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.facade.common.widget.BearLottieView;
import com.bytedance.ee.bear.middleground.comment.adapter.BaseContentViewHolder;
import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter2;
import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapterHelper;
import com.bytedance.ee.bear.middleground.comment.adapter.HalfScreenCardAdapter;
import com.bytedance.ee.bear.middleground.comment.adapter.ReactionViewHolder;
import com.bytedance.ee.bear.middleground.comment.bitablediscuss.BitableDiscussListAdapter;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.Reaction;
import com.bytedance.ee.bear.middleground.comment.export.bean.ReactionDetailUserInfo;
import com.bytedance.ee.bear.middleground.comment.export.bean.TranslateConfig;
import com.bytedance.ee.bear.middleground.comment.extension.events.CardAdapterActionType;
import com.bytedance.ee.bear.middleground.comment.widget.SmartReplyPreview;
import com.ss.android.lark.reaction.widget.flowlayout.ReactionFlowLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class CardAdapterAddin extends com.bytedance.ee.bear.middleground.comment.extension.addins.b {
    public com.bytedance.ee.bear.middleground.comment.uitls.p b;
    public com.bytedance.ee.bear.middleground.comment.control.y c;
    public com.bytedance.ee.bear.middleground.comment.control.z d;

    public final class CardAdapterActionEventHandler extends ff5.a<ef5.b> {
        public final /* synthetic */ CardAdapterAddin a;

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[CardAdapterActionType.values().length];
                r0[CardAdapterActionType.SetReaction.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
            L13:
                r0[CardAdapterActionType.SetTranslateIcon.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
            L19:
                r0[CardAdapterActionType.SetContentReaction.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
            L15:
                r0[CardAdapterActionType.SetAnim.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
            L7:
                a = r0;
            }
        }

        public static final class b implements ReactionFlowLayout.a {
            public final /* synthetic */ CommentBean.CommentDetail a;
            public final /* synthetic */ CardAdapterAddin b;

            public b(CommentBean.CommentDetail r1, CardAdapterAddin r2) {
                this.a = r1;
                this.b = r2;
            }

            public final void a(String r8) {
                com.bytedance.ee.bear.middleground.comment.control.z r1 = null;
                List<Reaction> r2 = this.a.getReaction();     // Catch: Exception -> L32
                if (r2 == null) goto L27;
                Iterator<T> r3 = r2.iterator();     // Catch: Exception -> L32
                boolean r4 = false;
            L7:
                if (r3.hasNext() == false) goto L28;
                Reaction r5 = (Reaction) r3.next();     // Catch: Exception -> L32
                if (r5 == null) goto L24;
                List<ReactionDetailUserInfo> r6 = r5.getUserList();     // Catch: Exception -> L32
                if (r6 == null) goto L24;
                Iterator<T> r7 = r6.iterator();     // Catch: Exception -> L32
            L14:
                if (r7.hasNext() == false) goto L22;
                Object r9 = r7.next();     // Catch: Exception -> L32
                ReactionDetailUserInfo r10 = (ReactionDetailUserInfo) r9;     // Catch: Exception -> L32
                if (r10 == null) goto L18;
                String r11 = r10.getUserId();     // Catch: Exception -> L32
            L20:
                if (Intrinsics.areEqual(r11, r8) == false) goto L14;
            L23:
                ReactionDetailUserInfo r12 = (ReactionDetailUserInfo) r9;     // Catch: Exception -> L32
            L25:
                if (r12 == null) goto L7;
                r4 = r12.isAnonymous();     // Catch: Exception -> L32
                goto L7
            L18:
                r11 = null;
                goto L20
            L22:
                r9 = null;
            L24:
                r12 = null;
            L28:
                if (r4 == true) goto L34;
                this.b.d().h.getClass();     // Catch: Exception -> L32
                if (com.bytedance.ee.bear.middleground.comment.p.c() == true) goto L52;
            L36:
                com.bytedance.ee.bear.middleground.comment.control.z r0 = this.b.d;
                if (r0 != null) goto L39;
                Intrinsics.throwUninitializedPropertyAccessException("commentListeners");
            L40:
                r1.s0().invoke(r8);
                return;
            L39:
                r1 = r0;
                goto L40
            L52:
                return;
            L34:
                return;
            L27:
                r4 = false;
            L32:
                e = move-exception;
                tt5.a.f("Comment#CardAdapterAddin", e, false);
                goto L36
            }
        }

        public CardAdapterActionEventHandler(CardAdapterAddin r1) {
            this.a = r1;
        }

        @Override // ff5.a
        public final void b(gf5.c r13) {
            ef5.b r14 = (ef5.b) r13;
            Intrinsics.checkNotNullParameter(r14, "event");
            int r0 = a.a[r14.a.ordinal()];
            int r3 = 36;
            int r4 = 8;
            com.bytedance.ee.bear.middleground.comment.control.y r6 = null;
            Integer r7 = null;
            BaseContentViewHolder r8 = null;
            Integer r9 = null;
            r9 = null;
            if (r0 != 1) goto L5;
            RecyclerView.ViewHolder r1 = r14.c;
            if ((r1 instanceof BaseContentViewHolder) == false) goto L44;
            BaseContentViewHolder r2 = (BaseContentViewHolder) r1;
        L45:
            if (r2 == null) goto L124;
            CommentBean.CommentDetail r10 = r14.d;
            RecyclerView r15 = r14.b;
            List<? extends q2c.c> r11 = r10.getReactionFlowData();
            if (r11 == null) goto L61;
            if ((!r11.isEmpty()) == false) goto L61;
            ArrayList r12 = new ArrayList();
            Iterator r16 = r11.iterator();
        L52:
            if (r16.hasNext() == false) goto L59;
            Object r17 = r16.next();
            if (((q2c.c) r17).b <= 0) goto L56;
            boolean r18 = true;
        L57:
            if (r18 == false) goto L52;
            r12.add(r17);
            goto L52
        L56:
            r18 = false;
            goto L57
        L59:
            r11 = r12;
        L61:
            if (this.a.d().w == false) goto L106;
            if (r11 == null) goto L106;
            if (r11.isEmpty() == true) goto L106;
            tt5.a.h("Comment#CardAdapterAddin", "setReaction size:" + r11.size());
            List<Reaction> r5 = r10.getReaction();
            if (r5 == null) goto L69;
            tt5.a.h("Comment#CardAdapterAddin", "setReaction, reaction list = " + r5);
        L69:
            com.bytedance.ee.bear.middleground.comment.control.y r19 = this.a.c;
            com.bytedance.ee.bear.middleground.comment.control.y r20 = r19;
            if (r19 != null) goto L72;
            Intrinsics.throwUninitializedPropertyAccessException("actionControl");
            r20 = null;
        L72:
            r20.v(r10.getReply_id(), r11);
            c(r2.U3(), r10);
            if (r15 == null) goto L75;
            Integer r21 = Integer.valueOf(r15.getMeasuredWidth());
        L76:
            if (r21 != null) goto L78;
        L105:
            r2.U3().a(r11, true);
            r2.U3().setReactionClickListener(new m(this.a, r15, r10));
            r2.U3().setOnReactionMoreTrigger(new n(this.a, r10));
            return;
        L78:
            if ((r2 instanceof BitableDiscussListAdapter.BitableDiscussContentViewHolder) == false) goto L84;
            if (((BitableDiscussListAdapter.BitableDiscussContentViewHolder) r2).Z3() == false) goto L82;
            r3 = 76;
        L104:
            r2.U3().setReactionMaxWidth(r21.intValue() - cu5.c.b(r3));
            goto L105
        L82:
            r3 = 112;
            goto L104
        L84:
            if ((r2 instanceof HalfScreenCardAdapter.ContentViewHolder) == false) goto L86;
        L103:
            r3 = 80;
            goto L104
        L86:
            if (this.a.d().n.isAside() == true) goto L103;
            if ((r2 instanceof CardAdapter2.ContentViewHolder) == false) goto L101;
            if (r15 == null) goto L94;
            RecyclerView.Adapter r22 = r15.getAdapter();
            if (r22 == null) goto L94;
            r9 = Integer.valueOf(r22.getItemViewType(((CardAdapter2.ContentViewHolder) r2).getBindingAdapterPosition()));
        L94:
            int r23 = CardAdapterHelper.ItemType.WHOLE_CONTENT.getType();
            if (r9 == null) goto L104;
            if (r9.intValue() != r23) goto L104;
            r3 = 64;
            goto L104
        L101:
            if ((r2 instanceof CardAdapter.ViewHolder) == false) goto L103;
            com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.doc.image_region_comment_view");
            goto L103
        L75:
            r21 = null;
        L106:
            tt5.a.h("Comment#CardAdapterAddin", "setReaction but reactionFlowData is null or empty");
            r2.U3().setVisibility(8);
            com.bytedance.ee.bear.middleground.comment.control.y r110 = this.a.c;
            if (r110 != null) goto L109;
            Intrinsics.throwUninitializedPropertyAccessException("actionControl");
        L110:
            r6.v(r10.getReply_id(), new ArrayList());
            return;
        L109:
            r6 = r110;
            goto L110
        L124:
            return;
        L44:
            r2 = null;
            goto L45
        L5:
            if (r0 != 2) goto L7;
            RecyclerView.ViewHolder r24 = r14.c;
            if ((r24 instanceof BaseContentViewHolder) == false) goto L32;
            r8 = (BaseContentViewHolder) r24;
        L32:
            if (r8 == null) goto L122;
            CommentBean.CommentDetail r25 = r14.d;
            RecyclerView r111 = r14.b;
            BearLottieView r26 = r8.V3();
            Map<String, Boolean> r27 = nf5.a.a;
            TranslateConfig r28 = this.a.d().x;
            Intrinsics.checkNotNullParameter(r28, "config");
            Intrinsics.checkNotNullParameter(r25, "item");
            if (nf5.a.h(r28, r25.getReply_id(), r25.getTranslate_status()) == false) goto L36;
            r4 = 0;
        L36:
            r26.setVisibility(r4);
            if (Intrinsics.areEqual(r25.getTranslate_status(), "loading") == false) goto L39;
            r8.V3().playAnimation();
        L40:
            r8.V3().setOnClickListener(new o(r25, r111, r8, this.a));
            return;
        L39:
            r8.V3().cancelAnimation();
            r8.V3().setFrame(0);
            goto L40
        L122:
            return;
        L7:
            if (r0 != 3) goto L9;
            RecyclerView.ViewHolder r29 = r14.c;
            if ((r29 instanceof ReactionViewHolder) == false) goto L17;
            ReactionViewHolder r30 = (ReactionViewHolder) r29;
        L18:
            if (r30 == null) goto L120;
            CommentBean.CommentDetail r31 = r14.d;
            RecyclerView r112 = r14.b;
            List<q2c.c> r32 = r31.getReactionFlowData();
            c(r30.e, r31);
            if (r112 == null) goto L22;
            r7 = Integer.valueOf(r112.getMeasuredWidth());
        L22:
            if (r7 == null) goto L25;
            r30.e.setReactionMaxWidth(r7.intValue() - cu5.c.b(36));
        L25:
            if (this.a.d().q.getComment() == false) goto L27;
            r30.e.b(r32, true, 2131254308, new i(this, r30, r31));
            e(r30);
        L28:
            r30.e.setReactionClickListener(new j(this.a, r31, r30));
            r30.e.setOnReactionMoreTrigger(new k(this.a, r31));
            ((RecyclerView.ViewHolder) r30).itemView.setOnLongClickListener(new l(this, r30, r31));
            return;
        L27:
            r30.e.a(r32, true);
            goto L28
        L120:
            return;
        L17:
            r30 = null;
            goto L18
        L9:
            if (r0 == 4) goto L12;
            tt5.a.d("Comment#CardAdapterAddin", "actionType not exist");
            return;
        L12:
            if (this.a.d().n.isAside() == true) goto L118;
            this.a.e(r14.c, r14.d);
            return;
        }

        public final void e(ReactionViewHolder r3) {
            Intrinsics.checkNotNullParameter(r3, "holder");
            com.bytedance.ee.bear.middleground.comment.control.y r0 = this.a.c;
            if (r0 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("actionControl");
            r0 = null;
        L6:
            if (r0.k() == false) goto L8;
            int r1 = v2c.a.b(this.a.d().getActivity(), 2131101111);
        L9:
            r3.e.setExtendIconTint(r1);
            return;
        L8:
            r1 = v2c.a.b(this.a.d().getActivity(), 2131108724);
            goto L9
        }

        public final void c(ReactionFlowLayout r3, CommentBean.CommentDetail r4) {
            r3.setVisibility(0);
            r3.setNewReactionEnable(true);
            r3.setMaxNameCount(5);
            r3.setTagBackground(v2c.a.c(this.a.d().getActivity(), 2131248260));
            r3.setOnReactionNameTrigger(new b(r4, this.a));
        }

        public final void d(final ReactionViewHolder r4, CommentBean.CommentDetail r5) {
            Intrinsics.checkNotNullParameter(r4, "holder");
            Intrinsics.checkNotNullParameter(r5, "commentDetail");
            com.bytedance.ee.bear.middleground.comment.control.y r0 = this.a.c;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("actionControl");
            r0 = null;
        L5:
            r0.x(((RecyclerView.ViewHolder) r4).itemView, r5, new CardAdapterAddin$CardAdapterActionEventHandler$showContentReaction$1(this, r4));
            e(r4);
        }
    }

    public final class a extends ff5.a<ef5.c> {
        public a() {
        }

        @Override // ff5.a
        public final void b(gf5.c r4) {
            ef5.c r5 = (ef5.c) r4;
            Intrinsics.checkNotNullParameter(r5, "event");
            TextView r0 = r5.b;
            View r6 = r5.c;
            Intrinsics.checkNotNullParameter(r0, "textView");
            Intrinsics.checkNotNullParameter(r6, "tran");
            if (r0.getVisibility() == 0) goto L5;
            return;
        L5:
            if (r6.getVisibility() != 0) goto L10;
            r0.getViewTreeObserver().addOnPreDrawListener(new p(r0, r6));
            return;
        }
    }

    public static final class b {
    }

    public static final class c implements Animator.AnimatorListener {
        public final /* synthetic */ CardAdapterAddin a;
        public final /* synthetic */ View b;
        public final /* synthetic */ Drawable c;
        public final /* synthetic */ TextView d;
        public final /* synthetic */ Drawable e;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r1) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r1) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r1) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            com.bytedance.ee.bear.middleground.comment.card.d r3 = this.a.c();
            if (r3 == null) goto L5;
            r3.i = null;
        L5:
            com.bytedance.ee.bear.middleground.comment.card.d r4 = this.a.c();
            if (r4 == null) goto L8;
            r4.j = false;
        L8:
            this.b.setBackground(this.c);
            this.d.setBackground(this.e);
        }

        public c(CardAdapterAddin r1, View r2, Drawable r3, TextView r4, Drawable r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }
    }

    public static final class d implements Animator.AnimatorListener {
        public final /* synthetic */ CardAdapterAddin a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r1) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r1) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r1) {
        }

        public d(CardAdapterAddin r1) {
            this.a = r1;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            com.bytedance.ee.bear.middleground.comment.card.d r3 = this.a.c();
            if (r3 == null) goto L5;
            r3.i = null;
        L5:
            com.bytedance.ee.bear.middleground.comment.card.d r4 = this.a.c();
            if (r4 == null) goto L9;
            r4.j = false;
            return;
        }
    }

    public static final class e implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ RecyclerView.ViewHolder a;

        public e(RecyclerView.ViewHolder r1) {
            this.a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r3) {
            Intrinsics.checkNotNullParameter(r3, "animation");
            View r0 = this.a.itemView;
            Object r4 = r3.getAnimatedValue();
            Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type kotlin.Int");
            r0.setBackgroundTintList(ColorStateList.valueOf(((Integer) r4).intValue()));
        }
    }

    public static final class f implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ RecyclerView.ViewHolder a;

        public f(RecyclerView.ViewHolder r1) {
            this.a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r3) {
            Intrinsics.checkNotNullParameter(r3, "animation");
            View r0 = this.a.itemView;
            Object r4 = r3.getAnimatedValue();
            Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type kotlin.Int");
            r0.setBackgroundTintList(ColorStateList.valueOf(((Integer) r4).intValue()));
        }
    }

    public static final class g implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ LayerDrawable a;
        public final /* synthetic */ LayerDrawable b;

        public g(LayerDrawable r1, LayerDrawable r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r4) {
            Intrinsics.checkNotNullParameter(r4, "animation");
            Object r5 = r4.getAnimatedValue();
            Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlin.Int");
            int r6 = ((Integer) r5).intValue();
            Drawable r0 = this.a.getDrawable(1);
            if (r0 == null) goto L5;
            r0.setAlpha(r6);
        L5:
            Drawable r1 = this.a.getDrawable(0);
            if (r1 == null) goto L8;
            r1.setAlpha(255 - r6);
        L8:
            Drawable r2 = this.b.getDrawable(1);
            if (r2 == null) goto L12;
            r2.setAlpha(r6);
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.middleground.comment.extension.addins.b, gf5.b
    public final void onDestroy() {
    }

    public final com.bytedance.ee.bear.middleground.comment.uitls.p d() {
        com.bytedance.ee.bear.middleground.comment.uitls.p r0 = this.b;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("config");
        return null;
    }

    public final com.bytedance.ee.bear.middleground.comment.card.d c() {
        return b().a().z7();
    }

    public CardAdapterAddin() {
    }

    @Override // com.bytedance.ee.bear.middleground.comment.extension.addins.b, gf5.b
    public final void a(cf5.a r3) {
        Intrinsics.checkNotNullParameter(r3, "host");
        Intrinsics.checkNotNullParameter(r3, "host");
        this.a = r3;
        com.bytedance.ee.bear.middleground.comment.uitls.p r0 = r3.a().getConfig();
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        this.b = r0;
        this.c = r3.a().a();
        this.d = r3.a().e();
        r3.b(ef5.b.class, new CardAdapterActionEventHandler(this));
        r3.b(ef5.c.class, new a());
    }

    public void e(RecyclerView.ViewHolder r20, CommentBean.CommentDetail r21) {
        Intrinsics.checkNotNullParameter(r20, "holder");
        Intrinsics.checkNotNullParameter(r21, "item");
        com.bytedance.ee.bear.middleground.comment.card.d r1 = c();
        if (r1 == null) goto L5;
        r1.j = true;
    L5:
        int r2 = r20.itemView.getResources().getColor(2131101127);
        int r3 = r20.itemView.getResources().getColor(2131100557);
        if ((r20 instanceof CardAdapter2.ContentViewHolder) == false) goto L35;
        CardAdapter2.ContentViewHolder r4 = (CardAdapter2.ContentViewHolder) r20;
        SmartReplyPreview r11 = r4.r;
        if (r11 == null) goto L35;
        View r15 = r11.findViewById(2131385747);
        TextView r5 = (TextView) r4.r.findViewById(2131385748);
        r20.itemView.setBackgroundTintList(ColorStateList.valueOf(r2));
        ValueAnimator r6 = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(r2), Integer.valueOf(r3)});
        r6.addUpdateListener(new e(r20));
        Drawable r7 = ContextCompat.getDrawable(r20.itemView.getContext(), 2131233328);
        if (r7 == null) goto L12;
        Drawable r8 = r7.mutate();
    L13:
        Drawable r12 = ContextCompat.getDrawable(r20.itemView.getContext(), 2131233327);
        if (r12 == null) goto L16;
        Drawable r16 = r12.mutate();
    L17:
        LayerDrawable r13 = new LayerDrawable(new Drawable[]{r16, r8});
        Drawable r9 = r13.getDrawable(1);
        if (r9 == null) goto L20;
        r9.setAlpha(255);
    L20:
        Drawable r10 = r13.getDrawable(0);
        if (r10 == null) goto L23;
        r10.setAlpha(0);
    L23:
        r15.setBackground(r13);
        Drawable r14 = ContextCompat.getDrawable(r20.itemView.getContext(), 2131233330);
        if (r14 == null) goto L26;
        Drawable r17 = r14.mutate();
    L27:
        Drawable r0 = ContextCompat.getDrawable(r20.itemView.getContext(), 2131233329);
        if (r0 == null) goto L30;
        Drawable r18 = r0.mutate();
    L31:
        LayerDrawable r19 = new LayerDrawable(new Drawable[]{r18, r17});
        Drawable r22 = r19.getDrawable(1);
        if (r22 == null) goto L34;
        r22.setAlpha(255);
    L34:
        r5.setBackground(r19);
        ValueAnimator r23 = ValueAnimator.ofInt(new int[]{255, 0});
        r23.addUpdateListener(new g(r13, r19));
        AnimatorSet r24 = new AnimatorSet();
        r24.playTogether(new Animator[]{r6, r23});
        r24.setDuration(500);
        r24.setStartDelay(1000);
        r24.addListener(new c(this, r15, r16, r5, r18));
        r24.start();
        return;
    L30:
        r18 = null;
        goto L31
    L26:
        r17 = null;
        goto L27
    L16:
        r16 = null;
        goto L17
    L12:
        r8 = null;
    L35:
        r20.itemView.setBackgroundTintList(ColorStateList.valueOf(r2));
        ValueAnimator r25 = ValueAnimator.ofInt(new int[]{r2, r3});
        r25.setEvaluator(new ArgbEvaluator());
        r25.addUpdateListener(new f(r20));
        Intrinsics.checkNotNull(r25);
        r25.addListener(new d(this));
        r25.setDuration(500);
        r25.setStartDelay(1000);
        r25.start();
    }
}
