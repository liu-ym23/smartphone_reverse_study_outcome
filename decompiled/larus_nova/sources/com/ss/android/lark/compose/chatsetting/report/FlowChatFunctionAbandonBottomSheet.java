package com.ss.android.lark.compose.chatsetting.report;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.larus.nova.R;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class FlowChatFunctionAbandonBottomSheet {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f417486a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e f417487b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f417488c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f417489d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c f417490e;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f417491a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f417492b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f417491a, r101.f417491a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f417492b, r101.f417492b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f417491a.hashCode() * 31) + this.f417492b.hashCode();
        }

        public final String toString() {
            return "Data(mainTitle=" + this.f417491a + ", subTitle=" + this.f417492b + ')';
        }

        public b() {
            this("", "");
        }

        public b(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "mainTitle");
            Intrinsics.checkNotNullParameter(r101, "subTitle");
            this.f417491a = r100;
            this.f417492b = r101;
        }
    }

    public interface c {
        void onDismiss();
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f417493a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final LinearLayout f417494b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final View f417495c;

        public d(View r100) {
            Intrinsics.checkNotNullParameter(r100, "rootView");
            this.f417493a = r100;
            this.f417494b = (LinearLayout) r100.findViewById(R.id.bottom_sheet_content_container);
            this.f417495c = r100.findViewById(R.id.bottom_sheet_mask);
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f417496a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ImageView f417497b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final TextView f417498c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final TextView f417499d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final TextView f417500e;

        public e(View r100) {
            Intrinsics.checkNotNullParameter(r100, "rootView");
            this.f417496a = r100;
            this.f417497b = (ImageView) r100.findViewById(R.id.group_avatar);
            this.f417498c = (TextView) r100.findViewById(R.id.main_title);
            this.f417499d = (TextView) r100.findViewById(R.id.sub_title);
            this.f417500e = (TextView) r100.findViewById(R.id.btn_know);
        }
    }

    public static final class f implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FlowChatFunctionAbandonBottomSheet f417501a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
        }

        public f(FlowChatFunctionAbandonBottomSheet r100) {
            this.f417501a = r100;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            this.f417501a.b().f417493a.setVisibility(8);
            c r101 = this.f417501a.f417490e;
            if (r101 == null) goto L6;
            r101.onDismiss();
            return;
        }
    }

    public static final class g implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FlowChatFunctionAbandonBottomSheet f417502a;

        public g(FlowChatFunctionAbandonBottomSheet r100) {
            this.f417502a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f417502a.a();
        }
    }

    static {
    }

    public final void a() {
        AnimatorSet r100 = new AnimatorSet().setDuration(200);
        r100.addListener(new f(this));
        r100.playTogether(new Animator[]{ObjectAnimator.ofFloat(b().f417494b, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{0.0f, b().f417494b.getHeight()}).setDuration(200), ObjectAnimator.ofFloat(b().f417495c, "alpha", new float[]{1.0f, 0.0f}).setDuration(200)});
        r100.start();
    }

    public final d b() {
        return (d) this.f417489d.getValue();
    }

    public final void c() {
        e r100 = this.f417487b;
        if (r100 != null) goto L5;
        return;
    L5:
        b r101 = this.f417488c;
        if (r101 != null) goto L8;
        return;
    L8:
        Context r102 = r100.f417497b.getContext();
        ImageView r103 = r100.f417497b;
        Intrinsics.checkNotNull(r102);
        r103.setImageDrawable(new FlowChatFunctionAbandonWarningDrawable(r102));
        r100.f417498c.setText(r101.f417491a);
        r100.f417498c.setVisibility(0);
        if (r101.f417492b.length() <= 0) goto L11;
        boolean r104 = true;
    L12:
        if (r104 == false) goto L14;
        r100.f417499d.setText(r101.f417492b);
        r100.f417499d.setVisibility(0);
    L15:
        r100.f417500e.setOnClickListener(new g(this));
        return;
    L14:
        r100.f417499d.setVisibility(8);
        goto L15
    L11:
        r104 = false;
        goto L12
    }

    public final Activity getActivity() {
        return this.f417486a;
    }

    public FlowChatFunctionAbandonBottomSheet(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        this.f417486a = r100;
        this.f417489d = LazyKt.lazy(new FlowChatFunctionAbandonBottomSheet$rootViewHolder$2(this));
    }
}
