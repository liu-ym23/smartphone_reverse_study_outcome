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
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.MutableLiveData;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.bytedance.ee.bear.facade.common.widget.BearLottieView;
import com.bytedance.ee.bear.middleground.comment.widget.CommentEditText;
import com.bytedance.ee.util.ui.n;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u001b\u0018\u0000 G2\u00020\u0001:\u0002GHB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020,J\b\u00100\u001a\u00020.H\u0002J\u0006\u00101\u001a\u00020.J\b\u00102\u001a\u00020.H\u0002J\b\u00103\u001a\u00020.H\u0002J\u0010\u00104\u001a\u00020.2\b\b\u0002\u00105\u001a\u00020\u0019J\u000e\u00106\u001a\u00020.2\u0006\u00107\u001a\u00020\u0017J\u000e\u00108\u001a\u00020.2\u0006\u00109\u001a\u00020\u0019J\u0010\u0010:\u001a\u00020.2\u0006\u00109\u001a\u00020\u0019H\u0002J\b\u0010;\u001a\u00020.H\u0002J\u0010\u0010<\u001a\u00020.2\u0006\u0010=\u001a\u00020\u0019H\u0002J\u0018\u0010>\u001a\u00020.2\u0006\u0010?\u001a\u00020\u00192\u0006\u0010=\u001a\u00020\u0019H\u0002J\u0010\u0010@\u001a\u00020.2\u0006\u0010?\u001a\u00020\u0019H\u0002J\u0006\u0010A\u001a\u00020.J\u0006\u0010B\u001a\u00020.J\b\u0010C\u001a\u00020.H\u0002J\u0006\u0010D\u001a\u00020\u0019J\u0010\u0010E\u001a\u00020.2\u0006\u0010F\u001a\u00020\u0007H\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R(\u0010&\u001a\u0004\u0018\u00010%2\b\u0010$\u001a\u0004\u0018\u00010%@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006I"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/audio/RecordPanelView;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "clear", "Landroid/widget/TextView;", "send", "play", "Landroid/widget/ImageView;", "pause", "motionPlay", "Lcom/bytedance/ee/bear/middleground/comment/audio/MotionFrameLayout;", "languageTv", "tipOperation", "waveLottie", "Lcom/bytedance/ee/bear/facade/common/widget/BearLottieView;", "atEditText", "Lcom/bytedance/ee/bear/middleground/comment/widget/CommentEditText;", "firstStartFlag", "", "getFirstStartFlag", "()Z", "setFirstStartFlag", "(Z)V", "commentAnalytic", "Lcom/bytedance/ee/bear/middleground/comment/uitls/CommentAnalytic;", "getCommentAnalytic", "()Lcom/bytedance/ee/bear/middleground/comment/uitls/CommentAnalytic;", "setCommentAnalytic", "(Lcom/bytedance/ee/bear/middleground/comment/uitls/CommentAnalytic;)V", "value", "Lcom/bytedance/ee/bear/middleground/comment/audio/RecordViewModel;", "viewModel", "getViewModel", "()Lcom/bytedance/ee/bear/middleground/comment/audio/RecordViewModel;", "setViewModel", "(Lcom/bytedance/ee/bear/middleground/comment/audio/RecordViewModel;)V", "operationCallback", "Lcom/bytedance/ee/bear/middleground/comment/audio/RecordPanelView$RecordPanelOperationCallback;", "setRecordPanelOperationCallback", "", "callback", "initViews", "setLanguageView", "setListener", "startRecord", "pauseRecord", "shouldReport", "injectEditText", "editText", "toggleEditStatus", "shown", "setClearSendButtonStatus", "showLanguageActionSheet", "setRecordUIStatus", "playAnim", "setControlButtonStatus", "recording", "setControlButtonVisible", BasicTestActionHandler.TEST_ACTION_RESET, "disConnect", "setTipOperationVisibility", "isShowing", "setVisibility", RemoteMessageConst.Notification.VISIBILITY, "Companion", "RecordPanelOperationCallback", "middleground-comment_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RecordPanelView extends FrameLayout {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f230299n = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f230300a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f230301b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ImageView f230302c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ImageView f230303d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public MotionFrameLayout f230304e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f230305f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f230306g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public BearLottieView f230307h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public CommentEditText f230308i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f230309j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public com.bytedance.ee.bear.middleground.comment.uitls.h f230310k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public RecordViewModel f230311l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public b f230312m;

    public static final class a {
    }

    public interface b {
        void a();

        void b(boolean r100);
    }

    public static final class c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f230313a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ RecordPanelView f230314b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            super.onAnimationEnd(r100);
            TextView r101 = null;
            if (this.f230313a == true) goto L12;
            TextView r102 = this.f230314b.f230300a;
            if (r102 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("clear");
            r102 = null;
        L7:
            r102.setVisibility(8);
            TextView r103 = this.f230314b.f230301b;
            if (r103 != null) goto L10;
            Intrinsics.throwUninitializedPropertyAccessException("send");
        L11:
            r101.setVisibility(8);
            return;
        L10:
            r101 = r103;
            goto L11
        L12:
            TextView r104 = this.f230314b.f230300a;
            if (r104 != null) goto L15;
            Intrinsics.throwUninitializedPropertyAccessException("clear");
            r104 = null;
        L15:
            r104.setVisibility(0);
            TextView r105 = this.f230314b.f230301b;
            if (r105 != null) goto L18;
            Intrinsics.throwUninitializedPropertyAccessException("send");
        L19:
            r101.setVisibility(0);
            return;
        L18:
            r101 = r105;
            goto L19
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            super.onAnimationStart(r100);
            TextView r101 = null;
            if (this.f230313a == false) goto L12;
            TextView r102 = this.f230314b.f230300a;
            if (r102 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("clear");
            r102 = null;
        L7:
            r102.setVisibility(0);
            TextView r103 = this.f230314b.f230301b;
            if (r103 != null) goto L10;
            Intrinsics.throwUninitializedPropertyAccessException("send");
        L11:
            r101.setVisibility(0);
            return;
        L10:
            r101 = r103;
            goto L11
        L12:
            TextView r104 = this.f230314b.f230300a;
            if (r104 != null) goto L15;
            Intrinsics.throwUninitializedPropertyAccessException("clear");
            r104 = null;
        L15:
            r104.setVisibility(8);
            TextView r105 = this.f230314b.f230301b;
            if (r105 != null) goto L18;
            Intrinsics.throwUninitializedPropertyAccessException("send");
        L19:
            r101.setVisibility(8);
            return;
        L18:
            r101 = r105;
            goto L19
        }

        public c(boolean r100, RecordPanelView r101) {
            this.f230313a = r100;
            this.f230314b = r101;
        }
    }

    static {
    }

    public RecordPanelView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public RecordPanelView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void e() {
        TextView r100 = this.f230300a;
        TextView r101 = null;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("clear");
        r100 = null;
    L5:
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r103 = (ConstraintLayout.LayoutParams) r102;
        TextView r104 = this.f230301b;
        if (r104 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("send");
        r104 = null;
    L8:
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r106 = (ConstraintLayout.LayoutParams) r105;
        r103.topToTop = R.id.motion_play;
        r103.startToStart = R.id.motion_play;
        r103.endToEnd = R.id.motion_play;
        r106.topToTop = R.id.motion_play;
        r106.startToStart = R.id.motion_play;
        r106.endToEnd = R.id.motion_play;
        TextView r107 = this.f230300a;
        if (r107 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("clear");
        r107 = null;
    L11:
        r107.setVisibility(8);
        TextView r108 = this.f230301b;
        if (r108 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("send");
    L15:
        r101.setVisibility(8);
        d(false);
        g();
        f();
        this.f230309j = true;
        return;
    L14:
        r101 = r108;
        goto L15
    }

    public final void f() {
        TextView r100 = this.f230305f;
        TextView r101 = null;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("languageTv");
        r100 = null;
    L5:
        RecordViewModel r102 = this.f230311l;
        int r103 = 0;
        if (r102 == null) goto L10;
        boolean r104 = true;
        if (r102.f230318d != true) goto L10;
    L11:
        if (r104 == false) goto L13;
        r103 = 8;
    L13:
        r100.setVisibility(r103);
        RecordViewModel r105 = this.f230311l;
        if (r105 == null) goto L18;
        MutableLiveData<String> r106 = r105.f230321g;
        if (r106 == null) goto L18;
        String r107 = r106.getValue();
    L19:
        if (r107 == null) goto L42;
        int r108 = r107.hashCode();
        if (r108 == 96647668) goto L34;
        if (r108 == 115862294) goto L26;
        return;
    L26:
        if (r107.equals("zh_ch") == false) goto L45;
        TextView r109 = this.f230305f;
        if (r109 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("languageTv");
    L32:
        r101.setText(getContext().getString(R.string.Doc_Comment_Chinese));
        return;
    L31:
        r101 = r109;
        goto L32
    L45:
        return;
    L34:
        if (r107.equals("en_us") == false) goto L46;
        TextView r110 = this.f230305f;
        if (r110 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("languageTv");
    L40:
        r101.setText(getContext().getString(R.string.Doc_Comment_English));
        return;
    L39:
        r101 = r110;
        goto L40
    L46:
        return;
    L42:
        return;
    L18:
        r107 = null;
    L10:
        r104 = false;
        goto L11
    }

    public final void g() {
        CommentEditText r100 = this.f230308i;
        TextView r101 = null;
        if (r100 == null) goto L7;
        Editable r102 = r100.getText();
        if (r102 == null) goto L7;
        String r103 = r102.toString();
    L9:
        if (TextUtils.isEmpty(r103) == false) goto L15;
        TextView r104 = this.f230306g;
        if (r104 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("tipOperation");
    L14:
        r101.setVisibility(0);
        return;
    L13:
        r101 = r104;
        goto L14
    L15:
        TextView r105 = this.f230306g;
        if (r105 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("tipOperation");
    L19:
        r101.setVisibility(8);
        return;
    L18:
        r101 = r105;
    L7:
        r103 = null;
        goto L9
    }

    public final boolean c() {
        if (getVisibility() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final com.bytedance.ee.bear.middleground.comment.uitls.h getCommentAnalytic() {
        return this.f230310k;
    }

    public final boolean getFirstStartFlag() {
        return this.f230309j;
    }

    public final RecordViewModel getViewModel() {
        return this.f230311l;
    }

    private final void setClearSendButtonStatus(boolean r210) {
        if (r210 == false) goto L10;
        TextView r100 = this.f230300a;
        if (r100 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("clear");
        r100 = null;
    L8:
        if (r100.getVisibility() != 0) goto L10;
        return;
    L10:
        if (r210 == true) goto L17;
        TextView r101 = this.f230300a;
        if (r101 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("clear");
        r101 = null;
    L15:
        if (r101.getVisibility() != 8) goto L17;
        return;
    L17:
        AnimatorSet r102 = new AnimatorSet();
        float r103 = 1.0f;
        float r104 = 0.0f;
        if (r210 == false) goto L20;
        float r105 = 0.0f;
    L21:
        if (r210 == true) goto L25;
        r103 = 0.0f;
    L25:
        if (r210 == false) goto L27;
        float r110 = 0.0f;
    L28:
        if (r210 == false) goto L30;
        float r111 = n.d(122);
    L31:
        if (r210 == false) goto L33;
        float r112 = 0.0f;
    L34:
        if (r210 == false) goto L36;
        r104 = -n.d(122);
    L36:
        TextView r106 = this.f230301b;
        if (r106 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("send");
        r106 = null;
    L39:
        ObjectAnimator r107 = ObjectAnimator.ofFloat(r106, "alpha", new float[]{r105, r103});
        TextView r113 = this.f230300a;
        if (r113 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("clear");
        r113 = null;
    L42:
        ObjectAnimator r108 = ObjectAnimator.ofFloat(r113, "alpha", new float[]{r105, r103});
        TextView r109 = this.f230301b;
        if (r109 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("send");
        r109 = null;
    L45:
        ObjectAnimator r114 = ObjectAnimator.ofFloat(r109, LiveDegradeFpsAnimator.SCALE_X, new float[]{r105, r103});
        TextView r115 = this.f230301b;
        if (r115 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("send");
        int r116 = 2;
        r115 = null;
    L49:
        float[] r117 = new float[r116];
        r117[0] = r105;
        r117[1] = r103;
        ObjectAnimator r118 = ObjectAnimator.ofFloat(r115, LiveDegradeFpsAnimator.SCALE_Y, r117);
        TextView r119 = this.f230300a;
        if (r119 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("clear");
        int r120 = 2;
        r119 = null;
    L53:
        float[] r121 = new float[r120];
        r121[0] = r105;
        r121[1] = r103;
        ObjectAnimator r122 = ObjectAnimator.ofFloat(r119, LiveDegradeFpsAnimator.SCALE_X, r121);
        TextView r123 = this.f230300a;
        if (r123 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("clear");
        r123 = null;
    L56:
        float[] r124 = new float[r120];
        r124[0] = r105;
        r124[1] = r103;
        ObjectAnimator r125 = ObjectAnimator.ofFloat(r123, LiveDegradeFpsAnimator.SCALE_Y, r124);
        TextView r126 = this.f230301b;
        if (r126 != null) goto L59;
        Intrinsics.throwUninitializedPropertyAccessException("send");
        r126 = null;
    L59:
        float[] r127 = new float[r120];
        r127[0] = r110;
        r127[1] = r111;
        ObjectAnimator r128 = ObjectAnimator.ofFloat(r126, LiveDegradeFpsAnimator.TRANSLATION_X, r127);
        TextView r129 = this.f230300a;
        if (r129 != null) goto L62;
        Intrinsics.throwUninitializedPropertyAccessException("clear");
        r129 = null;
    L62:
        float[] r130 = new float[r120];
        r130[0] = r112;
        r130[1] = r104;
        ObjectAnimator r131 = ObjectAnimator.ofFloat(r129, LiveDegradeFpsAnimator.TRANSLATION_X, r130);
        r102.setDuration(200);
        Animator[] r132 = new Animator[8];
        r132[0] = r107;
        r132[1] = r108;
        r132[r120] = r114;
        r132[3] = r118;
        r132[4] = r122;
        r132[5] = r125;
        r132[6] = r131;
        r132[7] = r128;
        r102.playTogether(r132);
        r102.setInterpolator(new AccelerateInterpolator());
        r102.addListener(new c(r210, this));
        r102.start();
        return;
    L52:
        r120 = 2;
        goto L53
    L48:
        r116 = 2;
        goto L49
    L33:
        r112 = n.d(122);
        goto L34
    L30:
        r111 = 0.0f;
        goto L31
    L27:
        r110 = -n.d(122);
        goto L28
    L20:
        r105 = 1.0f;
        goto L21
    }

    private final void setControlButtonVisible(boolean r100) {
        ImageView r101 = this.f230302c;
        ImageView r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("play");
        r101 = null;
    L5:
        int r103 = 8;
        if (r100 == false) goto L8;
        int r104 = 8;
    L9:
        r101.setVisibility(r104);
        ImageView r105 = this.f230303d;
        if (r105 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("pause");
    L13:
        if (r100 == false) goto L15;
        r103 = 0;
    L15:
        r102.setVisibility(r103);
        return;
    L12:
        r102 = r105;
        goto L13
    L8:
        r104 = 0;
        goto L9
    }

    private final void setRecordUIStatus(boolean r110) {
        RecordViewModel r100 = this.f230311l;
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        BearLottieView r102 = null;
        if (r110 == false) goto L24;
        float r111 = 1.0f;
        if (r101 == false) goto L13;
        float r103 = 0.0f;
    L14:
        if (r101 == true) goto L17;
        r111 = 0.0f;
    L17:
        ImageView r104 = this.f230303d;
        if (r104 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("pause");
        r104 = null;
    L20:
        ObjectAnimator r105 = ObjectAnimator.ofFloat(r104, "alpha", new float[]{r103, r111});
        ImageView r106 = this.f230302c;
        if (r106 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("play");
        r106 = null;
    L23:
        ObjectAnimator r112 = ObjectAnimator.ofFloat(r106, "alpha", new float[]{r111, r103});
        AnimatorSet r107 = new AnimatorSet();
        r107.playTogether(new Animator[]{r105, r112});
        r107.setDuration(200);
        r107.addListener(new e(r101, this));
        r107.start();
    L26:
        if (r101 == false) goto L41;
        TextView r108 = this.f230305f;
        if (r108 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("languageTv");
        r108 = null;
    L30:
        r108.setVisibility(8);
        TextView r113 = this.f230306g;
        if (r113 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("tipOperation");
        r113 = null;
    L33:
        r113.setVisibility(8);
        BearLottieView r114 = this.f230307h;
        if (r114 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("waveLottie");
        r114 = null;
    L36:
        r114.setVisibility(0);
        BearLottieView r115 = this.f230307h;
        if (r115 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("waveLottie");
    L40:
        r102.playAnimation();
        return;
    L39:
        r102 = r115;
        goto L40
    L41:
        TextView r109 = this.f230305f;
        if (r109 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("languageTv");
        r109 = null;
    L44:
        r109.setVisibility(0);
        BearLottieView r116 = this.f230307h;
        if (r116 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("waveLottie");
        r116 = null;
    L47:
        r116.setVisibility(8);
        BearLottieView r117 = this.f230307h;
        if (r117 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("waveLottie");
    L51:
        r102.cancelAnimation();
        g();
        return;
    L50:
        r102 = r117;
        goto L51
    L13:
        r103 = 1.0f;
        goto L14
    L24:
        setControlButtonVisible(r101);
        goto L26
    L5:
        if (r100.f230318d != true) goto L7;
        r101 = true;
        goto L8
    }

    public final void d(boolean r100) {
        RecordViewModel r101 = this.f230311l;
        boolean r102 = true;
        if (r101 != null) goto L5;
    L7:
        boolean r103 = false;
    L8:
        if (r103 == true) goto L10;
        return;
    L10:
        if (r101 == null) goto L12;
        r101.i();
    L12:
        CommentEditText r104 = this.f230308i;
        if (r104 == null) goto L15;
        r104.L();
    L15:
        CommentEditText r105 = this.f230308i;
        if (r105 == null) goto L25;
        Editable r106 = r105.getText();
        if (r106 == null) goto L25;
        if (r106.length() <= 0) goto L22;
        boolean r107 = true;
    L23:
        if (r107 != true) goto L25;
    L26:
        h(r102);
        b r108 = this.f230312m;
        if (r108 == null) goto L29;
        r108.b(false);
    L29:
        if (r100 == false) goto L34;
        com.bytedance.ee.bear.middleground.comment.uitls.h r109 = this.f230310k;
        if (r109 == null) goto L35;
        r109.m("pause");
        return;
    L35:
        return;
    L34:
        return;
    L22:
        r107 = false;
    L25:
        r102 = false;
        goto L26
    L5:
        if (r101.f230318d != true) goto L7;
        r103 = true;
        goto L8
    }

    public final void h(boolean r100) {
        boolean r101 = true;
        setRecordUIStatus(true);
        StringBuilder r102 = new StringBuilder("toggleEditStatus shown: ");
        r102.append(r100);
        r102.append(", button visible: ");
        TextView r103 = this.f230300a;
        if (r103 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("clear");
        r103 = null;
    L6:
        if (r103.getVisibility() == 0) goto L9;
        r101 = false;
    L9:
        r102.append(r101);
        tt5.a.h("Comment#RecordPanelView", r102.toString());
        setClearSendButtonStatus(r100);
    }

    public final void setCommentAnalytic(com.bytedance.ee.bear.middleground.comment.uitls.h r100) {
        this.f230310k = r100;
    }

    public final void setFirstStartFlag(boolean r100) {
        this.f230309j = r100;
    }

    public final void setRecordPanelOperationCallback(b r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f230312m = r100;
    }

    public final void setViewModel(RecordViewModel r100) {
        this.f230311l = r100;
        setRecordUIStatus(false);
    }

    @Override // android.view.View
    public void setVisibility(int r100) {
        super.setVisibility(r100);
        if (r100 != 0) goto L16;
        CommentEditText r101 = this.f230308i;
        boolean r102 = false;
        if (r101 == null) goto L14;
        Editable r103 = r101.getText();
        if (r103 == null) goto L14;
        if (r103.length() <= 0) goto L11;
        boolean r104 = true;
    L12:
        if (r104 != true) goto L14;
        r102 = true;
        goto L14
    L11:
        r104 = false;
    L14:
        h(r102);
        return;
    }

    public static final /* synthetic */ void a(RecordPanelView r100, boolean r101) {
        r100.setClearSendButtonStatus(r101);
    }

    public static final /* synthetic */ void b(RecordPanelView r100, boolean r101) {
        r100.setControlButtonVisible(r101);
    }

    public RecordPanelView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f230309j = true;
        View r103 = LayoutInflater.from(r100).inflate(R.layout.comment_record_panel, this);
        com.bytedance.ee.bear.appsetting.c r104 = com.bytedance.ee.bear.appsetting.c.a.f206237a;
        if (r104.g("ccm.mention.optimizing_authorizaiton_v2") == true) goto L5;
    L6:
        r103.findViewById(R.id.content_view).setBackground(new ColorDrawable(n.h(r100, R.color.bg_body)));
    L7:
        this.f230300a = (TextView) findViewById(R.id.clear);
        this.f230301b = (TextView) findViewById(R.id.send);
        this.f230302c = (ImageView) findViewById(R.id.play);
        this.f230303d = (ImageView) findViewById(R.id.pause);
        this.f230304e = (MotionFrameLayout) findViewById(R.id.motion_play);
        this.f230307h = (BearLottieView) findViewById(R.id.lottie_wave);
        this.f230305f = (TextView) findViewById(R.id.tv_language);
        this.f230306g = (TextView) findViewById(R.id.tv_tip_operation);
        TextView r105 = this.f230300a;
        MotionFrameLayout r106 = null;
        if (r105 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("clear");
        r105 = null;
    L10:
        r105.setOnClickListener(new f(this));
        TextView r107 = this.f230301b;
        if (r107 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("send");
        r107 = null;
    L13:
        r107.setOnClickListener(new g(this));
        TextView r108 = this.f230305f;
        if (r108 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("languageTv");
        r108 = null;
    L16:
        r108.setOnClickListener(new h(this));
        MotionFrameLayout r109 = this.f230304e;
        if (r109 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("motionPlay");
    L20:
        r106.setMotionCallbackListener(new RecordPanelView$setListener$4(this));
        return;
    L19:
        r106 = r109;
        goto L20
    L5:
        if (r104.g("ccm.mention.optimizing_authorizaiton") == true) goto L7;
        goto L6
    }

    public /* synthetic */ RecordPanelView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
