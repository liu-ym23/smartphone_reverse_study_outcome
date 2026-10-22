package com.lynx.markdown;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes32.dex */
public class MarkdownView extends ViewGroup implements IMarkdownViewHandle {
    @Override // com.lynx.markdown.IMarkdownViewHandle
    public int getVerticalAlign() {
        return 2;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
    }

    @Override // com.lynx.markdown.IMarkdownViewHandle
    public long getPosition() {
        return i.a(getLeft(), getTop());
    }

    @Override // com.lynx.markdown.IMarkdownViewHandle
    public long getSize() {
        return i.a(getWidth(), getHeight());
    }

    @Override // com.lynx.markdown.IMarkdownViewHandle
    public void requestAlign() {
        requestLayout();
    }

    @Override // com.lynx.markdown.IMarkdownViewHandle
    public void requestDraw() {
        invalidate();
    }

    @Override // com.lynx.markdown.IMarkdownViewHandle
    public void requestMeasure() {
        requestLayout();
    }

    public MarkdownView(Context r100) {
        super(r100);
    }

    @Override // com.lynx.markdown.IMarkdownViewHandle
    public void setVisibility(boolean r100) {
        if (r100 == false) goto L4;
        int r101 = 0;
    L5:
        super.setVisibility(r101);
        return;
    L4:
        r101 = 4;
        goto L5
    }

    public MarkdownView(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    public static int getMeasureSpec(int r100, int r101) {
        if (r101 != 1) goto L5;
        int r102 = 1073741824;
    L10:
        return View.MeasureSpec.makeMeasureSpec(r100, r102);
    L5:
        if (r101 == 2) goto L7;
        r102 = 0;
        goto L10
    L7:
        r102 = Integer.MIN_VALUE;
        goto L10
    }

    @Override // com.lynx.markdown.IMarkdownViewHandle
    public void align(int r100, int r101) {
        int r102 = getMeasuredWidth();
        layout(r100, r101, r102 + r100, getMeasuredHeight() + r101);
    }

    @Override // android.view.View
    public void onMeasure(int r100, int r101) {
        setMeasuredDimension(ViewGroup.resolveSize(0, r100), ViewGroup.resolveSize(0, r101));
    }

    @Override // com.lynx.markdown.IMarkdownViewHandle
    public void setPosition(int r100, int r101) {
        int r102 = getWidth();
        int r103 = getHeight();
        setLeft(r100);
        setTop(r101);
        setRight(r100 + r102);
        setBottom(r101 + r103);
    }

    @Override // com.lynx.markdown.IMarkdownViewHandle
    public void setSize(int r100, int r101) {
        setRight(getLeft() + r100);
        setBottom(getTop() + r101);
    }

    public MarkdownView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }

    @Override // com.lynx.markdown.IMarkdownViewHandle
    public long measure(int r100, int r101, int r102, int r103) {
        int r104 = 0;
        if (r101 == 1) goto L7;
        if (r101 == 2) goto L6;
        int r105 = 0;
    L8:
        int r106 = getMeasureSpec(r100, r105);
        if (r103 == 1) goto L13;
        if (r103 != 2) goto L14;
        r104 = Integer.MIN_VALUE;
    L14:
        measure(r106, getMeasureSpec(r102, r104));
        int r107 = getMeasuredWidth();
        int r108 = getMeasuredHeight();
        int r109 = getBaseline();
        if (r109 >= 0) goto L18;
        r109 = r108;
    L18:
        return i.b(r107, r108, r109);
    L13:
        r104 = 1073741824;
        goto L14
    L6:
        r105 = Integer.MIN_VALUE;
        goto L8
    L7:
        r105 = 1073741824;
        goto L8
    }
}
