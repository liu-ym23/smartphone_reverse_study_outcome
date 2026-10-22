package com.bytedance.awemeopen.apps.framework.base.view.refresh;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.awemeopen.apps.framework.feed.desc.ScrollMentionTextView;
import java.util.Objects;

/* JADX INFO: loaded from: classes14.dex */
public class DmtTextView extends AppCompatTextView {

    public interface a {
    }

    public interface b {
    }

    public void setFontType(String r100) {
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public CharSequence getText() {
        boolean r100 = this instanceof ScrollMentionTextView;
        return super.getText();
    }

    @Override // android.view.View
    public final AccessibilityNodeInfo createAccessibilityNodeInfo() {
        return super.createAccessibilityNodeInfo();
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
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

    public static void setSetTextMonitor(a r100) {
        Objects.toString(r100);
    }

    public static void setSetTextOptimizer(b r100) {
        Objects.toString(r100);
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas r100) {
        System.nanoTime();
        super.onDraw(r100);
        boolean r101 = this instanceof ScrollMentionTextView;
        System.nanoTime();
    }

    @Override // android.view.View
    public void setBackgroundColor(int r100) {
        super.setBackgroundColor(r100);
    }

    public DmtTextView(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onMeasure(int r100, int r101) {
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
    public final void setText(CharSequence r100, TextView.BufferType r101) {
        boolean r102 = this instanceof ScrollMentionTextView;
        System.nanoTime();
        super.setText(r100, r101);
        System.nanoTime();
    }

    public DmtTextView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
