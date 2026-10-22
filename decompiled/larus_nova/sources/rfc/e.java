package rfc;

import android.graphics.RectF;
import com.ss.android.photoeditor.graffiti.GraffitiView;

/* JADX INFO: loaded from: classes38.dex */
public final class e extends pfc.g.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GraffitiView f537659a;

    public e(GraffitiView r100) {
        this.f537659a = r100;
    }

    @Override // pfc.g.d
    public final void a(RectF r100) {
        GraffitiView r101 = this.f537659a;
        int r102 = GraffitiView.f449199n;
        r101.n();
        this.f537659a.invalidate();
    }
}
