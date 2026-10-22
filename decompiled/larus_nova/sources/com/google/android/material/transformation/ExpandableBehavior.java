package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.android.material.expandable.ExpandableWidget;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public abstract class ExpandableBehavior extends CoordinatorLayout.Behavior<View> {
    private static final int STATE_COLLAPSED = 2;
    private static final int STATE_EXPANDED = 1;
    private static final int STATE_UNINITIALIZED = 0;
    private int currentState;

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public abstract boolean layoutDependsOn(CoordinatorLayout r100, View r101, View r102);

    public abstract boolean onExpandedStateChange(View r100, View r101, boolean r102, boolean r103);

    public ExpandableBehavior() {
        this.currentState = 0;
    }

    public static /* synthetic */ int access$000(ExpandableBehavior r100) {
        return r100.currentState;
    }

    private boolean didStateChange(boolean r100) {
        if (r100 == false) goto L11;
        int r101 = this.currentState;
        if (r101 != 0) goto L7;
    L8:
        return true;
    L7:
        if (r101 == 2) goto L8;
        return false;
    L11:
        if (this.currentState != 1) goto L15;
        return true;
    L15:
        return false;
    }

    public ExpandableBehavior(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.currentState = 0;
    }

    public static <T extends ExpandableBehavior> T from(View r100, Class<T> r101) {
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        if ((r102 instanceof CoordinatorLayout.LayoutParams) == false) goto L11;
        CoordinatorLayout.Behavior r103 = ((CoordinatorLayout.LayoutParams) r102).getBehavior();
        if ((r103 instanceof ExpandableBehavior) == false) goto L9;
        return r101.cast(r103);
    L9:
        throw new IllegalArgumentException("The view is not associated with ExpandableBehavior");
    L11:
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ExpandableWidget findExpandableWidget(CoordinatorLayout r100, View r101) {
        List<View> r102 = r100.getDependencies(r101);
        int r103 = r102.size();
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L9;
        View r105 = (View) ListProtector.get(r102, r104);
        if (layoutDependsOn(r100, r101, r105) == true) goto L7;
        r104 = r104 + 1;
        goto L3
    L7:
        return (ExpandableWidget) r105;
    L9:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onDependentViewChanged(CoordinatorLayout r100, View r101, View r102) {
        ExpandableWidget r103 = (ExpandableWidget) r102;
        if (didStateChange(r103.isExpanded()) == true) goto L5;
        return false;
    L5:
        if (r103.isExpanded() == false) goto L7;
        int r104 = 1;
    L8:
        this.currentState = r104;
        return onExpandedStateChange((View) r103, r101, r103.isExpanded(), true);
    L7:
        r104 = 2;
        goto L8
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout r100, final View r101, int r102) {
        if (ViewCompat.isLaidOut(r101) == true) goto L15;
        final ExpandableWidget r103 = findExpandableWidget(r100, r101);
        if (r103 != null) goto L7;
        return false;
    L7:
        if (didStateChange(r103.isExpanded()) == true) goto L9;
        return false;
    L9:
        if (r103.isExpanded() == false) goto L11;
        final int r104 = 1;
    L12:
        this.currentState = r104;
        r101.getViewTreeObserver().addOnPreDrawListener(new AnonymousClass1(this, r101, r104, r103));
        return false;
    L11:
        r104 = 2;
        goto L12
    L15:
        return false;
    }
}
