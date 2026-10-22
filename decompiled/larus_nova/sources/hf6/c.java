package hf6;

import android.net.Uri;
import android.view.View;
import df6.o;
import java.util.Objects;

/* JADX INFO: loaded from: classes20.dex */
public abstract class c implements f {
    public c() {
    }

    @Override // hf6.f
    public void onRelease(Uri r100) {
        Objects.toString(r100);
    }

    @Override // hf6.f
    public void onIntermediateImageFailed(Uri r100, Throwable r101) {
        Objects.toString(r100);
        Objects.toString(r101);
    }

    @Override // hf6.f
    public void onIntermediateImageSet(Uri r100, o r101) {
        Objects.toString(r100);
        Objects.toString(r101);
    }

    @Override // hf6.f
    public void onStart(Uri r100, View r101) {
        Objects.toString(r100);
    }
}
