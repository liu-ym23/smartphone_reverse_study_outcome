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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class DmtTextView extends AppCompatTextView {

    public interface a {
    }

    public interface b {
    }

    public void setFontType(String r1) {
    }

    public CharSequence getText() {
        boolean r0 = this instanceof ScrollMentionTextView;
        return super.getText();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final AccessibilityNodeInfo createAccessibilityNodeInfo() {
        return super/*android.widget.TextView*/.createAccessibilityNodeInfo();
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean onPreDraw() {
        System.nanoTime();
        boolean r0 = super/*android.widget.TextView*/.onPreDraw();
        System.nanoTime();
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean performLongClick() {
        return super/*android.widget.TextView*/.performLongClick();
    L4:
        getText();
        return false;
    }

    public DmtTextView(Context r2) {
        this(r2, null);
    }

    public static void setSetTextMonitor(a r1) {
        Objects.toString(r1);
    }

    public static void setSetTextOptimizer(b r1) {
        Objects.toString(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDraw(Canvas r1) {
        System.nanoTime();
        super/*android.widget.TextView*/.onDraw(r1);
        boolean r2 = this instanceof ScrollMentionTextView;
        System.nanoTime();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setBackgroundColor(int r1) {
        super/*android.widget.TextView*/.setBackgroundColor(r1);
    }

    public DmtTextView(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public void onMeasure(int r1, int r2) {
        System.nanoTime();
        super.onMeasure(r1, r2);
        System.nanoTime();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onVisibilityChanged(View r1, int r2) {
        super/*android.widget.TextView*/.onVisibilityChanged(r1, r2);     // Catch: NullPointerException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setText(CharSequence r2, TextView.BufferType r3) {
        boolean r0 = this instanceof ScrollMentionTextView;
        System.nanoTime();
        super/*android.widget.TextView*/.setText(r2, r3);
        System.nanoTime();
    }

    public DmtTextView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }
}
