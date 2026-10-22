package com.bytedance.ee.bear.doc.blockeditpanel.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.text.TextPaint;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001e\u0010\u0010\u001a\u00020\u00112\b\u0010\r\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0007J\b\u0010\u0012\u001a\u00020\u0011H\u0002J(\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0007H\u0014J\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u000bH\u0002J\u0010\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u001fH\u0014R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/bytedance/ee/bear/doc/blockeditpanel/view/GradientTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defaultColorList", "Lcom/bytedance/ee/bear/doc/blockeditpanel/view/GradientColorConfig;", "pressedColorList", "defaultShader", "Landroid/graphics/Shader;", "pressedShader", "setGradientColor", "", "buildShaders", "onSizeChanged", "w", "h", "oldw", "oldh", "getShaderByGradientColorConfig", "config", "setPressed", "pressed", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "docs-doc-impl-native_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GradientTextView extends AppCompatTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public GradientColorConfig f217655a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public GradientColorConfig f217656b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Shader f217657c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Shader f217658d;

    public GradientTextView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public GradientTextView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void x() {
        if (getWidth() > 0) goto L5;
        return;
    L5:
        if (getHeight() <= 0) goto L10;
        this.f217658d = y(this.f217656b);
        this.f217657c = y(this.f217655a);
        return;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        TextPaint r101 = getPaint();
        if (isPressed() == false) goto L5;
        Shader r102 = this.f217658d;
    L6:
        r101.setShader(r102);
        super.onDraw(r100);
        return;
    L5:
        r102 = this.f217657c;
        goto L6
    }

    public final void setGradientColor(GradientColorConfig r100) {
        z(r100, null);
    }

    @Override // android.view.View
    public void setPressed(boolean r100) {
        super.setPressed(r100);
        invalidate();
    }

    public final Shader y(GradientColorConfig r110) {
        if (r110 != null) goto L4;
        return null;
    L4:
        if (r110.f217652a.size() < 2) goto L15;
        float r100 = (getWidth() - getPaddingStart()) - getPaddingEnd();
        float r101 = (getHeight() - getPaddingTop()) - getPaddingBottom();
        ArrayList r102 = new ArrayList();
        Iterator<T> r111 = r110.f217652a.iterator();
    L8:
        if (r111.hasNext() == false) goto L11;
        r102.add(Integer.valueOf(ContextCompat.getColor(getContext(), ((Number) r111.next()).intValue())));
        goto L8
    L11:
        return new LinearGradient(0.0f, 0.0f, r100, r101, CollectionsKt.toIntArray(r102), null, Shader.TileMode.CLAMP);
    L15:
        return null;
    }

    public final void z(GradientColorConfig r100, GradientColorConfig r101) {
        this.f217656b = r101;
        this.f217655a = r100;
        x();
        if (r100 == null) goto L9;
        List<Integer> r102 = r100.f217652a;
        if (r102 == null) goto L9;
        boolean r103 = true;
        if (r102.size() != 1) goto L9;
    L10:
        if (r103 == false) goto L13;
        setTextColor(ContextCompat.getColor(getContext(), ((Number) ListProtector.get(r100.f217652a, 0)).intValue()));
        return;
    L13:
        return;
    L9:
        r103 = false;
        goto L10
    }

    public GradientTextView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ GradientTextView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        x();
    }
}
