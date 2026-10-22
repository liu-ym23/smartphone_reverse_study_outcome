package ol2;

import android.graphics.Outline;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewOutlineProvider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class r extends ViewOutlineProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f524154a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f524155b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f524156c;

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View r100, Outline r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "outline");
        r101.setRoundRect(new Rect(0, 0, this.f524155b, this.f524156c), this.f524154a);
    }

    public r(float r100, int r101, int r102) {
        this.f524154a = r100;
        this.f524155b = r101;
        this.f524156c = r102;
    }
}
