package com.larus.bmhome.view;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.larus.nova.R;
import com.obric.assistant.spi.chat.ObricChatUIDelegate;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 '2\u00020\u0001:\u0001'B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0015\u001a\u00020\u000eJ)\u0010\u0016\u001a\u00020\u00172!\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00170\u0018J\u0010\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020\u0017H\u0002J\b\u0010%\u001a\u00020\u0017H\u0002J\u000e\u0010&\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\u0010R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006("}, d2 = {"Lcom/larus/bmhome/view/FastScrollButton;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "showAnimator", "Landroid/animation/AnimatorSet;", "hideAnimator", "totalY", "", "icon", "Landroid/widget/ImageView;", "value", "", "isShow", "()Z", "setShow", "(Z)V", "iconLayoutTarget", SendEventContainerMethodParamModel.EventKinds.onClick, "", "Lkotlin/Function1;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "it", "logTouchEvent", "event", "Landroid/view/MotionEvent;", "motionActionToString", "", "action", "", "show", "hide", "resume", "Companion", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FastScrollButton extends FrameLayout {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f315541f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AnimatorSet f315542a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AnimatorSet f315543b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f315544c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f315545d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f315546e;

    public static final class a {
    }

    static {
    }

    public FastScrollButton(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final void setShow(boolean r100) {
        if (r100 != this.f315546e) goto L5;
        return;
    L5:
        this.f315546e = r100;
        if (r100 == false) goto L11;
        AnimatorSet r101 = this.f315543b;
        if (r101 == null) goto L10;
        r101.cancel();
    L10:
        this.f315543b = null;
        ObjectAnimator r102 = ObjectAnimator.ofFloat(this, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{getTranslationY(), this.f315544c});
        ObjectAnimator r103 = ObjectAnimator.ofFloat(this, "alpha", new float[]{getAlpha(), 1.0f});
        AnimatorSet r104 = new AnimatorSet();
        r104.play(r102).with(r103);
        r104.setDuration((long) ((1 - getAlpha()) * 300));
        r104.addListener(new d2(this));
        r104.start();
        this.f315542a = r104;
        return;
    L11:
        AnimatorSet r105 = this.f315542a;
        if (r105 == null) goto L14;
        r105.cancel();
    L14:
        this.f315542a = null;
        ObjectAnimator r106 = ObjectAnimator.ofFloat(this, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{getTranslationY(), 0.0f});
        ObjectAnimator r107 = ObjectAnimator.ofFloat(this, "alpha", new float[]{getAlpha(), 0.0f});
        AnimatorSet r108 = new AnimatorSet();
        r108.play(r106).with(r107);
        r108.setDuration((long) (getAlpha() * 300));
        r108.addListener(new c2(this));
        r108.start();
        this.f315543b = r108;
    }

    public FastScrollButton(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f315544c = -i5.o0();
        ImageView r102 = new ImageView(r100);
        this.f315545d = r102;
        if (r102.getId() != (-1)) goto L5;
        r102.setId(R.id.fast_button_icon);
    L5:
        r102.setImageResource(v19.c.b(R.attr.larus_ic_fast_button, r102.getContext(), R.drawable.larus_ic_fast_button));
        addView(r102, new FrameLayout.LayoutParams(-1, -1));
        setBackgroundResource(R.drawable.larus_fast_button_bg_shadow);
        int r103 = com.larus.utils.j0.f375426a;
        r102.setContentDescription(com.larus.utils.j0.d(R.string.larus_accessibility_scrollToBottom));
        ObricChatUIDelegate.f392858b.z(this);
    }
}
