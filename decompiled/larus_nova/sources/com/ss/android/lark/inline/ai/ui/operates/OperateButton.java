package com.ss.android.lark.inline.ai.ui.operates;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;
import com.larksuite.component.universe_design.button.UDButton;
import com.larus.nova.R;
import com.ss.android.lark.inline.ai.logic.b;
import com.ss.android.lark.inline.ai.ui.f0;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000  2\u00020\u0001:\u0001 B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u0007J\u000e\u0010\u0013\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u000bJ(\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0007H\u0016J\u0018\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\u0015J\b\u0010\u001c\u001a\u00020\u0012H\u0002J\u0010\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u001fH\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/ss/android/lark/inline/ai/ui/operates/OperateButton;", "Lcom/larksuite/component/universe_design/button/UDButton;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "type", "", "savedWidth", "savedHeight", "colorfulShader", "Landroid/graphics/Shader;", "bgColor", "setPrimaryTypeBgColor", "", "setType", "setPadding", "left", "top", "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "updateColorfulShader", "onDraw", "canvas", "Landroid/graphics/Canvas;", "Companion", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OperateButton extends UDButton {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f427567a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f427568b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f427569c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Shader f427570d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f427571e;

    public static final class a {
    }

    static {
    }

    public OperateButton(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public OperateButton(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void a() {
        this.f427570d = new LinearGradient(0.0f, 0.0f, (getMeasuredWidth() - getPaddingStart()) - getPaddingEnd(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), ContextCompat.getColor(getContext(), R.color.ai_primary_content_default_0), ContextCompat.getColor(getContext(), R.color.ai_primary_content_default_1), Shader.TileMode.CLAMP);
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
        if (Intrinsics.areEqual(this.f427567a, "primary") == true) goto L7;
    L9:
        Shader r102 = null;
    L10:
        r101.setShader(r102);
        goto L11
    L7:
        if (isEnabled() == false) goto L9;
        r102 = this.f427570d;
        goto L10
    }

    public final void setPrimaryTypeBgColor(int r100) {
        this.f427571e = r100;
    }

    public final void setType(String r210) {
        Intrinsics.checkNotNullParameter(r210, "type");
        Log.i("OperateButton", "setType, type = " + r210);
        this.f427567a = r210;
        if (Intrinsics.areEqual(r210, "primary") == false) goto L5;
        StateListDrawable r100 = new StateListDrawable();
        int[] r101 = {android.R.attr.state_pressed};
        Drawable r102 = AppCompatResources.getDrawable(getContext(), R.drawable.ai_primary_content_default);
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        GradientDrawable r103 = (GradientDrawable) r102;
        r103.setCornerRadius(f0.a(6));
        Unit r110 = Unit.INSTANCE;
        GradientDrawable r104 = new GradientDrawable();
        r104.setColor(ContextCompat.getColor(getContext(), this.f427571e));
        r104.setCornerRadius(f0.a(5));
        Drawable r105 = AppCompatResources.getDrawable(getContext(), R.drawable.ai_primary_fill_transparent_02);
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        GradientDrawable r106 = (GradientDrawable) r105;
        r106.setCornerRadius(f0.a(5));
        LayerDrawable r107 = new LayerDrawable(new GradientDrawable[]{r103, r104, r106});
        r107.setLayerInset(1, f0.a(1), f0.a(1), f0.a(1), f0.a(1));
        r107.setLayerInset(2, f0.a(1), f0.a(1), f0.a(1), f0.a(1));
        r100.addState(r101, r107);
        GradientDrawable r108 = new GradientDrawable();
        r108.setColor(AppCompatResources.getColorStateList(getContext(), this.f427571e));
        r108.setCornerRadius(f0.a(6));
        r108.setStroke(f0.a(1), ContextCompat.getColor(getContext(), R.color.line_border_component));
        r100.addState(new int[]{-16842910}, r108);
        Drawable r109 = AppCompatResources.getDrawable(getContext(), R.drawable.ai_primary_content_default);
        Intrinsics.checkNotNull(r109, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        GradientDrawable r111 = (GradientDrawable) r109;
        r111.setCornerRadius(f0.a(6));
        GradientDrawable r112 = new GradientDrawable();
        r112.setColor(ContextCompat.getColor(getContext(), this.f427571e));
        r112.setCornerRadius(f0.a(5));
        LayerDrawable r113 = new LayerDrawable(new GradientDrawable[]{r111, r112});
        r113.setLayerInset(1, f0.a(1), f0.a(1), f0.a(1), f0.a(1));
        r100.addState(new int[0], r113);
        setBackground(r100);
        return;
    L5:
        StateListDrawable r114 = new StateListDrawable();
        int[] r115 = {android.R.attr.state_pressed};
        GradientDrawable r116 = new GradientDrawable();
        r116.setColor(AppCompatResources.getColorStateList(getContext(), R.color.fill_pressed));
        r116.setCornerRadius(f0.a(6));
        r116.setStroke(f0.a(1), ContextCompat.getColor(getContext(), R.color.line_border_component));
        Unit r117 = Unit.INSTANCE;
        r114.addState(r115, r116);
        GradientDrawable r118 = new GradientDrawable();
        r118.setColor(AppCompatResources.getColorStateList(getContext(), R.color.udtoken_component_outlined_bg));
        r118.setCornerRadius(f0.a(6));
        r118.setStroke(f0.a(1), ContextCompat.getColor(getContext(), R.color.line_border_component));
        r114.addState(new int[]{-16842910}, r118);
        GradientDrawable r119 = new GradientDrawable();
        r119.setColor(AppCompatResources.getColorStateList(getContext(), R.color.udtoken_component_outlined_bg));
        r119.setCornerRadius(f0.a(6));
        r119.setStroke(f0.a(1), ContextCompat.getColor(getContext(), R.color.line_border_component));
        r114.addState(new int[0], r119);
        setBackground(r114);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        if (this.f427568b == getMeasuredWidth()) goto L5;
    L6:
        this.f427568b = getMeasuredWidth();
        this.f427569c = getMeasuredHeight();
        a();
        return;
    L5:
        if (this.f427569c != getMeasuredHeight()) goto L6;
    }

    public OperateButton(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f427567a = "primary";
        com.ss.android.lark.storage.a r103 = b.f427283a;
        this.f427571e = R.color.bg_float;
        setTextColor(new ColorStateList(new int[][]{new int[]{-16842910}, new int[0]}, new int[]{ContextCompat.getColor(r100, R.color.text_link_disable), ContextCompat.getColor(r100, R.color.text_title)}));
        setType(this.f427567a);
    }

    public /* synthetic */ OperateButton(Context r100, AttributeSet r101, int r102, int r103) {
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
        a();
        return;
    }
}
