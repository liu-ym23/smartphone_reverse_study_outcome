package com.bytedance.ee.bear.middleground.comment.card;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Rect;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.Guideline;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.document.comment.CommentPlugin;
import com.bytedance.ee.bear.middleground.comment.Comment;
import com.bytedance.ee.bear.middleground.comment.Comment$inputCommentFunction$1;
import com.bytedance.ee.bear.middleground.comment.audio.MotionImageView;
import com.bytedance.ee.bear.middleground.comment.audio.RecordViewModel;
import com.bytedance.ee.bear.middleground.comment.audio.voiceinput.CommentImmersiveVoiceTouchDelegate;
import com.bytedance.ee.bear.middleground.comment.audio.voiceinput.CommentVoiceLog;
import com.bytedance.ee.bear.middleground.comment.audio.voiceinput.CommentVoiceMentionPermissionHelper;
import com.bytedance.ee.bear.middleground.comment.audio.voiceinput.richtext.CommentVoiceEditTextBridge;
import com.bytedance.ee.bear.middleground.comment.export.CardCommentHeight;
import com.bytedance.ee.bear.middleground.comment.export.CommentImageShowSource;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentInputRequest;
import com.bytedance.ee.bear.middleground.comment.export.bean.FocusInputBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.ScrollCommentBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.SmartReplyDataForInsert;
import com.bytedance.ee.bear.middleground.comment.input.b2;
import com.bytedance.ee.bear.middleground.comment.share.SharePermissionViewModel;
import com.bytedance.ee.bear.middleground.comment.widget.CommentEditText;
import com.bytedance.ee.bear.middleground.comment.widget.CommentVoiceBarLayout;
import com.bytedance.ee.bear.utils.AtUtils;
import com.bytedance.ee.bear.widgets.ScrollControlViewPager;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEmptyState;
import com.bytedance.ee.bear.widgets.universedesign.SpaceShadowLayout;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.larksuite.component.ui.button.LKUICheckBox2;
import com.larksuite.component.universe_design.edittext.UDEditText;
import com.larksuite.component.universe_design.shadow.UDShadowLayout;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class HalfScreenCardComment implements p1 {
    public static final /* synthetic */ int x1 = 0;
    public final LKUICheckBox2 A;
    public final TextView B;
    public final View C;
    public CommentPagerAdapter D;
    public com.bytedance.ee.bear.middleground.comment.card.d E;
    public com.bytedance.ee.bear.middleground.comment.detail.a F;
    public final RecordViewModel G;
    public final b2 H;
    public final View H0;
    public final Lazy<com.bytedance.ee.bear.middleground.comment.audio.voiceinput.g> I;
    public final MotionImageView J;
    public final View K;
    public final ImageView L;
    public final SharePermissionViewModel L0;
    public final CommentEditText M;
    public List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> N;
    public String O;
    public final ImageView P;
    public final jf5.a P0;
    public final ImageView Q;
    public final View R;
    public final View S;
    public boolean T;
    public boolean U;
    public final Lazy<CommentImmersiveVoiceTouchDelegate> V;
    public int V0;
    public final Lazy W;
    public com.bytedance.ee.bear.middleground.comment.export.bean.a X;
    public com.bytedance.ee.bear.middleground.comment.export.bean.a Y;
    public LiveData<ConnectionService.NetworkState> Z;
    public final com.bytedance.ee.bear.middleground.comment.uitls.p a;
    public final com.bytedance.ee.bear.middleground.comment.control.z b;
    public final boolean b1;
    public final com.bytedance.ee.bear.middleground.comment.control.t c;
    public final com.bytedance.ee.bear.middleground.comment.control.y d;
    public final com.bytedance.ee.bear.facade.common.widget.d e;
    public kf5.b f;
    public final View g;
    public final k0 g1;
    public final View h;
    public final Function2<Integer, Boolean, Unit> h1;
    public final View i;
    public final View j;
    public final TextView k;
    public String k0;
    public final boolean k1;
    public final SpaceShadowLayout l;
    public final View m;
    public final ScrollControlViewPager n;
    public final ImageView o;
    public final ImageView p;
    public final boolean p0;
    public final boolean p1;
    public final View q;
    public final View r;
    public final View s;
    public final SpaceEmptyState t;
    public final Guideline u;
    public final ViewGroup v;
    public final h0 v1;
    public AnimatorSet w;
    public AnimatorSet x;
    public Boolean y;
    public final boolean z;

    public static final class a {
    }

    public static final class b {
        public final String a;
        public final String b;
        public final List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
            List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r1 = this.c;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public final String toString() {
            return "SendSnapshot(commentId=" + this.a + ", content=" + this.b + ", images=" + this.c + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(String r2, String r3, List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r4) {
            Intrinsics.checkNotNullParameter(r2, "commentId");
            Intrinsics.checkNotNullParameter(r3, "content");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[CardCommentHeight.values().length];
            r0[CardCommentHeight.MAX.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[CardCommentHeight.DEFAULT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[CardCommentHeight.SHRINK.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[CardCommentHeight.MIN.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[CardCommentHeight.SHRINK_ONE_LEVEL.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            a = r0;
        }
    }

    public static final class d implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ HalfScreenCardComment a;

        public d(HalfScreenCardComment r1) {
            this.a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            Object r3 = r2.getAnimatedValue();
            Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type kotlin.Int");
            this.a.v.getLayoutParams().height = ((Integer) r3).intValue();
            this.a.v.requestLayout();
        }
    }

    public static final class e implements Runnable {
        public final /* synthetic */ HalfScreenCardComment a;
        public final /* synthetic */ View b;

        public e(HalfScreenCardComment r1, View r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            Rect r0 = new Rect();
            this.a.q.getGlobalVisibleRect(r0);
            Rect r1 = new Rect();
            this.b.getGlobalVisibleRect(r1);
            if ((r0.top - 30) >= r1.bottom) goto L11;
            CommentPagerAdapter r2 = this.a.D;
            if (r2 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
            r2 = null;
        L7:
            RecyclerView r3 = r2.P0(Integer.valueOf(this.a.n.getCurrentItem()));
            if (r3 == null) goto L12;
            r3.scrollBy(0, this.b.getHeight());
            return;
        L12:
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

    public static final class f extends AnimatorListenerAdapter {
        public final /* synthetic */ HalfScreenCardComment a;

        public f(HalfScreenCardComment r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            super.onAnimationEnd(r2);
            this.a.q.requestLayout();
        }
    }

    public static final class g<T> implements Observer {
        public final /* synthetic */ HalfScreenCardComment a;

        public g(HalfScreenCardComment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r12) {
            List<CommentBean> r13 = (List) r12;
            if (r13 != null) goto L5;
            tt5.a.d("Comment#CardComment", "data is null");
            return;
        L5:
            HalfScreenCardComment r1 = this.a;
            CommentImmersiveVoiceTouchDelegate r2 = r1.g();
            com.bytedance.ee.bear.middleground.comment.card.d r3 = r1.E;
            if (r3 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
            r3 = null;
        L8:
            String r4 = r3.k;
            int r8 = 0;
            if (r4.length() <= 0) goto L11;
            boolean r6 = true;
        L12:
            if (r6 == false) goto L33;
            List<CommentBean> r7 = r13;
            if ((r7 instanceof Collection) == true) goto L16;
        L18:
            Iterator<T> r9 = r7.iterator();
        L20:
            if (r9.hasNext() == false) goto L30;
            CommentBean r10 = (CommentBean) r9.next();
            if (Intrinsics.areEqual(r10.getComment_id(), r4) == false) goto L24;
        L27:
            boolean r11 = true;
        L28:
            if (r11 == false) goto L20;
            boolean r14 = false;
        L31:
            if (r14 == false) goto L33;
            boolean r15 = true;
        L34:
            if (r15 == false) goto L38;
            com.bytedance.ee.bear.middleground.comment.audio.voiceinput.g r5 = r1.h();
            if (r5 == null) goto L38;
            r5.d();
        L38:
            int r16 = com.bytedance.ee.bear.middleground.comment.audio.voiceinput.n.a;
            if (r2 != null) goto L41;
        L43:
            boolean r17 = false;
        L44:
            Intrinsics.checkNotNullParameter(r13, WikiFolderPushPlugin.DATA);
            if (r17 == true) goto L47;
        L70:
            boolean r18 = false;
        L71:
            if (r18 == false) goto L75;
            tt5.a.h("Comment#CardComment", "current comment " + r4 + " does not exist, so dismiss immersive voice popup");
            if (r2 == null) goto L75;
            r2.a();
        L75:
            HalfScreenCardComment r19 = this.a;
            r19.T = r19.a.q.getComment();
            this.a.t();
            this.a.b.q1().invoke(Integer.valueOf(r13.size()));
            if (r13.isEmpty() == false) goto L101;
            kf5.b r20 = this.a.f;
            if (r20 != null) goto L80;
        L82:
            boolean r21 = false;
        L83:
            if (r21 == false) goto L87;
            tt5.a.h("Comment#CardComment", "showDataLiveData: empty, so dismiss inputComment");
            kf5.b r22 = this.a.f;
            if (r22 == null) goto L87;
            kf5.a.a(r22, false, false, 3);
        L87:
            com.bytedance.ee.bear.middleground.comment.detail.c r23 = this.a.d.r();
            if (r23 == null) goto L97;
            View r24 = r23.i;
            if (r24 != null) goto L92;
        L94:
            boolean r25 = false;
        L95:
            if (r25 != true) goto L97;
            boolean r26 = true;
        L98:
            if (r26 == false) goto L101;
            r23.a();
            goto L101
        L92:
            if (r24.getParent() == null) goto L94;
            r25 = true;
        L97:
            r26 = false;
            goto L98
        L80:
            if (r20.isShowing() != true) goto L82;
            r21 = true;
        L101:
            if (r13.isEmpty() == false) goto L106;
            if (this.a.a.z == true) goto L106;
            tt5.a.d("Comment#CardComment", "data is empty");
            this.a.Ni(true);
            return;
        L106:
            if (this.a.a.z == true) goto L108;
        L122:
            tt5.a.h("Comment#CardComment", "data size = " + r13.size());
            CommentPagerAdapter r0 = this.a.D;
            if (r0 != null) goto L125;
            Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
            r0 = null;
        L125:
            this.a.a.h.getClass();
            this.a.a.h.getClass();
            List<String> r27 = CollectionsKt.listOf(new String[]{com.bytedance.ee.bear.middleground.comment.p.a(), null});
            r0.getClass();
            Intrinsics.checkNotNullParameter(r27, "userIds");
            Intrinsics.checkNotNullParameter(r13, "cards");
            r0.g = r27;
            r0.c = r13;
            CommentPagerAdapter r28 = this.a.D;
            if (r28 != null) goto L128;
            Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
            r28 = null;
        L128:
            r28.f();
            com.bytedance.ee.bear.middleground.comment.card.d r29 = this.a.E;
            if (r29 != null) goto L131;
            Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
            r29 = null;
        L131:
            int r30 = r29.j(this.a.n.getCurrentItem());
            int r31 = this.a.n.getCurrentItem();
            this.a.n.w(r30, false);
            this.a.l();
            com.bytedance.ee.bear.middleground.comment.card.d r32 = this.a.E;
            if (r32 != null) goto L134;
            Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
            r32 = null;
        L134:
            CommentBean r33 = (CommentBean) CollectionsKt.getOrNull(r13, this.a.n.getCurrentItem());
            if (r33 == null) goto L137;
            String r34 = r33.getComment_id();
        L138:
            if (r34 != null) goto L140;
            r34 = "";
        L140:
            r32.getClass();
            Intrinsics.checkNotNullParameter(r34, "<set-?>");
            r32.k = r34;
            HalfScreenCardComment r35 = this.a;
            View r36 = r35.q;
            if (r35.T == false) goto L153;
            com.bytedance.ee.bear.middleground.comment.card.d r37 = r35.E;
            if (r37 != null) goto L146;
            Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
            r37 = null;
        L146:
            if (r37.r(this.a.n.getCurrentItem()) == false) goto L153;
            com.bytedance.ee.bear.middleground.comment.card.d r38 = this.a.E;
            if (r38 != null) goto L151;
            Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
            r38 = null;
        L151:
            if (r38.e == true) goto L153;
            int r39 = 0;
        L154:
            r36.setVisibility(r39);
            HalfScreenCardComment r40 = this.a;
            View r41 = r40.m;
            if (r40.i() == true) goto L158;
            r8 = 8;
        L158:
            r41.setVisibility(r8);
            int r42 = this.a.n.getCurrentItem();
            HalfScreenCardComment.d(this.a, r42);
            HalfScreenCardComment r43 = this.a;
            TextView r44 = r43.k;
            com.bytedance.ee.bear.middleground.comment.card.d r45 = r43.E;
            if (r45 != null) goto L161;
            Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
            r45 = null;
        L161:
            r44.setText(r45.g(r42));
            this.a.a.N.a(new ef5.m(r13, Integer.valueOf(r30), Integer.valueOf(r31), null));
            SharePermissionViewModel.PreviewPermissionState r46 = this.a.L0.h();
            HalfScreenCardComment r47 = this.a;
            if (r47.p0 == false) goto L165;
            if (r46 != null) goto L165;
        L166:
            Iterator<T> r110 = r13.iterator();
        L168:
            if (r110.hasNext() == false) goto L217;
            List<CommentBean.CommentDetail> r48 = ((CommentBean) r110.next()).getComment_list();
            if (r48 == null) goto L168;
            Iterator<T> r49 = r48.iterator();
        L173:
            if (r49.hasNext() == false) goto L168;
            CommentBean.CommentDetail.ExtraEntity r50 = ((CommentBean.CommentDetail) r49.next()).getExtra();
            if (r50 == null) goto L173;
            List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r51 = r50.getImage_list();
            if (r51 == null) goto L173;
            Iterator<T> r52 = r51.iterator();
        L180:
            if (r52.hasNext() == false) goto L173;
            CommentBean.CommentDetail.ExtraEntity.CommentImageEntity r53 = (CommentBean.CommentDetail.ExtraEntity.CommentImageEntity) r52.next();
            if (r53 == null) goto L180;
            String r54 = r53.getToken();
            if (r54 == null) goto L180;
            r47.L0.m(r47.a, r54);
            goto L180
        L217:
            return;
        L165:
            if (r46 == SharePermissionViewModel.PreviewPermissionState.STATE_INIT) goto L166;
            return;
        L153:
            r39 = 8;
            goto L154
        L137:
            r34 = null;
            goto L138
        L108:
            if (r13.isEmpty() == false) goto L116;
            com.bytedance.ee.bear.middleground.comment.card.d r55 = this.a.E;
            if (r55 != null) goto L113;
            Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
            r55 = null;
        L113:
            if (r55.e == false) goto L115;
            this.a.Ni(false);
            return;
        L115:
            this.a.t.setVisibility(0);
            this.a.q.setVisibility(8);
            this.a.m.setVisibility(8);
            goto L122
        L116:
            this.a.t.setVisibility(8);
            com.bytedance.ee.bear.middleground.comment.card.d r56 = this.a.E;
            if (r56 != null) goto L120;
            Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
            r56 = null;
        L120:
            if (r56.e == true) goto L122;
            this.a.m(false);
            goto L122
        L47:
            if (r4.length() != 0) goto L49;
            boolean r57 = true;
        L50:
            if (r57 == true) goto L70;
            List<CommentBean> r58 = r13;
            if ((r58 instanceof Collection) == true) goto L55;
        L57:
            Iterator<T> r59 = r58.iterator();
        L59:
            if (r59.hasNext() == false) goto L69;
            CommentBean r60 = (CommentBean) r59.next();
            if (Intrinsics.areEqual(r60.getComment_id(), r4) == false) goto L63;
        L66:
            boolean r61 = true;
        L67:
            if (r61 == false) goto L59;
        L63:
            if (Intrinsics.areEqual(r60.getCommentUUID(), r4) == true) goto L66;
            r61 = false;
        L69:
            r18 = true;
            goto L71
        L55:
            if (r58.isEmpty() == false) goto L57;
        L49:
            r57 = false;
            goto L50
        L41:
            if (r2.k != true) goto L43;
            r17 = true;
            goto L44
        L24:
            if (Intrinsics.areEqual(r10.getCommentUUID(), r4) == true) goto L27;
            r11 = false;
        L30:
            r14 = true;
            goto L31
        L16:
            if (r7.isEmpty() == false) goto L18;
        L33:
            r15 = false;
            goto L34
        L11:
            r6 = false;
            goto L12
        }
    }

    public static final class h implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ com.bytedance.ee.bear.middleground.comment.export.bean.a a;
        public final /* synthetic */ HalfScreenCardComment b;

        public h(com.bytedance.ee.bear.middleground.comment.export.bean.a r1, HalfScreenCardComment r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r5) {
            Intrinsics.checkNotNullParameter(r5, "value");
            View r1 = null;
            if (this.a.a == false) goto L9;
            View r0 = this.b.g;
            if (r0 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("rootView");
        L8:
            Function1<Float, Float> r2 = this.a.h;
            Object r6 = r5.getAnimatedValue();
            Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type kotlin.Float");
            r1.setTranslationX(((Number) r2.invoke((Float) r6)).floatValue());
            return;
        L7:
            r1 = r0;
            goto L8
        L9:
            View r3 = this.b.g;
            if (r3 != null) goto L12;
            Intrinsics.throwUninitializedPropertyAccessException("rootView");
        L13:
            Function1<Float, Float> r4 = this.a.h;
            Object r7 = r5.getAnimatedValue();
            Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type kotlin.Float");
            r1.setTranslationY(((Number) r4.invoke((Float) r7)).floatValue());
            return;
        L12:
            r1 = r3;
            goto L13
        }
    }

    public static final class i extends AnimatorListenerAdapter {
        public final /* synthetic */ com.bytedance.ee.bear.middleground.comment.export.bean.a a;
        public final /* synthetic */ HalfScreenCardComment b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r4) {
            Intrinsics.checkNotNullParameter(r4, "animation");
            super.onAnimationEnd(r4);
            View r0 = null;
            if (this.a.a == false) goto L9;
            View r5 = this.b.g;
            if (r5 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("rootView");
        L8:
            r0.setTranslationX(0.0f);
        L14:
            com.bytedance.ee.bear.middleground.comment.export.bean.a r6 = this.a;
            if (r6.d == false) goto L23;
            this.b.k(r6.e, true);     // Catch: Exception -> L18
            return;
        L18:
            e = move-exception;
            iu5.d.a("Comment#CardComment", e);
            return;
        L23:
            return;
        L7:
            r0 = r5;
            goto L8
        L9:
            View r7 = this.b.g;
            if (r7 != null) goto L12;
            Intrinsics.throwUninitializedPropertyAccessException("rootView");
        L13:
            r0.setTranslationY(0.0f);
            goto L14
        L12:
            r0 = r7;
            goto L13
        }

        public i(com.bytedance.ee.bear.middleground.comment.export.bean.a r1, HalfScreenCardComment r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class j<T> implements Comparator {
        public j() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r1, T r2) {
            return ComparisonsKt.compareValues(Float.valueOf(((Number) r2).floatValue()), Float.valueOf(((Number) r1).floatValue()));
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final /* synthetic */ void XC(String r1, String r2, String r3, String r4) {
        o1.a(r1, r2, r3, r4);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final /* synthetic */ void jN() {
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final /* synthetic */ void t2() {
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final void v2() {
        m(false);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final void Hg() {
        this.P0.d();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final void IX() {
        tt5.a.h("Comment#CardComment", "dismissInputComment, so dismiss inputComment");
        kf5.b r0 = this.f;
        if (r0 == null) goto L6;
        kf5.a.a(r0, false, false, 3);
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final void LM() {
        com.bytedance.ee.bear.middleground.comment.uitls.p r0 = this.a;
        if (r0.A == true) goto L5;
        this.e.e();
    L16:
        this.e.f();
        return;
    L5:
        if (this.k1 == true) goto L7;
    L11:
        boolean r1 = false;
    L12:
        if (r1 == false) goto L14;
        this.e.n(r0.Z, r0.a0, r0.b0, r0.c0);
        goto L16
    L14:
        this.e.m(r0.Z, r0.b0, r0.c0);
        goto L16
    L7:
        if (this.p1 == false) goto L9;
    L10:
        r1 = true;
        goto L12
    L9:
        if (r0.s == true) goto L11;
        goto L10
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final String UT() {
        com.bytedance.ee.bear.middleground.comment.card.d r0 = this.E;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r0 = null;
    L6:
        return r0.f(Integer.valueOf(this.n.getCurrentItem()));
    }

    public final CommentVoiceMentionPermissionHelper f() {
        return (CommentVoiceMentionPermissionHelper) this.W.getValue();
    }

    public final CommentImmersiveVoiceTouchDelegate g() {
        if (this.V.isInitialized() == true) goto L7;
        return null;
    L7:
        return (CommentImmersiveVoiceTouchDelegate) this.V.getValue();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final View getRootView() {
        View r0 = this.g;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        return null;
    L6:
        return r0;
    }

    public final com.bytedance.ee.bear.middleground.comment.audio.voiceinput.g h() {
        if (this.I.isInitialized() == true) goto L7;
        return null;
    L7:
        return (com.bytedance.ee.bear.middleground.comment.audio.voiceinput.g) this.I.getValue();
    }

    public final boolean i() {
        if (this.U == false) goto L25;
        com.bytedance.ee.bear.middleground.comment.card.d r0 = this.E;
        List<String> r2 = null;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r0 = null;
    L8:
        if (r0.r(this.n.getCurrentItem()) == false) goto L25;
        com.bytedance.ee.bear.middleground.comment.control.y r1 = this.d;
        int r4 = this.n.getCurrentItem();
        com.bytedance.ee.bear.middleground.comment.card.d r5 = this.E;
        if (r5 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r5 = null;
    L12:
        CommentBean r6 = r5.e(Integer.valueOf(r4));
        if (r6 != null) goto L15;
        String r7 = "";
    L16:
        int r8 = this.n.getCurrentItem();
        com.bytedance.ee.bear.middleground.comment.card.d r9 = this.E;
        if (r9 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r9 = null;
    L19:
        CommentBean r3 = r9.e(Integer.valueOf(r8));
        if (r3 == null) goto L24;
        r2 = r3.getParticipantList();
    L24:
        if (r1.t(r7, r2) == false) goto L25;
        return true;
    L15:
        r7 = r6.getUserId();
    L25:
        String r10 = this.a.O;
        if (r10 != null) goto L28;
    L31:
        boolean r11 = true;
    L32:
        if (r11 == false) goto L34;
    L36:
        return false;
    L34:
        if (this.p0 == false) goto L36;
        return true;
    L28:
        if (r10.length() == 0) goto L31;
        r11 = false;
        goto L32
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final boolean isShowing() {
        View r0 = this.g;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        r0 = null;
    L6:
        if (r0.getParent() == null) goto L8;
        return true;
    L8:
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final q1 jV() {
        CommentPagerAdapter r0 = this.D;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
        return null;
    L6:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [android.widget.EditText] */
    public final void l() {
        com.bytedance.ee.bear.middleground.comment.card.d r0 = this.E;
        ?? r1 = 0;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r0 = null;
    L5:
        CommentBean r2 = r0.e(Integer.valueOf(this.n.getCurrentItem()));
        UDEditText r3 = this.M;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("commentEditText");
        r3 = null;
    L8:
        com.bytedance.ee.bear.middleground.comment.uitls.p r4 = this.a;
        boolean r9 = true;
        int r10 = 0;
        if (r4.o != 0) goto L11;
        CharSequence r5 = r4.getActivity().getString(2131887609);
    L21:
        r3.setHint(r5);
        if (com.bytedance.ee.bear.middleground.comment.export.e.a() == true) goto L24;
    L25:
        CommentEditText r6 = this.M;
        if (r6 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("commentEditText");
        r6 = null;
    L28:
        CommentEditText r7 = this.M;
        if (r7 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("commentEditText");
    L32:
        CharSequence r8 = r1.getHint();
        if (r8 == null) goto L36;
        String r11 = r8.toString();
        if (r11 == null) goto L36;
    L37:
        r6.setOriginHint(r11);
    L38:
        View r12 = this.H0;
        if (r12 == null) goto L52;
        if (r2 == null) goto L46;
        CommentBean.Extra r13 = r2.getExtra();
        if (r13 == null) goto L46;
        if (r13.getVisibility() != 1) goto L46;
    L47:
        if (r9 == true) goto L50;
        r10 = 8;
    L50:
        r12.setVisibility(r10);
        return;
    L46:
        r9 = false;
        goto L47
    L52:
        return;
    L36:
        r11 = "";
        goto L37
    L31:
        r1 = r7;
        goto L32
    L24:
        if (com.bytedance.ee.bear.middleground.comment.export.e.b() == false) goto L38;
    L11:
        if (r2 == null) goto L17;
        CommentBean.Extra r14 = r2.getExtra();
        if (r14 == null) goto L17;
        if (r14.getVisibility() != 1) goto L17;
        boolean r15 = true;
    L18:
        if (r15 == false) goto L20;
        r5 = this.a.getActivity().getString(2131889228);
        goto L21
    L20:
        r5 = this.a.getActivity().getString(2131887629);
    L17:
        r15 = false;
        goto L18
    }

    public final void t() {
        com.bytedance.ee.bear.middleground.comment.uitls.p r0 = this.a;
        boolean r2 = true;
        if (r0.Y == null) goto L5;
        boolean r1 = true;
    L6:
        boolean r3 = r0.q.getComment();
        if (r1 == false) goto L10;
        if (r3 == false) goto L10;
        boolean r4 = true;
    L12:
        if (r4 == false) goto L19;
        com.bytedance.ee.bear.middleground.comment.card.d r5 = this.E;
        if (r5 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r5 = null;
    L17:
        if (r5.e == true) goto L19;
        boolean r6 = true;
    L20:
        boolean r7 = com.bytedance.ee.bear.contract.j.a.a.getNetworkState().a();
        View r8 = this.r;
        if (r8 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("createWholeCommentView");
        r8 = null;
    L23:
        if (r6 == false) goto L25;
        int r9 = 0;
    L26:
        r8.setVisibility(r9);
        View r10 = this.r;
        if (r10 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("createWholeCommentView");
        r10 = null;
    L29:
        if (r6 == false) goto L32;
        if (r7 == false) goto L32;
    L33:
        r10.setEnabled(r2);
        View r11 = this.r;
        if (r11 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("createWholeCommentView");
        r11 = null;
    L36:
        View r12 = this.r;
        if (r12 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("createWholeCommentView");
        r12 = null;
    L40:
        if (r12.isEnabled() == false) goto L42;
        float r13 = 1.0f;
    L43:
        r11.setAlpha(r13);
        if (this.D == null) goto L60;
        if (r6 == false) goto L47;
        int r14 = 72;
    L48:
        int r15 = com.bytedance.ee.util.ui.n.d(r14);
        CommentPagerAdapter r16 = this.D;
        if (r16 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
        r16 = null;
    L51:
        r16.getClass();
        r16.p = RangesKt.coerceAtLeast(r15, 0);
        Iterator r17 = ((LinkedHashMap) r16.l).values().iterator();
    L53:
        if (r17.hasNext() == false) goto L66;
        RecyclerView r18 = (View) r17.next();
        if ((r18 instanceof RecyclerView) == false) goto L57;
        RecyclerView r19 = r18;
    L58:
        if (r19 == null) goto L53;
        r19.invalidateItemDecorations();
        goto L53
    L57:
        r19 = null;
        goto L58
    L66:
        return;
    L47:
        r14 = 0;
        goto L48
    L60:
        return;
    L42:
        r13 = 0.4f;
    L32:
        r2 = false;
        goto L33
    L25:
        r9 = 8;
    L19:
        r6 = false;
    L10:
        r4 = false;
        goto L12
    L5:
        r1 = false;
        goto L6
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final void v4() {
        this.P0.a();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final boolean wB() {
        kf5.b r0 = this.f;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.isShowing() != true) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final com.bytedance.ee.bear.middleground.comment.card.d z7() {
        com.bytedance.ee.bear.middleground.comment.card.d r0 = this.E;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        return null;
    L6:
        return r0;
    }

    public static boolean n() {
        if (com.bytedance.ee.bear.middleground.comment.export.e.b() == false) goto L5;
    L8:
        return true;
    L5:
        if (com.bytedance.ee.bear.middleground.comment.export.e.a() == false) goto L8;
        return false;
    }

    public final void j() {
        if (com.bytedance.ee.bear.middleground.comment.export.e.b() == true) goto L5;
        return;
    L5:
        ConstraintLayout r0 = this.q;
        ImageView r2 = null;
        if ((r0 instanceof ConstraintLayout) == false) goto L8;
        ConstraintLayout r1 = r0;
    L9:
        if (r1 != null) goto L11;
        return;
    L11:
        int r3 = we5.a.a;
        ImageView r4 = this.Q;
        if (r4 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("atButton");
        r4 = null;
    L14:
        AppCompatImageView r5 = this.J;
        if (r5 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("voiceButton");
        r5 = null;
    L17:
        ImageView r6 = this.L;
        if (r6 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("imageButton");
    L21:
        Intrinsics.checkNotNullParameter(r1, "container");
        Intrinsics.checkNotNullParameter(r4, "anchorView");
        Intrinsics.checkNotNullParameter(r5, "voiceView");
        Intrinsics.checkNotNullParameter(r2, "imageView");
        ConstraintSet r7 = new ConstraintSet();
        r7.clone(r1);
        r7.clear(r5.getId(), 1);
        r7.clear(r2.getId(), 1);
        if (r2.getVisibility() != 0) goto L24;
        boolean r8 = true;
    L26:
        if (r8 == false) goto L28;
        r7.connect(r2.getId(), 1, r4.getId(), 2);
        r7.connect(r5.getId(), 1, r2.getId(), 2);
    L29:
        r7.applyTo(r1);
        return;
    L28:
        r7.connect(r5.getId(), 1, r4.getId(), 2);
        r7.connect(r2.getId(), 1, r5.getId(), 2);
        goto L29
    L24:
        r8 = false;
        goto L26
    L20:
        r2 = r6;
        goto L21
    L8:
        r1 = null;
        goto L9
    }

    public static final com.bytedance.ee.bear.middleground.comment.audio.voiceinput.g a(HalfScreenCardComment r0) {
        return (com.bytedance.ee.bear.middleground.comment.audio.voiceinput.g) r0.I.getValue();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final void E7(String r5) {
        Intrinsics.checkNotNullParameter(r5, "commentId");
        com.bytedance.ee.bear.middleground.comment.card.d r0 = this.E;
        com.bytedance.ee.bear.middleground.comment.card.d r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r0 = null;
    L5:
        r0.getClass();
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r0.d = r5;
        ScrollControlViewPager r6 = this.n;
        com.bytedance.ee.bear.middleground.comment.card.d r2 = this.E;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
    L9:
        r6.w(r1.j(this.n.getCurrentItem()), false);
        return;
    L8:
        r1 = r2;
        goto L9
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final void Fa(CardCommentHeight r8) {
        Intrinsics.checkNotNullParameter(r8, "height");
        tt5.a.h("Comment#CardComment", "updatePanelHeight: height = " + r8);
        int r9 = c.a[r8.ordinal()];
        boolean r0 = false;
        if (r9 != 1) goto L5;
        float r10 = this.a.c0;
    L33:
        if (this.e.c() != r10) goto L35;
        r0 = true;
    L35:
        if (r0 == false) goto L38;
        tt5.a.h("Comment#CardComment", "updatePanelHeight: height not change");
        return;
    L38:
        this.e.j(r10, 200);
        return;
    L5:
        if (r9 != 2) goto L7;
        r10 = this.a.b0;
        goto L33
    L7:
        if (r9 != 3) goto L9;
        r10 = this.a.a0;
        goto L33
    L9:
        if (r9 != 4) goto L11;
        r10 = this.a.Z;
        goto L33
    L11:
        if (r9 != 5) goto L27;
        float r11 = this.e.c();
        List r3 = CollectionsKt.sortedWith(CollectionsKt.listOf(new Float[]{Float.valueOf(this.a.b0), Float.valueOf(this.a.a0)}), new j());
        Iterator r4 = r3.iterator();
    L14:
        if (r4.hasNext() == false) goto L21;
        Object r5 = r4.next();
        if (((Number) r5).floatValue() >= r11) goto L18;
        boolean r6 = true;
    L19:
        if (r6 == false) goto L14;
    L22:
        Float r7 = (Float) r5;
        if (r7 == null) goto L25;
        r10 = r7.floatValue();
        goto L33
    L25:
        r10 = ((Number) CollectionsKt.last(r3)).floatValue();
        goto L33
    L18:
        r6 = false;
        goto L19
    L21:
        r5 = null;
        goto L22
    L27:
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final void Ni(boolean r7) {
        com.bytedance.ee.bear.middleground.comment.audio.voiceinput.g r0 = h();
        if (r0 == null) goto L5;
        r0.d();
        r0.destroy();
    L5:
        CommentImmersiveVoiceTouchDelegate r1 = g();
        if (r1 == null) goto L8;
        r1.a();
    L8:
        this.d.h();
        com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.g r2 = com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.g.a;
        FragmentActivity r3 = this.a.getActivity();
        Fragment r4 = this.a.b;
        r2.getClass();
        sa5.b r5 = com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.g.a(r3, r4);
        if (r5 == null) goto L11;
        r5.d(this.v1);
    L11:
        CommentEditText r6 = this.M;
        com.bytedance.ee.bear.middleground.comment.card.d r8 = null;
        if (r6 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("commentEditText");
        r6 = null;
    L14:
        kn4.g r9 = r6.getAtWindow();
        if (r9 != null) goto L17;
    L19:
        boolean r10 = false;
    L20:
        if (r10 == false) goto L27;
        CommentEditText r11 = this.M;
        if (r11 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("commentEditText");
        r11 = null;
    L24:
        kn4.g r12 = r11.getAtWindow();
        if (r12 == null) goto L27;
        r12.close();
    L27:
        kf5.b r13 = this.f;
        if (r13 != null) goto L30;
    L32:
        boolean r14 = false;
    L33:
        if (r14 == false) goto L38;
        tt5.a.h("Comment#CardComment", "dismiss HalfScreenCardComment, so dismiss inputComment");
        kf5.b r15 = this.f;
        if (r15 == null) goto L38;
        kf5.a.a(r15, false, false, 3);
    L38:
        if (com.bytedance.ee.bear.middleground.comment.export.e.b() == false) goto L40;
    L45:
        this.b.a().remove(this.h1);
        View r16 = this.g;
        if (r16 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        r16 = null;
    L48:
        r16.setPadding(0, 0, 0, 0);
        this.t.setVisibility(8);
        AtUtils.c.clear();
        com.bytedance.ee.bear.middleground.comment.card.d r17 = this.E;
        if (r17 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r17 = null;
    L51:
        MutableLiveData<List<CommentBean>> r18 = r17.f;
        if (r18 == null) goto L54;
        r18.removeObservers(this.a.getActivity());
    L54:
        LiveData<ConnectionService.NetworkState> r19 = this.Z;
        if (r19 == null) goto L57;
        r19.removeObserver(this.g1);
    L57:
        com.bytedance.ee.bear.middleground.comment.card.d r20 = this.E;
        if (r20 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
    L61:
        r8.b();
        this.P0.a();
        this.n.w(0, false);
        com.bytedance.ee.bear.middleground.comment.export.bean.a r21 = this.Y;
        if (r21 != null) goto L64;
    L70:
        boolean r22 = false;
    L71:
        if (r7 == false) goto L75;
        if (r21 == null) goto L75;
        if (r22 == true) goto L75;
        o(r21);
    L76:
        this.a.N.a(new ef5.d());
        Function1<Boolean, Unit> r23 = this.b.n();
        if (r23 == null) goto L80;
        r23.invoke(Boolean.FALSE);
        return;
    L80:
        return;
    L75:
        k(true, false);
        goto L76
    L64:
        if (r21.d == false) goto L70;
        if (r21.j == false) goto L70;
        if (r21.f == true) goto L70;
        r22 = true;
        goto L71
    L60:
        r8 = r20;
        goto L61
    L40:
        if (com.bytedance.ee.bear.middleground.comment.export.e.a() == true) goto L45;
        this.G.k();
        this.G.i();
        CommentEditText r24 = this.M;
        if (r24 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("commentEditText");
        r24 = null;
    L44:
        r24.L();
        this.G.f();
        p(false);
        goto L45
    L30:
        if (r13.isShowing() != true) goto L32;
        r14 = true;
        goto L33
    L17:
        if (r9.isShowing() != true) goto L19;
        r10 = true;
        goto L20
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r5v7, types: [com.bytedance.ee.bear.middleground.comment.share.SharePermissionViewModel] */
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
    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final void Qa(FocusInputBean r5) {
        Intrinsics.checkNotNullParameter(r5, "focusInputBean");
        if (this.a.q.getComment() == true) goto L7;
        tt5.a.k("Comment#CardComment", "focusInput: not comment permission");
        return;
    L7:
        if (Intrinsics.areEqual(r5.getCommentId(), UT()) == true) goto L10;
        tt5.a.h("Comment#CardComment", "focusInput: not current comment");
        return;
    L10:
        tt5.a.h("Comment#CardComment", "focusInput: switch to full screen，" + r5);
        int r0 = r5.getType();
        if (r0 == 0) goto L34;
        com.bytedance.ee.bear.middleground.comment.card.d r2 = null;
        ?? r3 = 0;
        if (r0 != 1) goto L15;
        com.bytedance.ee.bear.middleground.comment.card.d r1 = this.E;
        if (r1 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
    L29:
        CommentBean r4 = r2.e(Integer.valueOf(this.n.getCurrentItem()));
        if (r4 != null) goto L33;
        tt5.a.k("Comment#CardComment", "focusInput: commentBean is null");
        return;
    L33:
        int r6 = com.bytedance.ee.bear.middleground.comment.input.utils.c.a;
        com.bytedance.ee.bear.middleground.comment.input.utils.c.a(r4, r5.getReplyId(), this.a, this.b, r5.getFrom());
        return;
    L28:
        r2 = r1;
        goto L29
    L15:
        if (r0 == 2) goto L18;
        return;
    L18:
        if (this.p0 == false) goto L24;
        ?? r7 = this.L0;
        CommentEditText r8 = this.M;
        if (r8 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("commentEditText");
    L23:
        r7.i(r3, true, new HalfScreenCardComment$focusInput$1(this));
        goto L24
    L22:
        r3 = r8;
    L24:
        s(this, false, false, 6);
        return;
    L34:
        tt5.a.k("Comment#CardComment", "unsupported type");
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final void RL(com.bytedance.ee.bear.middleground.comment.export.bean.a r1) {
        this.Y = r1;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final void eX(com.bytedance.ee.bear.middleground.comment.export.bean.a r1) {
        this.X = r1;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final void h5(Function0<Boolean> r2) {
        this.a.Y = r2;
        t();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final void hc(ScrollCommentBean r7) {
        Intrinsics.checkNotNullParameter(r7, "scrollCommentBean");
        if (this.p0 == true) goto L5;
        return;
    L5:
        com.bytedance.ee.bear.middleground.comment.card.d r0 = this.E;
        CommentPagerAdapter r1 = null;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r0 = null;
    L8:
        String r3 = r7.cur_comment_id;
        int r4 = com.bytedance.ee.bear.middleground.comment.card.d.l;
        r0.s(r3, null);
        com.bytedance.ee.bear.middleground.comment.card.d r2 = this.E;
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r2 = null;
    L11:
        int r5 = r2.j(this.n.getCurrentItem());
        if (r5 == this.n.getCurrentItem()) goto L16;
        tt5.a.h("Comment#CardComment", "commentCardScrollTo: outPosition = " + r5);
        return;
    L16:
        if (r7.replyId.equals(ScrollCommentBean.HEAD) == false) goto L22;
        CommentPagerAdapter r6 = this.D;
        if (r6 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
    L21:
        r1.k(r5, 0, r7.replyPercentage);
        return;
    L20:
        r1 = r6;
        goto L21
    L22:
        com.bytedance.ee.bear.middleground.comment.card.d r8 = this.E;
        if (r8 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r8 = null;
    L25:
        int r9 = r8.h(r5, r7.replyId);
        if (r9 >= 0) goto L29;
        tt5.a.h("Comment#CardComment", "commentCardScrollTo: replyId fail");
        return;
    L29:
        CommentPagerAdapter r10 = this.D;
        if (r10 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
    L33:
        r1.k(r5, r9, r7.replyPercentage);
        return;
    L32:
        r1 = r10;
        goto L33
    }

    public final void m(boolean r4) {
        l();
        int r0 = 0;
        if (r4 == false) goto L5;
        u(false);
    L5:
        this.U = this.a.q.a();
        View r5 = this.m;
        if (i() == false) goto L8;
        int r1 = 0;
    L9:
        r5.setVisibility(r1);
        boolean r6 = this.a.q.getComment();
        this.T = r6;
        View r2 = this.q;
        if (r6 == true) goto L13;
        r0 = 8;
    L13:
        r2.setVisibility(r0);
        t();
        return;
    L8:
        r1 = 8;
        goto L9
    }

    public final void o(com.bytedance.ee.bear.middleground.comment.export.bean.a r4) {
        if (r4 == null) goto L8;
        ValueAnimator r0 = ValueAnimator.ofFloat(new float[]{r4.b, r4.c});
        r0.addUpdateListener(new h(r4, this));
        Animator.AnimatorListener r1 = r4.g;
        if (r1 == null) goto L6;
        r0.addListener(r1);
    L6:
        r0.addListener(new i(r4, this));
        r0.setDuration(r4.i);
        r0.start();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [android.widget.EditText] */
    public final void p(boolean r5) {
        UDEditText r0 = this.M;
        ?? r1 = 0;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("commentEditText");
        r0 = null;
    L5:
        ViewGroup.LayoutParams r2 = r0.getLayoutParams();
        if (r5 == false) goto L9;
        if (r2 == null) goto L11;
        r2.height = (int) this.a.getActivity().getResources().getDimension(2131165348);
    L11:
        CommentEditText r6 = this.M;
        if (r6 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("commentEditText");
    L15:
        r1.requestLayout();
        return;
    L14:
        r1 = r6;
        goto L15
    L9:
        if (r2 == null) goto L11;
        r2.height = -2;
        goto L11
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final void qN(boolean r13) {
        this.e.f();
        Resources r0 = this.a.getActivity().getResources();
        AppCompatEditText r1 = this.M;
        CommentPagerAdapter r2 = null;
        AppCompatEditText r3 = r1;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("commentEditText");
        r3 = null;
    L5:
        com.bytedance.ee.bear.middleground.comment.card.d r4 = this.E;
        if (r4 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r4 = null;
    L8:
        Intrinsics.checkNotNull(r0);
        com.bytedance.ee.bear.middleground.comment.uitls.p r5 = this.a;
        long r6 = r5.o;
        FragmentActivity r7 = r5.getActivity();
        r4.getClass();
        Intrinsics.checkNotNullParameter(r0, "resource");
        Intrinsics.checkNotNullParameter(r7, "activity");
        if (com.bytedance.ee.bear.middleground.comment.card.d.p(r0, r7) == false) goto L12;
        CharSequence r8 = r0.getString(2131887624);
    L15:
        r3.setHint(r8);
        com.bytedance.ee.bear.middleground.comment.card.d r9 = this.E;
        if (r9 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r9 = null;
    L18:
        FragmentActivity r10 = this.a.getActivity();
        r9.getClass();
        Intrinsics.checkNotNullParameter(r0, "resource");
        Intrinsics.checkNotNullParameter(r10, "activity");
        r3.setEnabled(!com.bytedance.ee.bear.middleground.comment.card.d.p(r0, r10));
        com.bytedance.ee.bear.middleground.comment.card.d r11 = this.E;
        if (r11 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r11 = null;
    L21:
        String r12 = String.valueOf(r3.getText());
        FragmentActivity r14 = this.a.getActivity();
        r11.getClass();
        Intrinsics.checkNotNullParameter(r0, "resource");
        Intrinsics.checkNotNullParameter(r12, "text");
        Intrinsics.checkNotNullParameter(r14, "activity");
        if (com.bytedance.ee.bear.middleground.comment.card.d.p(r0, r14) == false) goto L24;
        r11.h = r12;
        String r15 = "";
    L25:
        r3.setText(r15);
        ImageView r16 = this.P;
        if (r16 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("sendView");
        r16 = null;
    L28:
        com.bytedance.ee.bear.middleground.comment.card.d r17 = this.E;
        if (r17 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r17 = null;
    L31:
        FragmentActivity r18 = this.a.getActivity();
        r17.getClass();
        r16.setVisibility(com.bytedance.ee.bear.middleground.comment.card.d.d(r0, r18));
        AppCompatImageView r19 = this.J;
        if (r19 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("voiceButton");
        r19 = null;
    L34:
        com.bytedance.ee.bear.middleground.comment.card.d r20 = this.E;
        if (r20 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r20 = null;
    L37:
        FragmentActivity r21 = this.a.getActivity();
        r20.getClass();
        int r22 = 0;
        if (com.bytedance.ee.bear.middleground.comment.card.d.d(r0, r21) == 0) goto L40;
    L49:
        int r23 = 8;
    L50:
        r19.setVisibility(r23);
        ImageView r24 = this.L;
        if (r24 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("imageButton");
        r24 = null;
    L53:
        com.bytedance.ee.bear.middleground.comment.card.d r25 = this.E;
        if (r25 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r25 = null;
    L56:
        FragmentActivity r110 = this.a.getActivity();
        r25.getClass();
        if (com.bytedance.ee.bear.middleground.comment.card.d.d(r0, r110) == 0) goto L59;
    L61:
        int r26 = 8;
    L62:
        r24.setVisibility(r26);
        j();
        ImageView r27 = this.Q;
        if (r27 != null) goto L65;
        Intrinsics.throwUninitializedPropertyAccessException("atButton");
        r27 = null;
    L65:
        com.bytedance.ee.bear.middleground.comment.card.d r111 = this.E;
        if (r111 != null) goto L68;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r111 = null;
    L68:
        FragmentActivity r112 = this.a.getActivity();
        r111.getClass();
        r27.setVisibility(com.bytedance.ee.bear.middleground.comment.card.d.d(r0, r112));
        this.a.h.getClass();
        if (com.bytedance.ee.bear.middleground.comment.p.c() != true) goto L75;
        ImageView r28 = this.Q;
        if (r28 != null) goto L73;
        Intrinsics.throwUninitializedPropertyAccessException("atButton");
        r28 = null;
    L73:
        r28.setVisibility(8);
    L75:
        if (this.p0 == false) goto L77;
        this.L0.d();
    L77:
        Guideline r29 = this.u;
        com.bytedance.ee.bear.middleground.comment.card.d r30 = this.E;
        if (r30 != null) goto L80;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r30 = null;
    L80:
        FragmentActivity r31 = this.a.getActivity();
        r30.getClass();
        Intrinsics.checkNotNullParameter(r0, "resource");
        Intrinsics.checkNotNullParameter(r31, "activity");
        if (com.bytedance.ee.bear.middleground.comment.card.d.p(r0, r31) == true) goto L84;
        r22 = r0.getDimensionPixelSize(2131168352);
    L84:
        r29.setGuidelineEnd(r22);
        CommentPagerAdapter r32 = this.D;
        if (r32 != null) goto L87;
        Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
    L88:
        r2.i(r13);
        t();
        return;
    L87:
        r2 = r32;
        goto L88
    L59:
        if (this.H.c.E == false) goto L61;
        r26 = 0;
        goto L62
    L40:
        if (this.H.f() == false) goto L49;
        if (this.H.j() == true) goto L44;
    L46:
        boolean r33 = false;
    L47:
        if (r33 == true) goto L49;
        r23 = 0;
        goto L50
    L44:
        if (com.bytedance.ee.bear.middleground.comment.export.e.b() == false) goto L46;
        r33 = true;
        goto L47
    L24:
        r15 = r11.h;
        goto L25
    L12:
        if (r6 != 1) goto L14;
        r8 = r0.getString(2131887629);
        goto L15
    L14:
        r8 = r0.getString(2131887609);
        goto L15
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final void r20(View r4) {
        Intrinsics.checkNotNullParameter(r4, "itemView");
        if (this.p0 == false) goto L5;
        return;
    L5:
        r4.postDelayed(new e(this, r4), 200);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final void tI(String r2) {
        if (com.bytedance.ee.bear.middleground.comment.export.e.b() == true) goto L5;
        return;
    L5:
        if (r2 != null) goto L7;
    L14:
        r2 = UT();
    L15:
        this.O = r2;
        return;
    L7:
        if (r2.length() <= 0) goto L9;
        boolean r0 = true;
    L10:
        if (r0 == true) goto L13;
        r2 = null;
    L13:
        if (r2 != null) goto L15;
    L9:
        r0 = false;
        goto L10
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void u(boolean r11) {
        StringBuilder r0 = new StringBuilder("updateUiStyle:");
        r0.append(r11);
        r0.append(", last isFullScreen: ");
        com.bytedance.ee.bear.middleground.comment.card.d r2 = this.E;
        View r4 = null;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r2 = null;
    L5:
        r0.append(r2.e);
        tt5.a.h("Comment#CardComment", r0.toString());
        com.bytedance.ee.bear.middleground.comment.card.d r1 = this.E;
        if (r1 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r1 = null;
    L9:
        if (r1.e != r11) goto L11;
        return;
    L11:
        com.bytedance.ee.bear.middleground.comment.card.d r3 = this.E;
        if (r3 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r3 = null;
    L14:
        r3.e = r11;
        if (r11 == false) goto L46;
        CommentEditText r5 = this.M;
        if (r5 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("commentEditText");
        r5 = null;
    L19:
        kn4.g r6 = r5.getAtWindow();
        if (r6 == null) goto L22;
        r6.close();
    L22:
        View r7 = this.g;
        if (r7 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        r7 = null;
    L25:
        r7.setBackgroundResource(2131100548);
        int[] r8 = new int[2];
        View r9 = this.g;
        if (r9 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        r9 = null;
    L28:
        r9.getLocationOnScreen(r8);
        if (r8[1] != 0) goto L31;
        int r10 = com.bytedance.ee.util.ui.k.e(this.a.getActivity());
    L32:
        View r12 = this.h;
        r12.setPadding(0, r10, 0, r12.getPaddingBottom());
        CommentPagerAdapter r13 = this.D;
        if (r13 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
        r13 = null;
    L35:
        RecyclerView r14 = r13.P0(Integer.valueOf(this.n.getCurrentItem()));
        if (r14 == null) goto L38;
        RecyclerView.LayoutManager r15 = r14.getLayoutManager();
    L40:
        if ((r15 instanceof LinearLayoutManager) == false) goto L42;
        LinearLayoutManager r16 = (LinearLayoutManager) r15;
    L43:
        if (r16 == null) goto L45;
        r16.findLastVisibleItemPosition();
    L45:
        this.s.setVisibility(8);
        this.q.setVisibility(8);
        this.j.setVisibility(0);
        this.i.setVisibility(4);
        this.s.setVisibility(8);
        this.l.setShadowSize(UDShadowLayout.Size.NONE);
    L57:
        boolean r17 = !r11;
        this.n.setCanScroll(r17);
        this.l.setEnabled(r17);
        View r18 = this.g;
        if (r18 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L61:
        r4.setEnabled(r17);
        t();
        return;
    L60:
        r4 = r18;
        goto L61
    L42:
        r16 = null;
        goto L43
    L38:
        r15 = null;
        goto L40
    L31:
        r10 = 0;
        goto L32
    L46:
        View r19 = this.g;
        if (r19 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        r19 = null;
    L49:
        r19.setBackgroundResource(2131101106);
        tt5.a.h("Comment#CardComment", "updateUiStyle:" + r11 + ", dismiss inputComment");
        kf5.b r20 = this.f;
        if (r20 == null) goto L52;
        kf5.a.a(r20, false, false, 3);
    L52:
        this.s.setVisibility(0);
        this.q.setVisibility(0);
        this.j.setVisibility(8);
        this.s.setVisibility(0);
        if (this.a.p != 1) goto L55;
        this.k.setVisibility(0);
        this.i.setVisibility(0);
    L56:
        this.l.setShadowSize(UDShadowLayout.Size.L);
        goto L57
    L55:
        this.k.setVisibility(0);
        this.i.setVisibility(4);
        goto L56
    }

    public static final void b(HalfScreenCardComment r14, boolean r15) {
        int r1 = 8;
        if (r14.p0 == false) goto L5;
        ViewGroup.LayoutParams r4 = null;
        if (r14.z == false) goto L21;
        tt5.a.h("Comment#CardComment", "mentionBatchAskOwnerEnable is true");
        if (r14.L0.e() == true) goto L16;
        tt5.a.h("Comment#CardComment", "currUserManageCollaborator is false");
        TextView r0 = r14.B;
        View r2 = r14.g;
        if (r2 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        r2 = null;
    L15:
        r0.setText(com.bytedance.ee.util.ui.n.x(r2.getContext(), 2131889126));
    L26:
        AppCompatEditText r3 = r14.M;
        if (r3 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("commentEditText");
        r3 = null;
    L29:
        Editable r5 = r3.getText();
        if (r5 == null) goto L46;
        AppCompatEditText r6 = r14.M;
        if (r6 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("commentEditText");
        r6 = null;
    L34:
        Editable r7 = r6.getText();
        if (r7 == null) goto L37;
        int r8 = r7.length();
    L38:
        un5.l[] r9 = (un5.l[]) r5.getSpans(0, r8, un5.l.class);
        if (r9 == null) goto L46;
        int r10 = r9.length;
        int r11 = 0;
        boolean r12 = false;
    L41:
        if (r11 >= r10) goto L48;
        if (r9[r11].j == false) goto L45;
        r12 = true;
    L45:
        r11 = r11 + 1;
    L48:
        if (com.bytedance.ee.bear.middleground.comment.export.e.b() == false) goto L53;
        if (Intrinsics.areEqual(r14.y, Boolean.valueOf(r12)) == false) goto L53;
        return;
    L53:
        if (com.bytedance.ee.bear.middleground.comment.export.e.b() == false) goto L55;
        r14.y = Boolean.valueOf(r12);
    L55:
        AnimatorSet r13 = r14.w;
        if (r13 != null) goto L58;
    L60:
        boolean r16 = false;
    L61:
        if (r16 == false) goto L64;
        if (r12 == false) goto L64;
        return;
    L64:
        AnimatorSet r17 = r14.x;
        if (r17 != null) goto L67;
    L69:
        boolean r18 = false;
    L70:
        if (r18 == false) goto L74;
        if (r12 == true) goto L74;
        return;
    L74:
        if (r14.v.getVisibility() != 0) goto L76;
        boolean r19 = true;
    L77:
        if (r19 != r12) goto L93;
        AnimatorSet r20 = r14.w;
        if (r20 != null) goto L81;
    L83:
        boolean r21 = false;
    L84:
        if (r21 == true) goto L93;
        AnimatorSet r22 = r14.x;
        if (r22 != null) goto L88;
    L90:
        boolean r23 = false;
    L91:
        if (r23 == true) goto L93;
        return;
    L88:
        if (r22.isRunning() != true) goto L90;
        r23 = true;
        goto L91
    L81:
        if (r20.isRunning() != true) goto L83;
        r21 = true;
    L93:
        if (r12 == false) goto L118;
        com.bytedance.ee.bear.middleground.comment.uitls.h r24 = r14.a.d0;
        String r25 = r14.UT();
        CommentPlugin.g r26 = r14.a.R;
        if (r26 != null) goto L97;
    L99:
        boolean r110 = false;
    L100:
        CommentPlugin.g r27 = r14.a.R;
        if (r27 != null) goto L103;
    L105:
        boolean r111 = false;
    L106:
        com.bytedance.ee.bear.middleground.comment.card.d r28 = r14.E;
        if (r28 != null) goto L109;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r28 = null;
    L109:
        CommentBean r29 = r28.e(Integer.valueOf(r14.n.getCurrentItem()));
        if (r29 == null) goto L116;
        CommentBean.Extra r30 = r29.getExtra();
        if (r30 == null) goto L116;
        String r31 = r30.getReportVisibility();
        if (r31 == null) goto L116;
        String r112 = r31;
    L117:
        r24.f(r25, "", r110, r111, r112);
    L116:
        r112 = null;
        goto L117
    L103:
        if (r27.c() != true) goto L105;
        r111 = true;
        goto L106
    L97:
        if (r26.b() != true) goto L99;
        r110 = true;
    L118:
        AnimatorSet r32 = r14.x;
        if (r32 == null) goto L121;
        r32.cancel();
    L121:
        AnimatorSet r33 = r14.w;
        if (r33 == null) goto L124;
        r33.cancel();
    L124:
        r14.A.setChecked(false);
        ViewGroup r34 = r14.v;
        if (r12 == false) goto L127;
        r1 = 0;
    L127:
        r34.setVisibility(r1);
        if (r15 == false) goto L140;
        if (com.bytedance.ee.bear.middleground.comment.export.e.b() == false) goto L137;
        if (r12 == false) goto L137;
        ViewGroup r113 = r14.v;
        ViewGroup.LayoutParams r35 = r113.getLayoutParams();
        if (r35 == null) goto L135;
        r35.height = -2;
        r4 = r35;
    L135:
        r113.setLayoutParams(r4);
        r14.v.setAlpha(1.0f);
        r14.v.requestLayout();
        return;
    L137:
        if (com.bytedance.ee.bear.middleground.comment.export.e.b() == false) goto L158;
        r14.v.setAlpha(0.0f);
        return;
    L158:
        return;
    L140:
        if (r14.w != null) goto L142;
    L143:
        int r114 = View.MeasureSpec.makeMeasureSpec(1073741823, 0);
        r14.v.getLayoutParams().height = -2;
        r14.v.measure(r114, r114);
        r14.w = r14.e(0, r14.v.getMeasuredHeight(), 0.0f, 1.0f);
        r14.x = r14.e(r14.v.getMeasuredHeight(), 0, 1.0f, 0.0f);
    L144:
        if (r12 == false) goto L148;
        AnimatorSet r115 = r14.w;
        if (r115 == null) goto L160;
        r115.start();
        return;
    L160:
        return;
    L148:
        AnimatorSet r116 = r14.x;
        if (r116 == null) goto L162;
        r116.addListener(new l0(r14, r116, r116));
        r116.start();
        return;
    L162:
        return;
    L142:
        if (r14.x != null) goto L144;
    L76:
        r19 = false;
        goto L77
    L67:
        if (r17.isRunning() != true) goto L69;
        r18 = true;
        goto L70
    L58:
        if (r13.isRunning() != true) goto L60;
        r16 = true;
        goto L61
    L37:
        r8 = 0;
    L46:
        r12 = false;
        goto L48
    L16:
        tt5.a.h("Comment#CardComment", "currUserManageCollaborator is true");
        TextView r36 = r14.B;
        View r37 = r14.g;
        if (r37 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        r37 = null;
    L19:
        r36.setText(com.bytedance.ee.util.ui.n.x(r37.getContext(), 2131889123));
        goto L26
    L21:
        if (r14.L0.e() == true) goto L26;
        tt5.a.h("Comment#CardComment", "currUserManageCollaborator is false");
        if (com.bytedance.ee.bear.middleground.comment.export.e.b() == false) goto L25;
        r14.y = Boolean.FALSE;
    L25:
        r14.v.setVisibility(8);
        return;
    L5:
        if (com.bytedance.ee.bear.middleground.comment.export.e.b() == false) goto L7;
        r14.y = Boolean.FALSE;
    L7:
        r14.v.setVisibility(8);
    }

    public static final void d(HalfScreenCardComment r3, int r4) {
        ImageView r0 = r3.p;
        com.bytedance.ee.bear.middleground.comment.card.d r1 = r3.E;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r1 = null;
    L5:
        boolean r2 = true;
        r0.setEnabled(!r1.o(r4));
        ImageView r5 = r3.o;
        if (r4 != 0) goto L9;
        r2 = false;
    L9:
        r5.setEnabled(r2);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final void Q6(String r2, Integer r3) {
        Intrinsics.checkNotNullParameter(r2, "commentId");
        com.bytedance.ee.bear.middleground.comment.card.d r4 = this.E;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r4 = null;
    L5:
        r4.getClass();
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        r4.d = r2;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final void fj(String r13, Integer r14) {
        Intrinsics.checkNotNullParameter(r13, "targetId");
        Function1<Boolean, Unit> r0 = this.b.n();
        if (r0 == null) goto L5;
        r0.invoke(Boolean.TRUE);
    L5:
        boolean r1 = true;
        m(true);
        if (this.b1 == false) goto L9;
        this.e.k = true;
    L9:
        if (this.a.A == false) goto L22;
        this.e.e.getLayoutParams().height = 1;
        if (this.k1 == true) goto L13;
    L17:
        boolean r2 = false;
    L18:
        if (r2 == false) goto L20;
        com.bytedance.ee.bear.facade.common.widget.d r3 = this.e;
        r3.b = 0.5f;
        r3.a = 0.5f;
        com.bytedance.ee.bear.middleground.comment.uitls.p r4 = this.a;
        r3.n(r4.Z, r4.a0, r4.b0, r4.c0);
    L21:
        this.e.j(this.a.b0, 200).addListener(new f(this));
    L23:
        qN(false);
        com.bytedance.ee.bear.middleground.comment.card.d r5 = this.E;
        com.bytedance.ee.bear.middleground.comment.card.d r6 = null;
        if (r5 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r5 = null;
    L26:
        r5.s(r13, null);
        this.b.a().remove(this.h1);
        this.b.a().add(this.h1);
        com.bytedance.ee.bear.middleground.comment.card.d r7 = this.E;
        if (r7 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r7 = null;
    L29:
        MutableLiveData<List<CommentBean>> r8 = r7.f;
        if (r8 == null) goto L32;
        r8.removeObservers(this.a.getActivity());
    L32:
        LiveData<ConnectionService.NetworkState> r9 = com.bytedance.ee.bear.contract.j.a.a.a();
        this.Z = r9;
        if (r9 == null) goto L35;
        r9.observe(this.a.getActivity(), this.g1);
    L35:
        com.bytedance.ee.bear.middleground.comment.card.d r10 = this.E;
        if (r10 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r10 = null;
    L38:
        MutableLiveData<List<CommentBean>> r11 = r10.f;
        if (r11 == null) goto L41;
        r11.observe(this.a.getActivity(), new g(this));
    L41:
        tt5.a.h("Comment#CardComment", "show card comment");
        this.a.d0.j("comment");
        this.a.d0.d("view_docs_message_sub_page", null, "", "", true);
        this.e.f();
        this.e.i = 1;
        if (r14 != null) goto L49;
        int r12 = com.bytedance.ee.bear.middleground.comment.card.a.a;
        if (r12 == 0) goto L47;
        r1 = false;
    L47:
        if (r1 == true) goto L49;
        com.bytedance.ee.bear.middleground.comment.card.a.a = 0;
        r14 = Integer.valueOf(r12);
    L49:
        if (r14 == null) goto L51;
        this.e.l(r14.intValue());
    L51:
        com.bytedance.ee.bear.middleground.comment.card.d r15 = this.E;
        if (r15 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r15 = null;
    L54:
        r15.g = r14;
        View r16 = this.g;
        if (r16 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        r16 = null;
    L57:
        ViewParent r17 = r16.getParent();
        if ((r17 instanceof ViewGroup) == false) goto L60;
        ViewGroup r18 = (ViewGroup) r17;
    L61:
        if (r18 == null) goto L66;
        View r19 = this.g;
        if (r19 != null) goto L65;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        r19 = null;
    L65:
        r18.removeView(r19);
    L66:
        FrameLayout r110 = this.a.c;
        View r20 = this.g;
        if (r20 != null) goto L69;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        r20 = null;
    L69:
        r110.addView(r20);
        com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.g r111 = com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.g.a;
        FragmentActivity r21 = this.a.getActivity();
        Fragment r22 = this.a.b;
        r111.getClass();
        sa5.b r112 = com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.g.a(r21, r22);
        if (r112 == null) goto L72;
        r112.e(this.v1);
    L72:
        StringBuilder r113 = new StringBuilder("show card comment, targetId = ");
        r113.append(r13);
        r113.append(", currentCommentId = ");
        com.bytedance.ee.bear.middleground.comment.card.d r23 = this.E;
        if (r23 != null) goto L75;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
    L76:
        r113.append(r6.k);
        tt5.a.h("Comment#CardComment", r113.toString());
        this.a.N.a(new ef5.i(r13));
        o(this.X);
        return;
    L75:
        r6 = r23;
        goto L76
    L60:
        r18 = null;
        goto L61
    L20:
        com.bytedance.ee.bear.facade.common.widget.d r24 = this.e;
        com.bytedance.ee.bear.middleground.comment.uitls.p r25 = this.a;
        r24.m(r25.Z, r25.b0, r25.c0);
        goto L21
    L13:
        if (this.p1 == false) goto L15;
    L16:
        r2 = true;
        goto L18
    L15:
        if (this.a.s == true) goto L17;
    L22:
        this.e.e();
        goto L23
    }

    public final void k(boolean r4, boolean r5) {
        if (this.b1 == false) goto L5;
        tt5.a.h("Comment#CardComment", "isImageRegionCommentOpenImageEnabled true");
        this.e.k = false;
    L5:
        this.b.z0().invoke(Boolean.valueOf(r5));
        View r6 = this.g;
        View r1 = null;
        if (r6 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        r6 = null;
    L8:
        ViewParent r7 = r6.getParent();
        if ((r7 instanceof ViewGroup) == false) goto L11;
        ViewGroup r8 = (ViewGroup) r7;
    L12:
        if (r8 == null) goto L18;
        View r2 = this.g;
        if (r2 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L17:
        r8.removeView(r1);
        goto L18
    L16:
        r1 = r2;
    L18:
        if (r4 == false) goto L20;
        this.e.f();
    L20:
        this.b.k0().invoke();
        return;
    L11:
        r8 = null;
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r3v3, types: [com.bytedance.ee.bear.middleground.comment.share.SharePermissionViewModel] */
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
    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final void bG(String r3, List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r4, SmartReplyDataForInsert r5) {
        CommentEditText r6 = this.M;
        ?? r1 = 0;
        if (r6 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("commentEditText");
        r6 = null;
    L5:
        r6.setRichText(r3);
        this.N = r4;
        if (this.p0 == true) goto L8;
        return;
    L8:
        if (com.bytedance.ee.bear.middleground.comment.export.e.b() == false) goto L10;
        this.y = null;
    L10:
        ?? r7 = this.L0;
        CommentEditText r8 = this.M;
        if (r8 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("commentEditText");
    L14:
        r7.i(r1, true, new HalfScreenCardComment$updateInputUi$1(this));
        return;
    L13:
        r1 = r8;
        goto L14
    }

    public final void q(final boolean r12, final boolean r13, final String r14) {
        com.bytedance.ee.bear.middleground.comment.export.m r0 = this.a.M;
        boolean r1 = true;
        int r2 = 0;
        if (r0 != null) goto L5;
    L7:
        boolean r3 = false;
    L8:
        if (r3 == false) goto L10;
        return;
    L10:
        CommentEditText r4 = this.M;
        com.bytedance.ee.bear.middleground.comment.card.d r5 = null;
        if (r4 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("commentEditText");
        r4 = null;
    L13:
        final boolean r9 = r4.getAtWindow().isShowing();
        if (r9 == false) goto L40;
        AppCompatEditText r6 = this.M;
        if (r6 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("commentEditText");
        r6 = null;
    L18:
        Editable r7 = r6.getText();
        if (r7 != null) goto L21;
    L26:
        r1 = false;
    L27:
        if (r1 == false) goto L40;
        AppCompatEditText r8 = this.M;
        if (r8 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("commentEditText");
        r8 = null;
    L31:
        Editable r10 = r8.getText();
        if (r10 == null) goto L34;
        r2 = StringsKt.getLastIndex(r10);
    L34:
        AppCompatEditText r11 = this.M;
        if (r11 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("commentEditText");
        r11 = null;
    L37:
        Editable r15 = r11.getText();
        if (r15 == null) goto L40;
        r15.delete(r2, r2 + 1);
        goto L40
    L21:
        if (r7.length() <= 0) goto L23;
        boolean r16 = true;
    L24:
        if (r16 != true) goto L26;
    L23:
        r16 = false;
    L40:
        int r17 = com.bytedance.ee.bear.middleground.comment.uitls.n.a;
        CommentEditText r18 = this.M;
        if (r18 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("commentEditText");
        r18 = null;
    L43:
        Disposable r19 = com.bytedance.ee.bear.middleground.comment.uitls.n.a(r18, new HalfScreenCardComment$toDetail$d$1(this, r14, r12, r9, r13));
        com.bytedance.ee.bear.middleground.comment.card.d r110 = this.E;
        if (r110 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
    L47:
        r5.a(r19);
        return;
    L46:
        r5 = r110;
        goto L47
    L5:
        if (r0.b() == true) goto L7;
        r3 = true;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v13, types: [android.widget.EditText] */
    /* JADX WARN: Type inference failed for: r11v14 */
    /* JADX WARN: Type inference failed for: r11v16 */
    /* JADX WARN: Type inference failed for: r14v39 */
    /* JADX WARN: Type inference failed for: r14v4, types: [android.view.View, com.bytedance.ee.bear.widgets.universedesign.SpaceShadowLayout] */
    /* JADX WARN: Type inference failed for: r14v40, types: [android.widget.EditText] */
    /* JADX WARN: Type inference failed for: r14v46 */
    /* JADX WARN: Type inference failed for: r14v47, types: [android.widget.EditText] */
    /* JADX WARN: Type inference failed for: r14v48 */
    /* JADX WARN: Type inference failed for: r14v49, types: [android.widget.EditText] */
    /* JADX WARN: Type inference failed for: r14v50 */
    /* JADX WARN: Type inference failed for: r14v51, types: [android.widget.ImageView] */
    /* JADX WARN: Type inference failed for: r14v55 */
    /* JADX WARN: Type inference failed for: r14v56 */
    /* JADX WARN: Type inference failed for: r14v57 */
    /* JADX WARN: Type inference failed for: r14v59 */
    public HalfScreenCardComment(com.bytedance.ee.bear.middleground.comment.uitls.p r38, Comment r39, com.bytedance.ee.bear.middleground.comment.control.t r40, com.bytedance.ee.bear.middleground.comment.control.y r41) {
        Intrinsics.checkNotNullParameter(r38, "config");
        Intrinsics.checkNotNullParameter(r39, "commentListeners");
        Intrinsics.checkNotNullParameter(r40, "dataControl");
        Intrinsics.checkNotNullParameter(r41, "actionControl");
        this.a = r38;
        this.b = r39;
        this.c = r40;
        this.d = r41;
        com.bytedance.ee.bear.appsetting.c r7 = com.bytedance.ee.bear.appsetting.c.a.a;
        this.z = r7.g("ccm.mobile.comment_batch_askowner");
        this.G = new RecordViewModel(r38);
        this.H = new b2(r38, r40, r39);
        this.I = LazyKt.lazy(new HalfScreenCardComment$voiceAdapterLazy$1(this));
        this.V = LazyKt.lazy(new HalfScreenCardComment$immersiveVoiceTouchDelegateLazy$1(this));
        this.W = LazyKt.lazy(new HalfScreenCardComment$voiceMentionPermissionHelper$2(this));
        this.k0 = "";
        this.p0 = r7.g("ccm.doc.image_region_comment_view");
        SharePermissionViewModel r8 = new SharePermissionViewModel(r38);
        this.L0 = r8;
        this.P0 = new jf5.a(r38, r39);
        this.b1 = r7.g("ccm.doc.image_region_comment_open_image");
        this.g1 = new k0(this);
        this.h1 = new HalfScreenCardComment$onInputCommentTopChange$1(this);
        this.k1 = r7.g("ccm.mobile.shrink_comment_panel_when_zoom_in");
        this.p1 = r7.g("ccm.mobile.area_comment_polish_for_ms");
        Comment$inputCommentFunction$1 r9 = r39.s;
        Function1<CommentInputRequest, Unit> r10 = new AnonymousClass1(this);
        r9.getClass();
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        r9.b = r10;
        Comment$inputCommentFunction$1 r11 = r39.s;
        Function1<CommentInputRequest, Unit> r12 = new AnonymousClass2(this);
        r11.getClass();
        Intrinsics.checkNotNullParameter(r12, "<set-?>");
        r11.a = r12;
        View r13 = LayoutInflater.from(r38.getActivity()).inflate(2131559853, null);
        this.g = r13;
        if (r13 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        View r14 = null;
    L6:
        View r15 = r14.findViewById(2131382751);
        this.h = r15;
        com.bytedance.ee.bear.facade.common.widget.d r16 = new com.bytedance.ee.bear.facade.common.widget.d(r38.getActivity(), r15);
        this.e = r16;
        if (r13 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        View r17 = null;
    L10:
        ?? r18 = (SpaceShadowLayout) r17.findViewById(2131384717);
        this.l = r18;
        r16.i(r18);
        if (r13 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        View r19 = null;
    L14:
        this.v = (ViewGroup) r19.findViewById(2131365642);
        if (r13 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        View r110 = null;
    L18:
        this.B = (TextView) r110.findViewById(2131365655);
        if (r13 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        View r111 = null;
    L22:
        LKUICheckBox2 r112 = r111.findViewById(2131365640);
        this.A = r112;
        if (r13 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        View r113 = null;
    L26:
        View r114 = r113.findViewById(2131365659);
        this.C = r114;
        if (r13 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        View r115 = null;
    L30:
        View r116 = r115.findViewById(2131367311);
        this.i = r116;
        if (r13 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        View r117 = null;
    L34:
        View r118 = r117.findViewById(2131367326);
        this.j = r118;
        if (r13 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        View r119 = null;
    L38:
        this.k = (TextView) r119.findViewById(2131391057);
        if (r13 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        View r120 = null;
    L42:
        View r121 = r120.findViewById(2131391037);
        this.m = r121;
        if (r13 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        View r122 = null;
    L46:
        ScrollControlViewPager r123 = (ScrollControlViewPager) r122.findViewById(2131369308);
        this.n = r123;
        if (r13 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        View r124 = null;
    L50:
        ImageView r125 = (ImageView) r124.findViewById(2131374783);
        this.o = r125;
        if (r13 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        View r126 = null;
    L54:
        ImageView r127 = (ImageView) r126.findViewById(2131374779);
        this.p = r127;
        if (r13 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        View r128 = null;
    L58:
        View r129 = r128.findViewById(2131369307);
        this.q = r129;
        if (r13 != null) goto L61;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        View r130 = null;
    L62:
        View r131 = r130.findViewById(2131367334);
        this.r = r131;
        if (r13 != null) goto L65;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        View r132 = null;
    L66:
        this.R = r132.findViewById(2131367429);
        if (r13 != null) goto L69;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        View r133 = null;
    L70:
        View r134 = r133.findViewById(2131369302);
        this.H0 = r134;
        if (r13 != null) goto L73;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        View r135 = null;
    L74:
        CommentEditText r136 = (CommentEditText) r135.findViewById(2131371814);
        this.M = r136;
        if (r13 != null) goto L77;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        View r137 = null;
    L78:
        ImageView r138 = (ImageView) r137.findViewById(2131367427);
        this.P = r138;
        if (r13 != null) goto L81;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        View r139 = null;
    L82:
        ImageView r140 = (ImageView) r139.findViewById(2131367309);
        this.Q = r140;
        if (r13 != null) goto L85;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        View r141 = null;
    L86:
        this.S = r141.findViewById(2131377908);
        if (r13 != null) goto L89;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        View r142 = null;
    L90:
        this.s = r142.findViewById(2131367453);
        if (r13 != null) goto L93;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        View r143 = null;
    L94:
        this.t = (SpaceEmptyState) r143.findViewById(2131380919);
        if (r13 != null) goto L97;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        View r144 = null;
    L98:
        MotionImageView r145 = (MotionImageView) r144.findViewById(2131367301);
        this.J = r145;
        if (r13 != null) goto L101;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        View r146 = null;
    L102:
        View r147 = r146.findViewById(2131367474);
        this.K = r147;
        if (r147 != null) goto L105;
        Intrinsics.throwUninitializedPropertyAccessException("commentVoiceBar");
        View r31 = r147;
        View r148 = null;
    L107:
        if ((r148 instanceof CommentVoiceBarLayout) == false) goto L109;
        CommentVoiceBarLayout r149 = (CommentVoiceBarLayout) r148;
    L110:
        if (r149 == null) goto L112;
        r149.setToggleIconConfig(r38.X.l());
    L112:
        if (r13 != null) goto L114;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        View r150 = null;
    L115:
        ImageView r151 = (ImageView) r150.findViewById(2131367287);
        this.L = r151;
        j();
        if (r13 != null) goto L118;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        View r152 = null;
    L119:
        this.u = r152.findViewById(2131389069);
        tt5.a.h("Comment#CardComment", "initDefaultData");
        com.bytedance.ee.bear.middleground.comment.card.d r153 = new com.bytedance.ee.bear.middleground.comment.card.d();
        this.E = r153;
        r153.k(r38.i, r40);
        m(true);
        r38.getActivity();
        kn4.h r3 = new kn4.h(kn4.f.a().a(), r38.k, r38.i);
        r3.f = r129;
        r3.h = (int) (((double) com.bytedance.ee.util.ui.n.t()) * 0.4d);
        r3.p = ((xe5.a) org.koin.java.a.c(xe5.a.class, null, null, 6)).a(null);
        if (r136 != null) goto L122;
        Intrinsics.throwUninitializedPropertyAccessException("commentEditText");
        CommentEditText r154 = null;
    L123:
        r154.C(r3);
        if (r136 != null) goto L126;
        Intrinsics.throwUninitializedPropertyAccessException("commentEditText");
        CommentEditText r155 = null;
    L127:
        r155.getAtWindow().b(new i0(this));
        if (r136 != null) goto L130;
        Intrinsics.throwUninitializedPropertyAccessException("commentEditText");
        CommentEditText r156 = null;
    L131:
        kn4.g r4 = r156.getAtWindow();
        if (r4 == null) goto L134;
        r4.f(new j0(this));
    L134:
        CommentPagerAdapter r5 = new CommentPagerAdapter();
        this.D = r5;
        Intrinsics.checkNotNullParameter(r123, "<set-?>");
        r5.m = r123;
        CommentPagerAdapter r157 = this.D;
        if (r157 != null) goto L137;
        Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
        r157 = null;
    L137:
        FragmentActivity r158 = r38.getActivity();
        com.bytedance.ee.bear.middleground.comment.export.o r159 = r38.q;
        String r20 = ((com.bytedance.ee.bear.contract.i0) org.koin.java.a.c(com.bytedance.ee.bear.contract.i0.class, null, null, 6)).a();
        com.bytedance.ee.bear.middleground.comment.card.d r160 = this.E;
        if (r160 != null) goto L140;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r160 = null;
    L140:
        Function0<Unit> r21 = new HalfScreenCardComment$initDefaultData$1(this);
        r157.getClass();
        Intrinsics.checkNotNullParameter(r38, "config");
        Intrinsics.checkNotNullParameter(r158, "activity");
        Intrinsics.checkNotNullParameter(r159, "per");
        Intrinsics.checkNotNullParameter(r20, "language");
        Intrinsics.checkNotNullParameter(r39, "IListeners");
        Intrinsics.checkNotNullParameter(r160, "cardDataViewModel");
        Intrinsics.checkNotNullParameter(r8, "sharePermissionViewModel");
        Intrinsics.checkNotNullParameter(r41, "actionControl");
        Intrinsics.checkNotNullParameter(r21, "clickLink");
        r157.d = r38;
        r157.e = r158;
        r157.f = r20;
        r157.h = r39;
        r157.i = r41;
        r157.j = r21;
        r157.n = r8;
        r157.o = r160;
        CommentPagerAdapter r161 = this.D;
        if (r161 != null) goto L143;
        Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
        r161 = null;
    L143:
        r123.setAdapter(r161);
        t();
        if (r136 != null) goto L146;
        Intrinsics.throwUninitializedPropertyAccessException("commentEditText");
        ?? r162 = 0;
    L147:
        r162.addTextChangedListener(new HalfScreenCardComment$initDefaultData$2(this));
        if (r138 != 0) goto L150;
        Intrinsics.throwUninitializedPropertyAccessException("sendView");
        ImageView r163 = null;
    L151:
        r163.setEnabled(false);
        r15.setOnClickListener(a1.a);
        r114.setOnClickListener(new g1(this));
        r112.setOnCheckedChangeListener(new h1(this));
        if (r131 != 0) goto L154;
        Intrinsics.throwUninitializedPropertyAccessException("createWholeCommentView");
        View r2 = null;
    L155:
        r2.setOnClickListener(new i1(this));
        if (((Boolean) this.b.j0().invoke()).booleanValue() == false) goto L161;
        if (r13 != null) goto L159;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        View r22 = null;
    L160:
        r22.setOnClickListener(new j1(this));
        goto L161
    L159:
        r22 = r13;
    L161:
        r121.setOnTouchListener(new k1(this));
        r121.setOnClickListener(new l1(this));
        r116.setOnClickListener(new m1(this));
        r125.setOnClickListener(new n1(this));
        r127.setOnClickListener(new s0(this));
        if (r134 == 0) goto L164;
        r134.setOnClickListener(new t0(this));
    L164:
        r118.setOnClickListener(new u0(this));
        r16.h = new v0(this);
        r123.b(new w0(this));
        if (r136 != null) goto L167;
        Intrinsics.throwUninitializedPropertyAccessException("commentEditText");
        ?? r164 = 0;
    L168:
        r164.setOnLongClickListener(new x0(this));
        if (r136 != null) goto L171;
        Intrinsics.throwUninitializedPropertyAccessException("commentEditText");
        ?? r165 = 0;
    L172:
        r165.setOnClickListener(new y0(this));
        if (r138 != 0) goto L175;
        Intrinsics.throwUninitializedPropertyAccessException("sendView");
        ImageView r166 = null;
    L176:
        r166.setOnClickListener(new HalfScreenCardComment$setListener$17(this));
        if (r145 != 0) goto L179;
        Intrinsics.throwUninitializedPropertyAccessException("voiceButton");
        ?? r167 = 0;
    L180:
        r167.setOnTouchListener(new z0(this));
        if (r145 != 0) goto L183;
        Intrinsics.throwUninitializedPropertyAccessException("voiceButton");
        MotionImageView r168 = null;
    L184:
        r168.setMotionCallbackListener(new HalfScreenCardComment$setListener$19(this));
        if (r31 != null) goto L187;
        Intrinsics.throwUninitializedPropertyAccessException("commentVoiceBar");
        View r169 = null;
    L188:
        View r1 = r169.findViewById(2131387913);
        if (r1 == null) goto L191;
        r1.setOnClickListener(new b1(this));
    L191:
        if (r31 != null) goto L193;
        Intrinsics.throwUninitializedPropertyAccessException(r15);
        View r170 = null;
    L194:
        View r6 = r170.findViewById(2131371700);
        if (r6 == null) goto L197;
        r6.setOnTouchListener(new c1(this));
    L197:
        if (r151 != 0) goto L199;
        Intrinsics.throwUninitializedPropertyAccessException("imageButton");
        ImageView r171 = null;
    L200:
        r171.setOnClickListener(new d1(this));
        if (r140 != 0) goto L203;
        Intrinsics.throwUninitializedPropertyAccessException("atButton");
        ImageView r172 = null;
    L204:
        r172.setOnClickListener(new e1(this));
        ?? r173 = r136;
        if (r136 != null) goto L207;
        Intrinsics.throwUninitializedPropertyAccessException("commentEditText");
        r173 = 0;
    L207:
        r173.addTextChangedListener(new f1(this));
        tt5.a.h("Comment#CardComment", "init, areaCommentReadEnable = " + this.p0);
        this.v1 = new h0(this);
        return;
    L203:
        r172 = r140;
        goto L204
    L199:
        r171 = r151;
        goto L200
    L193:
        r170 = r31;
        goto L194
    L187:
        r169 = r31;
        goto L188
    L183:
        r168 = r145;
        goto L184
    L179:
        r167 = r145;
        goto L180
    L175:
        r166 = r138;
        goto L176
    L171:
        r165 = r136;
        goto L172
    L167:
        r164 = r136;
        goto L168
    L154:
        r2 = r131;
        goto L155
    L150:
        r163 = r138;
        goto L151
    L146:
        r162 = r136;
        goto L147
    L130:
        r156 = r136;
        goto L131
    L126:
        r155 = r136;
        goto L127
    L122:
        r154 = r136;
        goto L123
    L118:
        r152 = r13;
        goto L119
    L114:
        r150 = r13;
        goto L115
    L109:
        r149 = null;
        goto L110
    L105:
        r31 = r147;
        r148 = r31;
        goto L107
    L101:
        r146 = r13;
        goto L102
    L97:
        r144 = r13;
        goto L98
    L93:
        r143 = r13;
        goto L94
    L89:
        r142 = r13;
        goto L90
    L85:
        r141 = r13;
        goto L86
    L81:
        r139 = r13;
        goto L82
    L77:
        r137 = r13;
        goto L78
    L73:
        r135 = r13;
        goto L74
    L69:
        r133 = r13;
        goto L70
    L65:
        r132 = r13;
        goto L66
    L61:
        r130 = r13;
        goto L62
    L57:
        r128 = r13;
        goto L58
    L53:
        r126 = r13;
        goto L54
    L49:
        r124 = r13;
        goto L50
    L45:
        r122 = r13;
        goto L46
    L41:
        r120 = r13;
        goto L42
    L37:
        r119 = r13;
        goto L38
    L33:
        r117 = r13;
        goto L34
    L29:
        r115 = r13;
        goto L30
    L25:
        r113 = r13;
        goto L26
    L21:
        r111 = r13;
        goto L22
    L17:
        r110 = r13;
        goto L18
    L13:
        r19 = r13;
        goto L14
    L9:
        r17 = r13;
        goto L10
    L5:
        r14 = r13;
        goto L6
    }

    public static final void c(HalfScreenCardComment r24, CharSequence r25, String r26, boolean r27) {
        r24.getClass();
        if (StringsKt.isBlank(r25) == false) goto L5;
        tt5.a.h("Comment#CardComment", "sendVoiceCommentDirectly skip: blank content");
        return;
    L5:
        com.bytedance.ee.bear.middleground.comment.export.m r1 = r24.a.M;
        if (r1 != null) goto L8;
    L10:
        boolean r2 = false;
    L11:
        if (r2 == true) goto L33;
        com.bytedance.ee.bear.middleground.comment.card.d r3 = r24.E;
        if (r3 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r3 = null;
    L17:
        if (r3.i(r26) == (-1)) goto L34;
        r24.a.N.a(new ef5.h(r26, null, 2, false, false));
        int r4 = CommentVoiceEditTextBridge.i;
        String r5 = CommentVoiceEditTextBridge.a.b(r25);
        if (r24.a.o != 0) goto L22;
        boolean r6 = true;
    L23:
        com.bytedance.ee.bear.rn.e r7 = new com.bytedance.ee.bear.rn.e(null, r5, r26, false, r6, null, null, null, null, null, r27, null, null, null, null, null, 0, null, 261097);
        StringBuilder r8 = new StringBuilder("[voiceSend] halfScreen reply shouldAuthorize=");
        r8.append(r27);
        r8.append(", ");
        CommentVoiceLog.a.getClass();
        r8.append(CommentVoiceLog.d("commentId", r26));
        r8.append(", ");
        r8.append(CommentVoiceLog.i("content", r25));
        tt5.a.h("CommentVoice", r8.toString());
        Flowable<String> r9 = com.bytedance.ee.bear.middleground.comment.uitls.o.a(r24.c.B(r7), new HalfScreenCardComment$getVipCb$1(r24));
        if (r9 == null) goto L26;
        Disposable r10 = r9.subscribe(new q0(r24), new r0(r24));
    L27:
        com.bytedance.ee.bear.middleground.comment.card.d r0 = r24.E;
        if (r0 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r0 = null;
    L30:
        r0.a(r10);
        return;
    L26:
        r10 = null;
        goto L27
    L22:
        r6 = false;
        goto L23
    L34:
        return;
    L33:
        return;
    L8:
        if (r1.b() == true) goto L10;
        r2 = true;
        goto L11
    }

    public static /* synthetic */ void s(HalfScreenCardComment r0, boolean r1, boolean r2, int r3) {
        if ((r3 & 2) == 0) goto L5;
        r2 = false;
    L5:
        r0.q(r1, r2, null);
    }

    public final AnimatorSet e(int r6, int r7, float r8, float r9) {
        AnimatorSet r0 = new AnimatorSet();
        ValueAnimator r10 = ValueAnimator.ofInt(new int[]{r6, r7});
        r10.addUpdateListener(new d(this));
        r0.playTogether(new Animator[]{r10, ObjectAnimator.ofFloat(this.v, "alpha", new float[]{r8, r9})});
        r0.setDuration(100);
        return r0;
    }

    public final void r(final boolean r3, final boolean r4, final boolean r5, final CommentInputRequest r6) {
        com.bytedance.ee.bear.middleground.comment.export.m r0 = this.a.M;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L10;
        return;
    L10:
        final Function1<CommentInputRequest, Unit> r2 = new HalfScreenCardComment$toDetail$1(this, r3, r4, r5);
        if (n() == false) goto L28;
        com.bytedance.ee.bear.middleground.comment.card.d r7 = this.E;
        com.bytedance.ee.bear.middleground.comment.card.d r8 = null;
        if (r7 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r7 = null;
    L16:
        if (r7.e == true) goto L28;
        if (r6.type == 1) goto L28;
        int r9 = com.bytedance.ee.bear.middleground.comment.uitls.n.a;
        CommentEditText r10 = this.M;
        if (r10 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("commentEditText");
        r10 = null;
    L23:
        Disposable r11 = com.bytedance.ee.bear.middleground.comment.uitls.n.a(r10, new HalfScreenCardComment$syncEtSenderToInputRequest$d$1(r6, r2));
        com.bytedance.ee.bear.middleground.comment.card.d r12 = this.E;
        if (r12 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
    L27:
        r8.a(r11);
        return;
    L26:
        r8 = r12;
    L28:
        r2.invoke(r6);
        return;
    L5:
        if (r0.b() == true) goto L7;
        r1 = true;
        goto L8
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.p1
    public final void i8(String r9, String r10, List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r11, int r12, CommentBean r13, CommentImageShowSource r14) {
        Intrinsics.checkNotNullParameter(r9, "commentId");
        Intrinsics.checkNotNullParameter(r10, "replyId");
        Intrinsics.checkNotNullParameter(r14, "showSource");
        jf5.a r5 = this.P0;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r9, "commentId");
        Intrinsics.checkNotNullParameter(r10, "replyId");
        Intrinsics.checkNotNullParameter(r14, "showSource");
        r5.c(r9, r10, r11, r12, false, r13, r14);
    }
}
