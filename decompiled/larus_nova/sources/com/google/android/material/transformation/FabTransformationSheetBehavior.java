package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.animation.Positioning;
import com.larus.nova.R;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes23.dex */
public class FabTransformationSheetBehavior extends FabTransformationBehavior {
    private Map<View, Integer> importantForAccessibilityMap;

    public FabTransformationSheetBehavior() {
    }

    public FabTransformationSheetBehavior(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    private void updateImportantForAccessibility(View r100, boolean r101) {
        ViewParent r102 = r100.getParent();
        if ((r102 instanceof CoordinatorLayout) == true) goto L5;
        return;
    L5:
        CoordinatorLayout r103 = (CoordinatorLayout) r102;
        int r104 = r103.getChildCount();
        if (r101 == false) goto L8;
        this.importantForAccessibilityMap = new HashMap(r104);
    L8:
        int r105 = 0;
    L9:
        if (r105 >= r104) goto L27;
        View r106 = r103.getChildAt(r105);
        if ((r106.getLayoutParams() instanceof CoordinatorLayout.LayoutParams) == true) goto L13;
    L15:
        boolean r107 = false;
    L16:
        if (r106 == r100) goto L26;
        if (r107 == true) goto L26;
        if (r101 == true) goto L25;
        Map<View, Integer> r108 = this.importantForAccessibilityMap;
        if (r108 == null) goto L26;
        if (r108.containsKey(r106) == false) goto L26;
        ViewCompat.setImportantForAccessibility(r106, this.importantForAccessibilityMap.get(r106).intValue());
        goto L26
    L25:
        this.importantForAccessibilityMap.put(r106, Integer.valueOf(r106.getImportantForAccessibility()));
        ViewCompat.setImportantForAccessibility(r106, 4);
    L26:
        r105 = r105 + 1;
        goto L9
    L13:
        if ((((CoordinatorLayout.LayoutParams) r106.getLayoutParams()).getBehavior() instanceof FabTransformationScrimBehavior) == false) goto L15;
        r107 = true;
        goto L16
    L27:
        if (r101 == true) goto L37;
        this.importantForAccessibilityMap = null;
        return;
    }

    @Override // com.google.android.material.transformation.FabTransformationBehavior
    public FabTransformationBehavior.FabTransformationSpec onCreateMotionSpec(Context r100, boolean r101) {
        if (r101 == false) goto L4;
        int r102 = R.animator.mtrl_fab_transformation_sheet_expand_spec;
    L5:
        FabTransformationBehavior.FabTransformationSpec r103 = new FabTransformationBehavior.FabTransformationSpec();
        r103.timings = MotionSpec.createFromResource(r100, r102);
        r103.positioning = new Positioning(17, 0.0f, 0.0f);
        return r103;
    L4:
        r102 = R.animator.mtrl_fab_transformation_sheet_collapse_spec;
        goto L5
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior, com.google.android.material.transformation.ExpandableBehavior
    public boolean onExpandedStateChange(View r100, View r101, boolean r102, boolean r103) {
        updateImportantForAccessibility(r101, r102);
        return super.onExpandedStateChange(r100, r101, r102, r103);
    }
}
