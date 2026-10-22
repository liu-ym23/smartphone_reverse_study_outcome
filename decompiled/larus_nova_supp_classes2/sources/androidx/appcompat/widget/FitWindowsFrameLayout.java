package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class FitWindowsFrameLayout extends FrameLayout implements FitWindowsViewGroup {
    private FitWindowsViewGroup.OnFitSystemWindowsListener mListener;

    public FitWindowsFrameLayout(Context r1) {
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

    public FitWindowsFrameLayout(Context r1, AttributeSet r2) {
        super(r1, r2);
    }
}
