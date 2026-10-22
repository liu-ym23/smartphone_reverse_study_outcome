package com.ss.android.lark.keyboard.plugin.tool.voice.audio2.ai;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.facebook.keyframes.model.KFFeatureEffect;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.gradient.UDGradientDrawableKt;
import com.larksuite.component.universe_design.gradient.UDLinearGradientDrawable;
import com.larus.nova.R;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.c;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/ai/AudioAIGradientButton;", "Landroidx/appcompat/widget/AppCompatTextView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bgPaint", "Landroid/graphics/Paint;", KFFeatureEffect.GRADIENT_JSON_FIELD, "Lcom/larksuite/component/universe_design/gradient/UDGradientDrawable;", "boundsRect", "Landroid/graphics/Rect;", "boundsRectF", "Landroid/graphics/RectF;", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AudioAIGradientButton extends AppCompatTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f429926a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final UDLinearGradientDrawable f429927b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Rect f429928c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RectF f429929d;

    public AudioAIGradientButton(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public AudioAIGradientButton(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        float r100 = getWidth() / 2.0f;
        this.f429928c.set(0, 0, getWidth(), getHeight());
        this.f429929d.set(0.0f, 0.0f, getWidth(), getHeight());
        r110.drawRoundRect(this.f429929d, r100, r100, this.f429926a);
        UDLinearGradientDrawable r101 = this.f429927b;
        Rect r102 = this.f429928c;
        r101.setBounds(r102);
        int r103 = r110.saveLayer(r102.left, r102.top, r102.right, r102.bottom, null);
        super.onDraw(r110);
        r101.b((PorterDuffXfermode) UDGradientDrawableKt.f285024a.getValue());
        r101.draw(r110);
        r110.restoreToCount(r103);
        r101.b(null);
    }

    public AudioAIGradientButton(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        Paint r103 = new Paint(1);
        int r104 = c.f430003a;
        r103.setColor(c.c(this, R.color.bg_body));
        this.f429926a = r103;
        int r105 = com.larksuite.component.universe_design.gradient.b.f285036a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        UDLinearGradientDrawable.Orientation r106 = UDLinearGradientDrawable.Orientation.TO_BOTTOM_RIGHT;
        UDLinearGradientDrawable r107 = new UDLinearGradientDrawable(UDColorUtils.getColor(r100, R.color.ai_primary_content_default_0), UDColorUtils.getColor(r100, R.color.ai_primary_content_default_1), r106);
        r107.mutate();
        this.f429927b = r107;
        this.f429928c = new Rect();
        this.f429929d = new RectF();
    }

    public /* synthetic */ AudioAIGradientButton(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
