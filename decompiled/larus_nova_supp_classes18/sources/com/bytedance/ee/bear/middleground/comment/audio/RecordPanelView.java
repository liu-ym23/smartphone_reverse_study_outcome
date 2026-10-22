package com.bytedance.ee.bear.middleground.comment.audio;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.facade.common.widget.BearLottieView;
import com.bytedance.ee.bear.middleground.comment.widget.CommentEditText;
import com.bytedance.ee.util.ui.n;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u001b\u0018\u0000 G2\u00020\u0001:\u0002GHB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020,J\b\u00100\u001a\u00020.H\u0002J\u0006\u00101\u001a\u00020.J\b\u00102\u001a\u00020.H\u0002J\b\u00103\u001a\u00020.H\u0002J\u0010\u00104\u001a\u00020.2\b\b\u0002\u00105\u001a\u00020\u0019J\u000e\u00106\u001a\u00020.2\u0006\u00107\u001a\u00020\u0017J\u000e\u00108\u001a\u00020.2\u0006\u00109\u001a\u00020\u0019J\u0010\u0010:\u001a\u00020.2\u0006\u00109\u001a\u00020\u0019H\u0002J\b\u0010;\u001a\u00020.H\u0002J\u0010\u0010<\u001a\u00020.2\u0006\u0010=\u001a\u00020\u0019H\u0002J\u0018\u0010>\u001a\u00020.2\u0006\u0010?\u001a\u00020\u00192\u0006\u0010=\u001a\u00020\u0019H\u0002J\u0010\u0010@\u001a\u00020.2\u0006\u0010?\u001a\u00020\u0019H\u0002J\u0006\u0010A\u001a\u00020.J\u0006\u0010B\u001a\u00020.J\b\u0010C\u001a\u00020.H\u0002J\u0006\u0010D\u001a\u00020\u0019J\u0010\u0010E\u001a\u00020.2\u0006\u0010F\u001a\u00020\u0007H\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R(\u0010&\u001a\u0004\u0018\u00010%2\b\u0010$\u001a\u0004\u0018\u00010%@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006I"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/audio/RecordPanelView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "clear", "Landroid/widget/TextView;", "send", "play", "Landroid/widget/ImageView;", "pause", "motionPlay", "Lcom/bytedance/ee/bear/middleground/comment/audio/MotionFrameLayout;", "languageTv", "tipOperation", "waveLottie", "Lcom/bytedance/ee/bear/facade/common/widget/BearLottieView;", "atEditText", "Lcom/bytedance/ee/bear/middleground/comment/widget/CommentEditText;", "firstStartFlag", "", "getFirstStartFlag", "()Z", "setFirstStartFlag", "(Z)V", "commentAnalytic", "Lcom/bytedance/ee/bear/middleground/comment/uitls/CommentAnalytic;", "getCommentAnalytic", "()Lcom/bytedance/ee/bear/middleground/comment/uitls/CommentAnalytic;", "setCommentAnalytic", "(Lcom/bytedance/ee/bear/middleground/comment/uitls/CommentAnalytic;)V", "value", "Lcom/bytedance/ee/bear/middleground/comment/audio/RecordViewModel;", "viewModel", "getViewModel", "()Lcom/bytedance/ee/bear/middleground/comment/audio/RecordViewModel;", "setViewModel", "(Lcom/bytedance/ee/bear/middleground/comment/audio/RecordViewModel;)V", "operationCallback", "Lcom/bytedance/ee/bear/middleground/comment/audio/RecordPanelView$RecordPanelOperationCallback;", "setRecordPanelOperationCallback", "", "callback", "initViews", "setLanguageView", "setListener", "startRecord", "pauseRecord", "shouldReport", "injectEditText", "editText", "toggleEditStatus", "shown", "setClearSendButtonStatus", "showLanguageActionSheet", "setRecordUIStatus", "playAnim", "setControlButtonStatus", "recording", "setControlButtonVisible", "reset", "disConnect", "setTipOperationVisibility", "isShowing", "setVisibility", "visibility", "Companion", "RecordPanelOperationCallback", "middleground-comment_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RecordPanelView extends FrameLayout {
    public static final /* synthetic */ int n = 0;
    public TextView a;
    public TextView b;
    public ImageView c;
    public ImageView d;
    public MotionFrameLayout e;
    public TextView f;
    public TextView g;
    public BearLottieView h;
    public CommentEditText i;
    public boolean j;
    public com.bytedance.ee.bear.middleground.comment.uitls.h k;
    public RecordViewModel l;
    public b m;

    public static final class a {
    }

    public interface b {
        void a();

        void b(boolean r1);
    }

    public static final class c extends AnimatorListenerAdapter {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ RecordPanelView b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r4) {
            Intrinsics.checkNotNullParameter(r4, "animation");
            super.onAnimationEnd(r4);
            TextView r2 = null;
            if (this.a == true) goto L12;
            TextView r5 = this.b.a;
            if (r5 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("clear");
            r5 = null;
        L7:
            r5.setVisibility(8);
            TextView r6 = this.b.b;
            if (r6 != null) goto L10;
            Intrinsics.throwUninitializedPropertyAccessException("send");
        L11:
            r2.setVisibility(8);
            return;
        L10:
            r2 = r6;
            goto L11
        L12:
            TextView r7 = this.b.a;
            if (r7 != null) goto L15;
            Intrinsics.throwUninitializedPropertyAccessException("clear");
            r7 = null;
        L15:
            r7.setVisibility(0);
            TextView r8 = this.b.b;
            if (r8 != null) goto L18;
            Intrinsics.throwUninitializedPropertyAccessException("send");
        L19:
            r2.setVisibility(0);
            return;
        L18:
            r2 = r8;
            goto L19
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r4) {
            Intrinsics.checkNotNullParameter(r4, "animation");
            super.onAnimationStart(r4);
            TextView r2 = null;
            if (this.a == false) goto L12;
            TextView r5 = this.b.a;
            if (r5 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("clear");
            r5 = null;
        L7:
            r5.setVisibility(0);
            TextView r6 = this.b.b;
            if (r6 != null) goto L10;
            Intrinsics.throwUninitializedPropertyAccessException("send");
        L11:
            r2.setVisibility(0);
            return;
        L10:
            r2 = r6;
            goto L11
        L12:
            TextView r7 = this.b.a;
            if (r7 != null) goto L15;
            Intrinsics.throwUninitializedPropertyAccessException("clear");
            r7 = null;
        L15:
            r7.setVisibility(8);
            TextView r8 = this.b.b;
            if (r8 != null) goto L18;
            Intrinsics.throwUninitializedPropertyAccessException("send");
        L19:
            r2.setVisibility(8);
            return;
        L18:
            r2 = r8;
            goto L19
        }

        public c(boolean r1, RecordPanelView r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
    }

    public RecordPanelView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public RecordPanelView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void e() {
        TextView r0 = this.a;
        TextView r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("clear");
        r0 = null;
    L5:
        ConstraintLayout.LayoutParams r1 = r0.getLayoutParams();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r3 = r1;
        TextView r4 = this.b;
        if (r4 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("send");
        r4 = null;
    L8:
        ConstraintLayout.LayoutParams r5 = r4.getLayoutParams();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r6 = r5;
        r3.topToTop = 2131380337;
        r3.startToStart = 2131380337;
        r3.endToEnd = 2131380337;
        r6.topToTop = 2131380337;
        r6.startToStart = 2131380337;
        r6.endToEnd = 2131380337;
        TextView r7 = this.a;
        if (r7 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("clear");
        r7 = null;
    L11:
        r7.setVisibility(8);
        TextView r8 = this.b;
        if (r8 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("send");
    L15:
        r2.setVisibility(8);
        d(false);
        g();
        f();
        this.j = true;
        return;
    L14:
        r2 = r8;
        goto L15
    }

    public final void f() {
        TextView r0 = this.f;
        TextView r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("languageTv");
        r0 = null;
    L5:
        RecordViewModel r3 = this.l;
        int r4 = 0;
        if (r3 == null) goto L10;
        boolean r5 = true;
        if (r3.d != true) goto L10;
    L11:
        if (r5 == false) goto L13;
        r4 = 8;
    L13:
        r0.setVisibility(r4);
        RecordViewModel r1 = this.l;
        if (r1 == null) goto L18;
        MutableLiveData<String> r6 = r1.g;
        if (r6 == null) goto L18;
        String r7 = (String) r6.getValue();
    L19:
        if (r7 == null) goto L42;
        int r8 = r7.hashCode();
        if (r8 == 96647668) goto L34;
        if (r8 == 115862294) goto L26;
        return;
    L26:
        if (r7.equals("zh_ch") == false) goto L45;
        TextView r9 = this.f;
        if (r9 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("languageTv");
    L32:
        r2.setText(getContext().getString(2131887607));
        return;
    L31:
        r2 = r9;
        goto L32
    L45:
        return;
    L34:
        if (r7.equals("en_us") == false) goto L46;
        TextView r10 = this.f;
        if (r10 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("languageTv");
    L40:
        r2.setText(getContext().getString(2131887618));
        return;
    L39:
        r2 = r10;
        goto L40
    L46:
        return;
    L42:
        return;
    L18:
        r7 = null;
    L10:
        r5 = false;
        goto L11
    }

    public final void g() {
        CommentEditText r0 = this.i;
        TextView r1 = null;
        if (r0 == null) goto L7;
        Editable r2 = r0.getText();
        if (r2 == null) goto L7;
        String r3 = r2.toString();
    L9:
        if (TextUtils.isEmpty(r3) == false) goto L15;
        TextView r4 = this.g;
        if (r4 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("tipOperation");
    L14:
        r1.setVisibility(0);
        return;
    L13:
        r1 = r4;
        goto L14
    L15:
        TextView r5 = this.g;
        if (r5 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("tipOperation");
    L19:
        r1.setVisibility(8);
        return;
    L18:
        r1 = r5;
    L7:
        r3 = null;
        goto L9
    }

    public final boolean c() {
        if (getVisibility() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final com.bytedance.ee.bear.middleground.comment.uitls.h getCommentAnalytic() {
        return this.k;
    }

    public final boolean getFirstStartFlag() {
        return this.j;
    }

    public final RecordViewModel getViewModel() {
        return this.l;
    }

    private final void setClearSendButtonStatus(boolean r22) {
        if (r22 == false) goto L10;
        TextView r4 = this.a;
        if (r4 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("clear");
        r4 = null;
    L8:
        if (r4.getVisibility() != 0) goto L10;
        return;
    L10:
        if (r22 == true) goto L17;
        TextView r5 = this.a;
        if (r5 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("clear");
        r5 = null;
    L15:
        if (r5.getVisibility() != 8) goto L17;
        return;
    L17:
        AnimatorSet r6 = new AnimatorSet();
        float r7 = 1.0f;
        float r8 = 0.0f;
        if (r22 == false) goto L20;
        float r9 = 0.0f;
    L21:
        if (r22 == true) goto L25;
        r7 = 0.0f;
    L25:
        if (r22 == false) goto L27;
        float r10 = 0.0f;
    L28:
        if (r22 == false) goto L30;
        float r11 = n.d(122);
    L31:
        if (r22 == false) goto L33;
        float r12 = 0.0f;
    L34:
        if (r22 == false) goto L36;
        r8 = -n.d(122);
    L36:
        TextView r13 = this.b;
        if (r13 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("send");
        r13 = null;
    L39:
        ObjectAnimator r14 = ObjectAnimator.ofFloat(r13, "alpha", new float[]{r9, r7});
        TextView r15 = this.a;
        if (r15 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("clear");
        r15 = null;
    L42:
        ObjectAnimator r3 = ObjectAnimator.ofFloat(r15, "alpha", new float[]{r9, r7});
        TextView r16 = this.b;
        if (r16 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("send");
        r16 = null;
    L45:
        ObjectAnimator r17 = ObjectAnimator.ofFloat(r16, "scaleX", new float[]{r9, r7});
        TextView r18 = this.b;
        if (r18 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("send");
        int r1 = 2;
        r18 = null;
    L49:
        float[] r19 = new float[r1];
        r19[0] = r9;
        r19[1] = r7;
        ObjectAnimator r20 = ObjectAnimator.ofFloat(r18, "scaleY", r19);
        TextView r110 = this.a;
        if (r110 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("clear");
        int r21 = 2;
        r110 = null;
    L53:
        float[] r23 = new float[r21];
        r23[0] = r9;
        r23[1] = r7;
        ObjectAnimator r24 = ObjectAnimator.ofFloat(r110, "scaleX", r23);
        TextView r111 = this.a;
        if (r111 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("clear");
        r111 = null;
    L56:
        float[] r112 = new float[r21];
        r112[0] = r9;
        r112[1] = r7;
        ObjectAnimator r2 = ObjectAnimator.ofFloat(r111, "scaleY", r112);
        TextView r25 = this.b;
        if (r25 != null) goto L59;
        Intrinsics.throwUninitializedPropertyAccessException("send");
        r25 = null;
    L59:
        float[] r26 = new float[r21];
        r26[0] = r10;
        r26[1] = r11;
        ObjectAnimator r27 = ObjectAnimator.ofFloat(r25, "translationX", r26);
        TextView r28 = this.a;
        if (r28 != null) goto L62;
        Intrinsics.throwUninitializedPropertyAccessException("clear");
        r28 = null;
    L62:
        float[] r29 = new float[r21];
        r29[0] = r12;
        r29[1] = r8;
        ObjectAnimator r30 = ObjectAnimator.ofFloat(r28, "translationX", r29);
        r6.setDuration(200);
        Animator[] r31 = new Animator[8];
        r31[0] = r14;
        r31[1] = r3;
        r31[r21] = r17;
        r31[3] = r20;
        r31[4] = r24;
        r31[5] = r2;
        r31[6] = r30;
        r31[7] = r27;
        r6.playTogether(r31);
        r6.setInterpolator(new AccelerateInterpolator());
        r6.addListener(new c(r22, this));
        r6.start();
        return;
    L52:
        r21 = 2;
        goto L53
    L48:
        r1 = 2;
        goto L49
    L33:
        r12 = n.d(122);
        goto L34
    L30:
        r11 = 0.0f;
        goto L31
    L27:
        r10 = -n.d(122);
        goto L28
    L20:
        r9 = 1.0f;
        goto L21
    }

    private final void setControlButtonVisible(boolean r6) {
        ImageView r0 = this.c;
        ImageView r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("play");
        r0 = null;
    L5:
        int r2 = 8;
        if (r6 == false) goto L8;
        int r4 = 8;
    L9:
        r0.setVisibility(r4);
        ImageView r3 = this.d;
        if (r3 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("pause");
    L13:
        if (r6 == false) goto L15;
        r2 = 0;
    L15:
        r1.setVisibility(r2);
        return;
    L12:
        r1 = r3;
        goto L13
    L8:
        r4 = 0;
        goto L9
    }

    private final void setRecordUIStatus(boolean r11) {
        RecordViewModel r0 = this.l;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        BearLottieView r3 = null;
        if (r11 == false) goto L24;
        float r12 = 1.0f;
        if (r1 == false) goto L13;
        float r5 = 0.0f;
    L14:
        if (r1 == true) goto L17;
        r12 = 0.0f;
    L17:
        ImageView r4 = this.d;
        if (r4 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("pause");
        r4 = null;
    L20:
        ObjectAnimator r6 = ObjectAnimator.ofFloat(r4, "alpha", new float[]{r5, r12});
        ImageView r7 = this.c;
        if (r7 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("play");
        r7 = null;
    L23:
        ObjectAnimator r13 = ObjectAnimator.ofFloat(r7, "alpha", new float[]{r12, r5});
        AnimatorSet r8 = new AnimatorSet();
        r8.playTogether(new Animator[]{r6, r13});
        r8.setDuration(200);
        r8.addListener(new e(r1, this));
        r8.start();
    L26:
        if (r1 == false) goto L41;
        TextView r2 = this.f;
        if (r2 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("languageTv");
        r2 = null;
    L30:
        r2.setVisibility(8);
        TextView r14 = this.g;
        if (r14 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("tipOperation");
        r14 = null;
    L33:
        r14.setVisibility(8);
        ImageView r15 = this.h;
        if (r15 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("waveLottie");
        r15 = null;
    L36:
        r15.setVisibility(0);
        BearLottieView r16 = this.h;
        if (r16 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("waveLottie");
    L40:
        r3.playAnimation();
        return;
    L39:
        r3 = r16;
        goto L40
    L41:
        TextView r9 = this.f;
        if (r9 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("languageTv");
        r9 = null;
    L44:
        r9.setVisibility(0);
        ImageView r17 = this.h;
        if (r17 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("waveLottie");
        r17 = null;
    L47:
        r17.setVisibility(8);
        BearLottieView r18 = this.h;
        if (r18 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("waveLottie");
    L51:
        r3.cancelAnimation();
        g();
        return;
    L50:
        r3 = r18;
        goto L51
    L13:
        r5 = 1.0f;
        goto L14
    L24:
        setControlButtonVisible(r1);
        goto L26
    L5:
        if (r0.d != true) goto L7;
        r1 = true;
        goto L8
    }

    public final void d(boolean r5) {
        RecordViewModel r0 = this.l;
        boolean r1 = true;
        if (r0 != null) goto L5;
    L7:
        boolean r3 = false;
    L8:
        if (r3 == true) goto L10;
        return;
    L10:
        if (r0 == null) goto L12;
        r0.i();
    L12:
        CommentEditText r2 = this.i;
        if (r2 == null) goto L15;
        r2.L();
    L15:
        CommentEditText r4 = this.i;
        if (r4 == null) goto L25;
        Editable r6 = r4.getText();
        if (r6 == null) goto L25;
        if (r6.length() <= 0) goto L22;
        boolean r7 = true;
    L23:
        if (r7 != true) goto L25;
    L26:
        h(r1);
        b r8 = this.m;
        if (r8 == null) goto L29;
        r8.b(false);
    L29:
        if (r5 == false) goto L34;
        com.bytedance.ee.bear.middleground.comment.uitls.h r9 = this.k;
        if (r9 == null) goto L35;
        r9.m("pause");
        return;
    L35:
        return;
    L34:
        return;
    L22:
        r7 = false;
    L25:
        r1 = false;
        goto L26
    L5:
        if (r0.d != true) goto L7;
        r3 = true;
        goto L8
    }

    public final void h(boolean r4) {
        boolean r0 = true;
        setRecordUIStatus(true);
        StringBuilder r1 = new StringBuilder("toggleEditStatus shown: ");
        r1.append(r4);
        r1.append(", button visible: ");
        TextView r2 = this.a;
        if (r2 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("clear");
        r2 = null;
    L6:
        if (r2.getVisibility() == 0) goto L9;
        r0 = false;
    L9:
        r1.append(r0);
        tt5.a.h("Comment#RecordPanelView", r1.toString());
        setClearSendButtonStatus(r4);
    }

    public final void setCommentAnalytic(com.bytedance.ee.bear.middleground.comment.uitls.h r1) {
        this.k = r1;
    }

    public final void setFirstStartFlag(boolean r1) {
        this.j = r1;
    }

    public final void setRecordPanelOperationCallback(b r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.m = r2;
    }

    public final void setViewModel(RecordViewModel r1) {
        this.l = r1;
        setRecordUIStatus(false);
    }

    @Override // android.view.View
    public void setVisibility(int r3) {
        super.setVisibility(r3);
        if (r3 != 0) goto L16;
        CommentEditText r4 = this.i;
        boolean r0 = false;
        if (r4 == null) goto L14;
        Editable r5 = r4.getText();
        if (r5 == null) goto L14;
        if (r5.length() <= 0) goto L11;
        boolean r6 = true;
    L12:
        if (r6 != true) goto L14;
        r0 = true;
        goto L14
    L11:
        r6 = false;
    L14:
        h(r0);
        return;
    }

    public static final /* synthetic */ void a(RecordPanelView r0, boolean r1) {
        r0.setClearSendButtonStatus(r1);
    }

    public static final /* synthetic */ void b(RecordPanelView r0, boolean r1) {
        r0.setControlButtonVisible(r1);
    }

    public RecordPanelView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.j = true;
        View r5 = LayoutInflater.from(r2).inflate(2131559868, this);
        com.bytedance.ee.bear.appsetting.c r6 = com.bytedance.ee.bear.appsetting.c.a.a;
        if (r6.g("ccm.mention.optimizing_authorizaiton_v2") == true) goto L5;
    L6:
        r5.findViewById(2131367862).setBackground(new ColorDrawable(n.h(r2, 2131100548)));
    L7:
        this.a = (TextView) findViewById(2131366927);
        this.b = (TextView) findViewById(2131385893);
        this.c = (ImageView) findViewById(2131382414);
        this.d = (ImageView) findViewById(2131381971);
        this.e = (MotionFrameLayout) findViewById(2131380337);
        this.h = findViewById(2131379223);
        this.f = (TextView) findViewById(2131390846);
        this.g = (TextView) findViewById(2131391598);
        TextView r7 = this.a;
        MotionFrameLayout r8 = null;
        if (r7 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("clear");
        r7 = null;
    L10:
        r7.setOnClickListener(new f(this));
        TextView r9 = this.b;
        if (r9 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("send");
        r9 = null;
    L13:
        r9.setOnClickListener(new g(this));
        TextView r10 = this.f;
        if (r10 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("languageTv");
        r10 = null;
    L16:
        r10.setOnClickListener(new h(this));
        MotionFrameLayout r11 = this.e;
        if (r11 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("motionPlay");
    L20:
        r8.setMotionCallbackListener(new RecordPanelView$setListener$4(this));
        return;
    L19:
        r8 = r11;
        goto L20
    L5:
        if (r6.g("ccm.mention.optimizing_authorizaiton") == true) goto L7;
        goto L6
    }

    public /* synthetic */ RecordPanelView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
