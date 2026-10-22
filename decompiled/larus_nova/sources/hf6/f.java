package hf6;

import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.view.View;
import df6.o;

/* JADX INFO: loaded from: classes20.dex */
public interface f {
    void onComplete(Uri r100, View r101, o r102, Animatable r103);

    void onFailed(Uri r100, View r101, Throwable r102);

    void onIntermediateImageFailed(Uri r100, Throwable r101);

    void onIntermediateImageSet(Uri r100, o r101);

    void onRelease(Uri r100);

    void onStart(Uri r100, View r101);
}
