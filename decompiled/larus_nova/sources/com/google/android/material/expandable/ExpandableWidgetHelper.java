package com.google.android.material.expandable;

import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* JADX INFO: loaded from: classes23.dex */
public final class ExpandableWidgetHelper {
    private boolean expanded;
    private int expandedComponentIdHint;
    private final View widget;

    private void dispatchExpandedStateChanged() {
        ViewParent r100 = this.widget.getParent();
        if ((r100 instanceof CoordinatorLayout) == false) goto L6;
        ((CoordinatorLayout) r100).dispatchDependentViewsChanged(this.widget);
        return;
    }

    public Bundle onSaveInstanceState() {
        Bundle r100 = new Bundle();
        r100.putBoolean("expanded", this.expanded);
        r100.putInt("expandedComponentIdHint", this.expandedComponentIdHint);
        return r100;
    }

    public int getExpandedComponentIdHint() {
        return this.expandedComponentIdHint;
    }

    public boolean isExpanded() {
        return this.expanded;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ExpandableWidgetHelper(ExpandableWidget r100) {
        this.expanded = false;
        this.expandedComponentIdHint = 0;
        this.widget = (View) r100;
    }

    public void onRestoreInstanceState(Bundle r100) {
        this.expanded = r100.getBoolean("expanded", false);
        this.expandedComponentIdHint = r100.getInt("expandedComponentIdHint", 0);
        if (this.expanded == false) goto L6;
        dispatchExpandedStateChanged();
        return;
    }

    public boolean setExpanded(boolean r100) {
        if (this.expanded == r100) goto L6;
        this.expanded = r100;
        dispatchExpandedStateChanged();
        return true;
    L6:
        return false;
    }

    public void setExpandedComponentIdHint(int r100) {
        this.expandedComponentIdHint = r100;
    }
}
