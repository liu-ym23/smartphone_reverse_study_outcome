package com.facebook.imagepipeline;

import android.content.Context;
import android.graphics.Point;
import android.util.Log;
import android.util.Pair;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.facebook.common.internal.Preconditions;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class SizeDeterminer {
    private static final int PENDING_SIZE = 0;
    private static final int SIZE_ORIGINAL = Integer.MIN_VALUE;
    private static final String TAG = "SizeDeterminer";
    static Integer maxDisplayLength;
    private final List<SizeReadyCallback> cbs;
    private SizeDeterminerLayoutListener layoutListener;
    boolean waitForLayout;
    private final WeakReference<View> weakRef;

    /* JADX INFO: loaded from: classes23.dex */
    public static final class SizeDeterminerLayoutListener implements ViewTreeObserver.OnPreDrawListener {
        private final WeakReference<SizeDeterminer> sizeDeterminerRef;

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            if (Log.isLoggable(SizeDeterminer.TAG, 2) == true) goto L5;
        L5:
            SizeDeterminer r100 = this.sizeDeterminerRef.get();
            if (r100 == null) goto L10;
            r100.checkCurrentDimens();
            return true;
        L10:
            return true;
        }

        public SizeDeterminerLayoutListener(SizeDeterminer r100) {
            this.sizeDeterminerRef = new WeakReference(r100);
        }
    }

    private boolean isDimensionValid(int r100) {
        if (r100 <= 0) goto L4;
    L7:
        return true;
    L4:
        if (r100 == Integer.MIN_VALUE) goto L7;
        return false;
    }

    public void checkCurrentDimens() {
        if (this.cbs.isEmpty() == false) goto L5;
        return;
    L5:
        View r100 = getView();
        if (r100 != null) goto L8;
        return;
    L8:
        int r101 = getTargetWidth(r100);
        int r102 = getTargetHeight(r100);
        if (isViewStateAndSizeValid(r101, r102) == true) goto L11;
        return;
    L11:
        notifyCbs(r101, r102);
        clearCallbacksAndListener();
    }

    public View getView() {
        return this.weakRef.get();
    }

    public void clearCallbacksAndListener() {
        View r100 = getView();
        if (r100 == null) goto L7;
        ViewTreeObserver r101 = r100.getViewTreeObserver();
        if (r101.isAlive() == false) goto L7;
        r101.removeOnPreDrawListener(this.layoutListener);
    L7:
        this.layoutListener = null;
        this.cbs.clear();
    }

    public Pair<Integer, Integer> getSize() {
        View r100 = getView();
        if (r100 != null) goto L5;
        return null;
    L5:
        int r101 = getTargetWidth(r100);
        int r102 = getTargetHeight(r100);
        if (isViewStateAndSizeValid(r101, r102) == true) goto L8;
        return null;
    L8:
        return new Pair(Integer.valueOf(r101), Integer.valueOf(r102));
    }

    public SizeDeterminer(View r100) {
        this.cbs = new ArrayList();
        this.weakRef = new WeakReference(r100);
    }

    private static int getMaxDisplayLength(Context r100) {
        if (maxDisplayLength != null) goto L6;
        Display r101 = ((WindowManager) Preconditions.checkNotNull((WindowManager) r100.getSystemService(LiveEndPageData.TAG_WINDOW))).getDefaultDisplay();
        Point r102 = new Point();
        r101.getSize(r102);
        maxDisplayLength = Integer.valueOf(Math.max(r102.x, r102.y));
    L6:
        return maxDisplayLength.intValue();
    }

    private int getTargetHeight(View r100) {
        int r101 = r100.getPaddingTop() + r100.getPaddingBottom();
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        if (r102 == null) goto L5;
        int r103 = r102.height;
    L7:
        return getTargetDimen(r100.getHeight(), r103, r101, r100);
    L5:
        r103 = 0;
        goto L7
    }

    private int getTargetWidth(View r100) {
        int r101 = r100.getPaddingLeft() + r100.getPaddingRight();
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        if (r102 == null) goto L5;
        int r103 = r102.width;
    L7:
        return getTargetDimen(r100.getWidth(), r103, r101, r100);
    L5:
        r103 = 0;
        goto L7
    }

    public void getSize(SizeReadyCallback r100) {
        View r101 = getView();
        if (r101 != null) goto L5;
        return;
    L5:
        int r102 = getTargetWidth(r101);
        int r103 = getTargetHeight(r101);
        if (isViewStateAndSizeValid(r102, r103) == false) goto L10;
        r100.onSizeReady(r102, r103);
        return;
    L10:
        if (this.cbs.contains(r100) == true) goto L13;
        this.cbs.add(r100);
    L13:
        if (this.layoutListener != null) goto L16;
        ViewTreeObserver r104 = r101.getViewTreeObserver();
        SizeDeterminerLayoutListener r105 = new SizeDeterminerLayoutListener(this);
        this.layoutListener = r105;
        r104.addOnPreDrawListener(r105);
        return;
    }

    public void removeCallback(SizeReadyCallback r100) {
        this.cbs.remove(r100);
    }

    private boolean isViewStateAndSizeValid(int r100, int r101) {
        if (isDimensionValid(r100) == true) goto L5;
    L7:
        return false;
    L5:
        if (isDimensionValid(r101) == false) goto L7;
        return true;
    }

    private void notifyCbs(int r100, int r101) {
        Iterator r102 = new ArrayList(this.cbs).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((SizeReadyCallback) r102.next()).onSizeReady(r100, r101);
        goto L4
    }

    private int getTargetDimen(int r100, int r101, int r102, View r103) {
        int r104 = r101 - r102;
        if (r104 <= 0) goto L6;
        return r104;
    L6:
        if (this.waitForLayout == true) goto L8;
    L10:
        int r105 = r100 - r102;
        if (r105 <= 0) goto L14;
        return r105;
    L14:
        if (r103.isLayoutRequested() == false) goto L16;
    L19:
        return 0;
    L16:
        if (r101 != (-2)) goto L19;
        return getMaxDisplayLength(r103.getContext());
    L8:
        if (r103.isLayoutRequested() == false) goto L10;
        return 0;
    }
}
