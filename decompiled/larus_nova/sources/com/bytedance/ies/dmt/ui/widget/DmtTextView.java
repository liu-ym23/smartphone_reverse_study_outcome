package com.bytedance.ies.dmt.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.text.InputFilter;
import android.text.PrecomputedText;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.dux.utils.EmojiTextViewHelper;
import java.util.Objects;

/* JADX INFO: loaded from: classes19.dex */
public class DmtTextView extends AppCompatTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f248440a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public EmojiTextViewHelper f248441b;

    public interface a {
    }

    public interface b {
    }

    public interface c {
    }

    private EmojiTextViewHelper getEmojiViewHelper() {
        if (this.f248441b != null) goto L6;
        this.f248441b = new EmojiTextViewHelper(this);
    L6:
        return this.f248441b;
    }

    @Override // android.view.View
    public final AccessibilityNodeInfo createAccessibilityNodeInfo() {
        return super.createAccessibilityNodeInfo();
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public CharSequence getText() {
        return super.getText();
    }

    @Override // android.widget.TextView, android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        System.nanoTime();
        boolean r100 = super.onPreDraw();
        System.nanoTime();
        return r100;
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean performLongClick() {
        return super.performLongClick();
    L4:
        getText();
        return false;
    }

    public DmtTextView(Context r100) {
        this(r100, null);
    }

    public static void setCrashMonitor(a r100) {
        Objects.toString(r100);
    }

    public static void setSetTextMonitor(b r100) {
        Objects.toString(r100);
    }

    public static void setSetTextOptimizer(c r100) {
        Objects.toString(r100);
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas r100) {
        System.nanoTime();
        super.onDraw(r100);
        System.nanoTime();
    }

    @Override // android.view.View
    public void setAlpha(float r100) {
        float r101 = this.f248440a;
        if (r101 > 0.0f) goto L5;
    L8:
        super.setAlpha(r100);
        return;
    L5:
        if (r100 <= r101) goto L8;
        super.setAlpha(r101);
    }

    public void setAlphaMax(float r100) {
        this.f248440a = r100;
        float r101 = getAlpha();
        float r102 = this.f248440a;
        if (r101 <= r102) goto L5;
        setAlpha(r102);
    L5:
        Objects.toString(getText());
    }

    public void setEnableParseEmoji(boolean r100) {
        getEmojiViewHelper().c(r100);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] r100) {
        InputFilter[] r101 = getEmojiViewHelper().b(r100);
        if (r101 != null) goto L5;
    L8:
        super.setFilters(r100);
        return;
    L5:
        if (r101.length == 0) goto L8;
        super.setFilters(r101);
    }

    public void setFontType(String r100) {
        com.bytedance.dux.text.a r101 = com.bytedance.dux.text.a.b();
        monitor-enter(r101);
        monitor-exit(r101);
    }

    public DmtTextView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f248440a = 1.0f;
        com.bytedance.dux.text.a.b().a(this, r101);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public final void onMeasure(int r100, int r101) {
        System.nanoTime();
        super.onMeasure(r100, r101);
        System.nanoTime();
    }

    @Override // android.widget.TextView, android.view.View
    public final void onVisibilityChanged(View r100, int r101) {
        super.onVisibilityChanged(r100, r101);     // Catch: NullPointerException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // android.widget.TextView
    public void setText(CharSequence r100, TextView.BufferType r101) {
        System.nanoTime();
        super.setText(r100, r101);     // Catch: Exception -> L5
    L13:
        System.nanoTime();
        return;
    L5:
        e = move-exception;
        if ((e instanceof IllegalArgumentException) == false) goto L13;
        if (Build.VERSION.SDK_INT < 28) goto L13;
        if ((r100 instanceof PrecomputedText) == false) goto L13;
        super.setText(new SpannableString(r100), r101);
        goto L13
    }

    public DmtTextView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f248440a = 1.0f;
        com.bytedance.dux.text.a.b().a(this, r101);
    }
}
