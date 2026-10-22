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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001e\u0010\u0010\u001a\u00020\u00112\b\u0010\r\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0007J\b\u0010\u0012\u001a\u00020\u0011H\u0002J(\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0007H\u0014J\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u000bH\u0002J\u0010\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u001fH\u0014R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/bytedance/ee/bear/doc/blockeditpanel/view/GradientTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defaultColorList", "Lcom/bytedance/ee/bear/doc/blockeditpanel/view/GradientColorConfig;", "pressedColorList", "defaultShader", "Landroid/graphics/Shader;", "pressedShader", "setGradientColor", "", "buildShaders", "onSizeChanged", "w", "h", "oldw", "oldh", "getShaderByGradientColorConfig", "config", "setPressed", "pressed", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "docs-doc-impl-native_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GradientTextView extends AppCompatTextView {
    public GradientColorConfig a;
    public GradientColorConfig b;
    public Shader c;
    public Shader d;

    public GradientTextView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public GradientTextView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void x() {
        if (getWidth() > 0) goto L5;
        return;
    L5:
        if (getHeight() <= 0) goto L10;
        this.d = y(this.b);
        this.c = y(this.a);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDraw(Canvas r3) {
        Intrinsics.checkNotNullParameter(r3, "canvas");
        TextPaint r0 = getPaint();
        if (isPressed() == false) goto L5;
        Shader r1 = this.d;
    L6:
        r0.setShader(r1);
        super/*android.widget.TextView*/.onDraw(r3);
        return;
    L5:
        r1 = this.c;
        goto L6
    }

    public final void setGradientColor(GradientColorConfig r2) {
        z(r2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setPressed(boolean r1) {
        super/*android.widget.TextView*/.setPressed(r1);
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Shader y(GradientColorConfig r11) {
        if (r11 != null) goto L4;
        return null;
    L4:
        if (r11.a.size() < 2) goto L15;
        float r5 = (getWidth() - getPaddingStart()) - getPaddingEnd();
        float r6 = (getHeight() - getPaddingTop()) - getPaddingBottom();
        ArrayList r0 = new ArrayList();
        Iterator<T> r12 = r11.a.iterator();
    L8:
        if (r12.hasNext() == false) goto L11;
        r0.add(Integer.valueOf(ContextCompat.getColor(getContext(), ((Number) r12.next()).intValue())));
        goto L8
    L11:
        return new LinearGradient(0.0f, 0.0f, r5, r6, CollectionsKt.toIntArray(r0), null, Shader.TileMode.CLAMP);
    L15:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void z(GradientColorConfig r3, GradientColorConfig r4) {
        this.b = r4;
        this.a = r3;
        x();
        if (r3 == null) goto L9;
        List<Integer> r0 = r3.a;
        if (r0 == null) goto L9;
        boolean r1 = true;
        if (r0.size() != 1) goto L9;
    L10:
        if (r1 == false) goto L13;
        setTextColor(ContextCompat.getColor(getContext(), ((Number) ListProtector.get(r3.a, 0)).intValue()));
        return;
    L13:
        return;
    L9:
        r1 = false;
        goto L10
    }

    public GradientTextView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ GradientTextView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super/*android.widget.TextView*/.onSizeChanged(r1, r2, r3, r4);
        x();
    }
}
