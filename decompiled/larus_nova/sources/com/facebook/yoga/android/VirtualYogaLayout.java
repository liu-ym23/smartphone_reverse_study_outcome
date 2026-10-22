package com.facebook.yoga.android;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.yoga.YogaNode;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes23.dex */
public class VirtualYogaLayout extends ViewGroup {
    private final List<View> mChildren;
    private final YogaNode mYogaNode;
    private final Map<View, YogaNode> mYogaNodes;

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new YogaLayout.LayoutParams(-1, -1);
    }

    public YogaNode getYogaNode() {
        return this.mYogaNode;
    }

    public VirtualYogaLayout(Context r100) {
        super(r100);
        this.mChildren = new LinkedList();
        this.mYogaNodes = new HashMap();
        this.mYogaNode = new YogaNode();
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams r100) {
        return r100 instanceof YogaLayout.LayoutParams;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet r100) {
        return new YogaLayout.LayoutParams(getContext(), r100);
    }

    public void transferChildren(ViewGroup r100) {
        if ((r100 instanceof VirtualYogaLayout) == false) goto L9;
        Iterator<View> r101 = this.mChildren.iterator();
    L6:
        if (r101.hasNext() == false) goto L14;
        View r102 = r101.next();
        ((VirtualYogaLayout) r100).addView(r102, this.mYogaNodes.get(r102));
    L14:
        this.mChildren.clear();
        return;
    L9:
        if ((r100 instanceof YogaLayout) == false) goto L17;
        Iterator<View> r103 = this.mChildren.iterator();
    L12:
        if (r103.hasNext() == false) goto L14;
        View r104 = r103.next();
        ((YogaLayout) r100).addView(r104, this.mYogaNodes.get(r104));
        goto L12
    L17:
        throw new RuntimeException("VirtualYogaLayout cannot transfer children to ViewGroup of type " + r100.getClass().getCanonicalName() + ".  Must either be a VirtualYogaLayout or a YogaLayout.");
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r100) {
        return new YogaLayout.LayoutParams(r100);
    }

    public VirtualYogaLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public void addView(View r100, YogaNode r101) {
        this.mChildren.add(r100);
        this.mYogaNodes.put(r100, r101);
    }

    public VirtualYogaLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.mChildren = new LinkedList();
        this.mYogaNodes = new HashMap();
        YogaNode r103 = new YogaNode();
        this.mYogaNode = r103;
        YogaLayout.applyLayoutParams(new YogaLayout.LayoutParams(r100, r101), r103, this);
    }

    @Override // android.view.ViewGroup
    public void addView(View r100, int r101, ViewGroup.LayoutParams r102) {
        if ((r100 instanceof VirtualYogaLayout) == false) goto L6;
        VirtualYogaLayout r103 = (VirtualYogaLayout) r100;
        r103.transferChildren(this);
        YogaNode r104 = r103.getYogaNode();
        YogaNode r105 = this.mYogaNode;
        r105.addChildAt(r104, r105.getChildCount());
        return;
    L6:
        YogaNode r106 = new YogaNode();
        YogaLayout.applyLayoutParams(new YogaLayout.LayoutParams(r102), r106, r100);
        r106.setData(r100);
        r106.setMeasureFunction(new YogaLayout.ViewMeasureFunction());
        YogaNode r107 = this.mYogaNode;
        r107.addChildAt(r106, r107.getChildCount());
        addView(r100, r106);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        throw new RuntimeException("Attempting to layout a VirtualYogaLayout");
    }
}
