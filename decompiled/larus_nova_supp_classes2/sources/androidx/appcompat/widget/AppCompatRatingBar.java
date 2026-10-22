package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RatingBar;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class AppCompatRatingBar extends RatingBar {
    private final AppCompatProgressBarHelper mAppCompatProgressBarHelper;

    public AppCompatRatingBar(Context r2) {
        this(r2, null);
    }

    public AppCompatRatingBar(Context r2, AttributeSet r3) {
        this(r2, r3, 2130973725);
    }

    @Override // android.widget.RatingBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public synchronized void onMeasure(int r2, int r3) {
        monitor-enter(this);
        super.onMeasure(r2, r3);     // Catch: Throwable -> L8
        Bitmap r4 = this.mAppCompatProgressBarHelper.getSampleTile();     // Catch: Throwable -> L8
        if (r4 == null) goto L6;
        setMeasuredDimension(View.resolveSizeAndState(r4.getWidth() * getNumStars(), r2, 0), getMeasuredHeight());     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public AppCompatRatingBar(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        ThemeUtils.checkAppCompatTheme(this, getContext());
        AppCompatProgressBarHelper r4 = new AppCompatProgressBarHelper(this);
        this.mAppCompatProgressBarHelper = r4;
        r4.loadFromAttributes(r2, r3);
    }
}
