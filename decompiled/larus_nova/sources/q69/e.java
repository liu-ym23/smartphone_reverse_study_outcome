package q69;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.larus.dora.impl.view.DoraMovieView;

/* JADX INFO: loaded from: classes27.dex */
public final class e extends ViewOutlineProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DoraMovieView f531872a;

    public e(DoraMovieView r100) {
        this.f531872a = r100;
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View r110, Outline r111) {
        DoraMovieView r100 = this.f531872a;
        int r101 = r100.f338197n;
        if (r101 > 0) goto L5;
    L7:
        if (r101 <= 0) goto L9;
        int r112 = r110.getWidth();
        int r102 = r110.getHeight();
        int r103 = this.f531872a.f338197n;
        r111.setRoundRect(0, 0, r112, r102 + r103, r103);
        return;
    L9:
        int r104 = r100.f338198o;
        if (r104 <= 0) goto L12;
        r111.setRoundRect(0, -r104, r110.getWidth(), r110.getHeight(), this.f531872a.f338198o);
        return;
    L12:
        r111.setRect(0, 0, r110.getWidth(), r110.getHeight());
        return;
    L5:
        if (r100.f338198o <= 0) goto L7;
        r111.setRoundRect(0, 0, r110.getWidth(), r110.getHeight(), this.f531872a.f338197n);
    }
}
