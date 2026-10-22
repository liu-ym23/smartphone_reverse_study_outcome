package e53;

import android.graphics.Outline;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewOutlineProvider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class b extends ViewOutlineProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f471049a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f471050b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f471051c;

    public b() {
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View r100, Outline r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "outline");
        r101.setRoundRect(new Rect(0, 0, this.f471050b, (int) (this.f471051c + this.f471049a)), this.f471049a);
    }

    public final void update(float r100, int r101, int r102) {
        this.f471049a = r100;
        this.f471050b = r101;
        this.f471051c = r102;
    }
}
