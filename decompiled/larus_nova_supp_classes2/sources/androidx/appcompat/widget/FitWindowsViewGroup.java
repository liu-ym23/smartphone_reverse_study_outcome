package androidx.appcompat.widget;

import android.graphics.Rect;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public interface FitWindowsViewGroup {

    public interface OnFitSystemWindowsListener {
        void onFitSystemWindows(Rect r1);
    }

    void setOnFitSystemWindowsListener(OnFitSystemWindowsListener r1);
}
