package com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.viewbinding.ViewBindings;
import com.larus.bot.impl.databinding.LarusWidgetGenBgPromptInputButtonBinding;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u000fJ\b\u0010\u0011\u001a\u00020\u000fH\u0002J\b\u0010\u0012\u001a\u00020\u000fH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/img2img/widget/PromptInputButtonView;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/bot/impl/databinding/LarusWidgetGenBgPromptInputButtonBinding;", "rotateAnimation", "Landroid/view/animation/RotateAnimation;", "showNormal", "", "showGenerating", "startGeneratingAnim", "cancelGeneratingAnim", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PromptInputButtonView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusWidgetGenBgPromptInputButtonBinding f318859a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RotateAnimation f318860b;

    public PromptInputButtonView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public PromptInputButtonView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void a() {
        this.f318859a.f317965b.setImageResource(R.drawable.larus_ugc_bot_icon_prompt_input_button_generating);
        RotateAnimation r100 = this.f318860b;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        this.f318860b = null;
        RotateAnimation r101 = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        this.f318860b = r101;
        this.f318859a.f317965b.setAnimation(r101);
        RotateAnimation r102 = this.f318860b;
        if (r102 == null) goto L8;
        r102.setDuration(2000);
    L8:
        RotateAnimation r103 = this.f318860b;
        if (r103 == null) goto L11;
        r103.setRepeatCount(-1);
    L11:
        RotateAnimation r104 = this.f318860b;
        if (r104 == null) goto L15;
        r104.start();
        return;
    }

    public PromptInputButtonView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.larus_widget_gen_bg_prompt_input_button, this);
        ImageView r103 = (ImageView) ViewBindings.findChildViewById(this, R.id.desc_prompt_input_icon);
        if (r103 == null) goto L7;
        this.f318859a = new LarusWidgetGenBgPromptInputButtonBinding(this, r103);
        setBackground(ContextCompat.getDrawable(r100, R.drawable.larus_ugc_bot_bg_prompt_input_button));
        return;
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(R.id.desc_prompt_input_icon)));
    }

    public /* synthetic */ PromptInputButtonView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
