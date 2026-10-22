package oh1;

import android.graphics.Outline;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewOutlineProvider;

/* JADX INFO: loaded from: classes7.dex */
public final class a extends ViewOutlineProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f523237a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f523238b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f523239c;

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View r100, Outline r101) {
        r101.setRoundRect(new Rect(0, 0, this.f523238b, this.f523239c), this.f523237a);
    }

    public a(float r100, int r101, int r102) {
        this.f523237a = r100;
        this.f523238b = r101;
        this.f523239c = r102;
    }
}
