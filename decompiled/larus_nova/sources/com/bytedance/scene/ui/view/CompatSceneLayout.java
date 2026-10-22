package com.bytedance.scene.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowInsets;
import android.widget.LinearLayout;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes19.dex */
public class CompatSceneLayout extends LinearLayout {
    public CompatSceneLayout(Context r100) {
        super(r100);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final WindowInsets dispatchApplyWindowInsets(WindowInsets r100) {
        StatusBarView r101 = (StatusBarView) findViewById(R.id.scene_status_bar);
        if (r101 == null) goto L10;
        if (r101.getParent() != this) goto L8;
        r100 = r101.dispatchApplyWindowInsets(r100);
        goto L10
    L8:
        throw new IllegalStateException("StatusBarView parent must be ".concat(getClass().getSimpleName()));
    L10:
        if (r100.isConsumed() == false) goto L12;
        return r100;
    L12:
        NavigationBarView r102 = (NavigationBarView) findViewById(R.id.scene_navigation_bar);
        if (r102 == null) goto L20;
        if (r102.getParent() != this) goto L18;
        r100 = r102.dispatchApplyWindowInsets(r100);
        goto L20
    L18:
        throw new IllegalStateException("NavigationBarView parent must be ".concat(getClass().getSimpleName()));
    L20:
        if (r100.isConsumed() == false) goto L22;
        return r100;
    L22:
        int r103 = getChildCount();
        int r104 = 0;
    L23:
        if (r104 >= r103) goto L32;
        View r105 = getChildAt(r104);
        if (r105 == r101) goto L31;
        if (r105 == r102) goto L31;
        r100 = r105.dispatchApplyWindowInsets(r100);
        if (r100.isConsumed() == true) goto L32;
    L31:
        r104 = r104 + 1;
    L32:
        return r100;
    }

    public CompatSceneLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    public CompatSceneLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
