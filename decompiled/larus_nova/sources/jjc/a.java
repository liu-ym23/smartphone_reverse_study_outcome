package jjc;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.ss.android.widget.slider.ProgressListener;
import hjc.f;

/* JADX INFO: loaded from: classes40.dex */
public final class a implements ProgressListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Drawable f499465a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f f499466b;

    public a() {
        ColorDrawable r100 = new ColorDrawable(-16777216);
        this.f499465a = r100;
        r100.setAlpha((int) ((0.5d - ((double) 0.0f)) * 255.0d));
    }

    @Override // com.ss.android.widget.slider.ProgressListener
    public final void a(float r100, int r101) {
        f r102 = this.f499466b;
        this.f499465a.setAlpha((int) ((0.5d - ((double) (r100 * 0.5f))) * 255.0d));
    }
}
