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
import com.alibaba.gaiax.template.GXTemplateKey;
import com.baidu.platform.comapi.map.MapController;
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
import com.larus.nova.R;
import com.ss.android.lark.reaction.widget.flowlayout.ReactionFlowLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public class CardAdapterAddin extends com.bytedance.ee.bear.middleground.comment.extension.addins.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.bytedance.ee.bear.middleground.comment.uitls.p f231405b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bytedance.ee.bear.middleground.comment.control.y f231406c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.bytedance.ee.bear.middleground.comment.control.z f231407d;

    public final class CardAdapterActionEventHandler extends ff5.a<ef5.b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CardAdapterAddin f231408a;

        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f231409a = null;

            static {
                int[] r100 = new int[CardAdapterActionType.values().length];
                r100[CardAdapterActionType.SetReaction.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
            L13:
                r100[CardAdapterActionType.SetTranslateIcon.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
            L19:
                r100[CardAdapterActionType.SetContentReaction.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
            L15:
                r100[CardAdapterActionType.SetAnim.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
            L7:
                f231409a = r100;
            }
        }

        public static final class b implements ReactionFlowLayout.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ CommentBean.CommentDetail f231410a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ CardAdapterAddin f231411b;

            public b(CommentBean.CommentDetail r100, CardAdapterAddin r101) {
                this.f231410a = r100;
                this.f231411b = r101;
            }

            @Override // com.ss.android.lark.reaction.widget.flowlayout.ReactionFlowLayout.a
            public final void a(String r100) {
                com.bytedance.ee.bear.middleground.comment.control.z r101 = null;
                List<Reaction> r102 = this.f231410a.getReaction();     // Catch: Exception -> L32
                if (r102 == null) goto L27;
                Iterator<T> r103 = r102.iterator();     // Catch: Exception -> L32
                boolean r104 = false;
            L7:
                if (r103.hasNext() == false) goto L28;
                Reaction r105 = (Reaction) r103.next();     // Catch: Exception -> L32
                if (r105 == null) goto L24;
                List<ReactionDetailUserInfo> r106 = r105.getUserList();     // Catch: Exception -> L32
                if (r106 == null) goto L24;
                Iterator<T> r107 = r106.iterator();     // Catch: Exception -> L32
            L14:
                if (r107.hasNext() == false) goto L22;
                Object r108 = r107.next();     // Catch: Exception -> L32
                ReactionDetailUserInfo r109 = (ReactionDetailUserInfo) r108;     // Catch: Exception -> L32
                if (r109 == null) goto L18;
                String r110 = r109.getUserId();     // Catch: Exception -> L32
            L20:
                if (Intrinsics.areEqual(r110, r100) == false) goto L14;
            L23:
                ReactionDetailUserInfo r111 = (ReactionDetailUserInfo) r108;     // Catch: Exception -> L32
            L25:
                if (r111 == null) goto L7;
                r104 = r111.isAnonymous();     // Catch: Exception -> L32
                goto L7
            L18:
                r110 = null;
                goto L20
            L22:
                r108 = null;
            L24:
                r111 = null;
            L28:
                if (r104 == true) goto L34;
                this.f231411b.d().f232232h.getClass();     // Catch: Exception -> L32
                if (com.bytedance.ee.bear.middleground.comment.p.c() == true) goto L52;
            L36:
                com.bytedance.ee.bear.middleground.comment.control.z r112 = this.f231411b.f231407d;
                if (r112 != null) goto L39;
                Intrinsics.throwUninitializedPropertyAccessException("commentListeners");
            L40:
                r101.s0().invoke(r100);
                return;
            L39:
                r101 = r112;
                goto L40
            L52:
                return;
            L34:
                return;
            L27:
                r104 = false;
            L32:
                e = move-exception;
                tt5.a.f("Comment#CardAdapterAddin", e, false);
                goto L36
            }
        }

        public CardAdapterActionEventHandler(CardAdapterAddin r100) {
            this.f231408a = r100;
        }

        @Override // ff5.a
        public final void b(gf5.c r110) {
            ef5.b r111 = (ef5.b) r110;
            Intrinsics.checkNotNullParameter(r111, "event");
            int r100 = a.f231409a[r111.f472437a.ordinal()];
            int r101 = 36;
            int r102 = 8;
            com.bytedance.ee.bear.middleground.comment.control.y r103 = null;
            Integer r104 = null;
            BaseContentViewHolder r105 = null;
            Integer r106 = null;
            r106 = null;
            if (r100 != 1) goto L5;
            RecyclerView.ViewHolder r107 = r111.f472439c;
            if ((r107 instanceof BaseContentViewHolder) == false) goto L44;
            BaseContentViewHolder r108 = (BaseContentViewHolder) r107;
        L45:
            if (r108 == null) goto L124;
            CommentBean.CommentDetail r109 = r111.f472440d;
            RecyclerView r112 = r111.f472438b;
            List<q2c.c> r113 = r109.getReactionFlowData();
            if (r113 == null) goto L61;
            if ((!r113.isEmpty()) == false) goto L61;
            ArrayList r114 = new ArrayList();
            Iterator r115 = r113.iterator();
        L52:
            if (r115.hasNext() == false) goto L59;
            Object r116 = r115.next();
            if (((q2c.c) r116).f531475b <= 0) goto L56;
            boolean r117 = true;
        L57:
            if (r117 == false) goto L52;
            r114.add(r116);
            goto L52
        L56:
            r117 = false;
            goto L57
        L59:
            r113 = r114;
        L61:
            if (this.f231408a.d().f232247w == false) goto L106;
            if (r113 == null) goto L106;
            if (r113.isEmpty() == true) goto L106;
            tt5.a.h("Comment#CardAdapterAddin", "setReaction size:" + r113.size());
            List<Reaction> r118 = r109.getReaction();
            if (r118 == null) goto L69;
            tt5.a.h("Comment#CardAdapterAddin", "setReaction, reaction list = " + r118);
        L69:
            com.bytedance.ee.bear.middleground.comment.control.y r119 = this.f231408a.f231406c;
            com.bytedance.ee.bear.middleground.comment.control.y r120 = r119;
            if (r119 != null) goto L72;
            Intrinsics.throwUninitializedPropertyAccessException("actionControl");
            r120 = null;
        L72:
            r120.v(r109.getReply_id(), r113);
            c(r108.U3(), r109);
            if (r112 == null) goto L75;
            Integer r121 = Integer.valueOf(r112.getMeasuredWidth());
        L76:
            if (r121 != null) goto L78;
        L105:
            r108.U3().a(r113, true);
            r108.U3().setReactionClickListener(new m(this.f231408a, r112, r109));
            r108.U3().setOnReactionMoreTrigger(new n(this.f231408a, r109));
            return;
        L78:
            if ((r108 instanceof BitableDiscussListAdapter.BitableDiscussContentViewHolder) == false) goto L84;
            if (((BitableDiscussListAdapter.BitableDiscussContentViewHolder) r108).Z3() == false) goto L82;
            r101 = 76;
        L104:
            r108.U3().setReactionMaxWidth(r121.intValue() - cu5.c.b(r101));
            goto L105
        L82:
            r101 = 112;
            goto L104
        L84:
            if ((r108 instanceof HalfScreenCardAdapter.ContentViewHolder) == false) goto L86;
        L103:
            r101 = 80;
            goto L104
        L86:
            if (this.f231408a.d().f232238n.isAside() == true) goto L103;
            if ((r108 instanceof CardAdapter2.ContentViewHolder) == false) goto L101;
            if (r112 == null) goto L94;
            RecyclerView.Adapter r122 = r112.getAdapter();
            if (r122 == null) goto L94;
            r106 = Integer.valueOf(r122.getItemViewType(((CardAdapter2.ContentViewHolder) r108).getBindingAdapterPosition()));
        L94:
            int r123 = CardAdapterHelper.ItemType.WHOLE_CONTENT.getType();
            if (r106 == null) goto L104;
            if (r106.intValue() != r123) goto L104;
            r101 = 64;
            goto L104
        L101:
            if ((r108 instanceof CardAdapter.ViewHolder) == false) goto L103;
            com.bytedance.ee.bear.appsetting.c.a.f206237a.g("ccm.doc.image_region_comment_view");
            goto L103
        L75:
            r121 = null;
        L106:
            tt5.a.h("Comment#CardAdapterAddin", "setReaction but reactionFlowData is null or empty");
            r108.U3().setVisibility(8);
            com.bytedance.ee.bear.middleground.comment.control.y r124 = this.f231408a.f231406c;
            if (r124 != null) goto L109;
            Intrinsics.throwUninitializedPropertyAccessException("actionControl");
        L110:
            r103.v(r109.getReply_id(), new ArrayList());
            return;
        L109:
            r103 = r124;
            goto L110
        L124:
            return;
        L44:
            r108 = null;
            goto L45
        L5:
            if (r100 != 2) goto L7;
            RecyclerView.ViewHolder r125 = r111.f472439c;
            if ((r125 instanceof BaseContentViewHolder) == false) goto L32;
            r105 = (BaseContentViewHolder) r125;
        L32:
            if (r105 == null) goto L122;
            CommentBean.CommentDetail r126 = r111.f472440d;
            RecyclerView r127 = r111.f472438b;
            BearLottieView r128 = r105.V3();
            Map<String, Boolean> r129 = nf5.a.f518950a;
            TranslateConfig r130 = this.f231408a.d().f232248x;
            Intrinsics.checkNotNullParameter(r130, "config");
            Intrinsics.checkNotNullParameter(r126, MapController.ITEM_LAYER_TAG);
            if (nf5.a.h(r130, r126.getReply_id(), r126.getTranslate_status()) == false) goto L36;
            r102 = 0;
        L36:
            r128.setVisibility(r102);
            if (Intrinsics.areEqual(r126.getTranslate_status(), "loading") == false) goto L39;
            r105.V3().playAnimation();
        L40:
            r105.V3().setOnClickListener(new o(r126, r127, r105, this.f231408a));
            return;
        L39:
            r105.V3().cancelAnimation();
            r105.V3().setFrame(0);
            goto L40
        L122:
            return;
        L7:
            if (r100 != 3) goto L9;
            RecyclerView.ViewHolder r131 = r111.f472439c;
            if ((r131 instanceof ReactionViewHolder) == false) goto L17;
            ReactionViewHolder r132 = (ReactionViewHolder) r131;
        L18:
            if (r132 == null) goto L120;
            CommentBean.CommentDetail r133 = r111.f472440d;
            RecyclerView r134 = r111.f472438b;
            List<q2c.c> r135 = r133.getReactionFlowData();
            c(r132.f230268e, r133);
            if (r134 == null) goto L22;
            r104 = Integer.valueOf(r134.getMeasuredWidth());
        L22:
            if (r104 == null) goto L25;
            r132.f230268e.setReactionMaxWidth(r104.intValue() - cu5.c.b(36));
        L25:
            if (this.f231408a.d().f232241q.getComment() == false) goto L27;
            r132.f230268e.b(r135, true, R.drawable.ud_icon_emoji_add_outlined, new i(this, r132, r133));
            e(r132);
        L28:
            r132.f230268e.setReactionClickListener(new j(this.f231408a, r133, r132));
            r132.f230268e.setOnReactionMoreTrigger(new k(this.f231408a, r133));
            r132.itemView.setOnLongClickListener(new l(this, r132, r133));
            return;
        L27:
            r132.f230268e.a(r135, true);
            goto L28
        L120:
            return;
        L17:
            r132 = null;
            goto L18
        L9:
            if (r100 == 4) goto L12;
            tt5.a.d("Comment#CardAdapterAddin", "actionType not exist");
            return;
        L12:
            if (this.f231408a.d().f232238n.isAside() == true) goto L118;
            this.f231408a.e(r111.f472439c, r111.f472440d);
            return;
        }

        public final void e(ReactionViewHolder r100) {
            Intrinsics.checkNotNullParameter(r100, "holder");
            com.bytedance.ee.bear.middleground.comment.control.y r101 = this.f231408a.f231406c;
            if (r101 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("actionControl");
            r101 = null;
        L6:
            if (r101.k() == false) goto L8;
            int r102 = v2c.a.b(this.f231408a.d().getActivity(), R.color.colorful_blue);
        L9:
            r100.f230268e.setExtendIconTint(r102);
            return;
        L8:
            r102 = v2c.a.b(this.f231408a.d().getActivity(), R.color.ud_N600);
            goto L9
        }

        public final void c(ReactionFlowLayout r100, CommentBean.CommentDetail r101) {
            r100.setVisibility(0);
            r100.setNewReactionEnable(true);
            r100.setMaxNameCount(5);
            r100.setTagBackground(v2c.a.c(this.f231408a.d().getActivity(), R.drawable.space_comment_bubble_reaction_black_bg));
            r100.setOnReactionNameTrigger(new b(r101, this.f231408a));
        }

        public final void d(final ReactionViewHolder r100, CommentBean.CommentDetail r101) {
            Intrinsics.checkNotNullParameter(r100, "holder");
            Intrinsics.checkNotNullParameter(r101, "commentDetail");
            com.bytedance.ee.bear.middleground.comment.control.y r102 = this.f231408a.f231406c;
            if (r102 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("actionControl");
            r102 = null;
        L5:
            r102.x(r100.itemView, r101, new CardAdapterAddin$CardAdapterActionEventHandler$showContentReaction$1(this, r100));
            e(r100);
        }
    }

    public final class a extends ff5.a<ef5.c> {
        public a() {
        }

        @Override // ff5.a
        public final void b(gf5.c r100) {
            ef5.c r101 = (ef5.c) r100;
            Intrinsics.checkNotNullParameter(r101, "event");
            TextView r102 = r101.f472450b;
            View r103 = r101.f472451c;
            Intrinsics.checkNotNullParameter(r102, "textView");
            Intrinsics.checkNotNullParameter(r103, "tran");
            if (r102.getVisibility() == 0) goto L5;
            return;
        L5:
            if (r103.getVisibility() != 0) goto L10;
            r102.getViewTreeObserver().addOnPreDrawListener(new p(r102, r103));
            return;
        }
    }

    public static final class b {
    }

    public static final class c implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CardAdapterAddin f231412a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f231413b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Drawable f231414c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ TextView f231415d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Drawable f231416e;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            com.bytedance.ee.bear.middleground.comment.card.d r101 = this.f231412a.c();
            if (r101 == null) goto L5;
            r101.f230967i = null;
        L5:
            com.bytedance.ee.bear.middleground.comment.card.d r102 = this.f231412a.c();
            if (r102 == null) goto L8;
            r102.f230968j = false;
        L8:
            this.f231413b.setBackground(this.f231414c);
            this.f231415d.setBackground(this.f231416e);
        }

        public c(CardAdapterAddin r100, View r101, Drawable r102, TextView r103, Drawable r104) {
            this.f231412a = r100;
            this.f231413b = r101;
            this.f231414c = r102;
            this.f231415d = r103;
            this.f231416e = r104;
        }
    }

    public static final class d implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CardAdapterAddin f231417a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
        }

        public d(CardAdapterAddin r100) {
            this.f231417a = r100;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            com.bytedance.ee.bear.middleground.comment.card.d r101 = this.f231417a.c();
            if (r101 == null) goto L5;
            r101.f230967i = null;
        L5:
            com.bytedance.ee.bear.middleground.comment.card.d r102 = this.f231417a.c();
            if (r102 == null) goto L9;
            r102.f230968j = false;
            return;
        }
    }

    public static final class e implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerView.ViewHolder f231418a;

        public e(RecyclerView.ViewHolder r100) {
            this.f231418a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            View r101 = this.f231418a.itemView;
            Object r102 = r100.getAnimatedValue();
            Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.Int");
            r101.setBackgroundTintList(ColorStateList.valueOf(((Integer) r102).intValue()));
        }
    }

    public static final class f implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerView.ViewHolder f231419a;

        public f(RecyclerView.ViewHolder r100) {
            this.f231419a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            View r101 = this.f231419a.itemView;
            Object r102 = r100.getAnimatedValue();
            Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.Int");
            r101.setBackgroundTintList(ColorStateList.valueOf(((Integer) r102).intValue()));
        }
    }

    public static final class g implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LayerDrawable f231420a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LayerDrawable f231421b;

        public g(LayerDrawable r100, LayerDrawable r101) {
            this.f231420a = r100;
            this.f231421b = r101;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            Object r101 = r100.getAnimatedValue();
            Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type kotlin.Int");
            int r102 = ((Integer) r101).intValue();
            Drawable r103 = this.f231420a.getDrawable(1);
            if (r103 == null) goto L5;
            r103.setAlpha(r102);
        L5:
            Drawable r104 = this.f231420a.getDrawable(0);
            if (r104 == null) goto L8;
            r104.setAlpha(255 - r102);
        L8:
            Drawable r105 = this.f231421b.getDrawable(1);
            if (r105 == null) goto L12;
            r105.setAlpha(r102);
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.middleground.comment.extension.addins.b, gf5.b
    public final void onDestroy() {
    }

    public final com.bytedance.ee.bear.middleground.comment.uitls.p d() {
        com.bytedance.ee.bear.middleground.comment.uitls.p r100 = this.f231405b;
        if (r100 == null) goto L5;
        return r100;
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
    public final void a(cf5.a r100) {
        Intrinsics.checkNotNullParameter(r100, "host");
        Intrinsics.checkNotNullParameter(r100, "host");
        this.f231427a = r100;
        com.bytedance.ee.bear.middleground.comment.uitls.p r101 = r100.a().getConfig();
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        this.f231405b = r101;
        this.f231406c = r100.a().a();
        this.f231407d = r100.a().e();
        r100.b(ef5.b.class, new CardAdapterActionEventHandler(this));
        r100.b(ef5.c.class, new a());
    }

    public void e(RecyclerView.ViewHolder r210, CommentBean.CommentDetail r211) {
        Intrinsics.checkNotNullParameter(r210, "holder");
        Intrinsics.checkNotNullParameter(r211, MapController.ITEM_LAYER_TAG);
        com.bytedance.ee.bear.middleground.comment.card.d r100 = c();
        if (r100 == null) goto L5;
        r100.f230968j = true;
    L5:
        int r101 = r210.itemView.getResources().getColor(R.color.comment_rounded_conner_bg_color);
        int r102 = r210.itemView.getResources().getColor(R.color.bg_float);
        if ((r210 instanceof CardAdapter2.ContentViewHolder) == false) goto L35;
        CardAdapter2.ContentViewHolder r103 = (CardAdapter2.ContentViewHolder) r210;
        SmartReplyPreview r110 = r103.f230153r;
        if (r110 == null) goto L35;
        View r111 = r110.findViewById(R.id.see_more_gradient);
        TextView r104 = (TextView) r103.f230153r.findViewById(R.id.see_more_textview);
        r210.itemView.setBackgroundTintList(ColorStateList.valueOf(r101));
        ValueAnimator r105 = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(r101), Integer.valueOf(r102)});
        r105.addUpdateListener(new e(r210));
        Drawable r106 = ContextCompat.getDrawable(r210.itemView.getContext(), R.drawable.comment_smart_reply_preview_gradient_start_selector);
        if (r106 == null) goto L12;
        Drawable r107 = r106.mutate();
    L13:
        Drawable r112 = ContextCompat.getDrawable(r210.itemView.getContext(), R.drawable.comment_smart_reply_preview_gradient_selector);
        if (r112 == null) goto L16;
        Drawable r113 = r112.mutate();
    L17:
        LayerDrawable r114 = new LayerDrawable(new Drawable[]{r113, r107});
        Drawable r108 = r114.getDrawable(1);
        if (r108 == null) goto L20;
        r108.setAlpha(255);
    L20:
        Drawable r109 = r114.getDrawable(0);
        if (r109 == null) goto L23;
        r109.setAlpha(0);
    L23:
        r111.setBackground(r114);
        Drawable r115 = ContextCompat.getDrawable(r210.itemView.getContext(), R.drawable.comment_smart_reply_preview_tv_bg_selector_start_selector);
        if (r115 == null) goto L26;
        Drawable r116 = r115.mutate();
    L27:
        Drawable r117 = ContextCompat.getDrawable(r210.itemView.getContext(), R.drawable.comment_smart_reply_preview_tv_bg_selector);
        if (r117 == null) goto L30;
        Drawable r118 = r117.mutate();
    L31:
        LayerDrawable r119 = new LayerDrawable(new Drawable[]{r118, r116});
        Drawable r120 = r119.getDrawable(1);
        if (r120 == null) goto L34;
        r120.setAlpha(255);
    L34:
        r104.setBackground(r119);
        ValueAnimator r121 = ValueAnimator.ofInt(new int[]{255, 0});
        r121.addUpdateListener(new g(r114, r119));
        AnimatorSet r122 = new AnimatorSet();
        r122.playTogether(new Animator[]{r105, r121});
        r122.setDuration(500);
        r122.setStartDelay(1000);
        r122.addListener(new c(this, r111, r113, r104, r118));
        r122.start();
        return;
    L30:
        r118 = null;
        goto L31
    L26:
        r116 = null;
        goto L27
    L16:
        r113 = null;
        goto L17
    L12:
        r107 = null;
    L35:
        r210.itemView.setBackgroundTintList(ColorStateList.valueOf(r101));
        ValueAnimator r123 = ValueAnimator.ofInt(new int[]{r101, r102});
        r123.setEvaluator(new ArgbEvaluator());
        r123.addUpdateListener(new f(r210));
        Intrinsics.checkNotNull(r123);
        r123.addListener(new d(this));
        r123.setDuration(500);
        r123.setStartDelay(1000);
        r123.start();
    }
}
