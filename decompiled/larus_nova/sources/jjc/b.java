package jjc;

import android.app.Activity;
import com.ss.android.widget.slider.ProgressListener;

/* JADX INFO: loaded from: classes40.dex */
public final class b implements ProgressListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f499467a;

    public b(Activity r100) {
        this.f499467a = r100;
    }

    @Override // com.ss.android.widget.slider.ProgressListener
    public final void a(float r100, int r101) {
        if (r101 != 5) goto L5;
    L6:
        this.f499467a.getWindow().setStatusBarColor(0);
        if (this.f499467a.isFinishing() == true) goto L9;
        this.f499467a.finish();
    L9:
        this.f499467a.overridePendingTransition(0, 0);
        return;
    L5:
        if (r101 == 8) goto L6;
    }
}
