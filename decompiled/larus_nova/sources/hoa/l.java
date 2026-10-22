package hoa;

import android.widget.ProgressBar;

/* JADX INFO: loaded from: classes34.dex */
public final class l implements coa.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f486297a;

    public l(m r100) {
        this.f486297a = r100;
    }

    @Override // coa.a
    public final void onProgress(int r100) {
        ProgressBar r101 = this.f486297a.f486300c;
        if (r101 == null) goto L6;
        r101.setProgress(r100);
        return;
    }

    @Override // coa.a
    public final void onStateUpdate(int r100) {
        this.f486297a.a(r100);
    }
}
