package fca;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class i extends ViewOutlineProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f476403a;

    public i(h r100) {
        this.f476403a = r100;
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View r100, Outline r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "outline");
        int r102 = this.f476403a.f476379i;
        if (r102 > 0) goto L6;
        r102 = r100.getWidth();
    L6:
        r101.setRoundRect(0, 0, r102, r100.getHeight(), this.f476403a.f476380j);
    }
}
