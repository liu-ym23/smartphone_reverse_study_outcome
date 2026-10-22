package g2b;

import android.animation.TimeInterpolator;

/* JADX INFO: loaded from: classes35.dex */
public final /* synthetic */ class b implements TimeInterpolator {
    public /* synthetic */ b() {
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float r100) {
        if (r100 > 0.5d) goto L6;
        return 0.0f;
    L6:
        return (r100 * 2.0f) - 1.0f;
    }
}
