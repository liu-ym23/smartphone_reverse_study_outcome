package dma;

import com.obric.oui.indexscrollbar.LettersBar;

/* JADX INFO: loaded from: classes34.dex */
public final /* synthetic */ class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LettersBar f469241a;

    public /* synthetic */ c(LettersBar r100) {
        this.f469241a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        LettersBar.a(this.f469241a);
    }
}
