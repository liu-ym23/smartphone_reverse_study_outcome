package com.facebook.drawee.view;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import com.facebook.common.internal.Preconditions;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes23.dex */
public class MultiDraweeHolder<DH extends DraweeHierarchy> {
    ArrayList<DraweeHolder<DH>> mHolders;
    boolean mIsAttached;

    public void clear() {
        if (this.mIsAttached == false) goto L8;
        int r100 = 0;
    L6:
        if (r100 >= this.mHolders.size()) goto L8;
        this.mHolders.get(r100).onDetach();
        r100 = r100 + 1;
    L8:
        this.mHolders.clear();
    }

    public void onAttach() {
        if (this.mIsAttached == false) goto L5;
        return;
    L5:
        this.mIsAttached = true;
        int r100 = 0;
    L7:
        if (r100 >= this.mHolders.size()) goto L9;
        this.mHolders.get(r100).onAttach();
        r100 = r100 + 1;
        goto L7
    }

    public void onDetach() {
        if (this.mIsAttached == true) goto L5;
        return;
    L5:
        int r100 = 0;
        this.mIsAttached = false;
    L7:
        if (r100 >= this.mHolders.size()) goto L9;
        this.mHolders.get(r100).onDetach();
        r100 = r100 + 1;
        goto L7
    }

    public int size() {
        return this.mHolders.size();
    }

    public MultiDraweeHolder() {
        this.mIsAttached = false;
        this.mHolders = new ArrayList();
    }

    public void add(DraweeHolder<DH> r100) {
        add(this.mHolders.size(), r100);
    }

    public void draw(Canvas r100) {
        int r101 = 0;
    L4:
        if (r101 >= this.mHolders.size()) goto L9;
        Drawable r102 = get(r101).getTopLevelDrawable();
        if (r102 == null) goto L8;
        r102.draw(r100);
    L8:
        r101 = r101 + 1;
        goto L4
    }

    public DraweeHolder<DH> get(int r100) {
        return this.mHolders.get(r100);
    }

    public boolean onTouchEvent(MotionEvent r100) {
        int r101 = 0;
    L4:
        if (r101 >= this.mHolders.size()) goto L10;
        if (this.mHolders.get(r101).onTouchEvent(r100) == true) goto L7;
        r101 = r101 + 1;
        goto L4
    L7:
        return true;
    L10:
        return false;
    }

    public void remove(int r100) {
        DraweeHolder<DH> r101 = this.mHolders.get(r100);
        if (this.mIsAttached == false) goto L5;
        r101.onDetach();
    L5:
        this.mHolders.remove(r100);
    }

    public boolean verifyDrawable(Drawable r100) {
        int r101 = 0;
    L4:
        if (r101 >= this.mHolders.size()) goto L10;
        if (r100 == get(r101).getTopLevelDrawable()) goto L7;
        r101 = r101 + 1;
        goto L4
    L7:
        return true;
    L10:
        return false;
    }

    public void add(int r100, DraweeHolder<DH> r101) {
        Preconditions.checkNotNull(r101);
        Preconditions.checkElementIndex(r100, this.mHolders.size() + 1);
        this.mHolders.add(r100, r101);
        if (this.mIsAttached == false) goto L6;
        r101.onAttach();
        return;
    }
}
