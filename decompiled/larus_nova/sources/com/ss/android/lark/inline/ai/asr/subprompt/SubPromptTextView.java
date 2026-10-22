package com.ss.android.lark.inline.ai.asr.subprompt;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.text.TextPaint;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import com.larus.nova.R;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ(\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0007H\u0016J\u000e\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000fJ\u0018\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0007H\u0015J\b\u0010\u001a\u001a\u00020\u0011H\u0002J\u0010\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001dH\u0014R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/ss/android/lark/inline/ai/asr/subprompt/SubPromptTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "savedWidth", "savedHeight", "colorfulShader", "Landroid/graphics/Shader;", "type", "", "setPadding", "", "left", "top", "right", "bottom", "setType", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "updateColorfulShader", "onDraw", "canvas", "Landroid/graphics/Canvas;", "Companion", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SubPromptTextView extends AppCompatTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f426902a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f426903b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Shader f426904c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f426905d;

    public static final class a {
    }

    static {
    }

    public SubPromptTextView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public SubPromptTextView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void x() {
        this.f426904c = new LinearGradient(0.0f, 0.0f, (getMeasuredWidth() - getPaddingStart()) - getPaddingEnd(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), ContextCompat.getColor(getContext(), R.color.ai_primary_content_default_0), ContextCompat.getColor(getContext(), R.color.ai_primary_content_default_1), Shader.TileMode.CLAMP);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        TextPaint r101 = getPaint();
        if (r101 != null) goto L5;
    L11:
        super.onDraw(r100);
        return;
    L5:
        if (Intrinsics.areEqual(this.f426905d, "primary") == true) goto L7;
    L9:
        Shader r102 = null;
    L10:
        r101.setShader(r102);
        goto L11
    L7:
        if (isEnabled() == false) goto L9;
        r102 = this.f426904c;
        goto L10
    }

    public final void setType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Log.i("SubPromptTextView", "setType, type = " + r100);
        this.f426905d = r100;
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        if (this.f426902a == getMeasuredWidth()) goto L5;
    L6:
        this.f426902a = getMeasuredWidth();
        this.f426903b = getMeasuredHeight();
        x();
        return;
    L5:
        if (this.f426903b != getMeasuredHeight()) goto L6;
    }

    public SubPromptTextView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f426905d = "primary";
    }

    public /* synthetic */ SubPromptTextView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.widget.TextView, android.view.View
    public final void setPadding(int r100, int r101, int r102, int r103) {
        super.setPadding(r100, r101, r102, r103);
        if (getMeasuredWidth() > 0) goto L5;
        return;
    L5:
        if (getMeasuredHeight() <= 0) goto L9;
        x();
        return;
    }
}
