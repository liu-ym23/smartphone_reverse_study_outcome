package com.ss.android.lark.flow.feed.cell.chat.chatdismiss;

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
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.utils.UIHelper;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class FlowChatDismissBottomSheet {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f423252a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e f423253b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f423254c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f423255d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c f423256e;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f423257a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f423258b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f423259c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f423260d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f423257a, r101.f423257a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f423258b, r101.f423258b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f423259c, r101.f423259c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f423260d, r101.f423260d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.f423257a.hashCode() * 31) + this.f423258b.hashCode()) * 31) + this.f423259c.hashCode()) * 31) + this.f423260d.hashCode();
        }

        public final String toString() {
            return "Data(avatarKey=" + this.f423257a + ", entityId=" + this.f423258b + ", mainTitle=" + this.f423259c + ", subTitle=" + this.f423260d + ')';
        }

        public b() {
            this("", "", "", "");
        }

        public b(String r100, String r101, String r102, String r103) {
            Intrinsics.checkNotNullParameter(r100, "avatarKey");
            Intrinsics.checkNotNullParameter(r101, "entityId");
            Intrinsics.checkNotNullParameter(r102, "mainTitle");
            Intrinsics.checkNotNullParameter(r103, "subTitle");
            this.f423257a = r100;
            this.f423258b = r101;
            this.f423259c = r102;
            this.f423260d = r103;
        }
    }

    public interface c {
        void h4(String r100);
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f423261a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final LinearLayout f423262b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final View f423263c;

        public d(View r100) {
            Intrinsics.checkNotNullParameter(r100, "rootView");
            this.f423261a = r100;
            this.f423262b = (LinearLayout) r100.findViewById(R.id.bottom_sheet_content_container);
            this.f423263c = r100.findViewById(R.id.bottom_sheet_mask);
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f423264a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ImageView f423265b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final TextView f423266c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final TextView f423267d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final TextView f423268e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final ImageView f423269f;

        public e(View r100) {
            Intrinsics.checkNotNullParameter(r100, "rootView");
            this.f423264a = r100;
            this.f423265b = (ImageView) r100.findViewById(R.id.group_avatar);
            this.f423266c = (TextView) r100.findViewById(R.id.main_title);
            this.f423267d = (TextView) r100.findViewById(R.id.sub_title);
            this.f423268e = (TextView) r100.findViewById(R.id.btn_know);
            this.f423269f = (ImageView) r100.findViewById(R.id.icon_chat_dismiss_warning);
        }
    }

    public static final class f implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FlowChatDismissBottomSheet f423270a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f423271b;

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
            this.f423270a.b().f423261a.setVisibility(8);
            c r101 = this.f423270a.f423256e;
            if (r101 == null) goto L6;
            r101.h4(this.f423271b);
            return;
        }

        public f(FlowChatDismissBottomSheet r100, String r101) {
            this.f423270a = r100;
            this.f423271b = r101;
        }
    }

    public static final class g implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FlowChatDismissBottomSheet f423272a;

        public g(FlowChatDismissBottomSheet r100) {
            this.f423272a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f423272a.a("click_btn_know");
        }
    }

    static {
    }

    public final d b() {
        return (d) this.f423255d.getValue();
    }

    public final void c() {
        e r100 = this.f423253b;
        if (r100 != null) goto L5;
        return;
    L5:
        b r101 = this.f423254c;
        if (r101 != null) goto L8;
        return;
    L8:
        String r102 = r101.f423257a;
        String r103 = r101.f423258b;
        com.ss.android.lark.chat.utils.g.e(r100.f423264a.getContext(), r100.f423265b, r102, r103, UIHelper.dp2px(56.0f), UIHelper.dp2px(56.0f), Scene.Chat);
        r100.f423266c.setText(r101.f423259c);
        r100.f423266c.setVisibility(0);
        if (r101.f423260d.length() <= 0) goto L11;
        boolean r104 = true;
    L12:
        if (r104 == false) goto L14;
        r100.f423267d.setText(r101.f423260d);
        r100.f423267d.setVisibility(0);
    L15:
        Context r105 = r100.f423264a.getContext();
        if (r105 == null) goto L18;
        r100.f423269f.setImageDrawable(new FlowChatDismissDialogWarningDrawable(r105));
    L18:
        r100.f423268e.setOnClickListener(new g(this));
        return;
    L14:
        r100.f423267d.setVisibility(8);
        goto L15
    L11:
        r104 = false;
        goto L12
    }

    public final Activity getActivity() {
        return this.f423252a;
    }

    public FlowChatDismissBottomSheet(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        this.f423252a = r100;
        this.f423255d = LazyKt.lazy(new FlowChatDismissBottomSheet$rootViewHolder$2(this));
    }

    public final void a(String r110) {
        Intrinsics.checkNotNullParameter(r110, "source");
        AnimatorSet r100 = new AnimatorSet().setDuration(300);
        r100.addListener(new f(this, r110));
        r100.playTogether(new Animator[]{ObjectAnimator.ofFloat(b().f423262b, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{0.0f, b().f423262b.getHeight()}).setDuration(300), ObjectAnimator.ofFloat(b().f423263c, "alpha", new float[]{1.0f, 0.0f}).setDuration(300)});
        r100.start();
    }
}
