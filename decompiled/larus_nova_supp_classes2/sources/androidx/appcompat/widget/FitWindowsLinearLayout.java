package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class FitWindowsLinearLayout extends LinearLayout implements FitWindowsViewGroup {
    private FitWindowsViewGroup.OnFitSystemWindowsListener mListener;

    public FitWindowsLinearLayout(Context r1) {
        super(r1);
    }

    @Override // android.view.View
    public boolean fitSystemWindows(Rect r2) {
        FitWindowsViewGroup.OnFitSystemWindowsListener r0 = this.mListener;
        if (r0 == null) goto L6;
        r0.onFitSystemWindows(r2);
    L6:
        return super.fitSystemWindows(r2);
    }

    @Override // androidx.appcompat.widget.FitWindowsViewGroup
    public void setOnFitSystemWindowsListener(FitWindowsViewGroup.OnFitSystemWindowsListener r1) {
        this.mListener = r1;
    }

    public FitWindowsLinearLayout(Context r1, AttributeSet r2) {
        super(r1, r2);
    }
}
