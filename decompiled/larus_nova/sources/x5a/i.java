package x5a;

import android.graphics.drawable.PictureDrawable;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.component.svg.SvgImageView;
import com.lynx.component.svg.UISvg;
import com.lynx.component.svg.parser.SVG;

/* JADX INFO: loaded from: classes32.dex */
public final class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PictureDrawable f562565a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SVG f562566b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ UISvg f562567c;

    @Override // java.lang.Runnable
    public final void run() {
        ((SvgImageView) UISvg.Q(this.f562567c)).setImageDrawable(this.f562565a);     // Catch: Throwable -> L4
        this.f562567c.invalidate();     // Catch: Throwable -> L4
        UISvg.R(this.f562567c, this.f562566b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public i(UISvg r100, e r101, SVG r102) {
        this.f562567c = r100;
        this.f562565a = r101;
        this.f562566b = r102;
    }
}
