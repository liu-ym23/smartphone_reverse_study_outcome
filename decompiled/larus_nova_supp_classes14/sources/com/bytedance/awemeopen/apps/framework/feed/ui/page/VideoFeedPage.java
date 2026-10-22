package com.bytedance.awemeopen.apps.framework.feed.ui.page;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.awemeopen.apps.framework.comment.AosCommentListContainer;
import com.bytedance.awemeopen.apps.framework.comment.CommentListView;
import com.bytedance.awemeopen.apps.framework.comment.view.commentimage.AosCommentImageContainer;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.b;
import com.bytedance.awemeopen.apps.framework.feed.slide.framework.group.BaseGroup;
import com.bytedance.awemeopen.apps.framework.feed.ui.information.InformationGroup;
import com.bytedance.awemeopen.apps.framework.feed.ui.rightbar.RightBarGroup;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.o;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import l14.c;
import xz3.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class VideoFeedPage extends uz3.a<Object, jz3.a> {
    public final Activity f;
    public final o g;
    public final c h;
    public final wz3.c i;
    public final InformationGroup j;
    public final d k;
    public final RightBarGroup l;

    public static final class a implements Animator.AnimatorListener {
        public final /* synthetic */ ArrayList<View> a;
        public final /* synthetic */ ArrayList<View> b;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r1) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r1) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r4) {
            Iterator<T> r5 = this.b.iterator();
        L4:
            if (r5.hasNext() == false) goto L6;
            View r0 = (View) r5.next();
            r0.setVisibility(0);
            r0.setAlpha(1.0f);
            goto L4
        L6:
            Iterator<T> r6 = this.a.iterator();
        L8:
            if (r6.hasNext() == false) goto L10;
            View r1 = (View) r6.next();
            r1.setVisibility(8);
            r1.setAlpha(1.0f);
            goto L8
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r3) {
            Iterator<T> r4 = this.a.iterator();
        L4:
            if (r4.hasNext() == false) goto L6;
            ((View) r4.next()).setAlpha(1.0f);
            goto L4
        L6:
            Iterator<T> r5 = this.b.iterator();
        L8:
            if (r5.hasNext() == false) goto L10;
            ((View) r5.next()).setAlpha(0.0f);
            goto L8
        }

        public a(ArrayList<View> r1, ArrayList<View> r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    @Override // uz3.a
    public final ArrayList<BaseGroup<?, ?, ?, jz3.a>> e() {
        return CollectionsKt.arrayListOf(new BaseGroup[]{this.j, this.l, this.i, this.k});
    }

    @Override // uz3.a
    public final void h() {
    }

    @Override // uz3.a
    public final void g() {
        com.bytedance.awemeopen.apps.framework.feed.ui.information.c r0 = this.j.d();
        Function0<Integer> r1 = new VideoFeedPage$onCreate$1(this);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        r0.a = r1;
        com.bytedance.awemeopen.apps.framework.feed.ui.information.c r2 = this.j.d();
        Function0<Integer> r3 = new VideoFeedPage$onCreate$2(this);
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r2.b = r3;
    }

    public final boolean j() {
        AosCommentListContainer r0 = this.l.o.k;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L10:
        boolean r3 = false;
    L11:
        if (r3 == false) goto L29;
        Intrinsics.checkNotNull(r0);
        CommentListView r4 = r0.g;
        if (r4 == null) goto L20;
        AosCommentImageContainer r5 = r4.F;
        if (r5 == null) goto L17;
        boolean r6 = r5.d();
    L18:
        if (r6 != true) goto L20;
        r1 = true;
        goto L20
    L17:
        r6 = false;
    L20:
        if (r1 == false) goto L26;
        CommentListView r2 = r0.g;
        if (r2 == null) goto L27;
        Intrinsics.checkNotNullParameter("slide", "exitMethod");
        AosCommentImageContainer r7 = r2.F;
        if (r7 == null) goto L27;
        r7.b("slide");
    L27:
        return true;
    L26:
        r0.j.a();
        goto L27
    L29:
        return false;
    L5:
        if (r0.j.e != 1) goto L7;
        boolean r8 = true;
    L8:
        if (r8 != true) goto L10;
        r3 = true;
        goto L11
    L7:
        r8 = false;
        goto L8
    }

    public final void l() {
        this.j.e().setVisibility(0);
        this.i.e().setVisibility(0);
        this.k.e().setVisibility(8);
        this.j.e().setAlpha(1.0f);
        this.i.e().setAlpha(1.0f);
        this.k.e().setAlpha(1.0f);
    }

    public final Activity getActivity() {
        return this.f;
    }

    @Override // uz3.a
    public final void f(jz3.a r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
    }

    public static void k(final ArrayList r3, final ArrayList r4) {
        ValueAnimator r0 = ValueAnimator.ofInt(new int[]{0, 800});
        r0.setDuration(800);
        r0.addListener(new a(r4, r3));
        r0.addUpdateListener(new com.bytedance.awemeopen.apps.framework.feed.ui.page.a(r4, r3));
        r0.start();
    }

    public /* synthetic */ VideoFeedPage(Activity r9, b r10, o r11, vz3.c r12, ViewGroup r13) {
        this(r9, r10, r11, null, r12, r13, AnonymousClass1.INSTANCE);
    }

    public VideoFeedPage(Activity r7, b r8, o r9, c r10, vz3.c r11, ViewGroup r12, Function1 r13) {
        Intrinsics.checkNotNullParameter(r7, "activity");
        Intrinsics.checkNotNullParameter(r8, "pageOwner");
        Intrinsics.checkNotNullParameter(r9, "vm");
        Intrinsics.checkNotNullParameter(r11, "config");
        Intrinsics.checkNotNullParameter(r12, "rootView");
        Intrinsics.checkNotNullParameter(r13, "onDescExpand");
        super(r7, r12, r11);
        this.f = r7;
        this.g = r9;
        this.h = r10;
        this.i = new wz3.c(r7, r9, r8);
        this.j = new InformationGroup(r7, r8, r9, r10, r13);
        this.k = new d(r7, r9, this);
        this.l = new RightBarGroup(r7, r8, r9, r10);
    }
}
