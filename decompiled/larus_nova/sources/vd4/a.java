package vd4;

import android.graphics.drawable.Animatable;

/* JADX INFO: loaded from: classes15.dex */
public interface a {
    void onFinalImageSet(Animatable r100);

    void onFrame(Animatable r100, int r101);

    void onImageSize(int r100, int r101);

    void onLoadFail();

    void onRepeat(Animatable r100);

    void onStart(Animatable r100);

    void onStop(Animatable r100);
}
